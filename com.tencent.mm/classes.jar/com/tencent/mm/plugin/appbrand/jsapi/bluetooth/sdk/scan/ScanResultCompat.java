package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
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
  private BluetoothDevice oLg;
  public i oLh;
  public int oLi;
  private long oLj;
  
  static
  {
    AppMethodBeat.i(144646);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(144646);
  }
  
  public ScanResultCompat(BluetoothDevice paramBluetoothDevice, i parami, int paramInt, long paramLong)
  {
    this.oLg = paramBluetoothDevice;
    this.oLh = parami;
    this.oLi = paramInt;
    this.oLj = paramLong;
  }
  
  @TargetApi(21)
  ScanResultCompat(ScanResult paramScanResult)
  {
    AppMethodBeat.i(144640);
    this.oLg = paramScanResult.getDevice();
    Object localObject = paramScanResult.getScanRecord();
    if (localObject != null) {
      if (!a.bQQ().oIF) {
        break label69;
      }
    }
    label69:
    for (localObject = i.aV(((ScanRecord)localObject).getBytes());; localObject = new i((ScanRecord)localObject))
    {
      this.oLh = ((i)localObject);
      this.oLi = paramScanResult.getRssi();
      this.oLj = System.currentTimeMillis();
      AppMethodBeat.o(144640);
      return;
    }
  }
  
  private ScanResultCompat(Parcel paramParcel)
  {
    AppMethodBeat.i(144641);
    if (paramParcel.readInt() == 1) {
      this.oLg = ((BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(paramParcel));
    }
    if (paramParcel.readInt() == 1) {
      this.oLh = i.aV(paramParcel.createByteArray());
    }
    this.oLi = paramParcel.readInt();
    this.oLj = paramParcel.readLong();
    AppMethodBeat.o(144641);
  }
  
  public final BluetoothDevice bRf()
  {
    if (this.oLg != null) {
      return this.oLg;
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
    if ((g.equals(this.oLg, paramObject.oLg)) && (this.oLi == paramObject.oLi) && (g.equals(this.oLh, paramObject.oLh)) && (this.oLj == paramObject.oLj))
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
    int i = Arrays.hashCode(new Object[] { this.oLg, Integer.valueOf(this.oLi), this.oLh, Long.valueOf(this.oLj) });
    AppMethodBeat.o(144643);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(144645);
    String str = "ScanResult{mDevice=" + this.oLg + ", mScanRecord=" + g.cG(this.oLh) + ", mRssi=" + this.oLi + ", mTimestampNanos=" + this.oLj + '}';
    AppMethodBeat.o(144645);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(144642);
    if (this.oLg != null)
    {
      paramParcel.writeInt(1);
      this.oLg.writeToParcel(paramParcel, paramInt);
      if (this.oLh == null) {
        break label79;
      }
      paramParcel.writeInt(1);
      paramParcel.writeByteArray(this.oLh.oLe);
    }
    for (;;)
    {
      paramParcel.writeInt(this.oLi);
      paramParcel.writeLong(this.oLj);
      AppMethodBeat.o(144642);
      return;
      paramParcel.writeInt(0);
      break;
      label79:
      paramParcel.writeInt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanResultCompat
 * JD-Core Version:    0.7.0.1
 */