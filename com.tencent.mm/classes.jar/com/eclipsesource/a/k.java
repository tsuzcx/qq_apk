package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;
import java.util.Arrays;

public final class k
  extends l
{
  private final char[] cCn;
  
  private k(char[] paramArrayOfChar)
  {
    this.cCn = paramArrayOfChar;
  }
  
  public static k hh(int paramInt)
  {
    AppMethodBeat.i(74792);
    if (paramInt < 0)
    {
      localObject = new IllegalArgumentException("number is negative");
      AppMethodBeat.o(74792);
      throw ((Throwable)localObject);
    }
    Object localObject = new char[paramInt];
    Arrays.fill((char[])localObject, ' ');
    localObject = new k((char[])localObject);
    AppMethodBeat.o(74792);
    return localObject;
  }
  
  protected final i a(Writer paramWriter)
  {
    AppMethodBeat.i(74793);
    paramWriter = new a(paramWriter, this.cCn, (byte)0);
    AppMethodBeat.o(74793);
    return paramWriter;
  }
  
  static final class a
    extends i
  {
    private final char[] cCn;
    private int cCo;
    
    private a(Writer paramWriter, char[] paramArrayOfChar)
    {
      super();
      this.cCn = paramArrayOfChar;
    }
    
    private boolean PN()
    {
      int i = 0;
      AppMethodBeat.i(74791);
      if (this.cCn == null)
      {
        AppMethodBeat.o(74791);
        return false;
      }
      this.cCm.write(10);
      while (i < this.cCo)
      {
        this.cCm.write(this.cCn);
        i += 1;
      }
      AppMethodBeat.o(74791);
      return true;
    }
    
    protected final void PG()
    {
      AppMethodBeat.i(74784);
      this.cCo += 1;
      this.cCm.write(91);
      PN();
      AppMethodBeat.o(74784);
    }
    
    protected final void PH()
    {
      AppMethodBeat.i(74785);
      this.cCo -= 1;
      PN();
      this.cCm.write(93);
      AppMethodBeat.o(74785);
    }
    
    protected final void PI()
    {
      AppMethodBeat.i(74786);
      this.cCm.write(44);
      if (!PN()) {
        this.cCm.write(32);
      }
      AppMethodBeat.o(74786);
    }
    
    protected final void PJ()
    {
      AppMethodBeat.i(74787);
      this.cCo += 1;
      this.cCm.write(123);
      PN();
      AppMethodBeat.o(74787);
    }
    
    protected final void PK()
    {
      AppMethodBeat.i(74788);
      this.cCo -= 1;
      PN();
      this.cCm.write(125);
      AppMethodBeat.o(74788);
    }
    
    protected final void PL()
    {
      AppMethodBeat.i(74789);
      this.cCm.write(58);
      this.cCm.write(32);
      AppMethodBeat.o(74789);
    }
    
    protected final void PM()
    {
      AppMethodBeat.i(74790);
      this.cCm.write(44);
      if (!PN()) {
        this.cCm.write(32);
      }
      AppMethodBeat.o(74790);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.eclipsesource.a.k
 * JD-Core Version:    0.7.0.1
 */