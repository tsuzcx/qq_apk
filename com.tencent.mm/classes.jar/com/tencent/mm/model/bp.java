package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.az;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class bp
  extends com.tencent.mm.sdk.e.k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS readerappnews1 ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE TABLE IF NOT EXISTS readerappweibo ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappnews1 ( time )", "CREATE INDEX IF NOT EXISTS  readerappfunctionId ON readerappnews1 ( reserved3 )", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappweibo ( time )" };
  public h hpA;
  
  public bp(h paramh)
  {
    this.hpA = paramh;
  }
  
  public static String oa(int paramInt)
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
  
  public static String yw(String paramString)
  {
    AppMethodBeat.i(102634);
    paramString = "select tweetid,time,type,name,title,url,shorturl,longurl,pubtime,sourcename,sourceicon,istop,cover,digest,reserved1,reserved2,reserved3,reserved4 from " + paramString + "  ";
    AppMethodBeat.o(102634);
    return paramString;
  }
  
  public final List<bo> ad(String paramString, int paramInt)
  {
    AppMethodBeat.i(102639);
    ArrayList localArrayList = new ArrayList();
    paramString = yw(oa(paramInt)) + "where reserved3 = " + h.ty(paramString) + " order by istop desc , tweetid asc ";
    ac.d("MicroMsg.ReaderAppInfoStorage", "getInfobyGroup :".concat(String.valueOf(paramString)));
    paramString = this.hpA.a(paramString, null, 2);
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
  
  public final Cursor ob(int paramInt)
  {
    AppMethodBeat.i(102636);
    Object localObject = "SELECT reserved3 from " + oa(20) + " GROUP BY reserved3 ORDER BY time ASC  LIMIT " + paramInt + " offset (SELECT COUNT(*) FROM (SELECT COUNT(*) FROM " + oa(20) + " GROUP BY reserved3)) -" + paramInt;
    localObject = this.hpA.a((String)localObject, null, 0);
    AppMethodBeat.o(102636);
    return localObject;
  }
  
  public final int oc(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(102637);
    Object localObject = "select count(*) from (SELECT count(*) FROM " + oa(paramInt) + " group by reserved3)";
    localObject = this.hpA.a((String)localObject, null, 2);
    paramInt = i;
    if (((Cursor)localObject).moveToFirst()) {
      paramInt = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(102637);
    return paramInt;
  }
  
  public final void od(int paramInt)
  {
    AppMethodBeat.i(102641);
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNI(bo.nZ(paramInt));
    if ((localObject == null) || (!((az)localObject).field_username.equals(bo.nZ(paramInt))))
    {
      AppMethodBeat.o(102641);
      return;
    }
    ((ap)localObject).setUsername(bo.nZ(paramInt));
    ((ap)localObject).setContent("");
    ((ap)localObject).jT(0);
    ((ap)localObject).jR(0);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().a((ap)localObject, bo.nZ(paramInt));
    localObject = "delete from " + oa(paramInt);
    if (this.hpA.execSQL(oa(paramInt), (String)localObject)) {
      doNotify();
    }
    AppMethodBeat.o(102641);
  }
  
  public final void oe(int paramInt)
  {
    AppMethodBeat.i(102642);
    Object localObject1 = yw(oa(paramInt)) + " where istop = 1  group by reserved3 ORDER BY time DESC  limit 2";
    ac.i("MicroMsg.ReaderAppInfoStorage", "reset conversation, sql is %s", new Object[] { localObject1 });
    Object localObject2 = this.hpA.a((String)localObject1, null, 2);
    if (!((Cursor)localObject2).moveToFirst())
    {
      ((Cursor)localObject2).close();
      localObject1 = new ap();
      ((ap)localObject1).setUsername(bo.nZ(paramInt));
      ((ap)localObject1).setContent("");
      ((ap)localObject1).ou(0L);
      ((ap)localObject1).jT(0);
      ((ap)localObject1).jR(0);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().a((ap)localObject1, bo.nZ(paramInt));
      AppMethodBeat.o(102642);
      return;
    }
    localObject1 = new bo();
    ((bo)localObject1).convertFrom((Cursor)localObject2);
    ((Cursor)localObject2).close();
    localObject2 = new ap();
    ((ap)localObject2).setUsername(bo.nZ(paramInt));
    ((ap)localObject2).setContent(((bo)localObject1).getTitle());
    ((ap)localObject2).ou(((bo)localObject1).time);
    ((ap)localObject2).jT(0);
    ((ap)localObject2).jR(0);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().a((ap)localObject2, bo.nZ(paramInt));
    AppMethodBeat.o(102642);
  }
  
  public final List<bo> pL(long paramLong)
  {
    AppMethodBeat.i(102638);
    ArrayList localArrayList = new ArrayList();
    Object localObject = yw(oa(20)) + " where reserved2 = " + paramLong;
    ac.d("MicroMsg.ReaderAppInfoStorage", "getInfoListByMsgSvrID :".concat(String.valueOf(localObject)));
    localObject = this.hpA.a((String)localObject, null, 2);
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
  
  public final List<bo> yx(String paramString)
  {
    AppMethodBeat.i(102640);
    paramString = this.hpA.a(oa(20), new String[] { "*" }, "reserved3=?", new String[] { paramString }, null, null, null, 2);
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
        ac.e("MicroMsg.ReaderAppInfoStorage", "getByFunctionMsgId, error: %s", new Object[] { localException.getMessage() });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bp
 * JD-Core Version:    0.7.0.1
 */