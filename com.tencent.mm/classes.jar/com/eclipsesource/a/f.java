package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Reader;
import java.io.StringReader;

final class f
{
  private final char[] auc;
  private int aud;
  private int aue;
  private int auf;
  private int aug;
  private StringBuilder auh;
  private int aui;
  private int index;
  private int line;
  private final Reader reader;
  
  private f(Reader paramReader, int paramInt)
  {
    AppMethodBeat.i(70556);
    this.reader = paramReader;
    this.auc = new char[paramInt];
    this.line = 1;
    this.aui = -1;
    AppMethodBeat.o(70556);
  }
  
  f(String paramString)
  {
    this(new StringReader(paramString), Math.max(10, Math.min(1024, paramString.length())));
    AppMethodBeat.i(70555);
    AppMethodBeat.o(70555);
  }
  
  private j ae(String paramString)
  {
    AppMethodBeat.i(70578);
    if (mj())
    {
      paramString = af("Unexpected end of input");
      AppMethodBeat.o(70578);
      return paramString;
    }
    paramString = af("Expected ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(70578);
    return paramString;
  }
  
  private void d(char paramChar)
  {
    AppMethodBeat.i(70564);
    if (!e(paramChar))
    {
      j localj = ae("'" + paramChar + "'");
      AppMethodBeat.o(70564);
      throw localj;
    }
    AppMethodBeat.o(70564);
  }
  
  private boolean e(char paramChar)
  {
    AppMethodBeat.i(70571);
    if (this.aug != paramChar)
    {
      AppMethodBeat.o(70571);
      return false;
    }
    mc();
    AppMethodBeat.o(70571);
    return true;
  }
  
  private b lO()
  {
    AppMethodBeat.i(70558);
    mc();
    Object localObject = new b();
    mb();
    if (e(']'))
    {
      AppMethodBeat.o(70558);
      return localObject;
    }
    do
    {
      mb();
      ((b)localObject).a(lN());
      mb();
    } while (e(','));
    if (!e(']'))
    {
      localObject = ae("',' or ']'");
      AppMethodBeat.o(70558);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(70558);
    return localObject;
  }
  
  private e lP()
  {
    AppMethodBeat.i(70559);
    mc();
    Object localObject = new e();
    mb();
    if (e('}'))
    {
      AppMethodBeat.o(70559);
      return localObject;
    }
    do
    {
      mb();
      String str = lQ();
      mb();
      if (!e(':'))
      {
        localObject = ae("':'");
        AppMethodBeat.o(70559);
        throw ((Throwable)localObject);
      }
      mb();
      ((e)localObject).a(str, lN());
      mb();
    } while (e(','));
    if (!e('}'))
    {
      localObject = ae("',' or '}'");
      AppMethodBeat.o(70559);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(70559);
    return localObject;
  }
  
  private String lQ()
  {
    AppMethodBeat.i(70560);
    if (this.aug != 34)
    {
      localObject = ae("name");
      AppMethodBeat.o(70560);
      throw ((Throwable)localObject);
    }
    Object localObject = lV();
    AppMethodBeat.o(70560);
    return localObject;
  }
  
  private h lR()
  {
    AppMethodBeat.i(70561);
    mc();
    d('u');
    d('l');
    d('l');
    h localh = a.atM;
    AppMethodBeat.o(70561);
    return localh;
  }
  
  private h lS()
  {
    AppMethodBeat.i(70562);
    mc();
    d('r');
    d('u');
    d('e');
    h localh = a.atN;
    AppMethodBeat.o(70562);
    return localh;
  }
  
  private h lT()
  {
    AppMethodBeat.i(70563);
    mc();
    d('a');
    d('l');
    d('s');
    d('e');
    h localh = a.atO;
    AppMethodBeat.o(70563);
    return localh;
  }
  
  private h lU()
  {
    AppMethodBeat.i(70565);
    g localg = new g(lV());
    AppMethodBeat.o(70565);
    return localg;
  }
  
  private String lV()
  {
    AppMethodBeat.i(70566);
    mc();
    md();
    while (this.aug != 34) {
      if (this.aug == 92)
      {
        me();
        lW();
        md();
      }
      else
      {
        if (this.aug < 32)
        {
          localObject = ae("valid string character");
          AppMethodBeat.o(70566);
          throw ((Throwable)localObject);
        }
        mc();
      }
    }
    Object localObject = mf();
    mc();
    AppMethodBeat.o(70566);
    return localObject;
  }
  
  private void lW()
  {
    AppMethodBeat.i(70567);
    mc();
    Object localObject;
    switch (this.aug)
    {
    default: 
      localObject = ae("valid escape sequence");
      AppMethodBeat.o(70567);
      throw ((Throwable)localObject);
    case 34: 
    case 47: 
    case 92: 
      this.auh.append((char)this.aug);
    }
    for (;;)
    {
      mc();
      AppMethodBeat.o(70567);
      return;
      this.auh.append('\b');
      continue;
      this.auh.append('\f');
      continue;
      this.auh.append('\n');
      continue;
      this.auh.append('\r');
      continue;
      this.auh.append('\t');
      continue;
      localObject = new char[4];
      int i = 0;
      while (i < 4)
      {
        mc();
        if (!mi())
        {
          localObject = ae("hexadecimal digit");
          AppMethodBeat.o(70567);
          throw ((Throwable)localObject);
        }
        localObject[i] = ((char)this.aug);
        i += 1;
      }
      this.auh.append((char)Integer.parseInt(new String((char[])localObject), 16));
    }
  }
  
  private h lX()
  {
    AppMethodBeat.i(70568);
    md();
    e('-');
    int i = this.aug;
    if (!ma())
    {
      localObject = ae("digit");
      AppMethodBeat.o(70568);
      throw ((Throwable)localObject);
    }
    while ((i != 48) && (ma())) {}
    lY();
    lZ();
    Object localObject = new d(mf());
    AppMethodBeat.o(70568);
    return localObject;
  }
  
  private boolean lY()
  {
    AppMethodBeat.i(70569);
    if (!e('.'))
    {
      AppMethodBeat.o(70569);
      return false;
    }
    if (!ma())
    {
      j localj = ae("digit");
      AppMethodBeat.o(70569);
      throw localj;
    }
    while (ma()) {}
    AppMethodBeat.o(70569);
    return true;
  }
  
  private boolean lZ()
  {
    AppMethodBeat.i(70570);
    if ((!e('e')) && (!e('E')))
    {
      AppMethodBeat.o(70570);
      return false;
    }
    if (!e('+')) {
      e('-');
    }
    if (!ma())
    {
      j localj = ae("digit");
      AppMethodBeat.o(70570);
      throw localj;
    }
    while (ma()) {}
    AppMethodBeat.o(70570);
    return true;
  }
  
  private boolean ma()
  {
    AppMethodBeat.i(70572);
    if (!mh())
    {
      AppMethodBeat.o(70572);
      return false;
    }
    mc();
    AppMethodBeat.o(70572);
    return true;
  }
  
  private void md()
  {
    AppMethodBeat.i(70575);
    if (this.auh == null) {
      this.auh = new StringBuilder();
    }
    this.aui = (this.index - 1);
    AppMethodBeat.o(70575);
  }
  
  private void me()
  {
    AppMethodBeat.i(70576);
    if (this.aug == -1) {}
    for (int i = this.index;; i = this.index - 1)
    {
      StringBuilder localStringBuilder = this.auh;
      char[] arrayOfChar = this.auc;
      int j = this.aui;
      localStringBuilder.append(arrayOfChar, j, i - j);
      this.aui = -1;
      AppMethodBeat.o(70576);
      return;
    }
  }
  
  private String mf()
  {
    AppMethodBeat.i(70577);
    int i;
    Object localObject;
    if (this.aug == -1)
    {
      i = this.index;
      if (this.auh.length() <= 0) {
        break label93;
      }
      localObject = this.auh;
      char[] arrayOfChar = this.auc;
      int j = this.aui;
      ((StringBuilder)localObject).append(arrayOfChar, j, i - j);
      localObject = this.auh.toString();
      this.auh.setLength(0);
    }
    for (;;)
    {
      this.aui = -1;
      AppMethodBeat.o(70577);
      return localObject;
      i = this.index - 1;
      break;
      label93:
      localObject = new String(this.auc, this.aui, i - this.aui);
    }
  }
  
  private boolean mg()
  {
    return (this.aug == 32) || (this.aug == 9) || (this.aug == 10) || (this.aug == 13);
  }
  
  private boolean mh()
  {
    return (this.aug >= 48) && (this.aug <= 57);
  }
  
  private boolean mi()
  {
    return ((this.aug >= 48) && (this.aug <= 57)) || ((this.aug >= 97) && (this.aug <= 102)) || ((this.aug >= 65) && (this.aug <= 70));
  }
  
  final j af(String paramString)
  {
    AppMethodBeat.i(70579);
    int j = this.aud + this.index;
    int k = this.auf;
    if (mj()) {}
    for (int i = j;; i = j - 1)
    {
      paramString = new j(paramString, i, this.line, j - k - 1);
      AppMethodBeat.o(70579);
      return paramString;
    }
  }
  
  final h lN()
  {
    AppMethodBeat.i(70557);
    switch (this.aug)
    {
    default: 
      localObject = ae("value");
      AppMethodBeat.o(70557);
      throw ((Throwable)localObject);
    case 110: 
      localObject = lR();
      AppMethodBeat.o(70557);
      return localObject;
    case 116: 
      localObject = lS();
      AppMethodBeat.o(70557);
      return localObject;
    case 102: 
      localObject = lT();
      AppMethodBeat.o(70557);
      return localObject;
    case 34: 
      localObject = lU();
      AppMethodBeat.o(70557);
      return localObject;
    case 91: 
      localObject = lO();
      AppMethodBeat.o(70557);
      return localObject;
    case 123: 
      localObject = lP();
      AppMethodBeat.o(70557);
      return localObject;
    }
    Object localObject = lX();
    AppMethodBeat.o(70557);
    return localObject;
  }
  
  final void mb()
  {
    AppMethodBeat.i(70573);
    while (mg()) {
      mc();
    }
    AppMethodBeat.o(70573);
  }
  
  final void mc()
  {
    AppMethodBeat.i(70574);
    if (this.index == this.aue)
    {
      if (this.aui != -1)
      {
        this.auh.append(this.auc, this.aui, this.aue - this.aui);
        this.aui = 0;
      }
      this.aud += this.aue;
      this.aue = this.reader.read(this.auc, 0, this.auc.length);
      this.index = 0;
      if (this.aue == -1)
      {
        this.aug = -1;
        AppMethodBeat.o(70574);
        return;
      }
    }
    if (this.aug == 10)
    {
      this.line += 1;
      this.auf = (this.aud + this.index);
    }
    char[] arrayOfChar = this.auc;
    int i = this.index;
    this.index = (i + 1);
    this.aug = arrayOfChar[i];
    AppMethodBeat.o(70574);
  }
  
  final boolean mj()
  {
    return this.aug == -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.eclipsesource.a.f
 * JD-Core Version:    0.7.0.1
 */