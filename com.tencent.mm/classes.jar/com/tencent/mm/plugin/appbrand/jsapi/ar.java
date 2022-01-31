package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.statusbar.a;
import java.util.HashMap;
import java.util.Map;

public class ar<C extends c>
  extends com.tencent.mm.plugin.appbrand.jsapi.r.g<C>
{
  public static final int CTRL_INDEX = 40;
  public static final String NAME = "getSystemInfo";
  float hxY = -1.0F;
  
  protected Map<String, Object> a(C paramC)
  {
    AppMethodBeat.i(140831);
    Map localMap = super.a(paramC);
    Object localObject1 = com.tencent.mm.plugin.appbrand.t.v.n(paramC);
    localMap.put("windowWidth", Integer.valueOf(com.tencent.mm.plugin.appbrand.s.g.pM(localObject1[0])));
    localMap.put("windowHeight", Integer.valueOf(com.tencent.mm.plugin.appbrand.s.g.pM(localObject1[1])));
    localObject1 = com.tencent.mm.plugin.appbrand.t.v.d(paramC);
    int i = localObject1[0];
    int j = localObject1[1];
    localMap.put("screenWidth", Integer.valueOf(com.tencent.mm.plugin.appbrand.s.g.pM(i)));
    localMap.put("screenHeight", Integer.valueOf(com.tencent.mm.plugin.appbrand.s.g.pM(j)));
    localMap.put("statusBarHeight", Integer.valueOf(com.tencent.mm.plugin.appbrand.s.g.pM(a.aG(paramC.X(Activity.class)))));
    localMap.put("language", aa.gP(paramC.getContext()));
    localMap.put("version", com.tencent.mm.sdk.platformtools.g.au(null, f.ymG));
    localMap.put("benchmarkLevel", Integer.valueOf(paramC.wj().wR().bDF));
    int k = paramC.getContext().getResources().getConfiguration().orientation;
    label254:
    Object localObject2;
    if (2 == k)
    {
      localMap.put("deviceOrientation", "landscape");
      if (this.hxY == -1.0F) {
        break label540;
      }
      localMap.put("fontSizeSetting", Integer.valueOf((int)(this.hxY * 16.0F)));
      localObject1 = new HashMap();
      localObject2 = paramC.getContext();
      if (localObject2 == null) {
        break label678;
      }
      Object localObject3 = (WifiManager)((Context)localObject2).getApplicationContext().getSystemService("wifi");
      if (localObject3 == null) {
        break label585;
      }
      ((Map)localObject1).put("wifiEnabled", Boolean.valueOf(((WifiManager)localObject3).isWifiEnabled()));
      label312:
      ((Map)localObject1).put("notificationAuthorized", Boolean.valueOf(android.support.v4.app.v.K((Context)localObject2).areNotificationsEnabled()));
      localObject3 = (LocationManager)((Context)localObject2).getSystemService("location");
      if (localObject3 == null) {
        break label601;
      }
      ((Map)localObject1).put("locationEnabled", Boolean.valueOf(((LocationManager)localObject3).isProviderEnabled("gps")));
    }
    for (;;)
    {
      try
      {
        ((Map)localObject1).put("locationAuthorized", Boolean.valueOf(com.tencent.luggage.g.g.o((Context)localObject2, "android.permission.ACCESS_FINE_LOCATION")));
        ((Map)localObject1).put("cameraAuthorized", Boolean.valueOf(com.tencent.luggage.g.g.o((Context)localObject2, "android.permission.CAMERA")));
        ((Map)localObject1).put("microphoneAuthorized", Boolean.valueOf(com.tencent.luggage.g.g.o((Context)localObject2, "android.permission.RECORD_AUDIO")));
        localObject2 = BluetoothAdapter.getDefaultAdapter();
        if (localObject2 == null) {
          break label759;
        }
        ((Map)localObject1).put("bluetoothEnabled", Boolean.valueOf(((BluetoothAdapter)localObject2).isEnabled()));
        ab.i("MicroMsg.JsApiGetSystemInfo", "check permissions:%s", new Object[] { localObject1 });
        localMap.putAll((Map)localObject1);
        localObject1 = new HashMap(6);
        if (paramC.X(Activity.class) != null) {
          break label775;
        }
        ab.w("MicroMsg.JsApiGetSystemInfo", "hy: can not retrieve UI!");
        AppMethodBeat.o(140831);
        return localMap;
        if (1 != k) {
          break;
        }
        localMap.put("deviceOrientation", "portrait");
        break;
        label540:
        j(paramC);
        localMap.put("fontSizeSetting", Integer.valueOf((int)(this.hxY * 16.0F)));
        e.a(paramC.getAppId(), new ar.1(this, paramC));
        break label254;
        label585:
        ((Map)localObject1).put("wifiEnabled", Boolean.FALSE);
        break label312;
        label601:
        ((Map)localObject1).put("locationEnabled", Boolean.FALSE);
        continue;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.JsApiGetSystemInfo", "check permissions exception", new Object[] { localException });
        ((Map)localObject1).put("locationAuthorized", Boolean.FALSE);
        ((Map)localObject1).put("cameraAuthorized", Boolean.FALSE);
        ((Map)localObject1).put("microphoneAuthorized", Boolean.FALSE);
        continue;
      }
      label678:
      ((Map)localObject1).put("wifiEnabled", Boolean.FALSE);
      ((Map)localObject1).put("notificationAuthorized", Boolean.FALSE);
      ((Map)localObject1).put("locationEnabled", Boolean.FALSE);
      ((Map)localObject1).put("locationAuthorized", Boolean.FALSE);
      ((Map)localObject1).put("cameraAuthorized", Boolean.FALSE);
      ((Map)localObject1).put("microphoneAuthorized", Boolean.FALSE);
      continue;
      label759:
      ((Map)localObject1).put("bluetoothEnabled", Boolean.FALSE);
      continue;
      label775:
      paramC = af.d(paramC.X(Activity.class), i, j);
      if (paramC != null)
      {
        i = com.tencent.mm.plugin.appbrand.s.g.pM(paramC.left);
        j = com.tencent.mm.plugin.appbrand.s.g.pM(paramC.top);
        k = com.tencent.mm.plugin.appbrand.s.g.pM(paramC.right);
        int m = com.tencent.mm.plugin.appbrand.s.g.pM(paramC.bottom);
        ((Map)localObject1).put("left", Integer.valueOf(i));
        ((Map)localObject1).put("top", Integer.valueOf(j));
        ((Map)localObject1).put("right", Integer.valueOf(k));
        ((Map)localObject1).put("bottom", Integer.valueOf(m));
        ((Map)localObject1).put("width", Integer.valueOf(k - i));
        ((Map)localObject1).put("height", Integer.valueOf(m - j));
        localMap.put("safeArea", localObject1);
      }
    }
  }
  
  final void j(r paramr)
  {
    AppMethodBeat.i(140832);
    this.hxY = paramr.getContext().getSharedPreferences(ah.dsP(), 4).getFloat("text_size_scale_key", 1.0F);
    AppMethodBeat.o(140832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ar
 * JD-Core Version:    0.7.0.1
 */