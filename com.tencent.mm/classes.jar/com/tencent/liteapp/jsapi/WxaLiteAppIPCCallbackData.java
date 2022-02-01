package com.tencent.liteapp.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WxaLiteAppIPCCallbackData
  implements Parcelable
{
  public static final Parcelable.Creator<WxaLiteAppIPCCallbackData> CREATOR;
  public boolean efS;
  public String efT;
  public String efU;
  
  static
  {
    AppMethodBeat.i(219081);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(219081);
  }
  
  public WxaLiteAppIPCCallbackData()
  {
    this.efS = false;
    this.efT = null;
    this.efU = null;
  }
  
  public WxaLiteAppIPCCallbackData(Parcel paramParcel)
  {
    AppMethodBeat.i(219075);
    this.efS = false;
    this.efT = null;
    this.efU = null;
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.efS = bool;
      this.efT = paramParcel.readString();
      this.efU = paramParcel.readString();
      AppMethodBeat.o(219075);
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
    AppMethodBeat.i(219094);
    if (this.efS) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.efT);
      paramParcel.writeString(this.efU);
      AppMethodBeat.o(219094);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.jsapi.WxaLiteAppIPCCallbackData
 * JD-Core Version:    0.7.0.1
 */