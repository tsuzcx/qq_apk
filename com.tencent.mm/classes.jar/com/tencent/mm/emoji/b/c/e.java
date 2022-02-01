package com.tencent.mm.emoji.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestLocal;", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest;", "()V", "TAG", "", "checkMatch", "", "desc", "getEmojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "md5List", "searchSuggest", "", "callback", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "plugin-emojisdk_release"})
public final class e
  implements j
{
  private final String TAG = "MicroMsg.EmojiSuggestLocal";
  
  public static boolean ET(String paramString)
  {
    AppMethodBeat.i(199941);
    p.h(paramString, "desc");
    boolean bool = bf.gCF().EV(paramString);
    AppMethodBeat.o(199941);
    return bool;
  }
  
  public final void a(String paramString, j.b paramb)
  {
    AppMethodBeat.i(199942);
    p.h(paramString, "desc");
    Object localObject1 = g.ah(PluginEmoji.class);
    p.g(localObject1, "MMKernel.plugin(PluginEmoji::class.java)");
    localObject1 = kotlin.a.j.t((Iterable)((PluginEmoji)localObject1).getEmojiMgr().amr(paramString));
    paramString = new LinkedList();
    Object localObject2 = (Collection)localObject1;
    int i;
    if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {
      i = 1;
    }
    while (i == 0)
    {
      if (((List)localObject1).size() > 100)
      {
        localObject2 = d.gZA;
        d.pl(24);
      }
      int j = ((List)localObject1).size();
      i = 0;
      for (;;)
      {
        if ((i < j) && (i < 100))
        {
          localObject2 = g.ah(PluginEmoji.class);
          p.g(localObject2, "MMKernel.plugin(PluginEmoji::class.java)");
          localObject2 = ((PluginEmoji)localObject2).getEmojiMgr().aml((String)((List)localObject1).get(i));
          if (localObject2 != null) {
            paramString.add(localObject2);
          }
          i += 1;
          continue;
          i = 0;
          break;
        }
      }
      if (!paramString.isEmpty()) {
        break label302;
      }
      Log.i(this.TAG, "sorEmojiList return. empty list.");
    }
    for (;;)
    {
      localObject1 = (Iterable)paramString;
      paramString = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          kotlin.a.j.hxH();
        }
        paramString.add(new l((EmojiInfo)localObject2, 0, i + 1));
        i += 1;
      }
      label302:
      localObject1 = ((Iterable)paramString).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (EmojiInfo)((Iterator)localObject1).next();
        Log.i(this.TAG, "getEmojiList: match " + ((EmojiInfo)localObject2).getMd5());
      }
    }
    paramb.a((List)paramString, new m(0L, 0, 0, null, 15));
    AppMethodBeat.o(199942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c.e
 * JD-Core Version:    0.7.0.1
 */