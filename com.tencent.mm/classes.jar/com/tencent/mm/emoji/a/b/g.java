package com.tencent.mm.emoji.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.bar;
import com.tencent.mm.protocal.protobuf.ckf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.vfs.i;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestWords;", "", "()V", "wordList", "Ljava/util/LinkedList;", "", "wordType", "", "getWordType", "()I", "setWordType", "(I)V", "wordVersion", "", "getWordVersion", "()J", "setWordVersion", "(J)V", "getWordList", "", "initPersonalWords", "", "rsp", "Lcom/tencent/mm/protocal/protobuf/GetEmotionWordListResponse;", "initResourceWords", "initWordList", "matchWord", "", "content", "plugin-emojisdk_release"})
public final class g
{
  private static int gmp;
  private static long gmq;
  private static final LinkedList<String> gmr;
  public static final g gms;
  
  static
  {
    AppMethodBeat.i(218975);
    gms = new g();
    gmp = 3;
    gmr = new LinkedList();
    afJ();
    AppMethodBeat.o(218975);
  }
  
  public static int afH()
  {
    return gmp;
  }
  
  public static long afI()
  {
    return gmq;
  }
  
  public static void afJ()
  {
    AppMethodBeat.i(218973);
    Object localObject1;
    synchronized (gmr)
    {
      ad.i(h.aeD(), "initWordList: start");
      localObject1 = bd.frc();
      p.g(localObject1, "EmojiStorageMgr.getInstance()");
      localObject3 = ((bd)localObject1).frf().get("cache_type_words_list");
      localObject1 = (a)new bar();
    }
    z localz;
    try
    {
      ((a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (bar)localObject1;
      if (localObject1 == null) {
        break label306;
      }
      localObject3 = d.gml;
      d.ma(31);
      gmr.clear();
      localObject3 = gmr;
      localObject4 = ((bar)localObject1).GxF;
      p.g(localObject4, "rsp.PersonalWords");
      Object localObject5 = (Iterable)localObject4;
      localObject4 = (Collection)new ArrayList(j.a((Iterable)localObject5, 10));
      localObject5 = ((Iterable)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        ((Collection)localObject4).add(((ckf)((Iterator)localObject5).next()).HdP);
        continue;
        localObject2 = finally;
        AppMethodBeat.o(218973);
        throw localObject2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.l("safeParser", "", new Object[] { localException });
        localz = null;
      }
      ((LinkedList)localObject3).addAll((Collection)localObject4);
      gmp = localz.GxG;
      gmq = localz.GxH;
    }
    Object localObject3 = h.aeD();
    Object localObject4 = new StringBuilder("initWordList: personal:");
    if (localz != null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i((String)localObject3, bool + ", size:" + gmr.size() + ", type:" + gmp + ", version:" + gmq);
      localz = z.MKo;
      AppMethodBeat.o(218973);
      return;
      label306:
      gmr.clear();
      localObject3 = new StringBuilder();
      localObject4 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
      p.g(localObject4, "MMKernel.plugin(IPluginEmoji::class.java)");
      localObject4 = ((com.tencent.mm.plugin.emoji.b.d)localObject4).getEmojiMgr();
      p.g(localObject4, "MMKernel.plugin(IPluginEmoji::class.java).emojiMgr");
      localObject3 = ((com.tencent.mm.pluginsdk.a.d)localObject4).getDataEmojiPath() + "/suggest_word/word2emoji.txt";
      if (i.fv((String)localObject3))
      {
        localObject3 = i.aYq((String)localObject3);
        localObject4 = gmr;
        p.g(localObject3, "content");
        ((LinkedList)localObject4).addAll((Collection)n.b((CharSequence)localObject3, new String[] { "\n" }));
      }
      gmp = 3;
      gmq = 0L;
      break;
    }
  }
  
  public static List<String> afK()
  {
    synchronized (gmr)
    {
      List localList = (List)gmr;
      return localList;
    }
  }
  
  public static boolean vZ(String paramString)
  {
    AppMethodBeat.i(218974);
    p.h(paramString, "content");
    synchronized (gmr)
    {
      Iterator localIterator = ((Iterable)gmr).iterator();
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
        ad.i(h.aeD(), "matchWord: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(218974);
        return true;
      }
      AppMethodBeat.o(218974);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.g
 * JD-Core Version:    0.7.0.1
 */