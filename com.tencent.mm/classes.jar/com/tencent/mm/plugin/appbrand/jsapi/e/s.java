package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.location.LocationManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class s
  extends com.tencent.luggage.f.a.a
{
  private static volatile Boolean jSF;
  
  static
  {
    AppMethodBeat.i(46387);
    try
    {
      ad.i("MicroMsg.TencentLocationManagerWxImp", "printBluetoothEnable open:%b", new Object[] { Boolean.valueOf(BluetoothAdapter.getDefaultAdapter().isEnabled()) });
      try
      {
        LocationManager localLocationManager = (LocationManager)aj.getContext().getSystemService("location");
        if (localLocationManager == null) {
          break label135;
        }
        boolean bool1 = localLocationManager.isProviderEnabled("gps");
        boolean bool2 = localLocationManager.isProviderEnabled("network");
        ad.i("MicroMsg.TencentLocationManagerWxImp", "isGPSEnable " + bool1 + ", isNetworkEnable:" + bool2);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.TencentLocationManagerWxImp", localException2, "", new Object[0]);
        }
      }
      ad.i("MicroMsg.TencentLocationManagerWxImp", "Imei:%s", new Object[] { q.cG(true) });
      AppMethodBeat.o(46387);
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.TencentLocationManagerWxImp", localException1, "", new Object[0]);
        ad.i("MicroMsg.TencentLocationManagerWxImp", "printBluetoothEnable fail");
        continue;
        label135:
        ad.e("MicroMsg.TencentLocationManagerWxImp", "locationManager is null");
      }
    }
  }
  
  public final boolean En()
  {
    AppMethodBeat.i(46386);
    if (jSF != null) {
      jSF.booleanValue();
    }
    Object localObject;
    for (;;)
    {
      bool = jSF.booleanValue();
      AppMethodBeat.o(46386);
      return bool;
      localObject = a.a.gaa;
      localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.qu("100459");
      if (localObject != null) {
        break;
      }
      ad.i("MicroMsg.TencentLocationManagerWxImp", "[sLocationLogOpen] item is null");
      jSF = Boolean.FALSE;
    }
    if ((((c)localObject).isValid()) && ("true".equals(((c)localObject).eJy().get("isLocationLogOpen")))) {}
    for (boolean bool = true;; bool = false)
    {
      jSF = Boolean.valueOf(bool);
      ad.i("MicroMsg.TencentLocationManagerWxImp", "sLocationLogOpen:%b", new Object[] { jSF });
      jSF.booleanValue();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.s
 * JD-Core Version:    0.7.0.1
 */