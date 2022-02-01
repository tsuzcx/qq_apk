package com.tencent.mm.plugin.appbrand.game.f.a;

import android.graphics.Rect;
import android.opengl.EGLContext;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.gamelive.render.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.b;
import kotlin.x;

final class f
  implements c.a
{
  Surface ooH;
  final c ook;
  
  public f(c paramc)
  {
    this.ook = paramc;
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3, c.b paramb)
  {
    AppMethodBeat.i(280485);
    Log.i("MicroMsg.GameRecordableSurfaceView.LiveImp", "surface changed %s %d %d", new Object[] { paramSurfaceHolder, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    ((com.tencent.mm.plugin.gamelive.render.f)h.ae(com.tencent.mm.plugin.gamelive.render.f.class)).setSize(paramInt2, paramInt3);
    this.ook.a(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    this.ook.a(paramb);
    AppMethodBeat.o(280485);
  }
  
  public final void a(final SurfaceHolder paramSurfaceHolder, final c.b paramb)
  {
    AppMethodBeat.i(280484);
    final int i = paramSurfaceHolder.getSurfaceFrame().width();
    final int j = paramSurfaceHolder.getSurfaceFrame().height();
    Log.i("MicroMsg.GameRecordableSurfaceView.LiveImp", "surface created %s %d %d", new Object[] { paramSurfaceHolder, Integer.valueOf(i), Integer.valueOf(j) });
    ((com.tencent.mm.plugin.gamelive.render.f)h.ae(com.tencent.mm.plugin.gamelive.render.f.class)).l(paramSurfaceHolder.getSurface());
    ((com.tencent.mm.plugin.gamelive.render.f)h.ae(com.tencent.mm.plugin.gamelive.render.f.class)).a(new g.a()
    {
      public final void i(Surface paramAnonymousSurface)
      {
        AppMethodBeat.i(267443);
        ((com.tencent.mm.plugin.gamelive.render.f)h.ae(com.tencent.mm.plugin.gamelive.render.f.class)).setSize(i, j);
        Log.i("MicroMsg.GameRecordableSurfaceView.LiveImp", "got surface %s", new Object[] { paramAnonymousSurface });
        f.this.ooH = paramAnonymousSurface;
        f.this.ook.b(paramSurfaceHolder);
        f.this.ook.a(paramb);
        AppMethodBeat.o(267443);
      }
    });
    AppMethodBeat.o(280484);
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder, c.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(280486);
    Log.i("MicroMsg.GameRecordableSurfaceView.LiveImp", "surface destroyed");
    this.ook.a(paramSurfaceHolder, paramBoolean);
    this.ook.a(paramb);
    AppMethodBeat.o(280486);
  }
  
  public final com.tencent.mm.media.j.a getAbsSurfaceRenderer()
  {
    AppMethodBeat.i(280488);
    Log.w("MicroMsg.GameRecordableSurfaceView.LiveImp", "hy: dummy queueEvent");
    AppMethodBeat.o(280488);
    return null;
  }
  
  public final EGLContext getEGLContext()
  {
    AppMethodBeat.i(280490);
    Log.w("MicroMsg.GameRecordableSurfaceView.LiveImp", "hy: dummy getEGLContext");
    AppMethodBeat.o(280490);
    return null;
  }
  
  public final int getPreviewTextureId()
  {
    AppMethodBeat.i(280493);
    Log.w("MicroMsg.GameRecordableSurfaceView.LiveImp", "hy: dummy getPreviewTextureId");
    AppMethodBeat.o(280493);
    return 0;
  }
  
  public final int getSurfaceHeight()
  {
    return this.ook.mSurfaceHeight;
  }
  
  public final Object getSurfaceTexture()
  {
    AppMethodBeat.i(280487);
    Log.i("MicroMsg.GameRecordableSurfaceView.LiveImp", "getSurfaceTexture %s", new Object[] { this.ooH });
    Surface localSurface = this.ooH;
    AppMethodBeat.o(280487);
    return localSurface;
  }
  
  public final int getSurfaceWidth()
  {
    return this.ook.mSurfaceWidth;
  }
  
  public final void i(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(280495);
    Log.w("MicroMsg.GameRecordableSurfaceView.LiveImp", "hy: dummy requestRender");
    AppMethodBeat.o(280495);
  }
  
  public final void init()
  {
    this.ooH = null;
  }
  
  public final boolean isAvailable()
  {
    return this.ook.oou;
  }
  
  public final boolean isSupport(int paramInt)
  {
    AppMethodBeat.i(280483);
    boolean bool = c.zP(paramInt);
    AppMethodBeat.o(280483);
    return bool;
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(280494);
    Log.w("MicroMsg.GameRecordableSurfaceView.LiveImp", "hy: dummy requestRender");
    AppMethodBeat.o(280494);
  }
  
  public final void setOnSurfaceTextureAvailableDelegate(e.a parama)
  {
    AppMethodBeat.i(280489);
    Log.w("MicroMsg.GameRecordableSurfaceView.LiveImp", "hy: dummy setOnSurfaceTextureAvailableDelegate");
    AppMethodBeat.o(280489);
  }
  
  public final void setOnTextureDrawFinishDelegate(b<d, x> paramb)
  {
    AppMethodBeat.i(280491);
    Log.w("MicroMsg.GameRecordableSurfaceView.LiveImp", "hy: dummy setOnTextureDrawFinishDelegate");
    AppMethodBeat.o(280491);
  }
  
  public final void setPreviewRenderer(com.tencent.mm.media.j.a parama)
  {
    AppMethodBeat.i(280492);
    Log.w("MicroMsg.GameRecordableSurfaceView.LiveImp", "hy: dummy setPreviewRenderer");
    AppMethodBeat.o(280492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.a.f
 * JD-Core Version:    0.7.0.1
 */