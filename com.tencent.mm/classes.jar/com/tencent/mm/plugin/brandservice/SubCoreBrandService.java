package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.xd;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class SubCoreBrandService
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private SetRecvTmpMsgOptionEventListener vAW;
  private com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b vAX;
  
  static
  {
    AppMethodBeat.i(5562);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("BIZAPPMSGREPORTCCONTEXT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.nVW;
      }
    });
    AppMethodBeat.o(5562);
  }
  
  private static SubCoreBrandService dbM()
  {
    AppMethodBeat.i(5558);
    SubCoreBrandService localSubCoreBrandService = (SubCoreBrandService)y.aL(SubCoreBrandService.class);
    AppMethodBeat.o(5558);
    return localSubCoreBrandService;
  }
  
  public static com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b dbN()
  {
    AppMethodBeat.i(5561);
    h.baC().aZJ();
    if (dbM().vAX == null) {
      dbM().vAX = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b(h.baE().mCN);
    }
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b localb = dbM().vAX;
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
    if (this.vAW == null) {
      this.vAW = new SetRecvTmpMsgOptionEventListener();
    }
    this.vAW.alive();
    Object localObject = new com.tencent.mm.plugin.brandservice.ui.a.d();
    ((n)h.az(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new com.tencent.mm.plugin.brandservice.ui.a.b();
    ((n)h.az(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    AppMethodBeat.o(5559);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(5560);
    if (this.vAW != null) {
      this.vAW.dead();
    }
    ((n)h.az(n.class)).unregisterFTSUILogic(96);
    ((n)h.az(n.class)).unregisterFTSUILogic(4208);
    AppMethodBeat.o(5560);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public static class SetRecvTmpMsgOptionEventListener
    extends IListener<xd>
  {
    public SetRecvTmpMsgOptionEventListener()
    {
      super();
      AppMethodBeat.i(160481);
      this.__eventId = xd.class.getName().hashCode();
      AppMethodBeat.o(160481);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.SubCoreBrandService
 * JD-Core Version:    0.7.0.1
 */