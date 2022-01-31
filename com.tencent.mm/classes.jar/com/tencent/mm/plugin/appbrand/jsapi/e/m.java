package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.location.LocationManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class m
  extends com.tencent.luggage.f.a.a
{
  private static volatile Boolean hNp;
  
  static
  {
    AppMethodBeat.i(131114);
    try
    {
      ab.i("MicroMsg.TencentLocationManagerWxImp", "printBluetoothEnable open:%b", new Object[] { Boolean.valueOf(BluetoothAdapter.getDefaultAdapter().isEnabled()) });
      try
      {
        LocationManager localLocationManager = (LocationManager)ah.getContext().getSystemService("location");
        if (localLocationManager == null) {
          break label135;
        }
        boolean bool1 = localLocationManager.isProviderEnabled("gps");
        boolean bool2 = localLocationManager.isProviderEnabled("network");
        ab.i("MicroMsg.TencentLocationManagerWxImp", "isGPSEnable " + bool1 + ", isNetworkEnable:" + bool2);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.TencentLocationManagerWxImp", localException2, "", new Object[0]);
        }
      }
      ab.i("MicroMsg.TencentLocationManagerWxImp", "Imei:%s", new Object[] { q.bP(true) });
      AppMethodBeat.o(131114);
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.TencentLocationManagerWxImp", localException1, "", new Object[0]);
        ab.i("MicroMsg.TencentLocationManagerWxImp", "printBluetoothEnable fail");
        continue;
        label135:
        ab.e("MicroMsg.TencentLocationManagerWxImp", "locationManager is null");
      }
    }
  }
  
  public final boolean xb()
  {
    AppMethodBeat.i(131113);
    if (hNp != null) {
      hNp.booleanValue();
    }
    Object localObject;
    for (;;)
    {
      bool = hNp.booleanValue();
      AppMethodBeat.o(131113);
      return bool;
      localObject = a.b.eEW;
      localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.me("100459");
      if (localObject != null) {
        break;
      }
      ab.i("MicroMsg.TencentLocationManagerWxImp", "[sLocationLogOpen] item is null");
      hNp = Boolean.FALSE;
    }
    if ((((c)localObject).isValid()) && ("true".equals(((c)localObject).dvN().get("isLocationLogOpen")))) {}
    for (boolean bool = true;; bool = false)
    {
      hNp = Boolean.valueOf(bool);
      ab.i("MicroMsg.TencentLocationManagerWxImp", "sLocationLogOpen:%b", new Object[] { hNp });
      hNp.booleanValue();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.m
 * JD-Core Version:    0.7.0.1
 */