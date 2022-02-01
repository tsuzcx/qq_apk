package com.tencent.mm.openim;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.iu;
import com.tencent.mm.g.a.no;
import com.tencent.mm.g.a.np;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.ak;
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
  private com.tencent.mm.al.g gWw;
  private com.tencent.mm.sdk.b.c hNu;
  private com.tencent.mm.sdk.b.c hNv;
  private d hNw;
  private com.tencent.mm.openim.e.b hNx;
  private com.tencent.mm.openim.e.f hNy;
  
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
    this.hNu = new com.tencent.mm.sdk.b.c() {};
    this.hNv = new com.tencent.mm.sdk.b.c() {};
    this.gWw = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(151167);
        if ((paramAnonymousn instanceof j))
        {
          paramAnonymousString = (j)paramAnonymousn;
          paramAnonymousn = new np();
          paramAnonymousn.dsI.dsJ = paramAnonymousString.dsJ;
          com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousn);
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
    if (paramg.agu()) {
      o.a("openim", "openim", 536870912L, 3, true);
    }
    AppMethodBeat.o(151174);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public com.tencent.mm.openim.e.b getAccTypeInfoStg()
  {
    AppMethodBeat.i(151170);
    com.tencent.mm.kernel.g.afz().aeD();
    if (this.hNx == null)
    {
      com.tencent.mm.kernel.g.afC();
      this.hNx = new com.tencent.mm.openim.e.b(com.tencent.mm.kernel.g.afB().gda);
    }
    com.tencent.mm.openim.e.b localb = this.hNx;
    AppMethodBeat.o(151170);
    return localb;
  }
  
  public d getAppIdInfoStg()
  {
    AppMethodBeat.i(151169);
    com.tencent.mm.kernel.g.afz().aeD();
    if (this.hNx == null)
    {
      com.tencent.mm.kernel.g.afC();
      this.hNw = new d(com.tencent.mm.kernel.g.afB().gda);
    }
    d locald = this.hNw;
    AppMethodBeat.o(151169);
    return locald;
  }
  
  public com.tencent.mm.openim.e.f getWordingInfoStg()
  {
    AppMethodBeat.i(151171);
    com.tencent.mm.kernel.g.afz().aeD();
    if (this.hNy == null)
    {
      com.tencent.mm.kernel.g.afC();
      this.hNy = new com.tencent.mm.openim.e.f(com.tencent.mm.kernel.g.afB().gda);
    }
    com.tencent.mm.openim.e.f localf = this.hNy;
    AppMethodBeat.o(151171);
    return localf;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(151172);
    ad.i("MicroMsg.PluginOpenIM", "onAccountInitialized");
    com.tencent.mm.sdk.b.a.ESL.b(this.hNu);
    this.hNv.alive();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.b(com.tencent.mm.openim.a.b.class, new t());
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.b(com.tencent.mm.openim.a.a.class, new p());
    w.a((ak)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class));
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(453, (com.tencent.mm.al.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class));
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(913, this.gWw);
    AppMethodBeat.o(151172);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151173);
    ad.i("MicroMsg.PluginOpenIM", "onAccountRelease");
    com.tencent.mm.sdk.b.a.ESL.d(this.hNu);
    this.hNv.dead();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(453, (com.tencent.mm.al.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class));
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(913, this.gWw);
    AppMethodBeat.o(151173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.PluginOpenIM
 * JD-Core Version:    0.7.0.1
 */