package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;

final class JsApiPrivateAddContact$AddContactResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final Parcelable.Creator<AddContactResult> CREATOR;
  private int bpE;
  
  static
  {
    AppMethodBeat.i(73165);
    CREATOR = new JsApiPrivateAddContact.AddContactResult.1();
    AppMethodBeat.o(73165);
  }
  
  JsApiPrivateAddContact$AddContactResult() {}
  
  JsApiPrivateAddContact$AddContactResult(Parcel paramParcel)
  {
    AppMethodBeat.i(73162);
    j(paramParcel);
    AppMethodBeat.o(73162);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void j(Parcel paramParcel)
  {
    AppMethodBeat.i(73163);
    this.bpE = paramParcel.readInt();
    AppMethodBeat.o(73163);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(73164);
    paramParcel.writeInt(this.bpE);
    AppMethodBeat.o(73164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact.AddContactResult
 * JD-Core Version:    0.7.0.1
 */