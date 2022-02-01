package com.tencent.mm.openim;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.jj;
import com.tencent.mm.g.a.of;
import com.tencent.mm.g.a.og;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.al;
import com.tencent.mm.model.w;
import com.tencent.mm.openim.b.j;
import com.tencent.mm.openim.b.t;
import com.tencent.mm.openim.d.p;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.o;
import java.util.HashMap;

public class PluginOpenIM
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c
{
  public static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.al.f hPn;
  private com.tencent.mm.sdk.b.c iHn;
  private com.tencent.mm.sdk.b.c iHo;
  private d iHp;
  private com.tencent.mm.openim.e.b iHq;
  private com.tencent.mm.openim.e.f iHr;
  
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
    this.iHn = new com.tencent.mm.sdk.b.c() {};
    this.iHo = new com.tencent.mm.sdk.b.c() {};
    this.hPn = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(151167);
        if ((paramAnonymousn instanceof j))
        {
          paramAnonymousString = (j)paramAnonymousn;
          paramAnonymousn = new og();
          paramAnonymousn.dCf.dCg = paramAnonymousString.dCg;
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousn);
        }
        AppMethodBeat.o(151167);
      }
    };
    AppMethodBeat.o(151168);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(151174);
    if (paramg.akw()) {
      o.a("openim", "openim", 536870912L, 3);
    }
    AppMethodBeat.o(151174);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public com.tencent.mm.openim.e.b getAccTypeInfoStg()
  {
    AppMethodBeat.i(151170);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (this.iHq == null)
    {
      com.tencent.mm.kernel.g.ajD();
      this.iHq = new com.tencent.mm.openim.e.b(com.tencent.mm.kernel.g.ajC().gBq);
    }
    com.tencent.mm.openim.e.b localb = this.iHq;
    AppMethodBeat.o(151170);
    return localb;
  }
  
  public d getAppIdInfoStg()
  {
    AppMethodBeat.i(151169);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (this.iHq == null)
    {
      com.tencent.mm.kernel.g.ajD();
      this.iHp = new d(com.tencent.mm.kernel.g.ajC().gBq);
    }
    d locald = this.iHp;
    AppMethodBeat.o(151169);
    return locald;
  }
  
  public com.tencent.mm.openim.e.f getWordingInfoStg()
  {
    AppMethodBeat.i(151171);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (this.iHr == null)
    {
      com.tencent.mm.kernel.g.ajD();
      this.iHr = new com.tencent.mm.openim.e.f(com.tencent.mm.kernel.g.ajC().gBq);
    }
    com.tencent.mm.openim.e.f localf = this.iHr;
    AppMethodBeat.o(151171);
    return localf;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(151172);
    ad.i("MicroMsg.PluginOpenIM", "onAccountInitialized");
    com.tencent.mm.sdk.b.a.IbL.b(this.iHn);
    this.iHo.alive();
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.b(com.tencent.mm.openim.a.b.class, new t());
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.b(com.tencent.mm.openim.a.a.class, new p());
    w.a((al)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class));
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(453, (com.tencent.mm.al.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class));
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(913, this.hPn);
    AppMethodBeat.o(151172);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151173);
    ad.i("MicroMsg.PluginOpenIM", "onAccountRelease");
    com.tencent.mm.sdk.b.a.IbL.d(this.iHn);
    this.iHo.dead();
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(453, (com.tencent.mm.al.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class));
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(913, this.hPn);
    AppMethodBeat.o(151173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.PluginOpenIM
 * JD-Core Version:    0.7.0.1
 */