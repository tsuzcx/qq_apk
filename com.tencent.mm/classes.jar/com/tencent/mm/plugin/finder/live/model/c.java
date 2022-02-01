package com.tencent.mm.plugin.finder.live.model;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.core.core.model.h;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.model.cgi.ak.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.protocal.protobuf.baf;
import com.tencent.mm.protocal.protobuf.bcw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveAnchorVerifyManager;", "", "curLiveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "curLiveLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;)V", "callback", "Lkotlin/Function1;", "", "", "countDownTime", "", "currentVerifyId", "", "currentVerifyMode", "timer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "verificationUrl", "addSystemMsg", "isVerifying", "checkAnchorVerify", "forceUpdate", "checkTimer", "serverCountDownTime", "finishAnchorVerify", "gotoVerificationH5", "postVerifyRequest", "success", "recoveryLive", "release", "reset", "showRecoveryToast", "updateCountDownTip", "updateCurLiveLayout", "layout", "updateLayerShowView", "info", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLayerAnchorVerificationShowInfo;", "updateVerifyInfo", "Companion", "plugin-finder_release"})
public final class c
{
  public static final a ydu;
  private final kotlin.g.a.b<Boolean, x> callback;
  MTimerHandler timer;
  int ydo;
  String ydp;
  String ydq;
  int ydr;
  final com.tencent.mm.plugin.finder.live.model.context.a yds;
  com.tencent.mm.plugin.finder.live.view.a ydt;
  
  static
  {
    AppMethodBeat.i(286335);
    ydu = new a((byte)0);
    AppMethodBeat.o(286335);
  }
  
  public c(com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.plugin.finder.live.view.a parama1)
  {
    AppMethodBeat.i(286334);
    this.yds = parama;
    this.ydt = parama1;
    this.callback = ((kotlin.g.a.b)new b(this));
    this.timer = new MTimerHandler("FinderLiveAnchorVerifyManager::Timer", (MTimerHandler.CallBack)new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(279723);
        c localc = this.ydv;
        c.b(localc, c.e(localc) - 1);
        if (c.e(this.ydv) >= 0)
        {
          c.j(this.ydv);
          AppMethodBeat.o(279723);
          return true;
        }
        Log.i("Finder.FinderLiveAnchorVerifyManager", "backupTimer onTimerExpired: currentVerifyMode:" + c.d(this.ydv) + ", currentVerifyId:" + c.k(this.ydv));
        switch (c.d(this.ydv))
        {
        }
        for (;;)
        {
          AppMethodBeat.o(279723);
          return false;
          c.a(this.ydv, false);
        }
      }
    }, true);
    AppMethodBeat.o(286334);
  }
  
  private final void oK(boolean paramBoolean)
  {
    AppMethodBeat.i(286333);
    if ((paramBoolean) && (((e)this.yds.business(e.class)).ncq))
    {
      AppMethodBeat.o(286333);
      return;
    }
    Object localObject;
    if (paramBoolean)
    {
      localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(b.j.finder_live_pause_comment_tips);
      p.j(localObject, "if (isVerifying) {\n     …y_comment_tips)\n        }");
      switch (this.ydo)
      {
      }
    }
    do
    {
      AppMethodBeat.o(286333);
      return;
      localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(b.j.finder_live_pause_recovery_comment_tips);
      break;
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.a((String)localObject, this.yds);
      if (paramBoolean)
      {
        localObject = ah.yhC;
        localObject = ah.getLiveCore();
        if (localObject != null)
        {
          ((com.tencent.mm.live.core.core.trtc.a)localObject).sV(2);
          AppMethodBeat.o(286333);
          return;
        }
        AppMethodBeat.o(286333);
        return;
      }
      localObject = ah.yhC;
      localObject = ah.getLiveCore();
    } while (localObject == null);
    ((com.tencent.mm.live.core.core.trtc.a)localObject).sW(2);
    AppMethodBeat.o(286333);
  }
  
  final void dxS()
  {
    AppMethodBeat.i(286332);
    d.uiThread((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(286332);
  }
  
  public final void oJ(boolean paramBoolean)
  {
    AppMethodBeat.i(286330);
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.yds.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted())
    {
      Object localObject = ((e)this.yds.business(e.class)).zha;
      if (localObject == null)
      {
        AppMethodBeat.o(286330);
        return;
      }
      if ((TextUtils.equals((CharSequence)this.ydp, (CharSequence)((baf)localObject).SMe)) && (this.ydo == ((baf)localObject).SMc) && (!paramBoolean))
      {
        Log.i("Finder.FinderLiveAnchorVerifyManager", "checkAnchorVerify: same id and mode, ignore. currentVerifyMode:" + this.ydo + ", currentVerifyId:" + this.ydp);
        AppMethodBeat.o(286330);
        return;
      }
      if (localObject == null) {
        Log.i("Finder.FinderLiveAnchorVerifyManager", "updateVerifyInfo: info is null");
      }
      for (;;)
      {
        ((e)this.yds.business(e.class)).ncq = true;
        localObject = ah.yhC;
        localObject = ah.dzB();
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).knA;
          if ((localObject != null) && (((h)localObject).pause == true)) {
            break;
          }
        }
        localObject = ah.yhC;
        localObject = ah.dzB();
        if (localObject == null) {
          break;
        }
        ((com.tencent.mm.live.core.core.a.b)localObject).aLE();
        AppMethodBeat.o(286330);
        return;
        Log.i("Finder.FinderLiveAnchorVerifyManager", "updateVerifyInfo: verify_mode:" + ((baf)localObject).SMc + ',' + " verification_id:" + ((baf)localObject).SMe + ", remaining_seconds:" + ((baf)localObject).SMf);
        this.ydo = ((baf)localObject).SMc;
        this.ydp = ((baf)localObject).SMe;
        this.ydq = ((baf)localObject).RLx;
        d.uiThread((kotlin.g.a.a)new i(this, (baf)localObject));
        oK(true);
      }
    }
    AppMethodBeat.o(286330);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveAnchorVerifyManager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    b(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveAnchorVerifyManager$postVerifyRequest$callback$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSuspiciousVerify$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSuspiciousVerifyResponse;", "plugin-finder_release"})
  public static final class e
    implements ak.a
  {
    e(boolean paramBoolean) {}
    
    public final void a(int paramInt1, int paramInt2, bcw parambcw)
    {
      AppMethodBeat.i(288344);
      p.k(parambcw, "resp");
      if (!this.jHs)
      {
        c.f(this.ydv);
        AppMethodBeat.o(288344);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (c.d(this.ydv) == 4)
        {
          c.g(this.ydv);
          AppMethodBeat.o(288344);
          return;
        }
        c.h(this.ydv);
      }
      AppMethodBeat.o(288344);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(c paramc, Context paramContext)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    i(c paramc, baf parambaf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.c
 * JD-Core Version:    0.7.0.1
 */