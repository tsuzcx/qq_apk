package com.tencent.mm.plugin.emoji.a;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;

final class i$a
{
  StoreBannerEmojiView iVF;
  ImageView iVG;
  
  public i$a(i parami, View paramView)
  {
    this.iVF = ((StoreBannerEmojiView)paramView.findViewById(f.e.emoji_bar_view));
    this.iVG = ((ImageView)paramView.findViewById(f.e.new_tips));
    this.iVF.setDefaultImageResource(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.i.a
 * JD-Core Version:    0.7.0.1
 */