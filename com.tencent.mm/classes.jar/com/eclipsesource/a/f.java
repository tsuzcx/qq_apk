package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Reader;
import java.io.StringReader;

final class f
{
  private final Reader aPB;
  private final char[] aPC;
  private int aPD;
  private int aPE;
  private int aPF;
  private int aPG;
  private StringBuilder aPH;
  private int aPI;
  private int index;
  private int line;
  
  private f(Reader paramReader, int paramInt)
  {
    AppMethodBeat.i(74743);
    this.aPB = paramReader;
    this.aPC = new char[paramInt];
    this.line = 1;
    this.aPI = -1;
    AppMethodBeat.o(74743);
  }
  
  f(String paramString)
  {
    this(new StringReader(paramString), Math.max(10, Math.min(1024, paramString.length())));
    AppMethodBeat.i(74742);
    AppMethodBeat.o(74742);
  }
  
  private j ac(String paramString)
  {
    AppMethodBeat.i(74765);
    if (re())
    {
      paramString = ad("Unexpected end of input");
      AppMethodBeat.o(74765);
      return paramString;
    }
    paramString = ad("Expected ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(74765);
    return paramString;
  }
  
  private void b(char paramChar)
  {
    AppMethodBeat.i(74751);
    if (!c(paramChar))
    {
      j localj = ac("'" + paramChar + "'");
      AppMethodBeat.o(74751);
      throw localj;
    }
    AppMethodBeat.o(74751);
  }
  
  private boolean c(char paramChar)
  {
    AppMethodBeat.i(74758);
    if (this.aPG != paramChar)
    {
      AppMethodBeat.o(74758);
      return false;
    }
    qX();
    AppMethodBeat.o(74758);
    return true;
  }
  
  private b qJ()
  {
    AppMethodBeat.i(74745);
    qX();
    Object localObject = new b();
    qW();
    if (c(']'))
    {
      AppMethodBeat.o(74745);
      return localObject;
    }
    do
    {
      qW();
      ((b)localObject).a(qI());
      qW();
    } while (c(','));
    if (!c(']'))
    {
      localObject = ac("',' or ']'");
      AppMethodBeat.o(74745);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(74745);
    return localObject;
  }
  
  private e qK()
  {
    AppMethodBeat.i(74746);
    qX();
    Object localObject = new e();
    qW();
    if (c('}'))
    {
      AppMethodBeat.o(74746);
      return localObject;
    }
    do
    {
      qW();
      String str = qL();
      qW();
      if (!c(':'))
      {
        localObject = ac("':'");
        AppMethodBeat.o(74746);
        throw ((Throwable)localObject);
      }
      qW();
      ((e)localObject).a(str, qI());
      qW();
    } while (c(','));
    if (!c('}'))
    {
      localObject = ac("',' or '}'");
      AppMethodBeat.o(74746);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(74746);
    return localObject;
  }
  
  private String qL()
  {
    AppMethodBeat.i(74747);
    if (this.aPG != 34)
    {
      localObject = ac("name");
      AppMethodBeat.o(74747);
      throw ((Throwable)localObject);
    }
    Object localObject = qQ();
    AppMethodBeat.o(74747);
    return localObject;
  }
  
  private h qM()
  {
    AppMethodBeat.i(74748);
    qX();
    b('u');
    b('l');
    b('l');
    h localh = a.aPm;
    AppMethodBeat.o(74748);
    return localh;
  }
  
  private h qN()
  {
    AppMethodBeat.i(74749);
    qX();
    b('r');
    b('u');
    b('e');
    h localh = a.aPn;
    AppMethodBeat.o(74749);
    return localh;
  }
  
  private h qO()
  {
    AppMethodBeat.i(74750);
    qX();
    b('a');
    b('l');
    b('s');
    b('e');
    h localh = a.aPo;
    AppMethodBeat.o(74750);
    return localh;
  }
  
  private h qP()
  {
    AppMethodBeat.i(74752);
    g localg = new g(qQ());
    AppMethodBeat.o(74752);
    return localg;
  }
  
  private String qQ()
  {
    AppMethodBeat.i(74753);
    qX();
    qY();
    while (this.aPG != 34) {
      if (this.aPG == 92)
      {
        qZ();
        qR();
        qY();
      }
      else
      {
        if (this.aPG < 32)
        {
          localObject = ac("valid string character");
          AppMethodBeat.o(74753);
          throw ((Throwable)localObject);
        }
        qX();
      }
    }
    Object localObject = ra();
    qX();
    AppMethodBeat.o(74753);
    return localObject;
  }
  
  private void qR()
  {
    AppMethodBeat.i(74754);
    qX();
    Object localObject;
    switch (this.aPG)
    {
    default: 
      localObject = ac("valid escape sequence");
      AppMethodBeat.o(74754);
      throw ((Throwable)localObject);
    case 34: 
    case 47: 
    case 92: 
      this.aPH.append((char)this.aPG);
    }
    for (;;)
    {
      qX();
      AppMethodBeat.o(74754);
      return;
      this.aPH.append('\b');
      continue;
      this.aPH.append('\f');
      continue;
      this.aPH.append('\n');
      continue;
      this.aPH.append('\r');
      continue;
      this.aPH.append('\t');
      continue;
      localObject = new char[4];
      int i = 0;
      while (i < 4)
      {
        qX();
        if (!rd())
        {
          localObject = ac("hexadecimal digit");
          AppMethodBeat.o(74754);
          throw ((Throwable)localObject);
        }
        localObject[i] = ((char)this.aPG);
        i += 1;
      }
      this.aPH.append((char)Integer.parseInt(new String((char[])localObject), 16));
    }
  }
  
  private h qS()
  {
    AppMethodBeat.i(74755);
    qY();
    c('-');
    int i = this.aPG;
    if (!qV())
    {
      localObject = ac("digit");
      AppMethodBeat.o(74755);
      throw ((Throwable)localObject);
    }
    while ((i != 48) && (qV())) {}
    qT();
    qU();
    Object localObject = new d(ra());
    AppMethodBeat.o(74755);
    return localObject;
  }
  
  private boolean qT()
  {
    AppMethodBeat.i(74756);
    if (!c('.'))
    {
      AppMethodBeat.o(74756);
      return false;
    }
    if (!qV())
    {
      j localj = ac("digit");
      AppMethodBeat.o(74756);
      throw localj;
    }
    while (qV()) {}
    AppMethodBeat.o(74756);
    return true;
  }
  
  private boolean qU()
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
    if (!qV())
    {
      j localj = ac("digit");
      AppMethodBeat.o(74757);
      throw localj;
    }
    while (qV()) {}
    AppMethodBeat.o(74757);
    return true;
  }
  
  private boolean qV()
  {
    AppMethodBeat.i(74759);
    if (!rc())
    {
      AppMethodBeat.o(74759);
      return false;
    }
    qX();
    AppMethodBeat.o(74759);
    return true;
  }
  
  private void qY()
  {
    AppMethodBeat.i(74762);
    if (this.aPH == null) {
      this.aPH = new StringBuilder();
    }
    this.aPI = (this.index - 1);
    AppMethodBeat.o(74762);
  }
  
  private void qZ()
  {
    AppMethodBeat.i(74763);
    if (this.aPG == -1) {}
    for (int i = this.index;; i = this.index - 1)
    {
      StringBuilder localStringBuilder = this.aPH;
      char[] arrayOfChar = this.aPC;
      int j = this.aPI;
      localStringBuilder.append(arrayOfChar, j, i - j);
      this.aPI = -1;
      AppMethodBeat.o(74763);
      return;
    }
  }
  
  private String ra()
  {
    AppMethodBeat.i(74764);
    int i;
    Object localObject;
    if (this.aPG == -1)
    {
      i = this.index;
      if (this.aPH.length() <= 0) {
        break label93;
      }
      localObject = this.aPH;
      char[] arrayOfChar = this.aPC;
      int j = this.aPI;
      ((StringBuilder)localObject).append(arrayOfChar, j, i - j);
      localObject = this.aPH.toString();
      this.aPH.setLength(0);
    }
    for (;;)
    {
      this.aPI = -1;
      AppMethodBeat.o(74764);
      return localObject;
      i = this.index - 1;
      break;
      label93:
      localObject = new String(this.aPC, this.aPI, i - this.aPI);
    }
  }
  
  private boolean rb()
  {
    return (this.aPG == 32) || (this.aPG == 9) || (this.aPG == 10) || (this.aPG == 13);
  }
  
  private boolean rc()
  {
    return (this.aPG >= 48) && (this.aPG <= 57);
  }
  
  private boolean rd()
  {
    return ((this.aPG >= 48) && (this.aPG <= 57)) || ((this.aPG >= 97) && (this.aPG <= 102)) || ((this.aPG >= 65) && (this.aPG <= 70));
  }
  
  final j ad(String paramString)
  {
    AppMethodBeat.i(74766);
    int j = this.aPD + this.index;
    int k = this.aPF;
    if (re()) {}
    for (int i = j;; i = j - 1)
    {
      paramString = new j(paramString, i, this.line, j - k - 1);
      AppMethodBeat.o(74766);
      return paramString;
    }
  }
  
  final h qI()
  {
    AppMethodBeat.i(74744);
    switch (this.aPG)
    {
    default: 
      localObject = ac("value");
      AppMethodBeat.o(74744);
      throw ((Throwable)localObject);
    case 110: 
      localObject = qM();
      AppMethodBeat.o(74744);
      return localObject;
    case 116: 
      localObject = qN();
      AppMethodBeat.o(74744);
      return localObject;
    case 102: 
      localObject = qO();
      AppMethodBeat.o(74744);
      return localObject;
    case 34: 
      localObject = qP();
      AppMethodBeat.o(74744);
      return localObject;
    case 91: 
      localObject = qJ();
      AppMethodBeat.o(74744);
      return localObject;
    case 123: 
      localObject = qK();
      AppMethodBeat.o(74744);
      return localObject;
    }
    Object localObject = qS();
    AppMethodBeat.o(74744);
    return localObject;
  }
  
  final void qW()
  {
    AppMethodBeat.i(74760);
    while (rb()) {
      qX();
    }
    AppMethodBeat.o(74760);
  }
  
  final void qX()
  {
    AppMethodBeat.i(74761);
    if (this.index == this.aPE)
    {
      if (this.aPI != -1)
      {
        this.aPH.append(this.aPC, this.aPI, this.aPE - this.aPI);
        this.aPI = 0;
      }
      this.aPD += this.aPE;
      this.aPE = this.aPB.read(this.aPC, 0, this.aPC.length);
      this.index = 0;
      if (this.aPE == -1)
      {
        this.aPG = -1;
        AppMethodBeat.o(74761);
        return;
      }
    }
    if (this.aPG == 10)
    {
      this.line += 1;
      this.aPF = (this.aPD + this.index);
    }
    char[] arrayOfChar = this.aPC;
    int i = this.index;
    this.index = (i + 1);
    this.aPG = arrayOfChar[i];
    AppMethodBeat.o(74761);
  }
  
  final boolean re()
  {
    return this.aPG == -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.a.f
 * JD-Core Version:    0.7.0.1
 */