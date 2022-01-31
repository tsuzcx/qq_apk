package com.tencent.mm.emoji.debug;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class EmojiDebugUI$d$a
  implements View.OnClickListener
{
  EmojiDebugUI$d$a(EmojiDebugUI.d paramd, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(63121);
    ((EmojiDebugUI.a)EmojiDebugUI.b(this.euW.euQ).get(this.euX)).onClick();
    AppMethodBeat.o(63121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.debug.EmojiDebugUI.d.a
 * JD-Core Version:    0.7.0.1
 */