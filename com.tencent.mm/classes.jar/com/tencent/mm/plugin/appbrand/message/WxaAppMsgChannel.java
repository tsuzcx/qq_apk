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
  public String hWn;
  public String msgId;
  public int msgType;
  public long rdg;
  public String tlA;
  public String tlB;
  
  static
  {
    AppMethodBeat.i(317180);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(317180);
  }
  
  public WxaAppMsgChannel() {}
  
  public WxaAppMsgChannel(Parcel paramParcel)
  {
    AppMethodBeat.i(317176);
    this.msgId = paramParcel.readString();
    this.tlA = paramParcel.readString();
    this.tlB = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.msgType = paramParcel.readInt();
    this.hWn = paramParcel.readString();
    this.rdg = paramParcel.readLong();
    AppMethodBeat.o(317176);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(317185);
    paramParcel.writeString(this.msgId);
    paramParcel.writeString(this.tlA);
    paramParcel.writeString(this.tlB);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.msgType);
    paramParcel.writeString(this.hWn);
    paramParcel.writeLong(this.rdg);
    AppMethodBeat.o(317185);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.WxaAppMsgChannel
 * JD-Core Version:    0.7.0.1
 */