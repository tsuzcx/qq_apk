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
  private static final ScanFilterCompat klJ;
  final String klA;
  final ParcelUuid klB;
  final ParcelUuid klC;
  final ParcelUuid klD;
  final byte[] klE;
  final byte[] klF;
  final int klG;
  final byte[] klH;
  final byte[] klI;
  final String mDeviceName;
  
  static
  {
    AppMethodBeat.i(144631);
    klJ = new a().bfO();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(144631);
  }
  
  private ScanFilterCompat(String paramString1, String paramString2, ParcelUuid paramParcelUuid1, ParcelUuid paramParcelUuid2, ParcelUuid paramParcelUuid3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    this.mDeviceName = paramString1;
    this.klB = paramParcelUuid1;
    this.klC = paramParcelUuid2;
    this.klA = paramString2;
    this.klD = paramParcelUuid3;
    this.klE = paramArrayOfByte1;
    this.klF = paramArrayOfByte2;
    this.klG = paramInt;
    this.klH = paramArrayOfByte3;
    this.klI = paramArrayOfByte4;
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
    if ((d.equals(this.mDeviceName, paramObject.mDeviceName)) && (d.equals(this.klA, paramObject.klA)) && (this.klG == paramObject.klG) && (d.deepEquals(this.klH, paramObject.klH)) && (d.deepEquals(this.klI, paramObject.klI)) && (d.deepEquals(this.klD, paramObject.klD)) && (d.deepEquals(this.klE, paramObject.klE)) && (d.deepEquals(this.klF, paramObject.klF)) && (d.equals(this.klB, paramObject.klB)) && (d.equals(this.klC, paramObject.klC)))
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
    int i = Arrays.hashCode(new Object[] { this.mDeviceName, this.klA, Integer.valueOf(this.klG), this.klH, this.klI, this.klD, this.klE, this.klF, this.klB, this.klC });
    AppMethodBeat.o(144629);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(144628);
    String str = "BluetoothLeScanFilter [mDeviceName=" + this.mDeviceName + ", mDeviceAddress=" + this.klA + ", mUuid=" + this.klB + ", mUuidMask=" + this.klC + ", mServiceDataUuid=" + d.toString(this.klD) + ", mServiceData=" + Arrays.toString(this.klE) + ", mServiceDataMask=" + Arrays.toString(this.klF) + ", mManufacturerId=" + this.klG + ", mManufacturerData=" + Arrays.toString(this.klH) + ", mManufacturerDataMask=" + Arrays.toString(this.klI) + "]";
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
      if (this.klA != null) {
        break label328;
      }
      i = 0;
      label46:
      paramParcel.writeInt(i);
      if (this.klA != null) {
        paramParcel.writeString(this.klA);
      }
      if (this.klB != null) {
        break label333;
      }
      i = 0;
      label75:
      paramParcel.writeInt(i);
      if (this.klB != null)
      {
        paramParcel.writeParcelable(this.klB, paramInt);
        if (this.klC != null) {
          break label338;
        }
        i = 0;
        label105:
        paramParcel.writeInt(i);
        if (this.klC != null) {
          paramParcel.writeParcelable(this.klC, paramInt);
        }
      }
      if (this.klD != null) {
        break label343;
      }
      i = 0;
      label135:
      paramParcel.writeInt(i);
      if (this.klD != null)
      {
        paramParcel.writeParcelable(this.klD, paramInt);
        if (this.klE != null) {
          break label348;
        }
        paramInt = 0;
        label165:
        paramParcel.writeInt(paramInt);
        if (this.klE != null)
        {
          paramParcel.writeInt(this.klE.length);
          paramParcel.writeByteArray(this.klE);
          if (this.klF != null) {
            break label353;
          }
          paramInt = 0;
          label203:
          paramParcel.writeInt(paramInt);
          if (this.klF != null)
          {
            paramParcel.writeInt(this.klF.length);
            paramParcel.writeByteArray(this.klF);
          }
        }
      }
      paramParcel.writeInt(this.klG);
      if (this.klH != null) {
        break label358;
      }
      paramInt = 0;
      label249:
      paramParcel.writeInt(paramInt);
      if (this.klH != null)
      {
        paramParcel.writeInt(this.klH.length);
        paramParcel.writeByteArray(this.klH);
        if (this.klI != null) {
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
      if (this.klI != null)
      {
        paramParcel.writeInt(this.klI.length);
        paramParcel.writeByteArray(this.klI);
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
    String klA;
    ParcelUuid klB;
    ParcelUuid klD;
    byte[] klE;
    byte[] klF;
    int klG = -1;
    byte[] klH;
    byte[] klI;
    ParcelUuid klK;
    String mDeviceName;
    
    public final a a(ParcelUuid paramParcelUuid)
    {
      this.klB = paramParcelUuid;
      this.klK = null;
      return this;
    }
    
    public final ScanFilterCompat bfO()
    {
      AppMethodBeat.i(144625);
      ScanFilterCompat localScanFilterCompat = new ScanFilterCompat(this.mDeviceName, this.klA, this.klB, this.klK, this.klD, this.klE, this.klF, this.klG, this.klH, this.klI, (byte)0);
      AppMethodBeat.o(144625);
      return localScanFilterCompat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat
 * JD-Core Version:    0.7.0.1
 */