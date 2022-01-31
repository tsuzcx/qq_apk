package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ScanSettingsCompat
  implements Parcelable
{
  public static final Parcelable.Creator<ScanSettingsCompat> CREATOR = new ScanSettingsCompat.1();
  final int goj;
  private final int gok;
  final long gol;
  
  private ScanSettingsCompat(int paramInt, long paramLong)
  {
    this.goj = paramInt;
    this.gok = 1;
    this.gol = paramLong;
  }
  
  private ScanSettingsCompat(Parcel paramParcel)
  {
    this.goj = paramParcel.readInt();
    this.gok = paramParcel.readInt();
    this.gol = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.goj);
    paramParcel.writeInt(this.gok);
    paramParcel.writeLong(this.gol);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanSettingsCompat
 * JD-Core Version:    0.7.0.1
 */