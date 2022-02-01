package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.h;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/AccountReleasePromptMMTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "TAG", "", "checkShouldLogin", "", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class a
  extends AppBrandProxyUIProcessTask
{
  private final String TAG = "MicroMsg.AccountReleasePromptMMTask";
  
  private final boolean bzN()
  {
    AppMethodBeat.i(51096);
    if (com.tencent.mm.kernel.a.aiT())
    {
      ae.i(this.TAG, "checkShouldLogin account hold, return true");
      AppMethodBeat.o(51096);
      return true;
    }
    if ((g.ajS().ajL()) && (g.ajP().aiZ()))
    {
      ae.i(this.TAG, "checkShouldLogin account initialized, return false");
      AppMethodBeat.o(51096);
      return false;
    }
    ae.i(this.TAG, "checkShouldLogin fallback return true");
    AppMethodBeat.o(51096);
    return true;
  }
  
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(51095);
    if (!bzN())
    {
      b((AppBrandProxyUIProcessTask.ProcessResult)new AccountReleaseProxyUILaunchResult());
      AppMethodBeat.o(51095);
      return;
    }
    h.a((Context)bis(), getString(2131755292), getString(2131755906), getString(2131755364), false, (DialogInterface.OnClickListener)new a(this));
    new b(this).alive();
    AppMethodBeat.o(51095);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/ui/AccountReleasePromptMMTask$handleRequest$1", "Landroid/content/DialogInterface$OnClickListener;", "onClick", "", "dialog", "Landroid/content/DialogInterface;", "which", "", "plugin-appbrand-integration_release"})
  public static final class a
    implements DialogInterface.OnClickListener
  {
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(51093);
      if (a.a(this.mEp))
      {
        paramDialogInterface = (Context)a.b(this.mEp);
        Intent localIntent = new Intent();
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        localIntent.putExtra("Intro_Switch", true);
        d.f(paramDialogInterface, ".ui.LauncherUI", localIntent);
      }
      a.a(this.mEp, (AppBrandProxyUIProcessTask.ProcessResult)new AccountReleaseProxyUILaunchResult());
      AppMethodBeat.o(51093);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/ui/AccountReleasePromptMMTask$handleRequest$2", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CoreAccountInitializationNotifiedEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class b
    extends c<cl>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.a
 * JD-Core Version:    0.7.0.1
 */