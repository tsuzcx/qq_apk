package com.tencent.mm.plugin.g.a.a;

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

public final class f
  implements BluetoothAdapter.LeScanCallback, r, b
{
  private static boolean vud = false;
  public static boolean vuf = false;
  public final MMHandler mHandler;
  private final b vtY;
  private final d vub;
  private final HashSet<UUID> vuc;
  private boolean vue;
  private BluetoothAdapter vug;
  private boolean vuh;
  private int vui;
  private String vuj;
  private e vuk;
  private Map<String, Long> vul;
  private final MTimerHandler vum;
  private final MTimerHandler vun;
  private final MTimerHandler vuo;
  private final MTimerHandler vup;
  private final MTimerHandler vuq;
  
  public f(b paramb)
  {
    AppMethodBeat.i(22454);
    this.vue = false;
    this.vuh = true;
    this.vui = 0;
    this.vuj = "";
    this.vuk = null;
    this.vul = new ConcurrentHashMap();
    this.vum = new MTimerHandler(v.dGF().oTi.getSerialTag(), new MTimerHandler.CallBack()
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
    this.vun = new MTimerHandler(v.dGF().oTi.getSerialTag(), new MTimerHandler.CallBack()
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
          f.mH(MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false));
          if (!f.cWj())
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
    this.vuo = new MTimerHandler(v.dGF().oTi.getSerialTag(), new MTimerHandler.CallBack()
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
    this.vup = new MTimerHandler(v.dGF().oTi.getSerialTag(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(22448);
        Log.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]make isScanning status false");
        f.daN();
        AppMethodBeat.o(22448);
        return false;
      }
    }, true);
    this.vuq = new MTimerHandler(v.dGF().oTi.getSerialTag(), new MTimerHandler.CallBack()
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
    this.vuc = new HashSet();
    this.vub = new d(this);
    this.vtY = paramb;
    this.mHandler = new MMHandler(v.dGF().oTi.getSerialTag());
    this.vug = ((BluetoothManager)MMApplicationContext.getContext().getSystemService("bluetooth")).getAdapter();
    AppMethodBeat.o(22454);
  }
  
  private void daL()
  {
    AppMethodBeat.i(22455);
    this.vul.clear();
    vud = false;
    if (!this.vup.stopped()) {
      this.vup.stopTimer();
    }
    if (!this.vuo.stopped()) {
      this.vuo.stopTimer();
    }
    if (!this.vun.stopped()) {
      this.vun.stopTimer();
    }
    if (!this.vum.stopped()) {
      this.vum.stopTimer();
    }
    if (!this.vuq.stopped()) {
      this.vuq.stopTimer();
    }
    if ((this.vue) && (this.vug != null))
    {
      if (this.vug != null) {
        this.vug.stopLeScan(this);
      }
      this.vue = false;
    }
    AppMethodBeat.o(22455);
  }
  
  private void daM()
  {
    label392:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(22456);
        if (this.vup.stopped()) {
          this.vup.startTimer(2000L);
        }
        if ((vuf) && (this.vuo.stopped())) {
          this.vuo.startTimer(10000L);
        }
        if (this.vuq.stopped())
        {
          if (!vuf) {
            this.vuq.startTimer(120000L);
          }
        }
        else
        {
          if (vud) {
            break label383;
          }
          this.vuh = true;
          Log.i("MicroMsg.exdevice.IBeaconServer", "[BluetoothTrace] start scan");
          Log.printErrStackTrace("MicroMsg.exdevice.IBeaconServer", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
          Boolean localBoolean = Boolean.valueOf(((Boolean)com.tencent.mm.hellhoundlib.a.a.a(this.vug, new com.tencent.mm.hellhoundlib.b.a().cG(this).aYi(), "com/tencent/mm/plugin/bluetooth/sdk/IBeacon/IBeaconServer", "startScan", "()V", "android/bluetooth/BluetoothAdapter", "startLeScan", "(Landroid/bluetooth/BluetoothAdapter$LeScanCallback;)Z")).booleanValue());
          if ((localBoolean.booleanValue()) || (vud)) {
            break label366;
          }
          int i = 0;
          if ((localBoolean.booleanValue()) || (i >= 3) || (vud)) {
            break label357;
          }
          i += 1;
          this.vug.stopLeScan(this);
          Log.e("MicroMsg.exdevice.IBeaconServer", "start IBEACON BLE scan failed,retry no " + i + " time");
          Log.i("MicroMsg.exdevice.IBeaconServer", "[BluetoothTrace] start scan");
          Log.printErrStackTrace("MicroMsg.exdevice.IBeaconServer", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
          localBoolean = Boolean.valueOf(((Boolean)com.tencent.mm.hellhoundlib.a.a.a(this.vug, new com.tencent.mm.hellhoundlib.b.a().cG(this).aYi(), "com/tencent/mm/plugin/bluetooth/sdk/IBeacon/IBeaconServer", "startScan", "()V", "android/bluetooth/BluetoothAdapter", "startLeScan", "(Landroid/bluetooth/BluetoothAdapter$LeScanCallback;)Z")).booleanValue());
          if (!localBoolean.booleanValue()) {
            break label392;
          }
          vud = true;
          this.vue = true;
          Log.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
          continue;
        }
        this.vuq.startTimer(1800000L);
        continue;
        AppMethodBeat.o(22456);
      }
      finally {}
      for (;;)
      {
        label357:
        return;
        label366:
        this.vue = true;
        vud = true;
        Log.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
        label383:
        AppMethodBeat.o(22456);
      }
    }
  }
  
  public final void GO(int paramInt)
  {
    AppMethodBeat.i(22458);
    if (paramInt != 0)
    {
      AppMethodBeat.o(22458);
      return;
    }
    daL();
    AppMethodBeat.o(22458);
  }
  
  public final void a(double paramDouble, c paramc)
  {
    AppMethodBeat.i(22457);
    Log.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback, distance = %f", new Object[] { Double.valueOf(paramDouble) });
    String str2 = com.tencent.mm.plugin.exdevice.k.b.bK(paramc.vtV.vua.vuB);
    String str1 = str2;
    if (str2.length() >= 32) {
      str1 = str2.substring(0, 8) + "-" + str2.substring(8, 12) + "-" + str2.substring(12, 16) + "-" + str2.substring(16, 20) + "-" + str2.substring(20);
    }
    str2 = str1 + paramc.vtV.vua.vuC + paramc.vtV.vua.vuD;
    if (!this.vul.containsKey(str2))
    {
      this.vul.put(str2, Long.valueOf(System.currentTimeMillis()));
      this.vtY.a(paramDouble, paramc);
      int i = paramc.vtV.vua.vuD;
      Log.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback,uuid = " + str1 + ",major = " + paramc.vtV.vua.vuC + ",minor = " + (i & 0xFFFF));
      AppMethodBeat.o(22457);
      return;
    }
    long l1 = ((Long)this.vul.get(str2)).longValue();
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 500L)
    {
      this.vul.put(str2, Long.valueOf(l2));
      this.vtY.a(paramDouble, paramc);
    }
    AppMethodBeat.o(22457);
  }
  
  public final void a(final String paramString1, final String paramString2, int paramInt1, final int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22459);
    Log.d("MicroMsg.exdevice.IBeaconServer", "onScanFound, device mac = %s, device name = %s, bluetooth version = %d, rssi = %d, advertisment = %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), com.tencent.mm.plugin.exdevice.k.b.bK(paramArrayOfByte) });
    if (paramInt1 != 0)
    {
      AppMethodBeat.o(22459);
      return;
    }
    paramString2 = new e();
    if (!paramString2.bi(paramArrayOfByte))
    {
      Log.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
      AppMethodBeat.o(22459);
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.exdevice.k.b.bM(paramString2.vua.vuB);
    if (paramArrayOfByte == null)
    {
      Log.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
      AppMethodBeat.o(22459);
      return;
    }
    if (!this.vuc.contains(paramArrayOfByte))
    {
      Log.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
      AppMethodBeat.o(22459);
      return;
    }
    if (this.vuh) {
      this.vuj = paramString1;
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
  
  public final void aim(String paramString)
  {
    AppMethodBeat.i(22460);
    Log.e("MicroMsg.exdevice.IBeaconServer", "------onScanError------ error code = %s, error msg = %s", new Object[] { Integer.valueOf(-1), paramString });
    AppMethodBeat.o(22460);
  }
  
  public final void onLeScan(final BluetoothDevice paramBluetoothDevice, final int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22461);
    final e locale = new e();
    if (!locale.bi(paramArrayOfByte))
    {
      Log.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
      AppMethodBeat.o(22461);
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.exdevice.k.b.bM(locale.vua.vuB);
    if (paramArrayOfByte == null)
    {
      Log.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
      AppMethodBeat.o(22461);
      return;
    }
    if (!this.vuc.contains(paramArrayOfByte))
    {
      Log.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
      AppMethodBeat.o(22461);
      return;
    }
    if (this.vuh)
    {
      this.vui = paramInt;
      this.vuk = locale;
      if (this.vum.stopped()) {
        this.vum.startTimer(2000L);
      }
      this.vuh = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.a.f
 * JD-Core Version:    0.7.0.1
 */