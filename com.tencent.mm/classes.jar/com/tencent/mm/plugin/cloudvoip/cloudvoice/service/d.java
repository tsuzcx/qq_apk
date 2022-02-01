package com.tencent.mm.plugin.cloudvoip.cloudvoice.service;

import android.graphics.SurfaceTexture;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView;", "", "getSameLayerSurfaceHeight", "", "getSameLayerSurfaceWidth", "setLogicSurfaceSize", "", "surfaceWidth", "surfaceHeight", "setSameLayerSurfaceSize", "setSurfaceTexture", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "ISameLayerScaleOpenVoiceView", "SameLayerCallback", "cloudvoice_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface d
{
  public abstract void gE(int paramInt1, int paramInt2);
  
  public abstract void gF(int paramInt1, int paramInt2);
  
  public abstract void setSurfaceTexture(SurfaceTexture paramSurfaceTexture);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView$ISameLayerScaleOpenVoiceView;", "", "setSameLayerCallback", "", "callback", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView$SameLayerCallback;", "cloudvoice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void setSameLayerCallback(d.b paramb);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView$SameLayerCallback;", "", "onVideoSizeChanged", "", "width", "", "height", "cloudvoice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void fH(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.service.d
 * JD-Core Version:    0.7.0.1
 */