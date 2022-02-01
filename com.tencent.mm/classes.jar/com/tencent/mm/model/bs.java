package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class bs
  extends k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS readerappnews1 ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE TABLE IF NOT EXISTS readerappweibo ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappnews1 ( time )", "CREATE INDEX IF NOT EXISTS  readerappfunctionId ON readerappnews1 ( reserved3 )", "CREATE INDEX IF NOT EXISTS readerappweiboreaderapptime ON readerappweibo ( time )" };
  public h hKK;
  
  public bs(h paramh)
  {
    this.hKK = paramh;
  }
  
  public static String BX(String paramString)
  {
    AppMethodBeat.i(102634);
    paramString = "select tweetid,time,type,name,title,url,shorturl,longurl,pubtime,sourcename,sourceicon,istop,cover,digest,reserved1,reserved2,reserved3,reserved4 from " + paramString + "  ";
    AppMethodBeat.o(102634);
    return paramString;
  }
  
  public static String oD(int paramInt)
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
  
  public final List<br> BY(String paramString)
  {
    AppMethodBeat.i(102640);
    paramString = this.hKK.a(oD(20), new String[] { "*" }, "reserved3=?", new String[] { paramString }, null, null, null, 2);
    if (paramString != null) {}
    try
    {
      if (paramString.moveToFirst())
      {
        ArrayList localArrayList = new ArrayList();
        boolean bool;
        do
        {
          br localbr = new br();
          localbr.convertFrom(paramString);
          localArrayList.add(localbr);
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
        ae.e("MicroMsg.ReaderAppInfoStorage", "getByFunctionMsgId, error: %s", new Object[] { localException.getMessage() });
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
  
  public final List<br> ai(String paramString, int paramInt)
  {
    AppMethodBeat.i(102639);
    ArrayList localArrayList = new ArrayList();
    paramString = BX(oD(paramInt)) + "where reserved3 = " + h.wX(paramString) + " order by istop desc , tweetid asc ";
    ae.d("MicroMsg.ReaderAppInfoStorage", "getInfobyGroup :".concat(String.valueOf(paramString)));
    paramString = this.hKK.a(paramString, null, 2);
    while (paramString.moveToNext())
    {
      br localbr = new br();
      localbr.convertFrom(paramString);
      localArrayList.add(localbr);
    }
    paramString.close();
    AppMethodBeat.o(102639);
    return localArrayList;
  }
  
  public final Cursor oE(int paramInt)
  {
    AppMethodBeat.i(102636);
    Object localObject = "SELECT reserved3 from " + oD(20) + " GROUP BY reserved3 ORDER BY time ASC  LIMIT " + paramInt + " offset (SELECT COUNT(*) FROM (SELECT COUNT(*) FROM " + oD(20) + " GROUP BY reserved3)) -" + paramInt;
    localObject = this.hKK.a((String)localObject, null, 0);
    AppMethodBeat.o(102636);
    return localObject;
  }
  
  public final int oF(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(102637);
    Object localObject = "select count(*) from (SELECT count(*) FROM " + oD(paramInt) + " group by reserved3)";
    localObject = this.hKK.a((String)localObject, null, 2);
    paramInt = i;
    if (((Cursor)localObject).moveToFirst()) {
      paramInt = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(102637);
    return paramInt;
  }
  
  public final void oG(int paramInt)
  {
    AppMethodBeat.i(102641);
    Object localObject = ((l)g.ab(l.class)).azL().aVa(br.oC(paramInt));
    if ((localObject == null) || (!((ba)localObject).field_username.equals(br.oC(paramInt))))
    {
      AppMethodBeat.o(102641);
      return;
    }
    ((au)localObject).setUsername(br.oC(paramInt));
    ((au)localObject).setContent("");
    ((au)localObject).kt(0);
    ((au)localObject).kr(0);
    ((l)g.ab(l.class)).azL().a((au)localObject, br.oC(paramInt));
    localObject = "delete from " + oD(paramInt);
    if (this.hKK.execSQL(oD(paramInt), (String)localObject)) {
      doNotify();
    }
    AppMethodBeat.o(102641);
  }
  
  public final void oH(int paramInt)
  {
    AppMethodBeat.i(102642);
    Object localObject1 = BX(oD(paramInt)) + " where istop = 1  group by reserved3 ORDER BY time DESC  limit 2";
    ae.i("MicroMsg.ReaderAppInfoStorage", "reset conversation, sql is %s", new Object[] { localObject1 });
    Object localObject2 = this.hKK.a((String)localObject1, null, 2);
    if (!((Cursor)localObject2).moveToFirst())
    {
      ((Cursor)localObject2).close();
      localObject1 = new au();
      ((au)localObject1).setUsername(br.oC(paramInt));
      ((au)localObject1).setContent("");
      ((au)localObject1).qH(0L);
      ((au)localObject1).kt(0);
      ((au)localObject1).kr(0);
      ((l)g.ab(l.class)).azL().a((au)localObject1, br.oC(paramInt));
      AppMethodBeat.o(102642);
      return;
    }
    localObject1 = new br();
    ((br)localObject1).convertFrom((Cursor)localObject2);
    ((Cursor)localObject2).close();
    localObject2 = new au();
    ((au)localObject2).setUsername(br.oC(paramInt));
    ((au)localObject2).setContent(((br)localObject1).getTitle());
    ((au)localObject2).qH(((br)localObject1).time);
    ((au)localObject2).kt(0);
    ((au)localObject2).kr(0);
    ((l)g.ab(l.class)).azL().a((au)localObject2, br.oC(paramInt));
    AppMethodBeat.o(102642);
  }
  
  public final List<br> rX(long paramLong)
  {
    AppMethodBeat.i(102638);
    ArrayList localArrayList = new ArrayList();
    Object localObject = BX(oD(20)) + " where reserved2 = " + paramLong;
    ae.d("MicroMsg.ReaderAppInfoStorage", "getInfoListByMsgSvrID :".concat(String.valueOf(localObject)));
    localObject = this.hKK.a((String)localObject, null, 2);
    while (((Cursor)localObject).moveToNext())
    {
      br localbr = new br();
      localbr.convertFrom((Cursor)localObject);
      localArrayList.add(localbr);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(102638);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bs
 * JD-Core Version:    0.7.0.1
 */