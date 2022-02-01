package com.tencent.mm.plugin.editor.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public final o oTs;
  public int oTt;
  public int oTu;
  
  public a(o paramo, int paramInt1, int paramInt2)
  {
    this.oTs = paramo;
    this.oTt = paramInt1;
    this.oTu = paramInt2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(181925);
    String str = this.oTs.name() + " - " + this.oTt + "/" + this.oTu;
    AppMethodBeat.o(181925);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.a
 * JD-Core Version:    0.7.0.1
 */