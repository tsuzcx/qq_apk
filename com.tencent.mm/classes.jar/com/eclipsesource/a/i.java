package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;

class i
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final char[] bad = { 92, 34 };
  private static final char[] bae = { 92, 92 };
  private static final char[] baf = { 92, 110 };
  private static final char[] bag = { 92, 114 };
  private static final char[] bah = { 92, 116 };
  private static final char[] bai = { 92, 117, 50, 48, 50, 56 };
  private static final char[] baj = { 92, 117, 50, 48, 50, 57 };
  protected final Writer bak;
  
  i(Writer paramWriter)
  {
    this.bak = paramWriter;
  }
  
  private void ba(String paramString)
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
        this.bak.write(paramString, j, i - j);
        this.bak.write(arrayOfChar);
        k = i + 1;
      }
      i += 1;
    }
    this.bak.write(paramString, j, m - j);
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
          return bai;
        }
        return baj;
        if (paramChar == '\\') {
          return bae;
        }
      } while (paramChar > '"');
      if (paramChar == '"') {
        return bad;
      }
    } while (paramChar > '\037');
    if (paramChar == '\n') {
      return baf;
    }
    if (paramChar == '\r') {
      return bag;
    }
    if (paramChar == '\t') {
      return bah;
    }
    return new char[] { '\\', 'u', '0', '0', HEX_DIGITS[(paramChar >> '\004' & 0xF)], HEX_DIGITS[(paramChar & 0xF)] };
  }
  
  protected final void aX(String paramString)
  {
    AppMethodBeat.i(74771);
    this.bak.write(paramString);
    AppMethodBeat.o(74771);
  }
  
  protected final void aY(String paramString)
  {
    AppMethodBeat.i(74772);
    this.bak.write(paramString);
    AppMethodBeat.o(74772);
  }
  
  protected final void aZ(String paramString)
  {
    AppMethodBeat.i(74779);
    this.bak.write(34);
    ba(paramString);
    this.bak.write(34);
    AppMethodBeat.o(74779);
  }
  
  protected void sE()
  {
    AppMethodBeat.i(74774);
    this.bak.write(91);
    AppMethodBeat.o(74774);
  }
  
  protected void sF()
  {
    AppMethodBeat.i(74775);
    this.bak.write(93);
    AppMethodBeat.o(74775);
  }
  
  protected void sG()
  {
    AppMethodBeat.i(74776);
    this.bak.write(44);
    AppMethodBeat.o(74776);
  }
  
  protected void sH()
  {
    AppMethodBeat.i(74777);
    this.bak.write(123);
    AppMethodBeat.o(74777);
  }
  
  protected void sI()
  {
    AppMethodBeat.i(74778);
    this.bak.write(125);
    AppMethodBeat.o(74778);
  }
  
  protected void sJ()
  {
    AppMethodBeat.i(74780);
    this.bak.write(58);
    AppMethodBeat.o(74780);
  }
  
  protected void sK()
  {
    AppMethodBeat.i(74781);
    this.bak.write(44);
    AppMethodBeat.o(74781);
  }
  
  protected final void writeString(String paramString)
  {
    AppMethodBeat.i(74773);
    this.bak.write(34);
    ba(paramString);
    this.bak.write(34);
    AppMethodBeat.o(74773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.a.i
 * JD-Core Version:    0.7.0.1
 */