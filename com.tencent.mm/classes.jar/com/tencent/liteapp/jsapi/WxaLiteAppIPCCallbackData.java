package com.tencent.liteapp.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WxaLiteAppIPCCallbackData
  implements Parcelable
{
  public static final Parcelable.Creator<WxaLiteAppIPCCallbackData> CREATOR;
  public boolean cqT;
  public String cqU;
  public String cqV;
  
  static
  {
    AppMethodBeat.i(197700);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(197700);
  }
  
  public WxaLiteAppIPCCallbackData()
  {
    this.cqT = false;
    this.cqU = null;
    this.cqV = null;
  }
  
  public WxaLiteAppIPCCallbackData(Parcel paramParcel)
  {
    AppMethodBeat.i(197698);
    this.cqT = false;
    this.cqU = null;
    this.cqV = null;
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.cqT = bool;
      this.cqU = paramParcel.readString();
      this.cqV = paramParcel.readString();
      AppMethodBeat.o(197698);
      return;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(197699);
    if (this.cqT) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.cqU);
      paramParcel.writeString(this.cqV);
      AppMethodBeat.o(197699);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.jsapi.WxaLiteAppIPCCallbackData
 * JD-Core Version:    0.7.0.1
 */