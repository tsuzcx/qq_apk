package com.tencent.mm.plugin.appbrand.game.f.a;

import android.opengl.EGLContext;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.j.a;
import com.tencent.mm.media.widget.camerarecordview.preview.c;
import kotlin.ah;
import kotlin.g.a.b;

public abstract interface e
  extends c
{
  public abstract a getAbsSurfaceRenderer();
  
  public abstract EGLContext getEGLContext();
  
  public abstract int getPreviewTextureId();
  
  public abstract int getSurfaceHeight();
  
  public abstract int getSurfaceWidth();
  
  public abstract boolean isAvailable();
  
  public abstract void setOnSurfaceTextureAvailableDelegate(a parama);
  
  public abstract void setOnTextureDrawFinishDelegate(b<d, ah> paramb);
  
  public abstract void setPreviewRenderer(a parama);
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.a.e
 * JD-Core Version:    0.7.0.1
 */