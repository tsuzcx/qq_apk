package com.tencent.mm.plugin.appbrand.report.model;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class i
{
  private static final Set<String> iGU = new HashSet();
  private static final String[] iGV;
  private static final Set<String> iGW;
  private static final ThreadPoolExecutor iGX;
  private static final i.b iGY;
  private static final Pattern iGZ;
  
  static
  {
    AppMethodBeat.i(132629);
    try
    {
      localObject1 = ah.getContext().getAssets().open("15007_api_list.txt");
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
          if (!bo.isNullOrNil(str)) {
            iGU.add(str);
          }
        }
      }
      catch (Exception localException2)
      {
        Object localObject1;
        ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", localException2, "readLine()", new Object[0]);
        bo.b(localBufferedReader);
        bo.b((Closeable)localObject1);
        for (;;)
        {
          iGV = new String[] { "addMapCircles", "addMapControls", "addMapLines", "addMapMarkers", "createAudioInstance", "createRequestTask", "createSocketTask", "destroyAudioInstance", "disableScrollBounce", "drawCanvas", "getAudioState", "getCurrentRoute", "getMapCenterLocation", "getStorage", "getStorageSync", "getSystemInfo", "hideToast", "moveToMapLocation", "onAccelerometerChange", "onCompassChange", "onKeyboardValueChange", "onMapRegionChange", "onSocketClose", "onSocketError", "onSocketMessage", "onSocketOpen", "onTouchEnd", "onTouchMove", "onTouchStart", "onVideoTimeUpdate", "operateAudio", "operateSocketTask", "removeStorageSync", "reportIDKey", "reportKeyValue", "reportRealtimeAction", "setStorage", "setStorageSync", "showModal", "showToast", "syncAudioEvent", "updateCanvas", "updateMap", "traceEvent" };
          iGW = new HashSet(Arrays.asList(iGV));
          iGX = new i.2(TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new i.1());
          iGY = new i.b((byte)0);
          iGZ = Pattern.compile(".*\"errMsg\":\"[^:]+:([^\"]+)\".*");
          AppMethodBeat.o(132629);
          return;
          localException1 = localException1;
          ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", localException1, "open read 15007_api_list.txt", new Object[0]);
          localCloseable = null;
          break;
          bo.b(localBufferedReader);
          bo.b(localCloseable);
        }
      }
      finally
      {
        BufferedReader localBufferedReader;
        Closeable localCloseable;
        bo.b(localBufferedReader);
        bo.b(localCloseable);
        AppMethodBeat.o(132629);
      }
    }
  }
  
  public static boolean EI(String paramString)
  {
    AppMethodBeat.i(132625);
    if (iGW.contains(paramString))
    {
      AppMethodBeat.o(132625);
      return true;
    }
    AppMethodBeat.o(132625);
    return false;
  }
  
  public static String EJ(String paramString)
  {
    AppMethodBeat.i(132627);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(132627);
      return "";
    }
    paramString = iGZ.matcher(paramString);
    if (paramString.matches())
    {
      paramString = bo.nullAsNil(paramString.group(1));
      AppMethodBeat.o(132627);
      return paramString;
    }
    AppMethodBeat.o(132627);
    return "";
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, long paramLong, String paramString5)
  {
    AppMethodBeat.i(132626);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(132626);
      return;
    }
    i.a locala = iGY.aLo();
    locala.appId = paramString1;
    locala.cmG = paramString2;
    locala.iHa = paramString3;
    locala.hCt = paramString4;
    locala.iHb = paramInt;
    locala.iHc = paramLong;
    locala.cvF = paramString5;
    iGX.submit(locala);
    AppMethodBeat.o(132626);
  }
  
  public static void aLk() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.i
 * JD-Core Version:    0.7.0.1
 */