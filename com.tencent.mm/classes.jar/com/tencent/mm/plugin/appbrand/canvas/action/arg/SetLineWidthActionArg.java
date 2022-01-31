package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.u.h;
import java.util.Objects;
import org.json.JSONObject;

public class SetLineWidthActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetLineWidthActionArg> CREATOR = new Parcelable.Creator() {};
  public float fLY;
  
  public SetLineWidthActionArg() {}
  
  public SetLineWidthActionArg(Parcel paramParcel)
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
      if (!(paramObject instanceof SetLineWidthActionArg)) {
        return false;
      }
      if (!super.equals(paramObject)) {
        return false;
      }
    } while (Float.compare(((SetLineWidthActionArg)paramObject).fLY, this.fLY) == 0);
    return false;
  }
  
  public final void f(Parcel paramParcel)
  {
    super.f(paramParcel);
    this.fLY = paramParcel.readFloat();
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.fLY) });
  }
  
  public final void j(JSONObject paramJSONObject)
  {
    super.j(paramJSONObject);
    this.fLY = h.d(paramJSONObject.optJSONArray("data"), 0);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.fLY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineWidthActionArg
 * JD-Core Version:    0.7.0.1
 */