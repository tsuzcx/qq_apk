package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y.g;
import org.json.JSONObject;

public class PathMoveToActionArg
  extends BasePathActionArg
{
  public static final Parcelable.Creator<PathMoveToActionArg> CREATOR;
  public float x;
  public float y;
  
  static
  {
    AppMethodBeat.i(145304);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145304);
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
    AppMethodBeat.i(145303);
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145303);
      return false;
    }
    if ((paramObject instanceof PathMoveToActionArg))
    {
      paramObject = (PathMoveToActionArg)paramObject;
      if ((paramObject.x == this.x) && (paramObject.y == this.y))
      {
        AppMethodBeat.o(145303);
        return true;
      }
      AppMethodBeat.o(145303);
      return false;
    }
    AppMethodBeat.o(145303);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(145302);
    super.h(paramParcel);
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    AppMethodBeat.o(145302);
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145300);
    super.parse(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.x = g.f(paramJSONObject, 0);
    this.y = g.f(paramJSONObject, 1);
    AppMethodBeat.o(145300);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145301);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    AppMethodBeat.o(145301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathMoveToActionArg
 * JD-Core Version:    0.7.0.1
 */