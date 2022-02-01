package com.tencent.mm.plugin.appbrand.pip;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@com.tencent.mm.ipcinvoker.c.a
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/pip/StablePosTask;", "", "()V", "storage", "Lcom/tencent/mm/plugin/appbrand/pip/PipStablePosStorage;", "getStorage", "()Lcom/tencent/mm/plugin/appbrand/pip/PipStablePosStorage;", "storage$delegate", "Lkotlin/Lazy;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
abstract class r
{
  private final j sZg = k.cm((kotlin.g.a.a)a.tKT);
  
  protected final p cHM()
  {
    return (p)this.sZg.getValue();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/plugin/appbrand/pip/StablePosTask$storage$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<1>
  {
    public static final a tKT;
    
    static
    {
      AppMethodBeat.i(319593);
      tKT = new a();
      AppMethodBeat.o(319593);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.r
 * JD-Core Version:    0.7.0.1
 */