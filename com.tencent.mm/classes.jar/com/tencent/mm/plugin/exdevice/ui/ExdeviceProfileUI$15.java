package com.tencent.mm.plugin.exdevice.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;

final class ExdeviceProfileUI$15
  implements Runnable
{
  ExdeviceProfileUI$15(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(179611);
    Object localObject1 = ExdeviceProfileUI.z(this.peX);
    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$22", "run", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    BackwardSupportUtil.c.b((ListView)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$22", "run", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    if (ExdeviceProfileUI.z(this.peX).getCount() > 0) {
      BackwardSupportUtil.c.b(ExdeviceProfileUI.z(this.peX), ExdeviceProfileUI.z(this.peX).getCount() - 1);
    }
    AppMethodBeat.o(179611);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.15
 * JD-Core Version:    0.7.0.1
 */