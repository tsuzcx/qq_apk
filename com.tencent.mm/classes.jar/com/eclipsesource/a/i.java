package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;

class i
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final char[] cCf = { 92, 34 };
  private static final char[] cCg = { 92, 92 };
  private static final char[] cCh = { 92, 110 };
  private static final char[] cCi = { 92, 114 };
  private static final char[] cCj = { 92, 116 };
  private static final char[] cCk = { 92, 117, 50, 48, 50, 56 };
  private static final char[] cCl = { 92, 117, 50, 48, 50, 57 };
  protected final Writer cCm;
  
  i(Writer paramWriter)
  {
    this.cCm = paramWriter;
  }
  
  private void cy(String paramString)
  {
    AppMethodBeat.i(74782);
    int m = paramString.length();
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      char[] arrayOfChar = g(paramString.charAt(i));
      k = j;
      if (arrayOfChar != null)
      {
        this.cCm.write(paramString, j, i - j);
        this.cCm.write(arrayOfChar);
        k = i + 1;
      }
      i += 1;
    }
    this.cCm.write(paramString, j, m - j);
    AppMethodBeat.o(74782);
  }
  
  private static char[] g(char paramChar)
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
          return cCk;
        }
        return cCl;
        if (paramChar == '\\') {
          return cCg;
        }
      } while (paramChar > '"');
      if (paramChar == '"') {
        return cCf;
      }
    } while (paramChar > '\037');
    if (paramChar == '\n') {
      return cCh;
    }
    if (paramChar == '\r') {
      return cCi;
    }
    if (paramChar == '\t') {
      return cCj;
    }
    return new char[] { '\\', 'u', '0', '0', HEX_DIGITS[(paramChar >> '\004' & 0xF)], HEX_DIGITS[(paramChar & 0xF)] };
  }
  
  protected void PG()
  {
    AppMethodBeat.i(74774);
    this.cCm.write(91);
    AppMethodBeat.o(74774);
  }
  
  protected void PH()
  {
    AppMethodBeat.i(74775);
    this.cCm.write(93);
    AppMethodBeat.o(74775);
  }
  
  protected void PI()
  {
    AppMethodBeat.i(74776);
    this.cCm.write(44);
    AppMethodBeat.o(74776);
  }
  
  protected void PJ()
  {
    AppMethodBeat.i(74777);
    this.cCm.write(123);
    AppMethodBeat.o(74777);
  }
  
  protected void PK()
  {
    AppMethodBeat.i(74778);
    this.cCm.write(125);
    AppMethodBeat.o(74778);
  }
  
  protected void PL()
  {
    AppMethodBeat.i(74780);
    this.cCm.write(58);
    AppMethodBeat.o(74780);
  }
  
  protected void PM()
  {
    AppMethodBeat.i(74781);
    this.cCm.write(44);
    AppMethodBeat.o(74781);
  }
  
  protected final void aU(String paramString)
  {
    AppMethodBeat.i(74773);
    this.cCm.write(34);
    cy(paramString);
    this.cCm.write(34);
    AppMethodBeat.o(74773);
  }
  
  protected final void cv(String paramString)
  {
    AppMethodBeat.i(74771);
    this.cCm.write(paramString);
    AppMethodBeat.o(74771);
  }
  
  protected final void cw(String paramString)
  {
    AppMethodBeat.i(74772);
    this.cCm.write(paramString);
    AppMethodBeat.o(74772);
  }
  
  protected final void cx(String paramString)
  {
    AppMethodBeat.i(74779);
    this.cCm.write(34);
    cy(paramString);
    this.cCm.write(34);
    AppMethodBeat.o(74779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.eclipsesource.a.i
 * JD-Core Version:    0.7.0.1
 */