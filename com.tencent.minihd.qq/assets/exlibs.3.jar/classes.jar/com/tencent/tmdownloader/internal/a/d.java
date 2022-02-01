package com.tencent.tmdownloader.internal.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.tmassistantbase.a.k;
import com.tencent.tmdownloader.internal.b.a;
import com.tencent.tmdownloader.internal.b.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  public String a;
  public String b;
  public String c;
  public int d;
  public int e;
  public String f;
  boolean g;
  public int h;
  public int i;
  public long j;
  public long k;
  public String l;
  protected String m;
  public int n;
  public int o;
  public String p;
  public long q;
  protected HashMap r;
  protected String s;
  
  public d()
  {
    this.g = false;
  }
  
  public d(String paramString1, int paramInt, String paramString2)
  {
    this.b = paramString1;
    this.c = c.a(paramString1);
    this.f = UUID.randomUUID().toString();
    this.n = paramInt;
    this.i = 0;
    this.o = 0;
    this.g = false;
    this.a = paramString2;
    this.p = c.b();
    this.q = 0L;
  }
  
  public static d a(Cursor paramCursor)
  {
    d locald = new d();
    locald.h = paramCursor.getInt(paramCursor.getColumnIndex("taskId"));
    locald.f = paramCursor.getString(paramCursor.getColumnIndex("uId"));
    locald.c = paramCursor.getString(paramCursor.getColumnIndex("finalUrl"));
    locald.b = paramCursor.getString(paramCursor.getColumnIndex("taskUrl"));
    locald.l = paramCursor.getString(paramCursor.getColumnIndex("fileName"));
    locald.a = paramCursor.getString(paramCursor.getColumnIndex("contentType"));
    locald.e = paramCursor.getInt(paramCursor.getColumnIndex("redirectCnt"));
    locald.d = paramCursor.getInt(paramCursor.getColumnIndex("retryCnt"));
    locald.k = paramCursor.getLong(paramCursor.getColumnIndex("totalBytes"));
    locald.i = paramCursor.getInt(paramCursor.getColumnIndex("status"));
    locald.j = paramCursor.getLong(paramCursor.getColumnIndex("receivedBytes"));
    locald.n = paramCursor.getInt(paramCursor.getColumnIndex("priority"));
    locald.p = paramCursor.getString(paramCursor.getColumnIndex("netType"));
    locald.o = paramCursor.getInt(paramCursor.getColumnIndex("downloadFailedErrCode"));
    locald.q = paramCursor.getLong(paramCursor.getColumnIndex("downloadFailedTime"));
    locald.s = paramCursor.getString(paramCursor.getColumnIndex("headerParams"));
    return locald;
  }
  
  public static void a(ContentValues paramContentValues, d paramd)
  {
    if ((paramd != null) && (paramContentValues != null))
    {
      paramContentValues.put("taskId", Integer.valueOf(paramd.h));
      paramContentValues.put("uId", paramd.f);
      paramContentValues.put("finalUrl", paramd.c);
      paramContentValues.put("taskUrl", paramd.b);
      paramContentValues.put("fileName", paramd.l);
      paramContentValues.put("contentType", paramd.a);
      paramContentValues.put("redirectCnt", Integer.valueOf(paramd.e));
      paramContentValues.put("retryCnt", Integer.valueOf(paramd.d));
      paramContentValues.put("totalBytes", Long.valueOf(paramd.k));
      paramContentValues.put("status", Integer.valueOf(paramd.i));
      paramContentValues.put("receivedBytes", Long.valueOf(paramd.j));
      paramContentValues.put("priority", Integer.valueOf(paramd.n));
      paramContentValues.put("netType", paramd.p);
      paramContentValues.put("downloadFailedErrCode", Integer.valueOf(paramd.o));
      paramContentValues.put("downloadFailedTime", Long.valueOf(paramd.q));
      paramContentValues.put("headerParams", paramd.s);
    }
  }
  
  public void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        boolean bool = c();
        if (bool) {
          return;
        }
        this.i = paramInt;
        if (this.i != 6)
        {
          if (this.i == 5) {
            this.q = System.currentTimeMillis();
          }
          a.a().a(this);
          e.a().a(this.b, this.i, this.o, "");
        }
        else
        {
          a.a().a(this.b);
        }
      }
      finally {}
    }
  }
  
  public void a(long paramLong)
  {
    if (0L == paramLong) {
      this.j = 0L;
    }
    this.k = paramLong;
    a.a().a(this);
  }
  
  public void a(String paramString)
  {
    k.c(paramString, "--------dump DownloadInfo-----------");
    k.c(paramString, "mContentType: " + this.a);
    k.c(paramString, "mURL: " + this.b);
    k.c(paramString, "mRetryCnt: " + this.d);
    k.c(paramString, "mRedirectCnt: " + this.e);
    k.c(paramString, "mTotalBytes: " + this.k);
    k.c(paramString, "mUUID: " + this.f);
    k.c(paramString, "mStatus: " + this.i);
    k.c(paramString, "mReceivedBytes: " + this.j);
    k.c(paramString, "mFileName: " + this.l);
    k.c(paramString, "mDownloadFailedErrCode: " + this.o);
    k.c(paramString, "mNetType:" + this.p);
    k.c(paramString, "mDownloadFailedTime:" + this.q);
    k.c(paramString, "mHeaderParamString:" + this.s);
  }
  
  public void a(HashMap paramHashMap)
  {
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      this.r = paramHashMap;
      this.s = new JSONObject(paramHashMap).toString();
    }
  }
  
  boolean a()
  {
    return (this.k != 0L) && (this.j == this.k);
  }
  
  public void b(long paramLong)
  {
    this.j += paramLong;
    e.a().a(this.b, this.j, this.k);
  }
  
  boolean b()
  {
    return this.d <= 5;
  }
  
  boolean c()
  {
    return this.i > 3;
  }
  
  public int d()
  {
    k.c("_DownloadInfo", "url: " + this.b);
    if ((!TextUtils.isEmpty(this.s)) && ((this.r == null) || (this.r.size() <= 0)))
    {
      HashMap localHashMap = new HashMap();
      try
      {
        JSONObject localJSONObject = new JSONObject(this.s);
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localHashMap.put(str, localJSONObject.getString(str));
          continue;
          if (!this.g) {
            break label162;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        k.b("_DownloadInfo", "exception: ", localJSONException);
        localJSONException.printStackTrace();
      }
    }
    for (;;)
    {
      return 5;
      if (localJSONException.size() > 0) {
        this.r = localJSONException;
      }
    }
    label162:
    if (this.l == null) {
      this.l = c.a(this.b, this.a);
    }
    if (this.m == null) {
      this.m = c.a(this.b, this.a);
    }
    if (this.k == 0L) {
      new b(this.m, this.l).a();
    }
    if (this.i == 5) {
      this.c = this.b;
    }
    Object localObject;
    if (!TextUtils.isEmpty(this.l))
    {
      localObject = new b(this.m, this.l);
      long l1 = ((b)localObject).b();
      k.c("_DownloadInfo", "FileLen: " + l1 + " filename: " + this.l);
      if (l1 > this.k) {
        ((b)localObject).a();
      }
      for (this.j = 0L; a(); this.j = l1)
      {
        ((b)localObject).f();
        a(4);
        return 4;
      }
    }
    if (this.i == 5)
    {
      this.e = 0;
      this.d = 0;
      this.i = 0;
      this.o = 0;
    }
    k.c("_DownloadInfo", "startDownloadIfReady...");
    a("_DownloadInfo");
    if (h.a().a(this.b) == null)
    {
      localObject = new g(this);
      a(1);
      this.h = h.a().a((g)localObject);
    }
    return 0;
  }
  
  public void e()
  {
    k.c("_DownloadInfo", "DownloadInfo::pauseDownload url: " + this.b);
    h.a().a(this.h);
    a(3);
  }
  
  public void f()
  {
    k.c("_DownloadInfo", "DownloadInfo::stopDownload url: " + this.b);
    h.a().a(this.h);
    a(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.a.d
 * JD-Core Version:    0.7.0.1
 */