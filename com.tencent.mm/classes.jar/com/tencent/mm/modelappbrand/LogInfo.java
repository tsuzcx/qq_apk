package com.tencent.mm.modelappbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LogInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LogInfo> CREATOR;
  public int level;
  public String message;
  public long ts;
  
  static
  {
    AppMethodBeat.i(70629);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70629);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70628);
    paramParcel.writeLong(this.ts);
    paramParcel.writeInt(this.level);
    paramParcel.writeString(this.message);
    AppMethodBeat.o(70628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.LogInfo
 * JD-Core Version:    0.7.0.1
 */