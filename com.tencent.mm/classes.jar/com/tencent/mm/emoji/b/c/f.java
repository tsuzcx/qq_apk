package com.tencent.mm.emoji.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.jx;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.cji;
import com.tencent.mm.protocal.protobuf.dkt;
import com.tencent.mm.protocal.protobuf.dlc;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestRemote;", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "TAG", "", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "remoteShuffle", "", "getRemoteShuffle", "()Z", "setRemoteShuffle", "(Z)V", "sessionId", "username", "checkMatch", "desc", "checkPrefetch", "", "rsp", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiResponse;", "checkUpdate", "searchSuggest", "callback", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "setRequestInfo", "chatId", "plugin-emojisdk_release"})
public final class f
  implements j
{
  private final String TAG;
  boolean gZB;
  private final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> gZm;
  public String sessionId;
  public String username;
  
  public f(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb)
  {
    this.gZm = paramb;
    this.TAG = "MicroMsg.EmojiSuggestMatchWord";
  }
  
  public static boolean ET(String paramString)
  {
    AppMethodBeat.i(199944);
    p.h(paramString, "desc");
    g localg = g.gZH;
    boolean bool = g.EV(paramString);
    AppMethodBeat.o(199944);
    return bool;
  }
  
  private void EU(final String paramString)
  {
    AppMethodBeat.i(199946);
    p.h(paramString, "desc");
    Object localObject1 = bj.gCJ();
    p.g(localObject1, "EmojiStorageMgr.getInstance()");
    Object localObject2 = ((bj)localObject1).gCO().blp(paramString);
    Object localObject3 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("checkUpdate: ").append(paramString).append(", ");
    if (localObject2 != null)
    {
      localObject1 = Integer.valueOf(((c)localObject2).field_updateTime);
      Log.i((String)localObject3, localObject1);
      if (localObject2 == null) {
        break label171;
      }
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rWA, 24);
      Log.i(c.TAG, "needUpdate: config ".concat(String.valueOf(i)));
      if (Util.secondsToNow(((c)localObject2).field_updateTime) <= 3600L * i) {
        break label166;
      }
    }
    label166:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label171;
      }
      AppMethodBeat.o(199946);
      return;
      localObject1 = null;
      break;
    }
    label171:
    localObject1 = new cji();
    if (this.gZB)
    {
      localObject2 = com.tencent.mm.kernel.g.ah(PluginEmoji.class);
      p.g(localObject2, "MMKernel.plugin(PluginEmoji::class.java)");
      localObject2 = ((PluginEmoji)localObject2).getEmojiMgr().amr(paramString);
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rWD, 20);
      Log.i(this.TAG, "checkUpdate: shuffle " + i + ", local " + ((ArrayList)localObject2).size());
      int j = Math.min(i, ((ArrayList)localObject2).size());
      i = 0;
      while (i < j)
      {
        ((cji)localObject1).MoI.add(((ArrayList)localObject2).get(i));
        i += 1;
      }
    }
    localObject2 = new dlc();
    ((dlc)localObject2).KXA = paramString;
    ((dlc)localObject2).MOZ = this.username;
    ((dlc)localObject2).SessionId = this.sessionId;
    ((dlc)localObject2).Scene = 4;
    ((dlc)localObject2).MPa = new com.tencent.mm.bw.b(((cji)localObject1).toByteArray());
    localObject1 = new jx();
    ((jx)localObject1).xi(this.sessionId);
    ((jx)localObject1).sZ(Util.nowMilliSecond());
    localObject3 = d.gZA;
    d.pl(40);
    new com.tencent.mm.emoji.b.b((dlc)localObject2).aYI().g((com.tencent.mm.vending.c.a)new a(this, (jx)localObject1, paramString));
    AppMethodBeat.o(199946);
  }
  
  public final void a(String paramString, j.b paramb)
  {
    AppMethodBeat.i(199945);
    p.h(paramString, "desc");
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rWy, false);
    Log.i(this.TAG, "searchSuggest: remoteEnable ".concat(String.valueOf(bool)));
    Object localObject1 = g.gZH;
    long l = g.avK();
    localObject1 = g.gZH;
    int i = g.avJ();
    localObject1 = g.gZH;
    m localm = new m(l, i, g.avM().size(), null, 8);
    if (!bool)
    {
      if (paramb != null)
      {
        paramb.a((List)v.SXr, localm);
        AppMethodBeat.o(199945);
        return;
      }
      AppMethodBeat.o(199945);
      return;
    }
    localObject1 = bj.gCJ();
    p.g(localObject1, "EmojiStorageMgr.getInstance()");
    localObject1 = ((bj)localObject1).gCO().blp(paramString);
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      Log.i(this.TAG, "searchSuggest: has cache " + ((c)localObject1).field_updateTime);
      localObject2 = d.gZA;
      d.pl(32);
      localObject3 = new dld();
      localObject2 = (com.tencent.mm.bw.a)localObject3;
      localObject1 = ((c)localObject1).field_content;
    }
    label696:
    for (;;)
    {
      try
      {
        ((com.tencent.mm.bw.a)localObject2).parseFrom((byte[])localObject1);
        localObject2 = ((dld)localObject3).SessionId;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        p.h(localObject1, "<set-?>");
        localm.gZQ = ((String)localObject1);
        if (paramb != null)
        {
          localObject1 = ((dld)localObject3).LVc;
          p.g(localObject1, "rsp.Emoji");
          localObject1 = (Iterable)localObject1;
          localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
          localObject3 = ((Iterable)localObject1).iterator();
          i = 0;
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = ((Iterator)localObject3).next();
            if (i < 0) {
              kotlin.a.j.hxH();
            }
            dkt localdkt = (dkt)localObject1;
            localObject1 = bj.gCJ();
            p.g(localObject1, "EmojiStorageMgr.getInstance()");
            localObject1 = ((bj)localObject1).cgN().blk(localdkt.MOJ.Md5);
            if (localObject1 != null) {
              break label696;
            }
            localObject1 = new EmojiInfo();
            com.tencent.mm.plugin.emoji.h.b.a(localdkt.MOJ, (EmojiInfo)localObject1);
            ((EmojiInfo)localObject1).field_catalog = EmojiInfo.Uup;
            Object localObject4 = com.tencent.mm.emoji.b.j.auL();
            p.g(localObject4, "EmojiStorageCache.getInstance()");
            localObject4 = ((com.tencent.mm.emoji.b.j)localObject4).auP();
            p.g(localObject4, "EmojiStorageCache.getInstance().emojiGroupInfoList");
            localObject4 = (Iterable)localObject4;
            if ((!(localObject4 instanceof Collection)) || (!((Collection)localObject4).isEmpty()))
            {
              localObject4 = ((Iterable)localObject4).iterator();
              if (((Iterator)localObject4).hasNext())
              {
                EmojiGroupInfo localEmojiGroupInfo = (EmojiGroupInfo)((Iterator)localObject4).next();
                p.g(localEmojiGroupInfo, "it");
                if (!p.j(localEmojiGroupInfo.hRu(), ((EmojiInfo)localObject1).field_groupId)) {
                  continue;
                }
                j = 1;
                if (localdkt.MOM != 1) {
                  continue;
                }
                if (j == 0) {
                  continue;
                }
                j = 0;
                ((Collection)localObject2).add(new l((EmojiInfo)localObject1, j, i + 1));
                i += 1;
                continue;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        continue;
        int j = 0;
        continue;
        Log.i(this.TAG, "searchSuggest: delete local emoji " + localException.getMd5());
        j = 1;
        continue;
        paramb.a((List)localObject2, localm);
      }
      for (;;)
      {
        EU(paramString);
        AppMethodBeat.o(199945);
        return;
        Log.i(this.TAG, "searchSuggest: no cache");
        if (paramb != null) {
          paramb.a((List)v.SXr, localm);
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(f paramf, jx paramjx, String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c.f
 * JD-Core Version:    0.7.0.1
 */