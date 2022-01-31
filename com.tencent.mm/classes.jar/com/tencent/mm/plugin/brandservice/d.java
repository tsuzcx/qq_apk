package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public class d
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private d.a jSI;
  private com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b jSJ;
  
  static
  {
    AppMethodBeat.i(13821);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("BIZAPPMSGREPORTCCONTEXT_TABLE".hashCode()), new d.1());
    AppMethodBeat.o(13821);
  }
  
  private static d aWp()
  {
    AppMethodBeat.i(13817);
    d locald = (d)q.S(d.class);
    AppMethodBeat.o(13817);
    return locald;
  }
  
  public static com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b aWq()
  {
    AppMethodBeat.i(13820);
    g.RJ().QQ();
    if (aWp().jSJ == null) {
      aWp().jSJ = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b(g.RL().eHS);
    }
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b localb = aWp().jSJ;
    AppMethodBeat.o(13820);
    return localb;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(13818);
    ab.d("MicroMsg.BrandService.SubCoreBrandService", "on sub core brand service reset");
    if (this.jSI == null) {
      this.jSI = new d.a();
    }
    com.tencent.mm.sdk.b.a.ymk.c(this.jSI);
    Object localObject = new com.tencent.mm.plugin.brandservice.ui.a.d();
    ((n)g.G(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new com.tencent.mm.plugin.brandservice.ui.a.b();
    ((n)g.G(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    AppMethodBeat.o(13818);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(13819);
    if (this.jSI != null) {
      com.tencent.mm.sdk.b.a.ymk.d(this.jSI);
    }
    ((n)g.G(n.class)).unregisterFTSUILogic(96);
    ((n)g.G(n.class)).unregisterFTSUILogic(4208);
    AppMethodBeat.o(13819);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.d
 * JD-Core Version:    0.7.0.1
 */