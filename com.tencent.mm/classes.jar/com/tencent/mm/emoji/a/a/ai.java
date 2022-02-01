package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/panel/StorePanelGroupModel;", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "Lcom/tencent/mm/emoji/model/panel/StoreItemGroup;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "data", "getData", "()Lcom/tencent/mm/emoji/model/panel/StoreItemGroup;", "setData", "(Lcom/tencent/mm/emoji/model/panel/StoreItemGroup;)V", "createData", "plugin-emojisdk_release"})
public final class ai
  extends x<ah>
{
  private final EmojiGroupInfo fON;
  private ah fSs;
  
  public ai(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(105591);
    this.fON = paramEmojiGroupInfo;
    this.fSs = acZ();
    AppMethodBeat.o(105591);
  }
  
  private ah acZ()
  {
    AppMethodBeat.i(105589);
    ah localah = new ah(this.fON);
    AppMethodBeat.o(105589);
    return localah;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.ai
 * JD-Core Version:    0.7.0.1
 */