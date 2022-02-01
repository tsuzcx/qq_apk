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
  public String dDP;
  public long kaJ;
  public String lTW;
  public String lTX;
  public String msgId;
  public int msgType;
  
  static
  {
    AppMethodBeat.i(188672);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(188672);
  }
  
  public WxaAppMsgChannel() {}
  
  public WxaAppMsgChannel(Parcel paramParcel)
  {
    AppMethodBeat.i(188670);
    this.msgId = paramParcel.readString();
    this.lTW = paramParcel.readString();
    this.lTX = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.msgType = paramParcel.readInt();
    this.dDP = paramParcel.readString();
    this.kaJ = paramParcel.readLong();
    AppMethodBeat.o(188670);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(188671);
    paramParcel.writeString(this.msgId);
    paramParcel.writeString(this.lTW);
    paramParcel.writeString(this.lTX);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.msgType);
    paramParcel.writeString(this.dDP);
    paramParcel.writeLong(this.kaJ);
    AppMethodBeat.o(188671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.WxaAppMsgChannel
 * JD-Core Version:    0.7.0.1
 */