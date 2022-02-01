package com.tencent.mm.danmaku.render;

import android.graphics.Canvas;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.f.a;

public final class e
  implements NativeDanmakuView.a, d
{
  private boolean jAr;
  private boolean jAs;
  private d.a jAt;
  private NativeDanmakuView jAu;
  private d.b jyw;
  
  public e(NativeDanmakuView paramNativeDanmakuView)
  {
    this.jAu = paramNativeDanmakuView;
    this.jAu.jAq = this;
  }
  
  public final void a(d.a parama)
  {
    this.jAt = parama;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(269030);
    this.jAs = true;
    this.jyw = paramb;
    if (a.aAe())
    {
      this.jAu.postInvalidateOnAnimation();
      AppMethodBeat.o(269030);
      return;
    }
    this.jAu.postInvalidate();
    AppMethodBeat.o(269030);
  }
  
  public final Canvas azQ()
  {
    return null;
  }
  
  public final float azR()
  {
    AppMethodBeat.i(269029);
    float f = this.jAu.getY();
    AppMethodBeat.o(269029);
    return f;
  }
  
  public final void azS()
  {
    AppMethodBeat.i(269031);
    if (!this.jAr)
    {
      if (this.jAt != null)
      {
        this.jAt.ayT();
        this.jAt.ayU();
      }
      this.jAr = true;
      AppMethodBeat.o(269031);
      return;
    }
    if (this.jAt != null) {
      this.jAt.ayU();
    }
    AppMethodBeat.o(269031);
  }
  
  public final void o(Canvas paramCanvas)
  {
    this.jyw = null;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(269033);
    if (this.jAt != null) {
      this.jAt.ayV();
    }
    this.jAr = false;
    AppMethodBeat.o(269033);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(269032);
    if (!this.jAs)
    {
      AppMethodBeat.o(269032);
      return;
    }
    this.jAs = false;
    if (this.jyw != null) {
      this.jyw.m(paramCanvas);
    }
    AppMethodBeat.o(269032);
  }
  
  public final void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(269028);
    this.jAu.setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(269028);
  }
  
  public final void unlock()
  {
    this.jyw = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.render.e
 * JD-Core Version:    0.7.0.1
 */