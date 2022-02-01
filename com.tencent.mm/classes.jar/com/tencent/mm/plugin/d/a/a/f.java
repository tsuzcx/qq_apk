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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(18)
public final class f
  implements BluetoothAdapter.LeScanCallback, b, r
{
  private static boolean nUW = false;
  public static boolean nUY = false;
  public final aq mHandler;
  private final b nUR;
  private final d nUU;
  private final HashSet<UUID> nUV;
  private boolean nUX;
  private BluetoothAdapter nUZ;
  private boolean nVa;
  private int nVb;
  private String nVc;
  private e nVd;
  private Map<String, Long> nVe;
  private final aw nVf;
  private final aw nVg;
  private final aw nVh;
  private final aw nVi;
  private final aw nVj;
  
  public f(b paramb)
  {
    AppMethodBeat.i(22454);
    this.nUX = false;
    this.nVa = true;
    this.nVb = 0;
    this.nVc = "";
    this.nVd = null;
    this.nVe = new ConcurrentHashMap();
    this.nVf = new aw(v.cnm().ipo.getSerialTag(), new aw.a()
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
    this.nVg = new aw(v.cnm().ipo.getSerialTag(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(22446);
        if (f.f(f.this).size() > 0)
        {
          ae.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now start");
          if (!f.g(f.this).booleanValue()) {
            break label127;
          }
          ae.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan ok");
        }
        for (;;)
        {
          f.jf(ak.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false));
          if (!f.bJu())
          {
            if (!f.h(f.this).foU()) {
              f.h(f.this).stopTimer();
            }
            if (!f.i(f.this).foU()) {
              f.i(f.this).stopTimer();
            }
          }
          AppMethodBeat.o(22446);
          return false;
          label127:
          ae.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan fail");
        }
      }
    }, true);
    this.nVh = new aw(v.cnm().ipo.getSerialTag(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(22447);
        if (f.f(f.this).size() > 0)
        {
          ae.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now stop");
          f.j(f.this);
          if (f.i(f.this).foU()) {
            f.i(f.this).ay(2000L, 2000L);
          }
          AppMethodBeat.o(22447);
          return true;
        }
        AppMethodBeat.o(22447);
        return false;
      }
    }, true);
    this.nVi = new aw(v.cnm().ipo.getSerialTag(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(22448);
        ae.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]make isScanning status false");
        f.bNB();
        AppMethodBeat.o(22448);
        return false;
      }
    }, true);
    this.nVj = new aw(v.cnm().ipo.getSerialTag(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(22449);
        ae.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]time out ,let's stop this new method scan");
        f.k(f.this);
        AppMethodBeat.o(22449);
        return false;
      }
    }, true);
    this.nUV = new HashSet();
    this.nUU = new d(this);
    this.nUR = paramb;
    this.mHandler = new aq(v.cnm().ipo.getSerialTag());
    this.nUZ = ((BluetoothManager)ak.getContext().getSystemService("bluetooth")).getAdapter();
    AppMethodBeat.o(22454);
  }
  
  private void bNA()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(22456);
        if (this.nVi.foU()) {
          this.nVi.ay(2000L, 2000L);
        }
        if ((nUY) && (this.nVh.foU())) {
          this.nVh.ay(10000L, 10000L);
        }
        if (this.nVj.foU())
        {
          if (!nUY) {
            this.nVj.ay(120000L, 120000L);
          }
        }
        else
        {
          if (nUW) {
            break label282;
          }
          this.nVa = true;
          Object localObject1 = Boolean.valueOf(this.nUZ.startLeScan(this));
          if ((((Boolean)localObject1).booleanValue()) || (nUW)) {
            break label265;
          }
          int i = 0;
          if ((((Boolean)localObject1).booleanValue()) || (i >= 3) || (nUW)) {
            break;
          }
          int j = i + 1;
          this.nUZ.stopLeScan(this);
          ae.e("MicroMsg.exdevice.IBeaconServer", "start IBEACON BLE scan failed,retry no " + j + " time");
          Boolean localBoolean = Boolean.valueOf(this.nUZ.startLeScan(this));
          i = j;
          localObject1 = localBoolean;
          if (!localBoolean.booleanValue()) {
            continue;
          }
          nUW = true;
          this.nUX = true;
          ae.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
          i = j;
          localObject1 = localBoolean;
          continue;
        }
        this.nVj.ay(1800000L, 1800000L);
      }
      finally {}
    }
    AppMethodBeat.o(22456);
    for (;;)
    {
      return;
      label265:
      this.nUX = true;
      nUW = true;
      ae.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
      label282:
      AppMethodBeat.o(22456);
    }
  }
  
  private void stopScan()
  {
    AppMethodBeat.i(22455);
    this.nVe.clear();
    nUW = false;
    if (!this.nVi.foU()) {
      this.nVi.stopTimer();
    }
    if (!this.nVh.foU()) {
      this.nVh.stopTimer();
    }
    if (!this.nVg.foU()) {
      this.nVg.stopTimer();
    }
    if (!this.nVf.foU()) {
      this.nVf.stopTimer();
    }
    if (!this.nVj.foU()) {
      this.nVj.stopTimer();
    }
    if ((this.nUX) && (this.nUZ != null))
    {
      if (this.nUZ != null) {
        this.nUZ.stopLeScan(this);
      }
      this.nUX = false;
    }
    AppMethodBeat.o(22455);
  }
  
  public final void Xo(String paramString)
  {
    AppMethodBeat.i(22460);
    ae.e("MicroMsg.exdevice.IBeaconServer", "------onScanError------ error code = %s, error msg = %s", new Object[] { Integer.valueOf(-1), paramString });
    AppMethodBeat.o(22460);
  }
  
  public final void a(double paramDouble, c paramc)
  {
    AppMethodBeat.i(22457);
    ae.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback, distance = %f", new Object[] { Double.valueOf(paramDouble) });
    String str2 = com.tencent.mm.plugin.exdevice.k.b.bf(paramc.nUP.nUT.nVu);
    String str1 = str2;
    if (str2.length() >= 32) {
      str1 = str2.substring(0, 8) + "-" + str2.substring(8, 12) + "-" + str2.substring(12, 16) + "-" + str2.substring(16, 20) + "-" + str2.substring(20);
    }
    str2 = str1 + paramc.nUP.nUT.nVv + paramc.nUP.nUT.nVw;
    if (!this.nVe.containsKey(str2))
    {
      this.nVe.put(str2, Long.valueOf(System.currentTimeMillis()));
      this.nUR.a(paramDouble, paramc);
      int i = paramc.nUP.nUT.nVw;
      ae.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback,uuid = " + str1 + ",major = " + paramc.nUP.nUT.nVv + ",minor = " + (i & 0xFFFF));
      AppMethodBeat.o(22457);
      return;
    }
    long l1 = ((Long)this.nVe.get(str2)).longValue();
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 500L)
    {
      this.nVe.put(str2, Long.valueOf(l2));
      this.nUR.a(paramDouble, paramc);
    }
    AppMethodBeat.o(22457);
  }
  
  public final void a(final String paramString1, final String paramString2, int paramInt1, final int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22459);
    ae.d("MicroMsg.exdevice.IBeaconServer", "onScanFound, device mac = %s, device name = %s, bluetooth version = %d, rssi = %d, advertisment = %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), com.tencent.mm.plugin.exdevice.k.b.bf(paramArrayOfByte) });
    if (paramInt1 != 0)
    {
      AppMethodBeat.o(22459);
      return;
    }
    paramString2 = new e();
    if (!paramString2.aE(paramArrayOfByte))
    {
      ae.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
      AppMethodBeat.o(22459);
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.exdevice.k.b.bh(paramString2.nUT.nVu);
    if (paramArrayOfByte == null)
    {
      ae.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
      AppMethodBeat.o(22459);
      return;
    }
    if (!this.nUV.contains(paramArrayOfByte))
    {
      ae.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
      AppMethodBeat.o(22459);
      return;
    }
    if (this.nVa) {
      this.nVc = paramString1;
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
      ae.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
      AppMethodBeat.o(22461);
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.exdevice.k.b.bh(locale.nUT.nVu);
    if (paramArrayOfByte == null)
    {
      ae.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
      AppMethodBeat.o(22461);
      return;
    }
    if (!this.nUV.contains(paramArrayOfByte))
    {
      ae.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
      AppMethodBeat.o(22461);
      return;
    }
    if (this.nVa)
    {
      this.nVb = paramInt;
      this.nVd = locale;
      if (this.nVf.foU()) {
        this.nVf.ay(2000L, 2000L);
      }
      this.nVa = false;
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
  
  public final void ze(int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.a.f
 * JD-Core Version:    0.7.0.1
 */