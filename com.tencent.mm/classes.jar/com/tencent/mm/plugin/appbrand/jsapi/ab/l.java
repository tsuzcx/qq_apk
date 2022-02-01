package com.tencent.mm.plugin.appbrand.jsapi.ab;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.view.View;
import androidx.core.app.h;
import com.tencent.luggage.k.i;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.dh;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.platform.window.c.c;
import com.tencent.mm.plugin.appbrand.utils.ak;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public class l<C extends com.tencent.mm.plugin.appbrand.g>
  extends j<C>
{
  public static final int CTRL_INDEX = 40;
  public static final String NAME = "getSystemInfo";
  
  protected Map<String, Object> a(C paramC)
  {
    AppMethodBeat.i(147302);
    Map localMap = super.a(paramC);
    Object localObject1 = ak.r(paramC);
    localMap.put("windowWidth", Integer.valueOf(com.tencent.mm.plugin.appbrand.ac.g.Dg(localObject1[0])));
    localMap.put("windowHeight", Integer.valueOf(com.tencent.mm.plugin.appbrand.ac.g.Dg(localObject1[1])));
    localObject1 = ak.f(paramC);
    int m = localObject1[0];
    int k = localObject1[1];
    localMap.put("screenWidth", Integer.valueOf(com.tencent.mm.plugin.appbrand.ac.g.Dg(m)));
    localMap.put("screenHeight", Integer.valueOf(com.tencent.mm.plugin.appbrand.ac.g.Dg(k)));
    localMap.put("pixelRatio", Float.valueOf(com.tencent.mm.plugin.appbrand.ac.g.clS()));
    localObject1 = dh.k(paramC);
    int j;
    if ((localObject1 != null) && (((ad)localObject1).cdZ() != null))
    {
      j = ((ad)localObject1).cdZ().getDrawnStatusBarHeight();
      i = j;
      if (j != 0) {}
    }
    else
    {
      localObject1 = paramC.getWindowAndroid().getStatusBar();
      Log.e("Luggage.FULL.JsApiGetSystemInfoLU", "getIntersectStatusBarHeight with component(%s %s), use windowStatusBar[%s]", new Object[] { paramC.getAppId(), paramC.getClass().getName(), localObject1 });
      if (localObject1 == null) {
        break label901;
      }
      i = ((c.c)localObject1).height;
    }
    localMap.put("statusBarHeight", Integer.valueOf(com.tencent.mm.plugin.appbrand.ac.g.Dg(i)));
    localMap.put("language", LocaleUtil.getCurrentLanguage(paramC.getContext()));
    localMap.put("version", ChannelUtil.formatVersion(null, BuildInfo.CLIENT_VERSION_INT));
    if ((paramC.getRuntime() != null) && (paramC.getRuntime().Sp() != null)) {
      localMap.put("benchmarkLevel", Integer.valueOf(((AppBrandSysConfigLU)paramC.getRuntime().Sp()).cxH));
    }
    localObject1 = new int[2];
    Object localObject2;
    if ((paramC instanceof com.tencent.mm.plugin.appbrand.g))
    {
      localObject2 = ak.q((com.tencent.mm.plugin.appbrand.g)paramC);
      if (localObject2 != null) {
        ((View)localObject2).getLocationOnScreen((int[])localObject1);
      }
    }
    for (int i = localObject1[1];; i = 0)
    {
      Log.v("Luggage.WXA.UIUtil", "getScreenTop: [%d]", new Object[] { Integer.valueOf(i) });
      localMap.put("screenTop", Integer.valueOf(com.tencent.mm.plugin.appbrand.ac.g.Dg(i)));
      i = paramC.getContext().getResources().getConfiguration().orientation;
      label418:
      float f;
      if (2 == i)
      {
        localMap.put("deviceOrientation", "landscape");
        localObject1 = (c)paramC.K(c.class);
        if (localObject1 != null) {
          break label927;
        }
        f = 1.0F;
        label436:
        localMap.put("fontSizeSetting", Integer.valueOf(Math.round(f * 16.0F)));
        localObject1 = new HashMap();
        localObject2 = paramC.getContext();
        if (localObject2 == null) {
          break label1035;
        }
        Object localObject3 = (WifiManager)((Context)localObject2).getApplicationContext().getSystemService("wifi");
        if (localObject3 == null) {
          break label938;
        }
        ((Map)localObject1).put("wifiEnabled", Boolean.valueOf(((WifiManager)localObject3).isWifiEnabled()));
        label514:
        ((Map)localObject1).put("notificationAuthorized", Boolean.valueOf(h.M((Context)localObject2).gs()));
        localObject3 = (LocationManager)((Context)localObject2).getSystemService("location");
        if (localObject3 == null) {
          break label954;
        }
        ((Map)localObject1).put("locationEnabled", Boolean.valueOf(((LocationManager)localObject3).isProviderEnabled("gps")));
      }
      for (;;)
      {
        try
        {
          ((Map)localObject1).put("locationAuthorized", Boolean.valueOf(i.o((Context)localObject2, "android.permission.ACCESS_FINE_LOCATION")));
          ((Map)localObject1).put("cameraAuthorized", Boolean.valueOf(i.o((Context)localObject2, "android.permission.CAMERA")));
          ((Map)localObject1).put("microphoneAuthorized", Boolean.valueOf(i.o((Context)localObject2, "android.permission.RECORD_AUDIO")));
          localObject2 = BluetoothAdapter.getDefaultAdapter();
          if (localObject2 == null) {
            break label1121;
          }
          ((Map)localObject1).put("bluetoothEnabled", Boolean.valueOf(((BluetoothAdapter)localObject2).isEnabled()));
          Log.i("Luggage.FULL.JsApiGetSystemInfoLU", "check permissions:%s", new Object[] { localObject1 });
          localMap.putAll((Map)localObject1);
          localObject1 = new HashMap(6);
          localObject2 = paramC.getWindowAndroid().getSafeAreaInsets();
          if (localObject2 != null)
          {
            i = com.tencent.mm.plugin.appbrand.ac.g.Dg(((Rect)localObject2).left);
            j = com.tencent.mm.plugin.appbrand.ac.g.Dg(((Rect)localObject2).top);
            m = com.tencent.mm.plugin.appbrand.ac.g.Dg(Math.min(((Rect)localObject2).right, m));
            k = com.tencent.mm.plugin.appbrand.ac.g.Dg(Math.min(((Rect)localObject2).bottom, k));
            ((Map)localObject1).put("left", Integer.valueOf(i));
            ((Map)localObject1).put("top", Integer.valueOf(j));
            ((Map)localObject1).put("right", Integer.valueOf(m));
            ((Map)localObject1).put("bottom", Integer.valueOf(k));
            ((Map)localObject1).put("width", Integer.valueOf(m - i));
            ((Map)localObject1).put("height", Integer.valueOf(k - j));
            localMap.put("safeArea", localObject1);
          }
          a(paramC, localMap);
          AppMethodBeat.o(147302);
          return localMap;
          label901:
          i = 0;
          break;
          if (1 != i) {
            break label418;
          }
          localMap.put("deviceOrientation", "portrait");
          break label418;
          label927:
          f = ((c)localObject1).bUx();
          break label436;
          label938:
          ((Map)localObject1).put("wifiEnabled", Boolean.FALSE);
          break label514;
          label954:
          ((Map)localObject1).put("locationEnabled", Boolean.FALSE);
          continue;
        }
        catch (Exception localException)
        {
          Log.e("Luggage.FULL.JsApiGetSystemInfoLU", "check permissions exception", new Object[] { localException });
          ((Map)localObject1).put("locationAuthorized", Boolean.FALSE);
          ((Map)localObject1).put("cameraAuthorized", Boolean.FALSE);
          ((Map)localObject1).put("microphoneAuthorized", Boolean.FALSE);
          continue;
        }
        label1035:
        ((Map)localObject1).put("wifiEnabled", Boolean.FALSE);
        ((Map)localObject1).put("notificationAuthorized", Boolean.FALSE);
        ((Map)localObject1).put("locationEnabled", Boolean.FALSE);
        ((Map)localObject1).put("locationAuthorized", Boolean.FALSE);
        ((Map)localObject1).put("cameraAuthorized", Boolean.FALSE);
        ((Map)localObject1).put("microphoneAuthorized", Boolean.FALSE);
        continue;
        label1121:
        ((Map)localObject1).put("bluetoothEnabled", Boolean.FALSE);
      }
    }
  }
  
  protected void a(C paramC, Map<String, Object> paramMap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.l
 * JD-Core Version:    0.7.0.1
 */