package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;

final class m
  extends Writer
{
  private final char[] aOM;
  private int aOO;
  private final Writer aPa;
  
  m(Writer paramWriter)
  {
    AppMethodBeat.i(74795);
    this.aOO = 0;
    this.aPa = paramWriter;
    this.aOM = new char[''];
    AppMethodBeat.o(74795);
  }
  
  public final void close() {}
  
  public final void flush()
  {
    AppMethodBeat.i(74799);
    this.aPa.write(this.aOM, 0, this.aOO);
    this.aOO = 0;
    AppMethodBeat.o(74799);
  }
  
  public final void write(int paramInt)
  {
    AppMethodBeat.i(74796);
    if (this.aOO > this.aOM.length - 1) {
      flush();
    }
    char[] arrayOfChar = this.aOM;
    int i = this.aOO;
    this.aOO = (i + 1);
    arrayOfChar[i] = ((char)paramInt);
    AppMethodBeat.o(74796);
  }
  
  public final void write(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74798);
    if (this.aOO > this.aOM.length - paramInt2)
    {
      flush();
      if (paramInt2 > this.aOM.length)
      {
        this.aPa.write(paramString, paramInt1, paramInt2);
        AppMethodBeat.o(74798);
        return;
      }
    }
    paramString.getChars(paramInt1, paramInt1 + paramInt2, this.aOM, this.aOO);
    this.aOO += paramInt2;
    AppMethodBeat.o(74798);
  }
  
  public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74797);
    if (this.aOO > this.aOM.length - paramInt2)
    {
      flush();
      if (paramInt2 > this.aOM.length)
      {
        this.aPa.write(paramArrayOfChar, paramInt1, paramInt2);
        AppMethodBeat.o(74797);
        return;
      }
    }
    System.arraycopy(paramArrayOfChar, paramInt1, this.aOM, this.aOO, paramInt2);
    this.aOO += paramInt2;
    AppMethodBeat.o(74797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.eclipsesource.a.m
 * JD-Core Version:    0.7.0.1
 */