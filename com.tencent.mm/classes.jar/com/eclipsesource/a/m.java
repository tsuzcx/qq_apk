package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;

final class m
  extends Writer
{
  private final char[] auc;
  private int aue;
  private final Writer writer;
  
  m(Writer paramWriter)
  {
    AppMethodBeat.i(70608);
    this.aue = 0;
    this.writer = paramWriter;
    this.auc = new char[''];
    AppMethodBeat.o(70608);
  }
  
  public final void close() {}
  
  public final void flush()
  {
    AppMethodBeat.i(70612);
    this.writer.write(this.auc, 0, this.aue);
    this.aue = 0;
    AppMethodBeat.o(70612);
  }
  
  public final void write(int paramInt)
  {
    AppMethodBeat.i(70609);
    if (this.aue > this.auc.length - 1) {
      flush();
    }
    char[] arrayOfChar = this.auc;
    int i = this.aue;
    this.aue = (i + 1);
    arrayOfChar[i] = ((char)paramInt);
    AppMethodBeat.o(70609);
  }
  
  public final void write(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70611);
    if (this.aue > this.auc.length - paramInt2)
    {
      flush();
      if (paramInt2 > this.auc.length)
      {
        this.writer.write(paramString, paramInt1, paramInt2);
        AppMethodBeat.o(70611);
        return;
      }
    }
    paramString.getChars(paramInt1, paramInt1 + paramInt2, this.auc, this.aue);
    this.aue += paramInt2;
    AppMethodBeat.o(70611);
  }
  
  public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70610);
    if (this.aue > this.auc.length - paramInt2)
    {
      flush();
      if (paramInt2 > this.auc.length)
      {
        this.writer.write(paramArrayOfChar, paramInt1, paramInt2);
        AppMethodBeat.o(70610);
        return;
      }
    }
    System.arraycopy(paramArrayOfChar, paramInt1, this.auc, this.aue, paramInt2);
    this.aue += paramInt2;
    AppMethodBeat.o(70610);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.eclipsesource.a.m
 * JD-Core Version:    0.7.0.1
 */