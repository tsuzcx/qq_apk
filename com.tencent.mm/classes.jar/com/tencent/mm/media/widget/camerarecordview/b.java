package com.tencent.mm.media.widget.camerarecordview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.media.widget.camerarecordview.preview.e;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewRenderView;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "mContext", "Landroid/content/Context;", "texture", "Landroid/graphics/SurfaceTexture;", "mWidth", "", "mHeight", "(Landroid/content/Context;Landroid/graphics/SurfaceTexture;II)V", "TAG", "", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "getMHeight", "()I", "setMHeight", "(I)V", "getMWidth", "setMWidth", "getTexture", "()Landroid/graphics/SurfaceTexture;", "setTexture", "(Landroid/graphics/SurfaceTexture;)V", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureRender;", "clearFrame", "", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "queueEvent", "r", "Lkotlin/Function0;", "release", "requestRender", "setOnDrawListener", "frameAvailableListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "setPreviewRenderer", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "cpuCrop", "", "tryCameraPreview", "callback", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "plugin-mediaeditor_release"})
public final class b
  extends CameraPreviewGLSurfaceView
  implements e
{
  private String TAG;
  private com.tencent.mm.media.widget.camerarecordview.preview.b hwq;
  private SurfaceTexture hwr;
  private Context mContext;
  private int mHeight;
  private int mWidth;
  
  public b(Context paramContext, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    super(paramContext, null);
    AppMethodBeat.i(94266);
    this.mContext = paramContext;
    this.hwr = paramSurfaceTexture;
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.TAG = "MicroMsg.CameraPreviewSurfaceRenderView";
    this.hwq = new com.tencent.mm.media.widget.camerarecordview.preview.b();
    AppMethodBeat.o(94266);
  }
  
  public final void a(com.tencent.mm.media.j.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(94256);
    p.h(parama, "renderer");
    com.tencent.mm.media.widget.camerarecordview.preview.b localb = this.hwq;
    if (localb != null) {
      localb.a(parama, false);
    }
    parama = this.hwq;
    if (parama != null) {
      parama.onSurfaceTextureAvailable(this.hwr, this.mWidth, this.mHeight);
    }
    parama = this.hwq;
    if (parama != null) {
      parama.onSurfaceTextureSizeChanged(this.hwr, this.mWidth, this.mHeight);
    }
    parama = this.hwq;
    if (parama != null)
    {
      parama.onSurfaceTextureUpdated(this.hwr);
      AppMethodBeat.o(94256);
      return;
    }
    AppMethodBeat.o(94256);
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    AppMethodBeat.i(94253);
    p.h(paramb, "cameraConfig");
    ae.m(this.TAG, "updateCameraConfig:".concat(String.valueOf(paramb)), new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.b localb = this.hwq;
    if (localb != null)
    {
      localb.a(paramb);
      AppMethodBeat.o(94253);
      return;
    }
    AppMethodBeat.o(94253);
  }
  
  public final void amB()
  {
    AppMethodBeat.i(94255);
    ae.m(this.TAG, "tryStopCameraPreview", new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.b localb = this.hwq;
    if (localb != null)
    {
      localb.amB();
      AppMethodBeat.o(94255);
      return;
    }
    AppMethodBeat.o(94255);
  }
  
  public final void amC()
  {
    AppMethodBeat.i(94261);
    com.tencent.mm.media.widget.camerarecordview.preview.b localb = this.hwq;
    if (localb != null)
    {
      localb.amC();
      AppMethodBeat.o(94261);
      return;
    }
    AppMethodBeat.o(94261);
  }
  
  public final void d(d.g.a.b<? super SurfaceTexture, z> paramb)
  {
    AppMethodBeat.i(94254);
    com.tencent.mm.media.widget.camerarecordview.preview.b localb = this.hwq;
    if (localb != null)
    {
      localb.d(paramb);
      AppMethodBeat.o(94254);
      return;
    }
    AppMethodBeat.o(94254);
  }
  
  public final EGLContext getEGLContext()
  {
    AppMethodBeat.i(94257);
    Object localObject = this.hwq;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.b)localObject).getEGLContext();
      AppMethodBeat.o(94257);
      return localObject;
    }
    AppMethodBeat.o(94257);
    return null;
  }
  
  public final g getFrameDataCallback()
  {
    AppMethodBeat.i(94260);
    Object localObject = this.hwq;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.b)localObject).getFrameDataCallback();
      AppMethodBeat.o(94260);
      return localObject;
    }
    AppMethodBeat.o(94260);
    return null;
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
    AppMethodBeat.i(217543);
    Object localObject = this.hwq;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.b)localObject).getPreviewTexture();
      AppMethodBeat.o(217543);
      return localObject;
    }
    AppMethodBeat.o(217543);
    return null;
  }
  
  public final SurfaceTexture getTexture()
  {
    return this.hwr;
  }
  
  public final void i(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(94252);
    p.h(parama, "r");
    com.tencent.mm.media.widget.camerarecordview.preview.b localb = this.hwq;
    if (localb != null)
    {
      localb.i(parama);
      AppMethodBeat.o(94252);
      return;
    }
    AppMethodBeat.o(94252);
  }
  
  public final void release()
  {
    AppMethodBeat.i(94262);
    com.tencent.mm.media.widget.camerarecordview.preview.b localb = this.hwq;
    if (localb != null) {
      localb.onSurfaceTextureDestroyed(this.hwr);
    }
    localb = this.hwq;
    if (localb != null) {
      localb.release();
    }
    this.hwq = null;
    AppMethodBeat.o(94262);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(94263);
    com.tencent.mm.media.widget.camerarecordview.preview.b localb = this.hwq;
    if (localb != null)
    {
      localb.requestRender();
      AppMethodBeat.o(94263);
      return;
    }
    AppMethodBeat.o(94263);
  }
  
  public final void setMContext(Context paramContext)
  {
    AppMethodBeat.i(94264);
    p.h(paramContext, "<set-?>");
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
  
  public final void setOnDrawListener(d.g.a.b<? super d, z> paramb)
  {
    AppMethodBeat.i(94258);
    ae.m(this.TAG, "setOnDrawListener", new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.b localb = this.hwq;
    if (localb != null)
    {
      localb.setOnDrawListener(paramb);
      AppMethodBeat.o(94258);
      return;
    }
    AppMethodBeat.o(94258);
  }
  
  public final void setTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(94265);
    p.h(paramSurfaceTexture, "<set-?>");
    this.hwr = paramSurfaceTexture;
    AppMethodBeat.o(94265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.b
 * JD-Core Version:    0.7.0.1
 */