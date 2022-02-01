package com.tencent.mm.live.c;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.d;
import com.tencent.mm.live.core.core.d.b.a;
import com.tencent.mm.live.core.view.LiveVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveTXLivePlayerPlygin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "curPlayerStatus", "", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "streamType", "txLivePlayer", "Lcom/tencent/rtmp/TXLivePlayer;", "txLivePlayerPreview", "Lcom/tencent/mm/live/core/view/LiveVideoView;", "kotlin.jvm.PlatformType", "getPlayer", "getPlayerView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "isCdnPlayerDisconnect", "", "pausePlayer", "", "resumePlayer", "setPreviewClickListener", "listener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "setRenderRotation", "rotation", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "setupSecondaryDeviceConfig", "core", "startPlay", "Lcom/tencent/rtmp/TXLivePlayConfig;", "renderMode", "action", "Lkotlin/Function1;", "success", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopPlay", "keepLastFrame", "unMount", "plugin-logic_release"})
public final class aw
  extends a
{
  private final String TAG;
  public int hCl;
  private final b hOp;
  public final LiveVideoView hSD;
  public TXLivePlayer hwO;
  public com.tencent.mm.live.core.core.d.b liveCore;
  private int streamType;
  
  public aw(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(208177);
    this.hOp = paramb;
    this.TAG = "MicroMsg.LiveTXLivePlayerPlygin";
    this.hSD = ((LiveVideoView)paramViewGroup.findViewById(2131303598));
    paramViewGroup.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(208177);
  }
  
  public final TXCloudVideoView aHJ()
  {
    AppMethodBeat.i(208174);
    Object localObject = this.hSD;
    p.g(localObject, "txLivePlayerPreview");
    localObject = (TXCloudVideoView)localObject;
    AppMethodBeat.o(208174);
    return localObject;
  }
  
  public final void aHy()
  {
    AppMethodBeat.i(208173);
    b.a locala = com.tencent.mm.live.core.core.d.b.hCo;
    this.hwr.getContext();
    this.liveCore = b.a.aEf();
    AppMethodBeat.o(208173);
  }
  
  public final void ev(boolean paramBoolean)
  {
    AppMethodBeat.i(208172);
    Log.i(this.TAG, "stopPlay, type:" + this.streamType);
    if (this.liveCore != null)
    {
      d.ev(paramBoolean);
      AppMethodBeat.o(208172);
      return;
    }
    AppMethodBeat.o(208172);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(208175);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (ax.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(208175);
      return;
      ev(true);
      AppMethodBeat.o(208175);
      return;
      if (!(this.liveCore instanceof com.tencent.mm.live.core.core.c.a)) {
        ev(true);
      }
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(208176);
    super.unMount();
    AppMethodBeat.o(208176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.aw
 * JD-Core Version:    0.7.0.1
 */