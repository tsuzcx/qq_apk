package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/panel/GroupExpandItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "expand", "", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;Z)V", "getExpand", "()Z", "getGroupInfo", "()Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "contentEquals", "other", "", "equals", "plugin-emojisdk_release"})
public final class t
  extends ac
{
  private final EmojiGroupInfo gVA;
  public final boolean gYL;
  
  public final boolean aZ(Object paramObject)
  {
    AppMethodBeat.i(105560);
    if ((super.aZ(paramObject)) && ((paramObject instanceof t)) && (p.j(((t)paramObject).gVA.hRu(), this.gVA.hRu())) && (((t)paramObject).gYL == this.gYL))
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
    if ((super.equals(paramObject)) && ((paramObject instanceof t)) && (p.j(((t)paramObject).gVA.hRu(), this.gVA.hRu())))
    {
      AppMethodBeat.o(105559);
      return true;
    }
    AppMethodBeat.o(105559);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.t
 * JD-Core Version:    0.7.0.1
 */