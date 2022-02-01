package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.graphics.SurfaceTexture;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView;", "", "getSameLayerSurfaceHeight", "", "getSameLayerSurfaceWidth", "setLogicSurfaceSize", "", "surfaceWidth", "surfaceHeight", "setSameLayerSurfaceSize", "setSurfaceTexture", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "ISameLayerScaleOpenVoiceView", "SameLayerCallback", "cloudvoice_release"})
public abstract interface d
{
  public abstract void fN(int paramInt1, int paramInt2);
  
  public abstract void fO(int paramInt1, int paramInt2);
  
  public abstract void setSurfaceTexture(SurfaceTexture paramSurfaceTexture);
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView$ISameLayerScaleOpenVoiceView;", "", "setSameLayerCallback", "", "callback", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView$SameLayerCallback;", "cloudvoice_release"})
  public static abstract interface a
  {
    public abstract void setSameLayerCallback(d.b paramb);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView$SameLayerCallback;", "", "onVideoSizeChanged", "", "width", "", "height", "cloudvoice_release"})
  public static abstract interface b
  {
    public abstract void eO(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.d
 * JD-Core Version:    0.7.0.1
 */