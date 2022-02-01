package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.d;
import com.tencent.mm.al.q;
import com.tencent.mm.am.a.d;
import com.tencent.mm.am.a.h;
import com.tencent.mm.api.c;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.model.t;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bq.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.storage.z;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class ag
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static long hQS;
  private com.tencent.mm.model.e hGc;
  private f hQT;
  private o.a hQU;
  private l hQV;
  private j hQW;
  private i hQX;
  private d hQY;
  private com.tencent.mm.am.a.b hQZ;
  private com.tencent.mm.am.a.l hRa;
  private com.tencent.mm.am.a.g hRb;
  private com.tencent.mm.am.a.i hRc;
  private h hRd;
  private e hRe;
  private x hRf;
  private z hRg;
  private a hRh;
  private cd.a hRi;
  private bq.a hRj;
  private f.a hRk;
  
  static
  {
    AppMethodBeat.i(124173);
    hQS = 0L;
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("BIZINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return f.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("BIZKF_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return j.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("BIZCHAT_TABLE".hashCode()), new ag.4());
    baseDBFactories.put(Integer.valueOf("BIZCHATUSER_TABLE".hashCode()), new ag.5());
    baseDBFactories.put(Integer.valueOf("BIZCONVERSATION_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.am.a.b.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("BIZCHAMYUSERINFO_TABLE".hashCode()), new ag.7());
    baseDBFactories.put(Integer.valueOf("BIZENTERPRISE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return e.SQL_CREATE;
      }
    });
    AppMethodBeat.o(124173);
  }
  
  public ag()
  {
    AppMethodBeat.i(124152);
    this.hQU = null;
    this.hQV = null;
    this.hQX = null;
    this.hQY = null;
    this.hQZ = null;
    this.hRa = null;
    this.hRb = null;
    this.hRc = null;
    this.hRd = null;
    this.hRe = null;
    this.hRf = null;
    this.hRg = null;
    this.hGc = new com.tencent.mm.model.e();
    this.hRi = new ag.9(this);
    this.hRj = new bq.a()
    {
      public final void a(at paramAnonymousat, bq paramAnonymousbq)
      {
        AppMethodBeat.i(124151);
        if ((paramAnonymousat != null) && (!bt.isNullOrNil(paramAnonymousat.field_username)))
        {
          paramAnonymousbq = paramAnonymousat.field_username;
          Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramAnonymousbq);
          if (localObject == null)
          {
            AppMethodBeat.o(124151);
            return;
          }
          if ((((am)localObject).fqg()) && (!w.zQ(paramAnonymousbq)))
          {
            localObject = ag.aFZ().DD(paramAnonymousbq);
            if (((c)localObject).systemRowid == -1L)
            {
              ad.i("MicroMsg.SubCoreBiz", "onMsgChangeNotify: no bizInfo");
              AppMethodBeat.o(124151);
              return;
            }
            if (((c)localObject).Ko())
            {
              if (((c)localObject).bX(false) == null)
              {
                paramAnonymousat.tD(null);
                ad.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
                AppMethodBeat.o(124151);
                return;
              }
              if (((c)localObject).bX(false).KP() == null)
              {
                paramAnonymousat.tD(null);
                ad.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
                AppMethodBeat.o(124151);
                return;
              }
              paramAnonymousat.tD(bt.nullAsNil(((c)localObject).Kv()));
              if (bt.isNullOrNil(((c)localObject).Kv())) {
                ad.w("MicroMsg.SubCoreBiz", "Enterprise belong is null:%s", new Object[] { paramAnonymousat.field_username });
              }
              AppMethodBeat.o(124151);
              return;
            }
            if ((((c)localObject).Kk()) || (((c)localObject).Kn()) || (w.Al(paramAnonymousbq)))
            {
              paramAnonymousat.tD(null);
              AppMethodBeat.o(124151);
              return;
            }
            paramAnonymousat.tD("officialaccounts");
          }
        }
        AppMethodBeat.o(124151);
      }
    };
    this.hRk = new f.a()
    {
      public final void a(f.a.b paramAnonymousb)
      {
        AppMethodBeat.i(124149);
        Object localObject;
        at localat;
        int i;
        if ((paramAnonymousb.hQa == f.a.a.hPW) || (paramAnonymousb.hQa == f.a.a.hPY))
        {
          if (paramAnonymousb.hQb == null)
          {
            AppMethodBeat.o(124149);
            return;
          }
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramAnonymousb.hPO);
          if (localObject == null)
          {
            AppMethodBeat.o(124149);
            return;
          }
          if (!((am)localObject).fqg())
          {
            ag.l(paramAnonymousb.hQb);
            AppMethodBeat.o(124149);
            return;
          }
          if (w.zQ(((aw)localObject).field_username))
          {
            AppMethodBeat.o(124149);
            return;
          }
          localat = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().aTz(paramAnonymousb.hPO);
          ad.v("MicroMsg.SubCoreBiz", "hakon onEvent bizName = %s", new Object[] { paramAnonymousb.hPO });
          if ((paramAnonymousb.hQb.Ko()) && (paramAnonymousb.hQb.bX(false) != null) && (paramAnonymousb.hQb.bX(false).KP() != null) && (!bt.isNullOrNil(paramAnonymousb.hQb.Kv())) && (bt.isNullOrNil(paramAnonymousb.hQb.field_enterpriseFather)))
          {
            paramAnonymousb.hQb.field_enterpriseFather = paramAnonymousb.hQb.Kv();
            ag.aFZ().g(paramAnonymousb.hQb);
            ad.i("MicroMsg.SubCoreBiz", "hakon bizStgExt, %s set enterpriseFather %s", new Object[] { paramAnonymousb.hPO, paramAnonymousb.hQb.field_enterpriseFather });
          }
          if (localat == null)
          {
            AppMethodBeat.o(124149);
            return;
          }
          if (paramAnonymousb.hQb.Ko())
          {
            if (paramAnonymousb.hQb.bX(false) == null)
            {
              ad.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
              AppMethodBeat.o(124149);
              return;
            }
            if (paramAnonymousb.hQb.bX(false).KP() == null)
            {
              ad.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
              AppMethodBeat.o(124149);
              return;
            }
            localObject = localat.field_parentRef;
            ad.i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", new Object[] { paramAnonymousb.hQb.Kv(), paramAnonymousb.hPO });
            localat.tD(bt.nullAsNil(paramAnonymousb.hQb.Kv()));
            if ((localObject != null) && (localat.field_parentRef != null) && (!((String)localObject).equals(localat.field_parentRef))) {
              i = 1;
            }
          }
        }
        for (;;)
        {
          ad.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseChildType, %s, %s", new Object[] { paramAnonymousb.hPO, localat.field_parentRef });
          for (;;)
          {
            if (i != 0)
            {
              ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().a(localat, localat.field_username);
              if (bt.isNullOrNil(localat.field_parentRef))
              {
                AppMethodBeat.o(124149);
                return;
                if ((localObject == null) && (localat.field_parentRef != null))
                {
                  i = 1;
                  break;
                }
                if ((localObject == null) || (localat.field_parentRef != null)) {
                  break label1020;
                }
                i = 1;
                break;
                if (paramAnonymousb.hQb.Kn())
                {
                  ad.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseFatherType, %s", new Object[] { paramAnonymousb.hPO });
                  i = 1;
                  continue;
                }
                if ((!paramAnonymousb.hQb.Kk()) && (!w.Al(((aw)localObject).field_username)) && (!"officialaccounts".equals(localat.field_parentRef)))
                {
                  localat.tD("officialaccounts");
                  i = 1;
                  continue;
                }
                if ((!paramAnonymousb.hQb.Kk()) || (localat.field_parentRef == null)) {
                  break label1015;
                }
                localat.tD(null);
                i = 1;
                continue;
              }
              if ("officialaccounts".equals(localat.field_parentRef))
              {
                localat = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().aTz("officialaccounts");
                paramAnonymousb = localat;
                if (localat == null)
                {
                  paramAnonymousb = new at("officialaccounts");
                  paramAnonymousb.fqK();
                  ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().e(paramAnonymousb);
                }
                if (bt.isNullOrNil(paramAnonymousb.field_content))
                {
                  ad.i("MicroMsg.SubCoreBiz", "conv content is null");
                  paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().fqS();
                  if (bt.isNullOrNil(paramAnonymousb))
                  {
                    ad.w("MicroMsg.SubCoreBiz", "last convBiz is null");
                    AppMethodBeat.o(124149);
                    return;
                  }
                  paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().apX(paramAnonymousb);
                  if ((paramAnonymousb == null) || (paramAnonymousb.field_msgId == 0L))
                  {
                    ad.w("MicroMsg.SubCoreBiz", "last biz msg is error");
                    AppMethodBeat.o(124149);
                    return;
                  }
                  ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(paramAnonymousb.field_msgId, paramAnonymousb);
                }
                AppMethodBeat.o(124149);
                return;
              }
              ad.i("MicroMsg.SubCoreBiz", "hakon username = %s, parentRef = %s", new Object[] { paramAnonymousb.hPO, localat.field_parentRef });
              paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().aTz(localat.field_parentRef);
              if (paramAnonymousb == null)
              {
                AppMethodBeat.o(124149);
                return;
              }
              if (bt.isNullOrNil(paramAnonymousb.field_content))
              {
                ad.i("MicroMsg.SubCoreBiz", "conv content is null");
                paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().aTM(localat.field_parentRef);
                if (bt.isNullOrNil(paramAnonymousb))
                {
                  ad.w("MicroMsg.SubCoreBiz", "last enterprise convBiz is null");
                  AppMethodBeat.o(124149);
                  return;
                }
                paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().apX(paramAnonymousb);
                if ((paramAnonymousb == null) || (paramAnonymousb.field_msgId == 0L))
                {
                  ad.w("MicroMsg.SubCoreBiz", "last enterprise biz msg is error");
                  AppMethodBeat.o(124149);
                  return;
                }
                ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(paramAnonymousb.field_msgId, paramAnonymousb);
              }
            }
            AppMethodBeat.o(124149);
            return;
            label1015:
            i = 0;
          }
          label1020:
          i = 0;
        }
      }
    };
    AppMethodBeat.o(124152);
  }
  
  private static ag aFX()
  {
    try
    {
      AppMethodBeat.i(124153);
      ag localag = (ag)t.ap(ag.class);
      AppMethodBeat.o(124153);
      return localag;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static j aFY()
  {
    AppMethodBeat.i(124154);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (aFX().hQW == null) {
      aFX().hQW = new j(com.tencent.mm.kernel.g.ajC().gBq);
    }
    j localj = aFX().hQW;
    AppMethodBeat.o(124154);
    return localj;
  }
  
  public static f aFZ()
  {
    AppMethodBeat.i(124155);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (aFX().hQT == null) {
      aFX().hQT = new f(com.tencent.mm.kernel.g.ajC().gBq);
    }
    f localf = aFX().hQT;
    AppMethodBeat.o(124155);
    return localf;
  }
  
  public static i aGa()
  {
    AppMethodBeat.i(124156);
    com.tencent.mm.kernel.g.ajA().aiF();
    i locali;
    if (aFX().hQX == null)
    {
      aFX().hQX = new i();
      locali = aFX().hQX;
      com.tencent.mm.kernel.g.ajB().gAO.a(675, locali);
      com.tencent.mm.kernel.g.ajB().gAO.a(672, locali);
      com.tencent.mm.kernel.g.ajB().gAO.a(674, locali);
    }
    for (;;)
    {
      synchronized (locali.dcK)
      {
        locali.hQf.clear();
        ??? = locali.hQc;
        if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBN, 0) == 1) || (com.tencent.mm.sdk.platformtools.i.DEBUG) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED))
        {
          bool = true;
          ((i.a)???).hQg = bool;
          locali.hQc.appId = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBQ, "wx3591b9dad10767f7");
          locali.hQc.path = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBR, "pages/profile/profile.html");
          locali.hQc.hQh = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBS, 0);
          ad.i("MicroMsg.BizKFService", "alvinluo initKFGuideAppBrandConfig: %s", new Object[] { locali.hQc });
          locali = aFX().hQX;
          AppMethodBeat.o(124156);
          return locali;
        }
      }
      boolean bool = false;
    }
  }
  
  public static d aGb()
  {
    AppMethodBeat.i(124157);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (aFX().hQY == null) {
      aFX().hQY = new d(com.tencent.mm.kernel.g.ajC().gBq);
    }
    d locald = aFX().hQY;
    AppMethodBeat.o(124157);
    return locald;
  }
  
  public static com.tencent.mm.am.a.b aGc()
  {
    AppMethodBeat.i(124158);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (aFX().hQZ == null) {
      aFX().hQZ = new com.tencent.mm.am.a.b(com.tencent.mm.kernel.g.ajC().gBq);
    }
    com.tencent.mm.am.a.b localb = aFX().hQZ;
    AppMethodBeat.o(124158);
    return localb;
  }
  
  public static com.tencent.mm.am.a.l aGd()
  {
    AppMethodBeat.i(124159);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (aFX().hRa == null) {
      aFX().hRa = new com.tencent.mm.am.a.l(com.tencent.mm.kernel.g.ajC().gBq);
    }
    com.tencent.mm.am.a.l locall = aFX().hRa;
    AppMethodBeat.o(124159);
    return locall;
  }
  
  public static com.tencent.mm.am.a.g aGe()
  {
    AppMethodBeat.i(124160);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (aFX().hRb == null) {
      aFX().hRb = new com.tencent.mm.am.a.g(com.tencent.mm.kernel.g.ajC().gBq);
    }
    com.tencent.mm.am.a.g localg = aFX().hRb;
    AppMethodBeat.o(124160);
    return localg;
  }
  
  public static x aGf()
  {
    AppMethodBeat.i(124161);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (aFX().hRf == null) {
      aFX().hRf = new x(com.tencent.mm.kernel.g.ajC().gBq);
    }
    x localx = aFX().hRf;
    AppMethodBeat.o(124161);
    return localx;
  }
  
  public static z aGg()
  {
    AppMethodBeat.i(124162);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (aFX().hRg == null) {
      aFX().hRg = new z(com.tencent.mm.kernel.g.ajC().gBq);
    }
    z localz = aFX().hRg;
    AppMethodBeat.o(124162);
    return localz;
  }
  
  public static h aGh()
  {
    AppMethodBeat.i(124163);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (aFX().hRd == null) {
      aFX().hRd = new h();
    }
    h localh = aFX().hRd;
    AppMethodBeat.o(124163);
    return localh;
  }
  
  public static e aGi()
  {
    AppMethodBeat.i(124164);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (aFX().hRe == null) {
      aFX().hRe = new e(com.tencent.mm.kernel.g.ajC().gBq);
    }
    e locale = aFX().hRe;
    AppMethodBeat.o(124164);
    return locale;
  }
  
  public static o.a aGj()
  {
    AppMethodBeat.i(124165);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (aFX().hQU == null) {
      aFX().hQU = new o.a();
    }
    o.a locala = aFX().hQU;
    AppMethodBeat.o(124165);
    return locala;
  }
  
  public static l aGk()
  {
    AppMethodBeat.i(124166);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (aFX().hQV == null) {
      aFX().hQV = new l();
    }
    l locall = aFX().hQV;
    AppMethodBeat.o(124166);
    return locall;
  }
  
  public static a aGl()
  {
    AppMethodBeat.i(124167);
    if (aFX().hRh == null) {
      aFX().hRh = new a();
    }
    a locala = aFX().hRh;
    AppMethodBeat.o(124167);
    return locala;
  }
  
  public static com.tencent.mm.am.a.i aGm()
  {
    AppMethodBeat.i(124168);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (aFX().hRc == null) {
      aFX().hRc = new com.tencent.mm.am.a.i();
    }
    com.tencent.mm.am.a.i locali = aFX().hRc;
    AppMethodBeat.o(124168);
    return locali;
  }
  
  public static long aGn()
  {
    AppMethodBeat.i(124169);
    if (hQS == 0L)
    {
      Object localObject = com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ird, null);
      if ((localObject != null) && ((localObject instanceof Long)))
      {
        hQS = ((Long)localObject).longValue();
        ad.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime : %d.(get from ConfigStorage)", new Object[] { Long.valueOf(hQS) });
      }
    }
    if (hQS == 0L)
    {
      hQS = System.currentTimeMillis();
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Ird, Long.valueOf(hQS));
      ad.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime is 0, so get current time : %d.", new Object[] { Long.valueOf(hQS) });
    }
    long l = hQS;
    AppMethodBeat.o(124169);
    return l;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(124170);
    e.d.a(Integer.valueOf(55), this.hGc);
    e.d.a(Integer.valueOf(57), this.hGc);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().c(this.hRj);
    aFZ().a(this.hRk, null);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("mmbizattrappsvr_BizAttrSync", this.hRi, true);
    AppMethodBeat.o(124170);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(124171);
    e.d.b(Integer.valueOf(55), this.hGc);
    e.d.b(Integer.valueOf(57), this.hGc);
    i locali;
    if (aFX().hQX != null)
    {
      locali = aFX().hQX;
      com.tencent.mm.kernel.g.ajB().gAO.b(675, locali);
      com.tencent.mm.kernel.g.ajB().gAO.b(672, locali);
      com.tencent.mm.kernel.g.ajB().gAO.b(674, locali);
    }
    synchronized (locali.dcK)
    {
      locali.hQf.clear();
      locali.hQe.clear();
      if (com.tencent.mm.kernel.g.ajA().aiK())
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().d(this.hRj);
        aFZ().a(this.hRk);
      }
      ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("mmbizattrappsvr_BizAttrSync", this.hRi, true);
      AppMethodBeat.o(124171);
      return;
    }
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.am.ag
 * JD-Core Version:    0.7.0.1
 */