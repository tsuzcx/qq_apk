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
  boolean clr;
  l jSG;
  AppBrandLivePlayerView.a jSH;
  private AppBrandLivePlayerView.c jSI;
  int jSJ;
  private b jSK;
  
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
    this.jSG = new l(paramContext);
    AppMethodBeat.o(145828);
  }
  
  final void fV(boolean paramBoolean)
  {
    AppMethodBeat.i(145827);
    if ((this.clr) && (this.jSI != null)) {
      this.jSI.o(paramBoolean, this.jSJ);
    }
    AppMethodBeat.o(145827);
  }
  
  public final boolean g(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145824);
    paramString = this.jSG.h(paramString, paramJSONObject);
    ad.i("MicroMsg.AppBrandLivePlayerView", "onOperate code:%d info:%s", new Object[] { Integer.valueOf(paramString.errorCode), paramString.cko });
    if (paramString.errorCode == 0)
    {
      AppMethodBeat.o(145824);
      return true;
    }
    AppMethodBeat.o(145824);
    return false;
  }
  
  public final void gP(int paramInt)
  {
    AppMethodBeat.i(145826);
    Object localObject = this.jSG;
    ad.i("TXLivePlayerJSAdapter", "enterBackground");
    if (((paramInt == 2) && (!((l)localObject).ckC)) || ((paramInt == 1) && (!((l)localObject).ckB)))
    {
      ((l)localObject).jTg = false;
      localObject = new i();
    }
    for (;;)
    {
      ad.i("MicroMsg.AppBrandLivePlayerView", "onBackground code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject).errorCode), ((i)localObject).cko });
      AppMethodBeat.o(145826);
      return;
      ((l)localObject).jTg = ((l)localObject).clh.isPlaying();
      if (((l)localObject).jTg)
      {
        if ((((l)localObject).clr) && (((l)localObject).cli != null)) {
          ((l)localObject).cli.onPlayEvent(6000, new Bundle());
        }
        localObject = ((l)localObject).h("pause", null);
      }
      else
      {
        localObject = new i();
      }
    }
  }
  
  public final void onExit()
  {
    AppMethodBeat.i(145825);
    Object localObject = this.jSG;
    if (!((l)localObject).mInited) {}
    for (localObject = new i(-3, "uninited livePlayer");; localObject = new i())
    {
      ad.i("MicroMsg.AppBrandLivePlayerView", "onDestroy code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject).errorCode), ((i)localObject).cko });
      if (this.jSK != null) {
        this.jSK.bai();
      }
      AppMethodBeat.o(145825);
      return;
      ((l)localObject).clh.stopPlay(true);
      ((l)localObject).clh.setPlayListener(null);
      ((l)localObject).mInited = false;
    }
  }
  
  public void setAudioVolumeEventListener(TXLivePlayer.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.jSG.mAudioVolumeListener = paramITXAudioVolumeEvaluationListener;
  }
  
  public void setExitListener(b paramb)
  {
    this.jSK = paramb;
  }
  
  public void setFullScreenDelegate(AppBrandLivePlayerView.a parama)
  {
    this.jSH = parama;
  }
  
  public void setNeedEvent(boolean paramBoolean)
  {
    this.clr = paramBoolean;
  }
  
  public void setOnFullScreenChangeListener(AppBrandLivePlayerView.c paramc)
  {
    this.jSI = paramc;
  }
  
  public void setPlayEventListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    this.jSG.cli = paramITXLivePlayListener;
  }
  
  public void setSnapshotListener(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.jSG.clj = paramITXSnapshotListener;
  }
  
  public static abstract interface b
  {
    public abstract void bai();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView
 * JD-Core Version:    0.7.0.1
 */