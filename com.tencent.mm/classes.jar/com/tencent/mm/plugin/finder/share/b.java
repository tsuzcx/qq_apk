package com.tencent.mm.plugin.finder.share;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.report.ac;
import com.tencent.mm.plugin.finder.report.ac.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ao.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.videocomposition.effect.d;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/share/FinderShareSideGuideUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "adapter", "Lcom/tencent/mm/plugin/finder/share/FinderShareSideGuideUIC$RvAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/finder/share/FinderShareSideGuideUIC$RvAdapter;", "setAdapter", "(Lcom/tencent/mm/plugin/finder/share/FinderShareSideGuideUIC$RvAdapter;)V", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFinderObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFinderObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "hasClick", "", "getHasClick", "()Z", "setHasClick", "(Z)V", "hideAnimator", "Landroid/animation/Animator;", "getHideAnimator", "()Landroid/animation/Animator;", "setHideAnimator", "(Landroid/animation/Animator;)V", "isShowing", "setShowing", "lastVisiblePosition", "", "getLastVisiblePosition", "()I", "setLastVisiblePosition", "(I)V", "onGlobalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "getOnGlobalLayoutListener", "()Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "setOnGlobalLayoutListener", "(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V", "outsideRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getOutsideRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setOutsideRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "position", "getPosition", "setPosition", "showAnimator", "getShowAnimator", "setShowAnimator", "sideLayout", "Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;", "getSideLayout", "()Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;", "setSideLayout", "(Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;)V", "sideRecyclerView", "getSideRecyclerView", "setSideRecyclerView", "clearClickSideData", "", "handleOnExit", "hideGuideView", "initOutsideRecyclerView", "recyclerView", "initViews", "finderObjects", "", "onClickSideItem", "onDestroy", "report", "eventCode", "setBlur", "blurRadius", "", "factor", "setData", "objects", "setTopMargin", "shouldShowTips", "showGuideView", "Companion", "RvAdapter", "RvItemDecoration", "ViewHolder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends UIComponent
{
  public static final a FzO;
  FinderObject ABJ;
  public RoundCornerRelativeLayout FzP;
  private RecyclerView FzQ;
  RecyclerView FzR;
  private b.b FzS;
  boolean FzT;
  int FzU;
  ViewTreeObserver.OnGlobalLayoutListener FzV;
  private boolean fhR;
  int position;
  private Animator vjw;
  private Animator vjx;
  
  static
  {
    AppMethodBeat.i(330732);
    FzO = new a((byte)0);
    AppMethodBeat.o(330732);
  }
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(330696);
    this.FzU = -1;
    this.position = -1;
    AppMethodBeat.o(330696);
  }
  
  public b(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(330682);
    this.FzU = -1;
    this.position = -1;
    AppMethodBeat.o(330682);
  }
  
  private static final void a(b paramb, float paramFloat)
  {
    Object localObject4 = null;
    AppMethodBeat.i(330715);
    s.u(paramb, "this$0");
    Object localObject1 = paramb.FzP;
    if (localObject1 != null)
    {
      double d1 = ao.mX((Context)paramb.getContext()).height;
      double d2 = ((RoundCornerRelativeLayout)localObject1).getHeight() >> 1;
      localObject1 = ((RoundCornerRelativeLayout)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(330715);
        throw paramb;
      }
      ((FrameLayout.LayoutParams)localObject1).topMargin = ((int)(d1 * 0.45D - d2));
    }
    localObject1 = paramb.FzP;
    Object localObject2;
    label124:
    com.tencent.mm.videocomposition.effect.a locala;
    Object localObject3;
    int j;
    label150:
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = paramb.FzP;
      if (localObject2 != null) {
        break label375;
      }
      localObject2 = null;
      locala = new com.tencent.mm.videocomposition.effect.a();
      localObject3 = paramb.getActivity().getResources();
      if (localObject3 != null) {
        break label391;
      }
      j = 0;
      localObject3 = paramb.FzP;
      if (localObject3 != null) {
        break label404;
      }
      i = 0;
      label164:
      if (i > 0) {
        break label583;
      }
      i = 900;
    }
    label182:
    label583:
    for (;;)
    {
      if (localObject1 == null)
      {
        localObject3 = null;
        if (localObject3 != null) {
          ((ViewGroup.LayoutParams)localObject3).height = i;
        }
        if (localObject2 != null) {
          break label424;
        }
      }
      for (localObject3 = localObject4;; localObject3 = ((ImageView)localObject2).getLayoutParams())
      {
        if (localObject3 != null) {
          ((ViewGroup.LayoutParams)localObject3).height = i;
        }
        localObject3 = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
        ((Bitmap)localObject3).eraseColor(Color.parseColor("#61F0F0F0"));
        s.s(localObject3, "bitmap");
        locala.setInputBitmap((Bitmap)localObject3);
        locala.setOutputSize(j, i);
        localObject3 = locala.HkF.GpO.jQj();
        ((com.tencent.mm.xeffect.effect.b)localObject3).setRadius(paramFloat);
        ((com.tencent.mm.xeffect.effect.b)localObject3).eC(5.0F);
        locala.aW((kotlin.g.a.b)new g((ImageView)localObject1));
        if (localObject2 != null) {
          ((ImageView)localObject2).setImageDrawable((Drawable)new ColorDrawable(paramb.getActivity().getResources().getColor(e.b.Blur_3)));
        }
        if ((!paramb.fhR) && (paramb.FzP != null)) {
          break label434;
        }
        AppMethodBeat.o(330715);
        return;
        localObject1 = (ImageView)((RoundCornerRelativeLayout)localObject1).findViewById(e.e.bg_blur);
        break;
        label375:
        localObject2 = (ImageView)((RoundCornerRelativeLayout)localObject2).findViewById(e.e.bg_mask);
        break label124;
        j = ((Resources)localObject3).getDimensionPixelSize(e.c.Edge_9A);
        break label150;
        i = ((RoundCornerRelativeLayout)localObject3).getHeight();
        break label164;
        localObject3 = ((ImageView)localObject1).getLayoutParams();
        break label182;
      }
      paramb.vjw = ((Animator)ObjectAnimator.ofFloat(paramb.FzP, "alpha", new float[] { 0.0F, 1.0F }));
      localObject1 = paramb.vjw;
      if (localObject1 != null) {
        ((Animator)localObject1).addListener((Animator.AnimatorListener)new h(paramb));
      }
      localObject1 = paramb.vjw;
      if (localObject1 != null) {
        ((Animator)localObject1).setDuration(280L);
      }
      localObject1 = paramb.vjw;
      if (localObject1 != null) {
        ((Animator)localObject1).start();
      }
      paramb.fhR = true;
      localObject1 = paramb.FzP;
      if (localObject1 != null)
      {
        localObject1 = (WeImageView)((RoundCornerRelativeLayout)localObject1).findViewById(e.e.finder_share_guide_close);
        if (localObject1 != null) {
          ((WeImageView)localObject1).setOnClickListener(new b..ExternalSyntheticLambda0(paramb));
        }
      }
      paramb.rG(3);
      AppMethodBeat.o(330715);
      return;
    }
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(330726);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/share/FinderShareSideGuideUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb.ePD();
    paramb.rG(5);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/share/FinderShareSideGuideUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(330726);
  }
  
  public final void C(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(330789);
    s.u(paramRecyclerView, "recyclerView");
    this.FzR = paramRecyclerView;
    paramRecyclerView = this.FzR;
    if (paramRecyclerView != null) {
      paramRecyclerView.a((RecyclerView.l)new f(this));
    }
    AppMethodBeat.o(330789);
  }
  
  public final void ePD()
  {
    AppMethodBeat.i(330773);
    if (!this.fhR)
    {
      AppMethodBeat.o(330773);
      return;
    }
    this.fhR = false;
    this.vjx = ((Animator)ObjectAnimator.ofFloat(this.FzP, "alpha", new float[] { 1.0F, 0.0F }));
    Animator localAnimator = this.vjx;
    if (localAnimator != null) {
      localAnimator.setDuration(280L);
    }
    localAnimator = this.vjx;
    if (localAnimator != null) {
      localAnimator.addListener((Animator.AnimatorListener)new e(this));
    }
    localAnimator = this.vjx;
    if (localAnimator != null) {
      localAnimator.start();
    }
    AppMethodBeat.o(330773);
  }
  
  public final void hw(List<? extends FinderObject> paramList)
  {
    AppMethodBeat.i(330759);
    s.u(paramList, "finderObjects");
    Object localObject = (ViewStub)getActivity().findViewById(e.e.right_side_guide_list);
    if (localObject == null)
    {
      AppMethodBeat.o(330759);
      return;
    }
    localObject = ((ViewStub)localObject).inflate();
    if (localObject == null)
    {
      paramList = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.RoundCornerRelativeLayout");
      AppMethodBeat.o(330759);
      throw paramList;
    }
    this.FzP = ((RoundCornerRelativeLayout)localObject);
    localObject = this.FzP;
    if (localObject != null)
    {
      ((RoundCornerRelativeLayout)localObject).setVisibility(8);
      this.FzQ = ((RecyclerView)((RoundCornerRelativeLayout)localObject).findViewById(e.e.finder_share_guide_rv));
      float f = getActivity().getResources().getDimension(e.c.Edge_A);
      ((RoundCornerRelativeLayout)localObject).A(f, 0.0F, f, 0.0F);
      this.FzV = new b..ExternalSyntheticLambda1(this, f);
      localObject = ((RoundCornerRelativeLayout)localObject).getViewTreeObserver();
      if (localObject != null) {
        ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(this.FzV);
      }
      this.FzS = new b.b(this, (Context)getActivity());
      localObject = this.FzQ;
      if (localObject != null) {
        ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.FzS);
      }
      localObject = this.FzQ;
      if (localObject != null)
      {
        getActivity();
        ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
      }
      localObject = this.FzQ;
      if (localObject != null) {
        ((RecyclerView)localObject).a((RecyclerView.h)new c((int)f));
      }
      localObject = this.FzS;
      if (localObject != null)
      {
        s.u(paramList, "objects");
        ((b.b)localObject).ALu.clear();
        ((b.b)localObject).ALu.addAll((Collection)paramList);
        ((RecyclerView.a)localObject).bZE.notifyChanged();
      }
    }
    AppMethodBeat.o(330759);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(330802);
    super.onDestroy();
    Animator localAnimator = this.vjw;
    if (localAnimator != null) {
      localAnimator.cancel();
    }
    localAnimator = this.vjx;
    if (localAnimator != null) {
      localAnimator.cancel();
    }
    AppMethodBeat.o(330802);
  }
  
  public final void rG(int paramInt)
  {
    AppMethodBeat.i(330813);
    ac.a locala = ac.Fsk;
    ac.eNa();
    ac.e((Context)getActivity(), paramInt, "right");
    AppMethodBeat.o(330813);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/share/FinderShareSideGuideUIC$Companion;", "", "()V", "ANIMATION_TIME", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/share/FinderShareSideGuideUIC$RvItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "space", "", "(Lcom/tencent/mm/plugin/finder/share/FinderShareSideGuideUIC;I)V", "getSpace", "()I", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "itemPosition", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends RecyclerView.h
  {
    private final int space;
    
    public c()
    {
      AppMethodBeat.i(330603);
      int i;
      this.space = i;
      AppMethodBeat.o(330603);
    }
    
    public final void a(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(330609);
      s.u(paramRect, "outRect");
      s.u(paramRecyclerView, "parent");
      super.a(paramRect, paramInt, paramRecyclerView);
      paramRect.bottom = this.space;
      AppMethodBeat.o(330609);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/share/FinderShareSideGuideUIC$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/share/FinderShareSideGuideUIC;Landroid/view/View;)V", "coverIv", "Landroid/widget/ImageView;", "getCoverIv", "()Landroid/widget/ImageView;", "setCoverIv", "(Landroid/widget/ImageView;)V", "strokeView", "getStrokeView", "()Landroid/view/View;", "setStrokeView", "(Landroid/view/View;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends RecyclerView.v
  {
    View FzY;
    ImageView coverIv;
    
    public d()
    {
      super();
      AppMethodBeat.i(330608);
      ((RoundCornerRelativeLayout)localObject).setRadius(((RoundCornerRelativeLayout)localObject).getContext().getResources().getDimension(e.c.Edge_0_5_A));
      this.coverIv = ((ImageView)localObject.findViewById(e.e.guide_item_iv));
      this.FzY = localObject.findViewById(e.e.guide_item_stroke);
      AppMethodBeat.o(330608);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/share/FinderShareSideGuideUIC$hideGuideView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends AnimatorListenerAdapter
  {
    e(b paramb) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(330614);
      super.onAnimationEnd(paramAnimator);
      paramAnimator = this.FzX.FzP;
      if (paramAnimator != null) {
        paramAnimator.setVisibility(8);
      }
      AppMethodBeat.o(330614);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/share/FinderShareSideGuideUIC$initOutsideRecyclerView$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends RecyclerView.l
  {
    f(b paramb) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(330618);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/share/FinderShareSideGuideUIC$initOutsideRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0)
      {
        paramRecyclerView = this.FzX.FzR;
        if (paramRecyclerView == null) {}
        for (paramRecyclerView = null; paramRecyclerView == null; paramRecyclerView = paramRecyclerView.getLayoutManager())
        {
          paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(330618);
          throw paramRecyclerView;
        }
        paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
        this.FzX.FzU = paramRecyclerView.Jw();
        if (this.FzX.FzU > 0) {
          this.FzX.ePD();
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/share/FinderShareSideGuideUIC$initOutsideRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(330618);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(330623);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/share/FinderShareSideGuideUIC$initOutsideRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/share/FinderShareSideGuideUIC$initOutsideRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(330623);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<Bitmap, ah>
  {
    g(ImageView paramImageView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/share/FinderShareSideGuideUIC$showGuideView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "isReverse", "", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    extends AnimatorListenerAdapter
  {
    h(b paramb) {}
    
    public final void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
    {
      AppMethodBeat.i(330617);
      super.onAnimationEnd(paramAnimator, paramBoolean);
      paramAnimator = this.FzX.FzP;
      if (paramAnimator != null)
      {
        paramAnimator = paramAnimator.getViewTreeObserver();
        if (paramAnimator != null) {
          paramAnimator.removeOnGlobalLayoutListener(this.FzX.FzV);
        }
      }
      AppMethodBeat.o(330617);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(330610);
      super.onAnimationStart(paramAnimator);
      paramAnimator = this.FzX.FzP;
      if (paramAnimator != null) {
        paramAnimator.setVisibility(0);
      }
      AppMethodBeat.o(330610);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.share.b
 * JD-Core Version:    0.7.0.1
 */