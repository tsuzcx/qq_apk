package com.tencent.mm.plugin.appbrand.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a.l;
import com.tencent.mm.d.a.t;
import com.tencent.mm.d.a.t.a;
import com.tencent.mm.d.a.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

class b
  extends t
{
  b(u paramu)
  {
    super(paramu);
  }
  
  public final void a(l paraml, t.a parama)
  {
    AppMethodBeat.i(140991);
    if ((parama instanceof a))
    {
      String str = ((a)parama).jxn;
      if (!bo.isNullOrNil(str))
      {
        ab.i("MicroMsg.V8EngineWorkerManagerLU", "hy: %s has sourcemap", new Object[] { parama.filePath });
        paraml.a(str, null);
      }
    }
    ab.i("MicroMsg.V8EngineWorkerManagerLU", "hy: evaluating %s", new Object[] { parama.filePath });
    long l = System.currentTimeMillis();
    paraml.a(parama.filePath, parama.script, new b.1(this, parama, l));
    AppMethodBeat.o(140991);
  }
  
  protected void a(t.a parama, long paramLong) {}
  
  static final class a
    extends t.a
  {
    String appId;
    String jxn;
    boolean jxo;
    
    a(t.a parama, String paramString1, String paramString2, boolean paramBoolean)
    {
      super(parama.script);
      this.jxn = paramString1;
      this.appId = paramString2;
      this.jxo = paramBoolean;
    }
    
    a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    {
      super(paramString2);
      this.jxn = null;
      this.appId = paramString3;
      this.jxo = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.b
 * JD-Core Version:    0.7.0.1
 */