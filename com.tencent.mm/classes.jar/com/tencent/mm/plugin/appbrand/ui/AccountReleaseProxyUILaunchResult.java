package com.tencent.mm.plugin.appbrand.ui;

import a.l;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/AccountReleaseProxyUILaunchResult;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessResult;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "describeContents", "", "readParcel", "", "in", "writeToParcel", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class AccountReleaseProxyUILaunchResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final AccountReleaseProxyUILaunchResult.a CREATOR;
  
  static
  {
    AppMethodBeat.i(134986);
    CREATOR = new AccountReleaseProxyUILaunchResult.a((byte)0);
    AppMethodBeat.o(134986);
  }
  
  public AccountReleaseProxyUILaunchResult() {}
  
  public AccountReleaseProxyUILaunchResult(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(134985);
    AppMethodBeat.o(134985);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void j(Parcel paramParcel) {}
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AccountReleaseProxyUILaunchResult
 * JD-Core Version:    0.7.0.1
 */