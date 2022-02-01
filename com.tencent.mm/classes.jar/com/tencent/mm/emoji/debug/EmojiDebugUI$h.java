package com.tencent.mm.emoji.debug;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$GroupItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "onClick", "", "textSize", "", "value", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmojiDebugUI$h
  extends EmojiDebugUI.a
{
  private final String title;
  
  public EmojiDebugUI$h(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(242244);
    this.title = localObject;
    AppMethodBeat.o(242244);
  }
  
  public final String aUa()
  {
    return this.title;
  }
  
  public final float aUb()
  {
    return 30.0F;
  }
  
  public final void onClick() {}
  
  public final String value()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.debug.EmojiDebugUI.h
 * JD-Core Version:    0.7.0.1
 */