package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/panel/StorePanelGroupModel;", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "Lcom/tencent/mm/emoji/model/panel/StoreItemGroup;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "data", "getData", "()Lcom/tencent/mm/emoji/model/panel/StoreItemGroup;", "setData", "(Lcom/tencent/mm/emoji/model/panel/StoreItemGroup;)V", "createData", "plugin-emojisdk_release"})
public final class am
  extends ab<al>
{
  private final EmojiGroupInfo gVA;
  private al gZl;
  
  public am(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(105591);
    this.gVA = paramEmojiGroupInfo;
    this.gZl = new al(this.gVA, true);
    AppMethodBeat.o(105591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.am
 * JD-Core Version:    0.7.0.1
 */