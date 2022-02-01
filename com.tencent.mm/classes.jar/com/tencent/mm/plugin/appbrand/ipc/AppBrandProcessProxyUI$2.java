package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandProcessProxyUI$2
  implements Runnable
{
  AppBrandProcessProxyUI$2(Class paramClass, Context paramContext, Intent paramIntent, AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest) {}
  
  public final void run()
  {
    AppMethodBeat.i(45386);
    if ((AppBrandProcessProxyUI.class != this.kph) && ((this.kpi instanceof Activity)))
    {
      ((Activity)this.kpi).startActivityForResult(this.kpj, this.kpk.bhT());
      AppMethodBeat.o(45386);
      return;
    }
    Context localContext = this.kpi;
    Object localObject = this.kpj;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(45386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI.2
 * JD-Core Version:    0.7.0.1
 */