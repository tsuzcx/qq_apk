package com.tencent.mm.emoji.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import d.n.n;
import d.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestCache;", "", "()V", "TAG", "", "wordList", "Ljava/util/LinkedList;", "getWordList", "", "initWordList", "", "matchWord", "", "content", "plugin-emojisdk_release"})
public final class c
{
  private static final String TAG = "MicroMsg.EmojiSuggestCache";
  private static final LinkedList<String> fOT;
  public static final c fOU;
  
  static
  {
    AppMethodBeat.i(193403);
    fOU = new c();
    TAG = "MicroMsg.EmojiSuggestCache";
    fOT = new LinkedList();
    aca();
    AppMethodBeat.o(193403);
  }
  
  public static void aca()
  {
    AppMethodBeat.i(193401);
    synchronized (fOT)
    {
      ad.i(TAG, "initWordList: start");
      fOT.clear();
      Object localObject1 = new StringBuilder();
      Object localObject3 = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
      k.g(localObject3, "MMKernel.plugin(IPluginEmoji::class.java)");
      localObject3 = ((com.tencent.mm.plugin.emoji.b.d)localObject3).getEmojiMgr();
      k.g(localObject3, "MMKernel.plugin(IPluginEmoji::class.java).emojiMgr");
      localObject1 = ((com.tencent.mm.pluginsdk.a.d)localObject3).getDataEmojiPath() + "/suggest_word/word2emoji.txt";
      if (i.eK((String)localObject1))
      {
        localObject1 = i.aMP((String)localObject1);
        localObject3 = fOT;
        k.g(localObject1, "content");
        ((LinkedList)localObject3).addAll((Collection)n.b((CharSequence)localObject1, new String[] { "\n" }));
      }
      ad.i(TAG, "initWordList: " + fOT.size());
      localObject1 = y.JfV;
      AppMethodBeat.o(193401);
      return;
    }
  }
  
  public static List<String> acb()
  {
    synchronized (fOT)
    {
      List localList = (List)fOT;
      return localList;
    }
  }
  
  public static boolean pW(String paramString)
  {
    AppMethodBeat.i(193402);
    k.h(paramString, "content");
    synchronized (fOT)
    {
      Iterator localIterator = ((Iterable)fOT).iterator();
      Object localObject;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = localIterator.next();
      } while (!n.I((String)localObject, paramString, true));
      for (paramString = localObject;; paramString = null)
      {
        paramString = (String)paramString;
        if (paramString == null) {
          break;
        }
        ad.i(TAG, "matchWord: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(193402);
        return true;
      }
      AppMethodBeat.o(193402);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.c
 * JD-Core Version:    0.7.0.1
 */