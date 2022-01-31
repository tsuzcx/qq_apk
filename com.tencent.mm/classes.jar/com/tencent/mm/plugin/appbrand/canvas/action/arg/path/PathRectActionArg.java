package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.u.h;
import org.json.JSONObject;

public class PathRectActionArg
  extends BasePathActionArg
{
  public static final Parcelable.Creator<PathRectActionArg> CREATOR = new PathRectActionArg.1();
  public float height;
  public float width;
  public float x;
  public float y;
  
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
    if (!super.equals(paramObject)) {}
    do
    {
      do
      {
        return false;
      } while (!(paramObject instanceof PathRectActionArg));
      paramObject = (PathRectActionArg)paramObject;
    } while ((paramObject.x != this.x) || (paramObject.y != this.y) || (paramObject.width != this.width) || (paramObject.height != this.height));
    return true;
  }
  
  public final void f(Parcel paramParcel)
  {
    super.f(paramParcel);
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    this.width = paramParcel.readFloat();
    this.height = paramParcel.readFloat();
  }
  
  public final void j(JSONObject paramJSONObject)
  {
    super.j(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.x = h.d(paramJSONObject, 0);
    this.y = h.d(paramJSONObject, 1);
    this.width = h.d(paramJSONObject, 2);
    this.height = h.d(paramJSONObject, 3);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    paramParcel.writeFloat(this.width);
    paramParcel.writeFloat(this.height);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathRectActionArg
 * JD-Core Version:    0.7.0.1
 */