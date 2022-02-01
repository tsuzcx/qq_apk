package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.u;
import com.tencent.mm.g.a.ac;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bq.a;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.br.a;
import com.tencent.mm.storage.br.b;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.k;
import com.tencent.mm.storage.m;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class bc
{
  private static bc hIN;
  private static final cc hIP;
  private final c hID;
  private final as hIM;
  private com.tencent.mm.compatible.b.g hIO;
  private final int hIQ;
  final c.a hIR;
  private cg hIS;
  private by hIT;
  private e hIU;
  private cj hIV;
  private aa hIW;
  private bq.a hIX;
  private br.a hIY;
  private br.a hIZ;
  private f hJa;
  
  static
  {
    AppMethodBeat.i(20360);
    hIN = null;
    hIP = new cc();
    AppMethodBeat.o(20360);
  }
  
  private bc(as paramas, q.a parama)
  {
    AppMethodBeat.i(20341);
    this.hIO = null;
    this.hIQ = 1;
    this.hIS = new cg();
    this.hIT = new by();
    this.hIU = new e();
    this.hIV = new cj();
    this.hIW = new aa();
    this.hIX = new bq.a()
    {
      public final an BH(String paramAnonymousString)
      {
        return null;
      }
      
      public final void a(bq paramAnonymousbq, an paramAnonymousan)
      {
        AppMethodBeat.i(20325);
        String str = paramAnonymousan.field_username;
        if (an.Ac(paramAnonymousan.field_username)) {
          paramAnonymousan.setUsername(an.aUA(paramAnonymousan.field_username));
        }
        if (bu.isNullOrNil(paramAnonymousan.VL())) {
          paramAnonymousan.tp(com.tencent.mm.platformtools.f.Jl(paramAnonymousan.field_nickname));
        }
        if (bu.isNullOrNil(paramAnonymousan.VM())) {
          paramAnonymousan.tq(com.tencent.mm.platformtools.f.Jk(paramAnonymousan.field_nickname));
        }
        if (bu.isNullOrNil(paramAnonymousan.field_conRemarkPYShort)) {
          paramAnonymousan.tt(com.tencent.mm.platformtools.f.Jl(paramAnonymousan.field_conRemark));
        }
        if (bu.isNullOrNil(paramAnonymousan.field_conRemarkPYFull)) {
          paramAnonymousan.ts(com.tencent.mm.platformtools.f.Jk(paramAnonymousan.field_conRemark));
        }
        if (x.p(paramAnonymousan))
        {
          paramAnonymousan.kb(43);
          paramAnonymousan.tp(com.tencent.mm.platformtools.f.Jl(paramAnonymousan.adF()));
          paramAnonymousan.tq(com.tencent.mm.platformtools.f.Jk(paramAnonymousan.adF()));
          paramAnonymousan.ts(com.tencent.mm.platformtools.f.Jk(paramAnonymousan.adG()));
          paramAnonymousan.tt(paramAnonymousan.adG());
          AppMethodBeat.o(20325);
          return;
        }
        if (x.AZ(str))
        {
          paramAnonymousan.acS();
          paramAnonymousan.kg(4);
          paramAnonymousan.kb(33);
          if (paramAnonymousan != null) {
            break label336;
          }
        }
        label336:
        for (paramAnonymousbq = new an();; paramAnonymousbq = paramAnonymousan)
        {
          paramAnonymousbq.setUsername(str);
          paramAnonymousbq.acS();
          ag.M(paramAnonymousbq);
          paramAnonymousbq.adb();
          if (paramAnonymousan.adx()) {
            paramAnonymousan.kb(paramAnonymousan.acP());
          }
          if (x.AN(str))
          {
            ae.i("MicroMsg.MMCore", "update official account helper showhead %d", new Object[] { Integer.valueOf(31) });
            paramAnonymousan.kb(31);
          }
          if (paramAnonymousan.adv())
          {
            bc.aCg();
            c.azL().c(new String[] { str }, "@blacklist");
          }
          ae.d("MicroMsg.MMCore", "onPreInsertContact2: %s, %s", new Object[] { paramAnonymousan.field_username, paramAnonymousan.VL() });
          AppMethodBeat.o(20325);
          return;
        }
      }
      
      public final int b(an paramAnonymousan, boolean paramAnonymousBoolean)
      {
        return 0;
      }
    };
    this.hIY = new br.a()
    {
      public final void a(au paramAnonymousau, br paramAnonymousbr)
      {
        AppMethodBeat.i(20326);
        if (paramAnonymousau == null)
        {
          AppMethodBeat.o(20326);
          return;
        }
        if ((!an.aUn(paramAnonymousau.field_username)) && (!an.aUp(paramAnonymousau.field_username)) && (!an.Ac(paramAnonymousau.field_username)) && (!x.Ao(paramAnonymousau.field_username)) && (!an.aUq(paramAnonymousau.field_username)))
        {
          AppMethodBeat.o(20326);
          return;
        }
        if (an.Ac(paramAnonymousau.field_username))
        {
          paramAnonymousau = paramAnonymousbr.aVa("floatbottle");
          if (paramAnonymousau != null) {
            break label472;
          }
          paramAnonymousau = new au("floatbottle");
        }
        label472:
        for (int i = 1;; i = 0)
        {
          paramAnonymousau.ks(1);
          paramAnonymousau.kr(o.aAu());
          bc.aCg();
          bv localbv = c.azI().arf(" and not ( type = 10000 and isSend != 2 ) ");
          if ((localbv != null) && (localbv.field_msgId > 0L))
          {
            paramAnonymousau.aK(localbv);
            paramAnonymousau.setContent(an.aUA(localbv.field_talker) + ":" + localbv.field_content);
            paramAnonymousau.tV(Integer.toString(localbv.getType()));
            br.b localb = paramAnonymousbr.MV();
            if (localb != null)
            {
              PString localPString1 = new PString();
              PString localPString2 = new PString();
              PInt localPInt = new PInt();
              localbv.ui("floatbottle");
              localbv.setContent(paramAnonymousau.field_content);
              localb.a(localbv, localPString1, localPString2, localPInt, false);
              paramAnonymousau.tW(localPString1.value);
              paramAnonymousau.tX(localPString2.value);
              paramAnonymousau.ku(localPInt.value);
            }
          }
          while (i != 0)
          {
            paramAnonymousbr.e(paramAnonymousau);
            AppMethodBeat.o(20326);
            return;
            paramAnonymousau.fuK();
          }
          paramAnonymousbr.a(paramAnonymousau, paramAnonymousau.field_username);
          AppMethodBeat.o(20326);
          return;
          if ((an.aUn(paramAnonymousau.field_username)) || (an.aUp(paramAnonymousau.field_username)))
          {
            AppMethodBeat.o(20326);
            return;
          }
          com.tencent.mm.kernel.g.ab(com.tencent.mm.al.q.class);
          com.tencent.mm.storage.s.b(paramAnonymousau, paramAnonymousbr);
          if ("@blacklist".equals(paramAnonymousau.field_parentRef))
          {
            bc.aCg();
            paramAnonymousbr = c.azF().BH(paramAnonymousau.field_username);
            if ((paramAnonymousbr != null) && (!bu.isNullOrNil(paramAnonymousbr.field_username)) && (!paramAnonymousbr.adv()))
            {
              bc.aCg();
              c.azL().c(new String[] { paramAnonymousau.field_username }, "");
            }
          }
          AppMethodBeat.o(20326);
          return;
        }
      }
    };
    this.hIZ = new br.a()
    {
      public final void a(au paramAnonymousau, br paramAnonymousbr)
      {
        if (paramAnonymousau == null) {}
      }
    };
    this.hJa = new f();
    this.hIM = paramas;
    this.hIR = new c.a()
    {
      public final void ey(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(20322);
        ae.i("MicroMsg.MMCore", "summeranrt2 onAccountPostReset tid:%d stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), bu.fpN() });
        bc.b(bc.this);
        long l1 = System.currentTimeMillis();
        bc.aCg();
        long l2 = c.getDataDB().yi(Thread.currentThread().getId());
        bc.a(bc.this);
        Object localObject;
        an localan1;
        an localan2;
        if (paramAnonymousBoolean)
        {
          ae.i("MicroMsg.MMCore", "[doAccountPostReset] updated is true");
          c.azF().aUS("readerapp");
          c.ajA().set(256, Boolean.TRUE);
          ae.i("MicroMsg.MMCore", "[doAccountPostReset] begin to updated HardCodeUpdate");
          localObject = x.aBC();
          ae.i("MicroMsg.HardCodeUpdateTask", "[updateHelperIndexFor50] size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localan1 = (an)((Iterator)localObject).next();
            if ((localan1 != null) && ((int)localan1.ght != 0) && (localan1.field_showHead == 32))
            {
              localan1.kb(localan1.acP());
              ae.d("MicroMsg.HardCodeUpdateTask", "contact to updatefavour " + localan1.field_username);
              bc.aCg();
              c.azF().c(localan1.field_username, localan1);
            }
          }
          localObject = x.hIe;
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            localan1 = localObject[i];
            localan2 = c.azF().BH(localan1);
            if ((localan2 != null) && (((int)localan2.ght != 0) || (com.tencent.mm.contact.c.lO(localan2.field_type))))
            {
              localan2.adb();
              c.azF().c(localan1, localan2);
            }
            i += 1;
          }
          ah.aBM();
          bn.BU("ver" + com.tencent.mm.protocal.d.FFH);
        }
        new ag(bc.a(bc.this));
        if (paramAnonymousBoolean)
        {
          ag.L(c.azF().BH("filehelper"));
          localObject = v.aAC();
          if (!bu.isNullOrNil((String)localObject))
          {
            localan1 = c.azF().BH((String)localObject);
            if ((int)localan1.ght != 0) {
              break label1435;
            }
            localan1.setUsername((String)localObject);
            localan1.acS();
            bc.aCg();
            c.azF().an(localan1);
          }
          ag.a(paramAnonymousBoolean, "qqmail", false);
          ag.a(paramAnonymousBoolean, "floatbottle", false);
          ag.a(paramAnonymousBoolean, "shakeapp", false);
          ag.a(paramAnonymousBoolean, "lbsapp", false);
          ag.a(paramAnonymousBoolean, "medianote", false);
          ag.a(paramAnonymousBoolean, "newsapp", true);
          c.azL().aUY("blogapp");
          c.azI().arj("blogapp");
          c.azF().aUS("blogapp");
          ag.a(paramAnonymousBoolean, "facebookapp", true);
          ag.a(paramAnonymousBoolean, "qqfriend", false);
          ag.a(paramAnonymousBoolean, "masssendapp", true);
          ag.a(paramAnonymousBoolean, "feedsapp", true);
          c.azL().aUY("tmessage");
          c.azF().aUS("tmessage");
          localan2 = c.azF().BH("voip");
          localan1 = c.azF().BH("voipapp");
          localObject = localan1;
          if (localan1 == null) {
            localObject = new an();
          }
          if ((localan2 != null) && ((int)localan2.ght != 0)) {
            c.azF().aUS("voip");
          }
          if ((int)((com.tencent.mm.contact.c)localObject).ght != 0) {
            break label1471;
          }
          ((an)localObject).setUsername("voipapp");
          ((an)localObject).acS();
          ag.M((an)localObject);
          ((an)localObject).kg(4);
          ((an)localObject).adb();
          c.azF().ao((an)localObject);
          label724:
          localan1 = c.azF().BH("officialaccounts");
          localObject = localan1;
          if (localan1 == null) {
            localObject = new an();
          }
          ae.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.contact.c)localObject).ght) });
          if ((int)((com.tencent.mm.contact.c)localObject).ght != 0) {
            break label1497;
          }
          ((an)localObject).setUsername("officialaccounts");
          ((an)localObject).acT();
          ag.M((an)localObject);
          ((an)localObject).kg(3);
          c.azF().ao((an)localObject);
          label831:
          localan2 = c.azF().BH("voipaudio");
          localan1 = c.azF().BH("voicevoipapp");
          localObject = localan1;
          if (localan1 == null) {
            localObject = new an();
          }
          if ((localan2 != null) && ((int)localan2.ght != 0)) {
            c.azF().aUS("voipaudio");
          }
          if ((int)((com.tencent.mm.contact.c)localObject).ght != 0) {
            break label1532;
          }
          ((an)localObject).setUsername("voicevoipapp");
          ((an)localObject).acS();
          ag.M((an)localObject);
          ((an)localObject).kg(4);
          ((an)localObject).adb();
          c.azF().ao((an)localObject);
          label950:
          ag.a(paramAnonymousBoolean, "voiceinputapp", false);
          ag.a(paramAnonymousBoolean, "linkedinplugin", false);
          localan1 = c.azF().BH("notifymessage");
          localObject = localan1;
          if (localan1 == null) {
            localObject = new an();
          }
          ae.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.contact.c)localObject).ght) });
          if ((int)((com.tencent.mm.contact.c)localObject).ght != 0) {
            break label1558;
          }
          ((an)localObject).setUsername("notifymessage");
          ((an)localObject).acT();
          ag.M((an)localObject);
          ((an)localObject).kg(3);
          c.azF().ao((an)localObject);
          label1075:
          localan1 = c.azF().BH("appbrandcustomerservicemsg");
          localObject = localan1;
          if (localan1 == null) {
            localObject = new an();
          }
          ae.i("MicroMsg.HardCodeHelper", "hardcodeAppBrandServiceMessage:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.contact.c)localObject).ght) });
          if ((int)((com.tencent.mm.contact.c)localObject).ght != 0) {
            break label1593;
          }
          ((an)localObject).setUsername("appbrandcustomerservicemsg");
          ((an)localObject).acT();
          ag.M((an)localObject);
          ((an)localObject).setType(0);
          ((an)localObject).kg(3);
          c.azF().ao((an)localObject);
          label1188:
          localan1 = c.azF().BH("appbrand_notify_message");
          localObject = localan1;
          if (localan1 == null) {
            localObject = new an();
          }
          ae.i("MicroMsg.HardCodeHelper", "hardcodeAppBrandNotifyMessage:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.contact.c)localObject).ght) });
          if ((int)((com.tencent.mm.contact.c)localObject).ght != 0) {
            break label1628;
          }
          ((an)localObject).setUsername("appbrand_notify_message");
          ((an)localObject).acT();
          ag.M((an)localObject);
          ((an)localObject).kg(3);
          c.azF().ao((an)localObject);
        }
        for (;;)
        {
          ag.a(paramAnonymousBoolean, "downloaderapp", true);
          if (paramAnonymousBoolean)
          {
            bc.aCg();
            c.azL().aUY("Weixin");
            bc.aCg();
            c.azF().aUS("Weixin");
          }
          bc.aCg();
          c.getDataDB().sW(l2);
          ae.i("MicroMsg.MMCore", "summeranrt dkwt set forceManual :%b, tid[%d], take[%s]ms, stack[%s]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l1), bu.fpN() });
          bc.a(bc.this);
          c.azL().a(bc.c(bc.aCj()).MV());
          AppMethodBeat.o(20322);
          return;
          label1435:
          if (com.tencent.mm.contact.c.lO(localan1.field_type)) {
            break;
          }
          localan1.acS();
          bc.aCg();
          c.azF().c((String)localObject, localan1);
          break;
          label1471:
          if (!paramAnonymousBoolean) {
            break label724;
          }
          ((an)localObject).adb();
          c.azF().c("voipapp", (an)localObject);
          break label724;
          label1497:
          if (!paramAnonymousBoolean) {
            break label831;
          }
          ae.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
          ((an)localObject).acT();
          c.azF().c("officialaccounts", (an)localObject);
          break label831;
          label1532:
          if (!paramAnonymousBoolean) {
            break label950;
          }
          ((an)localObject).adb();
          c.azF().c("voicevoipapp", (an)localObject);
          break label950;
          label1558:
          if (!paramAnonymousBoolean) {
            break label1075;
          }
          ae.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
          ((an)localObject).acT();
          c.azF().c("notifymessage", (an)localObject);
          break label1075;
          label1593:
          if (!paramAnonymousBoolean) {
            break label1188;
          }
          ae.i("MicroMsg.HardCodeHelper", "do update app brand service message accunt");
          ((an)localObject).acT();
          c.azF().c("appbrandcustomerservicemsg", (an)localObject);
          break label1188;
          label1628:
          if (paramAnonymousBoolean)
          {
            ae.i("MicroMsg.HardCodeHelper", "do update app brand service message accunt");
            ((an)localObject).acT();
            c.azF().c("appbrand_notify_message", (an)localObject);
          }
        }
      }
    };
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.b(a.class, new a());
    com.tencent.mm.kernel.g.ajS().gEA.bu(parama);
    this.hID = new c();
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(99L, 142L, 1L, false);
    u.a(new bc.2(this));
    com.tencent.mm.kernel.g.ajS();
    paramas = com.tencent.mm.kernel.g.ajQ();
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
    paramas.gDu.bu(parama);
    AppMethodBeat.o(20341);
  }
  
  public static aj MW()
  {
    AppMethodBeat.i(20340);
    aj localaj = aCd().hIM.MW();
    AppMethodBeat.o(20340);
    return localaj;
  }
  
  public static void a(ar paramar)
  {
    AppMethodBeat.i(20333);
    com.tencent.mm.kernel.b.a(paramar);
    AppMethodBeat.o(20333);
  }
  
  public static void a(as paramas, q.a parama)
  {
    AppMethodBeat.i(20338);
    hIN = new bc(paramas, parama);
    com.tencent.mm.modelstat.o.cM(ak.getContext());
    AppMethodBeat.o(20338);
  }
  
  public static void a(n paramn)
  {
    AppMethodBeat.i(20331);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().a(paramn);
    AppMethodBeat.o(20331);
  }
  
  public static boolean aBZ()
  {
    return hIN == null;
  }
  
  public static cc aCa()
  {
    AppMethodBeat.i(20335);
    aCd();
    cc localcc = hIP;
    AppMethodBeat.o(20335);
    return localcc;
  }
  
  public static boolean aCb()
  {
    AppMethodBeat.i(20336);
    boolean bool = com.tencent.mm.kernel.a.aiS();
    AppMethodBeat.o(20336);
    return bool;
  }
  
  public static void aCc()
  {
    AppMethodBeat.i(20337);
    com.tencent.mm.kernel.a.dC(false);
    AppMethodBeat.o(20337);
  }
  
  private static bc aCd()
  {
    AppMethodBeat.i(20342);
    Assert.assertNotNull("MMCore not initialized by MMApplication", hIN);
    bc localbc = hIN;
    AppMethodBeat.o(20342);
    return localbc;
  }
  
  public static ai aCe()
  {
    AppMethodBeat.i(20343);
    com.tencent.mm.kernel.g.ajS();
    ai localai = com.tencent.mm.kernel.g.ajR().gDO;
    AppMethodBeat.o(20343);
    return localai;
  }
  
  public static void aCf()
  {
    AppMethodBeat.i(20347);
    ac localac = new ac();
    com.tencent.mm.sdk.b.a.IvT.l(localac);
    AppMethodBeat.o(20347);
  }
  
  public static c aCg()
  {
    AppMethodBeat.i(20348);
    c localc = aCd().hID;
    if (localc != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("MMCore has not been initialize ?", bool);
      AppMethodBeat.o(20348);
      return localc;
    }
  }
  
  public static boolean aCh()
  {
    AppMethodBeat.i(20351);
    com.tencent.mm.kernel.g.ajP();
    boolean bool = com.tencent.mm.kernel.a.aiY();
    AppMethodBeat.o(20351);
    return bool;
  }
  
  public static f aCi()
  {
    AppMethodBeat.i(20357);
    f localf = aCd().hJa;
    AppMethodBeat.o(20357);
    return localf;
  }
  
  public static String aiH()
  {
    AppMethodBeat.i(20356);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajP();
    String str = com.tencent.mm.kernel.a.aiH();
    AppMethodBeat.o(20356);
    return str;
  }
  
  public static boolean aiT()
  {
    AppMethodBeat.i(20353);
    boolean bool = com.tencent.mm.kernel.a.aiT();
    AppMethodBeat.o(20353);
    return bool;
  }
  
  public static boolean ajM()
  {
    AppMethodBeat.i(20352);
    if (!ak.cpe())
    {
      AppMethodBeat.o(20352);
      return false;
    }
    boolean bool = com.tencent.mm.kernel.g.ajM();
    AppMethodBeat.o(20352);
    return bool;
  }
  
  @Deprecated
  public static com.tencent.mm.sdk.platformtools.ar ajU()
  {
    AppMethodBeat.i(20344);
    com.tencent.mm.sdk.platformtools.ar localar = com.tencent.mm.kernel.g.ajU();
    AppMethodBeat.o(20344);
    return localar;
  }
  
  public static String ajd()
  {
    AppMethodBeat.i(20346);
    String str = com.tencent.mm.kernel.a.ajd();
    AppMethodBeat.o(20346);
    return str;
  }
  
  public static com.tencent.mm.ak.q ajj()
  {
    AppMethodBeat.i(20349);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.ak.q localq = com.tencent.mm.kernel.g.ajQ().gDv;
    AppMethodBeat.o(20349);
    return localq;
  }
  
  public static void b(n paramn)
  {
    AppMethodBeat.i(20332);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().b(paramn);
    AppMethodBeat.o(20332);
  }
  
  public static at getNotification()
  {
    AppMethodBeat.i(20339);
    at localat = aCd().hIM.getNotification();
    AppMethodBeat.o(20339);
    return localat;
  }
  
  public static cf getSysCmdMsgExtension()
  {
    AppMethodBeat.i(20345);
    cf localcf = ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension();
    AppMethodBeat.o(20345);
    return localcf;
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
  
  public static void xA(String paramString)
  {
    AppMethodBeat.i(20334);
    com.tencent.mm.kernel.a.xA(paramString);
    AppMethodBeat.o(20334);
  }
  
  class a
    implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.api.e, com.tencent.mm.kernel.c.a
  {
    a() {}
    
    public HashMap<Integer, h.b> collectDatabaseFactory()
    {
      AppMethodBeat.i(20330);
      ae.i("MicroMsg.MMCore", "collectDatabaseFactory ");
      HashMap localHashMap = new HashMap();
      localHashMap.putAll(c.baseDBFactories);
      AppMethodBeat.o(20330);
      return localHashMap;
    }
    
    public void onAccountInitialized(e.c paramc)
    {
      AppMethodBeat.i(20327);
      if (paramc.gEo) {
        com.tencent.mm.y.c.ahI().w(262145, false);
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(598L, 13L, 1L, false);
      long l = System.currentTimeMillis();
      ae.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized start tid[%d]", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
      Object localObject1 = bc.a(bc.this);
      com.tencent.mm.storagebase.h localh = com.tencent.mm.kernel.g.ajR().gDX;
      com.tencent.mm.kernel.g.ajR();
      com.tencent.mm.plugin.messenger.foundation.a.a.i locali = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ();
      locali.a(new bf(locali));
      Object localObject2 = new com.tencent.mm.storage.h(locali);
      ((c)localObject1).hHf = ((com.tencent.mm.storage.h)localObject2);
      locali.a((com.tencent.mm.storage.e)localObject2);
      localObject2 = new com.tencent.mm.storage.i(locali);
      ((c)localObject1).hHg = ((com.tencent.mm.storage.i)localObject2);
      locali.a((com.tencent.mm.storage.e)localObject2);
      ((c)localObject1).hHd = new bx(localh, ((l)com.tencent.mm.kernel.g.ab(l.class)).azL());
      ((c)localObject1).hHe = new bw(localh, ((l)com.tencent.mm.kernel.g.ab(l.class)).azF());
      ((c)localObject1).hHh = new com.tencent.mm.model.b.c();
      ((c)localObject1).hHi = new com.tencent.mm.model.b.d();
      ((c)localObject1).hHm = new com.tencent.mm.model.b.b();
      ((c)localObject1).hHj = new k(localh);
      ((c)localObject1).hHk = new com.tencent.mm.storage.o(localh);
      ((c)localObject1).hHl = new m(localh);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(598L, 14L, 1L, false);
      ae.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done initDB take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      localObject1 = bc.this.hIR;
      bc.a(bc.this);
      ((c.a)localObject1).ey(paramc.gEo);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(598L, 15L, 1L, false);
      ae.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done onAccountPostReset take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      com.tencent.mm.compatible.util.e.abo();
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(598L, 16L, 1L, false);
      ae.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done all take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(20327);
    }
    
    public void onAccountRelease() {}
    
    public void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
    
    public void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
    {
      AppMethodBeat.i(20329);
      bc.a(bc.this);
      AppMethodBeat.o(20329);
    }
    
    public void parallelsDependency()
    {
      AppMethodBeat.i(20328);
      com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bA(com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class));
      AppMethodBeat.o(20328);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bc
 * JD-Core Version:    0.7.0.1
 */