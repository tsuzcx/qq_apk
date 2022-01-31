package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WidgetSysConfig
  implements Parcelable
{
  public static final Parcelable.Creator<WidgetSysConfig> CREATOR;
  public int hhN;
  public int hhO;
  public int hhP;
  
  static
  {
    AppMethodBeat.i(10934);
    CREATOR = new WidgetSysConfig.1();
    AppMethodBeat.o(10934);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(10933);
    paramParcel.writeInt(this.hhN);
    paramParcel.writeInt(this.hhO);
    paramParcel.writeInt(this.hhP);
    AppMethodBeat.o(10933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig
 * JD-Core Version:    0.7.0.1
 */