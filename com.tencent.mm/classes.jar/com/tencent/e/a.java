package com.tencent.e;

import com.tencent.e.b.d;
import com.tencent.e.g.a.b;
import com.tencent.e.g.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static g.b LTd;
  public static boolean cFj;
  public int LSW;
  public int LSX;
  public int LSY;
  public b LSZ;
  public h.a LTa;
  public d LTb;
  public boolean LTc = true;
  public long vLa;
  
  static
  {
    AppMethodBeat.i(219267);
    cFj = false;
    LTd = new g.b()
    {
      public final void a(Thread paramAnonymousThread, String paramAnonymousString) {}
      
      public final boolean dyV()
      {
        return false;
      }
      
      public final boolean dyW()
      {
        return false;
      }
    };
    AppMethodBeat.o(219267);
  }
  
  public static final class a
  {
    public a LTe;
    
    public a()
    {
      AppMethodBeat.i(183098);
      this.LTe = new a((byte)0);
      AppMethodBeat.o(183098);
    }
    
    public final a a(h.a parama)
    {
      this.LTe.LTa = parama;
      return this;
    }
    
    public final a agS(int paramInt)
    {
      this.LTe.LSY = paramInt;
      return this;
    }
    
    public final a fVn()
    {
      this.LTe.vLa = 259200000L;
      return this;
    }
    
    public final a fVo()
    {
      this.LTe.LTc = true;
      return this;
    }
    
    public final a kP(int paramInt1, int paramInt2)
    {
      this.LTe.LSX = paramInt1;
      this.LTe.LSW = paramInt2;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.a
 * JD-Core Version:    0.7.0.1
 */