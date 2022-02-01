package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.b.d;
import com.tencent.mm.plugin.finder.live.b.e;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.view.FinderMaxSizeLayout;
import com.tencent.mm.plugin.finder.live.viewmodel.data.a.f.d;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bf;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBoxCommentPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Lcom/tencent/mm/plugin/finder/live/gala/viewpager/ICommentViewSelect;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "value", "", "attachBoxId", "getAttachBoxId", "()Ljava/lang/String;", "setAttachBoxId", "(Ljava/lang/String;)V", "boxCommentAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BaseBoxMsg;", "getBoxCommentAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setBoxCommentAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "boxCommentList", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getBoxCommentList", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "boxCommentList$delegate", "Lkotlin/Lazy;", "canClear", "", "commentActionPresenter", "Lcom/tencent/mm/plugin/finder/live/comment/BoxCommentActionPresenter;", "getCommentActionPresenter", "()Lcom/tencent/mm/plugin/finder/live/comment/BoxCommentActionPresenter;", "commentActionPresenter$delegate", "commentListGlobalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "getCommentListGlobalLayoutListener", "()Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "commentListGlobalLayoutListener$delegate", "commentListPresenter", "Lcom/tencent/mm/plugin/finder/live/comment/BoxCommentListPresenter;", "getCommentListPresenter", "()Lcom/tencent/mm/plugin/finder/live/comment/BoxCommentListPresenter;", "commentListPresenter$delegate", "commentListVisible", "getCommentListVisible", "()Z", "setCommentListVisible", "(Z)V", "commentViewCallback", "Lcom/tencent/mm/plugin/finder/live/comment/BoxCommentViewCallback;", "getCommentViewCallback", "()Lcom/tencent/mm/plugin/finder/live/comment/BoxCommentViewCallback;", "commentViewCallback$delegate", "isFirstPageCommentData", "setFirstPageCommentData", "scrollListener", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveBoxCommentPlugin$scrollListener$2$1", "getScrollListener", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBoxCommentPlugin$scrollListener$2$1;", "scrollListener$delegate", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "", "boxId", "param", "Landroid/os/Bundle;", "canClearScreen", "changeMaxSize", "maxHeight", "", "createBoxComment", "fromMiniWindow", "getAndResetFirstPageFlag", "getCommentList", "", "getCommentListItemCount", "getCommentRootView", "Landroid/view/View;", "mount", "onSelected", "isSelected", "onViewVisible", "visible", "pauseBoxComment", "printDebugMsg", "prefix", "notifyMsg", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxDataStore$NotifyMsg;", "resumeBoxComment", "hasRedDot", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "unMount", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cy
  extends b
  implements com.tencent.mm.plugin.finder.live.gala.viewpager.a
{
  private static final j<Rect> agxA;
  public static final b agxp;
  private boolean CXU;
  public String agxq;
  private boolean agxr;
  public boolean agxs;
  private final j agxt;
  private final j agxu;
  private final j agxv;
  public WxRecyclerAdapter<com.tencent.mm.plugin.finder.live.viewmodel.data.a.b> agxw;
  private final j agxx;
  private final j agxy;
  private final j agxz;
  public final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(371372);
    agxp = new b((byte)0);
    agxA = kotlin.k.cm((kotlin.g.a.a)c.agxB);
    AppMethodBeat.o(371372);
  }
  
  public cy(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(371367);
    this.nfT = paramb;
    this.agxq = "";
    this.agxt = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.agxu = kotlin.k.cm((kotlin.g.a.a)new j(this));
    this.agxv = kotlin.k.cm((kotlin.g.a.a)new e(paramViewGroup, this));
    this.agxx = kotlin.k.cm((kotlin.g.a.a)new h(paramViewGroup, this));
    this.agxy = kotlin.k.cm((kotlin.g.a.a)new f(paramViewGroup, this));
    this.agxz = kotlin.k.cm((kotlin.g.a.a)new i(this));
    this.CXU = true;
    int i;
    if (isLandscape()) {
      i = (int)(bf.bf(MMApplicationContext.getContext()).y * 0.22D);
    }
    for (int j = bf.bf(MMApplicationContext.getContext()).x;; j = bf.bf(MMApplicationContext.getContext()).x)
    {
      paramb = (FinderMaxSizeLayout)paramViewGroup.findViewById(p.e.HHE);
      paramb.setMaxHeight(i);
      paramb.setForbidHorizontalScroll(true);
      paramb = jdt();
      paramb.getRootView().getContext();
      paramb.setLayoutManager((RecyclerView.LayoutManager)new FinderLiveBoxCommentPlugin.2.1());
      paramb.a((RecyclerView.h)new a(paramViewGroup));
      paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a((b)this, true);
      AppMethodBeat.o(371367);
      return;
      i = (int)(bf.bf(MMApplicationContext.getContext()).y * 0.25D);
    }
  }
  
  private void PV(boolean paramBoolean)
  {
    AppMethodBeat.i(371370);
    if (paramBoolean)
    {
      jdu().gOb();
      jdu().aqk(jdy());
      AppMethodBeat.o(371370);
      return;
    }
    jdu().epQ();
    AppMethodBeat.o(371370);
  }
  
  public final void NQ(boolean paramBoolean)
  {
    AppMethodBeat.i(371375);
    if (paramBoolean != this.agxr) {
      Log.i("FinderLiveBoxCommentPlugin", "isFirstPageCommentData from " + this.agxr + " to " + paramBoolean);
    }
    this.agxr = paramBoolean;
    AppMethodBeat.o(371375);
  }
  
  public final void NR(boolean paramBoolean)
  {
    AppMethodBeat.i(371376);
    if (paramBoolean != this.agxs)
    {
      Log.i("FinderLiveBoxCommentPlugin", "commentListVisible " + hashCode() + " from " + this.agxs + " to " + paramBoolean);
      PV(paramBoolean);
    }
    this.agxs = paramBoolean;
    AppMethodBeat.o(371376);
  }
  
  public final void a(String paramString, f.d paramd)
  {
    AppMethodBeat.i(371395);
    kotlin.g.b.s.u(paramString, "prefix");
    kotlin.g.b.s.u(paramd, "notifyMsg");
    Object localObject = aw.Gjk;
    StringBuilder localStringBuilder;
    int i;
    int j;
    int k;
    if (aw.bgV())
    {
      localStringBuilder = new StringBuilder(kotlin.g.b.s.X(paramString, ":"));
      paramString = this.agxw;
      if (paramString != null) {
        break label161;
      }
      localObject = null;
      i = paramd.start;
      j = paramd.start;
      k = paramd.count + j;
      if (i >= k) {}
    }
    for (;;)
    {
      j = i + 1;
      paramd = new StringBuilder("[").append(i).append(',');
      if (localObject == null) {
        paramString = null;
      }
      for (;;)
      {
        localStringBuilder.append(paramString + ']');
        if (j < k) {
          break label200;
        }
        Log.i("FinderLiveBoxCommentPlugin", String.valueOf(localStringBuilder));
        AppMethodBeat.o(371395);
        return;
        label161:
        localObject = (List)paramString.data;
        break;
        paramString = (com.tencent.mm.plugin.finder.live.viewmodel.data.a.b)p.ae((List)localObject, i);
        if (paramString == null) {
          paramString = null;
        } else {
          paramString = paramString.eYN();
        }
      }
      label200:
      i = j;
    }
  }
  
  public final void aql(int paramInt)
  {
    AppMethodBeat.i(371399);
    ((FinderMaxSizeLayout)this.mJe.findViewById(p.e.HHE)).setMaxHeight(paramInt);
    AppMethodBeat.o(371399);
  }
  
  public final void bko(String paramString)
  {
    AppMethodBeat.i(371374);
    kotlin.g.b.s.u(paramString, "value");
    if (!kotlin.g.b.s.p(paramString, this.agxq)) {
      Log.i("FinderLiveBoxCommentPlugin", "attachBoxId from:" + this.agxq + " to " + paramString);
    }
    this.agxq = paramString;
    AppMethodBeat.o(371374);
  }
  
  public final boolean eoI()
  {
    AppMethodBeat.i(371390);
    if ((isLandscape()) || (this.CXU))
    {
      AppMethodBeat.o(371390);
      return true;
    }
    AppMethodBeat.o(371390);
    return false;
  }
  
  public final View ivt()
  {
    return (View)this.mJe;
  }
  
  public final ViewTreeObserver.OnGlobalLayoutListener jdr()
  {
    AppMethodBeat.i(371377);
    ViewTreeObserver.OnGlobalLayoutListener localOnGlobalLayoutListener = (ViewTreeObserver.OnGlobalLayoutListener)this.agxt.getValue();
    AppMethodBeat.o(371377);
    return localOnGlobalLayoutListener;
  }
  
  public final cy.j.1 jds()
  {
    AppMethodBeat.i(371379);
    cy.j.1 local1 = (cy.j.1)this.agxu.getValue();
    AppMethodBeat.o(371379);
    return local1;
  }
  
  public final WxRecyclerView jdt()
  {
    AppMethodBeat.i(371382);
    Object localObject = this.agxv.getValue();
    kotlin.g.b.s.s(localObject, "<get-boxCommentList>(...)");
    localObject = (WxRecyclerView)localObject;
    AppMethodBeat.o(371382);
    return localObject;
  }
  
  public final d jdu()
  {
    AppMethodBeat.i(371384);
    d locald = (d)this.agxx.getValue();
    AppMethodBeat.o(371384);
    return locald;
  }
  
  public final com.tencent.mm.plugin.finder.live.b.a jdv()
  {
    AppMethodBeat.i(371386);
    com.tencent.mm.plugin.finder.live.b.a locala = (com.tencent.mm.plugin.finder.live.b.a)this.agxy.getValue();
    AppMethodBeat.o(371386);
    return locala;
  }
  
  public final e jdw()
  {
    AppMethodBeat.i(371387);
    e locale = (e)this.agxz.getValue();
    AppMethodBeat.o(371387);
    return locale;
  }
  
  public final void jdx()
  {
    AppMethodBeat.i(371392);
    Log.i("FinderLiveBoxCommentPlugin", "pauseBoxComment " + hashCode() + " id:" + this.agxq);
    ViewTreeObserver localViewTreeObserver = jdt().getViewTreeObserver();
    if (localViewTreeObserver != null) {
      localViewTreeObserver.removeOnGlobalLayoutListener(jdr());
    }
    jdt().b((RecyclerView.l)jds());
    NR(false);
    AppMethodBeat.o(371392);
  }
  
  public final int jdy()
  {
    AppMethodBeat.i(371394);
    WxRecyclerAdapter localWxRecyclerAdapter = this.agxw;
    if (localWxRecyclerAdapter == null)
    {
      AppMethodBeat.o(371394);
      return 0;
    }
    int i = localWxRecyclerAdapter.getItemCount();
    AppMethodBeat.o(371394);
    return i;
  }
  
  public final boolean jdz()
  {
    AppMethodBeat.i(371396);
    if (this.agxr)
    {
      NQ(false);
      AppMethodBeat.o(371396);
      return true;
    }
    AppMethodBeat.o(371396);
    return false;
  }
  
  public final void mount()
  {
    AppMethodBeat.i(371397);
    super.mount();
    Log.i("FinderLiveBoxCommentPlugin", kotlin.g.b.s.X("mount ", Integer.valueOf(hashCode())));
    AppMethodBeat.o(371397);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    boolean bool2 = false;
    AppMethodBeat.i(371388);
    kotlin.g.b.s.u(paramc, "status");
    switch (d.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(371388);
      return;
    case 1: 
      AppMethodBeat.o(371388);
      return;
    }
    if (paramBundle == null) {}
    for (boolean bool1 = false;; bool1 = paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT"))
    {
      if (!bool1) {
        bool2 = true;
      }
      this.CXU = bool2;
      break;
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(371398);
    Log.i("FinderLiveBoxCommentPlugin", "unMount " + hashCode() + " commentListVisible:" + this.agxs);
    NR(false);
    bko("");
    this.CXU = true;
    ViewTreeObserver localViewTreeObserver = jdt().getViewTreeObserver();
    if (localViewTreeObserver != null) {
      localViewTreeObserver.removeOnGlobalLayoutListener(jdr());
    }
    jdt().b((RecyclerView.l)jds());
    Log.i("BoxCommentListPresenter", kotlin.g.b.s.X("isFinished:", Boolean.valueOf(jdu().Zut.isFinished())));
    AppMethodBeat.o(371398);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveBoxCommentPlugin$2$2", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.h
  {
    a(ViewGroup paramViewGroup) {}
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(371348);
      kotlin.g.b.s.u(paramRect, "outRect");
      kotlin.g.b.s.u(paramView, "view");
      kotlin.g.b.s.u(paramRecyclerView, "parent");
      kotlin.g.b.s.u(params, "state");
      paramRect.left = 0;
      paramRect.right = 0;
      paramRect.top = 0;
      paramRect.bottom = this.nhV.getContext().getResources().getDimensionPixelOffset(p.c.Edge_0_5_A);
      AppMethodBeat.o(371348);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBoxCommentPlugin$Companion;", "", "()V", "H_SCALE_LANDSCAPE", "", "H_SCALE_PORTRAIT", "SCREEN_RECT", "Landroid/graphics/Rect;", "getSCREEN_RECT", "()Landroid/graphics/Rect;", "SCREEN_RECT$delegate", "Lkotlin/Lazy;", "TAG", "", "W_SCALE_LANDSCAPE", "W_SCALE_PORTRAIT", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static Rect jdB()
    {
      AppMethodBeat.i(371341);
      Rect localRect = (Rect)cy.jdA().getValue();
      AppMethodBeat.o(371341);
      return localRect;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/graphics/Rect;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Rect>
  {
    public static final c agxB;
    
    static
    {
      AppMethodBeat.i(371339);
      agxB = new c();
      AppMethodBeat.o(371339);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<WxRecyclerView>
  {
    e(ViewGroup paramViewGroup, cy paramcy)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/comment/BoxCommentActionPresenter;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.b.a>
  {
    f(ViewGroup paramViewGroup, cy paramcy)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ViewTreeObserver.OnGlobalLayoutListener>
  {
    g(cy paramcy)
    {
      super();
    }
    
    private static final void a(cy paramcy)
    {
      AppMethodBeat.i(371468);
      kotlin.g.b.s.u(paramcy, "this$0");
      boolean bool;
      if (paramcy.jdt().isShown())
      {
        Object localObject = cy.agxp;
        if (cy.b.jdB().right > 0)
        {
          localObject = cy.agxp;
          if (cy.b.jdB().bottom > 0)
          {
            localObject = new Rect();
            paramcy.jdt().getGlobalVisibleRect((Rect)localObject);
            if (paramcy.jdt().isShown())
            {
              cy.b localb = cy.agxp;
              if (((Rect)localObject).intersect(cy.b.jdB())) {
                bool = true;
              }
            }
          }
        }
      }
      for (;;)
      {
        paramcy.NR(bool);
        AppMethodBeat.o(371468);
        return;
        bool = false;
        continue;
        bool = paramcy.jdt().isShown();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/comment/BoxCommentListPresenter;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<d>
  {
    h(ViewGroup paramViewGroup, cy paramcy)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/comment/BoxCommentViewCallback;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<e>
  {
    i(cy paramcy)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveBoxCommentPlugin$scrollListener$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<1>
  {
    j(cy paramcy)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cy
 * JD-Core Version:    0.7.0.1
 */