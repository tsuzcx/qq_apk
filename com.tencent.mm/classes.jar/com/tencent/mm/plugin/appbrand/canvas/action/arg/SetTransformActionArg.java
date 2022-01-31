package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.j.c;
import com.tencent.mm.plugin.appbrand.u.h;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SetTransformActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetTransformActionArg> CREATOR = new SetTransformActionArg.1();
  public float fMc;
  public float fMd;
  public float scaleX;
  public float scaleY;
  public float translateX;
  public float translateY;
  
  public SetTransformActionArg() {}
  
  public SetTransformActionArg(Parcel paramParcel)
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
      if (!(paramObject instanceof SetTransformActionArg)) {
        return false;
      }
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (SetTransformActionArg)paramObject;
    } while ((Float.compare(paramObject.scaleX, this.scaleX) == 0) && (Float.compare(paramObject.fMc, this.fMc) == 0) && (Float.compare(paramObject.fMd, this.fMd) == 0) && (Float.compare(paramObject.scaleY, this.scaleY) == 0) && (Float.compare(paramObject.translateX, this.translateX) == 0) && (Float.compare(paramObject.translateY, this.translateY) == 0));
    return false;
  }
  
  public final void f(Parcel paramParcel)
  {
    super.f(paramParcel);
    this.scaleX = paramParcel.readFloat();
    this.fMc = paramParcel.readFloat();
    this.fMd = paramParcel.readFloat();
    this.scaleY = paramParcel.readFloat();
    this.translateX = paramParcel.readFloat();
    this.translateY = paramParcel.readFloat();
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.scaleX), Float.valueOf(this.fMc), Float.valueOf(this.fMd), Float.valueOf(this.scaleY), Float.valueOf(this.translateX), Float.valueOf(this.translateY) });
  }
  
  public final void j(JSONObject paramJSONObject)
  {
    super.j(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    try
    {
      this.scaleX = ((float)paramJSONObject.getDouble(0));
      this.fMc = ((float)paramJSONObject.getDouble(1));
      this.fMd = ((float)paramJSONObject.getDouble(2));
      this.scaleY = ((float)paramJSONObject.getDouble(3));
      this.translateX = h.c(paramJSONObject, 4);
      this.translateY = h.c(paramJSONObject, 5);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      c.printErrStackTrace("SetTransformActionArg", paramJSONObject, "", new Object[0]);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.scaleY);
    paramParcel.writeFloat(this.fMc);
    paramParcel.writeFloat(this.fMd);
    paramParcel.writeFloat(this.scaleY);
    paramParcel.writeFloat(this.translateX);
    paramParcel.writeFloat(this.translateY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTransformActionArg
 * JD-Core Version:    0.7.0.1
 */