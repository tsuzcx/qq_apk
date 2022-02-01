package com.tencent.mm.plugin.emojicapture.ui.editor.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/DefaultTextDrawer;", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "()V", "text", "", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "lineStart", "", "lineEnd", "x", "", "y", "paint", "Landroid/graphics/Paint;", "withEllipsis", "", "refresh", "setText", "switchFont", "fontName", "", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements c
{
  private CharSequence bba;
  
  public final void a(Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, Paint paramPaint, boolean paramBoolean)
  {
    AppMethodBeat.i(809);
    s.u(paramCanvas, "canvas");
    s.u(paramPaint, "paint");
    if (this.bba == null)
    {
      AppMethodBeat.o(809);
      return;
    }
    CharSequence localCharSequence = this.bba;
    s.checkNotNull(localCharSequence);
    paramCanvas.drawText(localCharSequence, paramInt1, paramInt2, paramFloat1, paramFloat2, paramPaint);
    if (paramBoolean)
    {
      float f = paramPaint.measureText(this.bba, paramInt1, paramInt2);
      paramCanvas.drawText(c.a.dET(), f + paramFloat1, paramFloat2, paramPaint);
    }
    AppMethodBeat.o(809);
  }
  
  public final void apq(String paramString)
  {
    AppMethodBeat.i(808);
    s.u(paramString, "fontName");
    AppMethodBeat.o(808);
  }
  
  public final void bDL() {}
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(807);
    s.u(paramCharSequence, "text");
    this.bba = paramCharSequence;
    AppMethodBeat.o(807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.text.a
 * JD-Core Version:    0.7.0.1
 */