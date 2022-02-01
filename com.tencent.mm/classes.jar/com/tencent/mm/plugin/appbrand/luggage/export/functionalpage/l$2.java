package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;

final class l$2
  implements Runnable
{
  l$2(l paraml, Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(319909);
    if ((this.val$context instanceof AppBrandPluginUI)) {
      ((AppBrandPluginUI)this.val$context).finish();
    }
    AppMethodBeat.o(319909);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l.2
 * JD-Core Version:    0.7.0.1
 */