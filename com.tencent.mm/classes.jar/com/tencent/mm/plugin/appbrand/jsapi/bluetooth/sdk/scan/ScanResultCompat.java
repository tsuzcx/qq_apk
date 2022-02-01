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
  private BluetoothDevice klR;
  public f klS;
  public int klT;
  private long klU;
  
  static
  {
    AppMethodBeat.i(144646);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(144646);
  }
  
  public ScanResultCompat(BluetoothDevice paramBluetoothDevice, f paramf, int paramInt, long paramLong)
  {
    this.klR = paramBluetoothDevice;
    this.klS = paramf;
    this.klT = paramInt;
    this.klU = paramLong;
  }
  
  @TargetApi(21)
  ScanResultCompat(ScanResult paramScanResult)
  {
    AppMethodBeat.i(144640);
    this.klR = paramScanResult.getDevice();
    this.klS = new f(paramScanResult.getScanRecord());
    this.klT = paramScanResult.getRssi();
    this.klU = System.currentTimeMillis();
    AppMethodBeat.o(144640);
  }
  
  private ScanResultCompat(Parcel paramParcel)
  {
    AppMethodBeat.i(144641);
    if (paramParcel.readInt() == 1) {
      this.klR = ((BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(paramParcel));
    }
    if (paramParcel.readInt() == 1) {
      this.klS = f.as(paramParcel.createByteArray());
    }
    this.klT = paramParcel.readInt();
    this.klU = paramParcel.readLong();
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
    if ((d.equals(this.klR, paramObject.klR)) && (this.klT == paramObject.klT) && (d.equals(this.klS, paramObject.klS)) && (this.klU == paramObject.klU))
    {
      AppMethodBeat.o(144644);
      return true;
    }
    AppMethodBeat.o(144644);
    return false;
  }
  
  public final BluetoothDevice getDevice()
  {
    if (this.klR != null) {
      return this.klR;
    }
    return null;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(144643);
    int i = Arrays.hashCode(new Object[] { this.klR, Integer.valueOf(this.klT), this.klS, Long.valueOf(this.klU) });
    AppMethodBeat.o(144643);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(144645);
    String str = "ScanResult{mDevice=" + this.klR + ", mScanRecord=" + d.toString(this.klS) + ", mRssi=" + this.klT + ", mTimestampNanos=" + this.klU + '}';
    AppMethodBeat.o(144645);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(144642);
    if (this.klR != null)
    {
      paramParcel.writeInt(1);
      this.klR.writeToParcel(paramParcel, paramInt);
      if (this.klS == null) {
        break label79;
      }
      paramParcel.writeInt(1);
      paramParcel.writeByteArray(this.klS.klQ);
    }
    for (;;)
    {
      paramParcel.writeInt(this.klT);
      paramParcel.writeLong(this.klU);
      AppMethodBeat.o(144642);
      return;
      paramParcel.writeInt(0);
      break;
      label79:
      paramParcel.writeInt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanResultCompat
 * JD-Core Version:    0.7.0.1
 */