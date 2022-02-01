package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
  implements ParagraphStyle
{
  public final ParagraphStyle pxF;
  public final o pxc;
  
  public p(o paramo, ParagraphStyle paramParagraphStyle)
  {
    this.pxc = paramo;
    this.pxF = paramParagraphStyle;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(181957);
    String str = this.pxc.name() + " - " + this.pxF.getClass().getSimpleName();
    AppMethodBeat.o(181957);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.p
 * JD-Core Version:    0.7.0.1
 */