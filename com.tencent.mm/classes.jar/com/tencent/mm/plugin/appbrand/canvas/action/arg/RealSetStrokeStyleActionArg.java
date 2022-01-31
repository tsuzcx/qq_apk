package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.json.JSONArray;

public class RealSetStrokeStyleActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<RealSetStrokeStyleActionArg> CREATOR = new Parcelable.Creator() {};
  
  public RealSetStrokeStyleActionArg() {}
  
  public RealSetStrokeStyleActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void e(JSONArray paramJSONArray) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionArg
 * JD-Core Version:    0.7.0.1
 */