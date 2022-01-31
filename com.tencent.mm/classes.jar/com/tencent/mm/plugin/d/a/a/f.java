package com.tencent.mm.plugin.d.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.r;
import com.tencent.mm.plugin.exdevice.service.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(18)
public final class f
  implements BluetoothAdapter.LeScanCallback, b, r
{
  private static boolean jNf = false;
  public static boolean jNh = false;
  private final b jNa;
  private final d jNd;
  private final HashSet<UUID> jNe;
  private boolean jNg;
  private BluetoothAdapter jNi;
  private boolean jNj;
  private int jNk;
  private String jNl;
  private e jNm;
  private Map<String, Long> jNn;
  private final ap jNo;
  private final ap jNp;
  private final ap jNq;
  private final ap jNr;
  private final ap jNs;
  public final ak mHandler;
  
  public f(b paramb)
  {
    AppMethodBeat.i(18343);
    this.jNg = false;
    this.jNj = true;
    this.jNk = 0;
    this.jNl = "";
    this.jNm = null;
    this.jNn = new ConcurrentHashMap();
    this.jNo = new ap(v.bqB().fPW.oNc.getLooper(), new f.1(this), true);
    this.jNp = new ap(v.bqB().fPW.oNc.getLooper(), new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(18335);
        if (f.f(f.this).size() > 0)
        {
          ab.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now start");
          if (!f.g(f.this).booleanValue()) {
            break label127;
          }
          ab.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan ok");
        }
        for (;;)
        {
          f.fI(ah.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false));
          if (!f.jNh)
          {
            if (!f.h(f.this).dtj()) {
              f.h(f.this).stopTimer();
            }
            if (!f.i(f.this).dtj()) {
              f.i(f.this).stopTimer();
            }
          }
          AppMethodBeat.o(18335);
          return false;
          label127:
          ab.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan fail");
        }
      }
    }, true);
    this.jNq = new ap(v.bqB().fPW.oNc.getLooper(), new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(18336);
        if (f.f(f.this).size() > 0)
        {
          ab.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now stop");
          f.j(f.this);
          if (f.i(f.this).dtj()) {
            f.i(f.this).ag(2000L, 2000L);
          }
          AppMethodBeat.o(18336);
          return true;
        }
        AppMethodBeat.o(18336);
        return false;
      }
    }, true);
    this.jNr = new ap(v.bqB().fPW.oNc.getLooper(), new f.4(this), true);
    this.jNs = new ap(v.bqB().fPW.oNc.getLooper(), new f.5(this), true);
    this.jNe = new HashSet();
    this.jNd = new d(this);
    this.jNa = paramb;
    this.mHandler = new ak(v.bqB().fPW.oNc.getLooper());
    this.jNi = ((BluetoothManager)ah.getContext().getSystemService("bluetooth")).getAdapter();
    AppMethodBeat.o(18343);
  }
  
  private void aVP()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(18345);
        if (this.jNr.dtj()) {
          this.jNr.ag(2000L, 2000L);
        }
        if ((jNh) && (this.jNq.dtj())) {
          this.jNq.ag(10000L, 10000L);
        }
        if (this.jNs.dtj())
        {
          if (!jNh) {
            this.jNs.ag(120000L, 120000L);
          }
        }
        else
        {
          if (jNf) {
            break label281;
          }
          this.jNj = true;
          Object localObject1 = Boolean.valueOf(this.jNi.startLeScan(this));
          if ((((Boolean)localObject1).booleanValue()) || (jNf)) {
            break label264;
          }
          int i = 0;
          if ((((Boolean)localObject1).booleanValue()) || (i >= 3) || (jNf)) {
            break;
          }
          int j = i + 1;
          this.jNi.stopLeScan(this);
          ab.e("MicroMsg.exdevice.IBeaconServer", "start IBEACON BLE scan failed,retry no " + j + " time");
          Boolean localBoolean = Boolean.valueOf(this.jNi.startLeScan(this));
          i = j;
          localObject1 = localBoolean;
          if (!localBoolean.booleanValue()) {
            continue;
          }
          jNf = true;
          this.jNg = true;
          ab.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
          i = j;
          localObject1 = localBoolean;
          continue;
        }
        this.jNs.ag(1800000L, 1800000L);
      }
      finally {}
    }
    AppMethodBeat.o(18345);
    for (;;)
    {
      return;
      label264:
      this.jNg = true;
      jNf = true;
      ab.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
      label281:
      AppMethodBeat.o(18345);
    }
  }
  
  private void stopScan()
  {
    AppMethodBeat.i(18344);
    this.jNn.clear();
    jNf = false;
    if (!this.jNr.dtj()) {
      this.jNr.stopTimer();
    }
    if (!this.jNq.dtj()) {
      this.jNq.stopTimer();
    }
    if (!this.jNp.dtj()) {
      this.jNp.stopTimer();
    }
    if (!this.jNo.dtj()) {
      this.jNo.stopTimer();
    }
    if (!this.jNs.dtj()) {
      this.jNs.stopTimer();
    }
    if ((this.jNg) && (this.jNi != null))
    {
      if (this.jNi != null) {
        this.jNi.stopLeScan(this);
      }
      this.jNg = false;
    }
    AppMethodBeat.o(18344);
  }
  
  public final void GE(String paramString)
  {
    AppMethodBeat.i(18349);
    ab.e("MicroMsg.exdevice.IBeaconServer", "------onScanError------ error code = %s, error msg = %s", new Object[] { Integer.valueOf(-1), paramString });
    AppMethodBeat.o(18349);
  }
  
  public final void a(double paramDouble, c paramc)
  {
    AppMethodBeat.i(18346);
    ab.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback, distance = %f", new Object[] { Double.valueOf(paramDouble) });
    String str2 = com.tencent.mm.plugin.exdevice.j.b.aO(paramc.jMY.jNc.jND);
    String str1 = str2;
    if (str2.length() >= 32) {
      str1 = str2.substring(0, 8) + "-" + str2.substring(8, 12) + "-" + str2.substring(12, 16) + "-" + str2.substring(16, 20) + "-" + str2.substring(20);
    }
    str2 = str1 + paramc.jMY.jNc.jNE + paramc.jMY.jNc.jNF;
    if (!this.jNn.containsKey(str2))
    {
      this.jNn.put(str2, Long.valueOf(System.currentTimeMillis()));
      this.jNa.a(paramDouble, paramc);
      int i = paramc.jMY.jNc.jNF;
      ab.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback,uuid = " + str1 + ",major = " + paramc.jMY.jNc.jNE + ",minor = " + (i & 0xFFFF));
      AppMethodBeat.o(18346);
      return;
    }
    long l1 = ((Long)this.jNn.get(str2)).longValue();
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 500L)
    {
      this.jNn.put(str2, Long.valueOf(l2));
      this.jNa.a(paramDouble, paramc);
    }
    AppMethodBeat.o(18346);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18348);
    ab.d("MicroMsg.exdevice.IBeaconServer", "onScanFound, device mac = %s, device name = %s, bluetooth version = %d, rssi = %d, advertisment = %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), com.tencent.mm.plugin.exdevice.j.b.aO(paramArrayOfByte) });
    if (paramInt1 != 0)
    {
      AppMethodBeat.o(18348);
      return;
    }
    paramString2 = new e();
    if (!paramString2.aq(paramArrayOfByte))
    {
      ab.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
      AppMethodBeat.o(18348);
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.exdevice.j.b.aQ(paramString2.jNc.jND);
    if (paramArrayOfByte == null)
    {
      ab.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
      AppMethodBeat.o(18348);
      return;
    }
    if (!this.jNe.contains(paramArrayOfByte))
    {
      ab.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
      AppMethodBeat.o(18348);
      return;
    }
    if (this.jNj) {
      this.jNl = paramString1;
    }
    this.mHandler.post(new f.8(this, paramInt2, paramString1, paramString2));
    AppMethodBeat.o(18348);
  }
  
  public final void onLeScan(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18350);
    e locale = new e();
    if (!locale.aq(paramArrayOfByte))
    {
      ab.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
      AppMethodBeat.o(18350);
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.exdevice.j.b.aQ(locale.jNc.jND);
    if (paramArrayOfByte == null)
    {
      ab.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
      AppMethodBeat.o(18350);
      return;
    }
    if (!this.jNe.contains(paramArrayOfByte))
    {
      ab.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
      AppMethodBeat.o(18350);
      return;
    }
    if (this.jNj)
    {
      this.jNk = paramInt;
      this.jNm = locale;
      if (this.jNo.dtj()) {
        this.jNo.ag(2000L, 2000L);
      }
      this.jNj = false;
    }
    this.mHandler.post(new f.9(this, paramInt, paramBluetoothDevice, locale));
    AppMethodBeat.o(18350);
  }
  
  public final void rN(int paramInt)
  {
    AppMethodBeat.i(18347);
    if (paramInt != 0)
    {
      AppMethodBeat.o(18347);
      return;
    }
    stopScan();
    AppMethodBeat.o(18347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.a.f
 * JD-Core Version:    0.7.0.1
 */