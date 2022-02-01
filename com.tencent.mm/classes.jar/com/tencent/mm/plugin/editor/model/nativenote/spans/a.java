package com.tencent.mm.plugin.editor.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public final o qSY;
  public int qSZ;
  public int qTa;
  
  public a(o paramo, int paramInt1, int paramInt2)
  {
    this.qSY = paramo;
    this.qSZ = paramInt1;
    this.qTa = paramInt2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(181925);
    String str = this.qSY.name() + " - " + this.qSZ + "/" + this.qTa;
    AppMethodBeat.o(181925);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.a
 * JD-Core Version:    0.7.0.1
 */