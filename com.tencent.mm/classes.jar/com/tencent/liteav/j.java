package com.tencent.liteav;

import android.content.Context;
import android.os.AsyncTask;
import java.text.SimpleDateFormat;
import java.util.Date;

public class j
{
  private String a = "";
  private String b = "";
  private String c = "";
  private long d = 0L;
  private long e = 0L;
  private long f = 0L;
  
  public j(Context paramContext) {}
  
  private String a(String paramString)
  {
    if (paramString.contains("#EXT-TX-TS-START-TIME"))
    {
      int i = paramString.indexOf("#EXT-TX-TS-START-TIME:") + 22;
      if (i > 0)
      {
        paramString = paramString.substring(i);
        i = paramString.indexOf("#");
        if (i > 0) {
          return paramString.substring(0, i).replaceAll("\r\n", "");
        }
      }
    }
    return null;
  }
  
  private String a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0))
    {
      paramString1 = null;
      return paramString1;
    }
    String str = paramString1.toLowerCase();
    paramString2 = paramString2.split("[?&]");
    int j = paramString2.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label112;
      }
      paramString1 = paramString2[i];
      if (paramString1.indexOf("=") != -1)
      {
        paramString1 = paramString1.split("[=]");
        if (paramString1.length == 2)
        {
          Object localObject = paramString1[0];
          paramString1 = paramString1[1];
          if ((localObject != null) && (localObject.toLowerCase().equalsIgnoreCase(str))) {
            break;
          }
        }
      }
      i += 1;
    }
    label112:
    return "";
  }
  
  public int a(String paramString, j.a parama)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      return -1;
    }
    AsyncTask.execute(new j.1(this, paramString, parama));
    return 0;
  }
  
  public long a()
  {
    this.f = (System.currentTimeMillis() - this.d);
    return this.f;
  }
  
  public String a(long paramLong)
  {
    String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(this.d + 1000L * paramLong));
    return String.format("http://playtimeshift.live.myqcloud.com/%s/%s/timeshift.m3u8?starttime=%s&appid=%s&txKbps=0", new Object[] { this.b, this.a, str, this.c });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.j
 * JD-Core Version:    0.7.0.1
 */