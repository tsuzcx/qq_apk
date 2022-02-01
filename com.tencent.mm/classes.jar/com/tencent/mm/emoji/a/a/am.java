package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/panel/StorePanelGroupModel;", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "Lcom/tencent/mm/emoji/model/panel/StoreItemGroup;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "data", "getData", "()Lcom/tencent/mm/emoji/model/panel/StoreItemGroup;", "setData", "(Lcom/tencent/mm/emoji/model/panel/StoreItemGroup;)V", "createData", "plugin-emojisdk_release"})
public final class am
  extends ab<al>
{
  private final EmojiGroupInfo gin;
  private al glW;
  
  public am(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(105591);
    this.gin = paramEmojiGroupInfo;
    this.glW = afG();
    AppMethodBeat.o(105591);
  }
  
  private al afG()
  {
    AppMethodBeat.i(105589);
    al localal = new al(this.gin);
    AppMethodBeat.o(105589);
    return localal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.am
 * JD-Core Version:    0.7.0.1
 */