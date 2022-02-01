package com.tencent.mm.plugin.finder.conv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.ag;
import com.tencent.mm.plugin.finder.storage.ag.b;
import com.tencent.mm.plugin.finder.storage.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.bw.b;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationUpdater;", "Lcom/tencent/mm/plugin/messenger/foundation/api/IConversationUpdateCallback;", "()V", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "sessionInfoStorage$delegate", "Lkotlin/Lazy;", "storage", "Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "getStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "storage$delegate", "afterConversationUpdate", "", "latestMsg", "Lcom/tencent/mm/storage/MsgInfo;", "conversation", "Lcom/tencent/mm/storage/Conversation;", "newCon", "", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "assemble", "newConv", "beforeConversationUpdate", "isConsumed", "", "checkInsertHolder", "checkInsertHolderInternal", "onConversationMsgEmpty", "sessionId", "", "updateFinderConversation", "pDigest", "Lcom/tencent/mm/pointers/PString;", "pDigestUser", "insertCount", "", "Companion", "plugin-finder_release"})
public final class i
  implements com.tencent.mm.plugin.messenger.foundation.a.g
{
  public static final a tyS;
  private final kotlin.f nDW;
  private final kotlin.f tyR;
  
  static
  {
    AppMethodBeat.i(242759);
    tyS = new a((byte)0);
    AppMethodBeat.o(242759);
  }
  
  public i()
  {
    AppMethodBeat.i(242758);
    this.tyR = kotlin.g.ah((kotlin.g.a.a)c.tyU);
    this.nDW = kotlin.g.ah((kotlin.g.a.a)d.tyV);
    AppMethodBeat.o(242758);
  }
  
  private final void cZy()
  {
    AppMethodBeat.i(242753);
    Object localObject1 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).aST();
    Object localObject2 = new LinkedList();
    ((LinkedList)localObject2).add("findersessionholder");
    ((bw)localObject1).bI((LinkedList)localObject2);
    localObject1 = cZz().avq("findersayhisessionholder");
    if (((c)localObject1).systemRowid < 0L)
    {
      localObject2 = new c();
      ((c)localObject2).field_sessionId = "findersayhisessionholder";
      ((c)localObject2).field_talker = "findersayhisessionholder";
      ((c)localObject2).field_placedFlag = 1000L;
      ((c)localObject2).field_type = 100;
      ((c)localObject2).field_scene = 2;
      ((c)localObject2).field_unReadCount = cZz().gk(2, 1);
      cZz().insert((IAutoDBItem)localObject2);
    }
    Log.i("Finder.ConversationUpdater", "[checkInsertHolder] " + com.tencent.mm.plugin.finder.storage.f.b((c)localObject1));
    AppMethodBeat.o(242753);
  }
  
  private final e cZz()
  {
    AppMethodBeat.i(242757);
    e locale = (e)this.nDW.getValue();
    AppMethodBeat.o(242757);
    return locale;
  }
  
  private final ag getSessionInfoStorage()
  {
    AppMethodBeat.i(242756);
    ag localag = (ag)this.tyR.getValue();
    AppMethodBeat.o(242756);
    return localag;
  }
  
  public final void a(ca paramca, com.tencent.mm.plugin.messenger.foundation.a.a.i.c paramc, boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(242754);
    p.h(paramc, "notifyInfo");
    p.h(paramArrayOfBoolean, "isConsumed");
    Object localObject1 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
    Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).aST();
    int i;
    int j;
    boolean bool;
    if (as.avl(paramc.talker))
    {
      if ((paramca != null) && (paramca.ajL() == 0L)) {
        break label885;
      }
      if (!p.j(paramc.zqn, "insert")) {
        break label559;
      }
      i = paramc.tYD;
      if (paramca == null) {
        p.hyc();
      }
      localObject1 = new PString();
      PString localPString = new PString();
      Object localObject3 = new PInt();
      p.g(localObject2, "storage");
      ((bw)localObject2).Xh().a(paramca, (PString)localObject1, localPString, (PInt)localObject3, false);
      paramc = paramc.talker;
      p.g(paramc, "notifyInfo.talker");
      localObject3 = getSessionInfoStorage().avz(paramc);
      localObject2 = ((k)localObject3).field_talker;
      int m = ((k)localObject3).field_type;
      int n = ((k)localObject3).field_actionPermission;
      int i1 = ((k)localObject3).field_rejectMsg;
      int i2 = ((k)localObject3).field_disableSendMsg;
      int k = n;
      j = m;
      if (m == 1) {
        if (paramca.ajN() != 1)
        {
          k = n;
          j = m;
          if (!as.bjt((String)localObject2)) {}
        }
        else
        {
          j = 2;
          k = 1;
          localObject3 = getSessionInfoStorage();
          p.g(localObject2, "talker");
          ((ag)localObject3).a(paramc, (String)localObject2, 2, 1, ag.b.vFf, i1, i2);
          Log.i("Finder.ConversationUpdater", "[updateFinderConversation] change type to normal. sessionId=".concat(String.valueOf(paramc)));
        }
      }
      paramc = cZz().avq(paramc);
      if (paramc.systemRowid > 0L) {
        break label565;
      }
      bool = true;
      label315:
      m = paramc.field_unReadCount;
      paramc.field_digest = ((PString)localObject1).value;
      paramc.field_digestUser = localPString.value;
      paramc.field_updateTime = paramca.getCreateTime();
      paramc.field_digestType = String.valueOf(paramca.getType());
      paramc.field_unReadCount += i;
      paramc.field_lastMsgID = paramca.ajL();
      paramc.field_isSend = paramca.ajN();
      paramc.field_status = paramca.getStatus();
      paramc.field_talker = ((String)localObject2);
      paramc.field_type = j;
      paramc.field_actionPermission = k;
      if (!as.bjt((String)localObject2)) {
        break label571;
      }
      j = 1;
      label422:
      paramc.field_scene = j;
      paramc.field_readStatus = 0;
      if (!bool) {
        break label577;
      }
      cZz().insertNotify((IAutoDBItem)paramc, false);
      cZz().doNotify(paramc.field_sessionId, 2, paramc);
      label464:
      switch (paramc.field_scene)
      {
      default: 
        label492:
        Log.i("Finder.ConversationUpdater", "[updateFinderConversation] isNew=" + bool + " beforeUnreadCount=" + m + " insertCount=" + i + ' ' + com.tencent.mm.plugin.finder.storage.f.b(paramc));
      }
    }
    for (;;)
    {
      paramArrayOfBoolean[0] = true;
      AppMethodBeat.o(242754);
      return;
      label559:
      i = 0;
      break;
      label565:
      bool = false;
      break label315;
      label571:
      j = 2;
      break label422;
      label577:
      cZz().update(paramc.systemRowid, (IAutoDBItem)paramc, false);
      cZz().doNotify(paramc.field_sessionId, 1, paramc);
      break label464;
      if (i <= 0) {
        break label492;
      }
      if (paramca.ajN() == 0)
      {
        paramca = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(paramca, "MMKernel.plugin(PluginFinder::class.java)");
        paramca = ((PluginFinder)paramca).getRedDotManager().tJB;
        localObject1 = paramc.field_sessionId;
        p.g(localObject1, "conv.field_sessionId");
        p.h(localObject1, "<set-?>");
        paramca.tJg = ((String)localObject1);
      }
      paramca = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(paramca, "MMKernel.plugin(PluginFinder::class.java)");
      paramca = ((PluginFinder)paramca).getRedDotManager().tJB;
      paramca.handler.removeMessages(3);
      paramca.handler.sendEmptyMessage(3);
      break label492;
      if (paramc.field_type == 1)
      {
        if (i > 0)
        {
          paramca = com.tencent.mm.kernel.g.ah(PluginFinder.class);
          p.g(paramca, "MMKernel.plugin(PluginFinder::class.java)");
          paramca = ((PluginFinder)paramca).getRedDotManager().tJB;
          paramca.handler.removeMessages(2);
          paramca.handler.sendEmptyMessage(2);
        }
        cZy();
        paramca = cZz().avq("findersayhisessionholder");
        paramca.field_digest = ((PString)localObject1).value;
        paramca.field_readStatus = 0;
        paramca.field_unReadCount += i;
        paramca.field_updateTime = paramc.field_updateTime;
        cZz().update(paramca.systemRowid, (IAutoDBItem)paramca, false);
        break label492;
      }
      if ((paramc.field_type != 2) || (i <= 0)) {
        break label492;
      }
      paramca = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(paramca, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)paramca).getRedDotManager().tJB.dau();
      break label492;
      label885:
      paramca = paramc.talker;
      p.g(paramca, "notifyInfo.talker");
      paramca = cZz().avq(paramca);
      Log.i("Finder.ConversationUpdater", "[onConversationMsgEmpty] " + paramca.systemRowid);
      if (paramca.systemRowid > 0L)
      {
        paramca.field_digest = "";
        cZz().update(paramca.systemRowid, (IAutoDBItem)paramca, false);
        cZz().doNotify(paramca.field_sessionId, 1, paramca);
      }
    }
  }
  
  public final void a(ca paramca, az paramaz, boolean paramBoolean, com.tencent.mm.plugin.messenger.foundation.a.a.i.c paramc)
  {
    AppMethodBeat.i(242755);
    p.h(paramaz, "conversation");
    p.h(paramc, "notifyInfo");
    AppMethodBeat.o(242755);
  }
  
  public final void b(ca paramca, az paramaz, boolean paramBoolean, com.tencent.mm.plugin.messenger.foundation.a.a.i.c paramc) {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationUpdater$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    public b(i parami)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<ag>
  {
    public static final c tyU;
    
    static
    {
      AppMethodBeat.i(242750);
      tyU = new c();
      AppMethodBeat.o(242750);
    }
    
    c()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<e>
  {
    public static final d tyV;
    
    static
    {
      AppMethodBeat.i(242752);
      tyV = new d();
      AppMethodBeat.o(242752);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.i
 * JD-Core Version:    0.7.0.1
 */