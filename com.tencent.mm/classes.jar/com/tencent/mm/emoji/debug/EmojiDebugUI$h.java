package com.tencent.mm.emoji.debug;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$GroupItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "onClick", "", "value", "plugin-emojisdk_release"})
public final class EmojiDebugUI$h
  extends EmojiDebugUI.a
{
  private final String title;
  
  public EmojiDebugUI$h(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(218926);
    this.title = localObject;
    AppMethodBeat.o(218926);
  }
  
  public final String aer()
  {
    return this.title;
  }
  
  public final void onClick() {}
  
  public final String value()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.emoji.debug.EmojiDebugUI.h
 * JD-Core Version:    0.7.0.1
 */