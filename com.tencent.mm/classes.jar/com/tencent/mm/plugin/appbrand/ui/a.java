package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.co;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/AccountReleasePromptMMTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "TAG", "", "checkShouldLogin", "", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class a
  extends AppBrandProxyUIProcessTask
{
  private final String TAG = "MicroMsg.AccountReleasePromptMMTask";
  
  private final boolean bWH()
  {
    AppMethodBeat.i(51096);
    if (com.tencent.mm.kernel.a.azj())
    {
      Log.i(this.TAG, "checkShouldLogin account hold, return true");
      AppMethodBeat.o(51096);
      return true;
    }
    if ((g.aAi().aAb()) && (g.aAf().azp()))
    {
      Log.i(this.TAG, "checkShouldLogin account initialized, return false");
      AppMethodBeat.o(51096);
      return false;
    }
    Log.i(this.TAG, "checkShouldLogin fallback return true");
    AppMethodBeat.o(51096);
    return true;
  }
  
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(51095);
    if (!bWH())
    {
      b((AppBrandProxyUIProcessTask.ProcessResult)new AccountReleaseProxyUILaunchResult());
      AppMethodBeat.o(51095);
      return;
    }
    h.a((Context)bDF(), getString(2131755328), getString(2131755998), getString(2131755401), false, (DialogInterface.OnClickListener)new a(this));
    new b(this).alive();
    AppMethodBeat.o(51095);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/ui/AccountReleasePromptMMTask$handleRequest$1", "Landroid/content/DialogInterface$OnClickListener;", "onClick", "", "dialog", "Landroid/content/DialogInterface;", "which", "", "plugin-appbrand-integration_release"})
  public static final class a
    implements DialogInterface.OnClickListener
  {
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(51093);
      if (a.a(this.nRe))
      {
        paramDialogInterface = (Context)a.b(this.nRe);
        Intent localIntent = new Intent();
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        localIntent.putExtra("Intro_Switch", true);
        c.f(paramDialogInterface, ".ui.LauncherUI", localIntent);
      }
      a.a(this.nRe, (AppBrandProxyUIProcessTask.ProcessResult)new AccountReleaseProxyUILaunchResult());
      AppMethodBeat.o(51093);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/ui/AccountReleasePromptMMTask$handleRequest$2", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CoreAccountInitializationNotifiedEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class b
    extends IListener<co>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.a
 * JD-Core Version:    0.7.0.1
 */