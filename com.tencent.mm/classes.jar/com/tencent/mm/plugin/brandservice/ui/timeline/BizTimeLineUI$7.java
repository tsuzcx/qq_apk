package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.z;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.r;

final class BizTimeLineUI$7
  implements Runnable
{
  BizTimeLineUI$7(BizTimeLineUI paramBizTimeLineUI, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(14189);
    if (z.afo().od(this.jWD) <= 0)
    {
      this.jXh.setMMTitleVisibility(0);
      AppMethodBeat.o(14189);
      return;
    }
    float f1 = BizTimeLineUI.o(this.jXh).getX();
    int i = (int)((BizTimeLineUI.o(this.jXh).getWidth() + (f1 + f1)) / 2.0F);
    int j = a.gw(this.jXh.getContext()) / 2;
    if (i != j)
    {
      float f2 = j - i + f1;
      BizTimeLineUI.o(this.jXh).setX(f2);
      ab.d("MicroMsg.BizTimeLineUI", "updateActionBarCustomView x = %f, new x=%f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
    }
    if (BizTimeLineUI.o(this.jXh).getVisibility() != 0) {
      BizTimeLineUI.o(this.jXh).setVisibility(0);
    }
    AppMethodBeat.o(14189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.7
 * JD-Core Version:    0.7.0.1
 */