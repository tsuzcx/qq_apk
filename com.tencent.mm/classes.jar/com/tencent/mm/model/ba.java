package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q.a;
import com.tencent.mm.g.a.ac;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bp.a;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bq.a;
import com.tencent.mm.storage.bq.b;
import com.tencent.mm.storage.k;
import com.tencent.mm.storage.m;
import com.tencent.mm.storage.s;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class ba
{
  private static ba hFV;
  private static final ca hFX;
  private final c hFL;
  private final aq hFU;
  private com.tencent.mm.compatible.b.g hFW;
  private final int hFY;
  final c.a hFZ;
  private ce hGa;
  private bw hGb;
  private e hGc;
  private ch hGd;
  private z hGe;
  private bp.a hGf;
  private bq.a hGg;
  private bq.a hGh;
  private f hGi;
  
  static
  {
    AppMethodBeat.i(20360);
    hFV = null;
    hFX = new ca();
    AppMethodBeat.o(20360);
  }
  
  private ba(aq paramaq, q.a parama)
  {
    AppMethodBeat.i(20341);
    this.hFW = null;
    this.hFY = 1;
    this.hGa = new ce();
    this.hGb = new bw();
    this.hGc = new e();
    this.hGd = new ch();
    this.hGe = new z();
    this.hGf = new bp.a()
    {
      public final am Bf(String paramAnonymousString)
      {
        return null;
      }
      
      public final void a(bp paramAnonymousbp, am paramAnonymousam)
      {
        AppMethodBeat.i(20325);
        String str = paramAnonymousam.field_username;
        if (am.zs(paramAnonymousam.field_username)) {
          paramAnonymousam.setUsername(am.aSZ(paramAnonymousam.field_username));
        }
        if (bt.isNullOrNil(paramAnonymousam.VD())) {
          paramAnonymousam.sU(com.tencent.mm.platformtools.f.IM(paramAnonymousam.field_nickname));
        }
        if (bt.isNullOrNil(paramAnonymousam.VE())) {
          paramAnonymousam.sV(com.tencent.mm.platformtools.f.IL(paramAnonymousam.field_nickname));
        }
        if (bt.isNullOrNil(paramAnonymousam.field_conRemarkPYShort)) {
          paramAnonymousam.sY(com.tencent.mm.platformtools.f.IM(paramAnonymousam.field_conRemark));
        }
        if (bt.isNullOrNil(paramAnonymousam.field_conRemarkPYFull)) {
          paramAnonymousam.sX(com.tencent.mm.platformtools.f.IL(paramAnonymousam.field_conRemark));
        }
        if (w.i(paramAnonymousam))
        {
          paramAnonymousam.jZ(43);
          paramAnonymousam.sU(com.tencent.mm.platformtools.f.IM(paramAnonymousam.adu()));
          paramAnonymousam.sV(com.tencent.mm.platformtools.f.IL(paramAnonymousam.adu()));
          paramAnonymousam.sX(com.tencent.mm.platformtools.f.IL(paramAnonymousam.adv()));
          paramAnonymousam.sY(paramAnonymousam.adv());
          AppMethodBeat.o(20325);
          return;
        }
        if (w.Ap(str))
        {
          paramAnonymousam.acH();
          paramAnonymousam.ke(4);
          paramAnonymousam.jZ(33);
          if (paramAnonymousam != null) {
            break label336;
          }
        }
        label336:
        for (paramAnonymousbp = new am();; paramAnonymousbp = paramAnonymousam)
        {
          paramAnonymousbp.setUsername(str);
          paramAnonymousbp.acH();
          af.F(paramAnonymousbp);
          paramAnonymousbp.acQ();
          if (paramAnonymousam.adm()) {
            paramAnonymousam.jZ(paramAnonymousam.acE());
          }
          if (w.Ad(str))
          {
            ad.i("MicroMsg.MMCore", "update official account helper showhead %d", new Object[] { Integer.valueOf(31) });
            paramAnonymousam.jZ(31);
          }
          if (paramAnonymousam.adk())
          {
            ba.aBQ();
            c.azv().c(new String[] { str }, "@blacklist");
          }
          ad.d("MicroMsg.MMCore", "onPreInsertContact2: %s, %s", new Object[] { paramAnonymousam.field_username, paramAnonymousam.VD() });
          AppMethodBeat.o(20325);
          return;
        }
      }
      
      public final int b(am paramAnonymousam, boolean paramAnonymousBoolean)
      {
        return 0;
      }
    };
    this.hGg = new bq.a()
    {
      public final void a(at paramAnonymousat, bq paramAnonymousbq)
      {
        AppMethodBeat.i(20326);
        if (paramAnonymousat == null)
        {
          AppMethodBeat.o(20326);
          return;
        }
        if ((!am.aSN(paramAnonymousat.field_username)) && (!am.aSP(paramAnonymousat.field_username)) && (!am.zs(paramAnonymousat.field_username)) && (!w.zE(paramAnonymousat.field_username)) && (!am.aSQ(paramAnonymousat.field_username)))
        {
          AppMethodBeat.o(20326);
          return;
        }
        if (am.zs(paramAnonymousat.field_username))
        {
          paramAnonymousat = paramAnonymousbq.aTz("floatbottle");
          if (paramAnonymousat != null) {
            break label472;
          }
          paramAnonymousat = new at("floatbottle");
        }
        label472:
        for (int i = 1;; i = 0)
        {
          paramAnonymousat.kq(1);
          paramAnonymousat.kp(o.aAe());
          ba.aBQ();
          com.tencent.mm.storage.bu localbu = c.azs().aqa(" and not ( type = 10000 and isSend != 2 ) ");
          if ((localbu != null) && (localbu.field_msgId > 0L))
          {
            paramAnonymousat.aL(localbu);
            paramAnonymousat.setContent(am.aSZ(localbu.field_talker) + ":" + localbu.field_content);
            paramAnonymousat.tA(Integer.toString(localbu.getType()));
            bq.b localb = paramAnonymousbq.Na();
            if (localb != null)
            {
              PString localPString1 = new PString();
              PString localPString2 = new PString();
              PInt localPInt = new PInt();
              localbu.tN("floatbottle");
              localbu.setContent(paramAnonymousat.field_content);
              localb.a(localbu, localPString1, localPString2, localPInt, false);
              paramAnonymousat.tB(localPString1.value);
              paramAnonymousat.tC(localPString2.value);
              paramAnonymousat.ks(localPInt.value);
            }
          }
          while (i != 0)
          {
            paramAnonymousbq.e(paramAnonymousat);
            AppMethodBeat.o(20326);
            return;
            paramAnonymousat.fqK();
          }
          paramAnonymousbq.a(paramAnonymousat, paramAnonymousat.field_username);
          AppMethodBeat.o(20326);
          return;
          if ((am.aSN(paramAnonymousat.field_username)) || (am.aSP(paramAnonymousat.field_username)))
          {
            AppMethodBeat.o(20326);
            return;
          }
          com.tencent.mm.kernel.g.ab(com.tencent.mm.am.q.class);
          s.b(paramAnonymousat, paramAnonymousbq);
          if ("@blacklist".equals(paramAnonymousat.field_parentRef))
          {
            ba.aBQ();
            paramAnonymousbq = c.azp().Bf(paramAnonymousat.field_username);
            if ((paramAnonymousbq != null) && (!bt.isNullOrNil(paramAnonymousbq.field_username)) && (!paramAnonymousbq.adk()))
            {
              ba.aBQ();
              c.azv().c(new String[] { paramAnonymousat.field_username }, "");
            }
          }
          AppMethodBeat.o(20326);
          return;
        }
      }
    };
    this.hGh = new bq.a()
    {
      public final void a(at paramAnonymousat, bq paramAnonymousbq)
      {
        if (paramAnonymousat == null) {}
      }
    };
    this.hGi = new f();
    this.hFU = paramaq;
    this.hFZ = new c.a()
    {
      public final void ew(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(20322);
        ad.i("MicroMsg.MMCore", "summeranrt2 onAccountPostReset tid:%d stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), bt.flS() });
        ba.b(ba.this);
        long l1 = System.currentTimeMillis();
        ba.aBQ();
        long l2 = c.getDataDB().xO(Thread.currentThread().getId());
        ba.a(ba.this);
        Object localObject;
        am localam1;
        am localam2;
        if (paramAnonymousBoolean)
        {
          ad.i("MicroMsg.MMCore", "[doAccountPostReset] updated is true");
          c.azp().aTr("readerapp");
          c.ajl().set(256, Boolean.TRUE);
          ad.i("MicroMsg.MMCore", "[doAccountPostReset] begin to updated HardCodeUpdate");
          localObject = w.aBm();
          ad.i("MicroMsg.HardCodeUpdateTask", "[updateHelperIndexFor50] size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localam1 = (am)((Iterator)localObject).next();
            if ((localam1 != null) && ((int)localam1.gfj != 0) && (localam1.field_showHead == 32))
            {
              localam1.jZ(localam1.acE());
              ad.d("MicroMsg.HardCodeUpdateTask", "contact to updatefavour " + localam1.field_username);
              ba.aBQ();
              c.azp().c(localam1.field_username, localam1);
            }
          }
          localObject = w.hFm;
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            localam1 = localObject[i];
            localam2 = c.azp().Bf(localam1);
            if ((localam2 != null) && (((int)localam2.gfj != 0) || (com.tencent.mm.o.b.lM(localam2.field_type))))
            {
              localam2.acQ();
              c.azp().c(localam1, localam2);
            }
            i += 1;
          }
          ag.aBw();
          bl.Bs("ver" + com.tencent.mm.protocal.d.Fnj);
        }
        new af(ba.a(ba.this));
        if (paramAnonymousBoolean)
        {
          af.E(c.azp().Bf("filehelper"));
          localObject = u.aAm();
          if (!bt.isNullOrNil((String)localObject))
          {
            localam1 = c.azp().Bf((String)localObject);
            if ((int)localam1.gfj != 0) {
              break label1435;
            }
            localam1.setUsername((String)localObject);
            localam1.acH();
            ba.aBQ();
            c.azp().ag(localam1);
          }
          af.a(paramAnonymousBoolean, "qqmail", false);
          af.a(paramAnonymousBoolean, "floatbottle", false);
          af.a(paramAnonymousBoolean, "shakeapp", false);
          af.a(paramAnonymousBoolean, "lbsapp", false);
          af.a(paramAnonymousBoolean, "medianote", false);
          af.a(paramAnonymousBoolean, "newsapp", true);
          c.azv().aTx("blogapp");
          c.azs().aqe("blogapp");
          c.azp().aTr("blogapp");
          af.a(paramAnonymousBoolean, "facebookapp", true);
          af.a(paramAnonymousBoolean, "qqfriend", false);
          af.a(paramAnonymousBoolean, "masssendapp", true);
          af.a(paramAnonymousBoolean, "feedsapp", true);
          c.azv().aTx("tmessage");
          c.azp().aTr("tmessage");
          localam2 = c.azp().Bf("voip");
          localam1 = c.azp().Bf("voipapp");
          localObject = localam1;
          if (localam1 == null) {
            localObject = new am();
          }
          if ((localam2 != null) && ((int)localam2.gfj != 0)) {
            c.azp().aTr("voip");
          }
          if ((int)((com.tencent.mm.o.b)localObject).gfj != 0) {
            break label1471;
          }
          ((am)localObject).setUsername("voipapp");
          ((am)localObject).acH();
          af.F((am)localObject);
          ((am)localObject).ke(4);
          ((am)localObject).acQ();
          c.azp().ah((am)localObject);
          label724:
          localam1 = c.azp().Bf("officialaccounts");
          localObject = localam1;
          if (localam1 == null) {
            localObject = new am();
          }
          ad.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.o.b)localObject).gfj) });
          if ((int)((com.tencent.mm.o.b)localObject).gfj != 0) {
            break label1497;
          }
          ((am)localObject).setUsername("officialaccounts");
          ((am)localObject).acI();
          af.F((am)localObject);
          ((am)localObject).ke(3);
          c.azp().ah((am)localObject);
          label831:
          localam2 = c.azp().Bf("voipaudio");
          localam1 = c.azp().Bf("voicevoipapp");
          localObject = localam1;
          if (localam1 == null) {
            localObject = new am();
          }
          if ((localam2 != null) && ((int)localam2.gfj != 0)) {
            c.azp().aTr("voipaudio");
          }
          if ((int)((com.tencent.mm.o.b)localObject).gfj != 0) {
            break label1532;
          }
          ((am)localObject).setUsername("voicevoipapp");
          ((am)localObject).acH();
          af.F((am)localObject);
          ((am)localObject).ke(4);
          ((am)localObject).acQ();
          c.azp().ah((am)localObject);
          label950:
          af.a(paramAnonymousBoolean, "voiceinputapp", false);
          af.a(paramAnonymousBoolean, "linkedinplugin", false);
          localam1 = c.azp().Bf("notifymessage");
          localObject = localam1;
          if (localam1 == null) {
            localObject = new am();
          }
          ad.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.o.b)localObject).gfj) });
          if ((int)((com.tencent.mm.o.b)localObject).gfj != 0) {
            break label1558;
          }
          ((am)localObject).setUsername("notifymessage");
          ((am)localObject).acI();
          af.F((am)localObject);
          ((am)localObject).ke(3);
          c.azp().ah((am)localObject);
          label1075:
          localam1 = c.azp().Bf("appbrandcustomerservicemsg");
          localObject = localam1;
          if (localam1 == null) {
            localObject = new am();
          }
          ad.i("MicroMsg.HardCodeHelper", "hardcodeAppBrandServiceMessage:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.o.b)localObject).gfj) });
          if ((int)((com.tencent.mm.o.b)localObject).gfj != 0) {
            break label1593;
          }
          ((am)localObject).setUsername("appbrandcustomerservicemsg");
          ((am)localObject).acI();
          af.F((am)localObject);
          ((am)localObject).setType(0);
          ((am)localObject).ke(3);
          c.azp().ah((am)localObject);
          label1188:
          localam1 = c.azp().Bf("appbrand_notify_message");
          localObject = localam1;
          if (localam1 == null) {
            localObject = new am();
          }
          ad.i("MicroMsg.HardCodeHelper", "hardcodeAppBrandNotifyMessage:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.o.b)localObject).gfj) });
          if ((int)((com.tencent.mm.o.b)localObject).gfj != 0) {
            break label1628;
          }
          ((am)localObject).setUsername("appbrand_notify_message");
          ((am)localObject).acI();
          af.F((am)localObject);
          ((am)localObject).ke(3);
          c.azp().ah((am)localObject);
        }
        for (;;)
        {
          af.a(paramAnonymousBoolean, "downloaderapp", true);
          if (paramAnonymousBoolean)
          {
            ba.aBQ();
            c.azv().aTx("Weixin");
            ba.aBQ();
            c.azp().aTr("Weixin");
          }
          ba.aBQ();
          c.getDataDB().sJ(l2);
          ad.i("MicroMsg.MMCore", "summeranrt dkwt set forceManual :%b, tid[%d], take[%s]ms, stack[%s]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l1), bt.flS() });
          ba.a(ba.this);
          c.azv().a(ba.c(ba.aBT()).Na());
          AppMethodBeat.o(20322);
          return;
          label1435:
          if (com.tencent.mm.o.b.lM(localam1.field_type)) {
            break;
          }
          localam1.acH();
          ba.aBQ();
          c.azp().c((String)localObject, localam1);
          break;
          label1471:
          if (!paramAnonymousBoolean) {
            break label724;
          }
          ((am)localObject).acQ();
          c.azp().c("voipapp", (am)localObject);
          break label724;
          label1497:
          if (!paramAnonymousBoolean) {
            break label831;
          }
          ad.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
          ((am)localObject).acI();
          c.azp().c("officialaccounts", (am)localObject);
          break label831;
          label1532:
          if (!paramAnonymousBoolean) {
            break label950;
          }
          ((am)localObject).acQ();
          c.azp().c("voicevoipapp", (am)localObject);
          break label950;
          label1558:
          if (!paramAnonymousBoolean) {
            break label1075;
          }
          ad.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
          ((am)localObject).acI();
          c.azp().c("notifymessage", (am)localObject);
          break label1075;
          label1593:
          if (!paramAnonymousBoolean) {
            break label1188;
          }
          ad.i("MicroMsg.HardCodeHelper", "do update app brand service message accunt");
          ((am)localObject).acI();
          c.azp().c("appbrandcustomerservicemsg", (am)localObject);
          break label1188;
          label1628:
          if (paramAnonymousBoolean)
          {
            ad.i("MicroMsg.HardCodeHelper", "do update app brand service message accunt");
            ((am)localObject).acI();
            c.azp().c("appbrand_notify_message", (am)localObject);
          }
        }
      }
    };
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.b(a.class, new a());
    com.tencent.mm.kernel.g.ajD().gBT.bu(parama);
    this.hFL = new c();
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(99L, 142L, 1L, false);
    com.tencent.mm.al.u.a(new ba.2(this));
    com.tencent.mm.kernel.g.ajD();
    paramaq = com.tencent.mm.kernel.g.ajB();
    parama = new com.tencent.mm.kernel.api.d()
    {
      public final void b(com.tencent.mm.network.e paramAnonymouse)
      {
        AppMethodBeat.i(20324);
        com.tencent.mm.modelstat.q.d(paramAnonymouse);
        com.tencent.mm.modelstat.q.e(paramAnonymouse);
        AppMethodBeat.o(20324);
      }
    };
    paramaq.gAN.bu(parama);
    AppMethodBeat.o(20341);
  }
  
  public static ai Nb()
  {
    AppMethodBeat.i(20340);
    ai localai = aBN().hFU.Nb();
    AppMethodBeat.o(20340);
    return localai;
  }
  
  public static void a(ap paramap)
  {
    AppMethodBeat.i(20333);
    com.tencent.mm.kernel.b.a(paramap);
    AppMethodBeat.o(20333);
  }
  
  public static void a(aq paramaq, q.a parama)
  {
    AppMethodBeat.i(20338);
    hFV = new ba(paramaq, parama);
    com.tencent.mm.modelstat.o.cK(aj.getContext());
    AppMethodBeat.o(20338);
  }
  
  public static void a(n paramn)
  {
    AppMethodBeat.i(20331);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().a(paramn);
    AppMethodBeat.o(20331);
  }
  
  public static boolean aBJ()
  {
    return hFV == null;
  }
  
  public static ca aBK()
  {
    AppMethodBeat.i(20335);
    aBN();
    ca localca = hFX;
    AppMethodBeat.o(20335);
    return localca;
  }
  
  public static boolean aBL()
  {
    AppMethodBeat.i(20336);
    boolean bool = com.tencent.mm.kernel.a.aiD();
    AppMethodBeat.o(20336);
    return bool;
  }
  
  public static void aBM()
  {
    AppMethodBeat.i(20337);
    com.tencent.mm.kernel.a.dB(false);
    AppMethodBeat.o(20337);
  }
  
  private static ba aBN()
  {
    AppMethodBeat.i(20342);
    Assert.assertNotNull("MMCore not initialized by MMApplication", hFV);
    ba localba = hFV;
    AppMethodBeat.o(20342);
    return localba;
  }
  
  public static ah aBO()
  {
    AppMethodBeat.i(20343);
    com.tencent.mm.kernel.g.ajD();
    ah localah = com.tencent.mm.kernel.g.ajC().gBh;
    AppMethodBeat.o(20343);
    return localah;
  }
  
  public static void aBP()
  {
    AppMethodBeat.i(20347);
    ac localac = new ac();
    com.tencent.mm.sdk.b.a.IbL.l(localac);
    AppMethodBeat.o(20347);
  }
  
  public static c aBQ()
  {
    AppMethodBeat.i(20348);
    c localc = aBN().hFL;
    if (localc != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("MMCore has not been initialize ?", bool);
      AppMethodBeat.o(20348);
      return localc;
    }
  }
  
  public static boolean aBR()
  {
    AppMethodBeat.i(20351);
    com.tencent.mm.kernel.g.ajA();
    boolean bool = com.tencent.mm.kernel.a.aiJ();
    AppMethodBeat.o(20351);
    return bool;
  }
  
  public static f aBS()
  {
    AppMethodBeat.i(20357);
    f localf = aBN().hGi;
    AppMethodBeat.o(20357);
    return localf;
  }
  
  public static boolean aiE()
  {
    AppMethodBeat.i(20353);
    boolean bool = com.tencent.mm.kernel.a.aiE();
    AppMethodBeat.o(20353);
    return bool;
  }
  
  public static String aiO()
  {
    AppMethodBeat.i(20346);
    String str = com.tencent.mm.kernel.a.aiO();
    AppMethodBeat.o(20346);
    return str;
  }
  
  public static com.tencent.mm.al.q aiU()
  {
    AppMethodBeat.i(20349);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.al.q localq = com.tencent.mm.kernel.g.ajB().gAO;
    AppMethodBeat.o(20349);
    return localq;
  }
  
  public static String ais()
  {
    AppMethodBeat.i(20356);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajA();
    String str = com.tencent.mm.kernel.a.ais();
    AppMethodBeat.o(20356);
    return str;
  }
  
  @Deprecated
  public static com.tencent.mm.sdk.platformtools.aq ajF()
  {
    AppMethodBeat.i(20344);
    com.tencent.mm.sdk.platformtools.aq localaq = com.tencent.mm.kernel.g.ajF();
    AppMethodBeat.o(20344);
    return localaq;
  }
  
  public static boolean ajx()
  {
    AppMethodBeat.i(20352);
    if (!aj.cnC())
    {
      AppMethodBeat.o(20352);
      return false;
    }
    boolean bool = com.tencent.mm.kernel.g.ajx();
    AppMethodBeat.o(20352);
    return bool;
  }
  
  public static void b(n paramn)
  {
    AppMethodBeat.i(20332);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().b(paramn);
    AppMethodBeat.o(20332);
  }
  
  public static ar getNotification()
  {
    AppMethodBeat.i(20339);
    ar localar = aBN().hFU.getNotification();
    AppMethodBeat.o(20339);
    return localar;
  }
  
  public static cd getSysCmdMsgExtension()
  {
    AppMethodBeat.i(20345);
    cd localcd = ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension();
    AppMethodBeat.o(20345);
    return localcd;
  }
  
  public static void hold()
  {
    AppMethodBeat.i(20354);
    com.tencent.mm.kernel.a.hold();
    AppMethodBeat.o(20354);
  }
  
  public static void unhold()
  {
    AppMethodBeat.i(20355);
    com.tencent.mm.kernel.a.unhold();
    AppMethodBeat.o(20355);
  }
  
  public static void wR(String paramString)
  {
    AppMethodBeat.i(20334);
    com.tencent.mm.kernel.a.wR(paramString);
    AppMethodBeat.o(20334);
  }
  
  class a
    implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.api.e, com.tencent.mm.kernel.c.a
  {
    a() {}
    
    public HashMap<Integer, h.b> collectDatabaseFactory()
    {
      AppMethodBeat.i(20330);
      ad.i("MicroMsg.MMCore", "collectDatabaseFactory ");
      HashMap localHashMap = new HashMap();
      localHashMap.putAll(c.baseDBFactories);
      AppMethodBeat.o(20330);
      return localHashMap;
    }
    
    public void onAccountInitialized(e.c paramc)
    {
      AppMethodBeat.i(20327);
      if (paramc.gBH) {
        com.tencent.mm.z.c.aht().w(262145, false);
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(598L, 13L, 1L, false);
      long l = System.currentTimeMillis();
      ad.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized start tid[%d]", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
      Object localObject1 = ba.a(ba.this);
      com.tencent.mm.storagebase.h localh = com.tencent.mm.kernel.g.ajC().gBq;
      com.tencent.mm.kernel.g.ajC();
      com.tencent.mm.plugin.messenger.foundation.a.a.i locali = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK();
      locali.a(new be(locali));
      Object localObject2 = new com.tencent.mm.storage.h(locali);
      ((c)localObject1).hEn = ((com.tencent.mm.storage.h)localObject2);
      locali.a((com.tencent.mm.storage.e)localObject2);
      localObject2 = new com.tencent.mm.storage.i(locali);
      ((c)localObject1).hEo = ((com.tencent.mm.storage.i)localObject2);
      locali.a((com.tencent.mm.storage.e)localObject2);
      ((c)localObject1).hEl = new bv(localh, ((l)com.tencent.mm.kernel.g.ab(l.class)).azv());
      ((c)localObject1).hEm = new bu(localh, ((l)com.tencent.mm.kernel.g.ab(l.class)).azp());
      ((c)localObject1).hEp = new com.tencent.mm.model.b.c();
      ((c)localObject1).hEq = new com.tencent.mm.model.b.d();
      ((c)localObject1).hEu = new com.tencent.mm.model.b.b();
      ((c)localObject1).hEr = new k(localh);
      ((c)localObject1).hEs = new com.tencent.mm.storage.o(localh);
      ((c)localObject1).hEt = new m(localh);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(598L, 14L, 1L, false);
      ad.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done initDB take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      localObject1 = ba.this.hFZ;
      ba.a(ba.this);
      ((c.a)localObject1).ew(paramc.gBH);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(598L, 15L, 1L, false);
      ad.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done onAccountPostReset take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      com.tencent.mm.compatible.util.e.abf();
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(598L, 16L, 1L, false);
      ad.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done all take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(20327);
    }
    
    public void onAccountRelease() {}
    
    public void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
    
    public void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
    {
      AppMethodBeat.i(20329);
      ba.a(ba.this);
      AppMethodBeat.o(20329);
    }
    
    public void parallelsDependency()
    {
      AppMethodBeat.i(20328);
      com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bA(com.tencent.mm.kernel.g.ad(r.class));
      AppMethodBeat.o(20328);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.ba
 * JD-Core Version:    0.7.0.1
 */