package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/panel/CustomPanelGroupModel;", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "Lcom/tencent/mm/emoji/model/panel/CustomItemGroup;", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;)V", "getConfig", "()Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "data", "getData", "()Lcom/tencent/mm/emoji/model/panel/CustomItemGroup;", "setData", "(Lcom/tencent/mm/emoji/model/panel/CustomItemGroup;)V", "createData", "plugin-emojisdk_release"})
public final class f
  extends ab<e>
{
  private final i gYa;
  private e gYb;
  
  public f(i parami)
  {
    AppMethodBeat.i(105535);
    this.gYa = parami;
    this.gYb = avs();
    AppMethodBeat.o(105535);
  }
  
  private e avs()
  {
    AppMethodBeat.i(105533);
    e locale = new e(this.gYa.gYj, this.gYa.gYi);
    AppMethodBeat.o(105533);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.f
 * JD-Core Version:    0.7.0.1
 */