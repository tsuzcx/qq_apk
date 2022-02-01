package com.tencent.mm.plugin.finder.floatball;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.Size;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.a.jj;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.megavideo.ui.FinderMegaVideoMiniView;
import com.tencent.mm.plugin.finder.megavideo.ui.FinderMegaVideoMiniView.a;
import com.tencent.mm.plugin.finder.megavideo.ui.FinderMegaVideoMiniView.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.logic.e;
import com.tencent.mm.plugin.finder.video.FinderCropVideoView;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.t;
import com.tencent.mm.plugin.finder.viewmodel.component.bi;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.component.k.b;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/floatball/BaseFinderMiniViewHelper;", "Lcom/tencent/mm/plugin/ball/service/FloatBallHelper;", "()V", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "getAudioHelperTool", "()Lcom/tencent/mm/model/AudioHelperTool;", "audioHelperTool$delegate", "Lkotlin/Lazy;", "checkVideoState", "com/tencent/mm/plugin/finder/floatball/BaseFinderMiniViewHelper$checkVideoState$1", "Lcom/tencent/mm/plugin/finder/floatball/BaseFinderMiniViewHelper$checkVideoState$1;", "finderSeekEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderSeekEvent;", "isBallHidden", "", "miniView", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoMiniView;", "getMiniView", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoMiniView;", "miniView$delegate", "multiTalkActionListener", "multiTaskCreateListener", "timeWhenRemoveView", "", "voipCallEvent", "Lcom/tencent/mm/autogen/events/VoipEvent;", "addMiniView", "", "bitmap", "Landroid/graphics/Bitmap;", "needPost", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "targetTime", "", "playSpeedRatio", "", "needPause", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "gainAudioFocus", "generateCloseClickListener", "Landroid/view/View$OnClickListener;", "generateWindowClickListener", "hideMiniView", "internalAddMiniView", "lossAudioFocus", "releaseListener", "removeMiniView", "resumeMiniView", "seekSec", "setLiveViewSize", "setPlaySpeed", "ratio", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  extends FloatBallHelper
{
  public static final a.a Btx = new a.a((byte)0);
  private final BaseFinderMiniViewHelper.checkVideoState.1 BtA = new BaseFinderMiniViewHelper.checkVideoState.1(this, com.tencent.mm.app.f.hfK);
  private final IListener<acn> BtB = (IListener)new BaseFinderMiniViewHelper.voipCallEvent.1(this, com.tencent.mm.app.f.hfK);
  private final IListener<?> BtC = (IListener)new BaseFinderMiniViewHelper.multiTaskCreateListener.1(this, com.tencent.mm.app.f.hfK);
  private final IListener<jj> BtD = (IListener)new BaseFinderMiniViewHelper.finderSeekEventListener.1(this, com.tencent.mm.app.f.hfK);
  private boolean Bty;
  private final kotlin.j Btz = kotlin.k.cm((kotlin.g.a.a)a.b.BtE);
  private long mUE;
  private final kotlin.j nnL = kotlin.k.cm((kotlin.g.a.a)a.d.BtG);
  private final IListener<?> nnP = (IListener)new BaseFinderMiniViewHelper.multiTalkActionListener.1(this, com.tencent.mm.app.f.hfK);
  
  private static final void a(a parama)
  {
    s.u(parama, "this$0");
    Log.i("FinderMegaVideoMiniViewHelper", "addMiniView, no ball, ball: %s, view:%s", new Object[] { parama.vjV, parama.egj() });
    parama.vjV.vjH = true;
    parama.vjV.trn = false;
    parama.vjV.state = 2048;
    parama.vjV.dyK = ((View)parama.egj());
    parama.vjV.vjG = true;
    parama.egq();
    parama.BtA.alive();
    parama.BtB.alive();
    parama.nnP.alive();
    parama.BtC.alive();
    parama.BtD.alive();
    parama.cYq();
  }
  
  private static final void a(a parama, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/floatball/BaseFinderMiniViewHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.vjV.vjI.opType = 14;
    parama.ego();
    parama = com.tencent.mm.ui.component.k.aeZF;
    ((bi)com.tencent.mm.ui.component.k.cn(cn.class).cq(bi.class)).fpt();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/floatball/BaseFinderMiniViewHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private static final void a(FinderThumbPlayerProxy paramFinderThumbPlayerProxy, int paramInt)
  {
    s.u(paramFinderThumbPlayerProxy, "$it");
    paramFinderThumbPlayerProxy.b(paramInt, false);
  }
  
  private final d egi()
  {
    return (d)this.Btz.getValue();
  }
  
  private final void egq()
  {
    if (this.vjV.vjC == null) {
      this.vjV.vjC = new Point();
    }
    int i = bd.bs(MMApplicationContext.getContext(), e.c.Edge_A);
    Object localObject = FinderMegaVideoMiniView.EAi;
    localObject = MMApplicationContext.getContext().getResources();
    s.s(localObject, "getContext().resources");
    localObject = FinderMegaVideoMiniView.a.a((Resources)localObject, egj().getShapeType());
    if (egj().getShapeType() == FinderMegaVideoMiniView.c.EAy) {
      i = 0;
    }
    this.vjV.vjC.x = (((Size)localObject).getWidth() + i * 2);
    this.vjV.vjC.y = (((Size)localObject).getHeight() + i * 2);
    Log.i("BaseFinderMiniViewHelper", "setLiveViewSize %s, margin: %d", new Object[] { this.vjV.vjC, Integer.valueOf(i) });
  }
  
  public final void Or(int paramInt)
  {
    if ((!cYo()) || (!this.Bty)) {
      Log.i("BaseFinderMiniViewHelper", s.X("resumeMiniView, do not have ball, or ball is Hidden = ", Boolean.valueOf(this.Bty)));
    }
    FinderThumbPlayerProxy localFinderThumbPlayerProxy;
    do
    {
      return;
      this.Bty = false;
      ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).mq(false);
      com.tencent.mm.plugin.ball.f.f.d(false, true, true);
      localFinderThumbPlayerProxy = egj().getVideoView();
    } while (localFinderThumbPlayerProxy == null);
    localFinderThumbPlayerProxy.setIsShouldPlayResume(false);
    localFinderThumbPlayerProxy.setVideoViewFocused(true);
    if (egj().EAm) {
      egj().setError(false);
    }
    ((t)localFinderThumbPlayerProxy).r(null);
    localFinderThumbPlayerProxy.post(new a..ExternalSyntheticLambda2(localFinderThumbPlayerProxy, paramInt));
  }
  
  public final void b(com.tencent.mm.view.recyclerview.j paramj, boolean paramBoolean)
  {
    s.u(paramj, "holder");
    egj().a(egk(), egl());
    int i = bd.bs(MMApplicationContext.getContext(), com.tencent.mm.live.core.a.b.Edge_A);
    egj().setPadding(i, i, i, i);
    FinderMegaVideoMiniView localFinderMegaVideoMiniView = egj();
    s.u(paramj, "holder");
    Object localObject1 = (FinderVideoLayout)paramj.UH(e.e.finder_banner_video_layout);
    if (localObject1 != null)
    {
      Log.i("FinderMegaVideoMiniView", s.X("addRenderView: proxy=", ((FinderVideoLayout)localObject1).getVideoView()));
      localFinderMegaVideoMiniView.eCO();
      localFinderMegaVideoMiniView.Oi();
      if (!(((FinderVideoLayout)localObject1).getVideoView() instanceof FinderThumbPlayerProxy)) {
        break label193;
      }
      paramj = ((FinderVideoLayout)localObject1).getVideoView();
      if (paramj == null) {
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy");
      }
      paramj = (FinderThumbPlayerProxy)paramj;
      j = paramj.getCurrentPlaySecond() + 1;
      i = j;
      if (j > paramj.getVideoDuration()) {
        i = j - 1;
      }
      FinderMegaVideoMiniView.a(localFinderMegaVideoMiniView, paramj.getVideoMediaInfo(), i, paramj.getPlaySpeedRatio(), 8);
      paramj.fjh();
      paramj.setMute(true);
    }
    label193:
    while (!(((FinderVideoLayout)localObject1).getVideoView() instanceof FinderCropVideoView))
    {
      int j;
      qg(paramBoolean);
      return;
    }
    localObject1 = ((FinderVideoLayout)localObject1).getVideoView();
    if (localObject1 == null) {
      throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.video.FinderCropVideoView");
    }
    localObject1 = (FinderCropVideoView)localObject1;
    i = ((FinderCropVideoView)localObject1).getCurrentPlaySecond() + 1;
    if (i > ((FinderCropVideoView)localObject1).getVideoDuration()) {
      i -= 1;
    }
    for (;;)
    {
      Object localObject2 = (BaseFinderFeed)paramj.CSA;
      paramj = FeedData.Companion;
      s.s(localObject2, "feed");
      paramj = FeedData.a.l((BaseFinderFeed)localObject2);
      e locale = e.FNF;
      long l = ((BaseFinderFeed)localObject2).bZA();
      localObject2 = paramj.getMediaList().get(0);
      s.s(localObject2, "feedData.mediaList[0]");
      localObject2 = locale.b(l, (dji)localObject2);
      FinderMegaVideoMiniView.a(localFinderMegaVideoMiniView, (com.tencent.mm.plugin.finder.video.v)new com.tencent.mm.plugin.finder.video.source.b(((com.tencent.mm.plugin.finder.loader.v)localObject2).getUrl(), ((com.tencent.mm.plugin.finder.loader.v)localObject2).getPath(), ((com.tencent.mm.plugin.finder.loader.v)localObject2).aUt(), ((com.tencent.mm.plugin.finder.loader.v)localObject2).ExE, (x)localObject2, paramj), i, 0.0F, 12);
      ((FinderCropVideoView)localObject1).setMute(true);
      break;
    }
  }
  
  public final FinderMegaVideoMiniView egj()
  {
    return (FinderMegaVideoMiniView)this.nnL.getValue();
  }
  
  public abstract View.OnClickListener egk();
  
  public View.OnClickListener egl()
  {
    return new a..ExternalSyntheticLambda0(this);
  }
  
  public void egm() {}
  
  public void egn() {}
  
  public boolean ego()
  {
    this.Bty = false;
    egi().gR(true);
    if (cYo())
    {
      Log.i("BaseFinderMiniViewHelper", "removeMiniView, has ball, view:%s", new Object[] { egj() });
      this.mUE = Util.nowMilliSecond();
      egj().eCO();
      this.BtA.dead();
      this.BtB.dead();
      this.nnP.dead();
      this.BtC.dead();
      this.BtD.dead();
      cYp();
      return true;
    }
    Log.i("BaseFinderMiniViewHelper", "removeMiniView, no ball, view:%s", new Object[] { egj() });
    return false;
  }
  
  public final void egp()
  {
    if (!cYo())
    {
      Log.i("BaseFinderMiniViewHelper", "hideMiniView, do not have ball");
      return;
    }
    this.Bty = true;
    FinderThumbPlayerProxy localFinderThumbPlayerProxy = egj().getVideoView();
    if (localFinderThumbPlayerProxy != null)
    {
      localFinderThumbPlayerProxy.setIsShouldPlayResume(false);
      localFinderThumbPlayerProxy.setVideoViewFocused(false);
      localFinderThumbPlayerProxy.eLK();
    }
    ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).mq(true);
    com.tencent.mm.plugin.ball.f.f.d(true, false, true);
  }
  
  protected final void qg(boolean paramBoolean)
  {
    long l1 = 200L;
    if (cYo())
    {
      Log.i("FinderMegaVideoMiniViewHelper", "addMiniView, has ball, but view is different, ballInfo.customView:%s", new Object[] { this.vjV.dyK });
      this.vjV.vjH = true;
      this.vjV.state = 2048;
      this.vjV.dyK = ((View)egj());
      this.vjV.trn = false;
      this.vjV.vjG = true;
      egq();
      cYr();
    }
    a..ExternalSyntheticLambda1 localExternalSyntheticLambda1;
    long l2;
    for (;;)
    {
      ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).mq(false);
      com.tencent.mm.plugin.ball.f.f.d(false, true, true);
      return;
      localExternalSyntheticLambda1 = new a..ExternalSyntheticLambda1(this);
      l2 = this.mUE + 200L - Util.nowMilliSecond();
      if ((l2 > 0L) || (paramBoolean)) {
        break;
      }
      localExternalSyntheticLambda1.run();
      egi().gR(true);
      egi().a((d.a)new c(this));
    }
    Log.i("FinderMegaVideoMiniViewHelper", "addMiniView, no ball, add delayed:%s", new Object[] { Long.valueOf(l2) });
    if (paramBoolean) {}
    for (;;)
    {
      MMHandlerThread.postToMainThreadDelayed(localExternalSyntheticLambda1, l1);
      break;
      l1 = l2;
    }
  }
  
  public final void setPlaySpeed(float paramFloat)
  {
    if (!cYo()) {
      Log.i("BaseFinderMiniViewHelper", "setPlaySpeed, do not have ball");
    }
    FinderThumbPlayerProxy localFinderThumbPlayerProxy;
    do
    {
      return;
      localFinderThumbPlayerProxy = egj().getVideoView();
    } while (localFinderThumbPlayerProxy == null);
    localFinderThumbPlayerProxy.setPlaySpeed(paramFloat);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/floatball/BaseFinderMiniViewHelper$internalAddMiniView$1", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "gain", "", "loss", "lossTransient", "lossTransientCanDuck", "unKown", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements d.a
  {
    c(a parama) {}
    
    public final void bAi()
    {
      AppMethodBeat.i(330242);
      Log.i("BaseFinderMiniViewHelper", "AudioFocus gain");
      this.BtF.egm();
      AppMethodBeat.o(330242);
    }
    
    public final void bAj()
    {
      AppMethodBeat.i(330254);
      Log.i("BaseFinderMiniViewHelper", "AudioFocus lossTransient");
      this.BtF.egn();
      AppMethodBeat.o(330254);
    }
    
    public final void bAk()
    {
      AppMethodBeat.i(330251);
      Log.i("BaseFinderMiniViewHelper", "AudioFocus lossTransient");
      this.BtF.egn();
      AppMethodBeat.o(330251);
    }
    
    public final void bAl()
    {
      AppMethodBeat.i(330258);
      Log.i("BaseFinderMiniViewHelper", "AudioFocus lossTransientCanDuck");
      AppMethodBeat.o(330258);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.floatball.a
 * JD-Core Version:    0.7.0.1
 */