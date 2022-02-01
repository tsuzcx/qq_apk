package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import org.json.JSONObject;

public class PathLineToActionArg
  extends BasePathActionArg
{
  public static final Parcelable.Creator<PathLineToActionArg> CREATOR;
  public float x;
  public float y;
  
  static
  {
    AppMethodBeat.i(145298);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145298);
  }
  
  public PathLineToActionArg() {}
  
  public PathLineToActionArg(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145297);
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145297);
      return false;
    }
    if ((paramObject instanceof PathLineToActionArg))
    {
      paramObject = (PathLineToActionArg)paramObject;
      if ((paramObject.x == this.x) && (paramObject.y == this.y))
      {
        AppMethodBeat.o(145297);
        return true;
      }
      AppMethodBeat.o(145297);
      return false;
    }
    AppMethodBeat.o(145297);
    return false;
  }
  
  public final void k(Parcel paramParcel)
  {
    AppMethodBeat.i(145296);
    super.k(paramParcel);
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    AppMethodBeat.o(145296);
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145294);
    super.parse(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.x = i.f(paramJSONObject, 0);
    this.y = i.f(paramJSONObject, 1);
    AppMethodBeat.o(145294);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145295);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    AppMethodBeat.o(145295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathLineToActionArg
 * JD-Core Version:    0.7.0.1
 */