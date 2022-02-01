package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sl;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class d
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private a mSs;
  private com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b mSt;
  
  static
  {
    AppMethodBeat.i(5562);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("BIZAPPMSGREPORTCCONTEXT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b.gLs;
      }
    });
    AppMethodBeat.o(5562);
  }
  
  private static d bBZ()
  {
    AppMethodBeat.i(5558);
    d locald = (d)t.ap(d.class);
    AppMethodBeat.o(5558);
    return locald;
  }
  
  public static com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b bCa()
  {
    AppMethodBeat.i(5561);
    g.afz().aeD();
    if (bBZ().mSt == null) {
      bBZ().mSt = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b(g.afB().gda);
    }
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b localb = bBZ().mSt;
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
    ad.d("MicroMsg.BrandService.SubCoreBrandService", "on sub core brand service reset");
    if (this.mSs == null) {
      this.mSs = new a();
    }
    com.tencent.mm.sdk.b.a.ESL.c(this.mSs);
    Object localObject = new com.tencent.mm.plugin.brandservice.ui.a.d();
    ((n)g.ad(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new com.tencent.mm.plugin.brandservice.ui.a.b();
    ((n)g.ad(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    AppMethodBeat.o(5559);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(5560);
    if (this.mSs != null) {
      com.tencent.mm.sdk.b.a.ESL.d(this.mSs);
    }
    ((n)g.ad(n.class)).unregisterFTSUILogic(96);
    ((n)g.ad(n.class)).unregisterFTSUILogic(4208);
    AppMethodBeat.o(5560);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public static final class a
    extends c<sl>
  {
    public a()
    {
      AppMethodBeat.i(160481);
      this.__eventId = sl.class.getName().hashCode();
      AppMethodBeat.o(160481);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.d
 * JD-Core Version:    0.7.0.1
 */