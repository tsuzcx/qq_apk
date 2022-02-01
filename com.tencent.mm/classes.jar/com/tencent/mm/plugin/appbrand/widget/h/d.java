package com.tencent.mm.plugin.appbrand.widget.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/prompt/AutoDismissRunner;", "Ljava/lang/Runnable;", "toast", "Lcom/tencent/mm/plugin/appbrand/widget/prompt/AppBrandPopupToast;", "(Lcom/tencent/mm/plugin/appbrand/widget/prompt/AppBrandPopupToast;)V", "ref", "Ljava/lang/ref/WeakReference;", "run", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class d
  implements Runnable
{
  private final WeakReference<c> tzB;
  
  public d(c paramc)
  {
    AppMethodBeat.i(51452);
    this.tzB = new WeakReference(paramc);
    AppMethodBeat.o(51452);
  }
  
  public final void run()
  {
    AppMethodBeat.i(51451);
    c localc = (c)this.tzB.get();
    if (localc != null) {
      localc.dismiss();
    }
    AppMethodBeat.o(51451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.h.d
 * JD-Core Version:    0.7.0.1
 */