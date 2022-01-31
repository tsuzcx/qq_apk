package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.so;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.protocal.protobuf.ow;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class CardHomePageUI$8
  implements View.OnClickListener
{
  CardHomePageUI$8(CardHomePageUI paramCardHomePageUI, ow paramow) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(88490);
    if (this.kwg.wFw == 1)
    {
      b.a(this.kwf, this.kwg.wFx, 0);
      AppMethodBeat.o(88490);
      return;
    }
    if (this.kwg.wFw == 2)
    {
      if (this.kwg.wFy != null)
      {
        paramView = new so();
        paramView.cIQ.userName = this.kwg.wFy.ugl;
        paramView.cIQ.cIS = bo.bf(this.kwg.wFy.uaL, "");
        paramView.cIQ.scene = 1028;
        a.ymk.l(paramView);
        AppMethodBeat.o(88490);
      }
    }
    else if (this.kwg.wFw == 3)
    {
      if ("weixin://wccard/sharecarddetail".equals(this.kwg.wFz))
      {
        ab.d("MicroMsg.CardHomePageUI", "go to share card ui");
        paramView = new Intent(this.kwf, ShareCardListUI.class);
        paramView.putExtra("key_layout_buff", CardHomePageUI.e(this.kwf));
        CardHomePageUI.f(this.kwf);
        this.kwf.startActivity(paramView);
        h.qsU.e(11324, new Object[] { "ClickShareCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(88490);
      }
    }
    else {
      ab.w("MicroMsg.CardHomePageUI", "unknown op action: %s", new Object[] { Integer.valueOf(this.kwg.wFw) });
    }
    AppMethodBeat.o(88490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardHomePageUI.8
 * JD-Core Version:    0.7.0.1
 */