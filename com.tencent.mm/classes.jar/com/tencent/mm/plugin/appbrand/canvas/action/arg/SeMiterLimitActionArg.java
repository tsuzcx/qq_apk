package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SeMiterLimitActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SeMiterLimitActionArg> CREATOR = new SeMiterLimitActionArg.1();
  public float fLQ;
  
  public SeMiterLimitActionArg() {}
  
  public SeMiterLimitActionArg(Parcel paramParcel)
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
      if (!(paramObject instanceof SeMiterLimitActionArg)) {
        return false;
      }
      if (!super.equals(paramObject)) {
        return false;
      }
    } while (Float.compare(((SeMiterLimitActionArg)paramObject).fLQ, this.fLQ) == 0);
    return false;
  }
  
  public final void f(Parcel paramParcel)
  {
    super.f(paramParcel);
    this.fLQ = paramParcel.readFloat();
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.fLQ) });
  }
  
  public final void j(JSONObject paramJSONObject)
  {
    super.j(paramJSONObject);
    this.fLQ = ((float)paramJSONObject.optJSONArray("data").optDouble(0));
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.fLQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SeMiterLimitActionArg
 * JD-Core Version:    0.7.0.1
 */