package com.tencent.mm.plugin.aa.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.p;
import com.tencent.mm.protocal.protobuf.w;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public class g
  implements b<f>
{
  protected f iBj;
  public final d iBk;
  public final a iBl;
  public final e iBm;
  public final c iBn;
  public final b iBo;
  public final f iBp;
  
  public g()
  {
    this(new f());
    AppMethodBeat.i(63468);
    AppMethodBeat.o(63468);
  }
  
  private g(f paramf)
  {
    AppMethodBeat.i(63469);
    this.iBk = new d();
    this.iBl = new a();
    this.iBm = new e();
    this.iBn = new c();
    this.iBo = new b();
    this.iBp = new f();
    this.iBj = paramf;
    AppMethodBeat.o(63469);
  }
  
  public final class a
    implements e<p, Long>
  {
    public a() {}
    
    public final String Ua()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class b
    implements e<Boolean, Void>
  {
    public b() {}
    
    public final String Ua()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class c
    implements e<Void, d<Long, String, String>>
  {
    public c() {}
    
    public final String Ua()
    {
      return "Vending.LOGIC";
    }
    
    public final c<Void> b(long paramLong, String paramString1, String paramString2)
    {
      AppMethodBeat.i(63461);
      paramString1 = com.tencent.mm.vending.g.g.h(Long.valueOf(paramLong), paramString1, paramString2).c(this);
      AppMethodBeat.o(63461);
      return paramString1;
    }
  }
  
  public final class d
    implements e<w, Void>
  {
    public d() {}
    
    public final String Ua()
    {
      return "Vending.LOGIC";
    }
    
    public final c<w> aOa()
    {
      AppMethodBeat.i(63463);
      c localc = com.tencent.mm.vending.g.g.fxs().c(this);
      AppMethodBeat.o(63463);
      return localc;
    }
  }
  
  public final class e
    implements e<Void, d<String, String, String>>
  {
    public e() {}
    
    public final String Ua()
    {
      return "Vending.LOGIC";
    }
    
    public final c<Void> x(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(63465);
      paramString1 = com.tencent.mm.vending.g.g.h(paramString1, paramString2, paramString3).c(this);
      AppMethodBeat.o(63465);
      return paramString1;
    }
  }
  
  public final class f
    implements e<Boolean, Void>
  {
    public f() {}
    
    public final String Ua()
    {
      return "Vending.LOGIC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.b.g
 * JD-Core Version:    0.7.0.1
 */