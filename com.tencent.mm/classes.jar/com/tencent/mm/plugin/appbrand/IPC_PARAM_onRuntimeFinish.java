package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/IPC_PARAM_onRuntimeFinish;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "appId", "", "(Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class IPC_PARAM_onRuntimeFinish
  implements Parcelable
{
  public static final a CREATOR;
  final String appId;
  
  static
  {
    AppMethodBeat.i(227913);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(227913);
  }
  
  public IPC_PARAM_onRuntimeFinish(Parcel paramParcel)
  {
    this(paramParcel);
    AppMethodBeat.i(227912);
    AppMethodBeat.o(227912);
  }
  
  public IPC_PARAM_onRuntimeFinish(String paramString)
  {
    AppMethodBeat.i(227911);
    this.appId = paramString;
    AppMethodBeat.o(227911);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(227910);
    p.h(paramParcel, "parcel");
    paramParcel.writeString(this.appId);
    AppMethodBeat.o(227910);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/IPC_PARAM_onRuntimeFinish$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/IPC_PARAM_onRuntimeFinish;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/IPC_PARAM_onRuntimeFinish;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<IPC_PARAM_onRuntimeFinish>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.IPC_PARAM_onRuntimeFinish
 * JD-Core Version:    0.7.0.1
 */