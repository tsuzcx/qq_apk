package com.tencent.mm.plugin.appbrand.game.f.a;

import a.f.a.b;
import a.y;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.HandlerThread;
import com.tencent.magicbrush.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
  extends g
  implements c
{
  private HandlerThread eVQ;
  private ak eVR;
  private com.tencent.mm.media.h.a eWh;
  private int fbH;
  private int fbI;
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a fby;
  private SurfaceTexture htJ;
  private b.b htK;
  private AtomicBoolean htL;
  private c.a htM;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143187);
    this.htL = new AtomicBoolean(false);
    this.eVQ = d.ey("GameTextureView_renderThread", -2);
    this.eVQ.start();
    this.eVR = new ak(this.eVQ.getLooper());
    AppMethodBeat.o(143187);
  }
  
  private void queueEvent(Runnable paramRunnable)
  {
    AppMethodBeat.i(143188);
    if (Thread.currentThread().getId() == this.eVQ.getId())
    {
      paramRunnable.run();
      AppMethodBeat.o(143188);
      return;
    }
    this.eVR.post(paramRunnable);
    AppMethodBeat.o(143188);
  }
  
  public final void e(a.f.a.a<y> parama)
  {
    AppMethodBeat.i(143189);
    if (Thread.currentThread().getId() == this.eVQ.getId())
    {
      parama.invoke();
      AppMethodBeat.o(143189);
      return;
    }
    this.eVR.post(new a.1(this, parama));
    AppMethodBeat.o(143189);
  }
  
  public EGLContext getEGLContext()
  {
    if (this.htK == null) {
      return null;
    }
    return this.htK.eZz;
  }
  
  public int getPreviewTextureId()
  {
    AppMethodBeat.i(143196);
    if (this.fby == null)
    {
      AppMethodBeat.o(143196);
      return -1;
    }
    int i = this.fby.getTextureId();
    AppMethodBeat.o(143196);
    return i;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143190);
    ab.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureAvailable, surfaceTexture:%s, width:%d, height:%d", new Object[] { paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    queueEvent(new a.2(this, paramInt1, paramInt2, paramSurfaceTexture));
    AppMethodBeat.o(143190);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(143192);
    ab.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureDestroyed");
    queueEvent(new a.4(this));
    AppMethodBeat.o(143192);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143191);
    ab.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureSizeChanged, surfaceTexture:%s, width:%d, height:%d", new Object[] { paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    queueEvent(new a.3(this, paramInt1, paramInt2));
    AppMethodBeat.o(143191);
  }
  
  public void requestRender()
  {
    AppMethodBeat.i(143195);
    queueEvent(new a.5(this));
    AppMethodBeat.o(143195);
  }
  
  public void setOnSurfaceTextureAvailableDelegate(c.a parama)
  {
    AppMethodBeat.i(143193);
    this.htM = parama;
    this.htL.get();
    AppMethodBeat.o(143193);
  }
  
  public void setOnTextureDrawFinishDelegate(b<Integer, y> paramb)
  {
    this.fby.fbN = paramb;
  }
  
  public void setPreviewRenderer(com.tencent.mm.media.h.a parama)
  {
    AppMethodBeat.i(143194);
    ab.i("MicroMsg.CameraPreviewGLTextureView", "setRenderer:${renderer.hashCode()}  ");
    if (this.fby != null)
    {
      this.fby.release();
      this.fby = new com.tencent.mm.media.widget.camerarecordview.preview.a.c(this);
    }
    this.fby = new com.tencent.mm.media.widget.camerarecordview.preview.a.c(this);
    this.fby.b(parama);
    this.eWh = parama;
    AppMethodBeat.o(143194);
  }
  
  public final void yA()
  {
    AppMethodBeat.i(143197);
    super.yA();
    this.eVQ.quitSafely();
    AppMethodBeat.o(143197);
  }
  
  public final boolean yz()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.a.a
 * JD-Core Version:    0.7.0.1
 */