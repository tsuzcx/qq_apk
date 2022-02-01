package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Reader;
import java.io.StringReader;

final class f
{
  private final Reader aJo;
  private final char[] aJp;
  private int aJq;
  private int aJr;
  private int aJs;
  private StringBuilder aJt;
  private int aJu;
  private int fill;
  private int index;
  private int line;
  
  private f(Reader paramReader, int paramInt)
  {
    AppMethodBeat.i(74743);
    this.aJo = paramReader;
    this.aJp = new char[paramInt];
    this.line = 1;
    this.aJu = -1;
    AppMethodBeat.o(74743);
  }
  
  f(String paramString)
  {
    this(new StringReader(paramString), Math.max(10, Math.min(1024, paramString.length())));
    AppMethodBeat.i(74742);
    AppMethodBeat.o(74742);
  }
  
  private j bg(String paramString)
  {
    AppMethodBeat.i(74765);
    if (qt())
    {
      paramString = bh("Unexpected end of input");
      AppMethodBeat.o(74765);
      return paramString;
    }
    paramString = bh("Expected ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(74765);
    return paramString;
  }
  
  private void d(char paramChar)
  {
    AppMethodBeat.i(74751);
    if (!e(paramChar))
    {
      j localj = bg("'" + paramChar + "'");
      AppMethodBeat.o(74751);
      throw localj;
    }
    AppMethodBeat.o(74751);
  }
  
  private boolean e(char paramChar)
  {
    AppMethodBeat.i(74758);
    if (this.aJs != paramChar)
    {
      AppMethodBeat.o(74758);
      return false;
    }
    qm();
    AppMethodBeat.o(74758);
    return true;
  }
  
  private b pY()
  {
    AppMethodBeat.i(74745);
    qm();
    Object localObject = new b();
    ql();
    if (e(']'))
    {
      AppMethodBeat.o(74745);
      return localObject;
    }
    do
    {
      ql();
      ((b)localObject).a(pX());
      ql();
    } while (e(','));
    if (!e(']'))
    {
      localObject = bg("',' or ']'");
      AppMethodBeat.o(74745);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(74745);
    return localObject;
  }
  
  private e pZ()
  {
    AppMethodBeat.i(74746);
    qm();
    Object localObject = new e();
    ql();
    if (e('}'))
    {
      AppMethodBeat.o(74746);
      return localObject;
    }
    do
    {
      ql();
      String str = qa();
      ql();
      if (!e(':'))
      {
        localObject = bg("':'");
        AppMethodBeat.o(74746);
        throw ((Throwable)localObject);
      }
      ql();
      ((e)localObject).a(str, pX());
      ql();
    } while (e(','));
    if (!e('}'))
    {
      localObject = bg("',' or '}'");
      AppMethodBeat.o(74746);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(74746);
    return localObject;
  }
  
  private String qa()
  {
    AppMethodBeat.i(74747);
    if (this.aJs != 34)
    {
      localObject = bg("name");
      AppMethodBeat.o(74747);
      throw ((Throwable)localObject);
    }
    Object localObject = qf();
    AppMethodBeat.o(74747);
    return localObject;
  }
  
  private h qb()
  {
    AppMethodBeat.i(74748);
    qm();
    d('u');
    d('l');
    d('l');
    h localh = a.aIY;
    AppMethodBeat.o(74748);
    return localh;
  }
  
  private h qc()
  {
    AppMethodBeat.i(74749);
    qm();
    d('r');
    d('u');
    d('e');
    h localh = a.aIZ;
    AppMethodBeat.o(74749);
    return localh;
  }
  
  private h qd()
  {
    AppMethodBeat.i(74750);
    qm();
    d('a');
    d('l');
    d('s');
    d('e');
    h localh = a.aJa;
    AppMethodBeat.o(74750);
    return localh;
  }
  
  private h qe()
  {
    AppMethodBeat.i(74752);
    g localg = new g(qf());
    AppMethodBeat.o(74752);
    return localg;
  }
  
  private String qf()
  {
    AppMethodBeat.i(74753);
    qm();
    qn();
    while (this.aJs != 34) {
      if (this.aJs == 92)
      {
        qo();
        qg();
        qn();
      }
      else
      {
        if (this.aJs < 32)
        {
          localObject = bg("valid string character");
          AppMethodBeat.o(74753);
          throw ((Throwable)localObject);
        }
        qm();
      }
    }
    Object localObject = qp();
    qm();
    AppMethodBeat.o(74753);
    return localObject;
  }
  
  private void qg()
  {
    AppMethodBeat.i(74754);
    qm();
    Object localObject;
    switch (this.aJs)
    {
    default: 
      localObject = bg("valid escape sequence");
      AppMethodBeat.o(74754);
      throw ((Throwable)localObject);
    case 34: 
    case 47: 
    case 92: 
      this.aJt.append((char)this.aJs);
    }
    for (;;)
    {
      qm();
      AppMethodBeat.o(74754);
      return;
      this.aJt.append('\b');
      continue;
      this.aJt.append('\f');
      continue;
      this.aJt.append('\n');
      continue;
      this.aJt.append('\r');
      continue;
      this.aJt.append('\t');
      continue;
      localObject = new char[4];
      int i = 0;
      while (i < 4)
      {
        qm();
        if (!qs())
        {
          localObject = bg("hexadecimal digit");
          AppMethodBeat.o(74754);
          throw ((Throwable)localObject);
        }
        localObject[i] = ((char)this.aJs);
        i += 1;
      }
      this.aJt.append((char)Integer.parseInt(new String((char[])localObject), 16));
    }
  }
  
  private h qh()
  {
    AppMethodBeat.i(74755);
    qn();
    e('-');
    int i = this.aJs;
    if (!qk())
    {
      localObject = bg("digit");
      AppMethodBeat.o(74755);
      throw ((Throwable)localObject);
    }
    while ((i != 48) && (qk())) {}
    qi();
    qj();
    Object localObject = new d(qp());
    AppMethodBeat.o(74755);
    return localObject;
  }
  
  private boolean qi()
  {
    AppMethodBeat.i(74756);
    if (!e('.'))
    {
      AppMethodBeat.o(74756);
      return false;
    }
    if (!qk())
    {
      j localj = bg("digit");
      AppMethodBeat.o(74756);
      throw localj;
    }
    while (qk()) {}
    AppMethodBeat.o(74756);
    return true;
  }
  
  private boolean qj()
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
    if (!qk())
    {
      j localj = bg("digit");
      AppMethodBeat.o(74757);
      throw localj;
    }
    while (qk()) {}
    AppMethodBeat.o(74757);
    return true;
  }
  
  private boolean qk()
  {
    AppMethodBeat.i(74759);
    if (!qr())
    {
      AppMethodBeat.o(74759);
      return false;
    }
    qm();
    AppMethodBeat.o(74759);
    return true;
  }
  
  private void qn()
  {
    AppMethodBeat.i(74762);
    if (this.aJt == null) {
      this.aJt = new StringBuilder();
    }
    this.aJu = (this.index - 1);
    AppMethodBeat.o(74762);
  }
  
  private void qo()
  {
    AppMethodBeat.i(74763);
    if (this.aJs == -1) {}
    for (int i = this.index;; i = this.index - 1)
    {
      StringBuilder localStringBuilder = this.aJt;
      char[] arrayOfChar = this.aJp;
      int j = this.aJu;
      localStringBuilder.append(arrayOfChar, j, i - j);
      this.aJu = -1;
      AppMethodBeat.o(74763);
      return;
    }
  }
  
  private String qp()
  {
    AppMethodBeat.i(74764);
    int i;
    Object localObject;
    if (this.aJs == -1)
    {
      i = this.index;
      if (this.aJt.length() <= 0) {
        break label93;
      }
      localObject = this.aJt;
      char[] arrayOfChar = this.aJp;
      int j = this.aJu;
      ((StringBuilder)localObject).append(arrayOfChar, j, i - j);
      localObject = this.aJt.toString();
      this.aJt.setLength(0);
    }
    for (;;)
    {
      this.aJu = -1;
      AppMethodBeat.o(74764);
      return localObject;
      i = this.index - 1;
      break;
      label93:
      localObject = new String(this.aJp, this.aJu, i - this.aJu);
    }
  }
  
  private boolean qq()
  {
    return (this.aJs == 32) || (this.aJs == 9) || (this.aJs == 10) || (this.aJs == 13);
  }
  
  private boolean qr()
  {
    return (this.aJs >= 48) && (this.aJs <= 57);
  }
  
  private boolean qs()
  {
    return ((this.aJs >= 48) && (this.aJs <= 57)) || ((this.aJs >= 97) && (this.aJs <= 102)) || ((this.aJs >= 65) && (this.aJs <= 70));
  }
  
  final j bh(String paramString)
  {
    AppMethodBeat.i(74766);
    int j = this.aJq + this.index;
    int k = this.aJr;
    if (qt()) {}
    for (int i = j;; i = j - 1)
    {
      paramString = new j(paramString, i, this.line, j - k - 1);
      AppMethodBeat.o(74766);
      return paramString;
    }
  }
  
  final h pX()
  {
    AppMethodBeat.i(74744);
    switch (this.aJs)
    {
    default: 
      localObject = bg("value");
      AppMethodBeat.o(74744);
      throw ((Throwable)localObject);
    case 110: 
      localObject = qb();
      AppMethodBeat.o(74744);
      return localObject;
    case 116: 
      localObject = qc();
      AppMethodBeat.o(74744);
      return localObject;
    case 102: 
      localObject = qd();
      AppMethodBeat.o(74744);
      return localObject;
    case 34: 
      localObject = qe();
      AppMethodBeat.o(74744);
      return localObject;
    case 91: 
      localObject = pY();
      AppMethodBeat.o(74744);
      return localObject;
    case 123: 
      localObject = pZ();
      AppMethodBeat.o(74744);
      return localObject;
    }
    Object localObject = qh();
    AppMethodBeat.o(74744);
    return localObject;
  }
  
  final void ql()
  {
    AppMethodBeat.i(74760);
    while (qq()) {
      qm();
    }
    AppMethodBeat.o(74760);
  }
  
  final void qm()
  {
    AppMethodBeat.i(74761);
    if (this.index == this.fill)
    {
      if (this.aJu != -1)
      {
        this.aJt.append(this.aJp, this.aJu, this.fill - this.aJu);
        this.aJu = 0;
      }
      this.aJq += this.fill;
      this.fill = this.aJo.read(this.aJp, 0, this.aJp.length);
      this.index = 0;
      if (this.fill == -1)
      {
        this.aJs = -1;
        AppMethodBeat.o(74761);
        return;
      }
    }
    if (this.aJs == 10)
    {
      this.line += 1;
      this.aJr = (this.aJq + this.index);
    }
    char[] arrayOfChar = this.aJp;
    int i = this.index;
    this.index = (i + 1);
    this.aJs = arrayOfChar[i];
    AppMethodBeat.o(74761);
  }
  
  final boolean qt()
  {
    return this.aJs == -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.eclipsesource.a.f
 * JD-Core Version:    0.7.0.1
 */