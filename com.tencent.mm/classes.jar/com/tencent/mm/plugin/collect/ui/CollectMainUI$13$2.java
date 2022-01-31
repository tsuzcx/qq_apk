package com.tencent.mm.plugin.collect.ui;

import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.awl;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

final class CollectMainUI$13$2
  implements n.d
{
  CollectMainUI$13$2(CollectMainUI.13 param13) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      paramInt = paramMenuItem.getItemId() - 1 - 1;
      if (paramInt < 0) {
        y.w("MicroMsg.CollectMainUI", "illegal pos: %s", new Object[] { Integer.valueOf(paramInt) });
      }
      break;
    }
    do
    {
      do
      {
        return;
        com.tencent.mm.plugin.collect.a.a.aEp();
        if (com.tencent.mm.plugin.collect.a.a.aEr())
        {
          CollectMainUI.v(this.iLU.iLP);
          Toast.makeText(this.iLU.iLP.mController.uMN, a.i.collect_main_close_ring_tone_tips, 1).show();
          h.nFQ.f(13944, new Object[] { Integer.valueOf(8) });
          return;
        }
        CollectMainUI.w(this.iLU.iLP);
        Toast.makeText(this.iLU.iLP.mController.uMN, a.i.collect_main_open_ring_tone_tips, 1).show();
        h.nFQ.f(13944, new Object[] { Integer.valueOf(7) });
        return;
        paramMenuItem = (awl)this.iLU.fng.get(paramInt);
        if (paramMenuItem.type == 1)
        {
          y.w("MicroMsg.CollectMainUI", "wrong native type: %s", new Object[] { paramMenuItem.url });
          h.nFQ.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(1), paramMenuItem.bQZ, "", "", "", Integer.valueOf(2) });
          return;
        }
        if (paramMenuItem.type != 2) {
          break;
        }
      } while (bk.bl(paramMenuItem.url));
      e.l(this.iLU.iLP.mController.uMN, paramMenuItem.url, false);
      h.nFQ.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(2), paramMenuItem.bQZ, "", "", paramMenuItem.url, Integer.valueOf(2) });
      return;
    } while (paramMenuItem.type != 3);
    rc localrc = new rc();
    localrc.caq.userName = paramMenuItem.ttb;
    localrc.caq.cas = bk.aM(paramMenuItem.ttc, "");
    localrc.caq.scene = 1072;
    localrc.caq.cat = 0;
    com.tencent.mm.sdk.b.a.udP.m(localrc);
    h.nFQ.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(3), paramMenuItem.bQZ, paramMenuItem.ttb, paramMenuItem.ttc, "", Integer.valueOf(2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.13.2
 * JD-Core Version:    0.7.0.1
 */