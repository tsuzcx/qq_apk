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
  public static final int ifT;
  public final Resources aKG;
  public final int ifU;
  public final int ifV;
  public final c ifW;
  public final o ifX;
  public final com.tencent.mm.av.a.c.b ifY;
  public final com.tencent.mm.av.a.c.c ifZ;
  public final com.tencent.mm.av.a.c.g iga;
  public final l igb;
  public final m igc;
  public final com.tencent.mm.av.a.c.f igd;
  public final j ige;
  public final Executor igf;
  public final p igg;
  public final String packageName;
  
  static
  {
    AppMethodBeat.i(130400);
    ifT = Runtime.getRuntime().availableProcessors();
    AppMethodBeat.o(130400);
  }
  
  public b(a parama)
  {
    AppMethodBeat.i(130398);
    this.packageName = parama.context.getPackageName();
    this.aKG = parama.context.getResources();
    this.ifU = parama.ifU;
    this.ifV = parama.ifV;
    this.ifW = parama.ifW;
    this.ifX = parama.ifX;
    this.ifY = parama.ifY;
    this.ifZ = parama.ifZ;
    this.iga = parama.iga;
    this.igb = parama.igb;
    this.ige = parama.ige;
    this.igf = parama.igf;
    this.igc = parama.igh;
    this.igd = parama.igd;
    this.igg = parama.igg;
    AppMethodBeat.o(130398);
  }
  
  public static b cF(Context paramContext)
  {
    AppMethodBeat.i(130399);
    paramContext = new a(paramContext).aJj();
    AppMethodBeat.o(130399);
    return paramContext;
  }
  
  public static final class a
  {
    Context context;
    int ifU;
    int ifV;
    c ifW;
    public o ifX;
    com.tencent.mm.av.a.c.b ifY;
    public com.tencent.mm.av.a.c.c ifZ;
    com.tencent.mm.av.a.c.g iga;
    l igb;
    com.tencent.mm.av.a.c.f igd;
    public j ige;
    Executor igf;
    p igg;
    m igh;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(130395);
      this.ifU = b.ifT;
      this.ifV = 5;
      this.ifW = null;
      this.ifX = null;
      this.ifY = null;
      this.ifZ = null;
      this.iga = null;
      this.igb = null;
      this.igh = null;
      this.igd = null;
      this.igg = null;
      this.ige = null;
      this.context = paramContext.getApplicationContext();
      AppMethodBeat.o(130395);
    }
    
    private void aJk()
    {
      AppMethodBeat.i(130397);
      if (this.ifW == null) {
        this.ifW = c.aJl();
      }
      if (this.ifX == null) {
        this.ifX = new com.tencent.mm.av.a.b.f();
      }
      if (this.ifY == null) {
        this.ifY = new com.tencent.mm.av.a.b.a();
      }
      if (this.ifZ == null) {
        this.ifZ = new com.tencent.mm.av.a.b.b();
      }
      if (this.iga == null) {
        this.iga = new d();
      }
      if (this.igb == null) {
        this.igb = new i();
      }
      if (this.ige == null) {
        this.ige = a.pH(this.ifU);
      }
      if (this.igf == null) {
        this.igf = a.aJi();
      }
      if (this.igh == null) {
        this.igh = new e();
      }
      if (this.igd == null) {
        this.igd = new com.tencent.mm.av.a.b.c();
      }
      if (this.igg == null) {
        this.igg = new com.tencent.mm.av.a.b.g();
      }
      AppMethodBeat.o(130397);
    }
    
    public final b aJj()
    {
      AppMethodBeat.i(130396);
      aJk();
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