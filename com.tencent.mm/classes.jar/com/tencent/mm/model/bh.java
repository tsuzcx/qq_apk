package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.an.t.a;
import com.tencent.mm.an.x;
import com.tencent.mm.ao.q;
import com.tencent.mm.f.a.af;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.bw.a;
import com.tencent.mm.storage.bw.b;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.k;
import com.tencent.mm.storage.m;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.u;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class bh
{
  private static final ch ltA;
  private static bh lty;
  private final int ltB;
  final c.a ltC;
  private cl ltD;
  private cd ltE;
  private e ltF;
  private co ltG;
  private ae ltH;
  private bv.a ltI;
  private bw.a ltJ;
  private bw.a ltK;
  private f ltL;
  private final c ltn;
  private final ax ltx;
  private com.tencent.mm.compatible.b.g ltz;
  
  static
  {
    AppMethodBeat.i(20360);
    lty = null;
    ltA = new ch();
    AppMethodBeat.o(20360);
  }
  
  private bh(ax paramax, t.a parama)
  {
    AppMethodBeat.i(20341);
    this.ltz = null;
    this.ltB = 1;
    this.ltD = new cl();
    this.ltE = new cd();
    this.ltF = new e();
    this.ltG = new co();
    this.ltH = new ae();
    this.ltI = new bv.a()
    {
      public final as RG(String paramAnonymousString)
      {
        return null;
      }
      
      public final void a(bv paramAnonymousbv, as paramAnonymousas)
      {
        AppMethodBeat.i(20325);
        String str = paramAnonymousas.field_username;
        if (as.PY(paramAnonymousas.field_username)) {
          paramAnonymousas.setUsername(as.bvW(paramAnonymousas.field_username));
        }
        if (Util.isNullOrNil(paramAnonymousas.aph())) {
          paramAnonymousas.It(com.tencent.mm.platformtools.f.ZK(paramAnonymousas.field_nickname));
        }
        if (Util.isNullOrNil(paramAnonymousas.api())) {
          paramAnonymousas.Iu(com.tencent.mm.platformtools.f.ZJ(paramAnonymousas.field_nickname));
        }
        if (Util.isNullOrNil(paramAnonymousas.field_conRemarkPYShort)) {
          paramAnonymousas.Ix(com.tencent.mm.platformtools.f.ZK(paramAnonymousas.field_conRemark));
        }
        if (Util.isNullOrNil(paramAnonymousas.field_conRemarkPYFull)) {
          paramAnonymousas.Iw(com.tencent.mm.platformtools.f.ZJ(paramAnonymousas.field_conRemark));
        }
        if (ab.p(paramAnonymousas))
        {
          paramAnonymousas.pq(43);
          paramAnonymousas.It(com.tencent.mm.platformtools.f.ZK(paramAnonymousas.ayr()));
          paramAnonymousas.Iu(com.tencent.mm.platformtools.f.ZJ(paramAnonymousas.ayr()));
          paramAnonymousas.Iw(com.tencent.mm.platformtools.f.ZJ(paramAnonymousas.ays()));
          paramAnonymousas.Ix(paramAnonymousas.ays());
          AppMethodBeat.o(20325);
          return;
        }
        if (ab.QX(str))
        {
          paramAnonymousas.axk();
          paramAnonymousas.pv(4);
          paramAnonymousas.pq(33);
          if (paramAnonymousas != null) {
            break label336;
          }
        }
        label336:
        for (paramAnonymousbv = new as();; paramAnonymousbv = paramAnonymousas)
        {
          paramAnonymousbv.setUsername(str);
          paramAnonymousbv.axk();
          ak.T(paramAnonymousbv);
          paramAnonymousbv.axx();
          if (paramAnonymousas.ayh()) {
            paramAnonymousas.pq(paramAnonymousas.axh());
          }
          if (ab.QL(str))
          {
            Log.i("MicroMsg.MMCore", "update official account helper showhead %d", new Object[] { Integer.valueOf(31) });
            paramAnonymousas.pq(31);
          }
          if (paramAnonymousas.ayc())
          {
            bh.beI();
            c.bbR().c(new String[] { str }, "@blacklist");
          }
          Log.d("MicroMsg.MMCore", "onPreInsertContact2: %s, %s", new Object[] { paramAnonymousas.field_username, paramAnonymousas.aph() });
          AppMethodBeat.o(20325);
          return;
        }
      }
      
      public final int b(as paramAnonymousas, boolean paramAnonymousBoolean)
      {
        return 0;
      }
    };
    this.ltJ = new bw.a()
    {
      public final void a(az paramAnonymousaz, bw paramAnonymousbw)
      {
        AppMethodBeat.i(20326);
        if (paramAnonymousaz == null)
        {
          AppMethodBeat.o(20326);
          return;
        }
        if ((!as.bvH(paramAnonymousaz.field_username)) && (!as.bvJ(paramAnonymousaz.field_username)) && (!as.PY(paramAnonymousaz.field_username)) && (!ab.Qm(paramAnonymousaz.field_username)) && (!as.bvK(paramAnonymousaz.field_username)))
        {
          AppMethodBeat.o(20326);
          return;
        }
        if (as.PY(paramAnonymousaz.field_username))
        {
          paramAnonymousaz = paramAnonymousbw.bwx("floatbottle");
          if (paramAnonymousaz != null) {
            break label480;
          }
          paramAnonymousaz = new az("floatbottle");
        }
        label480:
        for (int i = 1;; i = 0)
        {
          paramAnonymousaz.pI(1);
          paramAnonymousaz.pH(s.bcR());
          bh.beI();
          ca localca = c.bbO().aOK(" and not ( type = 10000 and isSend != 2 ) ");
          if ((localca != null) && (localca.field_msgId > 0L))
          {
            paramAnonymousaz.bq(localca);
            paramAnonymousaz.setContent(as.bvW(localca.field_talker) + ":" + localca.field_content);
            paramAnonymousaz.IZ(Integer.toString(localca.getType()));
            bw.b localb = paramAnonymousbw.abK();
            if (localb != null)
            {
              PString localPString1 = new PString();
              PString localPString2 = new PString();
              PInt localPInt = new PInt();
              localca.Jm("floatbottle");
              localca.setContent(paramAnonymousaz.field_content);
              localb.a(localca, localPString1, localPString2, localPInt, false);
              paramAnonymousaz.Ja(localPString1.value);
              paramAnonymousaz.Jb(localPString2.value);
              paramAnonymousaz.pK(localPInt.value);
            }
          }
          while (i != 0)
          {
            paramAnonymousbw.e(paramAnonymousaz);
            AppMethodBeat.o(20326);
            return;
            paramAnonymousaz.hyE();
          }
          paramAnonymousbw.a(paramAnonymousaz, paramAnonymousaz.field_username);
          AppMethodBeat.o(20326);
          return;
          if ((as.bvH(paramAnonymousaz.field_username)) || (as.bvJ(paramAnonymousaz.field_username)))
          {
            AppMethodBeat.o(20326);
            return;
          }
          ((q)com.tencent.mm.kernel.h.ae(q.class)).bbQ();
          u.b(paramAnonymousaz, paramAnonymousbw);
          if ("@blacklist".equals(paramAnonymousaz.field_parentRef))
          {
            bh.beI();
            paramAnonymousbw = c.bbL().RG(paramAnonymousaz.field_username);
            if ((paramAnonymousbw != null) && (!Util.isNullOrNil(paramAnonymousbw.field_username)) && (!paramAnonymousbw.ayc()))
            {
              bh.beI();
              c.bbR().c(new String[] { paramAnonymousaz.field_username }, "");
            }
          }
          AppMethodBeat.o(20326);
          return;
        }
      }
    };
    this.ltK = new bw.a()
    {
      public final void a(az paramAnonymousaz, bw paramAnonymousbw)
      {
        if (paramAnonymousaz == null) {}
      }
    };
    this.ltL = new f();
    this.ltx = paramax;
    this.ltC = new c.a()
    {
      public final void fY(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(20322);
        Log.i("MicroMsg.MMCore", "summeranrt2 onAccountPostReset tid:%d stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Util.getStack() });
        bh.b(bh.this);
        long l1 = System.currentTimeMillis();
        bh.beI();
        long l2 = c.getDataDB().beginTransaction(Thread.currentThread().getId());
        bh.a(bh.this);
        as localas1;
        as localas2;
        if (paramAnonymousBoolean)
        {
          Log.i("MicroMsg.MMCore", "[doAccountPostReset] updated is true");
          c.bbL().bwp("readerapp");
          c.aHp().i(256, Boolean.TRUE);
          Log.i("MicroMsg.MMCore", "[doAccountPostReset] begin to updated HardCodeUpdate");
          localObject = ab.bec();
          Log.i("MicroMsg.HardCodeUpdateTask", "[updateHelperIndexFor50] size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localas1 = (as)((Iterator)localObject).next();
            if ((localas1 != null) && ((int)localas1.jxt != 0) && (localas1.field_showHead == 32))
            {
              localas1.pq(localas1.axh());
              Log.d("MicroMsg.HardCodeUpdateTask", "contact to updatefavour " + localas1.field_username);
              bh.beI();
              c.bbL().c(localas1.field_username, localas1);
            }
          }
          localObject = ab.lsO;
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            localas1 = localObject[i];
            localas2 = c.bbL().RG(localas1);
            if ((localas2 != null) && (((int)localas2.jxt != 0) || (com.tencent.mm.contact.d.rk(localas2.field_type))))
            {
              localas2.axx();
              c.bbL().c(localas1, localas2);
            }
            i += 1;
          }
          al.ben();
          bs.RT("ver" + com.tencent.mm.protocal.d.RAD);
        }
        bs.b(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vZD, 1), ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vZE, 0.75F), ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vZF, 0.4F), ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vZF, 0.4F));
        Object localObject = com.tencent.mm.contact.b.jxn;
        boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vZX, true);
        Log.i("MicroMsg.ContactUpgradeHelper", "setDefalutOptOpen:%b", new Object[] { Boolean.valueOf(bool) });
        ((com.tencent.mm.contact.b)localObject).jxq = bool;
        new ak(bh.a(bh.this));
        if (paramAnonymousBoolean)
        {
          ak.S(c.bbL().RG("filehelper"));
          localObject = z.bcZ();
          if (!Util.isNullOrNil((String)localObject))
          {
            localas1 = c.bbL().RG((String)localObject);
            if ((int)localas1.jxt != 0) {
              break label1565;
            }
            localas1.setUsername((String)localObject);
            localas1.axk();
            bh.beI();
            c.bbL().av(localas1);
          }
          ak.a(paramAnonymousBoolean, "qqmail", false);
          ak.a(paramAnonymousBoolean, "floatbottle", false);
          ak.a(paramAnonymousBoolean, "shakeapp", false);
          ak.a(paramAnonymousBoolean, "lbsapp", false);
          ak.a(paramAnonymousBoolean, "medianote", false);
          ak.a(paramAnonymousBoolean, "newsapp", true);
          c.bbR().bwv("blogapp");
          c.bbO().aOO("blogapp");
          c.bbL().bwp("blogapp");
          ak.a(paramAnonymousBoolean, "facebookapp", true);
          ak.a(paramAnonymousBoolean, "qqfriend", false);
          ak.a(paramAnonymousBoolean, "masssendapp", true);
          ak.a(paramAnonymousBoolean, "feedsapp", true);
          c.bbR().bwv("tmessage");
          c.bbL().bwp("tmessage");
          localas2 = c.bbL().RG("voip");
          localas1 = c.bbL().RG("voipapp");
          localObject = localas1;
          if (localas1 == null) {
            localObject = new as();
          }
          if ((localas2 != null) && ((int)localas2.jxt != 0)) {
            c.bbL().bwp("voip");
          }
          if ((int)((com.tencent.mm.contact.d)localObject).jxt != 0) {
            break label1601;
          }
          ((as)localObject).setUsername("voipapp");
          ((as)localObject).axk();
          ak.T((as)localObject);
          ((as)localObject).pv(4);
          ((as)localObject).axx();
          c.bbL().aw((as)localObject);
          label854:
          localas1 = c.bbL().RG("officialaccounts");
          localObject = localas1;
          if (localas1 == null) {
            localObject = new as();
          }
          Log.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.contact.d)localObject).jxt) });
          if ((int)((com.tencent.mm.contact.d)localObject).jxt != 0) {
            break label1627;
          }
          ((as)localObject).setUsername("officialaccounts");
          ((as)localObject).axl();
          ak.T((as)localObject);
          ((as)localObject).pv(3);
          c.bbL().aw((as)localObject);
          label961:
          localas2 = c.bbL().RG("voipaudio");
          localas1 = c.bbL().RG("voicevoipapp");
          localObject = localas1;
          if (localas1 == null) {
            localObject = new as();
          }
          if ((localas2 != null) && ((int)localas2.jxt != 0)) {
            c.bbL().bwp("voipaudio");
          }
          if ((int)((com.tencent.mm.contact.d)localObject).jxt != 0) {
            break label1662;
          }
          ((as)localObject).setUsername("voicevoipapp");
          ((as)localObject).axk();
          ak.T((as)localObject);
          ((as)localObject).pv(4);
          ((as)localObject).axx();
          c.bbL().aw((as)localObject);
          label1080:
          ak.a(paramAnonymousBoolean, "voiceinputapp", false);
          ak.a(paramAnonymousBoolean, "linkedinplugin", false);
          localas1 = c.bbL().RG("notifymessage");
          localObject = localas1;
          if (localas1 == null) {
            localObject = new as();
          }
          Log.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.contact.d)localObject).jxt) });
          if ((int)((com.tencent.mm.contact.d)localObject).jxt != 0) {
            break label1688;
          }
          ((as)localObject).setUsername("notifymessage");
          ((as)localObject).axl();
          ak.T((as)localObject);
          ((as)localObject).pv(3);
          c.bbL().aw((as)localObject);
          label1205:
          localas1 = c.bbL().RG("appbrandcustomerservicemsg");
          localObject = localas1;
          if (localas1 == null) {
            localObject = new as();
          }
          Log.i("MicroMsg.HardCodeHelper", "hardcodeAppBrandServiceMessage:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.contact.d)localObject).jxt) });
          if ((int)((com.tencent.mm.contact.d)localObject).jxt != 0) {
            break label1723;
          }
          ((as)localObject).setUsername("appbrandcustomerservicemsg");
          ((as)localObject).axl();
          ak.T((as)localObject);
          ((as)localObject).rm(0);
          ((as)localObject).pv(3);
          c.bbL().aw((as)localObject);
          label1318:
          localas1 = c.bbL().RG("appbrand_notify_message");
          localObject = localas1;
          if (localas1 == null) {
            localObject = new as();
          }
          Log.i("MicroMsg.HardCodeHelper", "hardcodeAppBrandNotifyMessage:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.contact.d)localObject).jxt) });
          if ((int)((com.tencent.mm.contact.d)localObject).jxt != 0) {
            break label1758;
          }
          ((as)localObject).setUsername("appbrand_notify_message");
          ((as)localObject).axl();
          ak.T((as)localObject);
          ((as)localObject).pv(3);
          c.bbL().aw((as)localObject);
        }
        for (;;)
        {
          ak.a(paramAnonymousBoolean, "downloaderapp", true);
          if (paramAnonymousBoolean)
          {
            bh.beI();
            c.bbR().bwv("Weixin");
            bh.beI();
            c.bbL().bwp("Weixin");
          }
          bh.beI();
          c.getDataDB().endTransaction(l2);
          Log.i("MicroMsg.MMCore", "summeranrt dkwt set forceManual :%b, tid[%d], take[%s]ms, stack[%s]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l1), Util.getStack() });
          bh.a(bh.this);
          c.bbR().a(bh.c(bh.beL()).abK());
          AppMethodBeat.o(20322);
          return;
          label1565:
          if (com.tencent.mm.contact.d.rk(localas1.field_type)) {
            break;
          }
          localas1.axk();
          bh.beI();
          c.bbL().c((String)localObject, localas1);
          break;
          label1601:
          if (!paramAnonymousBoolean) {
            break label854;
          }
          ((as)localObject).axx();
          c.bbL().c("voipapp", (as)localObject);
          break label854;
          label1627:
          if (!paramAnonymousBoolean) {
            break label961;
          }
          Log.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
          ((as)localObject).axl();
          c.bbL().c("officialaccounts", (as)localObject);
          break label961;
          label1662:
          if (!paramAnonymousBoolean) {
            break label1080;
          }
          ((as)localObject).axx();
          c.bbL().c("voicevoipapp", (as)localObject);
          break label1080;
          label1688:
          if (!paramAnonymousBoolean) {
            break label1205;
          }
          Log.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
          ((as)localObject).axl();
          c.bbL().c("notifymessage", (as)localObject);
          break label1205;
          label1723:
          if (!paramAnonymousBoolean) {
            break label1318;
          }
          Log.i("MicroMsg.HardCodeHelper", "do update app brand service message accunt");
          ((as)localObject).axl();
          c.bbL().c("appbrandcustomerservicemsg", (as)localObject);
          break label1318;
          label1758:
          if (paramAnonymousBoolean)
          {
            Log.i("MicroMsg.HardCodeHelper", "do update app brand service message accunt");
            ((as)localObject).axl();
            c.bbL().c("appbrand_notify_message", (as)localObject);
          }
        }
      }
    };
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.b(a.class, new a());
    com.tencent.mm.kernel.h.aHH().kdj.add(parama);
    this.ltn = new c();
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(99L, 142L, 1L, false);
    x.a(new bh.2(this));
    com.tencent.mm.kernel.h.aHH();
    paramax = com.tencent.mm.kernel.h.aHF();
    parama = new com.tencent.mm.kernel.api.d()
    {
      public final void b(com.tencent.mm.network.g paramAnonymousg)
      {
        AppMethodBeat.i(20324);
        com.tencent.mm.modelstat.p.d(paramAnonymousg);
        com.tencent.mm.modelstat.p.e(paramAnonymousg);
        AppMethodBeat.o(20324);
      }
    };
    paramax.kcc.add(parama);
    AppMethodBeat.o(20341);
  }
  
  public static void MM(String paramString)
  {
    AppMethodBeat.i(20334);
    com.tencent.mm.kernel.b.MM(paramString);
    AppMethodBeat.o(20334);
  }
  
  public static void a(aw paramaw)
  {
    AppMethodBeat.i(20333);
    com.tencent.mm.kernel.c.a(paramaw);
    AppMethodBeat.o(20333);
  }
  
  public static void a(ax paramax, t.a parama)
  {
    AppMethodBeat.i(20338);
    lty = new bh(paramax, parama);
    com.tencent.mm.modelstat.n.de(MMApplicationContext.getContext());
    AppMethodBeat.o(20338);
  }
  
  public static void a(com.tencent.mm.network.p paramp)
  {
    AppMethodBeat.i(20331);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().a(paramp);
    AppMethodBeat.o(20331);
  }
  
  public static boolean aGE()
  {
    AppMethodBeat.i(20353);
    boolean bool = com.tencent.mm.kernel.b.aGE();
    AppMethodBeat.o(20353);
    return bool;
  }
  
  public static void aGF()
  {
    AppMethodBeat.i(20354);
    com.tencent.mm.kernel.b.aGF();
    AppMethodBeat.o(20354);
  }
  
  public static void aGG()
  {
    AppMethodBeat.i(20355);
    com.tencent.mm.kernel.b.aGG();
    AppMethodBeat.o(20355);
  }
  
  public static String aGR()
  {
    AppMethodBeat.i(20346);
    String str = com.tencent.mm.kernel.b.aGR();
    AppMethodBeat.o(20346);
    return str;
  }
  
  public static t aGY()
  {
    AppMethodBeat.i(20349);
    com.tencent.mm.kernel.h.aHH();
    t localt = com.tencent.mm.kernel.h.aHF().kcd;
    AppMethodBeat.o(20349);
    return localt;
  }
  
  public static String aGs()
  {
    AppMethodBeat.i(20356);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHE();
    String str = com.tencent.mm.kernel.b.aGs();
    AppMethodBeat.o(20356);
    return str;
  }
  
  public static boolean aHB()
  {
    AppMethodBeat.i(20352);
    if (!MMApplicationContext.isMMProcess())
    {
      AppMethodBeat.o(20352);
      return false;
    }
    boolean bool = com.tencent.mm.kernel.h.aHB();
    AppMethodBeat.o(20352);
    return bool;
  }
  
  @Deprecated
  public static MMHandlerThread aHJ()
  {
    AppMethodBeat.i(20344);
    MMHandlerThread localMMHandlerThread = com.tencent.mm.kernel.h.aHJ();
    AppMethodBeat.o(20344);
    return localMMHandlerThread;
  }
  
  public static ao abL()
  {
    AppMethodBeat.i(20340);
    ao localao = beF().ltx.abL();
    AppMethodBeat.o(20340);
    return localao;
  }
  
  public static void b(com.tencent.mm.network.p paramp)
  {
    AppMethodBeat.i(20332);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().b(paramp);
    AppMethodBeat.o(20332);
  }
  
  public static boolean beB()
  {
    return lty == null;
  }
  
  public static ch beC()
  {
    AppMethodBeat.i(20335);
    beF();
    ch localch = ltA;
    AppMethodBeat.o(20335);
    return localch;
  }
  
  public static boolean beD()
  {
    AppMethodBeat.i(20336);
    boolean bool = com.tencent.mm.kernel.b.aGD();
    AppMethodBeat.o(20336);
    return bool;
  }
  
  public static void beE()
  {
    AppMethodBeat.i(20337);
    com.tencent.mm.kernel.b.eQ(false);
    AppMethodBeat.o(20337);
  }
  
  private static bh beF()
  {
    AppMethodBeat.i(20342);
    Assert.assertNotNull("MMCore not initialized by MMApplication", lty);
    bh localbh = lty;
    AppMethodBeat.o(20342);
    return localbh;
  }
  
  public static an beG()
  {
    AppMethodBeat.i(20343);
    com.tencent.mm.kernel.h.aHH();
    an localan = com.tencent.mm.kernel.h.aHG().kcw;
    AppMethodBeat.o(20343);
    return localan;
  }
  
  public static void beH()
  {
    AppMethodBeat.i(20347);
    af localaf = new af();
    EventCenter.instance.publish(localaf);
    AppMethodBeat.o(20347);
  }
  
  public static c beI()
  {
    AppMethodBeat.i(20348);
    c localc = beF().ltn;
    if (localc != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("MMCore has not been initialize ?", bool);
      AppMethodBeat.o(20348);
      return localc;
    }
  }
  
  public static boolean beJ()
  {
    AppMethodBeat.i(20351);
    com.tencent.mm.kernel.h.aHE();
    boolean bool = com.tencent.mm.kernel.b.aGL();
    AppMethodBeat.o(20351);
    return bool;
  }
  
  public static f beK()
  {
    AppMethodBeat.i(20357);
    f localf = beF().ltL;
    AppMethodBeat.o(20357);
    return localf;
  }
  
  public static ay getNotification()
  {
    AppMethodBeat.i(20339);
    ay localay = beF().ltx.getNotification();
    AppMethodBeat.o(20339);
    return localay;
  }
  
  public static ck getSysCmdMsgExtension()
  {
    AppMethodBeat.i(20345);
    ck localck = ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension();
    AppMethodBeat.o(20345);
    return localck;
  }
  
  class a
    implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.api.e, com.tencent.mm.kernel.c.a
  {
    a() {}
    
    public HashMap<Integer, h.b> collectDatabaseFactory()
    {
      AppMethodBeat.i(20330);
      Log.i("MicroMsg.MMCore", "collectDatabaseFactory ");
      HashMap localHashMap = new HashMap();
      localHashMap.putAll(c.baseDBFactories);
      AppMethodBeat.o(20330);
      return localHashMap;
    }
    
    public void onAccountInitialized(f.c paramc)
    {
      AppMethodBeat.i(20327);
      if (paramc.kcX) {
        com.tencent.mm.aa.c.aFn().C(262145, false);
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(598L, 13L, 1L, false);
      long l = System.currentTimeMillis();
      Log.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized start tid[%d]", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
      Object localObject1 = bh.a(bh.this);
      com.tencent.mm.storagebase.h localh = com.tencent.mm.kernel.h.aHG().kcF;
      com.tencent.mm.kernel.h.aHG();
      com.tencent.mm.plugin.messenger.foundation.a.a.i locali = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe();
      locali.a(new bk(locali));
      Object localObject2 = new com.tencent.mm.storage.h(locali);
      ((c)localObject1).lqU = ((com.tencent.mm.storage.h)localObject2);
      locali.a((com.tencent.mm.storage.e)localObject2);
      localObject2 = new com.tencent.mm.storage.i(locali);
      ((c)localObject1).lqV = ((com.tencent.mm.storage.i)localObject2);
      locali.a((com.tencent.mm.storage.e)localObject2);
      ((c)localObject1).lqS = new cc(localh, ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbR());
      ((c)localObject1).lqT = new cb(localh, ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL());
      ((c)localObject1).lqW = new com.tencent.mm.model.b.c();
      ((c)localObject1).lqX = new com.tencent.mm.model.b.d();
      ((c)localObject1).lrb = new com.tencent.mm.model.b.b();
      ((c)localObject1).lqY = new k(localh);
      ((c)localObject1).lqZ = new o(localh);
      ((c)localObject1).lra = new m(localh);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(598L, 14L, 1L, false);
      Log.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done initDB take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      localObject1 = bh.this.ltC;
      bh.a(bh.this);
      ((c.a)localObject1).fY(paramc.kcX);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(598L, 15L, 1L, false);
      Log.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done onAccountPostReset take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      com.tencent.mm.compatible.util.e.avA();
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(598L, 16L, 1L, false);
      Log.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done all take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(20327);
    }
    
    public void onAccountRelease() {}
    
    public void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
    
    public void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
    {
      AppMethodBeat.i(20329);
      bh.a(bh.this);
      AppMethodBeat.o(20329);
    }
    
    public void parallelsDependency()
    {
      AppMethodBeat.i(20328);
      com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bI(com.tencent.mm.kernel.h.ag(v.class));
      AppMethodBeat.o(20328);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bh
 * JD-Core Version:    0.7.0.1
 */