package com.tencent.mm.plugin.emojicapture.ui;

import a.f.a.a;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.ui.b.i;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureRenderSurface;", "", "texture", "Landroid/graphics/SurfaceTexture;", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiVideoPlayTextureRenderer;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Landroid/graphics/SurfaceTexture;Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiVideoPlayTextureRenderer;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "mEglContext", "Landroid/opengl/EGLContext;", "mEglDisplay", "Landroid/opengl/EGLDisplay;", "kotlin.jvm.PlatformType", "mEglSurface", "Landroid/opengl/EGLSurface;", "needRender", "", "pauseRender", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "createEGLContext", "", "config", "Landroid/opengl/EGLConfig;", "destroyGL", "drawFrame", "pts", "", "initGL", "pause", "queue", "callback", "Lkotlin/Function0;", "releaseRender", "setNeedRender", "render", "plugin-emojicapture_release"})
public final class b
{
  final String TAG;
  HandlerThread eVQ;
  private ak eVR;
  final SurfaceTexture fbG;
  EGLDisplay lxl;
  EGLContext lxm;
  EGLSurface lxn;
  private boolean lxo;
  final i lxp;
  private boolean needRender;
  
  public b(SurfaceTexture paramSurfaceTexture, i parami, final a.f.a.b<? super b, y> paramb)
  {
    AppMethodBeat.i(2903);
    this.fbG = paramSurfaceTexture;
    this.lxp = parami;
    this.TAG = "MicroMsg.EmojiVideoPlayTextureRenderSurface";
    this.lxl = EGL14.EGL_NO_DISPLAY;
    this.lxm = EGL14.EGL_NO_CONTEXT;
    this.lxn = EGL14.EGL_NO_SURFACE;
    paramSurfaceTexture = d.aqu("EmojiVideoPlayTextureRenderSurface_renderThread");
    j.p(paramSurfaceTexture, "ThreadPool.newFreeHandle…derSurface_renderThread\")");
    this.eVQ = paramSurfaceTexture;
    this.eVQ.start();
    this.eVR = new ak(this.eVQ.getLooper());
    d((a)new k(paramb) {});
    AppMethodBeat.o(2903);
  }
  
  final void d(a<y> parama)
  {
    AppMethodBeat.i(2900);
    this.eVR.post((Runnable)new c(parama));
    AppMethodBeat.o(2900);
  }
  
  public final void gW(boolean paramBoolean)
  {
    AppMethodBeat.i(2901);
    ab.i(this.TAG, "setNeedRender:".concat(String.valueOf(paramBoolean)));
    this.needRender = paramBoolean;
    AppMethodBeat.o(2901);
  }
  
  public final void gX(boolean paramBoolean)
  {
    AppMethodBeat.i(2902);
    this.lxo = paramBoolean;
    d((a)new b.b(this, paramBoolean));
    AppMethodBeat.o(2902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b
 * JD-Core Version:    0.7.0.1
 */