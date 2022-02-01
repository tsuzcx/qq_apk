package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/panel/CustomPanelGroupModel;", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "Lcom/tencent/mm/emoji/model/panel/CustomItemGroup;", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;)V", "getConfig", "()Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "data", "getData", "()Lcom/tencent/mm/emoji/model/panel/CustomItemGroup;", "setData", "(Lcom/tencent/mm/emoji/model/panel/CustomItemGroup;)V", "createData", "plugin-emojisdk_release"})
public final class f
  extends x<e>
{
  private final i fRn;
  private e fRo;
  
  public f(i parami)
  {
    AppMethodBeat.i(105535);
    this.fRn = parami;
    this.fRo = acM();
    AppMethodBeat.o(105535);
  }
  
  private e acM()
  {
    AppMethodBeat.i(105533);
    e locale = new e(this.fRn.fRu, this.fRn.fRt);
    AppMethodBeat.o(105533);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.f
 * JD-Core Version:    0.7.0.1
 */