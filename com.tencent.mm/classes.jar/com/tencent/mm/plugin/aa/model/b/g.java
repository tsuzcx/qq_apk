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
  protected f ibg;
  public final d ibh;
  public final a ibi;
  public final e ibj;
  public final c ibk;
  public final b ibl;
  public final f ibm;
  
  public g()
  {
    this(new f());
    AppMethodBeat.i(63468);
    AppMethodBeat.o(63468);
  }
  
  private g(f paramf)
  {
    AppMethodBeat.i(63469);
    this.ibh = new d();
    this.ibi = new a();
    this.ibj = new e();
    this.ibk = new c();
    this.ibl = new b();
    this.ibm = new f();
    this.ibg = paramf;
    AppMethodBeat.o(63469);
  }
  
  public final class a
    implements e<p, Long>
  {
    public a() {}
    
    public final String Tg()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class b
    implements e<Boolean, Void>
  {
    public b() {}
    
    public final String Tg()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class c
    implements e<Void, d<Long, String, String>>
  {
    public c() {}
    
    public final String Tg()
    {
      return "Vending.LOGIC";
    }
    
    public final c<Void> a(long paramLong, String paramString1, String paramString2)
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
    
    public final String Tg()
    {
      return "Vending.LOGIC";
    }
    
    public final c<w> aHm()
    {
      AppMethodBeat.i(63463);
      c localc = com.tencent.mm.vending.g.g.fhq().c(this);
      AppMethodBeat.o(63463);
      return localc;
    }
  }
  
  public final class e
    implements e<Void, d<String, String, String>>
  {
    public e() {}
    
    public final String Tg()
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
    
    public final String Tg()
    {
      return "Vending.LOGIC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.b.g
 * JD-Core Version:    0.7.0.1
 */