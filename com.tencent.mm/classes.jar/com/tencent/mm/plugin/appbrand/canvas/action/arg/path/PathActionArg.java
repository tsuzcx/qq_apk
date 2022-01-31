package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import com.tencent.mm.plugin.appbrand.u.h;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class PathActionArg
  extends BasePathActionArg
{
  public float fLC;
  public float fMe;
  public boolean fMf;
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
    } while ((paramObject.x != this.x) || (paramObject.y != this.y) || (paramObject.radius != this.radius) || (paramObject.fLC != this.fLC) || (paramObject.fMf != this.fMf));
    return true;
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool = true;
    super.f(paramParcel);
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    this.radius = paramParcel.readFloat();
    this.fLC = paramParcel.readFloat();
    this.fMe = paramParcel.readFloat();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.fMf = bool;
      return;
      bool = false;
    }
  }
  
  public final void j(JSONObject paramJSONObject)
  {
    super.j(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.x = h.d(paramJSONObject, 0);
    this.y = h.d(paramJSONObject, 1);
    this.radius = h.d(paramJSONObject, 2);
    this.fLC = ((float)paramJSONObject.optDouble(3));
    this.fMe = ((float)paramJSONObject.optDouble(4));
    this.fMf = paramJSONObject.optBoolean(5);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    paramParcel.writeFloat(this.radius);
    paramParcel.writeFloat(this.fLC);
    paramParcel.writeFloat(this.fMe);
    if (this.fMf) {}
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