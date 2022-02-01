package com.bumptech.glide.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class e
  extends IOException
{
  private final int statusCode;
  
  public e(int paramInt)
  {
    this("Http request failed with status code: ".concat(String.valueOf(paramInt)), paramInt);
    AppMethodBeat.i(76842);
    AppMethodBeat.o(76842);
  }
  
  public e(String paramString)
  {
    this(paramString, -1);
  }
  
  public e(String paramString, int paramInt)
  {
    this(paramString, paramInt, (byte)0);
  }
  
  private e(String paramString, int paramInt, byte paramByte)
  {
    super(paramString, null);
    this.statusCode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.e
 * JD-Core Version:    0.7.0.1
 */