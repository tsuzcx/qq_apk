package com.tencent.mm.live.c;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.d;
import com.tencent.mm.live.view.LiveVideoView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/LiveTXLivePlayerPlygin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/rtmp/ITXLivePlayListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "curPlayerStatus", "", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "streamType", "txLivePlayer", "Lcom/tencent/rtmp/TXLivePlayer;", "txLivePlayerPreview", "Lcom/tencent/mm/live/view/LiveVideoView;", "kotlin.jvm.PlatformType", "url", "getPlayer", "getPlayerView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "isCdnPlayerDisconnect", "", "onNetStatus", "", "params", "Landroid/os/Bundle;", "onPlayEvent", "event", "pausePlayer", "resumePlayer", "setPreviewClickListener", "listener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "startPlay", "action", "Lkotlin/Function1;", "success", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "stopPlay", "keepLastFrame", "unMount", "plugin-logic_release"})
public final class aw
  extends a
  implements ITXLivePlayListener
{
  private final String TAG;
  public TXLivePlayer gMP;
  private final b gSM;
  public final LiveVideoView gWV;
  public com.tencent.mm.live.core.core.trtc.a gWW;
  public int gWX;
  private int streamType;
  private String url;
  
  public aw(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(212590);
    this.gSM = paramb;
    this.TAG = "MicroMsg.LiveTXLivePlayerPlygin";
    this.gWV = ((LiveVideoView)paramViewGroup.findViewById(2131307810));
    this.url = "";
    paramb = d.gMQ;
    Object localObject = paramViewGroup.getContext();
    p.g(localObject, "root.context");
    paramb = (ITXLivePlayListener)this;
    p.h(localObject, "context");
    p.h(paramb, "playListener");
    if (d.amS() == null)
    {
      d.a(new TXLivePlayer((Context)localObject));
      localObject = new TXLivePlayConfig();
      ((TXLivePlayConfig)localObject).setAutoAdjustCacheTime(true);
      ((TXLivePlayConfig)localObject).setMinAutoAdjustCacheTime(1.0F);
      ((TXLivePlayConfig)localObject).setMaxAutoAdjustCacheTime(1.0F);
      TXLivePlayer localTXLivePlayer = d.amS();
      if (localTXLivePlayer != null) {
        localTXLivePlayer.setPlayListener(paramb);
      }
      paramb = d.amS();
      if (paramb != null) {
        paramb.setConfig((TXLivePlayConfig)localObject);
      }
      paramb = d.amS();
      if (paramb != null) {
        paramb.setRenderMode(1);
      }
    }
    this.gMP = d.amS();
    paramViewGroup.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(212590);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(212586);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (ax.cpQ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(212586);
      return;
      aoV();
      nI(8);
    }
  }
  
  public final void aoA()
  {
    AppMethodBeat.i(212589);
    super.aoA();
    AppMethodBeat.o(212589);
  }
  
  public final void aoV()
  {
    AppMethodBeat.i(212584);
    ad.i(this.TAG, "stopPlay " + this.url + ", type:" + this.streamType);
    Object localObject = d.gMQ;
    ad.i(d.access$getTAG$cp(), "stopPlay");
    localObject = d.amS();
    if (localObject != null) {
      ((TXLivePlayer)localObject).stopPlay(false);
    }
    localObject = d.amS();
    if (localObject != null) {
      ((TXLivePlayer)localObject).setPlayListener(null);
    }
    d.a(null);
    AppMethodBeat.o(212584);
  }
  
  public final TXCloudVideoView aoW()
  {
    AppMethodBeat.i(212585);
    Object localObject = this.gWV;
    p.g(localObject, "txLivePlayerPreview");
    localObject = (TXCloudVideoView)localObject;
    AppMethodBeat.o(212585);
    return localObject;
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(212588);
    int i = ay.getNetType(this.gGK.getContext());
    paramBundle = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onNetStatus curPlayStatus:").append(this.gWX).append(", netQuality:").append(i).append(", isPlaying:");
    TXLivePlayer localTXLivePlayer = this.gMP;
    if ((localTXLivePlayer != null) && (localTXLivePlayer.isPlaying() == true)) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i(paramBundle, bool);
      paramBundle = this.gMP;
      if (paramBundle == null) {
        break;
      }
      if ((paramBundle.isPlaying() == true) && (i != -1) && (this.gWX == -2301))
      {
        paramBundle = this.gMP;
        if (paramBundle != null) {
          paramBundle.stopPlay(false);
        }
        paramBundle = this.gMP;
        if (paramBundle != null) {
          paramBundle.startPlay(this.url, this.streamType);
        }
        b.b.a(this.gSM, b.c.gRu);
      }
      AppMethodBeat.o(212588);
      return;
    }
    AppMethodBeat.o(212588);
  }
  
  public final void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(212587);
    paramBundle = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onPlayEvent:").append(paramInt).append(", isPlaying:");
    TXLivePlayer localTXLivePlayer = this.gMP;
    boolean bool;
    if ((localTXLivePlayer != null) && (localTXLivePlayer.isPlaying() == true))
    {
      bool = true;
      ad.i(paramBundle, bool);
      paramBundle = this.gMP;
      if (paramBundle == null) {
        break label144;
      }
      if (paramBundle.isPlaying() == true)
      {
        this.gWX = paramInt;
        switch (paramInt)
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(212587);
      return;
      bool = false;
      break;
      label144:
      AppMethodBeat.o(212587);
      return;
      b.b.a(this.gSM, b.c.gSh);
      AppMethodBeat.o(212587);
      return;
      if (ay.getNetType(this.gGK.getContext()) == -1)
      {
        b.b.a(this.gSM, b.c.gSf);
        AppMethodBeat.o(212587);
        return;
        paramBundle = this.gMP;
        if (paramBundle != null) {
          paramBundle.stopPlay(false);
        }
        if (ay.getNetType(this.gGK.getContext()) == -1) {
          b.b.a(this.gSM, b.c.gSg);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.aw
 * JD-Core Version:    0.7.0.1
 */