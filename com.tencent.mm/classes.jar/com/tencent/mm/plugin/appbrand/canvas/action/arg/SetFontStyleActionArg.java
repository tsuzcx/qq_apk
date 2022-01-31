package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetFontStyleActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetFontStyleActionArg> CREATOR = new SetFontStyleActionArg.1();
  public String fLS;
  
  public SetFontStyleActionArg() {}
  
  public SetFontStyleActionArg(Parcel paramParcel)
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
      } while (!(paramObject instanceof SetFontStyleActionArg));
      bool1 = bool2;
    } while (!super.equals(paramObject));
    paramObject = (SetFontStyleActionArg)paramObject;
    return Objects.equals(this.fLS, paramObject.fLS);
  }
  
  public final void f(Parcel paramParcel)
  {
    super.f(paramParcel);
    this.fLS = paramParcel.readString();
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.fLS });
  }
  
  public final void j(JSONObject paramJSONObject)
  {
    super.j(paramJSONObject);
    this.fLS = paramJSONObject.optJSONArray("data").optString(0);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.fLS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontStyleActionArg
 * JD-Core Version:    0.7.0.1
 */