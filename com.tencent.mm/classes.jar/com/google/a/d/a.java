package com.google.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class a
  implements Closeable, Flushable
{
  private static final String[] bGl;
  private static final String[] bGm;
  public boolean bCP;
  public boolean bCS;
  public boolean bCU;
  private int[] bGn;
  private int bGo;
  private String bGp;
  private String bGq;
  private final Writer out;
  private String separator;
  
  static
  {
    AppMethodBeat.i(107869);
    bGl = new String[''];
    int i = 0;
    while (i <= 31)
    {
      bGl[i] = String.format("\\u%04x", new Object[] { Integer.valueOf(i) });
      i += 1;
    }
    bGl[34] = "\\\"";
    bGl[92] = "\\\\";
    bGl[9] = "\\t";
    bGl[8] = "\\b";
    bGl[10] = "\\n";
    bGl[13] = "\\r";
    bGl[12] = "\\f";
    String[] arrayOfString = (String[])bGl.clone();
    bGm = arrayOfString;
    arrayOfString[60] = "\\u003c";
    bGm[62] = "\\u003e";
    bGm[38] = "\\u0026";
    bGm[61] = "\\u003d";
    bGm[39] = "\\u0027";
    AppMethodBeat.o(107869);
  }
  
  public a(Writer paramWriter)
  {
    AppMethodBeat.i(107845);
    this.bGn = new int[32];
    this.bGo = 0;
    fz(6);
    this.separator = ":";
    this.bCP = true;
    if (paramWriter == null)
    {
      paramWriter = new NullPointerException("out == null");
      AppMethodBeat.o(107845);
      throw paramWriter;
    }
    this.out = paramWriter;
    AppMethodBeat.o(107845);
  }
  
  private void bi(String paramString)
  {
    AppMethodBeat.i(107865);
    if (this.bCS) {}
    int m;
    int i;
    int j;
    int n;
    int k;
    for (String[] arrayOfString = bGm;; arrayOfString = bGl)
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
    int i = xz();
    if ((i != paramInt2) && (i != paramInt1))
    {
      paramString = new IllegalStateException("Nesting problem.");
      AppMethodBeat.o(107852);
      throw paramString;
    }
    if (this.bGq != null)
    {
      paramString = new IllegalStateException("Dangling name: " + this.bGq);
      AppMethodBeat.o(107852);
      throw paramString;
    }
    this.bGo -= 1;
    if (i == paramInt2) {
      xB();
    }
    this.out.write(paramString);
    AppMethodBeat.o(107852);
    return this;
  }
  
  private a c(int paramInt, String paramString)
  {
    AppMethodBeat.i(107851);
    xD();
    fz(paramInt);
    this.out.write(paramString);
    AppMethodBeat.o(107851);
    return this;
  }
  
  private void fA(int paramInt)
  {
    this.bGn[(this.bGo - 1)] = paramInt;
  }
  
  private void fz(int paramInt)
  {
    AppMethodBeat.i(107853);
    if (this.bGo == this.bGn.length)
    {
      arrayOfInt = new int[this.bGo * 2];
      System.arraycopy(this.bGn, 0, arrayOfInt, 0, this.bGo);
      this.bGn = arrayOfInt;
    }
    int[] arrayOfInt = this.bGn;
    int i = this.bGo;
    this.bGo = (i + 1);
    arrayOfInt[i] = paramInt;
    AppMethodBeat.o(107853);
  }
  
  private void xA()
  {
    AppMethodBeat.i(107856);
    if (this.bGq != null)
    {
      xC();
      bi(this.bGq);
      this.bGq = null;
    }
    AppMethodBeat.o(107856);
  }
  
  private void xB()
  {
    AppMethodBeat.i(107866);
    if (this.bGp == null)
    {
      AppMethodBeat.o(107866);
      return;
    }
    this.out.write("\n");
    int i = 1;
    int j = this.bGo;
    while (i < j)
    {
      this.out.write(this.bGp);
      i += 1;
    }
    AppMethodBeat.o(107866);
  }
  
  private void xC()
  {
    AppMethodBeat.i(107867);
    int i = xz();
    if (i == 5) {
      this.out.write(44);
    }
    while (i == 3)
    {
      xB();
      fA(4);
      AppMethodBeat.o(107867);
      return;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("Nesting problem.");
    AppMethodBeat.o(107867);
    throw localIllegalStateException;
  }
  
  private void xD()
  {
    AppMethodBeat.i(107868);
    IllegalStateException localIllegalStateException;
    switch (xz())
    {
    case 3: 
    case 5: 
    default: 
      localIllegalStateException = new IllegalStateException("Nesting problem.");
      AppMethodBeat.o(107868);
      throw localIllegalStateException;
    case 7: 
      if (!this.bCU)
      {
        localIllegalStateException = new IllegalStateException("JSON must have only one top-level value.");
        AppMethodBeat.o(107868);
        throw localIllegalStateException;
      }
    case 6: 
      fA(7);
      AppMethodBeat.o(107868);
      return;
    case 1: 
      fA(2);
      xB();
      AppMethodBeat.o(107868);
      return;
    case 2: 
      this.out.append(',');
      xB();
      AppMethodBeat.o(107868);
      return;
    }
    this.out.append(this.separator);
    fA(5);
    AppMethodBeat.o(107868);
  }
  
  private int xz()
  {
    AppMethodBeat.i(107854);
    if (this.bGo == 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("JsonWriter is closed.");
      AppMethodBeat.o(107854);
      throw localIllegalStateException;
    }
    int i = this.bGn[(this.bGo - 1)];
    AppMethodBeat.o(107854);
    return i;
  }
  
  public a a(Boolean paramBoolean)
  {
    AppMethodBeat.i(107860);
    if (paramBoolean == null)
    {
      paramBoolean = xv();
      AppMethodBeat.o(107860);
      return paramBoolean;
    }
    xA();
    xD();
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
      paramNumber = xv();
      AppMethodBeat.o(107862);
      return paramNumber;
    }
    xA();
    String str = paramNumber.toString();
    if ((!this.bCU) && ((str.equals("-Infinity")) || (str.equals("Infinity")) || (str.equals("NaN"))))
    {
      paramNumber = new IllegalArgumentException("Numeric values must be finite, but was ".concat(String.valueOf(paramNumber)));
      AppMethodBeat.o(107862);
      throw paramNumber;
    }
    xD();
    this.out.append(str);
    AppMethodBeat.o(107862);
    return this;
  }
  
  public a av(long paramLong)
  {
    AppMethodBeat.i(107861);
    xA();
    xD();
    this.out.write(Long.toString(paramLong));
    AppMethodBeat.o(107861);
    return this;
  }
  
  public a bf(boolean paramBoolean)
  {
    AppMethodBeat.i(107859);
    xA();
    xD();
    Writer localWriter = this.out;
    if (paramBoolean) {}
    for (String str = "true";; str = "false")
    {
      localWriter.write(str);
      AppMethodBeat.o(107859);
      return this;
    }
  }
  
  public a bg(String paramString)
  {
    AppMethodBeat.i(107855);
    if (paramString == null)
    {
      paramString = new NullPointerException("name == null");
      AppMethodBeat.o(107855);
      throw paramString;
    }
    if (this.bGq != null)
    {
      paramString = new IllegalStateException();
      AppMethodBeat.o(107855);
      throw paramString;
    }
    if (this.bGo == 0)
    {
      paramString = new IllegalStateException("JsonWriter is closed.");
      AppMethodBeat.o(107855);
      throw paramString;
    }
    this.bGq = paramString;
    AppMethodBeat.o(107855);
    return this;
  }
  
  public a bh(String paramString)
  {
    AppMethodBeat.i(107857);
    if (paramString == null)
    {
      paramString = xv();
      AppMethodBeat.o(107857);
      return paramString;
    }
    xA();
    xD();
    bi(paramString);
    AppMethodBeat.o(107857);
    return this;
  }
  
  public void close()
  {
    AppMethodBeat.i(107864);
    this.out.close();
    int i = this.bGo;
    if ((i > 1) || ((i == 1) && (this.bGn[(i - 1)] != 7)))
    {
      IOException localIOException = new IOException("Incomplete document");
      AppMethodBeat.o(107864);
      throw localIOException;
    }
    this.bGo = 0;
    AppMethodBeat.o(107864);
  }
  
  public void flush()
  {
    AppMethodBeat.i(107863);
    if (this.bGo == 0)
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
      this.bGp = null;
      this.separator = ":";
      AppMethodBeat.o(107846);
      return;
    }
    this.bGp = paramString;
    this.separator = ": ";
    AppMethodBeat.o(107846);
  }
  
  public a xr()
  {
    AppMethodBeat.i(107847);
    xA();
    a locala = c(1, "[");
    AppMethodBeat.o(107847);
    return locala;
  }
  
  public a xs()
  {
    AppMethodBeat.i(107848);
    a locala = c(1, 2, "]");
    AppMethodBeat.o(107848);
    return locala;
  }
  
  public a xt()
  {
    AppMethodBeat.i(107849);
    xA();
    a locala = c(3, "{");
    AppMethodBeat.o(107849);
    return locala;
  }
  
  public a xu()
  {
    AppMethodBeat.i(107850);
    a locala = c(3, 5, "}");
    AppMethodBeat.o(107850);
    return locala;
  }
  
  public a xv()
  {
    AppMethodBeat.i(107858);
    if (this.bGq != null)
    {
      if (this.bCP) {
        xA();
      }
    }
    else
    {
      xD();
      this.out.write("null");
      AppMethodBeat.o(107858);
      return this;
    }
    this.bGq = null;
    AppMethodBeat.o(107858);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.a.d.a
 * JD-Core Version:    0.7.0.1
 */