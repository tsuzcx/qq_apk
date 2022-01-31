package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.annotation.TargetApi;
import android.bluetooth.le.ScanRecord;
import android.os.ParcelUuid;
import android.support.v4.f.a;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class f
{
  public final String gnO;
  private final int goa;
  public final List<ParcelUuid> gob;
  public final SparseArray<byte[]> goc;
  public final Map<ParcelUuid, byte[]> god;
  private final int goe;
  final byte[] mBytes;
  
  @TargetApi(21)
  f(ScanRecord paramScanRecord)
  {
    this.gob = paramScanRecord.getServiceUuids();
    this.goc = paramScanRecord.getManufacturerSpecificData();
    this.god = paramScanRecord.getServiceData();
    this.gnO = paramScanRecord.getDeviceName();
    this.goa = paramScanRecord.getAdvertiseFlags();
    this.goe = paramScanRecord.getTxPowerLevel();
    this.mBytes = paramScanRecord.getBytes();
  }
  
  private f(List<ParcelUuid> paramList, SparseArray<byte[]> paramSparseArray, Map<ParcelUuid, byte[]> paramMap, int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte)
  {
    this.gob = paramList;
    this.goc = paramSparseArray;
    this.god = paramMap;
    this.gnO = paramString;
    this.goa = paramInt1;
    this.goe = paramInt2;
    this.mBytes = paramArrayOfByte;
  }
  
  public static f O(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
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
        break label362;
      }
      int n = k + 1;
      k = paramArrayOfByte[k] & 0xFF;
      if (k == 0) {
        break label362;
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
      return new f(null, null, null, -1, -2147483648, null, paramArrayOfByte);
    }
    a(paramArrayOfByte, m, k, 4, localArrayList2);
    break label402;
    a(paramArrayOfByte, m, k, 16, localArrayList2);
    break label402;
    Object localObject2 = new String(m(paramArrayOfByte, m, k));
    break label402;
    locala.put(c.N(m(paramArrayOfByte, m, 2)), m(paramArrayOfByte, m + 2, k - 2));
    break label402;
    localSparseArray.put(((paramArrayOfByte[(m + 1)] & 0xFF) << 8) + (paramArrayOfByte[m] & 0xFF), m(paramArrayOfByte, m + 2, k - 2));
    break label402;
    label362:
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2.isEmpty()) {
      localArrayList1 = null;
    }
    localObject2 = new f(localArrayList1, localSparseArray, locala, j, i, (String)localObject2, paramArrayOfByte);
    return localObject2;
    for (;;)
    {
      label402:
      k += m;
      break;
      j = paramArrayOfByte[m] & 0xFF;
      continue;
      i = paramArrayOfByte[m];
    }
  }
  
  private static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, List<ParcelUuid> paramList)
  {
    while (paramInt2 > 0)
    {
      paramList.add(c.N(m(paramArrayOfByte, paramInt1, paramInt3)));
      paramInt2 -= paramInt3;
      paramInt1 += paramInt3;
    }
    return paramInt1;
  }
  
  private static String b(SparseArray<byte[]> paramSparseArray)
  {
    if (paramSparseArray == null) {
      return "null";
    }
    if (paramSparseArray.size() == 0) {
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
    return localStringBuilder.toString();
  }
  
  private static byte[] m(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  private static <T> String s(Map<T, byte[]> paramMap)
  {
    if (paramMap == null) {
      return "null";
    }
    if (paramMap.isEmpty()) {
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
    return localStringBuilder.toString();
  }
  
  public final String toString()
  {
    return "ScanRecord [mAdvertiseFlags=" + this.goa + ", mServiceUuids=" + this.gob + ", mManufacturerSpecificData=" + b(this.goc) + ", mServiceData=" + s(this.god) + ", mTxPowerLevel=" + this.goe + ", mDeviceName=" + this.gnO + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.f
 * JD-Core Version:    0.7.0.1
 */