package com.tencent.mm.cs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

class g
{
  private long Dpr;
  private long agYX;
  private long agYY;
  private char agYZ;
  private boolean agZa;
  private long agZb;
  private final Reader cBZ;
  private boolean eof;
  
  public g(Reader paramReader)
  {
    AppMethodBeat.i(231617);
    if (paramReader.markSupported()) {}
    for (;;)
    {
      this.cBZ = paramReader;
      this.eof = false;
      this.agZa = false;
      this.agYZ = '\000';
      this.Dpr = 0L;
      this.agYX = 1L;
      this.agZb = 0L;
      this.agYY = 1L;
      AppMethodBeat.o(231617);
      return;
      paramReader = new BufferedReader(paramReader);
    }
  }
  
  public g(String paramString)
  {
    this(new StringReader(paramString));
    AppMethodBeat.i(231623);
    AppMethodBeat.o(231623);
  }
  
  private String H(char paramChar)
  {
    AppMethodBeat.i(231636);
    Object localObject = new StringBuilder();
    for (;;)
    {
      char c = next();
      b localb;
      switch (c)
      {
      default: 
        if (c == paramChar)
        {
          localObject = ((StringBuilder)localObject).toString();
          AppMethodBeat.o(231636);
          return localObject;
        }
        break;
      case '\000': 
      case '\n': 
      case '\r': 
        localObject = bFc("Unterminated string");
        AppMethodBeat.o(231636);
        throw ((Throwable)localObject);
      case '\\': 
        c = next();
        switch (c)
        {
        default: 
          localObject = bFc("Illegal escape.");
          AppMethodBeat.o(231636);
          throw ((Throwable)localObject);
        case 'b': 
          ((StringBuilder)localObject).append('\b');
          break;
        case 't': 
          ((StringBuilder)localObject).append('\t');
          break;
        case 'n': 
          ((StringBuilder)localObject).append('\n');
          break;
        case 'f': 
          ((StringBuilder)localObject).append('\f');
          break;
        case 'r': 
          ((StringBuilder)localObject).append('\r');
          break;
        case 'u': 
          try
          {
            ((StringBuilder)localObject).append((char)Integer.parseInt(jQs(), 16));
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localb = new b("Illegal escape." + toString(), localNumberFormatException);
            AppMethodBeat.o(231636);
            throw localb;
          }
        case '"': 
        case '\'': 
        case '/': 
        case '\\': 
          localb.append(c);
        }
        break;
      }
      localb.append(c);
    }
  }
  
  private void jQq()
  {
    this.Dpr -= 1L;
    if ((this.agYZ == '\r') || (this.agYZ == '\n'))
    {
      this.agYY -= 1L;
      this.agYX = this.agZb;
    }
    while (this.agYX <= 0L) {
      return;
    }
    this.agYX -= 1L;
  }
  
  private String jQs()
  {
    AppMethodBeat.i(231631);
    Object localObject = new char[4];
    int i = 0;
    while (i < 4)
    {
      localObject[i] = next();
      if ((this.eof) && (!this.agZa)) {}
      for (int j = 1; j != 0; j = 0)
      {
        localObject = bFc("Substring bounds error");
        AppMethodBeat.o(231631);
        throw ((Throwable)localObject);
      }
      i += 1;
    }
    localObject = new String((char[])localObject);
    AppMethodBeat.o(231631);
    return localObject;
  }
  
  public final b bFc(String paramString)
  {
    AppMethodBeat.i(231663);
    paramString = new b(paramString + toString());
    AppMethodBeat.o(231663);
    return paramString;
  }
  
  public final void cLO()
  {
    AppMethodBeat.i(231641);
    if ((this.agZa) || (this.Dpr <= 0L))
    {
      b localb = new b("Stepping back two steps is not supported");
      AppMethodBeat.o(231641);
      throw localb;
    }
    jQq();
    this.agZa = true;
    this.eof = false;
    AppMethodBeat.o(231641);
  }
  
