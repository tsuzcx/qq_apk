package com.tencent.mm.plugin.appbrand.game;

import com.tencent.magicbrush.handler.c;
import com.tencent.mm.plugin.appbrand.i.d;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.sdk.platformtools.y;

final class j$4
  implements c
{
  j$4(j paramj) {}
  
  public final void b(String paramString1, String paramString2, int paramInt)
  {
    y.e("MicroMsg.WAGameView", "hy: v8 exception! id is %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.gam.getRuntime() != null)
    {
      y.e("MicroMsg.WAGameView", "hy: v8_exception message = [%s], stackTrace = [%s]", new Object[] { paramString1, paramString2 });
      d locald = i.gad.kQ(paramInt);
      if (locald != null) {
        com.tencent.mm.plugin.appbrand.v.j.b(locald, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[] { com.tencent.mm.plugin.appbrand.v.i.wI(paramString1), com.tencent.mm.plugin.appbrand.v.i.wI(paramString2) }));
      }
    }
    else
    {
      return;
    }
    y.e("MicroMsg.WAGameView", "hy: not found js context!");
  }
  
  public final void onScreenCanvasContextTypeSet(boolean paramBoolean)
  {
    a locala = j.a(this.gam);
    if (paramBoolean) {}
    for (Object localObject = a.a.fZE;; localObject = a.a.fZF)
    {
      locala.fZD = ((a.a)localObject);
      localObject = com.tencent.mm.plugin.appbrand.report.quality.a.wg(j.b(this.gam).mAppId);
      if (localObject != null) {
        break;
      }
      return;
    }
    ((QualitySessionRuntime)localObject).hav.fZD = j.a(this.gam).fZD;
  }
  
  public final void onShaderCompileError(String paramString)
  {
    y.e("MicroMsg.WAGameView", "hy: onShaderCompileError: %s", new Object[] { paramString });
    j.tq(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.j.4
 * JD-Core Version:    0.7.0.1
 */