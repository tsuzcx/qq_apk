package com.tencent.mm.plugin.appbrand.widget.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.lang.ref.WeakReference;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/widget/prompt/AutoDismissRunner;", "Ljava/lang/Runnable;", "toast", "Lcom/tencent/mm/plugin/appbrand/widget/prompt/AppBrandPopupToast;", "(Lcom/tencent/mm/plugin/appbrand/widget/prompt/AppBrandPopupToast;)V", "ref", "Ljava/lang/ref/WeakReference;", "run", "", "plugin-appbrand-integration_release"})
final class d
  implements Runnable
{
  private final WeakReference<c> mix;
  
  public d(c paramc)
  {
    AppMethodBeat.i(51452);
    this.mix = new WeakReference(paramc);
    AppMethodBeat.o(51452);
  }
  
  public final void run()
  {
    AppMethodBeat.i(51451);
    c localc = (c)this.mix.get();
    if (localc != null)
    {
      localc.dismiss();
      AppMethodBeat.o(51451);
      return;
    }
    AppMethodBeat.o(51451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.d
 * JD-Core Version:    0.7.0.1
 */