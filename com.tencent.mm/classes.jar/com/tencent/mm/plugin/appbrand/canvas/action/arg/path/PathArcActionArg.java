package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class PathArcActionArg
  extends PathActionArg
{
  public static final Parcelable.Creator<PathArcActionArg> CREATOR = new PathArcActionArg.1();
  
  public PathArcActionArg() {}
  
  public PathArcActionArg(Parcel paramParcel)
  {
    super(paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathArcActionArg
 * JD-Core Version:    0.7.0.1
 */