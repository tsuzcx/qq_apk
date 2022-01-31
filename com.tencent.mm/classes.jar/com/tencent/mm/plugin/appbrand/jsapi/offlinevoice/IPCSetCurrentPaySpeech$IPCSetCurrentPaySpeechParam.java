package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class IPCSetCurrentPaySpeech$IPCSetCurrentPaySpeechParam
  implements Parcelable
{
  public static final Parcelable.Creator<IPCSetCurrentPaySpeechParam> CREATOR;
  private String hVd;
  private String hVe;
  private String hVf;
  private boolean hVg;
  private String hVh;
  
  static
  {
    AppMethodBeat.i(131369);
    CREATOR = new IPCSetCurrentPaySpeech.IPCSetCurrentPaySpeechParam.1();
    AppMethodBeat.o(131369);
  }
  
  public IPCSetCurrentPaySpeech$IPCSetCurrentPaySpeechParam() {}
  
  protected IPCSetCurrentPaySpeech$IPCSetCurrentPaySpeechParam(Parcel paramParcel)
  {
    AppMethodBeat.i(131368);
    this.hVd = paramParcel.readString();
    this.hVe = paramParcel.readString();
    this.hVf = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.hVg = bool;
      this.hVh = paramParcel.readString();
      AppMethodBeat.o(131368);
      return;
    }
  }
  
  public IPCSetCurrentPaySpeech$IPCSetCurrentPaySpeechParam(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    this.hVd = paramString1;
    this.hVe = paramString2;
    this.hVf = paramString3;
    this.hVg = paramBoolean;
    this.hVh = paramString4;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(131367);
    paramParcel.writeString(this.hVd);
    paramParcel.writeString(this.hVe);
    paramParcel.writeString(this.hVf);
    if (this.hVg) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeString(this.hVh);
      AppMethodBeat.o(131367);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.IPCSetCurrentPaySpeech.IPCSetCurrentPaySpeechParam
 * JD-Core Version:    0.7.0.1
 */