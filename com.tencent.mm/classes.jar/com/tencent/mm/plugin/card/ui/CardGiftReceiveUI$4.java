package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.plugin.card.d.a.a;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class CardGiftReceiveUI$4
  implements a.a
{
  CardGiftReceiveUI$4(CardGiftReceiveUI paramCardGiftReceiveUI) {}
  
  public final void bm(String paramString, int paramInt)
  {
    if (CardGiftReceiveUI.b(this.iuv) == null)
    {
      y.e("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress cardGiftInfo is null return!");
      return;
    }
    if ((!bk.bl(paramString)) && (!bk.bl(CardGiftReceiveUI.b(this.iuv).ilH)) && (paramString.equals(CardGiftReceiveUI.b(this.iuv).ilH)))
    {
      y.i("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress fromUserContentVideoUrl return!");
      return;
    }
    CardGiftReceiveUI.g(this.iuv).post(new CardGiftReceiveUI.4.1(this));
  }
  
  public final void cx(String paramString1, String paramString2)
  {
    y.i("MicroMsg.CardGiftReceiveUI", "CDN  download success! fieldId:" + paramString1);
    if (CardGiftReceiveUI.b(this.iuv) == null)
    {
      y.e("MicroMsg.CardGiftReceiveUI", "CDN  download cardGiftInfo is null return!");
      return;
    }
    if ((!bk.bl(paramString1)) && (!bk.bl(CardGiftReceiveUI.b(this.iuv).ilH)) && (paramString1.equals(CardGiftReceiveUI.b(this.iuv).ilH)))
    {
      y.i("MicroMsg.CardGiftReceiveUI", "CDN  download fromUserContentVideoUrl! return");
      return;
    }
    CardGiftReceiveUI.g(this.iuv).post(new CardGiftReceiveUI.4.2(this, paramString1, paramString2));
  }
  
  public final void fail(String paramString)
  {
    y.e("MicroMsg.CardGiftReceiveUI", "CDN download pic failure! fieldId:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftReceiveUI.4
 * JD-Core Version:    0.7.0.1
 */