package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;
import java.util.Arrays;

public final class k
  extends l
{
  private final char[] aPb;
  
  private k(char[] paramArrayOfChar)
  {
    this.aPb = paramArrayOfChar;
  }
  
  public static k dF(int paramInt)
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
    paramWriter = new a(paramWriter, this.aPb, (byte)0);
    AppMethodBeat.o(74793);
    return paramWriter;
  }
  
  static final class a
    extends i
  {
    private final char[] aPb;
    private int aPc;
    
    private a(Writer paramWriter, char[] paramArrayOfChar)
    {
      super();
      this.aPb = paramArrayOfChar;
    }
    
    private boolean rd()
    {
      int i = 0;
      AppMethodBeat.i(74791);
      if (this.aPb == null)
      {
        AppMethodBeat.o(74791);
        return false;
      }
      this.aPa.write(10);
      while (i < this.aPc)
      {
        this.aPa.write(this.aPb);
        i += 1;
      }
      AppMethodBeat.o(74791);
      return true;
    }
    
    protected final void qW()
    {
      AppMethodBeat.i(74784);
      this.aPc += 1;
      this.aPa.write(91);
      rd();
      AppMethodBeat.o(74784);
    }
    
    protected final void qX()
    {
      AppMethodBeat.i(74785);
      this.aPc -= 1;
      rd();
      this.aPa.write(93);
      AppMethodBeat.o(74785);
    }
    
    protected final void qY()
    {
      AppMethodBeat.i(74786);
      this.aPa.write(44);
      if (!rd()) {
        this.aPa.write(32);
      }
      AppMethodBeat.o(74786);
    }
    
    protected final void qZ()
    {
      AppMethodBeat.i(74787);
      this.aPc += 1;
      this.aPa.write(123);
      rd();
      AppMethodBeat.o(74787);
    }
    
    protected final void ra()
    {
      AppMethodBeat.i(74788);
      this.aPc -= 1;
      rd();
      this.aPa.write(125);
      AppMethodBeat.o(74788);
    }
    
    protected final void rb()
    {
      AppMethodBeat.i(74789);
      this.aPa.write(58);
      this.aPa.write(32);
      AppMethodBeat.o(74789);
    }
    
    protected final void rc()
    {
      AppMethodBeat.i(74790);
      this.aPa.write(44);
      if (!rd()) {
        this.aPa.write(32);
      }
      AppMethodBeat.o(74790);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.a.k
 * JD-Core Version:    0.7.0.1
 */