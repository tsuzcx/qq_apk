package com.tencent.mm.plugin.editor.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public final o xBB;
  public int xBC;
  public int xBD;
  
  public a(o paramo, int paramInt1, int paramInt2)
  {
    this.xBB = paramo;
    this.xBC = paramInt1;
    this.xBD = paramInt2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(181925);
    String str = this.xBB.name() + " - " + this.xBC + "/" + this.xBD;
    AppMethodBeat.o(181925);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.a
 * JD-Core Version:    0.7.0.1
 */