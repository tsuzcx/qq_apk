package com.tencent.mm.plugin.appbrand.ui;

import a.l;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/AccountReleasePromptMMTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "TAG", "", "checkShouldLogin", "", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class a
  extends AppBrandProxyUIProcessTask
{
  private final String TAG = "MicroMsg.AccountReleasePromptMMTask";
  
  private final boolean aLY()
  {
    AppMethodBeat.i(134977);
    if (com.tencent.mm.kernel.a.QP())
    {
      ab.i(this.TAG, "checkShouldLogin account hold, return true");
      AppMethodBeat.o(134977);
      return true;
    }
    if ((g.RM().RF()) && (g.RJ().QU()))
    {
      ab.i(this.TAG, "checkShouldLogin account initialized, return false");
      AppMethodBeat.o(134977);
      return false;
    }
    ab.i(this.TAG, "checkShouldLogin fallback return true");
    AppMethodBeat.o(134977);
    return true;
  }
  
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(134976);
    if (!aLY())
    {
      a((AppBrandProxyUIProcessTask.ProcessResult)new AccountReleaseProxyUILaunchResult());
      AppMethodBeat.o(134976);
      return;
    }
    h.a((Context)aBf(), getString(2131296557), getString(2131297087), getString(2131296599), false, (DialogInterface.OnClickListener)new a.a(this));
    new a.b(this).alive();
    AppMethodBeat.o(134976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.a
 * JD-Core Version:    0.7.0.1
 */