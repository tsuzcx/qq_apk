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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b
{
  final String cED;
  private final Context context;
  final AtomicBoolean fpT;
  final Handler mHandler;
  private BroadcastReceiver oGW;
  private h oKd;
  public final AtomicBoolean oKe;
  List<d> oKf;
  final Runnable oKg;
  volatile a oKh;
  private final Runnable oKi;
  private int oKj;
  volatile i oKk;
  Map<String, d> oew;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(144601);
    this.cED = ("MicroMsg.Ble.BleScanWorker#" + hashCode());
    this.oKe = new AtomicBoolean(false);
    this.fpT = new AtomicBoolean(false);
    this.mHandler = new Handler();
    this.oKg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144597);
        if (!b.this.oKe.get())
        {
          AppMethodBeat.o(144597);
          return;
        }
        synchronized (b.this)
        {
          ArrayList localArrayList = new ArrayList(b.this.oKf);
          b.this.oKf.clear();
          ??? = b.this.oKk;
          if ((??? != null) && (localArrayList.size() > 0)) {
            ((i)???).by(localArrayList);
          }
          b.this.mHandler.postDelayed(b.this.oKg, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bQQ().interval);
          AppMethodBeat.o(144597);
          return;
        }
      }
    };
    this.oKh = null;
    this.oKi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199606);
        Log.i(b.this.cED, "run#mScanWorkaroundTask");
        b.a locala = b.this.oKh;
        if ((!b.this.oKe.get()) || (locala == null))
        {
          AppMethodBeat.o(199606);
          return;
        }
        Log.i(b.this.cED, "run#mScanWorkaroundTask, stopBleScan");
        if (j.oJI.errCode == b.this.bRc().errCode) {
          synchronized (b.this)
          {
            Log.i(b.this.cED, "run#mScanWorkaroundTask, startBleScanLocked");
            b localb2 = b.this;
            if (b.a.oKm == locala.oJr)
            {
              localb2.a(locala);
              AppMethodBeat.o(199606);
              return;
            }
            locala = new b.a(b.a.oKm, locala.oKn, locala.oKk);
          }
        }
        AppMethodBeat.o(199606);
      }
    };
    this.oKj = -1;
    this.context = paramContext;
    AppMethodBeat.o(144601);
  }
  
  private static ScanSettingsCompat aht(String paramString)
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
    paramString = new ScanSettingsCompat.a().Aj(0).bRg();
    AppMethodBeat.o(175632);
    return paramString;
    paramString = new ScanSettingsCompat.a().Aj(1).bRg();
    AppMethodBeat.o(175632);
    return paramString;
    paramString = new ScanSettingsCompat.a().Aj(2).bRg();
    AppMethodBeat.o(175632);
    return paramString;
  }
  
  private void bQI()
  {
    try
    {
      AppMethodBeat.i(198303);
      if ((this.oGW != null) && (this.context != null))
      {
        Log.i(this.cED, "bluetoothStateListener uninit");
        this.context.unregisterReceiver(this.oGW);
        this.oGW = null;
      }
      AppMethodBeat.o(198303);
      return;
    }
    finally {}
  }
  
  /* Error */
  private void bRb()
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
    //   15: getfield 78	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/b:cED	Ljava/lang/String;
    //   18: ldc 158
    //   20: invokestatic 161	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: ldc 156
    //   25: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: aload_0
    //   32: getfield 141	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/b:oGW	Landroid/content/BroadcastReceiver;
    //   35: ifnonnull +47 -> 82
    //   38: aload_0
    //   39: getfield 78	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/b:cED	Ljava/lang/String;
    //   42: ldc 163
    //   44: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload_0
    //   48: new 12	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/b$4
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 164	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/b$4:<init>	(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/b;)V
    //   56: putfield 141	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/b:oGW	Landroid/content/BroadcastReceiver;
    //   59: new 166	android/content/IntentFilter
    //   62: dup
    //   63: ldc 168
    //   65: invokespecial 169	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   68: astore_1
    //   69: aload_0
    //   70: getfield 106	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/b:context	Landroid/content/Context;
    //   73: aload_0
    //   74: getfield 141	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/b:oGW	Landroid/content/BroadcastReceiver;
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
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b paramb, List<ScanFilterCompat> paramList, i parami)
  {
    try
    {
      AppMethodBeat.i(144602);
      paramb = new a(paramb, paramList, parami);
      this.oKh = paramb;
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
    AppMethodBeat.i(198289);
    if ((!this.fpT.get()) || (this.oKd == null))
    {
      parama.oJr.a(j.oJS);
      AppMethodBeat.o(198289);
      return;
    }
    if (this.oKe.get())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cED, "already scan", new Object[0]);
      parama.oJr.a(j.oJI);
      AppMethodBeat.o(198289);
      return;
    }
    Object localObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bRk();
    if ((localObject == null) || (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bRm()))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.cED, "BluetoothAdapter is null, err", new Object[0]);
      parama.oJr.a(j.oJL);
      AppMethodBeat.o(198289);
      return;
    }
    if ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bQQ().oIG) && (a.bRa().QJ()))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cED, "startBleScanLocked, isScanningTooFrequently", new Object[0]);
      localObject = new j(10008, "fail:system error, scanning too frequently");
      parama.oJr.a((j)localObject);
      AppMethodBeat.o(198289);
      return;
    }
    boolean bool1;
    boolean bool2;
    if (Build.VERSION.SDK_INT >= 23)
    {
      if ((!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.ahu("android.permission.ACCESS_FINE_LOCATION")) && (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.ahu("android.permission.ACCESS_COARSE_LOCATION"))) {
        break label554;
      }
      bool1 = true;
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cED, "checkLocationPermission :%b", new Object[] { Boolean.valueOf(bool1) });
      LocationManager localLocationManager = (LocationManager)MMApplicationContext.getContext().getSystemService("location");
      if (localLocationManager == null) {
        break label582;
      }
      bool2 = localLocationManager.isProviderEnabled("gps");
      bool1 = localLocationManager.isProviderEnabled("network");
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleHelper", "isGPSEnable " + bool2 + ", isNetworkEnable:" + bool1, new Object[0]);
    }
    for (;;)
    {
      if ((bool2) && (bool1)) {}
      for (bool1 = true;; bool1 = false)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cED, "checkGpsEnable:%b", new Object[] { Boolean.valueOf(bool1) });
        this.oKe.set(true);
        if ((parama.oKn != null) && (parama.oKn.size() == 0))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cED, "scanFilterCompats size:%d", new Object[] { Integer.valueOf(parama.oKn.size()) });
          parama.oKn = null;
        }
        bool1 = c.a((BluetoothAdapter)localObject, parama.oKn, aht(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bQQ().oIB), this.oKd);
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cED, "startBleScan isOk:%b", new Object[] { Boolean.valueOf(bool1) });
        if (!bool1) {
          break label564;
        }
        this.oKk = parama.oKk;
        if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bQQ().interval > 0) {
          this.mHandler.postDelayed(this.oKg, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bQQ().interval);
        }
        if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bQQ().oIG)
        {
          this.oKj = a.bRa().QI();
          if (Build.VERSION.SDK_INT >= 24) {
            this.mHandler.postDelayed(this.oKi, 1800000L);
          }
        }
        parama.oJr.a(j.oJI);
        AppMethodBeat.o(198289);
        return;
        label554:
        bool1 = false;
        break;
      }
      label564:
      parama.oJr.a(j.oJS);
      AppMethodBeat.o(198289);
      return;
      label582:
      bool1 = false;
      bool2 = false;
    }
  }
  
  public final j bRc()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(144603);
        j localj;
        if ((!this.fpT.get()) || (this.oKd == null))
        {
          localj = j.oJK;
          AppMethodBeat.o(144603);
          return localj;
        }
        if (!this.oKe.get())
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cED, "not scan", new Object[0]);
          localj = j.oJI;
          AppMethodBeat.o(144603);
          continue;
        }
        localObject2 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bRk();
      }
      finally {}
      Object localObject2;
      if ((localObject2 == null) || (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bRm()))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.cED, "BluetoothAdapter is null, err", new Object[0]);
        localObject2 = j.oJL;
        AppMethodBeat.o(144603);
      }
      else
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cED, "stopBleScan, stopScan", new Object[0]);
        this.oKe.set(false);
        c.a((BluetoothAdapter)localObject2, this.oKd);
        if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bQQ().oIG)
        {
          a.bRa().iQ(this.oKj);
          this.oKj = -1;
          this.mHandler.removeCallbacks(this.oKi);
        }
        localObject2 = j.oJI;
        AppMethodBeat.o(144603);
      }
    }
  }
  
  /* Error */
  public final List<d> bRd()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 385
    //   5: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 387	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/b:oew	Ljava/util/Map;
    //   12: ifnonnull +21 -> 33
    //   15: new 389	java/util/ArrayList
    //   18: dup
    //   19: invokespecial 390	java/util/ArrayList:<init>	()V
    //   22: astore_1
    //   23: ldc_w 385
    //   26: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: areturn
    //   33: new 389	java/util/ArrayList
    //   36: dup
    //   37: aload_0
    //   38: getfield 387	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/b:oew	Ljava/util/Map;
    //   41: invokeinterface 396 1 0
    //   46: invokespecial 399	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   49: astore_1
    //   50: ldc_w 385
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
      AppMethodBeat.i(198260);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cED, "init", new Object[0]);
      this.fpT.set(true);
      this.oew = new HashMap();
      this.oKf = new ArrayList();
      this.oKd = new h()
      {
        public final void a(int paramAnonymousInt, ScanResultCompat paramAnonymousScanResultCompat)
        {
          int i = 0;
          AppMethodBeat.i(199083);
          if (paramAnonymousScanResultCompat.bRf() == null)
          {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(b.this.cED, "[onScanResult]result is null, err", new Object[0]);
            AppMethodBeat.o(199083);
            return;
          }
          if (!b.this.fpT.get())
          {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(b.this.cED, "[onScanResult]not init, err", new Object[0]);
            AppMethodBeat.o(199083);
            return;
          }
          for (;;)
          {
            synchronized (b.this)
            {
              if (b.this.oew == null)
              {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(b.this.cED, "[onScanResult]may be close, err", new Object[0]);
                AppMethodBeat.o(199083);
                return;
              }
              com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(b.this.cED, "callbackType:%d, result:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousScanResultCompat });
              String str = paramAnonymousScanResultCompat.bRf().getAddress();
              if (!b.this.oew.containsKey(str)) {
                break label315;
              }
              paramAnonymousInt = i;
              if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bQQ().oIs) {
                break label315;
              }
              paramAnonymousScanResultCompat = new d(paramAnonymousScanResultCompat);
              b.this.oew.put(str, paramAnonymousScanResultCompat);
              if (paramAnonymousInt == 0) {
                break label309;
              }
              if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bQQ().interval <= 0) {
                break label287;
              }
            }
            synchronized (b.this)
            {
              if (b.this.oKf != null) {
                b.this.oKf.add(paramAnonymousScanResultCompat);
              }
              AppMethodBeat.o(199083);
              return;
              paramAnonymousScanResultCompat = finally;
              AppMethodBeat.o(199083);
              throw paramAnonymousScanResultCompat;
            }
            label287:
            ??? = b.this.oKk;
            if (??? != null) {
              ((i)???).a(paramAnonymousScanResultCompat);
            }
            label309:
            AppMethodBeat.o(199083);
            return;
            label315:
            paramAnonymousInt = 1;
          }
        }
        
        public final void onScanFailed(int paramAnonymousInt)
        {
          AppMethodBeat.i(199084);
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(b.this.cED, "[onScanResult]onScanFailed, errorCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(199084);
        }
      };
      bRb();
      AppMethodBeat.o(198260);
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
      AppMethodBeat.i(198301);
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cED, "uninit", new Object[0]);
      bRc();
      this.fpT.set(false);
      if (this.oew != null) {
        this.oew.clear();
      }
      if (this.oKf != null) {
        this.oKf.clear();
      }
      if ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bRk() != null) && (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bRk().isDiscovering())) {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bRk().cancelDiscovery();
      }
      bQI();
      this.oKd = null;
      AppMethodBeat.o(198301);
      return;
    }
    finally {}
  }
  
  static final class a
  {
    static final com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b oKm;
    public final com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b oJr;
    public final i oKk;
    public List<ScanFilterCompat> oKn;
    
    static
    {
      AppMethodBeat.i(199160);
      oKm = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b()
      {
        public final void a(j paramAnonymousj) {}
      };
      AppMethodBeat.o(199160);
    }
    
    public a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b paramb, List<ScanFilterCompat> paramList, i parami)
    {
      this.oJr = paramb;
      this.oKn = paramList;
      this.oKk = parami;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.b
 * JD-Core Version:    0.7.0.1
 */