package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import com.tencent.mm.plugin.appbrand.af.i;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class PathActionArg
  extends BasePathActionArg
{
  public float dxm;
  public float qTP;
  public boolean qTQ;
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
    } while ((paramObject.x != this.x) || (paramObject.y != this.y) || (paramObject.radius != this.radius) || (paramObject.dxm != this.dxm) || (paramObject.qTQ != this.qTQ));
    return true;
  }
  
  public final void k(Parcel paramParcel)
  {
    boolean bool = true;
    super.k(paramParcel);
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    this.radius = paramParcel.readFloat();
    this.dxm = paramParcel.readFloat();
    this.qTP = paramParcel.readFloat();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.qTQ = bool;
      return;
      bool = false;
    }
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    super.parse(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.x = i.f(paramJSONObject, 0);
    this.y = i.f(paramJSONObject, 1);
    this.radius = i.f(paramJSONObject, 2);
    this.dxm = ((float)paramJSONObject.optDouble(3));
    this.qTP = ((float)paramJSONObject.optDouble(4));
    this.qTQ = paramJSONObject.optBoolean(5);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    paramParcel.writeFloat(this.radius);
    paramParcel.writeFloat(this.dxm);
    paramParcel.writeFloat(this.qTP);
    if (this.qTQ) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathActionArg
 * JD-Core Version:    0.7.0.1
 */