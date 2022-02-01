package com.tencent.mm.plugin.finder.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.i;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.protocal.protobuf.amq;
import com.tencent.mm.protocal.protobuf.bqr;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.HardTouchableLayout.g;
import com.tencent.mm.view.MediaBanner.c;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import d.f;
import d.g;
import d.g.b.u;
import d.g.b.w;
import d.v;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(35)
@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "animationLayout", "Lcom/tencent/mm/view/AnimationLayout;", "getAnimationLayout", "()Lcom/tencent/mm/view/AnimationLayout;", "animationLayout$delegate", "Lkotlin/Lazy;", "closeBtn", "Landroid/view/View;", "getCloseBtn", "()Landroid/view/View;", "closeBtn$delegate", "curPos", "", "galleryBg", "getGalleryBg", "galleryBg$delegate", "isComeFromCreate", "", "mediaBanner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "getMediaBanner", "()Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "mediaBanner$delegate", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaList", "()Ljava/util/LinkedList;", "playingAnimation", "refFeedInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "getRefFeedInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeedInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "touchableLayout", "Lcom/tencent/mm/view/HardTouchableLayout;", "getTouchableLayout", "()Lcom/tencent/mm/view/HardTouchableLayout;", "touchableLayout$delegate", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "checkPlay", "", "position", "finish", "getLayoutId", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onWindowFocusChanged", "hasFocus", "runEnterAnimation", "runExitAnimation", "Companion", "plugin-finder_release"})
public final class FinderMediaPreviewUI
  extends MMFinderUI
{
  public static final FinderMediaPreviewUI.a rJd;
  private HashMap _$_findViewCache;
  private boolean iBD;
  final LinkedList<bqs> mediaList;
  private final f rIV;
  private final f rIW;
  private final f rIX;
  private final f rIY;
  private final f rIZ;
  private amq rJa;
  private boolean rJb;
  private int rJc;
  private final i rbo;
  
  static
  {
    AppMethodBeat.i(167420);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(FinderMediaPreviewUI.class), "mediaBanner", "getMediaBanner()Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;")), (d.l.k)w.a(new u(w.bn(FinderMediaPreviewUI.class), "closeBtn", "getCloseBtn()Landroid/view/View;")), (d.l.k)w.a(new u(w.bn(FinderMediaPreviewUI.class), "galleryBg", "getGalleryBg()Landroid/view/View;")), (d.l.k)w.a(new u(w.bn(FinderMediaPreviewUI.class), "animationLayout", "getAnimationLayout()Lcom/tencent/mm/view/AnimationLayout;")), (d.l.k)w.a(new u(w.bn(FinderMediaPreviewUI.class), "touchableLayout", "getTouchableLayout()Lcom/tencent/mm/view/HardTouchableLayout;")) };
    rJd = new FinderMediaPreviewUI.a((byte)0);
    AppMethodBeat.o(167420);
  }
  
  public FinderMediaPreviewUI()
  {
    AppMethodBeat.i(167432);
    this.rIV = g.K((d.g.a.a)new h(this));
    this.rIW = g.K((d.g.a.a)new c(this));
    this.rIX = g.K((d.g.a.a)new d(this));
    this.rIY = g.K((d.g.a.a)new b(this));
    this.rIZ = g.K((d.g.a.a)new l(this));
    this.rbo = new i();
    this.mediaList = new LinkedList();
    this.rJb = true;
    AppMethodBeat.o(167432);
  }
  
  private final void Ev(int paramInt)
  {
    AppMethodBeat.i(167428);
    Object localObject = cCa().getPagerView().ci(paramInt);
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    d.g.b.k.g(localObject, "mediaBanner.pagerView.fi…apterPosition(position)!!");
    if ((((RecyclerView.w)localObject).ly() == 2) || (((RecyclerView.w)localObject).ly() == 7))
    {
      this.rbo.cDY();
      AppMethodBeat.o(167428);
      return;
    }
    localObject = (FinderVideoLayout)((RecyclerView.w)localObject).asD.findViewById(2131299975);
    d.g.b.k.g(this.mediaList.get(paramInt), "mediaList[position]");
    if (localObject != null)
    {
      ((FinderVideoLayout)localObject).getVideoCore().cDY();
      FinderItem localFinderItem = new FinderItem();
      localFinderItem.setMediaExtList(new LinkedList());
      localFinderItem.getMediaExtList().addAll((Collection)this.mediaList);
      FinderVideoLayout.a((FinderVideoLayout)localObject, localFinderItem);
      FinderVideoLayout.a((FinderVideoLayout)localObject);
      AppMethodBeat.o(167428);
      return;
    }
    AppMethodBeat.o(167428);
  }
  
  private final void bSg()
  {
    AppMethodBeat.i(167431);
    if (this.iBD)
    {
      AppMethodBeat.o(167431);
      return;
    }
    this.iBD = true;
    ac.i("Finder.MediaPreviewUI", "runExitAnimation");
    Object localObject = getIntent().getParcelableExtra("crop_info");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.view.ViewAnimHelper.ViewInfo");
      AppMethodBeat.o(167431);
      throw ((Throwable)localObject);
    }
    localObject = (ViewAnimHelper.ViewInfo)localObject;
    AnimationLayout localAnimationLayout = cCd();
    View localView = cCc();
    Window localWindow = getWindow();
    d.g.b.k.g(localWindow, "window");
    localAnimationLayout.a(localView, localWindow.getDecorView(), (ViewAnimHelper.ViewInfo)localObject, (Animator.AnimatorListener)new j(this), (ValueAnimator.AnimatorUpdateListener)FinderMediaPreviewUI.k.rJf);
    AppMethodBeat.o(167431);
  }
  
  private final FinderMediaBanner cCa()
  {
    AppMethodBeat.i(167421);
    FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)this.rIV.getValue();
    AppMethodBeat.o(167421);
    return localFinderMediaBanner;
  }
  
  private final View cCb()
  {
    AppMethodBeat.i(167422);
    View localView = (View)this.rIW.getValue();
    AppMethodBeat.o(167422);
    return localView;
  }
  
  private final View cCc()
  {
    AppMethodBeat.i(167423);
    View localView = (View)this.rIX.getValue();
    AppMethodBeat.o(167423);
    return localView;
  }
  
  private final AnimationLayout cCd()
  {
    AppMethodBeat.i(167424);
    AnimationLayout localAnimationLayout = (AnimationLayout)this.rIY.getValue();
    AppMethodBeat.o(167424);
    return localAnimationLayout;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203239);
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
    AppMethodBeat.o(203239);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(167430);
    super.finish();
    overridePendingTransition(2130771986, 2130771986);
    AppMethodBeat.o(167430);
  }
  
  public final int getLayoutId()
  {
    return 2131494064;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167426);
    super.initView();
    Object localObject1 = (com.tencent.mm.bw.a)new bqr();
    Object localObject3 = getIntent().getByteArrayExtra("media_list_");
    label562:
    for (;;)
    {
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
        localObject3 = (bqr)localObject1;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = new bqr();
        }
        this.mediaList.addAll((Collection)((bqr)localObject1).mediaList);
        localObject1 = (bqs)this.mediaList.getFirst();
        Iterator localIterator = ((Iterable)this.mediaList).iterator();
        f1 = 0.0F;
        if (localIterator.hasNext())
        {
          localObject3 = (bqs)localIterator.next();
          float f2 = ((bqs)localObject3).height * 1.0F / ((bqs)localObject3).width;
          f1 = ((bqs)localObject1).height * 1.0F / ((bqs)localObject1).width;
          if (f1 >= f2) {
            break label562;
          }
          localObject1 = localObject3;
        }
      }
      catch (Exception localException)
      {
        float f1;
        ac.l("safeParser", "", new Object[] { localException });
        Object localObject2 = null;
        continue;
        localObject2 = cCa().getPagerView().getLayoutParams();
        localObject3 = getContext();
        d.g.b.k.g(localObject3, "context");
        localObject3 = ((AppCompatActivity)localObject3).getResources();
        d.g.b.k.g(localObject3, "context.resources");
        ((ViewGroup.LayoutParams)localObject2).width = ((Resources)localObject3).getDisplayMetrics().widthPixels;
        localObject2 = cCa().getPagerView().getLayoutParams();
        localObject3 = getContext();
        d.g.b.k.g(localObject3, "context");
        localObject3 = ((AppCompatActivity)localObject3).getResources();
        d.g.b.k.g(localObject3, "context.resources");
        ((ViewGroup.LayoutParams)localObject2).height = ((int)(f1 * ((Resources)localObject3).getDisplayMetrics().widthPixels));
        cCa().requestLayout();
        cCd().setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(cCa().getPagerView().getLayoutParams()));
        cCa().getPagerViewContainer().removeView((View)cCa().getPagerView());
        cCd().addView((View)cCa().getPagerView());
        cCa().getPagerViewContainer().addView((View)cCd(), 0);
        ((HardTouchableLayout)this.rIZ.getValue()).setOnSingleClickListener((HardTouchableLayout.g)new e(this));
        cCb().setOnClickListener((View.OnClickListener)new f(this));
        cCb().setVisibility(0);
        localObject2 = getIntent().getByteArrayExtra("ref_feed_info");
        if (localObject2 != null)
        {
          localObject3 = new amq();
          ((amq)localObject3).parseFrom((byte[])localObject2);
          this.rJa = ((amq)localObject3);
        }
        i.a(this.rbo, (MMActivity)this, null, 6);
        localObject2 = cCa();
        localObject3 = new FinderMediaBannerAdapter(this.rbo);
        ((FinderMediaBannerAdapter)localObject3).setItems((List)this.mediaList);
        ((FinderMediaBanner)localObject2).setAdapter((RecyclerView.a)localObject3);
        cCa().setRefFeedInfo(this.rJa);
        cCa().setPageChangeCallback((MediaBanner.c)new g(this));
        AppMethodBeat.o(167426);
        return;
      }
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(167429);
    bSg();
    AppMethodBeat.o(167429);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167425);
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    getWindow().setFlags(201326592, 201326592);
    setLightNavigationbarIcon();
    initView();
    if (!this.iBD)
    {
      this.iBD = true;
      ac.i("Finder.MediaPreviewUI", "runEnterAnimation");
      paramBundle = getIntent().getParcelableExtra("crop_info");
      if (paramBundle == null)
      {
        paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.view.ViewAnimHelper.ViewInfo");
        AppMethodBeat.o(167425);
        throw paramBundle;
      }
      paramBundle = (ViewAnimHelper.ViewInfo)paramBundle;
      AnimationLayout localAnimationLayout = cCd();
      View localView = cCc();
      Window localWindow = getWindow();
      d.g.b.k.g(localWindow, "window");
      localAnimationLayout.a(localView, localWindow.getDecorView(), paramBundle, (Animator.AnimatorListener)new i(this));
    }
    AppMethodBeat.o(167425);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(167427);
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.rJb))
    {
      this.rJb = false;
      Ev(0);
    }
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(167427);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/view/AnimationLayout;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<AnimationLayout>
  {
    b(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    c(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    d(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initView$2", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "plugin-finder_release"})
  public static final class e
    implements HardTouchableLayout.g
  {
    public final void dV(View paramView)
    {
      AppMethodBeat.i(167407);
      d.g.b.k.h(paramView, "view");
      if ((((bqs)this.rJe.mediaList.get(FinderMediaPreviewUI.a(this.rJe))).mediaType == 6) || (((bqs)this.rJe.mediaList.get(FinderMediaPreviewUI.a(this.rJe))).mediaType == 4))
      {
        FinderMediaPreviewUI.b(this.rJe);
        FinderMediaPreviewUI.b(this.rJe);
        AppMethodBeat.o(167407);
        return;
      }
      FinderMediaPreviewUI.c(this.rJe);
      AppMethodBeat.o(167407);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(FinderMediaPreviewUI paramFinderMediaPreviewUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167408);
      this.rJe.onBackPressed();
      AppMethodBeat.o(167408);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initView$6", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "plugin-finder_release"})
  public static final class g
    implements MediaBanner.c
  {
    public final void ad(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(203238);
      FinderMediaPreviewUI.a(this.rJe, paramInt);
      if (!paramBoolean)
      {
        AppMethodBeat.o(203238);
        return;
      }
      FinderMediaPreviewUI.b(this.rJe, paramInt);
      AppMethodBeat.o(203238);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<FinderMediaBanner>
  {
    h(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$runEnterAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class i
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(167411);
      FinderMediaPreviewUI.d(this.rJe);
      AppMethodBeat.o(167411);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(167412);
      FinderMediaPreviewUI.e(this.rJe).setVisibility(0);
      AppMethodBeat.o(167412);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$runExitAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class j
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(167415);
      d.g.b.k.h(paramAnimator, "animation");
      AppMethodBeat.o(167415);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(167414);
      d.g.b.k.h(paramAnimator, "animation");
      this.rJe.finish();
      this.rJe.overridePendingTransition(2130771986, 2130771986);
      AppMethodBeat.o(167414);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(167416);
      d.g.b.k.h(paramAnimator, "animation");
      AppMethodBeat.o(167416);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(167413);
      d.g.b.k.h(paramAnimator, "animation");
      FinderMediaPreviewUI.f(this.rJe).setVisibility(8);
      AppMethodBeat.o(167413);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/view/HardTouchableLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.a<HardTouchableLayout>
  {
    l(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaPreviewUI
 * JD-Core Version:    0.7.0.1
 */