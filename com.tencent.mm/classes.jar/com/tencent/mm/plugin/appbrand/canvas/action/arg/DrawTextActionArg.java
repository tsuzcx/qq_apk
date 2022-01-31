package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.u.h;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawTextActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<DrawTextActionArg> CREATOR = new DrawTextActionArg.1();
  public float fLH;
  public String text;
  public float x;
  public float y;
  
  public DrawTextActionArg() {}
  
  public DrawTextActionArg(Parcel paramParcel)
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
      if (!(paramObject instanceof DrawTextActionArg)) {
        return false;
      }
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (DrawTextActionArg)paramObject;
    } while ((Float.compare(paramObject.x, this.x) == 0) && (Float.compare(paramObject.y, this.y) == 0) && (Float.compare(paramObject.fLH, this.fLH) == 0) && (Objects.equals(this.text, paramObject.text)));
    return false;
  }
  
  public final void f(Parcel paramParcel)
  {
    super.f(paramParcel);
    this.text = paramParcel.readString();
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    this.fLH = paramParcel.readFloat();
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.text, Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.fLH) });
  }
  
  public final void j(JSONObject paramJSONObject)
  {
    super.j(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.text = paramJSONObject.optString(0);
    this.x = h.d(paramJSONObject, 1);
    this.y = h.d(paramJSONObject, 2);
    this.fLH = h.d(paramJSONObject, 3);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.text);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    paramParcel.writeFloat(this.fLH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawTextActionArg
 * JD-Core Version:    0.7.0.1
 */