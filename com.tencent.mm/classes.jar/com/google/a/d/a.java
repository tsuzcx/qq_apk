package com.google.a.d;

import com.google.a.b.a.e;
import com.google.a.b.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class a
  implements Closeable
{
  private static final char[] bOx;
  private final char[] aJp;
  public boolean bLb;
  int bOA;
  private long bOB;
  private int bOC;
  private String bOD;
  private int[] bOE;
  private int bOF;
  private String[] bOG;
  private int[] bOH;
  private final Reader bOy;
  private int bOz;
  private int limit;
  private int lineNumber;
  private int pos;
  
  static
  {
    AppMethodBeat.i(222280);
    bOx = ")]}'\n".toCharArray();
    f.bLV = new f()
    {
      public final void b(a paramAnonymousa)
      {
        AppMethodBeat.i(222007);
        if ((paramAnonymousa instanceof e))
        {
          paramAnonymousa = b.bOM;
          AppMethodBeat.o(222007);
          throw null;
        }
        int j = paramAnonymousa.bOA;
        int i = j;
        if (j == 0) {
          i = paramAnonymousa.zO();
        }
        if (i == 13)
        {
          paramAnonymousa.bOA = 9;
          AppMethodBeat.o(222007);
          return;
        }
        if (i == 12)
        {
          paramAnonymousa.bOA = 8;
          AppMethodBeat.o(222007);
          return;
        }
        if (i == 14)
        {
          paramAnonymousa.bOA = 10;
          AppMethodBeat.o(222007);
          return;
        }
        paramAnonymousa = new IllegalStateException("Expected a name but was " + paramAnonymousa.zw() + paramAnonymousa.zU());
        AppMethodBeat.o(222007);
        throw paramAnonymousa;
      }
    };
    AppMethodBeat.o(222280);
  }
  
  public a(Reader paramReader)
  {
    AppMethodBeat.i(222015);
    this.bLb = false;
    this.aJp = new char[1024];
    this.pos = 0;
    this.limit = 0;
    this.lineNumber = 0;
    this.bOz = 0;
    this.bOA = 0;
    this.bOE = new int[32];
    this.bOF = 0;
    int[] arrayOfInt = this.bOE;
    int i = this.bOF;
    this.bOF = (i + 1);
    arrayOfInt[i] = 6;
    this.bOG = new String[32];
    this.bOH = new int[32];
    this.bOy = paramReader;
    AppMethodBeat.o(222015);
  }
  
  private int bq(boolean paramBoolean)
  {
    AppMethodBeat.i(222242);
    Object localObject = this.aJp;
    int i = this.pos;
    int j = this.limit;
    for (;;)
    {
      int k = j;
      int m = i;
      if (i == j)
      {
        this.pos = i;
        if (gs(1))
        {
          m = this.pos;
          k = this.limit;
        }
      }
      else
      {
        i = m + 1;
        j = localObject[m];
        if (j == 10)
        {
          this.lineNumber += 1;
          this.bOz = i;
          j = k;
          continue;
        }
        if ((j == 32) || (j == 13) || (j == 9)) {
          break label383;
        }
        if (j == 47)
        {
          this.pos = i;
          if (i == k)
          {
            this.pos -= 1;
            boolean bool = gs(2);
            this.pos += 1;
            if (!bool)
            {
              AppMethodBeat.o(222242);
              return j;
            }
          }
          zS();
          switch (localObject[this.pos])
          {
          default: 
            AppMethodBeat.o(222242);
            return j;
          case '*': 
            this.pos += 1;
            if (!co("*/"))
            {
              localObject = cp("Unterminated comment");
              AppMethodBeat.o(222242);
              throw ((Throwable)localObject);
            }
            i = this.pos + 2;
            j = this.limit;
            break;
          case '/': 
            this.pos += 1;
            zT();
            i = this.pos;
            j = this.limit;
            break;
          }
        }
        if (j == 35)
        {
          this.pos = i;
          zS();
          zT();
          i = this.pos;
          j = this.limit;
          continue;
        }
        this.pos = i;
        AppMethodBeat.o(222242);
        return j;
      }
      if (paramBoolean)
      {
        localObject = new EOFException("End of input" + zU());
        AppMethodBeat.o(222242);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(222242);
      return -1;
      label383:
      j = k;
    }
  }
  
  private boolean co(String paramString)
  {
    AppMethodBeat.i(222249);
    int j = paramString.length();
    while ((this.pos + j <= this.limit) || (gs(j))) {
      if (this.aJp[this.pos] == '\n')
      {
        this.lineNumber += 1;
        this.bOz = (this.pos + 1);
        this.pos += 1;
      }
      else
      {
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label111;
          }
          if (this.aJp[(this.pos + i)] != paramString.charAt(i)) {
            break;
          }
          i += 1;
        }
        label111:
        AppMethodBeat.o(222249);
        return true;
      }
    }
    AppMethodBeat.o(222249);
    return false;
  }
  
  private IOException cp(String paramString)
  {
    AppMethodBeat.i(222271);
    paramString = new d(paramString + zU());
    AppMethodBeat.o(222271);
    throw paramString;
  }
  
  private void gr(int paramInt)
  {
    AppMethodBeat.i(222230);
    if (this.bOF == this.bOE.length)
    {
      arrayOfInt1 = new int[this.bOF * 2];
      int[] arrayOfInt2 = new int[this.bOF * 2];
      String[] arrayOfString = new String[this.bOF * 2];
      System.arraycopy(this.bOE, 0, arrayOfInt1, 0, this.bOF);
      System.arraycopy(this.bOH, 0, arrayOfInt2, 0, this.bOF);
      System.arraycopy(this.bOG, 0, arrayOfString, 0, this.bOF);
      this.bOE = arrayOfInt1;
      this.bOH = arrayOfInt2;
      this.bOG = arrayOfString;
    }
    int[] arrayOfInt1 = this.bOE;
    int i = this.bOF;
    this.bOF = (i + 1);
    arrayOfInt1[i] = paramInt;
    AppMethodBeat.o(222230);
  }
  
  private boolean gs(int paramInt)
  {
    AppMethodBeat.i(222238);
    char[] arrayOfChar = this.aJp;
    this.bOz -= this.pos;
    if (this.limit != this.pos)
    {
      this.limit -= this.pos;
      System.arraycopy(arrayOfChar, this.pos, arrayOfChar, 0, this.limit);
    }
    for (;;)
    {
      this.pos = 0;
      int i;
      do
      {
        i = this.bOy.read(arrayOfChar, this.limit, arrayOfChar.length - this.limit);
        if (i == -1) {
          break;
        }
        this.limit = (i + this.limit);
        i = paramInt;
        if (this.lineNumber == 0)
        {
          i = paramInt;
          if (this.bOz == 0)
          {
            i = paramInt;
            if (this.limit > 0)
            {
              i = paramInt;
              if (arrayOfChar[0] == 65279)
              {
                this.pos += 1;
                this.bOz += 1;
                i = paramInt + 1;
              }
            }
          }
        }
        paramInt = i;
      } while (this.limit < i);
      AppMethodBeat.o(222238);
      return true;
      this.limit = 0;
    }
    AppMethodBeat.o(222238);
    return false;
  }
  
  private boolean h(char paramChar)
  {
    AppMethodBeat.i(222096);
    switch (paramChar)
    {
    default: 
      AppMethodBeat.o(222096);
      return true;
    case '#': 
    case '/': 
    case ';': 
    case '=': 
    case '\\': 
      zS();
    }
    AppMethodBeat.o(222096);
    return false;
  }
  
  private String i(char paramChar)
  {
    AppMethodBeat.i(222181);
    char[] arrayOfChar = this.aJp;
    Object localObject1 = null;
    label214:
    do
    {
      char c2 = this.pos;
      int i = this.limit;
      char c3;
      for (char c1 = c2;; c1 = c3)
      {
        if (c1 >= i) {
          break label214;
        }
        c3 = c1 + '\001';
        c1 = arrayOfChar[c1];
        if (c1 == paramChar)
        {
          this.pos = c3;
          paramChar = c3 - c2 - 1;
          if (localObject1 == null)
          {
            localObject1 = new String(arrayOfChar, c2, paramChar);
            AppMethodBeat.o(222181);
            return localObject1;
          }
          ((StringBuilder)localObject1).append(arrayOfChar, c2, paramChar);
          localObject1 = ((StringBuilder)localObject1).toString();
          AppMethodBeat.o(222181);
          return localObject1;
        }
        if (c1 == '\\')
        {
          this.pos = c3;
          c1 = c3 - c2 - 1;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new StringBuilder(Math.max((c1 + '\001') * 2, 16));
          }
          ((StringBuilder)localObject2).append(arrayOfChar, c2, c1);
          ((StringBuilder)localObject2).append(zV());
          localObject1 = localObject2;
          break;
        }
        if (c1 == '\n')
        {
          this.lineNumber += 1;
          this.bOz = c3;
        }
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuilder(Math.max((c1 - c2) * 2, 16));
      }
      ((StringBuilder)localObject2).append(arrayOfChar, c2, c1 - c2);
      this.pos = c1;
      localObject1 = localObject2;
    } while (gs(1));
    localObject1 = cp("Unterminated string");
    AppMethodBeat.o(222181);
    throw ((Throwable)localObject1);
  }
  
  private void j(char paramChar)
  {
    AppMethodBeat.i(222191);
    Object localObject = this.aJp;
    label98:
    do
    {
      char c1 = this.pos;
      char c3 = this.limit;
      for (;;)
      {
        if (c1 >= c3) {
          break label98;
        }
        char c2 = c1 + '\001';
        c1 = localObject[c1];
        if (c1 == paramChar)
        {
          this.pos = c2;
          AppMethodBeat.o(222191);
          return;
        }
        if (c1 == '\\')
        {
          this.pos = c2;
          zV();
          break;
        }
        if (c1 == '\n')
        {
          this.lineNumber += 1;
          this.bOz = c2;
        }
        c1 = c2;
      }
      this.pos = c1;
    } while (gs(1));
    localObject = cp("Unterminated string");
    AppMethodBeat.o(222191);
    throw ((Throwable)localObject);
  }
  
  private int zP()
  {
    AppMethodBeat.i(222070);
    int i = this.aJp[this.pos];
    String str2;
    String str1;
    int k;
    int j;
    if ((i == 116) || (i == 84))
    {
      str2 = "true";
      str1 = "TRUE";
      i = 5;
      k = str2.length();
      j = 1;
    }
    for (;;)
    {
      if (j >= k) {
        break label188;
      }
      if ((this.pos + j >= this.limit) && (!gs(j + 1)))
      {
        AppMethodBeat.o(222070);
        return 0;
        if ((i == 102) || (i == 70))
        {
          str2 = "false";
          str1 = "FALSE";
          i = 6;
          break;
        }
        if ((i == 110) || (i == 78))
        {
          str2 = "null";
          str1 = "NULL";
          i = 7;
          break;
        }
        AppMethodBeat.o(222070);
        return 0;
      }
      int m = this.aJp[(this.pos + j)];
      if ((m != str2.charAt(j)) && (m != str1.charAt(j)))
      {
        AppMethodBeat.o(222070);
        return 0;
      }
      j += 1;
    }
    label188:
    if (((this.pos + k < this.limit) || (gs(k + 1))) && (h(this.aJp[(this.pos + k)])))
    {
      AppMethodBeat.o(222070);
      return 0;
    }
    this.pos += k;
    this.bOA = i;
    AppMethodBeat.o(222070);
    return i;
  }
  
  private int zQ()
  {
    AppMethodBeat.i(222095);
    char[] arrayOfChar = this.aJp;
    int i2 = this.pos;
    int i3 = this.limit;
    long l1 = 0L;
    int k = 0;
    int m = 1;
    int i = 0;
    int j = 0;
    int i1 = i3;
    int n = i2;
    char c;
    if (i2 + j == i3)
    {
      if (j == arrayOfChar.length)
      {
        AppMethodBeat.o(222095);
        return 0;
      }
      if (gs(j + 1))
      {
        n = this.pos;
        i1 = this.limit;
      }
    }
    else
    {
      c = arrayOfChar[(n + j)];
      switch (c)
      {
      default: 
        if ((c < '0') || (c > '9'))
        {
          if (!h(c)) {
            break label405;
          }
          AppMethodBeat.o(222095);
          return 0;
        }
        break;
      case '-': 
        if (i == 0)
        {
          i = 1;
          k = 1;
        }
        break;
      }
    }
    for (;;)
    {
      j += 1;
      i3 = i1;
      i2 = n;
      break;
      if (i == 5)
      {
        i = 6;
      }
      else
      {
        AppMethodBeat.o(222095);
        return 0;
        if (i == 5)
        {
          i = 6;
        }
        else
        {
          AppMethodBeat.o(222095);
          return 0;
          if ((i == 2) || (i == 4))
          {
            i = 5;
          }
          else
          {
            AppMethodBeat.o(222095);
            return 0;
            if (i == 2)
            {
              i = 3;
            }
            else
            {
              AppMethodBeat.o(222095);
              return 0;
              if ((i == 1) || (i == 0))
              {
                l1 = -(c - '0');
                i = 2;
              }
              else
              {
                if (i == 2)
                {
                  if (l1 == 0L)
                  {
                    AppMethodBeat.o(222095);
                    return 0;
                  }
                  long l2 = 10L * l1 - (c - '0');
                  if ((l1 > -922337203685477580L) || ((l1 == -922337203685477580L) && (l2 < l1))) {}
                  for (i2 = 1;; i2 = 0)
                  {
                    m &= i2;
                    l1 = l2;
                    break;
                  }
                }
                if (i == 3)
                {
                  i = 4;
                }
                else if ((i == 5) || (i == 6))
                {
                  i = 7;
                  continue;
                  label405:
                  if ((i == 2) && (m != 0) && ((l1 != -9223372036854775808L) || (k != 0)) && ((l1 != 0L) || (k == 0)))
                  {
                    if (k != 0) {}
                    for (;;)
                    {
                      this.bOB = l1;
                      this.pos += j;
                      this.bOA = 15;
                      AppMethodBeat.o(222095);
                      return 15;
                      l1 = -l1;
                    }
                  }
                  if ((i == 2) || (i == 4) || (i == 7))
                  {
                    this.bOC = j;
                    this.bOA = 16;
                    AppMethodBeat.o(222095);
                    return 16;
                  }
                  AppMethodBeat.o(222095);
                  return 0;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private String zR()
  {
    AppMethodBeat.i(222185);
    Object localObject1 = null;
    int i = 0;
    for (;;)
    {
      Object localObject2;
      int j;
      if (this.pos + i < this.limit)
      {
        localObject2 = localObject1;
        j = i;
        switch (this.aJp[(this.pos + i)])
        {
        default: 
          i += 1;
          break;
        case '#': 
        case '/': 
        case ';': 
        case '=': 
        case '\\': 
          zS();
          j = i;
          localObject2 = localObject1;
        case '\t': 
        case '\n': 
        case '\f': 
        case '\r': 
        case ' ': 
        case ',': 
        case ':': 
        case '[': 
        case ']': 
        case '{': 
        case '}': 
          label192:
          if (localObject2 != null) {}
          break;
        }
      }
      else
      {
        for (localObject1 = new String(this.aJp, this.pos, j);; localObject1 = ((StringBuilder)localObject2).append(this.aJp, this.pos, j).toString())
        {
          this.pos = (j + this.pos);
          AppMethodBeat.o(222185);
          return localObject1;
          if (i < this.aJp.length)
          {
            localObject2 = localObject1;
            j = i;
            if (!gs(i + 1)) {
              break label192;
            }
            break;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new StringBuilder(Math.max(i, 16));
          }
          ((StringBuilder)localObject2).append(this.aJp, this.pos, i);
          this.pos = (i + this.pos);
          if (gs(1)) {
            break label339;
          }
          j = 0;
          break label192;
        }
        label339:
        i = 0;
        localObject1 = localObject2;
      }
    }
  }
  
  private void zS()
  {
    AppMethodBeat.i(222244);
    if (!this.bLb)
    {
      IOException localIOException = cp("Use JsonReader.setLenient(true) to accept malformed JSON");
      AppMethodBeat.o(222244);
      throw localIOException;
    }
    AppMethodBeat.o(222244);
  }
  
  private void zT()
  {
    AppMethodBeat.i(222245);
    int i;
    do
    {
      if ((this.pos >= this.limit) && (!gs(1))) {
        break;
      }
      char[] arrayOfChar = this.aJp;
      i = this.pos;
      this.pos = (i + 1);
      i = arrayOfChar[i];
      if (i == 10)
      {
        this.lineNumber += 1;
        this.bOz = this.pos;
        AppMethodBeat.o(222245);
        return;
      }
    } while (i != 13);
    AppMethodBeat.o(222245);
  }
  
  private char zV()
  {
    AppMethodBeat.i(222268);
    if ((this.pos == this.limit) && (!gs(1)))
    {
      localObject = cp("Unterminated escape sequence");
      AppMethodBeat.o(222268);
      throw ((Throwable)localObject);
    }
    Object localObject = this.aJp;
    int i = this.pos;
    this.pos = (i + 1);
    char c = localObject[i];
    switch (c)
    {
    default: 
      localObject = cp("Invalid escape sequence");
      AppMethodBeat.o(222268);
      throw ((Throwable)localObject);
    case 'u': 
      if ((this.pos + 4 > this.limit) && (!gs(4)))
      {
        localObject = cp("Unterminated escape sequence");
        AppMethodBeat.o(222268);
        throw ((Throwable)localObject);
      }
      c = '\000';
      int j = this.pos;
      i = j;
      if (i < j + 4)
      {
        int k = this.aJp[i];
        int m = (char)(c << '\004');
        if ((k >= 48) && (k <= 57)) {
          c = (char)(m + (k - 48));
        }
        for (;;)
        {
          i += 1;
          break;
          if ((k >= 97) && (k <= 102))
          {
            c = (char)(m + (k - 97 + 10));
          }
          else
          {
            if ((k < 65) || (k > 70)) {
              break label338;
            }
            c = (char)(m + (k - 65 + 10));
          }
        }
        localObject = new NumberFormatException("\\u" + new String(this.aJp, this.pos, 4));
        AppMethodBeat.o(222268);
        throw ((Throwable)localObject);
      }
      this.pos += 4;
      AppMethodBeat.o(222268);
      return c;
    case 't': 
      AppMethodBeat.o(222268);
      return '\t';
    case 'b': 
      AppMethodBeat.o(222268);
      return '\b';
    case 'n': 
      AppMethodBeat.o(222268);
      return '\n';
    case 'r': 
      AppMethodBeat.o(222268);
      return '\r';
    case 'f': 
      AppMethodBeat.o(222268);
      return '\f';
    case '\n': 
      label338:
      this.lineNumber += 1;
      this.bOz = this.pos;
    }
    AppMethodBeat.o(222268);
    return c;
  }
  
  private void zW()
  {
    AppMethodBeat.i(222277);
    bq(true);
    this.pos -= 1;
    if ((this.pos + bOx.length > this.limit) && (!gs(bOx.length)))
    {
      AppMethodBeat.o(222277);
      return;
    }
    int i = 0;
    while (i < bOx.length)
    {
      if (this.aJp[(this.pos + i)] != bOx[i])
      {
        AppMethodBeat.o(222277);
        return;
      }
      i += 1;
    }
    this.pos += bOx.length;
    AppMethodBeat.o(222277);
  }
  
  public void close()
  {
    AppMethodBeat.i(222213);
    this.bOA = 0;
    this.bOE[0] = 8;
    this.bOF = 1;
    this.bOy.close();
    AppMethodBeat.o(222213);
  }
  
  public String getPath()
  {
    AppMethodBeat.i(222256);
    Object localObject = new StringBuilder("$");
    int i = 0;
    int j = this.bOF;
    if (i < j)
    {
      switch (this.bOE[i])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        ((StringBuilder)localObject).append('[').append(this.bOH[i]).append(']');
        continue;
        ((StringBuilder)localObject).append('.');
        if (this.bOG[i] != null) {
          ((StringBuilder)localObject).append(this.bOG[i]);
        }
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(222256);
    return localObject;
  }
  
  public boolean hasNext()
  {
    AppMethodBeat.i(222031);
    int j = this.bOA;
    int i = j;
    if (j == 0) {
      i = zO();
    }
    if ((i != 2) && (i != 4))
    {
      AppMethodBeat.o(222031);
      return true;
    }
    AppMethodBeat.o(222031);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(222250);
    String str = getClass().getSimpleName() + zU();
    AppMethodBeat.o(222250);
    return str;
  }
  
  public void zA()
  {
    AppMethodBeat.i(222132);
    int j = this.bOA;
    int i = j;
    if (j == 0) {
      i = zO();
    }
    if (i == 7)
    {
      this.bOA = 0;
      localObject = this.bOH;
      i = this.bOF - 1;
      localObject[i] += 1;
      AppMethodBeat.o(222132);
      return;
    }
    Object localObject = new IllegalStateException("Expected null but was " + zw() + zU());
    AppMethodBeat.o(222132);
    throw ((Throwable)localObject);
  }
  
  public double zB()
  {
    AppMethodBeat.i(222151);
    int j = this.bOA;
    int i = j;
    if (j == 0) {
      i = zO();
    }
    double d;
    if (i == 15)
    {
      this.bOA = 0;
      localObject = this.bOH;
      i = this.bOF - 1;
      localObject[i] += 1;
      d = this.bOB;
      AppMethodBeat.o(222151);
      return d;
    }
    if (i == 16)
    {
      this.bOD = new String(this.aJp, this.pos, this.bOC);
      this.pos += this.bOC;
    }
    do
    {
      for (;;)
      {
        this.bOA = 11;
        d = Double.parseDouble(this.bOD);
        if ((this.bLb) || ((!Double.isNaN(d)) && (!Double.isInfinite(d)))) {
          break label311;
        }
        localObject = new d("JSON forbids NaN and infinities: " + d + zU());
        AppMethodBeat.o(222151);
        throw ((Throwable)localObject);
        if ((i == 8) || (i == 9))
        {
          if (i == 8) {}
          for (char c = '\'';; c = '"')
          {
            this.bOD = i(c);
            break;
          }
        }
        if (i != 10) {
          break;
        }
        this.bOD = zR();
      }
    } while (i == 11);
    Object localObject = new IllegalStateException("Expected a double but was " + zw() + zU());
    AppMethodBeat.o(222151);
    throw ((Throwable)localObject);
    label311:
    this.bOD = null;
    this.bOA = 0;
    localObject = this.bOH;
    i = this.bOF - 1;
    localObject[i] += 1;
    AppMethodBeat.o(222151);
    return d;
  }
  
  public long zC()
  {
    AppMethodBeat.i(222169);
    int j = this.bOA;
    int i = j;
    if (j == 0) {
      i = zO();
    }
    Object localObject;
    long l;
    if (i == 15)
    {
      this.bOA = 0;
      localObject = this.bOH;
      i = this.bOF - 1;
      localObject[i] += 1;
      l = this.bOB;
      AppMethodBeat.o(222169);
      return l;
    }
    if (i == 16)
    {
      this.bOD = new String(this.aJp, this.pos, this.bOC);
      this.pos += this.bOC;
    }
    for (;;)
    {
      this.bOA = 11;
      double d = Double.parseDouble(this.bOD);
      l = d;
      if (l != d)
      {
        localObject = new NumberFormatException("Expected a long but was " + this.bOD + zU());
        AppMethodBeat.o(222169);
        throw ((Throwable)localObject);
        if ((i == 8) || (i == 9) || (i == 10)) {
          if (i == 10) {
            this.bOD = zR();
          }
        }
      }
      try
      {
        l = Long.parseLong(this.bOD);
        this.bOA = 0;
        localObject = this.bOH;
        i = this.bOF - 1;
        localObject[i] += 1;
        AppMethodBeat.o(222169);
        return l;
      }
      catch (NumberFormatException localNumberFormatException) {}
      if (i == 8) {}
      for (char c = '\'';; c = '"')
      {
        this.bOD = i(c);
        break;
      }
      localObject = new IllegalStateException("Expected a long but was " + zw() + zU());
      AppMethodBeat.o(222169);
      throw ((Throwable)localObject);
      this.bOD = null;
      this.bOA = 0;
      localObject = this.bOH;
      i = this.bOF - 1;
      localObject[i] += 1;
      AppMethodBeat.o(222169);
      return l;
    }
  }
  
  public int zD()
  {
    AppMethodBeat.i(222208);
    int j = this.bOA;
    int i = j;
    if (j == 0) {
      i = zO();
    }
    Object localObject;
    if (i == 15)
    {
      i = (int)this.bOB;
      if (this.bOB != i)
      {
        localObject = new NumberFormatException("Expected an int but was " + this.bOB + zU());
        AppMethodBeat.o(222208);
        throw ((Throwable)localObject);
      }
      this.bOA = 0;
      localObject = this.bOH;
      j = this.bOF - 1;
      localObject[j] += 1;
      AppMethodBeat.o(222208);
      return i;
    }
    if (i == 16)
    {
      this.bOD = new String(this.aJp, this.pos, this.bOC);
      this.pos += this.bOC;
    }
    for (;;)
    {
      this.bOA = 11;
      double d = Double.parseDouble(this.bOD);
      i = (int)d;
      if (i != d)
      {
        localObject = new NumberFormatException("Expected an int but was " + this.bOD + zU());
        AppMethodBeat.o(222208);
        throw ((Throwable)localObject);
        if ((i == 8) || (i == 9) || (i == 10)) {
          if (i == 10) {
            this.bOD = zR();
          }
        }
      }
      try
      {
        i = Integer.parseInt(this.bOD);
        this.bOA = 0;
        localObject = this.bOH;
        j = this.bOF - 1;
        localObject[j] += 1;
        AppMethodBeat.o(222208);
        return i;
      }
      catch (NumberFormatException localNumberFormatException) {}
      if (i == 8) {}
      for (char c = '\'';; c = '"')
      {
        this.bOD = i(c);
        break;
      }
      localObject = new IllegalStateException("Expected an int but was " + zw() + zU());
      AppMethodBeat.o(222208);
      throw ((Throwable)localObject);
      this.bOD = null;
      this.bOA = 0;
      localObject = this.bOH;
      j = this.bOF - 1;
      localObject[j] += 1;
      AppMethodBeat.o(222208);
      return i;
    }
  }
  
  public void zE()
  {
    AppMethodBeat.i(222224);
    int j = 0;
    int i = this.bOA;
    int k = i;
    if (i == 0) {
      k = zO();
    }
    if (k == 3)
    {
      gr(1);
      i = j + 1;
    }
    for (;;)
    {
      label38:
      this.bOA = 0;
      j = i;
      if (i != 0) {
        break;
      }
      int[] arrayOfInt = this.bOH;
      i = this.bOF - 1;
      arrayOfInt[i] += 1;
      this.bOG[(this.bOF - 1)] = "null";
      AppMethodBeat.o(222224);
      return;
      if (k == 1)
      {
        gr(3);
        i = j + 1;
      }
      else if (k == 4)
      {
        this.bOF -= 1;
        i = j - 1;
      }
      else if (k == 2)
      {
        this.bOF -= 1;
        i = j - 1;
      }
      else if ((k == 14) || (k == 10))
      {
        do
        {
          i = 0;
          for (;;)
          {
            if (this.pos + i < this.limit) {
              switch (this.aJp[(this.pos + i)])
              {
              default: 
                i += 1;
                break;
              case '#': 
              case '/': 
              case ';': 
              case '=': 
              case '\\': 
                zS();
              case '\t': 
              case '\n': 
              case '\f': 
              case '\r': 
              case ' ': 
              case ',': 
              case ':': 
              case '[': 
              case ']': 
              case '{': 
              case '}': 
                this.pos = (i + this.pos);
                i = j;
                break label38;
              }
            }
          }
          this.pos = (i + this.pos);
        } while (gs(1));
        i = j;
      }
      else if ((k == 8) || (k == 12))
      {
        j('\'');
        i = j;
      }
      else if ((k == 9) || (k == 13))
      {
        j('"');
        i = j;
      }
      else
      {
        i = j;
        if (k == 16)
        {
          this.pos += this.bOC;
          i = j;
        }
      }
    }
  }
  
  final int zO()
  {
    AppMethodBeat.i(222061);
    int i = this.bOE[(this.bOF - 1)];
    if (i == 1) {
      this.bOE[(this.bOF - 1)] = 2;
    }
    label682:
    do
    {
      for (;;)
      {
        switch (bq(true))
        {
        default: 
          this.pos -= 1;
          i = zP();
          if (i == 0) {
            break label840;
          }
          AppMethodBeat.o(222061);
          return i;
          if (i == 2)
          {
            switch (bq(true))
            {
            case 44: 
            default: 
              localObject = cp("Unterminated array");
              AppMethodBeat.o(222061);
              throw ((Throwable)localObject);
            case 93: 
              this.bOA = 4;
              AppMethodBeat.o(222061);
              return 4;
            }
            zS();
          }
          else
          {
            if ((i == 3) || (i == 5))
            {
              this.bOE[(this.bOF - 1)] = 4;
              if (i == 5) {
                switch (bq(true))
                {
                default: 
                  localObject = cp("Unterminated object");
                  AppMethodBeat.o(222061);
                  throw ((Throwable)localObject);
                case 125: 
                  this.bOA = 2;
                  AppMethodBeat.o(222061);
                  return 2;
                case 59: 
                  zS();
                }
              }
              int j = bq(true);
              switch (j)
              {
              default: 
                zS();
                this.pos -= 1;
                if (h((char)j))
                {
                  this.bOA = 14;
                  AppMethodBeat.o(222061);
                  return 14;
                }
                break;
              case 34: 
                this.bOA = 13;
                AppMethodBeat.o(222061);
                return 13;
              case 39: 
                zS();
                this.bOA = 12;
                AppMethodBeat.o(222061);
                return 12;
              case 125: 
                if (i != 5)
                {
                  this.bOA = 2;
                  AppMethodBeat.o(222061);
                  return 2;
                }
                localObject = cp("Expected name");
                AppMethodBeat.o(222061);
                throw ((Throwable)localObject);
              }
              localObject = cp("Expected name");
              AppMethodBeat.o(222061);
              throw ((Throwable)localObject);
            }
            if (i == 4)
            {
              this.bOE[(this.bOF - 1)] = 5;
              switch (bq(true))
              {
              case 58: 
              case 59: 
              case 60: 
              default: 
                localObject = cp("Expected ':'");
                AppMethodBeat.o(222061);
                throw ((Throwable)localObject);
              }
              zS();
              if (((this.pos < this.limit) || (gs(1))) && (this.aJp[this.pos] == '>')) {
                this.pos += 1;
              }
            }
            else if (i == 6)
            {
              if (this.bLb) {
                zW();
              }
              this.bOE[(this.bOF - 1)] = 7;
            }
            else
            {
              if (i != 7) {
                break label682;
              }
              if (bq(false) == -1)
              {
                this.bOA = 17;
                AppMethodBeat.o(222061);
                return 17;
              }
              zS();
              this.pos -= 1;
            }
          }
          break;
        }
      }
    } while (i != 8);
    Object localObject = new IllegalStateException("JsonReader is closed");
    AppMethodBeat.o(222061);
    throw ((Throwable)localObject);
    if (i == 1)
    {
      this.bOA = 4;
      AppMethodBeat.o(222061);
      return 4;
    }
    if ((i == 1) || (i == 2))
    {
      zS();
      this.pos -= 1;
      this.bOA = 7;
      AppMethodBeat.o(222061);
      return 7;
    }
    localObject = cp("Unexpected value");
    AppMethodBeat.o(222061);
    throw ((Throwable)localObject);
    zS();
    this.bOA = 8;
    AppMethodBeat.o(222061);
    return 8;
    this.bOA = 9;
    AppMethodBeat.o(222061);
    return 9;
    this.bOA = 3;
    AppMethodBeat.o(222061);
    return 3;
    this.bOA = 1;
    AppMethodBeat.o(222061);
    return 1;
    label840:
    i = zQ();
    if (i != 0)
    {
      AppMethodBeat.o(222061);
      return i;
    }
    if (!h(this.aJp[this.pos]))
    {
      localObject = cp("Expected value");
      AppMethodBeat.o(222061);
      throw ((Throwable)localObject);
    }
    zS();
    this.bOA = 10;
    AppMethodBeat.o(222061);
    return 10;
  }
  
  final String zU()
  {
    AppMethodBeat.i(222252);
    int i = this.lineNumber;
    int j = this.pos;
    int k = this.bOz;
    String str = " at line " + (i + 1) + " column " + (j - k + 1) + " path " + getPath();
    AppMethodBeat.o(222252);
    return str;
  }
  
  public void zs()
  {
    AppMethodBeat.i(222017);
    int j = this.bOA;
    int i = j;
    if (j == 0) {
      i = zO();
    }
    if (i == 3)
    {
      gr(1);
      this.bOH[(this.bOF - 1)] = 0;
      this.bOA = 0;
      AppMethodBeat.o(222017);
      return;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("Expected BEGIN_ARRAY but was " + zw() + zU());
    AppMethodBeat.o(222017);
    throw localIllegalStateException;
  }
  
  public void zt()
  {
    AppMethodBeat.i(222023);
    int j = this.bOA;
    int i = j;
    if (j == 0) {
      i = zO();
    }
    if (i == 4)
    {
      this.bOF -= 1;
      localObject = this.bOH;
      i = this.bOF - 1;
      localObject[i] += 1;
      this.bOA = 0;
      AppMethodBeat.o(222023);
      return;
    }
    Object localObject = new IllegalStateException("Expected END_ARRAY but was " + zw() + zU());
    AppMethodBeat.o(222023);
    throw ((Throwable)localObject);
  }
  
  public void zu()
  {
    AppMethodBeat.i(222025);
    int j = this.bOA;
    int i = j;
    if (j == 0) {
      i = zO();
    }
    if (i == 1)
    {
      gr(3);
      this.bOA = 0;
      AppMethodBeat.o(222025);
      return;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("Expected BEGIN_OBJECT but was " + zw() + zU());
    AppMethodBeat.o(222025);
    throw localIllegalStateException;
  }
  
  public void zv()
  {
    AppMethodBeat.i(222028);
    int j = this.bOA;
    int i = j;
    if (j == 0) {
      i = zO();
    }
    if (i == 2)
    {
      this.bOF -= 1;
      this.bOG[this.bOF] = null;
      localObject = this.bOH;
      i = this.bOF - 1;
      localObject[i] += 1;
      this.bOA = 0;
      AppMethodBeat.o(222028);
      return;
    }
    Object localObject = new IllegalStateException("Expected END_OBJECT but was " + zw() + zU());
    AppMethodBeat.o(222028);
    throw ((Throwable)localObject);
  }
  
  public b zw()
  {
    AppMethodBeat.i(222038);
    int j = this.bOA;
    int i = j;
    if (j == 0) {
      i = zO();
    }
    switch (i)
    {
    default: 
      localObject = new AssertionError();
      AppMethodBeat.o(222038);
      throw ((Throwable)localObject);
    case 1: 
      localObject = b.bOK;
      AppMethodBeat.o(222038);
      return localObject;
    case 2: 
      localObject = b.bOL;
      AppMethodBeat.o(222038);
      return localObject;
    case 3: 
      localObject = b.bOI;
      AppMethodBeat.o(222038);
      return localObject;
    case 4: 
      localObject = b.bOJ;
      AppMethodBeat.o(222038);
      return localObject;
    case 12: 
    case 13: 
    case 14: 
      localObject = b.bOM;
      AppMethodBeat.o(222038);
      return localObject;
    case 5: 
    case 6: 
      localObject = b.bOP;
      AppMethodBeat.o(222038);
      return localObject;
    case 7: 
      localObject = b.bOQ;
      AppMethodBeat.o(222038);
      return localObject;
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      localObject = b.bON;
      AppMethodBeat.o(222038);
      return localObject;
    case 15: 
    case 16: 
      localObject = b.bOO;
      AppMethodBeat.o(222038);
      return localObject;
    }
    Object localObject = b.bOR;
    AppMethodBeat.o(222038);
    return localObject;
  }
  
  public String zx()
  {
    AppMethodBeat.i(222100);
    int j = this.bOA;
    int i = j;
    if (j == 0) {
      i = zO();
    }
    if (i == 14) {
      localObject = zR();
    }
    for (;;)
    {
      this.bOA = 0;
      this.bOG[(this.bOF - 1)] = localObject;
      AppMethodBeat.o(222100);
      return localObject;
      if (i == 12)
      {
        localObject = i('\'');
      }
      else
      {
        if (i != 13) {
          break;
        }
        localObject = i('"');
      }
    }
    Object localObject = new IllegalStateException("Expected a name but was " + zw() + zU());
    AppMethodBeat.o(222100);
    throw ((Throwable)localObject);
  }
  
  public String zy()
  {
    AppMethodBeat.i(222111);
    int j = this.bOA;
    int i = j;
    if (j == 0) {
      i = zO();
    }
    if (i == 10) {
      localObject = zR();
    }
    for (;;)
    {
      this.bOA = 0;
      int[] arrayOfInt = this.bOH;
      i = this.bOF - 1;
      arrayOfInt[i] += 1;
      AppMethodBeat.o(222111);
      return localObject;
      if (i == 8)
      {
        localObject = i('\'');
      }
      else if (i == 9)
      {
        localObject = i('"');
      }
      else if (i == 11)
      {
        localObject = this.bOD;
        this.bOD = null;
      }
      else if (i == 15)
      {
        localObject = Long.toString(this.bOB);
      }
      else
      {
        if (i != 16) {
          break;
        }
        localObject = new String(this.aJp, this.pos, this.bOC);
        this.pos += this.bOC;
      }
    }
    Object localObject = new IllegalStateException("Expected a string but was " + zw() + zU());
    AppMethodBeat.o(222111);
    throw ((Throwable)localObject);
  }
  
  public boolean zz()
  {
    AppMethodBeat.i(222127);
    int j = this.bOA;
    int i = j;
    if (j == 0) {
      i = zO();
    }
    if (i == 5)
    {
      this.bOA = 0;
      localObject = this.bOH;
      i = this.bOF - 1;
      localObject[i] += 1;
      AppMethodBeat.o(222127);
      return true;
    }
    if (i == 6)
    {
      this.bOA = 0;
      localObject = this.bOH;
      i = this.bOF - 1;
      localObject[i] += 1;
      AppMethodBeat.o(222127);
      return false;
    }
    Object localObject = new IllegalStateException("Expected a boolean but was " + zw() + zU());
    AppMethodBeat.o(222127);
    throw ((Throwable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.a.d.a
 * JD-Core Version:    0.7.0.1
 */