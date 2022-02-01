package com.tencent.luggage.xweb_ext.extendplugin;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkExtendPluginClient;
import org.xwalk.core.XWalkView;

public final class c
  extends XWalkExtendPluginClient
{
  com.tencent.luggage.xweb_ext.extendplugin.b.c cqP;
  
  public c(XWalkView paramXWalkView)
  {
    super(paramXWalkView);
  }
  
  public final void onPluginDestroy(String paramString, int paramInt)
  {
    AppMethodBeat.i(138805);
    super.onPluginDestroy(paramString, paramInt);
    if (this.cqP != null) {
      this.cqP.onPluginDestroy(paramString, paramInt);
    }
    AppMethodBeat.o(138805);
  }
  
  public final void onPluginReady(String paramString, int paramInt, SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(138804);
    super.onPluginReady(paramString, paramInt, paramSurfaceTexture);
    if (this.cqP != null) {
      this.cqP.onPluginReady(paramString, paramInt, paramSurfaceTexture);
    }
    AppMethodBeat.o(138804);
  }
  
  public final void onPluginScreenshotTaken(String paramString, int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(178798);
    super.onPluginScreenshotTaken(paramString, paramInt, paramBitmap);
    if (this.cqP != null) {
      this.cqP.onPluginScreenshotTaken(paramString, paramInt, paramBitmap);
    }
    AppMethodBeat.o(178798);
  }
  
  public final void onPluginTouch(String paramString, int paramInt, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(138806);
    super.onPluginTouch(paramString, paramInt, paramMotionEvent);
    if (this.cqP != null) {
      this.cqP.onPluginTouch(paramString, paramInt, paramMotionEvent);
    }
    AppMethodBeat.o(138806);
  }
  
  public final void setPluginTextureScale(String paramString, int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(138807);
    super.setPluginTextureScale(paramString, paramInt, paramFloat1, paramFloat2);
    AppMethodBeat.o(138807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.c
 * JD-Core Version:    0.7.0.1
 */