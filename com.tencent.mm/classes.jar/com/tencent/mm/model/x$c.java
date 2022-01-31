package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.q;

final class x$c
{
  String filename;
  boolean flB;
  String flC;
  int pos;
  String url;
  
  public x$c(x paramx, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(77802);
    this.flB = false;
    this.url = paramString1;
    if ((q.ahJ()) && (paramx.flt)) {
      this.url = q.tu(this.url);
    }
    this.filename = paramString2;
    this.pos = paramInt;
    this.flB = false;
    this.flC = paramString3;
    AppMethodBeat.o(77802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.x.c
 * JD-Core Version:    0.7.0.1
 */