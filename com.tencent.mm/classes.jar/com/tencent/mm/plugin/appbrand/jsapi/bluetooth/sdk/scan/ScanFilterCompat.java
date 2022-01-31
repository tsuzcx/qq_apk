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
  private static final ScanFilterCompat hHV;
  final String hHM;
  final ParcelUuid hHN;
  final ParcelUuid hHO;
  final ParcelUuid hHP;
  final byte[] hHQ;
  final byte[] hHR;
  final int hHS;
  final byte[] hHT;
  final byte[] hHU;
  final String mDeviceName;
  
  static
  {
    AppMethodBeat.i(94319);
    hHV = new ScanFilterCompat.a().aCs();
    CREATOR = new ScanFilterCompat.1();
    AppMethodBeat.o(94319);
  }
  
  private ScanFilterCompat(String paramString1, String paramString2, ParcelUuid paramParcelUuid1, ParcelUuid paramParcelUuid2, ParcelUuid paramParcelUuid3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    this.mDeviceName = paramString1;
    this.hHN = paramParcelUuid1;
    this.hHO = paramParcelUuid2;
    this.hHM = paramString2;
    this.hHP = paramParcelUuid3;
    this.hHQ = paramArrayOfByte1;
    this.hHR = paramArrayOfByte2;
    this.hHS = paramInt;
    this.hHT = paramArrayOfByte3;
    this.hHU = paramArrayOfByte4;
  }
  
  static boolean a(UUID paramUUID1, UUID paramUUID2, UUID paramUUID3)
  {
    AppMethodBeat.i(94315);
    if (paramUUID2 == null)
    {
      boolean bool = paramUUID1.equals(paramUUID3);
      AppMethodBeat.o(94315);
      return bool;
    }
    if ((paramUUID1.getLeastSignificantBits() & paramUUID2.getLeastSignificantBits()) != (paramUUID3.getLeastSignificantBits() & paramUUID2.getLeastSignificantBits()))
    {
      AppMethodBeat.o(94315);
      return false;
    }
    if ((paramUUID1.getMostSignificantBits() & paramUUID2.getMostSignificantBits()) == (paramUUID3.getMostSignificantBits() & paramUUID2.getMostSignificantBits()))
    {
      AppMethodBeat.o(94315);
      return true;
    }
    AppMethodBeat.o(94315);
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
    AppMethodBeat.i(94318);
    if (this == paramObject)
    {
      AppMethodBeat.o(94318);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(94318);
      return false;
    }
    paramObject = (ScanFilterCompat)paramObject;
    if ((d.equals(this.mDeviceName, paramObject.mDeviceName)) && (d.equals(this.hHM, paramObject.hHM)) && (this.hHS == paramObject.hHS) && (d.deepEquals(this.hHT, paramObject.hHT)) && (d.deepEquals(this.hHU, paramObject.hHU)) && (d.deepEquals(this.hHP, paramObject.hHP)) && (d.deepEquals(this.hHQ, paramObject.hHQ)) && (d.deepEquals(this.hHR, paramObject.hHR)) && (d.equals(this.hHN, paramObject.hHN)) && (d.equals(this.hHO, paramObject.hHO)))
    {
      AppMethodBeat.o(94318);
      return true;
    }
    AppMethodBeat.o(94318);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(94317);
    int i = Arrays.hashCode(new Object[] { this.mDeviceName, this.hHM, Integer.valueOf(this.hHS), this.hHT, this.hHU, this.hHP, this.hHQ, this.hHR, this.hHN, this.hHO });
    AppMethodBeat.o(94317);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(94316);
    String str = "BluetoothLeScanFilter [mDeviceName=" + this.mDeviceName + ", mDeviceAddress=" + this.hHM + ", mUuid=" + this.hHN + ", mUuidMask=" + this.hHO + ", mServiceDataUuid=" + d.toString(this.hHP) + ", mServiceData=" + Arrays.toString(this.hHQ) + ", mServiceDataMask=" + Arrays.toString(this.hHR) + ", mManufacturerId=" + this.hHS + ", mManufacturerData=" + Arrays.toString(this.hHT) + ", mManufacturerDataMask=" + Arrays.toString(this.hHU) + "]";
    AppMethodBeat.o(94316);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(94314);
    int i;
    if (this.mDeviceName == null)
    {
      i = 0;
      paramParcel.writeInt(i);
      if (this.mDeviceName != null) {
        paramParcel.writeString(this.mDeviceName);
      }
      if (this.hHM != null) {
        break label328;
      }
      i = 0;
      label46:
      paramParcel.writeInt(i);
      if (this.hHM != null) {
        paramParcel.writeString(this.hHM);
      }
      if (this.hHN != null) {
        break label333;
      }
      i = 0;
      label75:
      paramParcel.writeInt(i);
      if (this.hHN != null)
      {
        paramParcel.writeParcelable(this.hHN, paramInt);
        if (this.hHO != null) {
          break label338;
        }
        i = 0;
        label105:
        paramParcel.writeInt(i);
        if (this.hHO != null) {
          paramParcel.writeParcelable(this.hHO, paramInt);
        }
      }
      if (this.hHP != null) {
        break label343;
      }
      i = 0;
      label135:
      paramParcel.writeInt(i);
      if (this.hHP != null)
      {
        paramParcel.writeParcelable(this.hHP, paramInt);
        if (this.hHQ != null) {
          break label348;
        }
        paramInt = 0;
        label165:
        paramParcel.writeInt(paramInt);
        if (this.hHQ != null)
        {
          paramParcel.writeInt(this.hHQ.length);
          paramParcel.writeByteArray(this.hHQ);
          if (this.hHR != null) {
            break label353;
          }
          paramInt = 0;
          label203:
          paramParcel.writeInt(paramInt);
          if (this.hHR != null)
          {
            paramParcel.writeInt(this.hHR.length);
            paramParcel.writeByteArray(this.hHR);
          }
        }
      }
      paramParcel.writeInt(this.hHS);
      if (this.hHT != null) {
        break label358;
      }
      paramInt = 0;
      label249:
      paramParcel.writeInt(paramInt);
      if (this.hHT != null)
      {
        paramParcel.writeInt(this.hHT.length);
        paramParcel.writeByteArray(this.hHT);
        if (this.hHU != null) {
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
      if (this.hHU != null)
      {
        paramParcel.writeInt(this.hHU.length);
        paramParcel.writeByteArray(this.hHU);
      }
      AppMethodBeat.o(94314);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat
 * JD-Core Version:    0.7.0.1
 */