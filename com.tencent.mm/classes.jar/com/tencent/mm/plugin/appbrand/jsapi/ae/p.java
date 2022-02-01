package com.tencent.mm.plugin.appbrand.jsapi.ae;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.wifi.WifiManager;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.dp;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.c.c;
import com.tencent.mm.plugin.appbrand.utils.aq;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public class p<C extends g>
  extends n<C>
{
  public static final int CTRL_INDEX = 40;
  public static final String NAME = "getSystemInfo";
  
  public p()
  {
    this(new d());
    AppMethodBeat.i(326040);
    AppMethodBeat.o(326040);
  }
  
  public p(d<C> paramd)
  {
    super(paramd);
  }
  
  public static void a(Map<String, Object> paramMap, g paramg)
  {
    AppMethodBeat.i(326059);
    paramg = (f)paramg.T(f.class);
    if (paramg == null) {}
    for (float f = 1.0F;; f = paramg.cuL())
    {
      paramMap.put("fontSizeSetting", Integer.valueOf(Math.round(16.0F * f)));
      paramMap.put("fontSizeScaleFactor", Float.valueOf(f));
      AppMethodBeat.o(326059);
      return;
    }
  }
  
  public static void a(Map<String, Object> paramMap, g paramg, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(326055);
    HashMap localHashMap = new HashMap(6);
    paramg = paramg.getWindowAndroid().getSafeAreaInsets();
    if (paramg != null)
    {
      int i = com.tencent.mm.plugin.appbrand.af.i.DA(paramg.left);
      int j = com.tencent.mm.plugin.appbrand.af.i.DA(paramg.top);
      paramInt1 = com.tencent.mm.plugin.appbrand.af.i.DA(Math.min(paramg.right, paramInt1));
      paramInt2 = com.tencent.mm.plugin.appbrand.af.i.DA(Math.min(paramg.bottom, paramInt2));
      localHashMap.put("left", Integer.valueOf(i));
      localHashMap.put("top", Integer.valueOf(j));
      localHashMap.put("right", Integer.valueOf(paramInt1));
      localHashMap.put("bottom", Integer.valueOf(paramInt2));
      localHashMap.put("width", Integer.valueOf(paramInt1 - i));
      localHashMap.put("height", Integer.valueOf(paramInt2 - j));
      paramMap.put("safeArea", localHashMap);
    }
    AppMethodBeat.o(326055);
  }
  
  public static int f(g paramg)
  {
    AppMethodBeat.i(326048);
    Object localObject = dp.j(paramg);
    int i;
    if ((localObject != null) && (((ad)localObject).cED() != null))
    {
      i = ((ad)localObject).cED().getDrawnStatusBarHeight();
      if (i != 0) {}
    }
    else
    {
      localObject = paramg.getWindowAndroid().getStatusBar();
      Log.e("Luggage.FULL.JsApiGetSystemInfoLU", "getIntersectStatusBarHeight with component(%s %s), use windowStatusBar[%s]", new Object[] { paramg.getAppId(), paramg.getClass().getName(), localObject });
      if (localObject != null)
      {
        i = ((c.c)localObject).height;
        AppMethodBeat.o(326048);
        return i;
      }
      AppMethodBeat.o(326048);
      return 0;
    }
    AppMethodBeat.o(326048);
    return i;
  }
  
  protected Map<String, Object> a(C paramC)
  {
    AppMethodBeat.i(147302);
    Map localMap = super.a(paramC);
    Object localObject1 = aq.n(paramC);
    localMap.put("windowWidth", Integer.valueOf(com.tencent.mm.plugin.appbrand.af.i.DA(localObject1[0])));
    localMap.put("windowHeight", Integer.valueOf(com.tencent.mm.plugin.appbrand.af.i.DA(localObject1[1])));
    localObject1 = aq.d(paramC);
    int i = localObject1[0];
    int j = localObject1[1];
    localMap.put("screenWidth", Integer.valueOf(com.tencent.mm.plugin.appbrand.af.i.DA(i)));
    localMap.put("screenHeight", Integer.valueOf(com.tencent.mm.plugin.appbrand.af.i.DA(j)));
    localMap.put("pixelRatio", Float.valueOf(com.tencent.mm.plugin.appbrand.af.i.mn()));
    localMap.put("statusBarHeight", Integer.valueOf(com.tencent.mm.plugin.appbrand.af.i.DA(f(paramC))));
    localMap.put("language", LocaleUtil.getCurrentLanguage(paramC.getContext()));
    localMap.put("version", ChannelUtil.formatVersion(null, BuildInfo.CLIENT_VERSION_INT));
    if ((paramC.getRuntime() != null) && (paramC.getRuntime().asG() != null)) {
      localMap.put("benchmarkLevel", Integer.valueOf(((AppBrandSysConfigLU)paramC.getRuntime().asG()).eqb));
    }
    localMap.put("screenTop", Integer.valueOf(com.tencent.mm.plugin.appbrand.af.i.DA(aq.f(paramC))));
    int k = paramC.getContext().getResources().getConfiguration().orientation;
    Object localObject2;
    if (2 == k)
    {
      localMap.put("deviceOrientation", "landscape");
      a(localMap, paramC);
      localObject1 = new HashMap();
      localObject2 = paramC.getContext();
      if (localObject2 == null) {
        break label645;
      }
      WifiManager localWifiManager = (WifiManager)((Context)localObject2).getApplicationContext().getSystemService("wifi");
      if (localWifiManager == null) {
        break label564;
      }
      ((Map)localObject1).put("wifiEnabled", Boolean.valueOf(localWifiManager.isWifiEnabled()));
      ((Map)localObject1).put("notificationAuthorized", Boolean.valueOf(androidx.core.app.i.X((Context)localObject2).DB()));
      ((Map)localObject1).put("locationEnabled", Boolean.valueOf(com.tencent.mm.modelgeo.d.bJm()));
    }
    for (;;)
    {
      try
      {
        ((Map)localObject1).put("locationAuthorized", Boolean.valueOf(com.tencent.luggage.l.i.s((Context)localObject2, "android.permission.ACCESS_FINE_LOCATION")));
        ((Map)localObject1).put("cameraAuthorized", Boolean.valueOf(com.tencent.luggage.l.i.s((Context)localObject2, "android.permission.CAMERA")));
        ((Map)localObject1).put("microphoneAuthorized", Boolean.valueOf(com.tencent.luggage.l.i.s((Context)localObject2, "android.permission.RECORD_AUDIO")));
        localObject2 = BluetoothAdapter.getDefaultAdapter();
        if (localObject2 == null) {
          break label732;
        }
        ((Map)localObject1).put("bluetoothEnabled", Boolean.valueOf(((BluetoothAdapter)localObject2).isEnabled()));
        ((Map)localObject1).put("phoneCalendarAuthorized", Boolean.TRUE);
        Log.i("Luggage.FULL.JsApiGetSystemInfoLU", "check permissions:%s", new Object[] { localObject1 });
        localMap.putAll((Map)localObject1);
        a(localMap, paramC, i, j);
        b(paramC, localMap);
        AppMethodBeat.o(147302);
        return localMap;
        if (1 != k) {
          break;
        }
        localMap.put("deviceOrientation", "portrait");
        break;
        label564:
        ((Map)localObject1).put("wifiEnabled", Boolean.FALSE);
      }
      catch (Exception localException)
      {
        Log.e("Luggage.FULL.JsApiGetSystemInfoLU", "check permissions exception", new Object[] { localException });
        ((Map)localObject1).put("locationAuthorized", Boolean.FALSE);
        ((Map)localObject1).put("cameraAuthorized", Boolean.FALSE);
        ((Map)localObject1).put("microphoneAuthorized", Boolean.FALSE);
        continue;
      }
      label645:
      ((Map)localObject1).put("wifiEnabled", Boolean.FALSE);
      ((Map)localObject1).put("notificationAuthorized", Boolean.FALSE);
      ((Map)localObject1).put("locationEnabled", Boolean.FALSE);
      ((Map)localObject1).put("locationAuthorized", Boolean.FALSE);
      ((Map)localObject1).put("cameraAuthorized", Boolean.FALSE);
      ((Map)localObject1).put("microphoneAuthorized", Boolean.FALSE);
      continue;
      label732:
      ((Map)localObject1).put("bluetoothEnabled", Boolean.FALSE);
    }
  }
  
  protected void b(C paramC, Map<String, Object> paramMap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.p
 * JD-Core Version:    0.7.0.1
 */