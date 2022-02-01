package com.tencent.mm.plugin.appbrand.game.f.a;

import android.opengl.EGLContext;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.b;
import kotlin.x;

final class a
  implements c.a
{
  private final c ook;
  
  public a(c paramc)
  {
    this.ook = paramc;
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3, c.b paramb)
  {
    AppMethodBeat.i(281168);
    this.ook.a(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    this.ook.a(paramb);
    AppMethodBeat.o(281168);
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder, c.b paramb)
  {
    AppMethodBeat.i(281167);
    this.ook.b(paramSurfaceHolder);
    this.ook.a(paramb);
    AppMethodBeat.o(281167);
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder, c.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(281169);
    this.ook.a(paramSurfaceHolder, paramBoolean);
    this.ook.a(paramb);
    AppMethodBeat.o(281169);
  }
  
  public final com.tencent.mm.media.j.a getAbsSurfaceRenderer()
  {
    AppMethodBeat.i(281171);
    Log.w("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: dummy queueEvent");
    AppMethodBeat.o(281171);
    return null;
  }
  
  public final EGLContext getEGLContext()
  {
    AppMethodBeat.i(281173);
    Log.w("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: dummy getEGLContext");
    AppMethodBeat.o(281173);
    return null;
  }
  
  public final int getPreviewTextureId()
  {
    AppMethodBeat.i(281177);
    Log.w("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: dummy getPreviewTextureId");
    AppMethodBeat.o(281177);
    return 0;
  }
  
  public final int getSurfaceHeight()
  {
    return this.ook.mSurfaceHeight;
  }
  
  public final Object getSurfaceTexture()
  {
    AppMethodBeat.i(281170);
    Object localObject = this.ook.bOP();
    AppMethodBeat.o(281170);
    return localObject;
  }
  
  public final int getSurfaceWidth()
  {
    return this.ook.mSurfaceWidth;
  }
  
  public final void i(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(281179);
    Log.w("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: dummy requestRender");
    AppMethodBeat.o(281179);
  }
  
  public final void init()
  {
    AppMethodBeat.i(281166);
    Log.i("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: init. switch to support node js");
    AppMethodBeat.o(281166);
  }
  
  public final boolean isAvailable()
  {
    return this.ook.oou;
  }
  
  public final boolean isSupport(int paramInt)
  {
    return paramInt == 0;
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(281178);
    Log.w("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: dummy requestRender");
    AppMethodBeat.o(281178);
  }
  
  public final void setOnSurfaceTextureAvailableDelegate(e.a parama)
  {
    AppMethodBeat.i(281172);
    Log.w("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: dummy setOnSurfaceTextureAvailableDelegate");
    AppMethodBeat.o(281172);
  }
  
  public final void setOnTextureDrawFinishDelegate(b<d, x> paramb)
  {
    AppMethodBeat.i(281174);
    Log.w("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: dummy setOnTextureDrawFinishDelegate");
    AppMethodBeat.o(281174);
  }
  
  public final void setPreviewRenderer(com.tencent.mm.media.j.a parama)
  {
    AppMethodBeat.i(281175);
    Log.w("MicroMsg.GameRecordableSurfaceView.DefaultImp", "hy: dummy setPreviewRenderer");
    AppMethodBeat.o(281175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.a.a
 * JD-Core Version:    0.7.0.1
 */