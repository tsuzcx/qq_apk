package com.tencent.liteav;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class j$1
  implements Runnable
{
  j$1(j paramj, String paramString, j.a parama) {}
  
  public void run()
  {
    j.a(this.c, 0L);
    j.b(this.c, 0L);
    j.c(this.c, 0L);
    j.a(this.c, "");
    j.b(this.c, "");
    j.a(this.c, TXCCommonUtil.getStreamIDByStreamUrl(this.a));
    j.b(this.c, j.a(this.c, "bizid", this.a));
    if (TextUtils.isEmpty(j.a(this.c))) {
      j.b(this.c, this.a.substring(this.a.indexOf("//") + 2, this.a.indexOf(".")));
    }
    j.c(this.c, TXCCommonUtil.getAppID());
    Object localObject = String.format("http://playtimeshift.live.myqcloud.com/%s/%s/timeshift.m3u8?delay=0&appid=%s&txKbps=0", new Object[] { j.a(this.c), j.b(this.c), j.c(this.c) });
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
      TXCLog.e("TXCTimeShiftUtil", "prepareSeekTime: receive response, strResponse = " + (String)localObject);
      localObject = j.d(this.c, (String)localObject);
      long l1 = Long.parseLong((String)localObject);
      long l2 = System.currentTimeMillis();
      TXCLog.i("TXCTimeShiftUtil", "time:" + (String)localObject + ",currentTime:" + l2 + ",diff:" + (l2 - l1));
      j.b(this.c, l1 * 1000L);
      j.c(this.c, l2 - j.d(this.c));
      if (this.b != null) {
        new Handler(Looper.getMainLooper()).post(new j.1.1(this));
      }
      return;
    }
    catch (Exception localException)
    {
      j.b(this.c, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.j.1
 * JD-Core Version:    0.7.0.1
 */