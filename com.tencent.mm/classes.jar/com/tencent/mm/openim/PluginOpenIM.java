package com.tencent.mm.openim;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.openim.b.t;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.u;
import java.util.HashMap;

public class PluginOpenIM
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c
{
  public static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.ak.f ghB;
  private com.tencent.mm.sdk.b.c iKg;
  private com.tencent.mm.sdk.b.c iKh;
  private d iKi;
  private com.tencent.mm.openim.e.b iKj;
  private com.tencent.mm.openim.e.f iKk;
  
  static
  {
    AppMethodBeat.i(151175);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("OpenIMAccTypeInfo_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.openim.e.b.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("OpenIMAppIdInfo_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return d.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("OpenIMWordingInfo_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.openim.e.f.SQL_CREATE;
      }
    });
    AppMethodBeat.o(151175);
  }
  
  public PluginOpenIM()
  {
    AppMethodBeat.i(151168);
    this.iKg = new PluginOpenIM.1(this);
    this.iKh = new PluginOpenIM.2(this);
    this.ghB = new PluginOpenIM.3(this);
    AppMethodBeat.o(151168);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(151174);
    if (paramg.akL()) {
      u.a("openim", "openim", 536870912L, 3);
    }
    AppMethodBeat.o(151174);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public com.tencent.mm.openim.e.b getAccTypeInfoStg()
  {
    AppMethodBeat.i(151170);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (this.iKj == null)
    {
      com.tencent.mm.kernel.g.ajS();
      this.iKj = new com.tencent.mm.openim.e.b(com.tencent.mm.kernel.g.ajR().gDX);
    }
    com.tencent.mm.openim.e.b localb = this.iKj;
    AppMethodBeat.o(151170);
    return localb;
  }
  
  public d getAppIdInfoStg()
  {
    AppMethodBeat.i(151169);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (this.iKj == null)
    {
      com.tencent.mm.kernel.g.ajS();
      this.iKi = new d(com.tencent.mm.kernel.g.ajR().gDX);
    }
    d locald = this.iKi;
    AppMethodBeat.o(151169);
    return locald;
  }
  
  public com.tencent.mm.openim.e.f getWordingInfoStg()
  {
    AppMethodBeat.i(151171);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (this.iKk == null)
    {
      com.tencent.mm.kernel.g.ajS();
      this.iKk = new com.tencent.mm.openim.e.f(com.tencent.mm.kernel.g.ajR().gDX);
    }
    com.tencent.mm.openim.e.f localf = this.iKk;
    AppMethodBeat.o(151171);
    return localf;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(151172);
    ae.i("MicroMsg.PluginOpenIM", "onAccountInitialized");
    com.tencent.mm.sdk.b.a.IvT.b(this.iKg);
    this.iKh.alive();
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.b(com.tencent.mm.openim.a.a.class, new t());
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(453, (com.tencent.mm.ak.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class));
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(913, this.ghB);
    AppMethodBeat.o(151172);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151173);
    ae.i("MicroMsg.PluginOpenIM", "onAccountRelease");
    com.tencent.mm.sdk.b.a.IvT.d(this.iKg);
    this.iKh.dead();
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(453, (com.tencent.mm.ak.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class));
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(913, this.ghB);
    AppMethodBeat.o(151173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.PluginOpenIM
 * JD-Core Version:    0.7.0.1
 */