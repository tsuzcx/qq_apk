package com.tencent.mm.plugin.appbrand.task.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.processes.client.LuggageClientProcessMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/task/ipc/AppBrandNetworkChangeMessage;", "Lcom/tencent/luggage/sdk/processes/client/LuggageClientProcessMessage;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "appId", "", "(Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "describeContents", "", "runInLuggageProcess", "", "runtime", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
public final class AppBrandNetworkChangeMessage
  extends LuggageClientProcessMessage<t>
{
  public static final Parcelable.Creator CREATOR;
  private final String appId;
  
  static
  {
    AppMethodBeat.i(247463);
    CREATOR = new a();
    AppMethodBeat.o(247463);
  }
  
  public AppBrandNetworkChangeMessage(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(247459);
    this.appId = paramString;
    AppMethodBeat.o(247459);
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
    AppMethodBeat.i(247462);
    p.k(paramParcel, "parcel");
    paramParcel.writeString(this.appId);
    AppMethodBeat.o(247462);
  }
  
  @l(iBK={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(272032);
      p.k(paramParcel, "in");
      paramParcel = new AppBrandNetworkChangeMessage(paramParcel.readString());
      AppMethodBeat.o(272032);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new AppBrandNetworkChangeMessage[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.ipc.AppBrandNetworkChangeMessage
 * JD-Core Version:    0.7.0.1
 */