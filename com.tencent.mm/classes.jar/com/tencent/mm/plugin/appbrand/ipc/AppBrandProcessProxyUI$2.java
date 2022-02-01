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
    if ((AppBrandProcessProxyUI.class != this.jUT) && ((this.jUU instanceof Activity)))
    {
      ((Activity)this.jUU).startActivityForResult(this.jUV, this.jUW.bep());
      AppMethodBeat.o(45386);
      return;
    }
    Context localContext = this.jUU;
    Object localObject = this.jUV;
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(45386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI.2
 * JD-Core Version:    0.7.0.1
 */