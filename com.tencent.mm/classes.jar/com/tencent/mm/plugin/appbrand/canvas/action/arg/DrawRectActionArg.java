package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.u.h;
import java.util.Objects;
import org.json.JSONObject;

public class DrawRectActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<DrawRectActionArg> CREATOR = new DrawRectActionArg.1();
  public float height;
  public float width;
  public float x;
  public float y;
  
  public DrawRectActionArg() {}
  
  public DrawRectActionArg(Parcel paramParcel)
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
      if (!(paramObject instanceof DrawRectActionArg)) {
        return false;
      }
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (DrawRectActionArg)paramObject;
    } while ((Float.compare(paramObject.x, this.x) == 0) && (Float.compare(paramObject.y, this.y) == 0) && (Float.compare(paramObject.width, this.width) == 0) && (Float.compare(paramObject.height, this.height) == 0));
    return false;
  }
  
  public final void f(Parcel paramParcel)
  {
    super.f(paramParcel);
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    this.width = paramParcel.readFloat();
    this.height = paramParcel.readFloat();
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.width), Float.valueOf(this.height) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawRectActionArg
 * JD-Core Version:    0.7.0.1
 */