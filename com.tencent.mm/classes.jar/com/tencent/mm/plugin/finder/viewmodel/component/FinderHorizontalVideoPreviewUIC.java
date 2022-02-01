package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.bo.a.a;
import com.tencent.mm.bo.a.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.r;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "horizontalFeedId", "", "horizontalLayout", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout;", "getHorizontalLayout", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout;", "horizontalLayout$delegate", "Lkotlin/Lazy;", "isPauseWhenEnterHorizontalPreview", "", "isResumed", "orientationEventListener", "Lcom/tencent/mm/orientation/OrientationListenerHelper;", "attachHorizontalLayout", "", "isRemove", "enterHorizontal", "orientation", "Lcom/tencent/mm/orientation/OrientationListenerHelper$Orientation;", "exitHorizontal", "exitType", "", "handleOrientationChanged", "isEnableHorizontal", "context", "Landroid/content/Context;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "report21875", "eventCode", "feedId", "", "leaveType", "AnimInfo", "Companion", "HorizontalVideoPreviewLayout", "plugin-finder_release"})
public final class FinderHorizontalVideoPreviewUIC
  extends UIComponent
{
  public static final b wxu;
  private boolean wxp;
  private boolean wxq;
  private final com.tencent.mm.bo.a wxr;
  private long wxs;
  private final f wxt;
  
  static
  {
    AppMethodBeat.i(255683);
    wxu = new b((byte)0);
    AppMethodBeat.o(255683);
  }
  
  public FinderHorizontalVideoPreviewUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(255682);
    this.wxr = new com.tencent.mm.bo.a((Context)getActivity(), (a.b)new g(this));
    this.wxt = g.ah((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(255682);
  }
  
  public FinderHorizontalVideoPreviewUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255681);
    this.wxr = new com.tencent.mm.bo.a((Context)getActivity(), (a.b)new g(this));
    this.wxt = g.ah((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(255681);
  }
  
  private final void Mx(int paramInt)
  {
    AppMethodBeat.i(255672);
    if (!dIi().sZd)
    {
      AppMethodBeat.o(255672);
      return;
    }
    final FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)findViewById(2131304549);
    if (localFinderMediaBanner != null) {
      localFinderMediaBanner.setFrozenRecyclerView(false);
    }
    if ((dIi().getPreview() instanceof r))
    {
      dIi().c(paramInt, (kotlin.g.a.a)new d(this));
      AppMethodBeat.o(255672);
      return;
    }
    dIi().c(paramInt, (kotlin.g.a.a)new e(this, localFinderMediaBanner));
    AppMethodBeat.o(255672);
  }
  
  private final c dIi()
  {
    AppMethodBeat.i(255675);
    c localc = (c)this.wxt.getValue();
    AppMethodBeat.o(255675);
    return localc;
  }
  
  private final void ph(boolean paramBoolean)
  {
    AppMethodBeat.i(255674);
    Log.i("Finder.HorizontalVideoPreviewUIC", "[attachHorizontalLayout] isRemove=".concat(String.valueOf(paramBoolean)));
    Object localObject = getActivity().getWindow();
    p.g(localObject, "activity.window");
    View localView = ((Window)localObject).getDecorView();
    localObject = localView;
    if (!(localView instanceof ViewGroup)) {
      localObject = null;
    }
    localObject = (ViewGroup)localObject;
    if (localObject != null)
    {
      if (paramBoolean)
      {
        ((ViewGroup)localObject).removeView((View)dIi());
        AppMethodBeat.o(255674);
        return;
      }
      ((ViewGroup)localObject).removeView((View)dIi());
      ((ViewGroup)localObject).addView((View)dIi(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      AppMethodBeat.o(255674);
      return;
    }
    AppMethodBeat.o(255674);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(255680);
    if (dIi().sZd)
    {
      Mx(1);
      AppMethodBeat.o(255680);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(255680);
    return bool;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(255676);
    super.onCreate(paramBundle);
    this.wxr.enable();
    AppMethodBeat.o(255676);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(255679);
    super.onDestroy();
    this.wxr.disable();
    AppMethodBeat.o(255679);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(255678);
    super.onPause();
    this.wxq = false;
    AppMethodBeat.o(255678);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(255677);
    super.onResume();
    this.wxq = true;
    AppMethodBeat.o(255677);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$AnimInfo;", "", "scale", "", "translationX", "translationY", "rotation", "(FFFF)V", "getRotation", "()F", "getScale", "getTranslationX", "getTranslationY", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    final float rotation;
    final float scale;
    final float translationX;
    final float translationY;
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.scale = paramFloat1;
      this.translationX = paramFloat2;
      this.translationY = paramFloat3;
      this.rotation = paramFloat4;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(255655);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((Float.compare(this.scale, paramObject.scale) != 0) || (Float.compare(this.translationX, paramObject.translationX) != 0) || (Float.compare(this.translationY, paramObject.translationY) != 0) || (Float.compare(this.rotation, paramObject.rotation) != 0)) {}
        }
      }
      else
      {
        AppMethodBeat.o(255655);
        return true;
      }
      AppMethodBeat.o(255655);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(255654);
      int i = Float.floatToIntBits(this.scale);
      int j = Float.floatToIntBits(this.translationX);
      int k = Float.floatToIntBits(this.translationY);
      int m = Float.floatToIntBits(this.rotation);
      AppMethodBeat.o(255654);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(255653);
      String str = "scale=" + this.scale + " translationX=" + this.translationX + " translationY=" + this.translationY + " rotation=" + this.rotation;
      AppMethodBeat.o(255653);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$Companion;", "", "()V", "ANIM_DURATION", "", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC;Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC;Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animInfo", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$AnimInfo;", "getAnimInfo", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$AnimInfo;", "setAnimInfo", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$AnimInfo;)V", "bgView", "Landroid/view/View;", "iconLayout", "indexOriginalParent", "getIndexOriginalParent", "()I", "setIndexOriginalParent", "(I)V", "isPreviewing", "", "()Z", "setPreviewing", "(Z)V", "originalParams", "Landroid/view/ViewGroup$LayoutParams;", "getOriginalParams", "()Landroid/view/ViewGroup$LayoutParams;", "setOriginalParams", "(Landroid/view/ViewGroup$LayoutParams;)V", "originalParent", "Landroid/view/ViewGroup;", "getOriginalParent", "()Landroid/view/ViewGroup;", "setOriginalParent", "(Landroid/view/ViewGroup;)V", "preview", "getPreview", "()Landroid/view/View;", "setPreview", "(Landroid/view/View;)V", "addPreview", "", "view", "rotation", "feedId", "", "itemView", "removePreview", "exitType", "finish", "Lkotlin/Function0;", "plugin-finder_release"})
  @SuppressLint({"ResourceType"})
  public final class c
    extends FrameLayout
  {
    private final View cBH;
    boolean sZd;
    private FinderHorizontalVideoPreviewUIC.a wxA;
    private final FrameLayout wxv;
    private View wxw;
    private ViewGroup wxx;
    private int wxy;
    private ViewGroup.LayoutParams wxz;
    
    public c()
    {
      super();
      AppMethodBeat.i(255667);
      this$1 = new View(getContext());
      FinderHorizontalVideoPreviewUIC.this.setBackgroundColor(-16777216);
      this.cBH = FinderHorizontalVideoPreviewUIC.this;
      this.wxv = new FrameLayout(getContext());
      addView(this.cBH, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      int i = (int)getResources().getDimension(2131165299);
      int j = (int)getResources().getDimension(2131165300);
      int k = (int)(getResources().getDimension(2131165289) / 2.0F);
      this$1 = this.wxv;
      FinderHorizontalVideoPreviewUIC.this.setPadding(k, k, k, k);
      FinderHorizontalVideoPreviewUIC.this.setBackgroundResource(2131232524);
      this.wxv.setPivotX(j / 2.0F);
      this.wxv.setPivotY(j / 2.0F);
      this$1 = new WeImageView(getContext());
      FinderHorizontalVideoPreviewUIC.this.setImageResource(2131690743);
      FinderHorizontalVideoPreviewUIC.this.setIconColor(-16777216);
      this.wxv.addView((View)FinderHorizontalVideoPreviewUIC.this, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      this$1 = (View)this.wxv;
      Object localObject = new FrameLayout.LayoutParams(j, j);
      ((FrameLayout.LayoutParams)localObject).setMarginEnd(i);
      ((FrameLayout.LayoutParams)localObject).bottomMargin = i;
      ((FrameLayout.LayoutParams)localObject).gravity = 8388661;
      addView(FinderHorizontalVideoPreviewUIC.this, (ViewGroup.LayoutParams)localObject);
      setOnClickListener((View.OnClickListener)FinderHorizontalVideoPreviewUIC.c.1.wxC);
      this.wxv.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(255658);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          FinderHorizontalVideoPreviewUIC.a(this.wxD.wxB);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(255658);
        }
      });
      this.wxy = -1;
      this.wxA = new FinderHorizontalVideoPreviewUIC.a(1.0F, 0.0F, 0.0F, 0.0F);
      AppMethodBeat.o(255667);
    }
    
    public final void a(View paramView1, int paramInt, long paramLong, View paramView2)
    {
      AppMethodBeat.i(255665);
      p.h(paramView1, "view");
      Object localObject1 = y.vXH;
      localObject1 = FinderHorizontalVideoPreviewUIC.this.getActivity().getWindow();
      p.g(localObject1, "activity.window");
      y.b((Window)localObject1, true);
      FinderHorizontalVideoPreviewUIC.a(FinderHorizontalVideoPreviewUIC.this, 2, d.zs(paramLong), 0);
      this.sZd = true;
      this.wxw = paramView1;
      localObject1 = paramView1.getParent();
      if (localObject1 == null)
      {
        paramView1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(255665);
        throw paramView1;
      }
      this.wxx = ((ViewGroup)localObject1);
      localObject1 = this.wxx;
      if (localObject1 != null) {}
      for (int i = ((ViewGroup)localObject1).indexOfChild(paramView1);; i = 0)
      {
        this.wxy = i;
        this.wxz = new ViewGroup.LayoutParams(paramView1.getWidth(), paramView1.getHeight());
        this.cBH.setAlpha(0.0F);
        localObject1 = ao.az(getContext());
        i = paramView1.getHeight();
        float f1 = paramView1.getWidth() * 1.0F / i;
        int j = ((Point)localObject1).x;
        int k = kotlin.h.a.cR(f1 * j);
        f1 = 1.0F * j / i;
        Object localObject2 = new int[2];
        Rect localRect = new Rect();
        paramView1.getLocationInWindow((int[])localObject2);
        paramView1.getDrawingRect(localRect);
        localRect.offset(localObject2[0], localObject2[1]);
        localObject2 = this.wxx;
        if (localObject2 != null) {
          ((ViewGroup)localObject2).removeView(paramView1);
        }
        localObject2 = new FrameLayout.LayoutParams(k, j);
        ((FrameLayout.LayoutParams)localObject2).gravity = 17;
        addView(paramView1, 1, (ViewGroup.LayoutParams)localObject2);
        paramView1.setPivotX(k / 2.0F);
        paramView1.setPivotY(j / 2.0F);
        paramView1.setScaleX(1.0F / f1);
        paramView1.setScaleY(1.0F / f1);
        f1 = localRect.centerX();
        float f2 = ((Point)localObject1).x / 2.0F;
        float f3 = localRect.centerY();
        float f4 = ((Point)localObject1).y / 2.0F;
        paramView1.setTranslationX(f1 - f2);
        paramView1.setTranslationY(f3 - f4);
        this.wxA = new FinderHorizontalVideoPreviewUIC.a(paramView1.getScaleX(), paramView1.getTranslationX(), paramView1.getTranslationY(), paramView1.getRotation());
        paramView1.setTag(paramView2);
        paramView1.animate().rotation(paramInt).translationX(0.0F).translationY(0.0F).scaleX(1.0F).scaleY(1.0F).setDuration(400L).setListener((Animator.AnimatorListener)new a(paramView2)).setInterpolator((TimeInterpolator)new DecelerateInterpolator()).start();
        this.cBH.animate().setDuration(400L).alpha(1.0F).setInterpolator((TimeInterpolator)new DecelerateInterpolator()).start();
        this.wxv.animate().setDuration(400L).alpha(1.0F).setInterpolator((TimeInterpolator)new DecelerateInterpolator()).start();
        paramView1 = this.wxv.getLayoutParams();
        if (paramView1 != null) {
          break;
        }
        paramView1 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(255665);
        throw paramView1;
      }
      paramView1 = (FrameLayout.LayoutParams)paramView1;
      i = au.getStatusBarHeight((Context)FinderHorizontalVideoPreviewUIC.this.getActivity());
      if (paramInt > 0)
      {
        paramView1.setMarginEnd((int)getResources().getDimension(2131165299));
        paramView1.topMargin = (i + (int)getResources().getDimension(2131165296));
        paramView1.gravity = 8388661;
        this.wxv.setRotation(90.0F);
        AppMethodBeat.o(255665);
        return;
      }
      this.wxv.setRotation(-90.0F);
      paramView1.setMarginStart((int)getResources().getDimension(2131165299));
      paramView1.bottomMargin = ((int)getResources().getDimension(2131165299));
      paramView1.gravity = 8388691;
      AppMethodBeat.o(255665);
    }
    
    public final void c(final int paramInt, final kotlin.g.a.a<x> parama)
    {
      AppMethodBeat.i(255666);
      p.h(parama, "finish");
      Object localObject = y.vXH;
      localObject = FinderHorizontalVideoPreviewUIC.this.getActivity().getWindow();
      p.g(localObject, "activity.window");
      y.b((Window)localObject, false);
      localObject = this.wxw;
      if (localObject != null)
      {
        this.wxv.animate().setInterpolator((TimeInterpolator)new DecelerateInterpolator()).setDuration(400L).alpha(0.0F).start();
        this.cBH.animate().setInterpolator((TimeInterpolator)new DecelerateInterpolator()).setDuration(400L).alpha(0.0F).start();
        ((View)localObject).animate().cancel();
        ((View)localObject).animate().rotation(this.wxA.rotation).translationX(this.wxA.translationX).translationY(this.wxA.translationY).scaleX(this.wxA.scale).scaleY(this.wxA.scale).setDuration(400L).setListener((Animator.AnimatorListener)new b((View)localObject, this, parama, paramInt)).setInterpolator((TimeInterpolator)new DecelerateInterpolator()).start();
        AppMethodBeat.o(255666);
        return;
      }
      AppMethodBeat.o(255666);
    }
    
    public final FinderHorizontalVideoPreviewUIC.a getAnimInfo()
    {
      return this.wxA;
    }
    
    public final int getIndexOriginalParent()
    {
      return this.wxy;
    }
    
    public final ViewGroup.LayoutParams getOriginalParams()
    {
      return this.wxz;
    }
    
    public final ViewGroup getOriginalParent()
    {
      return this.wxx;
    }
    
    public final View getPreview()
    {
      return this.wxw;
    }
    
    public final void setAnimInfo(FinderHorizontalVideoPreviewUIC.a parama)
    {
      AppMethodBeat.i(255664);
      p.h(parama, "<set-?>");
      this.wxA = parama;
      AppMethodBeat.o(255664);
    }
    
    public final void setIndexOriginalParent(int paramInt)
    {
      this.wxy = paramInt;
    }
    
    public final void setOriginalParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      this.wxz = paramLayoutParams;
    }
    
    public final void setOriginalParent(ViewGroup paramViewGroup)
    {
      this.wxx = paramViewGroup;
    }
    
    public final void setPreview(View paramView)
    {
      this.wxw = paramView;
    }
    
    public final void setPreviewing(boolean paramBoolean)
    {
      this.sZd = paramBoolean;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout$addPreview$2", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
    public static final class a
      extends com.tencent.mm.plugin.finder.animation.a
    {
      a(View paramView) {}
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(255659);
        p.h(paramAnimator, "animation");
        paramAnimator = this.rsM;
        if (paramAnimator != null)
        {
          paramAnimator = paramAnimator.findViewById(2131297134);
          if (paramAnimator != null)
          {
            paramAnimator.setVisibility(4);
            AppMethodBeat.o(255659);
            return;
          }
        }
        AppMethodBeat.o(255659);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout$removePreview$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-finder_release"})
    public static final class b
      extends com.tencent.mm.plugin.finder.animation.a
    {
      b(View paramView, FinderHorizontalVideoPreviewUIC.c paramc, kotlin.g.a.a parama, int paramInt) {}
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(255663);
        p.h(paramAnimator, "animation");
        this.tzy.post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(255661);
            this.wxG.wxD.removeView(this.wxG.tzy);
            this.wxG.tzy.setPivotX(0.0F);
            this.wxG.tzy.setPivotY(0.0F);
            this.wxG.tzy.setTranslationX(0.0F);
            this.wxG.tzy.setTranslationY(0.0F);
            this.wxG.tzy.setScaleX(1.0F);
            this.wxG.tzy.setScaleY(1.0F);
            this.wxG.tzy.setRotation(0.0F);
            ViewGroup localViewGroup = this.wxG.wxD.getOriginalParent();
            if (localViewGroup != null) {
              localViewGroup.removeView(this.wxG.tzy);
            }
            localViewGroup = this.wxG.wxD.getOriginalParent();
            if (localViewGroup != null) {
              localViewGroup.addView(this.wxG.tzy, this.wxG.wxD.getIndexOriginalParent(), this.wxG.wxD.getOriginalParams());
            }
            this.wxG.wxE.invoke();
            FinderHorizontalVideoPreviewUIC.a(this.wxG.wxD.wxB, 3, d.zs(FinderHorizontalVideoPreviewUIC.b(this.wxG.wxD.wxB)), this.wxG.wxF);
            this.wxG.wxD.setPreviewing(false);
            AppMethodBeat.o(255661);
          }
        });
        AppMethodBeat.o(255663);
      }
      
      public final void onAnimationStart(Animator paramAnimator)
      {
        AppMethodBeat.i(255662);
        super.onAnimationStart(paramAnimator);
        jdField_this.post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(255660);
            if ((this.wxG.tzy.getTag() instanceof View))
            {
              Object localObject = this.wxG.tzy.getTag();
              if (localObject == null)
              {
                localObject = new t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(255660);
                throw ((Throwable)localObject);
              }
              localObject = ((View)localObject).findViewById(2131297134);
              if (localObject != null)
              {
                ((View)localObject).setVisibility(0);
                AppMethodBeat.o(255660);
                return;
              }
            }
            AppMethodBeat.o(255660);
          }
        });
        AppMethodBeat.o(255662);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(FinderHorizontalVideoPreviewUIC paramFinderHorizontalVideoPreviewUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(FinderHorizontalVideoPreviewUIC paramFinderHorizontalVideoPreviewUIC, FinderMediaBanner paramFinderMediaBanner)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<FinderHorizontalVideoPreviewUIC.c>
  {
    f(FinderHorizontalVideoPreviewUIC paramFinderHorizontalVideoPreviewUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "lastOrientation", "Lcom/tencent/mm/orientation/OrientationListenerHelper$Orientation;", "kotlin.jvm.PlatformType", "newOrientation", "onFourOrientationsChange"})
  static final class g
    implements a.b
  {
    g(FinderHorizontalVideoPreviewUIC paramFinderHorizontalVideoPreviewUIC) {}
    
    public final void a(a.a parama1, a.a parama2)
    {
      boolean bool1 = true;
      boolean bool2 = false;
      AppMethodBeat.i(255671);
      if (!FinderHorizontalVideoPreviewUIC.fG((Context)this.wxB.getContext()))
      {
        AppMethodBeat.o(255671);
        return;
      }
      if (!this.wxB.isUserVisibleFocused())
      {
        AppMethodBeat.o(255671);
        return;
      }
      if ((FinderHorizontalVideoPreviewUIC.f(this.wxB)) && (parama1 != parama2))
      {
        parama1 = com.tencent.mm.ui.component.a.PRN;
        parama1 = ((FinderCommentDrawerUIC)com.tencent.mm.ui.component.a.b(this.wxB.getActivity()).get(FinderCommentDrawerUIC.class)).tLT;
        if ((parama1 == null) || (parama1.dGs() != true)) {
          break label208;
        }
      }
      for (;;)
      {
        parama1 = com.tencent.mm.ui.component.a.PRN;
        parama1 = ((FinderFeedFriendLikeDrawerUIC)com.tencent.mm.ui.component.a.b(this.wxB.getActivity()).get(FinderFeedFriendLikeDrawerUIC.class)).wvZ;
        if (parama1 != null) {
          bool2 = parama1.dGs();
        }
        Log.i("Finder.HorizontalVideoPreviewUIC", "[onConfigurationChanged] isDrawerOpen=" + bool1 + " isLikeDrawerOpen=" + bool2 + " newOrientation=" + parama2);
        if ((!bool1) && (!bool2))
        {
          parama1 = this.wxB;
          p.g(parama2, "newOrientation");
          FinderHorizontalVideoPreviewUIC.a(parama1, parama2);
        }
        AppMethodBeat.o(255671);
        return;
        label208:
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderHorizontalVideoPreviewUIC
 * JD-Core Version:    0.7.0.1
 */