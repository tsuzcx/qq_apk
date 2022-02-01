package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.WXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import org.json.JSONObject;

public class AppBrandLivePlayerView
  extends TXCloudVideoView
{
  boolean ctl;
  private b kSA;
  l kSw;
  a kSx;
  private AppBrandLivePlayerView.c kSy;
  int kSz;
  
  public AppBrandLivePlayerView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(145822);
    init(paramContext);
    AppMethodBeat.o(145822);
  }
  
  public AppBrandLivePlayerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(145823);
    init(paramContext);
    AppMethodBeat.o(145823);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(145828);
    this.kSw = new l(paramContext);
    AppMethodBeat.o(145828);
  }
  
  public final boolean g(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145824);
    paramString = this.kSw.h(paramString, paramJSONObject);
    ae.i("MicroMsg.AppBrandLivePlayerView", "onOperate code:%d info:%s", new Object[] { Integer.valueOf(paramString.errorCode), paramString.csi });
    if (paramString.errorCode == 0)
    {
      AppMethodBeat.o(145824);
      return true;
    }
    AppMethodBeat.o(145824);
    return false;
  }
  
  public final void gF(int paramInt)
  {
    AppMethodBeat.i(145826);
    Object localObject = this.kSw;
    ae.i("TXLivePlayerJSAdapter", "enterBackground");
    if (((paramInt == 2) && (!((l)localObject).csw)) || ((paramInt == 1) && (!((l)localObject).csv)))
    {
      ((l)localObject).kSW = false;
      localObject = new i();
    }
    for (;;)
    {
      ae.i("MicroMsg.AppBrandLivePlayerView", "onBackground code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject).errorCode), ((i)localObject).csi });
      AppMethodBeat.o(145826);
      return;
      ((l)localObject).kSW = ((l)localObject).ctb.isPlaying();
      if (((l)localObject).kSW)
      {
        if ((((l)localObject).ctl) && (((l)localObject).ctc != null)) {
          ((l)localObject).ctc.onPlayEvent(6000, new Bundle());
        }
        localObject = ((l)localObject).h("pause", null);
      }
      else
      {
        localObject = new i();
      }
    }
  }
  
  final void gw(boolean paramBoolean)
  {
    AppMethodBeat.i(145827);
    if ((this.ctl) && (this.kSy != null)) {
      this.kSy.p(paramBoolean, this.kSz);
    }
    AppMethodBeat.o(145827);
  }
  
  public final void onExit()
  {
    AppMethodBeat.i(145825);
    Object localObject = this.kSw;
    if (!((l)localObject).mInited) {}
    for (localObject = new i(-3, "uninited livePlayer");; localObject = new i())
    {
      ae.i("MicroMsg.AppBrandLivePlayerView", "onDestroy code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject).errorCode), ((i)localObject).csi });
      if (this.kSA != null) {
        this.kSA.blq();
      }
      AppMethodBeat.o(145825);
      return;
      ((l)localObject).ctb.stopPlay(true);
      ((l)localObject).ctb.setPlayListener(null);
      ((l)localObject).mInited = false;
    }
  }
  
  public void setAudioVolumeEventListener(TXLivePlayer.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.kSw.mAudioVolumeListener = paramITXAudioVolumeEvaluationListener;
  }
  
  public void setExitListener(b paramb)
  {
    this.kSA = paramb;
  }
  
  public void setFullScreenDelegate(a parama)
  {
    this.kSx = parama;
  }
  
  public void setNeedEvent(boolean paramBoolean)
  {
    this.ctl = paramBoolean;
  }
  
  public void setOnFullScreenChangeListener(AppBrandLivePlayerView.c paramc)
  {
    this.kSy = paramc;
  }
  
  public void setPlayEventListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    this.kSw.ctc = paramITXLivePlayListener;
  }
  
  public void setSnapshotListener(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.kSw.ctd = paramITXSnapshotListener;
  }
  
  public static abstract interface a
  {
    public abstract void blp();
    
    public abstract boolean isFullScreen();
    
    public abstract void th(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void blq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView
 * JD-Core Version:    0.7.0.1
 */