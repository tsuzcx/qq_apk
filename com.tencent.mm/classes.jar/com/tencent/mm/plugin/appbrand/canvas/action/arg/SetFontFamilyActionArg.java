package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetFontFamilyActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetFontFamilyActionArg> CREATOR = new SetFontFamilyActionArg.1();
  public String aPg;
  
  public SetFontFamilyActionArg() {}
  
  public SetFontFamilyActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof SetFontFamilyActionArg));
      bool1 = bool2;
    } while (!super.equals(paramObject));
    paramObject = (SetFontFamilyActionArg)paramObject;
    return Objects.equals(this.aPg, paramObject.aPg);
  }
  
  public final void f(Parcel paramParcel)
  {
    super.f(paramParcel);
    this.aPg = paramParcel.readString();
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.aPg });
  }
  
  public final void j(JSONObject paramJSONObject)
  {
    super.j(paramJSONObject);
    this.aPg = paramJSONObject.optJSONArray("data").optString(0);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.aPg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontFamilyActionArg
 * JD-Core Version:    0.7.0.1
 */