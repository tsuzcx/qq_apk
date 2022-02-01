package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;

final class m
  extends Writer
{
  private final char[] aPC;
  private int aPE;
  private final Writer aPQ;
  
  m(Writer paramWriter)
  {
    AppMethodBeat.i(74795);
    this.aPE = 0;
    this.aPQ = paramWriter;
    this.aPC = new char[''];
    AppMethodBeat.o(74795);
  }
  
  public final void close() {}
  
  public final void flush()
  {
    AppMethodBeat.i(74799);
    this.aPQ.write(this.aPC, 0, this.aPE);
    this.aPE = 0;
    AppMethodBeat.o(74799);
  }
  
  public final void write(int paramInt)
  {
    AppMethodBeat.i(74796);
    if (this.aPE > this.aPC.length - 1) {
      flush();
    }
    char[] arrayOfChar = this.aPC;
    int i = this.aPE;
    this.aPE = (i + 1);
    arrayOfChar[i] = ((char)paramInt);
    AppMethodBeat.o(74796);
  }
  
  public final void write(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74798);
    if (this.aPE > this.aPC.length - paramInt2)
    {
      flush();
      if (paramInt2 > this.aPC.length)
      {
        this.aPQ.write(paramString, paramInt1, paramInt2);
        AppMethodBeat.o(74798);
        return;
      }
    }
    paramString.getChars(paramInt1, paramInt1 + paramInt2, this.aPC, this.aPE);
    this.aPE += paramInt2;
    AppMethodBeat.o(74798);
  }
  
  public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74797);
    if (this.aPE > this.aPC.length - paramInt2)
    {
      flush();
      if (paramInt2 > this.aPC.length)
      {
        this.aPQ.write(paramArrayOfChar, paramInt1, paramInt2);
        AppMethodBeat.o(74797);
        return;
      }
    }
    System.arraycopy(paramArrayOfChar, paramInt1, this.aPC, this.aPE, paramInt2);
    this.aPE += paramInt2;
    AppMethodBeat.o(74797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.eclipsesource.a.m
 * JD-Core Version:    0.7.0.1
 */