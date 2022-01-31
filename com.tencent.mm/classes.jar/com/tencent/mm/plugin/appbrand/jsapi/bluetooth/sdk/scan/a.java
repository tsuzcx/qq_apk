package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.i;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
{
  public AtomicBoolean chl;
  public Context context;
  public BroadcastReceiver hFt;
  public e hHg;
  public ScanSettingsCompat hHh;
  public Map<String, d> hHi;
  public AtomicBoolean hHj;
  public List<d> hHk;
  Runnable hHl;
  i hHm;
  final Handler mHandler;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(94289);
    this.hHj = new AtomicBoolean(false);
    this.chl = new AtomicBoolean(false);
    this.mHandler = new Handler();
    this.hHl = new a.1(this);
    this.context = paramContext;
    AppMethodBeat.o(94289);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b paramb, List<ScanFilterCompat> paramList, i parami)
  {
    BluetoothAdapter localBluetoothAdapter;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(94290);
        if (!this.chl.get())
        {
          paramb.a(j.hGX);
          AppMethodBeat.o(94290);
          return;
        }
        if (this.hHj.get())
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleScanWorker", "already scan", new Object[0]);
          paramb.a(j.hGN);
          AppMethodBeat.o(94290);
          continue;
        }
        localBluetoothAdapter = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCv();
      }
      finally {}
      if ((localBluetoothAdapter != null) && (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCw())) {
        break;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleScanWorker", "BluetoothAdapter is null, err", new Object[0]);
      paramb.a(j.hGQ);
      AppMethodBeat.o(94290);
    }
    label148:
    boolean bool1;
    Object localObject;
    boolean bool2;
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.BX("android.permission.ACCESS_COARSE_LOCATION")) {
        break label431;
      }
      if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.BX("android.permission.ACCESS_FINE_LOCATION")) {
        break label453;
      }
      break label431;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleScanWorker", "checkLocationPermission :%b", new Object[] { Boolean.valueOf(bool1) });
      localObject = (LocationManager)ah.getContext().getSystemService("location");
      if (localObject == null) {
        break label422;
      }
      bool2 = ((LocationManager)localObject).isProviderEnabled("gps");
      bool1 = ((LocationManager)localObject).isProviderEnabled("network");
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleHelper", "isGPSEnable " + bool2 + ", isNetworkEnable:" + bool1, new Object[0]);
      break label437;
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleScanWorker", "checkGpsEnable:%b", new Object[] { Boolean.valueOf(bool1) });
      this.hHj.set(true);
      localObject = paramList;
      if (paramList != null)
      {
        localObject = paramList;
        if (paramList.size() == 0)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleScanWorker", "scanFilterCompats size:%d", new Object[] { Integer.valueOf(paramList.size()) });
          localObject = null;
        }
      }
      bool1 = b.a(localBluetoothAdapter, (List)localObject, this.hHh, this.hHg);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleScanWorker", "startBleScan isOk:%b", new Object[] { Boolean.valueOf(bool1) });
      if (bool1)
      {
        this.hHm = parami;
        if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.hFM.eAS > 0) {
          this.mHandler.postDelayed(this.hHl, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.hFM.eAS);
        }
        paramb.a(j.hGN);
        AppMethodBeat.o(94290);
        break;
      }
      paramb.a(j.hGX);
      AppMethodBeat.o(94290);
      break;
      label422:
      bool1 = false;
      bool2 = false;
      break label437;
      label431:
      bool1 = true;
      break label148;
      label437:
      if ((bool2) && (bool1))
      {
        bool1 = true;
        continue;
        label453:
        bool1 = false;
        break label148;
      }
      bool1 = false;
    }
  }
  
  public final j aCr()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(94291);
        j localj;
        if (!this.chl.get())
        {
          localj = j.hGP;
          AppMethodBeat.o(94291);
          return localj;
        }
        if (!this.hHj.get())
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleScanWorker", "not scan", new Object[0]);
          localj = j.hGN;
          AppMethodBeat.o(94291);
          continue;
        }
        localObject2 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCv();
      }
      finally {}
      Object localObject2;
      if ((localObject2 == null) || (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCw()))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleScanWorker", "BluetoothAdapter is null, err", new Object[0]);
        localObject2 = j.hGQ;
        AppMethodBeat.o(94291);
      }
      else
      {
        this.hHj.set(false);
        b.a((BluetoothAdapter)localObject2, this.hHg);
        localObject2 = j.hGN;
        AppMethodBeat.o(94291);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a
 * JD-Core Version:    0.7.0.1
 */