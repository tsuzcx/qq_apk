package com.tencent.mm.plugin.appbrand.jsapi.lab;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class JsApiSetLabInfo$IPCSetLabInfoRequest
  implements Parcelable
{
  public static final Parcelable.Creator<IPCSetLabInfoRequest> CREATOR;
  private String cwc;
  private boolean enabled;
  
  static
  {
    AppMethodBeat.i(131106);
    CREATOR = new JsApiSetLabInfo.IPCSetLabInfoRequest.1();
    AppMethodBeat.o(131106);
  }
  
  public JsApiSetLabInfo$IPCSetLabInfoRequest() {}
  
  protected JsApiSetLabInfo$IPCSetLabInfoRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(131105);
    this.cwc = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.enabled = bool;
      AppMethodBeat.o(131105);
      return;
    }
  }
  
  public JsApiSetLabInfo$IPCSetLabInfoRequest(String paramString, boolean paramBoolean)
  {
    this.cwc = paramString;
    this.enabled = paramBoolean;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(131104);
    paramParcel.writeString(this.cwc);
    if (this.enabled) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      AppMethodBeat.o(131104);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiSetLabInfo.IPCSetLabInfoRequest
 * JD-Core Version:    0.7.0.1
 */