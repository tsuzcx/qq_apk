package com.tencent.mm.plugin.appbrand.jsapi.h5_interact;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SendDataToMiniProgramFromH5Event
  implements Parcelable
{
  public static final Parcelable.Creator<SendDataToMiniProgramFromH5Event> CREATOR = new SendDataToMiniProgramFromH5Event.1();
  public String data;
  public String gqV;
  public int gqW;
  
  public SendDataToMiniProgramFromH5Event() {}
  
  protected SendDataToMiniProgramFromH5Event(Parcel paramParcel)
  {
    this.gqV = paramParcel.readString();
    this.data = paramParcel.readString();
    this.gqW = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.gqV);
    paramParcel.writeString(this.data);
    paramParcel.writeInt(this.gqW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToMiniProgramFromH5Event
 * JD-Core Version:    0.7.0.1
 */