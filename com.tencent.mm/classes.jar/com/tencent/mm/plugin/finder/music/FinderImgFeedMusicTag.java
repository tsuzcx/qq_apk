package com.tencent.mm.plugin.finder.music;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.finder.viewmodel.component.be;
import com.tencent.mm.plugin.findersdk.receiver.HeadsetReceiver.b;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.MediaBanner;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "frameAnim", "Landroid/graphics/drawable/AnimationDrawable;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isMusicFocused", "", "()Z", "setMusicFocused", "(Z)V", "isMusicPauseManually", "setMusicPauseManually", "musicIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getMusicIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setMusicIcon", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "onHeadsetStateChangeListener", "Lcom/tencent/mm/plugin/findersdk/receiver/HeadsetReceiver$OnHeadsetStateChangeListener;", "onHeadsetStateChangePauseMusicTag", "Lkotlin/Function0;", "", "getOnHeadsetStateChangePauseMusicTag", "()Lkotlin/jvm/functions/Function0;", "setOnHeadsetStateChangePauseMusicTag", "(Lkotlin/jvm/functions/Function0;)V", "player", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;", "getPlayer", "()Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;", "setPlayer", "(Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;)V", "rotate", "Landroid/animation/ObjectAnimator;", "getRotate", "()Landroid/animation/ObjectAnimator;", "setRotate", "(Landroid/animation/ObjectAnimator;)V", "shouldImgLoop", "getShouldImgLoop", "setShouldImgLoop", "shouldMusicResume", "getShouldMusicResume", "setShouldMusicResume", "viewEnable", "getViewEnable", "setViewEnable", "value", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "viewPager", "getViewPager", "()Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "setViewPager", "(Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;)V", "bindMusicInfo", "initView", "isPlaying", "onAttachedToWindow", "onDetachedFromWindow", "onViewClick", "onViewRecycled", "pauseImgLoop", "pauseMusic", "pauseMusicAuto", "playMusic", "startLoopImg", "stopImgLoop", "unbindMusicInfo", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderImgFeedMusicTag
  extends FrameLayout
{
  public static final FinderImgFeedMusicTag.a EEL;
  a EEM;
  public boolean EEN;
  boolean EEO;
  boolean EEP;
  private ObjectAnimator EEQ;
  private boolean EER;
  private WeImageView EES;
  private boolean EET;
  private FinderMediaBanner EEU;
  private kotlin.g.a.a<ah> EEV;
  private HeadsetReceiver.b EEW;
  private final MMHandler handler;
  bqj musicInfo;
  
  static
  {
    AppMethodBeat.i(330958);
    EEL = new FinderImgFeedMusicTag.a((byte)0);
    AppMethodBeat.o(330958);
  }
  
  public FinderImgFeedMusicTag(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(330889);
    this.EET = true;
    this.EEV = ((kotlin.g.a.a)FinderImgFeedMusicTag.d.EEY);
    this.EEW = ((HeadsetReceiver.b)new FinderImgFeedMusicTag.c(this));
    this.handler = new MMHandler("FinderImgFeedMusicTag", new FinderImgFeedMusicTag..ExternalSyntheticLambda0(this));
    ci(paramContext);
    AppMethodBeat.o(330889);
  }
  
  public FinderImgFeedMusicTag(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(330897);
    this.EET = true;
    this.EEV = ((kotlin.g.a.a)FinderImgFeedMusicTag.d.EEY);
    this.EEW = ((HeadsetReceiver.b)new FinderImgFeedMusicTag.c(this));
    this.handler = new MMHandler("FinderImgFeedMusicTag", new FinderImgFeedMusicTag..ExternalSyntheticLambda0(this));
    ci(paramContext);
    AppMethodBeat.o(330897);
  }
  
  private static final void a(FinderImgFeedMusicTag paramFinderImgFeedMusicTag, Context paramContext)
  {
    AppMethodBeat.i(330919);
    s.u(paramFinderImgFeedMusicTag, "this$0");
    s.u(paramContext, "$context");
    as localas = new as((View)paramFinderImgFeedMusicTag);
    int i = com.tencent.mm.cd.a.bs(paramContext, e.c.Edge_A);
    paramContext = new Rect();
    paramFinderImgFeedMusicTag.getHitRect(paramContext);
    paramContext.inset(-i, -i);
    localas.a(new at(paramContext, (View)paramFinderImgFeedMusicTag));
    AppMethodBeat.o(330919);
  }
  
  private static final void a(bqj parambqj1, FinderImgFeedMusicTag paramFinderImgFeedMusicTag, bqj parambqj2)
  {
    AppMethodBeat.i(330937);
    Log.i("FinderImgFeedMusicTag", "[bindMusicInfo] musicInfo:" + parambqj1.name + ",viewID:" + paramFinderImgFeedMusicTag);
    paramFinderImgFeedMusicTag.musicInfo = parambqj1;
    if (paramFinderImgFeedMusicTag.EEM != null)
    {
      parambqj1 = paramFinderImgFeedMusicTag.EEM;
      if (parambqj1 != null) {
        break label193;
      }
    }
    label193:
    for (parambqj1 = null;; parambqj1 = Boolean.valueOf(parambqj1.isPlaying()))
    {
      Log.i("FinderImgFeedMusicTag", s.X("[bindMusicInfo] this.player is not null and isPlaying = ", parambqj1));
      parambqj1 = paramFinderImgFeedMusicTag.EEM;
      if (parambqj1 != null) {
        parambqj1.release();
      }
      parambqj1 = k.aeZF;
      parambqj1 = paramFinderImgFeedMusicTag.getContext();
      s.s(parambqj1, "context");
      ((b)k.nq(parambqj1).q(b.class)).b(paramFinderImgFeedMusicTag);
      parambqj1 = paramFinderImgFeedMusicTag.getContext();
      s.s(parambqj1, "context");
      paramFinderImgFeedMusicTag.EEM = new a(parambqj1, parambqj2);
      parambqj1 = k.aeZF;
      parambqj1 = paramFinderImgFeedMusicTag.getContext();
      s.s(parambqj1, "context");
      parambqj1 = (b)k.nq(parambqj1).q(b.class);
      parambqj2 = paramFinderImgFeedMusicTag.EEM;
      s.checkNotNull(parambqj2);
      parambqj1.a(paramFinderImgFeedMusicTag, parambqj2);
      AppMethodBeat.o(330937);
      return;
    }
  }
  
  private static final boolean a(FinderImgFeedMusicTag paramFinderImgFeedMusicTag, Message paramMessage)
  {
    AppMethodBeat.i(330926);
    s.u(paramFinderImgFeedMusicTag, "this$0");
    s.u(paramMessage, "it");
    if (paramMessage.what == 1) {
      d.uiThread((kotlin.g.a.a)new b(paramFinderImgFeedMusicTag));
    }
    AppMethodBeat.o(330926);
    return true;
  }
  
  private final void ci(Context paramContext)
  {
    AppMethodBeat.i(330904);
    Object localObject = af.mU(paramContext).inflate(e.f.finder_bgm_icon_iv, null);
    if (localObject == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
      AppMethodBeat.o(330904);
      throw paramContext;
    }
    this.EES = ((WeImageView)localObject);
    addView((View)this.EES);
    localObject = this.EES;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((WeImageView)localObject).getLayoutParams())
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(330904);
      throw paramContext;
    }
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    localObject = this.EES;
    if (localObject != null) {
      ((WeImageView)localObject).setImageDrawable(bb.m(paramContext, e.g.finder_bgm_gif_first_page, com.tencent.mm.cd.a.w(paramContext, e.b.FG_2)));
    }
    post(new FinderImgFeedMusicTag..ExternalSyntheticLambda1(this, paramContext));
    AppMethodBeat.o(330904);
  }
  
  private final void eDR()
  {
    AppMethodBeat.i(330911);
    if (this.EER)
    {
      this.handler.removeMessages(1);
      this.handler.sendEmptyMessageDelayed(1, 3000L);
    }
    AppMethodBeat.o(330911);
  }
  
  public final void a(bqj parambqj)
  {
    int i = 1;
    AppMethodBeat.i(331091);
    if (parambqj != null)
    {
      if (getMusicInfo() == null)
      {
        a(parambqj, this, parambqj);
        AppMethodBeat.o(331091);
        return;
      }
      Object localObject = getMusicInfo();
      s.checkNotNull(localObject);
      if (s.p(((bqj)localObject).HsD, parambqj.HsD))
      {
        localObject = getPlayer();
        if ((localObject != null) && (((a)localObject).isPlaying() == true))
        {
          if (i == 0) {
            break label119;
          }
          parambqj = getMusicInfo();
          if (parambqj != null) {
            break label111;
          }
        }
        label111:
        for (parambqj = null;; parambqj = parambqj.name)
        {
          Log.i("FinderImgFeedMusicTag", s.X("[bindMusicInfo] already bind and playing,musicName = ", parambqj));
          AppMethodBeat.o(331091);
          return;
          i = 0;
          break;
        }
      }
      label119:
      eDT();
      a(parambqj, this, parambqj);
    }
    AppMethodBeat.o(331091);
  }
  
  public final void bLg()
  {
    AppMethodBeat.i(331116);
    if ((this.musicInfo == null) || (this.EEM == null))
    {
      AppMethodBeat.o(331116);
      return;
    }
    a locala = this.EEM;
    if (locala != null) {
      locala.pause();
    }
    eDS();
    AppMethodBeat.o(331116);
  }
  
  final void eDS()
  {
    AppMethodBeat.i(331084);
    if (this.EER) {
      this.handler.removeMessages(1);
    }
    AppMethodBeat.o(331084);
  }
  
  public final void eDT()
  {
    AppMethodBeat.i(331098);
    this.handler.removeMessages(1);
    Object localObject = this.EEQ;
    if (localObject != null) {
      ((ObjectAnimator)localObject).cancel();
    }
    clearAnimation();
    this.EEN = false;
    this.EEO = false;
    this.EEP = false;
    localObject = this.EEM;
    if (localObject != null) {
      ((a)localObject).release();
    }
    this.musicInfo = null;
    localObject = k.aeZF;
    localObject = getContext();
    s.s(localObject, "context");
    ((b)k.nq((Context)localObject).q(b.class)).b(this);
    AppMethodBeat.o(331098);
  }
  
  public final void eDU()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int i = 1;
    AppMethodBeat.i(331109);
    Object localObject3;
    if ((this.musicInfo == null) || (this.EEM == null))
    {
      localObject3 = new StringBuilder("[playMusic] musicInfo = ");
      localObject1 = this.musicInfo;
      if (localObject1 == null) {}
      for (localObject1 = localObject2;; localObject1 = ((bqj)localObject1).name)
      {
        Log.i("FinderImgFeedMusicTag", localObject1 + ",player = " + this.EEM + ",viewID:" + this);
        AppMethodBeat.o(331109);
        return;
      }
    }
    this.EEN = true;
    this.EEO = true;
    localObject2 = this.EEM;
    if ((localObject2 != null) && (((a)localObject2).isPlaying() == true)) {}
    while (i != 0)
    {
      Log.i("FinderImgFeedMusicTag", "music playing");
      AppMethodBeat.o(331109);
      return;
      i = 0;
    }
    if (this.EEP)
    {
      Log.i("FinderImgFeedMusicTag", "music pause Manually, dont play");
      AppMethodBeat.o(331109);
      return;
    }
    if (this.musicInfo != null)
    {
      localObject2 = new StringBuilder("[playMusic] play success musicInfo:");
      localObject3 = getMusicInfo();
      if (localObject3 != null) {
        break label250;
      }
    }
    for (;;)
    {
      Log.i("FinderImgFeedMusicTag", localObject1 + ",viewID:" + this);
      localObject1 = getPlayer();
      if (localObject1 != null) {
        ((a)localObject1).play();
      }
      eDR();
      AppMethodBeat.o(331109);
      return;
      label250:
      localObject1 = ((bqj)localObject3).name;
    }
  }
  
  public final WeImageView getMusicIcon()
  {
    return this.EES;
  }
  
  public final bqj getMusicInfo()
  {
    return this.musicInfo;
  }
  
  public final kotlin.g.a.a<ah> getOnHeadsetStateChangePauseMusicTag()
  {
    return this.EEV;
  }
  
  public final a getPlayer()
  {
    return this.EEM;
  }
  
  public final ObjectAnimator getRotate()
  {
    return this.EEQ;
  }
  
  public final boolean getShouldImgLoop()
  {
    return this.EER;
  }
  
  public final boolean getShouldMusicResume()
  {
    return this.EEO;
  }
  
  public final boolean getViewEnable()
  {
    return this.EET;
  }
  
  public final FinderMediaBanner getViewPager()
  {
    return this.EEU;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(331102);
    a locala = this.EEM;
    if (locala == null)
    {
      AppMethodBeat.o(331102);
      return false;
    }
    boolean bool = locala.isPlaying();
    AppMethodBeat.o(331102);
    return bool;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(331121);
    super.onAttachedToWindow();
    k localk = k.aeZF;
    ((be)k.cn(PluginFinder.class).q(be.class)).a(this.EEW);
    AppMethodBeat.o(331121);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(331128);
    super.onDetachedFromWindow();
    bLg();
    k localk = k.aeZF;
    ((be)k.cn(PluginFinder.class).q(be.class)).b(this.EEW);
    AppMethodBeat.o(331128);
  }
  
  public final void setMusicFocused(boolean paramBoolean)
  {
    this.EEN = paramBoolean;
  }
  
  public final void setMusicIcon(WeImageView paramWeImageView)
  {
    this.EES = paramWeImageView;
  }
  
  public final void setMusicInfo(bqj parambqj)
  {
    this.musicInfo = parambqj;
  }
  
  public final void setMusicPauseManually(boolean paramBoolean)
  {
    this.EEP = paramBoolean;
  }
  
  public final void setOnHeadsetStateChangePauseMusicTag(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(331078);
    s.u(parama, "<set-?>");
    this.EEV = parama;
    AppMethodBeat.o(331078);
  }
  
  public final void setPlayer(a parama)
  {
    this.EEM = parama;
  }
  
  public final void setRotate(ObjectAnimator paramObjectAnimator)
  {
    this.EEQ = paramObjectAnimator;
  }
  
  public final void setShouldImgLoop(boolean paramBoolean)
  {
    this.EER = paramBoolean;
  }
  
  public final void setShouldMusicResume(boolean paramBoolean)
  {
    this.EEO = paramBoolean;
  }
  
  public final void setViewEnable(boolean paramBoolean)
  {
    this.EET = paramBoolean;
  }
  
  public final void setViewPager(FinderMediaBanner paramFinderMediaBanner)
  {
    boolean bool = true;
    AppMethodBeat.i(331068);
    this.EEU = paramFinderMediaBanner;
    int i;
    if (paramFinderMediaBanner == null)
    {
      i = 0;
      if (i <= 1) {
        break label89;
      }
    }
    for (;;)
    {
      this.EER = bool;
      if (paramFinderMediaBanner != null)
      {
        paramFinderMediaBanner = paramFinderMediaBanner.getPagerView();
        if (paramFinderMediaBanner != null) {
          paramFinderMediaBanner.a((RecyclerView.l)new FinderImgFeedMusicTag.e(this));
        }
      }
      AppMethodBeat.o(331068);
      return;
      RecyclerView.a locala = paramFinderMediaBanner.getAdapter();
      if (locala == null)
      {
        i = 0;
        break;
      }
      i = locala.getItemCount();
      break;
      label89:
      bool = false;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(FinderImgFeedMusicTag paramFinderImgFeedMusicTag)
    {
      super();
    }
    
    private static final void a(FinderMediaBannerAdapter paramFinderMediaBannerAdapter, FinderMediaBanner paramFinderMediaBanner, FinderImgFeedMusicTag paramFinderImgFeedMusicTag)
    {
      AppMethodBeat.i(330780);
      s.u(paramFinderMediaBannerAdapter, "$adapter");
      s.u(paramFinderMediaBanner, "$bannner");
      s.u(paramFinderImgFeedMusicTag, "this$0");
      paramFinderMediaBannerAdapter.removeItem(paramFinderMediaBannerAdapter.getItemCount() - 1);
      try
      {
        paramFinderMediaBannerAdapter.a(paramFinderMediaBanner.getDataObserver());
        MediaBanner.a((MediaBanner)paramFinderMediaBanner, 0);
        FinderImgFeedMusicTag.d(paramFinderImgFeedMusicTag);
        AppMethodBeat.o(330780);
        return;
      }
      catch (IllegalStateException paramFinderMediaBannerAdapter)
      {
        for (;;)
        {
          Log.i("FinderImgFeedMusicTag", s.X("msg:", paramFinderMediaBannerAdapter.getMessage()));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag
 * JD-Core Version:    0.7.0.1
 */