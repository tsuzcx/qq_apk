package com.tencent.mm.openim;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.jz;
import com.tencent.mm.g.a.oy;
import com.tencent.mm.g.a.oz;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.openim.b.j;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.y;
import java.util.HashMap;

public class PluginOpenIM
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.a, c
{
  public static HashMap<Integer, h.b> baseDBFactories;
  private i gNh;
  private IListener jGM;
  private IListener jGN;
  private d jGO;
  private com.tencent.mm.openim.e.b jGP;
  private com.tencent.mm.openim.e.f jGQ;
  
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
    this.jGM = new IListener() {};
    this.jGN = new IListener() {};
    this.gNh = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(151167);
        if ((paramAnonymousq instanceof j))
        {
          paramAnonymousString = (j)paramAnonymousq;
          paramAnonymousq = new oz();
          paramAnonymousq.dUZ.dVa = paramAnonymousString.dVa;
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
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(151174);
    if (paramg.aBb()) {
      y.a("openim", "openim", 536870912L, 3);
    }
    AppMethodBeat.o(151174);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public com.tencent.mm.openim.e.b getAccTypeInfoStg()
  {
    AppMethodBeat.i(151170);
    com.tencent.mm.kernel.g.aAf().azk();
    if (this.jGP == null)
    {
      com.tencent.mm.kernel.g.aAi();
      this.jGP = new com.tencent.mm.openim.e.b(com.tencent.mm.kernel.g.aAh().hqK);
    }
    com.tencent.mm.openim.e.b localb = this.jGP;
    AppMethodBeat.o(151170);
    return localb;
  }
  
  public d getAppIdInfoStg()
  {
    AppMethodBeat.i(151169);
    com.tencent.mm.kernel.g.aAf().azk();
    if (this.jGP == null)
    {
      com.tencent.mm.kernel.g.aAi();
      this.jGO = new d(com.tencent.mm.kernel.g.aAh().hqK);
    }
    d locald = this.jGO;
    AppMethodBeat.o(151169);
    return locald;
  }
  
  public com.tencent.mm.openim.e.f getWordingInfoStg()
  {
    AppMethodBeat.i(151171);
    com.tencent.mm.kernel.g.aAf().azk();
    if (this.jGQ == null)
    {
      com.tencent.mm.kernel.g.aAi();
      this.jGQ = new com.tencent.mm.openim.e.f(com.tencent.mm.kernel.g.aAh().hqK);
    }
    com.tencent.mm.openim.e.f localf = this.jGQ;
    AppMethodBeat.o(151171);
    return localf;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(151172);
    Log.i("MicroMsg.PluginOpenIM", "onAccountInitialized");
    EventCenter.instance.add(this.jGM);
    this.jGN.alive();
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.b(com.tencent.mm.openim.a.a.class, new com.tencent.mm.openim.b.t());
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(453, (i)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class));
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(913, this.gNh);
    AppMethodBeat.o(151172);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151173);
    Log.i("MicroMsg.PluginOpenIM", "onAccountRelease");
    EventCenter.instance.removeListener(this.jGM);
    this.jGN.dead();
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(453, (i)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class));
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(913, this.gNh);
    AppMethodBeat.o(151173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.PluginOpenIM
 * JD-Core Version:    0.7.0.1
 */