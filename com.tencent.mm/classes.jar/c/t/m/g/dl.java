package c.t.m.g;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanFilter.Builder;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.bluetooth.le.ScanSettings.Builder;
import android.content.Context;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"NewApi"})
public final class dl
  extends ScanCallback
{
  final Context a;
  BluetoothManager b;
  BluetoothAdapter c;
  BluetoothLeScanner d;
  List<dz> e;
  boolean f;
  byte[] g = new byte[0];
  private ScanSettings h;
  private List<ScanFilter> i;
  private List<dz> j;
  private String[] k;
  
  public dl(Context paramContext)
  {
    this.a = paramContext;
    this.e = new LinkedList();
    this.j = new LinkedList();
    this.k = "AB8190D5-D11E-4941-ACC4-42F30510B408,FDA50693-A4E2-4FB1-AFCF-C6EB07647825".split(",");
    this.b = ((BluetoothManager)this.a.getSystemService("bluetooth"));
    this.h = new ScanSettings.Builder().setScanMode(1).build();
    this.i = new ArrayList();
    paramContext = this.k;
    int n = paramContext.length;
    int m = 0;
    while (m < n)
    {
      Object localObject = paramContext[m];
      List localList = this.i;
      byte[] arrayOfByte = new byte[23];
      byte[] tmp128_126 = arrayOfByte;
      tmp128_126[0] = 0;
      byte[] tmp133_128 = tmp128_126;
      tmp133_128[1] = 0;
      byte[] tmp138_133 = tmp133_128;
      tmp138_133[2] = 0;
      byte[] tmp143_138 = tmp138_133;
      tmp143_138[3] = 0;
      byte[] tmp148_143 = tmp143_138;
      tmp148_143[4] = 0;
      byte[] tmp153_148 = tmp148_143;
      tmp153_148[5] = 0;
      byte[] tmp158_153 = tmp153_148;
      tmp158_153[6] = 0;
      byte[] tmp164_158 = tmp158_153;
      tmp164_158[7] = 0;
      byte[] tmp170_164 = tmp164_158;
      tmp170_164[8] = 0;
      byte[] tmp176_170 = tmp170_164;
      tmp176_170[9] = 0;
      byte[] tmp182_176 = tmp176_170;
      tmp182_176[10] = 0;
      byte[] tmp188_182 = tmp182_176;
      tmp188_182[11] = 0;
      byte[] tmp194_188 = tmp188_182;
      tmp194_188[12] = 0;
      byte[] tmp200_194 = tmp194_188;
      tmp200_194[13] = 0;
      byte[] tmp206_200 = tmp200_194;
      tmp206_200[14] = 0;
      byte[] tmp212_206 = tmp206_200;
      tmp212_206[15] = 0;
      byte[] tmp218_212 = tmp212_206;
      tmp218_212[16] = 0;
      byte[] tmp224_218 = tmp218_212;
      tmp224_218[17] = 0;
      byte[] tmp230_224 = tmp224_218;
      tmp230_224[18] = 0;
      byte[] tmp236_230 = tmp230_224;
      tmp236_230[19] = 0;
      byte[] tmp242_236 = tmp236_230;
      tmp242_236[20] = 0;
      byte[] tmp248_242 = tmp242_236;
      tmp248_242[21] = 0;
      byte[] tmp254_248 = tmp248_242;
      tmp254_248[22] = 0;
      tmp254_248;
      System.arraycopy(a(localObject.replace("-", "")), 0, arrayOfByte, 2, 16);
      localList.add(new ScanFilter.Builder().setManufacturerData(76, arrayOfByte, new byte[] { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0 }).build());
      m += 1;
    }
  }
  
  private static byte[] a(String paramString)
  {
    int n = paramString.length();
    byte[] arrayOfByte = new byte[n / 2];
    int m = 0;
    while (m < n)
    {
      arrayOfByte[(m / 2)] = ((byte)((Character.digit(paramString.charAt(m), 16) << 4) + Character.digit(paramString.charAt(m + 1), 16)));
      m += 2;
    }
    return arrayOfByte;
  }
  
  public final List<dz> a()
  {
    synchronized (this.e)
    {
      new StringBuilder("getBeacon:").append(Thread.currentThread().getName());
      Iterator localIterator = this.e.iterator();
      this.j.clear();
      while (localIterator.hasNext())
      {
        dz localdz = (dz)localIterator.next();
        j.a("TxBluetoothProvider", 6, localdz.toString());
        if (System.currentTimeMillis() - localdz.a <= 5000L)
        {
          localdz.toString();
          this.j.add((dz)localdz.clone());
        }
      }
    }
    this.e.clear();
    List localList2 = this.j;
    return localList2;
  }
  
  final int b()
  {
    try
    {
      if (!this.a.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
        return -1;
      }
      if ((this.c != null) && (this.c.isEnabled()) && (this.d != null))
      {
        this.d.startScan(this.i, this.h, this);
        this.f = true;
        return 0;
      }
      return -2;
    }
    catch (Throwable localThrowable) {}
    return -3;
  }
  
  public final void onBatchScanResults(List<ScanResult> paramList) {}
  
  public final void onScanFailed(int paramInt) {}
  
  public final void onScanResult(int paramInt, ScanResult paramScanResult)
  {
    new StringBuilder("onScanResult:").append(Thread.currentThread().getName());
    if (paramScanResult == null) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject1 = paramScanResult.getDevice();
        paramInt = paramScanResult.getRssi();
        paramScanResult = paramScanResult.getScanRecord().getBytes();
        if ((paramScanResult == null) || (paramScanResult.length < 30)) {
          continue;
        }
        localObject1 = dz.a((BluetoothDevice)localObject1, paramInt, paramScanResult);
        paramScanResult = this.e;
        if (localObject1 != null) {}
        try
        {
          this.e.add(localObject1);
          return;
        }
        finally {}
        return;
      }
      catch (Throwable paramScanResult) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     c.t.m.g.dl
 * JD-Core Version:    0.7.0.1
 */