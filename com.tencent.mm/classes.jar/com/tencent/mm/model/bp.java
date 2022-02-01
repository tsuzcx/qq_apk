package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class bp
  extends com.tencent.mm.sdk.e.k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS readerappnews1 ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE TABLE IF NOT EXISTS readerappweibo ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappnews1 ( time )", "CREATE INDEX IF NOT EXISTS  readerappfunctionId ON readerappnews1 ( reserved3 )", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappweibo ( time )" };
  public h gPa;
  
  public bp(h paramh)
  {
    this.gPa = paramh;
  }
  
  public static String nm(int paramInt)
  {
    AppMethodBeat.i(102635);
    if (paramInt == 20)
    {
      AppMethodBeat.o(102635);
      return "readerappnews1";
    }
    if (paramInt == 11)
    {
      AppMethodBeat.o(102635);
      return "readerappweibo";
    }
    Assert.assertTrue("INFO TYPE NEITHER NEWS NOR WEIBO", false);
    AppMethodBeat.o(102635);
    return null;
  }
  
  public static String uq(String paramString)
  {
    AppMethodBeat.i(102634);
    paramString = "select tweetid,time,type,name,title,url,shorturl,longurl,pubtime,sourcename,sourceicon,istop,cover,digest,reserved1,reserved2,reserved3,reserved4 from " + paramString + "  ";
    AppMethodBeat.o(102634);
    return paramString;
  }
  
  public final List<bo> Z(String paramString, int paramInt)
  {
    AppMethodBeat.i(102639);
    ArrayList localArrayList = new ArrayList();
    paramString = uq(nm(paramInt)) + "where reserved3 = " + h.qj(paramString) + " order by istop desc , tweetid asc ";
    ad.d("MicroMsg.ReaderAppInfoStorage", "getInfobyGroup :".concat(String.valueOf(paramString)));
    paramString = this.gPa.a(paramString, null, 2);
    while (paramString.moveToNext())
    {
      bo localbo = new bo();
      localbo.convertFrom(paramString);
      localArrayList.add(localbo);
    }
    paramString.close();
    AppMethodBeat.o(102639);
    return localArrayList;
  }
  
  public final List<bo> lX(long paramLong)
  {
    AppMethodBeat.i(102638);
    ArrayList localArrayList = new ArrayList();
    Object localObject = uq(nm(20)) + " where reserved2 = " + paramLong;
    ad.d("MicroMsg.ReaderAppInfoStorage", "getInfoListByMsgSvrID :".concat(String.valueOf(localObject)));
    localObject = this.gPa.a((String)localObject, null, 2);
    while (((Cursor)localObject).moveToNext())
    {
      bo localbo = new bo();
      localbo.convertFrom((Cursor)localObject);
      localArrayList.add(localbo);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(102638);
    return localArrayList;
  }
  
  public final Cursor nn(int paramInt)
  {
    AppMethodBeat.i(102636);
    Object localObject = "SELECT reserved3 from " + nm(20) + " GROUP BY reserved3 ORDER BY time ASC  LIMIT " + paramInt + " offset (SELECT COUNT(*) FROM (SELECT COUNT(*) FROM " + nm(20) + " GROUP BY reserved3)) -" + paramInt;
    localObject = this.gPa.a((String)localObject, null, 0);
    AppMethodBeat.o(102636);
    return localObject;
  }
  
  public final int no(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(102637);
    Object localObject = "select count(*) from (SELECT count(*) FROM " + nm(paramInt) + " group by reserved3)";
    localObject = this.gPa.a((String)localObject, null, 2);
    paramInt = i;
    if (((Cursor)localObject).moveToFirst()) {
      paramInt = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(102637);
    return paramInt;
  }
  
  public final void np(int paramInt)
  {
    AppMethodBeat.i(102641);
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIn(bo.nl(paramInt));
    if ((localObject == null) || (!((ay)localObject).field_username.equals(bo.nl(paramInt))))
    {
      AppMethodBeat.o(102641);
      return;
    }
    ((am)localObject).setUsername(bo.nl(paramInt));
    ((am)localObject).setContent("");
    ((am)localObject).jV(0);
    ((am)localObject).jT(0);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().a((am)localObject, bo.nl(paramInt));
    localObject = "delete from " + nm(paramInt);
    if (this.gPa.execSQL(nm(paramInt), (String)localObject)) {
      doNotify();
    }
    AppMethodBeat.o(102641);
  }
  
  public final void nq(int paramInt)
  {
    AppMethodBeat.i(102642);
    Object localObject1 = uq(nm(paramInt)) + " where istop = 1  group by reserved3 ORDER BY time DESC  limit 2";
    ad.i("MicroMsg.ReaderAppInfoStorage", "reset conversation, sql is %s", new Object[] { localObject1 });
    Object localObject2 = this.gPa.a((String)localObject1, null, 2);
    if (!((Cursor)localObject2).moveToFirst())
    {
      ((Cursor)localObject2).close();
      localObject1 = new am();
      ((am)localObject1).setUsername(bo.nl(paramInt));
      ((am)localObject1).setContent("");
      ((am)localObject1).kS(0L);
      ((am)localObject1).jV(0);
      ((am)localObject1).jT(0);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().a((am)localObject1, bo.nl(paramInt));
      AppMethodBeat.o(102642);
      return;
    }
    localObject1 = new bo();
    ((bo)localObject1).convertFrom((Cursor)localObject2);
    ((Cursor)localObject2).close();
    localObject2 = new am();
    ((am)localObject2).setUsername(bo.nl(paramInt));
    ((am)localObject2).setContent(((bo)localObject1).getTitle());
    ((am)localObject2).kS(((bo)localObject1).time);
    ((am)localObject2).jV(0);
    ((am)localObject2).jT(0);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().a((am)localObject2, bo.nl(paramInt));
    AppMethodBeat.o(102642);
  }
  
  public final List<bo> ur(String paramString)
  {
    AppMethodBeat.i(102640);
    paramString = this.gPa.a(nm(20), new String[] { "*" }, "reserved3=?", new String[] { paramString }, null, null, null, 2);
    if (paramString != null) {}
    try
    {
      if (paramString.moveToFirst())
      {
        ArrayList localArrayList = new ArrayList();
        boolean bool;
        do
        {
          bo localbo = new bo();
          localbo.convertFrom(paramString);
          localArrayList.add(localbo);
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
        ad.e("MicroMsg.ReaderAppInfoStorage", "getByFunctionMsgId, error: %s", new Object[] { localException.getMessage() });
        if (paramString != null) {
          paramString.close();
        }
      }
    }
    finally
    {
      if (paramString == null) {
        break label180;
      }
      paramString.close();
      AppMethodBeat.o(102640);
    }
    AppMethodBeat.o(102640);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bp
 * JD-Core Version:    0.7.0.1
 */