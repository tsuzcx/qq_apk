package com.tencent.mm.plugin.groupsolitaire;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.groupsolitaire.b.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginGroupSolitaire
  extends f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, a
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.sdk.b.c<nb> uMw;
  private com.tencent.mm.plugin.groupsolitaire.b.c uMx;
  private com.tencent.mm.plugin.groupsolitaire.c.c uMy;
  private d uMz;
  
  static
  {
    AppMethodBeat.i(110311);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("GROUPSOLITAIRE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.groupsolitaire.c.c.SQL_CREATE;
      }
    });
    AppMethodBeat.o(110311);
  }
  
  public PluginGroupSolitaire()
  {
    AppMethodBeat.i(110298);
    this.uMw = new com.tencent.mm.sdk.b.c() {};
    this.uMx = null;
    this.uMy = null;
    this.uMz = null;
    AppMethodBeat.o(110298);
  }
  
  public static ay getKV()
  {
    AppMethodBeat.i(110310);
    ay localay = ay.aRW("group_solitatire");
    AppMethodBeat.o(110310);
    return localay;
  }
  
  public static boolean isSupportGroupSolitaireAnalyze()
  {
    AppMethodBeat.i(110302);
    if ((com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE)) {}
    for (int i = 1;; i = 0)
    {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLq, i) == 1)
      {
        AppMethodBeat.o(110302);
        return true;
      }
      AppMethodBeat.o(110302);
      return false;
    }
  }
  
  public static boolean isSupportGroupSolitaireShow()
  {
    AppMethodBeat.i(110303);
    if ((com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE)) {}
    for (int i = 1;; i = 0)
    {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLr, i) == 1)
      {
        AppMethodBeat.o(110303);
        return true;
      }
      AppMethodBeat.o(110303);
      return false;
    }
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(110301);
    if (paramg.akL()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.messenger.foundation.a.j.class, new com.tencent.mm.plugin.groupsolitaire.a.a());
    }
    AppMethodBeat.o(110301);
  }
  
  public com.tencent.mm.plugin.groupsolitaire.b.c getGroupSolitatireManager()
  {
    AppMethodBeat.i(110304);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (this.uMx == null) {
      this.uMx = new com.tencent.mm.plugin.groupsolitaire.b.c();
    }
    com.tencent.mm.plugin.groupsolitaire.b.c localc = this.uMx;
    AppMethodBeat.o(110304);
    return localc;
  }
  
  public d getGroupSolitatireReportManager()
  {
    AppMethodBeat.i(110306);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (this.uMz == null) {
      this.uMz = new d();
    }
    d locald = this.uMz;
    AppMethodBeat.o(110306);
    return locald;
  }
  
  public com.tencent.mm.plugin.groupsolitaire.c.c getGroupSolitatireStorage()
  {
    AppMethodBeat.i(110305);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (this.uMy == null)
    {
      com.tencent.mm.kernel.g.ajS();
      this.uMy = new com.tencent.mm.plugin.groupsolitaire.c.c(com.tencent.mm.kernel.g.ajR().gDX);
    }
    com.tencent.mm.plugin.groupsolitaire.c.c localc = this.uMy;
    AppMethodBeat.o(110305);
    return localc;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(110299);
    this.uMw.alive();
    AppMethodBeat.o(110299);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(110300);
    this.uMw.dead();
    AppMethodBeat.o(110300);
  }
  
  public Pair<Long, String> sendGroupSolitatire(String paramString, com.tencent.mm.plugin.groupsolitaire.c.a parama1, com.tencent.mm.plugin.groupsolitaire.c.a parama2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(174558);
    if (parama1 == null)
    {
      paramString = new Pair(Long.valueOf(-1L), "");
      AppMethodBeat.o(174558);
      return paramString;
    }
    String str = com.tencent.mm.plugin.groupsolitaire.b.b.g(parama1);
    k.b localb = new k.b();
    localb.title = str;
    localb.type = 53;
    localb.hFp = new Pair(parama1.field_key, com.tencent.mm.plugin.groupsolitaire.b.b.a(str, parama1, paramBoolean2));
    paramString = w.a.azs().a(localb, "", "", paramString, "", null);
    if ((paramBoolean1) && (paramString != null))
    {
      ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager().a(((Long)paramString.second).longValue(), parama1, parama2, false, 2);
      if (paramString != null) {
        com.tencent.mm.plugin.groupsolitaire.b.b.a(((Long)paramString.second).longValue(), v.aAC(), parama1);
      }
      ae.i("MicroMsg.groupsolitaire.PluginGroupSolitaire", "sendGroupSolitatire() ret:%s", new Object[] { paramString });
      if (paramString == null) {
        break label242;
      }
    }
    label242:
    for (long l = ((Long)paramString.second).longValue();; l = -1L)
    {
      paramString = new Pair(Long.valueOf(l), str);
      AppMethodBeat.o(174558);
      return paramString;
      if (paramBoolean1) {
        break;
      }
      ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager().a(parama1, parama2, 2);
      break;
    }
  }
  
  public void sendGroupSolitatire(String paramString1, String paramString2, com.tencent.mm.plugin.groupsolitaire.c.a parama1, com.tencent.mm.plugin.groupsolitaire.c.a parama2, com.tencent.mm.plugin.groupsolitaire.c.a parama3, boolean paramBoolean)
  {
    AppMethodBeat.i(221097);
    if (parama2 == null)
    {
      AppMethodBeat.o(221097);
      return;
    }
    k.b localb = new k.b();
    localb.title = paramString1;
    localb.type = 53;
    localb.hFp = new Pair(parama2.field_key, com.tencent.mm.plugin.groupsolitaire.b.b.b(paramString1, parama2));
    paramString1 = w.a.azs().a(localb, "", "", paramString2, "", null);
    if ((paramBoolean) && (paramString1 != null)) {
      ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager().a(((Long)paramString1.second).longValue(), parama2, parama3, true, 1);
    }
    for (;;)
    {
      if (paramString1 != null) {
        com.tencent.mm.plugin.groupsolitaire.b.b.a(((Long)paramString1.second).longValue(), v.aAC(), parama1);
      }
      ae.i("MicroMsg.groupsolitaire.PluginGroupSolitaire", "sendGroupSolitatire() content ret:%s", new Object[] { paramString1 });
      AppMethodBeat.o(221097);
      return;
      if (!paramBoolean) {
        ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager().a(parama2, parama3, 1);
      }
    }
  }
  
  public Pair<Long, String> sendGroupSolitatireInCall(String paramString, com.tencent.mm.plugin.groupsolitaire.c.a parama1, com.tencent.mm.plugin.groupsolitaire.c.a parama2, com.tencent.mm.plugin.groupsolitaire.c.a parama3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(174559);
    if (parama1 == null)
    {
      paramString = new Pair(Long.valueOf(-1L), "");
      AppMethodBeat.o(174559);
      return paramString;
    }
    parama2 = com.tencent.mm.plugin.groupsolitaire.b.b.g(parama2);
    k.b localb = new k.b();
    localb.title = parama2;
    localb.type = 53;
    localb.hFp = new Pair(parama1.field_key, com.tencent.mm.plugin.groupsolitaire.b.b.a(parama2, parama1, paramBoolean2));
    paramString = w.a.azs().a(localb, "", "", paramString, "", null);
    if ((paramBoolean1) && (paramString != null))
    {
      ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager().a(((Long)paramString.second).longValue(), parama1, parama3, false, 2);
      if (paramString != null) {
        com.tencent.mm.plugin.groupsolitaire.b.b.a(((Long)paramString.second).longValue(), v.aAC(), parama1);
      }
      ae.i("MicroMsg.groupsolitaire.PluginGroupSolitaire", "sendGroupSolitatire() ret:%s", new Object[] { paramString });
      if (paramString == null) {
        break label243;
      }
    }
    label243:
    for (long l = ((Long)paramString.second).longValue();; l = -1L)
    {
      paramString = new Pair(Long.valueOf(l), parama2);
      AppMethodBeat.o(174559);
      return paramString;
      if (paramBoolean1) {
        break;
      }
      ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager().a(parama1, parama3, 2);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire
 * JD-Core Version:    0.7.0.1
 */