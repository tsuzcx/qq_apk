package com.tencent.mm.emoji.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.bmw;
import com.tencent.mm.protocal.protobuf.dbh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bj;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestWords;", "", "()V", "wordList", "Ljava/util/LinkedList;", "", "wordType", "", "getWordType", "()I", "setWordType", "(I)V", "wordVersion", "", "getWordVersion", "()J", "setWordVersion", "(J)V", "getWordList", "", "initPersonalWords", "", "rsp", "Lcom/tencent/mm/protocal/protobuf/GetEmotionWordListResponse;", "initResourceWords", "initWordList", "matchWord", "", "content", "plugin-emojisdk_release"})
public final class g
{
  private static int gZE;
  private static long gZF;
  private static final LinkedList<String> gZG;
  public static final g gZH;
  
  static
  {
    AppMethodBeat.i(199950);
    gZH = new g();
    gZE = 3;
    gZG = new LinkedList();
    avL();
    AppMethodBeat.o(199950);
  }
  
  public static boolean EV(String paramString)
  {
    AppMethodBeat.i(199949);
    p.h(paramString, "content");
    synchronized (gZG)
    {
      Iterator localIterator = ((Iterable)gZG).iterator();
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
        Log.i(h.auD(), "matchWord: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(199949);
        return true;
      }
      AppMethodBeat.o(199949);
      return false;
    }
  }
  
  public static int avJ()
  {
    return gZE;
  }
  
  public static long avK()
  {
    return gZF;
  }
  
  public static void avL()
  {
    AppMethodBeat.i(199948);
    Object localObject1;
    synchronized (gZG)
    {
      Log.i(h.auD(), "initWordList: start");
      localObject1 = bj.gCJ();
      p.g(localObject1, "EmojiStorageMgr.getInstance()");
      localObject3 = ((bj)localObject1).gCM().get("cache_type_words_list");
      localObject1 = (a)new bmw();
    }
    x localx;
    try
    {
      ((a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (bmw)localObject1;
      if (localObject1 == null) {
        break label306;
      }
      localObject3 = d.gZA;
      d.pl(31);
      gZG.clear();
      localObject3 = gZG;
      localObject4 = ((bmw)localObject1).LVv;
      p.g(localObject4, "rsp.PersonalWords");
      Object localObject5 = (Iterable)localObject4;
      localObject4 = (Collection)new ArrayList(j.a((Iterable)localObject5, 10));
      localObject5 = ((Iterable)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        ((Collection)localObject4).add(((dbh)((Iterator)localObject5).next()).MGp);
        continue;
        localObject2 = finally;
        AppMethodBeat.o(199948);
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
      gZE = localx.LVw;
      gZF = localx.LVx;
    }
    Object localObject3 = h.auD();
    Object localObject4 = new StringBuilder("initWordList: personal:");
    if (localx != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i((String)localObject3, bool + ", size:" + gZG.size() + ", type:" + gZE + ", version:" + gZF);
      localx = x.SXb;
      AppMethodBeat.o(199948);
      return;
      label306:
      gZG.clear();
      localObject3 = new StringBuilder();
      localObject4 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class);
      p.g(localObject4, "MMKernel.plugin(IPluginEmoji::class.java)");
      localObject4 = ((com.tencent.mm.plugin.emoji.b.d)localObject4).getEmojiMgr();
      p.g(localObject4, "MMKernel.plugin(IPluginEmoji::class.java).emojiMgr");
      localObject3 = ((com.tencent.mm.pluginsdk.a.d)localObject4).getDataEmojiPath() + "/suggest_word/word2emoji.txt";
      if (com.tencent.mm.vfs.s.YS((String)localObject3))
      {
        localObject3 = com.tencent.mm.vfs.s.boY((String)localObject3);
        localObject4 = gZG;
        p.g(localObject3, "content");
        ((LinkedList)localObject4).addAll((Collection)n.b((CharSequence)localObject3, new String[] { "\n" }));
      }
      gZE = 3;
      gZF = 0L;
      break;
    }
  }
  
  public static List<String> avM()
  {
    synchronized (gZG)
    {
      List localList = (List)gZG;
      return localList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c.g
 * JD-Core Version:    0.7.0.1
 */