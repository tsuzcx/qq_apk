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
  public final c mLA;
  public final b mLB;
  public final f mLC;
  protected f mLw;
  public final d mLx;
  public final a mLy;
  public final e mLz;
  
  public g()
  {
    this(new f());
    AppMethodBeat.i(63468);
    AppMethodBeat.o(63468);
  }
  
  private g(f paramf)
  {
    AppMethodBeat.i(63469);
    this.mLx = new d();
    this.mLy = new a();
    this.mLz = new e();
    this.mLA = new c();
    this.mLB = new b();
    this.mLC = new f();
    this.mLw = paramf;
    AppMethodBeat.o(63469);
  }
  
  public final class a
    implements e<s, com.tencent.mm.vending.j.c<Long, String>>
  {
    public a() {}
    
    public final String aqj()
    {
      return "Vending.LOGIC";
    }
    
    public final com.tencent.mm.vending.g.c<s> l(long paramLong, String paramString)
    {
      AppMethodBeat.i(275368);
      paramString = com.tencent.mm.vending.g.g.H(Long.valueOf(paramLong), paramString).c(this);
      AppMethodBeat.o(275368);
      return paramString;
    }
  }
  
  public final class b
    implements e<Boolean, Void>
  {
    public b() {}
    
    public final String aqj()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class c
    implements e<Void, d<Long, String, String>>
  {
    public c() {}
    
    public final String aqj()
    {
      return "Vending.LOGIC";
    }
    
    public final com.tencent.mm.vending.g.c<Void> b(long paramLong, String paramString1, String paramString2)
    {
      AppMethodBeat.i(63461);
      paramString1 = com.tencent.mm.vending.g.g.g(Long.valueOf(paramLong), paramString1, paramString2).c(this);
      AppMethodBeat.o(63461);
      return paramString1;
    }
  }
  
  public final class d
    implements e<z, Void>
  {
    public d() {}
    
    public final String aqj()
    {
      return "Vending.LOGIC";
    }
    
    public final com.tencent.mm.vending.g.c<z> bwy()
    {
      AppMethodBeat.i(63463);
      com.tencent.mm.vending.g.c localc = com.tencent.mm.vending.g.g.ieN().c(this);
      AppMethodBeat.o(63463);
      return localc;
    }
  }
  
  public final class e
    implements e<Void, d<String, String, String>>
  {
    public e() {}
    
    public final String aqj()
    {
      return "Vending.LOGIC";
    }
    
    public final com.tencent.mm.vending.g.c<Void> z(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(63465);
      paramString1 = com.tencent.mm.vending.g.g.g(paramString1, paramString2, paramString3).c(this);
      AppMethodBeat.o(63465);
      return paramString1;
    }
  }
  
  public final class f
    implements e<Boolean, Void>
  {
    public f() {}
    
    public final String aqj()
    {
      return "Vending.LOGIC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.b.g
 * JD-Core Version:    0.7.0.1
 */