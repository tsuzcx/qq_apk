package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;

class i
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final char[] aOT = { 92, 34 };
  private static final char[] aOU = { 92, 92 };
  private static final char[] aOV = { 92, 110 };
  private static final char[] aOW = { 92, 114 };
  private static final char[] aOX = { 92, 116 };
  private static final char[] aOY = { 92, 117, 50, 48, 50, 56 };
  private static final char[] aOZ = { 92, 117, 50, 48, 50, 57 };
  protected final Writer aPa;
  
  i(Writer paramWriter)
  {
    this.aPa = paramWriter;
  }
  
  private void ag(String paramString)
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
        this.aPa.write(paramString, j, i - j);
        this.aPa.write(arrayOfChar);
        k = i + 1;
      }
      i += 1;
    }
    this.aPa.write(paramString, j, m - j);
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
          return aOY;
        }
        return aOZ;
        if (paramChar == '\\') {
          return aOU;
        }
      } while (paramChar > '"');
      if (paramChar == '"') {
        return aOT;
      }
    } while (paramChar > '\037');
    if (paramChar == '\n') {
      return aOV;
    }
    if (paramChar == '\r') {
      return aOW;
    }
    if (paramChar == '\t') {
      return aOX;
    }
    return new char[] { '\\', 'u', '0', '0', HEX_DIGITS[(paramChar >> '\004' & 0xF)], HEX_DIGITS[(paramChar & 0xF)] };
  }
  
  protected final void ad(String paramString)
  {
    AppMethodBeat.i(74771);
    this.aPa.write(paramString);
    AppMethodBeat.o(74771);
  }
  
  protected final void ae(String paramString)
  {
    AppMethodBeat.i(74772);
    this.aPa.write(paramString);
    AppMethodBeat.o(74772);
  }
  
  protected final void af(String paramString)
  {
    AppMethodBeat.i(74779);
    this.aPa.write(34);
    ag(paramString);
    this.aPa.write(34);
    AppMethodBeat.o(74779);
  }
  
  protected void qW()
  {
    AppMethodBeat.i(74774);
    this.aPa.write(91);
    AppMethodBeat.o(74774);
  }
  
  protected void qX()
  {
    AppMethodBeat.i(74775);
    this.aPa.write(93);
    AppMethodBeat.o(74775);
  }
  
  protected void qY()
  {
    AppMethodBeat.i(74776);
    this.aPa.write(44);
    AppMethodBeat.o(74776);
  }
  
  protected void qZ()
  {
    AppMethodBeat.i(74777);
    this.aPa.write(123);
    AppMethodBeat.o(74777);
  }
  
  protected void ra()
  {
    AppMethodBeat.i(74778);
    this.aPa.write(125);
    AppMethodBeat.o(74778);
  }
  
  protected void rb()
  {
    AppMethodBeat.i(74780);
    this.aPa.write(58);
    AppMethodBeat.o(74780);
  }
  
  protected void rc()
  {
    AppMethodBeat.i(74781);
    this.aPa.write(44);
    AppMethodBeat.o(74781);
  }
  
  protected final void writeString(String paramString)
  {
    AppMethodBeat.i(74773);
    this.aPa.write(34);
    ag(paramString);
    this.aPa.write(34);
    AppMethodBeat.o(74773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.a.i
 * JD-Core Version:    0.7.0.1
 */