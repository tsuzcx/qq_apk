package com.tencent.mm.plugin.finder.conv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.af;
import com.tencent.mm.plugin.finder.storage.af.b;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.bw.b;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationUpdater;", "Lcom/tencent/mm/plugin/messenger/foundation/api/IConversationUpdateCallback;", "()V", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "sessionInfoStorage$delegate", "Lkotlin/Lazy;", "storage", "Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "getStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "storage$delegate", "afterConversationUpdate", "", "latestMsg", "Lcom/tencent/mm/storage/MsgInfo;", "conversation", "Lcom/tencent/mm/storage/Conversation;", "newCon", "", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "assemble", "newConv", "beforeConversationUpdate", "isConsumed", "", "checkInsertAliasHoder", "checkInsertHolder", "checkInsertHolderInternal", "onConversationMsgEmpty", "sessionId", "", "updateFinderConversation", "pDigest", "Lcom/tencent/mm/pointers/PString;", "pDigestUser", "insertCount", "", "Companion", "plugin-finder_release"})
public final class j
  implements i
{
  public static final a xgC;
  private final kotlin.f pTX;
  private final kotlin.f xgB;
  
  static
  {
    AppMethodBeat.i(272827);
    xgC = new a((byte)0);
    AppMethodBeat.o(272827);
  }
  
  public j()
  {
    AppMethodBeat.i(272826);
    this.xgB = kotlin.g.ar((kotlin.g.a.a)c.xgE);
    this.pTX = kotlin.g.ar((kotlin.g.a.a)d.xgF);
    AppMethodBeat.o(272826);
  }
  
  private final void dpo()
  {
    AppMethodBeat.i(272816);
    Object localObject1 = h.ae(n.class);
    p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
    localObject1 = ((n)localObject1).bbR();
    Object localObject2 = new LinkedList();
    ((LinkedList)localObject2).add("finderaliassessionholder");
    ((bw)localObject1).ch((LinkedList)localObject2);
    localObject1 = dpq().aEG("finderaliassessionholder");
    if (((d)localObject1).systemRowid < 0L)
    {
      localObject2 = new d();
      ((d)localObject2).field_sessionId = "finderaliassessionholder";
      ((d)localObject2).field_talker = "finderaliassessionholder";
      ((d)localObject2).field_type = 200;
      ((d)localObject2).field_scene = 1;
      ((d)localObject2).field_unReadCount = dpq().gV(2, 3);
      dpq().insert((IAutoDBItem)localObject2);
    }
    Log.i("Finder.ConversationUpdater", "[checkInsertHolder] " + com.tencent.mm.plugin.finder.storage.g.b((d)localObject1));
    AppMethodBeat.o(272816);
  }
  
  private final void dpp()
  {
    AppMethodBeat.i(272817);
    Object localObject1 = h.ae(n.class);
    p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
    localObject1 = ((n)localObject1).bbR();
    Object localObject2 = new LinkedList();
    ((LinkedList)localObject2).add("findersessionholder");
    ((bw)localObject1).ch((LinkedList)localObject2);
    localObject1 = dpq().aEG("findersayhisessionholder");
    if (((d)localObject1).systemRowid < 0L)
    {
      localObject2 = new d();
      ((d)localObject2).field_sessionId = "findersayhisessionholder";
      ((d)localObject2).field_talker = "findersayhisessionholder";
      ((d)localObject2).field_placedFlag = 1000L;
      ((d)localObject2).field_type = 100;
      ((d)localObject2).field_scene = 2;
      ((d)localObject2).field_unReadCount = dpq().gV(2, 1);
      dpq().insert((IAutoDBItem)localObject2);
    }
    Log.i("Finder.ConversationUpdater", "[checkInsertHolder] " + com.tencent.mm.plugin.finder.storage.g.b((d)localObject1));
    AppMethodBeat.o(272817);
  }
  
  private final com.tencent.mm.plugin.finder.storage.f dpq()
  {
    AppMethodBeat.i(272825);
    com.tencent.mm.plugin.finder.storage.f localf = (com.tencent.mm.plugin.finder.storage.f)this.pTX.getValue();
    AppMethodBeat.o(272825);
    return localf;
  }
  
  private final af getSessionInfoStorage()
  {
    AppMethodBeat.i(272824);
    af localaf = (af)this.xgB.getValue();
    AppMethodBeat.o(272824);
    return localaf;
  }
  
  public final void a(ca paramca, i.c paramc, boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(272821);
    p.k(paramc, "notifyInfo");
    p.k(paramArrayOfBoolean, "isConsumed");
    Object localObject1 = h.ae(n.class);
    p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
    Object localObject3 = ((n)localObject1).bbR();
    int j;
    int i;
    boolean bool;
    if (as.aEF(paramc.talker))
    {
      if ((paramca != null) && (paramca.apG() == 0L)) {
        break label1178;
      }
      if (!p.h(paramc.EVM, "insert")) {
        break label651;
      }
      j = paramc.xKO;
      if (paramca == null) {
        p.iCn();
      }
      localObject1 = new PString();
      Object localObject2 = new PString();
      Object localObject4 = new PInt();
      p.j(localObject3, "storage");
      ((bw)localObject3).abK().a(paramca, (PString)localObject1, (PString)localObject2, (PInt)localObject4, false);
      paramc = paramc.talker;
      p.j(paramc, "notifyInfo.talker");
      Object localObject5 = getSessionInfoStorage().aEN(paramc);
      localObject3 = ((l)localObject5).field_talker;
      int m = ((l)localObject5).field_type;
      int n = ((l)localObject5).field_actionPermission;
      int i2 = ((l)localObject5).field_rejectMsg;
      int i3 = ((l)localObject5).field_disableSendMsg;
      localObject4 = ((l)localObject5).field_senderUserName;
      int i1 = ((l)localObject5).field_senderRoleType;
      int k = n;
      i = m;
      if (m == 1) {
        if (paramca.apA() != 1)
        {
          k = n;
          i = m;
          if (!p.h(localObject4, z.bcZ())) {}
        }
        else
        {
          i = 2;
          k = 1;
          localObject5 = getSessionInfoStorage();
          p.j(localObject3, "talker");
          af.b localb = af.b.Amw;
          p.j(localObject4, "senderUserName");
          ((af)localObject5).a(paramc, (String)localObject3, 2, 1, localb, i2, i3, (String)localObject4);
          Log.i("Finder.ConversationUpdater", "[updateFinderConversation] change type to normal. sessionId=".concat(String.valueOf(paramc)));
        }
      }
      paramc = dpq().aEG(paramc);
      if (paramc.systemRowid > 0L) {
        break label657;
      }
      bool = true;
      label346:
      m = paramc.field_unReadCount;
      paramc.field_digest = ((PString)localObject1).value;
      paramc.field_digestUser = ((PString)localObject2).value;
      paramc.field_updateTime = paramca.getCreateTime();
      paramc.field_digestType = String.valueOf(paramca.getType());
      paramc.field_unReadCount += j;
      paramc.field_lastMsgID = paramca.apG();
      paramc.field_isSend = paramca.apA();
      paramc.field_status = paramca.getStatus();
      paramc.field_talker = ((String)localObject3);
      paramc.field_type = i;
      paramc.field_actionPermission = k;
      paramc.field_senderUserName = ((String)localObject4);
      paramc.field_senderRoleType = i1;
      if (!as.bvP((String)localObject3)) {
        break label669;
      }
      if ((!p.h(localObject4, z.bcZ())) && (!p.h(localObject4, z.bdi()))) {
        break label663;
      }
      i = 1;
      label487:
      paramc.field_scene = i;
      paramc.field_readStatus = 0;
      localObject2 = h.aHG();
      p.j(localObject2, "MMKernel.storage()");
      paramc.field_senderUserNameVersion = ((com.tencent.mm.kernel.f)localObject2).aHp().getInt(ar.a.Vzd, 0);
      if (!bool) {
        break label675;
      }
      dpq().insertNotify((IAutoDBItem)paramc, false);
      dpq().doNotify(paramc.field_sessionId, 2, paramc);
      label558:
      switch (paramc.field_scene)
      {
      default: 
        Log.i("Finder.ConversationUpdater", "[updateFinderConversation] isNew=" + bool + " beforeUnreadCount=" + m + " insertCount=" + j + ' ' + com.tencent.mm.plugin.finder.storage.g.b(paramc));
      }
    }
    for (;;)
    {
      paramArrayOfBoolean[0] = true;
      AppMethodBeat.o(272821);
      return;
      label651:
      j = 0;
      break;
      label657:
      bool = false;
      break label346;
      label663:
      i = 2;
      break label487;
      label669:
      i = 2;
      break label487;
      label675:
      dpq().update(paramc.systemRowid, (IAutoDBItem)paramc, false);
      dpq().doNotify(paramc.field_sessionId, 1, paramc);
      break label558;
      switch (paramc.field_type)
      {
      default: 
        break;
      case 2: 
        if (j <= 0) {
          break;
        }
        if (paramca.apA() == 0)
        {
          paramca = h.ag(PluginFinder.class);
          p.j(paramca, "MMKernel.plugin(PluginFinder::class.java)");
          paramca = ((PluginFinder)paramca).getRedDotManager().xsM;
          localObject1 = paramc.field_sessionId;
          p.j(localObject1, "conv.field_sessionId");
          p.k(localObject1, "<set-?>");
          paramca.xsp = ((String)localObject1);
        }
        paramca = h.ag(PluginFinder.class);
        p.j(paramca, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)paramca).getRedDotManager().xsM.dqv();
        break;
      case 3: 
        dpo();
        paramca = dpq().aEG("finderaliassessionholder");
        paramca.field_digest = ((PString)localObject1).value;
        paramca.field_readStatus = 0;
        paramca.field_unReadCount += j;
        paramca.field_updateTime = paramc.field_updateTime;
        dpq().update(paramca.systemRowid, (IAutoDBItem)paramca, false);
        if (j <= 0) {
          break;
        }
        paramca = h.ag(PluginFinder.class);
        p.j(paramca, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)paramca).getRedDotManager().xsM.dqv();
        break;
        switch (paramc.field_type)
        {
        default: 
          break;
        case 1: 
          if ((j > 0) && (as.bvP(paramc.field_senderUserName)))
          {
            paramca = aj.AGc;
            paramca = paramc.field_senderUserName;
            p.j(paramca, "conv.field_senderUserName");
            if (aj.aFV(paramca))
            {
              paramca = h.ag(PluginFinder.class);
              p.j(paramca, "MMKernel.plugin(PluginFinder::class.java)");
              paramca = ((PluginFinder)paramca).getRedDotManager().xsM;
              paramca.handler.removeMessages(2);
              paramca.handler.sendEmptyMessage(2);
            }
          }
          dpp();
          paramca = dpq().aEG("findersayhisessionholder");
          paramca.field_digest = ((PString)localObject1).value;
          paramca.field_readStatus = 0;
          paramca.field_unReadCount += j;
          paramca.field_updateTime = paramc.field_updateTime;
          dpq().update(paramca.systemRowid, (IAutoDBItem)paramca, false);
          break;
        case 2: 
          if ((j <= 0) || (!as.bvP(paramc.field_senderUserName))) {
            break;
          }
          paramca = aj.AGc;
          paramca = paramc.field_senderUserName;
          p.j(paramca, "conv.field_senderUserName");
          if (!aj.aFV(paramca)) {
            break;
          }
          paramca = h.ag(PluginFinder.class);
          p.j(paramca, "MMKernel.plugin(PluginFinder::class.java)");
          ((PluginFinder)paramca).getRedDotManager().xsM.dqu();
          break;
          label1178:
          paramca = paramc.talker;
          p.j(paramca, "notifyInfo.talker");
          paramca = dpq().aEG(paramca);
          Log.i("Finder.ConversationUpdater", "[onConversationMsgEmpty] " + paramca.systemRowid);
          if (paramca.systemRowid > 0L)
          {
            paramca.field_digest = "";
            dpq().update(paramca.systemRowid, (IAutoDBItem)paramca, false);
            dpq().doNotify(paramca.field_sessionId, 1, paramca);
          }
          break;
        }
        break;
      }
    }
  }
  
  public final void a(ca paramca, az paramaz, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(272823);
    p.k(paramaz, "conversation");
    p.k(paramc, "notifyInfo");
    AppMethodBeat.o(272823);
  }
  
  public final void b(ca paramca, az paramaz, boolean paramBoolean, i.c paramc) {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationUpdater$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    public b(j paramj)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<af>
  {
    public static final c xgE;
    
    static
    {
      AppMethodBeat.i(226099);
      xgE = new c();
      AppMethodBeat.o(226099);
    }
    
    c()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.storage.f>
  {
    public static final d xgF;
    
    static
    {
      AppMethodBeat.i(291142);
      xgF = new d();
      AppMethodBeat.o(291142);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.j
 * JD-Core Version:    0.7.0.1
 */