package com.tencent.mm.plugin.finder.conv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.plugin.finder.storage.w.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bq.b;
import com.tencent.mm.storage.bu;
import d.f;
import d.g.b.p;
import d.g.b.q;
import d.z;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationUpdater;", "Lcom/tencent/mm/plugin/messenger/foundation/api/IConversationUpdateCallback;", "()V", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "sessionInfoStorage$delegate", "Lkotlin/Lazy;", "storage", "Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "getStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "storage$delegate", "afterConversationUpdate", "", "latestMsg", "Lcom/tencent/mm/storage/MsgInfo;", "conversation", "Lcom/tencent/mm/storage/Conversation;", "newCon", "", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "assemble", "newConv", "beforeConversationUpdate", "isConsumed", "", "checkInsertHolder", "onConversationMsgEmpty", "sessionId", "", "updateFinderConversation", "pDigest", "Lcom/tencent/mm/pointers/PString;", "pDigestUser", "insertCount", "", "Companion", "plugin-finder_release"})
public final class h
  implements com.tencent.mm.plugin.messenger.foundation.a.g
{
  public static final a rLK;
  private final f moq;
  private final f rLJ;
  
  static
  {
    AppMethodBeat.i(201297);
    rLK = new a((byte)0);
    AppMethodBeat.o(201297);
  }
  
  public h()
  {
    AppMethodBeat.i(201296);
    this.rLJ = d.g.O((d.g.a.a)c.rLM);
    this.moq = d.g.O((d.g.a.a)d.rLN);
    AppMethodBeat.o(201296);
  }
  
  private final d cyU()
  {
    AppMethodBeat.i(201295);
    d locald = (d)this.moq.getValue();
    AppMethodBeat.o(201295);
    return locald;
  }
  
  private final w getSessionInfoStorage()
  {
    AppMethodBeat.i(201294);
    w localw = (w)this.rLJ.getValue();
    AppMethodBeat.o(201294);
    return localw;
  }
  
  public final void a(bu parambu, i.c paramc, boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(201292);
    p.h(paramc, "notifyInfo");
    p.h(paramArrayOfBoolean, "isConsumed");
    Object localObject1 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
    Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).azv();
    int i;
    int j;
    boolean bool;
    if (am.ail(paramc.talker))
    {
      if ((parambu != null) && (parambu.VP() == 0L)) {
        break label889;
      }
      if (!p.i(paramc.vKe, "insert")) {
        break label551;
      }
      i = paramc.scY;
      if (parambu == null) {
        p.gfZ();
      }
      localObject1 = new PString();
      PString localPString = new PString();
      Object localObject3 = new PInt();
      p.g(localObject2, "storage");
      ((bq)localObject2).Na().a(parambu, (PString)localObject1, localPString, (PInt)localObject3, false);
      paramc = paramc.talker;
      p.g(paramc, "notifyInfo.talker");
      localObject3 = getSessionInfoStorage().aiw(paramc);
      localObject2 = ((j)localObject3).field_talker;
      int m = ((j)localObject3).field_type;
      int n = ((j)localObject3).field_actionPermission;
      int i1 = ((j)localObject3).field_rejectMsg;
      int i2 = ((j)localObject3).field_disableSendMsg;
      int k = n;
      j = m;
      if (m == 1) {
        if (parambu.VR() != 1)
        {
          k = n;
          j = m;
          if (!am.aSU((String)localObject2)) {}
        }
        else
        {
          j = 2;
          k = 1;
          localObject3 = getSessionInfoStorage();
          p.g(localObject2, "talker");
          ((w)localObject3).a(paramc, (String)localObject2, 2, 1, w.b.szj, i1, i2);
          ad.i("Finder.ConversationUpdater", "[updateFinderConversation] change type to normal. sessionId=".concat(String.valueOf(paramc)));
        }
      }
      paramc = cyU().aiq(paramc);
      if (paramc.systemRowid > 0L) {
        break label557;
      }
      bool = true;
      label310:
      m = paramc.field_unReadCount;
      paramc.field_digest = ((PString)localObject1).value;
      paramc.field_digestUser = localPString.value;
      paramc.field_updateTime = parambu.getCreateTime();
      paramc.field_digestType = String.valueOf(parambu.getType());
      paramc.field_unReadCount += i;
      paramc.field_lastMsgID = parambu.VP();
      paramc.field_isSend = parambu.VR();
      paramc.field_status = parambu.getStatus();
      paramc.field_talker = ((String)localObject2);
      paramc.field_type = j;
      paramc.field_actionPermission = k;
      if (!am.aSU((String)localObject2)) {
        break label563;
      }
      j = 1;
      label417:
      paramc.field_scene = j;
      paramc.field_readStatus = 0;
      if (!bool) {
        break label569;
      }
      cyU().insertNotify((com.tencent.mm.sdk.e.c)paramc, false);
      cyU().doNotify(paramc.field_sessionId, 2, paramc);
      label459:
      switch (paramc.field_scene)
      {
      default: 
        label484:
        ad.i("Finder.ConversationUpdater", "[updateFinderConversation] isNew=" + bool + " beforeUnreadCount=" + m + " insertCount=" + i + ' ' + com.tencent.mm.plugin.finder.storage.e.b(paramc));
      }
    }
    for (;;)
    {
      paramArrayOfBoolean[0] = true;
      AppMethodBeat.o(201292);
      return;
      label551:
      i = 0;
      break;
      label557:
      bool = false;
      break label310;
      label563:
      j = 2;
      break label417;
      label569:
      cyU().update(paramc.systemRowid, (com.tencent.mm.sdk.e.c)paramc, false);
      cyU().doNotify(paramc.field_sessionId, 1, paramc);
      break label459;
      if (i <= 0) {
        break label484;
      }
      if (parambu.VR() == 0)
      {
        parambu = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        p.g(parambu, "MMKernel.plugin(PluginFinder::class.java)");
        parambu = ((PluginFinder)parambu).getRedDotManager().rRV;
        localObject1 = paramc.field_sessionId;
        p.g(localObject1, "conv.field_sessionId");
        p.h(localObject1, "<set-?>");
        parambu.rRF = ((String)localObject1);
      }
      parambu = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      p.g(parambu, "MMKernel.plugin(PluginFinder::class.java)");
      parambu = ((PluginFinder)parambu).getRedDotManager().rRV;
      parambu.handler.removeMessages(3);
      parambu.handler.sendEmptyMessage(3);
      break label484;
      if (paramc.field_type == 1)
      {
        if (i > 0)
        {
          parambu = com.tencent.mm.kernel.g.ad(PluginFinder.class);
          p.g(parambu, "MMKernel.plugin(PluginFinder::class.java)");
          parambu = ((PluginFinder)parambu).getRedDotManager().rRV;
          parambu.handler.removeMessages(2);
          parambu.handler.sendEmptyMessage(2);
        }
        parambu = cyU().aiq("findersayhisessionholder");
        parambu.field_digest = ((PString)localObject1).value;
        parambu.field_readStatus = 0;
        parambu.field_unReadCount += i;
        parambu.field_updateTime = paramc.field_updateTime;
        cyU().update(parambu.systemRowid, (com.tencent.mm.sdk.e.c)parambu, false);
        break label484;
      }
      if ((paramc.field_type != 2) || (i <= 0)) {
        break label484;
      }
      parambu = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      p.g(parambu, "MMKernel.plugin(PluginFinder::class.java)");
      parambu = ((PluginFinder)parambu).getRedDotManager().rRV;
      parambu.handler.removeMessages(1);
      parambu.handler.sendEmptyMessage(1);
      break label484;
      label889:
      parambu = paramc.talker;
      p.g(parambu, "notifyInfo.talker");
      parambu = cyU().aiq(parambu);
      ad.i("Finder.ConversationUpdater", "[onConversationMsgEmpty] " + parambu.systemRowid);
      if (parambu.systemRowid > 0L)
      {
        parambu.field_digest = "";
        cyU().update(parambu.systemRowid, (com.tencent.mm.sdk.e.c)parambu, false);
        cyU().doNotify(parambu.field_sessionId, 1, parambu);
      }
    }
  }
  
  public final void a(bu parambu, at paramat, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(201293);
    p.h(paramat, "conversation");
    p.h(paramc, "notifyInfo");
    AppMethodBeat.o(201293);
  }
  
  public final void b(bu parambu, at paramat, boolean paramBoolean, i.c paramc) {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationUpdater$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  public static final class b
    extends q
    implements d.g.a.a<z>
  {
    public b(h paramh)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<w>
  {
    public static final c rLM;
    
    static
    {
      AppMethodBeat.i(201289);
      rLM = new c();
      AppMethodBeat.o(201289);
    }
    
    c()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<d>
  {
    public static final d rLN;
    
    static
    {
      AppMethodBeat.i(201291);
      rLN = new d();
      AppMethodBeat.o(201291);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.h
 * JD-Core Version:    0.7.0.1
 */