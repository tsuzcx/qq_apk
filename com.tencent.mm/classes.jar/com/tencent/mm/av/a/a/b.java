package com.tencent.mm.av.a.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.b.d;
import com.tencent.mm.av.a.b.e;
import com.tencent.mm.av.a.b.i;
import com.tencent.mm.av.a.c.j;
import com.tencent.mm.av.a.c.l;
import com.tencent.mm.av.a.c.m;
import com.tencent.mm.av.a.c.o;
import com.tencent.mm.av.a.c.p;
import java.util.concurrent.Executor;

public final class b
{
  public static final int jaO;
  public final Resources aKy;
  public final int jaP;
  public final int jaQ;
  public final c jaR;
  public final o jaS;
  public final com.tencent.mm.av.a.c.b jaT;
  public final com.tencent.mm.av.a.c.c jaU;
  public final com.tencent.mm.av.a.c.g jaV;
  public final l jaW;
  public final m jaX;
  public final com.tencent.mm.av.a.c.f jaY;
  public final j jaZ;
  public final Executor jba;
  public final p jbb;
  public final String packageName;
  
  static
  {
    AppMethodBeat.i(130400);
    jaO = Runtime.getRuntime().availableProcessors();
    AppMethodBeat.o(130400);
  }
  
  public b(a parama)
  {
    AppMethodBeat.i(130398);
    this.packageName = parama.context.getPackageName();
    this.aKy = parama.context.getResources();
    this.jaP = parama.jaP;
    this.jaQ = parama.jaQ;
    this.jaR = parama.jaR;
    this.jaS = parama.jaS;
    this.jaT = parama.jaT;
    this.jaU = parama.jaU;
    this.jaV = parama.jaV;
    this.jaW = parama.jaW;
    this.jaZ = parama.jaZ;
    this.jba = parama.jba;
    this.jaX = parama.jbc;
    this.jaY = parama.jaY;
    this.jbb = parama.jbb;
    AppMethodBeat.o(130398);
  }
  
  public static b db(Context paramContext)
  {
    AppMethodBeat.i(130399);
    paramContext = new a(paramContext).bdd();
    AppMethodBeat.o(130399);
    return paramContext;
  }
  
  public static final class a
  {
    Context context;
    int jaP;
    int jaQ;
    c jaR;
    public o jaS;
    com.tencent.mm.av.a.c.b jaT;
    public com.tencent.mm.av.a.c.c jaU;
    com.tencent.mm.av.a.c.g jaV;
    l jaW;
    com.tencent.mm.av.a.c.f jaY;
    public j jaZ;
    Executor jba;
    p jbb;
    m jbc;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(130395);
      this.jaP = b.jaO;
      this.jaQ = 5;
      this.jaR = null;
      this.jaS = null;
      this.jaT = null;
      this.jaU = null;
      this.jaV = null;
      this.jaW = null;
      this.jbc = null;
      this.jaY = null;
      this.jbb = null;
      this.jaZ = null;
      this.context = paramContext.getApplicationContext();
      AppMethodBeat.o(130395);
    }
    
    private void bde()
    {
      AppMethodBeat.i(130397);
      if (this.jaR == null) {
        this.jaR = c.bdf();
      }
      if (this.jaS == null) {
        this.jaS = new com.tencent.mm.av.a.b.f();
      }
      if (this.jaT == null) {
        this.jaT = new com.tencent.mm.av.a.b.a();
      }
      if (this.jaU == null) {
        this.jaU = new com.tencent.mm.av.a.b.b();
      }
      if (this.jaV == null) {
        this.jaV = new d();
      }
      if (this.jaW == null) {
        this.jaW = new i();
      }
      if (this.jaZ == null) {
        this.jaZ = a.tv(this.jaP);
      }
      if (this.jba == null) {
        this.jba = a.bdc();
      }
      if (this.jbc == null) {
        this.jbc = new e();
      }
      if (this.jaY == null) {
        this.jaY = new com.tencent.mm.av.a.b.c();
      }
      if (this.jbb == null) {
        this.jbb = new com.tencent.mm.av.a.b.g();
      }
      AppMethodBeat.o(130397);
    }
    
    public final b bdd()
    {
      AppMethodBeat.i(130396);
      bde();
      b localb = new b(this);
      AppMethodBeat.o(130396);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.av.a.a.b
 * JD-Core Version:    0.7.0.1
 */