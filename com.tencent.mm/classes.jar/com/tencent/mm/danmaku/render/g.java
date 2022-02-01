package com.tencent.mm.danmaku.render;

import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  implements TextureView.SurfaceTextureListener, d
{
  private TextureView cJq;
  private d.a jAt;
  
  public g(TextureView paramTextureView)
  {
    AppMethodBeat.i(277779);
    this.cJq = paramTextureView;
    this.cJq.setOpaque(false);
    this.cJq.setSurfaceTextureListener(this);
    AppMethodBeat.o(277779);
  }
  
  public final void a(d.a parama)
  {
    this.jAt = parama;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(277785);
    if (paramb != null) {
      paramb.m(null);
    }
    AppMethodBeat.o(277785);
  }
  
  public final Canvas azQ()
  {
    AppMethodBeat.i(277780);
    Canvas localCanvas = this.cJq.lockCanvas();
    AppMethodBeat.o(277780);
    return localCanvas;
  }
  
  public final float azR()
  {
    AppMethodBeat.i(277783);
    float f = this.cJq.getY();
    AppMethodBeat.o(277783);
    return f;
  }
  
  public final void o(Canvas paramCanvas)
  {
    AppMethodBeat.i(277781);
    this.cJq.unlockCanvasAndPost(paramCanvas);
    AppMethodBeat.o(277781);
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(277786);
    this.cJq.setOpaque(false);
    if (this.jAt != null)
    {
      this.jAt.ayT();
      this.jAt.ayU();
    }
    AppMethodBeat.o(277786);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(277788);
    if (this.jAt != null) {
      this.jAt.ayV();
    }
    AppMethodBeat.o(277788);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(277787);
    if (this.jAt != null) {
      this.jAt.ayU();
    }
    AppMethodBeat.o(277787);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(277782);
    this.cJq.setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(277782);
  }
  
  public final void unlock() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.render.g
 * JD-Core Version:    0.7.0.1
 */