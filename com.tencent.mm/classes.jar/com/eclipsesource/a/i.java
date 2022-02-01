package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;

class i
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final char[] aZZ = { 92, 34 };
  private static final char[] baa = { 92, 92 };
  private static final char[] bab = { 92, 110 };
  private static final char[] bac = { 92, 114 };
  private static final char[] bad = { 92, 116 };
  private static final char[] bae = { 92, 117, 50, 48, 50, 56 };
  private static final char[] baf = { 92, 117, 50, 48, 50, 57 };
  protected final Writer bag;
  
  i(Writer paramWriter)
  {
    this.bag = paramWriter;
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
        this.bag.write(paramString, j, i - j);
        this.bag.write(arrayOfChar);
        k = i + 1;
      }
      i += 1;
    }
    this.bag.write(paramString, j, m - j);
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
          return bae;
        }
        return baf;
        if (paramChar == '\\') {
          return baa;
        }
      } while (paramChar > '"');
      if (paramChar == '"') {
        return aZZ;
      }
    } while (paramChar > '\037');
    if (paramChar == '\n') {
      return bab;
    }
    if (paramChar == '\r') {
      return bac;
    }
    if (paramChar == '\t') {
      return bad;
    }
    return new char[] { '\\', 'u', '0', '0', HEX_DIGITS[(paramChar >> '\004' & 0xF)], HEX_DIGITS[(paramChar & 0xF)] };
  }
  
  protected final void aX(String paramString)
  {
    AppMethodBeat.i(74771);
    this.bag.write(paramString);
    AppMethodBeat.o(74771);
  }
  
  protected final void aY(String paramString)
  {
    AppMethodBeat.i(74772);
    this.bag.write(paramString);
    AppMethodBeat.o(74772);
  }
  
  protected final void aZ(String paramString)
  {
    AppMethodBeat.i(74779);
    this.bag.write(34);
    ba(paramString);
    this.bag.write(34);
    AppMethodBeat.o(74779);
  }
  
  protected void sH()
  {
    AppMethodBeat.i(74774);
    this.bag.write(91);
    AppMethodBeat.o(74774);
  }
  
  protected void sI()
  {
    AppMethodBeat.i(74775);
    this.bag.write(93);
    AppMethodBeat.o(74775);
  }
  
  protected void sJ()
  {
    AppMethodBeat.i(74776);
    this.bag.write(44);
    AppMethodBeat.o(74776);
  }
  
  protected void sK()
  {
    AppMethodBeat.i(74777);
    this.bag.write(123);
    AppMethodBeat.o(74777);
  }
  
  protected void sL()
  {
    AppMethodBeat.i(74778);
    this.bag.write(125);
    AppMethodBeat.o(74778);
  }
  
  protected void sM()
  {
    AppMethodBeat.i(74780);
    this.bag.write(58);
    AppMethodBeat.o(74780);
  }
  
  protected void sN()
  {
    AppMethodBeat.i(74781);
    this.bag.write(44);
    AppMethodBeat.o(74781);
  }
  
  protected final void writeString(String paramString)
  {
    AppMethodBeat.i(74773);
    this.bag.write(34);
    ba(paramString);
    this.bag.write(34);
    AppMethodBeat.o(74773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.a.i
 * JD-Core Version:    0.7.0.1
 */