package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.a.b;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.event.c.b;
import com.tencent.mm.plugin.finder.loader.aa;
import com.tencent.mm.plugin.finder.loader.ac;
import com.tencent.mm.plugin.finder.report.am;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.finder.video.FinderLongVideoPlayerSeekBar;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
import com.tencent.mm.plugin.finder.video.s;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.i;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "horizontalFeedId", "", "horizontalLayout", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout;", "getHorizontalLayout", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout;", "horizontalLayout$delegate", "Lkotlin/Lazy;", "isExiting", "", "isPauseManual", "isPauseWhenEnterHorizontalPreview", "()Z", "setPauseWhenEnterHorizontalPreview", "(Z)V", "isResumed", "orientationEventListener", "Lcom/tencent/mm/orientation/OrientationListenerHelper;", "attachHorizontalLayout", "", "isRemove", "exitType", "", "enterHorizontal", "orientation", "Lcom/tencent/mm/orientation/OrientationListenerHelper$Orientation;", "exitHorizontal", "finish", "Lkotlin/Function0;", "handleOrientationChanged", "isEnableHorizontal", "context", "Landroid/content/Context;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "AnimInfo", "Companion", "HorizontalVideoPreviewLayout", "HorizontalVideoSeekBarLayout", "plugin-finder_release"})
public final class ab
  extends UIComponent
{
  public static final b BlF;
  private boolean BlA;
  private final com.tencent.mm.br.a BlB;
  private long BlC;
  private boolean BlD;
  private final f BlE;
  public boolean Blz;
  private boolean zQA;
  
  static
  {
    AppMethodBeat.i(287582);
    BlF = new b((byte)0);
    AppMethodBeat.o(287582);
  }
  
  public ab(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(287580);
    this.BlB = new com.tencent.mm.br.a((Context)getActivity(), (a.b)new ab.h(this));
    this.BlE = kotlin.g.ar((kotlin.g.a.a)new ab.g(this));
    AppMethodBeat.o(287580);
  }
  
  public ab(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(287581);
    this.BlB = new com.tencent.mm.br.a((Context)getActivity(), (a.b)new ab.h(this));
    this.BlE = kotlin.g.ar((kotlin.g.a.a)new ab.g(this));
    AppMethodBeat.o(287581);
  }
  
  private final void S(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(287573);
    Log.i("Finder.HorizontalVideoPreviewUIC", "[attachHorizontalLayout] isRemove=" + paramBoolean + " exitType=" + paramInt);
    Object localObject = getActivity().getWindow();
    p.j(localObject, "activity.window");
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
        ((ViewGroup)localObject).removeView((View)ekO());
        AppMethodBeat.o(287573);
        return;
      }
      ((ViewGroup)localObject).removeView((View)ekO());
      ((ViewGroup)localObject).addView((View)ekO(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      AppMethodBeat.o(287573);
      return;
    }
    AppMethodBeat.o(287573);
  }
  
  private final c ekO()
  {
    AppMethodBeat.i(287574);
    c localc = (c)this.BlE.getValue();
    AppMethodBeat.o(287574);
    return localc;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(287579);
    if (ekO().wFf)
    {
      a(this, 0, null, 3);
      AppMethodBeat.o(287579);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(287579);
    return bool;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(287575);
    super.onCreate(paramBundle);
    this.BlB.enable();
    AppMethodBeat.o(287575);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(287578);
    super.onDestroy();
    this.BlB.disable();
    AppMethodBeat.o(287578);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(287577);
    super.onPause();
    this.zQA = false;
    AppMethodBeat.o(287577);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(287576);
    super.onResume();
    this.zQA = true;
    View localView = ekO().getPreview();
    Object localObject = localView;
    if (!(localView instanceof s)) {
      localObject = null;
    }
    localObject = (s)localObject;
    if (localObject != null)
    {
      if (!this.BlA)
      {
        ((s)localObject).setVideoViewFocused(true);
        ((s)localObject).egV();
      }
      AppMethodBeat.o(287576);
      return;
    }
    AppMethodBeat.o(287576);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$AnimInfo;", "", "scale", "", "translationX", "translationY", "rotation", "(FFFF)V", "getRotation", "()F", "getScale", "getTranslationX", "getTranslationY", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    final float GB;
    final float GC;
    final float rotation;
    final float scale;
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.scale = paramFloat1;
      this.GB = paramFloat2;
      this.GC = paramFloat3;
      this.rotation = paramFloat4;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(290782);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((Float.compare(this.scale, paramObject.scale) != 0) || (Float.compare(this.GB, paramObject.GB) != 0) || (Float.compare(this.GC, paramObject.GC) != 0) || (Float.compare(this.rotation, paramObject.rotation) != 0)) {}
        }
      }
      else
      {
        AppMethodBeat.o(290782);
        return true;
      }
      AppMethodBeat.o(290782);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(290781);
      int i = Float.floatToIntBits(this.scale);
      int j = Float.floatToIntBits(this.GB);
      int k = Float.floatToIntBits(this.GC);
      int m = Float.floatToIntBits(this.rotation);
      AppMethodBeat.o(290781);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(290780);
      String str = "scale=" + this.scale + " translationX=" + this.GB + " translationY=" + this.GC + " rotation=" + this.rotation;
      AppMethodBeat.o(290780);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$Companion;", "", "()V", "ANIM_DURATION", "", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC;Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC;Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animInfo", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$AnimInfo;", "getAnimInfo", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$AnimInfo;", "setAnimInfo", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$AnimInfo;)V", "bgView", "Landroid/view/View;", "currRotation", "fgView", "fullSeekBar", "Lcom/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout;", "getFullSeekBar", "()Lcom/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout;", "setFullSeekBar", "(Lcom/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout;)V", "iconLayout", "indexOriginalParent", "getIndexOriginalParent", "()I", "setIndexOriginalParent", "(I)V", "isPreviewing", "", "()Z", "setPreviewing", "(Z)V", "itemView", "getItemView", "()Landroid/view/View;", "setItemView", "(Landroid/view/View;)V", "longVideoSeekBarLayout", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoSeekBarLayout;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC;", "getLongVideoSeekBarLayout", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoSeekBarLayout;", "longVideoSeekBarLayout$delegate", "Lkotlin/Lazy;", "originalParams", "Landroid/view/ViewGroup$LayoutParams;", "getOriginalParams", "()Landroid/view/ViewGroup$LayoutParams;", "setOriginalParams", "(Landroid/view/ViewGroup$LayoutParams;)V", "originalParent", "Landroid/view/ViewGroup;", "getOriginalParent", "()Landroid/view/ViewGroup;", "setOriginalParent", "(Landroid/view/ViewGroup;)V", "pivotOffset", "getPivotOffset", "pivotOffset$delegate", "preview", "getPreview", "setPreview", "realScreenHeight", "realScreenWidth", "addPreview", "", "view", "rotation", "feedId", "", "simpleViewHolder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "isLongVideo", "attachSeekBar", "originVideoLayout", "Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout;", "videoView", "Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy;", "checkShowSeekBar", "detachSeekBar", "removePreview", "exitType", "finish", "Lkotlin/Function0;", "resetPreviewVideoView", "toggleCtrlViews", "forceShow", "plugin-finder_release"})
  @SuppressLint({"ResourceType"})
  public final class c
    extends FrameLayout
  {
    final View BlG;
    final FrameLayout BlH;
    private final f BlI;
    private final f BlJ;
    private final int BlK;
    private final int BlL;
    int BlM;
    View BlN;
    ViewGroup BlO;
    int BlP;
    ViewGroup.LayoutParams BlQ;
    ab.a BlR;
    FinderFullSeekBarLayout BlS;
    View amk;
    final View cCj;
    boolean wFf;
    
    public c()
    {
      super();
      AppMethodBeat.i(271231);
      this$1 = new View(getContext());
      ab.this.setBackgroundColor(-16777216);
      this.cCj = ab.this;
      this$1 = new View(getContext());
      ab.this.setVisibility(8);
      ab.this.setBackgroundColor(ab.this.getResources().getColor(b.c.hot_tab_BW_0_Alpha_0_5));
      this.BlG = ab.this;
      this.BlH = new FrameLayout(getContext());
      this.BlI = kotlin.g.ar((kotlin.g.a.a)new h(this));
      this.BlJ = kotlin.g.ar((kotlin.g.a.a)new i(this));
      addView(this.cCj, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      addView(this.BlG, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      int i = (int)getResources().getDimension(b.d.Edge_3A);
      int j = (int)getResources().getDimension(b.d.Edge_3_5_A);
      this.BlH.setPivotX(j / 2.0F);
      this.BlH.setPivotY(j / 2.0F);
      this$1 = new WeImageView(getContext());
      ab.this.setImageResource(b.i.icons_filled_back2);
      ab.this.setIconColor(-1);
      this.BlH.addView((View)ab.this, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      this$1 = (View)this.BlH;
      Object localObject = new FrameLayout.LayoutParams(j, j);
      ((FrameLayout.LayoutParams)localObject).setMarginEnd(i);
      ((FrameLayout.LayoutParams)localObject).bottomMargin = i;
      ((FrameLayout.LayoutParams)localObject).gravity = 8388661;
      addView(ab.this, (ViewGroup.LayoutParams)localObject);
      setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(284536);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          ab.c.a(this.BlU);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(284536);
        }
      });
      this.BlH.setOnClickListener((View.OnClickListener)new ab.c.2(this));
      this$1 = ax.au(getContext());
      this.BlK = Math.max(ab.this.x, ab.this.y);
      this.BlL = Math.min(ab.this.x, ab.this.y);
      getLongVideoSeekBarLayout().setVisibility(4);
      this$1 = (View)getLongVideoSeekBarLayout();
      localObject = new FrameLayout.LayoutParams(this.BlK, -2);
      ((FrameLayout.LayoutParams)localObject).gravity = 8388611;
      addView(ab.this, (ViewGroup.LayoutParams)localObject);
      this.BlP = -1;
      this.BlR = new ab.a(1.0F, 0.0F, 0.0F, 0.0F);
      AppMethodBeat.o(271231);
    }
    
    private final int getPivotOffset()
    {
      AppMethodBeat.i(271227);
      int i = ((Number)this.BlJ.getValue()).intValue();
      AppMethodBeat.o(271227);
      return i;
    }
    
    public final void c(final int paramInt, final kotlin.g.a.a<x> parama)
    {
      AppMethodBeat.i(271230);
      p.k(parama, "finish");
      this.BlM = 0;
      View localView = this.BlN;
      if (localView != null)
      {
        getLongVideoSeekBarLayout().animate().setListener(null).cancel();
        this.BlH.animate().setListener(null).cancel();
        getLongVideoSeekBarLayout().animate().setInterpolator((TimeInterpolator)new DecelerateInterpolator()).setDuration(400L).alpha(0.0F).start();
        this.BlH.animate().setInterpolator((TimeInterpolator)new DecelerateInterpolator()).setDuration(400L).alpha(0.0F).start();
        this.cCj.animate().setInterpolator((TimeInterpolator)new DecelerateInterpolator()).setDuration(400L).alpha(0.0F).start();
        getLongVideoSeekBarLayout().getDescTv().setMaxLines(2);
        getLongVideoSeekBarLayout().getHiddenTv().setVisibility(4);
        this.BlG.setVisibility(8);
        localView.animate().cancel();
        localView.animate().rotation(this.BlR.rotation).translationX(this.BlR.GB).translationY(this.BlR.GC).scaleX(this.BlR.scale).scaleY(this.BlR.scale).setDuration(400L).setListener((Animator.AnimatorListener)new j(localView, this, parama, paramInt)).setInterpolator((TimeInterpolator)new DecelerateInterpolator()).start();
      }
      this.BlS = null;
      AppMethodBeat.o(271230);
    }
    
    public final ab.a getAnimInfo()
    {
      return this.BlR;
    }
    
    public final FinderFullSeekBarLayout getFullSeekBar()
    {
      return this.BlS;
    }
    
    public final int getIndexOriginalParent()
    {
      return this.BlP;
    }
    
    public final View getItemView()
    {
      return this.amk;
    }
    
    public final ab.d getLongVideoSeekBarLayout()
    {
      AppMethodBeat.i(271226);
      ab.d locald = (ab.d)this.BlI.getValue();
      AppMethodBeat.o(271226);
      return locald;
    }
    
    public final ViewGroup.LayoutParams getOriginalParams()
    {
      return this.BlQ;
    }
    
    public final ViewGroup getOriginalParent()
    {
      return this.BlO;
    }
    
    public final View getPreview()
    {
      return this.BlN;
    }
    
    public final void setAnimInfo(ab.a parama)
    {
      AppMethodBeat.i(271228);
      p.k(parama, "<set-?>");
      this.BlR = parama;
      AppMethodBeat.o(271228);
    }
    
    public final void setFullSeekBar(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      this.BlS = paramFinderFullSeekBarLayout;
    }
    
    public final void setIndexOriginalParent(int paramInt)
    {
      this.BlP = paramInt;
    }
    
    public final void setItemView(View paramView)
    {
      this.amk = paramView;
    }
    
    public final void setOriginalParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      this.BlQ = paramLayoutParams;
    }
    
    public final void setOriginalParent(ViewGroup paramViewGroup)
    {
      this.BlO = paramViewGroup;
    }
    
    public final void setPreview(View paramView)
    {
      this.BlN = paramView;
    }
    
    public final void setPreviewing(boolean paramBoolean)
    {
      this.wFf = paramBoolean;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout$addPreview$4$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(ab.c paramc, i parami, boolean paramBoolean, int paramInt)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout$attachSeekBar$1$1"})
    static final class c
      implements View.OnClickListener
    {
      c(FinderLongVideoPlayerSeekBar paramFinderLongVideoPlayerSeekBar, ab.c paramc, FinderThumbPlayerProxy paramFinderThumbPlayerProxy, FinderVideoLayout paramFinderVideoLayout) {}
      
      public final void onClick(View paramView)
      {
        boolean bool2 = true;
        AppMethodBeat.i(286572);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout$attachSeekBar$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        boolean bool3 = this.AOr.cTl();
        paramView = this.BlY;
        if (!bool3)
        {
          bool1 = true;
          paramView.setVideoViewFocused(bool1);
          if (!bool3) {
            break label205;
          }
          paramView = this.BlU.getFullSeekBar();
          if (paramView != null) {
            paramView.egK();
          }
          this.BlY.pause();
          label94:
          ab.a(this.BlU.BlT, bool3);
          paramView = this.AOr;
          if (bool3) {
            break label234;
          }
        }
        label205:
        label234:
        for (boolean bool1 = bool2;; bool1 = false)
        {
          paramView.setIsPlay(bool1);
          if (bool3)
          {
            paramView = this.BlZ.getPlayInfo();
            if (paramView != null)
            {
              localObject = this.BlZ.getVideoPlayBehavior();
              if (localObject != null) {
                ((c.b)localObject).a(paramView.feed.getExpectId(), paramView.zBB.ztO, (ac)paramView.zBB);
              }
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout$attachSeekBar$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(286572);
          return;
          bool1 = false;
          break;
          paramView = this.BlU.getFullSeekBar();
          if (paramView != null) {
            paramView.aGh("HorizontalClick");
          }
          this.BlY.bqo();
          break label94;
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout$attachSeekBar$1$2", "Lcom/tencent/mm/plugin/sight/decode/ui/IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "plugin-finder_release"})
    public static final class d
      implements com.tencent.mm.plugin.sight.decode.ui.b
    {
      d(FinderLongVideoPlayerSeekBar paramFinderLongVideoPlayerSeekBar, ab.c paramc, FinderThumbPlayerProxy paramFinderThumbPlayerProxy, FinderVideoLayout paramFinderVideoLayout) {}
      
      public final void aRo()
      {
        AppMethodBeat.i(292280);
        this.BlY.pause();
        this.AOr.setIsPlay(false);
        kotlin.g.a.a locala = this.AOr.getOnSeekStart();
        if (locala != null)
        {
          locala.invoke();
          AppMethodBeat.o(292280);
          return;
        }
        AppMethodBeat.o(292280);
      }
      
      public final void tY(int paramInt)
      {
        Object localObject2 = null;
        AppMethodBeat.i(292279);
        this.AOr.tY(paramInt);
        this.BlY.a(paramInt, true);
        this.BlY.bqo();
        this.AOr.setIsPlay(true);
        Object localObject1 = this.AOr.getOnSeekEnd();
        if (localObject1 != null) {
          ((kotlin.g.a.a)localObject1).invoke();
        }
        localObject1 = this.BlZ.getPlayInfo();
        if (localObject1 != null)
        {
          if (((FinderVideoLayout.b)localObject1).AOk) {}
          while (localObject1 != null)
          {
            Object localObject3 = this.BlZ.getVideoPlayBehavior();
            if (localObject3 != null) {
              ((c.b)localObject3).d(((FinderVideoLayout.b)localObject1).feed.getExpectId(), ((FinderVideoLayout.b)localObject1).zBB.ztO, this.BlY.getCurrentPlaySecond(), paramInt, (ac)((FinderVideoLayout.b)localObject1).zBB);
            }
            long l = ((FinderVideoLayout.b)localObject1).feed.getExpectId();
            localObject3 = this.BlY;
            localObject1 = localObject2;
            if (localObject3 != null) {
              localObject1 = ((FinderThumbPlayerProxy)localObject3).getVideoMediaId();
            }
            FinderVideoLayout.b(l, (String)localObject1, this.BlY.getCurrentPlaySecond(), paramInt);
            AppMethodBeat.o(292279);
            return;
            localObject1 = null;
          }
        }
        AppMethodBeat.o(292279);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout$attachSeekBar$4$1"})
    static final class e
      implements View.OnClickListener
    {
      e(TextView paramTextView, ab.c paramc) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(269612);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout$attachSeekBar$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        int i = this.xAf.getLineCount();
        if ((this.xAf.getVisibility() == 0) && (i > 0))
        {
          paramView = this.xAf.getLayout();
          if (paramView == null) {
            break label220;
          }
          i = paramView.getEllipsisCount(i - 1);
          if (i > 0)
          {
            paramView = this.BlU.getLongVideoSeekBarLayout().getHiddenTv();
            paramView.setVisibility(0);
            paramView.scrollTo(0, 0);
            this.xAf.setVisibility(4);
            ab.c.e(this.BlU).setVisibility(0);
            paramView = am.zZN;
            paramView = aj.Bnu;
            paramView = aj.a.fZ((Context)this.BlU.BlT.getActivity());
            if (paramView == null) {
              break label225;
            }
          }
        }
        label220:
        label225:
        for (paramView = paramView.ekY();; paramView = null)
        {
          am.b(paramView, "transpose_video_card_caption", 1);
          paramView = new View.OnClickListener()
          {
            private int Bma;
            
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(291903);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout$attachSeekBar$$inlined$let$lambda$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              if ((ab.c.e(this.Bmb.BlU).getVisibility() == 0) && (this.Bma == this.Bmb.BlU.getLongVideoSeekBarLayout().getHiddenTv().getScrollY()))
              {
                ab.c.e(this.Bmb.BlU).setVisibility(8);
                this.Bmb.BlU.getLongVideoSeekBarLayout().getHiddenTv().setVisibility(4);
                this.Bmb.BlU.getLongVideoSeekBarLayout().getDescTv().setVisibility(0);
                paramAnonymousView = am.zZN;
                paramAnonymousView = aj.Bnu;
                paramAnonymousView = aj.a.fZ((Context)this.Bmb.BlU.BlT.getActivity());
                if (paramAnonymousView == null) {
                  break label204;
                }
              }
              label204:
              for (paramAnonymousView = paramAnonymousView.ekY();; paramAnonymousView = null)
              {
                am.b(paramAnonymousView, "transpose_video_card_caption_detail", 1);
                this.Bma = this.Bmb.BlU.getLongVideoSeekBarLayout().getHiddenTv().getScrollY();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout$attachSeekBar$$inlined$let$lambda$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(291903);
                return;
              }
            }
          };
          ab.c.e(this.BlU).setOnClickListener((View.OnClickListener)paramView);
          this.BlU.getLongVideoSeekBarLayout().getHiddenTv().setOnClickListener((View.OnClickListener)paramView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout$attachSeekBar$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(269612);
          return;
          i = 0;
          break;
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g
      implements View.OnClickListener
    {
      g(ab.c paramc) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(226108);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout$attachSeekBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        List localList = j.listOf(new View[] { (View)ab.c.c(this.BlU), (View)this.BlU.getLongVideoSeekBarLayout() });
        localObject = this.BlU.getPreview();
        paramView = (View)localObject;
        if (!(localObject instanceof FinderThumbPlayerProxy)) {
          paramView = null;
        }
        paramView = (FinderThumbPlayerProxy)paramView;
        if (paramView != null)
        {
          localObject = com.tencent.mm.ui.component.g.Xox;
          ((al)com.tencent.mm.ui.component.g.b(this.BlU.BlT.getActivity()).i(al.class)).a(localList, paramView, ab.c.d(this.BlU), true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout$attachSeekBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(226108);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoSeekBarLayout;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC;", "invoke"})
    static final class h
      extends q
      implements kotlin.g.a.a<ab.d>
    {
      h(ab.c paramc)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class i
      extends q
      implements kotlin.g.a.a<Integer>
    {
      i(ab.c paramc)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout$removePreview$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-finder_release"})
    public static final class j
      extends com.tencent.mm.plugin.finder.animation.a
    {
      j(View paramView, ab.c paramc, kotlin.g.a.a parama, int paramInt) {}
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(273164);
        p.k(paramAnimator, "animation");
        this.kJS.post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(244800);
            ab.c.b(this.Bmg.BlU);
            this.Bmg.Bme.invoke();
            Object localObject = am.zZN;
            localObject = aj.Bnu;
            localObject = aj.a.fZ((Context)this.Bmg.BlU.BlT.getActivity());
            String str;
            if (localObject != null)
            {
              localObject = ((aj)localObject).ekY();
              if (this.Bmg.Bmf != 0) {
                break label118;
              }
              str = "transpose_video_card";
              label78:
              if (this.Bmg.Bmf != 0) {
                break label124;
              }
            }
            label118:
            label124:
            for (int i = 3;; i = 1)
            {
              am.b((bid)localObject, str, i);
              this.Bmg.BlU.setPreviewing(false);
              AppMethodBeat.o(244800);
              return;
              localObject = null;
              break;
              str = "transpose_video_card_exitArrow";
              break label78;
            }
          }
        });
        AppMethodBeat.o(273164);
      }
      
      public final void onAnimationStart(Animator paramAnimator)
      {
        AppMethodBeat.i(273163);
        super.onAnimationStart(paramAnimator);
        jdField_this.post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(261572);
            View localView = this.Bmg.BlU.getItemView();
            if (localView != null)
            {
              localView = localView.findViewById(b.f.avatar_iv);
              if (localView != null)
              {
                localView.setVisibility(0);
                AppMethodBeat.o(261572);
                return;
              }
            }
            AppMethodBeat.o(261572);
          }
        });
        AppMethodBeat.o(273163);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoSeekBarLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC;Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC;Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "descTv$delegate", "Lkotlin/Lazy;", "floatingBallBtn", "getFloatingBallBtn", "floatingBallBtn$delegate", "hiddenTv", "getHiddenTv", "hiddenTv$delegate", "longVideoSeekBar", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "getLongVideoSeekBar", "()Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "longVideoSeekBar$delegate", "speedCtrlBtn", "getSpeedCtrlBtn", "speedCtrlBtn$delegate", "plugin-finder_release"})
  public final class d
    extends FrameLayout
  {
    private final f Bmh;
    private final f Bmi;
    private final f Bmj;
    private final f Bmk;
    private final View contentView;
    private final f zRC;
    
    public d()
    {
      super();
      AppMethodBeat.i(285338);
      this$1 = View.inflate(getContext(), b.g.finder_mega_video_seek_bar_layout, (ViewGroup)this);
      p.j(ab.this, "View.inflate(context, R.…eo_seek_bar_layout, this)");
      this.contentView = ab.this;
      this.Bmh = kotlin.g.ar((kotlin.g.a.a)new d(this));
      this.Bmi = kotlin.g.ar((kotlin.g.a.a)new e(this));
      this.Bmj = kotlin.g.ar((kotlin.g.a.a)new b(this));
      this.zRC = kotlin.g.ar((kotlin.g.a.a)new a(this));
      this.Bmk = kotlin.g.ar((kotlin.g.a.a)new c(this));
      AppMethodBeat.o(285338);
    }
    
    public final View getContentView()
    {
      return this.contentView;
    }
    
    public final TextView getDescTv()
    {
      AppMethodBeat.i(285336);
      TextView localTextView = (TextView)this.zRC.getValue();
      AppMethodBeat.o(285336);
      return localTextView;
    }
    
    public final View getFloatingBallBtn()
    {
      AppMethodBeat.i(285335);
      View localView = (View)this.Bmj.getValue();
      AppMethodBeat.o(285335);
      return localView;
    }
    
    public final TextView getHiddenTv()
    {
      AppMethodBeat.i(285337);
      TextView localTextView = (TextView)this.Bmk.getValue();
      AppMethodBeat.o(285337);
      return localTextView;
    }
    
    public final FinderLongVideoPlayerSeekBar getLongVideoSeekBar()
    {
      AppMethodBeat.i(285333);
      FinderLongVideoPlayerSeekBar localFinderLongVideoPlayerSeekBar = (FinderLongVideoPlayerSeekBar)this.Bmh.getValue();
      AppMethodBeat.o(285333);
      return localFinderLongVideoPlayerSeekBar;
    }
    
    public final View getSpeedCtrlBtn()
    {
      AppMethodBeat.i(285334);
      View localView = (View)this.Bmi.getValue();
      AppMethodBeat.o(285334);
      return localView;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<TextView>
    {
      a(ab.d paramd)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<View>
    {
      b(ab.d paramd)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c
      extends q
      implements kotlin.g.a.a<TextView>
    {
      c(ab.d paramd)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d
      extends q
      implements kotlin.g.a.a<FinderLongVideoPlayerSeekBar>
    {
      d(ab.d paramd)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e
      extends q
      implements kotlin.g.a.a<View>
    {
      e(ab.d paramd)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(ab paramab, int paramInt, FinderMediaBanner paramFinderMediaBanner, kotlin.g.a.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(ab paramab, int paramInt, FinderMediaBanner paramFinderMediaBanner, kotlin.g.a.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.ab
 * JD-Core Version:    0.7.0.1
 */