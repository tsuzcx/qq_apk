package com.tencent.mm.plugin.finder.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.protocal.protobuf.bvy;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.HardTouchableLayout.g;
import com.tencent.mm.view.MediaBanner.c;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import d.f;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(35)
@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "animationLayout", "Lcom/tencent/mm/view/AnimationLayout;", "getAnimationLayout", "()Lcom/tencent/mm/view/AnimationLayout;", "animationLayout$delegate", "Lkotlin/Lazy;", "closeBtn", "Landroid/view/View;", "getCloseBtn", "()Landroid/view/View;", "closeBtn$delegate", "curPos", "", "galleryBg", "getGalleryBg", "galleryBg$delegate", "isComeFromCreate", "", "mediaBanner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "getMediaBanner", "()Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "mediaBanner$delegate", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaList", "()Ljava/util/LinkedList;", "playingAnimation", "posterLayout", "Landroid/view/ViewGroup;", "refFeedInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "getRefFeedInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeedInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "touchableLayout", "Lcom/tencent/mm/view/HardTouchableLayout;", "getTouchableLayout", "()Lcom/tencent/mm/view/HardTouchableLayout;", "touchableLayout$delegate", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "checkPlay", "", "position", "finish", "getLayoutId", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onWindowFocusChanged", "hasFocus", "runEnterAnimation", "runExitAnimation", "Companion", "plugin-finder_release"})
public final class FinderMediaPreviewUI
  extends MMFinderUI
{
  public static final FinderMediaPreviewUI.a sPa;
  private HashMap _$_findViewCache;
  private boolean iXG;
  final LinkedList<bvz> mediaList;
  private final com.tencent.mm.plugin.finder.video.i rWB;
  private final f sOR;
  private final f sOS;
  private final f sOT;
  private final f sOU;
  private final f sOV;
  private ViewGroup sOW;
  private aqq sOX;
  private boolean sOY;
  private int sOZ;
  
  static
  {
    AppMethodBeat.i(167420);
    sPa = new FinderMediaPreviewUI.a((byte)0);
    AppMethodBeat.o(167420);
  }
  
  public FinderMediaPreviewUI()
  {
    AppMethodBeat.i(167432);
    this.sOR = d.g.O((d.g.a.a)new h(this));
    this.sOS = d.g.O((d.g.a.a)new c(this));
    this.sOT = d.g.O((d.g.a.a)new d(this));
    this.sOU = d.g.O((d.g.a.a)new b(this));
    this.sOV = d.g.O((d.g.a.a)new l(this));
    this.rWB = new com.tencent.mm.plugin.finder.video.i();
    this.mediaList = new LinkedList();
    this.sOY = true;
    AppMethodBeat.o(167432);
  }
  
  private final void Gc(int paramInt)
  {
    AppMethodBeat.i(167428);
    Object localObject = cMB().getPagerView().ci(paramInt);
    if (localObject == null) {
      p.gkB();
    }
    p.g(localObject, "mediaBanner.pagerView.fi…apterPosition(position)!!");
    if ((((RecyclerView.w)localObject).lQ() == 2) || (((RecyclerView.w)localObject).lQ() == 7))
    {
      this.rWB.cPb();
      AppMethodBeat.o(167428);
      return;
    }
    localObject = (FinderVideoLayout)((RecyclerView.w)localObject).auu.findViewById(2131299975);
    p.g(this.mediaList.get(paramInt), "mediaList[position]");
    if (localObject != null)
    {
      ((FinderVideoLayout)localObject).getVideoCore().cPb();
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
  
  private final void bYa()
  {
    AppMethodBeat.i(167431);
    if (this.iXG)
    {
      AppMethodBeat.o(167431);
      return;
    }
    this.iXG = true;
    ae.i("Finder.MediaPreviewUI", "runExitAnimation");
    Object localObject = getIntent().getParcelableExtra("crop_info");
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.view.ViewAnimHelper.ViewInfo");
      AppMethodBeat.o(167431);
      throw ((Throwable)localObject);
    }
    localObject = (ViewAnimHelper.ViewInfo)localObject;
    AnimationLayout localAnimationLayout = cME();
    View localView = cMD();
    Window localWindow = getWindow();
    p.g(localWindow, "window");
    localAnimationLayout.a(localView, localWindow.getDecorView(), (ViewAnimHelper.ViewInfo)localObject, (Animator.AnimatorListener)new j(this), (ValueAnimator.AnimatorUpdateListener)FinderMediaPreviewUI.k.sPc);
    AppMethodBeat.o(167431);
  }
  
  private final FinderMediaBanner cMB()
  {
    AppMethodBeat.i(167421);
    FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)this.sOR.getValue();
    AppMethodBeat.o(167421);
    return localFinderMediaBanner;
  }
  
  private final View cMC()
  {
    AppMethodBeat.i(167422);
    View localView = (View)this.sOS.getValue();
    AppMethodBeat.o(167422);
    return localView;
  }
  
  private final View cMD()
  {
    AppMethodBeat.i(167423);
    View localView = (View)this.sOT.getValue();
    AppMethodBeat.o(167423);
    return localView;
  }
  
  private final AnimationLayout cME()
  {
    AppMethodBeat.i(167424);
    AnimationLayout localAnimationLayout = (AnimationLayout)this.sOU.getValue();
    AppMethodBeat.o(167424);
    return localAnimationLayout;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204633);
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
    AppMethodBeat.o(204633);
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
    Object localObject1 = (com.tencent.mm.bw.a)new bvy();
    Object localObject3 = getIntent().getByteArrayExtra("media_list_");
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
      localObject3 = (bvy)localObject1;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new bvy();
      }
      this.mediaList.addAll((Collection)((bvy)localObject1).mediaList);
      localObject1 = (bvz)this.mediaList.getFirst();
      f1 = 0.0F;
      localObject4 = ((Iterable)this.mediaList).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject3 = (bvz)((Iterator)localObject4).next();
        float f2 = ((bvz)localObject3).height * 1.0F / ((bvz)localObject3).width;
        f1 = ((bvz)localObject1).height * 1.0F / ((bvz)localObject1).width;
        if (f1 >= f2) {
          break label917;
        }
        localObject1 = localObject3;
      }
    }
    catch (Exception localException)
    {
      label917:
      for (;;)
      {
        float f1;
        Object localObject4;
        ae.l("safeParser", "", new Object[] { localException });
        Object localObject2 = null;
        continue;
        localObject2 = cMB().getPagerView().getLayoutParams();
        localObject3 = getContext();
        p.g(localObject3, "context");
        localObject3 = ((AppCompatActivity)localObject3).getResources();
        p.g(localObject3, "context.resources");
        ((ViewGroup.LayoutParams)localObject2).width = ((Resources)localObject3).getDisplayMetrics().widthPixels;
        localObject2 = cMB().getPagerView().getLayoutParams();
        localObject3 = getContext();
        p.g(localObject3, "context");
        localObject3 = ((AppCompatActivity)localObject3).getResources();
        p.g(localObject3, "context.resources");
        ((ViewGroup.LayoutParams)localObject2).height = ((int)(((Resources)localObject3).getDisplayMetrics().widthPixels * f1));
        cMB().requestLayout();
        cME().setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(cMB().getPagerView().getLayoutParams()));
        cMB().getPagerViewContainer().removeView((View)cMB().getPagerView());
        cME().addView((View)cMB().getPagerView());
        cMB().getPagerViewContainer().addView((View)cME(), 0);
        localObject2 = LayoutInflater.from((Context)getContext()).inflate(2131496455, (ViewGroup)cMB().getPagerViewContainer(), false);
        if (localObject2 == null)
        {
          localObject2 = new d.v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(167426);
          throw ((Throwable)localObject2);
        }
        this.sOW = ((ViewGroup)localObject2);
        localObject2 = this.sOW;
        if (localObject2 != null)
        {
          localObject2 = (ImageView)((ViewGroup)localObject2).findViewById(2131303359);
          localObject3 = this.sOW;
          if (localObject3 == null) {
            break label874;
          }
          localObject3 = (TextView)((ViewGroup)localObject3).findViewById(2131303369);
          label487:
          localObject4 = c.rPy;
          localObject4 = c.a.ahT(com.tencent.mm.model.v.aAK());
          if (localObject4 != null)
          {
            if (localObject2 != null)
            {
              Object localObject5 = com.tencent.mm.plugin.finder.loader.i.srW;
              localObject5 = com.tencent.mm.plugin.finder.loader.i.cEo();
              com.tencent.mm.plugin.finder.loader.a locala = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.g)localObject4).field_avatarUrl);
              com.tencent.mm.plugin.finder.loader.i locali = com.tencent.mm.plugin.finder.loader.i.srW;
              ((d)localObject5).a(locala, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.i.a(i.a.srZ));
            }
            if (localObject3 != null) {
              ((TextView)localObject3).setText((CharSequence)k.c((Context)getContext(), (CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject4).VK()));
            }
          }
          localObject2 = this.sOW;
          if (localObject2 != null) {
            ((ViewGroup)localObject2).setVisibility(8);
          }
          cMB().getPagerViewContainer().addView((View)this.sOW);
          localObject3 = cME().getLayoutParams();
          localObject2 = localObject3;
          if (!(localObject3 instanceof FrameLayout.LayoutParams)) {
            localObject2 = null;
          }
          localObject2 = (FrameLayout.LayoutParams)localObject2;
          localObject3 = com.tencent.mm.plugin.finder.storage.b.sHP;
          if ((((Number)com.tencent.mm.plugin.finder.storage.b.cKe().value()).intValue() != 2) || (f1 < 1.316667F)) {
            break label880;
          }
          if (localObject2 != null) {
            ((FrameLayout.LayoutParams)localObject2).topMargin = 0;
          }
        }
        for (;;)
        {
          cME().setLayoutParams((ViewGroup.LayoutParams)localObject2);
          ((HardTouchableLayout)this.sOV.getValue()).setOnSingleClickListener((HardTouchableLayout.g)new e(this));
          cMC().setOnClickListener((View.OnClickListener)new FinderMediaPreviewUI.f(this));
          cMC().setVisibility(0);
          localObject2 = getIntent().getByteArrayExtra("ref_feed_info");
          if (localObject2 != null)
          {
            localObject3 = new aqq();
            ((aqq)localObject3).parseFrom((byte[])localObject2);
            this.sOX = ((aqq)localObject3);
          }
          com.tencent.mm.plugin.finder.video.i.a(this.rWB, (MMActivity)this, null, 6);
          localObject2 = cMB();
          localObject3 = new FinderMediaBannerAdapter(this.rWB);
          ((FinderMediaBannerAdapter)localObject3).setItems((List)this.mediaList);
          ((FinderMediaBanner)localObject2).setAdapter((RecyclerView.a)localObject3);
          cMB().setRefFeedInfo(this.sOX);
          cMB().setPageChangeCallback((MediaBanner.c)new g(this));
          AppMethodBeat.o(167426);
          return;
          localObject2 = null;
          break;
          label874:
          localObject3 = null;
          break label487;
          label880:
          if (localObject2 != null)
          {
            localObject3 = getContext();
            p.g(localObject3, "context");
            ((FrameLayout.LayoutParams)localObject2).topMargin = ((int)((AppCompatActivity)localObject3).getResources().getDimension(2131165300));
          }
        }
      }
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(167429);
    bYa();
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
    if (!this.iXG)
    {
      this.iXG = true;
      ae.i("Finder.MediaPreviewUI", "runEnterAnimation");
      paramBundle = getIntent().getParcelableExtra("crop_info");
      if (paramBundle == null)
      {
        paramBundle = new d.v("null cannot be cast to non-null type com.tencent.mm.view.ViewAnimHelper.ViewInfo");
        AppMethodBeat.o(167425);
        throw paramBundle;
      }
      paramBundle = (ViewAnimHelper.ViewInfo)paramBundle;
      AnimationLayout localAnimationLayout = cME();
      View localView = cMD();
      Window localWindow = getWindow();
      p.g(localWindow, "window");
      localAnimationLayout.a(localView, localWindow.getDecorView(), paramBundle, (Animator.AnimatorListener)new i(this));
    }
    AppMethodBeat.o(167425);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(167427);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.sOY))
    {
      this.sOY = false;
      Gc(0);
    }
    AppMethodBeat.o(167427);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/view/AnimationLayout;", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<AnimationLayout>
  {
    b(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<View>
  {
    c(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<View>
  {
    d(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initView$3", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "plugin-finder_release"})
  public static final class e
    implements HardTouchableLayout.g
  {
    public final void eb(View paramView)
    {
      AppMethodBeat.i(204630);
      p.h(paramView, "view");
      if ((((bvz)this.sPb.mediaList.get(FinderMediaPreviewUI.a(this.sPb))).mediaType == 6) || (((bvz)this.sPb.mediaList.get(FinderMediaPreviewUI.a(this.sPb))).mediaType == 4))
      {
        FinderMediaPreviewUI.b(this.sPb);
        FinderMediaPreviewUI.b(this.sPb);
        AppMethodBeat.o(204630);
        return;
      }
      FinderMediaPreviewUI.c(this.sPb);
      AppMethodBeat.o(204630);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initView$7", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "plugin-finder_release"})
  public static final class g
    implements MediaBanner.c
  {
    public final void af(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(204632);
      FinderMediaPreviewUI.a(this.sPb, paramInt);
      if (!paramBoolean)
      {
        AppMethodBeat.o(204632);
        return;
      }
      FinderMediaPreviewUI.b(this.sPb, paramInt);
      AppMethodBeat.o(204632);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<FinderMediaBanner>
  {
    h(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$runEnterAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class i
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(167411);
      FinderMediaPreviewUI.d(this.sPb);
      paramAnimator = FinderMediaPreviewUI.e(this.sPb);
      if (paramAnimator != null)
      {
        paramAnimator.setVisibility(0);
        AppMethodBeat.o(167411);
        return;
      }
      AppMethodBeat.o(167411);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(167412);
      FinderMediaPreviewUI.f(this.sPb).setVisibility(0);
      AppMethodBeat.o(167412);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$runExitAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class j
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(167415);
      p.h(paramAnimator, "animation");
      AppMethodBeat.o(167415);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(167414);
      p.h(paramAnimator, "animation");
      this.sPb.finish();
      this.sPb.overridePendingTransition(2130771986, 2130771986);
      AppMethodBeat.o(167414);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(167416);
      p.h(paramAnimator, "animation");
      AppMethodBeat.o(167416);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(167413);
      p.h(paramAnimator, "animation");
      paramAnimator = FinderMediaPreviewUI.e(this.sPb);
      if (paramAnimator != null) {
        paramAnimator.setVisibility(8);
      }
      FinderMediaPreviewUI.g(this.sPb).setVisibility(8);
      AppMethodBeat.o(167413);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/view/HardTouchableLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements d.g.a.a<HardTouchableLayout>
  {
    l(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaPreviewUI
 * JD-Core Version:    0.7.0.1
 */