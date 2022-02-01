package com.google.c.c.a;

import com.google.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;

final class h
{
  final String bLg;
  l bLh;
  b bLi;
  b bLj;
  final StringBuilder bLk;
  int bLl;
  k bLm;
  int bLn;
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
    this.bLg = localStringBuilder.toString();
    this.bLh = l.bLC;
    this.bLk = new StringBuilder(paramString.length());
    this.bLl = -1;
    AppMethodBeat.o(12272);
  }
  
  private int yo()
  {
    AppMethodBeat.i(12277);
    int i = this.bLg.length();
    int j = this.bLn;
    AppMethodBeat.o(12277);
    return i - j;
  }
  
  public final void bv(String paramString)
  {
    AppMethodBeat.i(12274);
    this.bLk.append(paramString);
    AppMethodBeat.o(12274);
  }
  
  public final void e(char paramChar)
  {
    AppMethodBeat.i(12275);
    this.bLk.append(paramChar);
    AppMethodBeat.o(12275);
  }
  
  public final void gi(int paramInt)
  {
    AppMethodBeat.i(12280);
    if ((this.bLm == null) || (paramInt > this.bLm.bLv)) {
      this.bLm = k.a(paramInt, this.bLh, this.bLi, this.bLj);
    }
    AppMethodBeat.o(12280);
  }
  
  public final char ym()
  {
    AppMethodBeat.i(12273);
    char c = this.bLg.charAt(this.pos);
    AppMethodBeat.o(12273);
    return c;
  }
  
  public final boolean yn()
  {
    AppMethodBeat.i(12276);
    if (this.pos < yo())
    {
      AppMethodBeat.o(12276);
      return true;
    }
    AppMethodBeat.o(12276);
    return false;
  }
  
  public final int yp()
  {
    AppMethodBeat.i(12278);
    int i = yo();
    int j = this.pos;
    AppMethodBeat.o(12278);
    return i - j;
  }
  
  public final void yq()
  {
    AppMethodBeat.i(12279);
    gi(this.bLk.length());
    AppMethodBeat.o(12279);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.c.c.a.h
 * JD-Core Version:    0.7.0.1
 */