package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.u.h;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawArcActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<DrawArcActionArg> CREATOR = new DrawArcActionArg.1();
  public float fLC;
  public float fLD;
  public float radius;
  public float x;
  public float y;
  
  public DrawArcActionArg() {}
  
  public DrawArcActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof DrawArcActionArg)) {
        return false;
      }
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (DrawArcActionArg)paramObject;
    } while ((Float.compare(paramObject.x, this.x) == 0) && (Float.compare(paramObject.y, this.y) == 0) && (Float.compare(paramObject.radius, this.radius) == 0) && (Float.compare(paramObject.fLC, this.fLC) == 0) && (Float.compare(paramObject.fLD, this.fLD) == 0));
    return false;
  }
  
  public final void f(Parcel paramParcel)
  {
    super.f(paramParcel);
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    this.radius = paramParcel.readFloat();
    this.fLC = paramParcel.readFloat();
    this.fLD = paramParcel.readFloat();
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.radius), Float.valueOf(this.fLC), Float.valueOf(this.fLD) });
  }
  
  public final void j(JSONObject paramJSONObject)
  {
    super.j(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.x = h.d(paramJSONObject, 0);
    this.y = h.d(paramJSONObject, 1);
    this.radius = h.d(paramJSONObject, 2);
    this.fLC = ((float)paramJSONObject.optDouble(3));
    this.fLD = ((float)paramJSONObject.optDouble(4));
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    paramParcel.writeFloat(this.radius);
    paramParcel.writeFloat(this.fLC);
    paramParcel.writeFloat(this.fLD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawArcActionArg
 * JD-Core Version:    0.7.0.1
 */