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
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
{
  public Context context;
  public final String crG;
  public AtomicBoolean dfX;
  public BroadcastReceiver kGi;
  public e kJk;
  public AtomicBoolean kJl;
  public List<d> kJm;
  Runnable kJn;
  i kJo;
  public Map<String, d> kge;
  final Handler mHandler;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(144601);
    this.crG = ("MicroMsg.Ble.BleScanWorker#" + hashCode());
    this.kJl = new AtomicBoolean(false);
    this.dfX = new AtomicBoolean(false);
    this.mHandler = new Handler();
    this.kJn = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144597);
        if (!a.this.kJl.get())
        {
          AppMethodBeat.o(144597);
          return;
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(a.this.kJm);
        a.this.kJm.clear();
        if ((a.this.kJo != null) && (localArrayList.size() > 0)) {
          a.this.kJo.bp(localArrayList);
        }
        a.this.mHandler.postDelayed(a.this.kJn, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kHB.gxu);
        AppMethodBeat.o(144597);
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(144601);
  }
  
  private static ScanSettingsCompat Qe(String paramString)
  {
    AppMethodBeat.i(175632);
    for (;;)
    {
      if (paramString.equals("low"))
      {
        paramString = new ScanSettingsCompat.a().sX(0).bkc();
        AppMethodBeat.o(175632);
        return paramString;
      }
      if (paramString.equals("medium"))
      {
        paramString = new ScanSettingsCompat.a().sX(1).bkc();
        AppMethodBeat.o(175632);
        return paramString;
      }
      if (paramString.equals("high"))
      {
        paramString = new ScanSettingsCompat.a().sX(2).bkc();
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
        if (!this.dfX.get())
        {
          paramb.a(j.kIZ);
          AppMethodBeat.o(144602);
          return;
        }
        if (this.kJl.get())
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.crG, "already scan", new Object[0]);
          paramb.a(j.kIP);
          AppMethodBeat.o(144602);
          continue;
        }
        localBluetoothAdapter = c.bkg();
      }
      finally {}
      if ((localBluetoothAdapter != null) && (c.bki())) {
        break;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.crG, "BluetoothAdapter is null, err", new Object[0]);
      paramb.a(j.kIS);
      AppMethodBeat.o(144602);
    }
    label152:
    boolean bool1;
    Object localObject;
    boolean bool2;
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (c.Qf("android.permission.ACCESS_COARSE_LOCATION")) {
        break label449;
      }
      if (!c.Qf("android.permission.ACCESS_FINE_LOCATION")) {
        break label471;
      }
      break label449;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.crG, "checkLocationPermission :%b", new Object[] { Boolean.valueOf(bool1) });
      localObject = (LocationManager)ak.getContext().getSystemService("location");
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
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.crG, "checkGpsEnable:%b", new Object[] { Boolean.valueOf(bool1) });
      this.kJl.set(true);
      localObject = paramList;
      if (paramList != null)
      {
        localObject = paramList;
        if (paramList.size() == 0)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.crG, "scanFilterCompats size:%d", new Object[] { Integer.valueOf(paramList.size()) });
          localObject = null;
        }
      }
      bool1 = b.a(localBluetoothAdapter, (List)localObject, Qe(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kHB.kHL), this.kJk);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.crG, "startBleScan isOk:%b", new Object[] { Boolean.valueOf(bool1) });
      if (bool1)
      {
        this.kJo = parami;
        if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kHB.gxu > 0) {
          this.mHandler.postDelayed(this.kJn, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.kHB.gxu);
        }
        paramb.a(j.kIP);
        AppMethodBeat.o(144602);
        break;
      }
      paramb.a(j.kIZ);
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
  
  public final j bka()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(144603);
        j localj;
        if (!this.dfX.get())
        {
          localj = j.kIR;
          AppMethodBeat.o(144603);
          return localj;
        }
        if (!this.kJl.get())
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.crG, "not scan", new Object[0]);
          localj = j.kIP;
          AppMethodBeat.o(144603);
          continue;
        }
        localObject2 = c.bkg();
      }
      finally {}
      Object localObject2;
      if ((localObject2 == null) || (!c.bki()))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.crG, "BluetoothAdapter is null, err", new Object[0]);
        localObject2 = j.kIS;
        AppMethodBeat.o(144603);
      }
      else
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.crG, "stopBleScan, stopScan", new Object[0]);
        this.kJl.set(false);
        b.a((BluetoothAdapter)localObject2, this.kJk);
        localObject2 = j.kIP;
        AppMethodBeat.o(144603);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a
 * JD-Core Version:    0.7.0.1
 */