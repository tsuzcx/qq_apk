package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;

final class m
  extends Writer
{
  private final char[] cCa;
  private final Writer cCm;
  private int fill;
  
  m(Writer paramWriter)
  {
    AppMethodBeat.i(74795);
    this.fill = 0;
    this.cCm = paramWriter;
    this.cCa = new char[''];
    AppMethodBeat.o(74795);
  }
  
  public final void close() {}
  
  public final void flush()
  {
    AppMethodBeat.i(74799);
    this.cCm.write(this.cCa, 0, this.fill);
    this.fill = 0;
    AppMethodBeat.o(74799);
  }
  
  public final void write(int paramInt)
  {
    AppMethodBeat.i(74796);
    if (this.fill > this.cCa.length - 1) {
      flush();
    }
    char[] arrayOfChar = this.cCa;
    int i = this.fill;
    this.fill = (i + 1);
    arrayOfChar[i] = ((char)paramInt);
    AppMethodBeat.o(74796);
  }
  
  public final void write(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74798);
    if (this.fill > this.cCa.length - paramInt2)
    {
      flush();
      if (paramInt2 > this.cCa.length)
      {
        this.cCm.write(paramString, paramInt1, paramInt2);
        AppMethodBeat.o(74798);
        return;
      }
    }
    paramString.getChars(paramInt1, paramInt1 + paramInt2, this.cCa, this.fill);
    this.fill += paramInt2;
    AppMethodBeat.o(74798);
  }
  
  public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74797);
    if (this.fill > this.cCa.length - paramInt2)
    {
      flush();
      if (paramInt2 > this.cCa.length)
      {
        this.cCm.write(paramArrayOfChar, paramInt1, paramInt2);
        AppMethodBeat.o(74797);
        return;
      }
    }
    System.arraycopy(paramArrayOfChar, paramInt1, this.cCa, this.fill, paramInt2);
    this.fill += paramInt2;
    AppMethodBeat.o(74797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.a.m
 * JD-Core Version:    0.7.0.1
 */