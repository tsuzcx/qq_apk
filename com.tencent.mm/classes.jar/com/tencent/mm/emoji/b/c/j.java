package com.tencent.mm.emoji.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/search/IEmojiSuggest;", "", "checkMatch", "", "desc", "", "searchSuggest", "", "callback", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "Companion", "SuggestCallback", "plugin-emojisdk_release"})
public abstract interface j
{
  public static final a gZM = a.gZN;
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$Companion;", "", "()V", "SuggestTypeLocal", "", "SuggestTypeRemote", "plugin-emojisdk_release"})
  public static final class a
  {
    static
    {
      AppMethodBeat.i(199957);
      gZN = new a();
      AppMethodBeat.o(199957);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "", "onResult", "", "emojiList", "", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "wordInfo", "Lcom/tencent/mm/emoji/model/search/SuggestWordInfo;", "plugin-emojisdk_release"})
  public static abstract interface b
  {
    public abstract void a(List<l> paramList, m paramm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c.j
 * JD-Core Version:    0.7.0.1
 */