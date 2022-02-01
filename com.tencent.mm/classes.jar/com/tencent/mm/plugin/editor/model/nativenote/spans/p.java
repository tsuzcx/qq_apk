package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
  implements ParagraphStyle
{
  public final o qSY;
  public final ParagraphStyle qTA;
  
  public p(o paramo, ParagraphStyle paramParagraphStyle)
  {
    this.qSY = paramo;
    this.qTA = paramParagraphStyle;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(181957);
    String str = this.qSY.name() + " - " + this.qTA.getClass().getSimpleName();
    AppMethodBeat.o(181957);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.p
 * JD-Core Version:    0.7.0.1
 */