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
  private static final ScanFilterCompat jLi;
  final String jKZ;
  final ParcelUuid jLa;
  final ParcelUuid jLb;
  final ParcelUuid jLc;
  final byte[] jLd;
  final byte[] jLe;
  final int jLf;
  final byte[] jLg;
  final byte[] jLh;
  final String mDeviceName;
  
  static
  {
    AppMethodBeat.i(144631);
    jLi = new a().aYW();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(144631);
  }
  
  private ScanFilterCompat(String paramString1, String paramString2, ParcelUuid paramParcelUuid1, ParcelUuid paramParcelUuid2, ParcelUuid paramParcelUuid3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    this.mDeviceName = paramString1;
    this.jLa = paramParcelUuid1;
    this.jLb = paramParcelUuid2;
    this.jKZ = paramString2;
    this.jLc = paramParcelUuid3;
    this.jLd = paramArrayOfByte1;
    this.jLe = paramArrayOfByte2;
    this.jLf = paramInt;
    this.jLg = paramArrayOfByte3;
    this.jLh = paramArrayOfByte4;
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
    if ((d.equals(this.mDeviceName, paramObject.mDeviceName)) && (d.equals(this.jKZ, paramObject.jKZ)) && (this.jLf == paramObject.jLf) && (d.deepEquals(this.jLg, paramObject.jLg)) && (d.deepEquals(this.jLh, paramObject.jLh)) && (d.deepEquals(this.jLc, paramObject.jLc)) && (d.deepEquals(this.jLd, paramObject.jLd)) && (d.deepEquals(this.jLe, paramObject.jLe)) && (d.equals(this.jLa, paramObject.jLa)) && (d.equals(this.jLb, paramObject.jLb)))
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
    int i = Arrays.hashCode(new Object[] { this.mDeviceName, this.jKZ, Integer.valueOf(this.jLf), this.jLg, this.jLh, this.jLc, this.jLd, this.jLe, this.jLa, this.jLb });
    AppMethodBeat.o(144629);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(144628);
    String str = "BluetoothLeScanFilter [mDeviceName=" + this.mDeviceName + ", mDeviceAddress=" + this.jKZ + ", mUuid=" + this.jLa + ", mUuidMask=" + this.jLb + ", mServiceDataUuid=" + d.toString(this.jLc) + ", mServiceData=" + Arrays.toString(this.jLd) + ", mServiceDataMask=" + Arrays.toString(this.jLe) + ", mManufacturerId=" + this.jLf + ", mManufacturerData=" + Arrays.toString(this.jLg) + ", mManufacturerDataMask=" + Arrays.toString(this.jLh) + "]";
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
      if (this.jKZ != null) {
        break label328;
      }
      i = 0;
      label46:
      paramParcel.writeInt(i);
      if (this.jKZ != null) {
        paramParcel.writeString(this.jKZ);
      }
      if (this.jLa != null) {
        break label333;
      }
      i = 0;
      label75:
      paramParcel.writeInt(i);
      if (this.jLa != null)
      {
        paramParcel.writeParcelable(this.jLa, paramInt);
        if (this.jLb != null) {
          break label338;
        }
        i = 0;
        label105:
        paramParcel.writeInt(i);
        if (this.jLb != null) {
          paramParcel.writeParcelable(this.jLb, paramInt);
        }
      }
      if (this.jLc != null) {
        break label343;
      }
      i = 0;
      label135:
      paramParcel.writeInt(i);
      if (this.jLc != null)
      {
        paramParcel.writeParcelable(this.jLc, paramInt);
        if (this.jLd != null) {
          break label348;
        }
        paramInt = 0;
        label165:
        paramParcel.writeInt(paramInt);
        if (this.jLd != null)
        {
          paramParcel.writeInt(this.jLd.length);
          paramParcel.writeByteArray(this.jLd);
          if (this.jLe != null) {
            break label353;
          }
          paramInt = 0;
          label203:
          paramParcel.writeInt(paramInt);
          if (this.jLe != null)
          {
            paramParcel.writeInt(this.jLe.length);
            paramParcel.writeByteArray(this.jLe);
          }
        }
      }
      paramParcel.writeInt(this.jLf);
      if (this.jLg != null) {
        break label358;
      }
      paramInt = 0;
      label249:
      paramParcel.writeInt(paramInt);
      if (this.jLg != null)
      {
        paramParcel.writeInt(this.jLg.length);
        paramParcel.writeByteArray(this.jLg);
        if (this.jLh != null) {
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
      if (this.jLh != null)
      {
        paramParcel.writeInt(this.jLh.length);
        paramParcel.writeByteArray(this.jLh);
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
    String jKZ;
    ParcelUuid jLa;
    ParcelUuid jLc;
    byte[] jLd;
    byte[] jLe;
    int jLf = -1;
    byte[] jLg;
    byte[] jLh;
    ParcelUuid jLj;
    String mDeviceName;
    
    public final a a(ParcelUuid paramParcelUuid)
    {
      this.jLa = paramParcelUuid;
      this.jLj = null;
      return this;
    }
    
    public final ScanFilterCompat aYW()
    {
      AppMethodBeat.i(144625);
      ScanFilterCompat localScanFilterCompat = new ScanFilterCompat(this.mDeviceName, this.jKZ, this.jLa, this.jLj, this.jLc, this.jLd, this.jLe, this.jLf, this.jLg, this.jLh, (byte)0);
      AppMethodBeat.o(144625);
      return localScanFilterCompat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat
 * JD-Core Version:    0.7.0.1
 */