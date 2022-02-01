package com.tencent.mm.plugin.editor.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public final o opS;
  public int opT;
  public int opU;
  
  public a(o paramo, int paramInt1, int paramInt2)
  {
    this.opS = paramo;
    this.opT = paramInt1;
    this.opU = paramInt2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(181925);
    String str = this.opS.name() + " - " + this.opT + "/" + this.opU;
    AppMethodBeat.o(181925);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.a
 * JD-Core Version:    0.7.0.1
 */