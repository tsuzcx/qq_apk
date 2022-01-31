package com.tencent.mm.plugin.emoji.ui;

import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EmojiStoreDetailUI$c
{
  SquareImageView lnC;
  
  public EmojiStoreDetailUI$c(EmojiStoreDetailUI paramEmojiStoreDetailUI, View paramView)
  {
    AppMethodBeat.i(53448);
    this.lnC = ((SquareImageView)paramView.findViewById(2131823645));
    this.lnC.setScaleType(ImageView.ScaleType.FIT_CENTER);
    AppMethodBeat.o(53448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.c
 * JD-Core Version:    0.7.0.1
 */