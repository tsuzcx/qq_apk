package com.tencent.mm.emoji.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.mmdata.rpt.pg;
import com.tencent.mm.emoji.b.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.djf;
import com.tencent.mm.protocal.protobuf.eng;
import com.tencent.mm.protocal.protobuf.enq;
import com.tencent.mm.protocal.protobuf.enr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestRemote;", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "TAG", "", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "remoteShuffle", "", "getRemoteShuffle", "()Z", "setRemoteShuffle", "(Z)V", "sessionId", "username", "checkMatch", "desc", "checkPrefetch", "", "rsp", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiResponse;", "checkUpdate", "searchSuggest", "callback", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "setRequestInfo", "chatId", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements j
{
  private final String TAG;
  private final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> mjD;
  boolean mjR;
  String sessionId;
  String username;
  
  public f(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb)
  {
    this.mjD = paramb;
    this.TAG = "MicroMsg.EmojiSuggestMatchWord";
  }
  
  public static boolean Er(String paramString)
  {
    AppMethodBeat.i(242668);
    s.u(paramString, "desc");
    g localg = g.mjS;
    boolean bool = g.Et(paramString);
    AppMethodBeat.o(242668);
    return bool;
  }
  
  private void Es(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(242671);
    s.u(paramString, "desc");
    Object localObject2 = bl.jba().adjI.bzf(paramString);
    Object localObject3 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("checkUpdate: ").append(paramString).append(", ");
    if (localObject2 == null)
    {
      localObject1 = null;
      Log.i((String)localObject3, localObject1);
      if (localObject2 == null) {
        break label162;
      }
      i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRB, 24);
      Log.i(c.TAG, s.X("needUpdate: config ", Integer.valueOf(i)));
      if (Util.secondsToNow(((c)localObject2).field_updateTime) <= 3600L * i) {
        break label157;
      }
    }
    label157:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label162;
      }
      AppMethodBeat.o(242671);
      return;
      localObject1 = Integer.valueOf(((c)localObject2).field_updateTime);
      break;
    }
    label162:
    localObject2 = new djf();
    if (this.mjR)
    {
      localObject1 = ((PluginEmoji)h.az(PluginEmoji.class)).getEmojiMgr().aok(paramString);
      i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRE, 20);
      Log.i(this.TAG, "checkUpdate: shuffle " + i + ", local " + ((ArrayList)localObject1).size());
      int k = Math.min(i, ((ArrayList)localObject1).size());
      if (k > 0)
      {
        i = j;
        do
        {
          j = i + 1;
          ((djf)localObject2).aaOY.add(((ArrayList)localObject1).get(i));
          i = j;
        } while (j < k);
      }
    }
    Object localObject1 = new enq();
    ((enq)localObject1).YWK = paramString;
    ((enq)localObject1).absf = this.username;
    ((enq)localObject1).SessionId = this.sessionId;
    ((enq)localObject1).IJG = 4;
    ((enq)localObject1).absg = new com.tencent.mm.bx.b(((djf)localObject2).toByteArray());
    localObject2 = new pg();
    ((pg)localObject2).ijk = ((pg)localObject2).F("SessionId", this.sessionId, true);
    ((pg)localObject2).jlH = Util.nowMilliSecond();
    localObject3 = d.mjQ;
    d.rG(40);
    new com.tencent.mm.emoji.c.b((enq)localObject1).bFJ().g(new f..ExternalSyntheticLambda0(this, (pg)localObject2, paramString));
    AppMethodBeat.o(242671);
  }
  
  private static final Boolean a(f paramf, pg parampg, String paramString, b.a parama)
  {
    c localc = null;
    AppMethodBeat.i(242680);
    s.u(paramf, "this$0");
    s.u(parampg, "$report");
    s.u(paramString, "$desc");
    int i = parama.errType;
    int j = parama.errCode;
    enr localenr = (enr)parama.ott;
    String str = paramf.TAG;
    StringBuilder localStringBuilder = new StringBuilder("checkUpdate: cgi result: ").append(i).append(", ").append(j).append(", ");
    if (localenr == null)
    {
      parama = localc;
      Log.i(str, parama);
      parampg.jlI = Util.nowMilliSecond();
      parampg.jlK = j;
      if ((i != 0) || (j != 0)) {
        break label315;
      }
      parampg.jlJ = 1L;
      if (localenr == null) {
        break label309;
      }
      parama = localenr.aaqZ;
      if (parama == null) {
        break label309;
      }
      if (((Collection)parama).isEmpty()) {
        break label303;
      }
      i = 1;
      label170:
      if (i != 1) {
        break label309;
      }
      i = 1;
      label179:
      if (i != 0)
      {
        parama = bl.jba().adjI;
        localc = new c();
        localc.field_desc = paramString;
        localc.field_updateTime = ((int)Util.nowSecond());
        localc.field_content = localenr.toByteArray();
        paramString = ah.aiuX;
        parama.a(localc);
        s.s(localenr, "rsp");
        paramf.a(localenr);
      }
      paramf = d.mjQ;
      d.rG(41);
    }
    for (;;)
    {
      boolean bool = parampg.bMH();
      AppMethodBeat.o(242680);
      return Boolean.valueOf(bool);
      LinkedList localLinkedList = localenr.aaqZ;
      parama = localc;
      if (localLinkedList == null) {
        break;
      }
      parama = Integer.valueOf(localLinkedList.size());
      break;
      label303:
      i = 0;
      break label170;
      label309:
      i = 0;
      break label179;
      label315:
      parampg.jlJ = 2L;
    }
  }
  
  private final void a(enr paramenr)
  {
    AppMethodBeat.i(242674);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRA, 0);
    boolean bool = NetStatusUtil.isWifi(MMApplicationContext.getContext());
    Log.i(this.TAG, "checkPrefetch: config: " + i + ", isWifi: " + bool);
    if (((i == 1) && (bool)) || (i == 2))
    {
      paramenr = paramenr.aaqZ;
      if (paramenr != null)
      {
        paramenr = ((Iterable)paramenr).iterator();
        while (paramenr.hasNext())
        {
          Object localObject = (eng)paramenr.next();
          EmojiInfo localEmojiInfo = new EmojiInfo();
          com.tencent.mm.plugin.emoji.g.d.a(((eng)localObject).abrK, localEmojiInfo);
          localEmojiInfo.field_catalog = EmojiInfo.aklG;
          localObject = e.mgl;
          e.a(localEmojiInfo, null);
        }
      }
    }
    AppMethodBeat.o(242674);
  }
  
  public final void a(String paramString, j.b paramb)
  {
    AppMethodBeat.i(242692);
    s.u(paramString, "desc");
    boolean bool1 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRz, false);
    boolean bool2 = ((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
    Log.i(this.TAG, s.X("searchSuggest: remoteEnable ", Boolean.valueOf(bool1)));
    Object localObject1 = g.mjS;
    long l = g.aVD();
    localObject1 = g.mjS;
    int i = g.aVC();
    localObject1 = g.mjS;
    m localm = new m(l, i, g.aVF().size(), null, 8);
    if ((bool2) || (!bool1))
    {
      if (paramb != null) {
        paramb.a((List)ab.aivy, localm);
      }
      AppMethodBeat.o(242692);
      return;
    }
    localObject1 = bl.jba().adjI.bzf(paramString);
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      Log.i(this.TAG, s.X("searchSuggest: has cache ", Integer.valueOf(((c)localObject1).field_updateTime)));
      localObject2 = d.mjQ;
      d.rG(32);
      localObject3 = new enr();
      localObject2 = (com.tencent.mm.bx.a)localObject3;
      localObject1 = ((c)localObject1).field_content;
    }
    label639:
    for (;;)
    {
      try
      {
        ((com.tencent.mm.bx.a)localObject2).parseFrom((byte[])localObject1);
        localObject2 = ((enr)localObject3).SessionId;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localm.Eu((String)localObject1);
        if (paramb != null)
        {
          localObject1 = ((enr)localObject3).aaqZ;
          s.s(localObject1, "rsp.Emoji");
          localObject1 = (Iterable)localObject1;
          localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
          localObject3 = ((Iterable)localObject1).iterator();
          i = 0;
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = ((Iterator)localObject3).next();
            if (i < 0) {
              p.kkW();
            }
            eng localeng = (eng)localObject1;
            localObject1 = bl.jba().adju.bza(localeng.abrK.Md5);
            if (localObject1 != null) {
              break label639;
            }
            localObject1 = new EmojiInfo();
            com.tencent.mm.plugin.emoji.g.d.a(localeng.abrK, (EmojiInfo)localObject1);
            ((EmojiInfo)localObject1).field_catalog = EmojiInfo.aklG;
            Object localObject4 = com.tencent.mm.emoji.c.l.aUF().aUH();
            s.s(localObject4, "getInstance().emojiGroupInfoList");
            localObject4 = (Iterable)localObject4;
            if ((!(localObject4 instanceof Collection)) || (!((Collection)localObject4).isEmpty()))
            {
              localObject4 = ((Iterable)localObject4).iterator();
              if (((Iterator)localObject4).hasNext())
              {
                if (!s.p(((EmojiGroupInfo)((Iterator)localObject4).next()).field_productID, ((EmojiInfo)localObject1).field_groupId)) {
                  continue;
                }
                j = 1;
                if (localeng.emoji_from != 1) {
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
        Log.i(this.TAG, s.X("searchSuggest: delete local emoji ", localException.getMd5()));
        j = 1;
        continue;
        paramb.a((List)localObject2, localm);
      }
      for (;;)
      {
        Es(paramString);
        AppMethodBeat.o(242692);
        return;
        Log.i(this.TAG, "searchSuggest: no cache");
        if (paramb != null) {
          paramb.a((List)ab.aivy, localm);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.c.c.f
 * JD-Core Version:    0.7.0.1
 */