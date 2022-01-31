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
  private BluetoothDevice hIc;
  public f hId;
  public int hIe;
  private long hIf;
  
  static
  {
    AppMethodBeat.i(94334);
    CREATOR = new ScanResultCompat.1();
    AppMethodBeat.o(94334);
  }
  
  public ScanResultCompat(BluetoothDevice paramBluetoothDevice, f paramf, int paramInt, long paramLong)
  {
    this.hIc = paramBluetoothDevice;
    this.hId = paramf;
    this.hIe = paramInt;
    this.hIf = paramLong;
  }
  
  @TargetApi(21)
  ScanResultCompat(ScanResult paramScanResult)
  {
    AppMethodBeat.i(94328);
    this.hIc = paramScanResult.getDevice();
    this.hId = new f(paramScanResult.getScanRecord());
    this.hIe = paramScanResult.getRssi();
    this.hIf = System.currentTimeMillis();
    AppMethodBeat.o(94328);
  }
  
  private ScanResultCompat(Parcel paramParcel)
  {
    AppMethodBeat.i(94329);
    if (paramParcel.readInt() == 1) {
      this.hIc = ((BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(paramParcel));
    }
    if (paramParcel.readInt() == 1) {
      this.hId = f.ai(paramParcel.createByteArray());
    }
    this.hIe = paramParcel.readInt();
    this.hIf = paramParcel.readLong();
    AppMethodBeat.o(94329);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(94332);
    if (this == paramObject)
    {
      AppMethodBeat.o(94332);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(94332);
      return false;
    }
    paramObject = (ScanResultCompat)paramObject;
    if ((d.equals(this.hIc, paramObject.hIc)) && (this.hIe == paramObject.hIe) && (d.equals(this.hId, paramObject.hId)) && (this.hIf == paramObject.hIf))
    {
      AppMethodBeat.o(94332);
      return true;
    }
    AppMethodBeat.o(94332);
    return false;
  }
  
  public final BluetoothDevice getDevice()
  {
    if (this.hIc != null) {
      return this.hIc;
    }
    return null;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(94331);
    int i = Arrays.hashCode(new Object[] { this.hIc, Integer.valueOf(this.hIe), this.hId, Long.valueOf(this.hIf) });
    AppMethodBeat.o(94331);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(94333);
    String str = "ScanResult{mDevice=" + this.hIc + ", mScanRecord=" + d.toString(this.hId) + ", mRssi=" + this.hIe + ", mTimestampNanos=" + this.hIf + '}';
    AppMethodBeat.o(94333);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(94330);
    if (this.hIc != null)
    {
      paramParcel.writeInt(1);
      this.hIc.writeToParcel(paramParcel, paramInt);
      if (this.hId == null) {
        break label79;
      }
      paramParcel.writeInt(1);
      paramParcel.writeByteArray(this.hId.mBytes);
    }
    for (;;)
    {
      paramParcel.writeInt(this.hIe);
      paramParcel.writeLong(this.hIf);
      AppMethodBeat.o(94330);
      return;
      paramParcel.writeInt(0);
      break;
      label79:
      paramParcel.writeInt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanResultCompat
 * JD-Core Version:    0.7.0.1
 */