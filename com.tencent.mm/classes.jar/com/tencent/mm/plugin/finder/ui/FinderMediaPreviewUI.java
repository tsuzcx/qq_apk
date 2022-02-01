package com.tencent.mm.plugin.finder.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderLongVideoPlayerSeekBar;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.k;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.HardTouchableLayout.g;
import com.tencent.mm.view.MediaBanner.c;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;

@com.tencent.mm.ui.base.a(35)
@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "animationLayout", "Lcom/tencent/mm/view/AnimationLayout;", "getAnimationLayout", "()Lcom/tencent/mm/view/AnimationLayout;", "animationLayout$delegate", "Lkotlin/Lazy;", "closeBtn", "Landroid/view/View;", "getCloseBtn", "()Landroid/view/View;", "closeBtn$delegate", "curPos", "", "galleryBg", "getGalleryBg", "galleryBg$delegate", "isComeFromCreate", "", "isLongVideoPreview", "mediaBanner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "getMediaBanner", "()Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "mediaBanner$delegate", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaList", "()Ljava/util/LinkedList;", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "musicTagView", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag;", "playingAnimation", "posterLayout", "Landroid/view/ViewGroup;", "refFeedInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "getRefFeedInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeedInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "seekBar", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "getSeekBar", "()Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "seekBar$delegate", "touchableLayout", "Lcom/tencent/mm/view/HardTouchableLayout;", "getTouchableLayout", "()Lcom/tencent/mm/view/HardTouchableLayout;", "touchableLayout$delegate", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "videoDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "checkPlay", "", "position", "getLayoutId", "initSeekBar", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onWindowFocusChanged", "hasFocus", "runEnterAnimation", "runExitAnimation", "toggleVideo", "isPlay", "videoSeek", "time", "Companion", "plugin-finder_release"})
public final class FinderMediaPreviewUI
  extends MMFinderUI
{
  public static final a vMg;
  private HashMap _$_findViewCache;
  private boolean jUE;
  final LinkedList<cjl> mediaList;
  private azk musicInfo;
  private final k tCD;
  private int uis;
  private final f vLU;
  private FinderImgFeedMusicTag vLV;
  private final f vLW;
  private final f vLX;
  private final f vLY;
  private final f vLZ;
  private ViewGroup vMa;
  private final f vMb;
  private azy vMc;
  private boolean vMd;
  private boolean vMe;
  private com.tencent.mm.plugin.finder.event.base.c vMf;
  
  static
  {
    AppMethodBeat.i(167420);
    vMg = new a((byte)0);
    AppMethodBeat.o(167420);
  }
  
  public FinderMediaPreviewUI()
  {
    AppMethodBeat.i(167432);
    this.vLU = kotlin.g.ah((kotlin.g.a.a)new m(this));
    this.vLW = kotlin.g.ah((kotlin.g.a.a)new d(this));
    this.vLX = kotlin.g.ah((kotlin.g.a.a)new e(this));
    this.vLY = kotlin.g.ah((kotlin.g.a.a)new b(this));
    this.vLZ = kotlin.g.ah((kotlin.g.a.a)new r(this));
    this.vMb = kotlin.g.ah((kotlin.g.a.a)new q(this));
    this.tCD = new k();
    this.mediaList = new LinkedList();
    this.vMd = true;
    AppMethodBeat.o(167432);
  }
  
  private final void Ls(int paramInt)
  {
    AppMethodBeat.i(167428);
    Object localObject = dzQ().getPagerView().ch(paramInt);
    if (localObject == null) {
      p.hyc();
    }
    p.g(localObject, "mediaBanner.pagerView.fi…apterPosition(position)!!");
    if ((((RecyclerView.v)localObject).lU() == 2) || (((RecyclerView.v)localObject).lU() == 7))
    {
      this.tCD.dFz();
      AppMethodBeat.o(167428);
      return;
    }
    localObject = (FinderVideoLayout)((RecyclerView.v)localObject).aus.findViewById(2131300776);
    p.g(this.mediaList.get(paramInt), "mediaList[position]");
    if (localObject != null)
    {
      ((FinderVideoLayout)localObject).getVideoCore().dFz();
      FinderItem localFinderItem = new FinderItem();
      localFinderItem.setMediaExtList(new LinkedList());
      localFinderItem.getMediaExtList().addAll((Collection)this.mediaList);
      if (((FinderVideoLayout)localObject).isLongVideo)
      {
        localFinderItem.setLongVideoMediaExtList(new LinkedList());
        localFinderItem.getLongVideoMediaExtList().addAll((Collection)this.mediaList);
        ((FinderVideoLayout)localObject).setOnClickListener((View.OnClickListener)new c(this));
      }
      FeedData.a locala = FeedData.Companion;
      FinderVideoLayout.a((FinderVideoLayout)localObject, 0, FeedData.a.i(localFinderItem), 0, false, false, 252);
      FinderVideoLayout.a((FinderVideoLayout)localObject);
      AppMethodBeat.o(167428);
      return;
    }
    AppMethodBeat.o(167428);
  }
  
  private final FinderMediaBanner dzQ()
  {
    AppMethodBeat.i(167421);
    FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)this.vLU.getValue();
    AppMethodBeat.o(167421);
    return localFinderMediaBanner;
  }
  
  private final View dzR()
  {
    AppMethodBeat.i(167422);
    View localView = (View)this.vLW.getValue();
    AppMethodBeat.o(167422);
    return localView;
  }
  
  private final View dzS()
  {
    AppMethodBeat.i(167423);
    View localView = (View)this.vLX.getValue();
    AppMethodBeat.o(167423);
    return localView;
  }
  
  private final AnimationLayout dzT()
  {
    AppMethodBeat.i(167424);
    AnimationLayout localAnimationLayout = (AnimationLayout)this.vLY.getValue();
    AppMethodBeat.o(167424);
    return localAnimationLayout;
  }
  
  private final FinderLongVideoPlayerSeekBar dzU()
  {
    AppMethodBeat.i(252528);
    FinderLongVideoPlayerSeekBar localFinderLongVideoPlayerSeekBar = (FinderLongVideoPlayerSeekBar)this.vMb.getValue();
    AppMethodBeat.o(252528);
    return localFinderLongVideoPlayerSeekBar;
  }
  
  private final boolean dzV()
  {
    AppMethodBeat.i(252532);
    if (this.jUE)
    {
      AppMethodBeat.o(252532);
      return false;
    }
    this.jUE = true;
    Log.i("Finder.MediaPreviewUI", "runExitAnimation");
    Object localObject2 = getIntent().getParcelableExtra("crop_info");
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof ViewAnimHelper.ViewInfo)) {
      localObject1 = null;
    }
    localObject1 = (ViewAnimHelper.ViewInfo)localObject1;
    if (localObject1 == null)
    {
      AppMethodBeat.o(252532);
      return false;
    }
    localObject2 = dzT();
    View localView = dzS();
    Window localWindow = getWindow();
    p.g(localWindow, "window");
    ((AnimationLayout)localObject2).a(localView, localWindow.getDecorView(), (ViewAnimHelper.ViewInfo)localObject1, (Animator.AnimatorListener)new o(this), (ValueAnimator.AnimatorUpdateListener)p.vMk);
    AppMethodBeat.o(252532);
    return true;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252538);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252538);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252537);
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
    AppMethodBeat.o(252537);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494502;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167426);
    super.initView();
    Object localObject1 = (com.tencent.mm.bw.a)new cjk();
    Object localObject3 = getIntent().getByteArrayExtra("media_list_");
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (cjk)localObject1;
      if (localObject1 == null)
      {
        localObject1 = new cjk();
        this.mediaList.addAll((Collection)((cjk)localObject1).mediaList);
        this.musicInfo = ((cjk)localObject1).MoJ;
        localObject3 = (cjl)this.mediaList.getFirst();
        f3 = 0.0F;
        f2 = ((cjl)localObject3).width;
        f1 = ((cjl)localObject3).height;
        localObject1 = ((cjl)localObject3).uOR;
        localObject5 = ((Iterable)this.mediaList).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject4 = (cjl)((Iterator)localObject5).next();
          float f4 = ((cjl)localObject4).height * 1.0F / ((cjl)localObject4).width;
          f3 = ((cjl)localObject3).height * 1.0F / ((cjl)localObject3).width;
          if (f3 >= f4) {
            break label1288;
          }
          f2 = ((cjl)localObject4).width;
          f1 = ((cjl)localObject4).height;
          localObject3 = ((cjl)localObject4).uOR;
          localObject1 = localObject4;
          localObject4 = localObject1;
          localObject1 = localObject3;
          localObject3 = localObject4;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        float f3;
        float f2;
        float f1;
        Object localObject5;
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        Object localObject2 = null;
        continue;
        if (this.vMe)
        {
          localObject3 = y.vXH;
          y.a((Activity)this, f2, f1, (View)dzQ().getPagerView(), (cjx)localObject2);
        }
        for (;;)
        {
          dzQ().requestLayout();
          localObject2 = this.musicInfo;
          if (localObject2 != null) {
            dzQ().post((Runnable)new i((azk)localObject2, this));
          }
          dzT().setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(dzQ().getPagerView().getLayoutParams()));
          dzQ().getPagerViewContainer().removeView((View)dzQ().getPagerView());
          dzT().addView((View)dzQ().getPagerView());
          dzQ().getPagerViewContainer().addView((View)dzT(), 0);
          if (this.vMe) {
            break label824;
          }
          localObject2 = LayoutInflater.from((Context)getContext()).inflate(2131494201, (ViewGroup)dzQ().getPagerViewContainer(), false);
          if (localObject2 != null) {
            break;
          }
          localObject2 = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(167426);
          throw ((Throwable)localObject2);
          localObject2 = dzQ().getPagerView().getLayoutParams();
          localObject3 = getContext();
          p.g(localObject3, "context");
          localObject3 = ((AppCompatActivity)localObject3).getResources();
          p.g(localObject3, "context.resources");
          ((ViewGroup.LayoutParams)localObject2).width = ((Resources)localObject3).getDisplayMetrics().widthPixels;
          localObject2 = dzQ().getPagerView().getLayoutParams();
          localObject3 = getContext();
          p.g(localObject3, "context");
          localObject3 = ((AppCompatActivity)localObject3).getResources();
          p.g(localObject3, "context.resources");
          ((ViewGroup.LayoutParams)localObject2).height = ((int)(((Resources)localObject3).getDisplayMetrics().widthPixels * f3));
        }
        this.vMa = ((ViewGroup)localObject2);
        localObject2 = this.vMa;
        if (localObject2 != null)
        {
          localObject2 = (ImageView)((ViewGroup)localObject2).findViewById(2131306056);
          localObject3 = this.vMa;
          if (localObject3 == null) {
            break label1243;
          }
          localObject3 = (TextView)((ViewGroup)localObject3).findViewById(2131306075);
          label645:
          if (localObject2 != null) {
            ((ImageView)localObject2).setVisibility(8);
          }
          if (localObject3 != null) {
            ((TextView)localObject3).setVisibility(8);
          }
          localObject4 = com.tencent.mm.plugin.finder.api.c.tsp;
          localObject4 = com.tencent.mm.plugin.finder.api.c.a.asG(z.aUg());
          if (localObject4 != null)
          {
            if (localObject2 != null) {
              ((ImageView)localObject2).setVisibility(0);
            }
            if (localObject3 != null) {
              ((TextView)localObject3).setVisibility(0);
            }
            if (localObject2 != null)
            {
              localObject5 = m.uJa;
              localObject5 = m.dka();
              com.tencent.mm.plugin.finder.loader.a locala = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.g)localObject4).field_avatarUrl);
              m localm = m.uJa;
              ((com.tencent.mm.loader.d)localObject5).a(locala, (ImageView)localObject2, m.a(m.a.uJe));
            }
            if (localObject3 != null) {
              ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)getContext(), (CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject4).getNickname()));
            }
          }
          localObject2 = this.vMa;
          if (localObject2 != null) {
            ((ViewGroup)localObject2).setVisibility(8);
          }
          dzQ().getPagerViewContainer().addView((View)this.vMa);
          label824:
          localObject3 = dzT().getLayoutParams();
          localObject2 = localObject3;
          if (!(localObject3 instanceof FrameLayout.LayoutParams)) {
            localObject2 = null;
          }
          localObject2 = (FrameLayout.LayoutParams)localObject2;
          localObject3 = y.vXH;
          if (!y.bk(f3)) {
            break label1249;
          }
          if (localObject2 != null) {
            ((FrameLayout.LayoutParams)localObject2).topMargin = 0;
          }
        }
        for (;;)
        {
          dzT().setLayoutParams((ViewGroup.LayoutParams)localObject2);
          ((HardTouchableLayout)this.vLZ.getValue()).setOnSingleClickListener((HardTouchableLayout.g)new j(this));
          dzR().setOnClickListener((View.OnClickListener)new k(this));
          dzR().setVisibility(0);
          localObject2 = getIntent().getByteArrayExtra("ref_feed_info");
          if (localObject2 != null)
          {
            localObject3 = new azy();
            ((azy)localObject3).parseFrom((byte[])localObject2);
            this.vMc = ((azy)localObject3);
          }
          k.a(this.tCD, (AppCompatActivity)this, null, 6);
          localObject2 = dzQ();
          localObject3 = new FinderMediaBannerAdapter(this.tCD);
          ((FinderMediaBannerAdapter)localObject3).isLongVideo = this.vMe;
          ((FinderMediaBannerAdapter)localObject3).setItems((List)this.mediaList);
          ((FinderMediaBanner)localObject2).setAdapter((RecyclerView.a)localObject3);
          dzQ().setRefFeedInfo(this.vMc);
          dzQ().setPageChangeCallback((MediaBanner.c)new l(this));
          if (this.vMe)
          {
            this.vMf = new com.tencent.mm.plugin.finder.event.base.c("Finder.MediaPreviewUI");
            this.tCD.weT = new com.tencent.mm.plugin.finder.event.c(this.vMf);
            localObject2 = this.vMf;
            if (localObject2 == null) {
              p.hyc();
            }
            ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)new f(this));
            dzU().setVisibility(0);
            dzU().setPlayBtnOnClickListener((View.OnClickListener)new g(this));
            dzU().setVideoTotalTime(((cjl)this.mediaList.getFirst()).videoDuration);
            dzU().setIsPlay(true);
            dzU().setIplaySeekCallback((com.tencent.mm.plugin.sight.decode.ui.b)new h(this));
          }
          this.vLV = ((FinderImgFeedMusicTag)findViewById(2131302589));
          AppMethodBeat.o(167426);
          return;
          localObject2 = null;
          break;
          label1243:
          localObject3 = null;
          break label645;
          label1249:
          if (localObject2 != null)
          {
            localObject3 = getContext();
            p.g(localObject3, "context");
            ((FrameLayout.LayoutParams)localObject2).topMargin = ((int)((AppCompatActivity)localObject3).getResources().getDimension(2131165311));
          }
        }
        label1288:
        Object localObject4 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
      }
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(167429);
    if (!dzV()) {
      finish();
    }
    AppMethodBeat.o(167429);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167425);
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    getWindow().setFlags(201326592, 201326592);
    setLightNavigationbarIcon();
    ao.d(getWindow(), false);
    this.vMe = getIntent().getBooleanExtra("long_video_preview", false);
    initView();
    if (!this.jUE)
    {
      this.jUE = true;
      Log.i("Finder.MediaPreviewUI", "runEnterAnimation");
      Object localObject = getIntent().getParcelableExtra("crop_info");
      paramBundle = (Bundle)localObject;
      if (!(localObject instanceof ViewAnimHelper.ViewInfo)) {
        paramBundle = null;
      }
      paramBundle = (ViewAnimHelper.ViewInfo)paramBundle;
      if (paramBundle == null)
      {
        AppMethodBeat.o(167425);
        return;
      }
      localObject = dzT();
      View localView = dzS();
      Window localWindow = getWindow();
      p.g(localWindow, "window");
      ((AnimationLayout)localObject).a(localView, localWindow.getDecorView(), paramBundle, (Animator.AnimatorListener)new n(this));
    }
    AppMethodBeat.o(167425);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(252531);
    Object localObject = this.vMf;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject).onRelease();
    }
    super.onDestroy();
    if (this.musicInfo != null)
    {
      localObject = this.vLV;
      if (localObject != null)
      {
        ((FinderImgFeedMusicTag)localObject).dle();
        AppMethodBeat.o(252531);
        return;
      }
    }
    AppMethodBeat.o(252531);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(252530);
    super.onPause();
    if (this.musicInfo != null)
    {
      FinderImgFeedMusicTag localFinderImgFeedMusicTag = this.vLV;
      if (localFinderImgFeedMusicTag != null)
      {
        localFinderImgFeedMusicTag.bdY();
        AppMethodBeat.o(252530);
        return;
      }
    }
    AppMethodBeat.o(252530);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(252529);
    super.onResume();
    if (this.musicInfo != null)
    {
      FinderImgFeedMusicTag localFinderImgFeedMusicTag = this.vLV;
      if (localFinderImgFeedMusicTag != null)
      {
        localFinderImgFeedMusicTag.dlf();
        AppMethodBeat.o(252529);
        return;
      }
    }
    AppMethodBeat.o(252529);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(167427);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.vMd))
    {
      this.vMd = false;
      Ls(0);
    }
    AppMethodBeat.o(167427);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$Companion;", "", "()V", "IS_VLOG_MODE", "", "KEY_LONG_VIDEO_PREVIEW", "MEDIA_LIST", "MEDIA_LIST_COUNT", "REF_FEED_INFO", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/view/AnimationLayout;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<AnimationLayout>
  {
    b(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$checkPlay$1$1"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderMediaPreviewUI paramFinderMediaPreviewUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252516);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$checkPlay$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (FinderMediaPreviewUI.e(this.vMh).getVisibility() == 0) {
        FinderMediaPreviewUI.e(this.vMh).setVisibility(8);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$checkPlay$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(252516);
        return;
        FinderMediaPreviewUI.e(this.vMh).setVisibility(0);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<View>
  {
    d(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<View>
  {
    e(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initSeekBar$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
  public static final class f
    extends com.tencent.mm.plugin.finder.event.base.d
  {
    public final void a(final com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(252518);
      p.h(paramb, "ev");
      if (!(paramb instanceof com.tencent.mm.plugin.finder.event.c.a)) {
        paramb = null;
      }
      for (;;)
      {
        paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
        if (paramb == null)
        {
          AppMethodBeat.o(252518);
          return;
        }
        FinderMediaPreviewUI.e(this.vMh).post((Runnable)new a(this, paramb));
        AppMethodBeat.o(252518);
        return;
      }
    }
    
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(252519);
      p.h(paramc, "dispatcher");
      p.h(paramb, "event");
      boolean bool = paramb instanceof com.tencent.mm.plugin.finder.event.c.a;
      AppMethodBeat.o(252519);
      return bool;
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderMediaPreviewUI.f paramf, com.tencent.mm.plugin.finder.event.c.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(252517);
        switch (paramb.type)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(252517);
          return;
          FinderMediaPreviewUI.e(this.vMi.vMh).xv(0);
          AppMethodBeat.o(252517);
          return;
          FinderMediaPreviewUI.e(this.vMi.vMh).setVideoTotalTime(paramb.jcu);
          FinderMediaPreviewUI.e(this.vMi.vMh).xv(paramb.offset);
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(FinderMediaPreviewUI paramFinderMediaPreviewUI) {}
    
    public final void onClick(View paramView)
    {
      boolean bool2 = true;
      AppMethodBeat.i(252520);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initSeekBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      boolean bool3 = FinderMediaPreviewUI.e(this.vMh).cEF();
      paramView = this.vMh;
      if (!bool3)
      {
        bool1 = true;
        FinderMediaPreviewUI.a(paramView, bool1);
        paramView = FinderMediaPreviewUI.e(this.vMh);
        if (bool3) {
          break label111;
        }
      }
      label111:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramView.setIsPlay(bool1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initSeekBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(252520);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initSeekBar$3", "Lcom/tencent/mm/plugin/sight/decode/ui/IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "plugin-finder_release"})
  public static final class h
    implements com.tencent.mm.plugin.sight.decode.ui.b
  {
    public final void aJq()
    {
      AppMethodBeat.i(252522);
      FinderMediaPreviewUI.a(this.vMh, false);
      FinderMediaPreviewUI.e(this.vMh).setIsPlay(false);
      AppMethodBeat.o(252522);
    }
    
    public final void rk(int paramInt)
    {
      AppMethodBeat.i(252521);
      FinderMediaPreviewUI.c(this.vMh, paramInt);
      FinderMediaPreviewUI.e(this.vMh).setIsPlay(true);
      AppMethodBeat.o(252521);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initView$2$1"})
  static final class i
    implements Runnable
  {
    i(azk paramazk, FinderMediaPreviewUI paramFinderMediaPreviewUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(252523);
      FinderImgFeedMusicTag localFinderImgFeedMusicTag = FinderMediaPreviewUI.a(jdField_this);
      if (localFinderImgFeedMusicTag != null) {
        localFinderImgFeedMusicTag.setVisibility(8);
      }
      localFinderImgFeedMusicTag = FinderMediaPreviewUI.a(jdField_this);
      if (localFinderImgFeedMusicTag != null) {
        localFinderImgFeedMusicTag.a(this.uPN);
      }
      localFinderImgFeedMusicTag = FinderMediaPreviewUI.a(jdField_this);
      if (localFinderImgFeedMusicTag != null)
      {
        localFinderImgFeedMusicTag.dlf();
        AppMethodBeat.o(252523);
        return;
      }
      AppMethodBeat.o(252523);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initView$4", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class j
    implements HardTouchableLayout.g
  {
    public final void b(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(252524);
      p.h(paramView, "view");
      if (((cjl)this.vMh.mediaList.get(FinderMediaPreviewUI.b(this.vMh))).mediaType == 6)
      {
        FinderMediaPreviewUI.c(this.vMh);
        FinderMediaPreviewUI.c(this.vMh);
        AppMethodBeat.o(252524);
        return;
      }
      FinderMediaPreviewUI.d(this.vMh);
      AppMethodBeat.o(252524);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(FinderMediaPreviewUI paramFinderMediaPreviewUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252525);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.vMh.onBackPressed();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(252525);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initView$8", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "plugin-finder_release"})
  public static final class l
    implements MediaBanner.c
  {
    public final void e(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(252526);
      FinderMediaPreviewUI.a(this.vMh, paramInt);
      if (!paramBoolean1)
      {
        AppMethodBeat.o(252526);
        return;
      }
      FinderMediaPreviewUI.b(this.vMh, paramInt);
      AppMethodBeat.o(252526);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<FinderMediaBanner>
  {
    m(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$runEnterAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class n
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(167411);
      FinderMediaPreviewUI.f(this.vMh);
      AppMethodBeat.o(167411);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(167412);
      FinderMediaPreviewUI.g(this.vMh).setVisibility(0);
      AppMethodBeat.o(167412);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$runExitAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class o
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
      this.vMh.finish();
      this.vMh.overridePendingTransition(2130771986, 2130771986);
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
      paramAnimator = FinderMediaPreviewUI.h(this.vMh);
      if (paramAnimator != null) {
        paramAnimator.setVisibility(8);
      }
      FinderMediaPreviewUI.i(this.vMh).setVisibility(8);
      AppMethodBeat.o(167413);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class p
    implements ValueAnimator.AnimatorUpdateListener
  {
    public static final p vMk;
    
    static
    {
      AppMethodBeat.i(167418);
      vMk = new p();
      AppMethodBeat.o(167418);
    }
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(167417);
      p.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(167417);
        throw paramValueAnimator;
      }
      ((Float)paramValueAnimator).floatValue();
      AppMethodBeat.o(167417);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "kotlin.jvm.PlatformType", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<FinderLongVideoPlayerSeekBar>
  {
    q(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/view/HardTouchableLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class r
    extends q
    implements kotlin.g.a.a<HardTouchableLayout>
  {
    r(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaPreviewUI
 * JD-Core Version:    0.7.0.1
 */