package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.u.h;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetShadowActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetShadowActionArg> CREATOR = new SetShadowActionArg.1();
  public int color;
  public float fLZ;
  public float x;
  public float y;
  
  public SetShadowActionArg() {}
  
  public SetShadowActionArg(Parcel paramParcel)
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
      if (!(paramObject instanceof SetShadowActionArg)) {
        return false;
      }
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (SetShadowActionArg)paramObject;
    } while ((Float.compare(paramObject.x, this.x) == 0) && (Float.compare(paramObject.y, this.y) == 0) && (Float.compare(paramObject.fLZ, this.fLZ) == 0) && (this.color == paramObject.color));
    return false;
  }
  
  public final void f(Parcel paramParcel)
  {
    super.f(paramParcel);
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    this.fLZ = paramParcel.readFloat();
    this.color = paramParcel.readInt();
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.fLZ), Integer.valueOf(this.color) });
  }
  
  public final void j(JSONObject paramJSONObject)
  {
    super.j(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    paramJSONObject.length();
    this.x = h.d(paramJSONObject, 0);
    this.y = h.d(paramJSONObject, 1);
    this.fLZ = h.d(paramJSONObject, 2);
    paramJSONObject = paramJSONObject.optJSONArray(3);
    if ((paramJSONObject == null) || (paramJSONObject.length() < 4)) {
      return;
    }
    this.color = h.l(paramJSONObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    paramParcel.writeFloat(this.fLZ);
    paramParcel.writeInt(this.color);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetShadowActionArg
 * JD-Core Version:    0.7.0.1
 */