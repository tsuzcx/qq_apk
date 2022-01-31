package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class RotateActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<RotateActionArg> CREATOR = new Parcelable.Creator() {};
  public float fLP;
  
  public RotateActionArg() {}
  
  public RotateActionArg(Parcel paramParcel)
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
      if (!(paramObject instanceof RotateActionArg)) {
        return false;
      }
      if (!super.equals(paramObject)) {
        return false;
      }
    } while (Float.compare(((RotateActionArg)paramObject).fLP, this.fLP) == 0);
    return false;
  }
  
  public final void f(Parcel paramParcel)
  {
    super.f(paramParcel);
    this.fLP = paramParcel.readFloat();
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.fLP) });
  }
  
  public final void j(JSONObject paramJSONObject)
  {
    super.j(paramJSONObject);
    this.fLP = ((float)paramJSONObject.optJSONArray("data").optDouble(0));
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.fLP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.RotateActionArg
 * JD-Core Version:    0.7.0.1
 */