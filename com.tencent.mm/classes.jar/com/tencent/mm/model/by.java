package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.bb;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class by
  extends MStorage
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS readerappnews1 ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE TABLE IF NOT EXISTS readerappweibo ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappnews1 ( time )", "CREATE INDEX IF NOT EXISTS  readerappfunctionId ON readerappnews1 ( reserved3 )", "CREATE INDEX IF NOT EXISTS readerappweiboreaderapptime ON readerappweibo ( time )" };
  public static boolean omW = false;
  public com.tencent.mm.storagebase.h omV;
  
  public by(com.tencent.mm.storagebase.h paramh)
  {
    this.omV = paramh;
  }
  
  public static String JX(String paramString)
  {
    AppMethodBeat.i(102634);
    paramString = "select tweetid,time,type,name,title,url,shorturl,longurl,pubtime,sourcename,sourceicon,istop,cover,digest,reserved1,reserved2,reserved3,reserved4 from " + paramString + "  ";
    AppMethodBeat.o(102634);
    return paramString;
  }
  
  public static String vl(int paramInt)
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
  
  public final List<bx> JY(String paramString)
  {
    AppMethodBeat.i(102640);
    paramString = this.omV.query(vl(20), new String[] { "*" }, "reserved3=?", new String[] { paramString }, null, null, null, 2);
    if (paramString != null) {}
    try
    {
      if (paramString.moveToFirst())
      {
        ArrayList localArrayList = new ArrayList();
        boolean bool;
        do
        {
          bx localbx = new bx();
          localbx.convertFrom(paramString);
          localArrayList.add(localbx);
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
  
  public final List<bx> aP(String paramString, int paramInt)
  {
    AppMethodBeat.i(102639);
    ArrayList localArrayList = new ArrayList();
    paramString = JX(vl(paramInt)) + "where reserved3 = " + com.tencent.mm.storagebase.h.EQ(paramString) + " order by istop desc , tweetid asc ";
    Log.d("MicroMsg.ReaderAppInfoStorage", "getInfobyGroup :".concat(String.valueOf(paramString)));
    paramString = this.omV.rawQuery(paramString, null, 2);
    while (paramString.moveToNext())
    {
      bx localbx = new bx();
      localbx.convertFrom(paramString);
      localArrayList.add(localbx);
    }
    paramString.close();
    AppMethodBeat.o(102639);
    return localArrayList;
  }
  
  public final List<bx> iv(long paramLong)
  {
    AppMethodBeat.i(102638);
    ArrayList localArrayList = new ArrayList();
    Object localObject = JX(vl(20)) + " where reserved2 = " + paramLong;
    Log.d("MicroMsg.ReaderAppInfoStorage", "getInfoListByMsgSvrID :".concat(String.valueOf(localObject)));
    localObject = this.omV.rawQuery((String)localObject, null, 2);
    while (((Cursor)localObject).moveToNext())
    {
      bx localbx = new bx();
      localbx.convertFrom((Cursor)localObject);
      localArrayList.add(localbx);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(102638);
    return localArrayList;
  }
  
  public final Cursor vm(int paramInt)
  {
    AppMethodBeat.i(102636);
    Object localObject = "SELECT reserved3 from (SELECT reserved3,time from " + vl(20) + " GROUP BY reserved3 ORDER BY time DESC  LIMIT " + paramInt + ") ORDER BY time ASC";
    localObject = this.omV.rawQuery((String)localObject, null);
    AppMethodBeat.o(102636);
    return localObject;
  }
  
  public final int vn(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(102637);
    Object localObject = "select count(*) from (SELECT count(*) FROM " + vl(paramInt) + " group by reserved3)";
    localObject = this.omV.rawQuery((String)localObject, null, 2);
    paramInt = i;
    if (((Cursor)localObject).moveToFirst()) {
      paramInt = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(102637);
    return paramInt;
  }
  
  public final void vo(int paramInt)
  {
    AppMethodBeat.i(102641);
    Object localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxM(bx.vk(paramInt));
    if ((localObject == null) || (!((bd)localObject).field_username.equals(bx.vk(paramInt))))
    {
      AppMethodBeat.o(102641);
      return;
    }
    ((bb)localObject).setUsername(bx.vk(paramInt));
    ((bb)localObject).setContent("");
    ((bb)localObject).pI(0);
    ((bb)localObject).pG(0);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().c((bb)localObject, bx.vk(paramInt));
    localObject = "delete from " + vl(paramInt);
    if (this.omV.execSQL(vl(paramInt), (String)localObject)) {
      doNotify();
    }
    AppMethodBeat.o(102641);
  }
  
  public final void vp(int paramInt)
  {
    AppMethodBeat.i(102642);
    Object localObject1 = JX(vl(paramInt)) + " where istop = 1  group by reserved3 ORDER BY time DESC  limit 2";
    Log.i("MicroMsg.ReaderAppInfoStorage", "reset conversation, sql is %s", new Object[] { localObject1 });
    Object localObject2 = this.omV.rawQuery((String)localObject1, null, 2);
    if (!((Cursor)localObject2).moveToFirst())
    {
      ((Cursor)localObject2).close();
      localObject1 = new bb();
      ((bb)localObject1).setUsername(bx.vk(paramInt));
      ((bb)localObject1).setContent("");
      ((bb)localObject1).gR(0L);
      ((bb)localObject1).pI(0);
      ((bb)localObject1).pG(0);
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().c((bb)localObject1, bx.vk(paramInt));
      AppMethodBeat.o(102642);
      return;
    }
    localObject1 = new bx();
    ((bx)localObject1).convertFrom((Cursor)localObject2);
    ((Cursor)localObject2).close();
    localObject2 = new bb();
    ((bb)localObject2).setUsername(bx.vk(paramInt));
    ((bb)localObject2).setContent(((bx)localObject1).getTitle());
    ((bb)localObject2).gR(((bx)localObject1).time);
    ((bb)localObject2).pI(0);
    ((bb)localObject2).pG(0);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().c((bb)localObject2, bx.vk(paramInt));
    AppMethodBeat.o(102642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.model.by
 * JD-Core Version:    0.7.0.1
 */