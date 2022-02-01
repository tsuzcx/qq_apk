package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.c;
import com.tencent.mm.plugin.finder.conv.d;
import com.tencent.mm.plugin.finder.conv.d.a;
import com.tencent.mm.plugin.finder.conv.d.b;
import com.tencent.mm.plugin.finder.conv.f.b;
import com.tencent.mm.plugin.finder.conv.h;
import com.tencent.mm.plugin.finder.report.ak;
import com.tencent.mm.plugin.finder.report.al;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.logic.e.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem;
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

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationUI;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource$onQueryBackListener;", "()V", "msgTypes", "", "requestScene", "", "scene", "scrollListener", "Lcom/tencent/mm/plugin/finder/report/SystemMsgScrollListener;", "sysMsgConversation", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "fakeData", "", "getLayoutId", "getSystemConversationInfo", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "mentionId", "", "limit", "getTitleResId", "initSystemMsgReporter", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "source", "onCreateAfter", "onDestroy", "onExitChattingUI", "onResume", "reportSystemMsg", "setTeamConversation", "updateSysConversation", "Companion", "plugin-finder_release"})
public final class FinderConversationUI
  extends FinderConversationParentUI
  implements f.b
{
  public static final a vHZ;
  private HashMap _$_findViewCache;
  private final int scene;
  private final int tvu;
  private final int[] uYt;
  private final c vHX;
  public al vHY;
  
  static
  {
    AppMethodBeat.i(252229);
    vHZ = new a((byte)0);
    AppMethodBeat.o(252229);
  }
  
  public FinderConversationUI()
  {
    AppMethodBeat.i(252228);
    this.vHX = new c();
    this.scene = 1;
    this.tvu = 1;
    this.uYt = new int[] { 4 };
    AppMethodBeat.o(252228);
  }
  
  private final void dzd()
  {
    AppMethodBeat.i(252226);
    Object localObject = dze();
    if (!((Collection)localObject).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        azp localazp = ((com.tencent.mm.plugin.finder.model.a)((ArrayList)localObject).get(0)).uNF.field_notify;
        this.vHX.field_updateTime = (((com.tencent.mm.plugin.finder.model.a)((ArrayList)localObject).get(0)).uNF.field_createTime * 1000L);
        this.vHX.field_digest = localazp.title;
      }
      localObject = com.tencent.mm.kernel.g.aAh();
      p.g(localObject, "MMKernel.storage()");
      i = ((com.tencent.mm.kernel.e)localObject).azQ().getInt(ar.a.Oms, 0);
      this.vHX.field_unReadCount = i;
      this.vHX.field_readStatus = 0;
      this.vHP.ci(0);
      AppMethodBeat.o(252226);
      return;
    }
  }
  
  private final ArrayList<com.tencent.mm.plugin.finder.model.a> dze()
  {
    AppMethodBeat.i(252227);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.e.vGT;
    Object localObject2 = (Iterable)e.a.a(9223372036854775807L, 1, this.uYt, this.scene);
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (com.tencent.mm.plugin.finder.storage.ao)((Iterator)localObject2).next();
      e.a locala = com.tencent.mm.plugin.finder.storage.logic.e.vGT;
      localObject3 = e.a.b((com.tencent.mm.plugin.finder.storage.ao)localObject3);
      if (localObject3 != null) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localArrayList.addAll((Collection)localObject1);
    AppMethodBeat.o(252227);
    return localArrayList;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252232);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252232);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252231);
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
    AppMethodBeat.o(252231);
    return localView1;
  }
  
  public final void a(Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(252220);
    Object localObject = new com.tencent.mm.plugin.finder.conv.g();
    ((com.tencent.mm.plugin.finder.conv.g)localObject).a((d.b)new h((kotlin.g.a.a)d.vIb));
    ((com.tencent.mm.plugin.finder.conv.g)localObject).a((d.a)new com.tencent.mm.plugin.finder.conv.e((ReadyChattingCompatUI)this, (kotlin.g.a.b)new c(this)));
    localObject = (d)localObject;
    p.h(localObject, "<set-?>");
    this.vHP = ((d)localObject);
    if ((this.vHP instanceof com.tencent.mm.plugin.finder.conv.g))
    {
      c localc = this.vHX;
      localc.nickname = getString(2131759618);
      localc.field_sessionId = "finder_system_message";
      Context localContext = MMApplicationContext.getContext();
      localObject = localc.nickname;
      if (localObject != null) {}
      for (localObject = (CharSequence)localObject;; localObject = (CharSequence)"")
      {
        localc.tyr = ((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(localContext, (CharSequence)localObject));
        localObject = this.vHP;
        if (localObject != null) {
          break;
        }
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.conv.FinderConversationFirstFixAdapter");
        AppMethodBeat.o(252220);
        throw paramBundle;
      }
      ((com.tencent.mm.plugin.finder.conv.g)localObject).tyI = this.vHX;
    }
    super.a(paramBundle, paramInt);
    paramBundle = new al();
    localObject = paramBundle.viV;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.report.a)localObject).vcM = ((z)new b(this));
    }
    localObject = (RecyclerView)_$_findCachedViewById(2131299243);
    p.g(localObject, "conversationRecyclerView");
    paramBundle.b((RecyclerView)localObject, false);
    this.vHY = paramBundle;
    AppMethodBeat.o(252220);
  }
  
  public final void anv()
  {
    AppMethodBeat.i(252221);
    super.anv();
    dzd();
    AppMethodBeat.o(252221);
  }
  
  public final int dzb()
  {
    return 2131759617;
  }
  
  public final void dzc()
  {
    AppMethodBeat.i(252224);
    Object localObject = com.tencent.mm.kernel.g.aAh();
    p.g(localObject, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.e)localObject).azQ().getInt(ar.a.Oms, 0);
    if (i > 0)
    {
      localObject = k.vfA;
      k.ai(i, 1L);
      localObject = k.vfA;
      localObject = FinderReporterUIC.wzC;
      localObject = getContext();
      p.g(localObject, "context");
      localObject = FinderReporterUIC.a.fH((Context)localObject);
      if (localObject != null) {}
      for (localObject = ((FinderReporterUIC)localObject).dIx();; localObject = null)
      {
        k.a("11", 4, 1, 5, 0, i, null, null, 0L, (bbn)localObject, 0, 0, 3520);
        AppMethodBeat.o(252224);
        return;
      }
    }
    localObject = k.vfA;
    k.ai(0, 1L);
    AppMethodBeat.o(252224);
  }
  
  public final int getLayoutId()
  {
    return 2131494231;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(252225);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == 1))
    {
      paramIntent = this.vHP;
      p.h("findersayhisessionholder", "sessionId");
      c localc = (c)paramIntent.tyt.get("findersayhisessionholder");
      paramInt1 = j.a((List)paramIntent.ppH, localc);
      if ((paramInt1 >= 0) && (paramInt1 < paramIntent.ppH.size()))
      {
        paramIntent.ppH.remove(paramInt1);
        paramIntent.tyt.remove("findersayhisessionholder");
        paramIntent.In(paramInt1);
      }
    }
    AppMethodBeat.o(252225);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(252223);
    super.onDestroy();
    Object localObject = com.tencent.mm.kernel.g.ah(PluginFinder.class);
    p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)localObject).getRedDotManager().tJB.dat();
    localObject = this.vHY;
    if (localObject != null)
    {
      ((al)localObject).doY();
      AppMethodBeat.o(252223);
      return;
    }
    AppMethodBeat.o(252223);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(252222);
    super.onResume();
    Object localObject1 = dyY();
    int i = this.vHP.ppH.size();
    Object localObject2 = ((com.tencent.mm.plugin.finder.conv.f)localObject1).tyE;
    int j = ((com.tencent.mm.plugin.finder.conv.f)localObject1).scene;
    localObject2 = ((com.tencent.mm.plugin.finder.storage.e)localObject2).a(0, i, new int[] { 1 }, j);
    long l;
    label84:
    c localc;
    if (((List)localObject2).isEmpty())
    {
      localObject1 = "";
      if (!((List)localObject2).isEmpty()) {
        break label305;
      }
      l = 0L;
      Log.i("Finder.FinderConversationUI", "[onResume] digest:".concat(String.valueOf(localObject1)));
      localObject2 = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getConversationStorage();
      i = ((com.tencent.mm.plugin.finder.storage.e)localObject2).KX(2);
      localc = ((com.tencent.mm.plugin.finder.storage.e)localObject2).avq("findersayhisessionholder");
      if ((i <= 0) || (localc.systemRowid <= 0L) || ((!(p.j(localObject1, localc.field_digest) ^ true)) && (l == localc.field_updateTime))) {
        break label323;
      }
      localc.field_digest = ((String)localObject1);
      localc.field_updateTime = l;
      if (((com.tencent.mm.plugin.finder.storage.e)localObject2).update(localc.systemRowid, (IAutoDBItem)localc, false)) {
        ((com.tencent.mm.plugin.finder.storage.e)localObject2).doNotify(localc.field_sessionId, 1, localc);
      }
    }
    for (;;)
    {
      dzd();
      localObject1 = this.vHY;
      if (localObject1 == null) {
        break label367;
      }
      if (((al)localObject1).doZ() == true) {
        dzc();
      }
      AppMethodBeat.o(252222);
      return;
      localObject1 = ((c)((List)localObject2).get(0)).nickname + ':' + ((c)((List)localObject2).get(0)).field_digest;
      break;
      label305:
      l = ((c)((List)localObject2).get(0)).field_updateTime;
      break label84;
      label323:
      if ((localc.systemRowid > 0L) && (i == 0) && (((com.tencent.mm.plugin.finder.storage.e)localObject2).delete(localc.systemRowid))) {
        ((com.tencent.mm.plugin.finder.storage.e)localObject2).doNotify(localc.field_sessionId, 6, localc);
      }
    }
    label367:
    AppMethodBeat.o(252222);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationUI$Companion;", "", "()V", "REQUEST_CODE_HI_BOX", "", "RESULT_CODE_REMOVE_HI_BOX", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderConversationUI$initSystemMsgReporter$1$1", "Lcom/tencent/mm/plugin/finder/report/IDiffData;", "", "onDiffData", "", "diffData", "", "plugin-finder_release"})
  public static final class b
    implements z<String>
  {
    b(FinderConversationUI paramFinderConversationUI) {}
    
    public final void doO()
    {
      AppMethodBeat.i(252217);
      FinderConversationUI.a(this.vIa);
      AppMethodBeat.o(252217);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderConversationUI$onCreate$1$2"})
  static final class c
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.conv.b, x>
  {
    c(FinderConversationUI paramFinderConversationUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final d vIb;
    
    static
    {
      AppMethodBeat.i(252219);
      vIb = new d();
      AppMethodBeat.o(252219);
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