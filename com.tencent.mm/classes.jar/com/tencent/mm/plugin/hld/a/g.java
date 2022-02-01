package com.tencent.mm.plugin.hld.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  public long JnG;
  public int keyType;
  public String text;
  
  public g(String paramString)
  {
    this.keyType = 0;
    this.text = paramString;
  }
  
  public g(String paramString, long paramLong)
  {
    AppMethodBeat.i(311427);
    this.keyType = 0;
    this.text = paramString;
    this.JnG = (System.currentTimeMillis() - paramLong);
    AppMethodBeat.o(311427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.a.g
 * JD-Core Version:    0.7.0.1
 */