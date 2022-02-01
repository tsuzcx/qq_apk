package com.tencent.mm.ipcinvoker.wx_extension.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a;

public class IPCRunCgiRespWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<IPCRunCgiRespWrapper> CREATOR;
  public int errCode;
  public String errMsg;
  public int errType;
  public com.tencent.mm.am.c rr;
  
  static
  {
    AppMethodBeat.i(146438);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146438);
  }
  
  public IPCRunCgiRespWrapper() {}
  
  IPCRunCgiRespWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(146436);
    this.errType = paramParcel.readInt();
    this.errCode = paramParcel.readInt();
    this.errMsg = paramParcel.readString();
    this.rr = ((com.tencent.mm.am.c)com.tencent.mm.ipcinvoker.extension.c.a(a.class.getName(), paramParcel));
    AppMethodBeat.o(146436);
  }
  
  public static IPCRunCgiRespWrapper b(com.tencent.mm.am.c paramc)
  {
    AppMethodBeat.i(235720);
    IPCRunCgiRespWrapper localIPCRunCgiRespWrapper = new IPCRunCgiRespWrapper();
    localIPCRunCgiRespWrapper.rr = paramc;
    localIPCRunCgiRespWrapper.errMsg = null;
    localIPCRunCgiRespWrapper.errType = 3;
    localIPCRunCgiRespWrapper.errCode = -2;
    AppMethodBeat.o(235720);
    return localIPCRunCgiRespWrapper;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(146435);
    paramParcel.writeInt(this.errType);
    paramParcel.writeInt(this.errCode);
    paramParcel.writeString(this.errMsg);
    com.tencent.mm.ipcinvoker.extension.c.a(this.rr, paramParcel);
    AppMethodBeat.o(146435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper
 * JD-Core Version:    0.7.0.1
 */