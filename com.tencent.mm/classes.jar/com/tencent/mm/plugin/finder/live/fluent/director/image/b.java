package com.tencent.mm.plugin.finder.live.fluent.director.image;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.view.LiveVideoView;
import com.tencent.mm.plugin.finder.live.fluent.h;
import com.tencent.mm.plugin.finder.live.fluent.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.w.a.a.a.d;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fluent/director/image/SwitchOutImageDirector;", "Lcom/tencent/mm/plugin/finder/live/fluent/director/base/BaseSwitchOutDirector;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isAnimationEnd", "", "isStartedLivePlay", "livePlayer", "Lcom/tencent/mm/live/core/core/player/ILivePlayer;", "getLivePlayer", "()Lcom/tencent/mm/live/core/core/player/ILivePlayer;", "setLivePlayer", "(Lcom/tencent/mm/live/core/core/player/ILivePlayer;)V", "addMaskView", "", "calculateSourceRect", "Landroid/graphics/Rect;", "calculateTargetRect", "changeResolution", "params", "Landroid/os/Bundle;", "detachMaskView", "detachTransitionContainerView", "getFloatViewBackgroundColor", "", "getTag", "", "getTransitionParams", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchImageParams;", "handleSwitchInLiveRoomCallback", "invokeSource", "onFirstFrameRenderCallback", "Lkotlin/Function0;", "preloadStartLivePlayer", "liveUrl", "stopSwitchOut", "switchInLiveRoom", "renderView", "Lcom/tencent/mm/live/core/view/LiveVideoView;", "switchOut", "onAnimationEndCallback", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.finder.live.fluent.director.base.c
{
  public com.tencent.mm.live.core.core.c.b CCB;
  private boolean CDa;
  private boolean CDb;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(352174);
    AppMethodBeat.o(352174);
  }
  
  private final void p(String paramString, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(352180);
    if (!this.CDa)
    {
      Log.w(this.TAG, paramString + " handleSwitchInLiveRoomCallback return for isStartedLivePlay:" + this.CDa);
      AppMethodBeat.o(352180);
      return;
    }
    if (!this.CDb)
    {
      Log.w(this.TAG, paramString + " handleSwitchInLiveRoomCallback return for isStartedLivePlay:" + this.CDa);
      AppMethodBeat.o(352180);
      return;
    }
    Log.i(this.TAG, s.X(paramString, " handleSwitchInLiveRoomCallback"));
    parama.invoke();
    ejD();
    AppMethodBeat.o(352180);
  }
  
  public final void a(LiveVideoView paramLiveVideoView, final kotlin.g.a.a<ah> parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(352291);
    s.u(paramLiveVideoView, "renderView");
    s.u(parama, "onFirstFrameRenderCallback");
    String str = this.TAG;
    Object localObject1 = ejz();
    label80:
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i(str, s.X("switchInLiveRoom isRunning:", localObject1));
      localObject1 = i.CCI;
      i.ejv().aDn("switchInLiveRoom before");
      localObject1 = this.CCB;
      if (localObject1 != null) {
        break label210;
      }
      localObject1 = localObject2;
      if (localObject1 == null)
      {
        this.CDa = true;
        Log.i(this.TAG, s.X("isStartedLivePlay:", Boolean.valueOf(this.CDa)));
      }
      localObject1 = this.CCB;
      if (localObject1 != null) {
        ((com.tencent.mm.live.core.core.c.b)localObject1).setPlayerView((TXCloudVideoView)paramLiveVideoView);
      }
      paramLiveVideoView = ejz();
      if ((paramLiveVideoView == null) || (paramLiveVideoView.isRunning() != true)) {
        break label237;
      }
      i = 1;
      label150:
      if (i == 0) {
        break label242;
      }
      paramLiveVideoView = ejz();
      if (paramLiveVideoView != null) {
        paramLiveVideoView.addListener((Animator.AnimatorListener)new c(this, parama));
      }
    }
    for (;;)
    {
      paramLiveVideoView = i.CCI;
      i.ejv().gG("switchInLiveRoom after");
      AppMethodBeat.o(352291);
      return;
      localObject1 = Boolean.valueOf(((AnimatorSet)localObject1).isRunning());
      break;
      label210:
      ((com.tencent.mm.live.core.core.c.b)localObject1).setPlayListener((ITXLivePlayListener)new b(this, parama));
      localObject1 = ah.aiuX;
      break label80;
      label237:
      i = 0;
      break label150;
      label242:
      Log.i(this.TAG, "switchInLiveRoom switch view success.");
      this.CDb = true;
      p("onAnimationEnd2", parama);
    }
  }
  
  public final void aX(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(352276);
    s.u(parama, "onAnimationEndCallback");
    Log.i(this.TAG, "start");
    super.aX(parama);
    this.CDb = false;
    parama = ((com.tencent.mm.plugin.finder.live.fluent.c)ejN()).CCl;
    if (TextUtils.isEmpty((CharSequence)parama))
    {
      Log.w(this.TAG, s.X("preloadStartLivePlayer return for liveUrl:", parama));
      AppMethodBeat.o(352276);
      return;
    }
    Log.i(this.TAG, s.X("preloadStartLivePlayer liveUrl:", parama));
    this.CDa = false;
    Object localObject = new TXLivePlayConfig();
    ((TXLivePlayConfig)localObject).setAutoAdjustCacheTime(true);
    ((TXLivePlayConfig)localObject).setMinAutoAdjustCacheTime(1.0F);
    ((TXLivePlayConfig)localObject).setMaxAutoAdjustCacheTime(1.0F);
    ((TXLivePlayConfig)localObject).setEnableMessage(true);
    if (this.CCB == null) {
      this.CCB = ((com.tencent.mm.live.core.core.c.b)new com.tencent.mm.live.core.core.c.a(getContext()));
    }
    com.tencent.mm.live.core.core.c.b localb = this.CCB;
    if (localb != null) {
      localb.enableHardwareDecode(true);
    }
    localb = this.CCB;
    if (localb != null) {
      localb.setConfig((TXLivePlayConfig)localObject);
    }
    localObject = this.CCB;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.c.b)localObject).setRenderMode(0);
    }
    localObject = this.CCB;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.c.b)localObject).setPlayListener((ITXLivePlayListener)new a(this));
    }
    localObject = this.CCB;
    if (localObject != null)
    {
      s.checkNotNull(parama);
      ((com.tencent.mm.live.core.core.c.b)localObject).Y(parama, 1);
    }
    AppMethodBeat.o(352276);
  }
  
  public final void ejD()
  {
    AppMethodBeat.i(352259);
    super.ejD();
    Object localObject = getTargetView();
    s.checkNotNull(localObject);
    View localView1 = ((View)localObject).getRootView();
    View localView2 = localView1.findViewWithTag(this.TAG);
    if (localView2 != null) {
      localView2.setOnTouchListener(null);
    }
    Log.i(this.TAG, s.X("detachFloatView view:", localView2));
    View localView3 = ((com.tencent.mm.plugin.finder.live.fluent.c)ejN()).CCk;
    Log.i(this.TAG, s.X("detachMaskView maskView:", localView3));
    localObject = localView3.getParent();
    if ((localObject instanceof ViewGroup)) {}
    for (localObject = (ViewGroup)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((ViewGroup)localObject).removeView(localView3);
      }
      localObject = ((com.tencent.mm.plugin.finder.live.fluent.c)ejN()).uJh;
      if (localObject != null) {
        break;
      }
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(352259);
      throw ((Throwable)localObject);
    }
    ((ViewGroup)localObject).addView(localView3);
    if (localView1 == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(352259);
      throw ((Throwable)localObject);
    }
    ((ViewGroup)localView1).removeView(localView2);
    AppMethodBeat.o(352259);
  }
  
  public final Rect ejE()
  {
    AppMethodBeat.i(352249);
    Object localObject = com.tencent.mm.plugin.finder.live.fluent.util.a.CDq;
    int m = com.tencent.mm.plugin.finder.live.fluent.util.a.ejw();
    localObject = com.tencent.mm.plugin.finder.live.fluent.util.a.CDq;
    int k = com.tencent.mm.plugin.finder.live.fluent.util.a.ejx();
    localObject = com.tencent.mm.plugin.finder.live.fluent.util.a.CDq;
    float f = com.tencent.mm.plugin.finder.live.fluent.util.a.e(ejN());
    int i = (int)(ejN().videoWidth * f);
    int j = (int)(f * ejN().videoHeight);
    m = (m - i) / 2;
    k = (k - j) / 2;
    localObject = new Rect(m, k, i + m, j + k);
    AppMethodBeat.o(352249);
    return localObject;
  }
  
  public final Rect ejF()
  {
    AppMethodBeat.i(352266);
    Object localObject1 = new int[2];
    Object localObject2 = com.tencent.mm.plugin.finder.live.fluent.util.a.CDq;
    localObject2 = getTargetView();
    s.checkNotNull(localObject2);
    com.tencent.mm.plugin.finder.live.fluent.util.a.a((View)localObject2, (int[])localObject1);
    localObject2 = getTargetView();
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(352266);
      throw ((Throwable)localObject1);
    }
    localObject2 = (ViewGroup)localObject2;
    com.tencent.mm.plugin.finder.live.fluent.c localc = (com.tencent.mm.plugin.finder.live.fluent.c)ejN();
    int i = localObject1[0];
    int j = localObject1[1];
    int k = localObject1[0];
    int m = ((ViewGroup)localObject2).getWidth();
    int n = localObject1[1];
    localc.w(new Rect(i, j, k + m, ((ViewGroup)localObject2).getHeight() + n));
    localObject1 = ((com.tencent.mm.plugin.finder.live.fluent.c)ejN()).CCC;
    AppMethodBeat.o(352266);
    return localObject1;
  }
  
  public final void ejP()
  {
    AppMethodBeat.i(352236);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(ejH().width(), ejH().height());
    localLayoutParams.gravity = 17;
    View localView = ((com.tencent.mm.plugin.finder.live.fluent.c)ejN()).CCk;
    Object localObject = localView.getParent();
    if ((localObject instanceof ViewGroup)) {}
    for (localObject = (ViewGroup)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((ViewGroup)localObject).removeView(localView);
      }
      localObject = ejO();
      if (localObject != null) {
        ((RoundedCornerFrameLayout)localObject).addView(localView, (ViewGroup.LayoutParams)localLayoutParams);
      }
      AppMethodBeat.o(352236);
      return;
    }
  }
  
  public final int ejQ()
  {
    return a.d.trans_drawable;
  }
  
  public final void ejn()
  {
    AppMethodBeat.i(352304);
    AnimatorSet localAnimatorSet = ejz();
    if (localAnimatorSet != null) {
      localAnimatorSet.pause();
    }
    ejD();
    AppMethodBeat.o(352304);
  }
  
  public final String getTag()
  {
    return "SwitchOutImageDirector";
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/fluent/director/image/SwitchOutImageDirector$preloadStartLivePlayer$1", "Lcom/tencent/rtmp/ITXLivePlayListener;", "onNetStatus", "", "p0", "Landroid/os/Bundle;", "onPlayEvent", "event", "", "params", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ITXLivePlayListener
  {
    a(b paramb) {}
    
    public final void onNetStatus(Bundle paramBundle) {}
    
    public final void onPlayEvent(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(352164);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(352164);
        return;
        Log.i(this.CDc.TAG, "preloadStartLivePlayer onPlayEvent EVT_PLAY_VIEW_CHANGED_FIRST_I_FRAME");
        b.a(this.CDc);
        AppMethodBeat.o(352164);
        return;
        Log.i(this.CDc.TAG, "preloadStartLivePlayer onPlayEvent PLAY_EVT_CHANGE_RESOLUTION");
        b.a(this.CDc, paramBundle);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/fluent/director/image/SwitchOutImageDirector$switchInLiveRoom$1", "Lcom/tencent/rtmp/ITXLivePlayListener;", "onNetStatus", "", "p0", "Landroid/os/Bundle;", "onPlayEvent", "event", "", "params", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements ITXLivePlayListener
  {
    b(b paramb, kotlin.g.a.a<ah> parama) {}
    
    public final void onNetStatus(Bundle paramBundle) {}
    
    public final void onPlayEvent(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(352167);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(352167);
        return;
        Log.i(this.CDc.TAG, "switchInLiveRoom onPlayEvent EVT_PLAY_VIEW_CHANGED_FIRST_I_FRAME");
        b.a(this.CDc);
        b.a(this.CDc, "onPlayEvent", parama);
        AppMethodBeat.o(352167);
        return;
        Log.i(this.CDc.TAG, "preloadStartLivePlayer onPlayEvent PLAY_EVT_CHANGE_RESOLUTION");
        b.a(this.CDc, paramBundle);
        b.a(this.CDc, "onPlayEvent", parama);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/fluent/director/image/SwitchOutImageDirector$switchInLiveRoom$3", "Lcom/tencent/mm/plugin/finder/live/fluent/animate/DefaultAnimatorListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends com.tencent.mm.plugin.finder.live.fluent.animate.a
  {
    c(b paramb, kotlin.g.a.a<ah> parama) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(352166);
      Log.i(this.CDc.TAG, "switchInLiveRoom switch view success.");
      b.b(this.CDc);
      b.a(this.CDc, "onAnimationEnd1", parama);
      AppMethodBeat.o(352166);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fluent.director.image.b
 * JD-Core Version:    0.7.0.1
 */