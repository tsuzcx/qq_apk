package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.c.as;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class bk
  extends com.tencent.mm.sdk.e.j
{
  public static final String[] dXp = { "CREATE TABLE IF NOT EXISTS readerappnews1 ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE TABLE IF NOT EXISTS readerappweibo ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappnews1 ( time )", "CREATE INDEX IF NOT EXISTS  readerappfunctionId ON readerappnews1 ( reserved3 )", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappweibo ( time )" };
  public h dXo;
  
  public bk(h paramh)
  {
    this.dXo = paramh;
  }
  
  public static String hT(int paramInt)
  {
    if (paramInt == 20) {
      return "readerappnews1";
    }
    if (paramInt == 11) {
      return "readerappweibo";
    }
    Assert.assertTrue("INFO TYPE NEITHER NEWS NOR WEIBO", false);
    return null;
  }
  
  public static String iP(String paramString)
  {
    return "select tweetid,time,type,name,title,url,shorturl,longurl,pubtime,sourcename,sourceicon,istop,cover,digest,reserved1,reserved2,reserved3,reserved4 from " + paramString + "  ";
  }
  
  public final List<bj> I(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = iP(hT(paramInt)) + "where reserved3 = " + h.fA(paramString) + " order by istop desc , tweetid asc ";
    y.d("MicroMsg.ReaderAppInfoStorage", "getInfobyGroup :" + paramString);
    paramString = this.dXo.a(paramString, null, 2);
    while (paramString.moveToNext())
    {
      bj localbj = new bj();
      localbj.d(paramString);
      localArrayList.add(localbj);
    }
    paramString.close();
    return localArrayList;
  }
  
  public final List<bj> J(String paramString, int paramInt)
  {
    localObject = null;
    localCursor = this.dXo.a(hT(paramInt), new String[] { "*" }, "reserved3=?", new String[] { paramString }, null, null, null, 2);
    if (localCursor != null) {}
    label113:
    do
    {
      try
      {
        if (!localCursor.moveToFirst()) {
          break label113;
        }
        paramString = new ArrayList();
        boolean bool;
        do
        {
          bj localbj = new bj();
          localbj.d(localCursor);
          paramString.add(localbj);
          bool = localCursor.moveToNext();
        } while (bool);
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.ReaderAppInfoStorage", "getByFunctionMsgId, error: %s", new Object[] { paramString.getMessage() });
        paramString = localObject;
        return null;
      }
      finally
      {
        if (localCursor == null) {
          break;
        }
        localCursor.close();
      }
      return paramString;
      paramString = localObject;
    } while (localCursor == null);
    localCursor.close();
    return null;
  }
  
  public final List<bj> bD(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = iP(hT(20)) + " where reserved2 = " + paramLong;
    y.d("MicroMsg.ReaderAppInfoStorage", "getInfoListByMsgSvrID :" + (String)localObject);
    localObject = this.dXo.a((String)localObject, null, 2);
    while (((Cursor)localObject).moveToNext())
    {
      bj localbj = new bj();
      localbj.d((Cursor)localObject);
      localArrayList.add(localbj);
    }
    ((Cursor)localObject).close();
    return localArrayList;
  }
  
  public final Cursor bj(int paramInt1, int paramInt2)
  {
    String str = "SELECT reserved3 from " + hT(paramInt2) + " GROUP BY reserved3 ORDER BY time ASC  LIMIT " + paramInt1 + " offset (SELECT COUNT(*) FROM (SELECT COUNT(*) FROM " + hT(paramInt2) + " GROUP BY reserved3)) -" + paramInt1;
    return this.dXo.a(str, null, 0);
  }
  
  public final int hU(int paramInt)
  {
    int i = 0;
    Object localObject = "select count(*) from (SELECT count(*) FROM " + hT(paramInt) + " group by reserved3)";
    localObject = this.dXo.a((String)localObject, null, 2);
    paramInt = i;
    if (((Cursor)localObject).moveToFirst()) {
      paramInt = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    return paramInt;
  }
  
  public final void hV(int paramInt)
  {
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().abv(bj.hS(paramInt));
    if ((localObject == null) || (!((as)localObject).field_username.equals(bj.hS(paramInt)))) {}
    do
    {
      return;
      ((ak)localObject).setUsername(bj.hS(paramInt));
      ((ak)localObject).setContent("");
      ((ak)localObject).fA(0);
      ((ak)localObject).fy(0);
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().a((ak)localObject, bj.hS(paramInt));
      localObject = "delete from " + hT(paramInt);
    } while (!this.dXo.gk(hT(paramInt), (String)localObject));
    doNotify();
  }
  
  public final void hW(int paramInt)
  {
    Object localObject1 = iP(hT(paramInt)) + " where istop = 1  group by reserved3 ORDER BY time DESC  limit 2";
    y.i("MicroMsg.ReaderAppInfoStorage", "reset conversation, sql is %s", new Object[] { localObject1 });
    Object localObject2 = this.dXo.a((String)localObject1, null, 2);
    if (!((Cursor)localObject2).moveToFirst())
    {
      ((Cursor)localObject2).close();
      localObject1 = new ak();
      ((ak)localObject1).setUsername(bj.hS(paramInt));
      ((ak)localObject1).setContent("");
      ((ak)localObject1).ba(0L);
      ((ak)localObject1).fA(0);
      ((ak)localObject1).fy(0);
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().a((ak)localObject1, bj.hS(paramInt));
      return;
    }
    localObject1 = new bj();
    ((bj)localObject1).d((Cursor)localObject2);
    ((Cursor)localObject2).close();
    localObject2 = new ak();
    ((ak)localObject2).setUsername(bj.hS(paramInt));
    ((ak)localObject2).setContent(((bj)localObject1).getTitle());
    ((ak)localObject2).ba(((bj)localObject1).time);
    ((ak)localObject2).fA(0);
    ((ak)localObject2).fy(0);
    ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().a((ak)localObject2, bj.hS(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bk
 * JD-Core Version:    0.7.0.1
 */