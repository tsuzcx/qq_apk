package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.i;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
{
  public Context context;
  public final String crd;
  public AtomicBoolean deV;
  public BroadcastReceiver kCT;
  public e kFV;
  public AtomicBoolean kFW;
  public List<d> kFX;
  Runnable kFY;
  i kFZ;
  public Map<String, d> kcN;
  final Handler mHandler;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(144601);
    this.crd = ("MicroMsg.Ble.BleScanWorker#" + hashCode());
    this.kFW = new AtomicBoolean(false);
    this.deV = new AtomicBoolean(false);
    this.mHandler = new Handler();
    this.kFY = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144597);
        if (!a.this.kFW.get())
        {
          AppMethodBeat.o(144597);
          return;
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(a.this.kFX);
        a.this.kFX.clear();
        if ((a.this.kFZ != null) && (localArrayList.size() > 0)) {
          a.this.kFZ.bn(localArrayList);
        }
        a.this.mHandler.postDelayed(a.this.kFY, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kEm.guN);
        AppMethodBeat.o(144597);
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(144601);
  }
  
  private static ScanSettingsCompat Pw(String paramString)
  {
    AppMethodBeat.i(175632);
    for (;;)
    {
      if (paramString.equals("low"))
      {
        paramString = new ScanSettingsCompat.a().sU(0).bjt();
        AppMethodBeat.o(175632);
        return paramString;
      }
      if (paramString.equals("medium"))
      {
        paramString = new ScanSettingsCompat.a().sU(1).bjt();
        AppMethodBeat.o(175632);
        return paramString;
      }
      if (paramString.equals("high"))
      {
        paramString = new ScanSettingsCompat.a().sU(2).bjt();
        AppMethodBeat.o(175632);
        return paramString;
      }
      paramString = "medium";
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b paramb, List<ScanFilterCompat> paramList, i parami)
  {
    BluetoothAdapter localBluetoothAdapter;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(144602);
        if (!this.deV.get())
        {
          paramb.a(j.kFK);
          AppMethodBeat.o(144602);
          return;
        }
        if (this.kFW.get())
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.crd, "already scan", new Object[0]);
          paramb.a(j.kFA);
          AppMethodBeat.o(144602);
          continue;
        }
        localBluetoothAdapter = c.bjx();
      }
      finally {}
      if ((localBluetoothAdapter != null) && (c.bjz())) {
        break;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.crd, "BluetoothAdapter is null, err", new Object[0]);
      paramb.a(j.kFD);
      AppMethodBeat.o(144602);
    }
    label152:
    boolean bool1;
    Object localObject;
    boolean bool2;
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (c.Px("android.permission.ACCESS_COARSE_LOCATION")) {
        break label449;
      }
      if (!c.Px("android.permission.ACCESS_FINE_LOCATION")) {
        break label471;
      }
      break label449;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.crd, "checkLocationPermission :%b", new Object[] { Boolean.valueOf(bool1) });
      localObject = (LocationManager)aj.getContext().getSystemService("location");
      if (localObject == null) {
        break label440;
      }
      bool2 = ((LocationManager)localObject).isProviderEnabled("gps");
      bool1 = ((LocationManager)localObject).isProviderEnabled("network");
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleHelper", "isGPSEnable " + bool2 + ", isNetworkEnable:" + bool1, new Object[0]);
      break label455;
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.crd, "checkGpsEnable:%b", new Object[] { Boolean.valueOf(bool1) });
      this.kFW.set(true);
      localObject = paramList;
      if (paramList != null)
      {
        localObject = paramList;
        if (paramList.size() == 0)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.crd, "scanFilterCompats size:%d", new Object[] { Integer.valueOf(paramList.size()) });
          localObject = null;
        }
      }
      bool1 = b.a(localBluetoothAdapter, (List)localObject, Pw(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kEm.kEw), this.kFV);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.crd, "startBleScan isOk:%b", new Object[] { Boolean.valueOf(bool1) });
      if (bool1)
      {
        this.kFZ = parami;
        if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kEm.guN > 0) {
          this.mHandler.postDelayed(this.kFY, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kEm.guN);
        }
        paramb.a(j.kFA);
        AppMethodBeat.o(144602);
        break;
      }
      paramb.a(j.kFK);
      AppMethodBeat.o(144602);
      break;
      label440:
      bool1 = false;
      bool2 = false;
      break label455;
      label449:
      bool1 = true;
      break label152;
      label455:
      if ((bool2) && (bool1))
      {
        bool1 = true;
        continue;
        label471:
        bool1 = false;
        break label152;
      }
      bool1 = false;
    }
  }
  
  public final j bjr()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(144603);
        j localj;
        if (!this.deV.get())
        {
          localj = j.kFC;
          AppMethodBeat.o(144603);
          return localj;
        }
        if (!this.kFW.get())
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.crd, "not scan", new Object[0]);
          localj = j.kFA;
          AppMethodBeat.o(144603);
          continue;
        }
        localObject2 = c.bjx();
      }
      finally {}
      Object localObject2;
      if ((localObject2 == null) || (!c.bjz()))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.crd, "BluetoothAdapter is null, err", new Object[0]);
        localObject2 = j.kFD;
        AppMethodBeat.o(144603);
      }
      else
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.crd, "stopBleScan, stopScan", new Object[0]);
        this.kFW.set(false);
        b.a((BluetoothAdapter)localObject2, this.kFV);
        localObject2 = j.kFA;
        AppMethodBeat.o(144603);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a
 * JD-Core Version:    0.7.0.1
 */