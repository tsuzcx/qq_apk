package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b
{
  private final Context context;
  final String exO;
  final AtomicBoolean huc;
  final Handler mHandler;
  private BroadcastReceiver rJV;
  private h rNW;
  public final AtomicBoolean rNX;
  List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> rNY;
  final Runnable rNZ;
  volatile a rOa;
  private final Runnable rOb;
  private int rOc;
  volatile j rOd;
  Map<String, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> ric;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(144601);
    this.exO = ("MicroMsg.Ble.BleScanWorker#" + hashCode());
    this.rNX = new AtomicBoolean(false);
    this.huc = new AtomicBoolean(false);
    this.mHandler = new Handler();
    this.rNZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144597);
        if (!b.this.rNX.get())
        {
          AppMethodBeat.o(144597);
          return;
        }
        synchronized (b.this)
        {
          ArrayList localArrayList = new ArrayList(b.this.rNY);
          b.this.rNY.clear();
          ??? = b.this.rOd;
          if ((??? != null) && (localArrayList.size() > 0)) {
            ((j)???).dj(localArrayList);
          }
          b.this.mHandler.postDelayed(b.this.rNZ, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.cqY().interval);
          AppMethodBeat.o(144597);
          return;
        }
      }
    };
    this.rOa = null;
    this.rOb = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(329709);
        Log.i(b.this.exO, "run#mScanWorkaroundTask");
        b.a locala = b.this.rOa;
        if ((!b.this.rNX.get()) || (locala == null))
        {
          AppMethodBeat.o(329709);
          return;
        }
        Log.i(b.this.exO, "run#mScanWorkaroundTask, stopBleScan");
        if (k.rNz.errCode == b.this.crk().errCode) {
          synchronized (b.this)
          {
            Log.i(b.this.exO, "run#mScanWorkaroundTask, startBleScanLocked");
            b localb2 = b.this;
            if (b.a.rOf == locala.rNf)
            {
              localb2.a(locala);
              AppMethodBeat.o(329709);
              return;
            }
            locala = new b.a(b.a.rOf, locala.rOg, locala.rOd);
          }
        }
        AppMethodBeat.o(329709);
      }
    };
    this.rOc = -1;
    this.context = paramContext;
    AppMethodBeat.o(144601);
  }
  
  private static ScanSettingsCompat aaq(String paramString)
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
    paramString = new ScanSettingsCompat.a().AA(0).cro();
    AppMethodBeat.o(175632);
    return paramString;
    paramString = new ScanSettingsCompat.a().AA(1).cro();
    AppMethodBeat.o(175632);
    return paramString;
    paramString = new ScanSettingsCompat.a().AA(2).cro();
    AppMethodBeat.o(175632);
    return paramString;
  }
  
  private void cqE()
  {
    try
    {
      AppMethodBeat.i(329705);
      if ((this.rJV != null) && (this.context != null))
      {
        Log.i(this.exO, "bluetoothStateListener uninit");
        this.context.unregisterReceiver(this.rJV);
        this.rJV = null;
      }
      AppMethodBeat.o(329705);
      return;
    }
    finally {}
  }
  
  /* Error */
  private void crj()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 156
    //   4: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 106	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/b:context	Landroid/content/Context;
    //   11: ifnonnull +20 -> 31
    //   14: aload_0
    //   15: getfield 78	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/b:exO	Ljava/lang/String;
    //   18: ldc 158
    //   20: invokestatic 161	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: ldc 156
    //   25: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: aload_0
    //   32: getfield 141	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/b:rJV	Landroid/content/BroadcastReceiver;
    //   35: ifnonnull +47 -> 82
    //   38: aload_0
    //   39: getfield 78	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/b:exO	Ljava/lang/String;
    //   42: ldc 163
    //   44: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload_0
    //   48: new 12	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/b$4
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 164	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/b$4:<init>	(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/b;)V
    //   56: putfield 141	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/b:rJV	Landroid/content/BroadcastReceiver;
    //   59: new 166	android/content/IntentFilter
    //   62: dup
    //   63: ldc 168
    //   65: invokespecial 169	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   68: astore_1
    //   69: aload_0
    //   70: getfield 106	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/b:context	Landroid/content/Context;
    //   73: aload_0
    //   74: getfield 141	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/b:rJV	Landroid/content/BroadcastReceiver;
    //   77: aload_1
    //   78: invokevirtual 173	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   81: pop
    //   82: ldc 156
    //   84: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: goto -59 -> 28
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	b
    //   68	10	1	localIntentFilter	android.content.IntentFilter
    //   90	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	28	90	finally
    //   31	82	90	finally
    //   82	87	90	finally
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b paramb, List<ScanFilterCompat> paramList, j paramj)
  {
    try
    {
      AppMethodBeat.i(144602);
      paramb = new a(paramb, paramList, paramj);
      this.rOa = paramb;
      a(paramb);
      AppMethodBeat.o(144602);
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  final void a(a parama)
  {
    AppMethodBeat.i(329710);
    if ((!this.huc.get()) || (this.rNW == null))
    {
      parama.rNf.onResult(k.rNI);
      AppMethodBeat.o(329710);
      return;
    }
    if (this.rNX.get())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.exO, "already scan", new Object[0]);
      parama.rNf.onResult(k.rNz);
      AppMethodBeat.o(329710);
      return;
    }
    Object localObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.crs();
    if ((localObject == null) || (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.cru()))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.exO, "BluetoothAdapter is null, err", new Object[0]);
      parama.rNf.onResult(k.rND);
      AppMethodBeat.o(329710);
      return;
    }
    if ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.cqY().rMp) && (a.cri().aqW()))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.exO, "startBleScanLocked, isScanningTooFrequently", new Object[0]);
      localObject = new k(10008, "fail:system error, scanning too frequently", a.c.rUH);
      parama.rNf.onResult((k)localObject);
      AppMethodBeat.o(329710);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      if ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.HC("android.permission.ACCESS_FINE_LOCATION")) || (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.HC("android.permission.ACCESS_COARSE_LOCATION")))
      {
        bool1 = true;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.exO, "checkLocationPermission :%b", new Object[] { Boolean.valueOf(bool1) });
        bool2 = com.tencent.mm.modelgeo.d.bJm();
        boolean bool3 = com.tencent.mm.modelgeo.d.bJn();
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleHelper", "isGPSEnable " + bool2 + ", isNetworkEnable:" + bool3, new Object[0]);
        if ((!bool2) && (!bool3)) {
          break label351;
        }
      }
      label351:
      for (boolean bool2 = true;; bool2 = false)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.exO, "checkGpsEnable:%b", new Object[] { Boolean.valueOf(bool2) });
        if (bool1) {
          break label356;
        }
        parama.rNf.onResult(k.rNS);
        AppMethodBeat.o(329710);
        return;
        bool1 = false;
        break;
      }
    }
    label356:
    this.rNX.set(true);
    if ((parama.rOg != null) && (parama.rOg.size() == 0))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.exO, "scanFilterCompats size:%d", new Object[] { Integer.valueOf(parama.rOg.size()) });
      parama.rOg = null;
    }
    boolean bool1 = c.a((BluetoothAdapter)localObject, parama.rOg, aaq(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.cqY().rMk), this.rNW);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.exO, "startBleScan isOk:%b", new Object[] { Boolean.valueOf(bool1) });
    if (bool1)
    {
      this.rOd = parama.rOd;
      if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.cqY().interval > 0) {
        this.mHandler.postDelayed(this.rNZ, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.cqY().interval);
      }
      if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.cqY().rMp)
      {
        this.rOc = a.cri().aqV();
        if (Build.VERSION.SDK_INT >= 24) {
          this.mHandler.postDelayed(this.rOb, 1800000L);
        }
      }
      parama.rNf.onResult(k.rNz);
      AppMethodBeat.o(329710);
      return;
    }
    parama.rNf.onResult(k.rNI);
    AppMethodBeat.o(329710);
  }
  
  public final k crk()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(144603);
        k localk;
        if ((!this.huc.get()) || (this.rNW == null))
        {
          localk = k.rNC;
          AppMethodBeat.o(144603);
          return localk;
        }
        if (!this.rNX.get())
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.exO, "not scan", new Object[0]);
          localk = k.rNz;
          AppMethodBeat.o(144603);
          continue;
        }
        localObject2 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.crs();
      }
      finally {}
      Object localObject2;
      if ((localObject2 == null) || (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.cru()))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.exO, "BluetoothAdapter is null, err", new Object[0]);
        localObject2 = k.rND;
        AppMethodBeat.o(144603);
      }
      else
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.exO, "stopBleScan, stopScan", new Object[0]);
        this.rNX.set(false);
        c.a((BluetoothAdapter)localObject2, this.rNW);
        if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.cqY().rMp)
        {
          a.cri().mr(this.rOc);
          this.rOc = -1;
          this.mHandler.removeCallbacks(this.rOb);
        }
        localObject2 = k.rNz;
        AppMethodBeat.o(144603);
      }
    }
  }
  
  /* Error */
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> crl()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 382
    //   5: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 384	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/b:ric	Ljava/util/Map;
    //   12: ifnonnull +21 -> 33
    //   15: new 386	java/util/ArrayList
    //   18: dup
    //   19: invokespecial 387	java/util/ArrayList:<init>	()V
    //   22: astore_1
    //   23: ldc_w 382
    //   26: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: areturn
    //   33: new 386	java/util/ArrayList
    //   36: dup
    //   37: aload_0
    //   38: getfield 384	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/b:ric	Ljava/util/Map;
    //   41: invokeinterface 393 1 0
    //   46: invokespecial 396	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   49: astore_1
    //   50: ldc_w 382
    //   53: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: goto -27 -> 29
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	b
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
      AppMethodBeat.i(329708);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.exO, "init", new Object[0]);
      this.huc.set(true);
      this.ric = new HashMap();
      this.rNY = new ArrayList();
      this.rNW = new h()
      {
        public final void a(int paramAnonymousInt, ScanResultCompat paramAnonymousScanResultCompat)
        {
          int i = 0;
          AppMethodBeat.i(329712);
          if (paramAnonymousScanResultCompat.crn() == null)
          {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(b.this.exO, "[onScanResult]result is null, err", new Object[0]);
            AppMethodBeat.o(329712);
            return;
          }
          if (!b.this.huc.get())
          {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(b.this.exO, "[onScanResult]not init, err", new Object[0]);
            AppMethodBeat.o(329712);
            return;
          }
          for (;;)
          {
            synchronized (b.this)
            {
              if (b.this.ric == null)
              {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(b.this.exO, "[onScanResult]may be close, err", new Object[0]);
                AppMethodBeat.o(329712);
                return;
              }
              com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(b.this.exO, "callbackType:%d, result:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousScanResultCompat });
              String str = paramAnonymousScanResultCompat.crn().getAddress();
              if (!b.this.ric.containsKey(str)) {
                break label315;
              }
              paramAnonymousInt = i;
              if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.cqY().rMb) {
                break label315;
              }
              paramAnonymousScanResultCompat = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d(paramAnonymousScanResultCompat);
              b.this.ric.put(str, paramAnonymousScanResultCompat);
              if (paramAnonymousInt == 0) {
                break label309;
              }
              if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.cqY().interval <= 0) {
                break label287;
              }
            }
            synchronized (b.this)
            {
              if (b.this.rNY != null) {
                b.this.rNY.add(paramAnonymousScanResultCompat);
              }
              AppMethodBeat.o(329712);
              return;
              paramAnonymousScanResultCompat = finally;
              AppMethodBeat.o(329712);
              throw paramAnonymousScanResultCompat;
            }
            label287:
            ??? = b.this.rOd;
            if (??? != null) {
              ((j)???).a(paramAnonymousScanResultCompat);
            }
            label309:
            AppMethodBeat.o(329712);
            return;
            label315:
            paramAnonymousInt = 1;
          }
        }
        
        public final void onScanFailed(int paramAnonymousInt)
        {
          AppMethodBeat.i(329713);
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(b.this.exO, "[onScanResult]onScanFailed, errorCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(329713);
        }
      };
      crj();
      AppMethodBeat.o(329708);
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
      AppMethodBeat.i(329716);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.exO, "uninit", new Object[0]);
      crk();
      this.huc.set(false);
      if (this.ric != null) {
        this.ric.clear();
      }
      if (this.rNY != null) {
        this.rNY.clear();
      }
      if ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.crs() != null) && (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.crs().isDiscovering())) {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.crs().cancelDiscovery();
      }
      cqE();
      this.rNW = null;
      AppMethodBeat.o(329716);
      return;
    }
    finally {}
  }
  
  static final class a
  {
    static final com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b rOf;
    public final com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b rNf;
    public final j rOd;
    public List<ScanFilterCompat> rOg;
    
    static
    {
      AppMethodBeat.i(329702);
      rOf = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b()
      {
        public final void onResult(k paramAnonymousk) {}
      };
      AppMethodBeat.o(329702);
    }
    
    public a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b paramb, List<ScanFilterCompat> paramList, j paramj)
    {
      this.rNf = paramb;
      this.rOg = paramList;
      this.rOd = paramj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.b
 * JD-Core Version:    0.7.0.1
 */