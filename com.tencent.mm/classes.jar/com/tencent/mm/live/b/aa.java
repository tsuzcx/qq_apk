package com.tencent.mm.live.b;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.core.core.f.d;
import com.tencent.mm.live.core.view.LiveVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/LiveTXLivePlayerPlygin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "curPlayerStatus", "", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "streamType", "txLivePlayer", "Lcom/tencent/mm/live/core/core/player/ILivePlayer;", "txLivePlayerPreview", "Lcom/tencent/mm/live/core/view/LiveVideoView;", "kotlin.jvm.PlatformType", "getPlayer", "getPlayerView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "isCdnPlayerDisconnect", "", "pausePlayer", "", "resumePlayer", "setPreviewClickListener", "listener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "setRenderRotation", "rotation", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "setupSecondaryDeviceConfig", "core", "startPlay", "Lcom/tencent/rtmp/TXLivePlayConfig;", "renderMode", "action", "Lkotlin/Function1;", "success", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopPlay", "keepLastFrame", "unMount", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
  extends a
{
  private final String TAG;
  public d liveCore;
  public com.tencent.mm.live.core.core.c.b mJG;
  public int mUo;
  private final b nfT;
  public final LiveVideoView njU;
  private int streamType;
  
  public aa(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247375);
    this.nfT = paramb;
    this.TAG = "MicroMsg.LiveTXLivePlayerPlygin";
    this.njU = ((LiveVideoView)paramViewGroup.findViewById(b.e.live_tx_live_player_preview));
    paramViewGroup.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(247375);
  }
  
  public final TXCloudVideoView bjv()
  {
    AppMethodBeat.i(247402);
    Object localObject = this.njU;
    s.s(localObject, "txLivePlayerPreview");
    localObject = (TXCloudVideoView)localObject;
    AppMethodBeat.o(247402);
    return localObject;
  }
  
  public final void fD(boolean paramBoolean)
  {
    AppMethodBeat.i(247394);
    Log.i(this.TAG, s.X("stopPlay, type:", Integer.valueOf(this.streamType)));
    d locald = this.liveCore;
    if (locald != null) {
      locald.fO(paramBoolean);
    }
    AppMethodBeat.o(247394);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(247409);
    s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247409);
      return;
      fD(true);
      AppMethodBeat.o(247409);
      return;
      if (!(this.liveCore instanceof com.tencent.mm.live.core.core.e.a)) {
        fD(true);
      }
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(247415);
    super.unMount();
    AppMethodBeat.o(247415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.aa
 * JD-Core Version:    0.7.0.1
 */