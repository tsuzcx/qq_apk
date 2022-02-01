package com.google.c.c.a;

import com.google.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;

final class h
{
  final String bIO;
  l bIP;
  b bIQ;
  b bIR;
  final StringBuilder bIS;
  int bIT;
  k bIU;
  int bIV;
  int pos;
  
  h(String paramString)
  {
    AppMethodBeat.i(12272);
    byte[] arrayOfByte = paramString.getBytes(Charset.forName("ISO-8859-1"));
    StringBuilder localStringBuilder = new StringBuilder(arrayOfByte.length);
    int i = 0;
    int j = arrayOfByte.length;
    while (i < j)
    {
      char c = (char)(arrayOfByte[i] & 0xFF);
      if ((c == '?') && (paramString.charAt(i) != '?'))
      {
        paramString = new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
        AppMethodBeat.o(12272);
        throw paramString;
      }
      localStringBuilder.append(c);
      i += 1;
    }
    this.bIO = localStringBuilder.toString();
    this.bIP = l.bJk;
    this.bIS = new StringBuilder(paramString.length());
    this.bIT = -1;
    AppMethodBeat.o(12272);
  }
  
  private int yb()
  {
    AppMethodBeat.i(12277);
    int i = this.bIO.length();
    int j = this.bIV;
    AppMethodBeat.o(12277);
    return i - j;
  }
  
  public final void bm(String paramString)
  {
    AppMethodBeat.i(12274);
    this.bIS.append(paramString);
    AppMethodBeat.o(12274);
  }
  
  public final void e(char paramChar)
  {
    AppMethodBeat.i(12275);
    this.bIS.append(paramChar);
    AppMethodBeat.o(12275);
  }
  
  public final void fU(int paramInt)
  {
    AppMethodBeat.i(12280);
    if ((this.bIU == null) || (paramInt > this.bIU.bJd)) {
      this.bIU = k.a(paramInt, this.bIP, this.bIQ, this.bIR);
    }
    AppMethodBeat.o(12280);
  }
  
  public final char xZ()
  {
    AppMethodBeat.i(12273);
    char c = this.bIO.charAt(this.pos);
    AppMethodBeat.o(12273);
    return c;
  }
  
  public final boolean ya()
  {
    AppMethodBeat.i(12276);
    if (this.pos < yb())
    {
      AppMethodBeat.o(12276);
      return true;
    }
    AppMethodBeat.o(12276);
    return false;
  }
  
  public final int yc()
  {
    AppMethodBeat.i(12278);
    int i = yb();
    int j = this.pos;
    AppMethodBeat.o(12278);
    return i - j;
  }
  
  public final void yd()
  {
    AppMethodBeat.i(12279);
    fU(this.bIS.length());
    AppMethodBeat.o(12279);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.c.c.a.h
 * JD-Core Version:    0.7.0.1
 */