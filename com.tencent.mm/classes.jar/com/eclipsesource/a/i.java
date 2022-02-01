package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;

class i
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final char[] aPJ = { 92, 34 };
  private static final char[] aPK = { 92, 92 };
  private static final char[] aPL = { 92, 110 };
  private static final char[] aPM = { 92, 114 };
  private static final char[] aPN = { 92, 116 };
  private static final char[] aPO = { 92, 117, 50, 48, 50, 56 };
  private static final char[] aPP = { 92, 117, 50, 48, 50, 57 };
  protected final Writer aPQ;
  
  i(Writer paramWriter)
  {
    this.aPQ = paramWriter;
  }
  
  private void ah(String paramString)
  {
    AppMethodBeat.i(74782);
    int m = paramString.length();
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      char[] arrayOfChar = d(paramString.charAt(i));
      k = j;
      if (arrayOfChar != null)
      {
        this.aPQ.write(paramString, j, i - j);
        this.aPQ.write(arrayOfChar);
        k = i + 1;
      }
      i += 1;
    }
    this.aPQ.write(paramString, j, m - j);
    AppMethodBeat.o(74782);
  }
  
  private static char[] d(char paramChar)
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
          return aPO;
        }
        return aPP;
        if (paramChar == '\\') {
          return aPK;
        }
      } while (paramChar > '"');
      if (paramChar == '"') {
        return aPJ;
      }
    } while (paramChar > '\037');
    if (paramChar == '\n') {
      return aPL;
    }
    if (paramChar == '\r') {
      return aPM;
    }
    if (paramChar == '\t') {
      return aPN;
    }
    return new char[] { '\\', 'u', '0', '0', HEX_DIGITS[(paramChar >> '\004' & 0xF)], HEX_DIGITS[(paramChar & 0xF)] };
  }
  
  protected final void ae(String paramString)
  {
    AppMethodBeat.i(74771);
    this.aPQ.write(paramString);
    AppMethodBeat.o(74771);
  }
  
  protected final void af(String paramString)
  {
    AppMethodBeat.i(74772);
    this.aPQ.write(paramString);
    AppMethodBeat.o(74772);
  }
  
  protected final void ag(String paramString)
  {
    AppMethodBeat.i(74779);
    this.aPQ.write(34);
    ah(paramString);
    this.aPQ.write(34);
    AppMethodBeat.o(74779);
  }
  
  protected void rg()
  {
    AppMethodBeat.i(74774);
    this.aPQ.write(91);
    AppMethodBeat.o(74774);
  }
  
  protected void rh()
  {
    AppMethodBeat.i(74775);
    this.aPQ.write(93);
    AppMethodBeat.o(74775);
  }
  
  protected void ri()
  {
    AppMethodBeat.i(74776);
    this.aPQ.write(44);
    AppMethodBeat.o(74776);
  }
  
  protected void rj()
  {
    AppMethodBeat.i(74777);
    this.aPQ.write(123);
    AppMethodBeat.o(74777);
  }
  
  protected void rk()
  {
    AppMethodBeat.i(74778);
    this.aPQ.write(125);
    AppMethodBeat.o(74778);
  }
  
  protected void rl()
  {
    AppMethodBeat.i(74780);
    this.aPQ.write(58);
    AppMethodBeat.o(74780);
  }
  
  protected void rm()
  {
    AppMethodBeat.i(74781);
    this.aPQ.write(44);
    AppMethodBeat.o(74781);
  }
  
  protected final void writeString(String paramString)
  {
    AppMethodBeat.i(74773);
    this.aPQ.write(34);
    ah(paramString);
    this.aPQ.write(34);
    AppMethodBeat.o(74773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.a.i
 * JD-Core Version:    0.7.0.1
 */