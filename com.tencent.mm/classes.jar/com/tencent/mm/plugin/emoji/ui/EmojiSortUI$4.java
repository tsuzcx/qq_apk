package com.tencent.mm.plugin.emoji.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.a.e;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;

final class EmojiSortUI$4
  implements DragSortListView.h
{
  EmojiSortUI$4(EmojiSortUI paramEmojiSortUI) {}
  
  public final void dp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(53411);
    EmojiGroupInfo localEmojiGroupInfo = (EmojiGroupInfo)EmojiSortUI.b(this.lmp).getItem(paramInt1);
    EmojiSortUI.b(this.lmp).remove(localEmojiGroupInfo);
    EmojiSortUI.b(this.lmp).insert(localEmojiGroupInfo, paramInt2);
    AppMethodBeat.o(53411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiSortUI.4
 * JD-Core Version:    0.7.0.1
 */