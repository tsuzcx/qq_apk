package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.a.d;
import com.tencent.mm.al.a.h;
import com.tencent.mm.api.c;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.br.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class ag
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static long hTK;
  private com.tencent.mm.model.e hIU;
  private f hTL;
  private o.a hTM;
  private l hTN;
  private j hTO;
  private i hTP;
  private d hTQ;
  private com.tencent.mm.al.a.b hTR;
  private com.tencent.mm.al.a.l hTS;
  private com.tencent.mm.al.a.g hTT;
  private com.tencent.mm.al.a.i hTU;
  private h hTV;
  private e hTW;
  private com.tencent.mm.storage.x hTX;
  private z hTY;
  private a hTZ;
  private cf.a hUa;
  private br.a hUb;
  private f.a hUc;
  
  static
  {
    AppMethodBeat.i(124173);
    hTK = 0L;
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
    baseDBFactories.put(Integer.valueOf("BIZCHAT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return d.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("BIZCHATUSER_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.al.a.l.SQL_CREATE;
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
        return e.SQL_CREATE;
      }
    });
    AppMethodBeat.o(124173);
  }
  
  public ag()
  {
    AppMethodBeat.i(124152);
    this.hTM = null;
    this.hTN = null;
    this.hTP = null;
    this.hTQ = null;
    this.hTR = null;
    this.hTS = null;
    this.hTT = null;
    this.hTU = null;
    this.hTV = null;
    this.hTW = null;
    this.hTX = null;
    this.hTY = null;
    this.hIU = new com.tencent.mm.model.e();
    this.hUa = new ag.9(this);
    this.hUb = new br.a()
    {
      public final void a(au paramAnonymousau, br paramAnonymousbr)
      {
        AppMethodBeat.i(124151);
        if ((paramAnonymousau != null) && (!bu.isNullOrNil(paramAnonymousau.field_username)))
        {
          paramAnonymousbr = paramAnonymousau.field_username;
          Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramAnonymousbr);
          if (localObject == null)
          {
            AppMethodBeat.o(124151);
            return;
          }
          if ((((an)localObject).fug()) && (!com.tencent.mm.model.x.AA(paramAnonymousbr)))
          {
            localObject = ag.aGp().Ef(paramAnonymousbr);
            if (((c)localObject).systemRowid == -1L)
            {
              ae.i("MicroMsg.SubCoreBiz", "onMsgChangeNotify: no bizInfo");
              AppMethodBeat.o(124151);
              return;
            }
            if (((c)localObject).Kw())
            {
              if (((c)localObject).bX(false) == null)
              {
                paramAnonymousau.tY(null);
                ae.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
                AppMethodBeat.o(124151);
                return;
              }
              if (((c)localObject).bX(false).KX() == null)
              {
                paramAnonymousau.tY(null);
                ae.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
                AppMethodBeat.o(124151);
                return;
              }
              paramAnonymousau.tY(bu.nullAsNil(((c)localObject).KD()));
              if (bu.isNullOrNil(((c)localObject).KD())) {
                ae.w("MicroMsg.SubCoreBiz", "Enterprise belong is null:%s", new Object[] { paramAnonymousau.field_username });
              }
              AppMethodBeat.o(124151);
              return;
            }
            if ((((c)localObject).Ks()) || (((c)localObject).Kv()) || (com.tencent.mm.model.x.AV(paramAnonymousbr)))
            {
              paramAnonymousau.tY(null);
              AppMethodBeat.o(124151);
              return;
            }
            paramAnonymousau.tY("officialaccounts");
          }
        }
        AppMethodBeat.o(124151);
      }
    };
    this.hUc = new f.a()
    {
      public final void a(f.a.b paramAnonymousb)
      {
        AppMethodBeat.i(124149);
        Object localObject;
        au localau;
        int i;
        if ((paramAnonymousb.hSS == f.a.a.hSO) || (paramAnonymousb.hSS == f.a.a.hSQ))
        {
          if (paramAnonymousb.hST == null)
          {
            AppMethodBeat.o(124149);
            return;
          }
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramAnonymousb.hSG);
          if (localObject == null)
          {
            AppMethodBeat.o(124149);
            return;
          }
          if (!((an)localObject).fug())
          {
            ag.l(paramAnonymousb.hST);
            AppMethodBeat.o(124149);
            return;
          }
          if (com.tencent.mm.model.x.AA(((aw)localObject).field_username))
          {
            AppMethodBeat.o(124149);
            return;
          }
          localau = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aVa(paramAnonymousb.hSG);
          ae.v("MicroMsg.SubCoreBiz", "hakon onEvent bizName = %s", new Object[] { paramAnonymousb.hSG });
          if ((paramAnonymousb.hST.Kw()) && (paramAnonymousb.hST.bX(false) != null) && (paramAnonymousb.hST.bX(false).KX() != null) && (!bu.isNullOrNil(paramAnonymousb.hST.KD())) && (bu.isNullOrNil(paramAnonymousb.hST.field_enterpriseFather)))
          {
            paramAnonymousb.hST.field_enterpriseFather = paramAnonymousb.hST.KD();
            ag.aGp().g(paramAnonymousb.hST);
            ae.i("MicroMsg.SubCoreBiz", "hakon bizStgExt, %s set enterpriseFather %s", new Object[] { paramAnonymousb.hSG, paramAnonymousb.hST.field_enterpriseFather });
          }
          if (localau == null)
          {
            AppMethodBeat.o(124149);
            return;
          }
          if (paramAnonymousb.hST.Kw())
          {
            if (paramAnonymousb.hST.bX(false) == null)
            {
              ae.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
              AppMethodBeat.o(124149);
              return;
            }
            if (paramAnonymousb.hST.bX(false).KX() == null)
            {
              ae.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
              AppMethodBeat.o(124149);
              return;
            }
            localObject = localau.field_parentRef;
            ae.i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", new Object[] { paramAnonymousb.hST.KD(), paramAnonymousb.hSG });
            localau.tY(bu.nullAsNil(paramAnonymousb.hST.KD()));
            if ((localObject != null) && (localau.field_parentRef != null) && (!((String)localObject).equals(localau.field_parentRef))) {
              i = 1;
            }
          }
        }
        for (;;)
        {
          ae.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseChildType, %s, %s", new Object[] { paramAnonymousb.hSG, localau.field_parentRef });
          for (;;)
          {
            if (i != 0)
            {
              ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().a(localau, localau.field_username);
              if (bu.isNullOrNil(localau.field_parentRef))
              {
                AppMethodBeat.o(124149);
                return;
                if ((localObject == null) && (localau.field_parentRef != null))
                {
                  i = 1;
                  break;
                }
                if ((localObject == null) || (localau.field_parentRef != null)) {
                  break label1020;
                }
                i = 1;
                break;
                if (paramAnonymousb.hST.Kv())
                {
                  ae.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseFatherType, %s", new Object[] { paramAnonymousb.hSG });
                  i = 1;
                  continue;
                }
                if ((!paramAnonymousb.hST.Ks()) && (!com.tencent.mm.model.x.AV(((aw)localObject).field_username)) && (!"officialaccounts".equals(localau.field_parentRef)))
                {
                  localau.tY("officialaccounts");
                  i = 1;
                  continue;
                }
                if ((!paramAnonymousb.hST.Ks()) || (localau.field_parentRef == null)) {
                  break label1015;
                }
                localau.tY(null);
                i = 1;
                continue;
              }
              if ("officialaccounts".equals(localau.field_parentRef))
              {
                localau = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aVa("officialaccounts");
                paramAnonymousb = localau;
                if (localau == null)
                {
                  paramAnonymousb = new au("officialaccounts");
                  paramAnonymousb.fuK();
                  ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().e(paramAnonymousb);
                }
                if (bu.isNullOrNil(paramAnonymousb.field_content))
                {
                  ae.i("MicroMsg.SubCoreBiz", "conv content is null");
                  paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().fuS();
                  if (bu.isNullOrNil(paramAnonymousb))
                  {
                    ae.w("MicroMsg.SubCoreBiz", "last convBiz is null");
                    AppMethodBeat.o(124149);
                    return;
                  }
                  paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().arc(paramAnonymousb);
                  if ((paramAnonymousb == null) || (paramAnonymousb.field_msgId == 0L))
                  {
                    ae.w("MicroMsg.SubCoreBiz", "last biz msg is error");
                    AppMethodBeat.o(124149);
                    return;
                  }
                  ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(paramAnonymousb.field_msgId, paramAnonymousb);
                }
                AppMethodBeat.o(124149);
                return;
              }
              ae.i("MicroMsg.SubCoreBiz", "hakon username = %s, parentRef = %s", new Object[] { paramAnonymousb.hSG, localau.field_parentRef });
              paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aVa(localau.field_parentRef);
              if (paramAnonymousb == null)
              {
                AppMethodBeat.o(124149);
                return;
              }
              if (bu.isNullOrNil(paramAnonymousb.field_content))
              {
                ae.i("MicroMsg.SubCoreBiz", "conv content is null");
                paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aVn(localau.field_parentRef);
                if (bu.isNullOrNil(paramAnonymousb))
                {
                  ae.w("MicroMsg.SubCoreBiz", "last enterprise convBiz is null");
                  AppMethodBeat.o(124149);
                  return;
                }
                paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().arc(paramAnonymousb);
                if ((paramAnonymousb == null) || (paramAnonymousb.field_msgId == 0L))
                {
                  ae.w("MicroMsg.SubCoreBiz", "last enterprise biz msg is error");
                  AppMethodBeat.o(124149);
                  return;
                }
                ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(paramAnonymousb.field_msgId, paramAnonymousb);
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
  
  public static l aGA()
  {
    AppMethodBeat.i(124166);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (aGn().hTN == null) {
      aGn().hTN = new l();
    }
    l locall = aGn().hTN;
    AppMethodBeat.o(124166);
    return locall;
  }
  
  public static a aGB()
  {
    AppMethodBeat.i(124167);
    if (aGn().hTZ == null) {
      aGn().hTZ = new a();
    }
    a locala = aGn().hTZ;
    AppMethodBeat.o(124167);
    return locala;
  }
  
  public static com.tencent.mm.al.a.i aGC()
  {
    AppMethodBeat.i(124168);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (aGn().hTU == null) {
      aGn().hTU = new com.tencent.mm.al.a.i();
    }
    com.tencent.mm.al.a.i locali = aGn().hTU;
    AppMethodBeat.o(124168);
    return locali;
  }
  
  public static long aGD()
  {
    AppMethodBeat.i(124169);
    if (hTK == 0L)
    {
      Object localObject = com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ILz, null);
      if ((localObject != null) && ((localObject instanceof Long)))
      {
        hTK = ((Long)localObject).longValue();
        ae.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime : %d.(get from ConfigStorage)", new Object[] { Long.valueOf(hTK) });
      }
    }
    if (hTK == 0L)
    {
      hTK = System.currentTimeMillis();
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILz, Long.valueOf(hTK));
      ae.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime is 0, so get current time : %d.", new Object[] { Long.valueOf(hTK) });
    }
    long l = hTK;
    AppMethodBeat.o(124169);
    return l;
  }
  
  private static ag aGn()
  {
    try
    {
      AppMethodBeat.i(124153);
      ag localag = (ag)u.ap(ag.class);
      AppMethodBeat.o(124153);
      return localag;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static j aGo()
  {
    AppMethodBeat.i(124154);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (aGn().hTO == null) {
      aGn().hTO = new j(com.tencent.mm.kernel.g.ajR().gDX);
    }
    j localj = aGn().hTO;
    AppMethodBeat.o(124154);
    return localj;
  }
  
  public static f aGp()
  {
    AppMethodBeat.i(124155);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (aGn().hTL == null) {
      aGn().hTL = new f(com.tencent.mm.kernel.g.ajR().gDX);
    }
    f localf = aGn().hTL;
    AppMethodBeat.o(124155);
    return localf;
  }
  
  public static i aGq()
  {
    AppMethodBeat.i(124156);
    com.tencent.mm.kernel.g.ajP().aiU();
    i locali;
    if (aGn().hTP == null)
    {
      aGn().hTP = new i();
      locali = aGn().hTP;
      com.tencent.mm.kernel.g.ajQ().gDv.a(675, locali);
      com.tencent.mm.kernel.g.ajQ().gDv.a(672, locali);
      com.tencent.mm.kernel.g.ajQ().gDv.a(674, locali);
    }
    for (;;)
    {
      synchronized (locali.ddM)
      {
        locali.hSX.clear();
        ??? = locali.hSU;
        if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qJi, 0) == 1) || (com.tencent.mm.sdk.platformtools.j.DEBUG) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED))
        {
          bool = true;
          ((i.a)???).hSY = bool;
          locali.hSU.appId = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qJl, "wx3591b9dad10767f7");
          locali.hSU.path = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qJm, "pages/profile/profile.html");
          locali.hSU.hSZ = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qJn, 0);
          ae.i("MicroMsg.BizKFService", "alvinluo initKFGuideAppBrandConfig: %s", new Object[] { locali.hSU });
          locali = aGn().hTP;
          AppMethodBeat.o(124156);
          return locali;
        }
      }
      boolean bool = false;
    }
  }
  
  public static d aGr()
  {
    AppMethodBeat.i(124157);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (aGn().hTQ == null) {
      aGn().hTQ = new d(com.tencent.mm.kernel.g.ajR().gDX);
    }
    d locald = aGn().hTQ;
    AppMethodBeat.o(124157);
    return locald;
  }
  
  public static com.tencent.mm.al.a.b aGs()
  {
    AppMethodBeat.i(124158);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (aGn().hTR == null) {
      aGn().hTR = new com.tencent.mm.al.a.b(com.tencent.mm.kernel.g.ajR().gDX);
    }
    com.tencent.mm.al.a.b localb = aGn().hTR;
    AppMethodBeat.o(124158);
    return localb;
  }
  
  public static com.tencent.mm.al.a.l aGt()
  {
    AppMethodBeat.i(124159);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (aGn().hTS == null) {
      aGn().hTS = new com.tencent.mm.al.a.l(com.tencent.mm.kernel.g.ajR().gDX);
    }
    com.tencent.mm.al.a.l locall = aGn().hTS;
    AppMethodBeat.o(124159);
    return locall;
  }
  
  public static com.tencent.mm.al.a.g aGu()
  {
    AppMethodBeat.i(124160);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (aGn().hTT == null) {
      aGn().hTT = new com.tencent.mm.al.a.g(com.tencent.mm.kernel.g.ajR().gDX);
    }
    com.tencent.mm.al.a.g localg = aGn().hTT;
    AppMethodBeat.o(124160);
    return localg;
  }
  
  public static com.tencent.mm.storage.x aGv()
  {
    AppMethodBeat.i(124161);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (aGn().hTX == null) {
      aGn().hTX = new com.tencent.mm.storage.x(com.tencent.mm.kernel.g.ajR().gDX);
    }
    com.tencent.mm.storage.x localx = aGn().hTX;
    AppMethodBeat.o(124161);
    return localx;
  }
  
  public static z aGw()
  {
    AppMethodBeat.i(124162);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (aGn().hTY == null) {
      aGn().hTY = new z(com.tencent.mm.kernel.g.ajR().gDX);
    }
    z localz = aGn().hTY;
    AppMethodBeat.o(124162);
    return localz;
  }
  
  public static h aGx()
  {
    AppMethodBeat.i(124163);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (aGn().hTV == null) {
      aGn().hTV = new h();
    }
    h localh = aGn().hTV;
    AppMethodBeat.o(124163);
    return localh;
  }
  
  public static e aGy()
  {
    AppMethodBeat.i(124164);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (aGn().hTW == null) {
      aGn().hTW = new e(com.tencent.mm.kernel.g.ajR().gDX);
    }
    e locale = aGn().hTW;
    AppMethodBeat.o(124164);
    return locale;
  }
  
  public static o.a aGz()
  {
    AppMethodBeat.i(124165);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (aGn().hTM == null) {
      aGn().hTM = new o.a();
    }
    o.a locala = aGn().hTM;
    AppMethodBeat.o(124165);
    return locala;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(124170);
    e.d.a(Integer.valueOf(55), this.hIU);
    e.d.a(Integer.valueOf(57), this.hIU);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().c(this.hUb);
    aGp().a(this.hUc, null);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("mmbizattrappsvr_BizAttrSync", this.hUa, true);
    AppMethodBeat.o(124170);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(124171);
    e.d.b(Integer.valueOf(55), this.hIU);
    e.d.b(Integer.valueOf(57), this.hIU);
    i locali;
    if (aGn().hTP != null)
    {
      locali = aGn().hTP;
      com.tencent.mm.kernel.g.ajQ().gDv.b(675, locali);
      com.tencent.mm.kernel.g.ajQ().gDv.b(672, locali);
      com.tencent.mm.kernel.g.ajQ().gDv.b(674, locali);
    }
    synchronized (locali.ddM)
    {
      locali.hSX.clear();
      locali.hSW.clear();
      if (com.tencent.mm.kernel.g.ajP().aiZ())
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().d(this.hUb);
        aGp().a(this.hUc);
      }
      ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("mmbizattrappsvr_BizAttrSync", this.hUa, true);
      AppMethodBeat.o(124171);
      return;
    }
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.ag
 * JD-Core Version:    0.7.0.1
 */