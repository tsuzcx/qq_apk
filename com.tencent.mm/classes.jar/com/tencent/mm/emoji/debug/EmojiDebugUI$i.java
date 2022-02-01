package com.tencent.mm.emoji.debug;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class EmojiDebugUI$i
  implements MenuItem.OnMenuItemClickListener
{
  EmojiDebugUI$i(EmojiDebugUI paramEmojiDebugUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(105346);
    this.ghD.finish();
    AppMethodBeat.o(105346);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.emoji.debug.EmojiDebugUI.i
 * JD-Core Version:    0.7.0.1
 */