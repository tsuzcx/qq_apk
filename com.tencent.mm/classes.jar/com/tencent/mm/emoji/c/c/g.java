package com.tencent.mm.emoji.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.cjg;
import com.tencent.mm.protocal.protobuf.edg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestWords;", "", "()V", "wordList", "Ljava/util/LinkedList;", "", "wordType", "", "getWordType", "()I", "setWordType", "(I)V", "wordVersion", "", "getWordVersion", "()J", "setWordVersion", "(J)V", "getWordList", "", "initPersonalWords", "", "rsp", "Lcom/tencent/mm/protocal/protobuf/GetEmotionWordListResponse;", "initResourceWords", "initWordList", "matchWord", "", "content", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g mjS;
  private static int mjT;
  private static long mjU;
  private static final LinkedList<String> mjV;
  
  static
  {
    AppMethodBeat.i(242688);
    mjS = new g();
    mjT = 3;
    mjV = new LinkedList();
    aVE();
    AppMethodBeat.o(242688);
  }
  
  public static boolean Et(String paramString)
  {
    AppMethodBeat.i(242681);
    kotlin.g.b.s.u(paramString, "content");
    synchronized (mjV)
    {
      Iterator localIterator = ((Iterable)mjV).iterator();
      Object localObject;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = localIterator.next();
      } while (!n.T((String)localObject, paramString, true));
      for (paramString = localObject;; paramString = null)
      {
        paramString = (String)paramString;
        if (paramString == null) {
          break;
        }
        Log.i(h.aUw(), kotlin.g.b.s.X("matchWord: ", paramString));
        AppMethodBeat.o(242681);
        return true;
      }
      AppMethodBeat.o(242681);
      return false;
    }
  }
  
  public static int aVC()
  {
    return mjT;
  }
  
  public static long aVD()
  {
    return mjU;
  }
  
  public static void aVE()
  {
    AppMethodBeat.i(242675);
    Object localObject1;
    synchronized (mjV)
    {
      Log.i(h.aUw(), "initWordList: start");
      localObject3 = bl.jba().adjx.get("cache_type_words_list");
      localObject1 = (a)new cjg();
    }
    ah localah;
    try
    {
      ((a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (cjg)localObject1;
      if (localObject1 == null) {
        break label298;
      }
      localObject3 = d.mjQ;
      d.rG(31);
      mjV.clear();
      localObject3 = mjV;
      localObject4 = ((cjg)localObject1).aarO;
      kotlin.g.b.s.s(localObject4, "rsp.PersonalWords");
      Object localObject5 = (Iterable)localObject4;
      localObject4 = (Collection)new ArrayList(p.a((Iterable)localObject5, 10));
      localObject5 = ((Iterable)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        ((Collection)localObject4).add(((edg)((Iterator)localObject5).next()).abiz);
        continue;
        localObject2 = finally;
        AppMethodBeat.o(242675);
        throw localObject2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        localah = null;
      }
      ((LinkedList)localObject3).addAll((Collection)localObject4);
      mjT = localah.aarP;
      mjU = localah.aarQ;
    }
    Object localObject3 = h.aUw();
    Object localObject4 = new StringBuilder("initWordList: personal:");
    if (localah != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i((String)localObject3, bool + ", size:" + mjV.size() + ", type:" + mjT + ", version:" + mjU);
      localah = ah.aiuX;
      AppMethodBeat.o(242675);
      return;
      label298:
      mjV.clear();
      localObject3 = kotlin.g.b.s.X(((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().getDataEmojiPath(), "/suggest_word/word2emoji.txt");
      if (y.ZC((String)localObject3))
      {
        localObject3 = y.bEn((String)localObject3);
        localObject4 = mjV;
        kotlin.g.b.s.s(localObject3, "content");
        ((LinkedList)localObject4).addAll((Collection)n.b((CharSequence)localObject3, new String[] { "\n" }));
      }
      mjT = 3;
      mjU = 0L;
      break;
    }
  }
  
  public static List<String> aVF()
  {
    synchronized (mjV)
    {
      List localList = (List)mjV;
      return localList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.c.c.g
 * JD-Core Version:    0.7.0.1
 */