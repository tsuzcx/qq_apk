package com.tencent.mm.ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.d;
import com.tencent.mm.an.t;
import com.tencent.mm.ao.a.d;
import com.tencent.mm.ao.a.g;
import com.tencent.mm.api.c.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.be;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.bw.a;
import com.tencent.mm.storage.q;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class af
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static long lFm;
  private aa lFA;
  private ae lFB;
  private a lFC;
  private ck.a lFD;
  private bw.a lFE;
  private f.a lFF;
  private f lFn;
  private o.a lFo;
  private l lFp;
  private j lFq;
  private i lFr;
  private d lFs;
  private q lFt;
  private com.tencent.mm.ao.a.b lFu;
  private com.tencent.mm.ao.a.l lFv;
  private g lFw;
  private com.tencent.mm.ao.a.i lFx;
  private com.tencent.mm.ao.a.h lFy;
  private e lFz;
  private com.tencent.mm.model.e ltF;
  
  static
  {
    AppMethodBeat.i(124173);
    lFm = 0L;
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
        return com.tencent.mm.ao.a.l.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("BIZCONVERSATION_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.ao.a.b.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("BIZCHAMYUSERINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return g.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("BIZENTERPRISE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return e.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("BIZADINFO_TABLE".hashCode()), new af.10());
    AppMethodBeat.o(124173);
  }
  
  public af()
  {
    AppMethodBeat.i(124152);
    this.lFo = null;
    this.lFp = null;
    this.lFr = null;
    this.lFs = null;
    this.lFt = null;
    this.lFu = null;
    this.lFv = null;
    this.lFw = null;
    this.lFx = null;
    this.lFy = null;
    this.lFz = null;
    this.lFA = null;
    this.lFB = null;
    this.ltF = new com.tencent.mm.model.e();
    this.lFD = new af.11(this);
    this.lFE = new bw.a()
    {
      public final void a(az paramAnonymousaz, bw paramAnonymousbw)
      {
        AppMethodBeat.i(206511);
        if ((paramAnonymousaz != null) && (!Util.isNullOrNil(paramAnonymousaz.field_username)))
        {
          paramAnonymousbw = paramAnonymousaz.field_username;
          Object localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramAnonymousbw);
          if (localObject == null)
          {
            AppMethodBeat.o(206511);
            return;
          }
          if ((((as)localObject).hxX()) && (!ab.Qy(paramAnonymousbw)))
          {
            localObject = af.bjv().Uo(paramAnonymousbw);
            if (((com.tencent.mm.api.c)localObject).systemRowid == -1L)
            {
              Log.i("MicroMsg.SubCoreBiz", "onMsgChangeNotify: no bizInfo");
              AppMethodBeat.o(206511);
              return;
            }
            if (((com.tencent.mm.api.c)localObject).YY())
            {
              if (((com.tencent.mm.api.c)localObject).dc(false) == null)
              {
                paramAnonymousaz.Jc(null);
                Log.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
                AppMethodBeat.o(206511);
                return;
              }
              if (((com.tencent.mm.api.c)localObject).dc(false).Zz() == null)
              {
                paramAnonymousaz.Jc(null);
                Log.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
                AppMethodBeat.o(206511);
                return;
              }
              paramAnonymousaz.Jc(Util.nullAsNil(((com.tencent.mm.api.c)localObject).Zf()));
              if (Util.isNullOrNil(((com.tencent.mm.api.c)localObject).Zf())) {
                Log.w("MicroMsg.SubCoreBiz", "Enterprise belong is null:%s", new Object[] { paramAnonymousaz.field_username });
              }
              AppMethodBeat.o(206511);
              return;
            }
            if ((((com.tencent.mm.api.c)localObject).YU()) || (((com.tencent.mm.api.c)localObject).YX()) || (ab.QT(paramAnonymousbw)))
            {
              paramAnonymousaz.Jc(null);
              AppMethodBeat.o(206511);
              return;
            }
            paramAnonymousaz.Jc("officialaccounts");
          }
        }
        AppMethodBeat.o(206511);
      }
    };
    this.lFF = new f.a()
    {
      public final void a(f.a.b paramAnonymousb)
      {
        AppMethodBeat.i(207973);
        Object localObject;
        az localaz;
        int i;
        if ((paramAnonymousb.lEy == f.a.a.lEu) || (paramAnonymousb.lEy == f.a.a.lEw))
        {
          if (paramAnonymousb.lEz == null)
          {
            AppMethodBeat.o(207973);
            return;
          }
          localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramAnonymousb.lEm);
          if (localObject == null)
          {
            AppMethodBeat.o(207973);
            return;
          }
          if (!((as)localObject).hxX())
          {
            af.m(paramAnonymousb.lEz);
            AppMethodBeat.o(207973);
            return;
          }
          if (ab.Qy(((ax)localObject).field_username))
          {
            AppMethodBeat.o(207973);
            return;
          }
          localaz = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwx(paramAnonymousb.lEm);
          Log.v("MicroMsg.SubCoreBiz", "hakon onEvent bizName = %s", new Object[] { paramAnonymousb.lEm });
          if ((paramAnonymousb.lEz.YY()) && (paramAnonymousb.lEz.dc(false) != null) && (paramAnonymousb.lEz.dc(false).Zz() != null) && (!Util.isNullOrNil(paramAnonymousb.lEz.Zf())) && (Util.isNullOrNil(paramAnonymousb.lEz.field_enterpriseFather)))
          {
            paramAnonymousb.lEz.field_enterpriseFather = paramAnonymousb.lEz.Zf();
            af.bjv().h(paramAnonymousb.lEz);
            Log.i("MicroMsg.SubCoreBiz", "hakon bizStgExt, %s set enterpriseFather %s", new Object[] { paramAnonymousb.lEm, paramAnonymousb.lEz.field_enterpriseFather });
          }
          if (localaz == null)
          {
            AppMethodBeat.o(207973);
            return;
          }
          if (paramAnonymousb.lEz.YY())
          {
            if (paramAnonymousb.lEz.dc(false) == null)
            {
              Log.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
              AppMethodBeat.o(207973);
              return;
            }
            if (paramAnonymousb.lEz.dc(false).Zz() == null)
            {
              Log.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
              AppMethodBeat.o(207973);
              return;
            }
            localObject = localaz.field_parentRef;
            Log.i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", new Object[] { paramAnonymousb.lEz.Zf(), paramAnonymousb.lEm });
            localaz.Jc(Util.nullAsNil(paramAnonymousb.lEz.Zf()));
            if ((localObject != null) && (localaz.field_parentRef != null) && (!((String)localObject).equals(localaz.field_parentRef))) {
              i = 1;
            }
          }
        }
        for (;;)
        {
          Log.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseChildType, %s, %s", new Object[] { paramAnonymousb.lEm, localaz.field_parentRef });
          for (;;)
          {
            if (i != 0)
            {
              ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().a(localaz, localaz.field_username);
              if (Util.isNullOrNil(localaz.field_parentRef))
              {
                AppMethodBeat.o(207973);
                return;
                if ((localObject == null) && (localaz.field_parentRef != null))
                {
                  i = 1;
                  break;
                }
                if ((localObject == null) || (localaz.field_parentRef != null)) {
                  break label1020;
                }
                i = 1;
                break;
                if (paramAnonymousb.lEz.YX())
                {
                  Log.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseFatherType, %s", new Object[] { paramAnonymousb.lEm });
                  i = 1;
                  continue;
                }
                if ((!paramAnonymousb.lEz.YU()) && (!ab.QT(((ax)localObject).field_username)) && (!"officialaccounts".equals(localaz.field_parentRef)))
                {
                  localaz.Jc("officialaccounts");
                  i = 1;
                  continue;
                }
                if ((!paramAnonymousb.lEz.YU()) || (localaz.field_parentRef == null)) {
                  break label1015;
                }
                localaz.Jc(null);
                i = 1;
                continue;
              }
              if ("officialaccounts".equals(localaz.field_parentRef))
              {
                localaz = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwx("officialaccounts");
                paramAnonymousb = localaz;
                if (localaz == null)
                {
                  paramAnonymousb = new az("officialaccounts");
                  paramAnonymousb.hyE();
                  ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().e(paramAnonymousb);
                }
                if (Util.isNullOrNil(paramAnonymousb.field_content))
                {
                  Log.i("MicroMsg.SubCoreBiz", "conv content is null");
                  paramAnonymousb = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().hyM();
                  if (Util.isNullOrNil(paramAnonymousb))
                  {
                    Log.w("MicroMsg.SubCoreBiz", "last convBiz is null");
                    AppMethodBeat.o(207973);
                    return;
                  }
                  paramAnonymousb = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOH(paramAnonymousb);
                  if ((paramAnonymousb == null) || (paramAnonymousb.field_msgId == 0L))
                  {
                    Log.w("MicroMsg.SubCoreBiz", "last biz msg is error");
                    AppMethodBeat.o(207973);
                    return;
                  }
                  ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(paramAnonymousb.field_msgId, paramAnonymousb);
                }
                AppMethodBeat.o(207973);
                return;
              }
              Log.i("MicroMsg.SubCoreBiz", "hakon username = %s, parentRef = %s", new Object[] { paramAnonymousb.lEm, localaz.field_parentRef });
              paramAnonymousb = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwx(localaz.field_parentRef);
              if (paramAnonymousb == null)
              {
                AppMethodBeat.o(207973);
                return;
              }
              if (Util.isNullOrNil(paramAnonymousb.field_content))
              {
                Log.i("MicroMsg.SubCoreBiz", "conv content is null");
                paramAnonymousb = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwJ(localaz.field_parentRef);
                if (Util.isNullOrNil(paramAnonymousb))
                {
                  Log.w("MicroMsg.SubCoreBiz", "last enterprise convBiz is null");
                  AppMethodBeat.o(207973);
                  return;
                }
                paramAnonymousb = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOH(paramAnonymousb);
                if ((paramAnonymousb == null) || (paramAnonymousb.field_msgId == 0L))
                {
                  Log.w("MicroMsg.SubCoreBiz", "last enterprise biz msg is error");
                  AppMethodBeat.o(207973);
                  return;
                }
                ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(paramAnonymousb.field_msgId, paramAnonymousb);
              }
            }
            AppMethodBeat.o(207973);
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
  
  public static g bjA()
  {
    AppMethodBeat.i(124160);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bjt().lFw == null) {
      bjt().lFw = new g(com.tencent.mm.kernel.h.aHG().kcF);
    }
    g localg = bjt().lFw;
    AppMethodBeat.o(124160);
    return localg;
  }
  
  public static aa bjB()
  {
    AppMethodBeat.i(124161);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bjt().lFA == null) {
      bjt().lFA = new aa(com.tencent.mm.kernel.h.aHG().kcF);
    }
    aa localaa = bjt().lFA;
    AppMethodBeat.o(124161);
    return localaa;
  }
  
  public static q bjC()
  {
    AppMethodBeat.i(205192);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bjt().lFt == null) {
      bjt().lFt = new q(com.tencent.mm.kernel.h.aHG().kcF);
    }
    q localq = bjt().lFt;
    AppMethodBeat.o(205192);
    return localq;
  }
  
  public static ae bjD()
  {
    AppMethodBeat.i(124162);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bjt().lFB == null) {
      bjt().lFB = new ae(com.tencent.mm.kernel.h.aHG().kcF);
    }
    ae localae = bjt().lFB;
    AppMethodBeat.o(124162);
    return localae;
  }
  
  public static com.tencent.mm.ao.a.h bjE()
  {
    AppMethodBeat.i(124163);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bjt().lFy == null) {
      bjt().lFy = new com.tencent.mm.ao.a.h();
    }
    com.tencent.mm.ao.a.h localh = bjt().lFy;
    AppMethodBeat.o(124163);
    return localh;
  }
  
  public static e bjF()
  {
    AppMethodBeat.i(124164);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bjt().lFz == null) {
      bjt().lFz = new e(com.tencent.mm.kernel.h.aHG().kcF);
    }
    e locale = bjt().lFz;
    AppMethodBeat.o(124164);
    return locale;
  }
  
  public static o.a bjG()
  {
    AppMethodBeat.i(124165);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bjt().lFo == null) {
      bjt().lFo = new o.a();
    }
    o.a locala = bjt().lFo;
    AppMethodBeat.o(124165);
    return locala;
  }
  
  public static l bjH()
  {
    AppMethodBeat.i(124166);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bjt().lFp == null) {
      bjt().lFp = new l();
    }
    l locall = bjt().lFp;
    AppMethodBeat.o(124166);
    return locall;
  }
  
  public static a bjI()
  {
    AppMethodBeat.i(124167);
    if (bjt().lFC == null) {
      bjt().lFC = new a();
    }
    a locala = bjt().lFC;
    AppMethodBeat.o(124167);
    return locala;
  }
  
  public static com.tencent.mm.ao.a.i bjJ()
  {
    AppMethodBeat.i(124168);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bjt().lFx == null) {
      bjt().lFx = new com.tencent.mm.ao.a.i();
    }
    com.tencent.mm.ao.a.i locali = bjt().lFx;
    AppMethodBeat.o(124168);
    return locali;
  }
  
  public static long bjK()
  {
    AppMethodBeat.i(124169);
    if (lFm == 0L)
    {
      Object localObject = com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VhA, null);
      if ((localObject != null) && ((localObject instanceof Long)))
      {
        lFm = ((Long)localObject).longValue();
        Log.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime : %d.(get from ConfigStorage)", new Object[] { Long.valueOf(lFm) });
      }
    }
    if (lFm == 0L)
    {
      lFm = System.currentTimeMillis();
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VhA, Long.valueOf(lFm));
      Log.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime is 0, so get current time : %d.", new Object[] { Long.valueOf(lFm) });
    }
    long l = lFm;
    AppMethodBeat.o(124169);
    return l;
  }
  
  private static af bjt()
  {
    try
    {
      AppMethodBeat.i(124153);
      af localaf = (af)y.as(af.class);
      AppMethodBeat.o(124153);
      return localaf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static j bju()
  {
    AppMethodBeat.i(124154);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bjt().lFq == null) {
      bjt().lFq = new j(com.tencent.mm.kernel.h.aHG().kcF);
    }
    j localj = bjt().lFq;
    AppMethodBeat.o(124154);
    return localj;
  }
  
  public static f bjv()
  {
    AppMethodBeat.i(124155);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bjt().lFn == null) {
      bjt().lFn = new f(com.tencent.mm.kernel.h.aHG().kcF);
    }
    f localf = bjt().lFn;
    AppMethodBeat.o(124155);
    return localf;
  }
  
  public static i bjw()
  {
    AppMethodBeat.i(124156);
    com.tencent.mm.kernel.h.aHE().aGH();
    i locali;
    if (bjt().lFr == null)
    {
      bjt().lFr = new i();
      locali = bjt().lFr;
      com.tencent.mm.kernel.h.aHF().kcd.a(675, locali);
      com.tencent.mm.kernel.h.aHF().kcd.a(672, locali);
      com.tencent.mm.kernel.h.aHF().kcd.a(674, locali);
    }
    for (;;)
    {
      synchronized (locali.fnq)
      {
        locali.lED.clear();
        ??? = locali.lEA;
        if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vOu, 0) == 1) || (BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED))
        {
          bool = true;
          ((i.a)???).lEE = bool;
          locali.lEA.appId = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vOx, "wx3591b9dad10767f7");
          locali.lEA.path = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vOy, "pages/profile/profile.html");
          locali.lEA.cBU = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vOz, 0);
          Log.i("MicroMsg.BizKFService", "alvinluo initKFGuideAppBrandConfig: %s", new Object[] { locali.lEA });
          locali = bjt().lFr;
          AppMethodBeat.o(124156);
          return locali;
        }
      }
      boolean bool = false;
    }
  }
  
  public static d bjx()
  {
    AppMethodBeat.i(124157);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bjt().lFs == null) {
      bjt().lFs = new d(com.tencent.mm.kernel.h.aHG().kcF);
    }
    d locald = bjt().lFs;
    AppMethodBeat.o(124157);
    return locald;
  }
  
  public static com.tencent.mm.ao.a.b bjy()
  {
    AppMethodBeat.i(124158);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bjt().lFu == null) {
      bjt().lFu = new com.tencent.mm.ao.a.b(com.tencent.mm.kernel.h.aHG().kcF);
    }
    com.tencent.mm.ao.a.b localb = bjt().lFu;
    AppMethodBeat.o(124158);
    return localb;
  }
  
  public static com.tencent.mm.ao.a.l bjz()
  {
    AppMethodBeat.i(124159);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bjt().lFv == null) {
      bjt().lFv = new com.tencent.mm.ao.a.l(com.tencent.mm.kernel.h.aHG().kcF);
    }
    com.tencent.mm.ao.a.l locall = bjt().lFv;
    AppMethodBeat.o(124159);
    return locall;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(124170);
    h.d.a(Integer.valueOf(55), this.ltF);
    h.d.a(Integer.valueOf(57), this.ltF);
    ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().b(this.lFE);
    bjv().a(this.lFF, null);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("mmbizattrappsvr_BizAttrSync", this.lFD, true);
    AppMethodBeat.o(124170);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(124171);
    h.d.b(Integer.valueOf(55), this.ltF);
    h.d.b(Integer.valueOf(57), this.ltF);
    i locali;
    if (bjt().lFr != null)
    {
      locali = bjt().lFr;
      com.tencent.mm.kernel.h.aHF().kcd.b(675, locali);
      com.tencent.mm.kernel.h.aHF().kcd.b(672, locali);
      com.tencent.mm.kernel.h.aHF().kcd.b(674, locali);
    }
    synchronized (locali.fnq)
    {
      locali.lED.clear();
      locali.lEC.clear();
      if (com.tencent.mm.kernel.h.aHE().aGM())
      {
        ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().c(this.lFE);
        bjv().a(this.lFF);
      }
      ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("mmbizattrappsvr_BizAttrSync", this.lFD, true);
      AppMethodBeat.o(124171);
      return;
    }
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ao.af
 * JD-Core Version:    0.7.0.1
 */