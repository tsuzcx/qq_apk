package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.plugin.emoji.a.e;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;

final class EmojiSortUI$4
  implements DragSortListView.h
{
  EmojiSortUI$4(EmojiSortUI paramEmojiSortUI) {}
  
  public final void cg(int paramInt1, int paramInt2)
  {
    EmojiGroupInfo localEmojiGroupInfo = (EmojiGroupInfo)EmojiSortUI.b(this.jdC).getItem(paramInt1);
    EmojiSortUI.b(this.jdC).remove(localEmojiGroupInfo);
    EmojiSortUI.b(this.jdC).insert(localEmojiGroupInfo, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiSortUI.4
 * JD-Core Version:    0.7.0.1
 */