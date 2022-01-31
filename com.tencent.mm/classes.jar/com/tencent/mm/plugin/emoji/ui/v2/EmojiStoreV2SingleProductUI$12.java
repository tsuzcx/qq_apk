package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.a;

final class EmojiStoreV2SingleProductUI$12
  implements MMTagPanel.a
{
  EmojiStoreV2SingleProductUI$12(EmojiStoreV2SingleProductUI paramEmojiStoreV2SingleProductUI) {}
  
  public final void Le(String paramString)
  {
    AppMethodBeat.i(53757);
    if ((!bo.isNullOrNil(EmojiStoreV2SingleProductUI.l(this.lrz))) && (!bo.isNullOrNil(paramString)) && (paramString.equals(EmojiStoreV2SingleProductUI.l(this.lrz)))) {
      EmojiStoreV2SingleProductUI.m(this.lrz).ck(EmojiStoreV2SingleProductUI.l(this.lrz), true);
    }
    AppMethodBeat.o(53757);
  }
  
  public final void Lf(String paramString)
  {
    AppMethodBeat.i(53758);
    EmojiStoreV2SingleProductUI.a(this.lrz, paramString);
    AppMethodBeat.o(53758);
  }
  
  public final void Lg(String paramString) {}
  
  public final void Lh(String paramString) {}
  
  public final void Li(String paramString) {}
  
  public final void bnq() {}
  
  public final void t(boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.12
 * JD-Core Version:    0.7.0.1
 */