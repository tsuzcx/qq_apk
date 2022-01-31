package com.tencent.mm.openim;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.ah;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public class PluginOpenIM
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c
{
  public static HashMap<Integer, h.d> baseDBFactories;
  private com.tencent.mm.ai.f fur;
  private com.tencent.mm.openim.e.b gfA;
  private com.tencent.mm.openim.e.f gfB;
  private com.tencent.mm.sdk.b.c gfx;
  private com.tencent.mm.sdk.b.c gfy;
  private d gfz;
  
  static
  {
    AppMethodBeat.i(78831);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("OpenIMAccTypeInfo_TABLE".hashCode()), new PluginOpenIM.4());
    baseDBFactories.put(Integer.valueOf("OpenIMAppIdInfo_TABLE".hashCode()), new PluginOpenIM.5());
    baseDBFactories.put(Integer.valueOf("OpenIMWordingInfo_TABLE".hashCode()), new PluginOpenIM.6());
    AppMethodBeat.o(78831);
  }
  
  public PluginOpenIM()
  {
    AppMethodBeat.i(78825);
    this.gfx = new PluginOpenIM.1(this);
    this.gfy = new PluginOpenIM.2(this);
    this.fur = new PluginOpenIM.3(this);
    AppMethodBeat.o(78825);
  }
  
  public HashMap<Integer, h.d> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public com.tencent.mm.openim.e.b getAccTypeInfoStg()
  {
    AppMethodBeat.i(78827);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (this.gfA == null)
    {
      com.tencent.mm.kernel.g.RM();
      this.gfA = new com.tencent.mm.openim.e.b(com.tencent.mm.kernel.g.RL().eHS);
    }
    com.tencent.mm.openim.e.b localb = this.gfA;
    AppMethodBeat.o(78827);
    return localb;
  }
  
  public d getAppIdInfoStg()
  {
    AppMethodBeat.i(78826);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (this.gfA == null)
    {
      com.tencent.mm.kernel.g.RM();
      this.gfz = new d(com.tencent.mm.kernel.g.RL().eHS);
    }
    d locald = this.gfz;
    AppMethodBeat.o(78826);
    return locald;
  }
  
  public com.tencent.mm.openim.e.f getWordingInfoStg()
  {
    AppMethodBeat.i(78828);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (this.gfB == null)
    {
      com.tencent.mm.kernel.g.RM();
      this.gfB = new com.tencent.mm.openim.e.f(com.tencent.mm.kernel.g.RL().eHS);
    }
    com.tencent.mm.openim.e.f localf = this.gfB;
    AppMethodBeat.o(78828);
    return localf;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(78829);
    ab.i("MicroMsg.PluginOpenIM", "onAccountInitialized");
    com.tencent.mm.sdk.b.a.ymk.b(this.gfx);
    this.gfy.alive();
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.b(com.tencent.mm.openim.a.b.class, new com.tencent.mm.openim.b.t());
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.b(com.tencent.mm.openim.a.a.class, new com.tencent.mm.openim.d.p());
    com.tencent.mm.model.t.a((ah)com.tencent.mm.kernel.g.E(com.tencent.mm.openim.a.a.class));
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(453, (com.tencent.mm.ai.f)com.tencent.mm.kernel.g.E(com.tencent.mm.openim.a.b.class));
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(913, this.fur);
    AppMethodBeat.o(78829);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(78830);
    ab.i("MicroMsg.PluginOpenIM", "onAccountRelease");
    com.tencent.mm.sdk.b.a.ymk.d(this.gfx);
    this.gfy.dead();
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(453, (com.tencent.mm.ai.f)com.tencent.mm.kernel.g.E(com.tencent.mm.openim.a.b.class));
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(913, this.fur);
    AppMethodBeat.o(78830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.PluginOpenIM
 * JD-Core Version:    0.7.0.1
 */