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
  private static final ScanFilterCompat rOQ;
  final String mDeviceName;
  final String rOH;
  final ParcelUuid rOI;
  final ParcelUuid rOJ;
  final ParcelUuid rOK;
  final byte[] rOL;
  final byte[] rOM;
  final int rON;
  final byte[] rOO;
  final byte[] rOP;
  
  static
  {
    AppMethodBeat.i(144631);
    rOQ = new a().crm();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(144631);
  }
  
  private ScanFilterCompat(String paramString1, String paramString2, ParcelUuid paramParcelUuid1, ParcelUuid paramParcelUuid2, ParcelUuid paramParcelUuid3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    this.mDeviceName = paramString1;
    this.rOI = paramParcelUuid1;
    this.rOJ = paramParcelUuid2;
    this.rOH = paramString2;
    this.rOK = paramParcelUuid3;
    this.rOL = paramArrayOfByte1;
    this.rOM = paramArrayOfByte2;
    this.rON = paramInt;
    this.rOO = paramArrayOfByte3;
    this.rOP = paramArrayOfByte4;
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
    if ((g.equals(this.mDeviceName, paramObject.mDeviceName)) && (g.equals(this.rOH, paramObject.rOH)) && (this.rON == paramObject.rON) && (g.M(this.rOO, paramObject.rOO)) && (g.M(this.rOP, paramObject.rOP)) && (g.M(this.rOK, paramObject.rOK)) && (g.M(this.rOL, paramObject.rOL)) && (g.M(this.rOM, paramObject.rOM)) && (g.equals(this.rOI, paramObject.rOI)) && (g.equals(this.rOJ, paramObject.rOJ)))
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
    int i = Arrays.hashCode(new Object[] { this.mDeviceName, this.rOH, Integer.valueOf(this.rON), this.rOO, this.rOP, this.rOK, this.rOL, this.rOM, this.rOI, this.rOJ });
    AppMethodBeat.o(144629);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(144628);
    String str = "BluetoothLeScanFilter [mDeviceName=" + this.mDeviceName + ", mDeviceAddress=" + this.rOH + ", mUuid=" + this.rOI + ", mUuidMask=" + this.rOJ + ", mServiceDataUuid=" + g.ca(this.rOK) + ", mServiceData=" + Arrays.toString(this.rOL) + ", mServiceDataMask=" + Arrays.toString(this.rOM) + ", mManufacturerId=" + this.rON + ", mManufacturerData=" + Arrays.toString(this.rOO) + ", mManufacturerDataMask=" + Arrays.toString(this.rOP) + "]";
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
      if (this.rOH != null) {
        break label328;
      }
      i = 0;
      label46:
      paramParcel.writeInt(i);
      if (this.rOH != null) {
        paramParcel.writeString(this.rOH);
      }
      if (this.rOI != null) {
        break label333;
      }
      i = 0;
      label75:
      paramParcel.writeInt(i);
      if (this.rOI != null)
      {
        paramParcel.writeParcelable(this.rOI, paramInt);
        if (this.rOJ != null) {
          break label338;
        }
        i = 0;
        label105:
        paramParcel.writeInt(i);
        if (this.rOJ != null) {
          paramParcel.writeParcelable(this.rOJ, paramInt);
        }
      }
      if (this.rOK != null) {
        break label343;
      }
      i = 0;
      label135:
      paramParcel.writeInt(i);
      if (this.rOK != null)
      {
        paramParcel.writeParcelable(this.rOK, paramInt);
        if (this.rOL != null) {
          break label348;
        }
        paramInt = 0;
        label165:
        paramParcel.writeInt(paramInt);
        if (this.rOL != null)
        {
          paramParcel.writeInt(this.rOL.length);
          paramParcel.writeByteArray(this.rOL);
          if (this.rOM != null) {
            break label353;
          }
          paramInt = 0;
          label203:
          paramParcel.writeInt(paramInt);
          if (this.rOM != null)
          {
            paramParcel.writeInt(this.rOM.length);
            paramParcel.writeByteArray(this.rOM);
          }
        }
      }
      paramParcel.writeInt(this.rON);
      if (this.rOO != null) {
        break label358;
      }
      paramInt = 0;
      label249:
      paramParcel.writeInt(paramInt);
      if (this.rOO != null)
      {
        paramParcel.writeInt(this.rOO.length);
        paramParcel.writeByteArray(this.rOO);
        if (this.rOP != null) {
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
      if (this.rOP != null)
      {
        paramParcel.writeInt(this.rOP.length);
        paramParcel.writeByteArray(this.rOP);
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
    String rOH;
    ParcelUuid rOI;
    ParcelUuid rOK;
    byte[] rOL;
    byte[] rOM;
    int rON = -1;
    byte[] rOO;
    byte[] rOP;
    ParcelUuid rOR;
    
    public final a a(ParcelUuid paramParcelUuid)
    {
      this.rOI = paramParcelUuid;
      this.rOR = null;
      return this;
    }
    
    public final ScanFilterCompat crm()
    {
      AppMethodBeat.i(144625);
      ScanFilterCompat localScanFilterCompat = new ScanFilterCompat(this.mDeviceName, this.rOH, this.rOI, this.rOR, this.rOK, this.rOL, this.rOM, this.rON, this.rOO, this.rOP, (byte)0);
      AppMethodBeat.o(144625);
      return localScanFilterCompat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat
 * JD-Core Version:    0.7.0.1
 */