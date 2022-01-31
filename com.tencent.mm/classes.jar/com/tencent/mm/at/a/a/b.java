package com.tencent.mm.at.a.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.b.g;
import com.tencent.mm.at.a.b.i;
import com.tencent.mm.at.a.c.h;
import com.tencent.mm.at.a.c.j;
import com.tencent.mm.at.a.c.k;
import com.tencent.mm.at.a.c.m;
import com.tencent.mm.at.a.c.n;
import java.util.concurrent.Executor;

public final class b
{
  public static final int fHe;
  public final Resources eTW;
  public final int fHf;
  public final int fHg;
  public final c fHh;
  public final m fHi;
  public final com.tencent.mm.at.a.c.a fHj;
  public final com.tencent.mm.at.a.c.b fHk;
  public final com.tencent.mm.at.a.c.f fHl;
  public final j fHm;
  public final k fHn;
  public final com.tencent.mm.at.a.c.e fHo;
  public final h fHp;
  public final Executor fHq;
  public final n fHr;
  public final String packageName;
  
  static
  {
    AppMethodBeat.i(116071);
    fHe = Runtime.getRuntime().availableProcessors();
    AppMethodBeat.o(116071);
  }
  
  public b(a parama)
  {
    AppMethodBeat.i(116069);
    this.packageName = parama.context.getPackageName();
    this.eTW = parama.context.getResources();
    this.fHf = parama.fHf;
    this.fHg = parama.fHg;
    this.fHh = parama.fHh;
    this.fHi = parama.fHi;
    this.fHj = parama.fHj;
    this.fHk = parama.fHk;
    this.fHl = parama.fHl;
    this.fHm = parama.fHm;
    this.fHp = parama.fHp;
    this.fHq = parama.fHq;
    this.fHn = parama.fHs;
    this.fHo = parama.fHo;
    this.fHr = parama.fHr;
    AppMethodBeat.o(116069);
  }
  
  public static b ce(Context paramContext)
  {
    AppMethodBeat.i(116070);
    paramContext = new a(paramContext).ahO();
    AppMethodBeat.o(116070);
    return paramContext;
  }
  
  public static final class a
  {
    Context context;
    int fHf;
    int fHg;
    c fHh;
    public m fHi;
    com.tencent.mm.at.a.c.a fHj;
    public com.tencent.mm.at.a.c.b fHk;
    com.tencent.mm.at.a.c.f fHl;
    j fHm;
    com.tencent.mm.at.a.c.e fHo;
    public h fHp;
    Executor fHq;
    n fHr;
    k fHs;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(116066);
      this.fHf = b.fHe;
      this.fHg = 5;
      this.fHh = null;
      this.fHi = null;
      this.fHj = null;
      this.fHk = null;
      this.fHl = null;
      this.fHm = null;
      this.fHs = null;
      this.fHo = null;
      this.fHr = null;
      this.fHp = null;
      this.context = paramContext.getApplicationContext();
      AppMethodBeat.o(116066);
    }
    
    private void ahP()
    {
      AppMethodBeat.i(116068);
      if (this.fHh == null) {
        this.fHh = c.ahQ();
      }
      if (this.fHi == null) {
        this.fHi = new com.tencent.mm.at.a.b.f();
      }
      if (this.fHj == null) {
        this.fHj = new com.tencent.mm.at.a.b.a();
      }
      if (this.fHk == null) {
        this.fHk = new com.tencent.mm.at.a.b.b();
      }
      if (this.fHl == null) {
        this.fHl = new com.tencent.mm.at.a.b.d();
      }
      if (this.fHm == null) {
        this.fHm = new i();
      }
      if (this.fHp == null) {
        this.fHp = a.cw(this.fHf, this.fHg);
      }
      if (this.fHq == null) {
        this.fHq = com.tencent.mm.sdk.g.c.d.aqx("image_loader_ImageTempFile");
      }
      if (this.fHs == null) {
        this.fHs = new com.tencent.mm.at.a.b.e();
      }
      if (this.fHo == null) {
        this.fHo = new com.tencent.mm.at.a.b.c();
      }
      if (this.fHr == null) {
        this.fHr = new g();
      }
      AppMethodBeat.o(116068);
    }
    
    public final b ahO()
    {
      AppMethodBeat.i(116067);
      ahP();
      b localb = new b(this);
      AppMethodBeat.o(116067);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.at.a.a.b
 * JD-Core Version:    0.7.0.1
 */