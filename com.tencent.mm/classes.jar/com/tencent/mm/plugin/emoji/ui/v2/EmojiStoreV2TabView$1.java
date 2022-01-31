package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.View;
import android.view.View.OnClickListener;

final class EmojiStoreV2TabView$1
  implements View.OnClickListener
{
  EmojiStoreV2TabView$1(EmojiStoreV2TabView paramEmojiStoreV2TabView) {}
  
  public final void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if (EmojiStoreV2TabView.a(this.jjd) != null) {
      EmojiStoreV2TabView.a(this.jjd).qc(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView.1
 * JD-Core Version:    0.7.0.1
 */