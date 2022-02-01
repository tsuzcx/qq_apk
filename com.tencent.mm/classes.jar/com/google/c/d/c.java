package com.google.c.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class c
  implements Closeable, Flushable
{
  private static final String[] dIy;
  private static final String[] dIz;
  private boolean dEE;
  private boolean dEH;
  public boolean dEJ;
  private final Writer dIA;
  private String dIB;
  private String dIC;
  private String dID;
  private int[] dIj;
  private int dIk;
  
  static
  {
    AppMethodBeat.i(107869);
    dIy = new String[''];
    int i = 0;
    while (i <= 31)
    {
      dIy[i] = String.format("\\u%04x", new Object[] { Integer.valueOf(i) });
      i += 1;
    }
    dIy[34] = "\\\"";
    dIy[92] = "\\\\";
    dIy[9] = "\\t";
    dIy[8] = "\\b";
    dIy[10] = "\\n";
    dIy[13] = "\\r";
    dIy[12] = "\\f";
    String[] arrayOfString = (String[])dIy.clone();
    dIz = arrayOfString;
    arrayOfString[60] = "\\u003c";
    dIz[62] = "\\u003e";
    dIz[38] = "\\u0026";
    dIz[61] = "\\u003d";
    dIz[39] = "\\u0027";
    AppMethodBeat.o(107869);
  }
  
  public c(Writer paramWriter)
  {
    AppMethodBeat.i(107845);
    this.dIj = new int[32];
    this.dIk = 0;
    bF(6);
    this.dIC = ":";
    this.dEE = true;
    if (paramWriter == null)
    {
      paramWriter = new NullPointerException("out == null");
      AppMethodBeat.o(107845);
      throw paramWriter;
    }
    this.dIA = paramWriter;
    AppMethodBeat.o(107845);
  }
  
  private void ZJ()
  {
    AppMethodBeat.i(107856);
    if (this.dID != null)
    {
      ZL();
      dQ(this.dID);
      this.dID = null;
    }
    AppMethodBeat.o(107856);
  }
  
  private void ZK()
  {
    AppMethodBeat.i(107866);
    if (this.dIB == null)
    {
      AppMethodBeat.o(107866);
      return;
    }
    this.dIA.write("\n");
    int i = 1;
    int j = this.dIk;
    while (i < j)
    {
      this.dIA.write(this.dIB);
      i += 1;
    }
    AppMethodBeat.o(107866);
  }
  
  private void ZL()
  {
    AppMethodBeat.i(107867);
    int i = px();
    if (i == 5) {
      this.dIA.write(44);
    }
    while (i == 3)
    {
      ZK();
      jE(4);
      AppMethodBeat.o(107867);
      return;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("Nesting problem.");
    AppMethodBeat.o(107867);
    throw localIllegalStateException;
  }
  
  private void ZM()
  {
    AppMethodBeat.i(107868);
    IllegalStateException localIllegalStateException;
    switch (px())
    {
    case 3: 
    case 5: 
    default: 
      localIllegalStateException = new IllegalStateException("Nesting problem.");
      AppMethodBeat.o(107868);
      throw localIllegalStateException;
    case 7: 
      if (!this.dEJ)
      {
        localIllegalStateException = new IllegalStateException("JSON must have only one top-level value.");
        AppMethodBeat.o(107868);
        throw localIllegalStateException;
      }
    case 6: 
      jE(7);
      AppMethodBeat.o(107868);
      return;
    case 1: 
      jE(2);
      ZK();
      AppMethodBeat.o(107868);
      return;
    case 2: 
      this.dIA.append(',');
      ZK();
      AppMethodBeat.o(107868);
      return;
    }
    this.dIA.append(this.dIC);
    jE(5);
    AppMethodBeat.o(107868);
  }
  
  private void bF(int paramInt)
  {
    AppMethodBeat.i(107853);
    if (this.dIk == this.dIj.length)
    {
      arrayOfInt = new int[this.dIk * 2];
      System.arraycopy(this.dIj, 0, arrayOfInt, 0, this.dIk);
      this.dIj = arrayOfInt;
    }
    int[] arrayOfInt = this.dIj;
    int i = this.dIk;
    this.dIk = (i + 1);
    arrayOfInt[i] = paramInt;
    AppMethodBeat.o(107853);
  }
  
  private c d(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(107852);
    int i = px();
    if ((i != paramInt2) && (i != paramInt1))
    {
      paramString = new IllegalStateException("Nesting problem.");
      AppMethodBeat.o(107852);
      throw paramString;
    }
    if (this.dID != null)
    {
      paramString = new IllegalStateException("Dangling name: " + this.dID);
      AppMethodBeat.o(107852);
      throw paramString;
    }
    this.dIk -= 1;
    if (i == paramInt2) {
      ZK();
    }
    this.dIA.write(paramString);
    AppMethodBeat.o(107852);
    return this;
  }
  
  private void dQ(String paramString)
  {
    AppMethodBeat.i(107865);
    if (this.dEH) {}
    int m;
    int i;
    int j;
    int n;
    int k;
    for (String[] arrayOfString = dIz;; arrayOfString = dIy)
    {
      this.dIA.write("\"");
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
        this.dIA.write(paramString, j, i - j);
      }
      this.dIA.write(str1);
      k = i + 1;
      break;
      k = j;
      if (n != 8233) {
        break;
      }
    }
    label158:
    if (j < m) {
      this.dIA.write(paramString, j, m - j);
    }
    this.dIA.write("\"");
    AppMethodBeat.o(107865);
  }
  
  private c f(int paramInt, String paramString)
  {
    AppMethodBeat.i(107851);
    ZM();
    bF(paramInt);
    this.dIA.write(paramString);
    AppMethodBeat.o(107851);
    return this;
  }
  
  private void jE(int paramInt)
  {
    this.dIj[(this.dIk - 1)] = paramInt;
  }
  
  private int px()
  {
    AppMethodBeat.i(107854);
    if (this.dIk == 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("JsonWriter is closed.");
      AppMethodBeat.o(107854);
      throw localIllegalStateException;
    }
    int i = this.dIj[(this.dIk - 1)];
    AppMethodBeat.o(107854);
    return i;
  }
  
  public final boolean ZI()
  {
    return this.dEE;
  }
  
  public c Zr()
  {
    AppMethodBeat.i(107847);
    ZJ();
    c localc = f(1, "[");
    AppMethodBeat.o(107847);
    return localc;
  }
  
  public c Zs()
  {
    AppMethodBeat.i(107848);
    c localc = d(1, 2, "]");
    AppMethodBeat.o(107848);
    return localc;
  }
  
  public c Zt()
  {
    AppMethodBeat.i(107849);
    ZJ();
    c localc = f(3, "{");
    AppMethodBeat.o(107849);
    return localc;
  }
  
  public c Zu()
  {
    AppMethodBeat.i(107850);
    c localc = d(3, 5, "}");
    AppMethodBeat.o(107850);
    return localc;
  }
  
  public c Zv()
  {
    AppMethodBeat.i(107858);
    if (this.dID != null)
    {
      if (this.dEE) {
        ZJ();
      }
    }
    else
    {
      ZM();
      this.dIA.write("null");
      AppMethodBeat.o(107858);
      return this;
    }
    this.dID = null;
    AppMethodBeat.o(107858);
    return this;
  }
  
  public c a(Number paramNumber)
  {
    AppMethodBeat.i(107862);
    if (paramNumber == null)
    {
      paramNumber = Zv();
      AppMethodBeat.o(107862);
      return paramNumber;
    }
    ZJ();
    String str = paramNumber.toString();
    if ((!this.dEJ) && ((str.equals("-Infinity")) || (str.equals("Infinity")) || (str.equals("NaN"))))
    {
      paramNumber = new IllegalArgumentException("Numeric values must be finite, but was ".concat(String.valueOf(paramNumber)));
      AppMethodBeat.o(107862);
      throw paramNumber;
    }
    ZM();
    this.dIA.append(str);
    AppMethodBeat.o(107862);
    return this;
  }
  
  public c bW(boolean paramBoolean)
  {
    AppMethodBeat.i(107859);
    ZJ();
    ZM();
    Writer localWriter = this.dIA;
    if (paramBoolean) {}
    for (String str = "true";; str = "false")
    {
      localWriter.write(str);
      AppMethodBeat.o(107859);
      return this;
    }
  }
  
  public c cN(long paramLong)
  {
    AppMethodBeat.i(107861);
    ZJ();
    ZM();
    this.dIA.write(Long.toString(paramLong));
    AppMethodBeat.o(107861);
    return this;
  }
  
  public void close()
  {
    AppMethodBeat.i(107864);
    this.dIA.close();
    int i = this.dIk;
    if ((i > 1) || ((i == 1) && (this.dIj[(i - 1)] != 7)))
    {
      IOException localIOException = new IOException("Incomplete document");
      AppMethodBeat.o(107864);
      throw localIOException;
    }
    this.dIk = 0;
    AppMethodBeat.o(107864);
  }
  
  public c dM(String paramString)
  {
    AppMethodBeat.i(107855);
    if (paramString == null)
    {
      paramString = new NullPointerException("name == null");
      AppMethodBeat.o(107855);
      throw paramString;
    }
    if (this.dID != null)
    {
      paramString = new IllegalStateException();
      AppMethodBeat.o(107855);
      throw paramString;
    }
    if (this.dIk == 0)
    {
      paramString = new IllegalStateException("JsonWriter is closed.");
      AppMethodBeat.o(107855);
      throw paramString;
    }
    this.dID = paramString;
    AppMethodBeat.o(107855);
    return this;
  }
  
  public c dN(String paramString)
  {
    AppMethodBeat.i(107857);
    if (paramString == null)
    {
      paramString = Zv();
      AppMethodBeat.o(107857);
      return paramString;
    }
    ZJ();
    ZM();
    dQ(paramString);
    AppMethodBeat.o(107857);
    return this;
  }
  
  public c e(Boolean paramBoolean)
  {
    AppMethodBeat.i(107860);
    if (paramBoolean == null)
    {
      paramBoolean = Zv();
      AppMethodBeat.o(107860);
      return paramBoolean;
    }
    ZJ();
    ZM();
    Writer localWriter = this.dIA;
    if (paramBoolean.booleanValue()) {}
    for (paramBoolean = "true";; paramBoolean = "false")
    {
      localWriter.write(paramBoolean);
      AppMethodBeat.o(107860);
      return this;
    }
  }
  
  public void flush()
  {
    AppMethodBeat.i(107863);
    if (this.dIk == 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("JsonWriter is closed.");
      AppMethodBeat.o(107863);
      throw localIllegalStateException;
    }
    this.dIA.flush();
    AppMethodBeat.o(107863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.c.d.c
 * JD-Core Version:    0.7.0.1
 */