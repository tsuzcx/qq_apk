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
  private BluetoothDevice lOM;
  public f lON;
  public int lOO;
  private long lOP;
  
  static
  {
    AppMethodBeat.i(144646);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(144646);
  }
  
  public ScanResultCompat(BluetoothDevice paramBluetoothDevice, f paramf, int paramInt, long paramLong)
  {
    this.lOM = paramBluetoothDevice;
    this.lON = paramf;
    this.lOO = paramInt;
    this.lOP = paramLong;
  }
  
  @TargetApi(21)
  ScanResultCompat(ScanResult paramScanResult)
  {
    AppMethodBeat.i(144640);
    this.lOM = paramScanResult.getDevice();
    Object localObject = paramScanResult.getScanRecord();
    if (localObject != null) {
      if (!a.bFm().lMq) {
        break label69;
      }
    }
    label69:
    for (localObject = f.aJ(((ScanRecord)localObject).getBytes());; localObject = new f((ScanRecord)localObject))
    {
      this.lON = ((f)localObject);
      this.lOO = paramScanResult.getRssi();
      this.lOP = System.currentTimeMillis();
      AppMethodBeat.o(144640);
      return;
    }
  }
  
  private ScanResultCompat(Parcel paramParcel)
  {
    AppMethodBeat.i(144641);
    if (paramParcel.readInt() == 1) {
      this.lOM = ((BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(paramParcel));
    }
    if (paramParcel.readInt() == 1) {
      this.lON = f.aJ(paramParcel.createByteArray());
    }
    this.lOO = paramParcel.readInt();
    this.lOP = paramParcel.readLong();
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
    if ((d.equals(this.lOM, paramObject.lOM)) && (this.lOO == paramObject.lOO) && (d.equals(this.lON, paramObject.lON)) && (this.lOP == paramObject.lOP))
    {
      AppMethodBeat.o(144644);
      return true;
    }
    AppMethodBeat.o(144644);
    return false;
  }
  
  public final BluetoothDevice getDevice()
  {
    if (this.lOM != null) {
      return this.lOM;
    }
    return null;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(144643);
    int i = Arrays.hashCode(new Object[] { this.lOM, Integer.valueOf(this.lOO), this.lON, Long.valueOf(this.lOP) });
    AppMethodBeat.o(144643);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(144645);
    String str = "ScanResult{mDevice=" + this.lOM + ", mScanRecord=" + d.toString(this.lON) + ", mRssi=" + this.lOO + ", mTimestampNanos=" + this.lOP + '}';
    AppMethodBeat.o(144645);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(144642);
    if (this.lOM != null)
    {
      paramParcel.writeInt(1);
      this.lOM.writeToParcel(paramParcel, paramInt);
      if (this.lON == null) {
        break label79;
      }
      paramParcel.writeInt(1);
      paramParcel.writeByteArray(this.lON.lOK);
    }
    for (;;)
    {
      paramParcel.writeInt(this.lOO);
      paramParcel.writeLong(this.lOP);
      AppMethodBeat.o(144642);
      return;
      paramParcel.writeInt(0);
      break;
      label79:
      paramParcel.writeInt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanResultCompat
 * JD-Core Version:    0.7.0.1
 */