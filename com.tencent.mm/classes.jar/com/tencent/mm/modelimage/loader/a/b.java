package com.tencent.mm.modelimage.loader.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.b.g;
import com.tencent.mm.modelimage.loader.b.j;
import com.tencent.mm.modelimage.loader.b.l;
import com.tencent.mm.modelimage.loader.b.m;
import com.tencent.mm.modelimage.loader.b.o;
import com.tencent.mm.modelimage.loader.b.p;
import com.tencent.mm.modelimage.loader.impr.DefaultImageMemoryCacheListener;
import com.tencent.mm.modelimage.loader.impr.d;
import com.tencent.mm.modelimage.loader.impr.e;
import com.tencent.mm.modelimage.loader.impr.h;
import java.util.concurrent.Executor;

public final class b
{
  public static final int oJX;
  public final Resources oJY;
  public final int oJZ;
  public final int oKa;
  public final c oKb;
  public final o oKc;
  public final com.tencent.mm.modelimage.loader.b.b oKd;
  public final com.tencent.mm.modelimage.loader.b.c oKe;
  public final g oKf;
  public final l oKg;
  public final m oKh;
  public final com.tencent.mm.modelimage.loader.b.f oKi;
  public final j oKj;
  public final Executor oKk;
  public final p oKl;
  public final String packageName;
  
  static
  {
    AppMethodBeat.i(130400);
    oJX = Runtime.getRuntime().availableProcessors();
    AppMethodBeat.o(130400);
  }
  
  public b(a parama)
  {
    AppMethodBeat.i(130398);
    this.packageName = parama.context.getPackageName();
    this.oJY = parama.context.getResources();
    this.oJZ = parama.oJZ;
    this.oKa = parama.oKa;
    this.oKb = parama.oKb;
    this.oKc = parama.oKc;
    this.oKd = parama.oKd;
    this.oKe = parama.oKe;
    this.oKf = parama.oKf;
    this.oKg = parama.oKg;
    this.oKj = parama.oKj;
    this.oKk = parama.oKk;
    this.oKh = parama.oKm;
    this.oKi = parama.oKi;
    this.oKl = parama.oKl;
    AppMethodBeat.o(130398);
  }
  
  public static b dR(Context paramContext)
  {
    AppMethodBeat.i(130399);
    paramContext = new a(paramContext).bKn();
    AppMethodBeat.o(130399);
    return paramContext;
  }
  
  public static final class a
  {
    Context context;
    int oJZ;
    int oKa;
    c oKb;
    public o oKc;
    com.tencent.mm.modelimage.loader.b.b oKd;
    public com.tencent.mm.modelimage.loader.b.c oKe;
    g oKf;
    l oKg;
    com.tencent.mm.modelimage.loader.b.f oKi;
    public j oKj;
    Executor oKk;
    p oKl;
    m oKm;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(130395);
      this.oJZ = b.oJX;
      this.oKa = 5;
      this.oKb = null;
      this.oKc = null;
      this.oKd = null;
      this.oKe = null;
      this.oKf = null;
      this.oKg = null;
      this.oKm = null;
      this.oKi = null;
      this.oKl = null;
      this.oKj = null;
      this.context = paramContext.getApplicationContext();
      AppMethodBeat.o(130395);
    }
    
    private void bKo()
    {
      AppMethodBeat.i(130397);
      if (this.oKb == null) {
        this.oKb = c.bKp();
      }
      if (this.oKc == null) {
        this.oKc = new DefaultImageMemoryCacheListener();
      }
      if (this.oKd == null) {
        this.oKd = new com.tencent.mm.modelimage.loader.impr.a();
      }
      if (this.oKe == null) {
        this.oKe = new com.tencent.mm.modelimage.loader.impr.b();
      }
      if (this.oKf == null) {
        this.oKf = new d();
      }
      if (this.oKg == null) {
        this.oKg = new h();
      }
      if (this.oKj == null) {
        this.oKj = a.wA(this.oJZ);
      }
      if (this.oKk == null) {
        this.oKk = a.bKm();
      }
      if (this.oKm == null) {
        this.oKm = new e();
      }
      if (this.oKi == null) {
        this.oKi = new com.tencent.mm.modelimage.loader.impr.c();
      }
      if (this.oKl == null) {
        this.oKl = new com.tencent.mm.modelimage.loader.impr.f();
      }
      AppMethodBeat.o(130397);
    }
    
    public final b bKn()
    {
      AppMethodBeat.i(130396);
      bKo();
      b localb = new b(this);
      AppMethodBeat.o(130396);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelimage.loader.a.b
 * JD-Core Version:    0.7.0.1
 */