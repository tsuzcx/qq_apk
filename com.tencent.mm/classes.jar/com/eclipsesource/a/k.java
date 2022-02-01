package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;
import java.util.Arrays;

public final class k
  extends l
{
  private final char[] bah;
  
  private k(char[] paramArrayOfChar)
  {
    this.bah = paramArrayOfChar;
  }
  
  public static k dD(int paramInt)
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
    paramWriter = new a(paramWriter, this.bah, (byte)0);
    AppMethodBeat.o(74793);
    return paramWriter;
  }
  
  static final class a
    extends i
  {
    private final char[] bah;
    private int bai;
    
    private a(Writer paramWriter, char[] paramArrayOfChar)
    {
      super();
      this.bah = paramArrayOfChar;
    }
    
    private boolean sO()
    {
      int i = 0;
      AppMethodBeat.i(74791);
      if (this.bah == null)
      {
        AppMethodBeat.o(74791);
        return false;
      }
      this.bag.write(10);
      while (i < this.bai)
      {
        this.bag.write(this.bah);
        i += 1;
      }
      AppMethodBeat.o(74791);
      return true;
    }
    
    protected final void sH()
    {
      AppMethodBeat.i(74784);
      this.bai += 1;
      this.bag.write(91);
      sO();
      AppMethodBeat.o(74784);
    }
    
    protected final void sI()
    {
      AppMethodBeat.i(74785);
      this.bai -= 1;
      sO();
      this.bag.write(93);
      AppMethodBeat.o(74785);
    }
    
    protected final void sJ()
    {
      AppMethodBeat.i(74786);
      this.bag.write(44);
      if (!sO()) {
        this.bag.write(32);
      }
      AppMethodBeat.o(74786);
    }
    
    protected final void sK()
    {
      AppMethodBeat.i(74787);
      this.bai += 1;
      this.bag.write(123);
      sO();
      AppMethodBeat.o(74787);
    }
    
    protected final void sL()
    {
      AppMethodBeat.i(74788);
      this.bai -= 1;
      sO();
      this.bag.write(125);
      AppMethodBeat.o(74788);
    }
    
    protected final void sM()
    {
      AppMethodBeat.i(74789);
      this.bag.write(58);
      this.bag.write(32);
      AppMethodBeat.o(74789);
    }
    
    protected final void sN()
    {
      AppMethodBeat.i(74790);
      this.bag.write(44);
      if (!sO()) {
        this.bag.write(32);
      }
      AppMethodBeat.o(74790);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.a.k
 * JD-Core Version:    0.7.0.1
 */