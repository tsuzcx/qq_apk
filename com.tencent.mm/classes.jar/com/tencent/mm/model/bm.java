package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class bm
  extends k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS readerappnews1 ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE TABLE IF NOT EXISTS readerappweibo ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappnews1 ( time )", "CREATE INDEX IF NOT EXISTS  readerappfunctionId ON readerappnews1 ( reserved3 )", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappweibo ( time )" };
  public h fnw;
  
  public bm(h paramh)
  {
    this.fnw = paramh;
  }
  
  public static String kG(int paramInt)
  {
    AppMethodBeat.i(76728);
    if (paramInt == 20)
    {
      AppMethodBeat.o(76728);
      return "readerappnews1";
    }
    if (paramInt == 11)
    {
      AppMethodBeat.o(76728);
      return "readerappweibo";
    }
    Assert.assertTrue("INFO TYPE NEITHER NEWS NOR WEIBO", false);
    AppMethodBeat.o(76728);
    return null;
  }
  
  public static String pD(String paramString)
  {
    AppMethodBeat.i(76727);
    paramString = "select tweetid,time,type,name,title,url,shorturl,longurl,pubtime,sourcename,sourceicon,istop,cover,digest,reserved1,reserved2,reserved3,reserved4 from " + paramString + "  ";
    AppMethodBeat.o(76727);
    return paramString;
  }
  
  public final List<bl> Q(String paramString, int paramInt)
  {
    AppMethodBeat.i(76732);
    ArrayList localArrayList = new ArrayList();
    paramString = pD(kG(paramInt)) + "where reserved3 = " + h.escape(paramString) + " order by istop desc , tweetid asc ";
    ab.d("MicroMsg.ReaderAppInfoStorage", "getInfobyGroup :".concat(String.valueOf(paramString)));
    paramString = this.fnw.a(paramString, null, 2);
    while (paramString.moveToNext())
    {
      bl localbl = new bl();
      localbl.convertFrom(paramString);
      localArrayList.add(localbl);
    }
    paramString.close();
    AppMethodBeat.o(76732);
    return localArrayList;
  }
  
  public final List<bl> R(String paramString, int paramInt)
  {
    AppMethodBeat.i(76733);
    paramString = this.fnw.a(kG(paramInt), new String[] { "*" }, "reserved3=?", new String[] { paramString }, null, null, null, 2);
    if (paramString != null) {}
    try
    {
      if (paramString.moveToFirst())
      {
        ArrayList localArrayList = new ArrayList();
        boolean bool;
        do
        {
          bl localbl = new bl();
          localbl.convertFrom(paramString);
          localArrayList.add(localbl);
          bool = paramString.moveToNext();
        } while (bool);
        return localArrayList;
      }
      if (paramString != null) {
        paramString.close();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.ReaderAppInfoStorage", "getByFunctionMsgId, error: %s", new Object[] { localException.getMessage() });
        if (paramString != null) {
          paramString.close();
        }
      }
    }
    finally
    {
      if (paramString == null) {
        break label179;
      }
      paramString.close();
      AppMethodBeat.o(76733);
    }
    AppMethodBeat.o(76733);
    return null;
  }
  
  public final Cursor ct(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76729);
    Object localObject = "SELECT reserved3 from " + kG(paramInt2) + " GROUP BY reserved3 ORDER BY time ASC  LIMIT " + paramInt1 + " offset (SELECT COUNT(*) FROM (SELECT COUNT(*) FROM " + kG(paramInt2) + " GROUP BY reserved3)) -" + paramInt1;
    localObject = this.fnw.a((String)localObject, null, 0);
    AppMethodBeat.o(76729);
    return localObject;
  }
  
  public final List<bl> gx(long paramLong)
  {
    AppMethodBeat.i(76731);
    ArrayList localArrayList = new ArrayList();
    Object localObject = pD(kG(20)) + " where reserved2 = " + paramLong;
    ab.d("MicroMsg.ReaderAppInfoStorage", "getInfoListByMsgSvrID :".concat(String.valueOf(localObject)));
    localObject = this.fnw.a((String)localObject, null, 2);
    while (((Cursor)localObject).moveToNext())
    {
      bl localbl = new bl();
      localbl.convertFrom((Cursor)localObject);
      localArrayList.add(localbl);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(76731);
    return localArrayList;
  }
  
  public final int kH(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(76730);
    Object localObject = "select count(*) from (SELECT count(*) FROM " + kG(paramInt) + " group by reserved3)";
    localObject = this.fnw.a((String)localObject, null, 2);
    paramInt = i;
    if (((Cursor)localObject).moveToFirst()) {
      paramInt = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(76730);
    return paramInt;
  }
  
  public final void kI(int paramInt)
  {
    AppMethodBeat.i(76734);
    Object localObject = ((j)g.E(j.class)).YF().arH(bl.kF(paramInt));
    if ((localObject == null) || (!((au)localObject).field_username.equals(bl.kF(paramInt))))
    {
      AppMethodBeat.o(76734);
      return;
    }
    ((ak)localObject).setUsername(bl.kF(paramInt));
    ((ak)localObject).setContent("");
    ((ak)localObject).hL(0);
    ((ak)localObject).hJ(0);
    ((j)g.E(j.class)).YF().a((ak)localObject, bl.kF(paramInt));
    localObject = "delete from " + kG(paramInt);
    if (this.fnw.execSQL(kG(paramInt), (String)localObject)) {
      doNotify();
    }
    AppMethodBeat.o(76734);
  }
  
  public final void kJ(int paramInt)
  {
    AppMethodBeat.i(76735);
    Object localObject1 = pD(kG(paramInt)) + " where istop = 1  group by reserved3 ORDER BY time DESC  limit 2";
    ab.i("MicroMsg.ReaderAppInfoStorage", "reset conversation, sql is %s", new Object[] { localObject1 });
    Object localObject2 = this.fnw.a((String)localObject1, null, 2);
    if (!((Cursor)localObject2).moveToFirst())
    {
      ((Cursor)localObject2).close();
      localObject1 = new ak();
      ((ak)localObject1).setUsername(bl.kF(paramInt));
      ((ak)localObject1).setContent("");
      ((ak)localObject1).fK(0L);
      ((ak)localObject1).hL(0);
      ((ak)localObject1).hJ(0);
      ((j)g.E(j.class)).YF().a((ak)localObject1, bl.kF(paramInt));
      AppMethodBeat.o(76735);
      return;
    }
    localObject1 = new bl();
    ((bl)localObject1).convertFrom((Cursor)localObject2);
    ((Cursor)localObject2).close();
    localObject2 = new ak();
    ((ak)localObject2).setUsername(bl.kF(paramInt));
    ((ak)localObject2).setContent(((bl)localObject1).getTitle());
    ((ak)localObject2).fK(((bl)localObject1).time);
    ((ak)localObject2).hL(0);
    ((ak)localObject2).hJ(0);
    ((j)g.E(j.class)).YF().a((ak)localObject2, bl.kF(paramInt));
    AppMethodBeat.o(76735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.bm
 * JD-Core Version:    0.7.0.1
 */