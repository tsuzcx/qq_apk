package com.tencent.mm.openim;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.kp;
import com.tencent.mm.f.a.pv;
import com.tencent.mm.f.a.pw;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.openim.b.j;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.ab;
import java.util.HashMap;

public class PluginOpenIM
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c
{
  public static HashMap<Integer, h.b> baseDBFactories;
  private i jxB;
  private IListener mxQ;
  private IListener mxR;
  private d mxS;
  private com.tencent.mm.openim.e.b mxT;
  private com.tencent.mm.openim.e.h mxU;
  private com.tencent.mm.openim.e.f mxV;
  
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
        return com.tencent.mm.openim.e.h.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("OpenIMFinderInfo_TABLE".hashCode()), new h.b()
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
    this.mxQ = new IListener() {};
    this.mxR = new IListener() {};
    this.jxB = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(151167);
        if ((paramAnonymousq instanceof j))
        {
          paramAnonymousString = (j)paramAnonymousq;
          paramAnonymousq = new pw();
          paramAnonymousq.fOB.fOC = paramAnonymousString.fOC;
          EventCenter.instance.publish(paramAnonymousq);
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
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(151174);
    if (paramg.aIE()) {
      ab.a("openim", "openim", 536870912L, 7776000000L, 1);
    }
    AppMethodBeat.o(151174);
  }
  
  public void execute(g paramg) {}
  
  public com.tencent.mm.openim.e.b getAccTypeInfoStg()
  {
    AppMethodBeat.i(151170);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (this.mxT == null)
    {
      com.tencent.mm.kernel.h.aHH();
      this.mxT = new com.tencent.mm.openim.e.b(com.tencent.mm.kernel.h.aHG().kcF);
    }
    com.tencent.mm.openim.e.b localb = this.mxT;
    AppMethodBeat.o(151170);
    return localb;
  }
  
  public d getAppIdInfoStg()
  {
    AppMethodBeat.i(151169);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (this.mxS == null)
    {
      com.tencent.mm.kernel.h.aHH();
      this.mxS = new d(com.tencent.mm.kernel.h.aHG().kcF);
    }
    d locald = this.mxS;
    AppMethodBeat.o(151169);
    return locald;
  }
  
  public com.tencent.mm.openim.e.f getFinderInfoStg()
  {
    AppMethodBeat.i(227387);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (this.mxV == null)
    {
      com.tencent.mm.kernel.h.aHH();
      this.mxV = new com.tencent.mm.openim.e.f(com.tencent.mm.kernel.h.aHG().kcF);
    }
    com.tencent.mm.openim.e.f localf = this.mxV;
    AppMethodBeat.o(227387);
    return localf;
  }
  
  public com.tencent.mm.openim.e.h getWordingInfoStg()
  {
    AppMethodBeat.i(151171);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (this.mxU == null)
    {
      com.tencent.mm.kernel.h.aHH();
      this.mxU = new com.tencent.mm.openim.e.h(com.tencent.mm.kernel.h.aHG().kcF);
    }
    com.tencent.mm.openim.e.h localh = this.mxU;
    AppMethodBeat.o(151171);
    return localh;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(151172);
    Log.i("MicroMsg.PluginOpenIM", "onAccountInitialized");
    EventCenter.instance.add(this.mxQ);
    this.mxR.alive();
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.b(com.tencent.mm.openim.a.a.class, new com.tencent.mm.openim.b.t());
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(453, (i)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class));
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(913, this.jxB);
    AppMethodBeat.o(151172);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151173);
    Log.i("MicroMsg.PluginOpenIM", "onAccountRelease");
    EventCenter.instance.removeListener(this.mxQ);
    this.mxR.dead();
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(453, (i)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class));
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(913, this.jxB);
    AppMethodBeat.o(151173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.PluginOpenIM
 * JD-Core Version:    0.7.0.1
 */