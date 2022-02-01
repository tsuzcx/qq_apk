package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.emoji.b.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.protocal.protobuf.dit;
import com.tencent.mm.protocal.protobuf.diu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/egg/EmojiEggUtil;", "", "()V", "Companion", "plugin-emojisdk_release"})
public final class f
{
  private static final String TAG = "MicroMsg.EmojiEggUtil";
  private static final String fyn = "emoji-anim.xml";
  private static final String jGs;
  private static long jGt;
  private static b jGu;
  public static final a jGv;
  
  static
  {
    AppMethodBeat.i(226112);
    jGv = new a((byte)0);
    TAG = "MicroMsg.EmojiEggUtil";
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.emoji.e.a locala = com.tencent.mm.emoji.e.a.jPz;
    jGs = com.tencent.mm.emoji.e.a.aDD() + "panel/";
    fyn = "emoji-anim.xml";
    jGu = new b();
    a.aBt();
    AppMethodBeat.o(226112);
  }
  
  public static final String s(ca paramca)
  {
    AppMethodBeat.i(226115);
    paramca = a.s(paramca);
    AppMethodBeat.o(226115);
    return paramca;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/egg/EmojiEggUtil$Companion;", "", "()V", "PatMsgJoint", "", "TAG", "animConfig", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig;", "getAnimConfig", "()Lcom/tencent/mm/emoji/egg/EmojiAnimConfig;", "setAnimConfig", "(Lcom/tencent/mm/emoji/egg/EmojiAnimConfig;)V", "assetDir", "configName", "lastCheckTick", "", "localDir", "versionName", "checkAnimUpdate", "", "getAnimItem", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimItem;", "key", "getEmojiAnimVersion", "", "getMsgContent", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "getPatMsgContentList", "", "getScreenEffectVersion", "initAnimConfig", "plugin-emojisdk_release"})
  public static final class a
  {
    public static int LF(String paramString)
    {
      AppMethodBeat.i(228966);
      p.k(paramString, "key");
      Iterator localIterator = ((Iterable)f.aBp().jFL).iterator();
      Object localObject;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = localIterator.next();
      } while (!p.h(((b.a)localObject).key, paramString));
      for (paramString = localObject;; paramString = null)
      {
        paramString = (b.a)paramString;
        if (paramString == null) {
          break;
        }
        paramString = paramString.jFN;
        if (paramString == null) {
          break;
        }
        int i = paramString.version;
        AppMethodBeat.o(228966);
        return i;
      }
      AppMethodBeat.o(228966);
      return 0;
    }
    
    public static void aBt()
    {
      AppMethodBeat.i(228958);
      int i = com.tencent.mm.emoji.e.b.LR(f.aBq() + "config.conf");
      int j = com.tencent.mm.emoji.e.b.LR("assets:///panel/config.conf");
      Object localObject1 = f.aBq() + f.aBr();
      Object localObject2 = "assets:///panel/" + f.aBr();
      if ((i > 0) && (i >= j) && (u.agG((String)localObject1)))
      {
        localObject2 = com.tencent.mm.emoji.b.a.jHS;
        a.a.a((String)localObject1, (com.tencent.mm.emoji.b.a)f.aBp());
      }
      for (;;)
      {
        Log.i(f.access$getTAG$cp(), "initAnimConfig: version:" + i + ", " + j + "; content " + f.aBp().jFL.size());
        AppMethodBeat.o(228958);
        return;
        localObject1 = com.tencent.mm.emoji.b.a.jHS;
        a.a.a((String)localObject2, (com.tencent.mm.emoji.b.a)f.aBp());
      }
    }
    
    public static void aBu()
    {
      AppMethodBeat.i(228960);
      if (!MMApplicationContext.isMainProcess())
      {
        AppMethodBeat.o(228960);
        return;
      }
      if (!h.aHB())
      {
        AppMethodBeat.o(228960);
        return;
      }
      if (Util.ticksToNow(f.aBs()) > 1800000L)
      {
        f.Fm(Util.currentTicks());
        com.tencent.mm.pluginsdk.k.a.a.b.hii().g(37, 7, -1, false);
        com.tencent.mm.pluginsdk.k.a.a.b.hii();
        com.tencent.mm.pluginsdk.k.a.a.b.apP(37);
        Log.i(f.access$getTAG$cp(), "checkAnimUpdate: " + f.aBp().jFL.size() + ", " + f.aBs());
      }
      AppMethodBeat.o(228960);
    }
    
    public static String s(ca paramca)
    {
      AppMethodBeat.i(228948);
      p.k(paramca, "msgInfo");
      Object localObject2 = paramca.getContent();
      Object localObject1 = localObject2;
      if (ab.Lj(paramca.apJ())) {
        localObject1 = bq.RJ((String)localObject2);
      }
      if (!paramca.hzM())
      {
        localObject2 = localObject1;
        if (!paramca.hzN()) {}
      }
      else
      {
        paramca = k.b.aG((String)localObject1, paramca.apL());
        if (paramca == null) {
          break label74;
        }
      }
      label74:
      for (localObject2 = paramca.title;; localObject2 = null)
      {
        AppMethodBeat.o(228948);
        return localObject2;
      }
    }
    
    public static List<String> t(ca paramca)
    {
      AppMethodBeat.i(228952);
      p.k(paramca, "msgInfo");
      LinkedList localLinkedList = new LinkedList();
      Object localObject;
      if (paramca.hzL())
      {
        localObject = paramca.getContent();
        if (!ab.Lj(paramca.apJ())) {
          break label158;
        }
      }
      label158:
      for (paramca = bq.RJ((String)localObject);; paramca = (ca)localObject)
      {
        paramca = ((com.tencent.mm.plugin.patmsg.a.b)h.ae(com.tencent.mm.plugin.patmsg.a.b.class)).aUf(paramca).Ezu;
        p.j(paramca, "patContent.recordList");
        localObject = (Iterable)paramca;
        paramca = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramca.add(((diu)((Iterator)localObject).next()).lqH);
        }
        localLinkedList.addAll((Collection)paramca);
        paramca = (List)localLinkedList;
        AppMethodBeat.o(228952);
        return paramca;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.f
 * JD-Core Version:    0.7.0.1
 */