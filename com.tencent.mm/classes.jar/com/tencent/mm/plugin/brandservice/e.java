package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.vn;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class e
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private a svt;
  private com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b svu;
  
  static
  {
    AppMethodBeat.i(5562);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("BIZAPPMSGREPORTCCONTEXT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.lqL;
      }
    });
    AppMethodBeat.o(5562);
  }
  
  private static e cyO()
  {
    AppMethodBeat.i(5558);
    e locale = (e)y.as(e.class);
    AppMethodBeat.o(5558);
    return locale;
  }
  
  public static com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b cyP()
  {
    AppMethodBeat.i(5561);
    h.aHE().aGH();
    if (cyO().svu == null) {
      cyO().svu = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b(h.aHG().kcF);
    }
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b localb = cyO().svu;
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
    Log.d("MicroMsg.BrandService.SubCoreBrandService", "on sub core brand service reset");
    if (this.svt == null) {
      this.svt = new a();
    }
    EventCenter.instance.addListener(this.svt);
    Object localObject = new com.tencent.mm.plugin.brandservice.ui.a.d();
    ((n)h.ag(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new com.tencent.mm.plugin.brandservice.ui.a.b();
    ((n)h.ag(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    AppMethodBeat.o(5559);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(5560);
    if (this.svt != null) {
      EventCenter.instance.removeListener(this.svt);
    }
    ((n)h.ag(n.class)).unregisterFTSUILogic(96);
    ((n)h.ag(n.class)).unregisterFTSUILogic(4208);
    AppMethodBeat.o(5560);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public static final class a
    extends IListener<vn>
  {
    public a()
    {
      AppMethodBeat.i(160481);
      this.__eventId = vn.class.getName().hashCode();
      AppMethodBeat.o(160481);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.e
 * JD-Core Version:    0.7.0.1
 */