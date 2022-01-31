package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.g;
import org.json.JSONObject;

public class PathRectActionArg
  extends BasePathActionArg
{
  public static final Parcelable.Creator<PathRectActionArg> CREATOR;
  public float height;
  public float width;
  public float x;
  public float y;
  
  static
  {
    AppMethodBeat.i(103633);
    CREATOR = new PathRectActionArg.1();
    AppMethodBeat.o(103633);
  }
  
  public PathRectActionArg() {}
  
  public PathRectActionArg(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(103632);
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103632);
      return false;
    }
    if ((paramObject instanceof PathRectActionArg))
    {
      paramObject = (PathRectActionArg)paramObject;
      if ((paramObject.x == this.x) && (paramObject.y == this.y) && (paramObject.width == this.width) && (paramObject.height == this.height))
      {
        AppMethodBeat.o(103632);
        return true;
      }
      AppMethodBeat.o(103632);
      return false;
    }
    AppMethodBeat.o(103632);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103631);
    super.h(paramParcel);
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    this.width = paramParcel.readFloat();
    this.height = paramParcel.readFloat();
    AppMethodBeat.o(103631);
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103629);
    super.p(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.x = g.d(paramJSONObject, 0);
    this.y = g.d(paramJSONObject, 1);
    this.width = g.d(paramJSONObject, 2);
    this.height = g.d(paramJSONObject, 3);
    AppMethodBeat.o(103629);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103630);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    paramParcel.writeFloat(this.width);
    paramParcel.writeFloat(this.height);
    AppMethodBeat.o(103630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathRectActionArg
 * JD-Core Version:    0.7.0.1
 */