package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetLineJoinActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetLineJoinActionArg> CREATOR = new Parcelable.Creator() {};
  public String fLX;
  
  public SetLineJoinActionArg() {}
  
  public SetLineJoinActionArg(Parcel paramParcel)
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
      } while (!(paramObject instanceof SetLineJoinActionArg));
      bool1 = bool2;
    } while (!super.equals(paramObject));
    paramObject = (SetLineJoinActionArg)paramObject;
    return Objects.equals(this.fLX, paramObject.fLX);
  }
  
  public final void f(Parcel paramParcel)
  {
    super.f(paramParcel);
    this.fLX = paramParcel.readString();
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.fLX });
  }
  
  public final void j(JSONObject paramJSONObject)
  {
    super.j(paramJSONObject);
    this.fLX = paramJSONObject.optJSONArray("data").optString(0);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.fLX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineJoinActionArg
 * JD-Core Version:    0.7.0.1
 */