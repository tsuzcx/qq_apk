package com.tencent.mm.plugin.finder.live.model;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.cgi.au.a;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.protocal.protobuf.biw;
import com.tencent.mm.protocal.protobuf.bng;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveAnchorVerifyManager;", "", "curLiveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "curLiveLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;)V", "buttonColdingRemainingTime", "", "buttonWordingNormal", "", "buttonWordingWithCountDown", "callback", "Lkotlin/Function1;", "", "", "countDownNumberSpan", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveFixWidthTextSpan;", "countDownWording", "countDownWordingThreshold", "currentVerifyId", "currentVerifyMode", "remainingTime", "timer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "verificationUrl", "addSystemMsg", "isVerifying", "checkAnchorVerify", "forceUpdate", "checkTimer", "serverCountDownTime", "finishAnchorVerify", "getShowWordingWithPlaceholder", "", "wording", "time", "gotoVerificationH5", "postVerifyRequest", "success", "recoveryLive", "release", "reset", "showRecoveryToast", "updateButtonState", "updateCountDownTip", "updateCurLiveLayout", "layout", "updateLayerShowView", "info", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLayerAnchorVerificationShowInfo;", "updateVerifyInfo", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d.a CDM;
  public final com.tencent.mm.plugin.finder.live.model.context.a CDN;
  com.tencent.mm.plugin.finder.live.view.a CDO;
  public int CDP;
  public String CDQ;
  private String CDR;
  private int CDS;
  private String CDT;
  private int CDU;
  private String CDV;
  private String CDW;
  private int CDX;
  private final com.tencent.mm.plugin.finder.live.view.span.d CDY;
  private final kotlin.g.a.b<Boolean, ah> callback;
  MTimerHandler timer;
  
  static
  {
    AppMethodBeat.i(359511);
    CDM = new d.a((byte)0);
    AppMethodBeat.o(359511);
  }
  
  public d(com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.plugin.finder.live.view.a parama1)
  {
    AppMethodBeat.i(359302);
    this.CDN = parama;
    this.CDO = parama1;
    this.callback = ((kotlin.g.a.b)new b(this));
    this.timer = new MTimerHandler("FinderLiveAnchorVerifyManager::Timer", (MTimerHandler.CallBack)new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(359722);
        d locald = this.CDZ;
        d.d(locald, d.g(locald) - 1);
        if (d.g(this.CDZ) >= 0)
        {
          if (d.h(this.CDZ) == 5)
          {
            if (d.m(this.CDZ) >= 0)
            {
              d.b(this.CDZ, d.n(this.CDZ), d.m(this.CDZ));
              locald = this.CDZ;
              d.b(locald, d.m(locald) - 1);
            }
            if ((d.o(this.CDZ) <= 0) || (d.g(this.CDZ) > d.o(this.CDZ))) {}
          }
          else
          {
            d.p(this.CDZ);
          }
          AppMethodBeat.o(359722);
          return true;
        }
        Log.i("Finder.FinderLiveAnchorVerifyManager", "backupTimer onTimerExpired: currentVerifyMode:" + d.h(this.CDZ) + ", currentVerifyId:" + d.q(this.CDZ));
        switch (d.h(this.CDZ))
        {
        }
        for (;;)
        {
          AppMethodBeat.o(359722);
          return false;
          d.a(this.CDZ, false);
        }
      }
    }, true);
    this.CDY = new com.tencent.mm.plugin.finder.live.view.span.d(com.tencent.mm.view.d.e(MMApplicationContext.getContext(), 22.0F));
    AppMethodBeat.o(359302);
  }
  
  private final void ekh()
  {
    AppMethodBeat.i(359316);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new g(this));
    AppMethodBeat.o(359316);
  }
  
  private final void qA(boolean paramBoolean)
  {
    AppMethodBeat.i(359326);
    if ((paramBoolean) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)this.CDN.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.i.class)).qag))
    {
      AppMethodBeat.o(359326);
      return;
    }
    Object localObject;
    if (paramBoolean)
    {
      localObject = MMApplicationContext.getContext().getResources().getString(p.h.finder_live_pause_comment_tips);
      s.s(localObject, "if (isVerifying) {\n     …y_comment_tips)\n        }");
      switch (this.CDP)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(359326);
      return;
      localObject = MMApplicationContext.getContext().getResources().getString(p.h.finder_live_pause_recovery_comment_tips);
      break;
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a((String)localObject, this.CDN);
      if (paramBoolean)
      {
        localObject = aj.CGT;
        localObject = aj.getLiveCore();
        if (localObject != null)
        {
          ((com.tencent.mm.live.core.core.trtc.a)localObject).sY(2);
          AppMethodBeat.o(359326);
        }
      }
      else
      {
        localObject = aj.CGT;
        localObject = aj.getLiveCore();
        if (localObject != null) {
          ((com.tencent.mm.live.core.core.trtc.a)localObject).sZ(2);
        }
      }
    }
  }
  
  public final void qz(boolean paramBoolean)
  {
    AppMethodBeat.i(359519);
    Object localObject;
    if (((e)this.CDN.business(e.class)).isLiveStarted())
    {
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)this.CDN.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.i.class)).Efj;
      if (localObject == null)
      {
        AppMethodBeat.o(359519);
        return;
      }
      if ((TextUtils.equals((CharSequence)this.CDQ, (CharSequence)((biw)localObject).ZSt)) && (this.CDP == ((biw)localObject).ZSr) && (!paramBoolean))
      {
        Log.i("Finder.FinderLiveAnchorVerifyManager", "checkAnchorVerify: same id and mode, ignore. currentVerifyMode:" + this.CDP + ", currentVerifyId:" + this.CDQ);
        AppMethodBeat.o(359519);
        return;
      }
      if (localObject != null) {
        break label220;
      }
      Log.i("Finder.FinderLiveAnchorVerifyManager", "updateVerifyInfo: info is null");
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)this.CDN.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.i.class)).qag = true;
      localObject = aj.CGT;
      localObject = aj.elM();
      if (localObject == null) {
        break label318;
      }
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRB;
      if ((localObject == null) || (((com.tencent.mm.live.core.core.model.i)localObject).pause != true)) {
        break label318;
      }
    }
    label318:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = aj.CGT;
        localObject = aj.elM();
        if (localObject != null) {
          ((com.tencent.mm.live.core.core.a.b)localObject).bfe();
        }
      }
      AppMethodBeat.o(359519);
      return;
      label220:
      Log.i("Finder.FinderLiveAnchorVerifyManager", "updateVerifyInfo: verify_mode:" + ((biw)localObject).ZSr + ", verification_id:" + ((biw)localObject).ZSt + ", remaining_seconds:" + ((biw)localObject).ZSu);
      this.CDP = ((biw)localObject).ZSr;
      this.CDQ = ((biw)localObject).ZSt;
      this.CDR = ((biw)localObject).YIJ;
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new k((biw)localObject, this));
      qA(true);
      break;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(359528);
    Log.i("Finder.FinderLiveAnchorVerifyManager", "reset");
    this.CDP = 0;
    this.CDQ = null;
    this.CDR = null;
    this.CDS = 0;
    this.CDT = null;
    this.CDU = 0;
    this.CDV = null;
    this.CDW = null;
    this.CDX = 0;
    MTimerHandler localMTimerHandler = this.timer;
    if (localMTimerHandler != null) {
      localMTimerHandler.stopTimer();
    }
    AppMethodBeat.o(359528);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    public c(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveAnchorVerifyManager$postVerifyRequest$callback$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSuspiciousVerify$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSuspiciousVerifyResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements au.a
  {
    f(boolean paramBoolean, d paramd) {}
    
    public final void a(int paramInt1, int paramInt2, bng parambng)
    {
      AppMethodBeat.i(359653);
      s.u(parambng, "resp");
      if (!this.mgW)
      {
        d.j(this.CDZ);
        AppMethodBeat.o(359653);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (d.h(this.CDZ) == 4)
        {
          d.k(this.CDZ);
          AppMethodBeat.o(359653);
          return;
        }
        d.b(this.CDZ);
      }
      AppMethodBeat.o(359653);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(Context paramContext, d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(d paramd, int paramInt, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<ah>
  {
    j(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<ah>
  {
    k(biw parambiw, d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.d
 * JD-Core Version:    0.7.0.1
 */