package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Reader;
import java.io.StringReader;

final class f
{
  private int apW;
  private final Reader cBZ;
  private final char[] cCa;
  private int cCb;
  private int cCc;
  private StringBuilder cCd;
  private int cCe;
  private int fill;
  private int index;
  private int line;
  
  private f(Reader paramReader, int paramInt)
  {
    AppMethodBeat.i(74743);
    this.cBZ = paramReader;
    this.cCa = new char[paramInt];
    this.line = 1;
    this.cCe = -1;
    AppMethodBeat.o(74743);
  }
  
  f(String paramString)
  {
    this(new StringReader(paramString), Math.max(10, Math.min(1024, paramString.length())));
    AppMethodBeat.i(74742);
    AppMethodBeat.o(74742);
  }
  
  private String PA()
  {
    AppMethodBeat.i(74764);
    int i;
    Object localObject;
    if (this.apW == -1)
    {
      i = this.index;
      if (this.cCd.length() <= 0) {
        break label93;
      }
      localObject = this.cCd;
      char[] arrayOfChar = this.cCa;
      int j = this.cCe;
      ((StringBuilder)localObject).append(arrayOfChar, j, i - j);
      localObject = this.cCd.toString();
      this.cCd.setLength(0);
    }
    for (;;)
    {
      this.cCe = -1;
      AppMethodBeat.o(74764);
      return localObject;
      i = this.index - 1;
      break;
      label93:
      localObject = new String(this.cCa, this.cCe, i - this.cCe);
    }
  }
  
  private boolean PB()
  {
    return (this.apW == 32) || (this.apW == 9) || (this.apW == 10) || (this.apW == 13);
  }
  
  private boolean PC()
  {
    return (this.apW >= 48) && (this.apW <= 57);
  }
  
  private boolean PD()
  {
    return ((this.apW >= 48) && (this.apW <= 57)) || ((this.apW >= 97) && (this.apW <= 102)) || ((this.apW >= 65) && (this.apW <= 70));
  }
  
