package com.tencent.mm.plugin.exdevice.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;

final class ExdeviceProfileUI$14
  implements Runnable
{
  ExdeviceProfileUI$14(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(24108);
    Object localObject1 = ExdeviceProfileUI.u(this.yBy);
    localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$21", "run", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$21", "run", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    if (ExdeviceProfileUI.u(this.yBy).getCount() > 0) {
      BackwardSupportUtil.SmoothScrollFactory.scrollTo(ExdeviceProfileUI.u(this.yBy), ExdeviceProfileUI.u(this.yBy).getCount() - 1);
    }
    AppMethodBeat.o(24108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.14
 * JD-Core Version:    0.7.0.1
 */