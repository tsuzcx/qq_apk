package com.tencent.mm.emoji.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/panel/StorePanelGroupModel;", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "Lcom/tencent/mm/emoji/model/panel/StoreItemGroup;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "data", "getData", "()Lcom/tencent/mm/emoji/model/panel/StoreItemGroup;", "setData", "(Lcom/tencent/mm/emoji/model/panel/StoreItemGroup;)V", "createData", "plugin-emojisdk_release"})
public final class am
  extends ab<al>
{
  private final EmojiGroupInfo gkF;
  private al gos;
  
  public am(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(105591);
    this.gkF = paramEmojiGroupInfo;
    this.gos = afU();
    AppMethodBeat.o(105591);
  }
  
  private al afU()
  {
    AppMethodBeat.i(105589);
    al localal = new al(this.gkF);
    AppMethodBeat.o(105589);
    return localal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.am
 * JD-Core Version:    0.7.0.1
 */