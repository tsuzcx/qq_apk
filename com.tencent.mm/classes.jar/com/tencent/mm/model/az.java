package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.am.p;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.account.friend.a.s.a;
import com.tencent.mm.plugin.account.friend.a.t.a;
import com.tencent.mm.plugin.account.friend.a.u.a;
import com.tencent.mm.plugin.account.friend.a.v.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.k.a;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.n.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.acr;
import com.tencent.mm.protocal.protobuf.adh;
import com.tencent.mm.protocal.protobuf.adi;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bci;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.protocal.protobuf.bkc;
import com.tencent.mm.protocal.protobuf.dkb;
import com.tencent.mm.protocal.protobuf.la;
import com.tencent.mm.protocal.protobuf.wi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bg.a;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bh.a;
import com.tencent.mm.storage.bh.b;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.i;
import com.tencent.mm.storage.m;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class az
{
  private static az gNd;
  private static final bz gNf;
  private final c gMT;
  private final ap gNc;
  private com.tencent.mm.compatible.b.g gNe;
  private final int gNg;
  final c.a gNh;
  private cd gNi;
  private bv gNj;
  private e gNk;
  private cg gNl;
  private z gNm;
  private bg.a gNn;
  private bh.a gNo;
  private bh.a gNp;
  private f gNq;
  
  static
  {
    AppMethodBeat.i(20360);
    gNd = null;
    gNf = new bz();
    AppMethodBeat.o(20360);
  }
  
  private az(ap paramap, com.tencent.mm.al.q.a parama)
  {
    AppMethodBeat.i(20341);
    this.gNe = null;
    this.gNg = 1;
    this.gNi = new cd();
    this.gNj = new bv();
    this.gNk = new e();
    this.gNl = new cg();
    this.gNm = new z();
    this.gNn = new bg.a()
    {
      public final void a(bg paramAnonymousbg, com.tencent.mm.storage.af paramAnonymousaf)
      {
        AppMethodBeat.i(20325);
        String str = paramAnonymousaf.field_username;
        if (com.tencent.mm.storage.af.st(paramAnonymousaf.field_username)) {
          paramAnonymousaf.setUsername(com.tencent.mm.storage.af.aHM(paramAnonymousaf.field_username));
        }
        if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramAnonymousaf.Sv())) {
          paramAnonymousaf.ne(com.tencent.mm.platformtools.f.Bs(paramAnonymousaf.field_nickname));
        }
        if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramAnonymousaf.Sw())) {
          paramAnonymousaf.nf(com.tencent.mm.platformtools.f.Br(paramAnonymousaf.field_nickname));
        }
        if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramAnonymousaf.field_conRemarkPYShort)) {
          paramAnonymousaf.ni(com.tencent.mm.platformtools.f.Bs(paramAnonymousaf.field_conRemark));
        }
        if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramAnonymousaf.field_conRemarkPYFull)) {
          paramAnonymousaf.nh(com.tencent.mm.platformtools.f.Br(paramAnonymousaf.field_conRemark));
        }
        if (w.i(paramAnonymousaf))
        {
          paramAnonymousaf.jD(43);
          paramAnonymousaf.ne(com.tencent.mm.platformtools.f.Bs(paramAnonymousaf.ZW()));
          paramAnonymousaf.nf(com.tencent.mm.platformtools.f.Br(paramAnonymousaf.ZW()));
          paramAnonymousaf.nh(com.tencent.mm.platformtools.f.Br(paramAnonymousaf.ZX()));
          paramAnonymousaf.ni(paramAnonymousaf.ZX());
          AppMethodBeat.o(20325);
          return;
        }
        if (w.to(str))
        {
          paramAnonymousaf.Zk();
          paramAnonymousaf.jI(4);
          paramAnonymousaf.jD(33);
          if (paramAnonymousaf != null) {
            break label336;
          }
        }
        label336:
        for (paramAnonymousbg = new com.tencent.mm.storage.af();; paramAnonymousbg = paramAnonymousaf)
        {
          paramAnonymousbg.setUsername(str);
          paramAnonymousbg.Zk();
          ae.E(paramAnonymousbg);
          paramAnonymousbg.Zt();
          if (paramAnonymousaf.ZO()) {
            paramAnonymousaf.jD(paramAnonymousaf.Zh());
          }
          if (w.td(str))
          {
            ad.i("MicroMsg.MMCore", "update official account helper showhead %d", new Object[] { Integer.valueOf(31) });
            paramAnonymousaf.jD(31);
          }
          if (paramAnonymousaf.ZM())
          {
            az.arV();
            c.apR().c(new String[] { str }, "@blacklist");
          }
          ad.d("MicroMsg.MMCore", "onPreInsertContact2: %s, %s", new Object[] { paramAnonymousaf.field_username, paramAnonymousaf.Sv() });
          AppMethodBeat.o(20325);
          return;
        }
      }
    };
    this.gNo = new bh.a()
    {
      public final void a(am paramAnonymousam, bh paramAnonymousbh)
      {
        AppMethodBeat.i(20326);
        if (paramAnonymousam == null)
        {
          AppMethodBeat.o(20326);
          return;
        }
        if ((!com.tencent.mm.storage.af.aHE(paramAnonymousam.field_username)) && (!com.tencent.mm.storage.af.aHG(paramAnonymousam.field_username)) && (!com.tencent.mm.storage.af.st(paramAnonymousam.field_username)) && (!w.sE(paramAnonymousam.field_username)) && (!com.tencent.mm.storage.af.aHH(paramAnonymousam.field_username)))
        {
          AppMethodBeat.o(20326);
          return;
        }
        if (com.tencent.mm.storage.af.st(paramAnonymousam.field_username))
        {
          paramAnonymousam = paramAnonymousbh.aIn("floatbottle");
          if (paramAnonymousam != null) {
            break label472;
          }
          paramAnonymousam = new am("floatbottle");
        }
        label472:
        for (int i = 1;; i = 0)
        {
          paramAnonymousam.jU(1);
          paramAnonymousam.jT(o.aqz());
          az.arV();
          bl localbl = c.apO().ags(" and not ( type = 10000 and isSend != 2 ) ");
          if ((localbl != null) && (localbl.field_msgId > 0L))
          {
            paramAnonymousam.aG(localbl);
            paramAnonymousam.setContent(com.tencent.mm.storage.af.aHM(localbl.field_talker) + ":" + localbl.field_content);
            paramAnonymousam.nK(Integer.toString(localbl.getType()));
            bh.b localb = paramAnonymousbh.Lu();
            if (localb != null)
            {
              PString localPString1 = new PString();
              PString localPString2 = new PString();
              PInt localPInt = new PInt();
              localbl.nY("floatbottle");
              localbl.setContent(paramAnonymousam.field_content);
              localb.a(localbl, localPString1, localPString2, localPInt, false);
              paramAnonymousam.nL(localPString1.value);
              paramAnonymousam.nM(localPString2.value);
              paramAnonymousam.jW(localPInt.value);
            }
          }
          while (i != 0)
          {
            paramAnonymousbh.e(paramAnonymousam);
            AppMethodBeat.o(20326);
            return;
            paramAnonymousam.eLf();
          }
          paramAnonymousbh.a(paramAnonymousam, paramAnonymousam.field_username);
          AppMethodBeat.o(20326);
          return;
          if ((com.tencent.mm.storage.af.aHE(paramAnonymousam.field_username)) || (com.tencent.mm.storage.af.aHG(paramAnonymousam.field_username)))
          {
            AppMethodBeat.o(20326);
            return;
          }
          com.tencent.mm.kernel.g.ab(p.class);
          com.tencent.mm.storage.q.b(paramAnonymousam, paramAnonymousbh);
          if ("@blacklist".equals(paramAnonymousam.field_parentRef))
          {
            az.arV();
            paramAnonymousbh = c.apM().aHY(paramAnonymousam.field_username);
            if ((paramAnonymousbh != null) && (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramAnonymousbh.field_username)) && (!paramAnonymousbh.ZM()))
            {
              az.arV();
              c.apR().c(new String[] { paramAnonymousam.field_username }, "");
            }
          }
          AppMethodBeat.o(20326);
          return;
        }
      }
    };
    this.gNp = new bh.a()
    {
      public final void a(am paramAnonymousam, bh paramAnonymousbh)
      {
        if (paramAnonymousam == null) {}
      }
    };
    this.gNq = new f();
    this.gNc = paramap;
    this.gNh = new c.a()
    {
      public final void dZ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(20322);
        ad.i("MicroMsg.MMCore", "summeranrt2 onAccountPostReset tid:%d stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), com.tencent.mm.sdk.platformtools.bt.eGN() });
        az.b(az.this);
        long l1 = System.currentTimeMillis();
        az.arV();
        long l2 = c.afg().rb(Thread.currentThread().getId());
        az.a(az.this);
        Object localObject;
        com.tencent.mm.storage.af localaf1;
        com.tencent.mm.storage.af localaf2;
        if (paramAnonymousBoolean)
        {
          ad.i("MicroMsg.MMCore", "[doAccountPostReset] updated is true");
          c.apM().aIf("readerapp");
          c.afk().set(256, Boolean.TRUE);
          ad.i("MicroMsg.MMCore", "[doAccountPostReset] begin to updated HardCodeUpdate");
          localObject = w.arw();
          ad.i("MicroMsg.HardCodeUpdateTask", "[updateHelperIndexFor50] size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localaf1 = (com.tencent.mm.storage.af)((Iterator)localObject).next();
            if ((localaf1 != null) && ((int)localaf1.fId != 0) && (localaf1.field_showHead == 32))
            {
              localaf1.jD(localaf1.Zh());
              ad.d("MicroMsg.HardCodeUpdateTask", "contact to updatefavour " + localaf1.field_username);
              az.arV();
              c.apM().c(localaf1.field_username, localaf1);
            }
          }
          localObject = w.gMw;
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            localaf1 = localObject[i];
            localaf2 = c.apM().aHY(localaf1);
            if ((localaf2 != null) && (((int)localaf2.fId != 0) || (com.tencent.mm.n.b.ls(localaf2.field_type))))
            {
              localaf2.Zt();
              c.apM().c(localaf1, localaf2);
            }
            i += 1;
          }
          af.arB();
          bk.un("ver" + com.tencent.mm.protocal.d.CpK);
        }
        new ae(az.a(az.this));
        if (paramAnonymousBoolean)
        {
          ae.D(c.apM().aHY("filehelper"));
          localObject = u.aqG();
          if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject))
          {
            localaf1 = c.apM().aHY((String)localObject);
            if ((int)localaf1.fId != 0) {
              break label1435;
            }
            localaf1.setUsername((String)localObject);
            localaf1.Zk();
            az.arV();
            c.apM().af(localaf1);
          }
          ae.a(paramAnonymousBoolean, "qqmail", false);
          ae.a(paramAnonymousBoolean, "floatbottle", false);
          ae.a(paramAnonymousBoolean, "shakeapp", false);
          ae.a(paramAnonymousBoolean, "lbsapp", false);
          ae.a(paramAnonymousBoolean, "medianote", false);
          ae.a(paramAnonymousBoolean, "newsapp", true);
          c.apR().aIl("blogapp");
          c.apO().agw("blogapp");
          c.apM().aIf("blogapp");
          ae.a(paramAnonymousBoolean, "facebookapp", true);
          ae.a(paramAnonymousBoolean, "qqfriend", false);
          ae.a(paramAnonymousBoolean, "masssendapp", true);
          ae.a(paramAnonymousBoolean, "feedsapp", true);
          c.apR().aIl("tmessage");
          c.apM().aIf("tmessage");
          localaf2 = c.apM().aHY("voip");
          localaf1 = c.apM().aHY("voipapp");
          localObject = localaf1;
          if (localaf1 == null) {
            localObject = new com.tencent.mm.storage.af();
          }
          if ((localaf2 != null) && ((int)localaf2.fId != 0)) {
            c.apM().aIf("voip");
          }
          if ((int)((com.tencent.mm.n.b)localObject).fId != 0) {
            break label1471;
          }
          ((com.tencent.mm.storage.af)localObject).setUsername("voipapp");
          ((com.tencent.mm.storage.af)localObject).Zk();
          ae.E((com.tencent.mm.storage.af)localObject);
          ((com.tencent.mm.storage.af)localObject).jI(4);
          ((com.tencent.mm.storage.af)localObject).Zt();
          c.apM().ag((com.tencent.mm.storage.af)localObject);
          label724:
          localaf1 = c.apM().aHY("officialaccounts");
          localObject = localaf1;
          if (localaf1 == null) {
            localObject = new com.tencent.mm.storage.af();
          }
          ad.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.n.b)localObject).fId) });
          if ((int)((com.tencent.mm.n.b)localObject).fId != 0) {
            break label1497;
          }
          ((com.tencent.mm.storage.af)localObject).setUsername("officialaccounts");
          ((com.tencent.mm.storage.af)localObject).Zl();
          ae.E((com.tencent.mm.storage.af)localObject);
          ((com.tencent.mm.storage.af)localObject).jI(3);
          c.apM().ag((com.tencent.mm.storage.af)localObject);
          label831:
          localaf2 = c.apM().aHY("voipaudio");
          localaf1 = c.apM().aHY("voicevoipapp");
          localObject = localaf1;
          if (localaf1 == null) {
            localObject = new com.tencent.mm.storage.af();
          }
          if ((localaf2 != null) && ((int)localaf2.fId != 0)) {
            c.apM().aIf("voipaudio");
          }
          if ((int)((com.tencent.mm.n.b)localObject).fId != 0) {
            break label1532;
          }
          ((com.tencent.mm.storage.af)localObject).setUsername("voicevoipapp");
          ((com.tencent.mm.storage.af)localObject).Zk();
          ae.E((com.tencent.mm.storage.af)localObject);
          ((com.tencent.mm.storage.af)localObject).jI(4);
          ((com.tencent.mm.storage.af)localObject).Zt();
          c.apM().ag((com.tencent.mm.storage.af)localObject);
          label950:
          ae.a(paramAnonymousBoolean, "voiceinputapp", false);
          ae.a(paramAnonymousBoolean, "linkedinplugin", false);
          localaf1 = c.apM().aHY("notifymessage");
          localObject = localaf1;
          if (localaf1 == null) {
            localObject = new com.tencent.mm.storage.af();
          }
          ad.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.n.b)localObject).fId) });
          if ((int)((com.tencent.mm.n.b)localObject).fId != 0) {
            break label1558;
          }
          ((com.tencent.mm.storage.af)localObject).setUsername("notifymessage");
          ((com.tencent.mm.storage.af)localObject).Zl();
          ae.E((com.tencent.mm.storage.af)localObject);
          ((com.tencent.mm.storage.af)localObject).jI(3);
          c.apM().ag((com.tencent.mm.storage.af)localObject);
          label1075:
          localaf1 = c.apM().aHY("appbrandcustomerservicemsg");
          localObject = localaf1;
          if (localaf1 == null) {
            localObject = new com.tencent.mm.storage.af();
          }
          ad.i("MicroMsg.HardCodeHelper", "hardcodeAppBrandServiceMessage:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.n.b)localObject).fId) });
          if ((int)((com.tencent.mm.n.b)localObject).fId != 0) {
            break label1593;
          }
          ((com.tencent.mm.storage.af)localObject).setUsername("appbrandcustomerservicemsg");
          ((com.tencent.mm.storage.af)localObject).Zl();
          ae.E((com.tencent.mm.storage.af)localObject);
          ((com.tencent.mm.storage.af)localObject).setType(0);
          ((com.tencent.mm.storage.af)localObject).jI(3);
          c.apM().ag((com.tencent.mm.storage.af)localObject);
          label1188:
          localaf1 = c.apM().aHY("appbrand_notify_message");
          localObject = localaf1;
          if (localaf1 == null) {
            localObject = new com.tencent.mm.storage.af();
          }
          ad.i("MicroMsg.HardCodeHelper", "hardcodeAppBrandNotifyMessage:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.n.b)localObject).fId) });
          if ((int)((com.tencent.mm.n.b)localObject).fId != 0) {
            break label1628;
          }
          ((com.tencent.mm.storage.af)localObject).setUsername("appbrand_notify_message");
          ((com.tencent.mm.storage.af)localObject).Zl();
          ae.E((com.tencent.mm.storage.af)localObject);
          ((com.tencent.mm.storage.af)localObject).jI(3);
          c.apM().ag((com.tencent.mm.storage.af)localObject);
        }
        for (;;)
        {
          ae.a(paramAnonymousBoolean, "downloaderapp", true);
          if (paramAnonymousBoolean)
          {
            az.arV();
            c.apR().aIl("Weixin");
            az.arV();
            c.apM().aIf("Weixin");
          }
          az.arV();
          c.afg().mX(l2);
          ad.i("MicroMsg.MMCore", "summeranrt dkwt set forceManual :%b, tid[%d], take[%s]ms, stack[%s]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l1), com.tencent.mm.sdk.platformtools.bt.eGN() });
          az.a(az.this);
          c.apR().a(az.c(az.arY()).Lu());
          AppMethodBeat.o(20322);
          return;
          label1435:
          if (com.tencent.mm.n.b.ls(localaf1.field_type)) {
            break;
          }
          localaf1.Zk();
          az.arV();
          c.apM().c((String)localObject, localaf1);
          break;
          label1471:
          if (!paramAnonymousBoolean) {
            break label724;
          }
          ((com.tencent.mm.storage.af)localObject).Zt();
          c.apM().c("voipapp", (com.tencent.mm.storage.af)localObject);
          break label724;
          label1497:
          if (!paramAnonymousBoolean) {
            break label831;
          }
          ad.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
          ((com.tencent.mm.storage.af)localObject).Zl();
          c.apM().c("officialaccounts", (com.tencent.mm.storage.af)localObject);
          break label831;
          label1532:
          if (!paramAnonymousBoolean) {
            break label950;
          }
          ((com.tencent.mm.storage.af)localObject).Zt();
          c.apM().c("voicevoipapp", (com.tencent.mm.storage.af)localObject);
          break label950;
          label1558:
          if (!paramAnonymousBoolean) {
            break label1075;
          }
          ad.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
          ((com.tencent.mm.storage.af)localObject).Zl();
          c.apM().c("notifymessage", (com.tencent.mm.storage.af)localObject);
          break label1075;
          label1593:
          if (!paramAnonymousBoolean) {
            break label1188;
          }
          ad.i("MicroMsg.HardCodeHelper", "do update app brand service message accunt");
          ((com.tencent.mm.storage.af)localObject).Zl();
          c.apM().c("appbrandcustomerservicemsg", (com.tencent.mm.storage.af)localObject);
          break label1188;
          label1628:
          if (paramAnonymousBoolean)
          {
            ad.i("MicroMsg.HardCodeHelper", "do update app brand service message accunt");
            ((com.tencent.mm.storage.af)localObject).Zl();
            c.apM().c("appbrand_notify_message", (com.tencent.mm.storage.af)localObject);
          }
        }
      }
    };
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.b(a.class, new a());
    com.tencent.mm.kernel.g.afC().gdD.bv(parama);
    this.gMT = new c();
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(99L, 142L, 1L, false);
    com.tencent.mm.al.u.a(new com.tencent.mm.plugin.zero.a.e()
    {
      public final byte[] a(l.d paramAnonymousd, int paramAnonymousInt)
      {
        AppMethodBeat.i(20323);
        switch (paramAnonymousInt)
        {
        default: 
          AppMethodBeat.o(20323);
          return null;
        case 722: 
          paramAnonymousd = ((com.tencent.mm.protocal.q.a)paramAnonymousd).CqI.DdW.CFU.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 145: 
          paramAnonymousd = ((n.a)paramAnonymousd).CqA.CFU.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 107: 
          paramAnonymousd = ((v.a)paramAnonymousd).ikJ.CFU.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 429: 
          paramAnonymousd = ((u.a)paramAnonymousd).ikH.CFU.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 499: 
          paramAnonymousd = ((com.tencent.mm.plugin.report.b.c.a)paramAnonymousd).vJk.CFU.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 694: 
          paramAnonymousd = ((com.tencent.mm.plugin.report.b.b.a)paramAnonymousd).vJk.CFU.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 989: 
          paramAnonymousd = ((ase)((b.b)paramAnonymousd).gUX).CYn.toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 987: 
        case 997: 
          paramAnonymousd = ((wi)((b.b)paramAnonymousd).gUX).CYn.toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 481: 
          paramAnonymousd = ((s.a)paramAnonymousd).ikE.CFU.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 572: 
          paramAnonymousd = ((t.a)paramAnonymousd).ikG.CFU.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 616: 
          paramAnonymousd = ((bd.a)paramAnonymousd).gNy.CFU.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 617: 
          paramAnonymousd = ((bf.a)paramAnonymousd).gNC.CFU.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 618: 
          paramAnonymousd = ((be.a)paramAnonymousd).gNA.CFU.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        }
        paramAnonymousd = ((k.a)paramAnonymousd).Cqv;
        AppMethodBeat.o(20323);
        return paramAnonymousd;
      }
    });
    com.tencent.mm.kernel.g.afC();
    paramap = com.tencent.mm.kernel.g.afA();
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
    paramap.gcx.bv(parama);
    AppMethodBeat.o(20341);
  }
  
  public static ah Lv()
  {
    AppMethodBeat.i(20340);
    ah localah = arS().gNc.Lv();
    AppMethodBeat.o(20340);
    return localah;
  }
  
  public static void a(ao paramao)
  {
    AppMethodBeat.i(20333);
    com.tencent.mm.kernel.b.a(paramao);
    AppMethodBeat.o(20333);
  }
  
  public static void a(ap paramap, com.tencent.mm.al.q.a parama)
  {
    AppMethodBeat.i(20338);
    gNd = new az(paramap, parama);
    com.tencent.mm.modelstat.o.cE(aj.getContext());
    AppMethodBeat.o(20338);
  }
  
  public static void a(n paramn)
  {
    AppMethodBeat.i(20331);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().a(paramn);
    AppMethodBeat.o(20331);
  }
  
  public static boolean aeC()
  {
    AppMethodBeat.i(20353);
    boolean bool = com.tencent.mm.kernel.a.aeC();
    AppMethodBeat.o(20353);
    return bool;
  }
  
  public static String aeM()
  {
    AppMethodBeat.i(20346);
    String str = com.tencent.mm.kernel.a.aeM();
    AppMethodBeat.o(20346);
    return str;
  }
  
  public static com.tencent.mm.al.q aeS()
  {
    AppMethodBeat.i(20349);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.al.q localq = com.tencent.mm.kernel.g.afA().gcy;
    AppMethodBeat.o(20349);
    return localq;
  }
  
  public static String aeq()
  {
    AppMethodBeat.i(20356);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afz();
    String str = com.tencent.mm.kernel.a.aeq();
    AppMethodBeat.o(20356);
    return str;
  }
  
  @Deprecated
  public static com.tencent.mm.sdk.platformtools.aq afE()
  {
    AppMethodBeat.i(20344);
    com.tencent.mm.sdk.platformtools.aq localaq = com.tencent.mm.kernel.g.afE();
    AppMethodBeat.o(20344);
    return localaq;
  }
  
  public static boolean afw()
  {
    AppMethodBeat.i(20352);
    if (!aj.cbv())
    {
      AppMethodBeat.o(20352);
      return false;
    }
    boolean bool = com.tencent.mm.kernel.g.afw();
    AppMethodBeat.o(20352);
    return bool;
  }
  
  public static boolean arO()
  {
    return gNd == null;
  }
  
  public static bz arP()
  {
    AppMethodBeat.i(20335);
    arS();
    bz localbz = gNf;
    AppMethodBeat.o(20335);
    return localbz;
  }
  
  public static boolean arQ()
  {
    AppMethodBeat.i(20336);
    boolean bool = com.tencent.mm.kernel.a.aeB();
    AppMethodBeat.o(20336);
    return bool;
  }
  
  public static void arR()
  {
    AppMethodBeat.i(20337);
    com.tencent.mm.kernel.a.dz(false);
    AppMethodBeat.o(20337);
  }
  
  private static az arS()
  {
    AppMethodBeat.i(20342);
    Assert.assertNotNull("MMCore not initialized by MMApplication", gNd);
    az localaz = gNd;
    AppMethodBeat.o(20342);
    return localaz;
  }
  
  public static aa arT()
  {
    AppMethodBeat.i(20343);
    com.tencent.mm.kernel.g.afC();
    aa localaa = com.tencent.mm.kernel.g.afB().gcR;
    AppMethodBeat.o(20343);
    return localaa;
  }
  
  public static void arU()
  {
    AppMethodBeat.i(20347);
    com.tencent.mm.g.a.ab localab = new com.tencent.mm.g.a.ab();
    com.tencent.mm.sdk.b.a.ESL.l(localab);
    AppMethodBeat.o(20347);
  }
  
  public static c arV()
  {
    AppMethodBeat.i(20348);
    c localc = arS().gMT;
    if (localc != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("MMCore has not been initialize ?", bool);
      AppMethodBeat.o(20348);
      return localc;
    }
  }
  
  public static boolean arW()
  {
    AppMethodBeat.i(20351);
    com.tencent.mm.kernel.g.afz();
    boolean bool = com.tencent.mm.kernel.a.aeH();
    AppMethodBeat.o(20351);
    return bool;
  }
  
  public static f arX()
  {
    AppMethodBeat.i(20357);
    f localf = arS().gNq;
    AppMethodBeat.o(20357);
    return localf;
  }
  
  public static void b(n paramn)
  {
    AppMethodBeat.i(20332);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().b(paramn);
    AppMethodBeat.o(20332);
  }
  
  public static aq getNotification()
  {
    AppMethodBeat.i(20339);
    aq localaq = arS().gNc.getNotification();
    AppMethodBeat.o(20339);
    return localaq;
  }
  
  public static cc getSysCmdMsgExtension()
  {
    AppMethodBeat.i(20345);
    cc localcc = ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension();
    AppMethodBeat.o(20345);
    return localcc;
  }
  
  public static void hold()
  {
    AppMethodBeat.i(20354);
    com.tencent.mm.kernel.a.hold();
    AppMethodBeat.o(20354);
  }
  
  public static void qM(String paramString)
  {
    AppMethodBeat.i(20334);
    com.tencent.mm.kernel.a.qM(paramString);
    AppMethodBeat.o(20334);
  }
  
  public static void unhold()
  {
    AppMethodBeat.i(20355);
    com.tencent.mm.kernel.a.unhold();
    AppMethodBeat.o(20355);
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
      if (paramc.gdr) {
        com.tencent.mm.z.c.adr().w(262145, false);
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(598L, 13L, 1L, false);
      long l = System.currentTimeMillis();
      ad.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized start tid[%d]", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
      Object localObject1 = az.a(az.this);
      com.tencent.mm.storagebase.h localh = com.tencent.mm.kernel.g.afB().gda;
      com.tencent.mm.kernel.g.afB();
      com.tencent.mm.plugin.messenger.foundation.a.a.h localh1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI();
      localh1.a(new ax(localh1));
      Object localObject2 = new com.tencent.mm.storage.h(localh1);
      ((c)localObject1).gLA = ((com.tencent.mm.storage.h)localObject2);
      localh1.a((com.tencent.mm.storage.e)localObject2);
      localObject2 = new i(localh1);
      ((c)localObject1).gLB = ((i)localObject2);
      localh1.a((com.tencent.mm.storage.e)localObject2);
      ((c)localObject1).gLy = new bu(localh, ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR());
      ((c)localObject1).gLz = new bt(localh, ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM());
      ((c)localObject1).gLC = new com.tencent.mm.model.b.c();
      ((c)localObject1).gLD = new com.tencent.mm.model.b.d();
      ((c)localObject1).gLH = new com.tencent.mm.model.b.b();
      ((c)localObject1).gLE = new com.tencent.mm.storage.k(localh);
      ((c)localObject1).gLF = new com.tencent.mm.storage.o(localh);
      ((c)localObject1).gLG = new m(localh);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(598L, 14L, 1L, false);
      ad.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done initDB take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      localObject1 = az.this.gNh;
      az.a(az.this);
      ((c.a)localObject1).dZ(paramc.gdr);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(598L, 15L, 1L, false);
      ad.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done onAccountPostReset take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      com.tencent.mm.compatible.util.e.XG();
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(598L, 16L, 1L, false);
      ad.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done all take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(20327);
    }
    
    public void onAccountRelease() {}
    
    public void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
    
    public void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
    {
      AppMethodBeat.i(20329);
      az.a(az.this);
      AppMethodBeat.o(20329);
    }
    
    public void parallelsDependency()
    {
      AppMethodBeat.i(20328);
      com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bB(com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class));
      AppMethodBeat.o(20328);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.az
 * JD-Core Version:    0.7.0.1
 */