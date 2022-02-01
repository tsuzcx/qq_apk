package com.tencent.mm.plugin.appbrand.message;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WxaAppMsgChannel
  implements Parcelable
{
  public static final Parcelable.Creator<WxaAppMsgChannel> CREATOR;
  public String appId;
  public String dEU;
  public long kdZ;
  public String lYA;
  public String lYz;
  public String msgId;
  public int msgType;
  
  static
  {
    AppMethodBeat.i(222842);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(222842);
  }
  
  public WxaAppMsgChannel() {}
  
  public WxaAppMsgChannel(Parcel paramParcel)
  {
    AppMethodBeat.i(222840);
    this.msgId = paramParcel.readString();
    this.lYz = paramParcel.readString();
    this.lYA = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.msgType = paramParcel.readInt();
    this.dEU = paramParcel.readString();
    this.kdZ = paramParcel.readLong();
    AppMethodBeat.o(222840);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(222841);
    paramParcel.writeString(this.msgId);
    paramParcel.writeString(this.lYz);
    paramParcel.writeString(this.lYA);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.msgType);
    paramParcel.writeString(this.dEU);
    paramParcel.writeLong(this.kdZ);
    AppMethodBeat.o(222841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.WxaAppMsgChannel
 * JD-Core Version:    0.7.0.1
 */