package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.json.JSONArray;

public class RealSetFillStyleActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<RealSetFillStyleActionArg> CREATOR = new RealSetFillStyleActionArg.1();
  
  public RealSetFillStyleActionArg() {}
  
  public RealSetFillStyleActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void e(JSONArray paramJSONArray) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionArg
 * JD-Core Version:    0.7.0.1
 */