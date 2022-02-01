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
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.plugin.finder.video.c;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.bmc;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.platformtools.ad;
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
@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "animationLayout", "Lcom/tencent/mm/view/AnimationLayout;", "getAnimationLayout", "()Lcom/tencent/mm/view/AnimationLayout;", "animationLayout$delegate", "Lkotlin/Lazy;", "closeBtn", "Landroid/view/View;", "getCloseBtn", "()Landroid/view/View;", "closeBtn$delegate", "curPos", "", "galleryBg", "getGalleryBg", "galleryBg$delegate", "isComeFromCreate", "", "mediaBanner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "getMediaBanner", "()Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "mediaBanner$delegate", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaList", "()Ljava/util/LinkedList;", "playingAnimation", "refFeedInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "getRefFeedInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeedInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "touchableLayout", "Lcom/tencent/mm/view/HardTouchableLayout;", "getTouchableLayout", "()Lcom/tencent/mm/view/HardTouchableLayout;", "touchableLayout$delegate", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "checkPlay", "", "position", "finish", "getLayoutId", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onWindowFocusChanged", "hasFocus", "runEnterAnimation", "runExitAnimation", "Companion", "plugin-finder_release"})
public final class FinderMediaPreviewUI
  extends MMFinderUI
{
  public static final a qNF;
  private HashMap _$_findViewCache;
  final LinkedList<bmd> mediaList;
  private boolean qMy;
  private final f qNA;
  private final f qNB;
  private akf qNC;
  private boolean qND;
  private int qNE;
  private final f qNx;
  private final f qNy;
  private final f qNz;
  private final c qrq;
  
  static
  {
    AppMethodBeat.i(167420);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(FinderMediaPreviewUI.class), "mediaBanner", "getMediaBanner()Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;")), (d.l.k)w.a(new u(w.bk(FinderMediaPreviewUI.class), "closeBtn", "getCloseBtn()Landroid/view/View;")), (d.l.k)w.a(new u(w.bk(FinderMediaPreviewUI.class), "galleryBg", "getGalleryBg()Landroid/view/View;")), (d.l.k)w.a(new u(w.bk(FinderMediaPreviewUI.class), "animationLayout", "getAnimationLayout()Lcom/tencent/mm/view/AnimationLayout;")), (d.l.k)w.a(new u(w.bk(FinderMediaPreviewUI.class), "touchableLayout", "getTouchableLayout()Lcom/tencent/mm/view/HardTouchableLayout;")) };
    qNF = new a((byte)0);
    AppMethodBeat.o(167420);
  }
  
  public FinderMediaPreviewUI()
  {
    AppMethodBeat.i(167432);
    this.qNx = g.E((d.g.a.a)new h(this));
    this.qNy = g.E((d.g.a.a)new c(this));
    this.qNz = g.E((d.g.a.a)new d(this));
    this.qNA = g.E((d.g.a.a)new b(this));
    this.qNB = g.E((d.g.a.a)new l(this));
    this.qrq = new c();
    this.mediaList = new LinkedList();
    this.qND = true;
    AppMethodBeat.o(167432);
  }
  
  private final void Da(int paramInt)
  {
    AppMethodBeat.i(167428);
    Object localObject = crj().getPagerView().cj(paramInt);
    if (localObject == null) {
      d.g.b.k.fvU();
    }
    d.g.b.k.g(localObject, "mediaBanner.pagerView.fi…apterPosition(position)!!");
    if ((((RecyclerView.v)localObject).lp() == 2) || (((RecyclerView.v)localObject).lp() == 7))
    {
      this.qrq.csl();
      AppMethodBeat.o(167428);
      return;
    }
    localObject = (FinderVideoLayout)((RecyclerView.v)localObject).arI.findViewById(2131299975);
    d.g.b.k.g(this.mediaList.get(paramInt), "mediaList[position]");
    if (localObject != null)
    {
      ((FinderVideoLayout)localObject).getVideoCore().csl();
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
  
  private final void bKT()
  {
    AppMethodBeat.i(167431);
    if (this.qMy)
    {
      AppMethodBeat.o(167431);
      return;
    }
    this.qMy = true;
    ad.i("Finder.MediaPreviewUI", "runExitAnimation");
    Object localObject = getIntent().getParcelableExtra("crop_info");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.view.ViewAnimHelper.ViewInfo");
      AppMethodBeat.o(167431);
      throw ((Throwable)localObject);
    }
    localObject = (ViewAnimHelper.ViewInfo)localObject;
    AnimationLayout localAnimationLayout = crl();
    View localView = crk();
    Window localWindow = getWindow();
    d.g.b.k.g(localWindow, "window");
    localAnimationLayout.a(localView, localWindow.getDecorView(), (ViewAnimHelper.ViewInfo)localObject, (Animator.AnimatorListener)new j(this), (ValueAnimator.AnimatorUpdateListener)FinderMediaPreviewUI.k.qNH);
    AppMethodBeat.o(167431);
  }
  
  private final FinderMediaBanner crj()
  {
    AppMethodBeat.i(167421);
    FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)this.qNx.getValue();
    AppMethodBeat.o(167421);
    return localFinderMediaBanner;
  }
  
  private final View crk()
  {
    AppMethodBeat.i(167423);
    View localView = (View)this.qNz.getValue();
    AppMethodBeat.o(167423);
    return localView;
  }
  
  private final AnimationLayout crl()
  {
    AppMethodBeat.i(167424);
    AnimationLayout localAnimationLayout = (AnimationLayout)this.qNA.getValue();
    AppMethodBeat.o(167424);
    return localAnimationLayout;
  }
  
  private final View getCloseBtn()
  {
    AppMethodBeat.i(167422);
    View localView = (View)this.qNy.getValue();
    AppMethodBeat.o(167422);
    return localView;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(199268);
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
    AppMethodBeat.o(199268);
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
    Object localObject1 = (com.tencent.mm.bx.a)new bmc();
    Object localObject3 = getIntent().getByteArrayExtra("media_list_");
    label562:
    for (;;)
    {
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
        localObject3 = (bmc)localObject1;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = new bmc();
        }
        this.mediaList.addAll((Collection)((bmc)localObject1).mediaList);
        localObject1 = (bmd)this.mediaList.getFirst();
        Iterator localIterator = ((Iterable)this.mediaList).iterator();
        f1 = 0.0F;
        if (localIterator.hasNext())
        {
          localObject3 = (bmd)localIterator.next();
          float f2 = ((bmd)localObject3).height * 1.0F / ((bmd)localObject3).width;
          f1 = ((bmd)localObject1).height * 1.0F / ((bmd)localObject1).width;
          if (f1 >= f2) {
            break label562;
          }
          localObject1 = localObject3;
        }
      }
      catch (Exception localException)
      {
        float f1;
        ad.l("safeParser", "", new Object[] { localException });
        Object localObject2 = null;
        continue;
        localObject2 = crj().getPagerView().getLayoutParams();
        localObject3 = getContext();
        d.g.b.k.g(localObject3, "context");
        localObject3 = ((AppCompatActivity)localObject3).getResources();
        d.g.b.k.g(localObject3, "context.resources");
        ((ViewGroup.LayoutParams)localObject2).width = ((Resources)localObject3).getDisplayMetrics().widthPixels;
        localObject2 = crj().getPagerView().getLayoutParams();
        localObject3 = getContext();
        d.g.b.k.g(localObject3, "context");
        localObject3 = ((AppCompatActivity)localObject3).getResources();
        d.g.b.k.g(localObject3, "context.resources");
        ((ViewGroup.LayoutParams)localObject2).height = ((int)(f1 * ((Resources)localObject3).getDisplayMetrics().widthPixels));
        crj().requestLayout();
        crl().setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(crj().getPagerView().getLayoutParams()));
        crj().getPagerViewContainer().removeView((View)crj().getPagerView());
        crl().addView((View)crj().getPagerView());
        crj().getPagerViewContainer().addView((View)crl(), 0);
        ((HardTouchableLayout)this.qNB.getValue()).setOnSingleClickListener((HardTouchableLayout.g)new e(this));
        getCloseBtn().setOnClickListener((View.OnClickListener)new f(this));
        getCloseBtn().setVisibility(0);
        localObject2 = getIntent().getByteArrayExtra("ref_feed_info");
        if (localObject2 != null)
        {
          localObject3 = new akf();
          ((akf)localObject3).parseFrom((byte[])localObject2);
          this.qNC = ((akf)localObject3);
        }
        c.a(this.qrq, (MMActivity)this, null, 6);
        localObject2 = crj();
        localObject3 = new FinderMediaBannerAdapter(this.qrq);
        ((FinderMediaBannerAdapter)localObject3).setItems((List)this.mediaList);
        ((FinderMediaBanner)localObject2).setAdapter((RecyclerView.a)localObject3);
        crj().setRefFeedInfo(this.qNC);
        crj().setPageChangeCallback((MediaBanner.c)new g(this));
        AppMethodBeat.o(167426);
        return;
      }
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(167429);
    bKT();
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
    if (!this.qMy)
    {
      this.qMy = true;
      ad.i("Finder.MediaPreviewUI", "runEnterAnimation");
      paramBundle = getIntent().getParcelableExtra("crop_info");
      if (paramBundle == null)
      {
        paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.view.ViewAnimHelper.ViewInfo");
        AppMethodBeat.o(167425);
        throw paramBundle;
      }
      paramBundle = (ViewAnimHelper.ViewInfo)paramBundle;
      AnimationLayout localAnimationLayout = crl();
      View localView = crk();
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
    if ((paramBoolean) && (this.qND))
    {
      this.qND = false;
      Da(0);
    }
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(167427);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$Companion;", "", "()V", "IS_VLOG_MODE", "", "MEDIA_LIST", "MEDIA_LIST_COUNT", "REF_FEED_INFO", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/view/AnimationLayout;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<AnimationLayout>
  {
    b(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    c(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    d(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initView$2", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "plugin-finder_release"})
  public static final class e
    implements HardTouchableLayout.g
  {
    public final void dR(View paramView)
    {
      AppMethodBeat.i(167407);
      d.g.b.k.h(paramView, "view");
      if ((((bmd)this.qNG.mediaList.get(FinderMediaPreviewUI.a(this.qNG))).mediaType == 6) || (((bmd)this.qNG.mediaList.get(FinderMediaPreviewUI.a(this.qNG))).mediaType == 4))
      {
        FinderMediaPreviewUI.b(this.qNG);
        FinderMediaPreviewUI.b(this.qNG);
        AppMethodBeat.o(167407);
        return;
      }
      FinderMediaPreviewUI.c(this.qNG);
      AppMethodBeat.o(167407);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(FinderMediaPreviewUI paramFinderMediaPreviewUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167408);
      this.qNG.onBackPressed();
      AppMethodBeat.o(167408);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initView$6", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "plugin-finder_release"})
  public static final class g
    implements MediaBanner.c
  {
    public final void ad(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(199267);
      FinderMediaPreviewUI.a(this.qNG, paramInt);
      if (!paramBoolean)
      {
        AppMethodBeat.o(199267);
        return;
      }
      FinderMediaPreviewUI.b(this.qNG, paramInt);
      AppMethodBeat.o(199267);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<FinderMediaBanner>
  {
    h(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$runEnterAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class i
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(167411);
      FinderMediaPreviewUI.d(this.qNG);
      AppMethodBeat.o(167411);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(167412);
      FinderMediaPreviewUI.e(this.qNG).setVisibility(0);
      AppMethodBeat.o(167412);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$runExitAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
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
      this.qNG.finish();
      this.qNG.overridePendingTransition(2130771986, 2130771986);
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
      FinderMediaPreviewUI.f(this.qNG).setVisibility(8);
      AppMethodBeat.o(167413);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/view/HardTouchableLayout;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaPreviewUI
 * JD-Core Version:    0.7.0.1
 */