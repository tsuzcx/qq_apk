package com.tencent.f;

import com.tencent.f.b.d;
import com.tencent.f.g.a.b;
import com.tencent.f.g.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static g.b RSx;
  public static boolean cWq;
  public int RSq;
  public int RSr;
  public int RSs;
  public b RSt;
  public h.a RSu;
  public d RSv;
  public boolean RSw = true;
  public long zrg;
  
  static
  {
    AppMethodBeat.i(256656);
    cWq = false;
    RSx = new g.b()
    {
      public final void a(Thread paramAnonymousThread, String paramAnonymousString) {}
      
      public final boolean eCC()
      {
        return false;
      }
      
      public final boolean eCD()
      {
        return false;
      }
    };
    AppMethodBeat.o(256656);
  }
  
  public static final class a
  {
    public a RSy;
    
    public a()
    {
      AppMethodBeat.i(183098);
      this.RSy = new a((byte)0);
      AppMethodBeat.o(183098);
    }
    
    public final a a(h.a parama)
    {
      this.RSy.RSu = parama;
      return this;
    }
    
    public final a aqO(int paramInt)
    {
      this.RSy.RSs = paramInt;
      return this;
    }
    
    public final a hlX()
    {
      this.RSy.zrg = 259200000L;
      return this;
    }
    
    public final a hlY()
    {
      this.RSy.RSw = true;
      return this;
    }
    
    public final a mv(int paramInt1, int paramInt2)
    {
      this.RSy.RSr = paramInt1;
      this.RSy.RSq = paramInt2;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.f.a
 * JD-Core Version:    0.7.0.1
 */