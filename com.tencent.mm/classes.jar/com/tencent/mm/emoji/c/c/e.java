package com.tencent.mm.emoji.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.tools.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestLocal;", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest;", "()V", "TAG", "", "checkMatch", "", "desc", "getEmojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "md5List", "searchSuggest", "", "callback", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements j
{
  private final String TAG = "MicroMsg.EmojiSuggestLocal";
  
  public static boolean Er(String paramString)
  {
    AppMethodBeat.i(242673);
    s.u(paramString, "desc");
    bh localbh = bh.jaX();
    if (!localbh.mInit) {
      localbh.jaY();
    }
    if (g.bCx(paramString) > localbh.adiQ) {
      Log.i("MicroMsg.emoji.EmojiDescNewMgr", "input text over checkout limit.");
    }
    while ((Util.isNullOrNil(paramString)) || (localbh.adiU == null))
    {
      AppMethodBeat.o(242673);
      return false;
    }
    paramString = paramString.toLowerCase();
    paramString = (ArrayList)localbh.adiU.get(paramString);
    if ((paramString != null) && (paramString.size() > 0))
    {
      AppMethodBeat.o(242673);
      return true;
    }
    AppMethodBeat.o(242673);
    return false;
  }
  
  public final void a(String paramString, j.b paramb)
  {
    AppMethodBeat.i(242685);
    s.u(paramString, "desc");
    paramString = ((PluginEmoji)h.az(PluginEmoji.class)).getEmojiMgr().aok(paramString);
    Object localObject1;
    Object localObject2;
    int i;
    if (paramString == null)
    {
      paramString = null;
      localObject1 = new LinkedList();
      localObject2 = (Collection)paramString;
      if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
        break label173;
      }
      i = 1;
    }
    label173:
    for (;;)
    {
      label67:
      if (i == 0)
      {
        if (paramString.size() > 100)
        {
          localObject2 = d.mjQ;
          d.rG(24);
        }
        int j = paramString.size();
        i = 0;
        for (;;)
        {
          if ((i < j) && (i < 100))
          {
            localObject2 = ((PluginEmoji)h.az(PluginEmoji.class)).getEmojiMgr().aoe((String)paramString.get(i));
            if (localObject2 != null) {
              ((LinkedList)localObject1).add(localObject2);
            }
            i += 1;
            continue;
            paramString = p.t((Iterable)paramString);
            break;
            i = 0;
            break label67;
          }
        }
        if (!((LinkedList)localObject1).isEmpty()) {
          break label290;
        }
        Log.i(this.TAG, "sorEmojiList return. empty list.");
      }
    }
    for (;;)
    {
      localObject1 = (Iterable)localObject1;
      paramString = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          p.kkW();
        }
        paramString.add(new l((EmojiInfo)localObject2, 0, i + 1));
        i += 1;
      }
      label290:
      paramString = ((Iterable)localObject1).iterator();
      while (paramString.hasNext())
      {
        localObject2 = (EmojiInfo)paramString.next();
        Log.i(this.TAG, s.X("getEmojiList: match ", ((EmojiInfo)localObject2).getMd5()));
      }
    }
    paramb.a((List)paramString, new m(0L, 0, 0, null, 15));
    AppMethodBeat.o(242685);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.c.c.e
 * JD-Core Version:    0.7.0.1
 */