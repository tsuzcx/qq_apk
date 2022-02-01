package com.tencent.mm.emoji.debug;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class EmojiDebugUI$l
  implements MenuItem.OnMenuItemClickListener
{
  EmojiDebugUI$l(EmojiDebugUI paramEmojiDebugUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(105346);
    this.jEE.finish();
    AppMethodBeat.o(105346);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.emoji.debug.EmojiDebugUI.l
 * JD-Core Version:    0.7.0.1
 */