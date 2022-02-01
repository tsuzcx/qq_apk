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
  private static boolean nPq = false;
  public static boolean nPs = false;
  public final ap mHandler;
  private final av nPA;
  private final av nPB;
  private final av nPC;
  private final av nPD;
  private final b nPl;
  private final d nPo;
  private final HashSet<UUID> nPp;
  private boolean nPr;
  private BluetoothAdapter nPt;
  private boolean nPu;
  private int nPv;
  private String nPw;
  private e nPx;
  private Map<String, Long> nPy;
  private final av nPz;
  
  public f(b paramb)
  {
    AppMethodBeat.i(22454);
    this.nPr = false;
    this.nPu = true;
    this.nPv = 0;
    this.nPw = "";
    this.nPx = null;
    this.nPy = new ConcurrentHashMap();
    this.nPz = new av(v.clW().imu.getSerialTag(), new av.a()
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
    this.nPA = new av(v.clW().imu.getSerialTag(), new av.a()
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
          f.jh(aj.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false));
          if (!f.bIw())
          {
            if (!f.h(f.this).fkZ()) {
              f.h(f.this).stopTimer();
            }
            if (!f.i(f.this).fkZ()) {
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
    this.nPB = new av(v.clW().imu.getSerialTag(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(22447);
        if (f.f(f.this).size() > 0)
        {
          ad.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now stop");
          f.j(f.this);
          if (f.i(f.this).fkZ()) {
            f.i(f.this).az(2000L, 2000L);
          }
          AppMethodBeat.o(22447);
          return true;
        }
        AppMethodBeat.o(22447);
        return false;
      }
    }, true);
    this.nPC = new av(v.clW().imu.getSerialTag(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(22448);
        ad.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]make isScanning status false");
        f.bMD();
        AppMethodBeat.o(22448);
        return false;
      }
    }, true);
    this.nPD = new av(v.clW().imu.getSerialTag(), new av.a()
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
    this.nPp = new HashSet();
    this.nPo = new d(this);
    this.nPl = paramb;
    this.mHandler = new ap(v.clW().imu.getSerialTag());
    this.nPt = ((BluetoothManager)aj.getContext().getSystemService("bluetooth")).getAdapter();
    AppMethodBeat.o(22454);
  }
  
  private void bMC()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(22456);
        if (this.nPC.fkZ()) {
          this.nPC.az(2000L, 2000L);
        }
        if ((nPs) && (this.nPB.fkZ())) {
          this.nPB.az(10000L, 10000L);
        }
        if (this.nPD.fkZ())
        {
          if (!nPs) {
            this.nPD.az(120000L, 120000L);
          }
        }
        else
        {
          if (nPq) {
            break label282;
          }
          this.nPu = true;
          Object localObject1 = Boolean.valueOf(this.nPt.startLeScan(this));
          if ((((Boolean)localObject1).booleanValue()) || (nPq)) {
            break label265;
          }
          int i = 0;
          if ((((Boolean)localObject1).booleanValue()) || (i >= 3) || (nPq)) {
            break;
          }
          int j = i + 1;
          this.nPt.stopLeScan(this);
          ad.e("MicroMsg.exdevice.IBeaconServer", "start IBEACON BLE scan failed,retry no " + j + " time");
          Boolean localBoolean = Boolean.valueOf(this.nPt.startLeScan(this));
          i = j;
          localObject1 = localBoolean;
          if (!localBoolean.booleanValue()) {
            continue;
          }
          nPq = true;
          this.nPr = true;
          ad.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
          i = j;
          localObject1 = localBoolean;
          continue;
        }
        this.nPD.az(1800000L, 1800000L);
      }
      finally {}
    }
    AppMethodBeat.o(22456);
    for (;;)
    {
      return;
      label265:
      this.nPr = true;
      nPq = true;
      ad.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
      label282:
      AppMethodBeat.o(22456);
    }
  }
  
  private void stopScan()
  {
    AppMethodBeat.i(22455);
    this.nPy.clear();
    nPq = false;
    if (!this.nPC.fkZ()) {
      this.nPC.stopTimer();
    }
    if (!this.nPB.fkZ()) {
      this.nPB.stopTimer();
    }
    if (!this.nPA.fkZ()) {
      this.nPA.stopTimer();
    }
    if (!this.nPz.fkZ()) {
      this.nPz.stopTimer();
    }
    if (!this.nPD.fkZ()) {
      this.nPD.stopTimer();
    }
    if ((this.nPr) && (this.nPt != null))
    {
      if (this.nPt != null) {
        this.nPt.stopLeScan(this);
      }
      this.nPr = false;
    }
    AppMethodBeat.o(22455);
  }
  
  public final void WC(String paramString)
  {
    AppMethodBeat.i(22460);
    ad.e("MicroMsg.exdevice.IBeaconServer", "------onScanError------ error code = %s, error msg = %s", new Object[] { Integer.valueOf(-1), paramString });
    AppMethodBeat.o(22460);
  }
  
  public final void a(double paramDouble, c paramc)
  {
    AppMethodBeat.i(22457);
    ad.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback, distance = %f", new Object[] { Double.valueOf(paramDouble) });
    String str2 = com.tencent.mm.plugin.exdevice.k.b.bg(paramc.nPj.nPn.nPO);
    String str1 = str2;
    if (str2.length() >= 32) {
      str1 = str2.substring(0, 8) + "-" + str2.substring(8, 12) + "-" + str2.substring(12, 16) + "-" + str2.substring(16, 20) + "-" + str2.substring(20);
    }
    str2 = str1 + paramc.nPj.nPn.nPP + paramc.nPj.nPn.nPQ;
    if (!this.nPy.containsKey(str2))
    {
      this.nPy.put(str2, Long.valueOf(System.currentTimeMillis()));
      this.nPl.a(paramDouble, paramc);
      int i = paramc.nPj.nPn.nPQ;
      ad.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback,uuid = " + str1 + ",major = " + paramc.nPj.nPn.nPP + ",minor = " + (i & 0xFFFF));
      AppMethodBeat.o(22457);
      return;
    }
    long l1 = ((Long)this.nPy.get(str2)).longValue();
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 500L)
    {
      this.nPy.put(str2, Long.valueOf(l2));
      this.nPl.a(paramDouble, paramc);
    }
    AppMethodBeat.o(22457);
  }
  
  public final void a(final String paramString1, final String paramString2, int paramInt1, final int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22459);
    ad.d("MicroMsg.exdevice.IBeaconServer", "onScanFound, device mac = %s, device name = %s, bluetooth version = %d, rssi = %d, advertisment = %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), com.tencent.mm.plugin.exdevice.k.b.bg(paramArrayOfByte) });
    if (paramInt1 != 0)
    {
      AppMethodBeat.o(22459);
      return;
    }
    paramString2 = new e();
    if (!paramString2.aE(paramArrayOfByte))
    {
      ad.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
      AppMethodBeat.o(22459);
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.exdevice.k.b.bi(paramString2.nPn.nPO);
    if (paramArrayOfByte == null)
    {
      ad.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
      AppMethodBeat.o(22459);
      return;
    }
    if (!this.nPp.contains(paramArrayOfByte))
    {
      ad.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
      AppMethodBeat.o(22459);
      return;
    }
    if (this.nPu) {
      this.nPw = paramString1;
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
    if (!locale.aE(paramArrayOfByte))
    {
      ad.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
      AppMethodBeat.o(22461);
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.exdevice.k.b.bi(locale.nPn.nPO);
    if (paramArrayOfByte == null)
    {
      ad.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
      AppMethodBeat.o(22461);
      return;
    }
    if (!this.nPp.contains(paramArrayOfByte))
    {
      ad.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
      AppMethodBeat.o(22461);
      return;
    }
    if (this.nPu)
    {
      this.nPv = paramInt;
      this.nPx = locale;
      if (this.nPz.fkZ()) {
        this.nPz.az(2000L, 2000L);
      }
      this.nPu = false;
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
  
  public final void yV(int paramInt)
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