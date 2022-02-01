package com.tencent.mm.emoji.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.g.b.a.fi;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.protocal.protobuf.ads;
import com.tencent.mm.protocal.protobuf.bqp;
import com.tencent.mm.protocal.protobuf.cmr;
import com.tencent.mm.protocal.protobuf.cmw;
import com.tencent.mm.protocal.protobuf.cmx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.a.v;
import d.g.b.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestRemote;", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "TAG", "", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "remoteShuffle", "", "getRemoteShuffle", "()Z", "setRemoteShuffle", "(Z)V", "sessionId", "username", "checkMatch", "desc", "checkPrefetch", "", "rsp", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiResponse;", "checkUpdate", "searchSuggest", "callback", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "setRequestInfo", "chatId", "plugin-emojisdk_release"})
public final class f
  implements j
{
  private final String TAG;
  boolean fSI;
  private final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> fSt;
  public String sessionId;
  public String username;
  
  public f(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb)
  {
    this.fSt = paramb;
    this.TAG = "MicroMsg.EmojiSuggestMatchWord";
  }
  
  public static boolean th(String paramString)
  {
    AppMethodBeat.i(209844);
    k.h(paramString, "desc");
    g localg = g.fSO;
    boolean bool = g.tj(paramString);
    AppMethodBeat.o(209844);
    return bool;
  }
  
  private void ti(final String paramString)
  {
    AppMethodBeat.i(209846);
    k.h(paramString, "desc");
    Object localObject1 = az.faZ();
    k.g(localObject1, "EmojiStorageMgr.getInstance()");
    Object localObject2 = ((az)localObject1).fbe().aOY(paramString);
    Object localObject3 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("checkUpdate: ").append(paramString).append(", ");
    if (localObject2 != null)
    {
      localObject1 = Integer.valueOf(((c)localObject2).field_updateTime);
      ac.i((String)localObject3, localObject1);
      if (localObject2 == null) {
        break label171;
      }
      i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pSj, 24);
      ac.i(c.TAG, "needUpdate: config ".concat(String.valueOf(i)));
      if (bs.pN(((c)localObject2).field_updateTime) <= 3600L * i) {
        break label166;
      }
    }
    label166:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label171;
      }
      AppMethodBeat.o(209846);
      return;
      localObject1 = null;
      break;
    }
    label171:
    localObject1 = new bqp();
    if (this.fSI)
    {
      localObject2 = com.tencent.mm.kernel.g.ad(PluginEmoji.class);
      k.g(localObject2, "MMKernel.plugin(PluginEmoji::class.java)");
      localObject2 = ((PluginEmoji)localObject2).getEmojiMgr().XR(paramString);
      i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pSm, 20);
      ac.i(this.TAG, "checkUpdate: shuffle " + i + ", local " + ((ArrayList)localObject2).size());
      int j = Math.min(i, ((ArrayList)localObject2).size());
      i = 0;
      while (i < j)
      {
        ((bqp)localObject1).FfL.add(((ArrayList)localObject2).get(i));
        i += 1;
      }
    }
    localObject2 = new cmw();
    ((cmw)localObject2).Eel = paramString;
    ((cmw)localObject2).FAh = this.username;
    ((cmw)localObject2).DSu = this.sessionId;
    ((cmw)localObject2).Scene = 4;
    ((cmw)localObject2).FAi = new com.tencent.mm.bw.b(((bqp)localObject1).toByteArray());
    localObject1 = new fi();
    ((fi)localObject1).mR(this.sessionId);
    ((fi)localObject1).ka(bs.eWj());
    localObject3 = d.fSH;
    d.lA(40);
    new com.tencent.mm.emoji.a.b((cmw)localObject2).aBB().g((com.tencent.mm.vending.c.a)new a(this, (fi)localObject1, paramString));
    AppMethodBeat.o(209846);
  }
  
  public final void a(String paramString, j.b paramb)
  {
    AppMethodBeat.i(209845);
    k.h(paramString, "desc");
    boolean bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pSh, false);
    ac.i(this.TAG, "searchSuggest: remoteEnable ".concat(String.valueOf(bool)));
    Object localObject1 = g.fSO;
    long l = g.adb();
    localObject1 = g.fSO;
    int i = g.ada();
    localObject1 = g.fSO;
    m localm = new m(l, i, g.ade().size(), null, 8);
    if (!bool)
    {
      if (paramb != null)
      {
        paramb.a((List)v.KTF, localm);
        AppMethodBeat.o(209845);
        return;
      }
      AppMethodBeat.o(209845);
      return;
    }
    localObject1 = az.faZ();
    k.g(localObject1, "EmojiStorageMgr.getInstance()");
    localObject1 = ((az)localObject1).fbe().aOY(paramString);
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      ac.i(this.TAG, "searchSuggest: has cache " + ((c)localObject1).field_updateTime);
      localObject2 = d.fSH;
      d.lA(32);
      localObject3 = new cmx();
      localObject2 = (com.tencent.mm.bw.a)localObject3;
      localObject1 = ((c)localObject1).field_content;
    }
    label696:
    for (;;)
    {
      try
      {
        ((com.tencent.mm.bw.a)localObject2).parseFrom((byte[])localObject1);
        localObject2 = ((cmx)localObject3).DSu;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        k.h(localObject1, "<set-?>");
        localm.fSX = ((String)localObject1);
        if (paramb != null)
        {
          localObject1 = ((cmx)localObject3).EOi;
          k.g(localObject1, "rsp.Emoji");
          localObject1 = (Iterable)localObject1;
          localObject2 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
          localObject3 = ((Iterable)localObject1).iterator();
          i = 0;
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = ((Iterator)localObject3).next();
            if (i < 0) {
              d.a.j.fOc();
            }
            cmr localcmr = (cmr)localObject1;
            localObject1 = az.faZ();
            k.g(localObject1, "EmojiStorageMgr.getInstance()");
            localObject1 = ((az)localObject1).bEN().aOT(localcmr.FzX.Md5);
            if (localObject1 != null) {
              break label696;
            }
            localObject1 = new EmojiInfo();
            com.tencent.mm.plugin.emoji.h.b.a(localcmr.FzX, (EmojiInfo)localObject1);
            ((EmojiInfo)localObject1).field_catalog = EmojiInfo.Jss;
            Object localObject4 = i.ach();
            k.g(localObject4, "EmojiStorageCache.getInstance()");
            localObject4 = ((i)localObject4).acj();
            k.g(localObject4, "EmojiStorageCache.getInstance().emojiGroupInfoList");
            localObject4 = (Iterable)localObject4;
            if ((!(localObject4 instanceof Collection)) || (!((Collection)localObject4).isEmpty()))
            {
              localObject4 = ((Iterable)localObject4).iterator();
              if (((Iterator)localObject4).hasNext())
              {
                EmojiGroupInfo localEmojiGroupInfo = (EmojiGroupInfo)((Iterator)localObject4).next();
                k.g(localEmojiGroupInfo, "it");
                if (!k.g(localEmojiGroupInfo.fdm(), ((EmojiInfo)localObject1).field_groupId)) {
                  continue;
                }
                j = 1;
                if (localcmr.FAa != 1) {
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
        ac.l("safeParser", "", new Object[] { localException });
        continue;
        int j = 0;
        continue;
        ac.i(this.TAG, "searchSuggest: delete local emoji " + localException.JC());
        j = 1;
        continue;
        paramb.a((List)localObject2, localm);
      }
      for (;;)
      {
        ti(paramString);
        AppMethodBeat.o(209845);
        return;
        ac.i(this.TAG, "searchSuggest: no cache");
        if (paramb != null) {
          paramb.a((List)v.KTF, localm);
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(f paramf, fi paramfi, String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.f
 * JD-Core Version:    0.7.0.1
 */