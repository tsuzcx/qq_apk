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
  public String drV;
  public String dtG;
  public long jGx;
  public String luN;
  public String luO;
  public int msgType;
  
  static
  {
    AppMethodBeat.i(186877);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(186877);
  }
  
  public WxaAppMsgChannel() {}
  
  public WxaAppMsgChannel(Parcel paramParcel)
  {
    AppMethodBeat.i(186875);
    this.dtG = paramParcel.readString();
    this.luN = paramParcel.readString();
    this.luO = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.msgType = paramParcel.readInt();
    this.drV = paramParcel.readString();
    this.jGx = paramParcel.readLong();
    AppMethodBeat.o(186875);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(186876);
    paramParcel.writeString(this.dtG);
    paramParcel.writeString(this.luN);
    paramParcel.writeString(this.luO);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.msgType);
    paramParcel.writeString(this.drV);
    paramParcel.writeLong(this.jGx);
    AppMethodBeat.o(186876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.WxaAppMsgChannel
 * JD-Core Version:    0.7.0.1
 */