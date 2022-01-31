package com.tencent.liteav;

import android.content.Context;
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
  private String c = "";
  private String d = "";
  private long e = 0L;
  private long f = 0L;
  private long g = 0L;
  
  public i(Context paramContext) {}
  
  private String a(String paramString)
  {
    AppMethodBeat.i(146405);
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
          AppMethodBeat.o(146405);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(146405);
    return null;
  }
  
  public int a(final String paramString1, final String paramString2, final int paramInt, final i.a parama)
  {
    AppMethodBeat.i(146404);
    if ((paramString1 == null) || (paramString1.isEmpty()))
    {
      AppMethodBeat.o(146404);
      return -1;
    }
    this.d = TXCCommonUtil.getAppID();
    if (TextUtils.isEmpty(this.d))
    {
      AppMethodBeat.o(146404);
      return -2;
    }
    AsyncTask.execute(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(146407);
        i.a(i.this, 0L);
        i.b(i.this, 0L);
        i.c(i.this, 0L);
        i.a(i.this, "");
        i.b(i.this, "");
        if (paramInt > 0) {
          i.b(i.this, String.valueOf(paramInt));
        }
        i.c(i.this, paramString2);
        i.a(i.this, TXCCommonUtil.getStreamIDByStreamUrl(paramString1));
        Object localObject = String.format("http://%s/%s/%s/timeshift.m3u8?delay=0&appid=%s&txKbps=0", new Object[] { i.a(i.this), i.b(i.this), i.c(i.this), i.d(i.this) });
        try
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
          TXCLog.e("TXCTimeShiftUtil", "prepareSeekTime: receive response, strResponse = ".concat(String.valueOf(localObject)));
          localObject = i.d(i.this, (String)localObject);
          long l1 = Long.parseLong((String)localObject);
          long l2 = System.currentTimeMillis();
          TXCLog.i("TXCTimeShiftUtil", "time:" + (String)localObject + ",currentTime:" + l2 + ",diff:" + (l2 - l1));
          i.b(i.this, l1 * 1000L);
          i.c(i.this, l2 - i.e(i.this));
          if (parama != null) {
            new Handler(Looper.getMainLooper()).post(new i.1.1(this));
          }
          AppMethodBeat.o(146407);
          return;
        }
        catch (Exception localException)
        {
          i.b(i.this, 0L);
          AppMethodBeat.o(146407);
        }
      }
    });
    AppMethodBeat.o(146404);
    return 0;
  }
  
  public long a()
  {
    AppMethodBeat.i(146402);
    this.g = (System.currentTimeMillis() - this.e);
    long l = this.g;
    AppMethodBeat.o(146402);
    return l;
  }
  
  public String a(long paramLong)
  {
    AppMethodBeat.i(146403);
    String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(this.e + 1000L * paramLong));
    str = String.format("http://%s/%s/%s/timeshift.m3u8?starttime=%s&appid=%s&txKbps=0", new Object[] { this.a, this.c, this.b, str, this.d });
    AppMethodBeat.o(146403);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.i
 * JD-Core Version:    0.7.0.1
 */