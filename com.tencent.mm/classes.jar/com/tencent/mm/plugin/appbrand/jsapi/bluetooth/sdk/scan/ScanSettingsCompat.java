package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScanSettingsCompat
  implements Parcelable
{
  public static final Parcelable.Creator<ScanSettingsCompat> CREATOR;
  final int hIg;
  private final int hIh;
  final long hIi;
  
  static
  {
    AppMethodBeat.i(94340);
    CREATOR = new ScanSettingsCompat.1();
    AppMethodBeat.o(94340);
  }
  
  private ScanSettingsCompat(int paramInt, long paramLong)
  {
    this.hIg = paramInt;
    this.hIh = 1;
    this.hIi = paramLong;
  }
  
  private ScanSettingsCompat(Parcel paramParcel)
  {
    AppMethodBeat.i(94338);
    this.hIg = paramParcel.readInt();
    this.hIh = paramParcel.readInt();
    this.hIi = paramParcel.readLong();
    AppMethodBeat.o(94338);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(94339);
    paramParcel.writeInt(this.hIg);
    paramParcel.writeInt(this.hIh);
    paramParcel.writeLong(this.hIi);
    AppMethodBeat.o(94339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanSettingsCompat
 * JD-Core Version:    0.7.0.1
 */