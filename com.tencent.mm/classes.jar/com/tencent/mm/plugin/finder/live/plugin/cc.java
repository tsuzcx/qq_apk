package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.jb;
import com.tencent.mm.autogen.a.jb.a;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.core.core.f.a.a;
import com.tencent.mm.live.core.view.LiveVideoView;
import com.tencent.mm.plugin.finder.live.fluent.g;
import com.tencent.mm.plugin.finder.live.fluent.k;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n;
import com.tencent.mm.plugin.finder.live.viewmodel.data.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RCRelativeLayout;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTXLivePlayerPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "curPlayerStatus", "", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "streamType", "switchWidget", "Lcom/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsPlayerSwitchWidget;", "txLivePlayer", "Lcom/tencent/mm/live/core/core/player/ILivePlayer;", "txLivePlayerPreview", "Lcom/tencent/mm/live/core/view/LiveVideoView;", "kotlin.jvm.PlatformType", "canClearScreenWhenSideBarShow", "", "checkStartPlayState", "getLiveVisitorTRTCCore", "Lcom/tencent/rtmp/ITXLivePlayListener;", "getOrCreateLivePlayer", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTXLivePlayerPlugin$LivePlayerParams;", "config", "Lcom/tencent/rtmp/TXLivePlayConfig;", "checkFluentSwitch", "getPlayer", "getPlayerView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "getSwitchView", "Landroid/view/View;", "hideSwitchGroup", "", "isCdnPlayerDisconnect", "notifySetCurrentSwitchTextureView", "pausePlayer", "resetSwitch", "resumePlayer", "setMute", "mute", "setRenderRotation", "rotation", "setVisible", "visible", "startPlay", "renderMode", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopPlay", "keepLastFrame", "switchVrPlayer", "unMount", "updateFluentSwitchPlayer", "visibleInCurrentLiveMode", "LivePlayerParams", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cc
  extends b
{
  public final com.tencent.mm.plugin.finder.live.olympic.widget.b Dkj;
  public final String TAG;
  public com.tencent.mm.live.core.core.c.b mJG;
  private final com.tencent.mm.live.b.b nfT;
  private final LiveVideoView njU;
  private int streamType;
  
  public cc(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354216);
    this.nfT = paramb;
    this.TAG = "MicroMsg.FinderLiveTXLivePlayerPlugin";
    this.njU = ((LiveVideoView)paramViewGroup.findViewById(b.e.live_tx_live_player_preview));
    paramb = paramViewGroup.findViewById(b.e.live_oly_switch_dialog_layout);
    s.s(paramb, "root.findViewById(R.id.l…oly_switch_dialog_layout)");
    com.tencent.mm.live.b.b localb = this.nfT;
    LiveVideoView localLiveVideoView = this.njU;
    s.s(localLiveVideoView, "txLivePlayerPreview");
    this.Dkj = new com.tencent.mm.plugin.finder.live.olympic.widget.b(paramb, localb, (View)localLiveVideoView, this);
    paramViewGroup.setPadding(0, 0, 0, 0);
    this.njU.mWQ = null;
    AppMethodBeat.o(354216);
  }
  
  private static final a a(cc paramcc, TXLivePlayConfig paramTXLivePlayConfig)
  {
    AppMethodBeat.i(354257);
    com.tencent.mm.live.core.core.f.d locald = paramcc.getLiveCore();
    if (locald == null) {}
    Context localContext;
    for (paramTXLivePlayConfig = null;; paramTXLivePlayConfig = locald.a(localContext, paramTXLivePlayConfig, (com.tencent.mm.live.core.core.f.b)new e(), ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramcc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyM()))
    {
      paramcc = new a(paramTXLivePlayConfig, paramcc.njU);
      AppMethodBeat.o(354257);
      return paramcc;
      localContext = paramcc.mJe.getContext();
      s.s(localContext, "root.context");
    }
  }
  
  private final void esu()
  {
    int j = 0;
    AppMethodBeat.i(354249);
    jb localjb = new jb();
    localjb.hKG.hKH = this.njU;
    localjb.hKG.hKJ = this.mJG;
    jb.a locala = localjb.hKG;
    com.tencent.mm.live.core.core.f.d locald = getLiveCore();
    int i;
    if (locald == null)
    {
      i = 0;
      locala.videoWidth = i;
      locala = localjb.hKG;
      locald = getLiveCore();
      if (locald != null) {
        break label158;
      }
      i = j;
      label87:
      locala.videoHeight = i;
      locala = localjb.hKG;
      locald = getLiveCore();
      if (locald != null) {
        break label167;
      }
    }
    label158:
    label167:
    for (float f = 0.0F;; f = locald.hKI)
    {
      locala.hKI = f;
      Log.i(this.TAG, s.X("start send FinderLiveViewLayoutEvent videoView ", this.njU));
      localjb.publish();
      AppMethodBeat.o(354249);
      return;
      i = locald.videoWidth;
      break;
      i = locald.videoHeight;
      break label87;
    }
  }
  
  public final TXCloudVideoView bjv()
  {
    AppMethodBeat.i(354302);
    Object localObject = this.njU;
    s.s(localObject, "txLivePlayerPreview");
    localObject = (TXCloudVideoView)localObject;
    AppMethodBeat.o(354302);
    return localObject;
  }
  
  public final boolean enH()
  {
    return false;
  }
  
  public final boolean eoJ()
  {
    return true;
  }
  
  public final void ess()
  {
    AppMethodBeat.i(354309);
    this.Dkj.qT(false);
    AppMethodBeat.o(354309);
  }
  
  public final void est()
  {
    AppMethodBeat.i(354315);
    fD(true);
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    localObject = com.tencent.mm.plugin.finder.live.utils.a.euG();
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    a(this, 0, (TXLivePlayConfig)localObject, com.tencent.mm.plugin.finder.live.utils.a.a(getBuContext(), isLandscape()), false, false, (kotlin.g.a.b)cc.g.Dkn, 25);
    AppMethodBeat.o(354315);
  }
  
  public final void fD(boolean paramBoolean)
  {
    AppMethodBeat.i(354295);
    Log.i(this.TAG, s.X("stopPlay, type:", Integer.valueOf(this.streamType)));
    com.tencent.mm.live.core.core.f.d locald = getLiveCore();
    if (locald != null) {
      locald.fO(paramBoolean);
    }
    AppMethodBeat.o(354295);
  }
  
  public final com.tencent.mm.live.core.core.f.d getLiveCore()
  {
    AppMethodBeat.i(354288);
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.n(((com.tencent.mm.plugin.finder.live.view.a)this.CTj).getBuContext()))
    {
      localObject = aj.CGT;
      localObject = aj.getLiveCore();
      if ((localObject instanceof com.tencent.mm.live.core.core.e.a)) {}
      for (localObject = (com.tencent.mm.live.core.core.e.a)localObject;; localObject = null)
      {
        localObject = (com.tencent.mm.live.core.core.f.d)localObject;
        AppMethodBeat.o(354288);
        return localObject;
      }
    }
    localObject = com.tencent.mm.live.core.core.f.a.mUf;
    localObject = (com.tencent.mm.live.core.core.f.d)a.a.hH(getData().Ebr.liveId);
    AppMethodBeat.o(354288);
    return localObject;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(354337);
    s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      this.Dkj.a(paramc);
      AppMethodBeat.o(354337);
      return;
      fD(true);
      long l = getData().Ebr.mIH;
      paramBundle = g.CCu;
      paramBundle = g.nV(l);
      if (paramBundle != null)
      {
        paramBundle.ejn();
        continue;
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eet)
        {
          this.njU.setBackgroundColor(-16777216);
          continue;
          l = getData().Ebr.mIH;
          Object localObject = g.CCu;
          localObject = g.nW(l);
          int i;
          label197:
          int j;
          if (paramBundle != null)
          {
            i = paramBundle.getInt("EVT_PARAM1", 0);
            if (paramBundle == null) {
              break label403;
            }
            j = paramBundle.getInt("EVT_PARAM2", 0);
            label211:
            if ((i == 0) || (j == 0)) {
              break label409;
            }
          }
          label403:
          label409:
          for (float f = i * 1.0F / j;; f = 0.0F)
          {
            if ((localObject instanceof com.tencent.mm.plugin.finder.live.fluent.e))
            {
              paramBundle = ((com.tencent.mm.plugin.finder.live.fluent.e)localObject).ejq();
              if (paramBundle != null) {
                paramBundle.videoWidth = i;
              }
              paramBundle = ((com.tencent.mm.plugin.finder.live.fluent.e)localObject).ejq();
              if (paramBundle != null) {
                paramBundle.videoHeight = j;
              }
              paramBundle = ((com.tencent.mm.plugin.finder.live.fluent.e)localObject).ejq();
              if (paramBundle != null) {
                paramBundle.hKI = f;
              }
              Log.i(this.TAG, "change director liveParamsLength videoWidth: " + i + " videoHeight: " + j + " videoRatioWH: " + f + ' ');
            }
            paramBundle = getLiveCore();
            if (paramBundle != null) {
              paramBundle.videoWidth = i;
            }
            paramBundle = getLiveCore();
            if (paramBundle != null) {
              paramBundle.videoHeight = j;
            }
            paramBundle = getLiveCore();
            if (paramBundle != null) {
              paramBundle.hKI = f;
            }
            esu();
            break;
            i = 0;
            break label197;
            j = 0;
            break label211;
          }
          Log.i(this.TAG, "statusChange " + paramc + ", stream_status = video");
          paramBundle = getLiveCore();
          if ((paramBundle instanceof com.tencent.mm.live.core.core.f.a)) {}
          for (paramBundle = (com.tencent.mm.live.core.core.f.a)paramBundle;; paramBundle = null)
          {
            if (paramBundle != null) {
              paramBundle.bfA();
            }
            if (this.mJe.getVisibility() == 0) {
              break;
            }
            tO(0);
            break;
          }
          Log.i(this.TAG, "statusChange " + paramc + ", stream_status = bgm");
          paramBundle = getLiveCore();
          if ((paramBundle instanceof com.tencent.mm.live.core.core.f.a)) {}
          for (paramBundle = (com.tencent.mm.live.core.core.f.a)paramBundle;; paramBundle = null)
          {
            if (paramBundle != null) {
              paramBundle.bC((List)((n)business(n.class)).Ehj);
            }
            if (this.mJe.getVisibility() == 8) {
              break;
            }
            tO(8);
            break;
          }
          Log.i(this.TAG, "hide player");
          this.mJe.animate().cancel();
          this.mJe.animate().alpha(0.0F).setDuration(250L).start();
          continue;
          Log.i(this.TAG, "show player");
          this.mJe.animate().cancel();
          this.mJe.animate().alpha(1.0F).setDuration(250L).start();
        }
      }
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(354364);
    super.tO(paramInt);
    AppMethodBeat.o(354364);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(354375);
    com.tencent.mm.plugin.finder.live.olympic.widget.b localb = this.Dkj;
    localb.CSH.removeOnLayoutChangeListener(localb.CSP);
    localb.CSJ = false;
    localb.CSK = false;
    localb.maskView.setAlpha(0.0F);
    Object localObject = localb.CSH.getParent();
    if ((localObject instanceof RCRelativeLayout)) {}
    for (localObject = (RCRelativeLayout)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((RCRelativeLayout)localObject).setRadius(0.0F);
      }
      localb.doE();
      super.unMount();
      AppMethodBeat.o(354375);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTXLivePlayerPlugin$LivePlayerParams;", "", "player", "Lcom/tencent/mm/live/core/core/player/ILivePlayer;", "view", "Lcom/tencent/mm/live/core/view/LiveVideoView;", "(Lcom/tencent/mm/live/core/core/player/ILivePlayer;Lcom/tencent/mm/live/core/view/LiveVideoView;)V", "getPlayer", "()Lcom/tencent/mm/live/core/core/player/ILivePlayer;", "getView", "()Lcom/tencent/mm/live/core/view/LiveVideoView;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    final LiveVideoView Dkk;
    final com.tencent.mm.live.core.core.c.b mUm;
    
    public a(com.tencent.mm.live.core.core.c.b paramb, LiveVideoView paramLiveVideoView)
    {
      this.mUm = paramb;
      this.Dkk = paramLiveVideoView;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(355449);
      if (this == paramObject)
      {
        AppMethodBeat.o(355449);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(355449);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(this.mUm, paramObject.mUm))
      {
        AppMethodBeat.o(355449);
        return false;
      }
      if (!s.p(this.Dkk, paramObject.Dkk))
      {
        AppMethodBeat.o(355449);
        return false;
      }
      AppMethodBeat.o(355449);
      return true;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(355438);
      int i;
      if (this.mUm == null)
      {
        i = 0;
        if (this.Dkk != null) {
          break label46;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(355438);
        return i * 31 + j;
        i = this.mUm.hashCode();
        break;
        label46:
        j = this.Dkk.hashCode();
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(355429);
      String str = "LivePlayerParams(player=" + this.mUm + ", view=" + this.Dkk + ')';
      AppMethodBeat.o(355429);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(cc paramcc, k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(cc paramcc, k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveTXLivePlayerPlugin$getOrCreateLivePlayer$genDefaultLivePlayerParams$player$1", "Lcom/tencent/mm/live/core/core/visitor/ILiveSwitchStreamCallback;", "switchStream", "", "url", "", "ret", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements com.tencent.mm.live.core.core.f.b
  {
    public final void ay(String paramString, int paramInt)
    {
      AppMethodBeat.i(355295);
      s.u(paramString, "url");
      com.tencent.mm.ae.d.B((kotlin.g.a.a)new cc.e.a(paramString, paramInt));
      AppMethodBeat.o(355295);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cc
 * JD-Core Version:    0.7.0.1
 */