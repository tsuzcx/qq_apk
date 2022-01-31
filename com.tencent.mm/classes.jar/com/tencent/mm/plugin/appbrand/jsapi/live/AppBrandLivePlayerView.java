package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class AppBrandLivePlayerView
  extends TXCloudVideoView
{
  boolean bGw;
  k hNq;
  a hNr;
  private AppBrandLivePlayerView.c hNs;
  int hNt;
  private AppBrandLivePlayerView.b hNu;
  
  public AppBrandLivePlayerView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(96048);
    init(paramContext);
    AppMethodBeat.o(96048);
  }
  
  public AppBrandLivePlayerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(96049);
    init(paramContext);
    AppMethodBeat.o(96049);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(96054);
    this.hNq = new k(paramContext);
    AppMethodBeat.o(96054);
  }
  
  public final boolean Cd(String paramString)
  {
    AppMethodBeat.i(96050);
    paramString = this.hNq.Ce(paramString);
    ab.i("MicroMsg.AppBrandLivePlayerView", "onOperate code:%d info:%s", new Object[] { Integer.valueOf(paramString.errorCode), paramString.bFT });
    if (paramString.errorCode == 0)
    {
      AppMethodBeat.o(96050);
      return true;
    }
    AppMethodBeat.o(96050);
    return false;
  }
  
  final void eg(boolean paramBoolean)
  {
    AppMethodBeat.i(96053);
    if ((this.bGw) && (this.hNs != null)) {
      this.hNs.k(paramBoolean, this.hNt);
    }
    AppMethodBeat.o(96053);
  }
  
  public final void fx(int paramInt)
  {
    AppMethodBeat.i(96052);
    Object localObject = this.hNq;
    ab.i("TXLivePlayerJSAdapter", "enterBackground");
    if (((paramInt == 2) && (!((k)localObject).bGf)) || ((paramInt == 1) && (!((k)localObject).bGe)))
    {
      ((k)localObject).bGp = false;
      localObject = new i();
    }
    for (;;)
    {
      ab.i("MicroMsg.AppBrandLivePlayerView", "onBackground code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject).errorCode), ((i)localObject).bFT });
      AppMethodBeat.o(96052);
      return;
      ((k)localObject).bGp = ((k)localObject).bGk.isPlaying();
      if (((k)localObject).bGp)
      {
        if ((((k)localObject).bGw) && (((k)localObject).bGl != null)) {
          ((k)localObject).bGl.onPlayEvent(6000, new Bundle());
        }
        localObject = ((k)localObject).Ce("pause");
      }
      else
      {
        localObject = new i();
      }
    }
  }
  
  public final void onExit()
  {
    AppMethodBeat.i(96051);
    Object localObject = this.hNq;
    if (!((k)localObject).mInited) {}
    for (localObject = new i(-3, "uninited livePlayer");; localObject = new i())
    {
      ab.i("MicroMsg.AppBrandLivePlayerView", "onDestroy code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject).errorCode), ((i)localObject).bFT });
      if (this.hNu != null) {
        this.hNu.aDi();
      }
      AppMethodBeat.o(96051);
      return;
      ((k)localObject).bGk.stopPlay(true);
      ((k)localObject).bGk.setPlayListener(null);
      ((k)localObject).mInited = false;
    }
  }
  
  public void setExitListener(AppBrandLivePlayerView.b paramb)
  {
    this.hNu = paramb;
  }
  
  public void setFullScreenDelegate(a parama)
  {
    this.hNr = parama;
  }
  
  public void setNeedEvent(boolean paramBoolean)
  {
    this.bGw = paramBoolean;
  }
  
  public void setOnFullScreenChangeListener(AppBrandLivePlayerView.c paramc)
  {
    this.hNs = paramc;
  }
  
  public void setPlayEventListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    this.hNq.bGl = paramITXLivePlayListener;
  }
  
  public void setSnapshotListener(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.hNq.bGm = paramITXSnapshotListener;
  }
  
  public static abstract interface a
  {
    public abstract void aDh();
    
    public abstract boolean isFullScreen();
    
    public abstract void oc(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView
 * JD-Core Version:    0.7.0.1
 */