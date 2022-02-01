package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.WXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import org.json.JSONObject;

public class AppBrandLivePlayerView
  extends TXCloudVideoView
{
  boolean cit;
  l kts;
  a ktt;
  private c ktu;
  int ktv;
  private b ktw;
  
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
    this.kts = new l(paramContext);
    AppMethodBeat.o(145828);
  }
  
  public final boolean g(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145824);
    paramString = this.kts.h(paramString, paramJSONObject);
    ac.i("MicroMsg.AppBrandLivePlayerView", "onOperate code:%d info:%s", new Object[] { Integer.valueOf(paramString.errorCode), paramString.chn });
    if (paramString.errorCode == 0)
    {
      AppMethodBeat.o(145824);
      return true;
    }
    AppMethodBeat.o(145824);
    return false;
  }
  
  final void gr(boolean paramBoolean)
  {
    AppMethodBeat.i(145827);
    if ((this.cit) && (this.ktu != null)) {
      this.ktu.p(paramBoolean, this.ktv);
    }
    AppMethodBeat.o(145827);
  }
  
  public final void gz(int paramInt)
  {
    AppMethodBeat.i(145826);
    Object localObject = this.kts;
    ac.i("TXLivePlayerJSAdapter", "enterBackground");
    if (((paramInt == 2) && (!((l)localObject).chB)) || ((paramInt == 1) && (!((l)localObject).chA)))
    {
      ((l)localObject).ktS = false;
      localObject = new i();
    }
    for (;;)
    {
      ac.i("MicroMsg.AppBrandLivePlayerView", "onBackground code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject).errorCode), ((i)localObject).chn });
      AppMethodBeat.o(145826);
      return;
      ((l)localObject).ktS = ((l)localObject).cij.isPlaying();
      if (((l)localObject).ktS)
      {
        if ((((l)localObject).cit) && (((l)localObject).cik != null)) {
          ((l)localObject).cik.onPlayEvent(6000, new Bundle());
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
    Object localObject = this.kts;
    if (!((l)localObject).mInited) {}
    for (localObject = new i(-3, "uninited livePlayer");; localObject = new i())
    {
      ac.i("MicroMsg.AppBrandLivePlayerView", "onDestroy code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject).errorCode), ((i)localObject).chn });
      if (this.ktw != null) {
        this.ktw.bhb();
      }
      AppMethodBeat.o(145825);
      return;
      ((l)localObject).cij.stopPlay(true);
      ((l)localObject).cij.setPlayListener(null);
      ((l)localObject).mInited = false;
    }
  }
  
  public void setAudioVolumeEventListener(TXLivePlayer.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.kts.mAudioVolumeListener = paramITXAudioVolumeEvaluationListener;
  }
  
  public void setExitListener(b paramb)
  {
    this.ktw = paramb;
  }
  
  public void setFullScreenDelegate(a parama)
  {
    this.ktt = parama;
  }
  
  public void setNeedEvent(boolean paramBoolean)
  {
    this.cit = paramBoolean;
  }
  
  public void setOnFullScreenChangeListener(c paramc)
  {
    this.ktu = paramc;
  }
  
  public void setPlayEventListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    this.kts.cik = paramITXLivePlayListener;
  }
  
  public void setSnapshotListener(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.kts.cil = paramITXSnapshotListener;
  }
  
  public static abstract interface a
  {
    public abstract void bha();
    
    public abstract boolean isFullScreen();
    
    public abstract void sC(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void bhb();
  }
  
  public static abstract interface c
  {
    public abstract void p(boolean paramBoolean, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView
 * JD-Core Version:    0.7.0.1
 */