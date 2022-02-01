package c.t.m.g;

import android.content.Context;
import android.util.Pair;
import com.tencent.map.geolocation.internal.TencentHttpClient;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public final class bt
  implements TencentHttpClient
{
  private static final List<String> a = Arrays.asList(new String[] { "lbs.map.qq.com", "lbssp.map.qq.com" });
  private w b;
  
  public bt(Context paramContext, String paramString)
  {
    b.a.a(cj.a);
    try
    {
      b.a.a(paramContext, "0M3006CS7U0ZC2K3", paramString, "test_uuid", a);
      this.b = b.a.a();
      return;
    }
    catch (l paramContext)
    {
      cj.a("TxNewHttpClient", "<init>", paramContext);
    }
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
  
  public final Pair<byte[], String> postSync(String paramString, byte[] paramArrayOfByte)
    throws IOException
  {
    if (this.b == null) {
      throw new IOException("can not init net sdk");
    }
    for (;;)
    {
      try
      {
        w localw = this.b;
        paramString = w.a(paramString, paramArrayOfByte);
        paramString.a();
        paramString.b();
        paramString.c();
        paramString = localw.a(paramString);
        if (paramString == null) {
          throw new IOException("null response");
        }
      }
      catch (ab paramString)
      {
        throw new IOException(paramString.getMessage());
        switch (paramString.a())
        {
        case -1: 
          throw new IOException("net sdk error: " + paramString.a());
        }
      }
      catch (Exception paramString)
      {
        throw new IOException(paramString.getMessage());
      }
      paramArrayOfByte = a(paramString.a("content-type"));
      return Pair.create(paramString.b(), paramArrayOfByte);
      paramString = Pair.create("{}".getBytes(), "utf-8");
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.bt
 * JD-Core Version:    0.7.0.1
 */