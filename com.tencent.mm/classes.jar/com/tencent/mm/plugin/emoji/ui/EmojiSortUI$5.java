package com.tencent.mm.plugin.emoji.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.a.e;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.l;

final class EmojiSortUI$5
  implements DragSortListView.l
{
  EmojiSortUI$5(EmojiSortUI paramEmojiSortUI) {}
  
  public final void remove(int paramInt)
  {
    AppMethodBeat.i(53412);
    EmojiSortUI.b(this.lmp).remove(EmojiSortUI.b(this.lmp).getItem(paramInt));
    AppMethodBeat.o(53412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiSortUI.5
 * JD-Core Version:    0.7.0.1
 */