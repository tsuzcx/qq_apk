package com.tencent.mm.plugin.finder.megavideo.floatball;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewOutlineProvider;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.a.ip;
import com.tencent.mm.f.a.iy;
import com.tencent.mm.f.a.nl;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoTimelineUI.a;
import com.tencent.mm.plugin.finder.megavideo.ui.FinderMegaVideoMiniView;
import com.tencent.mm.plugin.finder.megavideo.ui.FinderMegaVideoMiniView.c;
import com.tencent.mm.plugin.finder.megavideo.ui.FinderMegaVideoMiniView.d;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.report.ai;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy.b;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.reporter.e;
import com.tencent.mm.plugin.finder.video.t;
import com.tencent.mm.plugin.finder.video.z;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.cwl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/floatball/FinderMegaVideoMiniViewHelper;", "Lcom/tencent/mm/plugin/ball/service/FloatBallHelper;", "()V", "checkVideoState", "com/tencent/mm/plugin/finder/megavideo/floatball/FinderMegaVideoMiniViewHelper$checkVideoState$1", "Lcom/tencent/mm/plugin/finder/megavideo/floatball/FinderMegaVideoMiniViewHelper$checkVideoState$1;", "finderSeekEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderSeekEvent;", "isBallHidden", "", "miniView", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoMiniView;", "getMiniView", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoMiniView;", "miniView$delegate", "Lkotlin/Lazy;", "miniWindowClickListener", "Landroid/view/View$OnClickListener;", "miniWindowCloseClickListener", "multiTalkActionListener", "timeWhenRemoveView", "", "voipCallEvent", "Lcom/tencent/mm/autogen/events/VoipEvent;", "addMiniView", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "needPost", "megaVideoFeedId", "feedId", "hideMiniView", "removeMiniView", "resumeMiniView", "seekSec", "", "setLiveViewSize", "setPlaySpeed", "ratio", "", "Companion", "plugin-finder_release"})
public final class a
  extends FloatBallHelper
{
  private static final kotlin.f kPd;
  public static final a zwo;
  private final kotlin.f kLH;
  private final IListener<?> kLS;
  private long kqE;
  private final View.OnClickListener kwy;
  private final IListener<aaq> yhs;
  private final View.OnClickListener yhu;
  private boolean zwl;
  private final d zwm;
  private final IListener<ip> zwn;
  
  static
  {
    AppMethodBeat.i(278435);
    zwo = new a((byte)0);
    kPd = g.a(k.aazB, (kotlin.g.a.a)b.zwp);
    AppMethodBeat.o(278435);
  }
  
  public a()
  {
    AppMethodBeat.i(278433);
    n localn = n.zWF;
    I(22, n.dPD());
    cvL().kqZ = 17;
    this.kLH = g.ar((kotlin.g.a.a)f.zwr);
    this.kwy = ((View.OnClickListener)new g(this));
    this.yhu = ((View.OnClickListener)new h(this));
    this.zwm = new d(this);
    this.yhs = ((IListener)new k(this));
    this.kLS = ((IListener)new i(this));
    this.zwn = ((IListener)new e(this));
    AppMethodBeat.o(278433);
  }
  
  private final void dJG()
  {
    AppMethodBeat.i(278431);
    if (this.rYE.rYm == null) {
      this.rYE.rYm = new Point();
    }
    int i = aw.aZ(MMApplicationContext.getContext(), b.d.Edge_A);
    this.rYE.rYm.x = (aw.aZ(MMApplicationContext.getContext(), b.d.float_ball_voip_view_video_width) + i * 2);
    this.rYE.rYm.y = (aw.aZ(MMApplicationContext.getContext(), b.d.float_ball_voip_view_video_height) + i * 2);
    Log.i("FinderMegaVideoMiniViewHelper", "setLiveViewSize %s, margin: %d", new Object[] { this.rYE.rYm, Integer.valueOf(i) });
    AppMethodBeat.o(278431);
  }
  
  public final void Oe(final int paramInt)
  {
    AppMethodBeat.i(278426);
    if ((!cvD()) || (!this.zwl))
    {
      Log.i("FinderMegaVideoMiniViewHelper", "resumeMiniView, do not have ball, or ball is Hidden = " + this.zwl);
      AppMethodBeat.o(278426);
      return;
    }
    this.zwl = false;
    FinderThumbPlayerProxy localFinderThumbPlayerProxy = dJD().getVideoView();
    if (localFinderThumbPlayerProxy != null)
    {
      ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).ld(false);
      com.tencent.mm.plugin.ball.f.f.cwA();
      localFinderThumbPlayerProxy.setIsShouldPlayResume(false);
      localFinderThumbPlayerProxy.setVideoViewFocused(true);
      if (dJD().zxt) {
        dJD().setError(false);
      }
      localFinderThumbPlayerProxy.egV();
      localFinderThumbPlayerProxy.post((Runnable)new j(localFinderThumbPlayerProxy, this, paramInt));
      AppMethodBeat.o(278426);
      return;
    }
    AppMethodBeat.o(278426);
  }
  
  public final void a(i parami, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(278424);
    p.k(parami, "holder");
    Object localObject1 = dJD();
    Object localObject2 = this.kwy;
    Object localObject3 = this.yhu;
    p.k(localObject2, "clickListener");
    p.k(localObject3, "closeClickListener");
    ((FinderMegaVideoMiniView)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    ((FinderMegaVideoMiniView)localObject1).kHA.setOnClickListener((View.OnClickListener)localObject3);
    int i = aw.aZ(MMApplicationContext.getContext(), com.tencent.mm.live.core.a.b.Edge_A);
    dJD().setPadding(i, i, i, i);
    localObject3 = dJD();
    p.k(parami, "holder");
    Object localObject4 = (FinderVideoLayout)parami.RD(b.f.finder_banner_video_layout);
    Object localObject5;
    label356:
    Object localObject6;
    if (localObject4 != null)
    {
      localObject2 = ((FinderVideoLayout)localObject4).getVideoView();
      localObject1 = localObject2;
      if (!(localObject2 instanceof FinderThumbPlayerProxy)) {
        localObject1 = null;
      }
      localObject2 = (FinderThumbPlayerProxy)localObject1;
      if (localObject2 != null)
      {
        Log.i("FinderMegaVideoMiniView", "addRenderView: proxy=".concat(String.valueOf(localObject2)));
        ((FinderMegaVideoMiniView)localObject3).dJT();
        ((FinderMegaVideoMiniView)localObject3).oA();
        localObject1 = MMApplicationContext.getContext();
        p.j(localObject1, "MMApplicationContext.getContext()");
        localObject5 = new FinderThumbPlayerProxy((Context)localObject1);
        ((FinderThumbPlayerProxy)localObject5).AMF = true;
        ((FinderThumbPlayerProxy)localObject5).AMB = null;
        ((FinderThumbPlayerProxy)localObject5).AMI = null;
        ((FinderThumbPlayerProxy)localObject5).ALf = null;
        ((FinderThumbPlayerProxy)localObject5).AMH = null;
        ((FinderThumbPlayerProxy)localObject5).AMs = null;
        ((FinderThumbPlayerProxy)localObject5).zxu = null;
        ((FinderThumbPlayerProxy)localObject5).animate().cancel();
        ((FinderThumbPlayerProxy)localObject5).animate().setListener(null);
        if (localObject2 != null)
        {
          localObject1 = ((FinderThumbPlayerProxy)localObject2).getVideoMediaInfo();
          if (localObject1 != null)
          {
            if (!(localObject1 instanceof com.tencent.mm.plugin.finder.video.source.a)) {
              break label1064;
            }
            localObject1 = (t)new com.tencent.mm.plugin.finder.video.source.a("", ((t)localObject1).path, ((t)localObject1).mediaId, ((t)localObject1).APg, ((t)localObject1).xqx, ((t)localObject1).xzp);
            ((FinderThumbPlayerProxy)localObject5).xqv = ((t)localObject1);
            localObject1 = ((FinderThumbPlayerProxy)localObject5).AMt;
            if (localObject1 == null) {
              break label1109;
            }
            localObject1 = ((FinderThumbPlayerProxy.b)localObject1).mediaId;
            localObject6 = ((FinderThumbPlayerProxy)localObject5).xqv;
            if (localObject6 == null) {
              p.iCn();
            }
            if (!(p.h(localObject1, ((t)localObject6).mediaId) ^ true)) {
              break label1115;
            }
            localObject1 = ((FinderThumbPlayerProxy)localObject5).xqv;
            if (localObject1 == null) {
              p.iCn();
            }
            localObject1 = ((t)localObject1).mediaId;
            localObject6 = ((FinderThumbPlayerProxy)localObject5).xqv;
            if (localObject6 == null) {
              p.iCn();
            }
            ((FinderThumbPlayerProxy)localObject5).AMt = new FinderThumbPlayerProxy.b((FinderThumbPlayerProxy)localObject5, (String)localObject1, (t)localObject6);
            Log.i(FinderThumbPlayerProxy.TAG, "setVideoMediaInfo(), init proxy " + ((FinderThumbPlayerProxy)localObject5).AMt);
            label468:
            localObject1 = ((FinderThumbPlayerProxy)localObject5).xqv;
            if (localObject1 == null) {
              p.iCn();
            }
            ((FinderThumbPlayerProxy)localObject5).a((t)localObject1);
            ((FinderThumbPlayerProxy)localObject5).xqC.reset();
            localObject1 = ((FinderThumbPlayerProxy)localObject5).xqC;
            localObject6 = ((FinderThumbPlayerProxy)localObject5).xqv;
            if (localObject6 == null) {
              p.iCn();
            }
            ((e)localObject1).init(((t)localObject6).mediaId);
            ((FinderThumbPlayerProxy)localObject5).xqC.ehS();
            ((FinderThumbPlayerProxy)localObject2).ehd();
          }
        }
        localObject1 = ((FinderThumbPlayerProxy)localObject5).AMt;
        if (localObject1 != null) {
          FinderThumbPlayerProxy.AMM.add(((FinderThumbPlayerProxy.b)localObject1).mediaId);
        }
        ((FinderThumbPlayerProxy)localObject5).setFullScreenEnjoy(true);
        ((FinderThumbPlayerProxy)localObject5).setVideoViewCallback(((FinderMegaVideoMiniView)localObject3).zxu);
        ((FinderThumbPlayerProxy)localObject5).setLifecycle((z)new FinderMegaVideoMiniView.c((FinderThumbPlayerProxy)localObject2, (FinderThumbPlayerProxy)localObject5, (FinderVideoLayout)localObject4, (FinderMegaVideoMiniView)localObject3));
        ((FinderThumbPlayerProxy)localObject5).setLoop(false);
        ((FinderThumbPlayerProxy)localObject2).setMute(true);
        ((FinderThumbPlayerProxy)localObject5).setVideoViewFocused(true);
        ((FinderThumbPlayerProxy)localObject5).egV();
        ((FinderThumbPlayerProxy)localObject5).setClipToOutline(true);
        ((FinderThumbPlayerProxy)localObject5).setOutlineProvider((ViewOutlineProvider)new com.tencent.mm.live.core.mini.d(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 8)));
        ((FinderMegaVideoMiniView)localObject3).zxs.addView((View)localObject5, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        ((FinderMegaVideoMiniView)localObject3).zxs.post((Runnable)new FinderMegaVideoMiniView.d((FinderThumbPlayerProxy)localObject5, (FinderVideoLayout)localObject4, (FinderMegaVideoMiniView)localObject3));
      }
    }
    label795:
    long l;
    if (cvD())
    {
      Log.i("FinderMegaVideoMiniViewHelper", "addMiniView, has ball, but view is different, ballInfo.customView:%s", new Object[] { this.rYE.bFK });
      this.rYE.rYr = true;
      this.rYE.state = 2048;
      this.rYE.bFK = ((View)dJD());
      this.rYE.qmt = false;
      this.rYE.rYq = true;
      dJG();
      cvF();
      l = cm.bfE();
      localObject5 = "uin_".concat(String.valueOf(l));
      this.rYE.fg("KEY_FLOAT_BALL_MINI_SESSION_ID", (String)localObject5);
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      parami = parami.getContext();
      p.j(parami, "holder.context");
      parami = aj.a.fZ(parami);
      if (parami == null) {
        break label1232;
      }
    }
    label1064:
    label1232:
    for (parami = parami.ekY();; parami = null)
    {
      localObject1 = ai.zZt;
      localObject6 = com.tencent.mm.ae.d.Fw(paramLong1);
      if (parami != null)
      {
        localObject2 = parami.sessionId;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      if (parami != null)
      {
        localObject3 = parami.wmL;
        localObject2 = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        localObject2 = "";
      }
      if (parami != null)
      {
        localObject4 = parami.wmz;
        localObject3 = localObject4;
        if (localObject4 != null) {}
      }
      else
      {
        localObject3 = "";
      }
      ai.a(3, (String)localObject5, 0, (String)localObject6, (String)localObject1, (String)localObject2, (String)localObject3, true);
      localObject1 = ai.zZt;
      localObject4 = com.tencent.mm.ae.d.Fw(paramLong1);
      if (parami != null)
      {
        localObject2 = parami.sessionId;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      if (parami != null)
      {
        localObject3 = parami.wmL;
        localObject2 = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        localObject2 = "";
      }
      if (parami != null)
      {
        localObject3 = parami.wmz;
        parami = (i)localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        parami = "";
      }
      ai.a(l, 2, 0, (String)localObject4, (String)localObject5, (String)localObject1, (String)localObject2, parami, com.tencent.mm.ae.d.Fw(paramLong2));
      AppMethodBeat.o(278424);
      return;
      localObject1 = (t)new com.tencent.mm.plugin.finder.video.source.b(((t)localObject1).downloadUrl, ((t)localObject1).path, ((t)localObject1).mediaId, ((t)localObject1).APg, ((t)localObject1).xqx, ((t)localObject1).xzp);
      break;
      label1109:
      localObject1 = null;
      break label356;
      label1115:
      Log.w(FinderThumbPlayerProxy.TAG, "setVideoMediaInfo(), duplicated mediaId " + ((FinderThumbPlayerProxy)localObject5).AMt);
      break label468;
      localObject1 = (Runnable)new c(this);
      l = 200L + this.kqE - Util.nowMilliSecond();
      if ((l <= 0L) && (!paramBoolean))
      {
        ((Runnable)localObject1).run();
        break label795;
      }
      Log.i("FinderMegaVideoMiniViewHelper", "addMiniView, no ball, add delayed:%s", new Object[] { Long.valueOf(l) });
      if (paramBoolean) {
        l = 200L;
      }
      MMHandlerThread.postToMainThreadDelayed((Runnable)localObject1, l);
      break label795;
    }
  }
  
  public final FinderMegaVideoMiniView dJD()
  {
    AppMethodBeat.i(278422);
    FinderMegaVideoMiniView localFinderMegaVideoMiniView = (FinderMegaVideoMiniView)this.kLH.getValue();
    AppMethodBeat.o(278422);
    return localFinderMegaVideoMiniView;
  }
  
  public final void dJE()
  {
    AppMethodBeat.i(278425);
    this.zwl = false;
    if (cvD())
    {
      Log.i("FinderMegaVideoMiniViewHelper", "addMiniView, has ball, view:%s", new Object[] { dJD() });
      this.kqE = Util.nowMilliSecond();
      dJD().dJT();
      this.zwm.dead();
      this.yhs.dead();
      this.kLS.dead();
      this.zwn.dead();
      cvE();
      Object localObject2 = this.rYE.aou("KEY_VIDEO_FLOAT_BALL_INFO");
      Object localObject1 = new cwl();
      try
      {
        ((cwl)localObject1).parseFrom((byte[])localObject2);
        localObject2 = FinderLongVideoTimelineUI.xQK;
        int i = FinderLongVideoTimelineUI.a.MP(((cwl)localObject1).TFj);
        localObject2 = ((ak)h.ag(ak.class)).fillContextIdToIntent(8, 6, i, null);
        localObject1 = ((cwl)localObject1).TFk;
        p.j(localObject1, "floatBallInfo.cacheNewVideoList");
        localObject1 = (FinderObject)j.lp((List)localObject1);
        if (localObject1 != null)
        {
          localObject1 = new bs((FinderObject)localObject1);
          String str = this.rYE.fh("KEY_FLOAT_BALL_MINI_SESSION_ID", "");
          ai localai = ai.zZt;
          p.j(str, "miniSessionId");
          if (localObject1 == null) {
            break label298;
          }
          l = ((bs)localObject1).mf();
          localObject1 = com.tencent.mm.ae.d.Fw(l);
          p.j(localObject2, "contextId");
          ai.a(5, str, 0, (String)localObject1, "", (String)localObject2, "", true);
          AppMethodBeat.o(278425);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e("FinderMegaVideoMiniViewHelper", "handleBallInfoClicked", new Object[] { localThrowable });
          continue;
          localObject1 = null;
          continue;
          label298:
          long l = 0L;
        }
      }
    }
    Log.i("FinderMegaVideoMiniViewHelper", "addMiniView, no ball, view:%s", new Object[] { dJD() });
    AppMethodBeat.o(278425);
  }
  
  public final void dJF()
  {
    AppMethodBeat.i(278427);
    if (!cvD())
    {
      Log.i("FinderMegaVideoMiniViewHelper", "hideMiniView, do not have ball");
      AppMethodBeat.o(278427);
      return;
    }
    this.zwl = true;
    FinderThumbPlayerProxy localFinderThumbPlayerProxy = dJD().getVideoView();
    if (localFinderThumbPlayerProxy != null)
    {
      localFinderThumbPlayerProxy.setIsShouldPlayResume(false);
      localFinderThumbPlayerProxy.setVideoViewFocused(false);
      localFinderThumbPlayerProxy.egW();
      ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).ld(true);
      com.tencent.mm.plugin.ball.f.f.cvI();
      AppMethodBeat.o(278427);
      return;
    }
    AppMethodBeat.o(278427);
  }
  
  public final void setPlaySpeed(float paramFloat)
  {
    AppMethodBeat.i(278429);
    if (!cvD())
    {
      Log.i("FinderMegaVideoMiniViewHelper", "setPlaySpeed, do not have ball");
      AppMethodBeat.o(278429);
      return;
    }
    FinderThumbPlayerProxy localFinderThumbPlayerProxy = dJD().getVideoView();
    if (localFinderThumbPlayerProxy != null)
    {
      localFinderThumbPlayerProxy.setPlaySpeed(paramFloat);
      AppMethodBeat.o(278429);
      return;
    }
    AppMethodBeat.o(278429);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/floatball/FinderMegaVideoMiniViewHelper$Companion;", "", "()V", "KEY_OPEN_FROM_VIDEO_FLOAT_BALL", "", "TAG", "instance", "Lcom/tencent/mm/plugin/finder/megavideo/floatball/FinderMegaVideoMiniViewHelper;", "getInstance", "()Lcom/tencent/mm/plugin/finder/megavideo/floatball/FinderMegaVideoMiniViewHelper;", "instance$delegate", "Lkotlin/Lazy;", "plugin-finder_release"})
  public static final class a
  {
    public static a dJH()
    {
      AppMethodBeat.i(280340);
      Object localObject = a.aRW();
      a locala = a.zwo;
      localObject = (a)((kotlin.f)localObject).getValue();
      AppMethodBeat.o(280340);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/megavideo/floatball/FinderMegaVideoMiniViewHelper;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<a>
  {
    public static final b zwp;
    
    static
    {
      AppMethodBeat.i(225930);
      zwp = new b();
      AppMethodBeat.o(225930);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(279779);
      Log.i("FinderMegaVideoMiniViewHelper", "addMiniView, no ball, view:%s", new Object[] { this.zwq.dJD() });
      a.a(this.zwq).rYr = true;
      a.a(this.zwq).qmt = false;
      a.a(this.zwq).state = 2048;
      a.a(this.zwq).bFK = ((View)this.zwq.dJD());
      a.a(this.zwq).rYq = true;
      a.b(this.zwq);
      a.c(this.zwq).alive();
      a.d(this.zwq).alive();
      a.e(this.zwq).alive();
      a.f(this.zwq).alive();
      this.zwq.cvF();
      AppMethodBeat.o(279779);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/floatball/FinderMegaVideoMiniViewHelper$checkVideoState$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderVideoStateActionEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class d
    extends IListener<iy>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/floatball/FinderMegaVideoMiniViewHelper$finderSeekEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderSeekEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class e
    extends IListener<ip>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoMiniView;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<FinderMegaVideoMiniView>
  {
    public static final f zwr;
    
    static
    {
      AppMethodBeat.i(286263);
      zwr = new f();
      AppMethodBeat.o(286263);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(a parama) {}
    
    public final void onClick(View paramView)
    {
      long l2 = 0L;
      AppMethodBeat.i(273385);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/floatball/FinderMegaVideoMiniViewHelper$miniWindowClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      paramView = new Intent();
      paramView.putExtra("KEY_OPEN_FROM_VIDEO_FLOAT_BALL", true);
      long l1;
      if (!this.zwq.dJD().kLr)
      {
        localObject1 = this.zwq.dJD().getVideoView();
        if (localObject1 != null) {
          l1 = ((FinderThumbPlayerProxy)localObject1).getCurrentPlayMs();
        }
      }
      for (;;)
      {
        paramView.putExtra("KEY_VIDEO_START_PLAY_TIME_MS", l1);
        localObject1 = this.zwq.dJD().getVideoView();
        float f;
        Object localObject2;
        if (localObject1 != null)
        {
          f = ((FinderThumbPlayerProxy)localObject1).getPlaySpeedRatio();
          paramView.putExtra("KEY_VIDEO_PLAY_SPEED_RATIO", f);
          localObject2 = a.a(this.zwq).aou("KEY_VIDEO_FLOAT_BALL_INFO");
          localObject1 = new cwl();
        }
        try
        {
          ((cwl)localObject1).parseFrom((byte[])localObject2);
          localObject2 = ((cwl)localObject1).TFk;
          p.j(localObject2, "floatBallInfo.cacheNewVideoList");
          localObject4 = (Iterable)localObject2;
          localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          for (;;)
          {
            if (((Iterator)localObject4).hasNext())
            {
              Object localObject5 = (FinderObject)((Iterator)localObject4).next();
              Object localObject6 = FinderItem.Companion;
              p.j(localObject5, "it");
              localObject5 = FinderItem.a.b((FinderObject)localObject5, 1);
              localObject6 = c.AnK;
              ((Collection)localObject2).add(c.a.a((FinderItem)localObject5));
              continue;
              l1 = 0L;
              break;
              f = 1.0F;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Log.e("MegaVideoFloatBallHelper", "handleBallInfoClicked", new Object[] { localThrowable });
          }
          Object localObject3 = (List)localThrowable;
          Object localObject4 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          com.tencent.mm.plugin.finder.utils.aj.a(((cwl)localObject1).TFh, (List)localObject3, ((cwl)localObject1).lastBuffer, paramView);
          paramView.putExtra("KEY_ROUTER_UI", ((cwl)localObject1).TFj);
          paramView.putExtra("KEY_VIDEO_FLOAT_BALL_INFO", ((cwl)localObject1).toByteArray());
          paramView.putExtra("KEY_FLOAT_BALL_TASK_ORDER", a.a(this.zwq).getIntExtra("KEY_FLOAT_BALL_TASK_ORDER", 0));
          paramView.putExtra("KEY_FLOAT_BALL_MINI_SESSION_ID", a.a(this.zwq).fh("KEY_FLOAT_BALL_MINI_SESSION_ID", ""));
          paramView.addFlags(536870912);
          localObject1 = ((ak)h.ag(ak.class)).fillContextIdToIntent(8, 6, 45, paramView);
          localObject4 = com.tencent.mm.plugin.finder.utils.a.ACH;
          localObject4 = MMApplicationContext.getContext();
          p.j(localObject4, "MMApplicationContext.getContext()");
          com.tencent.mm.plugin.finder.utils.a.e((Context)localObject4, paramView, true);
          paramView = a.a(this.zwq).fh("KEY_FLOAT_BALL_MINI_SESSION_ID", "");
          localObject4 = ai.zZt;
          p.j(paramView, "miniSessionId");
          localObject3 = (BaseFinderFeed)j.lp((List)localObject3);
          l1 = l2;
          if (localObject3 != null) {
            l1 = ((BaseFinderFeed)localObject3).mf();
          }
          localObject3 = com.tencent.mm.ae.d.Fw(l1);
          p.j(localObject1, "contextId");
          ai.a(1, paramView, 0, (String)localObject3, "", (String)localObject1, "", true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/floatball/FinderMegaVideoMiniViewHelper$miniWindowClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(273385);
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245605);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/floatball/FinderMegaVideoMiniViewHelper$miniWindowCloseClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.zwq.dJE();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/floatball/FinderMegaVideoMiniViewHelper$miniWindowCloseClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245605);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/floatball/FinderMegaVideoMiniViewHelper$multiTalkActionListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MultiTalkActionEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class i
    extends IListener<nl>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/megavideo/floatball/FinderMegaVideoMiniViewHelper$resumeMiniView$1$1"})
  static final class j
    implements Runnable
  {
    j(FinderThumbPlayerProxy paramFinderThumbPlayerProxy, a parama, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(291532);
      this.zws.a(paramInt, false);
      AppMethodBeat.o(291532);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/floatball/FinderMegaVideoMiniViewHelper$voipCallEvent$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VoipEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class k
    extends IListener<aaq>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.floatball.a
 * JD-Core Version:    0.7.0.1
 */