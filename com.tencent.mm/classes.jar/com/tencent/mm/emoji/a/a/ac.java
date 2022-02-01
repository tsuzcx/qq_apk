package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/panel/PanelTab;", "", "type", "", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "groupIndex", "(ILcom/tencent/mm/storage/emotion/EmojiGroupInfo;I)V", "getGroupIndex", "()I", "getGroupInfo", "()Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "getType", "Companion", "plugin-emojisdk_release"})
public final class ac
{
  public static final a fSl;
  public final int bul;
  public final EmojiGroupInfo fON;
  public final int type;
  
  static
  {
    AppMethodBeat.i(105580);
    fSl = new a((byte)0);
    AppMethodBeat.o(105580);
  }
  
  public ac(int paramInt1, EmojiGroupInfo paramEmojiGroupInfo, int paramInt2)
  {
    AppMethodBeat.i(105579);
    this.type = paramInt1;
    this.fON = paramEmojiGroupInfo;
    this.bul = paramInt2;
    AppMethodBeat.o(105579);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/panel/PanelTab$Companion;", "", "()V", "TypeGroup", "", "TypeSetting", "TypeStore", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.ac
 * JD-Core Version:    0.7.0.1
 */