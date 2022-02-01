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
  private static final ScanFilterCompat lOD;
  final int lOA;
  final byte[] lOB;
  final byte[] lOC;
  final String lOu;
  final ParcelUuid lOv;
  final ParcelUuid lOw;
  final ParcelUuid lOx;
  final byte[] lOy;
  final byte[] lOz;
  final String mDeviceName;
  
  static
  {
    AppMethodBeat.i(144631);
    lOD = new a().bFx();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(144631);
  }
  
  private ScanFilterCompat(String paramString1, String paramString2, ParcelUuid paramParcelUuid1, ParcelUuid paramParcelUuid2, ParcelUuid paramParcelUuid3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    this.mDeviceName = paramString1;
    this.lOv = paramParcelUuid1;
    this.lOw = paramParcelUuid2;
    this.lOu = paramString2;
    this.lOx = paramParcelUuid3;
    this.lOy = paramArrayOfByte1;
    this.lOz = paramArrayOfByte2;
    this.lOA = paramInt;
    this.lOB = paramArrayOfByte3;
    this.lOC = paramArrayOfByte4;
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
    if ((d.equals(this.mDeviceName, paramObject.mDeviceName)) && (d.equals(this.lOu, paramObject.lOu)) && (this.lOA == paramObject.lOA) && (d.deepEquals(this.lOB, paramObject.lOB)) && (d.deepEquals(this.lOC, paramObject.lOC)) && (d.deepEquals(this.lOx, paramObject.lOx)) && (d.deepEquals(this.lOy, paramObject.lOy)) && (d.deepEquals(this.lOz, paramObject.lOz)) && (d.equals(this.lOv, paramObject.lOv)) && (d.equals(this.lOw, paramObject.lOw)))
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
    int i = Arrays.hashCode(new Object[] { this.mDeviceName, this.lOu, Integer.valueOf(this.lOA), this.lOB, this.lOC, this.lOx, this.lOy, this.lOz, this.lOv, this.lOw });
    AppMethodBeat.o(144629);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(144628);
    String str = "BluetoothLeScanFilter [mDeviceName=" + this.mDeviceName + ", mDeviceAddress=" + this.lOu + ", mUuid=" + this.lOv + ", mUuidMask=" + this.lOw + ", mServiceDataUuid=" + d.toString(this.lOx) + ", mServiceData=" + Arrays.toString(this.lOy) + ", mServiceDataMask=" + Arrays.toString(this.lOz) + ", mManufacturerId=" + this.lOA + ", mManufacturerData=" + Arrays.toString(this.lOB) + ", mManufacturerDataMask=" + Arrays.toString(this.lOC) + "]";
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
      if (this.lOu != null) {
        break label328;
      }
      i = 0;
      label46:
      paramParcel.writeInt(i);
      if (this.lOu != null) {
        paramParcel.writeString(this.lOu);
      }
      if (this.lOv != null) {
        break label333;
      }
      i = 0;
      label75:
      paramParcel.writeInt(i);
      if (this.lOv != null)
      {
        paramParcel.writeParcelable(this.lOv, paramInt);
        if (this.lOw != null) {
          break label338;
        }
        i = 0;
        label105:
        paramParcel.writeInt(i);
        if (this.lOw != null) {
          paramParcel.writeParcelable(this.lOw, paramInt);
        }
      }
      if (this.lOx != null) {
        break label343;
      }
      i = 0;
      label135:
      paramParcel.writeInt(i);
      if (this.lOx != null)
      {
        paramParcel.writeParcelable(this.lOx, paramInt);
        if (this.lOy != null) {
          break label348;
        }
        paramInt = 0;
        label165:
        paramParcel.writeInt(paramInt);
        if (this.lOy != null)
        {
          paramParcel.writeInt(this.lOy.length);
          paramParcel.writeByteArray(this.lOy);
          if (this.lOz != null) {
            break label353;
          }
          paramInt = 0;
          label203:
          paramParcel.writeInt(paramInt);
          if (this.lOz != null)
          {
            paramParcel.writeInt(this.lOz.length);
            paramParcel.writeByteArray(this.lOz);
          }
        }
      }
      paramParcel.writeInt(this.lOA);
      if (this.lOB != null) {
        break label358;
      }
      paramInt = 0;
      label249:
      paramParcel.writeInt(paramInt);
      if (this.lOB != null)
      {
        paramParcel.writeInt(this.lOB.length);
        paramParcel.writeByteArray(this.lOB);
        if (this.lOC != null) {
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
      if (this.lOC != null)
      {
        paramParcel.writeInt(this.lOC.length);
        paramParcel.writeByteArray(this.lOC);
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
    int lOA = -1;
    byte[] lOB;
    byte[] lOC;
    ParcelUuid lOE;
    String lOu;
    ParcelUuid lOv;
    ParcelUuid lOx;
    byte[] lOy;
    byte[] lOz;
    String mDeviceName;
    
    public final a a(ParcelUuid paramParcelUuid)
    {
      this.lOv = paramParcelUuid;
      this.lOE = null;
      return this;
    }
    
    public final ScanFilterCompat bFx()
    {
      AppMethodBeat.i(144625);
      ScanFilterCompat localScanFilterCompat = new ScanFilterCompat(this.mDeviceName, this.lOu, this.lOv, this.lOE, this.lOx, this.lOy, this.lOz, this.lOA, this.lOB, this.lOC, (byte)0);
      AppMethodBeat.o(144625);
      return localScanFilterCompat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat
 * JD-Core Version:    0.7.0.1
 */