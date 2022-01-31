package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PathArcActionArg
  extends PathActionArg
{
  public static final Parcelable.Creator<PathArcActionArg> CREATOR;
  
  static
  {
    AppMethodBeat.i(103598);
    CREATOR = new PathArcActionArg.1();
    AppMethodBeat.o(103598);
  }
  
  public PathArcActionArg() {}
  
  public PathArcActionArg(Parcel paramParcel)
  {
    super(paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathArcActionArg
 * JD-Core Version:    0.7.0.1
 */