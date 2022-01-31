package com.tencent.luggage.m.a;

import android.graphics.SurfaceTexture;
import org.xwalk.core.XWalkExtendPluginClient;
import org.xwalk.core.XWalkView;

public final class e
  extends XWalkExtendPluginClient
{
  public a bkf;
  
  public e(XWalkView paramXWalkView)
  {
    super(paramXWalkView);
  }
  
  public final void onPluginDestroy(String paramString, int paramInt)
  {
    super.onPluginDestroy(paramString, paramInt);
    if (this.bkf != null) {
      this.bkf.onPluginDestroy(paramString, paramInt);
    }
  }
  
  public final void onPluginReady(String paramString, int paramInt, SurfaceTexture paramSurfaceTexture)
  {
    super.onPluginReady(paramString, paramInt, paramSurfaceTexture);
    if (this.bkf != null) {
      this.bkf.onPluginReady(paramString, paramInt, paramSurfaceTexture);
    }
  }
  
  public final void setPluginTextureScale(String paramString, int paramInt, float paramFloat1, float paramFloat2)
  {
    super.setPluginTextureScale(paramString, paramInt, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.m.a.e
 * JD-Core Version:    0.7.0.1
 */