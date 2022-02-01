package com.google.c.d;

import com.google.c.b.a.e;
import com.google.c.b.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class a
  implements Closeable
{
  private static final char[] dIc;
  private final char[] cCa;
  public boolean dEJ;
  private final Reader dId;
  private int dIe;
  int dIf;
  private long dIg;
  private int dIh;
  private String dIi;
  private int[] dIj;
  private int dIk;
  private String[] dIl;
  private int[] dIm;
  private int limit;
  private int lineNumber;
  private int pos;
  
  static
  {
    AppMethodBeat.i(208821);
    dIc = ")]}'\n".toCharArray();
    f.dFD = new f()
    {
      public final void b(a paramAnonymousa)
      {
        AppMethodBeat.i(208801);
        if ((paramAnonymousa instanceof e))
        {
          paramAnonymousa = b.dIr;
          AppMethodBeat.o(208801);
          throw null;
        }
        int j = paramAnonymousa.dIf;
        int i = j;
        if (j == 0) {
          i = paramAnonymousa.Zz();
        }
        if (i == 13)
        {
          paramAnonymousa.dIf = 9;
          AppMethodBeat.o(208801);
          return;
        }
        if (i == 12)
        {
          paramAnonymousa.dIf = 8;
          AppMethodBeat.o(208801);
          return;
        }
        if (i == 14)
        {
          paramAnonymousa.dIf = 10;
          AppMethodBeat.o(208801);
          return;
        }
        paramAnonymousa = new IllegalStateException("Expected a name but was " + paramAnonymousa.Zh() + paramAnonymousa.ZF());
        AppMethodBeat.o(208801);
        throw paramAnonymousa;
      }
    };
    AppMethodBeat.o(208821);
  }
  
  public a(Reader paramReader)
  {
    AppMethodBeat.i(208798);
    this.dEJ = false;
    this.cCa = new char[1024];
    this.pos = 0;
    this.limit = 0;
    this.lineNumber = 0;
    this.dIe = 0;
    this.dIf = 0;
    this.dIj = new int[32];
    this.dIk = 0;
    int[] arrayOfInt = this.dIj;
    int i = this.dIk;
    this.dIk = (i + 1);
    arrayOfInt[i] = 6;
    this.dIl = new String[32];
    this.dIm = new int[32];
    this.dId = paramReader;
    AppMethodBeat.o(208798);
  }
  
  private int ZA()
  {
    AppMethodBeat.i(208800);
    int i = this.cCa[this.pos];
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
      if ((this.pos + j >= this.limit) && (!jD(j + 1)))
      {
        AppMethodBeat.o(208800);
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
        AppMethodBeat.o(208800);
        return 0;
      }
      int m = this.cCa[(this.pos + j)];
      if ((m != str2.charAt(j)) && (m != str1.charAt(j)))
      {
        AppMethodBeat.o(208800);
        return 0;
      }
      j += 1;
    }
    label188:
    if (((this.pos + k < this.limit) || (jD(k + 1))) && (i(this.cCa[(this.pos + k)])))
    {
      AppMethodBeat.o(208800);
      return 0;
    }
    this.pos += k;
    this.dIf = i;
    AppMethodBeat.o(208800);
    return i;
  }
  
  private int ZB()
  {
    AppMethodBeat.i(208802);
    char[] arrayOfChar = this.cCa;
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
        AppMethodBeat.o(208802);
        return 0;
      }
      if (jD(j + 1))
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
          if (!i(c)) {
            break label405;
          }
          AppMethodBeat.o(208802);
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
        AppMethodBeat.o(208802);
        return 0;
        if (i == 5)
        {
          i = 6;
        }
        else
        {
          AppMethodBeat.o(208802);
          return 0;
          if ((i == 2) || (i == 4))
          {
            i = 5;
          }
          else
          {
            AppMethodBeat.o(208802);
            return 0;
            if (i == 2)
            {
              i = 3;
            }
            else
            {
              AppMethodBeat.o(208802);
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
                    AppMethodBeat.o(208802);
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
                      this.dIg = l1;
                      this.pos += j;
                      this.dIf = 15;
                      AppMethodBeat.o(208802);
                      return 15;
                      l1 = -l1;
                    }
                  }
                  if ((i == 2) || (i == 4) || (i == 7))
                  {
                    this.dIh = j;
                    this.dIf = 16;
                    AppMethodBeat.o(208802);
                    return 16;
                  }
                  AppMethodBeat.o(208802);
                  return 0;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private String ZC()
  {
    AppMethodBeat.i(208806);
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
        switch (this.cCa[(this.pos + i)])
        {
        default: 
          i += 1;
          break;
        case '#': 
        case '/': 
        case ';': 
        case '=': 
        case '\\': 
          ZD();
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
        for (localObject1 = new String(this.cCa, this.pos, j);; localObject1 = ((StringBuilder)localObject2).append(this.cCa, this.pos, j).toString())
        {
          this.pos = (j + this.pos);
          AppMethodBeat.o(208806);
          return localObject1;
          if (i < this.cCa.length)
          {
            localObject2 = localObject1;
            j = i;
            if (!jD(i + 1)) {
              break label192;
            }
            break;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new StringBuilder(Math.max(i, 16));
          }
          ((StringBuilder)localObject2).append(this.cCa, this.pos, i);
          this.pos = (i + this.pos);
          if (jD(1)) {
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
  
  private void ZD()
  {
    AppMethodBeat.i(208814);
    if (!this.dEJ)
    {
      IOException localIOException = dP("Use JsonReader.setLenient(true) to accept malformed JSON");
      AppMethodBeat.o(208814);
      throw localIOException;
    }
    AppMethodBeat.o(208814);
  }
  
  private void ZE()
  {
    AppMethodBeat.i(208815);
    int i;
    do
    {
      if ((this.pos >= this.limit) && (!jD(1))) {
        break;
      }
      char[] arrayOfChar = this.cCa;
      i = this.pos;
      this.pos = (i + 1);
      i = arrayOfChar[i];
      if (i == 10)
      {
        this.lineNumber += 1;
        this.dIe = this.pos;
        AppMethodBeat.o(208815);
        return;
      }
    } while (i != 13);
    AppMethodBeat.o(208815);
  }
  
  private char ZG()
  {
    AppMethodBeat.i(208818);
    if ((this.pos == this.limit) && (!jD(1)))
    {
      localObject = dP("Unterminated escape sequence");
      AppMethodBeat.o(208818);
      throw ((Throwable)localObject);
    }
    Object localObject = this.cCa;
    int i = this.pos;
    this.pos = (i + 1);
    char c = localObject[i];
    switch (c)
    {
    default: 
      localObject = dP("Invalid escape sequence");
      AppMethodBeat.o(208818);
      throw ((Throwable)localObject);
    case 'u': 
      if ((this.pos + 4 > this.limit) && (!jD(4)))
      {
        localObject = dP("Unterminated escape sequence");
        AppMethodBeat.o(208818);
        throw ((Throwable)localObject);
      }
      c = '\000';
      int j = this.pos;
      i = j;
      if (i < j + 4)
      {
        int k = this.cCa[i];
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
        localObject = new NumberFormatException("\\u" + new String(this.cCa, this.pos, 4));
        AppMethodBeat.o(208818);
        throw ((Throwable)localObject);
      }
      this.pos += 4;
      AppMethodBeat.o(208818);
      return c;
    case 't': 
      AppMethodBeat.o(208818);
      return '\t';
    case 'b': 
      AppMethodBeat.o(208818);
      return '\b';
    case 'n': 
      AppMethodBeat.o(208818);
      return '\n';
    case 'r': 
      AppMethodBeat.o(208818);
      return '\r';
    case 'f': 
      AppMethodBeat.o(208818);
      return '\f';
    case '\n': 
      label338:
      this.lineNumber += 1;
      this.dIe = this.pos;
    }
    AppMethodBeat.o(208818);
    return c;
  }
  
  private void ZH()
  {
    AppMethodBeat.i(208820);
    bX(true);
    this.pos -= 1;
    if ((this.pos + dIc.length > this.limit) && (!jD(dIc.length)))
    {
      AppMethodBeat.o(208820);
      return;
    }
    int i = 0;
    while (i < dIc.length)
    {
      if (this.cCa[(this.pos + i)] != dIc[i])
      {
        AppMethodBeat.o(208820);
        return;
      }
      i += 1;
    }
    this.pos += dIc.length;
    AppMethodBeat.o(208820);
  }
  
  private void bF(int paramInt)
  {
    AppMethodBeat.i(208809);
    if (this.dIk == this.dIj.length)
    {
      arrayOfInt1 = new int[this.dIk * 2];
      int[] arrayOfInt2 = new int[this.dIk * 2];
      String[] arrayOfString = new String[this.dIk * 2];
      System.arraycopy(this.dIj, 0, arrayOfInt1, 0, this.dIk);
      System.arraycopy(this.dIm, 0, arrayOfInt2, 0, this.dIk);
      System.arraycopy(this.dIl, 0, arrayOfString, 0, this.dIk);
      this.dIj = arrayOfInt1;
      this.dIm = arrayOfInt2;
      this.dIl = arrayOfString;
    }
    int[] arrayOfInt1 = this.dIj;
    int i = this.dIk;
    this.dIk = (i + 1);
    arrayOfInt1[i] = paramInt;
    AppMethodBeat.o(208809);
  }
  
  private int bX(boolean paramBoolean)
  {
    AppMethodBeat.i(208813);
    Object localObject = this.cCa;
    int i = this.pos;
    int j = this.limit;
    for (;;)
    {
      int k = j;
      int m = i;
      if (i == j)
      {
        this.pos = i;
        if (jD(1))
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
          this.dIe = i;
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
            boolean bool = jD(2);
            this.pos += 1;
            if (!bool)
            {
              AppMethodBeat.o(208813);
              return j;
            }
          }
          ZD();
          switch (localObject[this.pos])
          {
          default: 
            AppMethodBeat.o(208813);
            return j;
          case '*': 
            this.pos += 1;
            if (!dO("*/"))
            {
              localObject = dP("Unterminated comment");
              AppMethodBeat.o(208813);
              throw ((Throwable)localObject);
            }
            i = this.pos + 2;
            j = this.limit;
            break;
          case '/': 
            this.pos += 1;
            ZE();
            i = this.pos;
            j = this.limit;
            break;
          }
        }
        if (j == 35)
        {
          this.pos = i;
          ZD();
          ZE();
          i = this.pos;
          j = this.limit;
          continue;
        }
        this.pos = i;
        AppMethodBeat.o(208813);
        return j;
      }
      if (paramBoolean)
      {
        localObject = new EOFException("End of input" + ZF());
        AppMethodBeat.o(208813);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(208813);
      return -1;
      label383:
      j = k;
    }
  }
  
  private boolean dO(String paramString)
  {
    AppMethodBeat.i(208817);
    int j = paramString.length();
    while ((this.pos + j <= this.limit) || (jD(j))) {
      if (this.cCa[this.pos] == '\n')
      {
        this.lineNumber += 1;
        this.dIe = (this.pos + 1);
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
          if (this.cCa[(this.pos + i)] != paramString.charAt(i)) {
            break;
          }
          i += 1;
        }
        label111:
        AppMethodBeat.o(208817);
        return true;
      }
    }
    AppMethodBeat.o(208817);
    return false;
  }
  
  private IOException dP(String paramString)
  {
    AppMethodBeat.i(208819);
    paramString = new d(paramString + ZF());
    AppMethodBeat.o(208819);
    throw paramString;
  }
  
  private boolean i(char paramChar)
  {
    AppMethodBeat.i(208803);
    switch (paramChar)
    {
    default: 
      AppMethodBeat.o(208803);
      return true;
    case '#': 
    case '/': 
    case ';': 
    case '=': 
    case '\\': 
      ZD();
    }
    AppMethodBeat.o(208803);
    return false;
  }
  
  private String j(char paramChar)
  {
    AppMethodBeat.i(208804);
    char[] arrayOfChar = this.cCa;
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
            AppMethodBeat.o(208804);
            return localObject1;
          }
          ((StringBuilder)localObject1).append(arrayOfChar, c2, paramChar);
          localObject1 = ((StringBuilder)localObject1).toString();
          AppMethodBeat.o(208804);
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
          ((StringBuilder)localObject2).append(ZG());
          localObject1 = localObject2;
          break;
        }
        if (c1 == '\n')
        {
          this.lineNumber += 1;
          this.dIe = c3;
        }
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuilder(Math.max((c1 - c2) * 2, 16));
      }
      ((StringBuilder)localObject2).append(arrayOfChar, c2, c1 - c2);
      this.pos = c1;
      localObject1 = localObject2;
    } while (jD(1));
    localObject1 = dP("Unterminated string");
    AppMethodBeat.o(208804);
    throw ((Throwable)localObject1);
  }
  
  private boolean jD(int paramInt)
  {
    AppMethodBeat.i(208812);
    char[] arrayOfChar = this.cCa;
    this.dIe -= this.pos;
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
        i = this.dId.read(arrayOfChar, this.limit, arrayOfChar.length - this.limit);
        if (i == -1) {
          break;
        }
        this.limit = (i + this.limit);
        i = paramInt;
        if (this.lineNumber == 0)
        {
          i = paramInt;
          if (this.dIe == 0)
          {
            i = paramInt;
            if (this.limit > 0)
            {
              i = paramInt;
              if (arrayOfChar[0] == 65279)
              {
                this.pos += 1;
                this.dIe += 1;
                i = paramInt + 1;
              }
            }
          }
        }
        paramInt = i;
      } while (this.limit < i);
      AppMethodBeat.o(208812);
      return true;
      this.limit = 0;
    }
    AppMethodBeat.o(208812);
    return false;
  }
  
  private void k(char paramChar)
  {
    AppMethodBeat.i(208807);
    Object localObject = this.cCa;
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
          AppMethodBeat.o(208807);
          return;
        }
        if (c1 == '\\')
        {
          this.pos = c2;
          ZG();
          break;
        }
        if (c1 == '\n')
        {
          this.lineNumber += 1;
          this.dIe = c2;
        }
        c1 = c2;
      }
      this.pos = c1;
    } while (jD(1));
    localObject = dP("Unterminated string");
    AppMethodBeat.o(208807);
    throw ((Throwable)localObject);
  }
  
  final String ZF()
  {
    AppMethodBeat.i(208881);
    int i = this.lineNumber;
    int j = this.pos;
    int k = this.dIe;
    String str = " at line " + (i + 1) + " column " + (j - k + 1) + " path " + getPath();
    AppMethodBeat.o(208881);
    return str;
  }
  
  public void Zd()
  {
    AppMethodBeat.i(208822);
    int j = this.dIf;
    int i = j;
    if (j == 0) {
      i = Zz();
    }
    if (i == 3)
    {
      bF(1);
      this.dIm[(this.dIk - 1)] = 0;
      this.dIf = 0;
      AppMethodBeat.o(208822);
      return;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("Expected BEGIN_ARRAY but was " + Zh() + ZF());
    AppMethodBeat.o(208822);
    throw localIllegalStateException;
  }
  
  public void Ze()
  {
    AppMethodBeat.i(208823);
    int j = this.dIf;
    int i = j;
    if (j == 0) {
      i = Zz();
    }
    if (i == 4)
    {
      this.dIk -= 1;
      localObject = this.dIm;
      i = this.dIk - 1;
      localObject[i] += 1;
      this.dIf = 0;
      AppMethodBeat.o(208823);
      return;
    }
    Object localObject = new IllegalStateException("Expected END_ARRAY but was " + Zh() + ZF());
    AppMethodBeat.o(208823);
    throw ((Throwable)localObject);
  }
  
  public void Zf()
  {
    AppMethodBeat.i(208824);
    int j = this.dIf;
    int i = j;
    if (j == 0) {
      i = Zz();
    }
    if (i == 1)
    {
      bF(3);
      this.dIf = 0;
      AppMethodBeat.o(208824);
      return;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("Expected BEGIN_OBJECT but was " + Zh() + ZF());
    AppMethodBeat.o(208824);
    throw localIllegalStateException;
  }
  
  public void Zg()
  {
    AppMethodBeat.i(208825);
    int j = this.dIf;
    int i = j;
    if (j == 0) {
      i = Zz();
    }
    if (i == 2)
    {
      this.dIk -= 1;
      this.dIl[this.dIk] = null;
      localObject = this.dIm;
      i = this.dIk - 1;
      localObject[i] += 1;
      this.dIf = 0;
      AppMethodBeat.o(208825);
      return;
    }
    Object localObject = new IllegalStateException("Expected END_OBJECT but was " + Zh() + ZF());
    AppMethodBeat.o(208825);
    throw ((Throwable)localObject);
  }
  
  public b Zh()
  {
    AppMethodBeat.i(208827);
    int j = this.dIf;
    int i = j;
    if (j == 0) {
      i = Zz();
    }
    switch (i)
    {
    default: 
      localObject = new AssertionError();
      AppMethodBeat.o(208827);
      throw ((Throwable)localObject);
    case 1: 
      localObject = b.dIp;
      AppMethodBeat.o(208827);
      return localObject;
    case 2: 
      localObject = b.dIq;
      AppMethodBeat.o(208827);
      return localObject;
    case 3: 
      localObject = b.dIn;
      AppMethodBeat.o(208827);
      return localObject;
    case 4: 
      localObject = b.dIo;
      AppMethodBeat.o(208827);
      return localObject;
    case 12: 
    case 13: 
    case 14: 
      localObject = b.dIr;
      AppMethodBeat.o(208827);
      return localObject;
    case 5: 
    case 6: 
      localObject = b.dIu;
      AppMethodBeat.o(208827);
      return localObject;
    case 7: 
      localObject = b.dIv;
      AppMethodBeat.o(208827);
      return localObject;
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      localObject = b.dIs;
      AppMethodBeat.o(208827);
      return localObject;
    case 15: 
    case 16: 
      localObject = b.dIt;
      AppMethodBeat.o(208827);
      return localObject;
    }
    Object localObject = b.dIw;
    AppMethodBeat.o(208827);
    return localObject;
  }
  
  public String Zi()
  {
    AppMethodBeat.i(208839);
    int j = this.dIf;
    int i = j;
    if (j == 0) {
      i = Zz();
    }
    if (i == 14) {
      localObject = ZC();
    }
    for (;;)
    {
      this.dIf = 0;
      this.dIl[(this.dIk - 1)] = localObject;
      AppMethodBeat.o(208839);
      return localObject;
      if (i == 12)
      {
        localObject = j('\'');
      }
      else
      {
        if (i != 13) {
          break;
        }
        localObject = j('"');
      }
    }
    Object localObject = new IllegalStateException("Expected a name but was " + Zh() + ZF());
    AppMethodBeat.o(208839);
    throw ((Throwable)localObject);
  }
  
  public String Zj()
  {
    AppMethodBeat.i(208841);
    int j = this.dIf;
    int i = j;
    if (j == 0) {
      i = Zz();
    }
    if (i == 10) {
      localObject = ZC();
    }
    for (;;)
    {
      this.dIf = 0;
      int[] arrayOfInt = this.dIm;
      i = this.dIk - 1;
      arrayOfInt[i] += 1;
      AppMethodBeat.o(208841);
      return localObject;
      if (i == 8)
      {
        localObject = j('\'');
      }
      else if (i == 9)
      {
        localObject = j('"');
      }
      else if (i == 11)
      {
        localObject = this.dIi;
        this.dIi = null;
      }
      else if (i == 15)
      {
        localObject = Long.toString(this.dIg);
      }
      else
      {
        if (i != 16) {
          break;
        }
        localObject = new String(this.cCa, this.pos, this.dIh);
        this.pos += this.dIh;
      }
    }
    Object localObject = new IllegalStateException("Expected a string but was " + Zh() + ZF());
    AppMethodBeat.o(208841);
    throw ((Throwable)localObject);
  }
  
  public boolean Zk()
  {
    AppMethodBeat.i(208843);
    int j = this.dIf;
    int i = j;
    if (j == 0) {
      i = Zz();
    }
    if (i == 5)
    {
      this.dIf = 0;
      localObject = this.dIm;
      i = this.dIk - 1;
      localObject[i] += 1;
      AppMethodBeat.o(208843);
      return true;
    }
    if (i == 6)
    {
      this.dIf = 0;
      localObject = this.dIm;
      i = this.dIk - 1;
      localObject[i] += 1;
      AppMethodBeat.o(208843);
      return false;
    }
    Object localObject = new IllegalStateException("Expected a boolean but was " + Zh() + ZF());
    AppMethodBeat.o(208843);
    throw ((Throwable)localObject);
  }
  
  public void Zl()
  {
    AppMethodBeat.i(208847);
    int j = this.dIf;
    int i = j;
    if (j == 0) {
      i = Zz();
    }
    if (i == 7)
    {
      this.dIf = 0;
      localObject = this.dIm;
      i = this.dIk - 1;
      localObject[i] += 1;
      AppMethodBeat.o(208847);
      return;
    }
    Object localObject = new IllegalStateException("Expected null but was " + Zh() + ZF());
    AppMethodBeat.o(208847);
    throw ((Throwable)localObject);
  }
  
  public double Zm()
  {
    AppMethodBeat.i(208851);
    int j = this.dIf;
    int i = j;
    if (j == 0) {
      i = Zz();
    }
    double d;
    if (i == 15)
    {
      this.dIf = 0;
      localObject = this.dIm;
      i = this.dIk - 1;
      localObject[i] += 1;
      d = this.dIg;
      AppMethodBeat.o(208851);
      return d;
    }
    if (i == 16)
    {
      this.dIi = new String(this.cCa, this.pos, this.dIh);
      this.pos += this.dIh;
    }
    do
    {
      for (;;)
      {
        this.dIf = 11;
        d = Double.parseDouble(this.dIi);
        if ((this.dEJ) || ((!Double.isNaN(d)) && (!Double.isInfinite(d)))) {
          break label311;
        }
        localObject = new d("JSON forbids NaN and infinities: " + d + ZF());
        AppMethodBeat.o(208851);
        throw ((Throwable)localObject);
        if ((i == 8) || (i == 9))
        {
          if (i == 8) {}
          for (char c = '\'';; c = '"')
          {
            this.dIi = j(c);
            break;
          }
        }
        if (i != 10) {
          break;
        }
        this.dIi = ZC();
      }
    } while (i == 11);
    Object localObject = new IllegalStateException("Expected a double but was " + Zh() + ZF());
    AppMethodBeat.o(208851);
    throw ((Throwable)localObject);
    label311:
    this.dIi = null;
    this.dIf = 0;
    localObject = this.dIm;
    i = this.dIk - 1;
    localObject[i] += 1;
    AppMethodBeat.o(208851);
    return d;
  }
  
  public long Zn()
  {
    AppMethodBeat.i(208854);
    int j = this.dIf;
    int i = j;
    if (j == 0) {
      i = Zz();
    }
    Object localObject;
    long l;
    if (i == 15)
    {
      this.dIf = 0;
      localObject = this.dIm;
      i = this.dIk - 1;
      localObject[i] += 1;
      l = this.dIg;
      AppMethodBeat.o(208854);
      return l;
    }
    if (i == 16)
    {
      this.dIi = new String(this.cCa, this.pos, this.dIh);
      this.pos += this.dIh;
    }
    for (;;)
    {
      this.dIf = 11;
      double d = Double.parseDouble(this.dIi);
      l = d;
      if (l != d)
      {
        localObject = new NumberFormatException("Expected a long but was " + this.dIi + ZF());
        AppMethodBeat.o(208854);
        throw ((Throwable)localObject);
        if ((i == 8) || (i == 9) || (i == 10)) {
          if (i == 10) {
            this.dIi = ZC();
          }
        }
      }
      try
      {
        l = Long.parseLong(this.dIi);
        this.dIf = 0;
        localObject = this.dIm;
        i = this.dIk - 1;
        localObject[i] += 1;
        AppMethodBeat.o(208854);
        return l;
      }
      catch (NumberFormatException localNumberFormatException) {}
      if (i == 8) {}
      for (char c = '\'';; c = '"')
      {
        this.dIi = j(c);
        break;
      }
      localObject = new IllegalStateException("Expected a long but was " + Zh() + ZF());
      AppMethodBeat.o(208854);
      throw ((Throwable)localObject);
      this.dIi = null;
      this.dIf = 0;
      localObject = this.dIm;
      i = this.dIk - 1;
      localObject[i] += 1;
      AppMethodBeat.o(208854);
      return l;
    }
  }
  
  public int Zo()
  {
    AppMethodBeat.i(208862);
    int j = this.dIf;
    int i = j;
    if (j == 0) {
      i = Zz();
    }
    Object localObject;
    if (i == 15)
    {
      i = (int)this.dIg;
      if (this.dIg != i)
      {
        localObject = new NumberFormatException("Expected an int but was " + this.dIg + ZF());
        AppMethodBeat.o(208862);
        throw ((Throwable)localObject);
      }
      this.dIf = 0;
      localObject = this.dIm;
      j = this.dIk - 1;
      localObject[j] += 1;
      AppMethodBeat.o(208862);
      return i;
    }
    if (i == 16)
    {
      this.dIi = new String(this.cCa, this.pos, this.dIh);
      this.pos += this.dIh;
    }
    for (;;)
    {
      this.dIf = 11;
      double d = Double.parseDouble(this.dIi);
      i = (int)d;
      if (i != d)
      {
        localObject = new NumberFormatException("Expected an int but was " + this.dIi + ZF());
        AppMethodBeat.o(208862);
        throw ((Throwable)localObject);
        if ((i == 8) || (i == 9) || (i == 10)) {
          if (i == 10) {
            this.dIi = ZC();
          }
        }
      }
      try
      {
        i = Integer.parseInt(this.dIi);
        this.dIf = 0;
        localObject = this.dIm;
        j = this.dIk - 1;
        localObject[j] += 1;
        AppMethodBeat.o(208862);
        return i;
      }
      catch (NumberFormatException localNumberFormatException) {}
      if (i == 8) {}
      for (char c = '\'';; c = '"')
      {
        this.dIi = j(c);
        break;
      }
      localObject = new IllegalStateException("Expected an int but was " + Zh() + ZF());
      AppMethodBeat.o(208862);
      throw ((Throwable)localObject);
      this.dIi = null;
      this.dIf = 0;
      localObject = this.dIm;
      j = this.dIk - 1;
      localObject[j] += 1;
      AppMethodBeat.o(208862);
      return i;
    }
  }
  
  public void Zp()
  {
    AppMethodBeat.i(208872);
    int j = 0;
    int i = this.dIf;
    int k = i;
    if (i == 0) {
      k = Zz();
    }
    if (k == 3)
    {
      bF(1);
      i = j + 1;
    }
    for (;;)
    {
      label38:
      this.dIf = 0;
      j = i;
      if (i != 0) {
        break;
      }
      int[] arrayOfInt = this.dIm;
      i = this.dIk - 1;
      arrayOfInt[i] += 1;
      this.dIl[(this.dIk - 1)] = "null";
      AppMethodBeat.o(208872);
      return;
      if (k == 1)
      {
        bF(3);
        i = j + 1;
      }
      else if (k == 4)
      {
        this.dIk -= 1;
        i = j - 1;
      }
      else if (k == 2)
      {
        this.dIk -= 1;
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
              switch (this.cCa[(this.pos + i)])
              {
              default: 
                i += 1;
                break;
              case '#': 
              case '/': 
              case ';': 
              case '=': 
              case '\\': 
                ZD();
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
        } while (jD(1));
        i = j;
      }
      else if ((k == 8) || (k == 12))
      {
        k('\'');
        i = j;
      }
      else if ((k == 9) || (k == 13))
      {
        k('"');
        i = j;
      }
      else
      {
        i = j;
        if (k == 16)
        {
          this.pos += this.dIh;
          i = j;
        }
      }
    }
  }
  
  final int Zz()
  {
    AppMethodBeat.i(208835);
    int i = this.dIj[(this.dIk - 1)];
    if (i == 1) {
      this.dIj[(this.dIk - 1)] = 2;
    }
    label682:
    do
    {
      for (;;)
      {
        switch (bX(true))
        {
        default: 
          this.pos -= 1;
          i = ZA();
          if (i == 0) {
            break label840;
          }
          AppMethodBeat.o(208835);
          return i;
          if (i == 2)
          {
            switch (bX(true))
            {
            case 44: 
            default: 
              localObject = dP("Unterminated array");
              AppMethodBeat.o(208835);
              throw ((Throwable)localObject);
            case 93: 
              this.dIf = 4;
              AppMethodBeat.o(208835);
              return 4;
            }
            ZD();
          }
          else
          {
            if ((i == 3) || (i == 5))
            {
              this.dIj[(this.dIk - 1)] = 4;
              if (i == 5) {
                switch (bX(true))
                {
                default: 
                  localObject = dP("Unterminated object");
                  AppMethodBeat.o(208835);
                  throw ((Throwable)localObject);
                case 125: 
                  this.dIf = 2;
                  AppMethodBeat.o(208835);
                  return 2;
                case 59: 
                  ZD();
                }
              }
              int j = bX(true);
              switch (j)
              {
              default: 
                ZD();
                this.pos -= 1;
                if (i((char)j))
                {
                  this.dIf = 14;
                  AppMethodBeat.o(208835);
                  return 14;
                }
                break;
              case 34: 
                this.dIf = 13;
                AppMethodBeat.o(208835);
                return 13;
              case 39: 
                ZD();
                this.dIf = 12;
                AppMethodBeat.o(208835);
                return 12;
              case 125: 
                if (i != 5)
                {
                  this.dIf = 2;
                  AppMethodBeat.o(208835);
                  return 2;
                }
                localObject = dP("Expected name");
                AppMethodBeat.o(208835);
                throw ((Throwable)localObject);
              }
              localObject = dP("Expected name");
              AppMethodBeat.o(208835);
              throw ((Throwable)localObject);
            }
            if (i == 4)
            {
              this.dIj[(this.dIk - 1)] = 5;
              switch (bX(true))
              {
              case 58: 
              case 59: 
              case 60: 
              default: 
                localObject = dP("Expected ':'");
                AppMethodBeat.o(208835);
                throw ((Throwable)localObject);
              }
              ZD();
              if (((this.pos < this.limit) || (jD(1))) && (this.cCa[this.pos] == '>')) {
                this.pos += 1;
              }
            }
            else if (i == 6)
            {
              if (this.dEJ) {
                ZH();
              }
              this.dIj[(this.dIk - 1)] = 7;
            }
            else
            {
              if (i != 7) {
                break label682;
              }
              if (bX(false) == -1)
              {
                this.dIf = 17;
                AppMethodBeat.o(208835);
                return 17;
              }
              ZD();
              this.pos -= 1;
            }
          }
          break;
        }
      }
    } while (i != 8);
    Object localObject = new IllegalStateException("JsonReader is closed");
    AppMethodBeat.o(208835);
    throw ((Throwable)localObject);
    if (i == 1)
    {
      this.dIf = 4;
      AppMethodBeat.o(208835);
      return 4;
    }
    if ((i == 1) || (i == 2))
    {
      ZD();
      this.pos -= 1;
      this.dIf = 7;
      AppMethodBeat.o(208835);
      return 7;
    }
    localObject = dP("Unexpected value");
    AppMethodBeat.o(208835);
    throw ((Throwable)localObject);
    ZD();
    this.dIf = 8;
    AppMethodBeat.o(208835);
    return 8;
    this.dIf = 9;
    AppMethodBeat.o(208835);
    return 9;
    this.dIf = 3;
    AppMethodBeat.o(208835);
    return 3;
    this.dIf = 1;
    AppMethodBeat.o(208835);
    return 1;
    label840:
    i = ZB();
    if (i != 0)
    {
      AppMethodBeat.o(208835);
      return i;
    }
    if (!i(this.cCa[this.pos]))
    {
      localObject = dP("Expected value");
      AppMethodBeat.o(208835);
      throw ((Throwable)localObject);
    }
    ZD();
    this.dIf = 10;
    AppMethodBeat.o(208835);
    return 10;
  }
  
  public void close()
  {
    AppMethodBeat.i(208867);
    this.dIf = 0;
    this.dIj[0] = 8;
    this.dIk = 1;
    this.dId.close();
    AppMethodBeat.o(208867);
  }
  
  public String getPath()
  {
    AppMethodBeat.i(208885);
    Object localObject = new StringBuilder("$");
    int i = 0;
    int j = this.dIk;
    if (i < j)
    {
      switch (this.dIj[i])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        ((StringBuilder)localObject).append('[').append(this.dIm[i]).append(']');
        continue;
        ((StringBuilder)localObject).append('.');
        if (this.dIl[i] != null) {
          ((StringBuilder)localObject).append(this.dIl[i]);
        }
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(208885);
    return localObject;
  }
  
  public boolean hasNext()
  {
    AppMethodBeat.i(208826);
    int j = this.dIf;
    int i = j;
    if (j == 0) {
      i = Zz();
    }
    if ((i != 2) && (i != 4))
    {
      AppMethodBeat.o(208826);
      return true;
    }
    AppMethodBeat.o(208826);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(208875);
    String str = getClass().getSimpleName() + ZF();
    AppMethodBeat.o(208875);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.c.d.a
 * JD-Core Version:    0.7.0.1
 */