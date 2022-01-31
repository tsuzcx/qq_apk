package com.eclipsesource.a;

import java.io.Writer;

final class m
  extends Writer
{
  private final char[] arL;
  private final Writer arY;
  private int fill = 0;
  
  m(Writer paramWriter)
  {
    this.arY = paramWriter;
    this.arL = new char[''];
  }
  
  public final void close() {}
  
  public final void flush()
  {
    this.arY.write(this.arL, 0, this.fill);
    this.fill = 0;
  }
  
  public final void write(int paramInt)
  {
    if (this.fill > this.arL.length - 1) {
      flush();
    }
    char[] arrayOfChar = this.arL;
    int i = this.fill;
    this.fill = (i + 1);
    arrayOfChar[i] = ((char)paramInt);
  }
  
  public final void write(String paramString, int paramInt1, int paramInt2)
  {
    if (this.fill > this.arL.length - paramInt2)
    {
      flush();
      if (paramInt2 > this.arL.length)
      {
        this.arY.write(paramString, paramInt1, paramInt2);
        return;
      }
    }
    paramString.getChars(paramInt1, paramInt1 + paramInt2, this.arL, this.fill);
    this.fill += paramInt2;
  }
  
  public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.fill > this.arL.length - paramInt2)
    {
      flush();
      if (paramInt2 > this.arL.length)
      {
        this.arY.write(paramArrayOfChar, paramInt1, paramInt2);
        return;
      }
    }
    System.arraycopy(paramArrayOfChar, paramInt1, this.arL, this.fill, paramInt2);
    this.fill += paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.eclipsesource.a.m
 * JD-Core Version:    0.7.0.1
 */