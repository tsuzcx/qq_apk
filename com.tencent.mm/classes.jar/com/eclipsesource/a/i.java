package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;

class i
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final char[] aJA;
  private static final char[] aJB;
  private static final char[] aJv = { 92, 34 };
  private static final char[] aJw = { 92, 92 };
  private static final char[] aJx = { 92, 110 };
  private static final char[] aJy = { 92, 114 };
  private static final char[] aJz = { 92, 116 };
  protected final Writer aJC;
  
  static
  {
    aJA = new char[] { 92, 117, 50, 48, 50, 56 };
    aJB = new char[] { 92, 117, 50, 48, 50, 57 };
  }
  
  i(Writer paramWriter)
  {
    this.aJC = paramWriter;
  }
  
  private void bl(String paramString)
  {
    AppMethodBeat.i(74782);
    int m = paramString.length();
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      char[] arrayOfChar = f(paramString.charAt(i));
      k = j;
      if (arrayOfChar != null)
      {
        this.aJC.write(paramString, j, i - j);
        this.aJC.write(arrayOfChar);
        k = i + 1;
      }
      i += 1;
    }
    this.aJC.write(paramString, j, m - j);
    AppMethodBeat.o(74782);
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
          return aJA;
        }
        return aJB;
        if (paramChar == '\\') {
          return aJw;
        }
      } while (paramChar > '"');
      if (paramChar == '"') {
        return aJv;
      }
    } while (paramChar > '\037');
    if (paramChar == '\n') {
      return aJx;
    }
    if (paramChar == '\r') {
      return aJy;
    }
    if (paramChar == '\t') {
      return aJz;
    }
    return new char[] { '\\', 'u', '0', '0', HEX_DIGITS[(paramChar >> '\004' & 0xF)], HEX_DIGITS[(paramChar & 0xF)] };
  }
  
  protected final void T(String paramString)
  {
    AppMethodBeat.i(74773);
    this.aJC.write(34);
    bl(paramString);
    this.aJC.write(34);
    AppMethodBeat.o(74773);
  }
  
  protected final void bi(String paramString)
  {
    AppMethodBeat.i(74771);
    this.aJC.write(paramString);
    AppMethodBeat.o(74771);
  }
  
  protected final void bj(String paramString)
  {
    AppMethodBeat.i(74772);
    this.aJC.write(paramString);
    AppMethodBeat.o(74772);
  }
  
  protected final void bk(String paramString)
  {
    AppMethodBeat.i(74779);
    this.aJC.write(34);
    bl(paramString);
    this.aJC.write(34);
    AppMethodBeat.o(74779);
  }
  
  protected void qA()
  {
    AppMethodBeat.i(74780);
    this.aJC.write(58);
    AppMethodBeat.o(74780);
  }
  
  protected void qB()
  {
    AppMethodBeat.i(74781);
    this.aJC.write(44);
    AppMethodBeat.o(74781);
  }
  
  protected void qv()
  {
    AppMethodBeat.i(74774);
    this.aJC.write(91);
    AppMethodBeat.o(74774);
  }
  
  protected void qw()
  {
    AppMethodBeat.i(74775);
    this.aJC.write(93);
    AppMethodBeat.o(74775);
  }
  
  protected void qx()
  {
    AppMethodBeat.i(74776);
    this.aJC.write(44);
    AppMethodBeat.o(74776);
  }
  
  protected void qy()
  {
    AppMethodBeat.i(74777);
    this.aJC.write(123);
    AppMethodBeat.o(74777);
  }
  
  protected void qz()
  {
    AppMethodBeat.i(74778);
    this.aJC.write(125);
    AppMethodBeat.o(74778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.eclipsesource.a.i
 * JD-Core Version:    0.7.0.1
 */