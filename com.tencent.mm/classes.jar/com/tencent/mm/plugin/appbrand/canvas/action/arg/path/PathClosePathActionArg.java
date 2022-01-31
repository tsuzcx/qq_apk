package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class PathClosePathActionArg
  extends BasePathActionArg
{
  public static final Parcelable.Creator<PathClosePathActionArg> CREATOR = new PathClosePathActionArg.1();
  
  public PathClosePathActionArg() {}
  
  public PathClosePathActionArg(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void j(JSONObject paramJSONObject)
  {
    super.j(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathClosePathActionArg
 * JD-Core Version:    0.7.0.1
 */