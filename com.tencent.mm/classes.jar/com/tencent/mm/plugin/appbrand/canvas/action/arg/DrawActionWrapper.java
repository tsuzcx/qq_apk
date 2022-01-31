package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.d;
import com.tencent.mm.sdk.b;
import org.json.JSONException;
import org.json.JSONObject;

public class DrawActionWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<DrawActionWrapper> CREATOR = new DrawActionWrapper.1();
  public BaseDrawActionArg fLA;
  public JSONObject fLB;
  public int type;
  
  public DrawActionWrapper() {}
  
  public DrawActionWrapper(Parcel paramParcel)
  {
    this.type = paramParcel.readInt();
    switch (this.type)
    {
    default: 
      return;
    case 1: 
      paramParcel = paramParcel.readString();
      try
      {
        this.fLB = new JSONObject(paramParcel);
        return;
      }
      catch (JSONException paramParcel)
      {
        com.tencent.luggage.j.c.printErrStackTrace("DrawActionWrapper", paramParcel, "", new Object[0]);
        return;
      }
    }
    this.fLA = ((BaseDrawActionArg)paramParcel.readParcelable(DrawActionWrapper.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String getMethod()
  {
    switch (this.type)
    {
    default: 
      return "";
    case 1: 
      return this.fLB.optString("method");
    }
    return this.fLA.method;
  }
  
  public final void reset()
  {
    if (this.fLA != null)
    {
      this.fLA.reset();
      com.tencent.mm.plugin.appbrand.canvas.action.arg.a.c.adI().a(this.fLA);
    }
    d locald = d.adJ();
    if (this != null) {
      locald.fMl.D(this);
    }
  }
  
  public String toString()
  {
    return String.format("type %d ,method %s", new Object[] { Integer.valueOf(this.type), getMethod() });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.type);
    switch (this.type)
    {
    default: 
      return;
    case 1: 
      paramParcel.writeString(this.fLB.toString());
      return;
    }
    paramParcel.writeParcelable(this.fLA, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper
 * JD-Core Version:    0.7.0.1
 */