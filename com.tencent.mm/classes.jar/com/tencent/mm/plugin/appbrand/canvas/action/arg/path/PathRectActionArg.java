package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.g;
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
    AppMethodBeat.i(145316);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145316);
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
    AppMethodBeat.i(145315);
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145315);
      return false;
    }
    if ((paramObject instanceof PathRectActionArg))
    {
      paramObject = (PathRectActionArg)paramObject;
      if ((paramObject.x == this.x) && (paramObject.y == this.y) && (paramObject.width == this.width) && (paramObject.height == this.height))
      {
        AppMethodBeat.o(145315);
        return true;
      }
      AppMethodBeat.o(145315);
      return false;
    }
    AppMethodBeat.o(145315);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(145314);
    super.h(paramParcel);
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    this.width = paramParcel.readFloat();
    this.height = paramParcel.readFloat();
    AppMethodBeat.o(145314);
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145312);
    super.parse(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.x = g.f(paramJSONObject, 0);
    this.y = g.f(paramJSONObject, 1);
    this.width = g.f(paramJSONObject, 2);
    this.height = g.f(paramJSONObject, 3);
    AppMethodBeat.o(145312);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145313);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    paramParcel.writeFloat(this.width);
    paramParcel.writeFloat(this.height);
    AppMethodBeat.o(145313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathRectActionArg
 * JD-Core Version:    0.7.0.1
 */