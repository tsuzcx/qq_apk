package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public class ScanResultCompat
  implements Parcelable
{
  public static final Parcelable.Creator<ScanResultCompat> CREATOR;
  private BluetoothDevice kGR;
  public f kGS;
  public int kGT;
  private long kGU;
  
  static
  {
    AppMethodBeat.i(144646);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(144646);
  }
  
  public ScanResultCompat(BluetoothDevice paramBluetoothDevice, f paramf, int paramInt, long paramLong)
  {
    this.kGR = paramBluetoothDevice;
    this.kGS = paramf;
    this.kGT = paramInt;
    this.kGU = paramLong;
  }
  
  @TargetApi(21)
  ScanResultCompat(ScanResult paramScanResult)
  {
    AppMethodBeat.i(144640);
    this.kGR = paramScanResult.getDevice();
    this.kGS = new f(paramScanResult.getScanRecord());
    this.kGT = paramScanResult.getRssi();
    this.kGU = System.currentTimeMillis();
    AppMethodBeat.o(144640);
  }
  
  private ScanResultCompat(Parcel paramParcel)
  {
    AppMethodBeat.i(144641);
    if (paramParcel.readInt() == 1) {
      this.kGR = ((BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(paramParcel));
    }
    if (paramParcel.readInt() == 1) {
      this.kGS = f.as(paramParcel.createByteArray());
    }
    this.kGT = paramParcel.readInt();
    this.kGU = paramParcel.readLong();
    AppMethodBeat.o(144641);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(144644);
    if (this == paramObject)
    {
      AppMethodBeat.o(144644);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(144644);
      return false;
    }
    paramObject = (ScanResultCompat)paramObject;
    if ((d.equals(this.kGR, paramObject.kGR)) && (this.kGT == paramObject.kGT) && (d.equals(this.kGS, paramObject.kGS)) && (this.kGU == paramObject.kGU))
    {
      AppMethodBeat.o(144644);
      return true;
    }
    AppMethodBeat.o(144644);
    return false;
  }
  
  public final BluetoothDevice getDevice()
  {
    if (this.kGR != null) {
      return this.kGR;
    }
    return null;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(144643);
    int i = Arrays.hashCode(new Object[] { this.kGR, Integer.valueOf(this.kGT), this.kGS, Long.valueOf(this.kGU) });
    AppMethodBeat.o(144643);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(144645);
    String str = "ScanResult{mDevice=" + this.kGR + ", mScanRecord=" + d.toString(this.kGS) + ", mRssi=" + this.kGT + ", mTimestampNanos=" + this.kGU + '}';
    AppMethodBeat.o(144645);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(144642);
    if (this.kGR != null)
    {
      paramParcel.writeInt(1);
      this.kGR.writeToParcel(paramParcel, paramInt);
      if (this.kGS == null) {
        break label79;
      }
      paramParcel.writeInt(1);
      paramParcel.writeByteArray(this.kGS.kGQ);
    }
    for (;;)
    {
      paramParcel.writeInt(this.kGT);
      paramParcel.writeLong(this.kGU);
      AppMethodBeat.o(144642);
      return;
      paramParcel.writeInt(0);
      break;
      label79:
      paramParcel.writeInt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanResultCompat
 * JD-Core Version:    0.7.0.1
 */