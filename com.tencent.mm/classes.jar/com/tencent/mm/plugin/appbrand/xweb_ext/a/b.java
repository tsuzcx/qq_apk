package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseResApplyAdapterCoreLogic;", "", "()V", "cacheDir", "Lcom/tencent/mm/vfs/VFSFile;", "getCacheDir", "()Lcom/tencent/mm/vfs/VFSFile;", "cacheDir$delegate", "Lkotlin/Lazy;", "plugin-appbrand-integration_release"})
public abstract class b
{
  private final f mJQ = g.ah((a)a.oGL);
  
  protected final o cdJ()
  {
    return (o)this.mJQ.getValue();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/vfs/VFSFile;", "invoke"})
  static final class a
    extends q
    implements a<o>
  {
    public static final a oGL;
    
    static
    {
      AppMethodBeat.i(229710);
      oGL = new a();
      AppMethodBeat.o(229710);
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