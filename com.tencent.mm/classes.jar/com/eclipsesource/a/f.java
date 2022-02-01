package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Reader;
import java.io.StringReader;

final class f
{
  private final Reader aZR;
  private final char[] aZS;
  private int aZT;
  private int aZU;
  private int aZV;
  private int aZW;
  private StringBuilder aZX;
  private int aZY;
  private int index;
  private int line;
  
  private f(Reader paramReader, int paramInt)
  {
    AppMethodBeat.i(74743);
    this.aZR = paramReader;
    this.aZS = new char[paramInt];
    this.line = 1;
    this.aZY = -1;
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
    if (sF())
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
    if (this.aZW != paramChar)
    {
      AppMethodBeat.o(74758);
      return false;
    }
    sy();
    AppMethodBeat.o(74758);
    return true;
  }
  
  private void sA()
  {
    AppMethodBeat.i(74763);
    if (this.aZW == -1) {}
    for (int i = this.index;; i = this.index - 1)
    {
      StringBuilder localStringBuilder = this.aZX;
      char[] arrayOfChar = this.aZS;
      int j = this.aZY;
      localStringBuilder.append(arrayOfChar, j, i - j);
      this.aZY = -1;
      AppMethodBeat.o(74763);
      return;
    }
  }
  
  private String sB()
  {
    AppMethodBeat.i(74764);
    int i;
    Object localObject;
    if (this.aZW == -1)
    {
      i = this.index;
      if (this.aZX.length() <= 0) {
        break label93;
      }
      localObject = this.aZX;
      char[] arrayOfChar = this.aZS;
      int j = this.aZY;
      ((StringBuilder)localObject).append(arrayOfChar, j, i - j);
      localObject = this.aZX.toString();
      this.aZX.setLength(0);
    }
    for (;;)
    {
      this.aZY = -1;
      AppMethodBeat.o(74764);
      return localObject;
      i = this.index - 1;
      break;
      label93:
      localObject = new String(this.aZS, this.aZY, i - this.aZY);
    }
  }
  
  private boolean sC()
  {
    return (this.aZW == 32) || (this.aZW == 9) || (this.aZW == 10) || (this.aZW == 13);
  }
  
  private boolean sD()
  {
    return (this.aZW >= 48) && (this.aZW <= 57);
  }
  
  private boolean sE()
  {
    return ((this.aZW >= 48) && (this.aZW <= 57)) || ((this.aZW >= 97) && (this.aZW <= 102)) || ((this.aZW >= 65) && (this.aZW <= 70));
  }
  
