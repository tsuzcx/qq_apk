package com.tencent.mm.plugin.appbrand.pip;

import android.graphics.Point;
import com.tencent.luggage.a.b;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.d;
import com.tencent.mm.sdk.platformtools.ac;
import d.f;
import d.g;
import d.g.b.k;
import d.n.n;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/pip/StablePosTask;", "", "()V", "storage", "Lcom/tencent/mm/plugin/appbrand/pip/PipStablePosStorage;", "getStorage", "()Lcom/tencent/mm/plugin/appbrand/pip/PipStablePosStorage;", "storage$delegate", "Lkotlin/Lazy;", "plugin-appbrand-integration_release"})
abstract class q
{
  private final f lOA = g.K((d.g.a.a)a.lOB);
  
  protected final o bsD()
  {
    return (o)this.lOA.getValue();
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "com/tencent/mm/plugin/appbrand/pip/StablePosTask$storage$2$1", "invoke", "()Lcom/tencent/mm/plugin/appbrand/pip/StablePosTask$storage$2$1;"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<1>
  {
    public static final a lOB;
    
    static
    {
      AppMethodBeat.i(187374);
      lOB = new a();
      AppMethodBeat.o(187374);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.q
 * JD-Core Version:    0.7.0.1
 */