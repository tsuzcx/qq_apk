package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.d;
import com.tencent.mm.am.s;
import com.tencent.mm.an.a.d;
import com.tencent.mm.an.a.g;
import com.tencent.mm.api.c.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.be;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.by.a;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.z;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class af
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static long owS;
  private com.tencent.mm.model.e ole;
  private f owT;
  private o.a owU;
  private l owV;
  private j owW;
  private i owX;
  private d owY;
  private q owZ;
  private z oxa;
  private com.tencent.mm.an.a.b oxb;
  private com.tencent.mm.an.a.l oxc;
  private g oxd;
  private com.tencent.mm.an.a.i oxe;
  private com.tencent.mm.an.a.h oxf;
  private e oxg;
  private ac oxh;
  private ag oxi;
  private a oxj;
  private cl.a oxk;
  private by.a oxl;
  private f.a oxm;
  
  static
  {
    AppMethodBeat.i(124173);
    owS = 0L;
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
        return com.tencent.mm.an.a.l.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("BIZCONVERSATION_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.an.a.b.SQL_CREATE;
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
    baseDBFactories.put(Integer.valueOf("BIZADINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return q.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("BIZRECSTORAGE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return z.SQL_CREATE;
      }
    });
    AppMethodBeat.o(124173);
  }
  
  public af()
  {
    AppMethodBeat.i(124152);
    this.owU = null;
    this.owV = null;
    this.owX = null;
    this.owY = null;
    this.owZ = null;
    this.oxa = null;
    this.oxb = null;
    this.oxc = null;
    this.oxd = null;
    this.oxe = null;
    this.oxf = null;
    this.oxg = null;
    this.oxh = null;
    this.oxi = null;
    this.ole = new com.tencent.mm.model.e();
    this.oxk = new af.2(this);
    this.oxl = new by.a()
    {
      public final void a(bb paramAnonymousbb, by paramAnonymousby)
      {
        AppMethodBeat.i(239468);
        if ((paramAnonymousbb != null) && (!Util.isNullOrNil(paramAnonymousbb.field_username)))
        {
          paramAnonymousby = paramAnonymousbb.field_username;
          Object localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramAnonymousby);
          if (localObject == null)
          {
            AppMethodBeat.o(239468);
            return;
          }
          if ((((au)localObject).iZC()) && (!au.bwc(paramAnonymousby)))
          {
            localObject = af.bHf().Mn(paramAnonymousby);
            if (((com.tencent.mm.api.c)localObject).systemRowid == -1L)
            {
              Log.i("MicroMsg.SubCoreBiz", "onMsgChangeNotify: no bizInfo");
              AppMethodBeat.o(239468);
              return;
            }
            if ((localObject != null) && (((com.tencent.mm.api.c)localObject).aAQ()))
            {
              if (((com.tencent.mm.api.c)localObject).dO(false) == null)
              {
                paramAnonymousbb.BH(null);
                Log.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
                AppMethodBeat.o(239468);
                return;
              }
              if (((com.tencent.mm.api.c)localObject).dO(false).aBr() == null)
              {
                paramAnonymousbb.BH(null);
                Log.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
                AppMethodBeat.o(239468);
                return;
              }
              paramAnonymousbb.BH(Util.nullAsNil(((com.tencent.mm.api.c)localObject).aAX()));
              if (Util.isNullOrNil(((com.tencent.mm.api.c)localObject).aAX())) {
                Log.w("MicroMsg.SubCoreBiz", "Enterprise belong is null:%s", new Object[] { paramAnonymousbb.field_username });
              }
              AppMethodBeat.o(239468);
              return;
            }
            if ((localObject != null) && ((((com.tencent.mm.api.c)localObject).aAM()) || (((com.tencent.mm.api.c)localObject).aAP()) || (au.bwx(paramAnonymousby))))
            {
              paramAnonymousbb.BH(null);
              AppMethodBeat.o(239468);
              return;
            }
            paramAnonymousbb.BH("officialaccounts");
          }
        }
        AppMethodBeat.o(239468);
      }
    };
    this.oxm = new f.a()
    {
      public final void a(f.a.b paramAnonymousb)
      {
        AppMethodBeat.i(239471);
        Object localObject;
        bb localbb;
        int i;
        if ((paramAnonymousb.owf == f.a.a.owb) || (paramAnonymousb.owf == f.a.a.owd))
        {
          if (paramAnonymousb.owg == null)
          {
            AppMethodBeat.o(239471);
            return;
          }
          localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramAnonymousb.ovT);
          if (localObject == null)
          {
            AppMethodBeat.o(239471);
            return;
          }
          if (!((au)localObject).iZC())
          {
            af.m(paramAnonymousb.owg);
            AppMethodBeat.o(239471);
            return;
          }
          if (au.bwc(((az)localObject).field_username))
          {
            AppMethodBeat.o(239471);
            return;
          }
          localbb = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxM(paramAnonymousb.ovT);
          Log.v("MicroMsg.SubCoreBiz", "hakon onEvent bizName = %s", new Object[] { paramAnonymousb.ovT });
          if ((paramAnonymousb.owg.aAQ()) && (paramAnonymousb.owg.dO(false) != null) && (paramAnonymousb.owg.dO(false).aBr() != null) && (!Util.isNullOrNil(paramAnonymousb.owg.aAX())) && (Util.isNullOrNil(paramAnonymousb.owg.field_enterpriseFather)))
          {
            paramAnonymousb.owg.field_enterpriseFather = paramAnonymousb.owg.aAX();
            af.bHf().h(paramAnonymousb.owg);
            Log.i("MicroMsg.SubCoreBiz", "hakon bizStgExt, %s set enterpriseFather %s", new Object[] { paramAnonymousb.ovT, paramAnonymousb.owg.field_enterpriseFather });
          }
          if (localbb == null)
          {
            AppMethodBeat.o(239471);
            return;
          }
          if (paramAnonymousb.owg.aAQ())
          {
            if (paramAnonymousb.owg.dO(false) == null)
            {
              Log.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
              AppMethodBeat.o(239471);
              return;
            }
            if (paramAnonymousb.owg.dO(false).aBr() == null)
            {
              Log.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
              AppMethodBeat.o(239471);
              return;
            }
            localObject = localbb.field_parentRef;
            Log.i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", new Object[] { paramAnonymousb.owg.aAX(), paramAnonymousb.ovT });
            localbb.BH(Util.nullAsNil(paramAnonymousb.owg.aAX()));
            if ((localObject != null) && (localbb.field_parentRef != null) && (!((String)localObject).equals(localbb.field_parentRef))) {
              i = 1;
            }
          }
        }
        for (;;)
        {
          Log.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseChildType, %s, %s", new Object[] { paramAnonymousb.ovT, localbb.field_parentRef });
          for (;;)
          {
            if (i != 0)
            {
              ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().c(localbb, localbb.field_username);
              if (Util.isNullOrNil(localbb.field_parentRef))
              {
                AppMethodBeat.o(239471);
                return;
                if ((localObject == null) && (localbb.field_parentRef != null))
                {
                  i = 1;
                  break;
                }
                if ((localObject == null) || (localbb.field_parentRef != null)) {
                  break label1020;
                }
                i = 1;
                break;
                if (paramAnonymousb.owg.aAP())
                {
                  Log.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseFatherType, %s", new Object[] { paramAnonymousb.ovT });
                  i = 1;
                  continue;
                }
                if ((!paramAnonymousb.owg.aAM()) && (!au.bwx(((az)localObject).field_username)) && (!"officialaccounts".equals(localbb.field_parentRef)))
                {
                  localbb.BH("officialaccounts");
                  i = 1;
                  continue;
                }
                if ((!paramAnonymousb.owg.aAM()) || (localbb.field_parentRef == null)) {
                  break label1015;
                }
                localbb.BH(null);
                i = 1;
                continue;
              }
              if ("officialaccounts".equals(localbb.field_parentRef))
              {
                localbb = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxM("officialaccounts");
                paramAnonymousb = localbb;
                if (localbb == null)
                {
                  paramAnonymousb = new bb("officialaccounts");
                  paramAnonymousb.jaJ();
                  ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().h(paramAnonymousb);
                }
                if (Util.isNullOrNil(paramAnonymousb.field_content))
                {
                  Log.i("MicroMsg.SubCoreBiz", "conv content is null");
                  paramAnonymousb = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().jaR();
                  if (Util.isNullOrNil(paramAnonymousb))
                  {
                    Log.w("MicroMsg.SubCoreBiz", "last convBiz is null");
                    AppMethodBeat.o(239471);
                    return;
                  }
                  paramAnonymousb = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLG(paramAnonymousb);
                  if ((paramAnonymousb == null) || (paramAnonymousb.field_msgId == 0L))
                  {
                    Log.w("MicroMsg.SubCoreBiz", "last biz msg is error");
                    AppMethodBeat.o(239471);
                    return;
                  }
                  ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(paramAnonymousb.field_msgId, paramAnonymousb);
                }
                AppMethodBeat.o(239471);
                return;
              }
              Log.i("MicroMsg.SubCoreBiz", "hakon username = %s, parentRef = %s", new Object[] { paramAnonymousb.ovT, localbb.field_parentRef });
              paramAnonymousb = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxM(localbb.field_parentRef);
              if (paramAnonymousb == null)
              {
                AppMethodBeat.o(239471);
                return;
              }
              if (Util.isNullOrNil(paramAnonymousb.field_content))
              {
                Log.i("MicroMsg.SubCoreBiz", "conv content is null");
                paramAnonymousb = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().byc(localbb.field_parentRef);
                if (Util.isNullOrNil(paramAnonymousb))
                {
                  Log.w("MicroMsg.SubCoreBiz", "last enterprise convBiz is null");
                  AppMethodBeat.o(239471);
                  return;
                }
                paramAnonymousb = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLG(paramAnonymousb);
                if ((paramAnonymousb == null) || (paramAnonymousb.field_msgId == 0L))
                {
                  Log.w("MicroMsg.SubCoreBiz", "last enterprise biz msg is error");
                  AppMethodBeat.o(239471);
                  return;
                }
                ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(paramAnonymousb.field_msgId, paramAnonymousb);
              }
            }
            AppMethodBeat.o(239471);
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
  
  private static af bHd()
  {
    try
    {
      AppMethodBeat.i(124153);
      af localaf = (af)y.aL(af.class);
      AppMethodBeat.o(124153);
      return localaf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static j bHe()
  {
    AppMethodBeat.i(124154);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bHd().owW == null) {
      bHd().owW = new j(com.tencent.mm.kernel.h.baE().mCN);
    }
    j localj = bHd().owW;
    AppMethodBeat.o(124154);
    return localj;
  }
  
  public static f bHf()
  {
    AppMethodBeat.i(124155);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bHd().owT == null) {
      bHd().owT = new f(com.tencent.mm.kernel.h.baE().mCN);
    }
    f localf = bHd().owT;
    AppMethodBeat.o(124155);
    return localf;
  }
  
  public static i bHg()
  {
    AppMethodBeat.i(124156);
    com.tencent.mm.kernel.h.baC().aZJ();
    i locali;
    if (bHd().owX == null)
    {
      bHd().owX = new i();
      locali = bHd().owX;
      com.tencent.mm.kernel.h.baD().mCm.a(675, locali);
      com.tencent.mm.kernel.h.baD().mCm.a(672, locali);
      com.tencent.mm.kernel.h.baD().mCm.a(674, locali);
    }
    for (;;)
    {
      synchronized (locali.hrB)
      {
        locali.owk.clear();
        ??? = locali.owh;
        if ((((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zgW, 0) == 1) || (BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED))
        {
          bool = true;
          ((i.a)???).owl = bool;
          locali.owh.appId = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zgZ, "wx3591b9dad10767f7");
          locali.owh.path = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zha, "pages/profile/profile.html");
          locali.owh.euz = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhb, 0);
          Log.i("MicroMsg.BizKFService", "alvinluo initKFGuideAppBrandConfig: %s", new Object[] { locali.owh });
          locali = bHd().owX;
          AppMethodBeat.o(124156);
          return locali;
        }
      }
      boolean bool = false;
    }
  }
  
  public static d bHh()
  {
    AppMethodBeat.i(124157);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bHd().owY == null) {
      bHd().owY = new d(com.tencent.mm.kernel.h.baE().mCN);
    }
    d locald = bHd().owY;
    AppMethodBeat.o(124157);
    return locald;
  }
  
  public static com.tencent.mm.an.a.b bHi()
  {
    AppMethodBeat.i(124158);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bHd().oxb == null) {
      bHd().oxb = new com.tencent.mm.an.a.b(com.tencent.mm.kernel.h.baE().mCN);
    }
    com.tencent.mm.an.a.b localb = bHd().oxb;
    AppMethodBeat.o(124158);
    return localb;
  }
  
  public static com.tencent.mm.an.a.l bHj()
  {
    AppMethodBeat.i(124159);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bHd().oxc == null) {
      bHd().oxc = new com.tencent.mm.an.a.l(com.tencent.mm.kernel.h.baE().mCN);
    }
    com.tencent.mm.an.a.l locall = bHd().oxc;
    AppMethodBeat.o(124159);
    return locall;
  }
  
  public static g bHk()
  {
    AppMethodBeat.i(124160);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bHd().oxd == null) {
      bHd().oxd = new g(com.tencent.mm.kernel.h.baE().mCN);
    }
    g localg = bHd().oxd;
    AppMethodBeat.o(124160);
    return localg;
  }
  
  public static ac bHl()
  {
    AppMethodBeat.i(124161);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bHd().oxh == null) {
      bHd().oxh = new ac(com.tencent.mm.kernel.h.baE().mCN);
    }
    ac localac = bHd().oxh;
    AppMethodBeat.o(124161);
    return localac;
  }
  
  public static q bHm()
  {
    AppMethodBeat.i(239469);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bHd().owZ == null) {
      bHd().owZ = new q(com.tencent.mm.kernel.h.baE().mCN);
    }
    q localq = bHd().owZ;
    AppMethodBeat.o(239469);
    return localq;
  }
  
  public static z bHn()
  {
    AppMethodBeat.i(239472);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bHd().oxa == null) {
      bHd().oxa = new z(com.tencent.mm.kernel.h.baE().mCN);
    }
    z localz = bHd().oxa;
    AppMethodBeat.o(239472);
    return localz;
  }
  
  public static ag bHo()
  {
    AppMethodBeat.i(124162);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bHd().oxi == null) {
      bHd().oxi = new ag(com.tencent.mm.kernel.h.baE().mCN);
    }
    ag localag = bHd().oxi;
    AppMethodBeat.o(124162);
    return localag;
  }
  
  public static com.tencent.mm.an.a.h bHp()
  {
    AppMethodBeat.i(124163);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bHd().oxf == null) {
      bHd().oxf = new com.tencent.mm.an.a.h();
    }
    com.tencent.mm.an.a.h localh = bHd().oxf;
    AppMethodBeat.o(124163);
    return localh;
  }
  
  public static e bHq()
  {
    AppMethodBeat.i(124164);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bHd().oxg == null) {
      bHd().oxg = new e(com.tencent.mm.kernel.h.baE().mCN);
    }
    e locale = bHd().oxg;
    AppMethodBeat.o(124164);
    return locale;
  }
  
  public static o.a bHr()
  {
    AppMethodBeat.i(124165);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bHd().owU == null) {
      bHd().owU = new o.a();
    }
    o.a locala = bHd().owU;
    AppMethodBeat.o(124165);
    return locala;
  }
  
  public static l bHs()
  {
    AppMethodBeat.i(124166);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bHd().owV == null) {
      bHd().owV = new l();
    }
    l locall = bHd().owV;
    AppMethodBeat.o(124166);
    return locall;
  }
  
  public static a bHt()
  {
    AppMethodBeat.i(124167);
    if (bHd().oxj == null) {
      bHd().oxj = new a();
    }
    a locala = bHd().oxj;
    AppMethodBeat.o(124167);
    return locala;
  }
  
  public static com.tencent.mm.an.a.i bHu()
  {
    AppMethodBeat.i(124168);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bHd().oxe == null) {
      bHd().oxe = new com.tencent.mm.an.a.i();
    }
    com.tencent.mm.an.a.i locali = bHd().oxe;
    AppMethodBeat.o(124168);
    return locali;
  }
  
  public static long bHv()
  {
    AppMethodBeat.i(124169);
    if (owS == 0L)
    {
      Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acIU, null);
      if ((localObject != null) && ((localObject instanceof Long)))
      {
        owS = ((Long)localObject).longValue();
        Log.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime : %d.(get from ConfigStorage)", new Object[] { Long.valueOf(owS) });
      }
    }
    if (owS == 0L)
    {
      owS = System.currentTimeMillis();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acIU, Long.valueOf(owS));
      Log.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime is 0, so get current time : %d.", new Object[] { Long.valueOf(owS) });
    }
    long l = owS;
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
    g.d.a(Integer.valueOf(55), this.ole);
    g.d.a(Integer.valueOf(57), this.ole);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().b(this.oxl);
    bHf().a(this.oxm, null);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("mmbizattrappsvr_BizAttrSync", this.oxk, true);
    AppMethodBeat.o(124170);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(124171);
    g.d.b(Integer.valueOf(55), this.ole);
    g.d.b(Integer.valueOf(57), this.ole);
    i locali;
    if (bHd().owX != null)
    {
      locali = bHd().owX;
      com.tencent.mm.kernel.h.baD().mCm.b(675, locali);
      com.tencent.mm.kernel.h.baD().mCm.b(672, locali);
      com.tencent.mm.kernel.h.baD().mCm.b(674, locali);
    }
    synchronized (locali.hrB)
    {
      locali.owk.clear();
      locali.owj.clear();
      if (com.tencent.mm.kernel.h.baC().aZN())
      {
        ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().c(this.oxl);
        bHf().a(this.oxm);
      }
      ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("mmbizattrappsvr_BizAttrSync", this.oxk, true);
      AppMethodBeat.o(124171);
      return;
    }
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.af
 * JD-Core Version:    0.7.0.1
 */