  private b sk()
  {
    AppMethodBeat.i(74745);
    sy();
    Object localObject = new b();
    sx();
    if (e(']'))
    {
      AppMethodBeat.o(74745);
      return localObject;
    }
    do
    {
      sx();
      ((b)localObject).a(sj());
      sx();
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
  
  private e sl()
  {
    AppMethodBeat.i(74746);
    sy();
    Object localObject = new e();
    sx();
    if (e('}'))
    {
      AppMethodBeat.o(74746);
      return localObject;
    }
    do
    {
      sx();
      String str = sm();
      sx();
      if (!e(':'))
      {
        localObject = aV("':'");
        AppMethodBeat.o(74746);
        throw ((Throwable)localObject);
      }
      sx();
      ((e)localObject).a(str, sj());
      sx();
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
  
  private String sm()
  {
    AppMethodBeat.i(74747);
    if (this.aZW != 34)
    {
      localObject = aV("name");
      AppMethodBeat.o(74747);
      throw ((Throwable)localObject);
    }
    Object localObject = sr();
    AppMethodBeat.o(74747);
    return localObject;
  }
  
  private h sn()
  {
    AppMethodBeat.i(74748);
    sy();
    d('u');
    d('l');
    d('l');
    h localh = a.aZC;
    AppMethodBeat.o(74748);
    return localh;
  }
  
  private h so()
  {
    AppMethodBeat.i(74749);
    sy();
    d('r');
    d('u');
    d('e');
    h localh = a.aZD;
    AppMethodBeat.o(74749);
    return localh;
  }
  
  private h sp()
  {
    AppMethodBeat.i(74750);
    sy();
    d('a');
    d('l');
    d('s');
    d('e');
    h localh = a.aZE;
    AppMethodBeat.o(74750);
    return localh;
  }
  
  private h sq()
  {
    AppMethodBeat.i(74752);
    g localg = new g(sr());
    AppMethodBeat.o(74752);
    return localg;
  }
  
  private String sr()
  {
    AppMethodBeat.i(74753);
    sy();
    sz();
    while (this.aZW != 34) {
      if (this.aZW == 92)
      {
        sA();
        ss();
        sz();
      }
      else
      {
        if (this.aZW < 32)
        {
          localObject = aV("valid string character");
          AppMethodBeat.o(74753);
          throw ((Throwable)localObject);
        }
        sy();
      }
    }
    Object localObject = sB();
    sy();
    AppMethodBeat.o(74753);
    return localObject;
  }
  
  private void ss()
  {
    AppMethodBeat.i(74754);
    sy();
    Object localObject;
    switch (this.aZW)
    {
    default: 
      localObject = aV("valid escape sequence");
      AppMethodBeat.o(74754);
      throw ((Throwable)localObject);
    case 34: 
    case 47: 
    case 92: 
      this.aZX.append((char)this.aZW);
    }
    for (;;)
    {
      sy();
      AppMethodBeat.o(74754);
      return;
      this.aZX.append('\b');
      continue;
      this.aZX.append('\f');
      continue;
      this.aZX.append('\n');
      continue;
      this.aZX.append('\r');
      continue;
      this.aZX.append('\t');
      continue;
      localObject = new char[4];
      int i = 0;
      while (i < 4)
      {
        sy();
        if (!sE())
        {
          localObject = aV("hexadecimal digit");
          AppMethodBeat.o(74754);
          throw ((Throwable)localObject);
        }
        localObject[i] = ((char)this.aZW);
        i += 1;
      }
      this.aZX.append((char)Integer.parseInt(new String((char[])localObject), 16));
    }
  }
  
  private h st()
  {
    AppMethodBeat.i(74755);
    sz();
    e('-');
    int i = this.aZW;
    if (!sw())
    {
      localObject = aV("digit");
      AppMethodBeat.o(74755);
      throw ((Throwable)localObject);
    }
    while ((i != 48) && (sw())) {}
    su();
    sv();
    Object localObject = new d(sB());
    AppMethodBeat.o(74755);
    return localObject;
  }
  
  private boolean su()
  {
    AppMethodBeat.i(74756);
    if (!e('.'))
    {
      AppMethodBeat.o(74756);
      return false;
    }
    if (!sw())
    {
      j localj = aV("digit");
      AppMethodBeat.o(74756);
      throw localj;
    }
    while (sw()) {}
    AppMethodBeat.o(74756);
    return true;
  }
  
  private boolean sv()
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
    if (!sw())
    {
      j localj = aV("digit");
      AppMethodBeat.o(74757);
      throw localj;
    }
    while (sw()) {}
    AppMethodBeat.o(74757);
    return true;
  }
  
  private boolean sw()
  {
    AppMethodBeat.i(74759);
    if (!sD())
    {
      AppMethodBeat.o(74759);
      return false;
    }
    sy();
    AppMethodBeat.o(74759);
    return true;
  }
  
  private void sz()
  {
    AppMethodBeat.i(74762);
    if (this.aZX == null) {
      this.aZX = new StringBuilder();
    }
    this.aZY = (this.index - 1);
    AppMethodBeat.o(74762);
  }
  
  final j aW(String paramString)
  {
    AppMethodBeat.i(74766);
    int j = this.aZT + this.index;
    int k = this.aZV;
    if (sF()) {}
    for (int i = j;; i = j - 1)
    {
      paramString = new j(paramString, i, this.line, j - k - 1);
      AppMethodBeat.o(74766);
      return paramString;
    }
  }
  
  final boolean sF()
  {
    return this.aZW == -1;
  }
  
  final h sj()
  {
    AppMethodBeat.i(74744);
    switch (this.aZW)
    {
    default: 
      localObject = aV("value");
      AppMethodBeat.o(74744);
      throw ((Throwable)localObject);
    case 110: 
      localObject = sn();
      AppMethodBeat.o(74744);
      return localObject;
    case 116: 
      localObject = so();
      AppMethodBeat.o(74744);
      return localObject;
    case 102: 
      localObject = sp();
      AppMethodBeat.o(74744);
      return localObject;
    case 34: 
      localObject = sq();
      AppMethodBeat.o(74744);
      return localObject;
    case 91: 
      localObject = sk();
      AppMethodBeat.o(74744);
      return localObject;
    case 123: 
      localObject = sl();
      AppMethodBeat.o(74744);
      return localObject;
    }
    Object localObject = st();
    AppMethodBeat.o(74744);
    return localObject;
  }
  
  final void sx()
  {
    AppMethodBeat.i(74760);
    while (sC()) {
      sy();
    }
    AppMethodBeat.o(74760);
  }
  
  final void sy()
  {
    AppMethodBeat.i(74761);
    if (this.index == this.aZU)
    {
      if (this.aZY != -1)
      {
        this.aZX.append(this.aZS, this.aZY, this.aZU - this.aZY);
        this.aZY = 0;
      }
      this.aZT += this.aZU;
      this.aZU = this.aZR.read(this.aZS, 0, this.aZS.length);
      this.index = 0;
      if (this.aZU == -1)
      {
        this.aZW = -1;
        AppMethodBeat.o(74761);
        return;
      }
    }
    if (this.aZW == 10)
    {
      this.line += 1;
      this.aZV = (this.aZT + this.index);
    }
    char[] arrayOfChar = this.aZS;
    int i = this.index;
    this.index = (i + 1);
    this.aZW = arrayOfChar[i];
    AppMethodBeat.o(74761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.a.f
 * JD-Core Version:    0.7.0.1
 */