package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
  implements ParagraphStyle
{
  public final o pDG;
  public final ParagraphStyle pEj;
  
  public p(o paramo, ParagraphStyle paramParagraphStyle)
  {
    this.pDG = paramo;
    this.pEj = paramParagraphStyle;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(181957);
    String str = this.pDG.name() + " - " + this.pEj.getClass().getSimpleName();
    AppMethodBeat.o(181957);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.p
 * JD-Core Version:    0.7.0.1
 */