package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Reader;
import java.io.StringReader;

final class f
{
  private final Reader aZV;
  private final char[] aZW;
  private int aZX;
  private int aZY;
  private int aZZ;
  private int baa;
  private StringBuilder bab;
  private int bac;
  private int index;
  private int line;
  
  private f(Reader paramReader, int paramInt)
  {
    AppMethodBeat.i(74743);
    this.aZV = paramReader;
    this.aZW = new char[paramInt];
    this.line = 1;
    this.bac = -1;
    AppMethodBeat.o(74743);
  }
  
  f(String paramString)
  {
    this(new StringReader(paramString), Math.max(10, Math.min(1024, paramString.length())));
    AppMethodBeat.i(74742);
    AppMethodBeat.o(74742);
  }
  
  private j aV(String paramString)
  {
    AppMethodBeat.i(74765);
    if (sC())
    {
      paramString = aW("Unexpected end of input");
      AppMethodBeat.o(74765);
      return paramString;
    }
    paramString = aW("Expected ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(74765);
    return paramString;
  }
  
  private void d(char paramChar)
  {
    AppMethodBeat.i(74751);
    if (!e(paramChar))
    {
      j localj = aV("'" + paramChar + "'");
      AppMethodBeat.o(74751);
      throw localj;
    }
    AppMethodBeat.o(74751);
  }
  
  private boolean e(char paramChar)
  {
    AppMethodBeat.i(74758);
    if (this.baa != paramChar)
    {
      AppMethodBeat.o(74758);
      return false;
    }
    sv();
    AppMethodBeat.o(74758);
    return true;
  }
  
  private boolean sA()
  {
    return (this.baa >= 48) && (this.baa <= 57);
  }
  
  private boolean sB()
  {
    return ((this.baa >= 48) && (this.baa <= 57)) || ((this.baa >= 97) && (this.baa <= 102)) || ((this.baa >= 65) && (this.baa <= 70));
  }
  
  private b sh()
  {
    AppMethodBeat.i(74745);
    sv();
    Object localObject = new b();
    su();
    if (e(']'))
    {
      AppMethodBeat.o(74745);
      return localObject;
    }
    do
    {
      su();
      ((b)localObject).a(sg());
      su();
    } while (e(','));
    if (!e(']'))
    {
      localObject = aV("',' or ']'");
      AppMethodBeat.o(74745);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(74745);
    return localObject;
  }
  
  private e si()
  {
    AppMethodBeat.i(74746);
    sv();
    Object localObject = new e();
    su();
    if (e('}'))
    {
      AppMethodBeat.o(74746);
      return localObject;
    }
    do
    {
      su();
      String str = sj();
      su();
      if (!e(':'))
      {
        localObject = aV("':'");
        AppMethodBeat.o(74746);
        throw ((Throwable)localObject);
      }
      su();
      ((e)localObject).a(str, sg());
      su();
    } while (e(','));
    if (!e('}'))
    {
      localObject = aV("',' or '}'");
      AppMethodBeat.o(74746);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(74746);
    return localObject;
  }
  
  private String sj()
  {
    AppMethodBeat.i(74747);
    if (this.baa != 34)
    {
      localObject = aV("name");
      AppMethodBeat.o(74747);
      throw ((Throwable)localObject);
    }
    Object localObject = so();
    AppMethodBeat.o(74747);
    return localObject;
  }
  
  private h sk()
  {
    AppMethodBeat.i(74748);
    sv();
    d('u');
    d('l');
    d('l');
    h localh = a.aZG;
    AppMethodBeat.o(74748);
    return localh;
  }
  
  private h sl()
  {
    AppMethodBeat.i(74749);
    sv();
    d('r');
    d('u');
    d('e');
    h localh = a.aZH;
    AppMethodBeat.o(74749);
    return localh;
  }
  
  private h sm()
  {
    AppMethodBeat.i(74750);
    sv();
    d('a');
    d('l');
    d('s');
    d('e');
    h localh = a.aZI;
    AppMethodBeat.o(74750);
    return localh;
  }
  
  private h sn()
  {
    AppMethodBeat.i(74752);
    g localg = new g(so());
    AppMethodBeat.o(74752);
    return localg;
  }
  
  private String so()
  {
    AppMethodBeat.i(74753);
    sv();
    sw();
    while (this.baa != 34) {
      if (this.baa == 92)
      {
        sx();
        sp();
        sw();
      }
      else
      {
        if (this.baa < 32)
        {
          localObject = aV("valid string character");
          AppMethodBeat.o(74753);
          throw ((Throwable)localObject);
        }
        sv();
      }
    }
    Object localObject = sy();
    sv();
    AppMethodBeat.o(74753);
    return localObject;
  }
  
  private void sp()
  {
    AppMethodBeat.i(74754);
    sv();
    Object localObject;
    switch (this.baa)
    {
    default: 
      localObject = aV("valid escape sequence");
      AppMethodBeat.o(74754);
      throw ((Throwable)localObject);
    case 34: 
    case 47: 
    case 92: 
      this.bab.append((char)this.baa);
    }
    for (;;)
    {
      sv();
      AppMethodBeat.o(74754);
      return;
      this.bab.append('\b');
      continue;
      this.bab.append('\f');
      continue;
      this.bab.append('\n');
      continue;
      this.bab.append('\r');
      continue;
      this.bab.append('\t');
      continue;
      localObject = new char[4];
      int i = 0;
      while (i < 4)
      {
        sv();
        if (!sB())
        {
          localObject = aV("hexadecimal digit");
          AppMethodBeat.o(74754);
          throw ((Throwable)localObject);
        }
        localObject[i] = ((char)this.baa);
        i += 1;
      }
      this.bab.append((char)Integer.parseInt(new String((char[])localObject), 16));
    }
  }
  
  private h sq()
  {
    AppMethodBeat.i(74755);
    sw();
    e('-');
    int i = this.baa;
    if (!st())
    {
      localObject = aV("digit");
      AppMethodBeat.o(74755);
      throw ((Throwable)localObject);
    }
    while ((i != 48) && (st())) {}
    sr();
    ss();
    Object localObject = new d(sy());
    AppMethodBeat.o(74755);
    return localObject;
  }
  
  private boolean sr()
  {
    AppMethodBeat.i(74756);
    if (!e('.'))
    {
      AppMethodBeat.o(74756);
      return false;
    }
    if (!st())
    {
      j localj = aV("digit");
      AppMethodBeat.o(74756);
      throw localj;
    }
    while (st()) {}
    AppMethodBeat.o(74756);
    return true;
  }
  
  private boolean ss()
  {
    AppMethodBeat.i(74757);
    if ((!e('e')) && (!e('E')))
    {
      AppMethodBeat.o(74757);
      return false;
    }
    if (!e('+')) {
      e('-');
    }
    if (!st())
    {
      j localj = aV("digit");
      AppMethodBeat.o(74757);
      throw localj;
    }
    while (st()) {}
    AppMethodBeat.o(74757);
    return true;
  }
  
  private boolean st()
  {
    AppMethodBeat.i(74759);
    if (!sA())
    {
      AppMethodBeat.o(74759);
      return false;
    }
    sv();
    AppMethodBeat.o(74759);
    return true;
  }
  
  private void sw()
  {
    AppMethodBeat.i(74762);
    if (this.bab == null) {
      this.bab = new StringBuilder();
    }
    this.bac = (this.index - 1);
    AppMethodBeat.o(74762);
  }
  
  private void sx()
  {
    AppMethodBeat.i(74763);
    if (this.baa == -1) {}
    for (int i = this.index;; i = this.index - 1)
    {
      StringBuilder localStringBuilder = this.bab;
      char[] arrayOfChar = this.aZW;
      int j = this.bac;
      localStringBuilder.append(arrayOfChar, j, i - j);
      this.bac = -1;
      AppMethodBeat.o(74763);
      return;
    }
  }
  
  private String sy()
  {
    AppMethodBeat.i(74764);
    int i;
    Object localObject;
    if (this.baa == -1)
    {
      i = this.index;
      if (this.bab.length() <= 0) {
        break label93;
      }
      localObject = this.bab;
      char[] arrayOfChar = this.aZW;
      int j = this.bac;
      ((StringBuilder)localObject).append(arrayOfChar, j, i - j);
      localObject = this.bab.toString();
      this.bab.setLength(0);
    }
    for (;;)
    {
      this.bac = -1;
      AppMethodBeat.o(74764);
      return localObject;
      i = this.index - 1;
      break;
      label93:
      localObject = new String(this.aZW, this.bac, i - this.bac);
    }
  }
  
  private boolean sz()
  {
    return (this.baa == 32) || (this.baa == 9) || (this.baa == 10) || (this.baa == 13);
  }
  
  final j aW(String paramString)
  {
    AppMethodBeat.i(74766);
    int j = this.aZX + this.index;
    int k = this.aZZ;
    if (sC()) {}
    for (int i = j;; i = j - 1)
    {
      paramString = new j(paramString, i, this.line, j - k - 1);
      AppMethodBeat.o(74766);
      return paramString;
    }
  }
  
  final boolean sC()
  {
    return this.baa == -1;
  }
  
  final h sg()
  {
    AppMethodBeat.i(74744);
    switch (this.baa)
    {
    default: 
      localObject = aV("value");
      AppMethodBeat.o(74744);
      throw ((Throwable)localObject);
    case 110: 
      localObject = sk();
      AppMethodBeat.o(74744);
      return localObject;
    case 116: 
      localObject = sl();
      AppMethodBeat.o(74744);
      return localObject;
    case 102: 
      localObject = sm();
      AppMethodBeat.o(74744);
      return localObject;
    case 34: 
      localObject = sn();
      AppMethodBeat.o(74744);
      return localObject;
    case 91: 
      localObject = sh();
      AppMethodBeat.o(74744);
      return localObject;
    case 123: 
      localObject = si();
      AppMethodBeat.o(74744);
      return localObject;
    }
    Object localObject = sq();
    AppMethodBeat.o(74744);
    return localObject;
  }
  
  final void su()
  {
    AppMethodBeat.i(74760);
    while (sz()) {
      sv();
    }
    AppMethodBeat.o(74760);
  }
  
  final void sv()
  {
    AppMethodBeat.i(74761);
    if (this.index == this.aZY)
    {
      if (this.bac != -1)
      {
        this.bab.append(this.aZW, this.bac, this.aZY - this.bac);
        this.bac = 0;
      }
      this.aZX += this.aZY;
      this.aZY = this.aZV.read(this.aZW, 0, this.aZW.length);
      this.index = 0;
      if (this.aZY == -1)
      {
        this.baa = -1;
        AppMethodBeat.o(74761);
        return;
      }
    }
    if (this.baa == 10)
    {
      this.line += 1;
      this.aZZ = (this.aZX + this.index);
    }
    char[] arrayOfChar = this.aZW;
    int i = this.index;
    this.index = (i + 1);
    this.baa = arrayOfChar[i];
    AppMethodBeat.o(74761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.a.f
 * JD-Core Version:    0.7.0.1
 */