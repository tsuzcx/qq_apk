package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.plugin.emoji.a.e;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.l;

final class EmojiSortUI$5
  implements DragSortListView.l
{
  EmojiSortUI$5(EmojiSortUI paramEmojiSortUI) {}
  
  public final void remove(int paramInt)
  {
    EmojiSortUI.b(this.jdC).remove(EmojiSortUI.b(this.jdC).getItem(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiSortUI.5
 * JD-Core Version:    0.7.0.1
 */