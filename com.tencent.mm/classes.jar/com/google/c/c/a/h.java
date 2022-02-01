package com.google.c.c.a;

import com.google.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;

final class h
{
  l bTc;
  b bTd;
  b bTe;
  final StringBuilder bTf;
  int bTg;
  k bTh;
  int bTi;
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
    this.bTc = l.bTx;
    this.bTf = new StringBuilder(paramString.length());
    this.bTg = -1;
    AppMethodBeat.o(12272);
  }
  
  private int zy()
  {
    AppMethodBeat.i(12277);
    int i = this.msg.length();
    int j = this.bTi;
    AppMethodBeat.o(12277);
    return i - j;
  }
  
  public final void cf(String paramString)
  {
    AppMethodBeat.i(12274);
    this.bTf.append(paramString);
    AppMethodBeat.o(12274);
  }
  
  public final void fX(int paramInt)
  {
    AppMethodBeat.i(12280);
    if ((this.bTh == null) || (paramInt > this.bTh.bTq)) {
      this.bTh = k.a(paramInt, this.bTc, this.bTd, this.bTe);
    }
    AppMethodBeat.o(12280);
  }
  
  public final void g(char paramChar)
  {
    AppMethodBeat.i(12275);
    this.bTf.append(paramChar);
    AppMethodBeat.o(12275);
  }
  
  public final void zA()
  {
    AppMethodBeat.i(12279);
    fX(this.bTf.length());
    AppMethodBeat.o(12279);
  }
  
  public final char zw()
  {
    AppMethodBeat.i(12273);
    char c = this.msg.charAt(this.pos);
    AppMethodBeat.o(12273);
    return c;
  }
  
  public final boolean zx()
  {
    AppMethodBeat.i(12276);
    if (this.pos < zy())
    {
      AppMethodBeat.o(12276);
      return true;
    }
    AppMethodBeat.o(12276);
    return false;
  }
  
  public final int zz()
  {
    AppMethodBeat.i(12278);
    int i = zy();
    int j = this.pos;
    AppMethodBeat.o(12278);
    return i - j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.c.c.a.h
 * JD-Core Version:    0.7.0.1
 */