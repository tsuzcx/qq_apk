package com.tencent.mm.plugin.finder.replay.shopping;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.plugin.finder.live.model.au;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.plugin.be;
import com.tencent.mm.plugin.finder.live.plugin.bf;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import com.tencent.mm.plugin.finder.replay.plugin.d;
import com.tencent.mm.plugin.finder.replay.viewmodel.c;
import com.tencent.mm.plugin.finder.replay.widget.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/shopping/FinderLiveShoppingReplayPluginLayout;", "Lcom/tencent/mm/plugin/finder/replay/shopping/FinderLiveShoppingReplayRouter;", "Lcom/tencent/mm/plugin/finder/replay/widget/IFinderLiveReplayFullScreenReplayUI;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "seiProcessViewCallbackProxy", "Lcom/tencent/mm/plugin/finder/live/model/SeiProcessCallbackFullUIProxy;", "getSeiProcessViewCallbackProxy", "()Lcom/tencent/mm/plugin/finder/live/model/SeiProcessCallbackFullUIProxy;", "seiProcessViewCallbackProxy$delegate", "Lkotlin/Lazy;", "uiClickListener", "Lcom/tencent/mm/plugin/finder/replay/widget/IFinderLiveReplayUI$UIClickListener;", "getUiClickListener", "()Lcom/tencent/mm/plugin/finder/replay/widget/IFinderLiveReplayUI$UIClickListener;", "setUiClickListener", "(Lcom/tencent/mm/plugin/finder/replay/widget/IFinderLiveReplayUI$UIClickListener;)V", "activate", "", "bindData", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "deactivate", "finishUI", "getLiveRole", "", "getRelativeLayoutId", "getUIContext", "getView", "T", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "onAcceptLiveMic", "info", "Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "onBattleApply", "onBattleClose", "onBattleDismiss", "onBattleEnd", "onBattleStart", "onCallStateChanged", "state", "incomingNumber", "", "onCloseLiveMic", "Lcom/tencent/mm/live/model/CloseLiveMicInfo;", "onFirstFrameUpdate", "onLiveEventCallback", "errorCode", "param", "Landroid/os/Bundle;", "onRotationSwitchChange", "rotationEnable", "", "onVideoFinish", "source", "onVideoPlay", "offset", "onVideoPlayEnded", "onVideoPlayOverTime", "onVideoPlayPause", "onVideoSizeChange", "width", "height", "release", "setUIClickListener", "listener", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "updatePlayProgress", "total", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveShoppingReplayPluginLayout
  extends b
  implements com.tencent.mm.plugin.finder.replay.widget.e
{
  private final kotlin.j Fkm;
  private f.a Fkn;
  
  public FinderLiveShoppingReplayPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(332564);
    this.Fkm = k.cm((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(332564);
  }
  
  private final void RY(int paramInt)
  {
    AppMethodBeat.i(332571);
    Object localObject = (com.tencent.mm.plugin.finder.replay.plugin.e)getPlugin(com.tencent.mm.plugin.finder.replay.plugin.e.class);
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.replay.plugin.e)localObject).eLU();
    }
    if (paramInt == 1)
    {
      localObject = (d)getPlugin(d.class);
      if (localObject != null) {
        ((d)localObject).eLS();
      }
    }
    localObject = (bf)getPlugin(bf.class);
    if ((localObject != null) && (((com.tencent.mm.live.b.a)localObject).mJe.getVisibility() == 0))
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        localObject = (bf)getPlugin(bf.class);
        if (localObject != null) {
          ((bf)localObject).tO(8);
        }
      }
      localObject = (be)getPlugin(be.class);
      if ((localObject == null) || (((com.tencent.mm.live.b.a)localObject).mJe.getVisibility() != 0)) {
        break label157;
      }
    }
    label157:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        localObject = (be)getPlugin(be.class);
        if (localObject != null) {
          ((be)localObject).tO(8);
        }
      }
      AppMethodBeat.o(332571);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public final void RM(int paramInt)
  {
    AppMethodBeat.i(332716);
    hideLoadingLayer(false);
    com.tencent.mm.plugin.finder.replay.plugin.e locale = (com.tencent.mm.plugin.finder.replay.plugin.e)getPlugin(com.tencent.mm.plugin.finder.replay.plugin.e.class);
    if (locale != null)
    {
      business(c.class);
      locale.RX(paramInt);
    }
    locale = (com.tencent.mm.plugin.finder.replay.plugin.e)getPlugin(com.tencent.mm.plugin.finder.replay.plugin.e.class);
    if (locale != null) {
      locale.onVideoPlay();
    }
    AppMethodBeat.o(332716);
  }
  
  public final void RN(int paramInt)
  {
    AppMethodBeat.i(332745);
    RY(paramInt);
    AppMethodBeat.o(332745);
  }
  
  public final void RO(int paramInt)
  {
    AppMethodBeat.i(332755);
    RY(paramInt);
    AppMethodBeat.o(332755);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final <T extends com.tencent.mm.plugin.finder.live.plugin.b> T bf(Class<T> paramClass)
  {
    AppMethodBeat.i(332688);
    s.u(paramClass, "modelClass");
    paramClass = super.getPlugin(paramClass);
    AppMethodBeat.o(332688);
    return paramClass;
  }
  
  public final void bindData(com.tencent.mm.plugin.finder.live.viewmodel.data.f paramf)
  {
    AppMethodBeat.i(332591);
    s.u(paramf, "data");
    super.bindData(paramf);
    com.tencent.mm.plugin.finder.live.view.a.fillBlurBg$default((com.tencent.mm.plugin.finder.live.view.a)this, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC, false, 2, null);
    getShoppingReplayBaseUIC().c((com.tencent.mm.plugin.finder.live.view.a)this);
    getShoppingReplayDecorateUIC().c((com.tencent.mm.plugin.finder.live.view.a)this);
    AppMethodBeat.o(332591);
  }
  
  public final void dmh()
  {
    AppMethodBeat.i(332696);
    finish();
    AppMethodBeat.o(332696);
  }
  
  public final void eLu()
  {
    AppMethodBeat.i(332707);
    getShoppingReplayBaseUIC().eLu();
    d locald = (d)getPlugin(d.class);
    if (locald != null) {
      locald.eLR();
    }
    AppMethodBeat.o(332707);
  }
  
  public final void eLx()
  {
    AppMethodBeat.i(332724);
    com.tencent.mm.plugin.finder.live.view.a.fillBlurBg$default((com.tencent.mm.plugin.finder.live.view.a)this, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC, false, 2, null);
    AppMethodBeat.o(332724);
  }
  
  public final void eLy()
  {
    AppMethodBeat.i(332737);
    com.tencent.mm.plugin.finder.replay.plugin.e locale = (com.tencent.mm.plugin.finder.replay.plugin.e)getPlugin(com.tencent.mm.plugin.finder.replay.plugin.e.class);
    if (locale != null) {
      locale.onVideoPause();
    }
    AppMethodBeat.o(332737);
  }
  
  public final int getLiveRole()
  {
    return 2;
  }
  
  public final int getRelativeLayoutId()
  {
    return p.f.CfI;
  }
  
  final au getSeiProcessViewCallbackProxy()
  {
    AppMethodBeat.i(332577);
    au localau = (au)this.Fkm.getValue();
    AppMethodBeat.o(332577);
    return localau;
  }
  
  public final Context getUIContext()
  {
    AppMethodBeat.i(332678);
    Context localContext = getContext();
    s.s(localContext, "context");
    AppMethodBeat.o(332678);
    return localContext;
  }
  
  public final f.a getUiClickListener()
  {
    return this.Fkn;
  }
  
  public final void ia(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(332730);
    com.tencent.mm.plugin.finder.replay.plugin.e locale = (com.tencent.mm.plugin.finder.replay.plugin.e)getPlugin(com.tencent.mm.plugin.finder.replay.plugin.e.class);
    if (locale != null) {
      locale.RX(paramInt1);
    }
    AppMethodBeat.o(332730);
  }
  
  public final void onAcceptLiveMic(com.tencent.mm.live.model.a parama)
  {
    AppMethodBeat.i(332654);
    s.u(parama, "info");
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
      AppMethodBeat.o(332654);
      return;
    }
  }
  
  public final void onBattleApply() {}
  
  public final void onBattleClose() {}
  
  public final void onBattleDismiss() {}
  
  public final void onBattleEnd() {}
  
  public final void onBattleStart() {}
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    AppMethodBeat.i(332613);
    s.u(paramString, "incomingNumber");
    AppMethodBeat.o(332613);
  }
  
  public final void onCloseLiveMic(com.tencent.mm.live.model.f arg1)
  {
    AppMethodBeat.i(332671);
    s.u(???, "info");
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
    int i;
    if ((localObject1 != null) && (((h)localObject1).EbD == true)) {
      i = 1;
    }
    while ((i == 0) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM)) {
      if (Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyF(), ???.mXL))
      {
        i = ???.mXM;
        Log.i(getTAG(), s.X("onCloseLinkMicSelf micType:", Integer.valueOf(i)));
        if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM) {
          com.tencent.mm.plugin.finder.live.view.a.notifyAudienceMicUserChange$default((com.tencent.mm.plugin.finder.live.view.a)this, false, 1, null);
        }
        AppMethodBeat.o(332671);
        return;
        i = 0;
      }
      else
      {
        i = ???.mXM;
        Log.i(getTAG(), s.X("onCloseLinkMicOthers micType:", Integer.valueOf(i)));
        i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyu();
        ??? = e.b.mKf;
        if (i != e.b.bct())
        {
          i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyu();
          ??? = e.b.mKf;
          if (i == e.b.bcu())
          {
            ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
            s.s(???, "business(\n              …).audienceLinkMicUserList");
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
              AppMethodBeat.o(332671);
              return;
            }
          }
        }
      }
    }
    AppMethodBeat.o(332671);
  }
  
  public final void onLiveEventCallback(int paramInt, Bundle paramBundle) {}
  
  public final void onRotationSwitchChange(boolean paramBoolean) {}
  
  public final void release() {}
  
  public final void setUIClickListener(f.a parama)
  {
    AppMethodBeat.i(332701);
    s.u(parama, "listener");
    this.Fkn = parama;
    AppMethodBeat.o(332701);
  }
  
  public final void setUiClickListener(f.a parama)
  {
    this.Fkn = parama;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(332598);
    s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    getShoppingReplayBaseUIC().c(paramc);
    AppMethodBeat.o(332598);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/model/SeiProcessCallbackFullUIProxy;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<au>
  {
    a(FinderLiveShoppingReplayPluginLayout paramFinderLiveShoppingReplayPluginLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.shopping.FinderLiveShoppingReplayPluginLayout
 * JD-Core Version:    0.7.0.1
 */