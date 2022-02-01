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
  public static final int hjD;
  public final Resources aHZ;
  public final int hjE;
  public final int hjF;
  public final c hjG;
  public final o hjH;
  public final com.tencent.mm.aw.a.c.b hjI;
  public final com.tencent.mm.aw.a.c.c hjJ;
  public final com.tencent.mm.aw.a.c.g hjK;
  public final l hjL;
  public final m hjM;
  public final com.tencent.mm.aw.a.c.f hjN;
  public final j hjO;
  public final Executor hjP;
  public final p hjQ;
  public final String packageName;
  
  static
  {
    AppMethodBeat.i(130400);
    hjD = Runtime.getRuntime().availableProcessors();
    AppMethodBeat.o(130400);
  }
  
  public b(a parama)
  {
    AppMethodBeat.i(130398);
    this.packageName = parama.context.getPackageName();
    this.aHZ = parama.context.getResources();
    this.hjE = parama.hjE;
    this.hjF = parama.hjF;
    this.hjG = parama.hjG;
    this.hjH = parama.hjH;
    this.hjI = parama.hjI;
    this.hjJ = parama.hjJ;
    this.hjK = parama.hjK;
    this.hjL = parama.hjL;
    this.hjO = parama.hjO;
    this.hjP = parama.hjP;
    this.hjM = parama.hjR;
    this.hjN = parama.hjN;
    this.hjQ = parama.hjQ;
    AppMethodBeat.o(130398);
  }
  
  public static b cx(Context paramContext)
  {
    AppMethodBeat.i(130399);
    paramContext = new a(paramContext).ayR();
    AppMethodBeat.o(130399);
    return paramContext;
  }
  
  public static final class a
  {
    Context context;
    int hjE;
    int hjF;
    c hjG;
    public o hjH;
    com.tencent.mm.aw.a.c.b hjI;
    public com.tencent.mm.aw.a.c.c hjJ;
    com.tencent.mm.aw.a.c.g hjK;
    l hjL;
    com.tencent.mm.aw.a.c.f hjN;
    public j hjO;
    Executor hjP;
    p hjQ;
    m hjR;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(130395);
      this.hjE = b.hjD;
      this.hjF = 5;
      this.hjG = null;
      this.hjH = null;
      this.hjI = null;
      this.hjJ = null;
      this.hjK = null;
      this.hjL = null;
      this.hjR = null;
      this.hjN = null;
      this.hjQ = null;
      this.hjO = null;
      this.context = paramContext.getApplicationContext();
      AppMethodBeat.o(130395);
    }
    
    private void ayS()
    {
      AppMethodBeat.i(130397);
      if (this.hjG == null) {
        this.hjG = c.ayT();
      }
      if (this.hjH == null) {
        this.hjH = new com.tencent.mm.aw.a.b.f();
      }
      if (this.hjI == null) {
        this.hjI = new com.tencent.mm.aw.a.b.a();
      }
      if (this.hjJ == null) {
        this.hjJ = new com.tencent.mm.aw.a.b.b();
      }
      if (this.hjK == null) {
        this.hjK = new d();
      }
      if (this.hjL == null) {
        this.hjL = new i();
      }
      if (this.hjO == null) {
        this.hjO = a.on(this.hjE);
      }
      if (this.hjP == null) {
        this.hjP = a.ayQ();
      }
      if (this.hjR == null) {
        this.hjR = new e();
      }
      if (this.hjN == null) {
        this.hjN = new com.tencent.mm.aw.a.b.c();
      }
      if (this.hjQ == null) {
        this.hjQ = new com.tencent.mm.aw.a.b.g();
      }
      AppMethodBeat.o(130397);
    }
    
    public final b ayR()
    {
      AppMethodBeat.i(130396);
      ayS();
      b localb = new b(this);
      AppMethodBeat.o(130396);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aw.a.a.b
 * JD-Core Version:    0.7.0.1
 */