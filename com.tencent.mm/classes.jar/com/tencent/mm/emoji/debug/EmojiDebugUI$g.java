package com.tencent.mm.emoji.debug;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$GetterItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "Lkotlin/Function0;", "", "value", "onClick", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "getTitle", "getValue", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmojiDebugUI$g
  extends EmojiDebugUI.a
{
  private final a<String> aWJ;
  private final a<ah> meC;
  private final a<String> meH;
  
  public EmojiDebugUI$g(a<String> parama1, a<String> parama2, a<ah> parama)
  {
    super(parama1);
    AppMethodBeat.i(105345);
    this.meH = parama2;
    this.aWJ = parama;
    Object localObject;
    this.meC = localObject;
    AppMethodBeat.o(105345);
  }
  
  public final String aUa()
  {
    AppMethodBeat.i(105342);
    String str = (String)this.meH.invoke();
    AppMethodBeat.o(105342);
    return str;
  }
  
  public final void onClick()
  {
    AppMethodBeat.i(105344);
    a locala = this.meC;
    if (locala != null) {
      locala.invoke();
    }
    AppMethodBeat.o(105344);
  }
  
  public final String value()
  {
    AppMethodBeat.i(105343);
    String str = (String)this.aWJ.invoke();
    AppMethodBeat.o(105343);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.debug.EmojiDebugUI.g
 * JD-Core Version:    0.7.0.1
 */