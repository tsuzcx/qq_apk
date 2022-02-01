package com.tencent.mm.danmaku.render;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.e.e;

public class NativeDanmakuView
  extends View
{
  a gPX;
  
  public NativeDanmakuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NativeDanmakuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(241703);
    super.onDetachedFromWindow();
    if (this.gPX != null) {
      this.gPX.onDestroy();
    }
    AppMethodBeat.o(241703);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(241701);
    e.d("NativeDanmakuView", "onDraw");
    if (this.gPX != null) {
      this.gPX.onDraw(paramCanvas);
    }
    AppMethodBeat.o(241701);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(241702);
    e.d("NativeDanmakuView", "onLayout");
    if (this.gPX != null) {
      this.gPX.ate();
    }
    AppMethodBeat.o(241702);
  }
  
  public static abstract interface a
  {
    public abstract void ate();
    
    public abstract void onDestroy();
    
    public abstract void onDraw(Canvas paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.danmaku.render.NativeDanmakuView
 * JD-Core Version:    0.7.0.1
 */