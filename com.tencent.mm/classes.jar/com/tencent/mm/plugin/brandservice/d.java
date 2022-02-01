package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tm;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class d
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private a obO;
  private com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b obP;
  
  static
  {
    AppMethodBeat.i(5562);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("BIZAPPMSGREPORTCCONTEXT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b.hGX;
      }
    });
    AppMethodBeat.o(5562);
  }
  
  private static d bOo()
  {
    AppMethodBeat.i(5558);
    d locald = (d)u.ap(d.class);
    AppMethodBeat.o(5558);
    return locald;
  }
  
  public static com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b bOp()
  {
    AppMethodBeat.i(5561);
    g.ajP().aiU();
    if (bOo().obP == null) {
      bOo().obP = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b(g.ajR().gDX);
    }
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b localb = bOo().obP;
    AppMethodBeat.o(5561);
    return localb;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(5559);
    ae.d("MicroMsg.BrandService.SubCoreBrandService", "on sub core brand service reset");
    if (this.obO == null) {
      this.obO = new a();
    }
    com.tencent.mm.sdk.b.a.IvT.c(this.obO);
    Object localObject = new com.tencent.mm.plugin.brandservice.ui.a.d();
    ((n)g.ad(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new com.tencent.mm.plugin.brandservice.ui.a.b();
    ((n)g.ad(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    AppMethodBeat.o(5559);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(5560);
    if (this.obO != null) {
      com.tencent.mm.sdk.b.a.IvT.d(this.obO);
    }
    ((n)g.ad(n.class)).unregisterFTSUILogic(96);
    ((n)g.ad(n.class)).unregisterFTSUILogic(4208);
    AppMethodBeat.o(5560);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public static final class a
    extends c<tm>
  {
    public a()
    {
      AppMethodBeat.i(160481);
      this.__eventId = tm.class.getName().hashCode();
      AppMethodBeat.o(160481);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.d
 * JD-Core Version:    0.7.0.1
 */