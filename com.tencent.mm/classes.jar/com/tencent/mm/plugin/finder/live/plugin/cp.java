package com.tencent.mm.plugin.finder.live.plugin;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.core.core.c.a.a;
import com.tencent.mm.live.core.core.c.c;
import com.tencent.mm.live.core.view.LiveVideoView;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.viewmodel.data.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTXLivePlayerPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "curPlayerStatus", "", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "streamType", "txLivePlayer", "Lcom/tencent/rtmp/TXLivePlayer;", "txLivePlayerPreview", "Lcom/tencent/mm/live/core/view/LiveVideoView;", "kotlin.jvm.PlatformType", "getPlayer", "getPlayerView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "isCdnPlayerDisconnect", "", "pausePlayer", "", "resumePlayer", "setMute", "mute", "setPreviewClickListener", "listener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "setRenderRotation", "rotation", "startPlay", "config", "Lcom/tencent/rtmp/TXLivePlayConfig;", "renderMode", "action", "Lkotlin/Function1;", "success", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopPlay", "keepLastFrame", "plugin-finder_release"})
public final class cp
  extends d
{
  private final String TAG;
  private final b kCL;
  private final LiveVideoView kHa;
  public TXLivePlayer kjc;
  private int streamType;
  
  public cp(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(275880);
    this.kCL = paramb;
    this.TAG = "MicroMsg.FinderLiveTXLivePlayerPlugin";
    this.kHa = ((LiveVideoView)paramViewGroup.findViewById(b.e.live_tx_live_player_preview));
    paramViewGroup.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(275880);
  }
  
  private final c getLiveCore()
  {
    AppMethodBeat.i(275874);
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    localObject = this.yld;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout");
      AppMethodBeat.o(275874);
      throw ((Throwable)localObject);
    }
    if (com.tencent.mm.plugin.finder.live.utils.a.k(((com.tencent.mm.plugin.finder.live.view.a)localObject).getBuContext()))
    {
      localObject = ah.yhC;
      com.tencent.mm.live.core.core.trtc.a locala = ah.getLiveCore();
      localObject = locala;
      if (!(locala instanceof com.tencent.mm.live.core.core.b.a)) {
        localObject = null;
      }
      localObject = (c)localObject;
      AppMethodBeat.o(275874);
      return localObject;
    }
    localObject = com.tencent.mm.live.core.core.c.a.kqk;
    localObject = (c)a.a.FC(getData().zey.getLiveId());
    AppMethodBeat.o(275874);
    return localObject;
  }
  
  public final TXCloudVideoView aPH()
  {
    AppMethodBeat.i(275877);
    Object localObject = this.kHa;
    p.j(localObject, "txLivePlayerPreview");
    localObject = (TXCloudVideoView)localObject;
    AppMethodBeat.o(275877);
    return localObject;
  }
  
  public final void eT(boolean paramBoolean)
  {
    AppMethodBeat.i(275876);
    Log.i(this.TAG, "stopPlay, type:" + this.streamType);
    c localc = getLiveCore();
    if (localc != null)
    {
      localc.fi(paramBoolean);
      AppMethodBeat.o(275876);
      return;
    }
    AppMethodBeat.o(275876);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(275878);
    TXLivePlayer localTXLivePlayer = this.kjc;
    if (localTXLivePlayer != null) {
      localTXLivePlayer.setMute(paramBoolean);
    }
    Log.i(this.TAG, "txLivePlayer:" + this.kjc + ", mute:" + paramBoolean);
    AppMethodBeat.o(275878);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(275879);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (cq.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(275879);
      return;
      eT(true);
      AppMethodBeat.o(275879);
      return;
      if (!(getLiveCore() instanceof com.tencent.mm.live.core.core.b.a)) {
        eT(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cp
 * JD-Core Version:    0.7.0.1
 */