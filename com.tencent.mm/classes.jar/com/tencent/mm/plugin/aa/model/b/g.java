package com.tencent.mm.plugin.aa.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.s;
import com.tencent.mm.protocal.protobuf.z;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public class g
  implements b<f>
{
  protected f pIe;
  public final d pIf;
  public final a pIg;
  public final e pIh;
  public final c pIi;
  public final b pIj;
  public final f pIk;
  
  public g()
  {
    this(new f());
    AppMethodBeat.i(63468);
    AppMethodBeat.o(63468);
  }
  
  private g(f paramf)
  {
    AppMethodBeat.i(63469);
    this.pIf = new d();
    this.pIg = new a();
    this.pIh = new e();
    this.pIi = new c();
    this.pIj = new b();
    this.pIk = new f();
    this.pIe = paramf;
    AppMethodBeat.o(63469);
  }
  
  public final class a
    implements e<s, com.tencent.mm.vending.j.c<Long, String>>
  {
    public a() {}
    
    public final String aKh()
    {
      return "Vending.LOGIC";
    }
    
    public final com.tencent.mm.vending.g.c<s> n(long paramLong, String paramString)
    {
      AppMethodBeat.i(268399);
      paramString = com.tencent.mm.vending.g.g.S(Long.valueOf(paramLong), paramString).c(this);
      AppMethodBeat.o(268399);
      return paramString;
    }
  }
  
  public final class b
    implements e<Boolean, Void>
  {
    public b() {}
    
    public final String aKh()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class c
    implements e<Void, d<Long, String, String>>
  {
    public c() {}
    
    public final String aKh()
    {
      return "Vending.LOGIC";
    }
    
    public final com.tencent.mm.vending.g.c<Void> b(long paramLong, String paramString1, String paramString2)
    {
      AppMethodBeat.i(63461);
      paramString1 = com.tencent.mm.vending.g.g.f(Long.valueOf(paramLong), paramString1, paramString2).c(this);
      AppMethodBeat.o(63461);
      return paramString1;
    }
  }
  
  public final class d
    implements e<z, Void>
  {
    public d() {}
    
    public final String aKh()
    {
      return "Vending.LOGIC";
    }
    
    public final com.tencent.mm.vending.g.c<z> bVq()
    {
      AppMethodBeat.i(63463);
      com.tencent.mm.vending.g.c localc = com.tencent.mm.vending.g.g.jJU().c(this);
      AppMethodBeat.o(63463);
      return localc;
    }
  }
  
  public final class e
    implements e<Void, d<String, String, String>>
  {
    public e() {}
    
    public final com.tencent.mm.vending.g.c<Void> C(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(63465);
      paramString1 = com.tencent.mm.vending.g.g.f(paramString1, paramString2, paramString3).c(this);
      AppMethodBeat.o(63465);
      return paramString1;
    }
    
    public final String aKh()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class f
    implements e<Boolean, Void>
  {
    public f() {}
    
    public final String aKh()
    {
      return "Vending.LOGIC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.b.g
 * JD-Core Version:    0.7.0.1
 */