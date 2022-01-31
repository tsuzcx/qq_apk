package com.eclipsesource.a;

import java.io.Reader;
import java.io.StringReader;

final class f
{
  private final Reader arK;
  private final char[] arL;
  private int arM;
  private int arN;
  private int arO;
  private StringBuilder arP;
  private int arQ;
  private int fill;
  private int index;
  private int line;
  
  private f(Reader paramReader, int paramInt)
  {
    this.arK = paramReader;
    this.arL = new char[paramInt];
    this.line = 1;
    this.arQ = -1;
  }
  
  f(String paramString)
  {
    this(new StringReader(paramString), Math.max(10, Math.min(1024, paramString.length())));
  }
  
  private j Z(String paramString)
  {
    if (ka()) {
      return aa("Unexpected end of input");
    }
    return aa("Expected " + paramString);
  }
  
  private void b(char paramChar)
  {
    if (!c(paramChar)) {
      throw Z("'" + paramChar + "'");
    }
  }
  
  private boolean c(char paramChar)
  {
    if (this.arO != paramChar) {
      return false;
    }
    jX();
    return true;
  }
  
  private String jU()
  {
    jX();
    jY();
    while (this.arO != 34)
    {
      if (this.arO == 92)
      {
        if (this.arO == -1) {}
        for (int i = this.index;; i = this.index - 1)
        {
          this.arP.append(this.arL, this.arQ, i - this.arQ);
          this.arQ = -1;
          jX();
          switch (this.arO)
          {
          default: 
            throw Z("valid escape sequence");
          }
        }
        this.arP.append((char)this.arO);
        for (;;)
        {
          jX();
          jY();
          break;
          this.arP.append('\b');
          continue;
          this.arP.append('\f');
          continue;
          this.arP.append('\n');
          continue;
          this.arP.append('\r');
          continue;
          this.arP.append('\t');
          continue;
          localObject = new char[4];
          i = 0;
          while (i < 4)
          {
            jX();
            if (((this.arO >= 48) && (this.arO <= 57)) || ((this.arO >= 97) && (this.arO <= 102)) || ((this.arO >= 65) && (this.arO <= 70))) {}
            for (int j = 1; j == 0; j = 0) {
              throw Z("hexadecimal digit");
            }
            localObject[i] = ((char)this.arO);
            i += 1;
          }
          this.arP.append((char)Integer.parseInt(new String((char[])localObject), 16));
        }
      }
      if (this.arO < 32) {
        throw Z("valid string character");
      }
      jX();
    }
    Object localObject = jZ();
    jX();
    return localObject;
  }
  
  private boolean jV()
  {
    if ((this.arO >= 48) && (this.arO <= 57)) {}
    for (int i = 1; i == 0; i = 0) {
      return false;
    }
    jX();
    return true;
  }
  
  private void jY()
  {
    if (this.arP == null) {
      this.arP = new StringBuilder();
    }
    this.arQ = (this.index - 1);
  }
  
  private String jZ()
  {
    int i;
    String str;
    if (this.arO == -1)
    {
      i = this.index;
      if (this.arP.length() <= 0) {
        break label78;
      }
      this.arP.append(this.arL, this.arQ, i - this.arQ);
      str = this.arP.toString();
      this.arP.setLength(0);
    }
    for (;;)
    {
      this.arQ = -1;
      return str;
      i = this.index - 1;
      break;
      label78:
      str = new String(this.arL, this.arQ, i - this.arQ);
    }
  }
  
  final j aa(String paramString)
  {
    int j = this.arM + this.index;
    int k = this.arN;
    if (ka()) {}
    for (int i = j;; i = j - 1) {
      return new j(paramString, i, this.line, j - k - 1);
    }
  }
  
  final h jT()
  {
    Object localObject1;
    switch (this.arO)
    {
    default: 
      throw Z("value");
    case 110: 
      jX();
      b('u');
      b('l');
      b('l');
      localObject1 = a.aru;
    case 116: 
    case 102: 
    case 34: 
    case 91: 
    case 123: 
      do
      {
        Object localObject2;
        do
        {
          do
          {
            do
            {
              return localObject1;
              jX();
              b('r');
              b('u');
              b('e');
              return a.arv;
              jX();
              b('a');
              b('l');
              b('s');
              b('e');
              return a.arw;
              return new g(jU());
              jX();
              localObject2 = new b();
              jW();
              localObject1 = localObject2;
            } while (c(']'));
            do
            {
              jW();
              ((b)localObject2).a(jT());
              jW();
            } while (c(','));
            localObject1 = localObject2;
          } while (c(']'));
          throw Z("',' or ']'");
          jX();
          localObject2 = new e();
          jW();
          localObject1 = localObject2;
        } while (c('}'));
        do
        {
          jW();
          if (this.arO != 34) {
            throw Z("name");
          }
          localObject1 = jU();
          jW();
          if (!c(':')) {
            throw Z("':'");
          }
          jW();
          ((e)localObject2).a((String)localObject1, jT());
          jW();
        } while (c(','));
        localObject1 = localObject2;
      } while (c('}'));
      throw Z("',' or '}'");
    }
    jY();
    c('-');
    int i = this.arO;
    if (!jV()) {
      throw Z("digit");
    }
    while ((i != 48) && (jV())) {}
    if (c('.'))
    {
      if (!jV()) {
        throw Z("digit");
      }
      while (jV()) {}
    }
    if ((c('e')) || (c('E')))
    {
      if (!c('+')) {
        c('-');
      }
      if (!jV()) {
        throw Z("digit");
      }
      while (jV()) {}
    }
    return new d(jZ());
  }
  
  final void jW()
  {
    if ((this.arO == 32) || (this.arO == 9) || (this.arO == 10) || (this.arO == 13)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        return;
      }
      jX();
      break;
    }
  }
  
  final void jX()
  {
    if (this.index == this.fill)
    {
      if (this.arQ != -1)
      {
        this.arP.append(this.arL, this.arQ, this.fill - this.arQ);
        this.arQ = 0;
      }
      this.arM += this.fill;
      this.fill = this.arK.read(this.arL, 0, this.arL.length);
      this.index = 0;
      if (this.fill == -1)
      {
        this.arO = -1;
        return;
      }
    }
    if (this.arO == 10)
    {
      this.line += 1;
      this.arN = (this.arM + this.index);
    }
    char[] arrayOfChar = this.arL;
    int i = this.index;
    this.index = (i + 1);
    this.arO = arrayOfChar[i];
  }
  
  final boolean ka()
  {
    return this.arO == -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.eclipsesource.a.f
 * JD-Core Version:    0.7.0.1
 */