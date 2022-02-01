package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.protocal.protobuf.ur;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class CardHomePageUI$8
  implements View.OnClickListener
{
  CardHomePageUI$8(CardHomePageUI paramCardHomePageUI, ur paramur) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113417);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    if (this.tyh.Sfm == 1) {
      com.tencent.mm.plugin.card.d.b.a(this.tyg, this.tyh.Sfn, 0);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(113417);
      return;
      if (this.tyh.Sfm == 2)
      {
        if (this.tyh.Sfo != null)
        {
          paramView = new xw();
          paramView.fWN.userName = this.tyh.Sfo.Ooe;
          paramView.fWN.fWP = Util.nullAs(this.tyh.Sfo.Oof, "");
          paramView.fWN.scene = 1028;
          EventCenter.instance.publish(paramView);
        }
      }
      else if (this.tyh.Sfm == 3)
      {
        if ("weixin://wccard/sharecarddetail".equals(this.tyh.Sfp))
        {
          Log.d("MicroMsg.CardHomePageUI", "go to share card ui");
          localObject = new Intent(this.tyg, ShareCardListUI.class);
          ((Intent)localObject).putExtra("key_layout_buff", CardHomePageUI.e(this.tyg));
          CardHomePageUI.f(this.tyg);
          paramView = this.tyg;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          h.IzE.a(11324, new Object[] { "ClickShareCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
        }
      }
      else {
        Log.w("MicroMsg.CardHomePageUI", "unknown op action: %s", new Object[] { Integer.valueOf(this.tyh.Sfm) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardHomePageUI.8
 * JD-Core Version:    0.7.0.1
 */