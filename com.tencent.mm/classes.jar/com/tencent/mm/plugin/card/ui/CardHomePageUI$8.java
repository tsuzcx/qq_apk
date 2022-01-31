package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.lx;
import com.tencent.mm.protocal.c.lz;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class CardHomePageUI$8
  implements View.OnClickListener
{
  CardHomePageUI$8(CardHomePageUI paramCardHomePageUI, lz paramlz) {}
  
  public final void onClick(View paramView)
  {
    if (this.ivc.sHT == 1) {
      b.a(this.ivb, this.ivc.sHU, 0);
    }
    do
    {
      do
      {
        return;
        if (this.ivc.sHT != 2) {
          break;
        }
      } while (this.ivc.sHV == null);
      paramView = new rc();
      paramView.caq.userName = this.ivc.sHV.qhq;
      paramView.caq.cas = bk.aM(this.ivc.sHV.qhr, "");
      paramView.caq.scene = 1028;
      a.udP.m(paramView);
      return;
      if (this.ivc.sHT != 3) {
        break;
      }
    } while (!"weixin://wccard/sharecarddetail".equals(this.ivc.sHW));
    y.d("MicroMsg.CardHomePageUI", "go to share card ui");
    paramView = new Intent(this.ivb, ShareCardListUI.class);
    paramView.putExtra("key_layout_buff", CardHomePageUI.e(this.ivb));
    CardHomePageUI.f(this.ivb);
    this.ivb.startActivity(paramView);
    h.nFQ.f(11324, new Object[] { "ClickShareCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
    return;
    y.w("MicroMsg.CardHomePageUI", "unknown op action: %s", new Object[] { Integer.valueOf(this.ivc.sHT) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardHomePageUI.8
 * JD-Core Version:    0.7.0.1
 */