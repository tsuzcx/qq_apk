package com.tencent.mm.plugin.emoji.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class EmojiCustomUI$14
  implements View.OnClickListener
{
  EmojiCustomUI$14(EmojiCustomUI paramEmojiCustomUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(108871);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/emoji/ui/EmojiCustomUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    EmojiCustomUI.d(this.xRY);
    a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiCustomUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(108871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.14
 * JD-Core Version:    0.7.0.1
 */