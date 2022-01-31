package com.tencent.mm.plugin.appbrand.report.model;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class i
{
  private static final Set<String> gYD = new HashSet();
  private static final String[] gYE;
  private static final Set<String> gYF;
  private static final ThreadPoolExecutor gYG;
  private static final i.b gYH;
  private static final Pattern gYI;
  
  static
  {
    try
    {
      localObject1 = ae.getContext().getAssets().open("15007_api_list.txt");
      if (localObject1 != null)
      {
        localObject1 = new InputStreamReader((InputStream)localObject1);
        localBufferedReader = new BufferedReader((Reader)localObject1);
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          String str = localBufferedReader.readLine();
          if (str == null) {
            break;
          }
          if (!bk.bl(str)) {
            gYD.add(str);
          }
        }
      }
      catch (Exception localException2)
      {
        Object localObject1;
        y.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", localException2, "readLine()", new Object[0]);
        bk.b(localBufferedReader);
        bk.b((Closeable)localObject1);
        for (;;)
        {
          gYE = new String[] { "addMapCircles", "addMapControls", "addMapLines", "addMapMarkers", "createAudioInstance", "createRequestTask", "createSocketTask", "destroyAudioInstance", "disableScrollBounce", "drawCanvas", "getAudioState", "getCurrentRoute", "getMapCenterLocation", "getStorage", "getStorageSync", "getSystemInfo", "hideToast", "moveToMapLocation", "onAccelerometerChange", "onCompassChange", "onKeyboardValueChange", "onMapRegionChange", "onSocketClose", "onSocketError", "onSocketMessage", "onSocketOpen", "onTouchEnd", "onTouchMove", "onTouchStart", "onVideoTimeUpdate", "operateAudio", "operateSocketTask", "removeStorageSync", "reportIDKey", "reportKeyValue", "reportRealtimeAction", "setStorage", "setStorageSync", "showModal", "showToast", "syncAudioEvent", "updateCanvas", "updateMap", "traceEvent" };
          gYF = new HashSet(Arrays.asList(gYE));
          gYG = new i.2(TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new i.1());
          gYH = new i.b((byte)0);
          gYI = Pattern.compile(".*\"errMsg\":\"[^:]+:([^\"]+)\".*");
          return;
          localException1 = localException1;
          y.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", localException1, "open read 15007_api_list.txt", new Object[0]);
          localCloseable = null;
          break;
          bk.b(localBufferedReader);
          bk.b(localCloseable);
        }
      }
      finally
      {
        BufferedReader localBufferedReader;
        Closeable localCloseable;
        bk.b(localBufferedReader);
        bk.b(localCloseable);
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, long paramLong, String paramString5)
  {
    if (bk.bl(paramString1)) {
      return;
    }
    i.a locala = gYH.aoq();
    locala.appId = paramString1;
    locala.bFw = paramString2;
    locala.gYJ = paramString3;
    locala.giZ = paramString4;
    locala.gYK = paramInt;
    locala.gYL = paramLong;
    locala.bOn = paramString5;
    gYG.submit(locala);
  }
  
  public static void aol() {}
  
  public static boolean we(String paramString)
  {
    return gYF.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.i
 * JD-Core Version:    0.7.0.1
 */