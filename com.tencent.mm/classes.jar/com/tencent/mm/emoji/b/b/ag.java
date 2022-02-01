package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/panel/PanelTab;", "", "type", "", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "groupIndex", "(ILcom/tencent/mm/storage/emotion/EmojiGroupInfo;I)V", "getGroupIndex", "()I", "getGroupInfo", "()Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "getType", "Companion", "plugin-emojisdk_release"})
public final class ag
{
  public static final ag.a gZe;
  public final int bEC;
  public final EmojiGroupInfo gVA;
  public final int type;
  
  static
  {
    AppMethodBeat.i(105580);
    gZe = new ag.a((byte)0);
    AppMethodBeat.o(105580);
  }
  
  public ag(int paramInt1, EmojiGroupInfo paramEmojiGroupInfo, int paramInt2)
  {
    AppMethodBeat.i(105579);
    this.type = paramInt1;
    this.gVA = paramEmojiGroupInfo;
    this.bEC = paramInt2;
    AppMethodBeat.o(105579);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.ag
 * JD-Core Version:    0.7.0.1
 */