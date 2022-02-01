package com.tencent.mm.plugin.finder.replay;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.live.model.n;
import com.tencent.mm.plugin.finder.live.model.au;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.plugin.ag;
import com.tencent.mm.plugin.finder.live.plugin.be;
import com.tencent.mm.plugin.finder.live.plugin.bf;
import com.tencent.mm.plugin.finder.live.plugin.cg;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import com.tencent.mm.plugin.finder.live.widget.bm;
import com.tencent.mm.plugin.finder.replay.widget.f.a;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayPluginLayout;", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayRouter;", "Lcom/tencent/mm/plugin/finder/replay/widget/IFinderLiveReplayFullScreenReplayUI;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveMessageCallback", "Lkotlin/Function0;", "", "liveSlowMessageCallback", "seiProcessViewCallbackProxy", "Lcom/tencent/mm/plugin/finder/live/model/SeiProcessCallbackFullUIProxy;", "getSeiProcessViewCallbackProxy", "()Lcom/tencent/mm/plugin/finder/live/model/SeiProcessCallbackFullUIProxy;", "seiProcessViewCallbackProxy$delegate", "Lkotlin/Lazy;", "uiClickListener", "Lcom/tencent/mm/plugin/finder/replay/widget/IFinderLiveReplayUI$UIClickListener;", "getUiClickListener", "()Lcom/tencent/mm/plugin/finder/replay/widget/IFinderLiveReplayUI$UIClickListener;", "setUiClickListener", "(Lcom/tencent/mm/plugin/finder/replay/widget/IFinderLiveReplayUI$UIClickListener;)V", "activate", "bindData", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "deactivate", "finishUI", "getLiveRole", "getRelativeLayoutId", "getUIContext", "getView", "T", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "mount", "onAcceptLiveMic", "info", "Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "onAnchorCallInterruption", "callInterruption", "", "onAnchorConnectionChange", "connectionAvailable", "onApplyLiveMic", "Lcom/tencent/mm/live/model/ApplyLiveMicInfo;", "onBanLiveComment", "Lcom/tencent/mm/live/model/BanLiveCommentInfo;", "onBattleApply", "onBattleClose", "onBattleDismiss", "onBattleEnd", "onBattleStart", "onCallStateChanged", "state", "incomingNumber", "", "onCloseApplyLiveMic", "Lcom/tencent/mm/live/model/CloseApplyLiveMicInfo;", "onCloseLiveMic", "Lcom/tencent/mm/live/model/CloseLiveMicInfo;", "onFirstFrameUpdate", "onLiveEventCallback", "errorCode", "param", "Landroid/os/Bundle;", "onLiveMicSucc", "Lcom/tencent/mm/live/model/LiveMicSuccessInfo;", "onOnlineLiveList", "Lcom/tencent/mm/live/model/OnlineLiveListInfo;", "onRotationSwitchChange", "rotationEnable", "onVideoPlay", "offset", "onVideoPlayEnded", "source", "onVideoPlayOverTime", "onVideoPlayPause", "onVideoSizeChange", "width", "height", "release", "setUIClickListener", "listener", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "unMount", "updatePlayProgress", "total", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveReplayPluginLayout
  extends j
  implements com.tencent.mm.plugin.finder.replay.widget.e
{
  private final kotlin.j Fkm;
  private f.a Fkn;
  private kotlin.g.a.a<ah> liveMessageCallback;
  private kotlin.g.a.a<ah> liveSlowMessageCallback;
  
  public FinderLiveReplayPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(332593);
    AppMethodBeat.o(332593);
  }
  
  public FinderLiveReplayPluginLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(332587);
    this.liveMessageCallback = ((kotlin.g.a.a)new b(this));
    this.liveSlowMessageCallback = ((kotlin.g.a.a)new c(this));
    this.Fkm = kotlin.k.cm((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(332587);
  }
  
  private static final void a(FinderLiveThumbPlayerProxy paramFinderLiveThumbPlayerProxy, FinderLiveReplayPluginLayout paramFinderLiveReplayPluginLayout)
  {
    AppMethodBeat.i(332600);
    kotlin.g.b.s.u(paramFinderLiveThumbPlayerProxy, "$it");
    kotlin.g.b.s.u(paramFinderLiveReplayPluginLayout, "this$0");
    int[] arrayOfInt = new int[2];
    paramFinderLiveThumbPlayerProxy.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[1];
    int j = paramFinderLiveThumbPlayerProxy.getHeight();
    paramFinderLiveThumbPlayerProxy = (cg)paramFinderLiveReplayPluginLayout.getPlugin(cg.class);
    if (paramFinderLiveThumbPlayerProxy != null) {
      cg.a(paramFinderLiveThumbPlayerProxy, j + i);
    }
    AppMethodBeat.o(332600);
  }
  
  public final void RM(int paramInt)
  {
    AppMethodBeat.i(332802);
    hideLoadingLayer(false);
    com.tencent.mm.plugin.finder.replay.plugin.e locale = (com.tencent.mm.plugin.finder.replay.plugin.e)getPlugin(com.tencent.mm.plugin.finder.replay.plugin.e.class);
    if (locale != null)
    {
      business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
      locale.RX(paramInt);
    }
    locale = (com.tencent.mm.plugin.finder.replay.plugin.e)getPlugin(com.tencent.mm.plugin.finder.replay.plugin.e.class);
    if (locale != null) {
      locale.onVideoPlay();
    }
    AppMethodBeat.o(332802);
  }
  
  public final void RN(int paramInt)
  {
    AppMethodBeat.i(332830);
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.d)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.class)).eyl()) {
      getWarnningCountWidget().hide();
    }
    Object localObject = (com.tencent.mm.plugin.finder.replay.plugin.e)getPlugin(com.tencent.mm.plugin.finder.replay.plugin.e.class);
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.replay.plugin.e)localObject).eLU();
    }
    if (paramInt == 1)
    {
      localObject = (com.tencent.mm.plugin.finder.replay.plugin.d)getPlugin(com.tencent.mm.plugin.finder.replay.plugin.d.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.replay.plugin.d)localObject).eLS();
      }
    }
    getReplayDecorateUIC().eLw();
    AppMethodBeat.o(332830);
  }
  
  public final void RO(int paramInt)
  {
    AppMethodBeat.i(332838);
    Object localObject;
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.d)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.class)).eyl())
    {
      getWarnningCountWidget().hide();
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC;
      String str = getContext().getResources().getString(p.h.CiX);
      kotlin.g.b.s.s(str, "context.resources.getStr…arge_free_time_over_tips)");
      showTipWithBlurBg((String)localObject, str);
      localObject = (cg)getPlugin(cg.class);
      if ((localObject != null) && (((com.tencent.mm.live.b.a)localObject).mJe.getVisibility() == 0))
      {
        paramInt = 1;
        if (paramInt != 0)
        {
          localObject = (cg)getPlugin(cg.class);
          if (localObject != null) {
            ((cg)localObject).tO(8);
          }
        }
        localObject = (bf)getPlugin(bf.class);
        if ((localObject == null) || (((com.tencent.mm.live.b.a)localObject).mJe.getVisibility() != 0)) {
          break label253;
        }
        paramInt = 1;
        label146:
        if (paramInt != 0)
        {
          localObject = (bf)getPlugin(bf.class);
          if (localObject != null) {
            ((bf)localObject).tO(8);
          }
        }
        localObject = (be)getPlugin(be.class);
        if ((localObject == null) || (((com.tencent.mm.live.b.a)localObject).mJe.getVisibility() != 0)) {
          break label258;
        }
        paramInt = 1;
        label198:
        if (paramInt != 0)
        {
          localObject = (be)getPlugin(be.class);
          if (localObject != null) {
            ((be)localObject).tO(8);
          }
        }
      }
    }
    for (;;)
    {
      localObject = (com.tencent.mm.plugin.finder.replay.plugin.e)getPlugin(com.tencent.mm.plugin.finder.replay.plugin.e.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.replay.plugin.e)localObject).eLU();
      }
      AppMethodBeat.o(332838);
      return;
      paramInt = 0;
      break;
      label253:
      paramInt = 0;
      break label146;
      label258:
      paramInt = 0;
      break label198;
      if (paramInt == 1)
      {
        localObject = (com.tencent.mm.plugin.finder.replay.plugin.d)getPlugin(com.tencent.mm.plugin.finder.replay.plugin.d.class);
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.replay.plugin.d)localObject).eLS();
        }
      }
      getReplayDecorateUIC().eLw();
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final <T extends com.tencent.mm.plugin.finder.live.plugin.b> T bf(Class<T> paramClass)
  {
    AppMethodBeat.i(332847);
    kotlin.g.b.s.u(paramClass, "modelClass");
    paramClass = super.getPlugin(paramClass);
    AppMethodBeat.o(332847);
    return paramClass;
  }
  
  public final void bindData(com.tencent.mm.plugin.finder.live.viewmodel.data.f paramf)
  {
    AppMethodBeat.i(332622);
    kotlin.g.b.s.u(paramf, "data");
    super.bindData(paramf);
    com.tencent.mm.plugin.finder.live.view.a.fillBlurBg$default((com.tencent.mm.plugin.finder.live.view.a)this, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC, false, 2, null);
    ((com.tencent.mm.plugin.finder.live.component.msginterceptor.c)business(com.tencent.mm.plugin.finder.live.component.msginterceptor.c.class)).init();
    getReplayBaseUIC().c((com.tencent.mm.plugin.finder.live.view.a)this);
    getReplayDecorateUIC().c((com.tencent.mm.plugin.finder.live.view.a)this);
    AppMethodBeat.o(332622);
  }
  
  public final void dmh()
  {
    AppMethodBeat.i(332856);
    finish();
    AppMethodBeat.o(332856);
  }
  
  public final void eLu()
  {
    AppMethodBeat.i(332792);
    getReplayBaseUIC().eLu();
    Object localObject1 = (com.tencent.mm.plugin.finder.replay.plugin.d)getPlugin(com.tencent.mm.plugin.finder.replay.plugin.d.class);
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.replay.plugin.d)localObject1).eLR();
    }
    localObject1 = (com.tencent.mm.plugin.finder.replay.plugin.d)getPlugin(com.tencent.mm.plugin.finder.replay.plugin.d.class);
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.replay.plugin.d)localObject1).Fmd;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.replay.widget.c)localObject1).Fni;
        if (localObject1 != null) {
          ((FinderLiveThumbPlayerProxy)localObject1).postDelayed(new FinderLiveReplayPluginLayout..ExternalSyntheticLambda0((FinderLiveThumbPlayerProxy)localObject1, this), 100L);
        }
      }
    }
    if (((com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).FmM != 3)
    {
      localObject1 = (cg)getPlugin(cg.class);
      if (localObject1 != null) {
        if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyC())
        {
          Object localObject2 = aw.Gjk;
          if (!aw.bgV()) {
            break label160;
          }
          localObject2 = com.tencent.d.a.a.a.a.a.ahiX;
          if (!com.tencent.d.a.a.a.a.a.jTH()) {
            break label160;
          }
        }
      }
    }
    label160:
    for (boolean bool = true;; bool = false)
    {
      ((cg)localObject1).rK(bool);
      AppMethodBeat.o(332792);
      return;
    }
  }
  
  public final void eLx()
  {
    AppMethodBeat.i(332809);
    com.tencent.mm.plugin.finder.live.view.a.fillBlurBg$default((com.tencent.mm.plugin.finder.live.view.a)this, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC, false, 2, null);
    AppMethodBeat.o(332809);
  }
  
  public final void eLy()
  {
    AppMethodBeat.i(332825);
    com.tencent.mm.plugin.finder.replay.plugin.e locale = (com.tencent.mm.plugin.finder.replay.plugin.e)getPlugin(com.tencent.mm.plugin.finder.replay.plugin.e.class);
    if (locale != null) {
      locale.onVideoPause();
    }
    AppMethodBeat.o(332825);
  }
  
  public final int getLiveRole()
  {
    return 0;
  }
  
  public final int getRelativeLayoutId()
  {
    return p.f.Cfr;
  }
  
  final au getSeiProcessViewCallbackProxy()
  {
    AppMethodBeat.i(332609);
    au localau = (au)this.Fkm.getValue();
    AppMethodBeat.o(332609);
    return localau;
  }
  
  public final Context getUIContext()
  {
    AppMethodBeat.i(332843);
    Context localContext = getContext();
    kotlin.g.b.s.s(localContext, "context");
    AppMethodBeat.o(332843);
    return localContext;
  }
  
  public final f.a getUiClickListener()
  {
    return this.Fkn;
  }
  
  public final void ia(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(332819);
    Object localObject = (com.tencent.mm.plugin.finder.replay.plugin.e)getPlugin(com.tencent.mm.plugin.finder.replay.plugin.e.class);
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.replay.plugin.e)localObject).RX(paramInt1);
    }
    localObject = (ag)getPlugin(ag.class);
    d.a locala;
    int i;
    if (localObject != null)
    {
      locala = com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.Eci;
      i = kotlin.k.k.qv(com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.eyn(), paramInt2);
      ((ag)localObject).hG(i - paramInt1, i);
    }
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.d)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.class)).eyl())
    {
      i = ((com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).total;
      localObject = com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.Eci;
      if (i >= com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.eyn())
      {
        localObject = getWarnningCountWidget();
        locala = com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.Eci;
        ((bm)localObject).Qr(kotlin.k.k.qv(com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.eyn(), paramInt2) - paramInt1);
      }
    }
    AppMethodBeat.o(332819);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(332627);
    super.mount();
    com.tencent.mm.live.model.j localj = com.tencent.mm.live.model.j.mXT;
    com.tencent.mm.live.model.j.g(name(), this.liveMessageCallback);
    localj = com.tencent.mm.live.model.j.mXT;
    com.tencent.mm.live.model.j.h(name(), this.liveSlowMessageCallback);
    AppMethodBeat.o(332627);
  }
  
  public final void onAcceptLiveMic(com.tencent.mm.live.model.a parama)
  {
    AppMethodBeat.i(332698);
    kotlin.g.b.s.u(parama, "info");
    Log.i(getTAG(), "onAcceptLinkMicOthers curLinkState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy + " curLiveUser:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv + " audienceLinkMicUserList:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw + " audienceMode:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyu());
    parama = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
    if ((parama != null) && (parama.EbD == true)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        com.tencent.mm.plugin.finder.live.view.a.notifyPKMicUserChange$default((com.tencent.mm.plugin.finder.live.view.a)this, false, 1, null);
        b.b.a((com.tencent.mm.live.b.b)this, b.c.neC);
      }
      AppMethodBeat.o(332698);
      return;
    }
  }
  
  public final void onAnchorCallInterruption(boolean paramBoolean) {}
  
  public final void onAnchorConnectionChange(boolean paramBoolean) {}
  
  public final void onApplyLiveMic(com.tencent.mm.live.model.b paramb)
  {
    AppMethodBeat.i(332689);
    kotlin.g.b.s.u(paramb, "info");
    AppMethodBeat.o(332689);
  }
  
  public final void onBanLiveComment(com.tencent.mm.live.model.c paramc)
  {
    AppMethodBeat.i(332741);
    kotlin.g.b.s.u(paramc, "info");
    AppMethodBeat.o(332741);
  }
  
  public final void onBattleApply() {}
  
  public final void onBattleClose() {}
  
  public final void onBattleDismiss() {}
  
  public final void onBattleEnd() {}
  
  public final void onBattleStart() {}
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    AppMethodBeat.i(332666);
    kotlin.g.b.s.u(paramString, "incomingNumber");
    AppMethodBeat.o(332666);
  }
  
  public final void onCloseApplyLiveMic(com.tencent.mm.live.model.d paramd)
  {
    AppMethodBeat.i(332731);
    kotlin.g.b.s.u(paramd, "info");
    AppMethodBeat.o(332731);
  }
  
  public final void onCloseLiveMic(com.tencent.mm.live.model.f arg1)
  {
    AppMethodBeat.i(332712);
    kotlin.g.b.s.u(???, "info");
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
    int i;
    if ((localObject1 != null) && (((h)localObject1).EbD == true)) {
      i = 1;
    }
    while ((i == 0) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM)) {
      if (Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyF(), ???.mXL))
      {
        i = ???.mXM;
        Log.i(getTAG(), kotlin.g.b.s.X("onCloseLinkMicSelf micType:", Integer.valueOf(i)));
        if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM) {
          com.tencent.mm.plugin.finder.live.view.a.notifyAudienceMicUserChange$default((com.tencent.mm.plugin.finder.live.view.a)this, false, 1, null);
        }
        AppMethodBeat.o(332712);
        return;
        i = 0;
      }
      else
      {
        i = ???.mXM;
        Log.i(getTAG(), kotlin.g.b.s.X("onCloseLinkMicOthers micType:", Integer.valueOf(i)));
        i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyu();
        ??? = e.b.mKf;
        if (i != e.b.bct())
        {
          i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyu();
          ??? = e.b.mKf;
          if (i == e.b.bcu())
          {
            ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
            kotlin.g.b.s.s(???, "business(\n              …).audienceLinkMicUserList");
            synchronized ((Iterable)???)
            {
              localObject1 = ???.iterator();
              boolean bool;
              do
              {
                if (!((Iterator)localObject1).hasNext()) {
                  break;
                }
                bool = Util.isEqual(((h)((Iterator)localObject1).next()).mXL, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyF());
              } while (!bool);
              AppMethodBeat.o(332712);
              return;
            }
          }
        }
      }
    }
    AppMethodBeat.o(332712);
  }
  
  public final void onLiveEventCallback(int paramInt, Bundle paramBundle) {}
  
  public final void onLiveMicSucc(n paramn)
  {
    AppMethodBeat.i(332748);
    kotlin.g.b.s.u(paramn, "info");
    AppMethodBeat.o(332748);
  }
  
  public final void onOnlineLiveList(com.tencent.mm.live.model.s params)
  {
    AppMethodBeat.i(332757);
    kotlin.g.b.s.u(params, "info");
    AppMethodBeat.o(332757);
  }
  
  public final void onRotationSwitchChange(boolean paramBoolean) {}
  
  public final void release() {}
  
  public final void setUIClickListener(f.a parama)
  {
    AppMethodBeat.i(332861);
    kotlin.g.b.s.u(parama, "listener");
    this.Fkn = parama;
    AppMethodBeat.o(332861);
  }
  
  public final void setUiClickListener(f.a parama)
  {
    this.Fkn = parama;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(332639);
    kotlin.g.b.s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    getReplayBaseUIC().c(paramc);
    g localg = getReplayDecorateUIC();
    kotlin.g.b.s.u(paramc, "status");
    switch (g.b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(332639);
      return;
      if (paramBundle == null) {}
      for (;;)
      {
        paramc = localg.FkM;
        if (paramc == null) {
          break;
        }
        paramc.onScreenClear(bool);
        AppMethodBeat.o(332639);
        return;
        bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_SCREEN_CLEAR");
      }
      localg.tu(true);
      paramc = localg.FkM;
      if (paramc != null) {
        com.tencent.mm.plugin.finder.live.view.a.hideLoadingLayer$default(paramc, false, 1, null);
      }
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(332632);
    super.unMount();
    com.tencent.mm.live.model.j localj = com.tencent.mm.live.model.j.mXT;
    com.tencent.mm.live.model.j.bhj();
    AppMethodBeat.o(332632);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "pair", "Lkotlin/Pair;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<r<? extends LinkedList<bke>, ? extends LinkedList<bdm>>, ah>
  {
    a(FinderLiveReplayPluginLayout paramFinderLiveReplayPluginLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(FinderLiveReplayPluginLayout paramFinderLiveReplayPluginLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(FinderLiveReplayPluginLayout paramFinderLiveReplayPluginLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/model/SeiProcessCallbackFullUIProxy;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<au>
  {
    d(FinderLiveReplayPluginLayout paramFinderLiveReplayPluginLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.FinderLiveReplayPluginLayout
 * JD-Core Version:    0.7.0.1
 */