package com.tencent.mm.plugin.ext.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e$a
{
  public int type;
  public String url;
  public int wuc;
  private boolean wud = false;
  
  public final String toString()
  {
    AppMethodBeat.i(24500);
    String str = "QrCodeModel{type=" + this.type + ", url='" + this.url + '\'' + ", flagTimeout=" + this.wud + '}';
    AppMethodBeat.o(24500);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.d.e.a
 * JD-Core Version:    0.7.0.1
 */