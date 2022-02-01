package com.tencent.mm.plugin.f.a.a;

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
  implements BluetoothAdapter.LeScanCallback, r, b
{
  private static boolean sic = false;
  public static boolean sie = false;
  public final MMHandler mHandler;
  private final b shX;
  private final d sia;
  private final HashSet<UUID> sib;
  private boolean sid;
  private BluetoothAdapter sif;
  private boolean sih;
  private int sii;
  private String sij;
  private e sik;
  private Map<String, Long> sil;
  private final MTimerHandler sim;
  private final MTimerHandler sin;
  private final MTimerHandler sio;
  private final MTimerHandler sip;
  private final MTimerHandler siq;
  
  public f(b paramb)
  {
    AppMethodBeat.i(22454);
    this.sid = false;
    this.sih = true;
    this.sii = 0;
    this.sij = "";
    this.sik = null;
    this.sil = new ConcurrentHashMap();
    this.sim = new MTimerHandler(v.dam().mat.getSerialTag(), new MTimerHandler.CallBack()
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
    this.sin = new MTimerHandler(v.dam().mat.getSerialTag(), new MTimerHandler.CallBack()
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
          f.lp(MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false));
          if (!f.ctz())
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
    this.sio = new MTimerHandler(v.dam().mat.getSerialTag(), new MTimerHandler.CallBack()
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
    this.sip = new MTimerHandler(v.dam().mat.getSerialTag(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(22448);
        Log.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]make isScanning status false");
        f.cxV();
        AppMethodBeat.o(22448);
        return false;
      }
    }, true);
    this.siq = new MTimerHandler(v.dam().mat.getSerialTag(), new MTimerHandler.CallBack()
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
    this.sib = new HashSet();
    this.sia = new d(this);
    this.shX = paramb;
    this.mHandler = new MMHandler(v.dam().mat.getSerialTag());
    this.sif = ((BluetoothManager)MMApplicationContext.getContext().getSystemService("bluetooth")).getAdapter();
    AppMethodBeat.o(22454);
  }
  
  private void cxT()
  {
    AppMethodBeat.i(22455);
    this.sil.clear();
    sic = false;
    if (!this.sip.stopped()) {
      this.sip.stopTimer();
    }
    if (!this.sio.stopped()) {
      this.sio.stopTimer();
    }
    if (!this.sin.stopped()) {
      this.sin.stopTimer();
    }
    if (!this.sim.stopped()) {
      this.sim.stopTimer();
    }
    if (!this.siq.stopped()) {
      this.siq.stopTimer();
    }
    if ((this.sid) && (this.sif != null))
    {
      if (this.sif != null) {
        this.sif.stopLeScan(this);
      }
      this.sid = false;
    }
    AppMethodBeat.o(22455);
  }
  
  private void cxU()
  {
    label392:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(22456);
        if (this.sip.stopped()) {
          this.sip.startTimer(2000L);
        }
        if ((sie) && (this.sio.stopped())) {
          this.sio.startTimer(10000L);
        }
        if (this.siq.stopped())
        {
          if (!sie) {
            this.siq.startTimer(120000L);
          }
        }
        else
        {
          if (sic) {
            break label383;
          }
          this.sih = true;
          Log.i("MicroMsg.exdevice.IBeaconServer", "[BluetoothTrace] start scan");
          Log.printErrStackTrace("MicroMsg.exdevice.IBeaconServer", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
          Boolean localBoolean = Boolean.valueOf(((Boolean)com.tencent.mm.hellhoundlib.a.a.a(this.sif, new com.tencent.mm.hellhoundlib.b.a().bm(this).aFh(), "com/tencent/mm/plugin/bluetooth/sdk/IBeacon/IBeaconServer", "startScan", "()V", "android/bluetooth/BluetoothAdapter", "startLeScan", "(Landroid/bluetooth/BluetoothAdapter$LeScanCallback;)Z")).booleanValue());
          if ((localBoolean.booleanValue()) || (sic)) {
            break label366;
          }
          int i = 0;
          if ((localBoolean.booleanValue()) || (i >= 3) || (sic)) {
            break label357;
          }
          i += 1;
          this.sif.stopLeScan(this);
          Log.e("MicroMsg.exdevice.IBeaconServer", "start IBEACON BLE scan failed,retry no " + i + " time");
          Log.i("MicroMsg.exdevice.IBeaconServer", "[BluetoothTrace] start scan");
          Log.printErrStackTrace("MicroMsg.exdevice.IBeaconServer", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
          localBoolean = Boolean.valueOf(((Boolean)com.tencent.mm.hellhoundlib.a.a.a(this.sif, new com.tencent.mm.hellhoundlib.b.a().bm(this).aFh(), "com/tencent/mm/plugin/bluetooth/sdk/IBeacon/IBeaconServer", "startScan", "()V", "android/bluetooth/BluetoothAdapter", "startLeScan", "(Landroid/bluetooth/BluetoothAdapter$LeScanCallback;)Z")).booleanValue());
          if (!localBoolean.booleanValue()) {
            break label392;
          }
          sic = true;
          this.sid = true;
          Log.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
          continue;
        }
        this.siq.startTimer(1800000L);
        continue;
        AppMethodBeat.o(22456);
      }
      finally {}
      for (;;)
      {
        label357:
        return;
        label366:
        this.sid = true;
        sic = true;
        Log.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
        label383:
        AppMethodBeat.o(22456);
      }
    }
  }
  
  public final void Gp(int paramInt)
  {
    AppMethodBeat.i(22458);
    if (paramInt != 0)
    {
      AppMethodBeat.o(22458);
      return;
    }
    cxT();
    AppMethodBeat.o(22458);
  }
  
  public final void a(double paramDouble, c paramc)
  {
    AppMethodBeat.i(22457);
    Log.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback, distance = %f", new Object[] { Double.valueOf(paramDouble) });
    String str2 = com.tencent.mm.plugin.exdevice.k.b.bK(paramc.shU.shZ.siC);
    String str1 = str2;
    if (str2.length() >= 32) {
      str1 = str2.substring(0, 8) + "-" + str2.substring(8, 12) + "-" + str2.substring(12, 16) + "-" + str2.substring(16, 20) + "-" + str2.substring(20);
    }
    str2 = str1 + paramc.shU.shZ.siD + paramc.shU.shZ.siE;
    if (!this.sil.containsKey(str2))
    {
      this.sil.put(str2, Long.valueOf(System.currentTimeMillis()));
      this.shX.a(paramDouble, paramc);
      int i = paramc.shU.shZ.siE;
      Log.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback,uuid = " + str1 + ",major = " + paramc.shU.shZ.siD + ",minor = " + (i & 0xFFFF));
      AppMethodBeat.o(22457);
      return;
    }
    long l1 = ((Long)this.sil.get(str2)).longValue();
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 500L)
    {
      this.sil.put(str2, Long.valueOf(l2));
      this.shX.a(paramDouble, paramc);
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
    paramArrayOfByte = com.tencent.mm.plugin.exdevice.k.b.bM(paramString2.shZ.siC);
    if (paramArrayOfByte == null)
    {
      Log.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
      AppMethodBeat.o(22459);
      return;
    }
    if (!this.sib.contains(paramArrayOfByte))
    {
      Log.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
      AppMethodBeat.o(22459);
      return;
    }
    if (this.sih) {
      this.sij = paramString1;
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
  
  public final void aoQ(String paramString)
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
    paramArrayOfByte = com.tencent.mm.plugin.exdevice.k.b.bM(locale.shZ.siC);
    if (paramArrayOfByte == null)
    {
      Log.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
      AppMethodBeat.o(22461);
      return;
    }
    if (!this.sib.contains(paramArrayOfByte))
    {
      Log.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
      AppMethodBeat.o(22461);
      return;
    }
    if (this.sih)
    {
      this.sii = paramInt;
      this.sik = locale;
      if (this.sim.stopped()) {
        this.sim.startTimer(2000L);
      }
      this.sih = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.a.f
 * JD-Core Version:    0.7.0.1
 */