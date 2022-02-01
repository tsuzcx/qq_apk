package com.tencent.mm.plugin.d.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.r;
import com.tencent.mm.plugin.exdevice.service.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(18)
public final class f
  implements BluetoothAdapter.LeScanCallback, b, r
{
  private static boolean pfT = false;
  public static boolean pfV = false;
  public final MMHandler mHandler;
  private final b pfO;
  private final d pfR;
  private final HashSet<UUID> pfS;
  private boolean pfU;
  private BluetoothAdapter pfW;
  private boolean pfX;
  private int pfY;
  private String pfZ;
  private e pga;
  private Map<String, Long> pgb;
  private final MTimerHandler pgc;
  private final MTimerHandler pgd;
  private final MTimerHandler pge;
  private final MTimerHandler pgf;
  private final MTimerHandler pgg;
  
  public f(b paramb)
  {
    AppMethodBeat.i(22454);
    this.pfU = false;
    this.pfX = true;
    this.pfY = 0;
    this.pfZ = "";
    this.pga = null;
    this.pgb = new ConcurrentHashMap();
    this.pgc = new MTimerHandler(v.cLz().jkv.getSerialTag(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(22445);
        f.e(f.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(22444);
            f.d(f.this).a(f.a(f.this), f.b(f.this), f.c(f.this));
            AppMethodBeat.o(22444);
          }
        });
        AppMethodBeat.o(22445);
        return false;
      }
    }, true);
    this.pgd = new MTimerHandler(v.cLz().jkv.getSerialTag(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(22446);
        if (f.f(f.this).size() > 0)
        {
          Log.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now start");
          if (!f.g(f.this).booleanValue()) {
            break label127;
          }
          Log.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan ok");
        }
        for (;;)
        {
          f.ke(MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false));
          if (!f.cgn())
          {
            if (!f.h(f.this).stopped()) {
              f.h(f.this).stopTimer();
            }
            if (!f.i(f.this).stopped()) {
              f.i(f.this).stopTimer();
            }
          }
          AppMethodBeat.o(22446);
          return false;
          label127:
          Log.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan fail");
        }
      }
    }, true);
    this.pge = new MTimerHandler(v.cLz().jkv.getSerialTag(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(22447);
        if (f.f(f.this).size() > 0)
        {
          Log.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now stop");
          f.j(f.this);
          if (f.i(f.this).stopped()) {
            f.i(f.this).startTimer(2000L);
          }
          AppMethodBeat.o(22447);
          return true;
        }
        AppMethodBeat.o(22447);
        return false;
      }
    }, true);
    this.pgf = new MTimerHandler(v.cLz().jkv.getSerialTag(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(22448);
        Log.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]make isScanning status false");
        f.ckB();
        AppMethodBeat.o(22448);
        return false;
      }
    }, true);
    this.pgg = new MTimerHandler(v.cLz().jkv.getSerialTag(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(22449);
        Log.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]time out ,let's stop this new method scan");
        f.k(f.this);
        AppMethodBeat.o(22449);
        return false;
      }
    }, true);
    this.pfS = new HashSet();
    this.pfR = new d(this);
    this.pfO = paramb;
    this.mHandler = new MMHandler(v.cLz().jkv.getSerialTag());
    this.pfW = ((BluetoothManager)MMApplicationContext.getContext().getSystemService("bluetooth")).getAdapter();
    AppMethodBeat.o(22454);
  }
  
  private void ckA()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(22456);
        if (this.pgf.stopped()) {
          this.pgf.startTimer(2000L);
        }
        if ((pfV) && (this.pge.stopped())) {
          this.pge.startTimer(10000L);
        }
        if (this.pgg.stopped())
        {
          if (!pfV) {
            this.pgg.startTimer(120000L);
          }
        }
        else
        {
          if (pfT) {
            break label321;
          }
          this.pfX = true;
          Log.i("MicroMsg.exdevice.IBeaconServer", "[BluetoothTrace] start scan");
          Log.printErrStackTrace("MicroMsg.exdevice.IBeaconServer", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
          Object localObject1 = Boolean.valueOf(this.pfW.startLeScan(this));
          if ((((Boolean)localObject1).booleanValue()) || (pfT)) {
            break label304;
          }
          if ((((Boolean)localObject1).booleanValue()) || (i >= 3) || (pfT)) {
            break;
          }
          int j = i + 1;
          this.pfW.stopLeScan(this);
          Log.e("MicroMsg.exdevice.IBeaconServer", "start IBEACON BLE scan failed,retry no " + j + " time");
          Log.i("MicroMsg.exdevice.IBeaconServer", "[BluetoothTrace] start scan");
          Log.printErrStackTrace("MicroMsg.exdevice.IBeaconServer", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
          Boolean localBoolean = Boolean.valueOf(this.pfW.startLeScan(this));
          i = j;
          localObject1 = localBoolean;
          if (!localBoolean.booleanValue()) {
            continue;
          }
          pfT = true;
          this.pfU = true;
          Log.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
          i = j;
          localObject1 = localBoolean;
          continue;
        }
        this.pgg.startTimer(1800000L);
      }
      finally {}
    }
    AppMethodBeat.o(22456);
    for (;;)
    {
      return;
      label304:
      this.pfU = true;
      pfT = true;
      Log.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
      label321:
      AppMethodBeat.o(22456);
    }
  }
  
  private void stopScan()
  {
    AppMethodBeat.i(22455);
    this.pgb.clear();
    pfT = false;
    if (!this.pgf.stopped()) {
      this.pgf.stopTimer();
    }
    if (!this.pge.stopped()) {
      this.pge.stopTimer();
    }
    if (!this.pgd.stopped()) {
      this.pgd.stopTimer();
    }
    if (!this.pgc.stopped()) {
      this.pgc.stopTimer();
    }
    if (!this.pgg.stopped()) {
      this.pgg.stopTimer();
    }
    if ((this.pfU) && (this.pfW != null))
    {
      if (this.pfW != null) {
        this.pfW.stopLeScan(this);
      }
      this.pfU = false;
    }
    AppMethodBeat.o(22455);
  }
  
  public final void CK(int paramInt)
  {
    AppMethodBeat.i(22458);
    if (paramInt != 0)
    {
      AppMethodBeat.o(22458);
      return;
    }
    stopScan();
    AppMethodBeat.o(22458);
  }
  
  public final void a(double paramDouble, c paramc)
  {
    AppMethodBeat.i(22457);
    Log.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback, distance = %f", new Object[] { Double.valueOf(paramDouble) });
    String str2 = com.tencent.mm.plugin.exdevice.k.b.bw(paramc.pfM.pfQ.pgr);
    String str1 = str2;
    if (str2.length() >= 32) {
      str1 = str2.substring(0, 8) + "-" + str2.substring(8, 12) + "-" + str2.substring(12, 16) + "-" + str2.substring(16, 20) + "-" + str2.substring(20);
    }
    str2 = str1 + paramc.pfM.pfQ.pgs + paramc.pfM.pfQ.pgt;
    if (!this.pgb.containsKey(str2))
    {
      this.pgb.put(str2, Long.valueOf(System.currentTimeMillis()));
      this.pfO.a(paramDouble, paramc);
      int i = paramc.pfM.pfQ.pgt;
      Log.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback,uuid = " + str1 + ",major = " + paramc.pfM.pfQ.pgs + ",minor = " + (i & 0xFFFF));
      AppMethodBeat.o(22457);
      return;
    }
    long l1 = ((Long)this.pgb.get(str2)).longValue();
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 500L)
    {
      this.pgb.put(str2, Long.valueOf(l2));
      this.pfO.a(paramDouble, paramc);
    }
    AppMethodBeat.o(22457);
  }
  
  public final void a(final String paramString1, final String paramString2, int paramInt1, final int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22459);
    Log.d("MicroMsg.exdevice.IBeaconServer", "onScanFound, device mac = %s, device name = %s, bluetooth version = %d, rssi = %d, advertisment = %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), com.tencent.mm.plugin.exdevice.k.b.bw(paramArrayOfByte) });
    if (paramInt1 != 0)
    {
      AppMethodBeat.o(22459);
      return;
    }
    paramString2 = new e();
    if (!paramString2.aV(paramArrayOfByte))
    {
      Log.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
      AppMethodBeat.o(22459);
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.exdevice.k.b.by(paramString2.pfQ.pgr);
    if (paramArrayOfByte == null)
    {
      Log.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
      AppMethodBeat.o(22459);
      return;
    }
    if (!this.pfS.contains(paramArrayOfByte))
    {
      Log.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
      AppMethodBeat.o(22459);
      return;
    }
    if (this.pfX) {
      this.pfZ = paramString1;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22452);
        f.d(f.this).a(paramInt2, paramString1, paramString2);
        AppMethodBeat.o(22452);
      }
    });
    AppMethodBeat.o(22459);
  }
  
  public final void ahk(String paramString)
  {
    AppMethodBeat.i(22460);
    Log.e("MicroMsg.exdevice.IBeaconServer", "------onScanError------ error code = %s, error msg = %s", new Object[] { Integer.valueOf(-1), paramString });
    AppMethodBeat.o(22460);
  }
  
  public final void onLeScan(final BluetoothDevice paramBluetoothDevice, final int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22461);
    final e locale = new e();
    if (!locale.aV(paramArrayOfByte))
    {
      Log.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
      AppMethodBeat.o(22461);
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.exdevice.k.b.by(locale.pfQ.pgr);
    if (paramArrayOfByte == null)
    {
      Log.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
      AppMethodBeat.o(22461);
      return;
    }
    if (!this.pfS.contains(paramArrayOfByte))
    {
      Log.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
      AppMethodBeat.o(22461);
      return;
    }
    if (this.pfX)
    {
      this.pfY = paramInt;
      this.pga = locale;
      if (this.pgc.stopped()) {
        this.pgc.startTimer(2000L);
      }
      this.pfX = false;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22453);
        f.d(f.this).a(paramInt, paramBluetoothDevice.getAddress(), locale);
        AppMethodBeat.o(22453);
      }
    });
    AppMethodBeat.o(22461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.a.f
 * JD-Core Version:    0.7.0.1
 */