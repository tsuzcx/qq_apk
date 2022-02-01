package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emoji/model/EmojiCustomGroupModel;", "Lcom/tencent/mm/plugin/emoji/model/AbsEmojiCustomGroupModel;", "Lcom/tencent/mm/plugin/emoji/model/EmojiCustomItemGroup;", "entrance", "", "(Z)V", "data", "getData", "()Lcom/tencent/mm/plugin/emoji/model/EmojiCustomItemGroup;", "setData", "(Lcom/tencent/mm/plugin/emoji/model/EmojiCustomItemGroup;)V", "getEntrance", "()Z", "setEntrance", "createData", "plugin-emoji_release"})
public final class g
  extends a<h>
{
  private boolean uDV;
  private h uEh;
  
  public g()
  {
    AppMethodBeat.i(256222);
    this.uDV = true;
    this.uEh = cUE();
    AppMethodBeat.o(256222);
  }
  
  private h cUE()
  {
    AppMethodBeat.i(256217);
    h localh = new h(this.uDV);
    AppMethodBeat.o(256217);
    return localh;
  }
  
  public final void cUC()
  {
    this.uDV = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.g
 * JD-Core Version:    0.7.0.1
 */