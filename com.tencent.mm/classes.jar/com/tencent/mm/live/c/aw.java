package com.tencent.mm.live.c;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.d;
import com.tencent.mm.live.view.LiveVideoView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/LiveTXLivePlayerPlygin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/rtmp/ITXLivePlayListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "curPlayerStatus", "", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "streamType", "txLivePlayer", "Lcom/tencent/rtmp/TXLivePlayer;", "txLivePlayerPreview", "Lcom/tencent/mm/live/view/LiveVideoView;", "kotlin.jvm.PlatformType", "url", "getPlayer", "getPlayerView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "isCdnPlayerDisconnect", "", "onNetStatus", "", "params", "Landroid/os/Bundle;", "onPlayEvent", "event", "pausePlayer", "resumePlayer", "setPreviewClickListener", "listener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "startPlay", "action", "Lkotlin/Function1;", "success", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "stopPlay", "keepLastFrame", "unMount", "plugin-logic_release"})
public final class aw
  extends a
  implements ITXLivePlayListener
{
  private final String TAG;
  public TXLivePlayer gPy;
  private final b gVv;
  public final LiveVideoView gZI;
  public com.tencent.mm.live.core.core.trtc.a gZJ;
  public int gZK;
  private int streamType;
  private String url;
  
  public aw(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(216216);
    this.gVv = paramb;
    this.TAG = "MicroMsg.LiveTXLivePlayerPlygin";
    this.gZI = ((LiveVideoView)paramViewGroup.findViewById(2131307810));
    this.url = "";
    paramb = d.gPz;
    Object localObject = paramViewGroup.getContext();
    p.g(localObject, "root.context");
    paramb = (ITXLivePlayListener)this;
    p.h(localObject, "context");
    p.h(paramb, "playListener");
    if (d.anh() == null)
    {
      d.a(new TXLivePlayer((Context)localObject));
      localObject = new TXLivePlayConfig();
      ((TXLivePlayConfig)localObject).setAutoAdjustCacheTime(true);
      ((TXLivePlayConfig)localObject).setMinAutoAdjustCacheTime(1.0F);
      ((TXLivePlayConfig)localObject).setMaxAutoAdjustCacheTime(1.0F);
      TXLivePlayer localTXLivePlayer = d.anh();
      if (localTXLivePlayer != null) {
        localTXLivePlayer.setPlayListener(paramb);
      }
      paramb = d.anh();
      if (paramb != null) {
        paramb.setConfig((TXLivePlayConfig)localObject);
      }
      paramb = d.anh();
      if (paramb != null) {
        paramb.setRenderMode(1);
      }
    }
    this.gPy = d.anh();
    paramViewGroup.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(216216);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(216212);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (ax.cqt[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(216212);
      return;
      apj();
      nL(8);
    }
  }
  
  public final void aoP()
  {
    AppMethodBeat.i(216215);
    super.aoP();
    AppMethodBeat.o(216215);
  }
  
  public final void apj()
  {
    AppMethodBeat.i(216210);
    ae.i(this.TAG, "stopPlay " + this.url + ", type:" + this.streamType);
    Object localObject = d.gPz;
    ae.i(d.access$getTAG$cp(), "stopPlay");
    localObject = d.anh();
    if (localObject != null) {
      ((TXLivePlayer)localObject).stopPlay(false);
    }
    localObject = d.anh();
    if (localObject != null) {
      ((TXLivePlayer)localObject).setPlayListener(null);
    }
    d.a(null);
    AppMethodBeat.o(216210);
  }
  
  public final TXCloudVideoView apk()
  {
    AppMethodBeat.i(216211);
    Object localObject = this.gZI;
    p.g(localObject, "txLivePlayerPreview");
    localObject = (TXCloudVideoView)localObject;
    AppMethodBeat.o(216211);
    return localObject;
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(216214);
    int i = az.getNetType(this.gJt.getContext());
    paramBundle = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onNetStatus curPlayStatus:").append(this.gZK).append(", netQuality:").append(i).append(", isPlaying:");
    TXLivePlayer localTXLivePlayer = this.gPy;
    if ((localTXLivePlayer != null) && (localTXLivePlayer.isPlaying() == true)) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i(paramBundle, bool);
      paramBundle = this.gPy;
      if (paramBundle == null) {
        break;
      }
      if ((paramBundle.isPlaying() == true) && (i != -1) && (this.gZK == -2301))
      {
        paramBundle = this.gPy;
        if (paramBundle != null) {
          paramBundle.stopPlay(false);
        }
        paramBundle = this.gPy;
        if (paramBundle != null) {
          paramBundle.startPlay(this.url, this.streamType);
        }
        b.b.a(this.gVv, b.c.gUc);
      }
      AppMethodBeat.o(216214);
      return;
    }
    AppMethodBeat.o(216214);
  }
  
  public final void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(216213);
    paramBundle = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onPlayEvent:").append(paramInt).append(", isPlaying:");
    TXLivePlayer localTXLivePlayer = this.gPy;
    boolean bool;
    if ((localTXLivePlayer != null) && (localTXLivePlayer.isPlaying() == true))
    {
      bool = true;
      ae.i(paramBundle, bool);
      paramBundle = this.gPy;
      if (paramBundle == null) {
        break label144;
      }
      if (paramBundle.isPlaying() == true)
      {
        this.gZK = paramInt;
        switch (paramInt)
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(216213);
      return;
      bool = false;
      break;
      label144:
      AppMethodBeat.o(216213);
      return;
      b.b.a(this.gVv, b.c.gUP);
      AppMethodBeat.o(216213);
      return;
      if (az.getNetType(this.gJt.getContext()) == -1)
      {
        b.b.a(this.gVv, b.c.gUN);
        AppMethodBeat.o(216213);
        return;
        paramBundle = this.gPy;
        if (paramBundle != null) {
          paramBundle.stopPlay(false);
        }
        if (az.getNetType(this.gJt.getContext()) == -1) {
          b.b.a(this.gVv, b.c.gUO);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.aw
 * JD-Core Version:    0.7.0.1
 */