package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import com.tencent.mm.ai.z;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.r;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class BizTimeLineUI$6
  implements Runnable
{
  BizTimeLineUI$6(BizTimeLineUI paramBizTimeLineUI, long paramLong) {}
  
  public final void run()
  {
    if (z.ME().hy(this.igL) <= 0) {
      this.ihl.FP(0);
    }
    do
    {
      return;
      float f1 = BizTimeLineUI.m(this.ihl).getX();
      int i = (int)((BizTimeLineUI.m(this.ihl).getWidth() + (f1 + f1)) / 2.0F);
      int j = a.fj(this.ihl.mController.uMN) / 2;
      if (i != j)
      {
        float f2 = j - i + f1;
        BizTimeLineUI.m(this.ihl).setX(f2);
        y.d("MicroMsg.BizTimeLineUI", "updateActionBarCustomView x = %f, new x=%f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
      }
    } while (BizTimeLineUI.m(this.ihl).getVisibility() == 0);
    BizTimeLineUI.m(this.ihl).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.6
 * JD-Core Version:    0.7.0.1
 */