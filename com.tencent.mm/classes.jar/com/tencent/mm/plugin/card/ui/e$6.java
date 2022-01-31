package com.tencent.mm.plugin.card.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.protocal.c.mg;

final class e$6
  implements q.a
{
  e$6(e parame, int paramInt, String paramString) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      this.isQ.isI = paramString;
      if (this.val$requestCode != 0) {
        break label160;
      }
      if (this.isQ.isM != null) {
        this.isQ.isM.yD(this.dol);
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(11582, new Object[] { "OperGift", Integer.valueOf(1), Integer.valueOf(this.isQ.ikk.azx().ilo), this.isQ.ikk.azC(), this.isQ.ikk.azB(), this.isQ.isH });
      com.tencent.mm.ui.base.h.bC(this.isQ.isl, this.isQ.isl.getResources().getString(a.g.card_has_gift_tips));
    }
    label160:
    do
    {
      return;
      if (this.val$requestCode == 1)
      {
        paramString = this.isQ;
        paramString.ikk.azz().tIn = (paramString.getString(a.g.card_share_to) + paramString.isG.getTitle());
        l.a(paramString.ikk, paramString.isH, paramString.isN.irX, 2);
        l.cC(paramString.isI, paramString.isH);
        com.tencent.mm.ui.base.h.bC(this.isQ.isl, this.isQ.isl.getResources().getString(a.g.card_has_gift_tips));
        return;
      }
    } while (this.val$requestCode != 4);
    paramString = this.isQ;
    if (TextUtils.isEmpty(paramString.ikk.azD())) {
      paramString.ikk.xW(q.Gj());
    }
    paramString.ikk.azz().tIn = (paramString.getString(a.g.card_recommend_to) + paramString.isG.getTitle());
    l.a(paramString.ikk, paramString.isH, paramString.isN.irX, 23);
    l.cC(paramString.isI, paramString.isH);
    com.tencent.mm.plugin.report.service.h.nFQ.f(11582, new Object[] { "OpeRecommendCard", Integer.valueOf(this.isQ.isN.drX), Integer.valueOf(this.isQ.ikk.azx().ilo), this.isQ.ikk.azC(), this.isQ.ikk.azB(), this.isQ.isH });
    com.tencent.mm.ui.base.h.bC(this.isQ.isl, this.isQ.isl.getResources().getString(a.g.card_has_gift_tips));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.e.6
 * JD-Core Version:    0.7.0.1
 */