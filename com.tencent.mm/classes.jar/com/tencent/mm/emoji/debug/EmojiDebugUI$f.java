package com.tencent.mm.emoji.debug;

import a.l;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class EmojiDebugUI$f
  implements MenuItem.OnMenuItemClickListener
{
  EmojiDebugUI$f(EmojiDebugUI paramEmojiDebugUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(63126);
    this.euQ.finish();
    AppMethodBeat.o(63126);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.emoji.debug.EmojiDebugUI.f
 * JD-Core Version:    0.7.0.1
 */