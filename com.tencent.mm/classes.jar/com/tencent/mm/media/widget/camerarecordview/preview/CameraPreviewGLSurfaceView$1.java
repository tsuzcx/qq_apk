package com.tencent.mm.media.widget.camerarecordview.preview;

import a.f.a.b;
import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.Buffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView$1", "Landroid/opengl/GLSurfaceView$Renderer;", "onDrawFrame", "", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "plugin-mediaeditor_release"})
public final class CameraPreviewGLSurfaceView$1
  implements GLSurfaceView.Renderer
{
  public final void onDrawFrame(GL10 paramGL10)
  {
    AppMethodBeat.i(13268);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = CameraPreviewGLSurfaceView.a(this.fbC);
    if (locala != null)
    {
      Object localObject = locala.eWh;
      if (localObject != null) {
        ((com.tencent.mm.media.h.a)localObject).onDrawFrame(paramGL10);
      }
      if (locala.fbO)
      {
        locala.fbO = false;
        locala.eYy = IntBuffer.allocate(locala.eYm * locala.eYl);
        paramGL10 = locala.eYy;
        if (paramGL10 == null) {
          j.ebi();
        }
        paramGL10.position(0);
        GLES20.glReadPixels(0, 0, locala.eYl, locala.eYm, 6408, 5121, (Buffer)locala.eYy);
        paramGL10 = Bitmap.createBitmap(locala.eYl, locala.eYm, Bitmap.Config.ARGB_8888);
        paramGL10.copyPixelsFromBuffer((Buffer)locala.eYy);
        localObject = new Matrix();
        ((Matrix)localObject).preScale(-1.0F, 1.0F);
        ((Matrix)localObject).preRotate(180.0F);
        localObject = Bitmap.createBitmap(paramGL10, 0, 0, locala.eYl, locala.eYm, (Matrix)localObject, false);
        paramGL10.recycle();
        paramGL10 = locala.fbP;
        if (paramGL10 != null)
        {
          j.p(localObject, "bmp");
          paramGL10.S(localObject);
          AppMethodBeat.o(13268);
          return;
        }
      }
      AppMethodBeat.o(13268);
      return;
    }
    AppMethodBeat.o(13268);
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13269);
    ab.b("MicroMsg.CameraPreviewGLSurfaceView", "onSurfaceChanged width:" + paramInt1 + " height:" + paramInt2, new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = CameraPreviewGLSurfaceView.a(this.fbC);
    if (locala != null)
    {
      int i = CameraPreviewGLSurfaceView.b(this.fbC);
      paramGL10 = (a.f.a.a)new CameraPreviewGLSurfaceView.1.a(this, paramGL10, paramInt1, paramInt2);
      locala.fbQ.e((a.f.a.a)new a.a(locala, paramGL10, i));
      AppMethodBeat.o(13269);
      return;
    }
    AppMethodBeat.o(13269);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(13270);
    ab.b("MicroMsg.CameraPreviewGLSurfaceView", "onSurfaceCreated", new Object[0]);
    Object localObject = CameraPreviewGLSurfaceView.a(this.fbC);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).eWh;
      if (localObject != null)
      {
        ((com.tencent.mm.media.h.a)localObject).onSurfaceCreated(paramGL10, paramEGLConfig);
        AppMethodBeat.o(13270);
        return;
      }
      AppMethodBeat.o(13270);
      return;
    }
    AppMethodBeat.o(13270);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView.1
 * JD-Core Version:    0.7.0.1
 */