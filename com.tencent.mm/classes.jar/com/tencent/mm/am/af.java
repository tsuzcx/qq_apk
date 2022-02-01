package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.d;
import com.tencent.mm.am.a.l;
import com.tencent.mm.api.c;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bh.a;
import com.tencent.mm.storage.v;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class af
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static long gXZ;
  private com.tencent.mm.model.e gNk;
  private e gYa;
  private n.a gYb;
  private k gYc;
  private i gYd;
  private h gYe;
  private com.tencent.mm.am.a.d gYf;
  private com.tencent.mm.am.a.b gYg;
  private l gYh;
  private com.tencent.mm.am.a.g gYi;
  private com.tencent.mm.am.a.i gYj;
  private com.tencent.mm.am.a.h gYk;
  private d gYl;
  private com.tencent.mm.storage.t gYm;
  private v gYn;
  private a gYo;
  private cc.a gYp;
  private bh.a gYq;
  private e.a gYr;
  
  static
  {
    AppMethodBeat.i(124173);
    gXZ = 0L;
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
        return com.tencent.mm.am.a.d.SQL_CREATE;
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
        return com.tencent.mm.am.a.b.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("BIZCHAMYUSERINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.am.a.g.SQL_CREATE;
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
    this.gYb = null;
    this.gYc = null;
    this.gYe = null;
    this.gYf = null;
    this.gYg = null;
    this.gYh = null;
    this.gYi = null;
    this.gYj = null;
    this.gYk = null;
    this.gYl = null;
    this.gYm = null;
    this.gYn = null;
    this.gNk = new com.tencent.mm.model.e();
    this.gYp = new af.9(this);
    this.gYq = new bh.a()
    {
      public final void a(am paramAnonymousam, bh paramAnonymousbh)
      {
        AppMethodBeat.i(124151);
        if ((paramAnonymousam != null) && (!bt.isNullOrNil(paramAnonymousam.field_username)))
        {
          paramAnonymousbh = paramAnonymousam.field_username;
          Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramAnonymousbh);
          if (localObject == null)
          {
            AppMethodBeat.o(124151);
            return;
          }
          if ((((com.tencent.mm.storage.af)localObject).eKB()) && (!w.sQ(paramAnonymousbh)))
          {
            localObject = af.awe().wy(paramAnonymousbh);
            if (((c)localObject).systemRowid == -1L)
            {
              ad.i("MicroMsg.SubCoreBiz", "onMsgChangeNotify: no bizInfo");
              AppMethodBeat.o(124151);
              return;
            }
            if (((c)localObject).Jf())
            {
              if (((c)localObject).bU(false) == null)
              {
                paramAnonymousam.nN(null);
                ad.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
                AppMethodBeat.o(124151);
                return;
              }
              if (((c)localObject).bU(false).JH() == null)
              {
                paramAnonymousam.nN(null);
                ad.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
                AppMethodBeat.o(124151);
                return;
              }
              paramAnonymousam.nN(bt.nullAsNil(((c)localObject).Jm()));
              if (bt.isNullOrNil(((c)localObject).Jm())) {
                ad.w("MicroMsg.SubCoreBiz", "Enterprise belong is null:%s", new Object[] { paramAnonymousam.field_username });
              }
              AppMethodBeat.o(124151);
              return;
            }
            if ((((c)localObject).Jb()) || (((c)localObject).Je()) || (w.tl(paramAnonymousbh)))
            {
              paramAnonymousam.nN(null);
              AppMethodBeat.o(124151);
              return;
            }
            paramAnonymousam.nN("officialaccounts");
          }
        }
        AppMethodBeat.o(124151);
      }
    };
    this.gYr = new e.a()
    {
      public final void a(e.a.b paramAnonymousb)
      {
        AppMethodBeat.i(124149);
        Object localObject;
        am localam;
        int i;
        if ((paramAnonymousb.gXg == e.a.a.gXc) || (paramAnonymousb.gXg == e.a.a.gXe))
        {
          if (paramAnonymousb.gXh == null)
          {
            AppMethodBeat.o(124149);
            return;
          }
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramAnonymousb.gWU);
          if (localObject == null)
          {
            AppMethodBeat.o(124149);
            return;
          }
          if (!((com.tencent.mm.storage.af)localObject).eKB())
          {
            af.l(paramAnonymousb.gXh);
            AppMethodBeat.o(124149);
            return;
          }
          if (w.sQ(((au)localObject).field_username))
          {
            AppMethodBeat.o(124149);
            return;
          }
          localam = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIn(paramAnonymousb.gWU);
          ad.v("MicroMsg.SubCoreBiz", "hakon onEvent bizName = %s", new Object[] { paramAnonymousb.gWU });
          if ((paramAnonymousb.gXh.Jf()) && (paramAnonymousb.gXh.bU(false) != null) && (paramAnonymousb.gXh.bU(false).JH() != null) && (!bt.isNullOrNil(paramAnonymousb.gXh.Jm())) && (bt.isNullOrNil(paramAnonymousb.gXh.field_enterpriseFather)))
          {
            paramAnonymousb.gXh.field_enterpriseFather = paramAnonymousb.gXh.Jm();
            af.awe().g(paramAnonymousb.gXh);
            ad.i("MicroMsg.SubCoreBiz", "hakon bizStgExt, %s set enterpriseFather %s", new Object[] { paramAnonymousb.gWU, paramAnonymousb.gXh.field_enterpriseFather });
          }
          if (localam == null)
          {
            AppMethodBeat.o(124149);
            return;
          }
          if (paramAnonymousb.gXh.Jf())
          {
            if (paramAnonymousb.gXh.bU(false) == null)
            {
              ad.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
              AppMethodBeat.o(124149);
              return;
            }
            if (paramAnonymousb.gXh.bU(false).JH() == null)
            {
              ad.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
              AppMethodBeat.o(124149);
              return;
            }
            localObject = localam.field_parentRef;
            ad.i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", new Object[] { paramAnonymousb.gXh.Jm(), paramAnonymousb.gWU });
            localam.nN(bt.nullAsNil(paramAnonymousb.gXh.Jm()));
            if ((localObject != null) && (localam.field_parentRef != null) && (!((String)localObject).equals(localam.field_parentRef))) {
              i = 1;
            }
          }
        }
        for (;;)
        {
          ad.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseChildType, %s, %s", new Object[] { paramAnonymousb.gWU, localam.field_parentRef });
          for (;;)
          {
            if (i != 0)
            {
              ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().a(localam, localam.field_username);
              if (bt.isNullOrNil(localam.field_parentRef))
              {
                AppMethodBeat.o(124149);
                return;
                if ((localObject == null) && (localam.field_parentRef != null))
                {
                  i = 1;
                  break;
                }
                if ((localObject == null) || (localam.field_parentRef != null)) {
                  break label1020;
                }
                i = 1;
                break;
                if (paramAnonymousb.gXh.Je())
                {
                  ad.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseFatherType, %s", new Object[] { paramAnonymousb.gWU });
                  i = 1;
                  continue;
                }
                if ((!paramAnonymousb.gXh.Jb()) && (!w.tl(((au)localObject).field_username)) && (!"officialaccounts".equals(localam.field_parentRef)))
                {
                  localam.nN("officialaccounts");
                  i = 1;
                  continue;
                }
                if ((!paramAnonymousb.gXh.Jb()) || (localam.field_parentRef == null)) {
                  break label1015;
                }
                localam.nN(null);
                i = 1;
                continue;
              }
              if ("officialaccounts".equals(localam.field_parentRef))
              {
                localam = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIn("officialaccounts");
                paramAnonymousb = localam;
                if (localam == null)
                {
                  paramAnonymousb = new am("officialaccounts");
                  paramAnonymousb.eLf();
                  ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().e(paramAnonymousb);
                }
                if (bt.isNullOrNil(paramAnonymousb.field_content))
                {
                  ad.i("MicroMsg.SubCoreBiz", "conv content is null");
                  paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().eLn();
                  if (bt.isNullOrNil(paramAnonymousb))
                  {
                    ad.w("MicroMsg.SubCoreBiz", "last convBiz is null");
                    AppMethodBeat.o(124149);
                    return;
                  }
                  paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agq(paramAnonymousb);
                  if ((paramAnonymousb == null) || (paramAnonymousb.field_msgId == 0L))
                  {
                    ad.w("MicroMsg.SubCoreBiz", "last biz msg is error");
                    AppMethodBeat.o(124149);
                    return;
                  }
                  ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(paramAnonymousb.field_msgId, paramAnonymousb);
                }
                AppMethodBeat.o(124149);
                return;
              }
              ad.i("MicroMsg.SubCoreBiz", "hakon username = %s, parentRef = %s", new Object[] { paramAnonymousb.gWU, localam.field_parentRef });
              paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIn(localam.field_parentRef);
              if (paramAnonymousb == null)
              {
                AppMethodBeat.o(124149);
                return;
              }
              if (bt.isNullOrNil(paramAnonymousb.field_content))
              {
                ad.i("MicroMsg.SubCoreBiz", "conv content is null");
                paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIz(localam.field_parentRef);
                if (bt.isNullOrNil(paramAnonymousb))
                {
                  ad.w("MicroMsg.SubCoreBiz", "last enterprise convBiz is null");
                  AppMethodBeat.o(124149);
                  return;
                }
                paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agq(paramAnonymousb);
                if ((paramAnonymousb == null) || (paramAnonymousb.field_msgId == 0L))
                {
                  ad.w("MicroMsg.SubCoreBiz", "last enterprise biz msg is error");
                  AppMethodBeat.o(124149);
                  return;
                }
                ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(paramAnonymousb.field_msgId, paramAnonymousb);
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
  
  private static af awc()
  {
    try
    {
      AppMethodBeat.i(124153);
      af localaf = (af)com.tencent.mm.model.t.ap(af.class);
      AppMethodBeat.o(124153);
      return localaf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static i awd()
  {
    AppMethodBeat.i(124154);
    com.tencent.mm.kernel.g.afz().aeD();
    if (awc().gYd == null) {
      awc().gYd = new i(com.tencent.mm.kernel.g.afB().gda);
    }
    i locali = awc().gYd;
    AppMethodBeat.o(124154);
    return locali;
  }
  
  public static e awe()
  {
    AppMethodBeat.i(124155);
    com.tencent.mm.kernel.g.afz().aeD();
    if (awc().gYa == null) {
      awc().gYa = new e(com.tencent.mm.kernel.g.afB().gda);
    }
    e locale = awc().gYa;
    AppMethodBeat.o(124155);
    return locale;
  }
  
  public static h awf()
  {
    AppMethodBeat.i(124156);
    com.tencent.mm.kernel.g.afz().aeD();
    h localh;
    if (awc().gYe == null)
    {
      awc().gYe = new h();
      localh = awc().gYe;
      com.tencent.mm.kernel.g.afA().gcy.a(675, localh);
      com.tencent.mm.kernel.g.afA().gcy.a(672, localh);
      com.tencent.mm.kernel.g.afA().gcy.a(674, localh);
    }
    for (;;)
    {
      synchronized (localh.cTX)
      {
        localh.gXl.clear();
        ??? = localh.gXi;
        if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.psE, 0) == 1) || (com.tencent.mm.sdk.platformtools.h.DEBUG) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED))
        {
          bool = true;
          ((h.a)???).gXm = bool;
          localh.gXi.appId = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.psF, "wx3591b9dad10767f7");
          localh.gXi.path = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.psG, "pages/profile/profile.html");
          localh.gXi.gXn = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.psH, 0);
          ad.i("MicroMsg.BizKFService", "alvinluo initKFGuideAppBrandConfig: %s", new Object[] { localh.gXi });
          localh = awc().gYe;
          AppMethodBeat.o(124156);
          return localh;
        }
      }
      boolean bool = false;
    }
  }
  
  public static com.tencent.mm.am.a.d awg()
  {
    AppMethodBeat.i(124157);
    com.tencent.mm.kernel.g.afz().aeD();
    if (awc().gYf == null) {
      awc().gYf = new com.tencent.mm.am.a.d(com.tencent.mm.kernel.g.afB().gda);
    }
    com.tencent.mm.am.a.d locald = awc().gYf;
    AppMethodBeat.o(124157);
    return locald;
  }
  
  public static com.tencent.mm.am.a.b awh()
  {
    AppMethodBeat.i(124158);
    com.tencent.mm.kernel.g.afz().aeD();
    if (awc().gYg == null) {
      awc().gYg = new com.tencent.mm.am.a.b(com.tencent.mm.kernel.g.afB().gda);
    }
    com.tencent.mm.am.a.b localb = awc().gYg;
    AppMethodBeat.o(124158);
    return localb;
  }
  
  public static l awi()
  {
    AppMethodBeat.i(124159);
    com.tencent.mm.kernel.g.afz().aeD();
    if (awc().gYh == null) {
      awc().gYh = new l(com.tencent.mm.kernel.g.afB().gda);
    }
    l locall = awc().gYh;
    AppMethodBeat.o(124159);
    return locall;
  }
  
  public static com.tencent.mm.am.a.g awj()
  {
    AppMethodBeat.i(124160);
    com.tencent.mm.kernel.g.afz().aeD();
    if (awc().gYi == null) {
      awc().gYi = new com.tencent.mm.am.a.g(com.tencent.mm.kernel.g.afB().gda);
    }
    com.tencent.mm.am.a.g localg = awc().gYi;
    AppMethodBeat.o(124160);
    return localg;
  }
  
  public static com.tencent.mm.storage.t awk()
  {
    AppMethodBeat.i(124161);
    com.tencent.mm.kernel.g.afz().aeD();
    if (awc().gYm == null) {
      awc().gYm = new com.tencent.mm.storage.t(com.tencent.mm.kernel.g.afB().gda);
    }
    com.tencent.mm.storage.t localt = awc().gYm;
    AppMethodBeat.o(124161);
    return localt;
  }
  
  public static v awl()
  {
    AppMethodBeat.i(124162);
    com.tencent.mm.kernel.g.afz().aeD();
    if (awc().gYn == null) {
      awc().gYn = new v(com.tencent.mm.kernel.g.afB().gda);
    }
    v localv = awc().gYn;
    AppMethodBeat.o(124162);
    return localv;
  }
  
  public static com.tencent.mm.am.a.h awm()
  {
    AppMethodBeat.i(124163);
    com.tencent.mm.kernel.g.afz().aeD();
    if (awc().gYk == null) {
      awc().gYk = new com.tencent.mm.am.a.h();
    }
    com.tencent.mm.am.a.h localh = awc().gYk;
    AppMethodBeat.o(124163);
    return localh;
  }
  
  public static d awn()
  {
    AppMethodBeat.i(124164);
    com.tencent.mm.kernel.g.afz().aeD();
    if (awc().gYl == null) {
      awc().gYl = new d(com.tencent.mm.kernel.g.afB().gda);
    }
    d locald = awc().gYl;
    AppMethodBeat.o(124164);
    return locald;
  }
  
  public static n.a awo()
  {
    AppMethodBeat.i(124165);
    com.tencent.mm.kernel.g.afz().aeD();
    if (awc().gYb == null) {
      awc().gYb = new n.a();
    }
    n.a locala = awc().gYb;
    AppMethodBeat.o(124165);
    return locala;
  }
  
  public static k awp()
  {
    AppMethodBeat.i(124166);
    com.tencent.mm.kernel.g.afz().aeD();
    if (awc().gYc == null) {
      awc().gYc = new k();
    }
    k localk = awc().gYc;
    AppMethodBeat.o(124166);
    return localk;
  }
  
  public static a awq()
  {
    AppMethodBeat.i(124167);
    if (awc().gYo == null) {
      awc().gYo = new a();
    }
    a locala = awc().gYo;
    AppMethodBeat.o(124167);
    return locala;
  }
  
  public static com.tencent.mm.am.a.i awr()
  {
    AppMethodBeat.i(124168);
    com.tencent.mm.kernel.g.afz().aeD();
    if (awc().gYj == null) {
      awc().gYj = new com.tencent.mm.am.a.i();
    }
    com.tencent.mm.am.a.i locali = awc().gYj;
    AppMethodBeat.o(124168);
    return locali;
  }
  
  public static long aws()
  {
    AppMethodBeat.i(124169);
    if (gXZ == 0L)
    {
      Object localObject = com.tencent.mm.kernel.g.afB().afk().get(ae.a.FgW, null);
      if ((localObject != null) && ((localObject instanceof Long)))
      {
        gXZ = ((Long)localObject).longValue();
        ad.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime : %d.(get from ConfigStorage)", new Object[] { Long.valueOf(gXZ) });
      }
    }
    if (gXZ == 0L)
    {
      gXZ = System.currentTimeMillis();
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FgW, Long.valueOf(gXZ));
      ad.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime is 0, so get current time : %d.", new Object[] { Long.valueOf(gXZ) });
    }
    long l = gXZ;
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
    f.d.a(Integer.valueOf(55), this.gNk);
    f.d.a(Integer.valueOf(57), this.gNk);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().c(this.gYq);
    awe().a(this.gYr, null);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("mmbizattrappsvr_BizAttrSync", this.gYp, true);
    AppMethodBeat.o(124170);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(124171);
    f.d.b(Integer.valueOf(55), this.gNk);
    f.d.b(Integer.valueOf(57), this.gNk);
    h localh;
    if (awc().gYe != null)
    {
      localh = awc().gYe;
      com.tencent.mm.kernel.g.afA().gcy.b(675, localh);
      com.tencent.mm.kernel.g.afA().gcy.b(672, localh);
      com.tencent.mm.kernel.g.afA().gcy.b(674, localh);
    }
    synchronized (localh.cTX)
    {
      localh.gXl.clear();
      localh.gXk.clear();
      if (com.tencent.mm.kernel.g.afz().aeI())
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().d(this.gYq);
        awe().a(this.gYr);
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("mmbizattrappsvr_BizAttrSync", this.gYp, true);
      AppMethodBeat.o(124171);
      return;
    }
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.af
 * JD-Core Version:    0.7.0.1
 */