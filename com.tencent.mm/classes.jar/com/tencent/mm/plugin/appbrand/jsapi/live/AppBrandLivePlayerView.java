package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class AppBrandLivePlayerView
  extends TXCloudVideoView
{
  l grW;
  AppBrandLivePlayerView.a grX;
  private AppBrandLivePlayerView.c grY;
  int grZ;
  boolean gsa;
  private AppBrandLivePlayerView.b gsb;
  
  public AppBrandLivePlayerView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public AppBrandLivePlayerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.grW = new l(paramContext);
  }
  
  final void dd(boolean paramBoolean)
  {
    if ((this.gsa) && (this.grY != null)) {
      this.grY.f(paramBoolean, this.grZ);
    }
  }
  
  public final void rX()
  {
    Object localObject = this.grW;
    if (!((l)localObject).mInited) {}
    for (localObject = new j(-3, "uninited livePlayer");; localObject = new j())
    {
      y.i("MicroMsg.AppBrandLivePlayerView", "onDestroy code:%d info:%s", new Object[] { Integer.valueOf(((j)localObject).errorCode), ((j)localObject).gst });
      if (this.gsb != null) {
        this.gsb.aja();
      }
      return;
      ((l)localObject).gsx.stopPlay(true);
      ((l)localObject).gsx.setPlayListener(null);
      ((l)localObject).mInited = false;
    }
  }
  
  public void setExitListener(AppBrandLivePlayerView.b paramb)
  {
    this.gsb = paramb;
  }
  
  public void setFullScreenDelegate(AppBrandLivePlayerView.a parama)
  {
    this.grX = parama;
  }
  
  public void setNeedEvent(boolean paramBoolean)
  {
    this.gsa = paramBoolean;
  }
  
  public void setOnFullScreenChangeListener(AppBrandLivePlayerView.c paramc)
  {
    this.grY = paramc;
  }
  
  public void setPlayEventListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    this.grW.gsy = paramITXLivePlayListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView
 * JD-Core Version:    0.7.0.1
 */