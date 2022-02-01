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

public class j
{
  private String a = "";
  private String b = "";
  private int c = 0;
  private String d = "";
  private String e = "";
  private long f = 0L;
  
  private String a(String paramString)
  {
    AppMethodBeat.i(229346);
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
          AppMethodBeat.o(229346);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(229346);
    return null;
  }
  
  public int a(final String paramString1, final String paramString2, final int paramInt, final a parama)
  {
    AppMethodBeat.i(229407);
    if ((paramString1 == null) || (paramString1.isEmpty()))
    {
      AppMethodBeat.o(229407);
      return -1;
    }
    this.d = TXCCommonUtil.getAppID();
    if (TextUtils.isEmpty(this.d))
    {
      AppMethodBeat.o(229407);
      return -2;
    }
    AsyncTask.execute(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(229423);
        j.a(j.this, System.currentTimeMillis());
        j.a(j.this, "");
        j.a(j.this, paramInt);
        j.b(j.this, paramString2);
        j.a(j.this, TXCCommonUtil.getStreamIDByStreamUrl(paramString1));
        j.c(j.this, TXCCommonUtil.getAppNameByStreamUrl(paramString1));
        if (j.a(j.this) == null) {
          j.c(j.this, "live");
        }
        Object localObject;
        if (j.b(j.this) < 0) {
          localObject = String.format("http://%s/timeshift/%s/%s/timeshift.m3u8?delay=0", new Object[] { j.c(j.this), j.a(j.this), j.d(j.this) });
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
            localObject = String.format("http://%s/%s/%s/timeshift.m3u8?delay=0&appid=%s&txKbps=0", new Object[] { j.c(j.this), Integer.valueOf(j.b(j.this)), j.d(j.this), j.e(j.this) });
          }
          TXCLog.i("TXCTimeShiftUtil", "prepareSeekTime: receive response, strResponse = ".concat(String.valueOf(localObject)));
          localObject = j.d(j.this, (String)localObject);
          if (localObject != null) {
            j.a(j.this, Long.parseLong((String)localObject) * 1000L);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            long l1;
            long l2;
            j.a(j.this, System.currentTimeMillis());
            TXCLog.e("TXCTimeShiftUtil", "prepareSeekTime error " + localException.toString());
          }
        }
        l1 = System.currentTimeMillis();
        TXCLog.i("TXCTimeShiftUtil", "live start time:" + j.f(j.this) + ",currentTime:" + l1 + ",diff:" + (l1 - j.f(j.this)));
        l2 = j.f(j.this);
        if (parama != null) {
          new Handler(Looper.getMainLooper()).post(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(229468);
              j.1.this.d.a(this.a);
              AppMethodBeat.o(229468);
            }
          });
        }
        AppMethodBeat.o(229423);
      }
    });
    AppMethodBeat.o(229407);
    return 0;
  }
  
  public long a()
  {
    AppMethodBeat.i(229396);
    long l1 = System.currentTimeMillis();
    long l2 = this.f;
    AppMethodBeat.o(229396);
    return l1 - l2;
  }
  
  public String a(long paramLong)
  {
    AppMethodBeat.i(229402);
    String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(this.f + 1000L * paramLong));
    if (this.c < 0) {
      paramLong = (System.currentTimeMillis() - this.f - paramLong) / 1000L;
    }
    for (str = String.format("http://%s/timeshift/%s/%s/timeshift.m3u8?delay=%d", new Object[] { this.a, this.e, this.b, Long.valueOf(paramLong) });; str = String.format("http://%s/%s/%s/timeshift.m3u8?starttime=%s&appid=%s&txKbps=0", new Object[] { this.a, Integer.valueOf(this.c), this.b, str, this.d }))
    {
      AppMethodBeat.o(229402);
      return str;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.j
 * JD-Core Version:    0.7.0.1
 */