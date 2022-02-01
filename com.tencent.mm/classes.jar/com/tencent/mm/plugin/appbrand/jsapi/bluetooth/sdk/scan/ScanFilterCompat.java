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
  private static final ScanFilterCompat kGJ;
  final String kGA;
  final ParcelUuid kGB;
  final ParcelUuid kGC;
  final ParcelUuid kGD;
  final byte[] kGE;
  final byte[] kGF;
  final int kGG;
  final byte[] kGH;
  final byte[] kGI;
  final String mDeviceName;
  
  static
  {
    AppMethodBeat.i(144631);
    kGJ = new a().bjs();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(144631);
  }
  
  private ScanFilterCompat(String paramString1, String paramString2, ParcelUuid paramParcelUuid1, ParcelUuid paramParcelUuid2, ParcelUuid paramParcelUuid3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    this.mDeviceName = paramString1;
    this.kGB = paramParcelUuid1;
    this.kGC = paramParcelUuid2;
    this.kGA = paramString2;
    this.kGD = paramParcelUuid3;
    this.kGE = paramArrayOfByte1;
    this.kGF = paramArrayOfByte2;
    this.kGG = paramInt;
    this.kGH = paramArrayOfByte3;
    this.kGI = paramArrayOfByte4;
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
    if ((d.equals(this.mDeviceName, paramObject.mDeviceName)) && (d.equals(this.kGA, paramObject.kGA)) && (this.kGG == paramObject.kGG) && (d.deepEquals(this.kGH, paramObject.kGH)) && (d.deepEquals(this.kGI, paramObject.kGI)) && (d.deepEquals(this.kGD, paramObject.kGD)) && (d.deepEquals(this.kGE, paramObject.kGE)) && (d.deepEquals(this.kGF, paramObject.kGF)) && (d.equals(this.kGB, paramObject.kGB)) && (d.equals(this.kGC, paramObject.kGC)))
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
    int i = Arrays.hashCode(new Object[] { this.mDeviceName, this.kGA, Integer.valueOf(this.kGG), this.kGH, this.kGI, this.kGD, this.kGE, this.kGF, this.kGB, this.kGC });
    AppMethodBeat.o(144629);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(144628);
    String str = "BluetoothLeScanFilter [mDeviceName=" + this.mDeviceName + ", mDeviceAddress=" + this.kGA + ", mUuid=" + this.kGB + ", mUuidMask=" + this.kGC + ", mServiceDataUuid=" + d.toString(this.kGD) + ", mServiceData=" + Arrays.toString(this.kGE) + ", mServiceDataMask=" + Arrays.toString(this.kGF) + ", mManufacturerId=" + this.kGG + ", mManufacturerData=" + Arrays.toString(this.kGH) + ", mManufacturerDataMask=" + Arrays.toString(this.kGI) + "]";
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
      if (this.kGA != null) {
        break label328;
      }
      i = 0;
      label46:
      paramParcel.writeInt(i);
      if (this.kGA != null) {
        paramParcel.writeString(this.kGA);
      }
      if (this.kGB != null) {
        break label333;
      }
      i = 0;
      label75:
      paramParcel.writeInt(i);
      if (this.kGB != null)
      {
        paramParcel.writeParcelable(this.kGB, paramInt);
        if (this.kGC != null) {
          break label338;
        }
        i = 0;
        label105:
        paramParcel.writeInt(i);
        if (this.kGC != null) {
          paramParcel.writeParcelable(this.kGC, paramInt);
        }
      }
      if (this.kGD != null) {
        break label343;
      }
      i = 0;
      label135:
      paramParcel.writeInt(i);
      if (this.kGD != null)
      {
        paramParcel.writeParcelable(this.kGD, paramInt);
        if (this.kGE != null) {
          break label348;
        }
        paramInt = 0;
        label165:
        paramParcel.writeInt(paramInt);
        if (this.kGE != null)
        {
          paramParcel.writeInt(this.kGE.length);
          paramParcel.writeByteArray(this.kGE);
          if (this.kGF != null) {
            break label353;
          }
          paramInt = 0;
          label203:
          paramParcel.writeInt(paramInt);
          if (this.kGF != null)
          {
            paramParcel.writeInt(this.kGF.length);
            paramParcel.writeByteArray(this.kGF);
          }
        }
      }
      paramParcel.writeInt(this.kGG);
      if (this.kGH != null) {
        break label358;
      }
      paramInt = 0;
      label249:
      paramParcel.writeInt(paramInt);
      if (this.kGH != null)
      {
        paramParcel.writeInt(this.kGH.length);
        paramParcel.writeByteArray(this.kGH);
        if (this.kGI != null) {
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
      if (this.kGI != null)
      {
        paramParcel.writeInt(this.kGI.length);
        paramParcel.writeByteArray(this.kGI);
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
    String kGA;
    ParcelUuid kGB;
    ParcelUuid kGD;
    byte[] kGE;
    byte[] kGF;
    int kGG = -1;
    byte[] kGH;
    byte[] kGI;
    ParcelUuid kGK;
    String mDeviceName;
    
    public final a a(ParcelUuid paramParcelUuid)
    {
      this.kGB = paramParcelUuid;
      this.kGK = null;
      return this;
    }
    
    public final ScanFilterCompat bjs()
    {
      AppMethodBeat.i(144625);
      ScanFilterCompat localScanFilterCompat = new ScanFilterCompat(this.mDeviceName, this.kGA, this.kGB, this.kGK, this.kGD, this.kGE, this.kGF, this.kGG, this.kGH, this.kGI, (byte)0);
      AppMethodBeat.o(144625);
      return localScanFilterCompat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat
 * JD-Core Version:    0.7.0.1
 */