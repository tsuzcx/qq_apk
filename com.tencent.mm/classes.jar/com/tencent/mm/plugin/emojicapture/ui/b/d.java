package com.tencent.mm.plugin.emojicapture.ui.b;

import a.f.a.a;
import a.f.b.j;
import a.l;
import a.v;
import a.y;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixEGLPixelBuffer;", "", "width", "", "height", "(II)V", "TAG", "", "eGL", "Ljavax/microedition/khronos/egl/EGL10;", "eGLConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "eGLContext", "Ljavax/microedition/khronos/egl/EGLContext;", "kotlin.jvm.PlatformType", "eGLDisplay", "Ljavax/microedition/khronos/egl/EGLDisplay;", "eGLSurface", "Ljavax/microedition/khronos/egl/EGLSurface;", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "glThread", "Landroid/os/HandlerThread;", "glThreadHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "onPrepareDrawFrame", "Lkotlin/Function0;", "", "getOnPrepareDrawFrame", "()Lkotlin/jvm/functions/Function0;", "setOnPrepareDrawFrame", "(Lkotlin/jvm/functions/Function0;)V", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixRenderer;", "videoDecodeSurface", "Landroid/view/Surface;", "createEGLContext", "config", "destroyGL", "getRenderContent", "callback", "Lkotlin/Function1;", "", "getVideoDecodeSurface", "init", "afterInitCallback", "initPixelBuffer", "mixVideoAndEmojiFrame", "nextFrameInfo", "Lcom/tencent/mm/media/mix/MixFrameSyncMgr$NextFrameInfo;", "", "onVideoSurfaceFrameAvailable", "queue", "setRemoveBackground", "remove", "plugin-emojicapture_release"})
public final class d
{
  public final String TAG;
  final int height;
  final EGL10 lAI;
  EGLDisplay lAJ;
  EGLContext lAK;
  EGLSurface lAL;
  EGLConfig lAM;
  public GL10 lAN;
  public e lAO;
  Surface lAP;
  public ak lAQ;
  HandlerThread lAR;
  public a<y> lAS;
  final int width;
  
  public d(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3164);
    this.width = paramInt1;
    this.height = paramInt2;
    this.TAG = "MicroMsg.EmojiCaptureEGLPixelBuffer";
    Object localObject = EGLContext.getEGL();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
      AppMethodBeat.o(3164);
      throw ((Throwable)localObject);
    }
    this.lAI = ((EGL10)localObject);
    this.lAJ = EGL10.EGL_NO_DISPLAY;
    this.lAK = EGL10.EGL_NO_CONTEXT;
    this.lAL = EGL10.EGL_NO_SURFACE;
    localObject = com.tencent.mm.sdk.g.d.aqu("EmojiCaptureMixEGLPixelBuffer_GLThread");
    j.p(localObject, "ThreadPool.newFreeHandle…EGLPixelBuffer_GLThread\")");
    this.lAR = ((HandlerThread)localObject);
    this.lAR.start();
    this.lAQ = new ak(this.lAR.getLooper());
    this.lAQ.post((Runnable)new d.1(this));
    AppMethodBeat.o(3164);
  }
  
  public final Surface bpj()
  {
    AppMethodBeat.i(3163);
    Surface localSurface = this.lAP;
    if (localSurface == null) {
      j.ays("videoDecodeSurface");
    }
    AppMethodBeat.o(3163);
    return localSurface;
  }
  
  public final void d(a<y> parama)
  {
    AppMethodBeat.i(3162);
    j.q(parama, "callback");
    this.lAQ.post((Runnable)new d.e(parama));
    AppMethodBeat.o(3162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.d
 * JD-Core Version:    0.7.0.1
 */