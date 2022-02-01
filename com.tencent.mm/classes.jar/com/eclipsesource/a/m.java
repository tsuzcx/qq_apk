package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;

final class m
  extends Writer
{
  private final char[] aZW;
  private int aZY;
  private final Writer bak;
  
  m(Writer paramWriter)
  {
    AppMethodBeat.i(74795);
    this.aZY = 0;
    this.bak = paramWriter;
    this.aZW = new char[''];
    AppMethodBeat.o(74795);
  }
  
  public final void close() {}
  
  public final void flush()
  {
    AppMethodBeat.i(74799);
    this.bak.write(this.aZW, 0, this.aZY);
    this.aZY = 0;
    AppMethodBeat.o(74799);
  }
  
  public final void write(int paramInt)
  {
    AppMethodBeat.i(74796);
    if (this.aZY > this.aZW.length - 1) {
      flush();
    }
    char[] arrayOfChar = this.aZW;
    int i = this.aZY;
    this.aZY = (i + 1);
    arrayOfChar[i] = ((char)paramInt);
    AppMethodBeat.o(74796);
  }
  
  public final void write(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74798);
    if (this.aZY > this.aZW.length - paramInt2)
    {
      flush();
      if (paramInt2 > this.aZW.length)
      {
        this.bak.write(paramString, paramInt1, paramInt2);
        AppMethodBeat.o(74798);
        return;
      }
    }
    paramString.getChars(paramInt1, paramInt1 + paramInt2, this.aZW, this.aZY);
    this.aZY += paramInt2;
    AppMethodBeat.o(74798);
  }
  
  public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74797);
    if (this.aZY > this.aZW.length - paramInt2)
    {
      flush();
      if (paramInt2 > this.aZW.length)
      {
        this.bak.write(paramArrayOfChar, paramInt1, paramInt2);
        AppMethodBeat.o(74797);
        return;
      }
    }
    System.arraycopy(paramArrayOfChar, paramInt1, this.aZW, this.aZY, paramInt2);
    this.aZY += paramInt2;
    AppMethodBeat.o(74797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.eclipsesource.a.m
 * JD-Core Version:    0.7.0.1
 */