package com.tencent.mm.live.c;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.d;
import com.tencent.mm.live.view.LiveVideoView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LiveTXLivePlayerPlygin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/rtmp/ITXLivePlayListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "curPlayerStatus", "", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "streamType", "txLivePlayer", "Lcom/tencent/rtmp/TXLivePlayer;", "txLivePlayerPreview", "Lcom/tencent/mm/live/view/LiveVideoView;", "kotlin.jvm.PlatformType", "url", "getPlayer", "getPlayerView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "isCdnPlayerDisconnect", "", "onNetStatus", "", "params", "Landroid/os/Bundle;", "onPlayEvent", "event", "pausePlayer", "resumePlayer", "setPreviewClickListener", "listener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "startPlay", "action", "Lkotlin/Function1;", "success", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "stopPlay", "keepLastFrame", "unMount", "plugin-logic_release"})
public final class aw
  extends a
  implements ITXLivePlayListener
{
  private final String TAG;
  public final LiveVideoView gDl;
  public com.tencent.mm.live.core.core.trtc.a gDm;
  public int gDn;
  public TXLivePlayer gte;
  private final b gzb;
  private int streamType;
  private String url;
  
  public aw(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(190300);
    this.gzb = paramb;
    this.TAG = "MicroMsg.LiveTXLivePlayerPlygin";
    this.gDl = ((LiveVideoView)paramViewGroup.findViewById(2131307810));
    this.url = "";
    paramb = d.gtf;
    Object localObject = paramViewGroup.getContext();
    k.g(localObject, "root.context");
    paramb = (ITXLivePlayListener)this;
    k.h(localObject, "context");
    k.h(paramb, "playListener");
    if (d.akg() == null)
    {
      d.a(new TXLivePlayer((Context)localObject));
      localObject = new TXLivePlayConfig();
      ((TXLivePlayConfig)localObject).setAutoAdjustCacheTime(true);
      ((TXLivePlayConfig)localObject).setMinAutoAdjustCacheTime(1.0F);
      ((TXLivePlayConfig)localObject).setMaxAutoAdjustCacheTime(1.0F);
      TXLivePlayer localTXLivePlayer = d.akg();
      if (localTXLivePlayer != null) {
        localTXLivePlayer.setPlayListener(paramb);
      }
      paramb = d.akg();
      if (paramb != null) {
        paramb.setConfig((TXLivePlayConfig)localObject);
      }
      paramb = d.akg();
      if (paramb != null) {
        paramb.setRenderMode(1);
      }
    }
    this.gte = d.akg();
    paramViewGroup.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(190300);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(190296);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (ax.cfA[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(190296);
      return;
      ami();
      nj(8);
    }
  }
  
  public final void alN()
  {
    AppMethodBeat.i(190299);
    super.alN();
    AppMethodBeat.o(190299);
  }
  
  public final void ami()
  {
    AppMethodBeat.i(190294);
    ac.i(this.TAG, "stopPlay " + this.url + ", type:" + this.streamType);
    Object localObject = d.gtf;
    ac.i(d.access$getTAG$cp(), "stopPlay");
    localObject = d.akg();
    if (localObject != null) {
      ((TXLivePlayer)localObject).stopPlay(false);
    }
    localObject = d.akg();
    if (localObject != null) {
      ((TXLivePlayer)localObject).setPlayListener(null);
    }
    d.a(null);
    AppMethodBeat.o(190294);
  }
  
  public final TXCloudVideoView amj()
  {
    AppMethodBeat.i(190295);
    Object localObject = this.gDl;
    k.g(localObject, "txLivePlayerPreview");
    localObject = (TXCloudVideoView)localObject;
    AppMethodBeat.o(190295);
    return localObject;
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(190298);
    int i = ax.getNetType(this.gnb.getContext());
    paramBundle = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onNetStatus curPlayStatus:").append(this.gDn).append(", netQuality:").append(i).append(", isPlaying:");
    TXLivePlayer localTXLivePlayer = this.gte;
    if ((localTXLivePlayer != null) && (localTXLivePlayer.isPlaying() == true)) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i(paramBundle, bool);
      paramBundle = this.gte;
      if (paramBundle == null) {
        break;
      }
      if ((paramBundle.isPlaying() == true) && (i != -1) && (this.gDn == -2301))
      {
        paramBundle = this.gte;
        if (paramBundle != null) {
          paramBundle.stopPlay(false);
        }
        paramBundle = this.gte;
        if (paramBundle != null) {
          paramBundle.startPlay(this.url, this.streamType);
        }
        b.b.a(this.gzb, b.c.gxJ);
      }
      AppMethodBeat.o(190298);
      return;
    }
    AppMethodBeat.o(190298);
  }
  
  public final void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(190297);
    paramBundle = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onPlayEvent:").append(paramInt).append(", isPlaying:");
    TXLivePlayer localTXLivePlayer = this.gte;
    boolean bool;
    if ((localTXLivePlayer != null) && (localTXLivePlayer.isPlaying() == true))
    {
      bool = true;
      ac.i(paramBundle, bool);
      paramBundle = this.gte;
      if (paramBundle == null) {
        break label144;
      }
      if (paramBundle.isPlaying() == true)
      {
        this.gDn = paramInt;
        switch (paramInt)
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(190297);
      return;
      bool = false;
      break;
      label144:
      AppMethodBeat.o(190297);
      return;
      b.b.a(this.gzb, b.c.gyw);
      AppMethodBeat.o(190297);
      return;
      if (ax.getNetType(this.gnb.getContext()) == -1)
      {
        b.b.a(this.gzb, b.c.gyu);
        AppMethodBeat.o(190297);
        return;
        paramBundle = this.gte;
        if (paramBundle != null) {
          paramBundle.stopPlay(false);
        }
        if (ax.getNetType(this.gnb.getContext()) == -1) {
          b.b.a(this.gzb, b.c.gyv);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.aw
 * JD-Core Version:    0.7.0.1
 */