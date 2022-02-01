package com.tencent.mm.media.camera.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.camera.i;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/view/CameraKitTextureView;", "Landroid/view/TextureView;", "Lcom/tencent/mm/media/camera/view/ICameraKitView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cameraKit", "Lcom/tencent/mm/media/camera/ICameraKitEnvExport;", "texture", "Landroid/graphics/SurfaceTexture;", "viewHeight", "", "viewWidth", "onSurfaceTextureAvailable", "", "surface", "width", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "setCameraKitEnv", "kit", "Companion", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CameraKitTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener, c
{
  public static final CameraKitTextureView.a nwG;
  private int mbM;
  private int mbN;
  private i nwE;
  private SurfaceTexture nwH;
  
  static
  {
    AppMethodBeat.i(237203);
    nwG = new CameraKitTextureView.a((byte)0);
    AppMethodBeat.o(237203);
  }
  
  public CameraKitTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(237198);
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    AppMethodBeat.o(237198);
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237212);
    s.u(paramSurfaceTexture, "surface");
    Log.i("MicroMsg.Camera.CameraKitTextureView", "[" + hashCode() + "]onSurfaceTextureAvailable");
    i locali = this.nwE;
    if (locali != null) {
      locali.a(paramSurfaceTexture, null, null);
    }
    locali = this.nwE;
    if (locali != null) {
      locali.ep(paramInt1, paramInt2);
    }
    this.nwH = paramSurfaceTexture;
    this.mbM = paramInt1;
    this.mbN = paramInt2;
    AppMethodBeat.o(237212);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(237222);
    s.u(paramSurfaceTexture, "surface");
    Log.i("MicroMsg.Camera.CameraKitTextureView", "[" + hashCode() + "]onSurfaceTextureDestroyed");
    paramSurfaceTexture = this.nwE;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.bnK();
    }
    this.nwH = null;
    this.mbM = 0;
    this.mbN = 0;
    AppMethodBeat.o(237222);
    return true;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237219);
    s.u(paramSurfaceTexture, "surface");
    Log.i("MicroMsg.Camera.CameraKitTextureView", "[" + hashCode() + "]onSurfaceTextureSizeChanged");
    paramSurfaceTexture = this.nwE;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.ep(paramInt1, paramInt2);
    }
    this.mbM = paramInt1;
    this.mbN = paramInt2;
    AppMethodBeat.o(237219);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(237228);
    s.u(paramSurfaceTexture, "surface");
    AppMethodBeat.o(237228);
  }
  
  public final void setCameraKitEnv(i parami)
  {
    AppMethodBeat.i(237208);
    this.nwE = parami;
    parami = this.nwH;
    if (parami != null)
    {
      i locali = this.nwE;
      if (locali != null) {
        locali.a(parami, Integer.valueOf(this.mbM), Integer.valueOf(this.mbN));
      }
    }
    AppMethodBeat.o(237208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.camera.view.CameraKitTextureView
 * JD-Core Version:    0.7.0.1
 */