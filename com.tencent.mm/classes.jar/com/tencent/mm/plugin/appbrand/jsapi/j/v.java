package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.location.LocationManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class v
  extends com.tencent.luggage.h.a.a
{
  private static volatile Boolean oVo;
  
  static
  {
    AppMethodBeat.i(46387);
    try
    {
      Log.i("MicroMsg.TencentLocationManagerWxImp", "printBluetoothEnable open:%b", new Object[] { Boolean.valueOf(BluetoothAdapter.getDefaultAdapter().isEnabled()) });
      try
      {
        LocationManager localLocationManager = (LocationManager)MMApplicationContext.getContext().getSystemService("location");
        if (localLocationManager == null) {
          break label135;
        }
        boolean bool1 = localLocationManager.isProviderEnabled("gps");
        boolean bool2 = localLocationManager.isProviderEnabled("network");
        Log.i("MicroMsg.TencentLocationManagerWxImp", "isGPSEnable " + bool1 + ", isNetworkEnable:" + bool2);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.TencentLocationManagerWxImp", localException2, "", new Object[0]);
        }
      }
      Log.i("MicroMsg.TencentLocationManagerWxImp", "Imei:%s", new Object[] { q.dR(true) });
      AppMethodBeat.o(46387);
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.TencentLocationManagerWxImp", localException1, "", new Object[0]);
        Log.i("MicroMsg.TencentLocationManagerWxImp", "printBluetoothEnable fail");
        continue;
        label135:
        Log.e("MicroMsg.TencentLocationManagerWxImp", "locationManager is null");
      }
    }
  }
  
  public final boolean SC()
  {
    AppMethodBeat.i(46386);
    if (oVo != null) {
      oVo.booleanValue();
    }
    Object localObject;
    for (;;)
    {
      bool = oVo.booleanValue();
      AppMethodBeat.o(46386);
      return bool;
      localObject = a.a.jZD;
      localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.Mu("100459");
      if (localObject != null) {
        break;
      }
      Log.i("MicroMsg.TencentLocationManagerWxImp", "[sLocationLogOpen] item is null");
      oVo = Boolean.FALSE;
    }
    if ((((c)localObject).isValid()) && ("true".equals(((c)localObject).hvz().get("isLocationLogOpen")))) {}
    for (boolean bool = true;; bool = false)
    {
      oVo = Boolean.valueOf(bool);
      Log.i("MicroMsg.TencentLocationManagerWxImp", "sLocationLogOpen:%b", new Object[] { oVo });
      oVo.booleanValue();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.v
 * JD-Core Version:    0.7.0.1
 */