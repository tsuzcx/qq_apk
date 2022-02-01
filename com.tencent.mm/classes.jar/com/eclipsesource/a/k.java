package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;
import java.util.Arrays;

public final class k
  extends l
{
  private final char[] aJD;
  
  private k(char[] paramArrayOfChar)
  {
    this.aJD = paramArrayOfChar;
  }
  
  public static k dR(int paramInt)
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
    paramWriter = new a(paramWriter, this.aJD, (byte)0);
    AppMethodBeat.o(74793);
    return paramWriter;
  }
  
  static final class a
    extends i
  {
    private final char[] aJD;
    private int aJE;
    
    private a(Writer paramWriter, char[] paramArrayOfChar)
    {
      super();
      this.aJD = paramArrayOfChar;
    }
    
    private boolean qC()
    {
      int i = 0;
      AppMethodBeat.i(74791);
      if (this.aJD == null)
      {
        AppMethodBeat.o(74791);
        return false;
      }
      this.aJC.write(10);
      while (i < this.aJE)
      {
        this.aJC.write(this.aJD);
        i += 1;
      }
      AppMethodBeat.o(74791);
      return true;
    }
    
    protected final void qA()
    {
      AppMethodBeat.i(74789);
      this.aJC.write(58);
      this.aJC.write(32);
      AppMethodBeat.o(74789);
    }
    
    protected final void qB()
    {
      AppMethodBeat.i(74790);
      this.aJC.write(44);
      if (!qC()) {
        this.aJC.write(32);
      }
      AppMethodBeat.o(74790);
    }
    
    protected final void qv()
    {
      AppMethodBeat.i(74784);
      this.aJE += 1;
      this.aJC.write(91);
      qC();
      AppMethodBeat.o(74784);
    }
    
    protected final void qw()
    {
      AppMethodBeat.i(74785);
      this.aJE -= 1;
      qC();
      this.aJC.write(93);
      AppMethodBeat.o(74785);
    }
    
    protected final void qx()
    {
      AppMethodBeat.i(74786);
      this.aJC.write(44);
      if (!qC()) {
        this.aJC.write(32);
      }
      AppMethodBeat.o(74786);
    }
    
    protected final void qy()
    {
      AppMethodBeat.i(74787);
      this.aJE += 1;
      this.aJC.write(123);
      qC();
      AppMethodBeat.o(74787);
    }
    
    protected final void qz()
    {
      AppMethodBeat.i(74788);
      this.aJE -= 1;
      qC();
      this.aJC.write(125);
      AppMethodBeat.o(74788);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.eclipsesource.a.k
 * JD-Core Version:    0.7.0.1
 */