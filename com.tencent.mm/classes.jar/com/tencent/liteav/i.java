package com.tencent.liteav;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class i
{
  private String a = "";
  private String b = "";
  private int c = 0;
  private String d = "";
  private String e = "";
  private long f = 0L;
  
  private String a(String paramString)
  {
    AppMethodBeat.i(16686);
    if (paramString.contains("#EXT-TX-TS-START-TIME"))
    {
      int i = paramString.indexOf("#EXT-TX-TS-START-TIME:") + 22;
      if (i > 0)
      {
        paramString = paramString.substring(i);
        i = paramString.indexOf("#");
        if (i > 0)
        {
          paramString = paramString.substring(0, i).replaceAll("\r\n", "");
          AppMethodBeat.o(16686);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(16686);
    return null;
  }
  
  public int a(final String paramString1, final String paramString2, final int paramInt, final a parama)
  {
    AppMethodBeat.i(16685);
    if ((paramString1 == null) || (paramString1.isEmpty()))
    {
      AppMethodBeat.o(16685);
      return -1;
    }
    this.d = TXCCommonUtil.getAppID();
    if (TextUtils.isEmpty(this.d))
    {
      AppMethodBeat.o(16685);
      return -2;
    }
    AsyncTask.execute(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14381);
        i.a(i.this, System.currentTimeMillis());
        i.a(i.this, "");
        i.a(i.this, paramInt);
        i.b(i.this, paramString2);
        i.a(i.this, TXCCommonUtil.getStreamIDByStreamUrl(paramString1));
        i.c(i.this, TXCCommonUtil.getAppNameByStreamUrl(paramString1));
        if (i.a(i.this) == null) {
          i.c(i.this, "live");
        }
        Object localObject;
        if (i.b(i.this) < 0) {
          localObject = String.format("http://%s/timeshift/%s/%s/timeshift.m3u8?delay=0", new Object[] { i.c(i.this), i.a(i.this), i.d(i.this) });
        }
        try
        {
          for (;;)
          {
            localObject = (HttpURLConnection)new URL((String)localObject).openConnection();
            ((HttpURLConnection)localObject).setDoOutput(true);
            ((HttpURLConnection)localObject).setDoInput(true);
            ((HttpURLConnection)localObject).setUseCaches(false);
            ((HttpURLConnection)localObject).setConnectTimeout(5000);
            ((HttpURLConnection)localObject).setReadTimeout(5000);
            ((HttpURLConnection)localObject).setRequestMethod("GET");
            ((HttpURLConnection)localObject).setRequestProperty("Charsert", "UTF-8");
            ((HttpURLConnection)localObject).setRequestProperty("Content-Type", "text/plain;");
            BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(((HttpURLConnection)localObject).getInputStream()));
            String str;
            for (localObject = "";; localObject = (String)localObject + str)
            {
              str = localBufferedReader.readLine();
              if (str == null) {
                break;
              }
            }
            localObject = String.format("http://%s/%s/%s/timeshift.m3u8?delay=0&appid=%s&txKbps=0", new Object[] { i.c(i.this), Integer.valueOf(i.b(i.this)), i.d(i.this), i.e(i.this) });
          }
          TXCLog.i("TXCTimeShiftUtil", "prepareSeekTime: receive response, strResponse = ".concat(String.valueOf(localObject)));
          localObject = i.d(i.this, (String)localObject);
          if (localObject != null) {
            i.a(i.this, Long.parseLong((String)localObject) * 1000L);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            long l1;
            long l2;
            i.a(i.this, System.currentTimeMillis());
            TXCLog.e("TXCTimeShiftUtil", "prepareSeekTime error " + localException.toString());
          }
        }
        l1 = System.currentTimeMillis();
        TXCLog.i("TXCTimeShiftUtil", "live start time:" + i.f(i.this) + ",currentTime:" + l1 + ",diff:" + (l1 - i.f(i.this)));
        l2 = i.f(i.this);
        if (parama != null) {
          new Handler(Looper.getMainLooper()).post(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(16064);
              i.1.this.d.a(this.a);
              AppMethodBeat.o(16064);
            }
          });
        }
        AppMethodBeat.o(14381);
      }
    });
    AppMethodBeat.o(16685);
    return 0;
  }
  
  public long a()
  {
    AppMethodBeat.i(16683);
    long l1 = System.currentTimeMillis();
    long l2 = this.f;
    AppMethodBeat.o(16683);
    return l1 - l2;
  }
  
  public String a(long paramLong)
  {
    AppMethodBeat.i(16684);
    String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(this.f + 1000L * paramLong));
    if (this.c < 0) {
      paramLong = (System.currentTimeMillis() - this.f - paramLong) / 1000L;
    }
    for (str = String.format("http://%s/timeshift/%s/%s/timeshift.m3u8?delay=%d", new Object[] { this.a, Integer.valueOf(this.c), this.b, Long.valueOf(paramLong) });; str = String.format("http://%s/%s/%s/timeshift.m3u8?starttime=%s&appid=%s&txKbps=0", new Object[] { this.a, Integer.valueOf(this.c), this.b, str, this.d }))
    {
      AppMethodBeat.o(16684);
      return str;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.i
 * JD-Core Version:    0.7.0.1
 */