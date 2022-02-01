package com.tencent.mm.emoji.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.g.b.a.gh;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.protocal.protobuf.bvc;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.crz;
import com.tencent.mm.protocal.protobuf.csa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.a.v;
import d.g.b.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestRemote;", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "TAG", "", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "remoteShuffle", "", "getRemoteShuffle", "()Z", "setRemoteShuffle", "(Z)V", "sessionId", "username", "checkMatch", "desc", "checkPrefetch", "", "rsp", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiResponse;", "checkUpdate", "searchSuggest", "callback", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "setRequestInfo", "chatId", "plugin-emojisdk_release"})
public final class f
  implements j
{
  private final String TAG;
  private final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> glX;
  boolean gmm;
  public String sessionId;
  public String username;
  
  public f(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb)
  {
    this.glX = paramb;
    this.TAG = "MicroMsg.EmojiSuggestMatchWord";
  }
  
  public static boolean vX(String paramString)
  {
    AppMethodBeat.i(218969);
    p.h(paramString, "desc");
    g localg = g.gms;
    boolean bool = g.vZ(paramString);
    AppMethodBeat.o(218969);
    return bool;
  }
  
  private void vY(String paramString)
  {
    AppMethodBeat.i(218971);
    p.h(paramString, "desc");
    Object localObject1 = bd.frc();
    p.g(localObject1, "EmojiStorageMgr.getInstance()");
    Object localObject2 = ((bd)localObject1).frh().aUP(paramString);
    Object localObject3 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("checkUpdate: ").append(paramString).append(", ");
    if (localObject2 != null)
    {
      localObject1 = Integer.valueOf(((c)localObject2).field_updateTime);
      ad.i((String)localObject3, localObject1);
      if (localObject2 == null) {
        break label171;
      }
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwH, 24);
      ad.i(c.TAG, "needUpdate: config ".concat(String.valueOf(i)));
      if (bt.rM(((c)localObject2).field_updateTime) <= 3600L * i) {
        break label166;
      }
    }
    label166:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label171;
      }
      AppMethodBeat.o(218971);
      return;
      localObject1 = null;
      break;
    }
    label171:
    localObject1 = new bvc();
    if (this.gmm)
    {
      localObject2 = com.tencent.mm.kernel.g.ad(PluginEmoji.class);
      p.g(localObject2, "MMKernel.plugin(PluginEmoji::class.java)");
      localObject2 = ((PluginEmoji)localObject2).getEmojiMgr().abx(paramString);
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwK, 20);
      ad.i(this.TAG, "checkUpdate: shuffle " + i + ", local " + ((ArrayList)localObject2).size());
      int j = Math.min(i, ((ArrayList)localObject2).size());
      i = 0;
      while (i < j)
      {
        ((bvc)localObject1).GPp.add(((ArrayList)localObject2).get(i));
        i += 1;
      }
    }
    localObject2 = new crz();
    ((crz)localObject2).FKK = paramString;
    ((crz)localObject2).Hkv = this.username;
    ((crz)localObject2).FxN = this.sessionId;
    ((crz)localObject2).Scene = 4;
    ((crz)localObject2).Hkw = new com.tencent.mm.bx.b(((bvc)localObject1).toByteArray());
    localObject1 = new gh();
    ((gh)localObject1).pe(this.sessionId);
    ((gh)localObject1).lM(bt.flT());
    localObject3 = d.gml;
    d.ma(40);
    new com.tencent.mm.emoji.a.b((crz)localObject2).aED().g((com.tencent.mm.vending.c.a)new f.a(this, (gh)localObject1, paramString));
    AppMethodBeat.o(218971);
  }
  
  public final void a(String paramString, j.b paramb)
  {
    AppMethodBeat.i(218970);
    p.h(paramString, "desc");
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwF, false);
    ad.i(this.TAG, "searchSuggest: remoteEnable ".concat(String.valueOf(bool)));
    Object localObject1 = g.gms;
    long l = g.afI();
    localObject1 = g.gms;
    int i = g.afH();
    localObject1 = g.gms;
    m localm = new m(l, i, g.afK().size(), null, 8);
    if (!bool)
    {
      if (paramb != null)
      {
        paramb.a((List)v.MKE, localm);
        AppMethodBeat.o(218970);
        return;
      }
      AppMethodBeat.o(218970);
      return;
    }
    localObject1 = bd.frc();
    p.g(localObject1, "EmojiStorageMgr.getInstance()");
    localObject1 = ((bd)localObject1).frh().aUP(paramString);
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      ad.i(this.TAG, "searchSuggest: has cache " + ((c)localObject1).field_updateTime);
      localObject2 = d.gml;
      d.ma(32);
      localObject3 = new csa();
      localObject2 = (com.tencent.mm.bx.a)localObject3;
      localObject1 = ((c)localObject1).field_content;
    }
    label696:
    for (;;)
    {
      try
      {
        ((com.tencent.mm.bx.a)localObject2).parseFrom((byte[])localObject1);
        localObject2 = ((csa)localObject3).FxN;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        p.h(localObject1, "<set-?>");
        localm.gmB = ((String)localObject1);
        if (paramb != null)
        {
          localObject1 = ((csa)localObject3).Gxm;
          p.g(localObject1, "rsp.Emoji");
          localObject1 = (Iterable)localObject1;
          localObject2 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
          localObject3 = ((Iterable)localObject1).iterator();
          i = 0;
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = ((Iterator)localObject3).next();
            if (i < 0) {
              d.a.j.gfB();
            }
            cru localcru = (cru)localObject1;
            localObject1 = bd.frc();
            p.g(localObject1, "EmojiStorageMgr.getInstance()");
            localObject1 = ((bd)localObject1).bIW().aUK(localcru.Hkl.Md5);
            if (localObject1 != null) {
              break label696;
            }
            localObject1 = new EmojiInfo();
            com.tencent.mm.plugin.emoji.h.b.a(localcru.Hkl, (EmojiInfo)localObject1);
            ((EmojiInfo)localObject1).field_catalog = EmojiInfo.OeN;
            Object localObject4 = i.aeL();
            p.g(localObject4, "EmojiStorageCache.getInstance()");
            localObject4 = ((i)localObject4).aeN();
            p.g(localObject4, "EmojiStorageCache.getInstance().emojiGroupInfoList");
            localObject4 = (Iterable)localObject4;
            if ((!(localObject4 instanceof Collection)) || (!((Collection)localObject4).isEmpty()))
            {
              localObject4 = ((Iterable)localObject4).iterator();
              if (((Iterator)localObject4).hasNext())
              {
                EmojiGroupInfo localEmojiGroupInfo = (EmojiGroupInfo)((Iterator)localObject4).next();
                p.g(localEmojiGroupInfo, "it");
                if (!p.i(localEmojiGroupInfo.fxi(), ((EmojiInfo)localObject1).field_groupId)) {
                  continue;
                }
                j = 1;
                if (localcru.Hko != 1) {
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
        ad.l("safeParser", "", new Object[] { localException });
        continue;
        int j = 0;
        continue;
        ad.i(this.TAG, "searchSuggest: delete local emoji " + localException.Lb());
        j = 1;
        continue;
        paramb.a((List)localObject2, localm);
      }
      for (;;)
      {
        vY(paramString);
        AppMethodBeat.o(218970);
        return;
        ad.i(this.TAG, "searchSuggest: no cache");
        if (paramb != null) {
          paramb.a((List)v.MKE, localm);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.f
 * JD-Core Version:    0.7.0.1
 */