package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Reader;
import java.io.StringReader;

final class f
{
  private final Reader aOL;
  private final char[] aOM;
  private int aON;
  private int aOO;
  private int aOP;
  private int aOQ;
  private StringBuilder aOR;
  private int aOS;
  private int index;
  private int line;
  
  private f(Reader paramReader, int paramInt)
  {
    AppMethodBeat.i(74743);
    this.aOL = paramReader;
    this.aOM = new char[paramInt];
    this.line = 1;
    this.aOS = -1;
    AppMethodBeat.o(74743);
  }
  
  f(String paramString)
  {
    this(new StringReader(paramString), Math.max(10, Math.min(1024, paramString.length())));
    AppMethodBeat.i(74742);
    AppMethodBeat.o(74742);
  }
  
  private j ab(String paramString)
  {
    AppMethodBeat.i(74765);
    if (qU())
    {
      paramString = ac("Unexpected end of input");
      AppMethodBeat.o(74765);
      return paramString;
    }
    paramString = ac("Expected ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(74765);
    return paramString;
  }
  
  private void b(char paramChar)
  {
    AppMethodBeat.i(74751);
    if (!c(paramChar))
    {
      j localj = ab("'" + paramChar + "'");
      AppMethodBeat.o(74751);
      throw localj;
    }
    AppMethodBeat.o(74751);
  }
  
  private boolean c(char paramChar)
  {
    AppMethodBeat.i(74758);
    if (this.aOQ != paramChar)
    {
      AppMethodBeat.o(74758);
      return false;
    }
    qN();
    AppMethodBeat.o(74758);
    return true;
  }
  
  private e qA()
  {
    AppMethodBeat.i(74746);
    qN();
    Object localObject = new e();
    qM();
    if (c('}'))
    {
      AppMethodBeat.o(74746);
      return localObject;
    }
    do
    {
      qM();
      String str = qB();
      qM();
      if (!c(':'))
      {
        localObject = ab("':'");
        AppMethodBeat.o(74746);
        throw ((Throwable)localObject);
      }
      qM();
      ((e)localObject).a(str, qy());
      qM();
    } while (c(','));
    if (!c('}'))
    {
      localObject = ab("',' or '}'");
      AppMethodBeat.o(74746);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(74746);
    return localObject;
  }
  
  private String qB()
  {
    AppMethodBeat.i(74747);
    if (this.aOQ != 34)
    {
      localObject = ab("name");
      AppMethodBeat.o(74747);
      throw ((Throwable)localObject);
    }
    Object localObject = qG();
    AppMethodBeat.o(74747);
    return localObject;
  }
  
  private h qC()
  {
    AppMethodBeat.i(74748);
    qN();
    b('u');
    b('l');
    b('l');
    h localh = a.aOw;
    AppMethodBeat.o(74748);
    return localh;
  }
  
  private h qD()
  {
    AppMethodBeat.i(74749);
    qN();
    b('r');
    b('u');
    b('e');
    h localh = a.aOx;
    AppMethodBeat.o(74749);
    return localh;
  }
  
  private h qE()
  {
    AppMethodBeat.i(74750);
    qN();
    b('a');
    b('l');
    b('s');
    b('e');
    h localh = a.aOy;
    AppMethodBeat.o(74750);
    return localh;
  }
  
  private h qF()
  {
    AppMethodBeat.i(74752);
    g localg = new g(qG());
    AppMethodBeat.o(74752);
    return localg;
  }
  
  private String qG()
  {
    AppMethodBeat.i(74753);
    qN();
    qO();
    while (this.aOQ != 34) {
      if (this.aOQ == 92)
      {
        qP();
        qH();
        qO();
      }
      else
      {
        if (this.aOQ < 32)
        {
          localObject = ab("valid string character");
          AppMethodBeat.o(74753);
          throw ((Throwable)localObject);
        }
        qN();
      }
    }
    Object localObject = qQ();
    qN();
    AppMethodBeat.o(74753);
    return localObject;
  }
  
  private void qH()
  {
    AppMethodBeat.i(74754);
    qN();
    Object localObject;
    switch (this.aOQ)
    {
    default: 
      localObject = ab("valid escape sequence");
      AppMethodBeat.o(74754);
      throw ((Throwable)localObject);
    case 34: 
    case 47: 
    case 92: 
      this.aOR.append((char)this.aOQ);
    }
    for (;;)
    {
      qN();
      AppMethodBeat.o(74754);
      return;
      this.aOR.append('\b');
      continue;
      this.aOR.append('\f');
      continue;
      this.aOR.append('\n');
      continue;
      this.aOR.append('\r');
      continue;
      this.aOR.append('\t');
      continue;
      localObject = new char[4];
      int i = 0;
      while (i < 4)
      {
        qN();
        if (!qT())
        {
          localObject = ab("hexadecimal digit");
          AppMethodBeat.o(74754);
          throw ((Throwable)localObject);
        }
        localObject[i] = ((char)this.aOQ);
        i += 1;
      }
      this.aOR.append((char)Integer.parseInt(new String((char[])localObject), 16));
    }
  }
  
  private h qI()
  {
    AppMethodBeat.i(74755);
    qO();
    c('-');
    int i = this.aOQ;
    if (!qL())
    {
      localObject = ab("digit");
      AppMethodBeat.o(74755);
      throw ((Throwable)localObject);
    }
    while ((i != 48) && (qL())) {}
    qJ();
    qK();
    Object localObject = new d(qQ());
    AppMethodBeat.o(74755);
    return localObject;
  }
  
  private boolean qJ()
  {
    AppMethodBeat.i(74756);
    if (!c('.'))
    {
      AppMethodBeat.o(74756);
      return false;
    }
    if (!qL())
    {
      j localj = ab("digit");
      AppMethodBeat.o(74756);
      throw localj;
    }
    while (qL()) {}
    AppMethodBeat.o(74756);
    return true;
  }
  
  private boolean qK()
  {
    AppMethodBeat.i(74757);
    if ((!c('e')) && (!c('E')))
    {
      AppMethodBeat.o(74757);
      return false;
    }
    if (!c('+')) {
      c('-');
    }
    if (!qL())
    {
      j localj = ab("digit");
      AppMethodBeat.o(74757);
      throw localj;
    }
    while (qL()) {}
    AppMethodBeat.o(74757);
    return true;
  }
  
  private boolean qL()
  {
    AppMethodBeat.i(74759);
    if (!qS())
    {
      AppMethodBeat.o(74759);
      return false;
    }
    qN();
    AppMethodBeat.o(74759);
    return true;
  }
  
  private void qO()
  {
    AppMethodBeat.i(74762);
    if (this.aOR == null) {
      this.aOR = new StringBuilder();
    }
    this.aOS = (this.index - 1);
    AppMethodBeat.o(74762);
  }
  
  private void qP()
  {
    AppMethodBeat.i(74763);
    if (this.aOQ == -1) {}
    for (int i = this.index;; i = this.index - 1)
    {
      StringBuilder localStringBuilder = this.aOR;
      char[] arrayOfChar = this.aOM;
      int j = this.aOS;
      localStringBuilder.append(arrayOfChar, j, i - j);
      this.aOS = -1;
      AppMethodBeat.o(74763);
      return;
    }
  }
  
  private String qQ()
  {
    AppMethodBeat.i(74764);
    int i;
    Object localObject;
    if (this.aOQ == -1)
    {
      i = this.index;
      if (this.aOR.length() <= 0) {
        break label93;
      }
      localObject = this.aOR;
      char[] arrayOfChar = this.aOM;
      int j = this.aOS;
      ((StringBuilder)localObject).append(arrayOfChar, j, i - j);
      localObject = this.aOR.toString();
      this.aOR.setLength(0);
    }
    for (;;)
    {
      this.aOS = -1;
      AppMethodBeat.o(74764);
      return localObject;
      i = this.index - 1;
      break;
      label93:
      localObject = new String(this.aOM, this.aOS, i - this.aOS);
    }
  }
  
  private boolean qR()
  {
    return (this.aOQ == 32) || (this.aOQ == 9) || (this.aOQ == 10) || (this.aOQ == 13);
  }
  
  private boolean qS()
  {
    return (this.aOQ >= 48) && (this.aOQ <= 57);
  }
  
  private boolean qT()
  {
    return ((this.aOQ >= 48) && (this.aOQ <= 57)) || ((this.aOQ >= 97) && (this.aOQ <= 102)) || ((this.aOQ >= 65) && (this.aOQ <= 70));
  }
  
  private b qz()
  {
    AppMethodBeat.i(74745);
    qN();
    Object localObject = new b();
    qM();
    if (c(']'))
    {
      AppMethodBeat.o(74745);
      return localObject;
    }
    do
    {
      qM();
      ((b)localObject).a(qy());
      qM();
    } while (c(','));
    if (!c(']'))
    {
      localObject = ab("',' or ']'");
      AppMethodBeat.o(74745);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(74745);
    return localObject;
  }
  
  final j ac(String paramString)
  {
    AppMethodBeat.i(74766);
    int j = this.aON + this.index;
    int k = this.aOP;
    if (qU()) {}
    for (int i = j;; i = j - 1)
    {
      paramString = new j(paramString, i, this.line, j - k - 1);
      AppMethodBeat.o(74766);
      return paramString;
    }
  }
  
  final void qM()
  {
    AppMethodBeat.i(74760);
    while (qR()) {
      qN();
    }
    AppMethodBeat.o(74760);
  }
  
  final void qN()
  {
    AppMethodBeat.i(74761);
    if (this.index == this.aOO)
    {
      if (this.aOS != -1)
      {
        this.aOR.append(this.aOM, this.aOS, this.aOO - this.aOS);
        this.aOS = 0;
      }
      this.aON += this.aOO;
      this.aOO = this.aOL.read(this.aOM, 0, this.aOM.length);
      this.index = 0;
      if (this.aOO == -1)
      {
        this.aOQ = -1;
        AppMethodBeat.o(74761);
        return;
      }
    }
    if (this.aOQ == 10)
    {
      this.line += 1;
      this.aOP = (this.aON + this.index);
    }
    char[] arrayOfChar = this.aOM;
    int i = this.index;
    this.index = (i + 1);
    this.aOQ = arrayOfChar[i];
    AppMethodBeat.o(74761);
  }
  
  final boolean qU()
  {
    return this.aOQ == -1;
  }
  
  final h qy()
  {
    AppMethodBeat.i(74744);
    switch (this.aOQ)
    {
    default: 
      localObject = ab("value");
      AppMethodBeat.o(74744);
      throw ((Throwable)localObject);
    case 110: 
      localObject = qC();
      AppMethodBeat.o(74744);
      return localObject;
    case 116: 
      localObject = qD();
      AppMethodBeat.o(74744);
      return localObject;
    case 102: 
      localObject = qE();
      AppMethodBeat.o(74744);
      return localObject;
    case 34: 
      localObject = qF();
      AppMethodBeat.o(74744);
      return localObject;
    case 91: 
      localObject = qz();
      AppMethodBeat.o(74744);
      return localObject;
    case 123: 
      localObject = qA();
      AppMethodBeat.o(74744);
      return localObject;
    }
    Object localObject = qI();
    AppMethodBeat.o(74744);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.a.f
 * JD-Core Version:    0.7.0.1
 */