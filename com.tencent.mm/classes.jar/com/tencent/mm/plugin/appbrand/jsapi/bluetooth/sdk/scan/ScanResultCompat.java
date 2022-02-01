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
  private BluetoothDevice kKg;
  public f kKh;
  public int kKi;
  private long kKj;
  
  static
  {
    AppMethodBeat.i(144646);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(144646);
  }
  
  public ScanResultCompat(BluetoothDevice paramBluetoothDevice, f paramf, int paramInt, long paramLong)
  {
    this.kKg = paramBluetoothDevice;
    this.kKh = paramf;
    this.kKi = paramInt;
    this.kKj = paramLong;
  }
  
  @TargetApi(21)
  ScanResultCompat(ScanResult paramScanResult)
  {
    AppMethodBeat.i(144640);
    this.kKg = paramScanResult.getDevice();
    this.kKh = new f(paramScanResult.getScanRecord());
    this.kKi = paramScanResult.getRssi();
    this.kKj = System.currentTimeMillis();
    AppMethodBeat.o(144640);
  }
  
  private ScanResultCompat(Parcel paramParcel)
  {
    AppMethodBeat.i(144641);
    if (paramParcel.readInt() == 1) {
      this.kKg = ((BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(paramParcel));
    }
    if (paramParcel.readInt() == 1) {
      this.kKh = f.as(paramParcel.createByteArray());
    }
    this.kKi = paramParcel.readInt();
    this.kKj = paramParcel.readLong();
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
    if ((d.equals(this.kKg, paramObject.kKg)) && (this.kKi == paramObject.kKi) && (d.equals(this.kKh, paramObject.kKh)) && (this.kKj == paramObject.kKj))
    {
      AppMethodBeat.o(144644);
      return true;
    }
    AppMethodBeat.o(144644);
    return false;
  }
  
  public final BluetoothDevice getDevice()
  {
    if (this.kKg != null) {
      return this.kKg;
    }
    return null;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(144643);
    int i = Arrays.hashCode(new Object[] { this.kKg, Integer.valueOf(this.kKi), this.kKh, Long.valueOf(this.kKj) });
    AppMethodBeat.o(144643);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(144645);
    String str = "ScanResult{mDevice=" + this.kKg + ", mScanRecord=" + d.toString(this.kKh) + ", mRssi=" + this.kKi + ", mTimestampNanos=" + this.kKj + '}';
    AppMethodBeat.o(144645);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(144642);
    if (this.kKg != null)
    {
      paramParcel.writeInt(1);
      this.kKg.writeToParcel(paramParcel, paramInt);
      if (this.kKh == null) {
        break label79;
      }
      paramParcel.writeInt(1);
      paramParcel.writeByteArray(this.kKh.kKf);
    }
    for (;;)
    {
      paramParcel.writeInt(this.kKi);
      paramParcel.writeLong(this.kKj);
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