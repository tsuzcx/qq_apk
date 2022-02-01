package com.tencent.mm.emoji.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.g.b.a.gj;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.agk;
import com.tencent.mm.protocal.protobuf.bvw;
import com.tencent.mm.protocal.protobuf.cso;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.a.v;
import d.g.b.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestRemote;", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "TAG", "", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "remoteShuffle", "", "getRemoteShuffle", "()Z", "setRemoteShuffle", "(Z)V", "sessionId", "username", "checkMatch", "desc", "checkPrefetch", "", "rsp", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiResponse;", "checkUpdate", "searchSuggest", "callback", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "setRequestInfo", "chatId", "plugin-emojisdk_release"})
public final class f
  implements j
{
  private final String TAG;
  boolean goI;
  private final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> got;
  public String sessionId;
  public String username;
  
  public f(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb)
  {
    this.got = paramb;
    this.TAG = "MicroMsg.EmojiSuggestMatchWord";
  }
  
  public static boolean wE(String paramString)
  {
    AppMethodBeat.i(188583);
    p.h(paramString, "desc");
    g localg = g.goO;
    boolean bool = g.wG(paramString);
    AppMethodBeat.o(188583);
    return bool;
  }
  
  private void wF(String paramString)
  {
    AppMethodBeat.i(188585);
    p.h(paramString, "desc");
    Object localObject1 = be.fvc();
    p.g(localObject1, "EmojiStorageMgr.getInstance()");
    Object localObject2 = ((be)localObject1).fvh().aWq(paramString);
    Object localObject3 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("checkUpdate: ").append(paramString).append(", ");
    if (localObject2 != null)
    {
      localObject1 = Integer.valueOf(((c)localObject2).field_updateTime);
      ae.i((String)localObject3, localObject1);
      if (localObject2 == null) {
        break label171;
      }
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDG, 24);
      ae.i(c.TAG, "needUpdate: config ".concat(String.valueOf(i)));
      if (bu.rZ(((c)localObject2).field_updateTime) <= 3600L * i) {
        break label166;
      }
    }
    label166:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label171;
      }
      AppMethodBeat.o(188585);
      return;
      localObject1 = null;
      break;
    }
    label171:
    localObject1 = new bvw();
    if (this.goI)
    {
      localObject2 = com.tencent.mm.kernel.g.ad(PluginEmoji.class);
      p.g(localObject2, "MMKernel.plugin(PluginEmoji::class.java)");
      localObject2 = ((PluginEmoji)localObject2).getEmojiMgr().aco(paramString);
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDJ, 20);
      ae.i(this.TAG, "checkUpdate: shuffle " + i + ", local " + ((ArrayList)localObject2).size());
      int j = Math.min(i, ((ArrayList)localObject2).size());
      i = 0;
      while (i < j)
      {
        ((bvw)localObject1).HiR.add(((ArrayList)localObject2).get(i));
        i += 1;
      }
    }
    localObject2 = new cst();
    ((cst)localObject2).Gdj = paramString;
    ((cst)localObject2).HDV = this.username;
    ((cst)localObject2).FQl = this.sessionId;
    ((cst)localObject2).Scene = 4;
    ((cst)localObject2).HDW = new com.tencent.mm.bw.b(((bvw)localObject1).toByteArray());
    localObject1 = new gj();
    ((gj)localObject1).pA(this.sessionId);
    ((gj)localObject1).lX(bu.fpO());
    localObject3 = d.goH;
    d.md(40);
    new com.tencent.mm.emoji.a.b((cst)localObject2).aET().g((com.tencent.mm.vending.c.a)new f.a(this, (gj)localObject1, paramString));
    AppMethodBeat.o(188585);
  }
  
  public final void a(String paramString, j.b paramb)
  {
    AppMethodBeat.i(188584);
    p.h(paramString, "desc");
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDE, false);
    ae.i(this.TAG, "searchSuggest: remoteEnable ".concat(String.valueOf(bool)));
    Object localObject1 = g.goO;
    long l = g.afW();
    localObject1 = g.goO;
    int i = g.afV();
    localObject1 = g.goO;
    m localm = new m(l, i, g.afY().size(), null, 8);
    if (!bool)
    {
      if (paramb != null)
      {
        paramb.a((List)v.NhH, localm);
        AppMethodBeat.o(188584);
        return;
      }
      AppMethodBeat.o(188584);
      return;
    }
    localObject1 = be.fvc();
    p.g(localObject1, "EmojiStorageMgr.getInstance()");
    localObject1 = ((be)localObject1).fvh().aWq(paramString);
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      ae.i(this.TAG, "searchSuggest: has cache " + ((c)localObject1).field_updateTime);
      localObject2 = d.goH;
      d.md(32);
      localObject3 = new csu();
      localObject2 = (com.tencent.mm.bw.a)localObject3;
      localObject1 = ((c)localObject1).field_content;
    }
    label696:
    for (;;)
    {
      try
      {
        ((com.tencent.mm.bw.a)localObject2).parseFrom((byte[])localObject1);
        localObject2 = ((csu)localObject3).FQl;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        p.h(localObject1, "<set-?>");
        localm.goX = ((String)localObject1);
        if (paramb != null)
        {
          localObject1 = ((csu)localObject3).GQM;
          p.g(localObject1, "rsp.Emoji");
          localObject1 = (Iterable)localObject1;
          localObject2 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
          localObject3 = ((Iterable)localObject1).iterator();
          i = 0;
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = ((Iterator)localObject3).next();
            if (i < 0) {
              d.a.j.gkd();
            }
            cso localcso = (cso)localObject1;
            localObject1 = be.fvc();
            p.g(localObject1, "EmojiStorageMgr.getInstance()");
            localObject1 = ((be)localObject1).bJU().aWl(localcso.HDL.Md5);
            if (localObject1 != null) {
              break label696;
            }
            localObject1 = new EmojiInfo();
            com.tencent.mm.plugin.emoji.h.b.a(localcso.HDL, (EmojiInfo)localObject1);
            ((EmojiInfo)localObject1).field_catalog = EmojiInfo.OzU;
            Object localObject4 = i.aeX();
            p.g(localObject4, "EmojiStorageCache.getInstance()");
            localObject4 = ((i)localObject4).afb();
            p.g(localObject4, "EmojiStorageCache.getInstance().emojiGroupInfoList");
            localObject4 = (Iterable)localObject4;
            if ((!(localObject4 instanceof Collection)) || (!((Collection)localObject4).isEmpty()))
            {
              localObject4 = ((Iterable)localObject4).iterator();
              if (((Iterator)localObject4).hasNext())
              {
                EmojiGroupInfo localEmojiGroupInfo = (EmojiGroupInfo)((Iterator)localObject4).next();
                p.g(localEmojiGroupInfo, "it");
                if (!p.i(localEmojiGroupInfo.fxk(), ((EmojiInfo)localObject1).field_groupId)) {
                  continue;
                }
                j = 1;
                if (localcso.HDO != 1) {
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
        ae.l("safeParser", "", new Object[] { localException });
        continue;
        int j = 0;
        continue;
        ae.i(this.TAG, "searchSuggest: delete local emoji " + localException.Lj());
        j = 1;
        continue;
        paramb.a((List)localObject2, localm);
      }
      for (;;)
      {
        wF(paramString);
        AppMethodBeat.o(188584);
        return;
        ae.i(this.TAG, "searchSuggest: no cache");
        if (paramb != null) {
          paramb.a((List)v.NhH, localm);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.c.f
 * JD-Core Version:    0.7.0.1
 */