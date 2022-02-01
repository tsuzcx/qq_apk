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
    if ((AppBrandProcessProxyUI.class != this.juy) && ((this.juz instanceof Activity)))
    {
      ((Activity)this.juz).startActivityForResult(this.juA, this.juB.aXs());
      AppMethodBeat.o(45386);
      return;
    }
    Context localContext = this.juz;
    Object localObject = this.juA;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(45386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI.2
 * JD-Core Version:    0.7.0.1
 */