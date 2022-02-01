package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PathArcToActionArg
  extends PathActionArg
{
  public static final Parcelable.Creator<PathArcToActionArg> CREATOR;
  
  static
  {
    AppMethodBeat.i(145283);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145283);
  }
  
  public PathArcToActionArg() {}
  
  public PathArcToActionArg(Parcel paramParcel)
  {
    super(paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathArcToActionArg
 * JD-Core Version:    0.7.0.1
 */