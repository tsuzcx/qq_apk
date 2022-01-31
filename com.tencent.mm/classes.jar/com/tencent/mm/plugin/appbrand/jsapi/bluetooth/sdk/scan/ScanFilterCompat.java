package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.UUID;

public class ScanFilterCompat
  implements Parcelable
{
  public static final Parcelable.Creator<ScanFilterCompat> CREATOR = new ScanFilterCompat.1();
  private static final ScanFilterCompat gnY = new ScanFilterCompat.a().aix();
  final String gnO;
  final String gnP;
  final ParcelUuid gnQ;
  final ParcelUuid gnR;
  final ParcelUuid gnS;
  final byte[] gnT;
  final byte[] gnU;
  final int gnV;
  final byte[] gnW;
  final byte[] gnX;
  
  private ScanFilterCompat(String paramString1, String paramString2, ParcelUuid paramParcelUuid1, ParcelUuid paramParcelUuid2, ParcelUuid paramParcelUuid3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    this.gnO = paramString1;
    this.gnQ = paramParcelUuid1;
    this.gnR = paramParcelUuid2;
    this.gnP = paramString2;
    this.gnS = paramParcelUuid3;
    this.gnT = paramArrayOfByte1;
    this.gnU = paramArrayOfByte2;
    this.gnV = paramInt;
    this.gnW = paramArrayOfByte3;
    this.gnX = paramArrayOfByte4;
  }
  
  static boolean a(UUID paramUUID1, UUID paramUUID2, UUID paramUUID3)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramUUID2 == null) {
      bool1 = paramUUID1.equals(paramUUID3);
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while ((paramUUID1.getLeastSignificantBits() & paramUUID2.getLeastSignificantBits()) != (paramUUID3.getLeastSignificantBits() & paramUUID2.getLeastSignificantBits()));
      bool1 = bool2;
    } while ((paramUUID1.getMostSignificantBits() & paramUUID2.getMostSignificantBits()) != (paramUUID3.getMostSignificantBits() & paramUUID2.getMostSignificantBits()));
    return true;
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
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (ScanFilterCompat)paramObject;
    } while ((d.equals(this.gnO, paramObject.gnO)) && (d.equals(this.gnP, paramObject.gnP)) && (this.gnV == paramObject.gnV) && (d.deepEquals(this.gnW, paramObject.gnW)) && (d.deepEquals(this.gnX, paramObject.gnX)) && (d.deepEquals(this.gnS, paramObject.gnS)) && (d.deepEquals(this.gnT, paramObject.gnT)) && (d.deepEquals(this.gnU, paramObject.gnU)) && (d.equals(this.gnQ, paramObject.gnQ)) && (d.equals(this.gnR, paramObject.gnR)));
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.gnO, this.gnP, Integer.valueOf(this.gnV), this.gnW, this.gnX, this.gnS, this.gnT, this.gnU, this.gnQ, this.gnR });
  }
  
  public String toString()
  {
    return "BluetoothLeScanFilter [mDeviceName=" + this.gnO + ", mDeviceAddress=" + this.gnP + ", mUuid=" + this.gnQ + ", mUuidMask=" + this.gnR + ", mServiceDataUuid=" + d.toString(this.gnS) + ", mServiceData=" + Arrays.toString(this.gnT) + ", mServiceDataMask=" + Arrays.toString(this.gnU) + ", mManufacturerId=" + this.gnV + ", mManufacturerData=" + Arrays.toString(this.gnW) + ", mManufacturerDataMask=" + Arrays.toString(this.gnX) + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 0;
    int i;
    if (this.gnO == null)
    {
      i = 0;
      paramParcel.writeInt(i);
      if (this.gnO != null) {
        paramParcel.writeString(this.gnO);
      }
      if (this.gnP != null) {
        break label318;
      }
      i = 0;
      label41:
      paramParcel.writeInt(i);
      if (this.gnP != null) {
        paramParcel.writeString(this.gnP);
      }
      if (this.gnQ != null) {
        break label323;
      }
      i = 0;
      label70:
      paramParcel.writeInt(i);
      if (this.gnQ != null)
      {
        paramParcel.writeParcelable(this.gnQ, paramInt);
        if (this.gnR != null) {
          break label328;
        }
        i = 0;
        label100:
        paramParcel.writeInt(i);
        if (this.gnR != null) {
          paramParcel.writeParcelable(this.gnR, paramInt);
        }
      }
      if (this.gnS != null) {
        break label333;
      }
      i = 0;
      label130:
      paramParcel.writeInt(i);
      if (this.gnS != null)
      {
        paramParcel.writeParcelable(this.gnS, paramInt);
        if (this.gnT != null) {
          break label338;
        }
        paramInt = 0;
        label160:
        paramParcel.writeInt(paramInt);
        if (this.gnT != null)
        {
          paramParcel.writeInt(this.gnT.length);
          paramParcel.writeByteArray(this.gnT);
          if (this.gnU != null) {
            break label343;
          }
          paramInt = 0;
          label198:
          paramParcel.writeInt(paramInt);
          if (this.gnU != null)
          {
            paramParcel.writeInt(this.gnU.length);
            paramParcel.writeByteArray(this.gnU);
          }
        }
      }
      paramParcel.writeInt(this.gnV);
      if (this.gnW != null) {
        break label348;
      }
      paramInt = 0;
      label244:
      paramParcel.writeInt(paramInt);
      if (this.gnW != null)
      {
        paramParcel.writeInt(this.gnW.length);
        paramParcel.writeByteArray(this.gnW);
        if (this.gnX != null) {
          break label353;
        }
      }
    }
    label318:
    label323:
    label328:
    label333:
    label338:
    label343:
    label348:
    label353:
    for (paramInt = j;; paramInt = 1)
    {
      paramParcel.writeInt(paramInt);
      if (this.gnX != null)
      {
        paramParcel.writeInt(this.gnX.length);
        paramParcel.writeByteArray(this.gnX);
      }
      return;
      i = 1;
      break;
      i = 1;
      break label41;
      i = 1;
      break label70;
      i = 1;
      break label100;
      i = 1;
      break label130;
      paramInt = 1;
      break label160;
      paramInt = 1;
      break label198;
      paramInt = 1;
      break label244;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat
 * JD-Core Version:    0.7.0.1
 */