package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uk;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class d
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private a pmK;
  private com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b pmL;
  
  static
  {
    AppMethodBeat.i(5562);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("BIZAPPMSGREPORTCCONTEXT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b.iBh;
      }
    });
    AppMethodBeat.o(5562);
  }
  
  private static d clo()
  {
    AppMethodBeat.i(5558);
    d locald = (d)y.at(d.class);
    AppMethodBeat.o(5558);
    return locald;
  }
  
  public static com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b clp()
  {
    AppMethodBeat.i(5561);
    g.aAf().azk();
    if (clo().pmL == null) {
      clo().pmL = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b(g.aAh().hqK);
    }
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b localb = clo().pmL;
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
    if (this.pmK == null) {
      this.pmK = new a();
    }
    EventCenter.instance.addListener(this.pmK);
    Object localObject = new com.tencent.mm.plugin.brandservice.ui.a.d();
    ((n)g.ah(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new com.tencent.mm.plugin.brandservice.ui.a.b();
    ((n)g.ah(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    AppMethodBeat.o(5559);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(5560);
    if (this.pmK != null) {
      EventCenter.instance.removeListener(this.pmK);
    }
    ((n)g.ah(n.class)).unregisterFTSUILogic(96);
    ((n)g.ah(n.class)).unregisterFTSUILogic(4208);
    AppMethodBeat.o(5560);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public static final class a
    extends IListener<uk>
  {
    public a()
    {
      AppMethodBeat.i(160481);
      this.__eventId = uk.class.getName().hashCode();
      AppMethodBeat.o(160481);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.d
 * JD-Core Version:    0.7.0.1
 */