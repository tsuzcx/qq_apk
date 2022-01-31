package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;

class i
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final char[] auj = { 92, 34 };
  private static final char[] auk = { 92, 92 };
  private static final char[] aul = { 92, 110 };
  private static final char[] aum = { 92, 114 };
  private static final char[] aun = { 92, 116 };
  private static final char[] auo = { 92, 117, 50, 48, 50, 56 };
  private static final char[] aup = { 92, 117, 50, 48, 50, 57 };
  protected final Writer writer;
  
  i(Writer paramWriter)
  {
    this.writer = paramWriter;
  }
  
  private void aj(String paramString)
  {
    AppMethodBeat.i(70595);
    int m = paramString.length();
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      char[] arrayOfChar = f(paramString.charAt(i));
      k = j;
      if (arrayOfChar != null)
      {
        this.writer.write(paramString, j, i - j);
        this.writer.write(arrayOfChar);
        k = i + 1;
      }
      i += 1;
    }
    this.writer.write(paramString, j, m - j);
    AppMethodBeat.o(70595);
  }
  
  private static char[] f(char paramChar)
  {
    if (paramChar > '\\') {
      if ((paramChar >= ' ') && (paramChar <= ' ')) {}
    }
    do
    {
      do
      {
        return null;
        if (paramChar == ' ') {
          return auo;
        }
        return aup;
        if (paramChar == '\\') {
          return auk;
        }
      } while (paramChar > '"');
      if (paramChar == '"') {
        return auj;
      }
    } while (paramChar > '\037');
    if (paramChar == '\n') {
      return aul;
    }
    if (paramChar == '\r') {
      return aum;
    }
    if (paramChar == '\t') {
      return aun;
    }
    return new char[] { '\\', 'u', '0', '0', HEX_DIGITS[(paramChar >> '\004' & 0xF)], HEX_DIGITS[(paramChar & 0xF)] };
  }
  
  protected final void ag(String paramString)
  {
    AppMethodBeat.i(70584);
    this.writer.write(paramString);
    AppMethodBeat.o(70584);
  }
  
  protected final void ah(String paramString)
  {
    AppMethodBeat.i(70585);
    this.writer.write(paramString);
    AppMethodBeat.o(70585);
  }
  
  protected final void ai(String paramString)
  {
    AppMethodBeat.i(70592);
    this.writer.write(34);
    aj(paramString);
    this.writer.write(34);
    AppMethodBeat.o(70592);
  }
  
  protected void ml()
  {
    AppMethodBeat.i(70587);
    this.writer.write(91);
    AppMethodBeat.o(70587);
  }
  
  protected void mm()
  {
    AppMethodBeat.i(70588);
    this.writer.write(93);
    AppMethodBeat.o(70588);
  }
  
  protected void mn()
  {
    AppMethodBeat.i(70589);
    this.writer.write(44);
    AppMethodBeat.o(70589);
  }
  
  protected void mo()
  {
    AppMethodBeat.i(70590);
    this.writer.write(123);
    AppMethodBeat.o(70590);
  }
  
  protected void mp()
  {
    AppMethodBeat.i(70591);
    this.writer.write(125);
    AppMethodBeat.o(70591);
  }
  
  protected void mq()
  {
    AppMethodBeat.i(70593);
    this.writer.write(58);
    AppMethodBeat.o(70593);
  }
  
  protected void mr()
  {
    AppMethodBeat.i(70594);
    this.writer.write(44);
    AppMethodBeat.o(70594);
  }
  
  protected final void writeString(String paramString)
  {
    AppMethodBeat.i(70586);
    this.writer.write(34);
    aj(paramString);
    this.writer.write(34);
    AppMethodBeat.o(70586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.eclipsesource.a.i
 * JD-Core Version:    0.7.0.1
 */