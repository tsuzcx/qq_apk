package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;

public class BasePathActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<BasePathActionArg> CREATOR = new BasePathActionArg.1();
  
  public BasePathActionArg() {}
  
  protected BasePathActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg
 * JD-Core Version:    0.7.0.1
 */