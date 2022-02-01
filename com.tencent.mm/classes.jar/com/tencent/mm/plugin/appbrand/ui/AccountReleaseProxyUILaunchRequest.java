package com.tencent.mm.plugin.appbrand.ui;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/AccountReleaseProxyUILaunchRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "CREATOR", "plugin-appbrand-integration_release"})
final class AccountReleaseProxyUILaunchRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  
  static
  {
    AppMethodBeat.i(51102);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(51102);
  }
  
  public AccountReleaseProxyUILaunchRequest() {}
  
  public AccountReleaseProxyUILaunchRequest(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(51101);
    AppMethodBeat.o(51101);
  }
  
  public final Class<? extends AppBrandProxyUIProcessTask> aWl()
  {
    return a.class;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/AccountReleaseProxyUILaunchRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/ui/AccountReleaseProxyUILaunchRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/ui/AccountReleaseProxyUILaunchRequest;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<AccountReleaseProxyUILaunchRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AccountReleaseProxyUILaunchRequest
 * JD-Core Version:    0.7.0.1
 */