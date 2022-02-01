package com.tencent.mm.media.widget.camerarecordview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.media.widget.camerarecordview.preview.a.b;
import com.tencent.mm.media.widget.camerarecordview.preview.a.c;
import com.tencent.mm.media.widget.camerarecordview.preview.a.d;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewRenderView;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "mContext", "Landroid/content/Context;", "surface", "Landroid/view/Surface;", "mWidth", "", "mHeight", "(Landroid/content/Context;Landroid/view/Surface;II)V", "TAG", "", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "getMHeight", "()I", "setMHeight", "(I)V", "getMWidth", "setMWidth", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureRender;", "clearFrame", "", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "queueEvent", "r", "Lkotlin/Function0;", "release", "requestRender", "setOnDrawListener", "frameAvailableListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "texture", "setPreviewRenderer", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "cpuCrop", "", "tryCameraPreview", "callback", "Landroid/graphics/SurfaceTexture;", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends CameraPreviewGLSurfaceView
{
  private String TAG;
  private Context mContext;
  private int mHeight;
  private int mWidth;
  private com.tencent.mm.media.widget.camerarecordview.preview.a nJB;
  private Surface surface;
  
  public b(Context paramContext, Surface paramSurface, int paramInt1, int paramInt2)
  {
    super(paramContext, null);
    AppMethodBeat.i(237624);
    this.mContext = paramContext;
    this.surface = paramSurface;
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.TAG = "MicroMsg.CameraPreviewSurfaceRenderView";
    this.nJB = new com.tencent.mm.media.widget.camerarecordview.preview.a();
    AppMethodBeat.o(237624);
  }
  
  public final void H(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(94252);
    s.u(parama, "r");
    com.tencent.mm.media.widget.camerarecordview.preview.a locala = this.nJB;
    if (locala != null) {
      locala.H(parama);
    }
    AppMethodBeat.o(94252);
  }
  
  public final void a(com.tencent.mm.media.j.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(94256);
    s.u(parama, "renderer");
    Object localObject = this.nJB;
    if (localObject != null) {
      ((com.tencent.mm.media.widget.camerarecordview.preview.a)localObject).a(parama, false);
    }
    parama = this.nJB;
    int i;
    int j;
    if (parama != null)
    {
      localObject = this.surface;
      i = this.mWidth;
      j = this.mHeight;
      Log.i("MicroMsg.CameraPreviewGLTextureRender", "onSurfaceAvailable, surface:" + localObject + ", width:" + i + ", height:" + j + ", handler: " + parama.nBk);
      if (parama.nBk == null) {
        parama.buk();
      }
      if (localObject != null) {
        parama.H((kotlin.g.a.a)new a.b(parama, i, j, (Surface)localObject));
      }
    }
    parama = this.nJB;
    if (parama != null)
    {
      localObject = this.surface;
      i = this.mWidth;
      j = this.mHeight;
      Log.i("MicroMsg.CameraPreviewGLTextureRender", "onSurfaceSizeChanged, surface:" + localObject + ", width:" + i + ", height:" + j);
      parama.H((kotlin.g.a.a)new a.d(parama, i, j));
    }
    AppMethodBeat.o(94256);
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    AppMethodBeat.i(94253);
    s.u(paramb, "cameraConfig");
    Log.printInfoStack(this.TAG, s.X("updateCameraConfig:", paramb), new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a locala = this.nJB;
    if (locala != null) {
      locala.a(paramb);
    }
    AppMethodBeat.o(94253);
  }
  
  public final void bgw()
  {
    AppMethodBeat.i(94255);
    Log.printInfoStack(this.TAG, "tryStopCameraPreview", new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a locala = this.nJB;
    if (locala != null) {
      locala.bgw();
    }
    AppMethodBeat.o(94255);
  }
  
  public final void bgx()
  {
    AppMethodBeat.i(94261);
    com.tencent.mm.media.widget.camerarecordview.preview.a locala = this.nJB;
    if (locala != null) {
      locala.bgx();
    }
    AppMethodBeat.o(94261);
  }
  
  public final EGLContext getEGLContext()
  {
    AppMethodBeat.i(94257);
    Object localObject = this.nJB;
    if (localObject == null)
    {
      AppMethodBeat.o(94257);
      return null;
    }
    localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a)localObject).getEGLContext();
    AppMethodBeat.o(94257);
    return localObject;
  }
  
  public final g getFrameDataCallback()
  {
    AppMethodBeat.i(94260);
    Object localObject = this.nJB;
    if (localObject == null)
    {
      AppMethodBeat.o(94260);
      return null;
    }
    localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a)localObject).getFrameDataCallback();
    AppMethodBeat.o(94260);
    return localObject;
  }
  
  public final Context getMContext()
  {
    return this.mContext;
  }
  
  public final int getMHeight()
  {
    return this.mHeight;
  }
  
  public final int getMWidth()
  {
    return this.mWidth;
  }
  
  public final d getPreviewTexture()
  {
    AppMethodBeat.i(237659);
    Object localObject = this.nJB;
    if (localObject == null)
    {
      AppMethodBeat.o(237659);
      return null;
    }
    localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a)localObject).getPreviewTexture();
    AppMethodBeat.o(237659);
    return localObject;
  }
  
  public final Surface getSurface()
  {
    return this.surface;
  }
  
  public final void release()
  {
    AppMethodBeat.i(94262);
    com.tencent.mm.media.widget.camerarecordview.preview.a locala = this.nJB;
    if (locala != null)
    {
      Log.printInfoStack("MicroMsg.CameraPreviewGLTextureRender", "onSurfaceDestroyed", new Object[0]);
      locala.nKo = false;
      locala.H((kotlin.g.a.a)new a.c(locala));
    }
    locala = this.nJB;
    if (locala != null) {
      locala.release();
    }
    this.nJB = null;
    AppMethodBeat.o(94262);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(94263);
    com.tencent.mm.media.widget.camerarecordview.preview.a locala = this.nJB;
    if (locala != null) {
      locala.requestRender();
    }
    AppMethodBeat.o(94263);
  }
  
  public final void setMContext(Context paramContext)
  {
    AppMethodBeat.i(94264);
    s.u(paramContext, "<set-?>");
    this.mContext = paramContext;
    AppMethodBeat.o(94264);
  }
  
  public final void setMHeight(int paramInt)
  {
    this.mHeight = paramInt;
  }
  
  public final void setMWidth(int paramInt)
  {
    this.mWidth = paramInt;
  }
  
  public final void setOnDrawListener(kotlin.g.a.b<? super d, ah> paramb)
  {
    AppMethodBeat.i(94258);
    Log.printInfoStack(this.TAG, "setOnDrawListener", new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a locala = this.nJB;
    if (locala != null) {
      locala.setOnDrawListener(paramb);
    }
    AppMethodBeat.o(94258);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(237630);
    s.u(paramSurface, "<set-?>");
    this.surface = paramSurface;
    AppMethodBeat.o(237630);
  }
  
  public final void t(kotlin.g.a.b<? super SurfaceTexture, ah> paramb)
  {
    AppMethodBeat.i(94254);
    com.tencent.mm.media.widget.camerarecordview.preview.a locala = this.nJB;
    if (locala != null) {
      locala.t(paramb);
    }
    AppMethodBeat.o(94254);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.b
 * JD-Core Version:    0.7.0.1
 */