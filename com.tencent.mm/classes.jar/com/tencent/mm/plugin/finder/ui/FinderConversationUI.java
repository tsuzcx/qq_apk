package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.conv.d;
import com.tencent.mm.plugin.finder.conv.e.b;
import com.tencent.mm.plugin.finder.conv.g;
import com.tencent.mm.plugin.finder.conv.g.b;
import com.tencent.mm.plugin.finder.conv.i;
import com.tencent.mm.plugin.finder.report.ad;
import com.tencent.mm.plugin.finder.report.ap;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.bfo;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationUI;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource$onQueryBackListener;", "()V", "msgTypes", "", "requestScene", "", "scene", "scrollListener", "Lcom/tencent/mm/plugin/finder/report/SystemMsgScrollListener;", "sysMsgConversation", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "fakeData", "", "getLayoutId", "getSystemConversationInfo", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "mentionId", "", "limit", "getTitleResId", "", "initSystemMsgReporter", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "source", "onCreateAfter", "onDestroy", "onExitChattingUI", "onResume", "reportSystemMsg", "setTeamConversation", "updateSysConversation", "Companion", "plugin-finder_release"})
public final class FinderConversationUI
  extends FinderConversationParentUI
  implements g.b
{
  public static final a AoW;
  private final d AoU;
  public ap AoV;
  private HashMap _$_findViewCache;
  private final int scene;
  private final int xdc;
  private final int[] zOH;
  
  static
  {
    AppMethodBeat.i(280116);
    AoW = new a((byte)0);
    AppMethodBeat.o(280116);
  }
  
  public FinderConversationUI()
  {
    AppMethodBeat.i(280115);
    this.AoU = new d();
    this.scene = 1;
    this.xdc = 1;
    this.zOH = new int[] { 4 };
    AppMethodBeat.o(280115);
  }
  
  private final void dZU()
  {
    AppMethodBeat.i(280113);
    Object localObject = dZV();
    if (!((Collection)localObject).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        bfo localbfo = ((com.tencent.mm.plugin.finder.model.a)((ArrayList)localObject).get(0)).zzT.field_notify;
        this.AoU.field_updateTime = (((com.tencent.mm.plugin.finder.model.a)((ArrayList)localObject).get(0)).zzT.field_createTime * 1000L);
        this.AoU.field_digest = localbfo.title;
      }
      localObject = com.tencent.mm.kernel.h.aHG();
      p.j(localObject, "MMKernel.storage()");
      i = ((com.tencent.mm.kernel.f)localObject).aHp().getInt(ar.a.VBp, 0);
      this.AoU.field_unReadCount = i;
      this.AoU.field_readStatus = 0;
      this.AoM.cL(0);
      AppMethodBeat.o(280113);
      return;
    }
  }
  
  private final ArrayList<com.tencent.mm.plugin.finder.model.a> dZV()
  {
    AppMethodBeat.i(280114);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.e.AnP;
    Object localObject2 = (Iterable)com.tencent.mm.plugin.finder.storage.logic.e.a.a(9223372036854775807L, 1, this.zOH, this.scene);
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (com.tencent.mm.plugin.finder.storage.an)((Iterator)localObject2).next();
      com.tencent.mm.plugin.finder.storage.logic.e.a locala = com.tencent.mm.plugin.finder.storage.logic.e.AnP;
      localObject3 = com.tencent.mm.plugin.finder.storage.logic.e.a.b((com.tencent.mm.plugin.finder.storage.an)localObject3);
      if (localObject3 != null) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localArrayList.addAll((Collection)localObject1);
    AppMethodBeat.o(280114);
    return localArrayList;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(280119);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(280119);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(280118);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(280118);
    return localView1;
  }
  
  public final void a(Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(280107);
    Object localObject = new com.tencent.mm.plugin.finder.conv.h();
    ((com.tencent.mm.plugin.finder.conv.h)localObject).a((e.b)new i((kotlin.g.a.a)d.AoY));
    ((com.tencent.mm.plugin.finder.conv.h)localObject).a((com.tencent.mm.plugin.finder.conv.e.a)new com.tencent.mm.plugin.finder.conv.f((ReadyChattingCompatUI)this, (kotlin.g.a.b)new c(this)));
    localObject = (com.tencent.mm.plugin.finder.conv.e)localObject;
    p.k(localObject, "<set-?>");
    this.AoM = ((com.tencent.mm.plugin.finder.conv.e)localObject);
    if ((this.AoM instanceof com.tencent.mm.plugin.finder.conv.h))
    {
      d locald = this.AoU;
      locald.nickname = getString(b.j.finder_conversation_finder_team);
      locald.field_sessionId = "finder_system_message";
      Context localContext = MMApplicationContext.getContext();
      localObject = locald.nickname;
      if (localObject != null) {}
      for (localObject = (CharSequence)localObject;; localObject = (CharSequence)"")
      {
        locald.xgc = ((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(localContext, (CharSequence)localObject));
        localObject = this.AoM;
        if (localObject != null) {
          break;
        }
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.conv.FinderConversationFirstFixAdapter");
        AppMethodBeat.o(280107);
        throw paramBundle;
      }
      ((com.tencent.mm.plugin.finder.conv.h)localObject).xgu = this.AoU;
    }
    super.a(paramBundle, paramInt);
    paramBundle = new ap();
    localObject = paramBundle.zZO;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.report.a)localObject).zTD = ((ad)new b(this));
    }
    localObject = (RecyclerView)_$_findCachedViewById(b.f.conversationRecyclerView);
    p.j(localObject, "conversationRecyclerView");
    paramBundle.b((RecyclerView)localObject, false);
    this.AoV = paramBundle;
    AppMethodBeat.o(280107);
  }
  
  public final void atw()
  {
    AppMethodBeat.i(280108);
    super.atw();
    dZU();
    AppMethodBeat.o(280108);
  }
  
  public final void dZT()
  {
    AppMethodBeat.i(280111);
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.f)localObject).aHp().getInt(ar.a.VBp, 0);
    if (i > 0)
    {
      localObject = n.zWF;
      n.al(i, 1L);
      localObject = n.zWF;
      localObject = aj.Bnu;
      localObject = getContext();
      p.j(localObject, "context");
      localObject = aj.a.fZ((Context)localObject);
      if (localObject != null) {}
      for (localObject = ((aj)localObject).ekY();; localObject = null)
      {
        n.a("11", 4, 1, 5, 0, i, null, null, 0L, (bid)localObject, 0, 0, 3520);
        AppMethodBeat.o(280111);
        return;
      }
    }
    localObject = n.zWF;
    n.al(0, 1L);
    AppMethodBeat.o(280111);
  }
  
  public final String duZ()
  {
    AppMethodBeat.i(280106);
    String str = getString(b.j.finder_conversation_finder_message_title);
    p.j(str, "this.getString(R.string.…ion_finder_message_title)");
    AppMethodBeat.o(280106);
    return str;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_conversation_ui;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(280112);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == 1))
    {
      paramIntent = this.AoM;
      p.k("findersayhisessionholder", "sessionId");
      d locald = (d)paramIntent.xge.get("findersayhisessionholder");
      paramInt1 = j.a((List)paramIntent.syG, locald);
      if ((paramInt1 >= 0) && (paramInt1 < paramIntent.syG.size()))
      {
        paramIntent.syG.remove(paramInt1);
        paramIntent.xge.remove("findersayhisessionholder");
        paramIntent.LY(paramInt1);
      }
    }
    AppMethodBeat.o(280112);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(280110);
    super.onDestroy();
    Object localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
    p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)localObject).getRedDotManager().xsM.dqt();
    localObject = this.AoV;
    if (localObject != null)
    {
      ((ap)localObject).dQB();
      AppMethodBeat.o(280110);
      return;
    }
    AppMethodBeat.o(280110);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(280109);
    super.onResume();
    Object localObject2 = dZQ().gy(this.AoM.syG.size(), 1);
    Object localObject1;
    long l;
    label57:
    int i;
    d locald;
    if (((List)localObject2).isEmpty())
    {
      localObject1 = "";
      if (!((List)localObject2).isEmpty()) {
        break label278;
      }
      l = 0L;
      Log.i("Finder.FinderConversationUI", "[onResume] digest:".concat(String.valueOf(localObject1)));
      localObject2 = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getConversationStorage();
      i = ((com.tencent.mm.plugin.finder.storage.f)localObject2).Qh(2);
      locald = ((com.tencent.mm.plugin.finder.storage.f)localObject2).aEG("findersayhisessionholder");
      if ((i <= 0) || (locald.systemRowid <= 0L) || ((!(p.h(localObject1, locald.field_digest) ^ true)) && (l == locald.field_updateTime))) {
        break label296;
      }
      locald.field_digest = ((String)localObject1);
      locald.field_updateTime = l;
      if (((com.tencent.mm.plugin.finder.storage.f)localObject2).update(locald.systemRowid, (IAutoDBItem)locald, false)) {
        ((com.tencent.mm.plugin.finder.storage.f)localObject2).doNotify(locald.field_sessionId, 1, locald);
      }
    }
    for (;;)
    {
      dZU();
      localObject1 = this.AoV;
      if (localObject1 == null) {
        break label340;
      }
      if (((ap)localObject1).dQC() == true) {
        dZT();
      }
      AppMethodBeat.o(280109);
      return;
      localObject1 = ((d)((List)localObject2).get(0)).nickname + ':' + ((d)((List)localObject2).get(0)).field_digest;
      break;
      label278:
      l = ((d)((List)localObject2).get(0)).field_updateTime;
      break label57;
      label296:
      if ((locald.systemRowid > 0L) && (i == 0) && (((com.tencent.mm.plugin.finder.storage.f)localObject2).delete(locald.systemRowid))) {
        ((com.tencent.mm.plugin.finder.storage.f)localObject2).doNotify(locald.field_sessionId, 6, locald);
      }
    }
    label340:
    AppMethodBeat.o(280109);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationUI$Companion;", "", "()V", "REQUEST_CODE_HI_BOX", "", "RESULT_CODE_REMOVE_HI_BOX", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderConversationUI$initSystemMsgReporter$1$1", "Lcom/tencent/mm/plugin/finder/report/IDiffData;", "", "onDiffData", "", "diffData", "", "plugin-finder_release"})
  public static final class b
    implements ad<String>
  {
    b(FinderConversationUI paramFinderConversationUI) {}
    
    public final void dQw()
    {
      AppMethodBeat.i(288638);
      FinderConversationUI.a(this.AoX);
      AppMethodBeat.o(288638);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderConversationUI$onCreate$1$2"})
  static final class c
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.conv.b, x>
  {
    c(FinderConversationUI paramFinderConversationUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final d AoY;
    
    static
    {
      AppMethodBeat.i(246667);
      AoY = new d();
      AppMethodBeat.o(246667);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderConversationUI
 * JD-Core Version:    0.7.0.1
 */