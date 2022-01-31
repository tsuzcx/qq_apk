package com.tencent.mm.plugin.card.ui.view;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;

final class n$2
  implements View.OnClickListener
{
  n$2(n paramn, ra paramra, com.tencent.mm.plugin.card.base.b paramb) {}
  
  public final void onClick(View paramView)
  {
    if ((!bk.bl(this.iyl.sIg)) && (!bk.bl(this.iyl.sIf)))
    {
      int i;
      if (this.iyk.hxN.getIntent() != null)
      {
        i = this.iyk.hxN.getIntent().getIntExtra("key_from_scene", 3);
        if (this.iyk.hxN.getIntent() == null) {
          break label171;
        }
      }
      label171:
      for (int j = this.iyk.hxN.getIntent().getIntExtra("key_from_appbrand_type", 0);; j = 0)
      {
        com.tencent.mm.plugin.card.d.b.a(this.iym.azB(), this.iyl, i, j);
        h.nFQ.f(11941, new Object[] { Integer.valueOf(20), this.iym.azB(), this.iym.azC(), "", this.iyl.title });
        return;
        i = 3;
        break;
      }
    }
    if (!bk.bl(this.iyl.url))
    {
      paramView = l.y(this.iyl.url, this.iyl.sJq);
      com.tencent.mm.plugin.card.d.b.a(this.iyk.hxN, paramView, 1);
      h localh = h.nFQ;
      String str1 = this.iym.azB();
      String str2 = this.iym.azC();
      if (this.iyl.title != null) {}
      for (paramView = this.iyl.title;; paramView = "")
      {
        localh.f(11941, new Object[] { Integer.valueOf(9), str1, str2, "", paramView });
        return;
      }
    }
    d.a(this.iyk.hxN, this.iyk.hxN.getString(a.g.card_wallet_unknown_err), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.n.2
 * JD-Core Version:    0.7.0.1
 */