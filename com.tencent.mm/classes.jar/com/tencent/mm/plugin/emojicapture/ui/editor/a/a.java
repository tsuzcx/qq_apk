package com.tencent.mm.plugin.emojicapture.ui.editor.a;

import a.d.b.g;
import android.graphics.Canvas;
import android.graphics.Paint;

public final class a
  implements c
{
  private CharSequence text;
  
  public final void Bo(String paramString)
  {
    g.k(paramString, "fontName");
  }
  
  public final void a(Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, Paint paramPaint, boolean paramBoolean)
  {
    g.k(paramCanvas, "canvas");
    g.k(paramPaint, "paint");
    if (this.text == null) {}
    do
    {
      return;
      paramCanvas.drawText(this.text, paramInt1, paramInt2, paramFloat1, paramFloat2, paramPaint);
    } while (!paramBoolean);
    float f = paramPaint.measureText(this.text, paramInt1, paramInt2);
    paramCanvas.drawText(c.a.ceH(), f + paramFloat1, paramFloat2, paramPaint);
  }
  
  public final void refresh() {}
  
  public final void setText(CharSequence paramCharSequence)
  {
    g.k(paramCharSequence, "text");
    this.text = paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.a.a
 * JD-Core Version:    0.7.0.1
 */