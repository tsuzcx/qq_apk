package com.tencent.mm.plugin.emoji.ui.fts;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class FTSEmojiDetailPageUI$7
  implements View.OnClickListener
{
  FTSEmojiDetailPageUI$7(FTSEmojiDetailPageUI paramFTSEmojiDetailPageUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(109105);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/emoji/ui/fts/FTSEmojiDetailPageUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    FTSEmojiDetailPageUI.c(this.rjA);
    a.a(this, "com/tencent/mm/plugin/emoji/ui/fts/FTSEmojiDetailPageUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(109105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.7
 * JD-Core Version:    0.7.0.1
 */