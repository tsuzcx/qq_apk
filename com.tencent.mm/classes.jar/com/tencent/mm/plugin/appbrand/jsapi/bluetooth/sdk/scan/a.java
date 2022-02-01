package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.i;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
{
  final String cDW;
  private final Context context;
  final AtomicBoolean dxh;
  private BroadcastReceiver lKJ;
  private e lNP;
  public final AtomicBoolean lNQ;
  List<d> lNR;
  final Runnable lNS;
  volatile i lNT;
  Map<String, d> ljN;
  final Handler mHandler;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(144601);
    this.cDW = ("MicroMsg.Ble.BleScanWorker#" + hashCode());
    this.lNQ = new AtomicBoolean(false);
    this.dxh = new AtomicBoolean(false);
    this.mHandler = new Handler();
    this.lNS = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144597);
        if (!a.this.lNQ.get())
        {
          AppMethodBeat.o(144597);
          return;
        }
        synchronized (a.this)
        {
          ArrayList localArrayList = new ArrayList(a.this.lNR);
          a.this.lNR.clear();
          ??? = a.this.lNT;
          if ((??? != null) && (localArrayList.size() > 0)) {
            ((i)???).bA(localArrayList);
          }
          a.this.mHandler.postDelayed(a.this.lNS, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bFm().gTn);
          AppMethodBeat.o(144597);
          return;
        }
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(144601);
  }
  
  private static ScanSettingsCompat ZF(String paramString)
  {
    AppMethodBeat.i(175632);
    label5:
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramString = "medium";
        break label5;
        if (paramString.equals("low"))
        {
          i = 0;
          continue;
          if (paramString.equals("medium"))
          {
            i = 1;
            continue;
            if (paramString.equals("high")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    paramString = new ScanSettingsCompat.a().wT(0).bFy();
    AppMethodBeat.o(175632);
    return paramString;
    paramString = new ScanSettingsCompat.a().wT(1).bFy();
    AppMethodBeat.o(175632);
    return paramString;
    paramString = new ScanSettingsCompat.a().wT(2).bFy();
    AppMethodBeat.o(175632);
    return paramString;
  }
  
  private void bFe()
  {
    try
    {
      AppMethodBeat.i(215161);
      if ((this.lKJ != null) && (this.context != null))
      {
        Log.i(this.cDW, "bluetoothStateListener uninit");
        this.context.unregisterReceiver(this.lKJ);
        this.lKJ = null;
      }
      AppMethodBeat.o(215161);
      return;
    }
    finally {}
  }
  
  /* Error */
  private void bFu()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 137
    //   4: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 87	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/a:context	Landroid/content/Context;
    //   11: ifnonnull +20 -> 31
    //   14: aload_0
    //   15: getfield 66	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/a:cDW	Ljava/lang/String;
    //   18: ldc 139
    //   20: invokestatic 142	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: ldc 137
    //   25: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: aload_0
    //   32: getfield 122	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/a:lKJ	Landroid/content/BroadcastReceiver;
    //   35: ifnonnull +47 -> 82
    //   38: aload_0
    //   39: getfield 66	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/a:cDW	Ljava/lang/String;
    //   42: ldc 144
    //   44: invokestatic 129	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload_0
    //   48: new 10	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/a$3
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 145	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/a$3:<init>	(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/a;)V
    //   56: putfield 122	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/a:lKJ	Landroid/content/BroadcastReceiver;
    //   59: new 147	android/content/IntentFilter
    //   62: dup
    //   63: ldc 149
    //   65: invokespecial 150	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   68: astore_1
    //   69: aload_0
    //   70: getfield 87	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/a:context	Landroid/content/Context;
    //   73: aload_0
    //   74: getfield 122	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/a:lKJ	Landroid/content/BroadcastReceiver;
    //   77: aload_1
    //   78: invokevirtual 154	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   81: pop
    //   82: ldc 137
    //   84: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: goto -59 -> 28
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	a
    //   68	10	1	localIntentFilter	android.content.IntentFilter
    //   90	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	28	90	finally
    //   31	82	90	finally
    //   82	87	90	finally
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b paramb, List<ScanFilterCompat> paramList, i parami)
  {
    BluetoothAdapter localBluetoothAdapter;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(144602);
        if ((!this.dxh.get()) || (this.lNP == null))
        {
          paramb.a(j.lNE);
          AppMethodBeat.o(144602);
          return;
        }
        if (this.lNQ.get())
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cDW, "already scan", new Object[0]);
          paramb.a(j.lNu);
          AppMethodBeat.o(144602);
          continue;
        }
        localBluetoothAdapter = c.bFC();
      }
      finally {}
      if ((localBluetoothAdapter != null) && (c.bFE())) {
        break;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.cDW, "BluetoothAdapter is null, err", new Object[0]);
      paramb.a(j.lNx);
      AppMethodBeat.o(144602);
    }
    label159:
    boolean bool1;
    Object localObject;
    boolean bool2;
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (c.ZG("android.permission.ACCESS_FINE_LOCATION")) {
        break label458;
      }
      if (!c.ZG("android.permission.ACCESS_COARSE_LOCATION")) {
        break label480;
      }
      break label458;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cDW, "checkLocationPermission :%b", new Object[] { Boolean.valueOf(bool1) });
      localObject = (LocationManager)MMApplicationContext.getContext().getSystemService("location");
      if (localObject == null) {
        break label449;
      }
      bool2 = ((LocationManager)localObject).isProviderEnabled("gps");
      bool1 = ((LocationManager)localObject).isProviderEnabled("network");
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleHelper", "isGPSEnable " + bool2 + ", isNetworkEnable:" + bool1, new Object[0]);
      break label464;
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cDW, "checkGpsEnable:%b", new Object[] { Boolean.valueOf(bool1) });
      this.lNQ.set(true);
      localObject = paramList;
      if (paramList != null)
      {
        localObject = paramList;
        if (paramList.size() == 0)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cDW, "scanFilterCompats size:%d", new Object[] { Integer.valueOf(paramList.size()) });
          localObject = null;
        }
      }
      bool1 = b.a(localBluetoothAdapter, (List)localObject, ZF(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bFm().lMm), this.lNP);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cDW, "startBleScan isOk:%b", new Object[] { Boolean.valueOf(bool1) });
      if (bool1)
      {
        this.lNT = parami;
        if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bFm().gTn > 0) {
          this.mHandler.postDelayed(this.lNS, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bFm().gTn);
        }
        paramb.a(j.lNu);
        AppMethodBeat.o(144602);
        break;
      }
      paramb.a(j.lNE);
      AppMethodBeat.o(144602);
      break;
      label449:
      bool1 = false;
      bool2 = false;
      break label464;
      label458:
      bool1 = true;
      break label159;
      label464:
      if ((bool2) && (bool1))
      {
        bool1 = true;
        continue;
        label480:
        bool1 = false;
        break label159;
      }
      bool1 = false;
    }
  }
  
  public final j bFv()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(144603);
        j localj;
        if ((!this.dxh.get()) || (this.lNP == null))
        {
          localj = j.lNw;
          AppMethodBeat.o(144603);
          return localj;
        }
        if (!this.lNQ.get())
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cDW, "not scan", new Object[0]);
          localj = j.lNu;
          AppMethodBeat.o(144603);
          continue;
        }
        localObject2 = c.bFC();
      }
      finally {}
      Object localObject2;
      if ((localObject2 == null) || (!c.bFE()))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.cDW, "BluetoothAdapter is null, err", new Object[0]);
        localObject2 = j.lNx;
        AppMethodBeat.o(144603);
      }
      else
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cDW, "stopBleScan, stopScan", new Object[0]);
        this.lNQ.set(false);
        b.a((BluetoothAdapter)localObject2, this.lNP);
        localObject2 = j.lNu;
        AppMethodBeat.o(144603);
      }
    }
  }
  
  /* Error */
  public final List<d> bFw()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 320
    //   5: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 322	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/a:ljN	Ljava/util/Map;
    //   12: ifnonnull +21 -> 33
    //   15: new 324	java/util/ArrayList
    //   18: dup
    //   19: invokespecial 325	java/util/ArrayList:<init>	()V
    //   22: astore_1
    //   23: ldc_w 320
    //   26: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: areturn
    //   33: new 324	java/util/ArrayList
    //   36: dup
    //   37: aload_0
    //   38: getfield 322	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/a:ljN	Ljava/util/Map;
    //   41: invokeinterface 331 1 0
    //   46: invokespecial 334	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   49: astore_1
    //   50: ldc_w 320
    //   53: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: goto -27 -> 29
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	a
    //   22	28	1	localArrayList	ArrayList
    //   59	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	29	59	finally
    //   33	56	59	finally
  }
  
  public final void init()
  {
    try
    {
      AppMethodBeat.i(215157);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cDW, "init", new Object[0]);
      this.dxh.set(true);
      this.ljN = new HashMap();
      this.lNR = new ArrayList();
      this.lNP = new e()
      {
        public final void a(int paramAnonymousInt, ScanResultCompat paramAnonymousScanResultCompat)
        {
          int i = 0;
          AppMethodBeat.i(144598);
          if (paramAnonymousScanResultCompat.getDevice() == null)
          {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(a.this.cDW, "[onScanResult]result is null, err", new Object[0]);
            AppMethodBeat.o(144598);
            return;
          }
          if (!a.this.dxh.get())
          {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(a.this.cDW, "[onScanResult]not init, err", new Object[0]);
            AppMethodBeat.o(144598);
            return;
          }
          for (;;)
          {
            synchronized (a.this)
            {
              if (a.this.ljN == null)
              {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(a.this.cDW, "[onScanResult]may be close, err", new Object[0]);
                AppMethodBeat.o(144598);
                return;
              }
              com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(a.this.cDW, "callbackType:%d, result:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousScanResultCompat });
              String str = paramAnonymousScanResultCompat.getDevice().getAddress();
              if (!a.this.ljN.containsKey(str)) {
                break label315;
              }
              paramAnonymousInt = i;
              if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bFm().lMd) {
                break label315;
              }
              paramAnonymousScanResultCompat = new d(paramAnonymousScanResultCompat);
              a.this.ljN.put(str, paramAnonymousScanResultCompat);
              if (paramAnonymousInt == 0) {
                break label309;
              }
              if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bFm().gTn <= 0) {
                break label287;
              }
            }
            synchronized (a.this)
            {
              if (a.this.lNR != null) {
                a.this.lNR.add(paramAnonymousScanResultCompat);
              }
              AppMethodBeat.o(144598);
              return;
              paramAnonymousScanResultCompat = finally;
              AppMethodBeat.o(144598);
              throw paramAnonymousScanResultCompat;
            }
            label287:
            ??? = a.this.lNT;
            if (??? != null) {
              ((i)???).a(paramAnonymousScanResultCompat);
            }
            label309:
            AppMethodBeat.o(144598);
            return;
            label315:
            paramAnonymousInt = 1;
          }
        }
        
        public final void onScanFailed(int paramAnonymousInt)
        {
          AppMethodBeat.i(144599);
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(a.this.cDW, "[onScanResult]onScanFailed, errorCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(144599);
        }
      };
      bFu();
      AppMethodBeat.o(215157);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void uninit()
  {
    try
    {
      AppMethodBeat.i(215160);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cDW, "uninit", new Object[0]);
      bFv();
      this.dxh.set(false);
      if (this.ljN != null) {
        this.ljN.clear();
      }
      if (this.lNR != null) {
        this.lNR.clear();
      }
      if ((c.bFC() != null) && (c.bFC().isDiscovering())) {
        c.bFC().cancelDiscovery();
      }
      bFe();
      this.lNP = null;
      AppMethodBeat.o(215160);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a
 * JD-Core Version:    0.7.0.1
 */