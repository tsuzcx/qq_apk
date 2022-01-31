package com.tencent.mm.plugin.emoji.ui;

import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.plugin.emoji.f.e;

final class EmojiStoreDetailUI$c
{
  SquareImageView jeM;
  
  public EmojiStoreDetailUI$c(EmojiStoreDetailUI paramEmojiStoreDetailUI, View paramView)
  {
    this.jeM = ((SquareImageView)paramView.findViewById(f.e.detail_image));
    this.jeM.setScaleType(ImageView.ScaleType.FIT_CENTER);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.c
 * JD-Core Version:    0.7.0.1
 */