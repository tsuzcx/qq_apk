package com.tencent.e;

import com.tencent.e.b.d;
import com.tencent.e.g.a.b;
import com.tencent.e.g.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static g.b Mqa;
  public static boolean cFS;
  public int MpT;
  public int MpU;
  public int MpV;
  public b MpW;
  public h.a MpX;
  public d MpY;
  public boolean MpZ = true;
  public long vXe;
  
  static
  {
    AppMethodBeat.i(216727);
    cFS = false;
    Mqa = new g.b()
    {
      public final void a(Thread paramAnonymousThread, String paramAnonymousString) {}
      
      public final boolean dCm()
      {
        return false;
      }
      
      public final boolean dCn()
      {
        return false;
      }
    };
    AppMethodBeat.o(216727);
  }
  
  public static final class a
  {
    public a Mqb;
    
    public a()
    {
      AppMethodBeat.i(183098);
      this.Mqb = new a((byte)0);
      AppMethodBeat.o(183098);
    }
    
    public final a a(h.a parama)
    {
      this.Mqb.MpX = parama;
      return this;
    }
    
    public final a ahB(int paramInt)
    {
      this.Mqb.MpV = paramInt;
      return this;
    }
    
    public final a fZM()
    {
      this.Mqb.vXe = 259200000L;
      return this;
    }
    
    public final a fZN()
    {
      this.Mqb.MpZ = true;
      return this;
    }
    
    public final a kW(int paramInt1, int paramInt2)
    {
      this.Mqb.MpU = paramInt1;
      this.Mqb.MpT = paramInt2;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.a
 * JD-Core Version:    0.7.0.1
 */