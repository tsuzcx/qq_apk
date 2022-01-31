package com.tencent.mm.plugin.ext.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e$a
{
  public int mfp;
  private boolean mfq = false;
  public int type;
  public String url;
  
  public e$a()
  {
    this.mfq = true;
  }
  
  public e$a(int paramInt1, String paramString, int paramInt2)
  {
    this.type = paramInt1;
    this.url = paramString;
    this.mfq = false;
    this.mfp = paramInt2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(20423);
    String str = "QrCodeModel{type=" + this.type + ", url='" + this.url + '\'' + ", flagTimeout=" + this.mfq + '}';
    AppMethodBeat.o(20423);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.c.e.a
 * JD-Core Version:    0.7.0.1
 */