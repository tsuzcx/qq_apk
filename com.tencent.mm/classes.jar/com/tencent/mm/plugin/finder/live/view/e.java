package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.u.a;
import com.tencent.mm.live.c.as;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.core.core.c;
import com.tencent.mm.live.core.core.c.a.a;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.live.plugin.ac;
import com.tencent.mm.plugin.finder.live.plugin.ae;
import com.tencent.mm.plugin.finder.live.plugin.aj;
import com.tencent.mm.plugin.finder.live.plugin.al;
import com.tencent.mm.plugin.finder.live.plugin.ap;
import com.tencent.mm.plugin.finder.live.plugin.ar;
import com.tencent.mm.plugin.finder.live.plugin.at;
import com.tencent.mm.plugin.finder.live.plugin.ay;
import com.tencent.mm.plugin.finder.live.plugin.bd;
import com.tencent.mm.plugin.finder.live.plugin.bf;
import com.tencent.mm.plugin.finder.live.plugin.bh;
import com.tencent.mm.plugin.finder.live.plugin.bj;
import com.tencent.mm.plugin.finder.live.plugin.bk;
import com.tencent.mm.plugin.finder.live.plugin.h;
import com.tencent.mm.plugin.finder.live.plugin.j;
import com.tencent.mm.plugin.finder.live.plugin.k.a;
import com.tencent.mm.plugin.finder.live.plugin.n;
import com.tencent.mm.plugin.finder.live.plugin.n.b;
import com.tencent.mm.plugin.finder.live.plugin.n.c;
import com.tencent.mm.plugin.finder.live.plugin.n.d;
import com.tencent.mm.plugin.finder.live.plugin.r;
import com.tencent.mm.plugin.finder.live.plugin.t;
import com.tencent.mm.plugin.finder.live.plugin.v;
import com.tencent.mm.plugin.finder.live.plugin.y;
import com.tencent.mm.plugin.finder.live.widget.f;
import com.tencent.mm.plugin.finder.live.widget.f.c;
import com.tencent.mm.plugin.finder.report.live.s.a;
import com.tencent.mm.plugin.finder.report.live.s.ad;
import com.tencent.mm.plugin.finder.report.live.s.ap;
import com.tencent.mm.plugin.finder.report.live.s.o;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.protocal.protobuf.ape;
import com.tencent.mm.protocal.protobuf.aqd;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveBaseAnchorPluginLayout;", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "context", "Lcom/tencent/mm/ui/MMActivity;", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/util/AttributeSet;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "bottomOptionPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorBottomOptionPlugin;", "getBottomOptionPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorBottomOptionPlugin;", "setBottomOptionPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorBottomOptionPlugin;)V", "cameraOptPanelPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorCameraOptPanelPlugin;", "getCameraOptPanelPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorCameraOptPanelPlugin;", "setCameraOptPanelPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorCameraOptPanelPlugin;)V", "cameraOptPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorCameraOptPlugin;", "getCameraOptPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorCameraOptPlugin;", "setCameraOptPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorCameraOptPlugin;)V", "closePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorClosePlugin;", "getClosePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorClosePlugin;", "setClosePlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorClosePlugin;)V", "commentPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;", "getCommentPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;", "setCommentPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;)V", "commonInfoPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin;", "getCommonInfoPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin;", "setCommonInfoPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin;)V", "confettiPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLikeConfettiPlugin;", "getConfettiPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLikeConfettiPlugin;", "setConfettiPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLikeConfettiPlugin;)V", "exceptionPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorExceptionPlugin;", "getExceptionPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorExceptionPlugin;", "setExceptionPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorExceptionPlugin;)V", "finderLiveAfterPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin;", "getFinderLiveAfterPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin;", "setFinderLiveAfterPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin;)V", "finderLiveBeforePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBeforePlugin;", "getFinderLiveBeforePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBeforePlugin;", "setFinderLiveBeforePlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBeforePlugin;)V", "giftPlayPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPlayPlugin;", "getGiftPlayPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPlayPlugin;", "setGiftPlayPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPlayPlugin;)V", "giftQueuePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin;", "getGiftQueuePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin;", "setGiftQueuePlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin;)V", "linkApplyListPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin;", "getLinkApplyListPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin;", "setLinkApplyListPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin;)V", "linkStatePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkMicStatePlugin;", "getLinkStatePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkMicStatePlugin;", "setLinkStatePlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkMicStatePlugin;)V", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "setLiveCore", "(Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;)V", "liveMessageCallback", "Lkotlin/Function0;", "", "getLiveMessageCallback", "()Lkotlin/jvm/functions/Function0;", "setLiveMessageCallback", "(Lkotlin/jvm/functions/Function0;)V", "lotteryBubblePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin;", "getLotteryBubblePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin;", "setLotteryBubblePlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin;)V", "lotteryCardPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin;", "getLotteryCardPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin;", "setLotteryCardPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin;)V", "memberListPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin;", "getMemberListPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin;", "setMemberListPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin;)V", "moreActionPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin;", "getMoreActionPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin;", "setMoreActionPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin;)V", "previewPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPreviewPlugin;", "getPreviewPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPreviewPlugin;", "setPreviewPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPreviewPlugin;)V", "profilePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberProfilePlugin;", "getProfilePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberProfilePlugin;", "setProfilePlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberProfilePlugin;)V", "readyPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveReadyPlugin;", "getReadyPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveReadyPlugin;", "setReadyPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveReadyPlugin;)V", "shadowPlugin", "Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "getShadowPlugin", "()Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "setShadowPlugin", "(Lcom/tencent/mm/live/plugin/LiveShadowPlugin;)V", "shoppingBubblePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin;", "getShoppingBubblePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin;", "setShoppingBubblePlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin;)V", "shoppingListPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin;", "getShoppingListPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin;", "setShoppingListPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin;)V", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimerThread", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "setTimerThread", "(Lcom/tencent/mm/sdk/platformtools/MTimerHandler;)V", "titleInfoPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin;", "getTitleInfoPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin;", "setTitleInfoPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin;)V", "topCommentPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTopCommentPlugin;", "getTopCommentPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTopCommentPlugin;", "setTopCommentPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTopCommentPlugin;)V", "videoLinkBottomBarPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoLinkBottomBarPlugin;", "getVideoLinkBottomBarPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoLinkBottomBarPlugin;", "setVideoLinkBottomBarPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoLinkBottomBarPlugin;)V", "createLive", "genLiveCore", "handleLiveErr", "errType", "", "errCode", "errMsg", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveResp;", "startTimer", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopLive", "stopTimer", "plugin-finder_release"})
public abstract class e
  extends FinderBaseLivePluginLayout
{
  private String TAG = "FinderLiveBaseAnchorPluginLayout";
  private HashMap _$_findViewCache;
  private v commentPlugin;
  private y commonInfoPlugin;
  private aj confettiPlugin;
  private ac giftPlayPlugin;
  private ae giftQueuePlugin;
  private com.tencent.mm.live.core.core.trtc.a hSS = dip();
  private kotlin.g.a.a<x> liveMessageCallback;
  private al lotteryBubblePlugin;
  private ap memberListPlugin;
  private at moreActionPlugin;
  private ar profilePlugin;
  private bd shoppingBubblePlugin;
  private bf shoppingListPlugin;
  MTimerHandler timerThread;
  private bh titleInfoPlugin;
  private bj topCommentPlugin;
  private n uxT;
  private t uxU;
  private r uxV;
  private com.tencent.mm.plugin.finder.live.plugin.e uxW;
  private as uxX;
  private ay uxY;
  private com.tencent.mm.plugin.finder.live.plugin.l uxZ;
  private com.tencent.mm.plugin.finder.live.plugin.k uya;
  private j uyb;
  private com.tencent.mm.plugin.finder.live.plugin.q uyc;
  private com.tencent.mm.plugin.finder.live.plugin.p uyd;
  private com.tencent.mm.plugin.finder.live.plugin.o uye;
  private h uyf;
  private bk videoLinkBottomBarPlugin;
  
  public e(final MMActivity paramMMActivity)
  {
    super((Context)paramMMActivity, null);
    this.liveMessageCallback = ((kotlin.g.a.a)new b(this, paramMMActivity));
    this.timerThread = new MTimerHandler("LiveCommonInfoPlugin::Timer", (MTimerHandler.CallBack)new e(this), true);
  }
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
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
    return localView1;
  }
  
  protected final void aJm()
  {
    this.hSS.b((c)new d());
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, aqd paramaqd)
  {
    Object localObject = null;
    kotlin.g.b.p.h(paramString, "errMsg");
    Log.i(getTAG(), "handleLiveErr errCode:" + paramInt2 + " errMsg:" + paramString);
    paramString = com.tencent.mm.plugin.finder.report.live.k.vkd;
    com.tencent.mm.plugin.finder.report.live.k.q(s.a.vmx.hlf, String.valueOf(s.ap.vrb.type));
    paramString = com.tencent.mm.plugin.finder.report.live.k.vkd;
    com.tencent.mm.plugin.finder.report.live.k.setErrorCode(paramInt2);
    paramString = com.tencent.mm.plugin.finder.report.live.k.vkd;
    com.tencent.mm.plugin.finder.report.live.k.b(s.o.vov);
    paramString = com.tencent.mm.plugin.finder.spam.a.vwk;
    if (paramaqd != null)
    {
      paramString = paramaqd.LCg;
      if (!com.tencent.mm.plugin.finder.spam.a.a(paramInt1, paramInt2, paramString)) {
        break label121;
      }
      b.b.a(this, b.c.hLy);
    }
    label121:
    do
    {
      do
      {
        return;
        paramString = null;
        break;
        paramString = com.tencent.mm.plugin.finder.spam.a.vwk;
        paramString = localObject;
        if (paramaqd != null) {
          paramString = paramaqd.LCg;
        }
        if (!com.tencent.mm.plugin.finder.spam.a.b(paramInt1, paramInt2, paramString)) {
          break label203;
        }
      } while (paramaqd == null);
      paramString = paramaqd.LCg;
    } while (paramString == null);
    paramaqd = new Bundle();
    paramaqd.putByteArray("PARAM_FINDER_LIVE_ERROR_PAGE", paramString.toByteArray());
    paramaqd.putInt("PARAM_FINDER_LIVE_ERROR_CODE", paramInt2);
    statusChange(b.c.hNz, paramaqd);
    return;
    switch (paramInt2)
    {
    default: 
      paramString = getContext();
      paramaqd = getContext();
      kotlin.g.b.p.g(paramaqd, "context");
      com.tencent.mm.ui.base.u.makeText(paramString, (CharSequence)paramaqd.getResources().getString(2131759538), 0).show();
      b.b.a(this, b.c.hLy);
      return;
    case -100038: 
      b.b.a(this, b.c.hLV);
      return;
    case -200012: 
    case -200011: 
      paramString = getContext();
      paramaqd = getContext();
      kotlin.g.b.p.g(paramaqd, "context");
      com.tencent.mm.ui.base.u.makeText(paramString, (CharSequence)paramaqd.getResources().getString(2131759916), 0).show();
      b.b.a(this, b.c.hLV);
      return;
    case -200018: 
    case -200017: 
    case -200013: 
      b.b.a(this, b.c.hNg);
      return;
    case -200009: 
      label203:
      paramString = getContext();
      paramaqd = getContext();
      kotlin.g.b.p.g(paramaqd, "context");
      com.tencent.mm.ui.base.u.makeText(paramString, (CharSequence)paramaqd.getResources().getString(2131759539), 0).show();
      b.b.a(this, b.c.hLy);
      return;
    }
    paramString = getContext();
    paramaqd = getContext();
    kotlin.g.b.p.g(paramaqd, "context");
    com.tencent.mm.ui.base.u.makeText(paramString, (CharSequence)paramaqd.getResources().getString(2131759871), 0).show();
    b.b.a(this, b.c.hLy);
  }
  
  public abstract com.tencent.mm.live.core.core.trtc.a dip();
  
  public final void dis()
  {
    com.tencent.mm.plugin.finder.live.model.s locals = getFinderLiveAssistant();
    if (locals != null) {
      locals.a((kotlin.g.a.u)new a(this));
    }
  }
  
  protected final h getBottomOptionPlugin()
  {
    return this.uyf;
  }
  
  protected final j getCameraOptPanelPlugin()
  {
    return this.uyb;
  }
  
  protected final com.tencent.mm.plugin.finder.live.plugin.k getCameraOptPlugin()
  {
    return this.uya;
  }
  
  protected final com.tencent.mm.plugin.finder.live.plugin.l getClosePlugin()
  {
    return this.uxZ;
  }
  
  protected final v getCommentPlugin()
  {
    return this.commentPlugin;
  }
  
  protected final y getCommonInfoPlugin()
  {
    return this.commonInfoPlugin;
  }
  
  protected final aj getConfettiPlugin()
  {
    return this.confettiPlugin;
  }
  
  public n getExceptionPlugin()
  {
    return this.uxT;
  }
  
  protected final com.tencent.mm.plugin.finder.live.plugin.e getFinderLiveAfterPlugin()
  {
    return this.uxW;
  }
  
  public t getFinderLiveBeforePlugin()
  {
    return this.uxU;
  }
  
  protected final ac getGiftPlayPlugin()
  {
    return this.giftPlayPlugin;
  }
  
  protected final ae getGiftQueuePlugin()
  {
    return this.giftQueuePlugin;
  }
  
  protected final com.tencent.mm.plugin.finder.live.plugin.o getLinkApplyListPlugin()
  {
    return this.uye;
  }
  
  protected final com.tencent.mm.plugin.finder.live.plugin.p getLinkStatePlugin()
  {
    return this.uyd;
  }
  
  protected final com.tencent.mm.live.core.core.trtc.a getLiveCore()
  {
    return this.hSS;
  }
  
  protected final kotlin.g.a.a<x> getLiveMessageCallback()
  {
    return this.liveMessageCallback;
  }
  
  protected final al getLotteryBubblePlugin()
  {
    return this.lotteryBubblePlugin;
  }
  
  protected final com.tencent.mm.plugin.finder.live.plugin.q getLotteryCardPlugin()
  {
    return this.uyc;
  }
  
  protected final ap getMemberListPlugin()
  {
    return this.memberListPlugin;
  }
  
  protected final at getMoreActionPlugin()
  {
    return this.moreActionPlugin;
  }
  
  protected final r getPreviewPlugin()
  {
    return this.uxV;
  }
  
  protected final ar getProfilePlugin()
  {
    return this.profilePlugin;
  }
  
  protected final ay getReadyPlugin()
  {
    return this.uxY;
  }
  
  protected final as getShadowPlugin()
  {
    return this.uxX;
  }
  
  protected final bd getShoppingBubblePlugin()
  {
    return this.shoppingBubblePlugin;
  }
  
  protected final bf getShoppingListPlugin()
  {
    return this.shoppingListPlugin;
  }
  
  public String getTAG()
  {
    return this.TAG;
  }
  
  protected final MTimerHandler getTimerThread()
  {
    return this.timerThread;
  }
  
  protected final bh getTitleInfoPlugin()
  {
    return this.titleInfoPlugin;
  }
  
  protected final bj getTopCommentPlugin()
  {
    return this.topCommentPlugin;
  }
  
  protected final bk getVideoLinkBottomBarPlugin()
  {
    return this.videoLinkBottomBarPlugin;
  }
  
  protected final void setBottomOptionPlugin(h paramh)
  {
    this.uyf = paramh;
  }
  
  protected final void setCameraOptPanelPlugin(j paramj)
  {
    this.uyb = paramj;
  }
  
  protected final void setCameraOptPlugin(com.tencent.mm.plugin.finder.live.plugin.k paramk)
  {
    this.uya = paramk;
  }
  
  protected final void setClosePlugin(com.tencent.mm.plugin.finder.live.plugin.l paraml)
  {
    this.uxZ = paraml;
  }
  
  protected final void setCommentPlugin(v paramv)
  {
    this.commentPlugin = paramv;
  }
  
  protected final void setCommonInfoPlugin(y paramy)
  {
    this.commonInfoPlugin = paramy;
  }
  
  protected final void setConfettiPlugin(aj paramaj)
  {
    this.confettiPlugin = paramaj;
  }
  
  public void setExceptionPlugin(n paramn)
  {
    this.uxT = paramn;
  }
  
  protected final void setFinderLiveAfterPlugin(com.tencent.mm.plugin.finder.live.plugin.e parame)
  {
    this.uxW = parame;
  }
  
  public void setFinderLiveBeforePlugin(t paramt)
  {
    this.uxU = paramt;
  }
  
  protected final void setGiftPlayPlugin(ac paramac)
  {
    this.giftPlayPlugin = paramac;
  }
  
  protected final void setGiftQueuePlugin(ae paramae)
  {
    this.giftQueuePlugin = paramae;
  }
  
  protected final void setLinkApplyListPlugin(com.tencent.mm.plugin.finder.live.plugin.o paramo)
  {
    this.uye = paramo;
  }
  
  protected final void setLinkStatePlugin(com.tencent.mm.plugin.finder.live.plugin.p paramp)
  {
    this.uyd = paramp;
  }
  
  protected final void setLiveCore(com.tencent.mm.live.core.core.trtc.a parama)
  {
    kotlin.g.b.p.h(parama, "<set-?>");
    this.hSS = parama;
  }
  
  protected final void setLiveMessageCallback(kotlin.g.a.a<x> parama)
  {
    kotlin.g.b.p.h(parama, "<set-?>");
    this.liveMessageCallback = parama;
  }
  
  protected final void setLotteryBubblePlugin(al paramal)
  {
    this.lotteryBubblePlugin = paramal;
  }
  
  protected final void setLotteryCardPlugin(com.tencent.mm.plugin.finder.live.plugin.q paramq)
  {
    this.uyc = paramq;
  }
  
  protected final void setMemberListPlugin(ap paramap)
  {
    this.memberListPlugin = paramap;
  }
  
  protected final void setMoreActionPlugin(at paramat)
  {
    this.moreActionPlugin = paramat;
  }
  
  protected final void setPreviewPlugin(r paramr)
  {
    this.uxV = paramr;
  }
  
  protected final void setProfilePlugin(ar paramar)
  {
    this.profilePlugin = paramar;
  }
  
  protected final void setReadyPlugin(ay paramay)
  {
    this.uxY = paramay;
  }
  
  protected final void setShadowPlugin(as paramas)
  {
    this.uxX = paramas;
  }
  
  protected final void setShoppingBubblePlugin(bd parambd)
  {
    this.shoppingBubblePlugin = parambd;
  }
  
  protected final void setShoppingListPlugin(bf parambf)
  {
    this.shoppingListPlugin = parambf;
  }
  
  public void setTAG(String paramString)
  {
    kotlin.g.b.p.h(paramString, "<set-?>");
    this.TAG = paramString;
  }
  
  protected final void setTimerThread(MTimerHandler paramMTimerHandler)
  {
    kotlin.g.b.p.h(paramMTimerHandler, "<set-?>");
    this.timerThread = paramMTimerHandler;
  }
  
  protected final void setTitleInfoPlugin(bh parambh)
  {
    this.titleInfoPlugin = parambh;
  }
  
  protected final void setTopCommentPlugin(bj parambj)
  {
    this.topCommentPlugin = parambj;
  }
  
  protected final void setVideoLinkBottomBarPlugin(bk parambk)
  {
    this.videoLinkBottomBarPlugin = parambk;
  }
  
  protected final void startTimer()
  {
    y localy = this.commonInfoPlugin;
    if ((localy != null) && (localy.hwr.getVisibility() == 0))
    {
      this.timerThread.stopTimer();
      this.timerThread.startTimer(1000L);
    }
  }
  
  public void statusChange(b.c paramc, Bundle paramBundle)
  {
    Object localObject2 = null;
    kotlin.g.b.p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    Object localObject3;
    if (paramBundle != null)
    {
      localObject3 = paramBundle.getByteArray("PARAM_FINDER_LIVE_ERROR_PAGE");
      if (localObject3 == null) {}
    }
    Object localObject1;
    for (avr localavr = new avr();; localObject1 = null) {
      try
      {
        localavr.parseFrom((byte[])localObject3);
        switch (f.$EnumSwitchMapping$0[paramc.ordinal()])
        {
        default: 
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e(getTAG(), "statusChange:", new Object[] { localThrowable });
          localObject1 = null;
        }
      }
    }
    if (paramBundle != null) {}
    for (paramc = paramBundle.getString("PARAM_FINDER_LIVE_FACE_VERIFY_URL");; paramc = null)
    {
      if (paramBundle != null) {
        localObject2 = paramBundle.getString("PARAM_FINDER_LIVE_USERNAME");
      }
      paramBundle = getExceptionPlugin();
      if (paramBundle != null)
      {
        Log.i(paramBundle.TAG, "showFaceVerify:".concat(String.valueOf(paramc)));
        localObject3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.a(s.ad.vqe, (String)localObject2);
        paramBundle.atI("");
        localObject3 = paramBundle.umS;
        if (localObject3 != null)
        {
          f.c localc = f.uGx;
          f.a((f)localObject3, f.djF(), (avr)localObject1, (kotlin.g.a.b)new n.d(paramBundle, paramc, (String)localObject2), 4);
        }
      }
      paramc = getExceptionPlugin();
      if (paramc != null) {
        paramc.rg(0);
      }
      paramc = getFinderLiveBeforePlugin();
      if (paramc == null) {
        break;
      }
      paramc.rg(8);
      return;
    }
    localObject2 = getFinderLiveBeforePlugin();
    if (localObject2 != null) {
      ((t)localObject2).rg(8);
    }
    hideLoadingLayer();
    localObject2 = this.uxX;
    if (localObject2 != null) {
      ((as)localObject2).rg(8);
    }
    localObject2 = this.uxV;
    if (localObject2 != null) {
      ((r)localObject2).rg(8);
    }
    localObject2 = this.titleInfoPlugin;
    if (localObject2 != null) {
      ((bh)localObject2).rg(8);
    }
    localObject2 = this.commonInfoPlugin;
    if (localObject2 != null) {
      ((y)localObject2).rg(8);
    }
    localObject2 = this.uxY;
    if (localObject2 != null) {
      ((ay)localObject2).rg(8);
    }
    localObject2 = this.commentPlugin;
    if (localObject2 != null) {
      ((v)localObject2).rg(8);
    }
    localObject2 = this.uxZ;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.l)localObject2).rg(8);
    }
    localObject2 = this.uxW;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.e)localObject2).rg(8);
    }
    localObject2 = this.memberListPlugin;
    if (localObject2 != null) {
      ((ap)localObject2).rg(8);
    }
    localObject2 = this.profilePlugin;
    if (localObject2 != null) {
      ((ar)localObject2).rg(8);
    }
    localObject2 = this.confettiPlugin;
    if (localObject2 != null) {
      ((aj)localObject2).rg(8);
    }
    localObject2 = this.moreActionPlugin;
    if (localObject2 != null) {
      ((at)localObject2).rg(8);
    }
    localObject2 = this.topCommentPlugin;
    if (localObject2 != null) {
      ((bj)localObject2).rg(8);
    }
    localObject2 = this.uya;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.k)localObject2).rg(8);
    }
    localObject2 = this.shoppingBubblePlugin;
    if (localObject2 != null) {
      ((bd)localObject2).rg(8);
    }
    localObject2 = this.shoppingListPlugin;
    if (localObject2 != null) {
      ((bf)localObject2).rg(8);
    }
    localObject2 = this.uyd;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.p)localObject2).rg(8);
    }
    localObject2 = this.uye;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.o)localObject2).rg(8);
    }
    localObject2 = this.videoLinkBottomBarPlugin;
    if (localObject2 != null) {
      ((bk)localObject2).rg(8);
    }
    localObject2 = this.uyb;
    if (localObject2 != null) {
      ((j)localObject2).rg(8);
    }
    localObject2 = this.giftPlayPlugin;
    if (localObject2 != null) {
      ((ac)localObject2).rg(8);
    }
    localObject2 = this.giftQueuePlugin;
    if (localObject2 != null) {
      ((ae)localObject2).rg(8);
    }
    localObject2 = this.uyf;
    if (localObject2 != null) {
      ((h)localObject2).rg(8);
    }
    if (paramc == b.c.hNg)
    {
      paramc = getExceptionPlugin();
      if (paramc != null)
      {
        paramBundle = getLiveData().hwd;
        kotlin.g.b.p.h(paramBundle, "anchorUserName");
        Log.i(paramc.TAG, "showAnchorForceQuit anchorUserName:".concat(String.valueOf(paramBundle)));
        paramc.atI(paramBundle);
        paramBundle = paramc.umS;
        if (paramBundle != null)
        {
          localObject1 = f.uGx;
          f.a(paramBundle, f.djG(), null, (kotlin.g.a.b)new n.b(paramc), 6);
        }
      }
      paramc = getExceptionPlugin();
      if (paramc != null) {
        paramc.rg(0);
      }
      this.hSS.a(com.tencent.mm.live.core.mini.d.hCX);
      if ((this.hSS instanceof com.tencent.mm.live.core.core.a.b))
      {
        paramc = getFinderLiveAssistant();
        if (paramc != null) {
          paramc.a(1, (kotlin.g.a.s)new c(this));
        }
      }
      paramc = getFinderLiveAssistant();
      if (paramc != null) {
        paramc.dfk();
      }
      paramc = com.tencent.mm.plugin.finder.live.model.q.ukd;
      com.tencent.mm.plugin.finder.live.model.q.dgC();
      paramc = com.tencent.mm.plugin.finder.live.model.o.ujN;
      com.tencent.mm.plugin.finder.live.model.o.aHh();
      aJm();
      return;
    }
    if (paramBundle != null) {}
    for (int i = paramBundle.getInt("PARAM_FINDER_LIVE_ERROR_CODE");; i = 0)
    {
      paramc = getExceptionPlugin();
      if (paramc == null) {
        break;
      }
      paramBundle = getLiveData().hwd;
      kotlin.g.b.p.h(paramBundle, "anchorUserName");
      Log.i(paramc.TAG, "showCreateLiveDynamicErrPage anchorUserName:".concat(String.valueOf(paramBundle)));
      paramc.atI(paramBundle);
      paramBundle = paramc.umS;
      if (paramBundle == null) {
        break;
      }
      localObject2 = f.uGx;
      paramBundle.a(f.djJ(), (avr)localObject1, i, (kotlin.g.a.b)new n.c(paramc));
      break;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "needFaceVerify", "verifyUrl", "", "errType", "", "errCode", "errMsg", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveResp;", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.u<Boolean, Boolean, String, Integer, Integer, String, aqd, x>
  {
    a(e parame)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(e parame, MMActivity paramMMActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "errresp", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.s<Boolean, Integer, Integer, String, ape, x>
  {
    c(e parame)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/view/FinderLiveBaseAnchorPluginLayout$stopLive$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
  public static final class d
    implements c
  {
    public final void callback(int paramInt, Bundle paramBundle) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class e
    implements MTimerHandler.CallBack
  {
    e(e parame) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(247433);
      Object localObject1 = this.uyg.getCommonInfoPlugin();
      int i;
      Object localObject2;
      long l;
      if ((localObject1 != null) && (((com.tencent.mm.live.c.a)localObject1).hwr.getVisibility() == 0))
      {
        localObject1 = this.uyg.getCommonInfoPlugin();
        if (localObject1 != null)
        {
          i = this.uyg.getLiveData().liveInfo.dvv;
          if (com.tencent.mm.kernel.g.aAf().azp())
          {
            int j = cl.aWB();
            localObject2 = com.tencent.mm.live.b.u.hIn;
            ((y)localObject1).hPQ = u.a.a(j - i, ":", false, false, false, 28);
            i = j - i;
            if (i <= 0) {
              break label308;
            }
            l = i;
            ((y)localObject1).duration = l;
          }
        }
        localObject1 = this.uyg.getCommonInfoPlugin();
        if (localObject1 != null)
        {
          if (!((y)localObject1).dMz) {
            break label340;
          }
          localObject2 = m.vVH;
          if (!m.i(((y)localObject1).getLiveData())) {
            break label313;
          }
          localObject2 = com.tencent.mm.live.core.core.c.a.hAj;
          ((com.tencent.mm.live.c.a)localObject1).hwr.getContext();
          i = a.a.aDw().hAz.hzL;
        }
      }
      for (;;)
      {
        ((y)localObject1).hPP = i;
        localObject1 = this.uyg.getCommonInfoPlugin();
        if (localObject1 != null) {
          ((y)localObject1).ae(this.uyg.getLiveData().liveInfo.uBn, this.uyg.getLiveData().liveInfo.wBG, this.uyg.getLiveData().uDV);
        }
        localObject1 = this.uyg.getCameraOptPlugin();
        if ((localObject1 != null) && (((com.tencent.mm.live.c.a)localObject1).hwr.getVisibility() == 0))
        {
          localObject1 = this.uyg.getCameraOptPlugin();
          if (localObject1 != null) {
            com.tencent.mm.ac.d.h((kotlin.g.a.a)new k.a((com.tencent.mm.plugin.finder.live.plugin.k)localObject1, this.uyg.getLiveData().liveInfo.wBG));
          }
        }
        AppMethodBeat.o(247433);
        return true;
        label308:
        l = 0L;
        break;
        label313:
        localObject2 = com.tencent.mm.live.core.core.a.b.hyv;
        ((com.tencent.mm.live.c.a)localObject1).hwr.getContext();
        i = com.tencent.mm.live.core.core.a.b.a.aDo().hAz.hzL;
        continue;
        label340:
        localObject2 = com.tencent.mm.live.core.core.d.b.hCo;
        ((com.tencent.mm.live.c.a)localObject1).hwr.getContext();
        i = com.tencent.mm.live.core.core.d.b.a.aEf().hAz.hzL;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.e
 * JD-Core Version:    0.7.0.1
 */