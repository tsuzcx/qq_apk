package com.tencent.mm.plugin.gamelife.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.hl;
import com.tencent.mm.by.a.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.game.api.c.b;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.d.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationPresenter;", "Lcom/tencent/mm/plugin/gamelife/ui/IGameLifeContract$IConversationPresenter;", "view", "Lcom/tencent/mm/plugin/gamelife/ui/IGameLifeContract$IConversationView;", "adapter", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter;", "(Lcom/tencent/mm/plugin/gamelife/ui/IGameLifeContract$IConversationView;Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter;)V", "conversationService", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeConversationService;", "kotlin.jvm.PlatformType", "conversationStorage", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationStorage;", "isInitialOnResume", "", "onConversationStorageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "onGameLifeContactStorageChange", "onItemClickListener", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationPresenter$onItemClickListener$1", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationPresenter$onItemClickListener$1;", "checkEmpty", "", "checkHistoryConversation", "loadInitial", "modifyChange", "obj", "", "onCreate", "onDestroy", "onLoadMore", "onResume", "refreshGameCenterMsg", "reportAllVisibleItems", "range", "Lkotlin/Pair;", "", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e.a Jck;
  private final com.tencent.mm.plugin.gamelife.f.e IZf;
  h.a Jcl;
  final b Jcm;
  private boolean Jcn;
  final com.tencent.mm.plugin.gamelife.a.c Jco;
  final i Jcp;
  final MStorage.IOnStorageChange Jcq;
  final MStorage.IOnStorageChange Jcr;
  
  static
  {
    AppMethodBeat.i(267998);
    Jck = new e.a((byte)0);
    AppMethodBeat.o(267998);
  }
  
  public e(h.a parama, b paramb)
  {
    AppMethodBeat.i(267907);
    this.Jcl = parama;
    this.Jcm = paramb;
    this.Jcn = true;
    this.Jco = ((com.tencent.mm.plugin.gamelife.a.c)h.ax(com.tencent.mm.plugin.gamelife.a.c.class));
    this.IZf = ((PluginGameLife)h.az(PluginGameLife.class)).getConversationStorage();
    this.Jcp = new i(this);
    this.Jcq = new e..ExternalSyntheticLambda1(this);
    this.Jcr = new e..ExternalSyntheticLambda2(this);
    AppMethodBeat.o(267907);
  }
  
  private static final void a(e parame, c.b paramb)
  {
    AppMethodBeat.i(267965);
    s.u(parame, "this$0");
    if (paramb == null)
    {
      Log.i("GameLife.ConversationPresenter", "checkHistoryConversation gameLifeHistoryNode null");
      AppMethodBeat.o(267965);
      return;
    }
    if (paramb.Icz)
    {
      com.tencent.mm.plugin.gamelife.f.a locala = parame.IZf.fIu();
      int i = paramb.IcA;
      Log.i("GameLife.ConversationPresenter", "checkHistoryConversation sysrowid: " + locala.systemRowid + " old: " + locala.field_unReadCount + " new: " + i);
      if (locala.field_unReadCount == 2147483647)
      {
        AppMethodBeat.o(267965);
        return;
      }
      if ((locala.systemRowid > 0L) && (i <= locala.field_unReadCount))
      {
        locala.field_unReadCount = i;
        parame = parame.IZf;
        parame.update(locala.systemRowid, (IAutoDBItem)locala, false);
        i = 4;
      }
      for (;;)
      {
        parame.doNotify("single", i, locala);
        AppMethodBeat.o(267965);
        return;
        locala.field_updateTime = cn.bDw();
        locala.field_unReadCount = i;
        locala.field_sessionId = "@gamelifehistory";
        locala.field_digest = com.tencent.mm.cd.a.bt(MMApplicationContext.getContext(), d.f.Jat);
        parame = parame.IZf;
        parame.replace((IAutoDBItem)locala, false);
        if (locala.systemRowid <= 0L) {
          i = 2;
        } else {
          i = 1;
        }
      }
    }
    Log.i("GameLife.ConversationPresenter", "checkHistoryConversation gameLifeNode.hasGameLife false");
    AppMethodBeat.o(267965);
  }
  
  private static final void a(e parame, String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(267938);
    s.u(parame, "this$0");
    paramString = paramMStorageEventData.obj;
    if ((paramString instanceof com.tencent.mm.plugin.gamelife.f.a)) {
      switch (paramMStorageEventData.eventId)
      {
      }
    }
    for (;;)
    {
      Log.d("GameLife.ConversationPresenter", "conversationStorageChange " + paramMStorageEventData.obj + ' ' + paramMStorageEventData.eventId);
      AppMethodBeat.o(267938);
      return;
      Object localObject = com.tencent.mm.plugin.gamelife.f.c.Jbt;
      com.tencent.mm.plugin.gamelife.f.c.a.a((com.tencent.mm.plugin.gamelife.f.a)paramString, (m)new e(parame));
      continue;
      localObject = com.tencent.mm.plugin.gamelife.f.c.Jbt;
      com.tencent.mm.plugin.gamelife.f.c.a.a((com.tencent.mm.plugin.gamelife.f.a)paramString, (m)new f(parame));
      continue;
      localObject = parame.Jcm;
      paramString = (com.tencent.mm.plugin.gamelife.f.a)paramString;
      s.u(paramString, "conversation");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b.e((b)localObject, paramString));
      parame.aNK();
      continue;
      paramString = com.tencent.mm.plugin.gamelife.f.c.Jbt;
      com.tencent.mm.plugin.gamelife.f.c.a.a(0, parame.Jcm.vEn.size(), (m)new g(parame));
    }
  }
  
  private final void aNK()
  {
    AppMethodBeat.i(267925);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(267925);
  }
  
  private static final void b(e parame, String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(267952);
    s.u(parame, "this$0");
    Log.i("GameLife.ConversationPresenter", "onGameLifeContactStorageChange eventId:[%d]", new Object[] { Integer.valueOf(paramMStorageEventData.eventId) });
    if (paramMStorageEventData.eventId == 3)
    {
      paramString = paramMStorageEventData.obj;
      if ((paramString instanceof String))
      {
        int i;
        Object localObject1;
        if (((CharSequence)paramString).length() > 0)
        {
          i = 1;
          if (i != 0)
          {
            localObject1 = (Iterable)parame.Jcm.vEn;
            paramMStorageEventData = (Collection)new ArrayList();
            localObject1 = ((Iterable)localObject1).iterator();
          }
        }
        else
        {
          label104:
          Object localObject2;
          label180:
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label182;
            }
            localObject2 = ((Iterator)localObject1).next();
            com.tencent.mm.plugin.gamelife.f.a locala = (com.tencent.mm.plugin.gamelife.f.a)localObject2;
            if ((s.p(locala.field_selfUserName, paramString)) || (s.p(locala.field_talker, paramString))) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label180;
              }
              paramMStorageEventData.add(localObject2);
              break label104;
              i = 0;
              break;
            }
          }
          label182:
          paramMStorageEventData = ((Iterable)paramMStorageEventData).iterator();
          while (paramMStorageEventData.hasNext())
          {
            localObject1 = (com.tencent.mm.plugin.gamelife.f.a)paramMStorageEventData.next();
            Log.i("GameLife.ConversationPresenter", s.X("[onContactStorageChange] username=", paramString));
            localObject2 = a.a.acjy;
            if (localObject2 != null)
            {
              ((com.tencent.mm.by.a.a)localObject2).aft(((com.tencent.mm.plugin.gamelife.f.a)localObject1).field_sessionId);
              ((com.tencent.mm.by.a.a)localObject2).aft(((com.tencent.mm.plugin.gamelife.f.a)localObject1).field_selfUserName);
            }
            localObject2 = com.tencent.mm.plugin.gamelife.f.c.Jbt;
            com.tencent.mm.plugin.gamelife.f.c.a.a((com.tencent.mm.plugin.gamelife.f.a)localObject1, (m)new d(parame));
          }
        }
      }
    }
    AppMethodBeat.o(267952);
  }
  
  private final void fIA()
  {
    AppMethodBeat.i(267916);
    Log.i("GameLife.ConversationPresenter", "checkHistoryConversation");
    ((com.tencent.mm.plugin.game.api.c)h.ax(com.tencent.mm.plugin.game.api.c.class)).a(new e..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(267916);
  }
  
  public final void fIz()
  {
    AppMethodBeat.i(268028);
    com.tencent.mm.plugin.gamelife.f.c.a locala = com.tencent.mm.plugin.gamelife.f.c.Jbt;
    com.tencent.mm.plugin.gamelife.f.c.a.a(0, 15, (m)new c(this));
    AppMethodBeat.o(268028);
  }
  
  public final void onLoadMore()
  {
    AppMethodBeat.i(268036);
    com.tencent.mm.plugin.gamelife.f.c.a locala = com.tencent.mm.plugin.gamelife.f.c.Jbt;
    com.tencent.mm.plugin.gamelife.f.c.a.a(this.Jcm.vEn.size(), 10, (m)new j(this));
    AppMethodBeat.o(268036);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(268048);
    Object localObject1 = com.tencent.mm.game.report.c.mtx;
    localObject1 = com.tencent.mm.plugin.gamelife.j.a.JbN;
    long l1 = com.tencent.mm.plugin.gamelife.j.a.fIw();
    com.tencent.mm.game.report.c.a.a(2L, 0L, 0L, 1L, l1).bMH();
    com.tencent.mm.game.report.c.a.a(2L, 201L, 0L, 1L, l1).bMH();
    if (this.Jcn)
    {
      this.Jcn = false;
      AppMethodBeat.o(268048);
      return;
    }
    localObject1 = com.tencent.mm.plugin.gamelife.j.a.JbN;
    com.tencent.mm.plugin.gamelife.j.a.rK(301L);
    fIA();
    localObject1 = this.Jcm;
    ((b)localObject1).JbY.refreshView();
    localObject1 = ((b)localObject1).JbZ;
    Object localObject2 = ((g)localObject1).JbU;
    if (localObject2 != null) {
      ((g)localObject1).a((b.b)localObject2, 0);
    }
    localObject1 = this.Jcl;
    int i;
    label170:
    label192:
    int j;
    if ((localObject1 != null) && (((h.a)localObject1).aNU() == true))
    {
      i = 1;
      if (i != 0)
      {
        localObject1 = this.Jcl;
        if (localObject1 != null) {
          break label400;
        }
        localObject1 = null;
        if (localObject1 != null)
        {
          if (((Number)((r)localObject1).bsC).intValue() >= 2) {
            break label412;
          }
          i = 2;
          j = ((Number)((r)localObject1).bsD).intValue();
          if (i > j) {}
        }
      }
    }
    for (;;)
    {
      localObject1 = this.Jcm.XT(i);
      int k;
      String str;
      if (!((com.tencent.mm.plugin.gamelife.f.a)localObject1).fIs())
      {
        Object localObject3 = ((com.tencent.mm.plugin.gamelife.a.b)h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).aHu(((com.tencent.mm.plugin.gamelife.f.a)localObject1).field_selfUserName);
        if (localObject3 != null)
        {
          localObject2 = com.tencent.mm.game.report.c.mtx;
          k = this.Jcm.vEn.size();
          str = ((com.tencent.mm.plugin.gamelife.f.a)localObject1).field_sessionId;
          s.s(str, "item.field_sessionId");
          l1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject3).fIh();
          localObject3 = ((com.tencent.mm.plugin.gamelife.f.a)localObject1).field_selfUserName;
          s.s(localObject3, "item.field_selfUserName");
          Object localObject4 = ((com.tencent.mm.plugin.gamelife.f.a)localObject1).Jbs;
          s.checkNotNull(localObject4);
          long l2 = ((com.tencent.mm.plugin.gamelife.e.a)localObject4).field_accountType;
          localObject4 = ((com.tencent.mm.plugin.gamelife.f.a)localObject1).field_talker;
          s.s(localObject4, "item.field_talker");
          long l3 = ((com.tencent.mm.plugin.gamelife.f.a)localObject1).fIr();
          localObject1 = com.tencent.mm.plugin.gamelife.j.a.JbN;
          com.tencent.mm.game.report.c.a.a((com.tencent.mm.game.report.c.a)localObject2, i - 2 + 1, 1L, k, str, l1, (String)localObject3, l2, (String)localObject4, l3, com.tencent.mm.plugin.gamelife.j.a.fIw());
        }
      }
      for (;;)
      {
        if (i != j) {
          break label500;
        }
        AppMethodBeat.o(268048);
        return;
        i = 0;
        break;
        label400:
        localObject1 = ((h.a)localObject1).fID();
        break label170;
        label412:
        i = ((Number)((r)localObject1).bsC).intValue();
        break label192;
        localObject2 = com.tencent.mm.game.report.c.mtx;
        k = this.Jcm.vEn.size();
        str = ((com.tencent.mm.plugin.gamelife.f.a)localObject1).field_sessionId;
        s.s(str, "item.field_sessionId");
        l1 = ((com.tencent.mm.plugin.gamelife.f.a)localObject1).fIr();
        localObject1 = com.tencent.mm.plugin.gamelife.j.a.JbN;
        com.tencent.mm.game.report.c.a.a((com.tencent.mm.game.report.c.a)localObject2, i - 2 + 1, 1L, k, str, 0L, "", 0L, "", l1, com.tencent.mm.plugin.gamelife.j.a.fIw());
      }
      label500:
      i += 1;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "result", "", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<Boolean, List<? extends com.tencent.mm.plugin.gamelife.f.a>, ah>
  {
    c(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "result", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements m<Boolean, com.tencent.mm.plugin.gamelife.f.a, ah>
  {
    d(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "result", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements m<Boolean, com.tencent.mm.plugin.gamelife.f.a, ah>
  {
    e(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "result", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements m<Boolean, com.tencent.mm.plugin.gamelife.f.a, ah>
  {
    f(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "", "list", "", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements m<Boolean, List<? extends com.tencent.mm.plugin.gamelife.f.a>, ah>
  {
    g(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/gamelife/ui/GameLifeConversationPresenter$onItemClickListener$1", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "onItemClick", "", "view", "Landroid/view/View;", "pos", "", "conversation", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements b.c
  {
    i(e parame) {}
    
    public final void a(View paramView, com.tencent.mm.plugin.gamelife.f.a parama)
    {
      AppMethodBeat.i(267817);
      s.u(paramView, "view");
      s.u(parama, "conversation");
      ((com.tencent.mm.plugin.gamelife.a.d)h.ax(com.tencent.mm.plugin.gamelife.a.d.class)).fIl();
      paramView = e.a(this.Jcs);
      if (paramView != null)
      {
        String str1 = parama.field_sessionId;
        s.s(str1, "conversation.field_sessionId");
        String str2 = parama.field_selfUserName;
        s.s(str2, "conversation.field_selfUserName");
        parama = parama.field_talker;
        s.s(parama, "conversation.field_talker");
        paramView.ax(str1, str2, parama);
      }
      AppMethodBeat.o(267817);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "result", "", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements m<Boolean, List<? extends com.tencent.mm.plugin.gamelife.f.a>, ah>
  {
    j(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.e
 * JD-Core Version:    0.7.0.1
 */