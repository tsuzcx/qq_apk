package com.tencent.mm.plugin.appbrand.jsapi.x;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.support.v4.app.v;
import android.view.View;
import com.tencent.luggage.h.h;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.co;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.c.c;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.k;
import java.util.HashMap;
import java.util.Map;

public class j<C extends com.tencent.mm.plugin.appbrand.d>
  extends i<C>
{
  public static final int CTRL_INDEX = 40;
  public static final String NAME = "getSystemInfo";
  
  protected Map<String, Object> a(C paramC)
  {
    AppMethodBeat.i(147302);
    Map localMap = super.a(paramC);
    Object localObject1 = ai.n(paramC);
    localMap.put("windowWidth", Integer.valueOf(g.vM(localObject1[0])));
    localMap.put("windowHeight", Integer.valueOf(g.vM(localObject1[1])));
    localObject1 = ai.f(paramC);
    int m = localObject1[0];
    int k = localObject1[1];
    localMap.put("screenWidth", Integer.valueOf(g.vM(m)));
    localMap.put("screenHeight", Integer.valueOf(g.vM(k)));
    localMap.put("pixelRatio", Float.valueOf(g.bCg()));
    localObject1 = co.i(paramC);
    int j;
    if ((localObject1 != null) && (((z)localObject1).bvj() != null))
    {
      j = ((z)localObject1).bvj().getDrawnStatusBarHeight();
      i = j;
      if (j != 0) {}
    }
    else
    {
      localObject1 = paramC.getWindowAndroid().getStatusBar();
      ae.e("Luggage.FULL.JsApiGetSystemInfoLU", "getIntersectStatusBarHeight with component(%s %s), use windowStatusBar[%s]", new Object[] { paramC.getAppId(), paramC.getClass().getName(), localObject1 });
      if (localObject1 == null) {
        break label888;
      }
      i = ((c.c)localObject1).height;
    }
    localMap.put("statusBarHeight", Integer.valueOf(g.vM(i)));
    localMap.put("language", ad.iR(paramC.getContext()));
    localMap.put("version", k.aD(null, com.tencent.mm.sdk.platformtools.j.IwD));
    if ((paramC.getRuntime() != null) && (paramC.getRuntime().Fm() != null)) {
      localMap.put("benchmarkLevel", Integer.valueOf(((AppBrandSysConfigLU)paramC.getRuntime().Fm()).cnd));
    }
    localObject1 = new int[2];
    Object localObject2;
    if ((paramC instanceof com.tencent.mm.plugin.appbrand.d))
    {
      localObject2 = ai.m((com.tencent.mm.plugin.appbrand.d)paramC);
      if (localObject2 != null) {
        ((View)localObject2).getLocationOnScreen((int[])localObject1);
      }
    }
    for (int i = localObject1[1];; i = 0)
    {
      ae.v("Luggage.WXA.UIUtil", "getScreenTop: [%d]", new Object[] { Integer.valueOf(i) });
      localMap.put("screenTop", Integer.valueOf(g.vM(i)));
      i = paramC.getContext().getResources().getConfiguration().orientation;
      label418:
      float f;
      if (2 == i)
      {
        localMap.put("deviceOrientation", "landscape");
        localObject1 = (b)paramC.K(b.class);
        if (localObject1 != null) {
          break label914;
        }
        f = 1.0F;
        label436:
        localMap.put("fontSizeSetting", Integer.valueOf(Math.round(f * 16.0F)));
        localObject1 = new HashMap();
        localObject2 = paramC.getContext();
        if (localObject2 == null) {
          break label1022;
        }
        Object localObject3 = (WifiManager)((Context)localObject2).getApplicationContext().getSystemService("wifi");
        if (localObject3 == null) {
          break label925;
        }
        ((Map)localObject1).put("wifiEnabled", Boolean.valueOf(((WifiManager)localObject3).isWifiEnabled()));
        label514:
        ((Map)localObject1).put("notificationAuthorized", Boolean.valueOf(v.O((Context)localObject2).areNotificationsEnabled()));
        localObject3 = (LocationManager)((Context)localObject2).getSystemService("location");
        if (localObject3 == null) {
          break label941;
        }
        ((Map)localObject1).put("locationEnabled", Boolean.valueOf(((LocationManager)localObject3).isProviderEnabled("gps")));
      }
      for (;;)
      {
        try
        {
          ((Map)localObject1).put("locationAuthorized", Boolean.valueOf(h.n((Context)localObject2, "android.permission.ACCESS_FINE_LOCATION")));
          ((Map)localObject1).put("cameraAuthorized", Boolean.valueOf(h.n((Context)localObject2, "android.permission.CAMERA")));
          ((Map)localObject1).put("microphoneAuthorized", Boolean.valueOf(h.n((Context)localObject2, "android.permission.RECORD_AUDIO")));
          localObject2 = BluetoothAdapter.getDefaultAdapter();
          if (localObject2 == null) {
            break label1108;
          }
          ((Map)localObject1).put("bluetoothEnabled", Boolean.valueOf(((BluetoothAdapter)localObject2).isEnabled()));
          ae.i("Luggage.FULL.JsApiGetSystemInfoLU", "check permissions:%s", new Object[] { localObject1 });
          localMap.putAll((Map)localObject1);
          localObject1 = new HashMap(6);
          paramC = paramC.getWindowAndroid().getSafeAreaInsets();
          if (paramC != null)
          {
            i = g.vM(paramC.left);
            j = g.vM(paramC.top);
            m = g.vM(Math.min(paramC.right, m));
            k = g.vM(Math.min(paramC.bottom, k));
            ((Map)localObject1).put("left", Integer.valueOf(i));
            ((Map)localObject1).put("top", Integer.valueOf(j));
            ((Map)localObject1).put("right", Integer.valueOf(m));
            ((Map)localObject1).put("bottom", Integer.valueOf(k));
            ((Map)localObject1).put("width", Integer.valueOf(m - i));
            ((Map)localObject1).put("height", Integer.valueOf(k - j));
            localMap.put("safeArea", localObject1);
          }
          AppMethodBeat.o(147302);
          return localMap;
          label888:
          i = 0;
          break;
          if (1 != i) {
            break label418;
          }
          localMap.put("deviceOrientation", "portrait");
          break label418;
          label914:
          f = ((b)localObject1).bnk();
          break label436;
          label925:
          ((Map)localObject1).put("wifiEnabled", Boolean.FALSE);
          break label514;
          label941:
          ((Map)localObject1).put("locationEnabled", Boolean.FALSE);
          continue;
        }
        catch (Exception localException)
        {
          ae.e("Luggage.FULL.JsApiGetSystemInfoLU", "check permissions exception", new Object[] { localException });
          ((Map)localObject1).put("locationAuthorized", Boolean.FALSE);
          ((Map)localObject1).put("cameraAuthorized", Boolean.FALSE);
          ((Map)localObject1).put("microphoneAuthorized", Boolean.FALSE);
          continue;
        }
        label1022:
        ((Map)localObject1).put("wifiEnabled", Boolean.FALSE);
        ((Map)localObject1).put("notificationAuthorized", Boolean.FALSE);
        ((Map)localObject1).put("locationEnabled", Boolean.FALSE);
        ((Map)localObject1).put("locationAuthorized", Boolean.FALSE);
        ((Map)localObject1).put("cameraAuthorized", Boolean.FALSE);
        ((Map)localObject1).put("microphoneAuthorized", Boolean.FALSE);
        continue;
        label1108:
        ((Map)localObject1).put("bluetoothEnabled", Boolean.FALSE);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.j
 * JD-Core Version:    0.7.0.1
 */