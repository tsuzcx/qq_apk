package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/panel/PanelTab;", "", "type", "", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "groupIndex", "(ILcom/tencent/mm/storage/emotion/EmojiGroupInfo;I)V", "getGroupIndex", "()I", "getGroupInfo", "()Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "getType", "Companion", "plugin-emojisdk_release"})
public final class ag
{
  public static final ag.a glP;
  public final int bEA;
  public final EmojiGroupInfo gin;
  public final int type;
  
  static
  {
    AppMethodBeat.i(105580);
    glP = new ag.a((byte)0);
    AppMethodBeat.o(105580);
  }
  
  public ag(int paramInt1, EmojiGroupInfo paramEmojiGroupInfo, int paramInt2)
  {
    AppMethodBeat.i(105579);
    this.type = paramInt1;
    this.gin = paramEmojiGroupInfo;
    this.bEA = paramInt2;
    AppMethodBeat.o(105579);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.ag
 * JD-Core Version:    0.7.0.1
 */