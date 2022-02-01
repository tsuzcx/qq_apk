package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseResApplyAdapterCoreLogic;", "", "()V", "cacheDir", "Lcom/tencent/mm/vfs/VFSFile;", "getCacheDir", "()Lcom/tencent/mm/vfs/VFSFile;", "cacheDir$delegate", "Lkotlin/Lazy;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
{
  private final j sPC = k.cm((a)a.uTQ);
  
  protected final com.tencent.mm.vfs.u cTD()
  {
    return (com.tencent.mm.vfs.u)this.sPC.getValue();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/vfs/VFSFile;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements a<com.tencent.mm.vfs.u>
  {
    public static final a uTQ;
    
    static
    {
      AppMethodBeat.i(317116);
      uTQ = new a();
      AppMethodBeat.o(317116);
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