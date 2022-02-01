package com.google.c.c.a;

import com.google.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;

final class h
{
  l cfe;
  b cff;
  b cfh;
  final StringBuilder cfi;
  int cfj;
  k cfk;
  int cfl;
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
    this.cfe = l.cfA;
    this.cfi = new StringBuilder(paramString.length());
    this.cfj = -1;
    AppMethodBeat.o(12272);
  }
  
  private int JO()
  {
    AppMethodBeat.i(12277);
    int i = this.msg.length();
    int j = this.cfl;
    AppMethodBeat.o(12277);
    return i - j;
  }
  
  public final char JM()
  {
    AppMethodBeat.i(12273);
    char c = this.msg.charAt(this.pos);
    AppMethodBeat.o(12273);
    return c;
  }
  
  public final boolean JN()
  {
    AppMethodBeat.i(12276);
    if (this.pos < JO())
    {
      AppMethodBeat.o(12276);
      return true;
    }
    AppMethodBeat.o(12276);
    return false;
  }
  
  public final int JP()
  {
    AppMethodBeat.i(12278);
    int i = JO();
    int j = this.pos;
    AppMethodBeat.o(12278);
    return i - j;
  }
  
  public final void JQ()
  {
    AppMethodBeat.i(12279);
    hZ(this.cfi.length());
    AppMethodBeat.o(12279);
  }
  
  public final void cM(String paramString)
  {
    AppMethodBeat.i(12274);
    this.cfi.append(paramString);
    AppMethodBeat.o(12274);
  }
  
  public final void hZ(int paramInt)
  {
    AppMethodBeat.i(12280);
    if ((this.cfk == null) || (paramInt > this.cfk.cft)) {
      this.cfk = k.a(paramInt, this.cfe, this.cff, this.cfh);
    }
    AppMethodBeat.o(12280);
  }
  
  public final void k(char paramChar)
  {
    AppMethodBeat.i(12275);
    this.cfi.append(paramChar);
    AppMethodBeat.o(12275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.c.c.a.h
 * JD-Core Version:    0.7.0.1
 */