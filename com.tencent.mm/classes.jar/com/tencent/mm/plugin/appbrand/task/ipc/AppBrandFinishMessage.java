package com.tencent.mm.plugin.appbrand.task.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.processes.client.LuggageClientProcessMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/task/ipc/AppBrandFinishMessage;", "Lcom/tencent/luggage/sdk/processes/client/LuggageClientProcessMessage;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "appId", "", "(Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "describeContents", "", "runInLuggageProcess", "", "runtime", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
public final class AppBrandFinishMessage
  extends LuggageClientProcessMessage<t>
{
  public static final Parcelable.Creator CREATOR;
  private final String appId;
  
  static
  {
    AppMethodBeat.i(262258);
    CREATOR = new a();
    AppMethodBeat.o(262258);
  }
  
  public AppBrandFinishMessage(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(262254);
    this.appId = paramString;
    AppMethodBeat.o(262254);
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
    AppMethodBeat.i(262256);
    p.k(paramParcel, "parcel");
    paramParcel.writeString(this.appId);
    AppMethodBeat.o(262256);
  }
  
  @l(iBK={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(278370);
      p.k(paramParcel, "in");
      paramParcel = new AppBrandFinishMessage(paramParcel.readString());
      AppMethodBeat.o(278370);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new AppBrandFinishMessage[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.ipc.AppBrandFinishMessage
 * JD-Core Version:    0.7.0.1
 */