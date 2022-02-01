package com.tencent.mm.emoji.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.cfg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.vfs.i;
import d.a.j;
import d.g.b.k;
import d.l;
import d.n.n;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestWords;", "", "()V", "wordList", "Ljava/util/LinkedList;", "", "wordType", "", "getWordType", "()I", "setWordType", "(I)V", "wordVersion", "", "getWordVersion", "()J", "setWordVersion", "(J)V", "getWordList", "", "initPersonalWords", "", "rsp", "Lcom/tencent/mm/protocal/protobuf/GetEmotionWordListResponse;", "initResourceWords", "initWordList", "matchWord", "", "content", "plugin-emojisdk_release"})
public final class g
{
  private static int fSL;
  private static long fSM;
  private static final LinkedList<String> fSN;
  public static final g fSO;
  
  static
  {
    AppMethodBeat.i(209850);
    fSO = new g();
    fSL = 3;
    fSN = new LinkedList();
    adc();
    AppMethodBeat.o(209850);
  }
  
  public static int ada()
  {
    return fSL;
  }
  
  public static long adb()
  {
    return fSM;
  }
  
  public static void adc()
  {
    AppMethodBeat.i(209848);
    Object localObject1;
    synchronized (fSN)
    {
      ac.i(h.abZ(), "initWordList: start");
      localObject1 = az.faZ();
      k.g(localObject1, "EmojiStorageMgr.getInstance()");
      localObject3 = ((az)localObject1).fbc().get("cache_type_words_list");
      localObject1 = (a)new awt();
    }
    y localy;
    try
    {
      ((a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (awt)localObject1;
      if (localObject1 == null) {
        break label306;
      }
      localObject3 = d.fSH;
      d.lA(31);
      fSN.clear();
      localObject3 = fSN;
      localObject4 = ((awt)localObject1).EOB;
      k.g(localObject4, "rsp.PersonalWords");
      Object localObject5 = (Iterable)localObject4;
      localObject4 = (Collection)new ArrayList(j.a((Iterable)localObject5, 10));
      localObject5 = ((Iterable)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        ((Collection)localObject4).add(((cfg)((Iterator)localObject5).next()).FtK);
        continue;
        localObject2 = finally;
        AppMethodBeat.o(209848);
        throw localObject2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.l("safeParser", "", new Object[] { localException });
        localy = null;
      }
      ((LinkedList)localObject3).addAll((Collection)localObject4);
      fSL = localy.EOC;
      fSM = localy.EOD;
    }
    Object localObject3 = h.abZ();
    Object localObject4 = new StringBuilder("initWordList: personal:");
    if (localy != null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i((String)localObject3, bool + ", size:" + fSN.size() + ", type:" + fSL + ", version:" + fSM);
      localy = y.KTp;
      AppMethodBeat.o(209848);
      return;
      label306:
      fSN.clear();
      localObject3 = new StringBuilder();
      localObject4 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
      k.g(localObject4, "MMKernel.plugin(IPluginEmoji::class.java)");
      localObject4 = ((com.tencent.mm.plugin.emoji.b.d)localObject4).getEmojiMgr();
      k.g(localObject4, "MMKernel.plugin(IPluginEmoji::class.java).emojiMgr");
      localObject3 = ((com.tencent.mm.pluginsdk.a.d)localObject4).getDataEmojiPath() + "/suggest_word/word2emoji.txt";
      if (i.eA((String)localObject3))
      {
        localObject3 = i.aSr((String)localObject3);
        localObject4 = fSN;
        k.g(localObject3, "content");
        ((LinkedList)localObject4).addAll((Collection)n.b((CharSequence)localObject3, new String[] { "\n" }));
      }
      fSL = 3;
      fSM = 0L;
      break;
    }
  }
  
  public static List<String> ade()
  {
    synchronized (fSN)
    {
      List localList = (List)fSN;
      return localList;
    }
  }
  
  public static boolean tj(String paramString)
  {
    AppMethodBeat.i(209849);
    k.h(paramString, "content");
    synchronized (fSN)
    {
      Iterator localIterator = ((Iterable)fSN).iterator();
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
        ac.i(h.abZ(), "matchWord: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(209849);
        return true;
      }
      AppMethodBeat.o(209849);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.g
 * JD-Core Version:    0.7.0.1
 */