package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.at;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class bq
  extends k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS readerappnews1 ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE TABLE IF NOT EXISTS readerappweibo ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappnews1 ( time )", "CREATE INDEX IF NOT EXISTS  readerappfunctionId ON readerappnews1 ( reserved3 )", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappweibo ( time )" };
  public h hHS;
  
  public bq(h paramh)
  {
    this.hHS = paramh;
  }
  
  public static String Bv(String paramString)
  {
    AppMethodBeat.i(102634);
    paramString = "select tweetid,time,type,name,title,url,shorturl,longurl,pubtime,sourcename,sourceicon,istop,cover,digest,reserved1,reserved2,reserved3,reserved4 from " + paramString + "  ";
    AppMethodBeat.o(102634);
    return paramString;
  }
  
  public static String oA(int paramInt)
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
  
  public final List<bp> Bw(String paramString)
  {
    AppMethodBeat.i(102640);
    paramString = this.hHS.a(oA(20), new String[] { "*" }, "reserved3=?", new String[] { paramString }, null, null, null, 2);
    if (paramString != null) {}
    try
    {
      if (paramString.moveToFirst())
      {
        ArrayList localArrayList = new ArrayList();
        boolean bool;
        do
        {
          bp localbp = new bp();
          localbp.convertFrom(paramString);
          localArrayList.add(localbp);
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
        break label174;
      }
      paramString.close();
      AppMethodBeat.o(102640);
    }
    AppMethodBeat.o(102640);
    return null;
  }
  
  public final List<bp> ah(String paramString, int paramInt)
  {
    AppMethodBeat.i(102639);
    ArrayList localArrayList = new ArrayList();
    paramString = Bv(oA(paramInt)) + "where reserved3 = " + h.wo(paramString) + " order by istop desc , tweetid asc ";
    ad.d("MicroMsg.ReaderAppInfoStorage", "getInfobyGroup :".concat(String.valueOf(paramString)));
    paramString = this.hHS.a(paramString, null, 2);
    while (paramString.moveToNext())
    {
      bp localbp = new bp();
      localbp.convertFrom(paramString);
      localArrayList.add(localbp);
    }
    paramString.close();
    AppMethodBeat.o(102639);
    return localArrayList;
  }
  
  public final Cursor oB(int paramInt)
  {
    AppMethodBeat.i(102636);
    Object localObject = "SELECT reserved3 from " + oA(20) + " GROUP BY reserved3 ORDER BY time ASC  LIMIT " + paramInt + " offset (SELECT COUNT(*) FROM (SELECT COUNT(*) FROM " + oA(20) + " GROUP BY reserved3)) -" + paramInt;
    localObject = this.hHS.a((String)localObject, null, 0);
    AppMethodBeat.o(102636);
    return localObject;
  }
  
  public final int oC(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(102637);
    Object localObject = "select count(*) from (SELECT count(*) FROM " + oA(paramInt) + " group by reserved3)";
    localObject = this.hHS.a((String)localObject, null, 2);
    paramInt = i;
    if (((Cursor)localObject).moveToFirst()) {
      paramInt = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(102637);
    return paramInt;
  }
  
  public final void oD(int paramInt)
  {
    AppMethodBeat.i(102641);
    Object localObject = ((l)g.ab(l.class)).azv().aTz(bp.oz(paramInt));
    if ((localObject == null) || (!((ba)localObject).field_username.equals(bp.oz(paramInt))))
    {
      AppMethodBeat.o(102641);
      return;
    }
    ((at)localObject).setUsername(bp.oz(paramInt));
    ((at)localObject).setContent("");
    ((at)localObject).kr(0);
    ((at)localObject).kp(0);
    ((l)g.ab(l.class)).azv().a((at)localObject, bp.oz(paramInt));
    localObject = "delete from " + oA(paramInt);
    if (this.hHS.execSQL(oA(paramInt), (String)localObject)) {
      doNotify();
    }
    AppMethodBeat.o(102641);
  }
  
  public final void oE(int paramInt)
  {
    AppMethodBeat.i(102642);
    Object localObject1 = Bv(oA(paramInt)) + " where istop = 1  group by reserved3 ORDER BY time DESC  limit 2";
    ad.i("MicroMsg.ReaderAppInfoStorage", "reset conversation, sql is %s", new Object[] { localObject1 });
    Object localObject2 = this.hHS.a((String)localObject1, null, 2);
    if (!((Cursor)localObject2).moveToFirst())
    {
      ((Cursor)localObject2).close();
      localObject1 = new at();
      ((at)localObject1).setUsername(bp.oz(paramInt));
      ((at)localObject1).setContent("");
      ((at)localObject1).qu(0L);
      ((at)localObject1).kr(0);
      ((at)localObject1).kp(0);
      ((l)g.ab(l.class)).azv().a((at)localObject1, bp.oz(paramInt));
      AppMethodBeat.o(102642);
      return;
    }
    localObject1 = new bp();
    ((bp)localObject1).convertFrom((Cursor)localObject2);
    ((Cursor)localObject2).close();
    localObject2 = new at();
    ((at)localObject2).setUsername(bp.oz(paramInt));
    ((at)localObject2).setContent(((bp)localObject1).getTitle());
    ((at)localObject2).qu(((bp)localObject1).time);
    ((at)localObject2).kr(0);
    ((at)localObject2).kp(0);
    ((l)g.ab(l.class)).azv().a((at)localObject2, bp.oz(paramInt));
    AppMethodBeat.o(102642);
  }
  
  public final List<bp> rK(long paramLong)
  {
    AppMethodBeat.i(102638);
    ArrayList localArrayList = new ArrayList();
    Object localObject = Bv(oA(20)) + " where reserved2 = " + paramLong;
    ad.d("MicroMsg.ReaderAppInfoStorage", "getInfoListByMsgSvrID :".concat(String.valueOf(localObject)));
    localObject = this.hHS.a((String)localObject, null, 2);
    while (((Cursor)localObject).moveToNext())
    {
      bp localbp = new bp();
      localbp.convertFrom((Cursor)localObject);
      localArrayList.add(localbp);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(102638);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bq
 * JD-Core Version:    0.7.0.1
 */