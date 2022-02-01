package com.google.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class c
  implements Closeable, Flushable
{
  private static final String[] bOT;
  private static final String[] bOU;
  private boolean bKW;
  private boolean bKZ;
  public boolean bLb;
  private int[] bOE;
  private int bOF;
  private final Writer bOV;
  private String bOW;
  private String bOX;
  private String bOY;
  
  static
  {
    AppMethodBeat.i(107869);
    bOT = new String[''];
    int i = 0;
    while (i <= 31)
    {
      bOT[i] = String.format("\\u%04x", new Object[] { Integer.valueOf(i) });
      i += 1;
    }
    bOT[34] = "\\\"";
    bOT[92] = "\\\\";
    bOT[9] = "\\t";
    bOT[8] = "\\b";
    bOT[10] = "\\n";
    bOT[13] = "\\r";
    bOT[12] = "\\f";
    String[] arrayOfString = (String[])bOT.clone();
    bOU = arrayOfString;
    arrayOfString[60] = "\\u003c";
    bOU[62] = "\\u003e";
    bOU[38] = "\\u0026";
    bOU[61] = "\\u003d";
    bOU[39] = "\\u0027";
    AppMethodBeat.o(107869);
  }
  
  public c(Writer paramWriter)
  {
    AppMethodBeat.i(107845);
    this.bOE = new int[32];
    this.bOF = 0;
    gr(6);
    this.bOX = ":";
    this.bKW = true;
    if (paramWriter == null)
    {
      paramWriter = new NullPointerException("out == null");
      AppMethodBeat.o(107845);
      throw paramWriter;
    }
    this.bOV = paramWriter;
    AppMethodBeat.o(107845);
  }
  
  private void Aa()
  {
    AppMethodBeat.i(107866);
    if (this.bOW == null)
    {
      AppMethodBeat.o(107866);
      return;
    }
    this.bOV.write("\n");
    int i = 1;
    int j = this.bOF;
    while (i < j)
    {
      this.bOV.write(this.bOW);
      i += 1;
    }
    AppMethodBeat.o(107866);
  }
  
  private void Ab()
  {
    AppMethodBeat.i(107867);
    int i = zY();
    if (i == 5) {
      this.bOV.write(44);
    }
    while (i == 3)
    {
      Aa();
      gt(4);
      AppMethodBeat.o(107867);
      return;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("Nesting problem.");
    AppMethodBeat.o(107867);
    throw localIllegalStateException;
  }
  
  private void Ac()
  {
    AppMethodBeat.i(107868);
    IllegalStateException localIllegalStateException;
    switch (zY())
    {
    case 3: 
    case 5: 
    default: 
      localIllegalStateException = new IllegalStateException("Nesting problem.");
      AppMethodBeat.o(107868);
      throw localIllegalStateException;
    case 7: 
      if (!this.bLb)
      {
        localIllegalStateException = new IllegalStateException("JSON must have only one top-level value.");
        AppMethodBeat.o(107868);
        throw localIllegalStateException;
      }
    case 6: 
      gt(7);
      AppMethodBeat.o(107868);
      return;
    case 1: 
      gt(2);
      Aa();
      AppMethodBeat.o(107868);
      return;
    case 2: 
      this.bOV.append(',');
      Aa();
      AppMethodBeat.o(107868);
      return;
    }
    this.bOV.append(this.bOX);
    gt(5);
    AppMethodBeat.o(107868);
  }
  
  private c c(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(107852);
    int i = zY();
    if ((i != paramInt2) && (i != paramInt1))
    {
      paramString = new IllegalStateException("Nesting problem.");
      AppMethodBeat.o(107852);
      throw paramString;
    }
    if (this.bOY != null)
    {
      paramString = new IllegalStateException("Dangling name: " + this.bOY);
      AppMethodBeat.o(107852);
      throw paramString;
    }
    this.bOF -= 1;
    if (i == paramInt2) {
      Aa();
    }
    this.bOV.write(paramString);
    AppMethodBeat.o(107852);
    return this;
  }
  
  private void cq(String paramString)
  {
    AppMethodBeat.i(107865);
    if (this.bKZ) {}
    int m;
    int i;
    int j;
    int n;
    int k;
    for (String[] arrayOfString = bOU;; arrayOfString = bOT)
    {
      this.bOV.write("\"");
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
        this.bOV.write(paramString, j, i - j);
      }
      this.bOV.write(str1);
      k = i + 1;
      break;
      k = j;
      if (n != 8233) {
        break;
      }
    }
    label158:
    if (j < m) {
      this.bOV.write(paramString, j, m - j);
    }
    this.bOV.write("\"");
    AppMethodBeat.o(107865);
  }
  
  private c e(int paramInt, String paramString)
  {
    AppMethodBeat.i(107851);
    Ac();
    gr(paramInt);
    this.bOV.write(paramString);
    AppMethodBeat.o(107851);
    return this;
  }
  
  private void gr(int paramInt)
  {
    AppMethodBeat.i(107853);
    if (this.bOF == this.bOE.length)
    {
      arrayOfInt = new int[this.bOF * 2];
      System.arraycopy(this.bOE, 0, arrayOfInt, 0, this.bOF);
      this.bOE = arrayOfInt;
    }
    int[] arrayOfInt = this.bOE;
    int i = this.bOF;
    this.bOF = (i + 1);
    arrayOfInt[i] = paramInt;
    AppMethodBeat.o(107853);
  }
  
  private void gt(int paramInt)
  {
    this.bOE[(this.bOF - 1)] = paramInt;
  }
  
  private int zY()
  {
    AppMethodBeat.i(107854);
    if (this.bOF == 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("JsonWriter is closed.");
      AppMethodBeat.o(107854);
      throw localIllegalStateException;
    }
    int i = this.bOE[(this.bOF - 1)];
    AppMethodBeat.o(107854);
    return i;
  }
  
  private void zZ()
  {
    AppMethodBeat.i(107856);
    if (this.bOY != null)
    {
      Ab();
      cq(this.bOY);
      this.bOY = null;
    }
    AppMethodBeat.o(107856);
  }
  
  public c a(Number paramNumber)
  {
    AppMethodBeat.i(107862);
    if (paramNumber == null)
    {
      paramNumber = zK();
      AppMethodBeat.o(107862);
      return paramNumber;
    }
    zZ();
    String str = paramNumber.toString();
    if ((!this.bLb) && ((str.equals("-Infinity")) || (str.equals("Infinity")) || (str.equals("NaN"))))
    {
      paramNumber = new IllegalArgumentException("Numeric values must be finite, but was ".concat(String.valueOf(paramNumber)));
      AppMethodBeat.o(107862);
      throw paramNumber;
    }
    Ac();
    this.bOV.append(str);
    AppMethodBeat.o(107862);
    return this;
  }
  
  public c az(long paramLong)
  {
    AppMethodBeat.i(107861);
    zZ();
    Ac();
    this.bOV.write(Long.toString(paramLong));
    AppMethodBeat.o(107861);
    return this;
  }
  
  public c b(Boolean paramBoolean)
  {
    AppMethodBeat.i(107860);
    if (paramBoolean == null)
    {
      paramBoolean = zK();
      AppMethodBeat.o(107860);
      return paramBoolean;
    }
    zZ();
    Ac();
    Writer localWriter = this.bOV;
    if (paramBoolean.booleanValue()) {}
    for (paramBoolean = "true";; paramBoolean = "false")
    {
      localWriter.write(paramBoolean);
      AppMethodBeat.o(107860);
      return this;
    }
  }
  
  public c bp(boolean paramBoolean)
  {
    AppMethodBeat.i(107859);
    zZ();
    Ac();
    Writer localWriter = this.bOV;
    if (paramBoolean) {}
    for (String str = "true";; str = "false")
    {
      localWriter.write(str);
      AppMethodBeat.o(107859);
      return this;
    }
  }
  
  public void close()
  {
    AppMethodBeat.i(107864);
    this.bOV.close();
    int i = this.bOF;
    if ((i > 1) || ((i == 1) && (this.bOE[(i - 1)] != 7)))
    {
      IOException localIOException = new IOException("Incomplete document");
      AppMethodBeat.o(107864);
      throw localIOException;
    }
    this.bOF = 0;
    AppMethodBeat.o(107864);
  }
  
  public c cm(String paramString)
  {
    AppMethodBeat.i(107855);
    if (paramString == null)
    {
      paramString = new NullPointerException("name == null");
      AppMethodBeat.o(107855);
      throw paramString;
    }
    if (this.bOY != null)
    {
      paramString = new IllegalStateException();
      AppMethodBeat.o(107855);
      throw paramString;
    }
    if (this.bOF == 0)
    {
      paramString = new IllegalStateException("JsonWriter is closed.");
      AppMethodBeat.o(107855);
      throw paramString;
    }
    this.bOY = paramString;
    AppMethodBeat.o(107855);
    return this;
  }
  
  public c cn(String paramString)
  {
    AppMethodBeat.i(107857);
    if (paramString == null)
    {
      paramString = zK();
      AppMethodBeat.o(107857);
      return paramString;
    }
    zZ();
    Ac();
    cq(paramString);
    AppMethodBeat.o(107857);
    return this;
  }
  
  public void flush()
  {
    AppMethodBeat.i(107863);
    if (this.bOF == 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("JsonWriter is closed.");
      AppMethodBeat.o(107863);
      throw localIllegalStateException;
    }
    this.bOV.flush();
    AppMethodBeat.o(107863);
  }
  
  public c zG()
  {
    AppMethodBeat.i(107847);
    zZ();
    c localc = e(1, "[");
    AppMethodBeat.o(107847);
    return localc;
  }
  
  public c zH()
  {
    AppMethodBeat.i(107848);
    c localc = c(1, 2, "]");
    AppMethodBeat.o(107848);
    return localc;
  }
  
  public c zI()
  {
    AppMethodBeat.i(107849);
    zZ();
    c localc = e(3, "{");
    AppMethodBeat.o(107849);
    return localc;
  }
  
  public c zJ()
  {
    AppMethodBeat.i(107850);
    c localc = c(3, 5, "}");
    AppMethodBeat.o(107850);
    return localc;
  }
  
  public c zK()
  {
    AppMethodBeat.i(107858);
    if (this.bOY != null)
    {
      if (this.bKW) {
        zZ();
      }
    }
    else
    {
      Ac();
      this.bOV.write("null");
      AppMethodBeat.o(107858);
      return this;
    }
    this.bOY = null;
    AppMethodBeat.o(107858);
    return this;
  }
  
  public final boolean zX()
  {
    return this.bKW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.a.d.c
 * JD-Core Version:    0.7.0.1
 */