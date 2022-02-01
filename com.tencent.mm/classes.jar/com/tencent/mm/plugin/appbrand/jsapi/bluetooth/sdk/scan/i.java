package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.annotation.TargetApi;
import android.bluetooth.le.ScanRecord;
import android.os.ParcelUuid;
import android.util.SparseArray;
import androidx.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class i
{
  public final String mDeviceName;
  private final int oKZ;
  public final List<ParcelUuid> oLa;
  public final SparseArray<byte[]> oLb;
  public final Map<ParcelUuid, byte[]> oLc;
  private final int oLd;
  final byte[] oLe;
  public final SparseArray<byte[]> oLf;
  
  @TargetApi(21)
  i(ScanRecord paramScanRecord)
  {
    AppMethodBeat.i(144632);
    this.oLa = paramScanRecord.getServiceUuids();
    this.oLb = paramScanRecord.getManufacturerSpecificData();
    this.oLc = paramScanRecord.getServiceData();
    this.mDeviceName = paramScanRecord.getDeviceName();
    this.oKZ = paramScanRecord.getAdvertiseFlags();
    this.oLd = paramScanRecord.getTxPowerLevel();
    this.oLe = paramScanRecord.getBytes();
    this.oLf = this.oLb;
    AppMethodBeat.o(144632);
  }
  
  private i(List<ParcelUuid> paramList, SparseArray<byte[]> paramSparseArray1, Map<ParcelUuid, byte[]> paramMap, int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte, SparseArray<byte[]> paramSparseArray2)
  {
    this.oLa = paramList;
    this.oLb = paramSparseArray1;
    this.oLc = paramMap;
    this.mDeviceName = paramString;
    this.oKZ = paramInt1;
    this.oLd = paramInt2;
    this.oLe = paramArrayOfByte;
    this.oLf = paramSparseArray2;
  }
  
  private static byte[] C(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144636);
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    AppMethodBeat.o(144636);
    return arrayOfByte;
  }
  
  private static <T> String F(Map<T, byte[]> paramMap)
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
      paramList.add(d.aU(C(paramArrayOfByte, paramInt1, paramInt3)));
      paramInt2 -= paramInt3;
      paramInt1 += paramInt3;
    }
    AppMethodBeat.o(144635);
    return paramInt1;
  }
  
  public static i aV(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(144633);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(144633);
      return null;
    }
    int k = 0;
    int j = -1;
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = null;
    int i = -2147483648;
    SparseArray localSparseArray2 = new SparseArray();
    a locala = new a();
    SparseArray localSparseArray1 = new SparseArray();
    int m;
    try
    {
      if (k >= paramArrayOfByte.length) {
        break label474;
      }
      n = k + 1;
      k = paramArrayOfByte[k] & 0xFF;
      if (k == 0) {
        break label474;
      }
      k -= 1;
      m = n + 1;
      switch (paramArrayOfByte[n] & 0xFF)
      {
      case 2: 
      case 3: 
        a(paramArrayOfByte, m, k, 2, localArrayList);
      }
    }
    catch (Exception localException)
    {
      new StringBuilder("unable to parse scan record: ").append(Arrays.toString(paramArrayOfByte));
      paramArrayOfByte = new i(null, null, null, -1, -2147483648, null, paramArrayOfByte, localSparseArray1);
      AppMethodBeat.o(144633);
      return paramArrayOfByte;
    }
    a(paramArrayOfByte, m, k, 4, localArrayList);
    break label521;
    a(paramArrayOfByte, m, k, 16, localArrayList);
    break label521;
    Object localObject2 = new String(C(paramArrayOfByte, m, k));
    break label521;
    locala.put(d.aU(C(paramArrayOfByte, m, 2)), C(paramArrayOfByte, m + 2, k - 2));
    break label521;
    int n = paramArrayOfByte[(m + 1)];
    n = (paramArrayOfByte[m] & 0xFF) + ((n & 0xFF) << 8);
    Object localObject3 = C(paramArrayOfByte, m + 2, k - 2);
    localSparseArray2.put(n, localObject3);
    byte[] arrayOfByte1 = (byte[])localSparseArray1.get(n);
    if (arrayOfByte1 != null)
    {
      byte[] arrayOfByte2 = new byte[arrayOfByte1.length + localObject3.length];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
      System.arraycopy(localObject3, 0, arrayOfByte2, arrayOfByte1.length, localObject3.length);
      localSparseArray1.put(n, arrayOfByte2);
    }
    else
    {
      localSparseArray1.put(n, localObject3);
      break label521;
      label474:
      localObject3 = localArrayList;
      if (localArrayList.isEmpty()) {
        localObject3 = null;
      }
      localObject2 = new i((List)localObject3, localSparseArray2, locala, j, i, (String)localObject2, paramArrayOfByte, localSparseArray1);
      AppMethodBeat.o(144633);
      return localObject2;
    }
    for (;;)
    {
      label521:
      k = m + k;
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
  
  public final String toString()
  {
    AppMethodBeat.i(144634);
    String str = "ScanRecord [mAdvertiseFlags=" + this.oKZ + ", mServiceUuids=" + this.oLa + ", mManufacturerSpecificData=" + d(this.oLb) + ", mServiceData=" + F(this.oLc) + ", mTxPowerLevel=" + this.oLd + ", mDeviceName=" + this.mDeviceName + ", mBytes=" + Arrays.toString(this.oLe) + ", mManufacturerSpecificDataFixed=" + d(this.oLf) + "]";
    AppMethodBeat.o(144634);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.i
 * JD-Core Version:    0.7.0.1
 */