package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.d;
import com.tencent.mm.al.a.l;
import com.tencent.mm.api.c;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.az;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bk.a;
import com.tencent.mm.storage.u;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class af
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static long hyy;
  private com.tencent.mm.model.e hnK;
  private n.a hyA;
  private k hyB;
  private i hyC;
  private h hyD;
  private com.tencent.mm.al.a.d hyE;
  private com.tencent.mm.al.a.b hyF;
  private l hyG;
  private com.tencent.mm.al.a.g hyH;
  private com.tencent.mm.al.a.i hyI;
  private com.tencent.mm.al.a.h hyJ;
  private d hyK;
  private u hyL;
  private com.tencent.mm.storage.w hyM;
  private a hyN;
  private cc.a hyO;
  private bk.a hyP;
  private e.a hyQ;
  private e hyz;
  
  static
  {
    AppMethodBeat.i(124173);
    hyy = 0L;
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("BIZINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return e.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("BIZKF_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return i.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("BIZCHAT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.al.a.d.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("BIZCHATUSER_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return l.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("BIZCONVERSATION_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.al.a.b.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("BIZCHAMYUSERINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.al.a.g.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("BIZENTERPRISE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return d.SQL_CREATE;
      }
    });
    AppMethodBeat.o(124173);
  }
  
  public af()
  {
    AppMethodBeat.i(124152);
    this.hyA = null;
    this.hyB = null;
    this.hyD = null;
    this.hyE = null;
    this.hyF = null;
    this.hyG = null;
    this.hyH = null;
    this.hyI = null;
    this.hyJ = null;
    this.hyK = null;
    this.hyL = null;
    this.hyM = null;
    this.hnK = new com.tencent.mm.model.e();
    this.hyO = new af.9(this);
    this.hyP = new bk.a()
    {
      public final void a(ap paramAnonymousap, bk paramAnonymousbk)
      {
        AppMethodBeat.i(124151);
        if ((paramAnonymousap != null) && (!bs.isNullOrNil(paramAnonymousap.field_username)))
        {
          paramAnonymousbk = paramAnonymousap.field_username;
          Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramAnonymousbk);
          if (localObject == null)
          {
            AppMethodBeat.o(124151);
            return;
          }
          if ((((ai)localObject).fad()) && (!com.tencent.mm.model.w.wT(paramAnonymousbk)))
          {
            localObject = af.aCW().AE(paramAnonymousbk);
            if (((c)localObject).systemRowid == -1L)
            {
              ac.i("MicroMsg.SubCoreBiz", "onMsgChangeNotify: no bizInfo");
              AppMethodBeat.o(124151);
              return;
            }
            if (((c)localObject).IO())
            {
              if (((c)localObject).bV(false) == null)
              {
                paramAnonymousap.qT(null);
                ac.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
                AppMethodBeat.o(124151);
                return;
              }
              if (((c)localObject).bV(false).Jq() == null)
              {
                paramAnonymousap.qT(null);
                ac.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
                AppMethodBeat.o(124151);
                return;
              }
              paramAnonymousap.qT(bs.nullAsNil(((c)localObject).IV()));
              if (bs.isNullOrNil(((c)localObject).IV())) {
                ac.w("MicroMsg.SubCoreBiz", "Enterprise belong is null:%s", new Object[] { paramAnonymousap.field_username });
              }
              AppMethodBeat.o(124151);
              return;
            }
            if ((((c)localObject).IK()) || (((c)localObject).IN()) || (com.tencent.mm.model.w.xo(paramAnonymousbk)))
            {
              paramAnonymousap.qT(null);
              AppMethodBeat.o(124151);
              return;
            }
            paramAnonymousap.qT("officialaccounts");
          }
        }
        AppMethodBeat.o(124151);
      }
    };
    this.hyQ = new e.a()
    {
      public final void a(e.a.b paramAnonymousb)
      {
        AppMethodBeat.i(124149);
        Object localObject;
        ap localap;
        int i;
        if ((paramAnonymousb.hxF == e.a.a.hxB) || (paramAnonymousb.hxF == e.a.a.hxD))
        {
          if (paramAnonymousb.hxG == null)
          {
            AppMethodBeat.o(124149);
            return;
          }
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramAnonymousb.hxt);
          if (localObject == null)
          {
            AppMethodBeat.o(124149);
            return;
          }
          if (!((ai)localObject).fad())
          {
            af.l(paramAnonymousb.hxG);
            AppMethodBeat.o(124149);
            return;
          }
          if (com.tencent.mm.model.w.wT(((av)localObject).field_username))
          {
            AppMethodBeat.o(124149);
            return;
          }
          localap = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNI(paramAnonymousb.hxt);
          ac.v("MicroMsg.SubCoreBiz", "hakon onEvent bizName = %s", new Object[] { paramAnonymousb.hxt });
          if ((paramAnonymousb.hxG.IO()) && (paramAnonymousb.hxG.bV(false) != null) && (paramAnonymousb.hxG.bV(false).Jq() != null) && (!bs.isNullOrNil(paramAnonymousb.hxG.IV())) && (bs.isNullOrNil(paramAnonymousb.hxG.field_enterpriseFather)))
          {
            paramAnonymousb.hxG.field_enterpriseFather = paramAnonymousb.hxG.IV();
            af.aCW().g(paramAnonymousb.hxG);
            ac.i("MicroMsg.SubCoreBiz", "hakon bizStgExt, %s set enterpriseFather %s", new Object[] { paramAnonymousb.hxt, paramAnonymousb.hxG.field_enterpriseFather });
          }
          if (localap == null)
          {
            AppMethodBeat.o(124149);
            return;
          }
          if (paramAnonymousb.hxG.IO())
          {
            if (paramAnonymousb.hxG.bV(false) == null)
            {
              ac.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
              AppMethodBeat.o(124149);
              return;
            }
            if (paramAnonymousb.hxG.bV(false).Jq() == null)
            {
              ac.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
              AppMethodBeat.o(124149);
              return;
            }
            localObject = localap.field_parentRef;
            ac.i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", new Object[] { paramAnonymousb.hxG.IV(), paramAnonymousb.hxt });
            localap.qT(bs.nullAsNil(paramAnonymousb.hxG.IV()));
            if ((localObject != null) && (localap.field_parentRef != null) && (!((String)localObject).equals(localap.field_parentRef))) {
              i = 1;
            }
          }
        }
        for (;;)
        {
          ac.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseChildType, %s, %s", new Object[] { paramAnonymousb.hxt, localap.field_parentRef });
          for (;;)
          {
            if (i != 0)
            {
              ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().a(localap, localap.field_username);
              if (bs.isNullOrNil(localap.field_parentRef))
              {
                AppMethodBeat.o(124149);
                return;
                if ((localObject == null) && (localap.field_parentRef != null))
                {
                  i = 1;
                  break;
                }
                if ((localObject == null) || (localap.field_parentRef != null)) {
                  break label1020;
                }
                i = 1;
                break;
                if (paramAnonymousb.hxG.IN())
                {
                  ac.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseFatherType, %s", new Object[] { paramAnonymousb.hxt });
                  i = 1;
                  continue;
                }
                if ((!paramAnonymousb.hxG.IK()) && (!com.tencent.mm.model.w.xo(((av)localObject).field_username)) && (!"officialaccounts".equals(localap.field_parentRef)))
                {
                  localap.qT("officialaccounts");
                  i = 1;
                  continue;
                }
                if ((!paramAnonymousb.hxG.IK()) || (localap.field_parentRef == null)) {
                  break label1015;
                }
                localap.qT(null);
                i = 1;
                continue;
              }
              if ("officialaccounts".equals(localap.field_parentRef))
              {
                localap = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNI("officialaccounts");
                paramAnonymousb = localap;
                if (localap == null)
                {
                  paramAnonymousb = new ap("officialaccounts");
                  paramAnonymousb.faH();
                  ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().e(paramAnonymousb);
                }
                if (bs.isNullOrNil(paramAnonymousb.field_content))
                {
                  ac.i("MicroMsg.SubCoreBiz", "conv content is null");
                  paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().faP();
                  if (bs.isNullOrNil(paramAnonymousb))
                  {
                    ac.w("MicroMsg.SubCoreBiz", "last convBiz is null");
                    AppMethodBeat.o(124149);
                    return;
                  }
                  paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alk(paramAnonymousb);
                  if ((paramAnonymousb == null) || (paramAnonymousb.field_msgId == 0L))
                  {
                    ac.w("MicroMsg.SubCoreBiz", "last biz msg is error");
                    AppMethodBeat.o(124149);
                    return;
                  }
                  ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(paramAnonymousb.field_msgId, paramAnonymousb);
                }
                AppMethodBeat.o(124149);
                return;
              }
              ac.i("MicroMsg.SubCoreBiz", "hakon username = %s, parentRef = %s", new Object[] { paramAnonymousb.hxt, localap.field_parentRef });
              paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNI(localap.field_parentRef);
              if (paramAnonymousb == null)
              {
                AppMethodBeat.o(124149);
                return;
              }
              if (bs.isNullOrNil(paramAnonymousb.field_content))
              {
                ac.i("MicroMsg.SubCoreBiz", "conv content is null");
                paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNV(localap.field_parentRef);
                if (bs.isNullOrNil(paramAnonymousb))
                {
                  ac.w("MicroMsg.SubCoreBiz", "last enterprise convBiz is null");
                  AppMethodBeat.o(124149);
                  return;
                }
                paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alk(paramAnonymousb);
                if ((paramAnonymousb == null) || (paramAnonymousb.field_msgId == 0L))
                {
                  ac.w("MicroMsg.SubCoreBiz", "last enterprise biz msg is error");
                  AppMethodBeat.o(124149);
                  return;
                }
                ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(paramAnonymousb.field_msgId, paramAnonymousb);
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
  
  private static af aCU()
  {
    try
    {
      AppMethodBeat.i(124153);
      af localaf = (af)t.ap(af.class);
      AppMethodBeat.o(124153);
      return localaf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static i aCV()
  {
    AppMethodBeat.i(124154);
    com.tencent.mm.kernel.g.agP().afT();
    if (aCU().hyC == null) {
      aCU().hyC = new i(com.tencent.mm.kernel.g.agR().ghG);
    }
    i locali = aCU().hyC;
    AppMethodBeat.o(124154);
    return locali;
  }
  
  public static e aCW()
  {
    AppMethodBeat.i(124155);
    com.tencent.mm.kernel.g.agP().afT();
    if (aCU().hyz == null) {
      aCU().hyz = new e(com.tencent.mm.kernel.g.agR().ghG);
    }
    e locale = aCU().hyz;
    AppMethodBeat.o(124155);
    return locale;
  }
  
  public static h aCX()
  {
    AppMethodBeat.i(124156);
    com.tencent.mm.kernel.g.agP().afT();
    h localh;
    if (aCU().hyD == null)
    {
      aCU().hyD = new h();
      localh = aCU().hyD;
      com.tencent.mm.kernel.g.agQ().ghe.a(675, localh);
      com.tencent.mm.kernel.g.agQ().ghe.a(672, localh);
      com.tencent.mm.kernel.g.agQ().ghe.a(674, localh);
    }
    for (;;)
    {
      synchronized (localh.cRu)
      {
        localh.hxK.clear();
        ??? = localh.hxH;
        if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pWN, 0) == 1) || (com.tencent.mm.sdk.platformtools.h.DEBUG) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED))
        {
          bool = true;
          ((h.a)???).hxL = bool;
          localh.hxH.appId = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pWO, "wx3591b9dad10767f7");
          localh.hxH.path = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pWP, "pages/profile/profile.html");
          localh.hxH.hxM = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pWQ, 0);
          ac.i("MicroMsg.BizKFService", "alvinluo initKFGuideAppBrandConfig: %s", new Object[] { localh.hxH });
          localh = aCU().hyD;
          AppMethodBeat.o(124156);
          return localh;
        }
      }
      boolean bool = false;
    }
  }
  
  public static com.tencent.mm.al.a.d aCY()
  {
    AppMethodBeat.i(124157);
    com.tencent.mm.kernel.g.agP().afT();
    if (aCU().hyE == null) {
      aCU().hyE = new com.tencent.mm.al.a.d(com.tencent.mm.kernel.g.agR().ghG);
    }
    com.tencent.mm.al.a.d locald = aCU().hyE;
    AppMethodBeat.o(124157);
    return locald;
  }
  
  public static com.tencent.mm.al.a.b aCZ()
  {
    AppMethodBeat.i(124158);
    com.tencent.mm.kernel.g.agP().afT();
    if (aCU().hyF == null) {
      aCU().hyF = new com.tencent.mm.al.a.b(com.tencent.mm.kernel.g.agR().ghG);
    }
    com.tencent.mm.al.a.b localb = aCU().hyF;
    AppMethodBeat.o(124158);
    return localb;
  }
  
  public static l aDa()
  {
    AppMethodBeat.i(124159);
    com.tencent.mm.kernel.g.agP().afT();
    if (aCU().hyG == null) {
      aCU().hyG = new l(com.tencent.mm.kernel.g.agR().ghG);
    }
    l locall = aCU().hyG;
    AppMethodBeat.o(124159);
    return locall;
  }
  
  public static com.tencent.mm.al.a.g aDb()
  {
    AppMethodBeat.i(124160);
    com.tencent.mm.kernel.g.agP().afT();
    if (aCU().hyH == null) {
      aCU().hyH = new com.tencent.mm.al.a.g(com.tencent.mm.kernel.g.agR().ghG);
    }
    com.tencent.mm.al.a.g localg = aCU().hyH;
    AppMethodBeat.o(124160);
    return localg;
  }
  
  public static u aDc()
  {
    AppMethodBeat.i(124161);
    com.tencent.mm.kernel.g.agP().afT();
    if (aCU().hyL == null) {
      aCU().hyL = new u(com.tencent.mm.kernel.g.agR().ghG);
    }
    u localu = aCU().hyL;
    AppMethodBeat.o(124161);
    return localu;
  }
  
  public static com.tencent.mm.storage.w aDd()
  {
    AppMethodBeat.i(124162);
    com.tencent.mm.kernel.g.agP().afT();
    if (aCU().hyM == null) {
      aCU().hyM = new com.tencent.mm.storage.w(com.tencent.mm.kernel.g.agR().ghG);
    }
    com.tencent.mm.storage.w localw = aCU().hyM;
    AppMethodBeat.o(124162);
    return localw;
  }
  
  public static com.tencent.mm.al.a.h aDe()
  {
    AppMethodBeat.i(124163);
    com.tencent.mm.kernel.g.agP().afT();
    if (aCU().hyJ == null) {
      aCU().hyJ = new com.tencent.mm.al.a.h();
    }
    com.tencent.mm.al.a.h localh = aCU().hyJ;
    AppMethodBeat.o(124163);
    return localh;
  }
  
  public static d aDf()
  {
    AppMethodBeat.i(124164);
    com.tencent.mm.kernel.g.agP().afT();
    if (aCU().hyK == null) {
      aCU().hyK = new d(com.tencent.mm.kernel.g.agR().ghG);
    }
    d locald = aCU().hyK;
    AppMethodBeat.o(124164);
    return locald;
  }
  
  public static n.a aDg()
  {
    AppMethodBeat.i(124165);
    com.tencent.mm.kernel.g.agP().afT();
    if (aCU().hyA == null) {
      aCU().hyA = new n.a();
    }
    n.a locala = aCU().hyA;
    AppMethodBeat.o(124165);
    return locala;
  }
  
  public static k aDh()
  {
    AppMethodBeat.i(124166);
    com.tencent.mm.kernel.g.agP().afT();
    if (aCU().hyB == null) {
      aCU().hyB = new k();
    }
    k localk = aCU().hyB;
    AppMethodBeat.o(124166);
    return localk;
  }
  
  public static a aDi()
  {
    AppMethodBeat.i(124167);
    if (aCU().hyN == null) {
      aCU().hyN = new a();
    }
    a locala = aCU().hyN;
    AppMethodBeat.o(124167);
    return locala;
  }
  
  public static com.tencent.mm.al.a.i aDj()
  {
    AppMethodBeat.i(124168);
    com.tencent.mm.kernel.g.agP().afT();
    if (aCU().hyI == null) {
      aCU().hyI = new com.tencent.mm.al.a.i();
    }
    com.tencent.mm.al.a.i locali = aCU().hyI;
    AppMethodBeat.o(124168);
    return locali;
  }
  
  public static long aDk()
  {
    AppMethodBeat.i(124169);
    if (hyy == 0L)
    {
      Object localObject = com.tencent.mm.kernel.g.agR().agA().get(ah.a.GEK, null);
      if ((localObject != null) && ((localObject instanceof Long)))
      {
        hyy = ((Long)localObject).longValue();
        ac.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime : %d.(get from ConfigStorage)", new Object[] { Long.valueOf(hyy) });
      }
    }
    if (hyy == 0L)
    {
      hyy = System.currentTimeMillis();
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GEK, Long.valueOf(hyy));
      ac.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime is 0, so get current time : %d.", new Object[] { Long.valueOf(hyy) });
    }
    long l = hyy;
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
    f.d.a(Integer.valueOf(55), this.hnK);
    f.d.a(Integer.valueOf(57), this.hnK);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().c(this.hyP);
    aCW().a(this.hyQ, null);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("mmbizattrappsvr_BizAttrSync", this.hyO, true);
    AppMethodBeat.o(124170);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(124171);
    f.d.b(Integer.valueOf(55), this.hnK);
    f.d.b(Integer.valueOf(57), this.hnK);
    h localh;
    if (aCU().hyD != null)
    {
      localh = aCU().hyD;
      com.tencent.mm.kernel.g.agQ().ghe.b(675, localh);
      com.tencent.mm.kernel.g.agQ().ghe.b(672, localh);
      com.tencent.mm.kernel.g.agQ().ghe.b(674, localh);
    }
    synchronized (localh.cRu)
    {
      localh.hxK.clear();
      localh.hxJ.clear();
      if (com.tencent.mm.kernel.g.agP().afY())
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().d(this.hyP);
        aCW().a(this.hyQ);
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("mmbizattrappsvr_BizAttrSync", this.hyO, true);
      AppMethodBeat.o(124171);
      return;
    }
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.af
 * JD-Core Version:    0.7.0.1
 */