package com.tencent.mm.emoji.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/panel/CustomPanelGroupModel;", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "Lcom/tencent/mm/emoji/model/panel/CustomItemGroup;", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;)V", "getConfig", "()Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "data", "getData", "()Lcom/tencent/mm/emoji/model/panel/CustomItemGroup;", "setData", "(Lcom/tencent/mm/emoji/model/panel/CustomItemGroup;)V", "createData", "plugin-emojisdk_release"})
public final class f
  extends ab<e>
{
  private final i gni;
  private e gnj;
  
  public f(i parami)
  {
    AppMethodBeat.i(105535);
    this.gni = parami;
    this.gnj = afE();
    AppMethodBeat.o(105535);
  }
  
  private e afE()
  {
    AppMethodBeat.i(105533);
    e locale = new e(this.gni.gnp, this.gni.gno);
    AppMethodBeat.o(105533);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.f
 * JD-Core Version:    0.7.0.1
 */