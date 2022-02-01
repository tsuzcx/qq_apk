package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.location.LocationManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class s
  extends com.tencent.luggage.f.a.a
{
  private static volatile Boolean ktr;
  
  static
  {
    AppMethodBeat.i(46387);
    try
    {
      ac.i("MicroMsg.TencentLocationManagerWxImp", "printBluetoothEnable open:%b", new Object[] { Boolean.valueOf(BluetoothAdapter.getDefaultAdapter().isEnabled()) });
      try
      {
        LocationManager localLocationManager = (LocationManager)ai.getContext().getSystemService("location");
        if (localLocationManager == null) {
          break label135;
        }
        boolean bool1 = localLocationManager.isProviderEnabled("gps");
        boolean bool2 = localLocationManager.isProviderEnabled("network");
        ac.i("MicroMsg.TencentLocationManagerWxImp", "isGPSEnable " + bool1 + ", isNetworkEnable:" + bool2);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.TencentLocationManagerWxImp", localException2, "", new Object[0]);
        }
      }
      ac.i("MicroMsg.TencentLocationManagerWxImp", "Imei:%s", new Object[] { q.cF(true) });
      AppMethodBeat.o(46387);
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.TencentLocationManagerWxImp", localException1, "", new Object[0]);
        ac.i("MicroMsg.TencentLocationManagerWxImp", "printBluetoothEnable fail");
        continue;
        label135:
        ac.e("MicroMsg.TencentLocationManagerWxImp", "locationManager is null");
      }
    }
  }
  
  public final boolean DQ()
  {
    AppMethodBeat.i(46386);
    if (ktr != null) {
      ktr.booleanValue();
    }
    Object localObject;
    for (;;)
    {
      bool = ktr.booleanValue();
      AppMethodBeat.o(46386);
      return bool;
      localObject = a.a.geG;
      localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.tJ("100459");
      if (localObject != null) {
        break;
      }
      ac.i("MicroMsg.TencentLocationManagerWxImp", "[sLocationLogOpen] item is null");
      ktr = Boolean.FALSE;
    }
    if ((((c)localObject).isValid()) && ("true".equals(((c)localObject).eYV().get("isLocationLogOpen")))) {}
    for (boolean bool = true;; bool = false)
    {
      ktr = Boolean.valueOf(bool);
      ac.i("MicroMsg.TencentLocationManagerWxImp", "sLocationLogOpen:%b", new Object[] { ktr });
      ktr.booleanValue();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.s
 * JD-Core Version:    0.7.0.1
 */