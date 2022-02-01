package com.tencent.mm.plugin.finder.profile;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.convert.cu;
import com.tencent.mm.plugin.finder.convert.h;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.model.by;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.e.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.c;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderTopicInfoFeed;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "foldAdapter", "getFoldAdapter", "setFoldAdapter", "foldHeight", "getFoldHeight", "()I", "setFoldHeight", "(I)V", "foldRecyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getFoldRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setFoldRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "isFold", "", "()Z", "setFold", "(Z)V", "layoutManager", "Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager;", "getLayoutManager", "()Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager;", "setLayoutManager", "(Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager;)V", "presenter", "Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterContract;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterContract;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterContract;)V", "recyclerView", "getRecyclerView", "setRecyclerView", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "initView", "", "notifyAdapter", "refresh", "refreshArrow", "report21875", "isClick", "setOnItemClickListener", "showFoldView", "show", "startAnim", "fromHeight", "toHeight", "fromAlpha", "", "toAlpha", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderTopicFilterView
  extends FrameLayout
{
  public static final a FaG;
  WxRecyclerAdapter<by> ALE;
  WxRecyclerView AZd;
  e FaH;
  private WxRecyclerAdapter<by> FaI;
  FlowLayoutManager FaJ;
  private WxRecyclerView FaK;
  private int FaL;
  private boolean evb;
  
  static
  {
    AppMethodBeat.i(348369);
    FaG = new a((byte)0);
    AppMethodBeat.o(348369);
  }
  
  public FinderTopicFilterView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(348230);
    AppMethodBeat.o(348230);
  }
  
  public FinderTopicFilterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(348237);
    AppMethodBeat.o(348237);
  }
  
  public FinderTopicFilterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(348245);
    AppMethodBeat.o(348245);
  }
  
  private final void a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(348262);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    localValueAnimator.setDuration(300L);
    localValueAnimator.addUpdateListener(new FinderTopicFilterView..ExternalSyntheticLambda0(this));
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.FaK, "alpha", new float[] { paramFloat1, paramFloat2 });
    localObjectAnimator.setDuration(300L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localValueAnimator).with((Animator)localObjectAnimator);
    localAnimatorSet.start();
    AppMethodBeat.o(348262);
  }
  
  private static final void a(FinderTopicFilterView paramFinderTopicFilterView)
  {
    AppMethodBeat.i(348299);
    s.u(paramFinderTopicFilterView, "this$0");
    Object localObject1 = paramFinderTopicFilterView.FaH;
    int i;
    label50:
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((e)localObject1).pUj;
      if (localObject1 != null) {
        if (!((Collection)localObject1).isEmpty())
        {
          i = 1;
          if (i != 1) {
            break label176;
          }
          i = 1;
          if (i == 0) {
            break label207;
          }
          localObject1 = (FrameLayout)paramFinderTopicFilterView.findViewById(e.e.filter_arrow_layout);
          if (localObject1 == null) {
            break label221;
          }
          com.tencent.mm.view.f.a((View)localObject1, (e.b)new d(paramFinderTopicFilterView));
          localObject2 = paramFinderTopicFilterView.getLayoutManager();
          if (localObject2 != null)
          {
            localObject3 = paramFinderTopicFilterView.getPresenter();
            if (localObject3 != null) {
              break label181;
            }
            i = 0;
          }
        }
      }
    }
    for (;;)
    {
      if (i > ((FlowLayoutManager)localObject2).eID()) {
        ((FrameLayout)localObject1).setVisibility(0);
      }
      localObject2 = (WeImageView)paramFinderTopicFilterView.findViewById(e.e.filter_arrow_view);
      localObject3 = new ah.c();
      ((ah.c)localObject3).aixa = 180.0F;
      ((FrameLayout)localObject1).setOnClickListener(new FinderTopicFilterView..ExternalSyntheticLambda1((WeImageView)localObject2, (ah.c)localObject3, paramFinderTopicFilterView));
      AppMethodBeat.o(348299);
      return;
      i = 0;
      break;
      label176:
      i = 0;
      break label50;
      label181:
      localObject3 = ((e)localObject3).pUj;
      if (localObject3 == null) {
        i = 0;
      } else {
        i = ((ArrayList)localObject3).size();
      }
    }
    label207:
    paramFinderTopicFilterView = paramFinderTopicFilterView.FaJ;
    if (paramFinderTopicFilterView != null) {
      paramFinderTopicFilterView.evb = false;
    }
    label221:
    AppMethodBeat.o(348299);
  }
  
  private static final void a(FinderTopicFilterView paramFinderTopicFilterView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(348343);
    s.u(paramFinderTopicFilterView, "this$0");
    WxRecyclerView localWxRecyclerView = paramFinderTopicFilterView.getFoldRecyclerView();
    if (localWxRecyclerView != null)
    {
      if (paramValueAnimator == null) {}
      for (paramFinderTopicFilterView = null; paramFinderTopicFilterView == null; paramFinderTopicFilterView = paramValueAnimator.getAnimatedValue())
      {
        paramFinderTopicFilterView = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(348343);
        throw paramFinderTopicFilterView;
      }
      int i = ((Integer)paramFinderTopicFilterView).intValue();
      paramFinderTopicFilterView = localWxRecyclerView.getLayoutParams();
      paramFinderTopicFilterView.height = i;
      localWxRecyclerView.setLayoutParams(paramFinderTopicFilterView);
    }
    AppMethodBeat.o(348343);
  }
  
  private static final void a(FinderTopicFilterView paramFinderTopicFilterView, FlowLayoutManager paramFlowLayoutManager, boolean paramBoolean)
  {
    AppMethodBeat.i(348331);
    s.u(paramFinderTopicFilterView, "this$0");
    s.u(paramFlowLayoutManager, "$foldLayoutManager");
    paramFinderTopicFilterView.setFoldHeight(paramFlowLayoutManager.FaR + com.tencent.mm.cd.a.fromDPToPix(paramFinderTopicFilterView.getContext(), 8));
    paramFinderTopicFilterView.tf(paramBoolean);
    AppMethodBeat.o(348331);
  }
  
  private static final void a(WeImageView paramWeImageView, ah.c paramc, FinderTopicFilterView paramFinderTopicFilterView, View paramView)
  {
    AppMethodBeat.i(348317);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramWeImageView);
    localb.cH(paramc);
    localb.cH(paramFinderTopicFilterView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/FinderTopicFilterView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "$rotation");
    s.u(paramFinderTopicFilterView, "this$0");
    if (paramWeImageView != null) {
      paramWeImageView.setRotation(paramWeImageView.getRotation() + paramc.aixa);
    }
    paramc.aixa = (-paramc.aixa);
    boolean bool;
    int i;
    if (!paramFinderTopicFilterView.evb)
    {
      bool = true;
      paramFinderTopicFilterView.setFold(bool);
      bool = paramFinderTopicFilterView.evb;
      paramWeImageView = new FlowLayoutManager();
      if (paramFinderTopicFilterView.FaK == null)
      {
        paramFinderTopicFilterView.FaK = ((WxRecyclerView)paramFinderTopicFilterView.findViewById(e.e.filter_recycler_view_fold));
        paramc = paramFinderTopicFilterView.FaK;
        if (paramc != null) {
          paramc.a(paramFinderTopicFilterView.getItemDecoration());
        }
        paramc = paramFinderTopicFilterView.FaK;
        if (paramc != null) {
          paramc.setLayoutManager((RecyclerView.LayoutManager)paramWeImageView);
        }
        paramc = paramFinderTopicFilterView.FaJ;
        if (paramc != null) {
          break label384;
        }
        i = 0;
        label206:
        paramc = new ArrayList();
        paramView = paramFinderTopicFilterView.FaH;
        if (paramView != null)
        {
          paramView = paramView.pUj;
          if (paramView != null)
          {
            paramView = paramView.subList(i, paramView.size());
            s.s(paramView, "it.subList(firstRowItemCount, it.size)");
            paramc.addAll((Collection)paramView);
          }
        }
        if (paramc.isEmpty()) {
          break label340;
        }
        paramc = new WxRecyclerAdapter(dUK(), paramc, false);
        paramFinderTopicFilterView.setOnItemClickListener(paramc);
        paramView = ah.aiuX;
        paramFinderTopicFilterView.FaI = paramc;
        paramc = paramFinderTopicFilterView.FaK;
        if (paramc != null) {
          paramc.setAdapter((RecyclerView.a)paramFinderTopicFilterView.FaI);
        }
        paramc = paramFinderTopicFilterView.FaK;
        if (paramc != null) {
          paramc.setVisibility(0);
        }
      }
      if (paramFinderTopicFilterView.FaL <= 0) {
        break label393;
      }
      paramFinderTopicFilterView.tf(bool);
    }
    for (;;)
    {
      label340:
      paramFinderTopicFilterView.al(true, paramFinderTopicFilterView.evb);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/FinderTopicFilterView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(348317);
      return;
      bool = false;
      break;
      label384:
      i = paramc.eID();
      break label206;
      label393:
      paramc = paramFinderTopicFilterView.FaK;
      if (paramc != null) {
        paramc.post(new FinderTopicFilterView..ExternalSyntheticLambda3(paramFinderTopicFilterView, paramWeImageView, bool));
      }
    }
  }
  
  private final void al(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(348275);
    int i;
    String str;
    if (paramBoolean1)
    {
      i = 1;
      if (!paramBoolean2) {
        break label79;
      }
      str = "fold";
      label21:
      localObject = bb.FuK;
      localObject = as.GSQ;
      localObject = getContext();
      s.s(localObject, "context");
      localObject = as.a.hu((Context)localObject);
      if (localObject != null) {
        break label87;
      }
    }
    label79:
    label87:
    for (Object localObject = null;; localObject = ((as)localObject).fou())
    {
      bb.a((bui)localObject, str, i);
      AppMethodBeat.o(348275);
      return;
      i = 0;
      break;
      str = "unfold";
      break label21;
    }
  }
  
  public static com.tencent.mm.view.recyclerview.g dUK()
  {
    AppMethodBeat.i(348286);
    com.tencent.mm.view.recyclerview.g localg = (com.tencent.mm.view.recyclerview.g)new b();
    AppMethodBeat.o(348286);
    return localg;
  }
  
  private final void tf(boolean paramBoolean)
  {
    AppMethodBeat.i(348252);
    if (paramBoolean)
    {
      a(0, this.FaL, 0.0F, 1.0F);
      AppMethodBeat.o(348252);
      return;
    }
    a(this.FaL, 0, 1.0F, 0.0F);
    AppMethodBeat.o(348252);
  }
  
  public final void bDL()
  {
    AppMethodBeat.i(348492);
    Log.i("Finder.FinderTopicFilterView", "refresh");
    Object localObject = this.FaJ;
    if (localObject != null) {
      ((FlowLayoutManager)localObject).evb = true;
    }
    localObject = this.AZd;
    if (localObject != null)
    {
      localObject = ((WxRecyclerView)localObject).getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).bZE.notifyChanged();
      }
    }
    localObject = this.AZd;
    if (localObject != null) {
      ((WxRecyclerView)localObject).post(new FinderTopicFilterView..ExternalSyntheticLambda2(this));
    }
    AppMethodBeat.o(348492);
  }
  
  public final WxRecyclerAdapter<by> getAdapter()
  {
    return this.ALE;
  }
  
  public final WxRecyclerAdapter<by> getFoldAdapter()
  {
    return this.FaI;
  }
  
  public final int getFoldHeight()
  {
    return this.FaL;
  }
  
  public final WxRecyclerView getFoldRecyclerView()
  {
    return this.FaK;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(348500);
    RecyclerView.h localh = (RecyclerView.h)new c();
    AppMethodBeat.o(348500);
    return localh;
  }
  
  public final FlowLayoutManager getLayoutManager()
  {
    return this.FaJ;
  }
  
  public final e getPresenter()
  {
    return this.FaH;
  }
  
  public final WxRecyclerView getRecyclerView()
  {
    return this.AZd;
  }
  
  public final void setAdapter(WxRecyclerAdapter<by> paramWxRecyclerAdapter)
  {
    this.ALE = paramWxRecyclerAdapter;
  }
  
  public final void setFold(boolean paramBoolean)
  {
    this.evb = paramBoolean;
  }
  
  public final void setFoldAdapter(WxRecyclerAdapter<by> paramWxRecyclerAdapter)
  {
    this.FaI = paramWxRecyclerAdapter;
  }
  
  public final void setFoldHeight(int paramInt)
  {
    this.FaL = paramInt;
  }
  
  public final void setFoldRecyclerView(WxRecyclerView paramWxRecyclerView)
  {
    this.FaK = paramWxRecyclerView;
  }
  
  public final void setLayoutManager(FlowLayoutManager paramFlowLayoutManager)
  {
    this.FaJ = paramFlowLayoutManager;
  }
  
  final void setOnItemClickListener(WxRecyclerAdapter<by> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(348483);
    paramWxRecyclerAdapter.agOe = ((i.c)new e(paramWxRecyclerAdapter, this));
    AppMethodBeat.o(348483);
  }
  
  public final void setPresenter(e parame)
  {
    this.FaH = parame;
  }
  
  public final void setRecyclerView(WxRecyclerView paramWxRecyclerView)
  {
    this.AZd = paramWxRecyclerView;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterView$Companion;", "", "()V", "FOLD_ANIM_TIME", "", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/FinderTopicFilterView$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.view.recyclerview.g
  {
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(348229);
      switch (paramInt)
      {
      default: 
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
        {
          localObject = new RuntimeException("type invalid");
          AppMethodBeat.o(348229);
          throw ((Throwable)localObject);
        }
        break;
      case 1: 
        localObject = (com.tencent.mm.view.recyclerview.f)new cu();
        AppMethodBeat.o(348229);
        return localObject;
      case 2: 
        localObject = (com.tencent.mm.view.recyclerview.f)new h();
        AppMethodBeat.o(348229);
        return localObject;
      }
      Log.printInfoStack("Finder.FinderTopicFilterView", "type invalid", new Object[0]);
      Object localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.g();
      AppMethodBeat.o(348229);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/FinderTopicFilterView$getItemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(348278);
      s.u(paramRect, "outRect");
      s.u(paramView, "view");
      s.u(paramRecyclerView, "parent");
      s.u(params, "state");
      int i = (int)paramView.getContext().getResources().getDimension(e.c.Edge_0_5_A);
      paramRect.left = i;
      paramRect.right = i;
      paramRect.bottom = i;
      paramRect.top = i;
      AppMethodBeat.o(348278);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/FinderTopicFilterView$refreshArrow$1$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends e.b
  {
    d(FinderTopicFilterView paramFinderTopicFilterView) {}
    
    public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(348258);
      s.u(paramView, "view");
      if (paramBoolean) {
        FinderTopicFilterView.c(this.FaM);
      }
      AppMethodBeat.o(348258);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/FinderTopicFilterView$setOnItemClickListener$1$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements i.c<j>
  {
    e(WxRecyclerAdapter<by> paramWxRecyclerAdapter, FinderTopicFilterView paramFinderTopicFilterView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.FinderTopicFilterView
 * JD-Core Version:    0.7.0.1
 */