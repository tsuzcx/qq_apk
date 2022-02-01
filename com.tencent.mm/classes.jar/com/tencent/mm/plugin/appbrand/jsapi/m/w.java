package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.bluetooth.BluetoothAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class w
  extends com.tencent.luggage.i.a.a
{
  private static volatile Boolean saE;
  
  static
  {
    AppMethodBeat.i(46387);
    try
    {
      Log.i("MicroMsg.TencentLocationManagerWxImp", "printBluetoothEnable open:%b", new Object[] { Boolean.valueOf(BluetoothAdapter.getDefaultAdapter().isEnabled()) });
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          boolean bool1 = d.bJm();
          boolean bool2 = d.bJn();
          Log.i("MicroMsg.TencentLocationManagerWxImp", "isGPSEnable " + bool1 + ", isNetworkEnable:" + bool2);
          Log.i("MicroMsg.TencentLocationManagerWxImp", "Imei:%s", new Object[] { q.eD(true) });
          AppMethodBeat.o(46387);
          return;
          localException1 = localException1;
          Log.printErrStackTrace("MicroMsg.TencentLocationManagerWxImp", localException1, "", new Object[0]);
          Log.i("MicroMsg.TencentLocationManagerWxImp", "printBluetoothEnable fail");
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.TencentLocationManagerWxImp", localException2, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean atg()
  {
    AppMethodBeat.i(46386);
    if (saE != null) {
      saE.booleanValue();
    }
    Object localObject;
    for (;;)
    {
      bool = saE.booleanValue();
      AppMethodBeat.o(46386);
      return bool;
      localObject = a.a.mzH;
      localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.Fd("100459");
      if (localObject != null) {
        break;
      }
      Log.i("MicroMsg.TencentLocationManagerWxImp", "[sLocationLogOpen] item is null");
      saE = Boolean.FALSE;
    }
    if ((((c)localObject).isValid()) && ("true".equals(((c)localObject).iWZ().get("isLocationLogOpen")))) {}
    for (boolean bool = true;; bool = false)
    {
      saE = Boolean.valueOf(bool);
      Log.i("MicroMsg.TencentLocationManagerWxImp", "sLocationLogOpen:%b", new Object[] { saE });
      saE.booleanValue();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.w
 * JD-Core Version:    0.7.0.1
 */