package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/panel/GroupExpandItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "expand", "", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;Z)V", "getExpand", "()Z", "getGroupInfo", "()Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "contentEquals", "other", "", "equals", "plugin-emojisdk_release"})
public final class p
  extends y
{
  private final EmojiGroupInfo fLb;
  public final boolean fOg;
  
  public final boolean aT(Object paramObject)
  {
    AppMethodBeat.i(105560);
    if ((super.aT(paramObject)) && ((paramObject instanceof p)) && (k.g(((p)paramObject).fLb.fZJ(), this.fLb.fZJ())) && (((p)paramObject).fOg == this.fOg))
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
    if ((super.equals(paramObject)) && ((paramObject instanceof p)) && (k.g(((p)paramObject).fLb.fZJ(), this.fLb.fZJ())))
    {
      AppMethodBeat.o(105559);
      return true;
    }
    AppMethodBeat.o(105559);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.p
 * JD-Core Version:    0.7.0.1
 */