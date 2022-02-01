package com.tencent.mm.openim;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.jb;
import com.tencent.mm.g.a.nx;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.w;
import com.tencent.mm.openim.b.j;
import com.tencent.mm.openim.b.t;
import com.tencent.mm.openim.d.p;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.o;
import java.util.HashMap;

public class PluginOpenIM
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c
{
  public static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.ak.g hwV;
  private com.tencent.mm.sdk.b.c inQ;
  private com.tencent.mm.sdk.b.c inR;
  private d inS;
  private com.tencent.mm.openim.e.b inT;
  private com.tencent.mm.openim.e.f inU;
  
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
    this.inQ = new com.tencent.mm.sdk.b.c() {};
    this.inR = new com.tencent.mm.sdk.b.c() {};
    this.hwV = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(151167);
        if ((paramAnonymousn instanceof j))
        {
          paramAnonymousString = (j)paramAnonymousn;
          paramAnonymousn = new ny();
          paramAnonymousn.dqs.dqt = paramAnonymousString.dqt;
          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousn);
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
    if (paramg.ahL()) {
      o.a("openim", "openim", 536870912L, 3);
    }
    AppMethodBeat.o(151174);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public com.tencent.mm.openim.e.b getAccTypeInfoStg()
  {
    AppMethodBeat.i(151170);
    com.tencent.mm.kernel.g.agP().afT();
    if (this.inT == null)
    {
      com.tencent.mm.kernel.g.agS();
      this.inT = new com.tencent.mm.openim.e.b(com.tencent.mm.kernel.g.agR().ghG);
    }
    com.tencent.mm.openim.e.b localb = this.inT;
    AppMethodBeat.o(151170);
    return localb;
  }
  
  public d getAppIdInfoStg()
  {
    AppMethodBeat.i(151169);
    com.tencent.mm.kernel.g.agP().afT();
    if (this.inT == null)
    {
      com.tencent.mm.kernel.g.agS();
      this.inS = new d(com.tencent.mm.kernel.g.agR().ghG);
    }
    d locald = this.inS;
    AppMethodBeat.o(151169);
    return locald;
  }
  
  public com.tencent.mm.openim.e.f getWordingInfoStg()
  {
    AppMethodBeat.i(151171);
    com.tencent.mm.kernel.g.agP().afT();
    if (this.inU == null)
    {
      com.tencent.mm.kernel.g.agS();
      this.inU = new com.tencent.mm.openim.e.f(com.tencent.mm.kernel.g.agR().ghG);
    }
    com.tencent.mm.openim.e.f localf = this.inU;
    AppMethodBeat.o(151171);
    return localf;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(151172);
    ac.i("MicroMsg.PluginOpenIM", "onAccountInitialized");
    com.tencent.mm.sdk.b.a.GpY.b(this.inQ);
    this.inR.alive();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.b(com.tencent.mm.openim.a.b.class, new t());
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.b(com.tencent.mm.openim.a.a.class, new p());
    w.a((ak)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class));
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(453, (com.tencent.mm.ak.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class));
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(913, this.hwV);
    AppMethodBeat.o(151172);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151173);
    ac.i("MicroMsg.PluginOpenIM", "onAccountRelease");
    com.tencent.mm.sdk.b.a.GpY.d(this.inQ);
    this.inR.dead();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(453, (com.tencent.mm.ak.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class));
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(913, this.hwV);
    AppMethodBeat.o(151173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.PluginOpenIM
 * JD-Core Version:    0.7.0.1
 */