  /* Error */
  public final boolean jQr()
  {
    // Byte code:
    //   0: ldc 132
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 40	com/tencent/mm/cs/g:agZa	Z
    //   9: ifeq +10 -> 19
    //   12: ldc 132
    //   14: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: iconst_1
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 36	com/tencent/mm/cs/g:cBZ	Ljava/io/Reader;
    //   23: iconst_1
    //   24: invokevirtual 135	java/io/Reader:mark	(I)V
    //   27: aload_0
    //   28: getfield 36	com/tencent/mm/cs/g:cBZ	Ljava/io/Reader;
    //   31: invokevirtual 139	java/io/Reader:read	()I
    //   34: ifgt +34 -> 68
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 38	com/tencent/mm/cs/g:eof	Z
    //   42: ldc 132
    //   44: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: iconst_0
    //   48: ireturn
    //   49: astore_1
    //   50: new 104	com/tencent/mm/cs/b
    //   53: dup
    //   54: ldc 141
    //   56: aload_1
    //   57: invokespecial 111	com/tencent/mm/cs/b:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   60: astore_1
    //   61: ldc 132
    //   63: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_1
    //   67: athrow
    //   68: aload_0
    //   69: getfield 36	com/tencent/mm/cs/g:cBZ	Ljava/io/Reader;
    //   72: invokevirtual 144	java/io/Reader:reset	()V
    //   75: ldc 132
    //   77: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: iconst_1
    //   81: ireturn
    //   82: astore_1
    //   83: new 104	com/tencent/mm/cs/b
    //   86: dup
    //   87: ldc 146
    //   89: aload_1
    //   90: invokespecial 111	com/tencent/mm/cs/b:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   93: astore_1
    //   94: ldc 132
    //   96: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	g
    //   49	8	1	localIOException1	IOException
    //   60	7	1	localb1	b
    //   82	8	1	localIOException2	IOException
    //   93	7	1	localb2	b
    // Exception table:
    //   from	to	target	type
    //   19	27	49	java/io/IOException
    //   27	42	82	java/io/IOException
    //   68	75	82	java/io/IOException
  }
  
  public final char jQt()
  {
    AppMethodBeat.i(231654);
    char c;
    do
    {
      c = next();
    } while ((c != 0) && (c <= ' '));
    AppMethodBeat.o(231654);
    return c;
  }
  
  public final Object jQu()
  {
    AppMethodBeat.i(231658);
    char c = jQt();
    switch (c)
    {
    default: 
      localObject = new StringBuilder();
    }
    while ((c >= ' ') && (",:]}/\\\"[{;=#".indexOf(c) < 0))
    {
      ((StringBuilder)localObject).append(c);
      c = next();
      continue;
      localObject = H(c);
      AppMethodBeat.o(231658);
      return localObject;
      cLO();
      localObject = new c(this);
      AppMethodBeat.o(231658);
      return localObject;
      cLO();
      localObject = new a(this);
      AppMethodBeat.o(231658);
      return localObject;
    }
    if (!this.eof) {
      cLO();
    }
    Object localObject = ((StringBuilder)localObject).toString().trim();
    if ("".equals(localObject))
    {
      localObject = bFc("Missing value");
      AppMethodBeat.o(231658);
      throw ((Throwable)localObject);
    }
    localObject = c.bFb((String)localObject);
    AppMethodBeat.o(231658);
    return localObject;
  }
  
  public final char next()
  {
    AppMethodBeat.i(231650);
    int i;
    if (this.agZa)
    {
      this.agZa = false;
      i = this.agYZ;
    }
    while (i <= 0)
    {
      this.eof = true;
      AppMethodBeat.o(231650);
      return '\000';
      try
      {
        i = this.cBZ.read();
      }
      catch (IOException localIOException)
      {
        b localb = new b(localIOException);
        AppMethodBeat.o(231650);
        throw localb;
      }
    }
    if (i > 0)
    {
      this.Dpr += 1L;
      if (i != 13) {
        break label127;
      }
      this.agYY += 1L;
      this.agZb = this.agYX;
      this.agYX = 0L;
    }
    for (;;)
    {
      this.agYZ = ((char)i);
      char c = this.agYZ;
      AppMethodBeat.o(231650);
      return c;
      label127:
      if (i == 10)
      {
        if (this.agYZ != '\r')
        {
          this.agYY += 1L;
          this.agZb = this.agYX;
        }
        this.agYX = 0L;
      }
      else
      {
        this.agYX += 1L;
      }
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(231670);
    String str = " at " + this.Dpr + " [character " + this.agYX + " line " + this.agYY + "]";
    AppMethodBeat.o(231670);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.cs.g
 * JD-Core Version:    0.7.0.1
 */