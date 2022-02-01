package com.google.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class a
  implements Closeable, Flushable
{
  private static final String[] bID;
  private static final String[] bIE;
  public boolean bFh;
  public boolean bFk;
  public boolean bFm;
  private int[] bIF;
  private int bIG;
  private String bIH;
  private String bII;
  private final Writer out;
  private String separator;
  
  static
  {
    AppMethodBeat.i(107869);
    bID = new String[''];
    int i = 0;
    while (i <= 31)
    {
      bID[i] = String.format("\\u%04x", new Object[] { Integer.valueOf(i) });
      i += 1;
    }
    bID[34] = "\\\"";
    bID[92] = "\\\\";
    bID[9] = "\\t";
    bID[8] = "\\b";
    bID[10] = "\\n";
    bID[13] = "\\r";
    bID[12] = "\\f";
    String[] arrayOfString = (String[])bID.clone();
    bIE = arrayOfString;
    arrayOfString[60] = "\\u003c";
    bIE[62] = "\\u003e";
    bIE[38] = "\\u0026";
    bIE[61] = "\\u003d";
    bIE[39] = "\\u0027";
    AppMethodBeat.o(107869);
  }
  
  public a(Writer paramWriter)
  {
    AppMethodBeat.i(107845);
    this.bIF = new int[32];
    this.bIG = 0;
    fN(6);
    this.separator = ":";
    this.bFh = true;
    if (paramWriter == null)
    {
      paramWriter = new NullPointerException("out == null");
      AppMethodBeat.o(107845);
      throw paramWriter;
    }
    this.out = paramWriter;
    AppMethodBeat.o(107845);
  }
  
  private void br(String paramString)
  {
    AppMethodBeat.i(107865);
    if (this.bFk) {}
    int m;
    int i;
    int j;
    int n;
    int k;
    for (String[] arrayOfString = bIE;; arrayOfString = bID)
    {
      this.out.write("\"");
      m = paramString.length();
      i = 0;
      for (j = 0;; j = k)
      {
        if (i >= m) {
          break label158;
        }
        n = paramString.charAt(i);
        if (n >= 128) {
          break;
        }
        String str2 = arrayOfString[n];
        str1 = str2;
        if (str2 != null) {
          break label106;
        }
        k = j;
        i += 1;
      }
    }
    if (n == 8232) {}
    for (String str1 = "\\u2028";; str1 = "\\u2029")
    {
      label106:
      if (j < i) {
        this.out.write(paramString, j, i - j);
      }
      this.out.write(str1);
      k = i + 1;
      break;
      k = j;
      if (n != 8233) {
        break;
      }
    }
    label158:
    if (j < m) {
      this.out.write(paramString, j, m - j);
    }
    this.out.write("\"");
    AppMethodBeat.o(107865);
  }
  
  private a c(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(107852);
    int i = xM();
    if ((i != paramInt2) && (i != paramInt1))
    {
      paramString = new IllegalStateException("Nesting problem.");
      AppMethodBeat.o(107852);
      throw paramString;
    }
    if (this.bII != null)
    {
      paramString = new IllegalStateException("Dangling name: " + this.bII);
      AppMethodBeat.o(107852);
      throw paramString;
    }
    this.bIG -= 1;
    if (i == paramInt2) {
      xO();
    }
    this.out.write(paramString);
    AppMethodBeat.o(107852);
    return this;
  }
  
  private a c(int paramInt, String paramString)
  {
    AppMethodBeat.i(107851);
    xQ();
    fN(paramInt);
    this.out.write(paramString);
    AppMethodBeat.o(107851);
    return this;
  }
  
  private void fN(int paramInt)
  {
    AppMethodBeat.i(107853);
    if (this.bIG == this.bIF.length)
    {
      arrayOfInt = new int[this.bIG * 2];
      System.arraycopy(this.bIF, 0, arrayOfInt, 0, this.bIG);
      this.bIF = arrayOfInt;
    }
    int[] arrayOfInt = this.bIF;
    int i = this.bIG;
    this.bIG = (i + 1);
    arrayOfInt[i] = paramInt;
    AppMethodBeat.o(107853);
  }
  
  private void fO(int paramInt)
  {
    this.bIF[(this.bIG - 1)] = paramInt;
  }
  
  private int xM()
  {
    AppMethodBeat.i(107854);
    if (this.bIG == 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("JsonWriter is closed.");
      AppMethodBeat.o(107854);
      throw localIllegalStateException;
    }
    int i = this.bIF[(this.bIG - 1)];
    AppMethodBeat.o(107854);
    return i;
  }
  
  private void xN()
  {
    AppMethodBeat.i(107856);
    if (this.bII != null)
    {
      xP();
      br(this.bII);
      this.bII = null;
    }
    AppMethodBeat.o(107856);
  }
  
  private void xO()
  {
    AppMethodBeat.i(107866);
    if (this.bIH == null)
    {
      AppMethodBeat.o(107866);
      return;
    }
    this.out.write("\n");
    int i = 1;
    int j = this.bIG;
    while (i < j)
    {
      this.out.write(this.bIH);
      i += 1;
    }
    AppMethodBeat.o(107866);
  }
  
  private void xP()
  {
    AppMethodBeat.i(107867);
    int i = xM();
    if (i == 5) {
      this.out.write(44);
    }
    while (i == 3)
    {
      xO();
      fO(4);
      AppMethodBeat.o(107867);
      return;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("Nesting problem.");
    AppMethodBeat.o(107867);
    throw localIllegalStateException;
  }
  
  private void xQ()
  {
    AppMethodBeat.i(107868);
    IllegalStateException localIllegalStateException;
    switch (xM())
    {
    case 3: 
    case 5: 
    default: 
      localIllegalStateException = new IllegalStateException("Nesting problem.");
      AppMethodBeat.o(107868);
      throw localIllegalStateException;
    case 7: 
      if (!this.bFm)
      {
        localIllegalStateException = new IllegalStateException("JSON must have only one top-level value.");
        AppMethodBeat.o(107868);
        throw localIllegalStateException;
      }
    case 6: 
      fO(7);
      AppMethodBeat.o(107868);
      return;
    case 1: 
      fO(2);
      xO();
      AppMethodBeat.o(107868);
      return;
    case 2: 
      this.out.append(',');
      xO();
      AppMethodBeat.o(107868);
      return;
    }
    this.out.append(this.separator);
    fO(5);
    AppMethodBeat.o(107868);
  }
  
  public a a(Boolean paramBoolean)
  {
    AppMethodBeat.i(107860);
    if (paramBoolean == null)
    {
      paramBoolean = xI();
      AppMethodBeat.o(107860);
      return paramBoolean;
    }
    xN();
    xQ();
    Writer localWriter = this.out;
    if (paramBoolean.booleanValue()) {}
    for (paramBoolean = "true";; paramBoolean = "false")
    {
      localWriter.write(paramBoolean);
      AppMethodBeat.o(107860);
      return this;
    }
  }
  
  public a a(Number paramNumber)
  {
    AppMethodBeat.i(107862);
    if (paramNumber == null)
    {
      paramNumber = xI();
      AppMethodBeat.o(107862);
      return paramNumber;
    }
    xN();
    String str = paramNumber.toString();
    if ((!this.bFm) && ((str.equals("-Infinity")) || (str.equals("Infinity")) || (str.equals("NaN"))))
    {
      paramNumber = new IllegalArgumentException("Numeric values must be finite, but was ".concat(String.valueOf(paramNumber)));
      AppMethodBeat.o(107862);
      throw paramNumber;
    }
    xQ();
    this.out.append(str);
    AppMethodBeat.o(107862);
    return this;
  }
  
  public a az(long paramLong)
  {
    AppMethodBeat.i(107861);
    xN();
    xQ();
    this.out.write(Long.toString(paramLong));
    AppMethodBeat.o(107861);
    return this;
  }
  
  public a bg(boolean paramBoolean)
  {
    AppMethodBeat.i(107859);
    xN();
    xQ();
    Writer localWriter = this.out;
    if (paramBoolean) {}
    for (String str = "true";; str = "false")
    {
      localWriter.write(str);
      AppMethodBeat.o(107859);
      return this;
    }
  }
  
  public a bp(String paramString)
  {
    AppMethodBeat.i(107855);
    if (paramString == null)
    {
      paramString = new NullPointerException("name == null");
      AppMethodBeat.o(107855);
      throw paramString;
    }
    if (this.bII != null)
    {
      paramString = new IllegalStateException();
      AppMethodBeat.o(107855);
      throw paramString;
    }
    if (this.bIG == 0)
    {
      paramString = new IllegalStateException("JsonWriter is closed.");
      AppMethodBeat.o(107855);
      throw paramString;
    }
    this.bII = paramString;
    AppMethodBeat.o(107855);
    return this;
  }
  
  public a bq(String paramString)
  {
    AppMethodBeat.i(107857);
    if (paramString == null)
    {
      paramString = xI();
      AppMethodBeat.o(107857);
      return paramString;
    }
    xN();
    xQ();
    br(paramString);
    AppMethodBeat.o(107857);
    return this;
  }
  
  public void close()
  {
    AppMethodBeat.i(107864);
    this.out.close();
    int i = this.bIG;
    if ((i > 1) || ((i == 1) && (this.bIF[(i - 1)] != 7)))
    {
      IOException localIOException = new IOException("Incomplete document");
      AppMethodBeat.o(107864);
      throw localIOException;
    }
    this.bIG = 0;
    AppMethodBeat.o(107864);
  }
  
  public void flush()
  {
    AppMethodBeat.i(107863);
    if (this.bIG == 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("JsonWriter is closed.");
      AppMethodBeat.o(107863);
      throw localIllegalStateException;
    }
    this.out.flush();
    AppMethodBeat.o(107863);
  }
  
  public final void setIndent(String paramString)
  {
    AppMethodBeat.i(107846);
    if (paramString.length() == 0)
    {
      this.bIH = null;
      this.separator = ":";
      AppMethodBeat.o(107846);
      return;
    }
    this.bIH = paramString;
    this.separator = ": ";
    AppMethodBeat.o(107846);
  }
  
  public a xE()
  {
    AppMethodBeat.i(107847);
    xN();
    a locala = c(1, "[");
    AppMethodBeat.o(107847);
    return locala;
  }
  
  public a xF()
  {
    AppMethodBeat.i(107848);
    a locala = c(1, 2, "]");
    AppMethodBeat.o(107848);
    return locala;
  }
  
  public a xG()
  {
    AppMethodBeat.i(107849);
    xN();
    a locala = c(3, "{");
    AppMethodBeat.o(107849);
    return locala;
  }
  
  public a xH()
  {
    AppMethodBeat.i(107850);
    a locala = c(3, 5, "}");
    AppMethodBeat.o(107850);
    return locala;
  }
  
  public a xI()
  {
    AppMethodBeat.i(107858);
    if (this.bII != null)
    {
      if (this.bFh) {
        xN();
      }
    }
    else
    {
      xQ();
      this.out.write("null");
      AppMethodBeat.o(107858);
      return this;
    }
    this.bII = null;
    AppMethodBeat.o(107858);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.a.d.a
 * JD-Core Version:    0.7.0.1
 */