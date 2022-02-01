package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.UUID;

public class ScanFilterCompat
  implements Parcelable
{
  public static final Parcelable.Creator<ScanFilterCompat> CREATOR;
  private static final ScanFilterCompat oKX;
  final String mDeviceName;
  final String oKO;
  final ParcelUuid oKP;
  final ParcelUuid oKQ;
  final ParcelUuid oKR;
  final byte[] oKS;
  final byte[] oKT;
  final int oKU;
  final byte[] oKV;
  final byte[] oKW;
  
  static
  {
    AppMethodBeat.i(144631);
    oKX = new a().bRe();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(144631);
  }
  
  private ScanFilterCompat(String paramString1, String paramString2, ParcelUuid paramParcelUuid1, ParcelUuid paramParcelUuid2, ParcelUuid paramParcelUuid3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    this.mDeviceName = paramString1;
    this.oKP = paramParcelUuid1;
    this.oKQ = paramParcelUuid2;
    this.oKO = paramString2;
    this.oKR = paramParcelUuid3;
    this.oKS = paramArrayOfByte1;
    this.oKT = paramArrayOfByte2;
    this.oKU = paramInt;
    this.oKV = paramArrayOfByte3;
    this.oKW = paramArrayOfByte4;
  }
  
  static boolean a(UUID paramUUID1, UUID paramUUID2, UUID paramUUID3)
  {
    AppMethodBeat.i(144627);
    if (paramUUID2 == null)
    {
      boolean bool = paramUUID1.equals(paramUUID3);
      AppMethodBeat.o(144627);
      return bool;
    }
    if ((paramUUID1.getLeastSignificantBits() & paramUUID2.getLeastSignificantBits()) != (paramUUID3.getLeastSignificantBits() & paramUUID2.getLeastSignificantBits()))
    {
      AppMethodBeat.o(144627);
      return false;
    }
    if ((paramUUID1.getMostSignificantBits() & paramUUID2.getMostSignificantBits()) == (paramUUID3.getMostSignificantBits() & paramUUID2.getMostSignificantBits()))
    {
      AppMethodBeat.o(144627);
      return true;
    }
    AppMethodBeat.o(144627);
    return false;
  }
  
  static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if ((paramArrayOfByte3 == null) || (paramArrayOfByte3.length < paramArrayOfByte1.length)) {
      return false;
    }
    if (paramArrayOfByte2 == null)
    {
      i = 0;
      for (;;)
      {
        if (i >= paramArrayOfByte1.length) {
          break label41;
        }
        if (paramArrayOfByte3[i] != paramArrayOfByte1[i]) {
          break;
        }
        i += 1;
      }
      label41:
      return true;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte1.length) {
        break label75;
      }
      if ((paramArrayOfByte2[i] & paramArrayOfByte3[i]) != (paramArrayOfByte2[i] & paramArrayOfByte1[i])) {
        break;
      }
      i += 1;
    }
    label75:
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(144630);
    if (this == paramObject)
    {
      AppMethodBeat.o(144630);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(144630);
      return false;
    }
    paramObject = (ScanFilterCompat)paramObject;
    if ((g.equals(this.mDeviceName, paramObject.mDeviceName)) && (g.equals(this.oKO, paramObject.oKO)) && (this.oKU == paramObject.oKU) && (g.B(this.oKV, paramObject.oKV)) && (g.B(this.oKW, paramObject.oKW)) && (g.B(this.oKR, paramObject.oKR)) && (g.B(this.oKS, paramObject.oKS)) && (g.B(this.oKT, paramObject.oKT)) && (g.equals(this.oKP, paramObject.oKP)) && (g.equals(this.oKQ, paramObject.oKQ)))
    {
      AppMethodBeat.o(144630);
      return true;
    }
    AppMethodBeat.o(144630);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(144629);
    int i = Arrays.hashCode(new Object[] { this.mDeviceName, this.oKO, Integer.valueOf(this.oKU), this.oKV, this.oKW, this.oKR, this.oKS, this.oKT, this.oKP, this.oKQ });
    AppMethodBeat.o(144629);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(144628);
    String str = "BluetoothLeScanFilter [mDeviceName=" + this.mDeviceName + ", mDeviceAddress=" + this.oKO + ", mUuid=" + this.oKP + ", mUuidMask=" + this.oKQ + ", mServiceDataUuid=" + g.cG(this.oKR) + ", mServiceData=" + Arrays.toString(this.oKS) + ", mServiceDataMask=" + Arrays.toString(this.oKT) + ", mManufacturerId=" + this.oKU + ", mManufacturerData=" + Arrays.toString(this.oKV) + ", mManufacturerDataMask=" + Arrays.toString(this.oKW) + "]";
    AppMethodBeat.o(144628);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(144626);
    int i;
    if (this.mDeviceName == null)
    {
      i = 0;
      paramParcel.writeInt(i);
      if (this.mDeviceName != null) {
        paramParcel.writeString(this.mDeviceName);
      }
      if (this.oKO != null) {
        break label328;
      }
      i = 0;
      label46:
      paramParcel.writeInt(i);
      if (this.oKO != null) {
        paramParcel.writeString(this.oKO);
      }
      if (this.oKP != null) {
        break label333;
      }
      i = 0;
      label75:
      paramParcel.writeInt(i);
      if (this.oKP != null)
      {
        paramParcel.writeParcelable(this.oKP, paramInt);
        if (this.oKQ != null) {
          break label338;
        }
        i = 0;
        label105:
        paramParcel.writeInt(i);
        if (this.oKQ != null) {
          paramParcel.writeParcelable(this.oKQ, paramInt);
        }
      }
      if (this.oKR != null) {
        break label343;
      }
      i = 0;
      label135:
      paramParcel.writeInt(i);
      if (this.oKR != null)
      {
        paramParcel.writeParcelable(this.oKR, paramInt);
        if (this.oKS != null) {
          break label348;
        }
        paramInt = 0;
        label165:
        paramParcel.writeInt(paramInt);
        if (this.oKS != null)
        {
          paramParcel.writeInt(this.oKS.length);
          paramParcel.writeByteArray(this.oKS);
          if (this.oKT != null) {
            break label353;
          }
          paramInt = 0;
          label203:
          paramParcel.writeInt(paramInt);
          if (this.oKT != null)
          {
            paramParcel.writeInt(this.oKT.length);
            paramParcel.writeByteArray(this.oKT);
          }
        }
      }
      paramParcel.writeInt(this.oKU);
      if (this.oKV != null) {
        break label358;
      }
      paramInt = 0;
      label249:
      paramParcel.writeInt(paramInt);
      if (this.oKV != null)
      {
        paramParcel.writeInt(this.oKV.length);
        paramParcel.writeByteArray(this.oKV);
        if (this.oKW != null) {
          break label363;
        }
      }
    }
    label328:
    label333:
    label338:
    label343:
    label348:
    label353:
    label358:
    label363:
    for (paramInt = j;; paramInt = 1)
    {
      paramParcel.writeInt(paramInt);
      if (this.oKW != null)
      {
        paramParcel.writeInt(this.oKW.length);
        paramParcel.writeByteArray(this.oKW);
      }
      AppMethodBeat.o(144626);
      return;
      i = 1;
      break;
      i = 1;
      break label46;
      i = 1;
      break label75;
      i = 1;
      break label105;
      i = 1;
      break label135;
      paramInt = 1;
      break label165;
      paramInt = 1;
      break label203;
      paramInt = 1;
      break label249;
    }
  }
  
  public static final class a
  {
    String mDeviceName;
    String oKO;
    ParcelUuid oKP;
    ParcelUuid oKR;
    byte[] oKS;
    byte[] oKT;
    int oKU = -1;
    byte[] oKV;
    byte[] oKW;
    ParcelUuid oKY;
    
    public final a a(ParcelUuid paramParcelUuid)
    {
      this.oKP = paramParcelUuid;
      this.oKY = null;
      return this;
    }
    
    public final ScanFilterCompat bRe()
    {
      AppMethodBeat.i(144625);
      ScanFilterCompat localScanFilterCompat = new ScanFilterCompat(this.mDeviceName, this.oKO, this.oKP, this.oKY, this.oKR, this.oKS, this.oKT, this.oKU, this.oKV, this.oKW, (byte)0);
      AppMethodBeat.o(144625);
      return localScanFilterCompat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat
 * JD-Core Version:    0.7.0.1
 */