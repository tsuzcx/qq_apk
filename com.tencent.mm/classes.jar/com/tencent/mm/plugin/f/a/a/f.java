package com.tencent.mm.plugin.f.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.HandlerThread;
import com.tencent.mm.plugin.exdevice.service.r;
import com.tencent.mm.plugin.exdevice.service.v;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(18)
public final class f
  implements BluetoothAdapter.LeScanCallback, r, b
{
  private static boolean hTl = false;
  public static boolean hTn = false;
  private final b hTg;
  private final d hTj;
  private final HashSet<UUID> hTk;
  private boolean hTm = false;
  private BluetoothAdapter hTo;
  private boolean hTp = true;
  private int hTq = 0;
  private String hTr = "";
  private e hTs = null;
  private Map<String, Long> hTt = new ConcurrentHashMap();
  private final am hTu = new am(v.aMo().eAg.mnU.getLooper(), new f.1(this), true);
  private final am hTv = new am(v.aMo().eAg.mnU.getLooper(), new f.2(this), true);
  private final am hTw = new am(v.aMo().eAg.mnU.getLooper(), new f.3(this), true);
  private final am hTx = new am(v.aMo().eAg.mnU.getLooper(), new f.4(this), true);
  private final am hTy = new am(v.aMo().eAg.mnU.getLooper(), new f.5(this), true);
  public final ah mHandler;
  
  public f(b paramb)
  {
    if (paramb == null) {
      throw new NullPointerException("aCallback is null");
    }
    this.hTk = new HashSet();
    this.hTj = new d(this);
    this.hTg = paramb;
    this.mHandler = new ah(v.aMo().eAg.mnU.getLooper());
    this.hTo = ((BluetoothManager)ae.getContext().getSystemService("bluetooth")).getAdapter();
  }
  
  private void awl()
  {
    this.hTt.clear();
    hTl = false;
    if (!this.hTx.crl()) {
      this.hTx.stopTimer();
    }
    if (!this.hTw.crl()) {
      this.hTw.stopTimer();
    }
    if (!this.hTv.crl()) {
      this.hTv.stopTimer();
    }
    if (!this.hTu.crl()) {
      this.hTu.stopTimer();
    }
    if (!this.hTy.crl()) {
      this.hTy.stopTimer();
    }
    if ((this.hTm) && (this.hTo != null))
    {
      this.hTo.stopLeScan(this);
      this.hTm = false;
    }
  }
  
  private void awm()
  {
    for (;;)
    {
      try
      {
        if (this.hTx.crl()) {
          this.hTx.S(2000L, 2000L);
        }
        if ((hTn) && (this.hTw.crl())) {
          this.hTw.S(10000L, 10000L);
        }
        if (this.hTy.crl())
        {
          if (!hTn) {
            this.hTy.S(120000L, 120000L);
          }
        }
        else
        {
          if (hTl) {
            break label267;
          }
          this.hTp = true;
          Object localObject1 = Boolean.valueOf(this.hTo.startLeScan(this));
          if ((((Boolean)localObject1).booleanValue()) || (hTl)) {
            break;
          }
          int i = 0;
          if ((((Boolean)localObject1).booleanValue()) || (i >= 3) || (hTl)) {
            break label267;
          }
          int j = i + 1;
          this.hTo.stopLeScan(this);
          y.e("MicroMsg.exdevice.IBeaconServer", "start IBEACON BLE scan failed,retry no " + j + " time");
          Boolean localBoolean = Boolean.valueOf(this.hTo.startLeScan(this));
          i = j;
          localObject1 = localBoolean;
          if (!localBoolean.booleanValue()) {
            continue;
          }
          hTl = true;
          this.hTm = true;
          y.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
          i = j;
          localObject1 = localBoolean;
          continue;
        }
        this.hTy.S(1800000L, 1800000L);
      }
      finally {}
    }
    this.hTm = true;
    hTl = true;
    y.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
    label267:
  }
  
  public final void a(double paramDouble, c paramc)
  {
    y.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback, distance = %f", new Object[] { Double.valueOf(paramDouble) });
    String str2 = com.tencent.mm.plugin.exdevice.j.b.aq(paramc.hTe.hTi.hTJ);
    String str1 = str2;
    if (str2.length() >= 32) {
      str1 = str2.substring(0, 8) + "-" + str2.substring(8, 12) + "-" + str2.substring(12, 16) + "-" + str2.substring(16, 20) + "-" + str2.substring(20);
    }
    str2 = str1 + paramc.hTe.hTi.hTK + paramc.hTe.hTi.hTL;
    if (!this.hTt.containsKey(str2))
    {
      this.hTt.put(str2, Long.valueOf(System.currentTimeMillis()));
      this.hTg.a(paramDouble, paramc);
      int i = paramc.hTe.hTi.hTL;
      y.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback,uuid = " + str1 + ",major = " + paramc.hTe.hTi.hTK + ",minor = " + (i & 0xFFFF));
    }
    long l1;
    long l2;
    do
    {
      return;
      l1 = ((Long)this.hTt.get(str2)).longValue();
      l2 = System.currentTimeMillis();
    } while (l2 - l1 <= 500L);
    this.hTt.put(str2, Long.valueOf(l2));
    this.hTg.a(paramDouble, paramc);
  }
  
  public final void a(final String paramString1, final String paramString2, int paramInt1, final int paramInt2, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.exdevice.IBeaconServer", "onScanFound, device mac = %s, device name = %s, bluetooth version = %d, rssi = %d, advertisment = %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), com.tencent.mm.plugin.exdevice.j.b.aq(paramArrayOfByte) });
    if (paramInt1 != 0) {
      return;
    }
    paramString2 = new e();
    if (!paramString2.X(paramArrayOfByte))
    {
      y.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.exdevice.j.b.as(paramString2.hTi.hTJ);
    if (paramArrayOfByte == null)
    {
      y.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
      return;
    }
    if (!this.hTk.contains(paramArrayOfByte))
    {
      y.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
      return;
    }
    if (this.hTp) {
      this.hTr = paramString1;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        f.d(f.this).a(paramInt2, paramString1, paramString2);
      }
    });
  }
  
  public final void nZ(int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    awl();
  }
  
  public final void onLeScan(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    e locale = new e();
    if (!locale.X(paramArrayOfByte))
    {
      y.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.exdevice.j.b.as(locale.hTi.hTJ);
    if (paramArrayOfByte == null)
    {
      y.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
      return;
    }
    if (!this.hTk.contains(paramArrayOfByte))
    {
      y.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
      return;
    }
    if (this.hTp)
    {
      this.hTq = paramInt;
      this.hTs = locale;
      if (this.hTu.crl()) {
        this.hTu.S(2000L, 2000L);
      }
      this.hTp = false;
    }
    this.mHandler.post(new f.9(this, paramInt, paramBluetoothDevice, locale));
  }
  
  public final void xM(String paramString)
  {
    y.e("MicroMsg.exdevice.IBeaconServer", "------onScanError------ error code = %s, error msg = %s", new Object[] { Integer.valueOf(-1), paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.a.f
 * JD-Core Version:    0.7.0.1
 */