  private b Pj()
  {
    AppMethodBeat.i(74745);
    Px();
    Object localObject = new b();
    Pw();
    if (f(']'))
    {
      AppMethodBeat.o(74745);
      return localObject;
    }
    do
    {
      Pw();
      ((b)localObject).a(Pi());
      Pw();
    } while (f(','));
    if (!f(']'))
    {
      localObject = ct("',' or ']'");
      AppMethodBeat.o(74745);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(74745);
    return localObject;
  }
  
  private e Pk()
  {
    AppMethodBeat.i(74746);
    Px();
    Object localObject = new e();
    Pw();
    if (f('}'))
    {
      AppMethodBeat.o(74746);
      return localObject;
    }
    do
    {
      Pw();
      String str = Pl();
      Pw();
      if (!f(':'))
      {
        localObject = ct("':'");
        AppMethodBeat.o(74746);
        throw ((Throwable)localObject);
      }
      Pw();
      ((e)localObject).a(str, Pi());
      Pw();
    } while (f(','));
    if (!f('}'))
    {
      localObject = ct("',' or '}'");
      AppMethodBeat.o(74746);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(74746);
    return localObject;
  }
  
  private String Pl()
  {
    AppMethodBeat.i(74747);
    if (this.apW != 34)
    {
      localObject = ct("name");
      AppMethodBeat.o(74747);
      throw ((Throwable)localObject);
    }
    Object localObject = Pq();
    AppMethodBeat.o(74747);
    return localObject;
  }
  
  private h Pm()
  {
    AppMethodBeat.i(74748);
    Px();
    e('u');
    e('l');
    e('l');
    h localh = a.cBJ;
    AppMethodBeat.o(74748);
    return localh;
  }
  
  private h Pn()
  {
    AppMethodBeat.i(74749);
    Px();
    e('r');
    e('u');
    e('e');
    h localh = a.cBK;
    AppMethodBeat.o(74749);
    return localh;
  }
  
  private h Po()
  {
    AppMethodBeat.i(74750);
    Px();
    e('a');
    e('l');
    e('s');
    e('e');
    h localh = a.cBL;
    AppMethodBeat.o(74750);
    return localh;
  }
  
  private h Pp()
  {
    AppMethodBeat.i(74752);
    g localg = new g(Pq());
    AppMethodBeat.o(74752);
    return localg;
  }
  
  private String Pq()
  {
    AppMethodBeat.i(74753);
    Px();
    Py();
    while (this.apW != 34) {
      if (this.apW == 92)
      {
        Pz();
        Pr();
        Py();
      }
      else
      {
        if (this.apW < 32)
        {
          localObject = ct("valid string character");
          AppMethodBeat.o(74753);
          throw ((Throwable)localObject);
        }
        Px();
      }
    }
    Object localObject = PA();
    Px();
    AppMethodBeat.o(74753);
    return localObject;
  }
  
  private void Pr()
  {
    AppMethodBeat.i(74754);
    Px();
    Object localObject;
    switch (this.apW)
    {
    default: 
      localObject = ct("valid escape sequence");
      AppMethodBeat.o(74754);
      throw ((Throwable)localObject);
    case 34: 
    case 47: 
    case 92: 
      this.cCd.append((char)this.apW);
    }
    for (;;)
    {
      Px();
      AppMethodBeat.o(74754);
      return;
      this.cCd.append('\b');
      continue;
      this.cCd.append('\f');
      continue;
      this.cCd.append('\n');
      continue;
      this.cCd.append('\r');
      continue;
      this.cCd.append('\t');
      continue;
      localObject = new char[4];
      int i = 0;
      while (i < 4)
      {
        Px();
        if (!PD())
        {
          localObject = ct("hexadecimal digit");
          AppMethodBeat.o(74754);
          throw ((Throwable)localObject);
        }
        localObject[i] = ((char)this.apW);
        i += 1;
      }
      this.cCd.append((char)Integer.parseInt(new String((char[])localObject), 16));
    }
  }
  
  private h Ps()
  {
    AppMethodBeat.i(74755);
    Py();
    f('-');
    int i = this.apW;
    if (!Pv())
    {
      localObject = ct("digit");
      AppMethodBeat.o(74755);
      throw ((Throwable)localObject);
    }
    while ((i != 48) && (Pv())) {}
    Pt();
    Pu();
    Object localObject = new d(PA());
    AppMethodBeat.o(74755);
    return localObject;
  }
  
  private boolean Pt()
  {
    AppMethodBeat.i(74756);
    if (!f('.'))
    {
      AppMethodBeat.o(74756);
      return false;
    }
    if (!Pv())
    {
      j localj = ct("digit");
      AppMethodBeat.o(74756);
      throw localj;
    }
    while (Pv()) {}
    AppMethodBeat.o(74756);
    return true;
  }
  
  private boolean Pu()
  {
    AppMethodBeat.i(74757);
    if ((!f('e')) && (!f('E')))
    {
      AppMethodBeat.o(74757);
      return false;
    }
    if (!f('+')) {
      f('-');
    }
    if (!Pv())
    {
      j localj = ct("digit");
      AppMethodBeat.o(74757);
      throw localj;
    }
    while (Pv()) {}
    AppMethodBeat.o(74757);
    return true;
  }
  
  private boolean Pv()
  {
    AppMethodBeat.i(74759);
    if (!PC())
    {
      AppMethodBeat.o(74759);
      return false;
    }
    Px();
    AppMethodBeat.o(74759);
    return true;
  }
  
  private void Py()
  {
    AppMethodBeat.i(74762);
    if (this.cCd == null) {
      this.cCd = new StringBuilder();
    }
    this.cCe = (this.index - 1);
    AppMethodBeat.o(74762);
  }
  
  private void Pz()
  {
    AppMethodBeat.i(74763);
    if (this.apW == -1) {}
    for (int i = this.index;; i = this.index - 1)
    {
      StringBuilder localStringBuilder = this.cCd;
      char[] arrayOfChar = this.cCa;
      int j = this.cCe;
      localStringBuilder.append(arrayOfChar, j, i - j);
      this.cCe = -1;
      AppMethodBeat.o(74763);
      return;
    }
  }
  
  private j ct(String paramString)
  {
    AppMethodBeat.i(74765);
    if (PE())
    {
      paramString = cu("Unexpected end of input");
      AppMethodBeat.o(74765);
      return paramString;
    }
    paramString = cu("Expected ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(74765);
    return paramString;
  }
  
  private void e(char paramChar)
  {
    AppMethodBeat.i(74751);
    if (!f(paramChar))
    {
      j localj = ct("'" + paramChar + "'");
      AppMethodBeat.o(74751);
      throw localj;
    }
    AppMethodBeat.o(74751);
  }
  
  private boolean f(char paramChar)
  {
    AppMethodBeat.i(74758);
    if (this.apW != paramChar)
    {
      AppMethodBeat.o(74758);
      return false;
    }
    Px();
    AppMethodBeat.o(74758);
    return true;
  }
  
  final boolean PE()
  {
    return this.apW == -1;
  }
  
  final h Pi()
  {
    AppMethodBeat.i(74744);
    switch (this.apW)
    {
    default: 
      localObject = ct("value");
      AppMethodBeat.o(74744);
      throw ((Throwable)localObject);
    case 110: 
      localObject = Pm();
      AppMethodBeat.o(74744);
      return localObject;
    case 116: 
      localObject = Pn();
      AppMethodBeat.o(74744);
      return localObject;
    case 102: 
      localObject = Po();
      AppMethodBeat.o(74744);
      return localObject;
    case 34: 
      localObject = Pp();
      AppMethodBeat.o(74744);
      return localObject;
    case 91: 
      localObject = Pj();
      AppMethodBeat.o(74744);
      return localObject;
    case 123: 
      localObject = Pk();
      AppMethodBeat.o(74744);
      return localObject;
    }
    Object localObject = Ps();
    AppMethodBeat.o(74744);
    return localObject;
  }
  
  final void Pw()
  {
    AppMethodBeat.i(74760);
    while (PB()) {
      Px();
    }
    AppMethodBeat.o(74760);
  }
  
  final void Px()
  {
    AppMethodBeat.i(74761);
    if (this.index == this.fill)
    {
      if (this.cCe != -1)
      {
        this.cCd.append(this.cCa, this.cCe, this.fill - this.cCe);
        this.cCe = 0;
      }
      this.cCb += this.fill;
      this.fill = this.cBZ.read(this.cCa, 0, this.cCa.length);
      this.index = 0;
      if (this.fill == -1)
      {
        this.apW = -1;
        AppMethodBeat.o(74761);
        return;
      }
    }
    if (this.apW == 10)
    {
      this.line += 1;
      this.cCc = (this.cCb + this.index);
    }
    char[] arrayOfChar = this.cCa;
    int i = this.index;
    this.index = (i + 1);
    this.apW = arrayOfChar[i];
    AppMethodBeat.o(74761);
  }
  
  final j cu(String paramString)
  {
    AppMethodBeat.i(74766);
    int j = this.cCb + this.index;
    int k = this.cCc;
    if (PE()) {}
    for (int i = j;; i = j - 1)
    {
      paramString = new j(paramString, i, this.line, j - k - 1);
      AppMethodBeat.o(74766);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.eclipsesource.a.f
 * JD-Core Version:    0.7.0.1
 */