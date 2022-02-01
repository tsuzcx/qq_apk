package com.tencent.mm.plugin.emojicapture.ui.editor.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/DefaultTextDrawer;", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "()V", "text", "", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "lineStart", "", "lineEnd", "x", "", "y", "paint", "Landroid/graphics/Paint;", "withEllipsis", "", "refresh", "setText", "switchFont", "fontName", "", "plugin-emojicapture_release"})
public final class a
  implements c
{
  private CharSequence LV;
  
  public final void a(Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, Paint paramPaint, boolean paramBoolean)
  {
    AppMethodBeat.i(809);
    p.k(paramCanvas, "canvas");
    p.k(paramPaint, "paint");
    if (this.LV == null)
    {
      AppMethodBeat.o(809);
      return;
    }
    CharSequence localCharSequence = this.LV;
    if (localCharSequence == null) {
      p.iCn();
    }
    paramCanvas.drawText(localCharSequence, paramInt1, paramInt2, paramFloat1, paramFloat2, paramPaint);
    if (paramBoolean)
    {
      float f = paramPaint.measureText(this.LV, paramInt1, paramInt2);
      paramCanvas.drawText(c.a.cYC(), f + paramFloat1, paramFloat2, paramPaint);
    }
    AppMethodBeat.o(809);
  }
  
  public final void avq(String paramString)
  {
    AppMethodBeat.i(808);
    p.k(paramString, "fontName");
    AppMethodBeat.o(808);
  }
  
  public final void bfU() {}
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(807);
    p.k(paramCharSequence, "text");
    this.LV = paramCharSequence;
    AppMethodBeat.o(807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.text.a
 * JD-Core Version:    0.7.0.1
 */