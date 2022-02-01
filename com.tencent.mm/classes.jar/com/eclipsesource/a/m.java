package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;

final class m
  extends Writer
{
  private final char[] aZS;
  private int aZU;
  private final Writer bag;
  
  m(Writer paramWriter)
  {
    AppMethodBeat.i(74795);
    this.aZU = 0;
    this.bag = paramWriter;
    this.aZS = new char[''];
    AppMethodBeat.o(74795);
  }
  
  public final void close() {}
  
  public final void flush()
  {
    AppMethodBeat.i(74799);
    this.bag.write(this.aZS, 0, this.aZU);
    this.aZU = 0;
    AppMethodBeat.o(74799);
  }
  
  public final void write(int paramInt)
  {
    AppMethodBeat.i(74796);
    if (this.aZU > this.aZS.length - 1) {
      flush();
    }
    char[] arrayOfChar = this.aZS;
    int i = this.aZU;
    this.aZU = (i + 1);
    arrayOfChar[i] = ((char)paramInt);
    AppMethodBeat.o(74796);
  }
  
  public final void write(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74798);
    if (this.aZU > this.aZS.length - paramInt2)
    {
      flush();
      if (paramInt2 > this.aZS.length)
      {
        this.bag.write(paramString, paramInt1, paramInt2);
        AppMethodBeat.o(74798);
        return;
      }
    }
    paramString.getChars(paramInt1, paramInt1 + paramInt2, this.aZS, this.aZU);
    this.aZU += paramInt2;
    AppMethodBeat.o(74798);
  }
  
  public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74797);
    if (this.aZU > this.aZS.length - paramInt2)
    {
      flush();
      if (paramInt2 > this.aZS.length)
      {
        this.bag.write(paramArrayOfChar, paramInt1, paramInt2);
        AppMethodBeat.o(74797);
        return;
      }
    }
    System.arraycopy(paramArrayOfChar, paramInt1, this.aZS, this.aZU, paramInt2);
    this.aZU += paramInt2;
    AppMethodBeat.o(74797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.eclipsesource.a.m
 * JD-Core Version:    0.7.0.1
 */