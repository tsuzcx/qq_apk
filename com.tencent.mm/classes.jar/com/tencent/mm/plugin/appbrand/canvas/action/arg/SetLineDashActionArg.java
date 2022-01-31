package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.u.h;
import java.util.Arrays;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SetLineDashActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetLineDashActionArg> CREATOR = new SetLineDashActionArg.1();
  public float[] fLV = null;
  public float fLW = 1.4E-45F;
  
  public SetLineDashActionArg() {}
  
  public SetLineDashActionArg(Parcel paramParcel)
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
      if (!(paramObject instanceof SetLineDashActionArg)) {
        return false;
      }
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (SetLineDashActionArg)paramObject;
    } while ((Float.compare(paramObject.fLW, this.fLW) == 0) && (Arrays.equals(this.fLV, paramObject.fLV)));
    return false;
  }
  
  public final void f(Parcel paramParcel)
  {
    super.f(paramParcel);
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.fLV = new float[i];
      paramParcel.readFloatArray(this.fLV);
    }
    this.fLW = paramParcel.readFloat();
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.fLW) }) * 31 + Arrays.hashCode(this.fLV);
  }
  
  public final void j(JSONObject paramJSONObject)
  {
    int i = 0;
    super.j(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    if (paramJSONObject.length() < 2) {}
    for (;;)
    {
      return;
      try
      {
        JSONArray localJSONArray = paramJSONObject.getJSONArray(0);
        if (localJSONArray != null)
        {
          this.fLV = new float[localJSONArray.length()];
          while (i < this.fLV.length)
          {
            this.fLV[i] = h.d(localJSONArray, i);
            i += 1;
          }
          this.fLW = h.d(paramJSONObject, 1);
          return;
        }
      }
      catch (JSONException paramJSONObject) {}
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    if (this.fLV != null)
    {
      paramParcel.writeInt(this.fLV.length);
      paramParcel.writeFloatArray(this.fLV);
    }
    paramParcel.writeFloat(this.fLW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineDashActionArg
 * JD-Core Version:    0.7.0.1
 */