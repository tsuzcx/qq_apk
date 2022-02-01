package com.tencent.mm.emoji.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.vfs.o;
import d.a.j;
import d.g.b.p;
import d.l;
import d.n.n;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestWords;", "", "()V", "wordList", "Ljava/util/LinkedList;", "", "wordType", "", "getWordType", "()I", "setWordType", "(I)V", "wordVersion", "", "getWordVersion", "()J", "setWordVersion", "(J)V", "getWordList", "", "initPersonalWords", "", "rsp", "Lcom/tencent/mm/protocal/protobuf/GetEmotionWordListResponse;", "initResourceWords", "initWordList", "matchWord", "", "content", "plugin-emojisdk_release"})
public final class g
{
  private static int goL;
  private static long goM;
  private static final LinkedList<String> goN;
  public static final g goO;
  
  static
  {
    AppMethodBeat.i(188589);
    goO = new g();
    goL = 3;
    goN = new LinkedList();
    afX();
    AppMethodBeat.o(188589);
  }
  
  public static int afV()
  {
    return goL;
  }
  
  public static long afW()
  {
    return goM;
  }
  
  public static void afX()
  {
    AppMethodBeat.i(188587);
    Object localObject1;
    synchronized (goN)
    {
      ae.i(h.aeP(), "initWordList: start");
      localObject1 = be.fvc();
      p.g(localObject1, "EmojiStorageMgr.getInstance()");
      localObject3 = ((be)localObject1).fvf().get("cache_type_words_list");
      localObject1 = (a)new bbh();
    }
    z localz;
    try
    {
      ((a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (bbh)localObject1;
      if (localObject1 == null) {
        break label306;
      }
      localObject3 = d.goH;
      d.md(31);
      goN.clear();
      localObject3 = goN;
      localObject4 = ((bbh)localObject1).GRf;
      p.g(localObject4, "rsp.PersonalWords");
      Object localObject5 = (Iterable)localObject4;
      localObject4 = (Collection)new ArrayList(j.a((Iterable)localObject5, 10));
      localObject5 = ((Iterable)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        ((Collection)localObject4).add(((ckz)((Iterator)localObject5).next()).Hxp);
        continue;
        localObject2 = finally;
        AppMethodBeat.o(188587);
        throw localObject2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.l("safeParser", "", new Object[] { localException });
        localz = null;
      }
      ((LinkedList)localObject3).addAll((Collection)localObject4);
      goL = localz.GRg;
      goM = localz.GRh;
    }
    Object localObject3 = h.aeP();
    Object localObject4 = new StringBuilder("initWordList: personal:");
    if (localz != null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i((String)localObject3, bool + ", size:" + goN.size() + ", type:" + goL + ", version:" + goM);
      localz = z.Nhr;
      AppMethodBeat.o(188587);
      return;
      label306:
      goN.clear();
      localObject3 = new StringBuilder();
      localObject4 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
      p.g(localObject4, "MMKernel.plugin(IPluginEmoji::class.java)");
      localObject4 = ((com.tencent.mm.plugin.emoji.b.d)localObject4).getEmojiMgr();
      p.g(localObject4, "MMKernel.plugin(IPluginEmoji::class.java).emojiMgr");
      localObject3 = ((com.tencent.mm.pluginsdk.a.d)localObject4).getDataEmojiPath() + "/suggest_word/word2emoji.txt";
      if (o.fB((String)localObject3))
      {
        localObject3 = o.aZT((String)localObject3);
        localObject4 = goN;
        p.g(localObject3, "content");
        ((LinkedList)localObject4).addAll((Collection)n.b((CharSequence)localObject3, new String[] { "\n" }));
      }
      goL = 3;
      goM = 0L;
      break;
    }
  }
  
  public static List<String> afY()
  {
    synchronized (goN)
    {
      List localList = (List)goN;
      return localList;
    }
  }
  
  public static boolean wG(String paramString)
  {
    AppMethodBeat.i(188588);
    p.h(paramString, "content");
    synchronized (goN)
    {
      Iterator localIterator = ((Iterable)goN).iterator();
      Object localObject;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = localIterator.next();
      } while (!n.H((String)localObject, paramString, true));
      for (paramString = localObject;; paramString = null)
      {
        paramString = (String)paramString;
        if (paramString == null) {
          break;
        }
        ae.i(h.aeP(), "matchWord: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(188588);
        return true;
      }
      AppMethodBeat.o(188588);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.c.g
 * JD-Core Version:    0.7.0.1
 */