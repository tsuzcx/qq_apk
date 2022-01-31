package com.tencent.mm.ipcinvoker.wx_extension.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ah.b;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.ipcinvoker.wx_extension.a;

public class IPCRunCgiRespWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<IPCRunCgiRespWrapper> CREATOR = new IPCRunCgiRespWrapper.1();
  public String aox;
  public b dmK;
  public int errCode;
  public int errType;
  
  public IPCRunCgiRespWrapper() {}
  
  IPCRunCgiRespWrapper(Parcel paramParcel)
  {
    this.errType = paramParcel.readInt();
    this.errCode = paramParcel.readInt();
    this.aox = paramParcel.readString();
    this.dmK = ((b)c.a(a.class.getName(), paramParcel));
  }
  
  public static IPCRunCgiRespWrapper Ch()
  {
    IPCRunCgiRespWrapper localIPCRunCgiRespWrapper = new IPCRunCgiRespWrapper();
    localIPCRunCgiRespWrapper.dmK = null;
    localIPCRunCgiRespWrapper.aox = null;
    localIPCRunCgiRespWrapper.errType = 3;
    localIPCRunCgiRespWrapper.errCode = -2;
    return localIPCRunCgiRespWrapper;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.errType);
    paramParcel.writeInt(this.errCode);
    paramParcel.writeString(this.aox);
    c.a(this.dmK, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper
 * JD-Core Version:    0.7.0.1
 */