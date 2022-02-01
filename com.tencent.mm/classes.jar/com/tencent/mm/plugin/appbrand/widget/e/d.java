package com.tencent.mm.plugin.appbrand.widget.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.lang.ref.WeakReference;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/widget/prompt/AutoDismissRunner;", "Ljava/lang/Runnable;", "toast", "Lcom/tencent/mm/plugin/appbrand/widget/prompt/AppBrandPopupToast;", "(Lcom/tencent/mm/plugin/appbrand/widget/prompt/AppBrandPopupToast;)V", "ref", "Ljava/lang/ref/WeakReference;", "run", "", "plugin-appbrand-integration_release"})
final class d
  implements Runnable
{
  private final WeakReference<c> leJ;
  
  public d(c paramc)
  {
    AppMethodBeat.i(51452);
    this.leJ = new WeakReference(paramc);
    AppMethodBeat.o(51452);
  }
  
  public final void run()
  {
    AppMethodBeat.i(51451);
    c localc = (c)this.leJ.get();
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