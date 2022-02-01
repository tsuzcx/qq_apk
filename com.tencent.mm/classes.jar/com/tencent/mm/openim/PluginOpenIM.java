package com.tencent.mm.openim;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.d;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.af.a;
import com.tencent.mm.model.af.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.openim.a.i;
import com.tencent.mm.openim.e.l;
import com.tencent.mm.openim.model.aa;
import com.tencent.mm.openim.model.ab;
import com.tencent.mm.openim.model.y;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.bx.a;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.by.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.af;
import java.util.HashMap;
import java.util.Map;

public class PluginOpenIM
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.openim.api.f
{
  public static HashMap<Integer, h.b> baseDBFactories;
  private static String pqK;
  private com.tencent.mm.am.h maV;
  private IListener pqL;
  private IListener pqM;
  private af.b pqN;
  private bx.a pqO;
  private by.a pqP;
  private MStorageEx.IOnStorageChange pqQ;
  private com.tencent.mm.openim.a.b pqR;
  private com.tencent.mm.openim.e.d pqS;
  private com.tencent.mm.openim.e.b pqT;
  private l pqU;
  private com.tencent.mm.openim.e.h pqV;
  private com.tencent.mm.openim.e.j pqW;
  private com.tencent.mm.openim.a.h pqX;
  private com.tencent.mm.openim.e.f pqY;
  private t pqZ;
  
  static
  {
    AppMethodBeat.i(151175);
    pqK = "OpenIMArchivePopUp";
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
        return com.tencent.mm.openim.e.d.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("OpenIMWordingInfo_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return l.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("OpenIMFinderInfoNew_TABLE".hashCode()), new PluginOpenIM.10());
    baseDBFactories.put(Integer.valueOf("OpenIMSnsFlag_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.openim.e.j.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("OpenIMKefuContact_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(235728);
        String[] arrayOfString = com.tencent.mm.openim.a.h.bSc();
        AppMethodBeat.o(235728);
        return arrayOfString;
      }
    });
    baseDBFactories.put(Integer.valueOf("OpenIMArchive_TABLE".hashCode()), new PluginOpenIM.4());
    AppMethodBeat.o(151175);
  }
  
  public PluginOpenIM()
  {
    AppMethodBeat.i(151168);
    this.pqL = new PluginOpenIM.1(this, com.tencent.mm.app.f.hfK);
    this.pqM = new PluginOpenIM.2(this, com.tencent.mm.app.f.hfK);
    this.maV = new PluginOpenIM.5(this);
    this.pqR = null;
    this.pqZ = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, g.a paramAnonymousa)
      {
        AppMethodBeat.i(235726);
        try
        {
          paramAnonymousString = paramAnonymousa.mpN.YFE.abwM;
          Log.i("MicroMsg.PluginOpenIM", "OpenIMArchivePopUp fromUser:%s newxml:%s", new Object[] { paramAnonymousString, paramAnonymousMap });
          paramAnonymousMap = (String)paramAnonymousMap.get(".sysmsg.privacy_agreement_url");
          if (!Util.isNullOrNil(paramAnonymousMap)) {
            PluginOpenIM.this.getArchiveStg().replace(new com.tencent.mm.openim.e.e(paramAnonymousString, paramAnonymousMap));
          }
          AppMethodBeat.o(235726);
          return;
        }
        finally
        {
          for (;;)
          {
            paramAnonymousString = null;
          }
        }
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
    if (paramg.bbA()) {
      af.b("openim", "openim", 536870912L, 7776000000L, 1);
    }
    AppMethodBeat.o(151174);
  }
  
  public void delArchie(String paramString)
  {
    AppMethodBeat.i(235793);
    paramString = new com.tencent.mm.openim.e.e(paramString, null);
    getArchiveStg().delete(paramString, new String[0]);
    AppMethodBeat.o(235793);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(235798);
    if (paramg.bbA())
    {
      com.tencent.mm.kernel.h.b(com.tencent.mm.openim.api.c.class, new y());
      com.tencent.mm.kernel.h.b(com.tencent.mm.openim.api.d.class, new aa());
      com.tencent.mm.kernel.h.b(com.tencent.mm.openim.api.b.class, new com.tencent.mm.openim.c.d());
      com.tencent.mm.openim.f.a.init();
      AppMethodBeat.o(235798);
      return;
    }
    if ((paramg.FH(":tools")) || (paramg.FH(":toolsmp")) || (paramg.FI(":appbrand"))) {
      com.tencent.mm.kernel.h.b(com.tencent.mm.openim.api.d.class, new aa());
    }
    AppMethodBeat.o(235798);
  }
  
  public com.tencent.mm.openim.e.b getAccTypeInfoStg()
  {
    AppMethodBeat.i(151170);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (this.pqT == null)
    {
      com.tencent.mm.kernel.h.baF();
      this.pqT = new com.tencent.mm.openim.e.b(com.tencent.mm.kernel.h.baE().mCN);
    }
    com.tencent.mm.openim.e.b localb = this.pqT;
    AppMethodBeat.o(151170);
    return localb;
  }
  
  public com.tencent.mm.openim.e.d getAppIdInfoStg()
  {
    AppMethodBeat.i(151169);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (this.pqS == null)
    {
      com.tencent.mm.kernel.h.baF();
      this.pqS = new com.tencent.mm.openim.e.d(com.tencent.mm.kernel.h.baE().mCN);
    }
    com.tencent.mm.openim.e.d locald = this.pqS;
    AppMethodBeat.o(151169);
    return locald;
  }
  
  public String getArchieUrl(String paramString)
  {
    AppMethodBeat.i(235792);
    paramString = new com.tencent.mm.openim.e.e(paramString, null);
    getArchiveStg().get(paramString, new String[0]);
    paramString = paramString.field_content;
    AppMethodBeat.o(235792);
    return paramString;
  }
  
  public com.tencent.mm.openim.e.f getArchiveStg()
  {
    AppMethodBeat.i(235790);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (this.pqY == null)
    {
      com.tencent.mm.kernel.h.baF();
      this.pqY = new com.tencent.mm.openim.e.f(com.tencent.mm.kernel.h.baE().mCN);
    }
    com.tencent.mm.openim.e.f localf = this.pqY;
    AppMethodBeat.o(235790);
    return localf;
  }
  
  public com.tencent.mm.openim.a.h getContactStorage()
  {
    AppMethodBeat.i(235803);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (this.pqX == null)
    {
      com.tencent.mm.kernel.h.baF();
      this.pqX = new com.tencent.mm.openim.a.h(com.tencent.mm.kernel.h.baE().mCN);
    }
    com.tencent.mm.openim.a.h localh = this.pqX;
    AppMethodBeat.o(235803);
    return localh;
  }
  
  public com.tencent.mm.openim.e.h getFinderInfoStg()
  {
    AppMethodBeat.i(235786);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (this.pqV == null)
    {
      com.tencent.mm.kernel.h.baF();
      this.pqV = new com.tencent.mm.openim.e.h(com.tencent.mm.kernel.h.baE().mCN);
    }
    com.tencent.mm.openim.e.h localh = this.pqV;
    AppMethodBeat.o(235786);
    return localh;
  }
  
  public com.tencent.mm.openim.e.j getSnsFlagStg()
  {
    AppMethodBeat.i(235788);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (this.pqW == null)
    {
      com.tencent.mm.kernel.h.baF();
      this.pqW = new com.tencent.mm.openim.e.j(com.tencent.mm.kernel.h.baE().mCN);
    }
    com.tencent.mm.openim.e.j localj = this.pqW;
    AppMethodBeat.o(235788);
    return localj;
  }
  
  public l getWordingInfoStg()
  {
    AppMethodBeat.i(151171);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (this.pqU == null)
    {
      com.tencent.mm.kernel.h.baF();
      this.pqU = new l(com.tencent.mm.kernel.h.baE().mCN);
    }
    l locall = this.pqU;
    AppMethodBeat.o(151171);
    return locall;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(151172);
    Log.i("MicroMsg.PluginOpenIM", "onAccountInitialized");
    this.pqL.alive();
    this.pqM.alive();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.b(com.tencent.mm.openim.api.e.class, new ab());
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(453, (com.tencent.mm.am.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class));
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(913, this.maV);
    this.pqN = new com.tencent.mm.openim.a.a();
    af.a.a(this.pqN);
    this.pqO = new com.tencent.mm.openim.a.f();
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().a(this.pqO);
    this.pqP = new com.tencent.mm.openim.a.j();
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().a(this.pqP);
    this.pqR = new com.tencent.mm.openim.a.b();
    g.d.a(Integer.valueOf(67), this.pqR);
    this.pqQ = new i();
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().add(this.pqQ);
    ((com.tencent.mm.openim.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.c.class)).bRV();
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a(pqK, this.pqZ);
    AppMethodBeat.o(151172);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151173);
    Log.i("MicroMsg.PluginOpenIM", "onAccountRelease");
    this.pqL.dead();
    this.pqM.dead();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(453, (com.tencent.mm.am.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class));
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(913, this.maV);
    af.a.b(this.pqN);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().b(this.pqO);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().c(this.pqP);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().remove(this.pqQ);
    g.d.b(Integer.valueOf(67), this.pqR);
    ((com.tencent.mm.openim.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.c.class)).onAccountRelease();
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b(pqK, this.pqZ);
    AppMethodBeat.o(151173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.PluginOpenIM
 * JD-Core Version:    0.7.0.1
 */