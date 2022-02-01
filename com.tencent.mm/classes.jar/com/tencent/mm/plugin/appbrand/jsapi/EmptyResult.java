package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/EmptyResult;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessResult;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "describeContents", "", "readParcel", "", "in", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmptyResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final a CREATOR;
  
  static
  {
    AppMethodBeat.i(325505);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(325505);
  }
  
  public EmptyResult() {}
  
  public EmptyResult(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(325503);
    AppMethodBeat.o(325503);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void readParcel(Parcel paramParcel) {}
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(325508);
    s.u(paramParcel, "parcel");
    AppMethodBeat.o(325508);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/EmptyResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/EmptyResult;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/EmptyResult;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<EmptyResult>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.EmptyResult
 * JD-Core Version:    0.7.0.1
 */