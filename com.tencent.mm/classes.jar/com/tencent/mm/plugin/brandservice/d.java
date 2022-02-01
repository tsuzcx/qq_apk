package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.su;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class d
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private a nuH;
  private com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b nuI;
  
  static
  {
    AppMethodBeat.i(5562);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("BIZAPPMSGREPORTCCONTEXT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b.hlS;
      }
    });
    AppMethodBeat.o(5562);
  }
  
  private static d bIX()
  {
    AppMethodBeat.i(5558);
    d locald = (d)t.ap(d.class);
    AppMethodBeat.o(5558);
    return locald;
  }
  
  public static com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b bIY()
  {
    AppMethodBeat.i(5561);
    g.agP().afT();
    if (bIX().nuI == null) {
      bIX().nuI = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b(g.agR().ghG);
    }
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b localb = bIX().nuI;
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
    ac.d("MicroMsg.BrandService.SubCoreBrandService", "on sub core brand service reset");
    if (this.nuH == null) {
      this.nuH = new a();
    }
    com.tencent.mm.sdk.b.a.GpY.c(this.nuH);
    Object localObject = new com.tencent.mm.plugin.brandservice.ui.a.d();
    ((n)g.ad(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new com.tencent.mm.plugin.brandservice.ui.a.b();
    ((n)g.ad(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    AppMethodBeat.o(5559);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(5560);
    if (this.nuH != null) {
      com.tencent.mm.sdk.b.a.GpY.d(this.nuH);
    }
    ((n)g.ad(n.class)).unregisterFTSUILogic(96);
    ((n)g.ad(n.class)).unregisterFTSUILogic(4208);
    AppMethodBeat.o(5560);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public static final class a
    extends c<su>
  {
    public a()
    {
      AppMethodBeat.i(160481);
      this.__eventId = su.class.getName().hashCode();
      AppMethodBeat.o(160481);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.d
 * JD-Core Version:    0.7.0.1
 */