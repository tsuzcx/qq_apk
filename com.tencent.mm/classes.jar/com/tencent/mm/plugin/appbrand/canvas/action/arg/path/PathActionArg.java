package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import com.tencent.mm.plugin.appbrand.z.g;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class PathActionArg
  extends BasePathActionArg
{
  public float jzM;
  public boolean jzN;
  public float kr;
  public float radius;
  public float x;
  public float y;
  
  public PathActionArg() {}
  
  public PathActionArg(Parcel paramParcel)
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
      } while (!(paramObject instanceof PathActionArg));
      paramObject = (PathActionArg)paramObject;
    } while ((paramObject.x != this.x) || (paramObject.y != this.y) || (paramObject.radius != this.radius) || (paramObject.kr != this.kr) || (paramObject.jzN != this.jzN));
    return true;
  }
  
  public final void h(Parcel paramParcel)
  {
    boolean bool = true;
    super.h(paramParcel);
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    this.radius = paramParcel.readFloat();
    this.kr = paramParcel.readFloat();
    this.jzM = paramParcel.readFloat();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.jzN = bool;
      return;
      bool = false;
    }
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    super.parse(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.x = g.f(paramJSONObject, 0);
    this.y = g.f(paramJSONObject, 1);
    this.radius = g.f(paramJSONObject, 2);
    this.kr = ((float)paramJSONObject.optDouble(3));
    this.jzM = ((float)paramJSONObject.optDouble(4));
    this.jzN = paramJSONObject.optBoolean(5);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    paramParcel.writeFloat(this.radius);
    paramParcel.writeFloat(this.kr);
    paramParcel.writeFloat(this.jzM);
    if (this.jzN) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathActionArg
 * JD-Core Version:    0.7.0.1
 */