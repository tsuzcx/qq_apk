package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.u.h;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetFontActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetFontActionArg> CREATOR = new SetFontActionArg.1();
  public String name;
  public float size;
  
  public SetFontActionArg() {}
  
  public SetFontActionArg(Parcel paramParcel)
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
      if (!(paramObject instanceof SetFontActionArg)) {
        return false;
      }
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (SetFontActionArg)paramObject;
    } while ((Float.compare(paramObject.size, this.size) == 0) && (Objects.equals(this.name, paramObject.name)));
    return false;
  }
  
  public final void f(Parcel paramParcel)
  {
    super.f(paramParcel);
    this.name = paramParcel.readString();
    this.size = paramParcel.readFloat();
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.name, Float.valueOf(this.size) });
  }
  
  public final void j(JSONObject paramJSONObject)
  {
    super.j(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    if (paramJSONObject.length() < 2) {
      return;
    }
    this.name = paramJSONObject.optString(0);
    this.size = h.d(paramJSONObject, 1);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.name);
    paramParcel.writeFloat(this.size);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontActionArg
 * JD-Core Version:    0.7.0.1
 */