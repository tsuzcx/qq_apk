package com.tencent.mm.modelappbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LogInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LogInfo> CREATOR;
  public long gRD;
  public int level;
  public String message;
  
  static
  {
    AppMethodBeat.i(76377);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(76377);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(76376);
    paramParcel.writeLong(this.gRD);
    paramParcel.writeInt(this.level);
    paramParcel.writeString(this.message);
    AppMethodBeat.o(76376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.LogInfo
 * JD-Core Version:    0.7.0.1
 */