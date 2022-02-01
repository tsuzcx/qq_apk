package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.annotation.TargetApi;
import android.bluetooth.le.ScanRecord;
import android.os.ParcelUuid;
import android.support.v4.e.a;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class f
{
  private final int kKa;
  public final List<ParcelUuid> kKb;
  public final SparseArray<byte[]> kKc;
  public final Map<ParcelUuid, byte[]> kKd;
  private final int kKe;
  final byte[] kKf;
  public final String mDeviceName;
  
  @TargetApi(21)
  f(ScanRecord paramScanRecord)
  {
    AppMethodBeat.i(144632);
    this.kKb = paramScanRecord.getServiceUuids();
    this.kKc = paramScanRecord.getManufacturerSpecificData();
    this.kKd = paramScanRecord.getServiceData();
    this.mDeviceName = paramScanRecord.getDeviceName();
    this.kKa = paramScanRecord.getAdvertiseFlags();
    this.kKe = paramScanRecord.getTxPowerLevel();
    this.kKf = paramScanRecord.getBytes();
    AppMethodBeat.o(144632);
  }
  
  private f(List<ParcelUuid> paramList, SparseArray<byte[]> paramSparseArray, Map<ParcelUuid, byte[]> paramMap, int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte)
  {
    this.kKb = paramList;
    this.kKc = paramSparseArray;
    this.kKd = paramMap;
    this.mDeviceName = paramString;
    this.kKa = paramInt1;
    this.kKe = paramInt2;
    this.kKf = paramArrayOfByte;
  }
  
  private static <T> String J(Map<T, byte[]> paramMap)
  {
    AppMethodBeat.i(144638);
    if (paramMap == null)
    {
      AppMethodBeat.o(144638);
      return "null";
    }
    if (paramMap.isEmpty())
    {
      AppMethodBeat.o(144638);
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('{');
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = ((Map.Entry)localIterator.next()).getKey();
      localStringBuilder.append(localObject).append("=").append(Arrays.toString((byte[])paramMap.get(localObject)));
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append('}');
    paramMap = localStringBuilder.toString();
    AppMethodBeat.o(144638);
    return paramMap;
  }
  
  private static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, List<ParcelUuid> paramList)
  {
    AppMethodBeat.i(144635);
    while (paramInt2 > 0)
    {
      paramList.add(c.ar(r(paramArrayOfByte, paramInt1, paramInt3)));
      paramInt2 -= paramInt3;
      paramInt1 += paramInt3;
    }
    AppMethodBeat.o(144635);
    return paramInt1;
  }
  
  public static f as(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(144633);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(144633);
      return null;
    }
    int k = 0;
    ArrayList localArrayList2 = new ArrayList();
    SparseArray localSparseArray = new SparseArray();
    a locala = new a();
    int i = -2147483648;
    Object localObject1 = null;
    int j = -1;
    int m;
    try
    {
      if (k >= paramArrayOfByte.length) {
        break label377;
      }
      int n = k + 1;
      k = paramArrayOfByte[k] & 0xFF;
      if (k == 0) {
        break label377;
      }
      k -= 1;
      m = n + 1;
      switch (paramArrayOfByte[n] & 0xFF)
      {
      case 2: 
      case 3: 
        a(paramArrayOfByte, m, k, 2, localArrayList2);
      }
    }
    catch (Exception localException)
    {
      new StringBuilder("unable to parse scan record: ").append(Arrays.toString(paramArrayOfByte));
      paramArrayOfByte = new f(null, null, null, -1, -2147483648, null, paramArrayOfByte);
      AppMethodBeat.o(144633);
      return paramArrayOfByte;
    }
    a(paramArrayOfByte, m, k, 4, localArrayList2);
    break label422;
    a(paramArrayOfByte, m, k, 16, localArrayList2);
    break label422;
    Object localObject2 = new String(r(paramArrayOfByte, m, k));
    break label422;
    locala.put(c.ar(r(paramArrayOfByte, m, 2)), r(paramArrayOfByte, m + 2, k - 2));
    break label422;
    localSparseArray.put(((paramArrayOfByte[(m + 1)] & 0xFF) << 8) + (paramArrayOfByte[m] & 0xFF), r(paramArrayOfByte, m + 2, k - 2));
    break label422;
    label377:
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2.isEmpty()) {
      localArrayList1 = null;
    }
    localObject2 = new f(localArrayList1, localSparseArray, locala, j, i, (String)localObject2, paramArrayOfByte);
    AppMethodBeat.o(144633);
    return localObject2;
    for (;;)
    {
      label422:
      k += m;
      break;
      j = paramArrayOfByte[m] & 0xFF;
      continue;
      i = paramArrayOfByte[m];
    }
  }
  
  private static String d(SparseArray<byte[]> paramSparseArray)
  {
    AppMethodBeat.i(144637);
    if (paramSparseArray == null)
    {
      AppMethodBeat.o(144637);
      return "null";
    }
    if (paramSparseArray.size() == 0)
    {
      AppMethodBeat.o(144637);
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('{');
    int i = 0;
    while (i < paramSparseArray.size())
    {
      localStringBuilder.append(paramSparseArray.keyAt(i)).append("=").append(Arrays.toString((byte[])paramSparseArray.valueAt(i)));
      i += 1;
    }
    localStringBuilder.append('}');
    paramSparseArray = localStringBuilder.toString();
    AppMethodBeat.o(144637);
    return paramSparseArray;
  }
  
  private static byte[] r(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144636);
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    AppMethodBeat.o(144636);
    return arrayOfByte;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144634);
    String str = "ScanRecord [mAdvertiseFlags=" + this.kKa + ", mServiceUuids=" + this.kKb + ", mManufacturerSpecificData=" + d(this.kKc) + ", mServiceData=" + J(this.kKd) + ", mTxPowerLevel=" + this.kKe + ", mDeviceName=" + this.mDeviceName + "]";
    AppMethodBeat.o(144634);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.f
 * JD-Core Version:    0.7.0.1
 */