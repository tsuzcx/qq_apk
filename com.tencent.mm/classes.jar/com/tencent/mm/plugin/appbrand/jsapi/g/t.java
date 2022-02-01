package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.location.LocationManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class t
  extends com.tencent.luggage.f.a.a
{
  private static volatile Boolean kSv;
  
  static
  {
    AppMethodBeat.i(46387);
    try
    {
      ae.i("MicroMsg.TencentLocationManagerWxImp", "printBluetoothEnable open:%b", new Object[] { Boolean.valueOf(BluetoothAdapter.getDefaultAdapter().isEnabled()) });
      try
      {
        LocationManager localLocationManager = (LocationManager)ak.getContext().getSystemService("location");
        if (localLocationManager == null) {
          break label135;
        }
        boolean bool1 = localLocationManager.isProviderEnabled("gps");
        boolean bool2 = localLocationManager.isProviderEnabled("network");
        ae.i("MicroMsg.TencentLocationManagerWxImp", "isGPSEnable " + bool1 + ", isNetworkEnable:" + bool2);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.TencentLocationManagerWxImp", localException2, "", new Object[0]);
        }
      }
      ae.i("MicroMsg.TencentLocationManagerWxImp", "Imei:%s", new Object[] { q.cH(true) });
      AppMethodBeat.o(46387);
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.TencentLocationManagerWxImp", localException1, "", new Object[0]);
        ae.i("MicroMsg.TencentLocationManagerWxImp", "printBluetoothEnable fail");
        continue;
        label135:
        ae.e("MicroMsg.TencentLocationManagerWxImp", "locationManager is null");
      }
    }
  }
  
  public final boolean Fu()
  {
    AppMethodBeat.i(46386);
    if (kSv != null) {
      kSv.booleanValue();
    }
    Object localObject;
    for (;;)
    {
      bool = kSv.booleanValue();
      AppMethodBeat.o(46386);
      return bool;
      localObject = a.a.gAX;
      localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.xi("100459");
      if (localObject != null) {
        break;
      }
      ae.i("MicroMsg.TencentLocationManagerWxImp", "[sLocationLogOpen] item is null");
      kSv = Boolean.FALSE;
    }
    if ((((c)localObject).isValid()) && ("true".equals(((c)localObject).fsy().get("isLocationLogOpen")))) {}
    for (boolean bool = true;; bool = false)
    {
      kSv = Boolean.valueOf(bool);
      ae.i("MicroMsg.TencentLocationManagerWxImp", "sLocationLogOpen:%b", new Object[] { kSv });
      kSv.booleanValue();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.t
 * JD-Core Version:    0.7.0.1
 */