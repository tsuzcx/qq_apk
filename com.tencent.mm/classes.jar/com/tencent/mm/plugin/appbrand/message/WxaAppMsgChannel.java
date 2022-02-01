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
  public String fQs;
  public String msgId;
  public int msgType;
  public long oco;
  public String qgP;
  public String qgQ;
  
  static
  {
    AppMethodBeat.i(265681);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(265681);
  }
  
  public WxaAppMsgChannel() {}
  
  public WxaAppMsgChannel(Parcel paramParcel)
  {
    AppMethodBeat.i(265679);
    this.msgId = paramParcel.readString();
    this.qgP = paramParcel.readString();
    this.qgQ = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.msgType = paramParcel.readInt();
    this.fQs = paramParcel.readString();
    this.oco = paramParcel.readLong();
    AppMethodBeat.o(265679);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(265680);
    paramParcel.writeString(this.msgId);
    paramParcel.writeString(this.qgP);
    paramParcel.writeString(this.qgQ);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.msgType);
    paramParcel.writeString(this.fQs);
    paramParcel.writeLong(this.oco);
    AppMethodBeat.o(265680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.WxaAppMsgChannel
 * JD-Core Version:    0.7.0.1
 */