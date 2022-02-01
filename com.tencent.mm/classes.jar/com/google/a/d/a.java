package com.google.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class a
  implements Closeable, Flushable
{
  private static final String[] bQA;
  private static final String[] bQz;
  public boolean bNd;
  public boolean bNg;
  public boolean bNi;
  private int[] bQB;
  private int bQC;
  private String bQD;
  private String bQE;
  private final Writer out;
  private String separator;
  
  static
  {
    AppMethodBeat.i(107869);
    bQz = new String[''];
    int i = 0;
    while (i <= 31)
    {
      bQz[i] = String.format("\\u%04x", new Object[] { Integer.valueOf(i) });
      i += 1;
    }
    bQz[34] = "\\\"";
    bQz[92] = "\\\\";
    bQz[9] = "\\t";
    bQz[8] = "\\b";
    bQz[10] = "\\n";
    bQz[13] = "\\r";
    bQz[12] = "\\f";
    String[] arrayOfString = (String[])bQz.clone();
    bQA = arrayOfString;
    arrayOfString[60] = "\\u003c";
    bQA[62] = "\\u003e";
    bQA[38] = "\\u0026";
    bQA[61] = "\\u003d";
    bQA[39] = "\\u0027";
    AppMethodBeat.o(107869);
  }
  
  public a(Writer paramWriter)
  {
    AppMethodBeat.i(107845);
    this.bQB = new int[32];
    this.bQC = 0;
    fC(6);
    this.separator = ":";
    this.bNd = true;
    if (paramWriter == null)
    {
      paramWriter = new NullPointerException("out == null");
      AppMethodBeat.o(107845);
      throw paramWriter;
    }
    this.out = paramWriter;
    AppMethodBeat.o(107845);
  }
  
  private a c(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(107852);
    int i = yW();
    if ((i != paramInt2) && (i != paramInt1))
    {
      paramString = new IllegalStateException("Nesting problem.");
      AppMethodBeat.o(107852);
      throw paramString;
    }
    if (this.bQE != null)
    {
      paramString = new IllegalStateException("Dangling name: " + this.bQE);
      AppMethodBeat.o(107852);
      throw paramString;
    }
    this.bQC -= 1;
    if (i == paramInt2) {
      yY();
    }
    this.out.write(paramString);
    AppMethodBeat.o(107852);
    return this;
  }
  
  private a c(int paramInt, String paramString)
  {
    AppMethodBeat.i(107851);
    za();
    fC(paramInt);
    this.out.write(paramString);
    AppMethodBeat.o(107851);
    return this;
  }
  
  private void cb(String paramString)
  {
    AppMethodBeat.i(107865);
    if (this.bNg) {}
    int m;
    int i;
    int j;
    int n;
    int k;
    for (String[] arrayOfString = bQA;; arrayOfString = bQz)
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
  
  private void fC(int paramInt)
  {
    AppMethodBeat.i(107853);
    if (this.bQC == this.bQB.length)
    {
      arrayOfInt = new int[this.bQC * 2];
      System.arraycopy(this.bQB, 0, arrayOfInt, 0, this.bQC);
      this.bQB = arrayOfInt;
    }
    int[] arrayOfInt = this.bQB;
    int i = this.bQC;
    this.bQC = (i + 1);
    arrayOfInt[i] = paramInt;
    AppMethodBeat.o(107853);
  }
  
  private void fD(int paramInt)
  {
    this.bQB[(this.bQC - 1)] = paramInt;
  }
  
  private int yW()
  {
    AppMethodBeat.i(107854);
    if (this.bQC == 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("JsonWriter is closed.");
      AppMethodBeat.o(107854);
      throw localIllegalStateException;
    }
    int i = this.bQB[(this.bQC - 1)];
    AppMethodBeat.o(107854);
    return i;
  }
  
  private void yX()
  {
    AppMethodBeat.i(107856);
    if (this.bQE != null)
    {
      yZ();
      cb(this.bQE);
      this.bQE = null;
    }
    AppMethodBeat.o(107856);
  }
  
  private void yY()
  {
    AppMethodBeat.i(107866);
    if (this.bQD == null)
    {
      AppMethodBeat.o(107866);
      return;
    }
    this.out.write("\n");
    int i = 1;
    int j = this.bQC;
    while (i < j)
    {
      this.out.write(this.bQD);
      i += 1;
    }
    AppMethodBeat.o(107866);
  }
  
  private void yZ()
  {
    AppMethodBeat.i(107867);
    int i = yW();
    if (i == 5) {
      this.out.write(44);
    }
    while (i == 3)
    {
      yY();
      fD(4);
      AppMethodBeat.o(107867);
      return;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("Nesting problem.");
    AppMethodBeat.o(107867);
    throw localIllegalStateException;
  }
  
  private void za()
  {
    AppMethodBeat.i(107868);
    IllegalStateException localIllegalStateException;
    switch (yW())
    {
    case 3: 
    case 5: 
    default: 
      localIllegalStateException = new IllegalStateException("Nesting problem.");
      AppMethodBeat.o(107868);
      throw localIllegalStateException;
    case 7: 
      if (!this.bNi)
      {
        localIllegalStateException = new IllegalStateException("JSON must have only one top-level value.");
        AppMethodBeat.o(107868);
        throw localIllegalStateException;
      }
    case 6: 
      fD(7);
      AppMethodBeat.o(107868);
      return;
    case 1: 
      fD(2);
      yY();
      AppMethodBeat.o(107868);
      return;
    case 2: 
      this.out.append(',');
      yY();
      AppMethodBeat.o(107868);
      return;
    }
    this.out.append(this.separator);
    fD(5);
    AppMethodBeat.o(107868);
  }
  
  public a a(Number paramNumber)
  {
    AppMethodBeat.i(107862);
    if (paramNumber == null)
    {
      paramNumber = yS();
      AppMethodBeat.o(107862);
      return paramNumber;
    }
    yX();
    String str = paramNumber.toString();
    if ((!this.bNi) && ((str.equals("-Infinity")) || (str.equals("Infinity")) || (str.equals("NaN"))))
    {
      paramNumber = new IllegalArgumentException("Numeric values must be finite, but was ".concat(String.valueOf(paramNumber)));
      AppMethodBeat.o(107862);
      throw paramNumber;
    }
    za();
    this.out.append(str);
    AppMethodBeat.o(107862);
    return this;
  }
  
  public a av(long paramLong)
  {
    AppMethodBeat.i(107861);
    yX();
    za();
    this.out.write(Long.toString(paramLong));
    AppMethodBeat.o(107861);
    return this;
  }
  
  public a b(Boolean paramBoolean)
  {
    AppMethodBeat.i(107860);
    if (paramBoolean == null)
    {
      paramBoolean = yS();
      AppMethodBeat.o(107860);
      return paramBoolean;
    }
    yX();
    za();
    Writer localWriter = this.out;
    if (paramBoolean.booleanValue()) {}
    for (paramBoolean = "true";; paramBoolean = "false")
    {
      localWriter.write(paramBoolean);
      AppMethodBeat.o(107860);
      return this;
    }
  }
  
  public a bZ(String paramString)
  {
    AppMethodBeat.i(107855);
    if (paramString == null)
    {
      paramString = new NullPointerException("name == null");
      AppMethodBeat.o(107855);
      throw paramString;
    }
    if (this.bQE != null)
    {
      paramString = new IllegalStateException();
      AppMethodBeat.o(107855);
      throw paramString;
    }
    if (this.bQC == 0)
    {
      paramString = new IllegalStateException("JsonWriter is closed.");
      AppMethodBeat.o(107855);
      throw paramString;
    }
    this.bQE = paramString;
    AppMethodBeat.o(107855);
    return this;
  }
  
  public a bg(boolean paramBoolean)
  {
    AppMethodBeat.i(107859);
    yX();
    za();
    Writer localWriter = this.out;
    if (paramBoolean) {}
    for (String str = "true";; str = "false")
    {
      localWriter.write(str);
      AppMethodBeat.o(107859);
      return this;
    }
  }
  
  public a ca(String paramString)
  {
    AppMethodBeat.i(107857);
    if (paramString == null)
    {
      paramString = yS();
      AppMethodBeat.o(107857);
      return paramString;
    }
    yX();
    za();
    cb(paramString);
    AppMethodBeat.o(107857);
    return this;
  }
  
  public void close()
  {
    AppMethodBeat.i(107864);
    this.out.close();
    int i = this.bQC;
    if ((i > 1) || ((i == 1) && (this.bQB[(i - 1)] != 7)))
    {
      IOException localIOException = new IOException("Incomplete document");
      AppMethodBeat.o(107864);
      throw localIOException;
    }
    this.bQC = 0;
    AppMethodBeat.o(107864);
  }
  
  public void flush()
  {
    AppMethodBeat.i(107863);
    if (this.bQC == 0)
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
      this.bQD = null;
      this.separator = ":";
      AppMethodBeat.o(107846);
      return;
    }
    this.bQD = paramString;
    this.separator = ": ";
    AppMethodBeat.o(107846);
  }
  
  public a yO()
  {
    AppMethodBeat.i(107847);
    yX();
    a locala = c(1, "[");
    AppMethodBeat.o(107847);
    return locala;
  }
  
  public a yP()
  {
    AppMethodBeat.i(107848);
    a locala = c(1, 2, "]");
    AppMethodBeat.o(107848);
    return locala;
  }
  
  public a yQ()
  {
    AppMethodBeat.i(107849);
    yX();
    a locala = c(3, "{");
    AppMethodBeat.o(107849);
    return locala;
  }
  
  public a yR()
  {
    AppMethodBeat.i(107850);
    a locala = c(3, 5, "}");
    AppMethodBeat.o(107850);
    return locala;
  }
  
  public a yS()
  {
    AppMethodBeat.i(107858);
    if (this.bQE != null)
    {
      if (this.bNd) {
        yX();
      }
    }
    else
    {
      za();
      this.out.write("null");
      AppMethodBeat.o(107858);
      return this;
    }
    this.bQE = null;
    AppMethodBeat.o(107858);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.a.d.a
 * JD-Core Version:    0.7.0.1
 */