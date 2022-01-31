package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetTextAlignActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetTextAlignActionArg> CREATOR = new SetTextAlignActionArg.1();
  public String fMb;
  
  public SetTextAlignActionArg() {}
  
  public SetTextAlignActionArg(Parcel paramParcel)
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
      } while (!(paramObject instanceof SetTextAlignActionArg));
      bool1 = bool2;
    } while (!super.equals(paramObject));
    paramObject = (SetTextAlignActionArg)paramObject;
    return Objects.equals(this.fMb, paramObject.fMb);
  }
  
  public final void f(Parcel paramParcel)
  {
    super.f(paramParcel);
    this.fMb = paramParcel.readString();
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.fMb });
  }
  
  public final void j(JSONObject paramJSONObject)
  {
    super.j(paramJSONObject);
    this.fMb = paramJSONObject.optJSONArray("data").optString(0);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.fMb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTextAlignActionArg
 * JD-Core Version:    0.7.0.1
 */