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
  public static final int hKg;
  public final Resources aIP;
  public final int hKh;
  public final int hKi;
  public final c hKj;
  public final o hKk;
  public final com.tencent.mm.av.a.c.b hKl;
  public final com.tencent.mm.av.a.c.c hKm;
  public final com.tencent.mm.av.a.c.g hKn;
  public final l hKo;
  public final m hKp;
  public final com.tencent.mm.av.a.c.f hKq;
  public final j hKr;
  public final Executor hKs;
  public final p hKt;
  public final String packageName;
  
  static
  {
    AppMethodBeat.i(130400);
    hKg = Runtime.getRuntime().availableProcessors();
    AppMethodBeat.o(130400);
  }
  
  public b(a parama)
  {
    AppMethodBeat.i(130398);
    this.packageName = parama.context.getPackageName();
    this.aIP = parama.context.getResources();
    this.hKh = parama.hKh;
    this.hKi = parama.hKi;
    this.hKj = parama.hKj;
    this.hKk = parama.hKk;
    this.hKl = parama.hKl;
    this.hKm = parama.hKm;
    this.hKn = parama.hKn;
    this.hKo = parama.hKo;
    this.hKr = parama.hKr;
    this.hKs = parama.hKs;
    this.hKp = parama.hKu;
    this.hKq = parama.hKq;
    this.hKt = parama.hKt;
    AppMethodBeat.o(130398);
  }
  
  public static b cG(Context paramContext)
  {
    AppMethodBeat.i(130399);
    paramContext = new a(paramContext).aFI();
    AppMethodBeat.o(130399);
    return paramContext;
  }
  
  public static final class a
  {
    Context context;
    int hKh;
    int hKi;
    c hKj;
    public o hKk;
    com.tencent.mm.av.a.c.b hKl;
    public com.tencent.mm.av.a.c.c hKm;
    com.tencent.mm.av.a.c.g hKn;
    l hKo;
    com.tencent.mm.av.a.c.f hKq;
    public j hKr;
    Executor hKs;
    p hKt;
    m hKu;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(130395);
      this.hKh = b.hKg;
      this.hKi = 5;
      this.hKj = null;
      this.hKk = null;
      this.hKl = null;
      this.hKm = null;
      this.hKn = null;
      this.hKo = null;
      this.hKu = null;
      this.hKq = null;
      this.hKt = null;
      this.hKr = null;
      this.context = paramContext.getApplicationContext();
      AppMethodBeat.o(130395);
    }
    
    private void aFJ()
    {
      AppMethodBeat.i(130397);
      if (this.hKj == null) {
        this.hKj = c.aFK();
      }
      if (this.hKk == null) {
        this.hKk = new com.tencent.mm.av.a.b.f();
      }
      if (this.hKl == null) {
        this.hKl = new com.tencent.mm.av.a.b.a();
      }
      if (this.hKm == null) {
        this.hKm = new com.tencent.mm.av.a.b.b();
      }
      if (this.hKn == null) {
        this.hKn = new d();
      }
      if (this.hKo == null) {
        this.hKo = new i();
      }
      if (this.hKr == null) {
        this.hKr = a.pb(this.hKh);
      }
      if (this.hKs == null) {
        this.hKs = a.aFH();
      }
      if (this.hKu == null) {
        this.hKu = new e();
      }
      if (this.hKq == null) {
        this.hKq = new com.tencent.mm.av.a.b.c();
      }
      if (this.hKt == null) {
        this.hKt = new com.tencent.mm.av.a.b.g();
      }
      AppMethodBeat.o(130397);
    }
    
    public final b aFI()
    {
      AppMethodBeat.i(130396);
      aFJ();
      b localb = new b(this);
      AppMethodBeat.o(130396);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.av.a.a.b
 * JD-Core Version:    0.7.0.1
 */