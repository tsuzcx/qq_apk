package com.tencent.mm.media.camera.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.camera.i;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/view/CameraKitSurfaceView;", "Landroid/view/SurfaceView;", "Landroid/view/SurfaceHolder$Callback;", "Lcom/tencent/mm/media/camera/view/ICameraKitView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cameraKit", "Lcom/tencent/mm/media/camera/ICameraKitEnvExport;", "texture", "Landroid/view/Surface;", "viewHeight", "", "viewWidth", "setCameraKitEnv", "", "kit", "surfaceChanged", "holder", "Landroid/view/SurfaceHolder;", "format", "width", "height", "surfaceCreated", "surfaceDestroyed", "Companion", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CameraKitSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback, c
{
  public static final CameraKitSurfaceView.a nwD;
  private int mbM;
  private int mbN;
  private i nwE;
  private Surface nwF;
  
  static
  {
    AppMethodBeat.i(237238);
    nwD = new CameraKitSurfaceView.a((byte)0);
    AppMethodBeat.o(237238);
  }
  
  public CameraKitSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(237232);
    getHolder().addCallback((SurfaceHolder.Callback)this);
    try
    {
      getHolder().setType(2);
      Log.i("MicroMsg.Camera.CameraKitSurfaceView", "CameraKitSurfaceView create");
      AppMethodBeat.o(237232);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        try
        {
          getHolder().setType(1);
        }
        catch (Exception paramContext)
        {
          try
          {
            getHolder().setType(0);
          }
          catch (Exception paramContext) {}
        }
      }
    }
  }
  
  public final void setCameraKitEnv(i parami)
  {
    AppMethodBeat.i(237249);
    this.nwE = parami;
    parami = this.nwF;
    if (parami != null)
    {
      i locali = this.nwE;
      if (locali != null) {
        locali.a(parami, Integer.valueOf(this.mbM), Integer.valueOf(this.mbN));
      }
    }
    AppMethodBeat.o(237249);
  }
  
  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(237267);
    s.u(paramSurfaceHolder, "holder");
    Log.i("MicroMsg.Camera.CameraKitSurfaceView", "[" + hashCode() + "]surfaceChanged width:" + paramInt2 + " height:" + paramInt3);
    paramSurfaceHolder = this.nwE;
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder.ep(paramInt2, paramInt3);
    }
    this.mbM = paramInt2;
    this.mbN = paramInt3;
    setBackgroundColor(0);
    AppMethodBeat.o(237267);
  }
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(237258);
    s.u(paramSurfaceHolder, "holder");
    Log.i("MicroMsg.Camera.CameraKitSurfaceView", "[" + hashCode() + "]surfaceCreated");
    i locali = this.nwE;
    if (locali != null)
    {
      Surface localSurface = paramSurfaceHolder.getSurface();
      s.s(localSurface, "holder.surface");
      locali.a(localSurface, null, null);
    }
    this.nwF = paramSurfaceHolder.getSurface();
    AppMethodBeat.o(237258);
  }
  
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(237270);
    s.u(paramSurfaceHolder, "holder");
    Log.i("MicroMsg.Camera.CameraKitSurfaceView", "[" + hashCode() + "]surfaceDestroyed");
    paramSurfaceHolder = this.nwE;
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder.bnK();
    }
    this.nwF = null;
    this.mbM = 0;
    this.mbN = 0;
    setBackgroundColor(-16777216);
    AppMethodBeat.o(237270);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.camera.view.CameraKitSurfaceView
 * JD-Core Version:    0.7.0.1
 */