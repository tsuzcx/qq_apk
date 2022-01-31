package com.tencent.mm.plugin.appbrand.widget.f;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/widget/prompt/AutoDismissRunner;", "Ljava/lang/Runnable;", "toast", "Lcom/tencent/mm/plugin/appbrand/widget/prompt/AppBrandPopupToast;", "(Lcom/tencent/mm/plugin/appbrand/widget/prompt/AppBrandPopupToast;)V", "ref", "Ljava/lang/ref/WeakReference;", "run", "", "plugin-appbrand-integration_release"})
final class d
  implements Runnable
{
  private final WeakReference<c> iyQ;
  
  public d(c paramc)
  {
    AppMethodBeat.i(135267);
    this.iyQ = new WeakReference(paramc);
    AppMethodBeat.o(135267);
  }
  
  public final void run()
  {
    AppMethodBeat.i(135266);
    c localc = (c)this.iyQ.get();
    if (localc != null)
    {
      localc.dismiss();
      AppMethodBeat.o(135266);
      return;
    }
    AppMethodBeat.o(135266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.f.d
 * JD-Core Version:    0.7.0.1
 */