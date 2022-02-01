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
  public String dWG;
  public long lhG;
  public String msgId;
  public int msgType;
  public String ngf;
  public String ngg;
  
  static
  {
    AppMethodBeat.i(227193);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(227193);
  }
  
  public WxaAppMsgChannel() {}
  
  public WxaAppMsgChannel(Parcel paramParcel)
  {
    AppMethodBeat.i(227191);
    this.msgId = paramParcel.readString();
    this.ngf = paramParcel.readString();
    this.ngg = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.msgType = paramParcel.readInt();
    this.dWG = paramParcel.readString();
    this.lhG = paramParcel.readLong();
    AppMethodBeat.o(227191);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(227192);
    paramParcel.writeString(this.msgId);
    paramParcel.writeString(this.ngf);
    paramParcel.writeString(this.ngg);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.msgType);
    paramParcel.writeString(this.dWG);
    paramParcel.writeLong(this.lhG);
    AppMethodBeat.o(227192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.WxaAppMsgChannel
 * JD-Core Version:    0.7.0.1
 */