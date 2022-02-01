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
  a jAq;
  
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
    AppMethodBeat.i(278670);
    super.onDetachedFromWindow();
    if (this.jAq != null) {
      this.jAq.onDestroy();
    }
    AppMethodBeat.o(278670);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(278668);
    e.d("NativeDanmakuView", "onDraw");
    if (this.jAq != null) {
      this.jAq.onDraw(paramCanvas);
    }
    AppMethodBeat.o(278668);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(278669);
    e.d("NativeDanmakuView", "onLayout");
    if (this.jAq != null) {
      this.jAq.azS();
    }
    AppMethodBeat.o(278669);
  }
  
  public static abstract interface a
  {
    public abstract void azS();
    
    public abstract void onDestroy();
    
    public abstract void onDraw(Canvas paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.render.NativeDanmakuView
 * JD-Core Version:    0.7.0.1
 */