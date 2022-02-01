package com.tencent.mm.live.c;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.core.core.c.c;
import com.tencent.mm.live.core.view.LiveVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveTXLivePlayerPlygin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "curPlayerStatus", "", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "streamType", "txLivePlayer", "Lcom/tencent/rtmp/TXLivePlayer;", "txLivePlayerPreview", "Lcom/tencent/mm/live/core/view/LiveVideoView;", "kotlin.jvm.PlatformType", "getPlayer", "getPlayerView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "isCdnPlayerDisconnect", "", "pausePlayer", "", "resumePlayer", "setPreviewClickListener", "listener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "setRenderRotation", "rotation", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "setupSecondaryDeviceConfig", "core", "startPlay", "Lcom/tencent/rtmp/TXLivePlayConfig;", "renderMode", "action", "Lkotlin/Function1;", "success", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopPlay", "keepLastFrame", "unMount", "plugin-logic_release"})
public final class aw
  extends a
{
  private final String TAG;
  private final b kCL;
  public final LiveVideoView kHa;
  public TXLivePlayer kjc;
  public int kqn;
  public c liveCore;
  private int streamType;
  
  public aw(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(192182);
    this.kCL = paramb;
    this.TAG = "MicroMsg.LiveTXLivePlayerPlygin";
    this.kHa = ((LiveVideoView)paramViewGroup.findViewById(b.e.live_tx_live_player_preview));
    paramViewGroup.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(192182);
  }
  
  public final TXCloudVideoView aPH()
  {
    AppMethodBeat.i(192170);
    Object localObject = this.kHa;
    p.j(localObject, "txLivePlayerPreview");
    localObject = (TXCloudVideoView)localObject;
    AppMethodBeat.o(192170);
    return localObject;
  }
  
  public final void eT(boolean paramBoolean)
  {
    AppMethodBeat.i(192165);
    Log.i(this.TAG, "stopPlay, type:" + this.streamType);
    c localc = this.liveCore;
    if (localc != null)
    {
      localc.fi(paramBoolean);
      AppMethodBeat.o(192165);
      return;
    }
    AppMethodBeat.o(192165);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(192174);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (ax.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(192174);
      return;
      eT(true);
      AppMethodBeat.o(192174);
      return;
      if (!(this.liveCore instanceof com.tencent.mm.live.core.core.b.a)) {
        eT(true);
      }
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(192176);
    super.unMount();
    AppMethodBeat.o(192176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.aw
 * JD-Core Version:    0.7.0.1
 */