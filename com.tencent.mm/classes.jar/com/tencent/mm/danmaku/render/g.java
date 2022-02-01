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
  private TextureView cIM;
  private d.a gQa;
  
  public g(TextureView paramTextureView)
  {
    AppMethodBeat.i(241722);
    this.cIM = paramTextureView;
    this.cIM.setOpaque(false);
    this.cIM.setSurfaceTextureListener(this);
    AppMethodBeat.o(241722);
  }
  
  public final void a(d.a parama)
  {
    this.gQa = parama;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(241727);
    if (paramb != null) {
      paramb.l(null);
    }
    AppMethodBeat.o(241727);
  }
  
  public final float atd()
  {
    AppMethodBeat.i(241726);
    float f = this.cIM.getY();
    AppMethodBeat.o(241726);
    return f;
  }
  
  public final Canvas lockCanvas()
  {
    AppMethodBeat.i(241723);
    Canvas localCanvas = this.cIM.lockCanvas();
    AppMethodBeat.o(241723);
    return localCanvas;
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(241728);
    this.cIM.setOpaque(false);
    if (this.gQa != null)
    {
      this.gQa.asg();
      this.gQa.ash();
    }
    AppMethodBeat.o(241728);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(241730);
    if (this.gQa != null) {
      this.gQa.asi();
    }
    AppMethodBeat.o(241730);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(241729);
    if (this.gQa != null) {
      this.gQa.ash();
    }
    AppMethodBeat.o(241729);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(241725);
    this.cIM.setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(241725);
  }
  
  public final void unlock() {}
  
  public final void unlockCanvasAndPost(Canvas paramCanvas)
  {
    AppMethodBeat.i(241724);
    this.cIM.unlockCanvasAndPost(paramCanvas);
    AppMethodBeat.o(241724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.danmaku.render.g
 * JD-Core Version:    0.7.0.1
 */