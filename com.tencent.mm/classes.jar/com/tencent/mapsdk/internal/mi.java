package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mi
  extends TextView
{
  private int a;
  private float b;
  private boolean c;
  
  public mi(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(223013);
    setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    getPaint().setFakeBoldText(true);
    AppMethodBeat.o(223013);
  }
  
  public final void invalidate()
  {
    AppMethodBeat.i(223039);
    if (this.c)
    {
      AppMethodBeat.o(223039);
      return;
    }
    super.invalidate();
    AppMethodBeat.o(223039);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(223034);
    super.onDraw(paramCanvas);
    if (this.b > 0.0F)
    {
      this.c = true;
      int i = getCurrentTextColor();
      TextPaint localTextPaint = getPaint();
      localTextPaint.setStyle(Paint.Style.STROKE);
      localTextPaint.setStrokeWidth(this.b);
      setTextColor(this.a);
      super.onDraw(paramCanvas);
      localTextPaint.setStyle(Paint.Style.FILL);
      localTextPaint.setStrokeWidth(0.0F);
      setTextColor(i);
      super.onDraw(paramCanvas);
      setTextColor(i);
      this.c = false;
      AppMethodBeat.o(223034);
      return;
    }
    super.onDraw(paramCanvas);
    AppMethodBeat.o(223034);
  }
  
  public final void setStrokeColor(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final void setStrokeWidth(float paramFloat)
  {
    this.b = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.internal.mi
 * JD-Core Version:    0.7.0.1
 */