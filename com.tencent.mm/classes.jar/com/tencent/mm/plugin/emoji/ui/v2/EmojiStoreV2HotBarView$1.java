package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class EmojiStoreV2HotBarView$1
  implements View.OnClickListener
{
  EmojiStoreV2HotBarView$1(EmojiStoreV2HotBarView paramEmojiStoreV2HotBarView) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.setClass(this.jgW.getContext(), EmojiStoreV2RankUI.class);
    this.jgW.getContext().startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2HotBarView.1
 * JD-Core Version:    0.7.0.1
 */