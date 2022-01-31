package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class ScaleActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<ScaleActionArg> CREATOR = new ScaleActionArg.1();
  public float fLI;
  public float fLJ;
  
  public ScaleActionArg() {}
  
  public ScaleActionArg(Parcel paramParcel)
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
      if (!(paramObject instanceof ScaleActionArg)) {
        return false;
      }
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (ScaleActionArg)paramObject;
    } while ((Float.compare(paramObject.fLI, this.fLI) == 0) && (Float.compare(paramObject.fLJ, this.fLJ) == 0));
    return false;
  }
  
  public final void f(Parcel paramParcel)
  {
    super.f(paramParcel);
    this.fLI = paramParcel.readFloat();
    this.fLJ = paramParcel.readFloat();
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.fLI), Float.valueOf(this.fLJ) });
  }
  
  public final void j(JSONObject paramJSONObject)
  {
    super.j(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.fLI = ((float)paramJSONObject.optDouble(0));
    this.fLJ = ((float)paramJSONObject.optDouble(1));
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.fLI);
    paramParcel.writeFloat(this.fLJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.ScaleActionArg
 * JD-Core Version:    0.7.0.1
 */