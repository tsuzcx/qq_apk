package com.tencent.mm.plugin.emoji.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class EmojiCustomUI$12
  implements View.OnClickListener
{
  EmojiCustomUI$12(EmojiCustomUI paramEmojiCustomUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(108870);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/emoji/ui/EmojiCustomUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    EmojiCustomUI.d(this.rga);
    a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiCustomUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(108870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.12
 * JD-Core Version:    0.7.0.1
 */