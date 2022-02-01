package com.tencent.mm.danmaku.render;

import android.graphics.Canvas;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.f.a;

public final class e
  implements NativeDanmakuView.a, d
{
  private d.b gOb;
  private boolean gPY;
  private boolean gPZ;
  private d.a gQa;
  private NativeDanmakuView gQb;
  
  public e(NativeDanmakuView paramNativeDanmakuView)
  {
    this.gQb = paramNativeDanmakuView;
    this.gQb.gPX = this;
  }
  
  public final void a(d.a parama)
  {
    this.gQa = parama;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(241706);
    this.gPZ = true;
    this.gOb = paramb;
    if (a.ato())
    {
      this.gQb.postInvalidateOnAnimation();
      AppMethodBeat.o(241706);
      return;
    }
    this.gQb.postInvalidate();
    AppMethodBeat.o(241706);
  }
  
  public final float atd()
  {
    AppMethodBeat.i(241705);
    float f = this.gQb.getY();
    AppMethodBeat.o(241705);
    return f;
  }
  
  public final void ate()
  {
    AppMethodBeat.i(241707);
    if (!this.gPY)
    {
      if (this.gQa != null)
      {
        this.gQa.asg();
        this.gQa.ash();
      }
      this.gPY = true;
      AppMethodBeat.o(241707);
      return;
    }
    if (this.gQa != null) {
      this.gQa.ash();
    }
    AppMethodBeat.o(241707);
  }
  
  public final Canvas lockCanvas()
  {
    return null;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(241709);
    if (this.gQa != null) {
      this.gQa.asi();
    }
    this.gPY = false;
    AppMethodBeat.o(241709);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(241708);
    if (!this.gPZ)
    {
      AppMethodBeat.o(241708);
      return;
    }
    this.gPZ = false;
    if (this.gOb != null) {
      this.gOb.l(paramCanvas);
    }
    AppMethodBeat.o(241708);
  }
  
  public final void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(241704);
    this.gQb.setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(241704);
  }
  
  public final void unlock()
  {
    this.gOb = null;
  }
  
  public final void unlockCanvasAndPost(Canvas paramCanvas)
  {
    this.gOb = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.danmaku.render.e
 * JD-Core Version:    0.7.0.1
 */