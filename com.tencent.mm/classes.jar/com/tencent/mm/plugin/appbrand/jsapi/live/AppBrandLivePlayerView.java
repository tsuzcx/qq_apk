package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.WXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import org.json.JSONObject;

public class AppBrandLivePlayerView
  extends TXCloudVideoView
{
  boolean csI;
  l kOO;
  a kOP;
  private AppBrandLivePlayerView.c kOQ;
  int kOR;
  private b kOS;
  
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
    this.kOO = new l(paramContext);
    AppMethodBeat.o(145828);
  }
  
  public final boolean g(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145824);
    paramString = this.kOO.h(paramString, paramJSONObject);
    ad.i("MicroMsg.AppBrandLivePlayerView", "onOperate code:%d info:%s", new Object[] { Integer.valueOf(paramString.errorCode), paramString.crF });
    if (paramString.errorCode == 0)
    {
      AppMethodBeat.o(145824);
      return true;
    }
    AppMethodBeat.o(145824);
    return false;
  }
  
  public final void gE(int paramInt)
  {
    AppMethodBeat.i(145826);
    Object localObject = this.kOO;
    ad.i("TXLivePlayerJSAdapter", "enterBackground");
    if (((paramInt == 2) && (!((l)localObject).crT)) || ((paramInt == 1) && (!((l)localObject).crS)))
    {
      ((l)localObject).kPo = false;
      localObject = new i();
    }
    for (;;)
    {
      ad.i("MicroMsg.AppBrandLivePlayerView", "onBackground code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject).errorCode), ((i)localObject).crF });
      AppMethodBeat.o(145826);
      return;
      ((l)localObject).kPo = ((l)localObject).csy.isPlaying();
      if (((l)localObject).kPo)
      {
        if ((((l)localObject).csI) && (((l)localObject).csz != null)) {
          ((l)localObject).csz.onPlayEvent(6000, new Bundle());
        }
        localObject = ((l)localObject).h("pause", null);
      }
      else
      {
        localObject = new i();
      }
    }
  }
  
  final void gx(boolean paramBoolean)
  {
    AppMethodBeat.i(145827);
    if ((this.csI) && (this.kOQ != null)) {
      this.kOQ.o(paramBoolean, this.kOR);
    }
    AppMethodBeat.o(145827);
  }
  
  public final void onExit()
  {
    AppMethodBeat.i(145825);
    Object localObject = this.kOO;
    if (!((l)localObject).mInited) {}
    for (localObject = new i(-3, "uninited livePlayer");; localObject = new i())
    {
      ad.i("MicroMsg.AppBrandLivePlayerView", "onDestroy code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject).errorCode), ((i)localObject).crF });
      if (this.kOS != null) {
        this.kOS.bkG();
      }
      AppMethodBeat.o(145825);
      return;
      ((l)localObject).csy.stopPlay(true);
      ((l)localObject).csy.setPlayListener(null);
      ((l)localObject).mInited = false;
    }
  }
  
  public void setAudioVolumeEventListener(TXLivePlayer.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.kOO.mAudioVolumeListener = paramITXAudioVolumeEvaluationListener;
  }
  
  public void setExitListener(b paramb)
  {
    this.kOS = paramb;
  }
  
  public void setFullScreenDelegate(a parama)
  {
    this.kOP = parama;
  }
  
  public void setNeedEvent(boolean paramBoolean)
  {
    this.csI = paramBoolean;
  }
  
  public void setOnFullScreenChangeListener(AppBrandLivePlayerView.c paramc)
  {
    this.kOQ = paramc;
  }
  
  public void setPlayEventListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    this.kOO.csz = paramITXLivePlayListener;
  }
  
  public void setSnapshotListener(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.kOO.csA = paramITXSnapshotListener;
  }
  
  public static abstract interface a
  {
    public abstract void bkF();
    
    public abstract boolean isFullScreen();
    
    public abstract void te(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void bkG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView
 * JD-Core Version:    0.7.0.1
 */