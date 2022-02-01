package com.tencent.mm.plugin.emoji.ui.fts;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class FTSEmojiDetailPageUI$8
  implements View.OnClickListener
{
  FTSEmojiDetailPageUI$8(FTSEmojiDetailPageUI paramFTSEmojiDetailPageUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(109105);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/emoji/ui/fts/FTSEmojiDetailPageUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    FTSEmojiDetailPageUI.c(this.xVq);
    a.a(this, "com/tencent/mm/plugin/emoji/ui/fts/FTSEmojiDetailPageUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(109105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.8
 * JD-Core Version:    0.7.0.1
 */