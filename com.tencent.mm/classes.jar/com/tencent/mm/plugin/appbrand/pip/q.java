package com.tencent.mm.plugin.appbrand.pip;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.config.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@com.tencent.mm.ipcinvoker.c.a
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/pip/StablePosTask;", "", "()V", "storage", "Lcom/tencent/mm/plugin/appbrand/pip/PipStablePosStorage;", "getStorage", "()Lcom/tencent/mm/plugin/appbrand/pip/PipStablePosStorage;", "storage$delegate", "Lkotlin/Lazy;", "plugin-appbrand-integration_release"})
abstract class q
{
  private final f pTX = g.ar((kotlin.g.a.a)a.qGh);
  
  protected final o cgO()
  {
    return (o)this.pTX.getValue();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "com/tencent/mm/plugin/appbrand/pip/StablePosTask$storage$2$1", "invoke", "()Lcom/tencent/mm/plugin/appbrand/pip/StablePosTask$storage$2$1;"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<1>
  {
    public static final a qGh;
    
    static
    {
      AppMethodBeat.i(279843);
      qGh = new a();
      AppMethodBeat.o(279843);
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