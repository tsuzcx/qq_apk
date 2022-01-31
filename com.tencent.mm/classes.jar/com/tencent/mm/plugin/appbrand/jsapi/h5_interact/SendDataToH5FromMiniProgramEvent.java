package com.tencent.mm.plugin.appbrand.jsapi.h5_interact;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.b.b;

public class SendDataToH5FromMiniProgramEvent
  extends b
  implements Parcelable
{
  public static final Parcelable.Creator<SendDataToH5FromMiniProgramEvent> CREATOR = new Parcelable.Creator() {};
  public String data;
  public String gqT;
  public int gqU;
  
  public SendDataToH5FromMiniProgramEvent() {}
  
  protected SendDataToH5FromMiniProgramEvent(Parcel paramParcel)
  {
    this.gqT = paramParcel.readString();
    this.data = paramParcel.readString();
    this.gqU = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.gqT);
    paramParcel.writeString(this.data);
    paramParcel.writeInt(this.gqU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToH5FromMiniProgramEvent
 * JD-Core Version:    0.7.0.1
 */