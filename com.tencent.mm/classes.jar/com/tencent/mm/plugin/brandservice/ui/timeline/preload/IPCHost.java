package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/IPCHost;", "Landroid/os/Parcelable;", "Lcom/tencent/mm/ipcinvoker/event/IPCData;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "hosts", "", "", "([Ljava/lang/String;)V", "getHosts", "()[Ljava/lang/String;", "setHosts", "[Ljava/lang/String;", "describeContents", "", "fromBundle", "", "bundle", "Landroid/os/Bundle;", "invoke", "processName", "process", "Ljava/lang/Class;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "callback", "Lkotlin/Function1;", "toBundle", "writeToParcel", "flags", "CREATOR", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class IPCHost
  implements Parcelable, a
{
  public static final a CREATOR;
  private String[] vRd;
  
  static
  {
    AppMethodBeat.i(6589);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(6589);
  }
  
  public IPCHost(Parcel paramParcel)
  {
    this(paramParcel);
    AppMethodBeat.i(6588);
    AppMethodBeat.o(6588);
  }
  
  private IPCHost(String[] paramArrayOfString)
  {
    AppMethodBeat.i(6587);
    this.vRd = paramArrayOfString;
    AppMethodBeat.o(6587);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(6585);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getStringArray("hosts");
      if (paramBundle == null)
      {
        paramBundle = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        AppMethodBeat.o(6585);
        throw paramBundle;
      }
      s.u(paramBundle, "<set-?>");
      this.vRd = paramBundle;
    }
    AppMethodBeat.o(6585);
  }
  
  public final Bundle toBundle()
  {
    AppMethodBeat.i(6584);
    Bundle localBundle = new Bundle();
    localBundle.putStringArray("hosts", this.vRd);
    AppMethodBeat.o(6584);
    return localBundle;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(6586);
    s.u(paramParcel, "parcel");
    paramParcel.writeStringArray(this.vRd);
    AppMethodBeat.o(6586);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/IPCHost$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/IPCHost;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/IPCHost;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<IPCHost>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.IPCHost
 * JD-Core Version:    0.7.0.1
 */