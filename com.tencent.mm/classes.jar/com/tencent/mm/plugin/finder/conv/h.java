package com.tencent.mm.plugin.finder.conv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.plugin.finder.storage.w.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.br.b;
import com.tencent.mm.storage.bv;
import d.f;
import d.g.b.p;
import d.g.b.q;
import d.z;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationUpdater;", "Lcom/tencent/mm/plugin/messenger/foundation/api/IConversationUpdateCallback;", "()V", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "sessionInfoStorage$delegate", "Lkotlin/Lazy;", "storage", "Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "getStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "storage$delegate", "afterConversationUpdate", "", "latestMsg", "Lcom/tencent/mm/storage/MsgInfo;", "conversation", "Lcom/tencent/mm/storage/Conversation;", "newCon", "", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "assemble", "newConv", "beforeConversationUpdate", "isConsumed", "", "checkInsertHolder", "onConversationMsgEmpty", "sessionId", "", "updateFinderConversation", "pDigest", "Lcom/tencent/mm/pointers/PString;", "pDigestUser", "insertCount", "", "Companion", "plugin-finder_release"})
public final class h
  implements com.tencent.mm.plugin.messenger.foundation.a.g
{
  public static final a rTX;
  private final f mto;
  private final f rTW;
  
  static
  {
    AppMethodBeat.i(201724);
    rTX = new a((byte)0);
    AppMethodBeat.o(201724);
  }
  
  public h()
  {
    AppMethodBeat.i(201723);
    this.rTW = d.g.O((d.g.a.a)c.rTZ);
    this.mto = d.g.O((d.g.a.a)d.rUa);
    AppMethodBeat.o(201723);
  }
  
  private final d cAy()
  {
    AppMethodBeat.i(201722);
    d locald = (d)this.mto.getValue();
    AppMethodBeat.o(201722);
    return locald;
  }
  
  private final w getSessionInfoStorage()
  {
    AppMethodBeat.i(201721);
    w localw = (w)this.rTW.getValue();
    AppMethodBeat.o(201721);
    return localw;
  }
  
  public final void a(bv parambv, i.c paramc, boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(201719);
    p.h(paramc, "notifyInfo");
    p.h(paramArrayOfBoolean, "isConsumed");
    Object localObject1 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
    Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).azL();
    int i;
    int j;
    boolean bool;
    if (an.aji(paramc.talker))
    {
      if ((parambv != null) && (parambv.VX() == 0L)) {
        break label889;
      }
      if (!p.i(paramc.vWi, "insert")) {
        break label551;
      }
      i = paramc.slP;
      if (parambv == null) {
        p.gkB();
      }
      localObject1 = new PString();
      PString localPString = new PString();
      Object localObject3 = new PInt();
      p.g(localObject2, "storage");
      ((br)localObject2).MV().a(parambv, (PString)localObject1, localPString, (PInt)localObject3, false);
      paramc = paramc.talker;
      p.g(paramc, "notifyInfo.talker");
      localObject3 = getSessionInfoStorage().ajt(paramc);
      localObject2 = ((j)localObject3).field_talker;
      int m = ((j)localObject3).field_type;
      int n = ((j)localObject3).field_actionPermission;
      int i1 = ((j)localObject3).field_rejectMsg;
      int i2 = ((j)localObject3).field_disableSendMsg;
      int k = n;
      j = m;
      if (m == 1) {
        if (parambv.VZ() != 1)
        {
          k = n;
          j = m;
          if (!an.aUu((String)localObject2)) {}
        }
        else
        {
          j = 2;
          k = 1;
          localObject3 = getSessionInfoStorage();
          p.g(localObject2, "talker");
          ((w)localObject3).a(paramc, (String)localObject2, 2, 1, w.b.sKa, i1, i2);
          ae.i("Finder.ConversationUpdater", "[updateFinderConversation] change type to normal. sessionId=".concat(String.valueOf(paramc)));
        }
      }
      paramc = cAy().ajn(paramc);
      if (paramc.systemRowid > 0L) {
        break label557;
      }
      bool = true;
      label310:
      m = paramc.field_unReadCount;
      paramc.field_digest = ((PString)localObject1).value;
      paramc.field_digestUser = localPString.value;
      paramc.field_updateTime = parambv.getCreateTime();
      paramc.field_digestType = String.valueOf(parambv.getType());
      paramc.field_unReadCount += i;
      paramc.field_lastMsgID = parambv.VX();
      paramc.field_isSend = parambv.VZ();
      paramc.field_status = parambv.getStatus();
      paramc.field_talker = ((String)localObject2);
      paramc.field_type = j;
      paramc.field_actionPermission = k;
      if (!an.aUu((String)localObject2)) {
        break label563;
      }
      j = 1;
      label417:
      paramc.field_scene = j;
      paramc.field_readStatus = 0;
      if (!bool) {
        break label569;
      }
      cAy().insertNotify((com.tencent.mm.sdk.e.c)paramc, false);
      cAy().doNotify(paramc.field_sessionId, 2, paramc);
      label459:
      switch (paramc.field_scene)
      {
      default: 
        label484:
        ae.i("Finder.ConversationUpdater", "[updateFinderConversation] isNew=" + bool + " beforeUnreadCount=" + m + " insertCount=" + i + ' ' + com.tencent.mm.plugin.finder.storage.e.b(paramc));
      }
    }
    for (;;)
    {
      paramArrayOfBoolean[0] = true;
      AppMethodBeat.o(201719);
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
      cAy().update(paramc.systemRowid, (com.tencent.mm.sdk.e.c)paramc, false);
      cAy().doNotify(paramc.field_sessionId, 1, paramc);
      break label459;
      if (i <= 0) {
        break label484;
      }
      if (parambv.VZ() == 0)
      {
        parambv = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        p.g(parambv, "MMKernel.plugin(PluginFinder::class.java)");
        parambv = ((PluginFinder)parambv).getRedDotManager().sax;
        localObject1 = paramc.field_sessionId;
        p.g(localObject1, "conv.field_sessionId");
        p.h(localObject1, "<set-?>");
        parambv.sah = ((String)localObject1);
      }
      parambv = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      p.g(parambv, "MMKernel.plugin(PluginFinder::class.java)");
      parambv = ((PluginFinder)parambv).getRedDotManager().sax;
      parambv.handler.removeMessages(3);
      parambv.handler.sendEmptyMessage(3);
      break label484;
      if (paramc.field_type == 1)
      {
        if (i > 0)
        {
          parambv = com.tencent.mm.kernel.g.ad(PluginFinder.class);
          p.g(parambv, "MMKernel.plugin(PluginFinder::class.java)");
          parambv = ((PluginFinder)parambv).getRedDotManager().sax;
          parambv.handler.removeMessages(2);
          parambv.handler.sendEmptyMessage(2);
        }
        parambv = cAy().ajn("findersayhisessionholder");
        parambv.field_digest = ((PString)localObject1).value;
        parambv.field_readStatus = 0;
        parambv.field_unReadCount += i;
        parambv.field_updateTime = paramc.field_updateTime;
        cAy().update(parambv.systemRowid, (com.tencent.mm.sdk.e.c)parambv, false);
        break label484;
      }
      if ((paramc.field_type != 2) || (i <= 0)) {
        break label484;
      }
      parambv = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      p.g(parambv, "MMKernel.plugin(PluginFinder::class.java)");
      parambv = ((PluginFinder)parambv).getRedDotManager().sax;
      parambv.handler.removeMessages(1);
      parambv.handler.sendEmptyMessage(1);
      break label484;
      label889:
      parambv = paramc.talker;
      p.g(parambv, "notifyInfo.talker");
      parambv = cAy().ajn(parambv);
      ae.i("Finder.ConversationUpdater", "[onConversationMsgEmpty] " + parambv.systemRowid);
      if (parambv.systemRowid > 0L)
      {
        parambv.field_digest = "";
        cAy().update(parambv.systemRowid, (com.tencent.mm.sdk.e.c)parambv, false);
        cAy().doNotify(parambv.field_sessionId, 1, parambv);
      }
    }
  }
  
  public final void a(bv parambv, au paramau, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(201720);
    p.h(paramau, "conversation");
    p.h(paramc, "notifyInfo");
    AppMethodBeat.o(201720);
  }
  
  public final void b(bv parambv, au paramau, boolean paramBoolean, i.c paramc) {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationUpdater$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class b
    extends q
    implements d.g.a.a<z>
  {
    public b(h paramh)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<w>
  {
    public static final c rTZ;
    
    static
    {
      AppMethodBeat.i(201716);
      rTZ = new c();
      AppMethodBeat.o(201716);
    }
    
    c()
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<d>
  {
    public static final d rUa;
    
    static
    {
      AppMethodBeat.i(201718);
      rUa = new d();
      AppMethodBeat.o(201718);
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