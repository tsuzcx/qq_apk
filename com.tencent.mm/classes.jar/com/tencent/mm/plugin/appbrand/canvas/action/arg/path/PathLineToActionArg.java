package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.g;
import org.json.JSONObject;

public class PathLineToActionArg
  extends BasePathActionArg
{
  public static final Parcelable.Creator<PathLineToActionArg> CREATOR;
  public float x;
  public float y;
  
  static
  {
    AppMethodBeat.i(103615);
    CREATOR = new PathLineToActionArg.1();
    AppMethodBeat.o(103615);
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
    AppMethodBeat.i(103614);
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103614);
      return false;
    }
    if ((paramObject instanceof PathLineToActionArg))
    {
      paramObject = (PathLineToActionArg)paramObject;
      if ((paramObject.x == this.x) && (paramObject.y == this.y))
      {
        AppMethodBeat.o(103614);
        return true;
      }
      AppMethodBeat.o(103614);
      return false;
    }
    AppMethodBeat.o(103614);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103613);
    super.h(paramParcel);
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    AppMethodBeat.o(103613);
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103611);
    super.p(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.x = g.d(paramJSONObject, 0);
    this.y = g.d(paramJSONObject, 1);
    AppMethodBeat.o(103611);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103612);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    AppMethodBeat.o(103612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathLineToActionArg
 * JD-Core Version:    0.7.0.1
 */