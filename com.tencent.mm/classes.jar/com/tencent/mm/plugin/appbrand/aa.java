package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.d.a.b.a;
import com.tencent.mm.d.a.i;
import com.tencent.mm.d.a.i.a;
import com.tencent.mm.d.a.j;
import com.tencent.mm.plugin.appbrand.report.quality.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

class aa
  extends i
{
  static
  {
    if (!aa.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  aa(j paramj)
  {
    super(paramj);
  }
  
  protected final void a(com.tencent.mm.d.a.b paramb, i.a parama)
  {
    Object localObject;
    if ((parama instanceof aa.a))
    {
      localObject = ((aa.a)parama).fAD;
      if (!bk.bl((String)localObject))
      {
        y.i("MicroMsg.V8EngineWorkerManagerWC", "hy: %s has sourcemap", new Object[] { parama.filePath });
        paramb.a((String)localObject, null);
      }
    }
    y.i("MicroMsg.V8EngineWorkerManagerWC", "hy: evaluating %s", new Object[] { parama.filePath });
    if (!parama.filePath.endsWith("WAWorker.js")) {}
    for (int i = 0; i != 0; i = 1)
    {
      return;
      assert ((parama instanceof aa.a));
      localObject = (aa.a)parama;
      final long l = System.currentTimeMillis();
      paramb.a(parama.filePath, parama.script, new b.a()
      {
        public final void cB(String paramAnonymousString)
        {
          a.aov();
          com.tencent.mm.plugin.appbrand.report.quality.b.a(this.fAA.fAE, this.fAA.appId, l, "WAWorker.js", this.fAB.script.length());
        }
      });
    }
    paramb.a(parama.filePath, parama.script, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aa
 * JD-Core Version:    0.7.0.1
 */