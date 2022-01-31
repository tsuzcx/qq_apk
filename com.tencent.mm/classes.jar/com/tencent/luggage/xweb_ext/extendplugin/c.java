package com.tencent.luggage.xweb_ext.extendplugin;

import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkExtendPluginClient;
import org.xwalk.core.XWalkView;

public final class c
  extends XWalkExtendPluginClient
{
  public com.tencent.luggage.xweb_ext.extendplugin.b.c bFS;
  
  public c(XWalkView paramXWalkView)
  {
    super(paramXWalkView);
  }
  
  public final void onPluginDestroy(String paramString, int paramInt)
  {
    AppMethodBeat.i(117327);
    super.onPluginDestroy(paramString, paramInt);
    if (this.bFS != null) {
      this.bFS.onPluginDestroy(paramString, paramInt);
    }
    AppMethodBeat.o(117327);
  }
  
  public final void onPluginReady(String paramString, int paramInt, SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(117326);
    super.onPluginReady(paramString, paramInt, paramSurfaceTexture);
    if (this.bFS != null) {
      this.bFS.onPluginReady(paramString, paramInt, paramSurfaceTexture);
    }
    AppMethodBeat.o(117326);
  }
  
  public final void onPluginTouch(String paramString, int paramInt, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(117328);
    super.onPluginTouch(paramString, paramInt, paramMotionEvent);
    if (this.bFS != null) {
      this.bFS.onPluginTouch(paramString, paramInt, paramMotionEvent);
    }
    AppMethodBeat.o(117328);
  }
  
  public final void setPluginTextureScale(String paramString, int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(117329);
    super.setPluginTextureScale(paramString, paramInt, paramFloat1, paramFloat2);
    AppMethodBeat.o(117329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.c
 * JD-Core Version:    0.7.0.1
 */