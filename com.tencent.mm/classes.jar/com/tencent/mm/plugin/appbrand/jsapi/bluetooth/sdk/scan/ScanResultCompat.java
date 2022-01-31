package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public class ScanResultCompat
  implements Parcelable
{
  public static final Parcelable.Creator<ScanResultCompat> CREATOR = new ScanResultCompat.1();
  private BluetoothDevice gof;
  public f gog;
  public int goh;
  private long goi;
  
  public ScanResultCompat(BluetoothDevice paramBluetoothDevice, f paramf, int paramInt, long paramLong)
  {
    this.gof = paramBluetoothDevice;
    this.gog = paramf;
    this.goh = paramInt;
    this.goi = paramLong;
  }
  
  @TargetApi(21)
  ScanResultCompat(ScanResult paramScanResult)
  {
    this.gof = paramScanResult.getDevice();
    this.gog = new f(paramScanResult.getScanRecord());
    this.goh = paramScanResult.getRssi();
    this.goi = System.currentTimeMillis();
  }
  
  private ScanResultCompat(Parcel paramParcel)
  {
    if (paramParcel.readInt() == 1) {
      this.gof = ((BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(paramParcel));
    }
    if (paramParcel.readInt() == 1) {
      this.gog = f.O(paramParcel.createByteArray());
    }
    this.goh = paramParcel.readInt();
    this.goi = paramParcel.readLong();
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
      paramObject = (ScanResultCompat)paramObject;
    } while ((d.equals(this.gof, paramObject.gof)) && (this.goh == paramObject.goh) && (d.equals(this.gog, paramObject.gog)) && (this.goi == paramObject.goi));
    return false;
  }
  
  public final BluetoothDevice getDevice()
  {
    if (this.gof != null) {
      return this.gof;
    }
    return null;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.gof, Integer.valueOf(this.goh), this.gog, Long.valueOf(this.goi) });
  }
  
  public String toString()
  {
    return "ScanResult{mDevice=" + this.gof + ", mScanRecord=" + d.toString(this.gog) + ", mRssi=" + this.goh + ", mTimestampNanos=" + this.goi + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.gof != null)
    {
      paramParcel.writeInt(1);
      this.gof.writeToParcel(paramParcel, paramInt);
      if (this.gog == null) {
        break label69;
      }
      paramParcel.writeInt(1);
      paramParcel.writeByteArray(this.gog.mBytes);
    }
    for (;;)
    {
      paramParcel.writeInt(this.goh);
      paramParcel.writeLong(this.goi);
      return;
      paramParcel.writeInt(0);
      break;
      label69:
      paramParcel.writeInt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanResultCompat
 * JD-Core Version:    0.7.0.1
 */