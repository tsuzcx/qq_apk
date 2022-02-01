package com.tencent.mm.media.camera.view;

import android.view.Surface;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/view/ICameraAdvancedUsage;", "Lcom/tencent/mm/media/camera/view/ICameraUsage;", "setCustomRenderTarget", "", "surface", "Landroid/view/Surface;", "width", "", "height", "(Landroid/view/Surface;Ljava/lang/Integer;Ljava/lang/Integer;)V", "setScreenRenderTarget", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
  extends d
{
  public abstract void b(Surface paramSurface, Integer paramInteger1, Integer paramInteger2);
  
  public abstract void box();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.camera.view.b
 * JD-Core Version:    0.7.0.1
 */