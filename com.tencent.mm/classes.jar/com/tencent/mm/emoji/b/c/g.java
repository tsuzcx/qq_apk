package com.tencent.mm.emoji.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.protocal.protobuf.bul;
import com.tencent.mm.protocal.protobuf.dkw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestWords;", "", "()V", "wordList", "Ljava/util/LinkedList;", "", "wordType", "", "getWordType", "()I", "setWordType", "(I)V", "wordVersion", "", "getWordVersion", "()J", "setWordVersion", "(J)V", "getWordList", "", "initPersonalWords", "", "rsp", "Lcom/tencent/mm/protocal/protobuf/GetEmotionWordListResponse;", "initResourceWords", "initWordList", "matchWord", "", "content", "plugin-emojisdk_release"})
public final class g
{
  private static int jKF;
  private static long jKG;
  private static final LinkedList<String> jKH;
  public static final g jKI;
  
  static
  {
    AppMethodBeat.i(231352);
    jKI = new g();
    jKF = 3;
    jKH = new LinkedList();
    aCH();
    AppMethodBeat.o(231352);
  }
  
  public static boolean LO(String paramString)
  {
    AppMethodBeat.i(231344);
    p.k(paramString, "content");
    synchronized (jKH)
    {
      Iterator localIterator = ((Iterable)jKH).iterator();
      Object localObject;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = localIterator.next();
      } while (!n.L((String)localObject, paramString, true));
      for (paramString = localObject;; paramString = null)
      {
        paramString = (String)paramString;
        if (paramString == null) {
          break;
        }
        Log.i(h.aBy(), "matchWord: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(231344);
        return true;
      }
      AppMethodBeat.o(231344);
      return false;
    }
  }
  
  public static int aCF()
  {
    return jKF;
  }
  
  public static long aCG()
  {
    return jKG;
  }
  
  public static void aCH()
  {
    AppMethodBeat.i(231341);
    Object localObject1;
    synchronized (jKH)
    {
      Log.i(h.aBy(), "initWordList: start");
      localObject1 = bj.hyV();
      p.j(localObject1, "EmojiStorageMgr.getInstance()");
      localObject3 = ((bj)localObject1).hyZ().get("cache_type_words_list");
      localObject1 = (a)new bul();
    }
    x localx;
    try
    {
      ((a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (bul)localObject1;
      if (localObject1 == null) {
        break label306;
      }
      localObject3 = d.jKB;
      d.rE(31);
      jKH.clear();
      localObject3 = jKH;
      localObject4 = ((bul)localObject1).Tez;
      p.j(localObject4, "rsp.PersonalWords");
      Object localObject5 = (Iterable)localObject4;
      localObject4 = (Collection)new ArrayList(j.a((Iterable)localObject5, 10));
      localObject5 = ((Iterable)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        ((Collection)localObject4).add(((dkw)((Iterator)localObject5).next()).TSb);
        continue;
        localObject2 = finally;
        AppMethodBeat.o(231341);
        throw localObject2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        localx = null;
      }
      ((LinkedList)localObject3).addAll((Collection)localObject4);
      jKF = localx.TeA;
      jKG = localx.TeB;
    }
    Object localObject3 = h.aBy();
    Object localObject4 = new StringBuilder("initWordList: personal:");
    if (localx != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i((String)localObject3, bool + ", size:" + jKH.size() + ", type:" + jKF + ", version:" + jKG);
      localx = x.aazN;
      AppMethodBeat.o(231341);
      return;
      label306:
      jKH.clear();
      localObject3 = new StringBuilder();
      localObject4 = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class);
      p.j(localObject4, "MMKernel.plugin(IPluginEmoji::class.java)");
      localObject4 = ((com.tencent.mm.plugin.emoji.b.d)localObject4).getEmojiMgr();
      p.j(localObject4, "MMKernel.plugin(IPluginEmoji::class.java).emojiMgr");
      localObject3 = ((com.tencent.mm.pluginsdk.b.d)localObject4).getDataEmojiPath() + "/suggest_word/word2emoji.txt";
      if (u.agG((String)localObject3))
      {
        localObject3 = u.bBS((String)localObject3);
        localObject4 = jKH;
        p.j(localObject3, "content");
        ((LinkedList)localObject4).addAll((Collection)n.b((CharSequence)localObject3, new String[] { "\n" }));
      }
      jKF = 3;
      jKG = 0L;
      break;
    }
  }
  
  public static List<String> aCI()
  {
    synchronized (jKH)
    {
      List localList = (List)jKH;
      return localList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c.g
 * JD-Core Version:    0.7.0.1
 */