package com.tencent.mm.plugin.appbrand.jsapi.ui.launcher;

import a.f.b.j;
import a.l;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "resultCode", "", "getResultCode", "()I", "setResultCode", "(I)V", "describeContents", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
final class API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult
  implements Parcelable
{
  public static final Parcelable.Creator<IPC_AppBrandSearchUIParamsPrepareResult> CREATOR;
  public static final API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult.a ibm;
  int bpE;
  Intent intent;
  
  static
  {
    AppMethodBeat.i(143889);
    ibm = new API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult.a((byte)0);
    CREATOR = (Parcelable.Creator)new API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult.b();
    AppMethodBeat.o(143889);
  }
  
  public API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult() {}
  
  public API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(143888);
    this.bpE = paramParcel.readInt();
    this.intent = ((Intent)paramParcel.readParcelable(Intent.class.getClassLoader()));
    AppMethodBeat.o(143888);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(143887);
    j.q(paramParcel, "dest");
    paramParcel.writeInt(this.bpE);
    paramParcel.writeParcelable((Parcelable)this.intent, paramInt);
    AppMethodBeat.o(143887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult
 * JD-Core Version:    0.7.0.1
 */