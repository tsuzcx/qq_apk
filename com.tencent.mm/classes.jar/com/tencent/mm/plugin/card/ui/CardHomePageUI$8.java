package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.un;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class CardHomePageUI$8
  implements View.OnClickListener
{
  CardHomePageUI$8(CardHomePageUI paramCardHomePageUI, up paramup) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113417);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    if (this.qcj.LdZ == 1) {
      com.tencent.mm.plugin.card.d.b.a(this.qci, this.qcj.Lea, 0);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(113417);
      return;
      if (this.qcj.LdZ == 2)
      {
        if (this.qcj.Leb != null)
        {
          paramView = new wq();
          paramView.ecI.userName = this.qcj.Leb.Hwr;
          paramView.ecI.ecK = Util.nullAs(this.qcj.Leb.Hws, "");
          paramView.ecI.scene = 1028;
          EventCenter.instance.publish(paramView);
        }
      }
      else if (this.qcj.LdZ == 3)
      {
        if ("weixin://wccard/sharecarddetail".equals(this.qcj.Lec))
        {
          Log.d("MicroMsg.CardHomePageUI", "go to share card ui");
          localObject = new Intent(this.qci, ShareCardListUI.class);
          ((Intent)localObject).putExtra("key_layout_buff", CardHomePageUI.e(this.qci));
          CardHomePageUI.f(this.qci);
          paramView = this.qci;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          h.CyF.a(11324, new Object[] { "ClickShareCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
        }
      }
      else {
        Log.w("MicroMsg.CardHomePageUI", "unknown op action: %s", new Object[] { Integer.valueOf(this.qcj.LdZ) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardHomePageUI.8
 * JD-Core Version:    0.7.0.1
 */