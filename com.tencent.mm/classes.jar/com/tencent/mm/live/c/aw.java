package com.tencent.mm.live.c;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.d;
import com.tencent.mm.plugin.mmsight.model.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveTXLivePlayerPlygin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/rtmp/ITXLivePlayListener;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "curPlayerStatus", "", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "streamType", "txLivePlayer", "Lcom/tencent/rtmp/TXLivePlayer;", "txLivePlayerPreview", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "kotlin.jvm.PlatformType", "url", "getPlayer", "getPlayerView", "isCdnPlayerDisconnect", "", "mount", "", "onNetStatus", "params", "Landroid/os/Bundle;", "onOrientationChange", "orientation", "onPlayEvent", "event", "pausePlayer", "resumePlayer", "setPreviewClickListener", "listener", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "startPlay", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "stopPlay", "keepLastFrame", "unMount", "plugin-logic_release"})
public final class aw
  extends a
  implements d.a, ITXLivePlayListener
{
  private final b IIs;
  public final TXCloudVideoView KwQ;
  public final TXLivePlayer KwR;
  public com.tencent.mm.live.core.core.trtc.a KwS;
  public int KwT;
  private final String TAG;
  private int streamType;
  private d tKW;
  private String url;
  
  public aw(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(203065);
    this.IIs = paramb;
    this.TAG = "MicroMsg.LiveTXLivePlayerPlygin";
    this.KwQ = ((TXCloudVideoView)paramViewGroup.findViewById(2131307729));
    this.KwR = new TXLivePlayer(paramViewGroup.getContext());
    this.url = "";
    paramb = new TXLivePlayConfig();
    paramb.setAutoAdjustCacheTime(true);
    paramb.setMinAutoAdjustCacheTime(1.0F);
    paramb.setMaxAutoAdjustCacheTime(1.0F);
    this.KwR.setPlayerView(this.KwQ);
    this.KwR.setPlayListener((ITXLivePlayListener)this);
    this.KwR.setConfig(paramb);
    this.KwR.setRenderMode(1);
    this.tKW = new d(paramViewGroup.getContext(), (byte)0);
    paramViewGroup.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(203065);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(203059);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (ax.ciE[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(203059);
      return;
      this.KwR.stopPlay(false);
      agK(8);
    }
  }
  
  public final void fOM()
  {
    AppMethodBeat.i(203062);
    super.fOM();
    d locald = this.tKW;
    if (locald != null) {
      locald.a((d.a)this);
    }
    locald = this.tKW;
    if (locald != null)
    {
      locald.enable();
      AppMethodBeat.o(203062);
      return;
    }
    AppMethodBeat.o(203062);
  }
  
  public final void fON()
  {
    AppMethodBeat.i(203063);
    super.fON();
    this.KwR.setPlayListener(null);
    d locald = this.tKW;
    if (locald != null) {
      locald.a(null);
    }
    locald = this.tKW;
    if (locald != null)
    {
      locald.disable();
      AppMethodBeat.o(203063);
      return;
    }
    AppMethodBeat.o(203063);
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(203061);
    int i = ay.getNetType(this.pTc.getContext());
    ad.i(this.TAG, "onNetStatus curPlayStatus:" + this.KwT + ", netQuality:" + i + ", isPlaying:" + this.KwR.isPlaying());
    if ((this.KwR.isPlaying()) && (i != -1) && (this.KwT == -2301))
    {
      this.KwR.stopPlay(false);
      this.KwR.startPlay(this.url, this.streamType);
      b.b.a(this.IIs, b.c.FAV);
    }
    AppMethodBeat.o(203061);
  }
  
  public final void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(203060);
    ad.i(this.TAG, "onPlayEvent:" + paramInt + ", isPlaying:" + this.KwR.isPlaying());
    if (this.KwR.isPlaying())
    {
      this.KwT = paramInt;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(203060);
      return;
      b.b.a(this.IIs, b.c.HRL);
      AppMethodBeat.o(203060);
      return;
      if (ay.getNetType(this.pTc.getContext()) == -1)
      {
        b.b.a(this.IIs, b.c.HRJ);
        AppMethodBeat.o(203060);
        return;
        this.KwR.stopPlay(false);
        if (ay.getNetType(this.pTc.getContext()) == -1) {
          b.b.a(this.IIs, b.c.HRK);
        }
      }
    }
  }
  
  public final void wy(int paramInt)
  {
    AppMethodBeat.i(203064);
    ad.d(this.TAG, "orientation:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(203064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.aw
 * JD-Core Version:    0.7.0.1
 */