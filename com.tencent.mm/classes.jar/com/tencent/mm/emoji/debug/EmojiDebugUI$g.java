package com.tencent.mm.emoji.debug;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$GetterItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "Lkotlin/Function0;", "", "value", "onClick", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "getTitle", "getValue", "plugin-emojisdk_release"})
public final class EmojiDebugUI$g
  extends EmojiDebugUI.a
{
  private final a<z> gjX;
  private final a<String> gkf;
  private final a<String> gkg;
  
  public EmojiDebugUI$g(a<String> parama1, a<String> parama2, a<z> parama)
  {
    super(parama1);
    AppMethodBeat.i(105345);
    this.gkf = parama2;
    this.gkg = parama;
    Object localObject;
    this.gjX = localObject;
    AppMethodBeat.o(105345);
  }
  
  public final String aeD()
  {
    AppMethodBeat.i(105342);
    String str = (String)this.gkf.invoke();
    AppMethodBeat.o(105342);
    return str;
  }
  
  public final void onClick()
  {
    AppMethodBeat.i(105344);
    a locala = this.gjX;
    if (locala != null)
    {
      locala.invoke();
      AppMethodBeat.o(105344);
      return;
    }
    AppMethodBeat.o(105344);
  }
  
  public final String value()
  {
    AppMethodBeat.i(105343);
    String str = (String)this.gkg.invoke();
    AppMethodBeat.o(105343);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.emoji.debug.EmojiDebugUI.g
 * JD-Core Version:    0.7.0.1
 */