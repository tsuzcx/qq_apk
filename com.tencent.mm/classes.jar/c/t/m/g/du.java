package c.t.m.g;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.map.geolocation.internal.TencentHttpClient;
import java.io.IOException;

public final class du
  implements dc, TencentHttpClient
{
  private static b a;
  
  public du(Context paramContext, String paramString)
  {
    a = new b(paramContext, "test_uuid", paramString);
  }
  
  private static f a(e parame)
  {
    label57:
    for (;;)
    {
      try
      {
        long l = SystemClock.elapsedRealtime();
        locald = a.a(a);
        j.a("TxNewHttpClient", "< halley init>", localThrowable1);
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          j.a("doPost", 6, "TimeCost:" + (SystemClock.elapsedRealtime() - l));
          if (locald != null) {
            break;
          }
          j.a("TxNewHttpClient", 6, "< halley init> httpClient is null");
          return null;
        }
        catch (Throwable localThrowable2)
        {
          d locald;
          break label57;
        }
        localThrowable1 = localThrowable1;
        locald = null;
      }
    }
    return locald.a(parame);
  }
  
  private static String a(String paramString)
  {
    String str2 = "GBK";
    String str1 = str2;
    int j;
    int i;
    if (paramString != null)
    {
      paramString = paramString.split(";");
      j = paramString.length;
      i = 0;
    }
    for (;;)
    {
      str1 = str2;
      if (i < j)
      {
        str1 = paramString[i].trim();
        int k = str1.indexOf("charset=");
        if (-1 != k) {
          str1 = str1.substring(k + 8, str1.length());
        }
      }
      else
      {
        return str1;
      }
      i += 1;
    }
  }
  
  private static e b(String paramString, byte[] paramArrayOfByte)
  {
    label60:
    for (;;)
    {
      try
      {
        long l = SystemClock.elapsedRealtime();
        locald = a.a(a);
        j.a("TxNewHttpClient", "< halley init>", localThrowable1);
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          j.a("getHttpRequest", 6, "TimeCost:" + (SystemClock.elapsedRealtime() - l));
          if (locald != null) {
            break;
          }
          j.a("TxNewHttpClient", 6, "< halley init> httpClient is null");
          return null;
        }
        catch (Throwable localThrowable2)
        {
          d locald;
          break label60;
        }
        localThrowable1 = localThrowable1;
        locald = null;
      }
    }
    paramString = locald.a(paramString, paramArrayOfByte);
    paramString.a("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4; Nexus 5 Build/KRT16M)");
    paramString.b();
    return paramString;
  }
  
  public final String a(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      paramString = postSync(paramString, paramArrayOfByte);
      paramString = new String(paramString.getByteArray("data_bytes"), paramString.getString("data_charset"));
      return paramString;
    }
    catch (Throwable paramString) {}
    return "{}";
  }
  
  public final Bundle postSync(String paramString, byte[] paramArrayOfByte)
  {
    d locald = null;
    localObject = locald;
    try
    {
      long l = SystemClock.elapsedRealtime();
      localObject = locald;
      locald = a.a(a);
      localObject = locald;
      j.a("HalleyAgent", 6, "TimeCost:" + (SystemClock.elapsedRealtime() - l));
      localObject = locald;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        j.a("TxNewHttpClient", "< halley init>", localThrowable);
      }
      try
      {
        localObject = b(paramString, paramArrayOfByte);
        paramString = a((e)localObject);
        if ((paramString.a() == 0) && (paramString.c() >= 200) && (paramString.c() < 300))
        {
          paramArrayOfByte = new Bundle();
          paramArrayOfByte.putString("req_key", ((e)localObject).a());
          if (paramString.d() == null)
          {
            paramArrayOfByte.putByteArray("data_bytes", "{}".getBytes());
            paramArrayOfByte.putString("data_charset", "utf-8");
            return paramArrayOfByte;
          }
          localObject = a(paramString.a("content-type"));
          paramArrayOfByte.putByteArray("data_bytes", paramString.d());
          paramArrayOfByte.putString("data_charset", (String)localObject);
          return paramArrayOfByte;
        }
      }
      catch (Exception paramString)
      {
        throw new IOException(paramString.getMessage());
      }
      throw new IOException("net sdk error: errCode: " + paramString.a() + ", errInfo: " + paramString.b() + ", statusCode: " + paramString.c() + ", reqKey: " + ((e)localObject).a());
    }
    if (localObject == null)
    {
      j.a("TxNewHttpClient", 6, "< halley init> httpClient is null");
      throw new IOException("can not init net sdk");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     c.t.m.g.du
 * JD-Core Version:    0.7.0.1
 */