package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.az;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class bx
  extends MStorage
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS readerappnews1 ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE TABLE IF NOT EXISTS readerappweibo ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappnews1 ( time )", "CREATE INDEX IF NOT EXISTS  readerappfunctionId ON readerappnews1 ( reserved3 )", "CREATE INDEX IF NOT EXISTS readerappweiboreaderapptime ON readerappweibo ( time )" };
  public static boolean lvz = false;
  public com.tencent.mm.storagebase.h lvy;
  
  public bx(com.tencent.mm.storagebase.h paramh)
  {
    this.lvy = paramh;
  }
  
  public static String RW(String paramString)
  {
    AppMethodBeat.i(102634);
    paramString = "select tweetid,time,type,name,title,url,shorturl,longurl,pubtime,sourcename,sourceicon,istop,cover,digest,reserved1,reserved2,reserved3,reserved4 from " + paramString + "  ";
    AppMethodBeat.o(102634);
    return paramString;
  }
  
  public static String vb(int paramInt)
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
  
  public final List<bw> Gl(long paramLong)
  {
    AppMethodBeat.i(102638);
    ArrayList localArrayList = new ArrayList();
    Object localObject = RW(vb(20)) + " where reserved2 = " + paramLong;
    Log.d("MicroMsg.ReaderAppInfoStorage", "getInfoListByMsgSvrID :".concat(String.valueOf(localObject)));
    localObject = this.lvy.rawQuery((String)localObject, null, 2);
    while (((Cursor)localObject).moveToNext())
    {
      bw localbw = new bw();
      localbw.convertFrom((Cursor)localObject);
      localArrayList.add(localbw);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(102638);
    return localArrayList;
  }
  
  public final List<bw> RX(String paramString)
  {
    AppMethodBeat.i(102640);
    paramString = this.lvy.query(vb(20), new String[] { "*" }, "reserved3=?", new String[] { paramString }, null, null, null, 2);
    if (paramString != null) {}
    try
    {
      if (paramString.moveToFirst())
      {
        ArrayList localArrayList = new ArrayList();
        boolean bool;
        do
        {
          bw localbw = new bw();
          localbw.convertFrom(paramString);
          localArrayList.add(localbw);
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
  
  public final List<bw> aD(String paramString, int paramInt)
  {
    AppMethodBeat.i(102639);
    ArrayList localArrayList = new ArrayList();
    paramString = RW(vb(paramInt)) + "where reserved3 = " + com.tencent.mm.storagebase.h.Mi(paramString) + " order by istop desc , tweetid asc ";
    Log.d("MicroMsg.ReaderAppInfoStorage", "getInfobyGroup :".concat(String.valueOf(paramString)));
    paramString = this.lvy.rawQuery(paramString, null, 2);
    while (paramString.moveToNext())
    {
      bw localbw = new bw();
      localbw.convertFrom(paramString);
      localArrayList.add(localbw);
    }
    paramString.close();
    AppMethodBeat.o(102639);
    return localArrayList;
  }
  
  public final Cursor vc(int paramInt)
  {
    AppMethodBeat.i(102636);
    Object localObject = "SELECT reserved3 from (SELECT reserved3,time from " + vb(20) + " GROUP BY reserved3 ORDER BY time DESC  LIMIT " + paramInt + ") ORDER BY time ASC";
    localObject = this.lvy.rawQuery((String)localObject, null);
    AppMethodBeat.o(102636);
    return localObject;
  }
  
  public final int vd(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(102637);
    Object localObject = "select count(*) from (SELECT count(*) FROM " + vb(paramInt) + " group by reserved3)";
    localObject = this.lvy.rawQuery((String)localObject, null, 2);
    paramInt = i;
    if (((Cursor)localObject).moveToFirst()) {
      paramInt = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(102637);
    return paramInt;
  }
  
  public final void ve(int paramInt)
  {
    AppMethodBeat.i(102641);
    Object localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwx(bw.va(paramInt));
    if ((localObject == null) || (!((bb)localObject).field_username.equals(bw.va(paramInt))))
    {
      AppMethodBeat.o(102641);
      return;
    }
    ((az)localObject).setUsername(bw.va(paramInt));
    ((az)localObject).setContent("");
    ((az)localObject).pJ(0);
    ((az)localObject).pH(0);
    ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().a((az)localObject, bw.va(paramInt));
    localObject = "delete from " + vb(paramInt);
    if (this.lvy.execSQL(vb(paramInt), (String)localObject)) {
      doNotify();
    }
    AppMethodBeat.o(102641);
  }
  
  public final void vf(int paramInt)
  {
    AppMethodBeat.i(102642);
    Object localObject1 = RW(vb(paramInt)) + " where istop = 1  group by reserved3 ORDER BY time DESC  limit 2";
    Log.i("MicroMsg.ReaderAppInfoStorage", "reset conversation, sql is %s", new Object[] { localObject1 });
    Object localObject2 = this.lvy.rawQuery((String)localObject1, null, 2);
    if (!((Cursor)localObject2).moveToFirst())
    {
      ((Cursor)localObject2).close();
      localObject1 = new az();
      ((az)localObject1).setUsername(bw.va(paramInt));
      ((az)localObject1).setContent("");
      ((az)localObject1).EB(0L);
      ((az)localObject1).pJ(0);
      ((az)localObject1).pH(0);
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().a((az)localObject1, bw.va(paramInt));
      AppMethodBeat.o(102642);
      return;
    }
    localObject1 = new bw();
    ((bw)localObject1).convertFrom((Cursor)localObject2);
    ((Cursor)localObject2).close();
    localObject2 = new az();
    ((az)localObject2).setUsername(bw.va(paramInt));
    ((az)localObject2).setContent(((bw)localObject1).getTitle());
    ((az)localObject2).EB(((bw)localObject1).time);
    ((az)localObject2).pJ(0);
    ((az)localObject2).pH(0);
    ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().a((az)localObject2, bw.va(paramInt));
    AppMethodBeat.o(102642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.model.bx
 * JD-Core Version:    0.7.0.1
 */