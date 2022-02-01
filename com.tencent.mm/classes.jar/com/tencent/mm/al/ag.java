package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.d;
import com.tencent.mm.ak.t;
import com.tencent.mm.al.a.d;
import com.tencent.mm.al.a.h;
import com.tencent.mm.api.c;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.s;
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

public class ag
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static long iOV;
  private com.tencent.mm.model.e iDE;
  private f iOW;
  private o.a iOX;
  private l iOY;
  private j iOZ;
  private i iPa;
  private d iPb;
  private q iPc;
  private com.tencent.mm.al.a.b iPd;
  private com.tencent.mm.al.a.l iPe;
  private com.tencent.mm.al.a.g iPf;
  private com.tencent.mm.al.a.i iPg;
  private h iPh;
  private e iPi;
  private aa iPj;
  private ae iPk;
  private a iPl;
  private cj.a iPm;
  private bw.a iPn;
  private f.a iPo;
  
  static
  {
    AppMethodBeat.i(124173);
    iOV = 0L;
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
    baseDBFactories.put(Integer.valueOf("BIZADINFO_TABLE".hashCode()), new ag.10());
    AppMethodBeat.o(124173);
  }
  
  public ag()
  {
    AppMethodBeat.i(124152);
    this.iOX = null;
    this.iOY = null;
    this.iPa = null;
    this.iPb = null;
    this.iPc = null;
    this.iPd = null;
    this.iPe = null;
    this.iPf = null;
    this.iPg = null;
    this.iPh = null;
    this.iPi = null;
    this.iPj = null;
    this.iPk = null;
    this.iDE = new com.tencent.mm.model.e();
    this.iPm = new ag.11(this);
    this.iPn = new bw.a()
    {
      public final void a(az paramAnonymousaz, bw paramAnonymousbw)
      {
        AppMethodBeat.i(212187);
        if ((paramAnonymousaz != null) && (!Util.isNullOrNil(paramAnonymousaz.field_username)))
        {
          paramAnonymousbw = paramAnonymousaz.field_username;
          Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramAnonymousbw);
          if (localObject == null)
          {
            AppMethodBeat.o(212187);
            return;
          }
          if ((((as)localObject).gBM()) && (!ab.Jf(paramAnonymousbw)))
          {
            localObject = ag.bah().MT(paramAnonymousbw);
            if (((c)localObject).systemRowid == -1L)
            {
              Log.i("MicroMsg.SubCoreBiz", "onMsgChangeNotify: no bizInfo");
              AppMethodBeat.o(212187);
              return;
            }
            if (((c)localObject).UG())
            {
              if (((c)localObject).cG(false) == null)
              {
                paramAnonymousaz.Co(null);
                Log.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
                AppMethodBeat.o(212187);
                return;
              }
              if (((c)localObject).cG(false).Vh() == null)
              {
                paramAnonymousaz.Co(null);
                Log.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
                AppMethodBeat.o(212187);
                return;
              }
              paramAnonymousaz.Co(Util.nullAsNil(((c)localObject).UN()));
              if (Util.isNullOrNil(((c)localObject).UN())) {
                Log.w("MicroMsg.SubCoreBiz", "Enterprise belong is null:%s", new Object[] { paramAnonymousaz.field_username });
              }
              AppMethodBeat.o(212187);
              return;
            }
            if ((((c)localObject).UC()) || (((c)localObject).UF()) || (ab.JA(paramAnonymousbw)))
            {
              paramAnonymousaz.Co(null);
              AppMethodBeat.o(212187);
              return;
            }
            paramAnonymousaz.Co("officialaccounts");
          }
        }
        AppMethodBeat.o(212187);
      }
    };
    this.iPo = new f.a()
    {
      public final void a(f.a.b paramAnonymousb)
      {
        AppMethodBeat.i(212188);
        Object localObject;
        az localaz;
        int i;
        if ((paramAnonymousb.iOh == f.a.a.iOd) || (paramAnonymousb.iOh == f.a.a.iOf))
        {
          if (paramAnonymousb.iOi == null)
          {
            AppMethodBeat.o(212188);
            return;
          }
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramAnonymousb.iNV);
          if (localObject == null)
          {
            AppMethodBeat.o(212188);
            return;
          }
          if (!((as)localObject).gBM())
          {
            ag.m(paramAnonymousb.iOi);
            AppMethodBeat.o(212188);
            return;
          }
          if (ab.Jf(((ax)localObject).field_username))
          {
            AppMethodBeat.o(212188);
            return;
          }
          localaz = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bjY(paramAnonymousb.iNV);
          Log.v("MicroMsg.SubCoreBiz", "hakon onEvent bizName = %s", new Object[] { paramAnonymousb.iNV });
          if ((paramAnonymousb.iOi.UG()) && (paramAnonymousb.iOi.cG(false) != null) && (paramAnonymousb.iOi.cG(false).Vh() != null) && (!Util.isNullOrNil(paramAnonymousb.iOi.UN())) && (Util.isNullOrNil(paramAnonymousb.iOi.field_enterpriseFather)))
          {
            paramAnonymousb.iOi.field_enterpriseFather = paramAnonymousb.iOi.UN();
            ag.bah().h(paramAnonymousb.iOi);
            Log.i("MicroMsg.SubCoreBiz", "hakon bizStgExt, %s set enterpriseFather %s", new Object[] { paramAnonymousb.iNV, paramAnonymousb.iOi.field_enterpriseFather });
          }
          if (localaz == null)
          {
            AppMethodBeat.o(212188);
            return;
          }
          if (paramAnonymousb.iOi.UG())
          {
            if (paramAnonymousb.iOi.cG(false) == null)
            {
              Log.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
              AppMethodBeat.o(212188);
              return;
            }
            if (paramAnonymousb.iOi.cG(false).Vh() == null)
            {
              Log.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
              AppMethodBeat.o(212188);
              return;
            }
            localObject = localaz.field_parentRef;
            Log.i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", new Object[] { paramAnonymousb.iOi.UN(), paramAnonymousb.iNV });
            localaz.Co(Util.nullAsNil(paramAnonymousb.iOi.UN()));
            if ((localObject != null) && (localaz.field_parentRef != null) && (!((String)localObject).equals(localaz.field_parentRef))) {
              i = 1;
            }
          }
        }
        for (;;)
        {
          Log.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseChildType, %s, %s", new Object[] { paramAnonymousb.iNV, localaz.field_parentRef });
          for (;;)
          {
            if (i != 0)
            {
              ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().a(localaz, localaz.field_username);
              if (Util.isNullOrNil(localaz.field_parentRef))
              {
                AppMethodBeat.o(212188);
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
                if (paramAnonymousb.iOi.UF())
                {
                  Log.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseFatherType, %s", new Object[] { paramAnonymousb.iNV });
                  i = 1;
                  continue;
                }
                if ((!paramAnonymousb.iOi.UC()) && (!ab.JA(((ax)localObject).field_username)) && (!"officialaccounts".equals(localaz.field_parentRef)))
                {
                  localaz.Co("officialaccounts");
                  i = 1;
                  continue;
                }
                if ((!paramAnonymousb.iOi.UC()) || (localaz.field_parentRef == null)) {
                  break label1015;
                }
                localaz.Co(null);
                i = 1;
                continue;
              }
              if ("officialaccounts".equals(localaz.field_parentRef))
              {
                localaz = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bjY("officialaccounts");
                paramAnonymousb = localaz;
                if (localaz == null)
                {
                  paramAnonymousb = new az("officialaccounts");
                  paramAnonymousb.gCr();
                  ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().e(paramAnonymousb);
                }
                if (Util.isNullOrNil(paramAnonymousb.field_content))
                {
                  Log.i("MicroMsg.SubCoreBiz", "conv content is null");
                  paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().gCz();
                  if (Util.isNullOrNil(paramAnonymousb))
                  {
                    Log.w("MicroMsg.SubCoreBiz", "last convBiz is null");
                    AppMethodBeat.o(212188);
                    return;
                  }
                  paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEx(paramAnonymousb);
                  if ((paramAnonymousb == null) || (paramAnonymousb.field_msgId == 0L))
                  {
                    Log.w("MicroMsg.SubCoreBiz", "last biz msg is error");
                    AppMethodBeat.o(212188);
                    return;
                  }
                  ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(paramAnonymousb.field_msgId, paramAnonymousb);
                }
                AppMethodBeat.o(212188);
                return;
              }
              Log.i("MicroMsg.SubCoreBiz", "hakon username = %s, parentRef = %s", new Object[] { paramAnonymousb.iNV, localaz.field_parentRef });
              paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bjY(localaz.field_parentRef);
              if (paramAnonymousb == null)
              {
                AppMethodBeat.o(212188);
                return;
              }
              if (Util.isNullOrNil(paramAnonymousb.field_content))
              {
                Log.i("MicroMsg.SubCoreBiz", "conv content is null");
                paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bkl(localaz.field_parentRef);
                if (Util.isNullOrNil(paramAnonymousb))
                {
                  Log.w("MicroMsg.SubCoreBiz", "last enterprise convBiz is null");
                  AppMethodBeat.o(212188);
                  return;
                }
                paramAnonymousb = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEx(paramAnonymousb);
                if ((paramAnonymousb == null) || (paramAnonymousb.field_msgId == 0L))
                {
                  Log.w("MicroMsg.SubCoreBiz", "last enterprise biz msg is error");
                  AppMethodBeat.o(212188);
                  return;
                }
                ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(paramAnonymousb.field_msgId, paramAnonymousb);
              }
            }
            AppMethodBeat.o(212188);
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
  
  private static ag baf()
  {
    try
    {
      AppMethodBeat.i(124153);
      ag localag = (ag)y.at(ag.class);
      AppMethodBeat.o(124153);
      return localag;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static j bag()
  {
    AppMethodBeat.i(124154);
    com.tencent.mm.kernel.g.aAf().azk();
    if (baf().iOZ == null) {
      baf().iOZ = new j(com.tencent.mm.kernel.g.aAh().hqK);
    }
    j localj = baf().iOZ;
    AppMethodBeat.o(124154);
    return localj;
  }
  
  public static f bah()
  {
    AppMethodBeat.i(124155);
    com.tencent.mm.kernel.g.aAf().azk();
    if (baf().iOW == null) {
      baf().iOW = new f(com.tencent.mm.kernel.g.aAh().hqK);
    }
    f localf = baf().iOW;
    AppMethodBeat.o(124155);
    return localf;
  }
  
  public static i bai()
  {
    AppMethodBeat.i(124156);
    com.tencent.mm.kernel.g.aAf().azk();
    i locali;
    if (baf().iPa == null)
    {
      baf().iPa = new i();
      locali = baf().iPa;
      com.tencent.mm.kernel.g.aAg().hqi.a(675, locali);
      com.tencent.mm.kernel.g.aAg().hqi.a(672, locali);
      com.tencent.mm.kernel.g.aAg().hqi.a(674, locali);
    }
    for (;;)
    {
      synchronized (locali.duI)
      {
        locali.iOm.clear();
        ??? = locali.iOj;
        if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.seJ, 0) == 1) || (BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED))
        {
          bool = true;
          ((i.a)???).iOn = bool;
          locali.iOj.appId = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.seM, "wx3591b9dad10767f7");
          locali.iOj.path = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.seN, "pages/profile/profile.html");
          locali.iOj.iOo = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.seO, 0);
          Log.i("MicroMsg.BizKFService", "alvinluo initKFGuideAppBrandConfig: %s", new Object[] { locali.iOj });
          locali = baf().iPa;
          AppMethodBeat.o(124156);
          return locali;
        }
      }
      boolean bool = false;
    }
  }
  
  public static d baj()
  {
    AppMethodBeat.i(124157);
    com.tencent.mm.kernel.g.aAf().azk();
    if (baf().iPb == null) {
      baf().iPb = new d(com.tencent.mm.kernel.g.aAh().hqK);
    }
    d locald = baf().iPb;
    AppMethodBeat.o(124157);
    return locald;
  }
  
  public static com.tencent.mm.al.a.b bak()
  {
    AppMethodBeat.i(124158);
    com.tencent.mm.kernel.g.aAf().azk();
    if (baf().iPd == null) {
      baf().iPd = new com.tencent.mm.al.a.b(com.tencent.mm.kernel.g.aAh().hqK);
    }
    com.tencent.mm.al.a.b localb = baf().iPd;
    AppMethodBeat.o(124158);
    return localb;
  }
  
  public static com.tencent.mm.al.a.l bal()
  {
    AppMethodBeat.i(124159);
    com.tencent.mm.kernel.g.aAf().azk();
    if (baf().iPe == null) {
      baf().iPe = new com.tencent.mm.al.a.l(com.tencent.mm.kernel.g.aAh().hqK);
    }
    com.tencent.mm.al.a.l locall = baf().iPe;
    AppMethodBeat.o(124159);
    return locall;
  }
  
  public static com.tencent.mm.al.a.g bam()
  {
    AppMethodBeat.i(124160);
    com.tencent.mm.kernel.g.aAf().azk();
    if (baf().iPf == null) {
      baf().iPf = new com.tencent.mm.al.a.g(com.tencent.mm.kernel.g.aAh().hqK);
    }
    com.tencent.mm.al.a.g localg = baf().iPf;
    AppMethodBeat.o(124160);
    return localg;
  }
  
  public static aa ban()
  {
    AppMethodBeat.i(124161);
    com.tencent.mm.kernel.g.aAf().azk();
    if (baf().iPj == null) {
      baf().iPj = new aa(com.tencent.mm.kernel.g.aAh().hqK);
    }
    aa localaa = baf().iPj;
    AppMethodBeat.o(124161);
    return localaa;
  }
  
  public static q bao()
  {
    AppMethodBeat.i(212190);
    com.tencent.mm.kernel.g.aAf().azk();
    if (baf().iPc == null) {
      baf().iPc = new q(com.tencent.mm.kernel.g.aAh().hqK);
    }
    q localq = baf().iPc;
    AppMethodBeat.o(212190);
    return localq;
  }
  
  public static ae bap()
  {
    AppMethodBeat.i(124162);
    com.tencent.mm.kernel.g.aAf().azk();
    if (baf().iPk == null) {
      baf().iPk = new ae(com.tencent.mm.kernel.g.aAh().hqK);
    }
    ae localae = baf().iPk;
    AppMethodBeat.o(124162);
    return localae;
  }
  
  public static h baq()
  {
    AppMethodBeat.i(124163);
    com.tencent.mm.kernel.g.aAf().azk();
    if (baf().iPh == null) {
      baf().iPh = new h();
    }
    h localh = baf().iPh;
    AppMethodBeat.o(124163);
    return localh;
  }
  
  public static e bar()
  {
    AppMethodBeat.i(124164);
    com.tencent.mm.kernel.g.aAf().azk();
    if (baf().iPi == null) {
      baf().iPi = new e(com.tencent.mm.kernel.g.aAh().hqK);
    }
    e locale = baf().iPi;
    AppMethodBeat.o(124164);
    return locale;
  }
  
  public static o.a bas()
  {
    AppMethodBeat.i(124165);
    com.tencent.mm.kernel.g.aAf().azk();
    if (baf().iOX == null) {
      baf().iOX = new o.a();
    }
    o.a locala = baf().iOX;
    AppMethodBeat.o(124165);
    return locala;
  }
  
  public static l bat()
  {
    AppMethodBeat.i(124166);
    com.tencent.mm.kernel.g.aAf().azk();
    if (baf().iOY == null) {
      baf().iOY = new l();
    }
    l locall = baf().iOY;
    AppMethodBeat.o(124166);
    return locall;
  }
  
  public static a bau()
  {
    AppMethodBeat.i(124167);
    if (baf().iPl == null) {
      baf().iPl = new a();
    }
    a locala = baf().iPl;
    AppMethodBeat.o(124167);
    return locala;
  }
  
  public static com.tencent.mm.al.a.i bav()
  {
    AppMethodBeat.i(124168);
    com.tencent.mm.kernel.g.aAf().azk();
    if (baf().iPg == null) {
      baf().iPg = new com.tencent.mm.al.a.i();
    }
    com.tencent.mm.al.a.i locali = baf().iPg;
    AppMethodBeat.o(124168);
    return locali;
  }
  
  public static long baw()
  {
    AppMethodBeat.i(124169);
    if (iOV == 0L)
    {
      Object localObject = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NTA, null);
      if ((localObject != null) && ((localObject instanceof Long)))
      {
        iOV = ((Long)localObject).longValue();
        Log.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime : %d.(get from ConfigStorage)", new Object[] { Long.valueOf(iOV) });
      }
    }
    if (iOV == 0L)
    {
      iOV = System.currentTimeMillis();
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NTA, Long.valueOf(iOV));
      Log.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime is 0, so get current time : %d.", new Object[] { Long.valueOf(iOV) });
    }
    long l = iOV;
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
    h.d.a(Integer.valueOf(55), this.iDE);
    h.d.a(Integer.valueOf(57), this.iDE);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().c(this.iPn);
    bah().a(this.iPo, null);
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("mmbizattrappsvr_BizAttrSync", this.iPm, true);
    AppMethodBeat.o(124170);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(124171);
    h.d.b(Integer.valueOf(55), this.iDE);
    h.d.b(Integer.valueOf(57), this.iDE);
    i locali;
    if (baf().iPa != null)
    {
      locali = baf().iPa;
      com.tencent.mm.kernel.g.aAg().hqi.b(675, locali);
      com.tencent.mm.kernel.g.aAg().hqi.b(672, locali);
      com.tencent.mm.kernel.g.aAg().hqi.b(674, locali);
    }
    synchronized (locali.duI)
    {
      locali.iOm.clear();
      locali.iOl.clear();
      if (com.tencent.mm.kernel.g.aAf().azp())
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().d(this.iPn);
        bah().a(this.iPo);
      }
      ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("mmbizattrappsvr_BizAttrSync", this.iPm, true);
      AppMethodBeat.o(124171);
      return;
    }
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.al.ag
 * JD-Core Version:    0.7.0.1
 */