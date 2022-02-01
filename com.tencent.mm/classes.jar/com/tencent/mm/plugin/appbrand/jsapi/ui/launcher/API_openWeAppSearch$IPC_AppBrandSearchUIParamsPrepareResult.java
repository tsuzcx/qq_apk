package com.tencent.mm.plugin.appbrand.jsapi.ui.launcher;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "resultCode", "", "getResultCode", "()I", "setResultCode", "(I)V", "describeContents", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
final class API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult
  implements Parcelable
{
  public static final Parcelable.Creator<IPC_AppBrandSearchUIParamsPrepareResult> CREATOR;
  public static final API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult.a ptF;
  Intent intent;
  int resultCode;
  
  static
  {
    AppMethodBeat.i(50709);
    ptF = new API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(50709);
  }
  
  public API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult() {}
  
  public API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(50708);
    this.resultCode = paramParcel.readInt();
    this.intent = ((Intent)paramParcel.readParcelable(Intent.class.getClassLoader()));
    AppMethodBeat.o(50708);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(50707);
    p.k(paramParcel, "dest");
    paramParcel.writeInt(this.resultCode);
    paramParcel.writeParcelable((Parcelable)this.intent, paramInt);
    AppMethodBeat.o(50707);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "plugin-appbrand-integration_release"})
  public static final class b
    implements Parcelable.Creator<API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult
 * JD-Core Version:    0.7.0.1
 */