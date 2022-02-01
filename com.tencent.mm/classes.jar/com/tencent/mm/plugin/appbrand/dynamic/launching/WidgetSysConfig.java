package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WidgetSysConfig
  implements Parcelable
{
  public static final Parcelable.Creator<WidgetSysConfig> CREATOR;
  public int jWG;
  public int jWH;
  public int jWI;
  
  static
  {
    AppMethodBeat.i(121415);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(121415);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(121414);
    paramParcel.writeInt(this.jWG);
    paramParcel.writeInt(this.jWH);
    paramParcel.writeInt(this.jWI);
    AppMethodBeat.o(121414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig
 * JD-Core Version:    0.7.0.1
 */