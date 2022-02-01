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
  private BluetoothDevice jLq;
  public f jLr;
  public int jLs;
  private long jLt;
  
  static
  {
    AppMethodBeat.i(144646);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(144646);
  }
  
  public ScanResultCompat(BluetoothDevice paramBluetoothDevice, f paramf, int paramInt, long paramLong)
  {
    this.jLq = paramBluetoothDevice;
    this.jLr = paramf;
    this.jLs = paramInt;
    this.jLt = paramLong;
  }
  
  @TargetApi(21)
  ScanResultCompat(ScanResult paramScanResult)
  {
    AppMethodBeat.i(144640);
    this.jLq = paramScanResult.getDevice();
    this.jLr = new f(paramScanResult.getScanRecord());
    this.jLs = paramScanResult.getRssi();
    this.jLt = System.currentTimeMillis();
    AppMethodBeat.o(144640);
  }
  
  private ScanResultCompat(Parcel paramParcel)
  {
    AppMethodBeat.i(144641);
    if (paramParcel.readInt() == 1) {
      this.jLq = ((BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(paramParcel));
    }
    if (paramParcel.readInt() == 1) {
      this.jLr = f.at(paramParcel.createByteArray());
    }
    this.jLs = paramParcel.readInt();
    this.jLt = paramParcel.readLong();
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
    if ((d.equals(this.jLq, paramObject.jLq)) && (this.jLs == paramObject.jLs) && (d.equals(this.jLr, paramObject.jLr)) && (this.jLt == paramObject.jLt))
    {
      AppMethodBeat.o(144644);
      return true;
    }
    AppMethodBeat.o(144644);
    return false;
  }
  
  public final BluetoothDevice getDevice()
  {
    if (this.jLq != null) {
      return this.jLq;
    }
    return null;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(144643);
    int i = Arrays.hashCode(new Object[] { this.jLq, Integer.valueOf(this.jLs), this.jLr, Long.valueOf(this.jLt) });
    AppMethodBeat.o(144643);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(144645);
    String str = "ScanResult{mDevice=" + this.jLq + ", mScanRecord=" + d.toString(this.jLr) + ", mRssi=" + this.jLs + ", mTimestampNanos=" + this.jLt + '}';
    AppMethodBeat.o(144645);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(144642);
    if (this.jLq != null)
    {
      paramParcel.writeInt(1);
      this.jLq.writeToParcel(paramParcel, paramInt);
      if (this.jLr == null) {
        break label79;
      }
      paramParcel.writeInt(1);
      paramParcel.writeByteArray(this.jLr.jLp);
    }
    for (;;)
    {
      paramParcel.writeInt(this.jLs);
      paramParcel.writeLong(this.jLt);
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