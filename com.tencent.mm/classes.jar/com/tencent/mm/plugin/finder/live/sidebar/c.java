package com.tencent.mm.plugin.finder.live.sidebar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.view.sidebar.DraggableConstraintLayout;
import com.tencent.mm.plugin.finder.view.sidebar.a.a;
import com.tencent.mm.plugin.finder.view.sidebar.a.c;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.e.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import com.tencent.mm.view.recyclerview.m;
import com.tencent.mm.view.recyclerview.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar;", "", "liveContainer", "Landroid/view/View;", "(Landroid/view/View;)V", "TAG", "", "barrierSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "config", "Lcom/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar$FinderLiveSideBarConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar$FinderLiveSideBarConfig;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "curPosition", "", "enable", "", "enableExposeReport", "finderSideBar", "Lcom/tencent/mm/plugin/finder/view/sidebar/FinderSideBar;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "listener", "Lcom/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar$Listener;", "getListener", "()Lcom/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar$Listener;", "setListener", "(Lcom/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar$Listener;)V", "getLiveContainer", "()Landroid/view/View;", "sideBarDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/sidebar/FinderLiveFeed;", "Lkotlin/collections/ArrayList;", "sideBarRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getSideBarRv", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setSideBarRv", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "title", "addDragBarrier", "", "sceneId", "appendData", "dataList", "", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "attachToView", "parent", "Landroid/view/ViewGroup;", "getCurData", "Lkotlin/Pair;", "hide", "mergeFilter", "", "sourceList", "newList", "mount", "curLive", "removeDragBarrier", "select", "position", "setHideBtnVisible", "visible", "show", "isShowExitBtn", "exitClick", "Lkotlin/Function0;", "toggleSideBar", "unmount", "FinderLiveSideBarConfig", "Listener", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  final View BwE;
  int CVo;
  public com.tencent.mm.plugin.finder.view.sidebar.a DGn;
  public final HashSet<String> DGo;
  public b DGp;
  public WxRecyclerView DGq;
  final ArrayList<b> DGr;
  boolean DGs;
  public final a DGt;
  public final String TAG;
  public Context context;
  public boolean enable;
  private com.tencent.mm.bx.b lastBuffer;
  private String title;
  
  public c(View paramView)
  {
    AppMethodBeat.i(352007);
    this.BwE = paramView;
    this.TAG = "Finder.FinderLiveSideBar";
    this.DGo = new HashSet();
    this.DGr = new ArrayList();
    this.title = "";
    this.DGt = new a();
    AppMethodBeat.o(352007);
  }
  
  private static final void a(c paramc)
  {
    AppMethodBeat.i(352026);
    s.u(paramc, "this$0");
    WxRecyclerView localWxRecyclerView = paramc.etB();
    paramc = com.tencent.mm.hellhoundlib.b.c.a(paramc.CVo, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localWxRecyclerView, paramc.aYi(), "com/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar", "mount$lambda-2", "(Lcom/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar;)V", "Undefined", "smoothScrollToPosition", "(I)V");
    localWxRecyclerView.smoothScrollToPosition(((Integer)paramc.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localWxRecyclerView, "com/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar", "mount$lambda-2", "(Lcom/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar;)V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(352026);
  }
  
  private static final void c(c paramc)
  {
    AppMethodBeat.i(371089);
    s.u(paramc, "this$0");
    Object localObject = paramc.etB().getContext();
    s.s(localObject, "sideBarRv.context");
    localObject = new com.tencent.mm.plugin.finder.event.recyclerview.a((Context)localObject);
    ((RecyclerView.r)localObject).cag = paramc.CVo;
    paramc = paramc.etB().getLayoutManager();
    if (paramc != null) {
      paramc.startSmoothScroll((RecyclerView.r)localObject);
    }
    AppMethodBeat.o(371089);
  }
  
  private static final void n(kotlin.g.a.a parama, View paramView)
  {
    AppMethodBeat.i(371088);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    if (parama != null) {
      parama.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(371088);
  }
  
  private static List<com.tencent.mm.plugin.finder.live.viewmodel.data.f> w(List<com.tencent.mm.plugin.finder.live.viewmodel.data.f> paramList1, List<com.tencent.mm.plugin.finder.live.viewmodel.data.f> paramList2)
  {
    AppMethodBeat.i(352016);
    s.u(paramList1, "sourceList");
    s.u(paramList2, "newList");
    LinkedList localLinkedList = new LinkedList();
    paramList2 = ((Iterable)paramList2).iterator();
    label69:
    label199:
    label205:
    label212:
    label215:
    while (paramList2.hasNext())
    {
      com.tencent.mm.plugin.finder.live.viewmodel.data.f localf = (com.tencent.mm.plugin.finder.live.viewmodel.data.f)paramList2.next();
      Iterator localIterator = paramList1.iterator();
      int i = 0;
      int j;
      label102:
      label108:
      label122:
      int k;
      if (localIterator.hasNext()) {
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localIterator.next()).a((com.tencent.mm.plugin.finder.feed.model.internal.k)localf) == 0)
        {
          j = 1;
          if (j == 0) {
            break label187;
          }
          j = i;
          localIterator = ((List)localLinkedList).iterator();
          i = 0;
          if (!localIterator.hasNext()) {
            break label212;
          }
          if (((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localIterator.next()).a((com.tencent.mm.plugin.finder.feed.model.internal.k)localf) != 0) {
            break label199;
          }
          k = 1;
          if (k == 0) {
            break label205;
          }
        }
      }
      for (;;)
      {
        if ((j != -1) || (i != -1)) {
          break label215;
        }
        localLinkedList.add(localf);
        break;
        j = 0;
        break label102;
        i += 1;
        break label69;
        j = -1;
        break label108;
        k = 0;
        break label156;
        i += 1;
        break label122;
        i = -1;
      }
    }
    label156:
    label187:
    paramList1 = (List)localLinkedList;
    AppMethodBeat.o(352016);
    return paramList1;
  }
  
  public final void Po(int paramInt)
  {
    AppMethodBeat.i(352155);
    View localView = this.DGt.niB;
    if (localView != null) {
      localView.setVisibility(paramInt);
    }
    AppMethodBeat.o(352155);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.viewmodel.data.f paramf, List<com.tencent.mm.plugin.finder.live.viewmodel.data.f> paramList, String paramString)
  {
    AppMethodBeat.i(352082);
    s.u(paramf, "curLive");
    s.u(paramList, "dataList");
    s.u(paramString, "title");
    Log.i(this.TAG, "mount curLive:" + com.tencent.mm.ae.d.hF(paramf.Ebr.liveId) + ", dataList:" + paramList.size() + ", title:" + paramString);
    this.DGr.clear();
    this.CVo = 0;
    ArrayList localArrayList = this.DGr;
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(new b((com.tencent.mm.plugin.finder.live.viewmodel.data.f)((Iterator)localObject).next()));
    }
    localArrayList.addAll((Collection)paramList);
    paramList = ((List)this.DGr).iterator();
    int i = 0;
    int j;
    if (paramList.hasNext()) {
      if (((b)paramList.next()).data.Ebr.liveId == paramf.Ebr.liveId)
      {
        j = 1;
        label243:
        if (j == 0) {
          break label387;
        }
      }
    }
    for (;;)
    {
      this.CVo = i;
      if (this.CVo < 0)
      {
        this.CVo = 0;
        this.DGr.add(0, new b(paramf));
      }
      paramf = (b)p.ae((List)this.DGr, this.CVo);
      if (paramf != null) {
        paramf.Bvd = true;
      }
      paramf = etB().getAdapter();
      if (paramf != null) {
        paramf.bZE.notifyChanged();
      }
      etB().post(new c..ExternalSyntheticLambda1(this));
      rS(true);
      this.title = paramString;
      paramf = this.DGt.DGu;
      if (paramf != null) {
        paramf.setText((CharSequence)paramString);
      }
      AppMethodBeat.o(352082);
      return;
      j = 0;
      break label243;
      label387:
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void a(List<com.tencent.mm.plugin.finder.live.viewmodel.data.f> paramList, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(352115);
    s.u(paramList, "dataList");
    Log.i(this.TAG, "appendData origin " + this.DGr.size() + ", " + paramList.size());
    this.lastBuffer = paramb;
    Object localObject = (Iterable)this.DGr;
    paramb = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramb.add(((b)((Iterator)localObject).next()).data);
    }
    paramb = w((List)paramb, paramList);
    paramList = this.DGr;
    localObject = (Iterable)paramb;
    paramb = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramb.add(new b((com.tencent.mm.plugin.finder.live.viewmodel.data.f)((Iterator)localObject).next()));
    }
    paramList.addAll((Collection)paramb);
    paramList = etB().getAdapter();
    if (paramList != null) {
      paramList.bZE.notifyChanged();
    }
    Log.i(this.TAG, "appendData after " + this.DGr.size() + ", liveIds: " + p.a((Iterable)this.DGr, null, null, null, 0, null, (kotlin.g.a.b)c.DGC, 31));
    AppMethodBeat.o(352115);
  }
  
  public final void e(boolean paramBoolean, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(371107);
    Log.i(this.TAG, s.X("show isShowExitBtn=", Boolean.valueOf(paramBoolean)));
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    ((d)com.tencent.mm.ui.component.k.nq(getContext()).q(d.class)).DGH.DGM = 1;
    if (this.DGr.size() > 0)
    {
      this.DGt.akft = paramBoolean;
      localObject = this.DGt.akfu;
      if (localObject != null) {
        ((ImageView)localObject).setOnClickListener(new c..ExternalSyntheticLambda0(parama));
      }
      parama = this.DGn;
      if (parama == null)
      {
        s.bIx("finderSideBar");
        parama = null;
      }
      for (;;)
      {
        parama.GIw.GIk = DraggableConstraintLayout.GIp;
        parama.GIy.qk(true);
        parama.a((View)parama.GIw, 0.0F, 1.0F, (kotlin.g.a.a)new a.c(parama));
        AppMethodBeat.o(371107);
        return;
      }
    }
    Log.w(this.TAG, "sideBar list is empty, cannot show");
    AppMethodBeat.o(371107);
  }
  
  public final WxRecyclerView etB()
  {
    AppMethodBeat.i(352056);
    WxRecyclerView localWxRecyclerView = this.DGq;
    if (localWxRecyclerView != null)
    {
      AppMethodBeat.o(352056);
      return localWxRecyclerView;
    }
    s.bIx("sideBarRv");
    AppMethodBeat.o(352056);
    return null;
  }
  
  public final void etC()
  {
    AppMethodBeat.i(352086);
    Log.i(this.TAG, "unmount");
    this.DGr.clear();
    this.CVo = 0;
    this.DGo.clear();
    RecyclerView.a locala = etB().getAdapter();
    if (locala != null) {
      locala.bZE.notifyChanged();
    }
    rS(false);
    AppMethodBeat.o(352086);
  }
  
  public final r<List<com.tencent.mm.plugin.finder.live.viewmodel.data.f>, com.tencent.mm.bx.b> etD()
  {
    AppMethodBeat.i(352124);
    Object localObject2 = (Iterable)this.DGr;
    Object localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((b)((Iterator)localObject2).next()).data);
    }
    localObject1 = new r((List)localObject1, this.lastBuffer);
    AppMethodBeat.o(352124);
    return localObject1;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(352064);
    Context localContext = this.context;
    if (localContext != null)
    {
      AppMethodBeat.o(352064);
      return localContext;
    }
    s.bIx("context");
    AppMethodBeat.o(352064);
    return null;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(352092);
    Log.i(this.TAG, "hide");
    com.tencent.mm.plugin.finder.view.sidebar.a locala2 = this.DGn;
    com.tencent.mm.plugin.finder.view.sidebar.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("finderSideBar");
      locala1 = null;
    }
    locala1.fmk();
    AppMethodBeat.o(352092);
  }
  
  public final void rS(boolean paramBoolean)
  {
    com.tencent.mm.plugin.finder.view.sidebar.a locala2 = null;
    com.tencent.mm.plugin.finder.view.sidebar.a locala1 = null;
    AppMethodBeat.i(352134);
    Log.i(this.TAG, "toggleSideBar from:" + paramBoolean + ", to:" + paramBoolean + ", barrierSet size:" + this.DGo.size());
    this.enable = paramBoolean;
    if ((paramBoolean) && (this.DGo.isEmpty()))
    {
      locala2 = this.DGn;
      if (locala2 == null) {
        s.bIx("finderSideBar");
      }
      for (;;)
      {
        locala1.fmh();
        AppMethodBeat.o(352134);
        return;
        locala1 = locala2;
      }
    }
    locala1 = this.DGn;
    if (locala1 == null)
    {
      s.bIx("finderSideBar");
      locala1 = locala2;
    }
    for (;;)
    {
      locala1.fmj();
      AppMethodBeat.o(352134);
      return;
    }
  }
  
  public final void select(int paramInt)
  {
    AppMethodBeat.i(352148);
    Log.i(this.TAG, "select position:" + paramInt + ", sideBarDataList.size:" + this.DGr.size() + ", curPosition:" + this.CVo);
    if ((paramInt < 0) || (paramInt >= this.DGr.size()) || (this.CVo == paramInt))
    {
      AppMethodBeat.o(352148);
      return;
    }
    this.CVo = paramInt;
    Object localObject1 = ((Iterable)this.DGr).iterator();
    int i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        p.kkW();
      }
      localObject2 = (b)localObject2;
      if (i == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        ((b)localObject2).Bvd = bool;
        i += 1;
        break;
      }
    }
    localObject1 = etB().getAdapter();
    if (localObject1 != null) {
      ((RecyclerView.a)localObject1).bZE.notifyChanged();
    }
    etB().post(new c..ExternalSyntheticLambda2(this));
    AppMethodBeat.o(352148);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar$FinderLiveSideBarConfig;", "Lcom/tencent/mm/plugin/finder/view/sidebar/FinderSideBar$Config;", "(Lcom/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar;)V", "bodyRoot", "Landroid/view/View;", "getBodyRoot", "()Landroid/view/View;", "setBodyRoot", "(Landroid/view/View;)V", "bottomMask", "getBottomMask", "setBottomMask", "closeBtn", "getCloseBtn", "setCloseBtn", "headerExitBtn", "Landroid/widget/ImageView;", "getHeaderExitBtn", "()Landroid/widget/ImageView;", "setHeaderExitBtn", "(Landroid/widget/ImageView;)V", "headerTv", "Landroid/widget/TextView;", "getHeaderTv", "()Landroid/widget/TextView;", "setHeaderTv", "(Landroid/widget/TextView;)V", "isNeedShowExitLiveBtn", "", "()Z", "setNeedShowExitLiveBtn", "(Z)V", "lastInSideBarStatus", "getLastInSideBarStatus", "setLastInSideBarStatus", "topMask", "getTopMask", "setTopMask", "buildBody", "", "Landroidx/constraintlayout/widget/ConstraintLayout;", "buildFooter", "footer", "buildHeader", "header", "buildSideBar", "sideBarRoot", "getDragRate", "", "getTotalAnimationDuration", "", "hideSideBarMask", "onDragFinished", "show", "onDragProgress", "percent", "onDragStarted", "toShow", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends a.a
  {
    TextView DGu;
    View DGv;
    View DGw;
    private boolean DGx;
    private View DGy;
    boolean akft;
    ImageView akfu;
    View niB;
    
    public a()
    {
      AppMethodBeat.i(352055);
      AppMethodBeat.o(352055);
    }
    
    private static final void a(c paramc, View paramView)
    {
      AppMethodBeat.i(352066);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramc);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar$FinderLiveSideBarConfig", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramc, "this$0");
      Log.i(paramc.TAG, "click close btn");
      paramView = com.tencent.mm.ui.component.k.aeZF;
      ((d)com.tencent.mm.ui.component.k.nq(paramc.getContext()).q(d.class)).DGH.DGN = 1;
      paramc.hide();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar$FinderLiveSideBarConfig", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(352066);
    }
    
    public final void cl(float paramFloat)
    {
      AppMethodBeat.i(352140);
      Object localObject1 = this.DGu;
      if (localObject1 != null) {
        ((TextView)localObject1).setAlpha(paramFloat);
      }
      localObject1 = this.DGy;
      label51:
      Object localObject2;
      label65:
      label80:
      label88:
      int i;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (!(localObject1 instanceof ConstraintLayout.LayoutParams)) {
          break label163;
        }
        localObject1 = (ConstraintLayout.LayoutParams)localObject1;
        localObject2 = this.DGy;
        if (localObject2 != null) {
          break label169;
        }
        localObject2 = null;
        if (!(localObject2 instanceof View)) {
          break label179;
        }
        localObject2 = (View)localObject2;
        if (localObject2 != null) {
          break label185;
        }
        localObject2 = null;
        if (localObject1 != null) {
          break label198;
        }
        i = 0;
        label95:
        if ((localObject2 == null) || (localObject1 == null)) {
          break label207;
        }
      }
      label163:
      label169:
      label179:
      label185:
      label198:
      label207:
      for (int j = ((Integer)localObject2).intValue() - ((ConstraintLayout.LayoutParams)localObject1).topMargin - ((ConstraintLayout.LayoutParams)localObject1).bottomMargin;; j = 0)
      {
        localObject1 = this.DGz.DGp;
        if (localObject1 != null) {
          ((c.b)localObject1).c(paramFloat, i, j);
        }
        AppMethodBeat.o(352140);
        return;
        localObject1 = ((View)localObject1).getLayoutParams();
        break;
        localObject1 = null;
        break label51;
        localObject2 = ((View)localObject2).getParent();
        break label65;
        localObject2 = null;
        break label80;
        localObject2 = Integer.valueOf(((View)localObject2).getHeight());
        break label88;
        i = ((ConstraintLayout.LayoutParams)localObject1).width;
        break label95;
      }
    }
    
    public final void e(ConstraintLayout paramConstraintLayout)
    {
      AppMethodBeat.i(352090);
      s.u(paramConstraintLayout, "header");
      ViewGroup.LayoutParams localLayoutParams = paramConstraintLayout.getLayoutParams();
      if (localLayoutParams == null)
      {
        paramConstraintLayout = new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        AppMethodBeat.o(352090);
        throw paramConstraintLayout;
      }
      ((ConstraintLayout.LayoutParams)localLayoutParams).height = (com.tencent.mm.cd.a.fromDPToPix(paramConstraintLayout.getContext(), 64) + bf.getStatusBarHeight(paramConstraintLayout.getContext()));
      this.DGu = ((TextView)paramConstraintLayout.findViewById(p.e.BWy));
      this.akfu = ((ImageView)paramConstraintLayout.findViewById(p.e.VIu));
      paramConstraintLayout = this.DGu;
      if (paramConstraintLayout != null) {
        paramConstraintLayout.setAlpha(0.0F);
      }
      AppMethodBeat.o(352090);
    }
    
    public final long etE()
    {
      return 300L;
    }
    
    public final void f(ConstraintLayout paramConstraintLayout)
    {
      AppMethodBeat.i(352097);
      s.u(paramConstraintLayout, "footer");
      AppMethodBeat.o(352097);
    }
    
    public final void g(ConstraintLayout paramConstraintLayout)
    {
      AppMethodBeat.i(352110);
      s.u(paramConstraintLayout, "sideBarRoot");
      this.DGv = paramConstraintLayout.findViewById(p.e.Cbc);
      this.DGw = paramConstraintLayout.findViewById(p.e.Cbb);
      Object localObject1 = this.DGv;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = this.DGw;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = this.DGz;
      Object localObject2 = paramConstraintLayout.findViewById(p.e.BWN);
      s.s(localObject2, "sideBarRoot.findViewById(R.id.live_group_rv)");
      localObject2 = (WxRecyclerView)localObject2;
      s.u(localObject2, "<set-?>");
      ((c)localObject1).DGq = ((WxRecyclerView)localObject2);
      localObject1 = this.DGz.etB();
      paramConstraintLayout = paramConstraintLayout.getContext();
      s.s(paramConstraintLayout, "sideBarRoot.context");
      ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new FinderLinearLayoutManager(paramConstraintLayout));
      paramConstraintLayout = this.DGz.etB();
      localObject1 = new WxRecyclerAdapter((g)new a(), this.DGz.DGr, true);
      localObject2 = this.DGz;
      ((i)localObject1).agOe = ((i.c)new b((c)localObject2));
      ((WxRecyclerAdapter)localObject1).agOS = ((o)new c(this, (c)localObject2));
      localObject2 = ah.aiuX;
      paramConstraintLayout.setAdapter((RecyclerView.a)localObject1);
      this.DGz.etB().a((RecyclerView.h)new c.a.d(this.DGz));
      com.tencent.mm.view.f.a((RecyclerView)this.DGz.etB(), (e.a)new e(this.DGz));
      this.DGz.etB().a((RecyclerView.l)new f(this.DGz));
      AppMethodBeat.o(352110);
    }
    
    public final void h(ConstraintLayout paramConstraintLayout)
    {
      AppMethodBeat.i(352122);
      s.u(paramConstraintLayout, "bodyRoot");
      Object localObject = this.DGz.BwE.getParent();
      if (localObject == null)
      {
        paramConstraintLayout = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(352122);
        throw paramConstraintLayout;
      }
      ((ViewGroup)localObject).removeView(this.DGz.BwE);
      localObject = new ConstraintLayout.LayoutParams(-1, -1);
      paramConstraintLayout.addView(this.DGz.BwE, 0, (ViewGroup.LayoutParams)localObject);
      this.DGy = ((View)paramConstraintLayout);
      this.niB = paramConstraintLayout.findViewById(p.e.BXf);
      paramConstraintLayout = this.niB;
      if (paramConstraintLayout != null) {
        paramConstraintLayout.setOnClickListener(new c.a..ExternalSyntheticLambda0(this.DGz));
      }
      AppMethodBeat.o(352122);
    }
    
    public final void qk(boolean paramBoolean)
    {
      AppMethodBeat.i(352130);
      Object localObject = com.tencent.mm.ui.component.k.aeZF;
      this.DGx = ((d)com.tencent.mm.ui.component.k.nq(this.DGz.getContext()).q(d.class)).DGD;
      localObject = com.tencent.mm.ui.component.k.aeZF;
      ((d)com.tencent.mm.ui.component.k.nq(this.DGz.getContext()).q(d.class)).rT(true);
      localObject = this.DGz.DGp;
      if (localObject != null) {
        ((c.b)localObject).qk(paramBoolean);
      }
      AppMethodBeat.o(352130);
    }
    
    public final void ql(boolean paramBoolean)
    {
      AppMethodBeat.i(352162);
      Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = com.tencent.mm.ui.component.k.nq(this.DGz.getContext()).q(d.class);
      s.s(localObject1, "UICProvider.of(context).…veSideBarUIC::class.java)");
      localObject1 = (d)localObject1;
      d.a locala;
      Object localObject2;
      int i;
      if ((paramBoolean) && (!this.DGx))
      {
        locala = ((d)localObject1).DGH;
        Object localObject3 = (RecyclerView)this.DGz.etB();
        localObject2 = this.DGz.DGr;
        kotlin.g.a.a locala1 = (kotlin.g.a.a)new g(this.DGz);
        s.u(localObject3, "sideBarRv");
        s.u(localObject2, "sideBarDataList");
        s.u(locala1, "doAfterReport");
        RecyclerView.LayoutManager localLayoutManager = ((RecyclerView)localObject3).getLayoutManager();
        if (localLayoutManager == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(352162);
          throw ((Throwable)localObject1);
        }
        i = ((LinearLayoutManager)localLayoutManager).Ju();
        localObject3 = ((RecyclerView)localObject3).getLayoutManager();
        if (localObject3 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(352162);
          throw ((Throwable)localObject1);
        }
        com.tencent.mm.ae.d.d("SideBarReport", (kotlin.g.a.a)new d.a.b(i, ((LinearLayoutManager)localObject3).Jw(), locala, (ArrayList)localObject2, locala1));
        locala = ((d)localObject1).DGH;
        locala.DGI = cn.bDv();
        localObject2 = com.tencent.mm.ui.component.k.aeZF;
        localObject2 = locala.ai(locala.ai(locala.ai(((bn)com.tencent.mm.ui.component.k.nq((Context)locala.DGO.getContext()).cq(bn.class)).foA(), "event_type", "1"), "model_operat_type", String.valueOf(locala.DGM)), "active_id", String.valueOf(locala.id));
        com.tencent.mm.plugin.finder.live.report.k.Doi.axv((String)localObject2);
        Log.i(d.a(locala.DGO), locala.DGO.DGH.hashCode() + "report reportEnterSideBar " + locala.DGM + ", " + (String)localObject2);
        locala.DGM = 2;
        locala.AUK.clear();
        ((d)localObject1).rT(paramBoolean);
        if (!paramBoolean) {
          break label695;
        }
        localObject1 = this.akfu;
        if (localObject1 != null)
        {
          if (!this.akft) {
            break label689;
          }
          i = 0;
          label433:
          ((ImageView)localObject1).setVisibility(i);
        }
      }
      for (;;)
      {
        localObject1 = this.DGz.DGp;
        if (localObject1 != null) {
          ((c.b)localObject1).ql(paramBoolean);
        }
        AppMethodBeat.o(352162);
        return;
        if ((paramBoolean) || (!this.DGx)) {
          break;
        }
        locala = ((d)localObject1).DGH;
        long l = cn.bDv() - locala.DGI;
        localObject2 = com.tencent.mm.ui.component.k.aeZF;
        localObject2 = locala.ai(locala.ai(locala.ai(locala.ai(((bn)com.tencent.mm.ui.component.k.nq((Context)locala.DGO.getContext()).cq(bn.class)).foA(), "event_type", "2"), "model_operat_type", String.valueOf(locala.DGN)), "model_stay_time", String.valueOf(l)), "active_id", String.valueOf(locala.id));
        com.tencent.mm.plugin.finder.live.report.k.Doi.axv((String)localObject2);
        Log.i(d.a(locala.DGO), locala.DGO.DGH.hashCode() + "report reportExitSideBar " + locala.DGN + ", " + l + ", " + (String)localObject2);
        locala.DGN = 2;
        locala.AUK.clear();
        this.DGz.DGs = false;
        break;
        label689:
        i = 8;
        break label433;
        label695:
        this.akft = false;
        localObject1 = this.akfu;
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(8);
        }
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar$FinderLiveSideBarConfig$buildSideBar$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements g
    {
      public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
      {
        AppMethodBeat.i(351994);
        if (paramInt == b.class.hashCode())
        {
          localObject = (com.tencent.mm.view.recyclerview.f)new e();
          AppMethodBeat.o(351994);
          return localObject;
        }
        s.checkNotNull(null);
        Object localObject = new kotlin.f();
        AppMethodBeat.o(351994);
        throw ((Throwable)localObject);
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar$FinderLiveSideBarConfig$buildSideBar$2$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements i.c<j>
    {
      b(c paramc) {}
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar$FinderLiveSideBarConfig$buildSideBar$2$2", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class c
      implements o
    {
      c(c.a parama, c paramc) {}
      
      public final void a(RecyclerView paramRecyclerView, m paramm)
      {
        AppMethodBeat.i(352010);
        s.u(paramRecyclerView, "recyclerView");
        s.u(paramm, "data");
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(paramRecyclerView, this.DGA, this.DGB));
        AppMethodBeat.o(352010);
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements kotlin.g.a.a<ah>
      {
        a(RecyclerView paramRecyclerView, c.a parama, c paramc)
        {
          super();
        }
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar$FinderLiveSideBarConfig$buildSideBar$4", "Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "ignoreFlingExposed", "", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class e
      extends e.a
    {
      e(c paramc) {}
      
      public final void b(View paramView, List<? extends RecyclerView.v> paramList)
      {
        AppMethodBeat.i(352001);
        s.u(paramView, "parent");
        s.u(paramList, "exposedHolders");
        ArrayList localArrayList;
        HashSet localHashSet;
        RecyclerView.v localv;
        int i;
        int k;
        label115:
        int j;
        if (this.DGz.DGs)
        {
          paramView = com.tencent.mm.ui.component.k.aeZF;
          paramView = ((d)com.tencent.mm.ui.component.k.nq(this.DGz.getContext()).q(d.class)).DGH;
          localArrayList = this.DGz.DGr;
          s.u(localArrayList, "sideBarDataList");
          s.u(paramList, "exposedHolders");
          localHashSet = new HashSet();
          localv = (RecyclerView.v)p.oL(paramList);
          if (localv == null)
          {
            i = 1000;
            k = -1;
            paramList = ((Iterable)paramList).iterator();
            if (!paramList.hasNext()) {
              break label207;
            }
            localv = (RecyclerView.v)paramList.next();
            j = k;
            if (localv.KJ() > k)
            {
              j = k;
              if (localv.KJ() >= 0) {
                j = localv.KJ();
              }
            }
            if ((localv.KJ() >= i) || (localv.KJ() < 0)) {
              break label266;
            }
            i = localv.KJ();
          }
        }
        label266:
        for (;;)
        {
          k = j;
          break label115;
          i = localv.KJ();
          break;
          label207:
          if (i <= k) {}
          for (;;)
          {
            localHashSet.add(Integer.valueOf(i));
            if (i == k)
            {
              com.tencent.mm.ae.d.d("SideBarReport", (kotlin.g.a.a)new d.a.a(localHashSet, paramView, paramView.DGO, localArrayList));
              AppMethodBeat.o(352001);
              return;
            }
            i += 1;
          }
        }
      }
      
      public final boolean dXG()
      {
        return true;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar$FinderLiveSideBarConfig$buildSideBar$5", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class f
      extends RecyclerView.l
    {
      f(c paramc) {}
      
      public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
      {
        AppMethodBeat.i(351999);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramRecyclerView);
        localb.sc(paramInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar$FinderLiveSideBarConfig$buildSideBar$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
        s.u(paramRecyclerView, "recyclerView");
        super.onScrollStateChanged(paramRecyclerView, paramInt);
        if (paramInt == 0)
        {
          paramRecyclerView = this.DGz.etB().getLayoutManager();
          if (!(paramRecyclerView instanceof LinearLayoutManager)) {
            break label147;
          }
          paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
          if (paramRecyclerView != null) {
            break label152;
          }
        }
        label147:
        label152:
        for (paramInt = 0;; paramInt = paramRecyclerView.Jw())
        {
          if (paramInt == this.DGz.DGr.size() - 1)
          {
            paramRecyclerView = this.DGz.DGp;
            if (paramRecyclerView != null) {
              paramRecyclerView.hA(paramInt, this.DGz.DGr.size());
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar$FinderLiveSideBarConfig$buildSideBar$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(351999);
          return;
          paramRecyclerView = null;
          break;
        }
      }
      
      public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(352006);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramRecyclerView);
        localb.sc(paramInt1);
        localb.sc(paramInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar$FinderLiveSideBarConfig$buildSideBar$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
        super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar$FinderLiveSideBarConfig$buildSideBar$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(352006);
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class g
      extends u
      implements kotlin.g.a.a<ah>
    {
      g(c paramc)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar$Listener;", "", "onDragFinished", "", "show", "", "onDragProgress", "percent", "", "width", "", "height", "onDragStarted", "toShow", "onLoadNextPage", "position", "size", "onSelectLive", "fromPos", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void c(float paramFloat, int paramInt1, int paramInt2);
    
    public abstract void hA(int paramInt1, int paramInt2);
    
    public abstract void hC(int paramInt1, int paramInt2);
    
    public abstract void qk(boolean paramBoolean);
    
    public abstract void ql(boolean paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/sidebar/FinderLiveFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<b, CharSequence>
  {
    public static final c DGC;
    
    static
    {
      AppMethodBeat.i(352047);
      DGC = new c();
      AppMethodBeat.o(352047);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.sidebar.c
 * JD-Core Version:    0.7.0.1
 */