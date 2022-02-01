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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(18)
public final class f
  implements BluetoothAdapter.LeScanCallback, b, r
{
  private static boolean nou = false;
  public static boolean now = false;
  public final ao mHandler;
  private String noA;
  private e noB;
  private Map<String, Long> noC;
  private final au noD;
  private final au noE;
  private final au noF;
  private final au noG;
  private final au noH;
  private final b nop;
  private final d nos;
  private final HashSet<UUID> not;
  private boolean nov;
  private BluetoothAdapter nox;
  private boolean noy;
  private int noz;
  
  public f(b paramb)
  {
    AppMethodBeat.i(22454);
    this.nov = false;
    this.noy = true;
    this.noz = 0;
    this.noA = "";
    this.noB = null;
    this.noC = new ConcurrentHashMap();
    this.noD = new au(v.chs().hTd.getSerialTag(), new au.a()
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
    this.noE = new au(v.chs().hTd.getSerialTag(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(22446);
        if (f.f(f.this).size() > 0)
        {
          ac.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now start");
          if (!f.g(f.this).booleanValue()) {
            break label127;
          }
          ac.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan ok");
        }
        for (;;)
        {
          f.iX(ai.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false));
          if (!f.bEn())
          {
            if (!f.h(f.this).eVs()) {
              f.h(f.this).stopTimer();
            }
            if (!f.i(f.this).eVs()) {
              f.i(f.this).stopTimer();
            }
          }
          AppMethodBeat.o(22446);
          return false;
          label127:
          ac.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan fail");
        }
      }
    }, true);
    this.noF = new au(v.chs().hTd.getSerialTag(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(22447);
        if (f.f(f.this).size() > 0)
        {
          ac.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now stop");
          f.j(f.this);
          if (f.i(f.this).eVs()) {
            f.i(f.this).au(2000L, 2000L);
          }
          AppMethodBeat.o(22447);
          return true;
        }
        AppMethodBeat.o(22447);
        return false;
      }
    }, true);
    this.noG = new au(v.chs().hTd.getSerialTag(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(22448);
        ac.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]make isScanning status false");
        f.bIq();
        AppMethodBeat.o(22448);
        return false;
      }
    }, true);
    this.noH = new au(v.chs().hTd.getSerialTag(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(22449);
        ac.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]time out ,let's stop this new method scan");
        f.k(f.this);
        AppMethodBeat.o(22449);
        return false;
      }
    }, true);
    this.not = new HashSet();
    this.nos = new d(this);
    this.nop = paramb;
    this.mHandler = new ao(v.chs().hTd.getSerialTag());
    this.nox = ((BluetoothManager)ai.getContext().getSystemService("bluetooth")).getAdapter();
    AppMethodBeat.o(22454);
  }
  
  private void bIp()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(22456);
        if (this.noG.eVs()) {
          this.noG.au(2000L, 2000L);
        }
        if ((now) && (this.noF.eVs())) {
          this.noF.au(10000L, 10000L);
        }
        if (this.noH.eVs())
        {
          if (!now) {
            this.noH.au(120000L, 120000L);
          }
        }
        else
        {
          if (nou) {
            break label282;
          }
          this.noy = true;
          Object localObject1 = Boolean.valueOf(this.nox.startLeScan(this));
          if ((((Boolean)localObject1).booleanValue()) || (nou)) {
            break label265;
          }
          int i = 0;
          if ((((Boolean)localObject1).booleanValue()) || (i >= 3) || (nou)) {
            break;
          }
          int j = i + 1;
          this.nox.stopLeScan(this);
          ac.e("MicroMsg.exdevice.IBeaconServer", "start IBEACON BLE scan failed,retry no " + j + " time");
          Boolean localBoolean = Boolean.valueOf(this.nox.startLeScan(this));
          i = j;
          localObject1 = localBoolean;
          if (!localBoolean.booleanValue()) {
            continue;
          }
          nou = true;
          this.nov = true;
          ac.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
          i = j;
          localObject1 = localBoolean;
          continue;
        }
        this.noH.au(1800000L, 1800000L);
      }
      finally {}
    }
    AppMethodBeat.o(22456);
    for (;;)
    {
      return;
      label265:
      this.nov = true;
      nou = true;
      ac.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
      label282:
      AppMethodBeat.o(22456);
    }
  }
  
  private void stopScan()
  {
    AppMethodBeat.i(22455);
    this.noC.clear();
    nou = false;
    if (!this.noG.eVs()) {
      this.noG.stopTimer();
    }
    if (!this.noF.eVs()) {
      this.noF.stopTimer();
    }
    if (!this.noE.eVs()) {
      this.noE.stopTimer();
    }
    if (!this.noD.eVs()) {
      this.noD.stopTimer();
    }
    if (!this.noH.eVs()) {
      this.noH.stopTimer();
    }
    if ((this.nov) && (this.nox != null))
    {
      if (this.nox != null) {
        this.nox.stopLeScan(this);
      }
      this.nov = false;
    }
    AppMethodBeat.o(22455);
  }
  
  public final void Tc(String paramString)
  {
    AppMethodBeat.i(22460);
    ac.e("MicroMsg.exdevice.IBeaconServer", "------onScanError------ error code = %s, error msg = %s", new Object[] { Integer.valueOf(-1), paramString });
    AppMethodBeat.o(22460);
  }
  
  public final void a(double paramDouble, c paramc)
  {
    AppMethodBeat.i(22457);
    ac.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback, distance = %f", new Object[] { Double.valueOf(paramDouble) });
    String str2 = com.tencent.mm.plugin.exdevice.k.b.bd(paramc.non.nor.noS);
    String str1 = str2;
    if (str2.length() >= 32) {
      str1 = str2.substring(0, 8) + "-" + str2.substring(8, 12) + "-" + str2.substring(12, 16) + "-" + str2.substring(16, 20) + "-" + str2.substring(20);
    }
    str2 = str1 + paramc.non.nor.noT + paramc.non.nor.noU;
    if (!this.noC.containsKey(str2))
    {
      this.noC.put(str2, Long.valueOf(System.currentTimeMillis()));
      this.nop.a(paramDouble, paramc);
      int i = paramc.non.nor.noU;
      ac.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback,uuid = " + str1 + ",major = " + paramc.non.nor.noT + ",minor = " + (i & 0xFFFF));
      AppMethodBeat.o(22457);
      return;
    }
    long l1 = ((Long)this.noC.get(str2)).longValue();
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 500L)
    {
      this.noC.put(str2, Long.valueOf(l2));
      this.nop.a(paramDouble, paramc);
    }
    AppMethodBeat.o(22457);
  }
  
  public final void a(final String paramString1, final String paramString2, int paramInt1, final int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22459);
    ac.d("MicroMsg.exdevice.IBeaconServer", "onScanFound, device mac = %s, device name = %s, bluetooth version = %d, rssi = %d, advertisment = %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), com.tencent.mm.plugin.exdevice.k.b.bd(paramArrayOfByte) });
    if (paramInt1 != 0)
    {
      AppMethodBeat.o(22459);
      return;
    }
    paramString2 = new e();
    if (!paramString2.aE(paramArrayOfByte))
    {
      ac.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
      AppMethodBeat.o(22459);
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.exdevice.k.b.bf(paramString2.nor.noS);
    if (paramArrayOfByte == null)
    {
      ac.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
      AppMethodBeat.o(22459);
      return;
    }
    if (!this.not.contains(paramArrayOfByte))
    {
      ac.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
      AppMethodBeat.o(22459);
      return;
    }
    if (this.noy) {
      this.noA = paramString1;
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
      ac.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
      AppMethodBeat.o(22461);
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.exdevice.k.b.bf(locale.nor.noS);
    if (paramArrayOfByte == null)
    {
      ac.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
      AppMethodBeat.o(22461);
      return;
    }
    if (!this.not.contains(paramArrayOfByte))
    {
      ac.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
      AppMethodBeat.o(22461);
      return;
    }
    if (this.noy)
    {
      this.noz = paramInt;
      this.noB = locale;
      if (this.noD.eVs()) {
        this.noD.au(2000L, 2000L);
      }
      this.noy = false;
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
  
  public final void yl(int paramInt)
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