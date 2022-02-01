package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.wg;
import com.tencent.mm.protocal.protobuf.wi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class CardHomePageUI$8
  implements View.OnClickListener
{
  CardHomePageUI$8(CardHomePageUI paramCardHomePageUI, wi paramwi) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113417);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    if (this.wCE.Zdh == 1) {
      com.tencent.mm.plugin.card.c.b.a(this.wCD, this.wCE.Zdi, 0);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(113417);
      return;
      if (this.wCE.Zdh == 2)
      {
        if (this.wCE.Zdj != null)
        {
          paramView = new zp();
          paramView.icM.userName = this.wCE.Zdj.VcU;
          paramView.icM.icO = Util.nullAs(this.wCE.Zdj.VcV, "");
          paramView.icM.scene = 1028;
          paramView.publish();
        }
      }
      else if (this.wCE.Zdh == 3)
      {
        if ("weixin://wccard/sharecarddetail".equals(this.wCE.Zdk))
        {
          Log.d("MicroMsg.CardHomePageUI", "go to share card ui");
          localObject = new Intent(this.wCD, ShareCardListUI.class);
          ((Intent)localObject).putExtra("key_layout_buff", CardHomePageUI.e(this.wCD));
          CardHomePageUI.f(this.wCD);
          paramView = this.wCD;
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          h.OAn.b(11324, new Object[] { "ClickShareCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
        }
      }
      else {
        Log.w("MicroMsg.CardHomePageUI", "unknown op action: %s", new Object[] { Integer.valueOf(this.wCE.Zdh) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardHomePageUI.8
 * JD-Core Version:    0.7.0.1
 */