package com.google.b.c.a;

import com.google.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;

final class h
{
  final String bjm;
  l bjn;
  b bjo;
  b bjp;
  final StringBuilder bjq;
  int bjr;
  k bjs;
  int bjt;
  int pos;
  
  h(String paramString)
  {
    AppMethodBeat.i(57207);
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
        AppMethodBeat.o(57207);
        throw paramString;
      }
      localStringBuilder.append(c);
      i += 1;
    }
    this.bjm = localStringBuilder.toString();
    this.bjn = l.bjI;
    this.bjq = new StringBuilder(paramString.length());
    this.bjr = -1;
    AppMethodBeat.o(57207);
  }
  
  private int sH()
  {
    AppMethodBeat.i(57212);
    int i = this.bjm.length();
    int j = this.bjt;
    AppMethodBeat.o(57212);
    return i - j;
  }
  
  public final void bi(String paramString)
  {
    AppMethodBeat.i(57209);
    this.bjq.append(paramString);
    AppMethodBeat.o(57209);
  }
  
  public final void fg(int paramInt)
  {
    AppMethodBeat.i(57215);
    if ((this.bjs == null) || (paramInt > this.bjs.bjB)) {
      this.bjs = k.a(paramInt, this.bjn, this.bjo, this.bjp);
    }
    AppMethodBeat.o(57215);
  }
  
  public final void g(char paramChar)
  {
    AppMethodBeat.i(57210);
    this.bjq.append(paramChar);
    AppMethodBeat.o(57210);
  }
  
  public final char sF()
  {
    AppMethodBeat.i(57208);
    char c = this.bjm.charAt(this.pos);
    AppMethodBeat.o(57208);
    return c;
  }
  
  public final boolean sG()
  {
    AppMethodBeat.i(57211);
    if (this.pos < sH())
    {
      AppMethodBeat.o(57211);
      return true;
    }
    AppMethodBeat.o(57211);
    return false;
  }
  
  public final int sI()
  {
    AppMethodBeat.i(57213);
    int i = sH();
    int j = this.pos;
    AppMethodBeat.o(57213);
    return i - j;
  }
  
  public final void sJ()
  {
    AppMethodBeat.i(57214);
    fg(this.bjq.length());
    AppMethodBeat.o(57214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.c.a.h
 * JD-Core Version:    0.7.0.1
 */