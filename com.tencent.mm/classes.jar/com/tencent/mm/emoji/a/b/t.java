package com.tencent.mm.emoji.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/panel/GroupExpandItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "expand", "", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;Z)V", "getExpand", "()Z", "getGroupInfo", "()Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "contentEquals", "other", "", "equals", "plugin-emojisdk_release"})
public final class t
  extends ac
{
  private final EmojiGroupInfo gkF;
  public final boolean gnQ;
  
  public final boolean aS(Object paramObject)
  {
    AppMethodBeat.i(105560);
    if ((super.aS(paramObject)) && ((paramObject instanceof t)) && (p.i(((t)paramObject).gkF.fxk(), this.gkF.fxk())) && (((t)paramObject).gnQ == this.gnQ))
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
    if ((super.equals(paramObject)) && ((paramObject instanceof t)) && (p.i(((t)paramObject).gkF.fxk(), this.gkF.fxk())))
    {
      AppMethodBeat.o(105559);
      return true;
    }
    AppMethodBeat.o(105559);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.t
 * JD-Core Version:    0.7.0.1
 */