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
  private final int hHX;
  public final List<ParcelUuid> hHY;
  public final SparseArray<byte[]> hHZ;
  public final Map<ParcelUuid, byte[]> hIa;
  private final int hIb;
  final byte[] mBytes;
  public final String mDeviceName;
  
  @TargetApi(21)
  f(ScanRecord paramScanRecord)
  {
    AppMethodBeat.i(94320);
    this.hHY = paramScanRecord.getServiceUuids();
    this.hHZ = paramScanRecord.getManufacturerSpecificData();
    this.hIa = paramScanRecord.getServiceData();
    this.mDeviceName = paramScanRecord.getDeviceName();
    this.hHX = paramScanRecord.getAdvertiseFlags();
    this.hIb = paramScanRecord.getTxPowerLevel();
    this.mBytes = paramScanRecord.getBytes();
    AppMethodBeat.o(94320);
  }
  
  private f(List<ParcelUuid> paramList, SparseArray<byte[]> paramSparseArray, Map<ParcelUuid, byte[]> paramMap, int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte)
  {
    this.hHY = paramList;
    this.hHZ = paramSparseArray;
    this.hIa = paramMap;
    this.mDeviceName = paramString;
    this.hHX = paramInt1;
    this.hIb = paramInt2;
    this.mBytes = paramArrayOfByte;
  }
  
  private static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, List<ParcelUuid> paramList)
  {
    AppMethodBeat.i(94323);
    while (paramInt2 > 0)
    {
      paramList.add(c.ah(p(paramArrayOfByte, paramInt1, paramInt3)));
      paramInt2 -= paramInt3;
      paramInt1 += paramInt3;
    }
    AppMethodBeat.o(94323);
    return paramInt1;
  }
  
  public static f ai(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94321);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(94321);
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
      AppMethodBeat.o(94321);
      return paramArrayOfByte;
    }
    a(paramArrayOfByte, m, k, 4, localArrayList2);
    break label422;
    a(paramArrayOfByte, m, k, 16, localArrayList2);
    break label422;
    Object localObject2 = new String(p(paramArrayOfByte, m, k));
    break label422;
    locala.put(c.ah(p(paramArrayOfByte, m, 2)), p(paramArrayOfByte, m + 2, k - 2));
    break label422;
    localSparseArray.put(((paramArrayOfByte[(m + 1)] & 0xFF) << 8) + (paramArrayOfByte[m] & 0xFF), p(paramArrayOfByte, m + 2, k - 2));
    break label422;
    label377:
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2.isEmpty()) {
      localArrayList1 = null;
    }
    localObject2 = new f(localArrayList1, localSparseArray, locala, j, i, (String)localObject2, paramArrayOfByte);
    AppMethodBeat.o(94321);
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
  
  private static String c(SparseArray<byte[]> paramSparseArray)
  {
    AppMethodBeat.i(94325);
    if (paramSparseArray == null)
    {
      AppMethodBeat.o(94325);
      return "null";
    }
    if (paramSparseArray.size() == 0)
    {
      AppMethodBeat.o(94325);
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
    AppMethodBeat.o(94325);
    return paramSparseArray;
  }
  
  private static byte[] p(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94324);
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    AppMethodBeat.o(94324);
    return arrayOfByte;
  }
  
  private static <T> String y(Map<T, byte[]> paramMap)
  {
    AppMethodBeat.i(94326);
    if (paramMap == null)
    {
      AppMethodBeat.o(94326);
      return "null";
    }
    if (paramMap.isEmpty())
    {
      AppMethodBeat.o(94326);
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
    AppMethodBeat.o(94326);
    return paramMap;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(94322);
    String str = "ScanRecord [mAdvertiseFlags=" + this.hHX + ", mServiceUuids=" + this.hHY + ", mManufacturerSpecificData=" + c(this.hHZ) + ", mServiceData=" + y(this.hIa) + ", mTxPowerLevel=" + this.hIb + ", mDeviceName=" + this.mDeviceName + "]";
    AppMethodBeat.o(94322);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.f
 * JD-Core Version:    0.7.0.1
 */