package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.ti;
import com.tencent.mm.protocal.protobuf.tk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

final class CardHomePageUI$8
  implements View.OnClickListener
{
  CardHomePageUI$8(CardHomePageUI paramCardHomePageUI, tk paramtk) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113417);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    if (this.oOv.Gju == 1) {
      com.tencent.mm.plugin.card.d.b.a(this.oOu, this.oOv.Gjv, 0);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(113417);
      return;
      if (this.oOv.Gju == 2)
      {
        if (this.oOv.Gjw != null)
        {
          paramView = new vq();
          paramView.dKT.userName = this.oOv.Gjw.CRv;
          paramView.dKT.dKV = bu.bI(this.oOv.Gjw.CRw, "");
          paramView.dKT.scene = 1028;
          com.tencent.mm.sdk.b.a.IvT.l(paramView);
        }
      }
      else if (this.oOv.Gju == 3)
      {
        if ("weixin://wccard/sharecarddetail".equals(this.oOv.Gjx))
        {
          ae.d("MicroMsg.CardHomePageUI", "go to share card ui");
          localObject = new Intent(this.oOu, ShareCardListUI.class);
          ((Intent)localObject).putExtra("key_layout_buff", CardHomePageUI.e(this.oOu));
          CardHomePageUI.f(this.oOu);
          paramView = this.oOu;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          g.yxI.f(11324, new Object[] { "ClickShareCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
        }
      }
      else {
        ae.w("MicroMsg.CardHomePageUI", "unknown op action: %s", new Object[] { Integer.valueOf(this.oOv.Gju) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardHomePageUI.8
 * JD-Core Version:    0.7.0.1
 */