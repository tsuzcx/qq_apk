package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.az;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class bw
  extends MStorage
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS readerappnews1 ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE TABLE IF NOT EXISTS readerappweibo ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappnews1 ( time )", "CREATE INDEX IF NOT EXISTS  readerappfunctionId ON readerappnews1 ( reserved3 )", "CREATE INDEX IF NOT EXISTS readerappweiboreaderapptime ON readerappweibo ( time )" };
  public h iFy;
  
  public bw(h paramh)
  {
    this.iFy = paramh;
  }
  
  public static String KD(String paramString)
  {
    AppMethodBeat.i(102634);
    paramString = "select tweetid,time,type,name,title,url,shorturl,longurl,pubtime,sourcename,sourceicon,istop,cover,digest,reserved1,reserved2,reserved3,reserved4 from " + paramString + "  ";
    AppMethodBeat.o(102634);
    return paramString;
  }
  
  public static String se(int paramInt)
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
  
  public final List<bv> Ae(long paramLong)
  {
    AppMethodBeat.i(102638);
    ArrayList localArrayList = new ArrayList();
    Object localObject = KD(se(20)) + " where reserved2 = " + paramLong;
    Log.d("MicroMsg.ReaderAppInfoStorage", "getInfoListByMsgSvrID :".concat(String.valueOf(localObject)));
    localObject = this.iFy.rawQuery((String)localObject, null, 2);
    while (((Cursor)localObject).moveToNext())
    {
      bv localbv = new bv();
      localbv.convertFrom((Cursor)localObject);
      localArrayList.add(localbv);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(102638);
    return localArrayList;
  }
  
  public final List<bv> KE(String paramString)
  {
    AppMethodBeat.i(102640);
    paramString = this.iFy.query(se(20), new String[] { "*" }, "reserved3=?", new String[] { paramString }, null, null, null, 2);
    if (paramString != null) {}
    try
    {
      if (paramString.moveToFirst())
      {
        ArrayList localArrayList = new ArrayList();
        boolean bool;
        do
        {
          bv localbv = new bv();
          localbv.convertFrom(paramString);
          localArrayList.add(localbv);
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
        Log.e("MicroMsg.ReaderAppInfoStorage", "getByFunctionMsgId, error: %s", new Object[] { localException.getMessage() });
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
  
  public final List<bv> al(String paramString, int paramInt)
  {
    AppMethodBeat.i(102639);
    ArrayList localArrayList = new ArrayList();
    paramString = KD(se(paramInt)) + "where reserved3 = " + h.Fl(paramString) + " order by istop desc , tweetid asc ";
    Log.d("MicroMsg.ReaderAppInfoStorage", "getInfobyGroup :".concat(String.valueOf(paramString)));
    paramString = this.iFy.rawQuery(paramString, null, 2);
    while (paramString.moveToNext())
    {
      bv localbv = new bv();
      localbv.convertFrom(paramString);
      localArrayList.add(localbv);
    }
    paramString.close();
    AppMethodBeat.o(102639);
    return localArrayList;
  }
  
  public final Cursor sf(int paramInt)
  {
    AppMethodBeat.i(102636);
    Object localObject = "SELECT reserved3 from " + se(20) + " GROUP BY reserved3 ORDER BY time ASC  LIMIT " + paramInt + " offset (SELECT COUNT(*) FROM (SELECT COUNT(*) FROM " + se(20) + " GROUP BY reserved3)) -" + paramInt;
    localObject = this.iFy.rawQuery((String)localObject, null);
    AppMethodBeat.o(102636);
    return localObject;
  }
  
  public final int sg(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(102637);
    Object localObject = "select count(*) from (SELECT count(*) FROM " + se(paramInt) + " group by reserved3)";
    localObject = this.iFy.rawQuery((String)localObject, null, 2);
    paramInt = i;
    if (((Cursor)localObject).moveToFirst()) {
      paramInt = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(102637);
    return paramInt;
  }
  
  public final void sh(int paramInt)
  {
    AppMethodBeat.i(102641);
    Object localObject = ((l)g.af(l.class)).aST().bjY(bv.sd(paramInt));
    if ((localObject == null) || (!((bb)localObject).field_username.equals(bv.sd(paramInt))))
    {
      AppMethodBeat.o(102641);
      return;
    }
    ((az)localObject).setUsername(bv.sd(paramInt));
    ((az)localObject).setContent("");
    ((az)localObject).nv(0);
    ((az)localObject).nt(0);
    ((l)g.af(l.class)).aST().a((az)localObject, bv.sd(paramInt));
    localObject = "delete from " + se(paramInt);
    if (this.iFy.execSQL(se(paramInt), (String)localObject)) {
      doNotify();
    }
    AppMethodBeat.o(102641);
  }
  
  public final void si(int paramInt)
  {
    AppMethodBeat.i(102642);
    Object localObject1 = KD(se(paramInt)) + " where istop = 1  group by reserved3 ORDER BY time DESC  limit 2";
    Log.i("MicroMsg.ReaderAppInfoStorage", "reset conversation, sql is %s", new Object[] { localObject1 });
    Object localObject2 = this.iFy.rawQuery((String)localObject1, null, 2);
    if (!((Cursor)localObject2).moveToFirst())
    {
      ((Cursor)localObject2).close();
      localObject1 = new az();
      ((az)localObject1).setUsername(bv.sd(paramInt));
      ((az)localObject1).setContent("");
      ((az)localObject1).yA(0L);
      ((az)localObject1).nv(0);
      ((az)localObject1).nt(0);
      ((l)g.af(l.class)).aST().a((az)localObject1, bv.sd(paramInt));
      AppMethodBeat.o(102642);
      return;
    }
    localObject1 = new bv();
    ((bv)localObject1).convertFrom((Cursor)localObject2);
    ((Cursor)localObject2).close();
    localObject2 = new az();
    ((az)localObject2).setUsername(bv.sd(paramInt));
    ((az)localObject2).setContent(((bv)localObject1).getTitle());
    ((az)localObject2).yA(((bv)localObject1).time);
    ((az)localObject2).nv(0);
    ((az)localObject2).nt(0);
    ((l)g.af(l.class)).aST().a((az)localObject2, bv.sd(paramInt));
    AppMethodBeat.o(102642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bw
 * JD-Core Version:    0.7.0.1
 */