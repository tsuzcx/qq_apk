package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import org.json.JSONObject;

public class PathQuadraticCurveToActionArg
  extends BasePathActionArg
{
  public static final Parcelable.Creator<PathQuadraticCurveToActionArg> CREATOR;
  public float x1;
  public float x2;
  public float y1;
  public float y2;
  
  static
  {
    AppMethodBeat.i(145310);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145310);
  }
  
  public PathQuadraticCurveToActionArg() {}
  
  public PathQuadraticCurveToActionArg(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145309);
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145309);
      return false;
    }
    if ((paramObject instanceof PathQuadraticCurveToActionArg))
    {
      paramObject = (PathQuadraticCurveToActionArg)paramObject;
      if ((paramObject.x1 == this.x1) && (paramObject.y1 == this.y1) && (paramObject.x2 == this.x2) && (paramObject.y2 == this.y2))
      {
        AppMethodBeat.o(145309);
        return true;
      }
      AppMethodBeat.o(145309);
      return false;
    }
    AppMethodBeat.o(145309);
    return false;
  }
  
  public final void k(Parcel paramParcel)
  {
    AppMethodBeat.i(145308);
    super.k(paramParcel);
    this.x1 = paramParcel.readFloat();
    this.y1 = paramParcel.readFloat();
    this.x2 = paramParcel.readFloat();
    this.y2 = paramParcel.readFloat();
    AppMethodBeat.o(145308);
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145306);
    super.parse(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.x1 = i.f(paramJSONObject, 0);
    this.y1 = i.f(paramJSONObject, 1);
    this.x2 = i.f(paramJSONObject, 2);
    this.y2 = i.f(paramJSONObject, 3);
    AppMethodBeat.o(145306);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145307);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.x1);
    paramParcel.writeFloat(this.y1);
    paramParcel.writeFloat(this.x2);
    paramParcel.writeFloat(this.y2);
    AppMethodBeat.o(145307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathQuadraticCurveToActionArg
 * JD-Core Version:    0.7.0.1
 */