package com.tencent.mm.emoji.debug;

import a.f.a.a;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$ClickItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "value", "onClick", "Lkotlin/Function0;", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "getTitle", "()Ljava/lang/String;", "getValue", "plugin-emojisdk_release"})
public final class EmojiDebugUI$b
  extends EmojiDebugUI.a
{
  private final a<y> euR;
  private final String title;
  private final String value;
  
  public EmojiDebugUI$b(String paramString1, String paramString2, a<y> parama)
  {
    super(paramString1);
    AppMethodBeat.i(63116);
    this.title = paramString2;
    this.value = parama;
    Object localObject;
    this.euR = localObject;
    AppMethodBeat.o(63116);
  }
  
  public final String Ol()
  {
    return this.title;
  }
  
  public final void onClick()
  {
    AppMethodBeat.i(63115);
    a locala = this.euR;
    if (locala != null)
    {
      locala.invoke();
      AppMethodBeat.o(63115);
      return;
    }
    AppMethodBeat.o(63115);
  }
  
  public final String value()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.debug.EmojiDebugUI.b
 * JD-Core Version:    0.7.0.1
 */