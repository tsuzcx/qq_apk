package com.tencent.mm.plugin.appbrand.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.m.b;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.appbrand.v8.v;
import com.tencent.mm.appbrand.v8.v.a;
import com.tencent.mm.appbrand.v8.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

class b
  extends v
{
  b(w paramw)
  {
    super(paramw);
  }
  
  public final void a(m paramm, final v.a parama)
  {
    AppMethodBeat.i(147756);
    if ((parama instanceof a))
    {
      String str = ((a)parama).nqb;
      if (!bt.isNullOrNil(str))
      {
        ad.i("MicroMsg.V8EngineWorkerManagerLU", "hy: %s has sourcemap", new Object[] { parama.filePath });
        paramm.a(str, null);
      }
    }
    ad.i("MicroMsg.V8EngineWorkerManagerLU", "hy: evaluating %s", new Object[] { parama.filePath });
    final long l = System.currentTimeMillis();
    paramm.a(parama.filePath, parama.script, new m.b()
    {
      public final void a(String paramAnonymousString, m.c paramAnonymousc)
      {
        AppMethodBeat.i(147755);
        System.currentTimeMillis();
        b.this.a(parama);
        AppMethodBeat.o(147755);
      }
    });
    AppMethodBeat.o(147756);
  }
  
  protected void a(v.a parama) {}
  
  static final class a
    extends v.a
  {
    String appId;
    String nqb;
    boolean nqc;
    
    a(v.a parama, String paramString1, String paramString2, boolean paramBoolean)
    {
      super(parama.script);
      this.nqb = paramString1;
      this.appId = paramString2;
      this.nqc = paramBoolean;
    }
    
    a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    {
      super(paramString2);
      this.nqb = null;
      this.appId = paramString3;
      this.nqc = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac.b
 * JD-Core Version:    0.7.0.1
 */