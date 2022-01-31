package com.tencent.mm.plugin.card.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.a.a;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

final class CardGiftReceiveUI$4
  implements a.a
{
  CardGiftReceiveUI$4(CardGiftReceiveUI paramCardGiftReceiveUI) {}
  
  public final void Ig(String paramString)
  {
    AppMethodBeat.i(88421);
    ab.e("MicroMsg.CardGiftReceiveUI", "CDN download pic failure! fieldId:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(88421);
  }
  
  public final void bO(String paramString, int paramInt)
  {
    AppMethodBeat.i(88420);
    if (CardGiftReceiveUI.b(this.kvA) == null)
    {
      ab.e("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress cardGiftInfo is null return!");
      AppMethodBeat.o(88420);
      return;
    }
    if ((!bo.isNullOrNil(paramString)) && (!bo.isNullOrNil(CardGiftReceiveUI.b(this.kvA).kmE)) && (paramString.equals(CardGiftReceiveUI.b(this.kvA).kmE)))
    {
      ab.i("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress fromUserContentVideoUrl return!");
      AppMethodBeat.o(88420);
      return;
    }
    CardGiftReceiveUI.g(this.kvA).post(new CardGiftReceiveUI.4.1(this));
    AppMethodBeat.o(88420);
  }
  
  public final void du(String paramString1, String paramString2)
  {
    AppMethodBeat.i(88422);
    ab.i("MicroMsg.CardGiftReceiveUI", "CDN  download success! fieldId:".concat(String.valueOf(paramString1)));
    if (CardGiftReceiveUI.b(this.kvA) == null)
    {
      ab.e("MicroMsg.CardGiftReceiveUI", "CDN  download cardGiftInfo is null return!");
      AppMethodBeat.o(88422);
      return;
    }
    if ((!bo.isNullOrNil(paramString1)) && (!bo.isNullOrNil(CardGiftReceiveUI.b(this.kvA).kmE)) && (paramString1.equals(CardGiftReceiveUI.b(this.kvA).kmE)))
    {
      ab.i("MicroMsg.CardGiftReceiveUI", "CDN  download fromUserContentVideoUrl! return");
      AppMethodBeat.o(88422);
      return;
    }
    CardGiftReceiveUI.g(this.kvA).post(new CardGiftReceiveUI.4.2(this, paramString1, paramString2));
    AppMethodBeat.o(88422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftReceiveUI.4
 * JD-Core Version:    0.7.0.1
 */