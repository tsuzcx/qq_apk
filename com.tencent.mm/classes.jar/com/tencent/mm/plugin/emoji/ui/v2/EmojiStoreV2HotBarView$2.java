package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EmojiStoreV2HotBarView$2
  implements View.OnClickListener
{
  EmojiStoreV2HotBarView$2(EmojiStoreV2HotBarView paramEmojiStoreV2HotBarView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(53628);
    paramView = new Intent();
    paramView.setClass(this.lpP.getContext(), EmojiStoreV2SingleProductUI.class);
    this.lpP.getContext().startActivity(paramView);
    AppMethodBeat.o(53628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2HotBarView.2
 * JD-Core Version:    0.7.0.1
 */