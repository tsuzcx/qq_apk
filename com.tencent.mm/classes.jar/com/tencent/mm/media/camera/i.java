package com.tencent.mm.media.camera;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/ICameraKitEnvExport;", "", "bindSurface", "", "surface", "Landroid/view/Surface;", "width", "", "height", "(Landroid/view/Surface;Ljava/lang/Integer;Ljava/lang/Integer;)V", "bindSurfaceTexture", "texture", "Landroid/graphics/SurfaceTexture;", "(Landroid/graphics/SurfaceTexture;Ljava/lang/Integer;Ljava/lang/Integer;)V", "destroyGLEnv", "unbindSurface", "updateScreenSize", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface i
{
  public abstract void a(SurfaceTexture paramSurfaceTexture, Integer paramInteger1, Integer paramInteger2);
  
  public abstract void a(Surface paramSurface, Integer paramInteger1, Integer paramInteger2);
  
  public abstract void bnK();
  
  public abstract void ep(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.camera.i
 * JD-Core Version:    0.7.0.1
 */