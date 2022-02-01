package com.tencent.mm.plugin.finder.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
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
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.a;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.video.FinderLongVideoPlayerSeekBar;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.l;
import com.tencent.mm.plugin.finder.video.t;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.brq;
import com.tencent.mm.protocal.protobuf.djh;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.HardTouchableLayout.g;
import com.tencent.mm.view.MediaBanner.c;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@com.tencent.mm.ui.base.a(35)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "animationLayout", "Lcom/tencent/mm/view/AnimationLayout;", "getAnimationLayout", "()Lcom/tencent/mm/view/AnimationLayout;", "animationLayout$delegate", "Lkotlin/Lazy;", "closeBtn", "Landroid/view/View;", "getCloseBtn", "()Landroid/view/View;", "closeBtn$delegate", "curPos", "", "galleryBg", "getGalleryBg", "galleryBg$delegate", "isComeFromCreate", "", "isLongVideoPreview", "mediaBanner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "getMediaBanner", "()Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "mediaBanner$delegate", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaList", "()Ljava/util/LinkedList;", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "musicTagView", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag;", "playingAnimation", "posterLayout", "Landroid/view/ViewGroup;", "refFeedInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "getRefFeedInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeedInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "seekBar", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "getSeekBar", "()Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "seekBar$delegate", "touchableLayout", "Lcom/tencent/mm/view/HardTouchableLayout;", "getTouchableLayout", "()Lcom/tencent/mm/view/HardTouchableLayout;", "touchableLayout$delegate", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "videoDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "checkPlay", "", "position", "getLayoutId", "initSeekBar", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onWindowFocusChanged", "hasFocus", "runEnterAnimation", "runExitAnimation", "toggleVideo", "forcePause", "videoSeek", "time", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderMediaPreviewUI
  extends MMFinderUI
{
  public static final FinderMediaPreviewUI.a FSa;
  private final l AJn;
  private int CEY;
  private final j FSb;
  private FinderImgFeedMusicTag FSc;
  private final j FSd;
  private final j FSe;
  private final j FSf;
  private final j FSg;
  private ViewGroup FSh;
  private final j FSi;
  private brq FSj;
  private boolean FSk;
  private boolean FSl;
  private com.tencent.mm.plugin.finder.event.base.c FSm;
  final LinkedList<dji> mediaList;
  private bqj musicInfo;
  private boolean pIz;
  
  static
  {
    AppMethodBeat.i(167420);
    FSa = new FinderMediaPreviewUI.a((byte)0);
    AppMethodBeat.o(167420);
  }
  
  public FinderMediaPreviewUI()
  {
    AppMethodBeat.i(167432);
    this.FSb = k.cm((kotlin.g.a.a)new i(this));
    this.FSd = k.cm((kotlin.g.a.a)new c(this));
    this.FSe = k.cm((kotlin.g.a.a)new d(this));
    this.FSf = k.cm((kotlin.g.a.a)new b(this));
    this.FSg = k.cm((kotlin.g.a.a)new m(this));
    this.FSi = k.cm((kotlin.g.a.a)new l(this));
    this.AJn = new l();
    this.mediaList = new LinkedList();
    this.FSk = true;
    AppMethodBeat.o(167432);
  }
  
  private final void TI(int paramInt)
  {
    AppMethodBeat.i(167428);
    Object localObject1 = fbw().getPagerView().fU(paramInt);
    s.checkNotNull(localObject1);
    s.s(localObject1, "mediaBanner.pagerView.fi…apterPosition(position)!!");
    if ((((RecyclerView.v)localObject1).caO == 2) || (((RecyclerView.v)localObject1).caO == 7))
    {
      this.AJn.fjr();
      AppMethodBeat.o(167428);
      return;
    }
    localObject1 = (FinderVideoLayout)((RecyclerView.v)localObject1).caK.findViewById(e.e.finder_banner_video_layout);
    s.s(this.mediaList.get(paramInt), "mediaList[position]");
    if (localObject1 != null)
    {
      ((FinderVideoLayout)localObject1).getVideoCore().fjr();
      FinderItem localFinderItem = new FinderItem();
      localFinderItem.setMediaExtList(new LinkedList());
      localFinderItem.getMediaExtList().addAll((Collection)this.mediaList);
      if (((FinderVideoLayout)localObject1).isLongVideo)
      {
        localFinderItem.setLongVideoMediaExtList(new LinkedList());
        localFinderItem.getLongVideoMediaExtList().addAll((Collection)this.mediaList);
        localObject2 = new FinderMediaPreviewUI..ExternalSyntheticLambda1(this);
        fbw().setOnClickListener((View.OnClickListener)localObject2);
        ((FinderVideoLayout)localObject1).setOnClickListener((View.OnClickListener)localObject2);
      }
      Object localObject2 = FeedData.Companion;
      FinderVideoLayout.a((FinderVideoLayout)localObject1, 0, FeedData.a.n(localFinderItem), 0, false, false, 252);
      FinderVideoLayout.a((FinderVideoLayout)localObject1, 0, 3);
    }
    AppMethodBeat.o(167428);
  }
  
  private static final void a(FinderMediaPreviewUI paramFinderMediaPreviewUI, View paramView)
  {
    AppMethodBeat.i(347341);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderMediaPreviewUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderMediaPreviewUI, "this$0");
    paramFinderMediaPreviewUI.onBackPressed();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(347341);
  }
  
  private static final void a(FinderMediaPreviewUI paramFinderMediaPreviewUI, bqj parambqj)
  {
    AppMethodBeat.i(347335);
    s.u(paramFinderMediaPreviewUI, "this$0");
    s.u(parambqj, "$it");
    FinderImgFeedMusicTag localFinderImgFeedMusicTag = paramFinderMediaPreviewUI.FSc;
    if (localFinderImgFeedMusicTag != null) {
      localFinderImgFeedMusicTag.setVisibility(8);
    }
    localFinderImgFeedMusicTag = paramFinderMediaPreviewUI.FSc;
    if (localFinderImgFeedMusicTag != null) {
      localFinderImgFeedMusicTag.a(parambqj);
    }
    paramFinderMediaPreviewUI = paramFinderMediaPreviewUI.FSc;
    if (paramFinderMediaPreviewUI != null) {
      paramFinderMediaPreviewUI.eDU();
    }
    AppMethodBeat.o(347335);
  }
  
  private static final void b(FinderMediaPreviewUI paramFinderMediaPreviewUI, View paramView)
  {
    AppMethodBeat.i(347346);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderMediaPreviewUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderMediaPreviewUI, "this$0");
    boolean bool = a(paramFinderMediaPreviewUI);
    paramFinderMediaPreviewUI.fbA().setIsPlay(bool);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(347346);
  }
  
  private static final void c(FinderMediaPreviewUI paramFinderMediaPreviewUI, View paramView)
  {
    AppMethodBeat.i(347357);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderMediaPreviewUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderMediaPreviewUI, "this$0");
    if (paramFinderMediaPreviewUI.fbA().getVisibility() == 0) {
      paramFinderMediaPreviewUI.fbA().setVisibility(8);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(347357);
      return;
      paramFinderMediaPreviewUI.fbA().setVisibility(0);
    }
  }
  
  private static final void d(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(347365);
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(347365);
      throw paramValueAnimator;
    }
    ((Float)paramValueAnimator).floatValue();
    AppMethodBeat.o(347365);
  }
  
  private final FinderLongVideoPlayerSeekBar fbA()
  {
    AppMethodBeat.i(347295);
    Object localObject = this.FSi.getValue();
    s.s(localObject, "<get-seekBar>(...)");
    localObject = (FinderLongVideoPlayerSeekBar)localObject;
    AppMethodBeat.o(347295);
    return localObject;
  }
  
  private final boolean fbB()
  {
    AppMethodBeat.i(347302);
    Object localObject = fbw().getPagerView().fU(0);
    s.checkNotNull(localObject);
    s.s(localObject, "mediaBanner.pagerView.fi…erForAdapterPosition(0)!!");
    localObject = ((FinderVideoLayout)((RecyclerView.v)localObject).caK.findViewById(e.e.finder_banner_video_layout)).getVideoView();
    if (localObject != null)
    {
      boolean bool = ((t)localObject).isPlaying();
      if (bool) {
        ((t)localObject).pause();
      }
      while (!bool)
      {
        AppMethodBeat.o(347302);
        return true;
        ((t)localObject).bNU();
      }
      AppMethodBeat.o(347302);
      return false;
    }
    AppMethodBeat.o(347302);
    return false;
  }
  
  private final boolean fbC()
  {
    AppMethodBeat.i(347329);
    if (this.pIz)
    {
      AppMethodBeat.o(347329);
      return false;
    }
    this.pIz = true;
    Log.i("Finder.MediaPreviewUI", "runExitAnimation");
    Object localObject = getIntent().getParcelableExtra("crop_info");
    if ((localObject instanceof ViewAnimHelper.ViewInfo)) {}
    for (localObject = (ViewAnimHelper.ViewInfo)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(347329);
      return false;
    }
    fbz().a(fby(), getWindow().getDecorView(), (ViewAnimHelper.ViewInfo)localObject, (Animator.AnimatorListener)new k(this), FinderMediaPreviewUI..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(347329);
    return true;
  }
  
  private final FinderMediaBanner fbw()
  {
    AppMethodBeat.i(167421);
    Object localObject = this.FSb.getValue();
    s.s(localObject, "<get-mediaBanner>(...)");
    localObject = (FinderMediaBanner)localObject;
    AppMethodBeat.o(167421);
    return localObject;
  }
  
  private final View fbx()
  {
    AppMethodBeat.i(167422);
    Object localObject = this.FSd.getValue();
    s.s(localObject, "<get-closeBtn>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(167422);
    return localObject;
  }
  
  private final View fby()
  {
    AppMethodBeat.i(167423);
    Object localObject = this.FSe.getValue();
    s.s(localObject, "<get-galleryBg>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(167423);
    return localObject;
  }
  
  private final AnimationLayout fbz()
  {
    AppMethodBeat.i(167424);
    AnimationLayout localAnimationLayout = (AnimationLayout)this.FSf.getValue();
    AppMethodBeat.o(167424);
    return localAnimationLayout;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return e.f.finder_media_preview_ui;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167426);
    super.initView();
    Object localObject1 = (com.tencent.mm.bx.a)new djh();
    Object localObject3 = getIntent().getByteArrayExtra("media_list_");
    label1191:
    label1207:
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (djh)localObject1;
      if (localObject1 == null)
      {
        localObject1 = new djh();
        this.mediaList.addAll((Collection)((djh)localObject1).mediaList);
        this.musicInfo = ((djh)localObject1).aaOZ;
        localObject3 = this.mediaList.getFirst();
        f2 = ((dji)localObject3).width;
        f1 = ((dji)localObject3).height;
        localObject1 = ((dji)localObject3).EDC;
        localObject5 = ((Iterable)this.mediaList).iterator();
        f3 = 0.0F;
        while (((Iterator)localObject5).hasNext())
        {
          localObject4 = (dji)((Iterator)localObject5).next();
          float f4 = ((dji)localObject4).height * 1.0F / ((dji)localObject4).width;
          f3 = 1.0F * ((dji)localObject3).height / ((dji)localObject3).width;
          if (f3 >= f4) {
            break label1213;
          }
          f2 = ((dji)localObject4).width;
          f1 = ((dji)localObject4).height;
          localObject1 = ((dji)localObject4).EDC;
          localObject3 = localObject4;
        }
      }
    }
    catch (Exception localException)
    {
      label569:
      label1213:
      for (;;)
      {
        float f2;
        float f1;
        Object localObject5;
        float f3;
        Object localObject4;
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        Object localObject2 = null;
        continue;
        continue;
        if (this.FSl)
        {
          localObject3 = av.GiL;
          av.a((Activity)this, f2, f1, (View)fbw().getPagerView(), (dju)localObject2);
        }
        for (;;)
        {
          fbw().requestLayout();
          localObject2 = this.musicInfo;
          if (localObject2 != null) {
            fbw().post(new FinderMediaPreviewUI..ExternalSyntheticLambda4(this, (bqj)localObject2));
          }
          fbz().setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(fbw().getPagerView().getLayoutParams()));
          fbw().getPagerViewContainer().removeView((View)fbw().getPagerView());
          fbz().addView((View)fbw().getPagerView());
          fbw().getPagerViewContainer().addView((View)fbz(), 0);
          if (this.FSl) {
            break label748;
          }
          localObject2 = LayoutInflater.from((Context)getContext()).inflate(e.f.finder_banner_inside_self_layout, (ViewGroup)fbw().getPagerViewContainer(), false);
          if (localObject2 != null) {
            break;
          }
          localObject2 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(167426);
          throw ((Throwable)localObject2);
          fbw().getPagerView().getLayoutParams().width = getContext().getResources().getDisplayMetrics().widthPixels;
          fbw().getPagerView().getLayoutParams().height = ((int)(f3 * getContext().getResources().getDisplayMetrics().widthPixels));
        }
        this.FSh = ((ViewGroup)localObject2);
        localObject2 = this.FSh;
        if (localObject2 == null)
        {
          localObject2 = null;
          localObject3 = this.FSh;
          if (localObject3 != null) {
            break label1191;
          }
          localObject3 = null;
          if (localObject2 != null) {
            ((ImageView)localObject2).setVisibility(8);
          }
          if (localObject3 != null) {
            ((TextView)localObject3).setVisibility(8);
          }
          localObject4 = com.tencent.mm.plugin.finder.api.d.AwY;
          localObject4 = d.a.auT(z.bAW());
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
              localObject5 = com.tencent.mm.plugin.finder.loader.p.ExI;
              localObject5 = com.tencent.mm.plugin.finder.loader.p.eCp();
              com.tencent.mm.plugin.finder.loader.b localb = new com.tencent.mm.plugin.finder.loader.b(((m)localObject4).field_avatarUrl);
              com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
              ((com.tencent.mm.loader.d)localObject5).a(localb, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
            }
            if (localObject3 != null) {
              ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)getContext(), (CharSequence)((m)localObject4).getNickname()));
            }
          }
          localObject2 = this.FSh;
          if (localObject2 != null) {
            ((ViewGroup)localObject2).setVisibility(8);
          }
          fbw().getPagerViewContainer().addView((View)this.FSh);
          label748:
          localObject2 = fbz().getLayoutParams();
          if (!(localObject2 instanceof FrameLayout.LayoutParams)) {
            break label1207;
          }
        }
        for (localObject2 = (FrameLayout.LayoutParams)localObject2;; localObject2 = null)
        {
          if (localObject2 != null) {
            ((FrameLayout.LayoutParams)localObject2).topMargin = ((int)getContext().getResources().getDimension(e.c.Edge_7_5_A));
          }
          fbz().setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject2 = this.FSg.getValue();
          s.s(localObject2, "<get-touchableLayout>(...)");
          ((HardTouchableLayout)localObject2).setOnSingleClickListener((HardTouchableLayout.g)new g(this));
          fbx().setOnClickListener(new FinderMediaPreviewUI..ExternalSyntheticLambda3(this));
          fbx().setVisibility(0);
          localObject3 = getIntent().getByteArrayExtra("ref_feed_info");
          if (localObject3 != null)
          {
            localObject2 = new brq();
            ((brq)localObject2).parseFrom((byte[])localObject3);
            localObject3 = ah.aiuX;
            this.FSj = ((brq)localObject2);
          }
          l.a(this.AJn, (AppCompatActivity)this, null, 6);
          localObject2 = fbw();
          localObject3 = new FinderMediaBannerAdapter(this.AJn);
          ((FinderMediaBannerAdapter)localObject3).isLongVideo = this.FSl;
          ((FinderMediaBannerAdapter)localObject3).setItems((List)this.mediaList);
          localObject4 = ah.aiuX;
          ((FinderMediaBanner)localObject2).setAdapter((RecyclerView.a)localObject3);
          fbw().setRefFeedInfo(this.FSj);
          fbw().setPageChangeCallback((MediaBanner.c)new h(this));
          if (getIntent().getBooleanExtra("KEY_SHOW_SEEK_BAR", false))
          {
            this.FSm = new com.tencent.mm.plugin.finder.event.base.c("Finder.MediaPreviewUI");
            this.AJn.Gqa = new com.tencent.mm.plugin.finder.event.c(this.FSm);
            localObject2 = this.FSm;
            s.checkNotNull(localObject2);
            ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)new e(this));
            fbA().setVisibility(0);
            fbA().setPlayBtnOnClickListener(new FinderMediaPreviewUI..ExternalSyntheticLambda2(this));
            fbA().setVideoTotalTime(((dji)this.mediaList.getFirst()).videoDuration);
            fbA().setIsPlay(true);
            fbA().setIplaySeekCallback((com.tencent.mm.plugin.sight.decode.ui.b)new f(this));
          }
          this.FSc = ((FinderImgFeedMusicTag)findViewById(e.e.image_music_tag));
          AppMethodBeat.o(167426);
          return;
          localObject2 = (ImageView)((ViewGroup)localObject2).findViewById(e.e.post_avatar);
          break;
          localObject3 = (TextView)((ViewGroup)localObject3).findViewById(e.e.post_nickname);
          break label569;
        }
      }
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(167429);
    if (!fbC()) {
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
    aw.c(getWindow(), false);
    this.FSl = getIntent().getBooleanExtra("long_video_preview", false);
    initView();
    if (!this.pIz)
    {
      this.pIz = true;
      Log.i("Finder.MediaPreviewUI", "runEnterAnimation");
      paramBundle = getIntent().getParcelableExtra("crop_info");
      if (!(paramBundle instanceof ViewAnimHelper.ViewInfo)) {
        break label147;
      }
    }
    label147:
    for (paramBundle = (ViewAnimHelper.ViewInfo)paramBundle;; paramBundle = null)
    {
      if (paramBundle != null) {
        fbz().a(fby(), getWindow().getDecorView(), paramBundle, (Animator.AnimatorListener)new j(this));
      }
      AppMethodBeat.o(167425);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(347510);
    Object localObject = this.FSm;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject).onRelease();
    }
    super.onDestroy();
    if (this.musicInfo != null)
    {
      localObject = this.FSc;
      if (localObject != null) {
        ((FinderImgFeedMusicTag)localObject).eDT();
      }
    }
    AppMethodBeat.o(347510);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(347504);
    super.onPause();
    if (this.musicInfo != null)
    {
      FinderImgFeedMusicTag localFinderImgFeedMusicTag = this.FSc;
      if (localFinderImgFeedMusicTag != null) {
        localFinderImgFeedMusicTag.bLg();
      }
    }
    AppMethodBeat.o(347504);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(347500);
    super.onResume();
    if (this.musicInfo != null)
    {
      FinderImgFeedMusicTag localFinderImgFeedMusicTag = this.FSc;
      if (localFinderImgFeedMusicTag != null) {
        localFinderImgFeedMusicTag.eDU();
      }
    }
    AppMethodBeat.o(347500);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(167427);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.FSk))
    {
      this.FSk = false;
      TI(0);
    }
    AppMethodBeat.o(167427);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/AnimationLayout;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<AnimationLayout>
  {
    b(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<View>
  {
    c(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<View>
  {
    d(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initSeekBar$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends com.tencent.mm.plugin.finder.event.base.d
  {
    e(FinderMediaPreviewUI paramFinderMediaPreviewUI) {}
    
    private static final void a(c.a parama, FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      AppMethodBeat.i(346423);
      s.u(parama, "$event");
      s.u(paramFinderMediaPreviewUI, "this$0");
      switch (parama.type)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(346423);
        return;
        FinderMediaPreviewUI.e(paramFinderMediaPreviewUI).Bh(0);
        AppMethodBeat.o(346423);
        return;
        FinderMediaPreviewUI.e(paramFinderMediaPreviewUI).setVideoTotalTime(parama.total);
        FinderMediaPreviewUI.e(paramFinderMediaPreviewUI).Bh(parama.offset);
      }
    }
    
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(346432);
      s.u(paramb, "ev");
      if ((paramb instanceof c.a)) {}
      for (paramb = (c.a)paramb; paramb == null; paramb = null)
      {
        AppMethodBeat.o(346432);
        return;
      }
      FinderMediaPreviewUI.e(this.FSn).post(new FinderMediaPreviewUI.e..ExternalSyntheticLambda0(paramb, this.FSn));
      AppMethodBeat.o(346432);
    }
    
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(346438);
      s.u(paramc, "dispatcher");
      s.u(paramb, "event");
      boolean bool = paramb instanceof c.a;
      AppMethodBeat.o(346438);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initSeekBar$3", "Lcom/tencent/mm/plugin/sight/decode/ui/IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "onSeeking", "currentTime", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements com.tencent.mm.plugin.sight.decode.ui.b
  {
    f(FinderMediaPreviewUI paramFinderMediaPreviewUI) {}
    
    public final void blc()
    {
      AppMethodBeat.i(346435);
      FinderMediaPreviewUI.f(this.FSn);
      FinderMediaPreviewUI.e(this.FSn).setIsPlay(false);
      AppMethodBeat.o(346435);
    }
    
    public final void tS(int paramInt)
    {
      AppMethodBeat.i(346426);
      FinderMediaPreviewUI.c(this.FSn, paramInt);
      FinderMediaPreviewUI.e(this.FSn).setIsPlay(true);
      AppMethodBeat.o(346426);
    }
    
    public final void tT(int paramInt) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initView$4", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements HardTouchableLayout.g
  {
    g(FinderMediaPreviewUI paramFinderMediaPreviewUI) {}
    
    public final void fu(View paramView)
    {
      AppMethodBeat.i(346558);
      s.u(paramView, "view");
      if (((dji)this.FSn.mediaList.get(FinderMediaPreviewUI.b(this.FSn))).mediaType == 6)
      {
        FinderMediaPreviewUI.c(this.FSn);
        FinderMediaPreviewUI.c(this.FSn);
        AppMethodBeat.o(346558);
        return;
      }
      FinderMediaPreviewUI.d(this.FSn);
      AppMethodBeat.o(346558);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initView$8", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements MediaBanner.c
  {
    h(FinderMediaPreviewUI paramFinderMediaPreviewUI) {}
    
    public final void g(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(346567);
      FinderMediaPreviewUI.a(this.FSn, paramInt);
      if (!paramBoolean1)
      {
        AppMethodBeat.o(346567);
        return;
      }
      FinderMediaPreviewUI.b(this.FSn, paramInt);
      AppMethodBeat.o(346567);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<FinderMediaBanner>
  {
    i(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$runEnterAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements Animator.AnimatorListener
  {
    j(FinderMediaPreviewUI paramFinderMediaPreviewUI) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(167411);
      FinderMediaPreviewUI.g(this.FSn);
      FinderMediaPreviewUI.h(this.FSn).MlJ.setEmpty();
      FinderMediaPreviewUI.h(this.FSn).invalidate();
      AppMethodBeat.o(167411);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(167412);
      FinderMediaPreviewUI.i(this.FSn).setVisibility(0);
      AppMethodBeat.o(167412);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$runExitAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements Animator.AnimatorListener
  {
    k(FinderMediaPreviewUI paramFinderMediaPreviewUI) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(167415);
      s.u(paramAnimator, "animation");
      AppMethodBeat.o(167415);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(167414);
      s.u(paramAnimator, "animation");
      this.FSn.finish();
      paramAnimator = this.FSn;
      int i = e.a.anim_not_change;
      paramAnimator.overridePendingTransition(i, i);
      AppMethodBeat.o(167414);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(167416);
      s.u(paramAnimator, "animation");
      AppMethodBeat.o(167416);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(167413);
      s.u(paramAnimator, "animation");
      paramAnimator = FinderMediaPreviewUI.j(this.FSn);
      if (paramAnimator != null) {
        paramAnimator.setVisibility(8);
      }
      FinderMediaPreviewUI.k(this.FSn).setVisibility(8);
      AppMethodBeat.o(167413);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<FinderLongVideoPlayerSeekBar>
  {
    l(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/HardTouchableLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.a<HardTouchableLayout>
  {
    m(FinderMediaPreviewUI paramFinderMediaPreviewUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaPreviewUI
 * JD-Core Version:    0.7.0.1
 */