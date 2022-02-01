package com.tencent.mm.emoji.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.f.b.a.mg;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.protocal.protobuf.csd;
import com.tencent.mm.protocal.protobuf.dui;
import com.tencent.mm.protocal.protobuf.dus;
import com.tencent.mm.protocal.protobuf.dut;
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

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestRemote;", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "TAG", "", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "remoteShuffle", "", "getRemoteShuffle", "()Z", "setRemoteShuffle", "(Z)V", "sessionId", "username", "checkMatch", "desc", "checkPrefetch", "", "rsp", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiResponse;", "checkUpdate", "searchSuggest", "callback", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "setRequestInfo", "chatId", "plugin-emojisdk_release"})
public final class f
  implements j
{
  private final String TAG;
  boolean jKC;
  private final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> jKn;
  public String sessionId;
  public String username;
  
  public f(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb)
  {
    this.jKn = paramb;
    this.TAG = "MicroMsg.EmojiSuggestMatchWord";
  }
  
  public static boolean LM(String paramString)
  {
    AppMethodBeat.i(231957);
    p.k(paramString, "desc");
    g localg = g.jKI;
    boolean bool = g.LO(paramString);
    AppMethodBeat.o(231957);
    return bool;
  }
  
  private void LN(final String paramString)
  {
    AppMethodBeat.i(231962);
    p.k(paramString, "desc");
    Object localObject1 = bj.hyV();
    p.j(localObject1, "EmojiStorageMgr.getInstance()");
    Object localObject2 = ((bj)localObject1).hzb().bxP(paramString);
    Object localObject3 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("checkUpdate: ").append(paramString).append(", ");
    if (localObject2 != null)
    {
      localObject1 = Integer.valueOf(((c)localObject2).field_updateTime);
      Log.i((String)localObject3, localObject1);
      if (localObject2 == null) {
        break label171;
      }
      i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDf, 24);
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
      AppMethodBeat.o(231962);
      return;
      localObject1 = null;
      break;
    }
    label171:
    localObject1 = new csd();
    if (this.jKC)
    {
      localObject2 = h.ag(PluginEmoji.class);
      p.j(localObject2, "MMKernel.plugin(PluginEmoji::class.java)");
      localObject2 = ((PluginEmoji)localObject2).getEmojiMgr().auj(paramString);
      i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDi, 20);
      Log.i(this.TAG, "checkUpdate: shuffle " + i + ", local " + ((ArrayList)localObject2).size());
      int j = Math.min(i, ((ArrayList)localObject2).size());
      i = 0;
      while (i < j)
      {
        ((csd)localObject1).TzO.add(((ArrayList)localObject2).get(i));
        i += 1;
      }
    }
    localObject2 = new dus();
    ((dus)localObject2).RYJ = paramString;
    ((dus)localObject2).UaY = this.username;
    ((dus)localObject2).SessionId = this.sessionId;
    ((dus)localObject2).CPw = 4;
    ((dus)localObject2).UaZ = new com.tencent.mm.cd.b(((csd)localObject1).toByteArray());
    localObject1 = new mg();
    ((mg)localObject1).CJ(this.sessionId);
    ((mg)localObject1).xa(Util.nowMilliSecond());
    localObject3 = d.jKB;
    d.rE(40);
    new com.tencent.mm.emoji.b.b((dus)localObject2).bhW().g((com.tencent.mm.vending.c.a)new a(this, (mg)localObject1, paramString));
    AppMethodBeat.o(231962);
  }
  
  public final void a(String paramString, j.b paramb)
  {
    AppMethodBeat.i(231959);
    p.k(paramString, "desc");
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDd, false);
    Log.i(this.TAG, "searchSuggest: remoteEnable ".concat(String.valueOf(bool)));
    Object localObject1 = g.jKI;
    long l = g.aCG();
    localObject1 = g.jKI;
    int i = g.aCF();
    localObject1 = g.jKI;
    m localm = new m(l, i, g.aCI().size(), null, 8);
    if (!bool)
    {
      if (paramb != null)
      {
        paramb.a((List)v.aaAd, localm);
        AppMethodBeat.o(231959);
        return;
      }
      AppMethodBeat.o(231959);
      return;
    }
    localObject1 = bj.hyV();
    p.j(localObject1, "EmojiStorageMgr.getInstance()");
    localObject1 = ((bj)localObject1).hzb().bxP(paramString);
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      Log.i(this.TAG, "searchSuggest: has cache " + ((c)localObject1).field_updateTime);
      localObject2 = d.jKB;
      d.rE(32);
      localObject3 = new dut();
      localObject2 = (com.tencent.mm.cd.a)localObject3;
      localObject1 = ((c)localObject1).field_content;
    }
    label696:
    for (;;)
    {
      try
      {
        ((com.tencent.mm.cd.a)localObject2).parseFrom((byte[])localObject1);
        localObject2 = ((dut)localObject3).SessionId;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        p.k(localObject1, "<set-?>");
        localm.jKR = ((String)localObject1);
        if (paramb != null)
        {
          localObject1 = ((dut)localObject3).TdL;
          p.j(localObject1, "rsp.Emoji");
          localObject1 = (Iterable)localObject1;
          localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
          localObject3 = ((Iterable)localObject1).iterator();
          i = 0;
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = ((Iterator)localObject3).next();
            if (i < 0) {
              kotlin.a.j.iBO();
            }
            dui localdui = (dui)localObject1;
            localObject1 = bj.hyV();
            p.j(localObject1, "EmojiStorageMgr.getInstance()");
            localObject1 = ((bj)localObject1).ctY().bxK(localdui.UaH.Md5);
            if (localObject1 != null) {
              break label696;
            }
            localObject1 = new EmojiInfo();
            com.tencent.mm.plugin.emoji.i.b.a(localdui.UaH, (EmojiInfo)localObject1);
            ((EmojiInfo)localObject1).field_catalog = EmojiInfo.YCx;
            Object localObject4 = k.aBH();
            p.j(localObject4, "EmojiStorageCache.getInstance()");
            localObject4 = ((k)localObject4).aBL();
            p.j(localObject4, "EmojiStorageCache.getInstance().emojiGroupInfoList");
            localObject4 = (Iterable)localObject4;
            if ((!(localObject4 instanceof Collection)) || (!((Collection)localObject4).isEmpty()))
            {
              localObject4 = ((Iterable)localObject4).iterator();
              if (((Iterator)localObject4).hasNext())
              {
                EmojiGroupInfo localEmojiGroupInfo = (EmojiGroupInfo)((Iterator)localObject4).next();
                p.j(localEmojiGroupInfo, "it");
                if (!p.h(localEmojiGroupInfo.hBl(), ((EmojiInfo)localObject1).field_groupId)) {
                  continue;
                }
                j = 1;
                if (localdui.emoji_from != 1) {
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
        LN(paramString);
        AppMethodBeat.o(231959);
        return;
        Log.i(this.TAG, "searchSuggest: no cache");
        if (paramb != null) {
          paramb.a((List)v.aaAd, localm);
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(f paramf, mg parammg, String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c.f
 * JD-Core Version:    0.7.0.1
 */