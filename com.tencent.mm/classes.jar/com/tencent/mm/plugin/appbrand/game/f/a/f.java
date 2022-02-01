package com.tencent.mm.plugin.appbrand.game.f.a;

import android.graphics.Rect;
import android.opengl.EGLContext;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.gamelive.render.e;
import com.tencent.mm.plugin.gamelive.render.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.ah;
import kotlin.g.a.b;

final class f
  implements c.a
{
  Surface renderSurface;
  final c rrT;
  
  public f(c paramc)
  {
    this.rrT = paramc;
  }
  
  public final boolean Af(int paramInt)
  {
    AppMethodBeat.i(318464);
    boolean bool = c.Ah(paramInt);
    AppMethodBeat.o(318464);
    return bool;
  }
  
  public final void H(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(318515);
    Log.w("MicroMsg.GameRecordableSurfaceView.LiveImp", "hy: dummy requestRender");
    AppMethodBeat.o(318515);
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3, c.b paramb)
  {
    AppMethodBeat.i(318471);
    Log.i("MicroMsg.GameRecordableSurfaceView.LiveImp", "surface changed %s %d %d", new Object[] { paramSurfaceHolder, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    ((e)h.ax(e.class)).setSize(paramInt2, paramInt3);
    this.rrT.a(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    this.rrT.a(paramb);
    AppMethodBeat.o(318471);
  }
  
  public final void a(final SurfaceHolder paramSurfaceHolder, final c.b paramb)
  {
    AppMethodBeat.i(318467);
    final int i = paramSurfaceHolder.getSurfaceFrame().width();
    final int j = paramSurfaceHolder.getSurfaceFrame().height();
    Log.i("MicroMsg.GameRecordableSurfaceView.LiveImp", "surface created %s %d %d", new Object[] { paramSurfaceHolder, Integer.valueOf(i), Integer.valueOf(j) });
    ((e)h.ax(e.class)).q(paramSurfaceHolder.getSurface());
    ((e)h.ax(e.class)).a(new f.a()
    {
      public final void gotSurface(Surface paramAnonymousSurface)
      {
        AppMethodBeat.i(318451);
        ((e)h.ax(e.class)).setSize(i, j);
        Log.i("MicroMsg.GameRecordableSurfaceView.LiveImp", "got surface %s", new Object[] { paramAnonymousSurface });
        f.this.renderSurface = paramAnonymousSurface;
        f.this.rrT.b(paramSurfaceHolder);
        f.this.rrT.a(paramb);
        AppMethodBeat.o(318451);
      }
    });
    AppMethodBeat.o(318467);
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder, c.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(318476);
    Log.i("MicroMsg.GameRecordableSurfaceView.LiveImp", "surface destroyed");
    this.rrT.a(paramSurfaceHolder, paramBoolean);
    this.rrT.a(paramb);
    AppMethodBeat.o(318476);
  }
  
  public final com.tencent.mm.media.j.a getAbsSurfaceRenderer()
  {
    AppMethodBeat.i(318488);
    Log.w("MicroMsg.GameRecordableSurfaceView.LiveImp", "hy: dummy queueEvent");
    AppMethodBeat.o(318488);
    return null;
  }
  
  public final EGLContext getEGLContext()
  {
    AppMethodBeat.i(318496);
    Log.w("MicroMsg.GameRecordableSurfaceView.LiveImp", "hy: dummy getEGLContext");
    AppMethodBeat.o(318496);
    return null;
  }
  
  public final int getPreviewTextureId()
  {
    AppMethodBeat.i(318505);
    Log.w("MicroMsg.GameRecordableSurfaceView.LiveImp", "hy: dummy getPreviewTextureId");
    AppMethodBeat.o(318505);
    return 0;
  }
  
  public final int getSurfaceHeight()
  {
    return this.rrT.mSurfaceHeight;
  }
  
  public final Object getSurfaceTexture()
  {
    AppMethodBeat.i(318484);
    Log.i("MicroMsg.GameRecordableSurfaceView.LiveImp", "getSurfaceTexture %s", new Object[] { this.renderSurface });
    Surface localSurface = this.renderSurface;
    AppMethodBeat.o(318484);
    return localSurface;
  }
  
  public final int getSurfaceWidth()
  {
    return this.rrT.mSurfaceWidth;
  }
  
  public final void init()
  {
    this.renderSurface = null;
  }
  
  public final boolean isAvailable()
  {
    return this.rrT.rse;
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(318513);
    Log.w("MicroMsg.GameRecordableSurfaceView.LiveImp", "hy: dummy requestRender");
    AppMethodBeat.o(318513);
  }
  
  public final void setOnSurfaceTextureAvailableDelegate(e.a parama)
  {
    AppMethodBeat.i(318491);
    Log.w("MicroMsg.GameRecordableSurfaceView.LiveImp", "hy: dummy setOnSurfaceTextureAvailableDelegate");
    AppMethodBeat.o(318491);
  }
  
  public final void setOnTextureDrawFinishDelegate(b<d, ah> paramb)
  {
    AppMethodBeat.i(318499);
    Log.w("MicroMsg.GameRecordableSurfaceView.LiveImp", "hy: dummy setOnTextureDrawFinishDelegate");
    AppMethodBeat.o(318499);
  }
  
  public final void setPreviewRenderer(com.tencent.mm.media.j.a parama)
  {
    AppMethodBeat.i(318503);
    Log.w("MicroMsg.GameRecordableSurfaceView.LiveImp", "hy: dummy setPreviewRenderer");
    AppMethodBeat.o(318503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.a.f
 * JD-Core Version:    0.7.0.1
 */