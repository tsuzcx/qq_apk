package com.tencent.mm.plugin.emojicapture.ui.editor.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/DefaultTextDrawer;", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "()V", "text", "", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "lineStart", "", "lineEnd", "x", "", "y", "paint", "Landroid/graphics/Paint;", "withEllipsis", "", "refresh", "setText", "switchFont", "fontName", "", "plugin-emojicapture_release"})
public final class a
  implements c
{
  private CharSequence text;
  
  public final void a(Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, Paint paramPaint, boolean paramBoolean)
  {
    AppMethodBeat.i(809);
    p.h(paramCanvas, "canvas");
    p.h(paramPaint, "paint");
    if (this.text == null)
    {
      AppMethodBeat.o(809);
      return;
    }
    paramCanvas.drawText(this.text, paramInt1, paramInt2, paramFloat1, paramFloat2, paramPaint);
    if (paramBoolean)
    {
      float f = paramPaint.measureText(this.text, paramInt1, paramInt2);
      paramCanvas.drawText(c.a.ckA(), f + paramFloat1, paramFloat2, paramPaint);
    }
    AppMethodBeat.o(809);
  }
  
  public final void acr(String paramString)
  {
    AppMethodBeat.i(808);
    p.h(paramString, "fontName");
    AppMethodBeat.o(808);
  }
  
  public final void refresh() {}
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(807);
    p.h(paramCharSequence, "text");
    this.text = paramCharSequence;
    AppMethodBeat.o(807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.text.a
 * JD-Core Version:    0.7.0.1
 */