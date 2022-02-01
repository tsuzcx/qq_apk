package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/model/EmojiCustomGroupModel;", "Lcom/tencent/mm/plugin/emoji/model/AbsEmojiCustomGroupModel;", "Lcom/tencent/mm/plugin/emoji/model/EmojiCustomItemGroup;", "entrance", "", "(Z)V", "data", "getData", "()Lcom/tencent/mm/plugin/emoji/model/EmojiCustomItemGroup;", "setData", "(Lcom/tencent/mm/plugin/emoji/model/EmojiCustomItemGroup;)V", "getEntrance", "()Z", "setEntrance", "createData", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends a<h>
{
  private boolean xMm;
  private h xMy;
  
  public g()
  {
    AppMethodBeat.i(269856);
    this.xMm = true;
    this.xMy = dzL();
    AppMethodBeat.o(269856);
  }
  
  private h dzL()
  {
    AppMethodBeat.i(269860);
    h localh = new h(this.xMm);
    AppMethodBeat.o(269860);
    return localh;
  }
  
  public final void dzJ()
  {
    this.xMm = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.g
 * JD-Core Version:    0.7.0.1
 */