package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatting.BasePrivateMsgConvListFragment.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.c;
import com.tencent.mm.plugin.finder.conv.c.a;
import com.tencent.mm.plugin.finder.conv.c.b;
import com.tencent.mm.plugin.finder.conv.d;
import com.tencent.mm.plugin.finder.conv.e;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.report.ar;
import com.tencent.mm.plugin.finder.report.bc;
import com.tencent.mm.plugin.finder.report.be;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.av;
import com.tencent.mm.plugin.finder.storage.logic.f.a;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.bqv;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationFragment;", "Lcom/tencent/mm/plugin/finder/ui/FinderBaseConversationFragment;", "()V", "msgTypes", "", "scene", "", "scrollListener", "Lcom/tencent/mm/plugin/finder/report/SystemMsgScrollListener;", "sysMsgConversation", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "getAdapter", "Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment$BasePrivateMsgConvAdapter;", "getSystemConversationInfo", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "mentionId", "", "limit", "initSystemMsgReporter", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "onExitChattingUI", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "reportSystemMsg", "setTeamConversation", "updateSysConversation", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderConversationFragment
  extends FinderBaseConversationFragment
{
  private final int[] EZk;
  private final com.tencent.mm.plugin.finder.conv.b FOV;
  private be FOW;
  private final int scene;
  
  public FinderConversationFragment()
  {
    AppMethodBeat.i(347646);
    this.FOV = new com.tencent.mm.plugin.finder.conv.b();
    this.EZk = new int[] { 4 };
    this.scene = 1;
    AppMethodBeat.o(347646);
  }
  
  private final void faM()
  {
    AppMethodBeat.i(347657);
    ArrayList localArrayList = faN();
    if (!((Collection)localArrayList).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        bqv localbqv = ((com.tencent.mm.plugin.finder.model.a)localArrayList.get(0)).ECa.field_notify;
        this.FOV.field_updateTime = (((com.tencent.mm.plugin.finder.model.a)localArrayList.get(0)).ECa.field_createTime * 1000L);
        this.FOV.field_digest = localbqv.title;
      }
      i = h.baE().ban().getInt(at.a.addL, 0);
      this.FOV.field_unReadCount = i;
      this.FOV.field_readStatus = 0;
      aNG().fV(0);
      AppMethodBeat.o(347657);
      return;
    }
  }
  
  private final ArrayList<com.tencent.mm.plugin.finder.model.a> faN()
  {
    AppMethodBeat.i(347661);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.f.FNJ;
    Object localObject2 = (Iterable)f.a.a(9223372036854775807L, 1, this.EZk, this.scene);
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (av)((Iterator)localObject2).next();
      f.a locala = com.tencent.mm.plugin.finder.storage.logic.f.FNJ;
      localObject3 = f.a.c((av)localObject3);
      if (localObject3 != null) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localArrayList.addAll((Collection)localObject1);
    AppMethodBeat.o(347661);
    return localArrayList;
  }
  
  private final void faO()
  {
    AppMethodBeat.i(347669);
    int i = h.baE().ban().getInt(at.a.addL, 0);
    if (i > 0)
    {
      localObject = z.FrZ;
      z.ar(i, 1L);
      localObject = z.FrZ;
      localObject = getActivity();
      if (localObject == null)
      {
        localObject = null;
        z.a("11", 4, 1, 5, 0, i, null, null, 0L, (bui)localObject, 0, 0, 3520);
        AppMethodBeat.o(347669);
        return;
      }
      as.a locala = as.GSQ;
      localObject = as.a.hu((Context)localObject);
      if (localObject == null) {}
      for (localObject = null;; localObject = ((as)localObject).fou()) {
        break;
      }
    }
    Object localObject = z.FrZ;
    z.ar(0, 1L);
    AppMethodBeat.o(347669);
  }
  
  public final BasePrivateMsgConvListFragment.a<com.tencent.mm.plugin.finder.conv.b> aNO()
  {
    AppMethodBeat.i(347682);
    Object localObject = new com.tencent.mm.plugin.finder.conv.f();
    ((com.tencent.mm.plugin.finder.conv.f)localObject).a((c.b)new com.tencent.mm.plugin.finder.conv.g((kotlin.g.a.a)a.FOX));
    ((com.tencent.mm.plugin.finder.conv.f)localObject).a((c.a)new d((FinderBaseConversationFragment)this, (kotlin.g.a.b)new b(this)));
    localObject = (BasePrivateMsgConvListFragment.a)localObject;
    AppMethodBeat.o(347682);
    return localObject;
  }
  
  public final void faI()
  {
    int i = 1;
    AppMethodBeat.i(347720);
    be localbe = this.FOW;
    if ((localbe != null) && (localbe.eNZ() == true)) {}
    for (;;)
    {
      if (i != 0) {
        faO();
      }
      AppMethodBeat.o(347720);
      return;
      i = 0;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(347713);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == 1))
    {
      paramIntent = (c)aNG();
      s.u("findersayhisessionholder", "sessionId");
      com.tencent.mm.plugin.finder.conv.b localb = (com.tencent.mm.plugin.finder.conv.b)paramIntent.AFz.get("findersayhisessionholder");
      paramInt1 = kotlin.a.p.a((List)paramIntent.vEn, localb);
      if ((paramInt1 >= 0) && (paramInt1 < paramIntent.vEn.size()))
      {
        paramIntent.vEn.remove(paramInt1);
        paramIntent.AFz.remove("findersayhisessionholder");
        paramIntent.Nc(paramInt1);
      }
    }
    AppMethodBeat.o(347713);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(347709);
    super.onDestroy();
    ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().AQv.dZa();
    be localbe = this.FOW;
    if (localbe != null) {
      localbe.eNY();
    }
    AppMethodBeat.o(347709);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(347703);
    super.onResume();
    Object localObject2 = ((e)aNC()).Nd(1);
    Object localObject1;
    long l;
    label50:
    com.tencent.mm.plugin.finder.conv.b localb;
    if (((List)localObject2).isEmpty())
    {
      localObject1 = "";
      if (!((List)localObject2).isEmpty()) {
        break label272;
      }
      l = 0L;
      Log.i("Finder.FinderConversationUI", s.X("[onResume] digest:", localObject1));
      localObject2 = ((PluginFinder)h.az(PluginFinder.class)).getConversationStorage();
      i = ((com.tencent.mm.plugin.finder.storage.g)localObject2).Tp(2);
      localb = ((com.tencent.mm.plugin.finder.storage.g)localObject2).aAz("findersayhisessionholder");
      if ((i <= 0) || (localb.systemRowid <= 0L) || ((s.p(localObject1, localb.field_digest)) && (l == localb.field_updateTime))) {
        break label290;
      }
      localb.field_digest = ((String)localObject1);
      localb.field_updateTime = l;
      if (((com.tencent.mm.plugin.finder.storage.g)localObject2).update(localb.systemRowid, (IAutoDBItem)localb, false)) {
        ((com.tencent.mm.plugin.finder.storage.g)localObject2).doNotify(localb.field_sessionId, 1, localb);
      }
      label177:
      faM();
      localObject1 = this.FOW;
      if ((localObject1 == null) || (((be)localObject1).eNZ() != true)) {
        break label334;
      }
    }
    label272:
    label290:
    label334:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        faO();
      }
      AppMethodBeat.o(347703);
      return;
      localObject1 = ((com.tencent.mm.plugin.finder.conv.b)((List)localObject2).get(0)).nickname + ':' + ((com.tencent.mm.plugin.finder.conv.b)((List)localObject2).get(0)).field_digest;
      break;
      l = ((com.tencent.mm.plugin.finder.conv.b)((List)localObject2).get(0)).field_updateTime;
      break label50;
      if ((localb.systemRowid <= 0L) || (i != 0) || (!((com.tencent.mm.plugin.finder.storage.g)localObject2).delete(localb.systemRowid))) {
        break label177;
      }
      ((com.tencent.mm.plugin.finder.storage.g)localObject2).doNotify(localb.field_sessionId, 6, localb);
      break label177;
    }
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(347691);
    s.u(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    if ((aNG() instanceof com.tencent.mm.plugin.finder.conv.f))
    {
      com.tencent.mm.plugin.finder.conv.b localb = this.FOV;
      localb.nickname = getString(e.h.finder_conversation_finder_team);
      localb.field_sessionId = "finder_system_message";
      Context localContext = MMApplicationContext.getContext();
      paramBundle = localb.nickname;
      paramView = paramBundle;
      if (paramBundle == null) {
        paramView = "";
      }
      localb.AFy = ((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(localContext, (CharSequence)paramView));
      ((com.tencent.mm.plugin.finder.conv.f)aNG()).AFM = this.FOV;
    }
    paramBundle = new be();
    paramView = paramBundle.FuL;
    if (paramView != null) {
      paramView.Fno = ((ar)new c(this));
    }
    paramView = getView();
    if (paramView == null) {}
    for (paramView = null;; paramView = paramView.findViewById(e.e.conversationRecyclerView))
    {
      s.s(paramView, "conversationRecyclerView");
      paramBundle.b((RecyclerView)paramView, false);
      paramView = ah.aiuX;
      this.FOW = paramBundle;
      faM();
      AppMethodBeat.o(347691);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final a FOX;
    
    static
    {
      AppMethodBeat.i(346906);
      FOX = new a();
      AppMethodBeat.o(346906);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/anim/conv/ConvItemUnselectedAnim;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<com.tencent.mm.ui.anim.c.a, ah>
  {
    b(FinderConversationFragment paramFinderConversationFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderConversationFragment$initSystemMsgReporter$1$1", "Lcom/tencent/mm/plugin/finder/report/IDiffData;", "", "onDiffData", "", "diffData", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements ar<String>
  {
    c(FinderConversationFragment paramFinderConversationFragment) {}
    
    public final void eNQ()
    {
      AppMethodBeat.i(346904);
      FinderConversationFragment.a(this.FOY);
      AppMethodBeat.o(346904);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderConversationFragment
 * JD-Core Version:    0.7.0.1
 */