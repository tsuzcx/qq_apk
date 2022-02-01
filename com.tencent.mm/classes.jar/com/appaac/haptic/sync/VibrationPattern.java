package com.appaac.haptic.sync;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VibrationPattern
  implements Parcelable
{
  public static final Parcelable.Creator<VibrationPattern> CREATOR;
  public int cse;
  public int interval;
  public String pattern;
  
  static
  {
    AppMethodBeat.i(208376);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(208376);
  }
  
  public VibrationPattern(Parcel paramParcel)
  {
    AppMethodBeat.i(208371);
    this.pattern = paramParcel.readString();
    this.cse = paramParcel.readInt();
    this.interval = paramParcel.readInt();
    AppMethodBeat.o(208371);
  }
  
  public VibrationPattern(String paramString)
  {
    this.pattern = paramString;
    this.cse = 1;
    this.interval = 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(208380);
    String str = "loop='" + this.cse + "',interval='" + this.interval + "'," + this.pattern;
    AppMethodBeat.o(208380);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(208390);
    paramParcel.writeString(this.pattern);
    paramParcel.writeInt(this.cse);
    paramParcel.writeInt(this.interval);
    AppMethodBeat.o(208390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.appaac.haptic.sync.VibrationPattern
 * JD-Core Version:    0.7.0.1
 */