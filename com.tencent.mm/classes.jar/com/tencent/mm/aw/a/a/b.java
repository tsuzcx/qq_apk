package com.tencent.mm.aw.a.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.b.d;
import com.tencent.mm.aw.a.b.e;
import com.tencent.mm.aw.a.b.i;
import com.tencent.mm.aw.a.c.j;
import com.tencent.mm.aw.a.c.l;
import com.tencent.mm.aw.a.c.m;
import com.tencent.mm.aw.a.c.o;
import com.tencent.mm.aw.a.c.p;
import java.util.concurrent.Executor;

public final class b
{
  public static final int ida;
  public final Resources aKG;
  public final int idb;
  public final int idc;
  public final c idd;
  public final o ide;
  public final com.tencent.mm.aw.a.c.b idf;
  public final com.tencent.mm.aw.a.c.c idg;
  public final com.tencent.mm.aw.a.c.g idh;
  public final l idi;
  public final m idj;
  public final com.tencent.mm.aw.a.c.f idk;
  public final j idl;
  public final Executor idm;
  public final p idn;
  public final String packageName;
  
  static
  {
    AppMethodBeat.i(130400);
    ida = Runtime.getRuntime().availableProcessors();
    AppMethodBeat.o(130400);
  }
  
  public b(a parama)
  {
    AppMethodBeat.i(130398);
    this.packageName = parama.context.getPackageName();
    this.aKG = parama.context.getResources();
    this.idb = parama.idb;
    this.idc = parama.idc;
    this.idd = parama.idd;
    this.ide = parama.ide;
    this.idf = parama.idf;
    this.idg = parama.idg;
    this.idh = parama.idh;
    this.idi = parama.idi;
    this.idl = parama.idl;
    this.idm = parama.idm;
    this.idj = parama.ido;
    this.idk = parama.idk;
    this.idn = parama.idn;
    AppMethodBeat.o(130398);
  }
  
  public static b cD(Context paramContext)
  {
    AppMethodBeat.i(130399);
    paramContext = new a(paramContext).aIR();
    AppMethodBeat.o(130399);
    return paramContext;
  }
  
  public static final class a
  {
    Context context;
    int idb;
    int idc;
    c idd;
    public o ide;
    com.tencent.mm.aw.a.c.b idf;
    public com.tencent.mm.aw.a.c.c idg;
    com.tencent.mm.aw.a.c.g idh;
    l idi;
    com.tencent.mm.aw.a.c.f idk;
    public j idl;
    Executor idm;
    p idn;
    m ido;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(130395);
      this.idb = b.ida;
      this.idc = 5;
      this.idd = null;
      this.ide = null;
      this.idf = null;
      this.idg = null;
      this.idh = null;
      this.idi = null;
      this.ido = null;
      this.idk = null;
      this.idn = null;
      this.idl = null;
      this.context = paramContext.getApplicationContext();
      AppMethodBeat.o(130395);
    }
    
    private void aIS()
    {
      AppMethodBeat.i(130397);
      if (this.idd == null) {
        this.idd = c.aIT();
      }
      if (this.ide == null) {
        this.ide = new com.tencent.mm.aw.a.b.f();
      }
      if (this.idf == null) {
        this.idf = new com.tencent.mm.aw.a.b.a();
      }
      if (this.idg == null) {
        this.idg = new com.tencent.mm.aw.a.b.b();
      }
      if (this.idh == null) {
        this.idh = new d();
      }
      if (this.idi == null) {
        this.idi = new i();
      }
      if (this.idl == null) {
        this.idl = a.pE(this.idb);
      }
      if (this.idm == null) {
        this.idm = a.aIQ();
      }
      if (this.ido == null) {
        this.ido = new e();
      }
      if (this.idk == null) {
        this.idk = new com.tencent.mm.aw.a.b.c();
      }
      if (this.idn == null) {
        this.idn = new com.tencent.mm.aw.a.b.g();
      }
      AppMethodBeat.o(130397);
    }
    
    public final b aIR()
    {
      AppMethodBeat.i(130396);
      aIS();
      b localb = new b(this);
      AppMethodBeat.o(130396);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aw.a.a.b
 * JD-Core Version:    0.7.0.1
 */