package com.tencent.mm.plugin.finder.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.b.a;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.loader.e;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.video.FinderLongVideoPlayerSeekBar;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.s;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
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
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;

@com.tencent.mm.ui.base.a(35)
@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "animationLayout", "Lcom/tencent/mm/view/AnimationLayout;", "getAnimationLayout", "()Lcom/tencent/mm/view/AnimationLayout;", "animationLayout$delegate", "Lkotlin/Lazy;", "closeBtn", "Landroid/view/View;", "getCloseBtn", "()Landroid/view/View;", "closeBtn$delegate", "curPos", "", "galleryBg", "getGalleryBg", "galleryBg$delegate", "isComeFromCreate", "", "isLongVideoPreview", "mediaBanner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "getMediaBanner", "()Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "mediaBanner$delegate", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaList", "()Ljava/util/LinkedList;", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "musicTagView", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag;", "playingAnimation", "posterLayout", "Landroid/view/ViewGroup;", "refFeedInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "getRefFeedInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeedInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "seekBar", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "getSeekBar", "()Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "seekBar$delegate", "touchableLayout", "Lcom/tencent/mm/view/HardTouchableLayout;", "getTouchableLayout", "()Lcom/tencent/mm/view/HardTouchableLayout;", "touchableLayout$delegate", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "videoDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "checkPlay", "", "position", "getLayoutId", "initSeekBar", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onWindowFocusChanged", "hasFocus", "runEnterAnimation", "runExitAnimation", "toggleVideo", "forcePause", "videoSeek", "time", "Companion", "plugin-finder_release"})
public final class FinderMediaPreviewUI
  extends MMFinderUI
{
  public static final a AsT;
  private final f AsH;
  private FinderImgFeedMusicTag AsI;
  private final f AsJ;
  private final f AsK;
  private final f AsL;
  private final f AsM;
  private ViewGroup AsN;
  private final f AsO;
  private bge AsP;
  private boolean AsQ;
  private boolean AsR;
  private com.tencent.mm.plugin.finder.event.base.c AsS;
  private HashMap _$_findViewCache;
  private boolean mLR;
  final LinkedList<csg> mediaList;
  private bfg musicInfo;
  private final com.tencent.mm.plugin.finder.video.l xkW;
  private int yeA;
  
  static
  {
    AppMethodBeat.i(167420);
    AsT = new a((byte)0);
    AppMethodBeat.o(167420);
  }
  
  public FinderMediaPreviewUI()
  {
    AppMethodBeat.i(167432);
    this.AsH = g.ar((kotlin.g.a.a)new m(this));
    this.AsJ = g.ar((kotlin.g.a.a)new d(this));
    this.AsK = g.ar((kotlin.g.a.a)new e(this));
    this.AsL = g.ar((kotlin.g.a.a)new b(this));
    this.AsM = g.ar((kotlin.g.a.a)new r(this));
    this.AsO = g.ar((kotlin.g.a.a)new q(this));
    this.xkW = new com.tencent.mm.plugin.finder.video.l();
    this.mediaList = new LinkedList();
    this.AsQ = true;
    AppMethodBeat.o(167432);
  }
  
  private final void Qz(int paramInt)
  {
    AppMethodBeat.i(167428);
    Object localObject = eaG().getPagerView().cK(paramInt);
    if (localObject == null) {
      p.iCn();
    }
    p.j(localObject, "mediaBanner.pagerView.fi…apterPosition(position)!!");
    if ((((RecyclerView.v)localObject).mg() == 2) || (((RecyclerView.v)localObject).mg() == 7))
    {
      this.xkW.eho();
      AppMethodBeat.o(167428);
      return;
    }
    localObject = (FinderVideoLayout)((RecyclerView.v)localObject).amk.findViewById(b.f.finder_banner_video_layout);
    p.j(this.mediaList.get(paramInt), "mediaList[position]");
    if (localObject != null)
    {
      ((FinderVideoLayout)localObject).getVideoCore().eho();
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
      FinderVideoLayout.a((FinderVideoLayout)localObject, 0, FeedData.a.j(localFinderItem), 0, false, false, 252);
      FinderVideoLayout.a((FinderVideoLayout)localObject, 0, 3);
      AppMethodBeat.o(167428);
      return;
    }
    AppMethodBeat.o(167428);
  }
  
  private final FinderMediaBanner eaG()
  {
    AppMethodBeat.i(167421);
    FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)this.AsH.getValue();
    AppMethodBeat.o(167421);
    return localFinderMediaBanner;
  }
  
  private final View eaH()
  {
    AppMethodBeat.i(167422);
    View localView = (View)this.AsJ.getValue();
    AppMethodBeat.o(167422);
    return localView;
  }
  
  private final View eaI()
  {
    AppMethodBeat.i(167423);
    View localView = (View)this.AsK.getValue();
    AppMethodBeat.o(167423);
    return localView;
  }
  
  private final AnimationLayout eaJ()
  {
    AppMethodBeat.i(167424);
    AnimationLayout localAnimationLayout = (AnimationLayout)this.AsL.getValue();
    AppMethodBeat.o(167424);
    return localAnimationLayout;
  }
  
  private final FinderLongVideoPlayerSeekBar eaK()
  {
    AppMethodBeat.i(266203);
    FinderLongVideoPlayerSeekBar localFinderLongVideoPlayerSeekBar = (FinderLongVideoPlayerSeekBar)this.AsO.getValue();
    AppMethodBeat.o(266203);
    return localFinderLongVideoPlayerSeekBar;
  }
  
  private final boolean eaL()
  {
    AppMethodBeat.i(266207);
    Object localObject = eaG().getPagerView().cK(0);
    if (localObject == null) {
      p.iCn();
    }
    p.j(localObject, "mediaBanner.pagerView.fi…erForAdapterPosition(0)!!");
    localObject = ((FinderVideoLayout)((RecyclerView.v)localObject).amk.findViewById(b.f.finder_banner_video_layout)).getVideoView();
    if (localObject != null)
    {
      boolean bool = ((s)localObject).isPlaying();
      if (bool) {
        ((s)localObject).pause();
      }
      while (!bool)
      {
        AppMethodBeat.o(266207);
        return true;
        ((s)localObject).bqo();
      }
      AppMethodBeat.o(266207);
      return false;
    }
    AppMethodBeat.o(266207);
    return false;
  }
  
  private final boolean eaM()
  {
    AppMethodBeat.i(266209);
    if (this.mLR)
    {
      AppMethodBeat.o(266209);
      return false;
    }
    this.mLR = true;
    Log.i("Finder.MediaPreviewUI", "runExitAnimation");
    Object localObject2 = getIntent().getParcelableExtra("crop_info");
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof ViewAnimHelper.ViewInfo)) {
      localObject1 = null;
    }
    localObject1 = (ViewAnimHelper.ViewInfo)localObject1;
    if (localObject1 == null)
    {
      AppMethodBeat.o(266209);
      return false;
    }
    localObject2 = eaJ();
    View localView = eaI();
    Window localWindow = getWindow();
    p.j(localWindow, "window");
    ((AnimationLayout)localObject2).a(localView, localWindow.getDecorView(), (ViewAnimHelper.ViewInfo)localObject1, (Animator.AnimatorListener)new o(this), (ValueAnimator.AnimatorUpdateListener)FinderMediaPreviewUI.p.AsX);
    AppMethodBeat.o(266209);
    return true;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(266219);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(266219);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(266218);
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
    AppMethodBeat.o(266218);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_media_preview_ui;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167426);
    super.initView();
    Object localObject1 = (com.tencent.mm.cd.a)new csf();
    Object localObject3 = getIntent().getByteArrayExtra("media_list_");
    try
    {
      ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (csf)localObject1;
      if (localObject1 == null)
      {
        localObject1 = new csf();
        this.mediaList.addAll((Collection)((csf)localObject1).mediaList);
        this.musicInfo = ((csf)localObject1).TzP;
        localObject3 = (csg)this.mediaList.getFirst();
        f3 = 0.0F;
        f2 = ((csg)localObject3).width;
        f1 = ((csg)localObject3).height;
        localObject1 = ((csg)localObject3).zBo;
        localObject5 = ((Iterable)this.mediaList).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject4 = (csg)((Iterator)localObject5).next();
          float f4 = ((csg)localObject4).height * 1.0F / ((csg)localObject4).width;
          f3 = ((csg)localObject3).height * 1.0F / ((csg)localObject3).width;
          if (f3 >= f4) {
            break label1295;
          }
          f2 = ((csg)localObject4).width;
          f1 = ((csg)localObject4).height;
          localObject3 = ((csg)localObject4).zBo;
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
        if (this.AsR)
        {
          localObject3 = aj.AGc;
          aj.a((Activity)this, f2, f1, (View)eaG().getPagerView(), (css)localObject2);
        }
        for (;;)
        {
          eaG().requestLayout();
          localObject2 = this.musicInfo;
          if (localObject2 != null) {
            eaG().post((Runnable)new i((bfg)localObject2, this));
          }
          eaJ().setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(eaG().getPagerView().getLayoutParams()));
          eaG().getPagerViewContainer().removeView((View)eaG().getPagerView());
          eaJ().addView((View)eaG().getPagerView());
          eaG().getPagerViewContainer().addView((View)eaJ(), 0);
          if (this.AsR) {
            break label824;
          }
          localObject2 = LayoutInflater.from((Context)getContext()).inflate(b.g.finder_banner_inside_self_layout, (ViewGroup)eaG().getPagerViewContainer(), false);
          if (localObject2 != null) {
            break;
          }
          localObject2 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(167426);
          throw ((Throwable)localObject2);
          localObject2 = eaG().getPagerView().getLayoutParams();
          localObject3 = getContext();
          p.j(localObject3, "context");
          localObject3 = ((AppCompatActivity)localObject3).getResources();
          p.j(localObject3, "context.resources");
          ((ViewGroup.LayoutParams)localObject2).width = ((Resources)localObject3).getDisplayMetrics().widthPixels;
          localObject2 = eaG().getPagerView().getLayoutParams();
          localObject3 = getContext();
          p.j(localObject3, "context");
          localObject3 = ((AppCompatActivity)localObject3).getResources();
          p.j(localObject3, "context.resources");
          ((ViewGroup.LayoutParams)localObject2).height = ((int)(((Resources)localObject3).getDisplayMetrics().widthPixels * f3));
        }
        this.AsN = ((ViewGroup)localObject2);
        localObject2 = this.AsN;
        if (localObject2 != null)
        {
          localObject2 = (ImageView)((ViewGroup)localObject2).findViewById(b.f.post_avatar);
          localObject3 = this.AsN;
          if (localObject3 == null) {
            break label1250;
          }
          localObject3 = (TextView)((ViewGroup)localObject3).findViewById(b.f.post_nickname);
          label645:
          if (localObject2 != null) {
            ((ImageView)localObject2).setVisibility(8);
          }
          if (localObject3 != null) {
            ((TextView)localObject3).setVisibility(8);
          }
          localObject4 = com.tencent.mm.plugin.finder.api.d.wZQ;
          localObject4 = d.a.aAK(z.bdh());
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
              localObject5 = com.tencent.mm.plugin.finder.loader.t.ztT;
              localObject5 = com.tencent.mm.plugin.finder.loader.t.dJh();
              e locale = new e(((i)localObject4).field_avatarUrl);
              com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
              ((com.tencent.mm.loader.d)localObject5).a(locale, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
            }
            if (localObject3 != null) {
              ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)getContext(), (CharSequence)((i)localObject4).getNickname()));
            }
          }
          localObject2 = this.AsN;
          if (localObject2 != null) {
            ((ViewGroup)localObject2).setVisibility(8);
          }
          eaG().getPagerViewContainer().addView((View)this.AsN);
          label824:
          localObject3 = eaJ().getLayoutParams();
          localObject2 = localObject3;
          if (!(localObject3 instanceof FrameLayout.LayoutParams)) {
            localObject2 = null;
          }
          localObject2 = (FrameLayout.LayoutParams)localObject2;
          localObject3 = aj.AGc;
          if (!aj.bj(f3)) {
            break label1256;
          }
          if (localObject2 != null) {
            ((FrameLayout.LayoutParams)localObject2).topMargin = 0;
          }
        }
        for (;;)
        {
          eaJ().setLayoutParams((ViewGroup.LayoutParams)localObject2);
          ((HardTouchableLayout)this.AsM.getValue()).setOnSingleClickListener((HardTouchableLayout.g)new j(this));
          eaH().setOnClickListener((View.OnClickListener)new k(this));
          eaH().setVisibility(0);
          localObject2 = getIntent().getByteArrayExtra("ref_feed_info");
          if (localObject2 != null)
          {
            localObject3 = new bge();
            ((bge)localObject3).parseFrom((byte[])localObject2);
            this.AsP = ((bge)localObject3);
          }
          com.tencent.mm.plugin.finder.video.l.a(this.xkW, (AppCompatActivity)this, null, 6);
          localObject2 = eaG();
          localObject3 = new FinderMediaBannerAdapter(this.xkW);
          ((FinderMediaBannerAdapter)localObject3).isLongVideo = this.AsR;
          ((FinderMediaBannerAdapter)localObject3).setItems((List)this.mediaList);
          ((FinderMediaBanner)localObject2).setAdapter((RecyclerView.a)localObject3);
          eaG().setRefFeedInfo(this.AsP);
          eaG().setPageChangeCallback((MediaBanner.c)new l(this));
          if (getIntent().getBooleanExtra("KEY_SHOW_SEEK_BAR", false))
          {
            this.AsS = new com.tencent.mm.plugin.finder.event.base.c("Finder.MediaPreviewUI");
            this.xkW.ANB = new com.tencent.mm.plugin.finder.event.c(this.AsS);
            localObject2 = this.AsS;
            if (localObject2 == null) {
              p.iCn();
            }
            ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)new f(this));
            eaK().setVisibility(0);
            eaK().setPlayBtnOnClickListener((View.OnClickListener)new g(this));
            eaK().setVideoTotalTime(((csg)this.mediaList.getFirst()).videoDuration);
            eaK().setIsPlay(true);
            eaK().setIplaySeekCallback((com.tencent.mm.plugin.sight.decode.ui.b)new h(this));
          }
          this.AsI = ((FinderImgFeedMusicTag)findViewById(b.f.image_music_tag));
          AppMethodBeat.o(167426);
          return;
          localObject2 = null;
          break;
          label1250:
          localObject3 = null;
          break label645;
          label1256:
          if (localObject2 != null)
          {
            localObject3 = getContext();
            p.j(localObject3, "context");
            ((FrameLayout.LayoutParams)localObject2).topMargin = ((int)((AppCompatActivity)localObject3).getResources().getDimension(b.d.Edge_7_5_A));
          }
        }
        label1295:
        Object localObject4 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
      }
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(167429);
    if (!eaM()) {
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
    ar.d(getWindow(), false);
    this.AsR = getIntent().getBooleanExtra("long_video_preview", false);
    initView();
    if (!this.mLR)
    {
      this.mLR = true;
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
      localObject = eaJ();
      View localView = eaI();
      Window localWindow = getWindow();
      p.j(localWindow, "window");
      ((AnimationLayout)localObject).a(localView, localWindow.getDecorView(), paramBundle, (Animator.AnimatorListener)new n(this));
    }
    AppMethodBeat.o(167425);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(266206);
    Object localObject = this.AsS;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject).onRelease();
    }
    super.onDestroy();
    if (this.musicInfo != null)
    {
      localObject = this.AsI;
      if (localObject != null)
      {
        ((FinderImgFeedMusicTag)localObject).dLe();
        AppMethodBeat.o(266206);
        return;
      }
    }
    AppMethodBeat.o(266206);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(266205);
    super.onPause();
    if (this.musicInfo != null)
    {
      FinderImgFeedMusicTag localFinderImgFeedMusicTag = this.AsI;
      if (localFinderImgFeedMusicTag != null)
      {
        localFinderImgFeedMusicTag.bnt();
        AppMethodBeat.o(266205);
        return;
      }
    }
    AppMethodBeat.o(266205);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(266204);
    super.onResume();
    if (this.musicInfo != null)
    {
      FinderImgFeedMusicTag localFinderImgFeedMusicTag = this.AsI;
      if (localFinderImgFeedMusicTag != null)
      {
        localFinderImgFeedMusicTag.dLf();
        AppMethodBeat.o(266204);
        return;
      }
    }
    AppMethodBeat.o(266204);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(167427);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.AsQ))
    {
      this.AsQ = false;
      Qz(0);
    }
    AppMethodBeat.o(167427);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$Companion;", "", "()V", "IS_VLOG_MODE", "", "KEY_LONG_VIDEO_PREVIEW", "KEY_SHOW_SEEK_BAR", "MEDIA_LIST", "MEDIA_LIST_COUNT", "REF_FEED_INFO", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/view/AnimationLayout;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<AnimationLayout>
  {
    b(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$checkPlay$1$1"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderMediaPreviewUI paramFinderMediaPreviewUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(283569);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$checkPlay$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (FinderMediaPreviewUI.f(this.AsU).getVisibility() == 0) {
        FinderMediaPreviewUI.f(this.AsU).setVisibility(8);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$checkPlay$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(283569);
        return;
        FinderMediaPreviewUI.f(this.AsU).setVisibility(0);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<View>
  {
    d(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<View>
  {
    e(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initSeekBar$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
  public static final class f
    extends com.tencent.mm.plugin.finder.event.base.d
  {
    public final void a(final com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(282045);
      p.k(paramb, "ev");
      if (!(paramb instanceof c.a)) {
        paramb = null;
      }
      for (;;)
      {
        paramb = (c.a)paramb;
        if (paramb == null)
        {
          AppMethodBeat.o(282045);
          return;
        }
        FinderMediaPreviewUI.f(this.AsU).post((Runnable)new a(this, paramb));
        AppMethodBeat.o(282045);
        return;
      }
    }
    
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(282046);
      p.k(paramc, "dispatcher");
      p.k(paramb, "event");
      boolean bool = paramb instanceof c.a;
      AppMethodBeat.o(282046);
      return bool;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderMediaPreviewUI.f paramf, c.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(279195);
        switch (paramb.type)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(279195);
          return;
          FinderMediaPreviewUI.f(this.AsV.AsU).AS(0);
          AppMethodBeat.o(279195);
          return;
          FinderMediaPreviewUI.f(this.AsV.AsU).setVideoTotalTime(paramb.total);
          FinderMediaPreviewUI.f(this.AsV.AsU).AS(paramb.offset);
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(FinderMediaPreviewUI paramFinderMediaPreviewUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(288175);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initSeekBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      boolean bool = FinderMediaPreviewUI.a(this.AsU);
      FinderMediaPreviewUI.f(this.AsU).setIsPlay(bool);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initSeekBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(288175);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initSeekBar$3", "Lcom/tencent/mm/plugin/sight/decode/ui/IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "plugin-finder_release"})
  public static final class h
    implements com.tencent.mm.plugin.sight.decode.ui.b
  {
    public final void aRo()
    {
      AppMethodBeat.i(272992);
      FinderMediaPreviewUI.g(this.AsU);
      FinderMediaPreviewUI.f(this.AsU).setIsPlay(false);
      AppMethodBeat.o(272992);
    }
    
    public final void tY(int paramInt)
    {
      AppMethodBeat.i(272991);
      FinderMediaPreviewUI.c(this.AsU, paramInt);
      FinderMediaPreviewUI.f(this.AsU).setIsPlay(true);
      AppMethodBeat.o(272991);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initView$2$1"})
  static final class i
    implements Runnable
  {
    i(bfg parambfg, FinderMediaPreviewUI paramFinderMediaPreviewUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(279519);
      FinderImgFeedMusicTag localFinderImgFeedMusicTag = FinderMediaPreviewUI.b(jdField_this);
      if (localFinderImgFeedMusicTag != null) {
        localFinderImgFeedMusicTag.setVisibility(8);
      }
      localFinderImgFeedMusicTag = FinderMediaPreviewUI.b(jdField_this);
      if (localFinderImgFeedMusicTag != null) {
        localFinderImgFeedMusicTag.a(this.zCk);
      }
      localFinderImgFeedMusicTag = FinderMediaPreviewUI.b(jdField_this);
      if (localFinderImgFeedMusicTag != null)
      {
        localFinderImgFeedMusicTag.dLf();
        AppMethodBeat.o(279519);
        return;
      }
      AppMethodBeat.o(279519);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initView$4", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class j
    implements HardTouchableLayout.g
  {
    public final void et(View paramView)
    {
      AppMethodBeat.i(286493);
      p.k(paramView, "view");
      if (((csg)this.AsU.mediaList.get(FinderMediaPreviewUI.c(this.AsU))).mediaType == 6)
      {
        FinderMediaPreviewUI.d(this.AsU);
        FinderMediaPreviewUI.d(this.AsU);
        AppMethodBeat.o(286493);
        return;
      }
      FinderMediaPreviewUI.e(this.AsU);
      AppMethodBeat.o(286493);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(FinderMediaPreviewUI paramFinderMediaPreviewUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(291961);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.AsU.onBackPressed();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(291961);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initView$8", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "plugin-finder_release"})
  public static final class l
    implements MediaBanner.c
  {
    public final void g(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(268690);
      FinderMediaPreviewUI.a(this.AsU, paramInt);
      if (!paramBoolean1)
      {
        AppMethodBeat.o(268690);
        return;
      }
      FinderMediaPreviewUI.b(this.AsU, paramInt);
      AppMethodBeat.o(268690);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<FinderMediaBanner>
  {
    m(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$runEnterAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class n
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(167411);
      FinderMediaPreviewUI.h(this.AsU);
      FinderMediaPreviewUI.i(this.AsU).GrG.setEmpty();
      FinderMediaPreviewUI.i(this.AsU).invalidate();
      AppMethodBeat.o(167411);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(167412);
      FinderMediaPreviewUI.j(this.AsU).setVisibility(0);
      AppMethodBeat.o(167412);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$runExitAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class o
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(167415);
      p.k(paramAnimator, "animation");
      AppMethodBeat.o(167415);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(167414);
      p.k(paramAnimator, "animation");
      this.AsU.finish();
      paramAnimator = this.AsU;
      int i = b.a.anim_not_change;
      paramAnimator.overridePendingTransition(i, i);
      AppMethodBeat.o(167414);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(167416);
      p.k(paramAnimator, "animation");
      AppMethodBeat.o(167416);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(167413);
      p.k(paramAnimator, "animation");
      paramAnimator = FinderMediaPreviewUI.k(this.AsU);
      if (paramAnimator != null) {
        paramAnimator.setVisibility(8);
      }
      FinderMediaPreviewUI.l(this.AsU).setVisibility(8);
      AppMethodBeat.o(167413);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "kotlin.jvm.PlatformType", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<FinderLongVideoPlayerSeekBar>
  {
    q(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/view/HardTouchableLayout;", "kotlin.jvm.PlatformType", "invoke"})
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