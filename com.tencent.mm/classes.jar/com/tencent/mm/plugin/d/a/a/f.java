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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(18)
public final class f
  implements BluetoothAdapter.LeScanCallback, b, r
{
  private static boolean mMi = false;
  public static boolean mMk = false;
  public final ap mHandler;
  private final b mMd;
  private final d mMg;
  private final HashSet<UUID> mMh;
  private boolean mMj;
  private BluetoothAdapter mMl;
  private boolean mMm;
  private int mMn;
  private String mMo;
  private e mMp;
  private Map<String, Long> mMq;
  private final av mMr;
  private final av mMs;
  private final av mMt;
  private final av mMu;
  private final av mMv;
  
  public f(b paramb)
  {
    AppMethodBeat.i(22454);
    this.mMj = false;
    this.mMm = true;
    this.mMn = 0;
    this.mMo = "";
    this.mMp = null;
    this.mMq = new ConcurrentHashMap();
    this.mMr = new av(v.caj().hsB.getSerialTag(), new av.a()
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
    this.mMs = new av(v.caj().hsB.getSerialTag(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(22446);
        if (f.f(f.this).size() > 0)
        {
          ad.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now start");
          if (!f.g(f.this).booleanValue()) {
            break label127;
          }
          ad.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan ok");
        }
        for (;;)
        {
          f.iv(aj.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false));
          if (!f.bxr())
          {
            if (!f.h(f.this).eFX()) {
              f.h(f.this).stopTimer();
            }
            if (!f.i(f.this).eFX()) {
              f.i(f.this).stopTimer();
            }
          }
          AppMethodBeat.o(22446);
          return false;
          label127:
          ad.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan fail");
        }
      }
    }, true);
    this.mMt = new av(v.caj().hsB.getSerialTag(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(22447);
        if (f.f(f.this).size() > 0)
        {
          ad.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now stop");
          f.j(f.this);
          if (f.i(f.this).eFX()) {
            f.i(f.this).av(2000L, 2000L);
          }
          AppMethodBeat.o(22447);
          return true;
        }
        AppMethodBeat.o(22447);
        return false;
      }
    }, true);
    this.mMu = new av(v.caj().hsB.getSerialTag(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(22448);
        ad.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]make isScanning status false");
        f.bBs();
        AppMethodBeat.o(22448);
        return false;
      }
    }, true);
    this.mMv = new av(v.caj().hsB.getSerialTag(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(22449);
        ad.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]time out ,let's stop this new method scan");
        f.k(f.this);
        AppMethodBeat.o(22449);
        return false;
      }
    }, true);
    this.mMh = new HashSet();
    this.mMg = new d(this);
    this.mMd = paramb;
    this.mHandler = new ap(v.caj().hsB.getSerialTag());
    this.mMl = ((BluetoothManager)aj.getContext().getSystemService("bluetooth")).getAdapter();
    AppMethodBeat.o(22454);
  }
  
  private void bBr()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(22456);
        if (this.mMu.eFX()) {
          this.mMu.av(2000L, 2000L);
        }
        if ((mMk) && (this.mMt.eFX())) {
          this.mMt.av(10000L, 10000L);
        }
        if (this.mMv.eFX())
        {
          if (!mMk) {
            this.mMv.av(120000L, 120000L);
          }
        }
        else
        {
          if (mMi) {
            break label282;
          }
          this.mMm = true;
          Object localObject1 = Boolean.valueOf(this.mMl.startLeScan(this));
          if ((((Boolean)localObject1).booleanValue()) || (mMi)) {
            break label265;
          }
          int i = 0;
          if ((((Boolean)localObject1).booleanValue()) || (i >= 3) || (mMi)) {
            break;
          }
          int j = i + 1;
          this.mMl.stopLeScan(this);
          ad.e("MicroMsg.exdevice.IBeaconServer", "start IBEACON BLE scan failed,retry no " + j + " time");
          Boolean localBoolean = Boolean.valueOf(this.mMl.startLeScan(this));
          i = j;
          localObject1 = localBoolean;
          if (!localBoolean.booleanValue()) {
            continue;
          }
          mMi = true;
          this.mMj = true;
          ad.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
          i = j;
          localObject1 = localBoolean;
          continue;
        }
        this.mMv.av(1800000L, 1800000L);
      }
      finally {}
    }
    AppMethodBeat.o(22456);
    for (;;)
    {
      return;
      label265:
      this.mMj = true;
      mMi = true;
      ad.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
      label282:
      AppMethodBeat.o(22456);
    }
  }
  
  private void stopScan()
  {
    AppMethodBeat.i(22455);
    this.mMq.clear();
    mMi = false;
    if (!this.mMu.eFX()) {
      this.mMu.stopTimer();
    }
    if (!this.mMt.eFX()) {
      this.mMt.stopTimer();
    }
    if (!this.mMs.eFX()) {
      this.mMs.stopTimer();
    }
    if (!this.mMr.eFX()) {
      this.mMr.stopTimer();
    }
    if (!this.mMv.eFX()) {
      this.mMv.stopTimer();
    }
    if ((this.mMj) && (this.mMl != null))
    {
      if (this.mMl != null) {
        this.mMl.stopLeScan(this);
      }
      this.mMj = false;
    }
    AppMethodBeat.o(22455);
  }
  
  public final void OS(String paramString)
  {
    AppMethodBeat.i(22460);
    ad.e("MicroMsg.exdevice.IBeaconServer", "------onScanError------ error code = %s, error msg = %s", new Object[] { Integer.valueOf(-1), paramString });
    AppMethodBeat.o(22460);
  }
  
  public final void a(double paramDouble, c paramc)
  {
    AppMethodBeat.i(22457);
    ad.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback, distance = %f", new Object[] { Double.valueOf(paramDouble) });
    String str2 = com.tencent.mm.plugin.exdevice.k.b.be(paramc.mMb.mMf.mMG);
    String str1 = str2;
    if (str2.length() >= 32) {
      str1 = str2.substring(0, 8) + "-" + str2.substring(8, 12) + "-" + str2.substring(12, 16) + "-" + str2.substring(16, 20) + "-" + str2.substring(20);
    }
    str2 = str1 + paramc.mMb.mMf.mMH + paramc.mMb.mMf.mMI;
    if (!this.mMq.containsKey(str2))
    {
      this.mMq.put(str2, Long.valueOf(System.currentTimeMillis()));
      this.mMd.a(paramDouble, paramc);
      int i = paramc.mMb.mMf.mMI;
      ad.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback,uuid = " + str1 + ",major = " + paramc.mMb.mMf.mMH + ",minor = " + (i & 0xFFFF));
      AppMethodBeat.o(22457);
      return;
    }
    long l1 = ((Long)this.mMq.get(str2)).longValue();
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 500L)
    {
      this.mMq.put(str2, Long.valueOf(l2));
      this.mMd.a(paramDouble, paramc);
    }
    AppMethodBeat.o(22457);
  }
  
  public final void a(final String paramString1, final String paramString2, int paramInt1, final int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22459);
    ad.d("MicroMsg.exdevice.IBeaconServer", "onScanFound, device mac = %s, device name = %s, bluetooth version = %d, rssi = %d, advertisment = %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), com.tencent.mm.plugin.exdevice.k.b.be(paramArrayOfByte) });
    if (paramInt1 != 0)
    {
      AppMethodBeat.o(22459);
      return;
    }
    paramString2 = new e();
    if (!paramString2.aF(paramArrayOfByte))
    {
      ad.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
      AppMethodBeat.o(22459);
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.exdevice.k.b.bg(paramString2.mMf.mMG);
    if (paramArrayOfByte == null)
    {
      ad.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
      AppMethodBeat.o(22459);
      return;
    }
    if (!this.mMh.contains(paramArrayOfByte))
    {
      ad.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
      AppMethodBeat.o(22459);
      return;
    }
    if (this.mMm) {
      this.mMo = paramString1;
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
  
  public final void onLeScan(final BluetoothDevice paramBluetoothDevice, final int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22461);
    final e locale = new e();
    if (!locale.aF(paramArrayOfByte))
    {
      ad.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
      AppMethodBeat.o(22461);
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.exdevice.k.b.bg(locale.mMf.mMG);
    if (paramArrayOfByte == null)
    {
      ad.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
      AppMethodBeat.o(22461);
      return;
    }
    if (!this.mMh.contains(paramArrayOfByte))
    {
      ad.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
      AppMethodBeat.o(22461);
      return;
    }
    if (this.mMm)
    {
      this.mMn = paramInt;
      this.mMp = locale;
      if (this.mMr.eFX()) {
        this.mMr.av(2000L, 2000L);
      }
      this.mMm = false;
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
  
  public final void xt(int paramInt)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.a.f
 * JD-Core Version:    0.7.0.1
 */