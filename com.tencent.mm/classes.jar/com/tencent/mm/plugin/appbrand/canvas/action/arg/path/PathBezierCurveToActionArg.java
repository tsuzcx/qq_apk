package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.u.h;
import org.json.JSONObject;

public class PathBezierCurveToActionArg
  extends BasePathActionArg
{
  public static final Parcelable.Creator<PathBezierCurveToActionArg> CREATOR = new PathBezierCurveToActionArg.1();
  public float x1;
  public float x2;
  public float x3;
  public float y1;
  public float y2;
  public float y3;
  
  public PathBezierCurveToActionArg() {}
  
  public PathBezierCurveToActionArg(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!super.equals(paramObject)) {}
    do
    {
      do
      {
        return false;
      } while (!(paramObject instanceof PathBezierCurveToActionArg));
      paramObject = (PathBezierCurveToActionArg)paramObject;
    } while ((paramObject.x1 != this.x1) || (paramObject.y1 != this.y1) || (paramObject.x2 != this.x2) || (paramObject.y2 != this.y2) || (paramObject.x3 != this.x3) || (paramObject.y3 != this.y3));
    return true;
  }
  
  public final void f(Parcel paramParcel)
  {
    super.f(paramParcel);
    this.x1 = paramParcel.readFloat();
    this.y1 = paramParcel.readFloat();
    this.x2 = paramParcel.readFloat();
    this.y2 = paramParcel.readFloat();
    this.x3 = paramParcel.readFloat();
    this.y3 = paramParcel.readFloat();
  }
  
  public final void j(JSONObject paramJSONObject)
  {
    super.j(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.x1 = h.d(paramJSONObject, 0);
    this.y1 = h.d(paramJSONObject, 1);
    this.x2 = h.d(paramJSONObject, 2);
    this.y2 = h.d(paramJSONObject, 3);
    this.x3 = h.d(paramJSONObject, 4);
    this.y3 = h.d(paramJSONObject, 5);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.x1);
    paramParcel.writeFloat(this.y1);
    paramParcel.writeFloat(this.x2);
    paramParcel.writeFloat(this.y2);
    paramParcel.writeFloat(this.x2);
    paramParcel.writeFloat(this.y2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathBezierCurveToActionArg
 * JD-Core Version:    0.7.0.1
 */