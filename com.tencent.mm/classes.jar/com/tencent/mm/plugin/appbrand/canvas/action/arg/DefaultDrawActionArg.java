package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DefaultDrawActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<DefaultDrawActionArg> CREATOR;
  
  static
  {
    AppMethodBeat.i(145000);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145000);
  }
  
  public DefaultDrawActionArg() {}
  
  public DefaultDrawActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.DefaultDrawActionArg
 * JD-Core Version:    0.7.0.1
 */