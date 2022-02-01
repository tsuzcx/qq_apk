package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;
import java.util.Arrays;

public final class k
  extends l
{
  private final char[] bal;
  
  private k(char[] paramArrayOfChar)
  {
    this.bal = paramArrayOfChar;
  }
  
  public static k dI(int paramInt)
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
    paramWriter = new a(paramWriter, this.bal, (byte)0);
    AppMethodBeat.o(74793);
    return paramWriter;
  }
  
  static final class a
    extends i
  {
    private final char[] bal;
    private int bam;
    
    private a(Writer paramWriter, char[] paramArrayOfChar)
    {
      super();
      this.bal = paramArrayOfChar;
    }
    
    private boolean sL()
    {
      int i = 0;
      AppMethodBeat.i(74791);
      if (this.bal == null)
      {
        AppMethodBeat.o(74791);
        return false;
      }
      this.bak.write(10);
      while (i < this.bam)
      {
        this.bak.write(this.bal);
        i += 1;
      }
      AppMethodBeat.o(74791);
      return true;
    }
    
    protected final void sE()
    {
      AppMethodBeat.i(74784);
      this.bam += 1;
      this.bak.write(91);
      sL();
      AppMethodBeat.o(74784);
    }
    
    protected final void sF()
    {
      AppMethodBeat.i(74785);
      this.bam -= 1;
      sL();
      this.bak.write(93);
      AppMethodBeat.o(74785);
    }
    
    protected final void sG()
    {
      AppMethodBeat.i(74786);
      this.bak.write(44);
      if (!sL()) {
        this.bak.write(32);
      }
      AppMethodBeat.o(74786);
    }
    
    protected final void sH()
    {
      AppMethodBeat.i(74787);
      this.bam += 1;
      this.bak.write(123);
      sL();
      AppMethodBeat.o(74787);
    }
    
    protected final void sI()
    {
      AppMethodBeat.i(74788);
      this.bam -= 1;
      sL();
      this.bak.write(125);
      AppMethodBeat.o(74788);
    }
    
    protected final void sJ()
    {
      AppMethodBeat.i(74789);
      this.bak.write(58);
      this.bak.write(32);
      AppMethodBeat.o(74789);
    }
    
    protected final void sK()
    {
      AppMethodBeat.i(74790);
      this.bak.write(44);
      if (!sL()) {
        this.bak.write(32);
      }
      AppMethodBeat.o(74790);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.a.k
 * JD-Core Version:    0.7.0.1
 */