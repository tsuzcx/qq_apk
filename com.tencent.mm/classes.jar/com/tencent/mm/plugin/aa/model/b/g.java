package com.tencent.mm.plugin.aa.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.r;
import com.tencent.mm.protocal.protobuf.y;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public class g
  implements b<f>
{
  protected f jUj;
  public final d jUk;
  public final a jUl;
  public final e jUm;
  public final c jUn;
  public final b jUo;
  public final f jUp;
  
  public g()
  {
    this(new f());
    AppMethodBeat.i(63468);
    AppMethodBeat.o(63468);
  }
  
  private g(f paramf)
  {
    AppMethodBeat.i(63469);
    this.jUk = new d();
    this.jUl = new a();
    this.jUm = new e();
    this.jUn = new c();
    this.jUo = new b();
    this.jUp = new f();
    this.jUj = paramf;
    AppMethodBeat.o(63469);
  }
  
  public final class a
    implements e<r, com.tencent.mm.vending.j.c<Long, String>>
  {
    public a() {}
    
    public final String akn()
    {
      return "Vending.LOGIC";
    }
    
    public final com.tencent.mm.vending.g.c<r> j(long paramLong, String paramString)
    {
      AppMethodBeat.i(212951);
      paramString = com.tencent.mm.vending.g.g.O(Long.valueOf(paramLong), paramString).c(this);
      AppMethodBeat.o(212951);
      return paramString;
    }
  }
  
  public final class b
    implements e<Boolean, Void>
  {
    public b() {}
    
    public final String akn()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class c
    implements e<Void, d<Long, String, String>>
  {
    public c() {}
    
    public final String akn()
    {
      return "Vending.LOGIC";
    }
    
    public final com.tencent.mm.vending.g.c<Void> b(long paramLong, String paramString1, String paramString2)
    {
      AppMethodBeat.i(63461);
      paramString1 = com.tencent.mm.vending.g.g.h(Long.valueOf(paramLong), paramString1, paramString2).c(this);
      AppMethodBeat.o(63461);
      return paramString1;
    }
  }
  
  public final class d
    implements e<y, Void>
  {
    public d() {}
    
    public final String akn()
    {
      return "Vending.LOGIC";
    }
    
    public final com.tencent.mm.vending.g.c<y> bmq()
    {
      AppMethodBeat.i(63463);
      com.tencent.mm.vending.g.c localc = com.tencent.mm.vending.g.g.hdG().c(this);
      AppMethodBeat.o(63463);
      return localc;
    }
  }
  
  public final class e
    implements e<Void, d<String, String, String>>
  {
    public e() {}
    
    public final String akn()
    {
      return "Vending.LOGIC";
    }
    
    public final com.tencent.mm.vending.g.c<Void> w(String paramString1, String paramString2, String paramString3)
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
    
    public final String akn()
    {
      return "Vending.LOGIC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.b.g
 * JD-Core Version:    0.7.0.1
 */