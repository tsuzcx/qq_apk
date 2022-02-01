package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public class PathClosePathActionArg
  extends BasePathActionArg
{
  public static final Parcelable.Creator<PathClosePathActionArg> CREATOR;
  
  static
  {
    AppMethodBeat.i(145292);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145292);
  }
  
  public PathClosePathActionArg() {}
  
  public PathClosePathActionArg(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145291);
    super.parse(paramJSONObject);
    AppMethodBeat.o(145291);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathClosePathActionArg
 * JD-Core Version:    0.7.0.1
 */