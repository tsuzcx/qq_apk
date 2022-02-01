package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import com.tencent.mm.plugin.appbrand.ac.g;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class PathActionArg
  extends BasePathActionArg
{
  public float kZU;
  public boolean kZV;
  public float mj;
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
    } while ((paramObject.x != this.x) || (paramObject.y != this.y) || (paramObject.radius != this.radius) || (paramObject.mj != this.mj) || (paramObject.kZV != this.kZV));
    return true;
  }
  
  public final void i(Parcel paramParcel)
  {
    boolean bool = true;
    super.i(paramParcel);
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    this.radius = paramParcel.readFloat();
    this.mj = paramParcel.readFloat();
    this.kZU = paramParcel.readFloat();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.kZV = bool;
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
    this.mj = ((float)paramJSONObject.optDouble(3));
    this.kZU = ((float)paramJSONObject.optDouble(4));
    this.kZV = paramJSONObject.optBoolean(5);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    paramParcel.writeFloat(this.radius);
    paramParcel.writeFloat(this.mj);
    paramParcel.writeFloat(this.kZU);
    if (this.kZV) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathActionArg
 * JD-Core Version:    0.7.0.1
 */