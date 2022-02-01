package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseResApplyAdapterCoreLogic;", "", "()V", "cacheDir", "Lcom/tencent/mm/vfs/VFSFile;", "getCacheDir", "()Lcom/tencent/mm/vfs/VFSFile;", "cacheDir$delegate", "Lkotlin/Lazy;", "plugin-appbrand-integration_release"})
public abstract class b
{
  private final f pKI = g.ar((a)a.rIB);
  
  protected final com.tencent.mm.vfs.q cqW()
  {
    return (com.tencent.mm.vfs.q)this.pKI.getValue();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/vfs/VFSFile;", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements a<com.tencent.mm.vfs.q>
  {
    public static final a rIB;
    
    static
    {
      AppMethodBeat.i(271176);
      rIB = new a();
      AppMethodBeat.o(271176);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.b
 * JD-Core Version:    0.7.0.1
 */