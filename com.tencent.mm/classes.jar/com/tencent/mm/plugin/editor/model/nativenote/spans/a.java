package com.tencent.mm.plugin.editor.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public final o uve;
  public int uvf;
  public int uvg;
  
  public a(o paramo, int paramInt1, int paramInt2)
  {
    this.uve = paramo;
    this.uvf = paramInt1;
    this.uvg = paramInt2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(181925);
    String str = this.uve.name() + " - " + this.uvf + "/" + this.uvg;
    AppMethodBeat.o(181925);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.a
 * JD-Core Version:    0.7.0.1
 */