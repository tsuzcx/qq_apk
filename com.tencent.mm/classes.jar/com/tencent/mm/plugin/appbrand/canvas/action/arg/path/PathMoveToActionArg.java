package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.g;
import org.json.JSONObject;

public class PathMoveToActionArg
  extends BasePathActionArg
{
  public static final Parcelable.Creator<PathMoveToActionArg> CREATOR;
  public float x;
  public float y;
  
  static
  {
    AppMethodBeat.i(103621);
    CREATOR = new PathMoveToActionArg.1();
    AppMethodBeat.o(103621);
  }
  
  public PathMoveToActionArg() {}
  
  public PathMoveToActionArg(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(103620);
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103620);
      return false;
    }
    if ((paramObject instanceof PathMoveToActionArg))
    {
      paramObject = (PathMoveToActionArg)paramObject;
      if ((paramObject.x == this.x) && (paramObject.y == this.y))
      {
        AppMethodBeat.o(103620);
        return true;
      }
      AppMethodBeat.o(103620);
      return false;
    }
    AppMethodBeat.o(103620);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103619);
    super.h(paramParcel);
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    AppMethodBeat.o(103619);
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103617);
    super.p(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.x = g.d(paramJSONObject, 0);
    this.y = g.d(paramJSONObject, 1);
    AppMethodBeat.o(103617);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103618);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    AppMethodBeat.o(103618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathMoveToActionArg
 * JD-Core Version:    0.7.0.1
 */