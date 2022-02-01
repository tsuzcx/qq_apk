package com.tencent.liteapp.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WxaLiteAppIPCCallbackData
  implements Parcelable
{
  public static final Parcelable.Creator<WxaLiteAppIPCCallbackData> CREATOR;
  public boolean coH;
  public String coI;
  public String coJ;
  
  static
  {
    AppMethodBeat.i(258516);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(258516);
  }
  
  public WxaLiteAppIPCCallbackData()
  {
    this.coH = false;
    this.coI = null;
    this.coJ = null;
  }
  
  public WxaLiteAppIPCCallbackData(Parcel paramParcel)
  {
    AppMethodBeat.i(258514);
    this.coH = false;
    this.coI = null;
    this.coJ = null;
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.coH = bool;
      this.coI = paramParcel.readString();
      this.coJ = paramParcel.readString();
      AppMethodBeat.o(258514);
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
    AppMethodBeat.i(258515);
    if (this.coH) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.coI);
      paramParcel.writeString(this.coJ);
      AppMethodBeat.o(258515);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.jsapi.WxaLiteAppIPCCallbackData
 * JD-Core Version:    0.7.0.1
 */