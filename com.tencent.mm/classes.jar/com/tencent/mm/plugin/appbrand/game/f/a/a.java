package com.tencent.mm.plugin.appbrand.game.f.a;

import android.opengl.EGLContext;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.ah;
import kotlin.g.a.b;

final class a
  implements c.a
{
  private final c rrT;
  
  public a(c paramc)
  {
    this.rrT = paramc;
  }
  
  public final boolean Af(int paramInt)
  {
    return paramInt == 0;
  }
  
  public final void H(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(318510);
    Log.w("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: dummy requestRender");
    AppMethodBeat.o(318510);
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3, c.b paramb)
  {
    AppMethodBeat.i(318466);
    this.rrT.a(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    this.rrT.a(paramb);
    AppMethodBeat.o(318466);
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder, c.b paramb)
  {
    AppMethodBeat.i(318463);
    this.rrT.b(paramSurfaceHolder);
    this.rrT.a(paramb);
    AppMethodBeat.o(318463);
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder, c.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(318469);
    this.rrT.a(paramSurfaceHolder, paramBoolean);
    this.rrT.a(paramb);
    AppMethodBeat.o(318469);
  }
  
  public final com.tencent.mm.media.j.a getAbsSurfaceRenderer()
  {
    AppMethodBeat.i(318481);
    Log.w("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: dummy queueEvent");
    AppMethodBeat.o(318481);
    return null;
  }
  
  public final EGLContext getEGLContext()
  {
    AppMethodBeat.i(318490);
    Log.w("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: dummy getEGLContext");
    AppMethodBeat.o(318490);
    return null;
  }
  
  public final int getPreviewTextureId()
  {
    AppMethodBeat.i(318500);
    Log.w("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: dummy getPreviewTextureId");
    AppMethodBeat.o(318500);
    return 0;
  }
  
  public final int getSurfaceHeight()
  {
    return this.rrT.mSurfaceHeight;
  }
  
  public final Object getSurfaceTexture()
  {
    AppMethodBeat.i(318475);
    Object localObject = this.rrT.cpd();
    AppMethodBeat.o(318475);
    return localObject;
  }
  
  public final int getSurfaceWidth()
  {
    return this.rrT.mSurfaceWidth;
  }
  
  public final void init()
  {
    AppMethodBeat.i(318458);
    Log.i("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: init. switch to support node js");
    AppMethodBeat.o(318458);
  }
  
  public final boolean isAvailable()
  {
    return this.rrT.rse;
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(318509);
    Log.w("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: dummy requestRender");
    AppMethodBeat.o(318509);
  }
  
  public final void setOnSurfaceTextureAvailableDelegate(e.a parama)
  {
    AppMethodBeat.i(318486);
    Log.w("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: dummy setOnSurfaceTextureAvailableDelegate");
    AppMethodBeat.o(318486);
  }
  
  public final void setOnTextureDrawFinishDelegate(b<d, ah> paramb)
  {
    AppMethodBeat.i(318493);
    Log.w("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: dummy setOnTextureDrawFinishDelegate");
    AppMethodBeat.o(318493);
  }
  
  public final void setPreviewRenderer(com.tencent.mm.media.j.a parama)
  {
    AppMethodBeat.i(318497);
    Log.w("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: dummy setPreviewRenderer");
    AppMethodBeat.o(318497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.a.a
 * JD-Core Version:    0.7.0.1
 */