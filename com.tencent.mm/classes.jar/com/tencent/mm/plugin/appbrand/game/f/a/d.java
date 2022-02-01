package com.tencent.mm.plugin.appbrand.game.f.a;

import android.opengl.EGLContext;
import com.tencent.mm.media.j.a;
import com.tencent.mm.media.widget.camerarecordview.preview.f;
import d.g.a.b;
import d.z;

public abstract interface d
  extends f
{
  public abstract a getAbsSurfaceRenderer();
  
  public abstract EGLContext getEGLContext();
  
  public abstract int getPreviewTextureId();
  
  public abstract int getSurfaceHeight();
  
  public abstract int getSurfaceWidth();
  
  public abstract boolean isAvailable();
  
  public abstract void setOnSurfaceTextureAvailableDelegate(a parama);
  
  public abstract void setOnTextureDrawFinishDelegate(b<com.tencent.mm.media.g.d, z> paramb);
  
  public abstract void setPreviewRenderer(a parama);
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.a.d
 * JD-Core Version:    0.7.0.1
 */