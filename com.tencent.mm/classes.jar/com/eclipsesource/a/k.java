package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;
import java.util.Arrays;

public final class k
  extends l
{
  private final char[] aPR;
  
  private k(char[] paramArrayOfChar)
  {
    this.aPR = paramArrayOfChar;
  }
  
  public static k dE(int paramInt)
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
    paramWriter = new a(paramWriter, this.aPR, (byte)0);
    AppMethodBeat.o(74793);
    return paramWriter;
  }
  
  static final class a
    extends i
  {
    private final char[] aPR;
    private int aPS;
    
    private a(Writer paramWriter, char[] paramArrayOfChar)
    {
      super();
      this.aPR = paramArrayOfChar;
    }
    
    private boolean rn()
    {
      int i = 0;
      AppMethodBeat.i(74791);
      if (this.aPR == null)
      {
        AppMethodBeat.o(74791);
        return false;
      }
      this.aPQ.write(10);
      while (i < this.aPS)
      {
        this.aPQ.write(this.aPR);
        i += 1;
      }
      AppMethodBeat.o(74791);
      return true;
    }
    
    protected final void rg()
    {
      AppMethodBeat.i(74784);
      this.aPS += 1;
      this.aPQ.write(91);
      rn();
      AppMethodBeat.o(74784);
    }
    
    protected final void rh()
    {
      AppMethodBeat.i(74785);
      this.aPS -= 1;
      rn();
      this.aPQ.write(93);
      AppMethodBeat.o(74785);
    }
    
    protected final void ri()
    {
      AppMethodBeat.i(74786);
      this.aPQ.write(44);
      if (!rn()) {
        this.aPQ.write(32);
      }
      AppMethodBeat.o(74786);
    }
    
    protected final void rj()
    {
      AppMethodBeat.i(74787);
      this.aPS += 1;
      this.aPQ.write(123);
      rn();
      AppMethodBeat.o(74787);
    }
    
    protected final void rk()
    {
      AppMethodBeat.i(74788);
      this.aPS -= 1;
      rn();
      this.aPQ.write(125);
      AppMethodBeat.o(74788);
    }
    
    protected final void rl()
    {
      AppMethodBeat.i(74789);
      this.aPQ.write(58);
      this.aPQ.write(32);
      AppMethodBeat.o(74789);
    }
    
    protected final void rm()
    {
      AppMethodBeat.i(74790);
      this.aPQ.write(44);
      if (!rn()) {
        this.aPQ.write(32);
      }
      AppMethodBeat.o(74790);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.a.k
 * JD-Core Version:    0.7.0.1
 */