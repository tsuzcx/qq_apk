package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;
import java.util.Arrays;

public class ScanResultCompat
  implements Parcelable
{
  public static final Parcelable.Creator<ScanResultCompat> CREATOR;
  public Boolean rNx;
  private BluetoothDevice rOZ;
  public i rPa;
  public int rPb;
  private long rPc;
  
  static
  {
    AppMethodBeat.i(144646);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(144646);
  }
  
  public ScanResultCompat(BluetoothDevice paramBluetoothDevice, i parami, int paramInt, long paramLong)
  {
    this.rOZ = paramBluetoothDevice;
    this.rPa = parami;
    this.rPb = paramInt;
    this.rPc = paramLong;
    this.rNx = null;
  }
  
  ScanResultCompat(ScanResult paramScanResult)
  {
    AppMethodBeat.i(144640);
    this.rOZ = paramScanResult.getDevice();
    Object localObject = paramScanResult.getScanRecord();
    if (localObject != null) {
      if (!a.cqY().rMo) {
        break label88;
      }
    }
    label88:
    for (localObject = i.aV(((ScanRecord)localObject).getBytes());; localObject = new i((ScanRecord)localObject))
    {
      this.rPa = ((i)localObject);
      this.rPb = paramScanResult.getRssi();
      this.rPc = System.currentTimeMillis();
      if (Build.VERSION.SDK_INT < 26) {
        break;
      }
      this.rNx = Boolean.valueOf(paramScanResult.isConnectable());
      AppMethodBeat.o(144640);
      return;
    }
    this.rNx = null;
    AppMethodBeat.o(144640);
  }
  
  private ScanResultCompat(Parcel paramParcel)
  {
    AppMethodBeat.i(144641);
    if (paramParcel.readInt() == 1) {
      this.rOZ = ((BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(paramParcel));
    }
    if (paramParcel.readInt() == 1) {
      this.rPa = i.aV(paramParcel.createByteArray());
    }
    this.rPb = paramParcel.readInt();
    this.rPc = paramParcel.readLong();
    int i = paramParcel.readInt();
    if (-1 == i)
    {
      this.rNx = null;
      AppMethodBeat.o(144641);
      return;
    }
    if (1 == i) {}
    for (boolean bool = true;; bool = false)
    {
      this.rNx = Boolean.valueOf(bool);
      AppMethodBeat.o(144641);
      return;
    }
  }
  
  public final BluetoothDevice crn()
  {
    if (this.rOZ != null) {
      return this.rOZ;
    }
    return null;
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
    if ((g.equals(this.rOZ, paramObject.rOZ)) && (this.rPb == paramObject.rPb) && (g.equals(this.rPa, paramObject.rPa)) && (this.rPc == paramObject.rPc))
    {
      AppMethodBeat.o(144644);
      return true;
    }
    AppMethodBeat.o(144644);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(144643);
    int i = Arrays.hashCode(new Object[] { this.rOZ, Integer.valueOf(this.rPb), this.rPa, Long.valueOf(this.rPc) });
    AppMethodBeat.o(144643);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(144645);
    String str = "ScanResult{mDevice=" + this.rOZ + ", mScanRecord=" + g.ca(this.rPa) + ", mRssi=" + this.rPb + ", mTimestampNanos=" + this.rPc + '}';
    AppMethodBeat.o(144645);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(144642);
    if (this.rOZ != null)
    {
      paramParcel.writeInt(1);
      this.rOZ.writeToParcel(paramParcel, paramInt);
      if (this.rPa == null) {
        break label95;
      }
      paramParcel.writeInt(1);
      paramParcel.writeByteArray(this.rPa.rOX);
      label51:
      paramParcel.writeInt(this.rPb);
      paramParcel.writeLong(this.rPc);
      if (this.rNx != null) {
        break label103;
      }
      paramInt = -1;
    }
    for (;;)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(144642);
      return;
      paramParcel.writeInt(0);
      break;
      label95:
      paramParcel.writeInt(0);
      break label51;
      label103:
      paramInt = i;
      if (!this.rNx.booleanValue()) {
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanResultCompat
 * JD-Core Version:    0.7.0.1
 */