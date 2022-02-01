package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.WXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import org.json.JSONObject;

public class AppBrandLivePlayerView
  extends TXCloudVideoView
{
  boolean cFE;
  l lXC;
  AppBrandLivePlayerView.a lXD;
  private AppBrandLivePlayerView.c lXE;
  int lXF;
  private b lXG;
  
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
    this.lXC = new l(paramContext);
    AppMethodBeat.o(145828);
  }
  
  public final void hU(int paramInt)
  {
    AppMethodBeat.i(145826);
    Object localObject = this.lXC;
    Log.i("TXLivePlayerJSAdapter", "enterBackground");
    if (((paramInt == 2) && (!((l)localObject).cEL)) || ((paramInt == 1) && (!((l)localObject).cEK)))
    {
      ((l)localObject).lYb = false;
      localObject = new i();
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrandLivePlayerView", "onBackground code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject).errorCode), ((i)localObject).errorInfo });
      AppMethodBeat.o(145826);
      return;
      ((l)localObject).lYb = ((l)localObject).cFu.isPlaying();
      if (((l)localObject).lYb)
      {
        if ((((l)localObject).cFE) && (((l)localObject).cFv != null)) {
          ((l)localObject).cFv.onPlayEvent(6000, new Bundle());
        }
        localObject = ((l)localObject).k("pause", null);
      }
      else
      {
        localObject = new i();
      }
    }
  }
  
  final void ht(boolean paramBoolean)
  {
    AppMethodBeat.i(145827);
    if ((this.cFE) && (this.lXE != null)) {
      this.lXE.n(paramBoolean, this.lXF);
    }
    AppMethodBeat.o(145827);
  }
  
  public final boolean j(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145824);
    paramString = this.lXC.k(paramString, paramJSONObject);
    Log.i("MicroMsg.AppBrandLivePlayerView", "onOperate code:%d info:%s", new Object[] { Integer.valueOf(paramString.errorCode), paramString.errorInfo });
    if (paramString.errorCode == 0)
    {
      AppMethodBeat.o(145824);
      return true;
    }
    AppMethodBeat.o(145824);
    return false;
  }
  
  public final void onExit()
  {
    AppMethodBeat.i(145825);
    Object localObject = this.lXC;
    if (!((l)localObject).mInited) {}
    for (localObject = new i(-3, "uninited livePlayer");; localObject = new i())
    {
      Log.i("MicroMsg.AppBrandLivePlayerView", "onDestroy code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject).errorCode), ((i)localObject).errorInfo });
      if (this.lXG != null) {
        this.lXG.bGM();
      }
      AppMethodBeat.o(145825);
      return;
      ((l)localObject).cFu.stopPlay(true);
      ((l)localObject).cFu.setPlayListener(null);
      ((l)localObject).mInited = false;
    }
  }
  
  public void setAudioVolumeEventListener(TXLivePlayer.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.lXC.mAudioVolumeListener = paramITXAudioVolumeEvaluationListener;
  }
  
  public void setExitListener(b paramb)
  {
    this.lXG = paramb;
  }
  
  public void setFullScreenDelegate(AppBrandLivePlayerView.a parama)
  {
    this.lXD = parama;
  }
  
  public void setNeedEvent(boolean paramBoolean)
  {
    this.cFE = paramBoolean;
  }
  
  public void setOnFullScreenChangeListener(AppBrandLivePlayerView.c paramc)
  {
    this.lXE = paramc;
  }
  
  public void setPlayEventListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    this.lXC.cFv = paramITXLivePlayListener;
  }
  
  public void setSnapshotListener(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.lXC.cFw = paramITXSnapshotListener;
  }
  
  public static abstract interface b
  {
    public abstract void bGM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView
 * JD-Core Version:    0.7.0.1
 */