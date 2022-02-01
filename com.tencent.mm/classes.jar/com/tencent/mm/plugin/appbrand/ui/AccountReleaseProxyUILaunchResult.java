package com.tencent.mm.plugin.appbrand.ui;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/AccountReleaseProxyUILaunchResult;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessResult;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "describeContents", "", "readParcel", "", "in", "writeToParcel", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class AccountReleaseProxyUILaunchResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final a CREATOR;
  
  static
  {
    AppMethodBeat.i(51105);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(51105);
  }
  
  public AccountReleaseProxyUILaunchResult() {}
  
  public AccountReleaseProxyUILaunchResult(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(51104);
    AppMethodBeat.o(51104);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void j(Parcel paramParcel) {}
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/AccountReleaseProxyUILaunchResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/ui/AccountReleaseProxyUILaunchResult;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/ui/AccountReleaseProxyUILaunchResult;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<AccountReleaseProxyUILaunchResult>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AccountReleaseProxyUILaunchResult
 * JD-Core Version:    0.7.0.1
 */