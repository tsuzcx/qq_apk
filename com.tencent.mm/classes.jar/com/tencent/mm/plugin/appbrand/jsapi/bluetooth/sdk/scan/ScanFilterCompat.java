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
  private static final ScanFilterCompat kJY;
  final String kJP;
  final ParcelUuid kJQ;
  final ParcelUuid kJR;
  final ParcelUuid kJS;
  final byte[] kJT;
  final byte[] kJU;
  final int kJV;
  final byte[] kJW;
  final byte[] kJX;
  final String mDeviceName;
  
  static
  {
    AppMethodBeat.i(144631);
    kJY = new a().bkb();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(144631);
  }
  
  private ScanFilterCompat(String paramString1, String paramString2, ParcelUuid paramParcelUuid1, ParcelUuid paramParcelUuid2, ParcelUuid paramParcelUuid3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    this.mDeviceName = paramString1;
    this.kJQ = paramParcelUuid1;
    this.kJR = paramParcelUuid2;
    this.kJP = paramString2;
    this.kJS = paramParcelUuid3;
    this.kJT = paramArrayOfByte1;
    this.kJU = paramArrayOfByte2;
    this.kJV = paramInt;
    this.kJW = paramArrayOfByte3;
    this.kJX = paramArrayOfByte4;
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
    if ((d.equals(this.mDeviceName, paramObject.mDeviceName)) && (d.equals(this.kJP, paramObject.kJP)) && (this.kJV == paramObject.kJV) && (d.deepEquals(this.kJW, paramObject.kJW)) && (d.deepEquals(this.kJX, paramObject.kJX)) && (d.deepEquals(this.kJS, paramObject.kJS)) && (d.deepEquals(this.kJT, paramObject.kJT)) && (d.deepEquals(this.kJU, paramObject.kJU)) && (d.equals(this.kJQ, paramObject.kJQ)) && (d.equals(this.kJR, paramObject.kJR)))
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
    int i = Arrays.hashCode(new Object[] { this.mDeviceName, this.kJP, Integer.valueOf(this.kJV), this.kJW, this.kJX, this.kJS, this.kJT, this.kJU, this.kJQ, this.kJR });
    AppMethodBeat.o(144629);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(144628);
    String str = "BluetoothLeScanFilter [mDeviceName=" + this.mDeviceName + ", mDeviceAddress=" + this.kJP + ", mUuid=" + this.kJQ + ", mUuidMask=" + this.kJR + ", mServiceDataUuid=" + d.toString(this.kJS) + ", mServiceData=" + Arrays.toString(this.kJT) + ", mServiceDataMask=" + Arrays.toString(this.kJU) + ", mManufacturerId=" + this.kJV + ", mManufacturerData=" + Arrays.toString(this.kJW) + ", mManufacturerDataMask=" + Arrays.toString(this.kJX) + "]";
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
      if (this.kJP != null) {
        break label328;
      }
      i = 0;
      label46:
      paramParcel.writeInt(i);
      if (this.kJP != null) {
        paramParcel.writeString(this.kJP);
      }
      if (this.kJQ != null) {
        break label333;
      }
      i = 0;
      label75:
      paramParcel.writeInt(i);
      if (this.kJQ != null)
      {
        paramParcel.writeParcelable(this.kJQ, paramInt);
        if (this.kJR != null) {
          break label338;
        }
        i = 0;
        label105:
        paramParcel.writeInt(i);
        if (this.kJR != null) {
          paramParcel.writeParcelable(this.kJR, paramInt);
        }
      }
      if (this.kJS != null) {
        break label343;
      }
      i = 0;
      label135:
      paramParcel.writeInt(i);
      if (this.kJS != null)
      {
        paramParcel.writeParcelable(this.kJS, paramInt);
        if (this.kJT != null) {
          break label348;
        }
        paramInt = 0;
        label165:
        paramParcel.writeInt(paramInt);
        if (this.kJT != null)
        {
          paramParcel.writeInt(this.kJT.length);
          paramParcel.writeByteArray(this.kJT);
          if (this.kJU != null) {
            break label353;
          }
          paramInt = 0;
          label203:
          paramParcel.writeInt(paramInt);
          if (this.kJU != null)
          {
            paramParcel.writeInt(this.kJU.length);
            paramParcel.writeByteArray(this.kJU);
          }
        }
      }
      paramParcel.writeInt(this.kJV);
      if (this.kJW != null) {
        break label358;
      }
      paramInt = 0;
      label249:
      paramParcel.writeInt(paramInt);
      if (this.kJW != null)
      {
        paramParcel.writeInt(this.kJW.length);
        paramParcel.writeByteArray(this.kJW);
        if (this.kJX != null) {
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
      if (this.kJX != null)
      {
        paramParcel.writeInt(this.kJX.length);
        paramParcel.writeByteArray(this.kJX);
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
    String kJP;
    ParcelUuid kJQ;
    ParcelUuid kJS;
    byte[] kJT;
    byte[] kJU;
    int kJV = -1;
    byte[] kJW;
    byte[] kJX;
    ParcelUuid kJZ;
    String mDeviceName;
    
    public final a a(ParcelUuid paramParcelUuid)
    {
      this.kJQ = paramParcelUuid;
      this.kJZ = null;
      return this;
    }
    
    public final ScanFilterCompat bkb()
    {
      AppMethodBeat.i(144625);
      ScanFilterCompat localScanFilterCompat = new ScanFilterCompat(this.mDeviceName, this.kJP, this.kJQ, this.kJZ, this.kJS, this.kJT, this.kJU, this.kJV, this.kJW, this.kJX, (byte)0);
      AppMethodBeat.o(144625);
      return localScanFilterCompat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat
 * JD-Core Version:    0.7.0.1
 */