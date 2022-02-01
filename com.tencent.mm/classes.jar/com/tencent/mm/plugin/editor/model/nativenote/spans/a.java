package com.tencent.mm.plugin.editor.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public final o pxc;
  public int pxd;
  public int pxe;
  
  public a(o paramo, int paramInt1, int paramInt2)
  {
    this.pxc = paramo;
    this.pxd = paramInt1;
    this.pxe = paramInt2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(181925);
    String str = this.pxc.name() + " - " + this.pxd + "/" + this.pxe;
    AppMethodBeat.o(181925);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.a
 * JD-Core Version:    0.7.0.1
 */