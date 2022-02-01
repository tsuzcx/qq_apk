package com.tencent.mm.ay.a.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.b.d;
import com.tencent.mm.ay.a.b.e;
import com.tencent.mm.ay.a.b.i;
import com.tencent.mm.ay.a.c.j;
import com.tencent.mm.ay.a.c.l;
import com.tencent.mm.ay.a.c.m;
import com.tencent.mm.ay.a.c.o;
import com.tencent.mm.ay.a.c.p;
import java.util.concurrent.Executor;

public final class b
{
  public static final int lRl;
  public final Resources lRm;
  public final int lRn;
  public final int lRo;
  public final c lRp;
  public final o lRq;
  public final com.tencent.mm.ay.a.c.b lRr;
  public final com.tencent.mm.ay.a.c.c lRs;
  public final com.tencent.mm.ay.a.c.g lRt;
  public final l lRu;
  public final m lRv;
  public final com.tencent.mm.ay.a.c.f lRw;
  public final j lRx;
  public final Executor lRy;
  public final p lRz;
  public final String packageName;
  
  static
  {
    AppMethodBeat.i(130400);
    lRl = Runtime.getRuntime().availableProcessors();
    AppMethodBeat.o(130400);
  }
  
  public b(a parama)
  {
    AppMethodBeat.i(130398);
    this.packageName = parama.context.getPackageName();
    this.lRm = parama.context.getResources();
    this.lRn = parama.lRn;
    this.lRo = parama.lRo;
    this.lRp = parama.lRp;
    this.lRq = parama.lRq;
    this.lRr = parama.lRr;
    this.lRs = parama.lRs;
    this.lRt = parama.lRt;
    this.lRu = parama.lRu;
    this.lRx = parama.lRx;
    this.lRy = parama.lRy;
    this.lRv = parama.lRA;
    this.lRw = parama.lRw;
    this.lRz = parama.lRz;
    AppMethodBeat.o(130398);
  }
  
  public static b cY(Context paramContext)
  {
    AppMethodBeat.i(130399);
    paramContext = new a(paramContext).bmu();
    AppMethodBeat.o(130399);
    return paramContext;
  }
  
  public static final class a
  {
    Context context;
    m lRA;
    int lRn;
    int lRo;
    c lRp;
    public o lRq;
    com.tencent.mm.ay.a.c.b lRr;
    public com.tencent.mm.ay.a.c.c lRs;
    com.tencent.mm.ay.a.c.g lRt;
    l lRu;
    com.tencent.mm.ay.a.c.f lRw;
    public j lRx;
    Executor lRy;
    p lRz;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(130395);
      this.lRn = b.lRl;
      this.lRo = 5;
      this.lRp = null;
      this.lRq = null;
      this.lRr = null;
      this.lRs = null;
      this.lRt = null;
      this.lRu = null;
      this.lRA = null;
      this.lRw = null;
      this.lRz = null;
      this.lRx = null;
      this.context = paramContext.getApplicationContext();
      AppMethodBeat.o(130395);
    }
    
    private void bmv()
    {
      AppMethodBeat.i(130397);
      if (this.lRp == null) {
        this.lRp = c.bmw();
      }
      if (this.lRq == null) {
        this.lRq = new com.tencent.mm.ay.a.b.f();
      }
      if (this.lRr == null) {
        this.lRr = new com.tencent.mm.ay.a.b.a();
      }
      if (this.lRs == null) {
        this.lRs = new com.tencent.mm.ay.a.b.b();
      }
      if (this.lRt == null) {
        this.lRt = new d();
      }
      if (this.lRu == null) {
        this.lRu = new i();
      }
      if (this.lRx == null) {
        this.lRx = a.wv(this.lRn);
      }
      if (this.lRy == null) {
        this.lRy = a.bmt();
      }
      if (this.lRA == null) {
        this.lRA = new e();
      }
      if (this.lRw == null) {
        this.lRw = new com.tencent.mm.ay.a.b.c();
      }
      if (this.lRz == null) {
        this.lRz = new com.tencent.mm.ay.a.b.g();
      }
      AppMethodBeat.o(130397);
    }
    
    public final b bmu()
    {
      AppMethodBeat.i(130396);
      bmv();
      b localb = new b(this);
      AppMethodBeat.o(130396);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ay.a.a.b
 * JD-Core Version:    0.7.0.1
 */