package com.google.b.c.a;

import com.google.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;

final class h
{
  l cdB;
  b cdC;
  b cdD;
  final StringBuilder cdE;
  int cdF;
  k cdG;
  int cdH;
  final String msg;
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
    this.msg = localStringBuilder.toString();
    this.cdB = l.cdW;
    this.cdE = new StringBuilder(paramString.length());
    this.cdF = -1;
    AppMethodBeat.o(12272);
  }
  
  private int Io()
  {
    AppMethodBeat.i(12277);
    int i = this.msg.length();
    int j = this.cdH;
    AppMethodBeat.o(12277);
    return i - j;
  }
  
  public final char Im()
  {
    AppMethodBeat.i(12273);
    char c = this.msg.charAt(this.pos);
    AppMethodBeat.o(12273);
    return c;
  }
  
  public final boolean In()
  {
    AppMethodBeat.i(12276);
    if (this.pos < Io())
    {
      AppMethodBeat.o(12276);
      return true;
    }
    AppMethodBeat.o(12276);
    return false;
  }
  
  public final int Ip()
  {
    AppMethodBeat.i(12278);
    int i = Io();
    int j = this.pos;
    AppMethodBeat.o(12278);
    return i - j;
  }
  
  public final void Iq()
  {
    AppMethodBeat.i(12279);
    hi(this.cdE.length());
    AppMethodBeat.o(12279);
  }
  
  public final void cs(String paramString)
  {
    AppMethodBeat.i(12274);
    this.cdE.append(paramString);
    AppMethodBeat.o(12274);
  }
  
  public final void g(char paramChar)
  {
    AppMethodBeat.i(12275);
    this.cdE.append(paramChar);
    AppMethodBeat.o(12275);
  }
  
  public final void hi(int paramInt)
  {
    AppMethodBeat.i(12280);
    if ((this.cdG == null) || (paramInt > this.cdG.cdP)) {
      this.cdG = k.a(paramInt, this.cdB, this.cdC, this.cdD);
    }
    AppMethodBeat.o(12280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.c.a.h
 * JD-Core Version:    0.7.0.1
 */