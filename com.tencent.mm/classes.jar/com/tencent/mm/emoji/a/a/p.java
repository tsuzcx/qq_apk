package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/panel/GroupExpandItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "expand", "", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;Z)V", "getExpand", "()Z", "getGroupInfo", "()Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "contentEquals", "other", "", "equals", "plugin-emojisdk_release"})
public final class p
  extends y
{
  private final EmojiGroupInfo fON;
  public final boolean fRR;
  
  public final boolean aQ(Object paramObject)
  {
    AppMethodBeat.i(105560);
    if ((super.aQ(paramObject)) && ((paramObject instanceof p)) && (k.g(((p)paramObject).fON.fdm(), this.fON.fdm())) && (((p)paramObject).fRR == this.fRR))
    {
      AppMethodBeat.o(105560);
      return true;
    }
    AppMethodBeat.o(105560);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(105559);
    if ((super.equals(paramObject)) && ((paramObject instanceof p)) && (k.g(((p)paramObject).fON.fdm(), this.fON.fdm())))
    {
      AppMethodBeat.o(105559);
      return true;
    }
    AppMethodBeat.o(105559);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.p
 * JD-Core Version:    0.7.0.1
 */