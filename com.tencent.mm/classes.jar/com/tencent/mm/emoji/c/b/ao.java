package com.tencent.mm.emoji.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/panel/StorePanelGroupModel;", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "Lcom/tencent/mm/emoji/model/panel/StoreItemGroup;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "data", "getData", "()Lcom/tencent/mm/emoji/model/panel/StoreItemGroup;", "setData", "(Lcom/tencent/mm/emoji/model/panel/StoreItemGroup;)V", "getGroupInfo", "()Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "setGroupInfo", "createData", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ao
  extends ad<an>
{
  EmojiGroupInfo mgd;
  private an mjC;
  
  public ao(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(105591);
    this.mgd = paramEmojiGroupInfo;
    this.mjC = new an(this.mgd, true);
    AppMethodBeat.o(105591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b.ao
 * JD-Core Version:    0.7.0.1
 */