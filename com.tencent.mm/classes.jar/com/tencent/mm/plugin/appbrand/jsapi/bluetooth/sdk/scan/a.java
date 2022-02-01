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
import com.tencent.mm.sdk.platformtools.ai;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
{
  public AtomicBoolean cTF;
  public final String cgL;
  public Context context;
  public Map<String, d> jIB;
  public BroadcastReceiver kia;
  public e kkV;
  public AtomicBoolean kkW;
  public List<d> kkX;
  Runnable kkY;
  i kkZ;
  final Handler mHandler;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(144601);
    this.cgL = ("MicroMsg.Ble.BleScanWorker#" + hashCode());
    this.kkW = new AtomicBoolean(false);
    this.cTF = new AtomicBoolean(false);
    this.mHandler = new Handler();
    this.kkY = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144597);
        if (!a.this.kkW.get())
        {
          AppMethodBeat.o(144597);
          return;
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(a.this.kkX);
        a.this.kkX.clear();
        if ((a.this.kkZ != null) && (localArrayList.size() > 0)) {
          a.this.kkZ.bl(localArrayList);
        }
        a.this.mHandler.postDelayed(a.this.kkY, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kjo.gbd);
        AppMethodBeat.o(144597);
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(144601);
  }
  
  private static ScanSettingsCompat Ma(String paramString)
  {
    AppMethodBeat.i(175632);
    for (;;)
    {
      if (paramString.equals("low"))
      {
        paramString = new ScanSettingsCompat.a().ss(0).bfP();
        AppMethodBeat.o(175632);
        return paramString;
      }
      if (paramString.equals("medium"))
      {
        paramString = new ScanSettingsCompat.a().ss(1).bfP();
        AppMethodBeat.o(175632);
        return paramString;
      }
      if (paramString.equals("high"))
      {
        paramString = new ScanSettingsCompat.a().ss(2).bfP();
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
        if (!this.cTF.get())
        {
          paramb.a(j.kkK);
          AppMethodBeat.o(144602);
          return;
        }
        if (this.kkW.get())
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cgL, "already scan", new Object[0]);
          paramb.a(j.kkA);
          AppMethodBeat.o(144602);
          continue;
        }
        localBluetoothAdapter = c.bfT();
      }
      finally {}
      if ((localBluetoothAdapter != null) && (c.bfV())) {
        break;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.cgL, "BluetoothAdapter is null, err", new Object[0]);
      paramb.a(j.kkD);
      AppMethodBeat.o(144602);
    }
    label152:
    boolean bool1;
    Object localObject;
    boolean bool2;
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (c.Mb("android.permission.ACCESS_COARSE_LOCATION")) {
        break label449;
      }
      if (!c.Mb("android.permission.ACCESS_FINE_LOCATION")) {
        break label471;
      }
      break label449;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cgL, "checkLocationPermission :%b", new Object[] { Boolean.valueOf(bool1) });
      localObject = (LocationManager)ai.getContext().getSystemService("location");
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
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cgL, "checkGpsEnable:%b", new Object[] { Boolean.valueOf(bool1) });
      this.kkW.set(true);
      localObject = paramList;
      if (paramList != null)
      {
        localObject = paramList;
        if (paramList.size() == 0)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cgL, "scanFilterCompats size:%d", new Object[] { Integer.valueOf(paramList.size()) });
          localObject = null;
        }
      }
      bool1 = b.a(localBluetoothAdapter, (List)localObject, Ma(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kjo.kjy), this.kkV);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cgL, "startBleScan isOk:%b", new Object[] { Boolean.valueOf(bool1) });
      if (bool1)
      {
        this.kkZ = parami;
        if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kjo.gbd > 0) {
          this.mHandler.postDelayed(this.kkY, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kjo.gbd);
        }
        paramb.a(j.kkA);
        AppMethodBeat.o(144602);
        break;
      }
      paramb.a(j.kkK);
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
  
  public final j bfN()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(144603);
        j localj;
        if (!this.cTF.get())
        {
          localj = j.kkC;
          AppMethodBeat.o(144603);
          return localj;
        }
        if (!this.kkW.get())
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cgL, "not scan", new Object[0]);
          localj = j.kkA;
          AppMethodBeat.o(144603);
          continue;
        }
        localObject2 = c.bfT();
      }
      finally {}
      Object localObject2;
      if ((localObject2 == null) || (!c.bfV()))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.cgL, "BluetoothAdapter is null, err", new Object[0]);
        localObject2 = j.kkD;
        AppMethodBeat.o(144603);
      }
      else
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cgL, "stopBleScan, stopScan", new Object[0]);
        this.kkW.set(false);
        b.a((BluetoothAdapter)localObject2, this.kkV);
        localObject2 = j.kkA;
        AppMethodBeat.o(144603);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a
 * JD-Core Version:    0.7.0.1
 */