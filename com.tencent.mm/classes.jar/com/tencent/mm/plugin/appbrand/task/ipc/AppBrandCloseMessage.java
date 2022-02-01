package com.tencent.mm.plugin.appbrand.task.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.processes.client.LuggageClientProcessMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.w;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/task/ipc/AppBrandCloseMessage;", "Lcom/tencent/luggage/sdk/processes/client/LuggageClientProcessMessage;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "appId", "", "(Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "describeContents", "", "runInLuggageProcess", "", "runtime", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandCloseMessage
  extends LuggageClientProcessMessage<w>
{
  public static final Parcelable.Creator<AppBrandCloseMessage> CREATOR;
  private final String appId;
  
  static
  {
    AppMethodBeat.i(318687);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(318687);
  }
  
  public AppBrandCloseMessage(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(318677);
    this.appId = paramString;
    AppMethodBeat.o(318677);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String getAppId()
  {
    return this.appId;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(318702);
    s.u(paramParcel, "out");
    paramParcel.writeString(this.appId);
    AppMethodBeat.o(318702);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<AppBrandCloseMessage>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.ipc.AppBrandCloseMessage
 * JD-Core Version:    0.7.0.1
 */