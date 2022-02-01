package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.al.p;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
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
import com.tencent.mm.protocal.protobuf.adq;
import com.tencent.mm.protocal.protobuf.aeg;
import com.tencent.mm.protocal.protobuf.aeh;
import com.tencent.mm.protocal.protobuf.avi;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.beo;
import com.tencent.mm.protocal.protobuf.bga;
import com.tencent.mm.protocal.protobuf.bgd;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bnw;
import com.tencent.mm.protocal.protobuf.dpq;
import com.tencent.mm.protocal.protobuf.lg;
import com.tencent.mm.protocal.protobuf.wt;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bj.a;
import com.tencent.mm.storage.bk.a;
import com.tencent.mm.storage.bk.b;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.i;
import com.tencent.mm.storage.m;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class az
{
  private static az hnD;
  private static final bz hnF;
  private final ap hnC;
  private com.tencent.mm.compatible.b.g hnE;
  private final int hnG;
  final c.a hnH;
  private cd hnI;
  private bv hnJ;
  private e hnK;
  private cg hnL;
  private z hnM;
  private bj.a hnN;
  private bk.a hnO;
  private bk.a hnP;
  private f hnQ;
  private final c hnt;
  
  static
  {
    AppMethodBeat.i(20360);
    hnD = null;
    hnF = new bz();
    AppMethodBeat.o(20360);
  }
  
  private az(ap paramap, com.tencent.mm.ak.q.a parama)
  {
    AppMethodBeat.i(20341);
    this.hnE = null;
    this.hnG = 1;
    this.hnI = new cd();
    this.hnJ = new bv();
    this.hnK = new e();
    this.hnL = new cg();
    this.hnM = new z();
    this.hnN = new bj.a()
    {
      public final void a(bj paramAnonymousbj, com.tencent.mm.storage.ai paramAnonymousai)
      {
        AppMethodBeat.i(20325);
        String str = paramAnonymousai.field_username;
        if (com.tencent.mm.storage.ai.ww(paramAnonymousai.field_username)) {
          paramAnonymousai.setUsername(com.tencent.mm.storage.ai.aNh(paramAnonymousai.field_username));
        }
        if (bs.isNullOrNil(paramAnonymousai.To())) {
          paramAnonymousai.qk(com.tencent.mm.platformtools.f.Fw(paramAnonymousai.field_nickname));
        }
        if (bs.isNullOrNil(paramAnonymousai.Tp())) {
          paramAnonymousai.ql(com.tencent.mm.platformtools.f.Fv(paramAnonymousai.field_nickname));
        }
        if (bs.isNullOrNil(paramAnonymousai.field_conRemarkPYShort)) {
          paramAnonymousai.qo(com.tencent.mm.platformtools.f.Fw(paramAnonymousai.field_conRemark));
        }
        if (bs.isNullOrNil(paramAnonymousai.field_conRemarkPYFull)) {
          paramAnonymousai.qn(com.tencent.mm.platformtools.f.Fv(paramAnonymousai.field_conRemark));
        }
        if (w.i(paramAnonymousai))
        {
          paramAnonymousai.jB(43);
          paramAnonymousai.qk(com.tencent.mm.platformtools.f.Fw(paramAnonymousai.aaR()));
          paramAnonymousai.ql(com.tencent.mm.platformtools.f.Fv(paramAnonymousai.aaR()));
          paramAnonymousai.qn(com.tencent.mm.platformtools.f.Fv(paramAnonymousai.aaS()));
          paramAnonymousai.qo(paramAnonymousai.aaS());
          AppMethodBeat.o(20325);
          return;
        }
        if (w.xr(str))
        {
          paramAnonymousai.aaf();
          paramAnonymousai.jG(4);
          paramAnonymousai.jB(33);
          if (paramAnonymousai != null) {
            break label336;
          }
        }
        label336:
        for (paramAnonymousbj = new com.tencent.mm.storage.ai();; paramAnonymousbj = paramAnonymousai)
        {
          paramAnonymousbj.setUsername(str);
          paramAnonymousbj.aaf();
          ae.F(paramAnonymousbj);
          paramAnonymousbj.aao();
          if (paramAnonymousai.aaJ()) {
            paramAnonymousai.jB(paramAnonymousai.aac());
          }
          if (w.xg(str))
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMCore", "update official account helper showhead %d", new Object[] { Integer.valueOf(31) });
            paramAnonymousai.jB(31);
          }
          if (paramAnonymousai.aaH())
          {
            az.ayM();
            c.awG().c(new String[] { str }, "@blacklist");
          }
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.MMCore", "onPreInsertContact2: %s, %s", new Object[] { paramAnonymousai.field_username, paramAnonymousai.To() });
          AppMethodBeat.o(20325);
          return;
        }
      }
    };
    this.hnO = new bk.a()
    {
      public final void a(com.tencent.mm.storage.ap paramAnonymousap, com.tencent.mm.storage.bk paramAnonymousbk)
      {
        AppMethodBeat.i(20326);
        if (paramAnonymousap == null)
        {
          AppMethodBeat.o(20326);
          return;
        }
        if ((!com.tencent.mm.storage.ai.aMZ(paramAnonymousap.field_username)) && (!com.tencent.mm.storage.ai.aNb(paramAnonymousap.field_username)) && (!com.tencent.mm.storage.ai.ww(paramAnonymousap.field_username)) && (!w.wH(paramAnonymousap.field_username)) && (!com.tencent.mm.storage.ai.aNc(paramAnonymousap.field_username)))
        {
          AppMethodBeat.o(20326);
          return;
        }
        if (com.tencent.mm.storage.ai.ww(paramAnonymousap.field_username))
        {
          paramAnonymousap = paramAnonymousbk.aNI("floatbottle");
          if (paramAnonymousap != null) {
            break label472;
          }
          paramAnonymousap = new com.tencent.mm.storage.ap("floatbottle");
        }
        label472:
        for (int i = 1;; i = 0)
        {
          paramAnonymousap.jS(1);
          paramAnonymousap.jR(o.axp());
          az.ayM();
          bo localbo = c.awD().alm(" and not ( type = 10000 and isSend != 2 ) ");
          if ((localbo != null) && (localbo.field_msgId > 0L))
          {
            paramAnonymousap.aI(localbo);
            paramAnonymousap.setContent(com.tencent.mm.storage.ai.aNh(localbo.field_talker) + ":" + localbo.field_content);
            paramAnonymousap.qQ(Integer.toString(localbo.getType()));
            bk.b localb = paramAnonymousbk.Ls();
            if (localb != null)
            {
              PString localPString1 = new PString();
              PString localPString2 = new PString();
              PInt localPInt = new PInt();
              localbo.re("floatbottle");
              localbo.setContent(paramAnonymousap.field_content);
              localb.a(localbo, localPString1, localPString2, localPInt, false);
              paramAnonymousap.qR(localPString1.value);
              paramAnonymousap.qS(localPString2.value);
              paramAnonymousap.jU(localPInt.value);
            }
          }
          while (i != 0)
          {
            paramAnonymousbk.e(paramAnonymousap);
            AppMethodBeat.o(20326);
            return;
            paramAnonymousap.faH();
          }
          paramAnonymousbk.a(paramAnonymousap, paramAnonymousap.field_username);
          AppMethodBeat.o(20326);
          return;
          if ((com.tencent.mm.storage.ai.aMZ(paramAnonymousap.field_username)) || (com.tencent.mm.storage.ai.aNb(paramAnonymousap.field_username)))
          {
            AppMethodBeat.o(20326);
            return;
          }
          com.tencent.mm.kernel.g.ab(p.class);
          com.tencent.mm.storage.q.b(paramAnonymousap, paramAnonymousbk);
          if ("@blacklist".equals(paramAnonymousap.field_parentRef))
          {
            az.ayM();
            paramAnonymousbk = c.awB().aNt(paramAnonymousap.field_username);
            if ((paramAnonymousbk != null) && (!bs.isNullOrNil(paramAnonymousbk.field_username)) && (!paramAnonymousbk.aaH()))
            {
              az.ayM();
              c.awG().c(new String[] { paramAnonymousap.field_username }, "");
            }
          }
          AppMethodBeat.o(20326);
          return;
        }
      }
    };
    this.hnP = new bk.a()
    {
      public final void a(com.tencent.mm.storage.ap paramAnonymousap, com.tencent.mm.storage.bk paramAnonymousbk)
      {
        if (paramAnonymousap == null) {}
      }
    };
    this.hnQ = new f();
    this.hnC = paramap;
    this.hnH = new c.a()
    {
      public final void eu(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(20322);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMCore", "summeranrt2 onAccountPostReset tid:%d stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), bs.eWi() });
        az.b(az.this);
        long l1 = System.currentTimeMillis();
        az.ayM();
        long l2 = c.agw().vE(Thread.currentThread().getId());
        az.a(az.this);
        Object localObject;
        com.tencent.mm.storage.ai localai1;
        com.tencent.mm.storage.ai localai2;
        if (paramAnonymousBoolean)
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMCore", "[doAccountPostReset] updated is true");
          c.awB().aNA("readerapp");
          c.agA().set(256, Boolean.TRUE);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMCore", "[doAccountPostReset] begin to updated HardCodeUpdate");
          localObject = w.aym();
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.HardCodeUpdateTask", "[updateHelperIndexFor50] size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localai1 = (com.tencent.mm.storage.ai)((Iterator)localObject).next();
            if ((localai1 != null) && ((int)localai1.fLJ != 0) && (localai1.field_showHead == 32))
            {
              localai1.jB(localai1.aac());
              com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.HardCodeUpdateTask", "contact to updatefavour " + localai1.field_username);
              az.ayM();
              c.awB().c(localai1.field_username, localai1);
            }
          }
          localObject = w.hmW;
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            localai1 = localObject[i];
            localai2 = c.awB().aNt(localai1);
            if ((localai2 != null) && (((int)localai2.fLJ != 0) || (com.tencent.mm.n.b.ln(localai2.field_type))))
            {
              localai2.aao();
              c.awB().c(localai1, localai2);
            }
            i += 1;
          }
          af.ays();
          bk.yt("ver" + com.tencent.mm.protocal.d.DIc);
        }
        new ae(az.a(az.this));
        if (paramAnonymousBoolean)
        {
          ae.E(c.awB().aNt("filehelper"));
          localObject = u.axw();
          if (!bs.isNullOrNil((String)localObject))
          {
            localai1 = c.awB().aNt((String)localObject);
            if ((int)localai1.fLJ != 0) {
              break label1435;
            }
            localai1.setUsername((String)localObject);
            localai1.aaf();
            az.ayM();
            c.awB().ag(localai1);
          }
          ae.a(paramAnonymousBoolean, "qqmail", false);
          ae.a(paramAnonymousBoolean, "floatbottle", false);
          ae.a(paramAnonymousBoolean, "shakeapp", false);
          ae.a(paramAnonymousBoolean, "lbsapp", false);
          ae.a(paramAnonymousBoolean, "medianote", false);
          ae.a(paramAnonymousBoolean, "newsapp", true);
          c.awG().aNG("blogapp");
          c.awD().alq("blogapp");
          c.awB().aNA("blogapp");
          ae.a(paramAnonymousBoolean, "facebookapp", true);
          ae.a(paramAnonymousBoolean, "qqfriend", false);
          ae.a(paramAnonymousBoolean, "masssendapp", true);
          ae.a(paramAnonymousBoolean, "feedsapp", true);
          c.awG().aNG("tmessage");
          c.awB().aNA("tmessage");
          localai2 = c.awB().aNt("voip");
          localai1 = c.awB().aNt("voipapp");
          localObject = localai1;
          if (localai1 == null) {
            localObject = new com.tencent.mm.storage.ai();
          }
          if ((localai2 != null) && ((int)localai2.fLJ != 0)) {
            c.awB().aNA("voip");
          }
          if ((int)((com.tencent.mm.n.b)localObject).fLJ != 0) {
            break label1471;
          }
          ((com.tencent.mm.storage.ai)localObject).setUsername("voipapp");
          ((com.tencent.mm.storage.ai)localObject).aaf();
          ae.F((com.tencent.mm.storage.ai)localObject);
          ((com.tencent.mm.storage.ai)localObject).jG(4);
          ((com.tencent.mm.storage.ai)localObject).aao();
          c.awB().ah((com.tencent.mm.storage.ai)localObject);
          label724:
          localai1 = c.awB().aNt("officialaccounts");
          localObject = localai1;
          if (localai1 == null) {
            localObject = new com.tencent.mm.storage.ai();
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.n.b)localObject).fLJ) });
          if ((int)((com.tencent.mm.n.b)localObject).fLJ != 0) {
            break label1497;
          }
          ((com.tencent.mm.storage.ai)localObject).setUsername("officialaccounts");
          ((com.tencent.mm.storage.ai)localObject).aag();
          ae.F((com.tencent.mm.storage.ai)localObject);
          ((com.tencent.mm.storage.ai)localObject).jG(3);
          c.awB().ah((com.tencent.mm.storage.ai)localObject);
          label831:
          localai2 = c.awB().aNt("voipaudio");
          localai1 = c.awB().aNt("voicevoipapp");
          localObject = localai1;
          if (localai1 == null) {
            localObject = new com.tencent.mm.storage.ai();
          }
          if ((localai2 != null) && ((int)localai2.fLJ != 0)) {
            c.awB().aNA("voipaudio");
          }
          if ((int)((com.tencent.mm.n.b)localObject).fLJ != 0) {
            break label1532;
          }
          ((com.tencent.mm.storage.ai)localObject).setUsername("voicevoipapp");
          ((com.tencent.mm.storage.ai)localObject).aaf();
          ae.F((com.tencent.mm.storage.ai)localObject);
          ((com.tencent.mm.storage.ai)localObject).jG(4);
          ((com.tencent.mm.storage.ai)localObject).aao();
          c.awB().ah((com.tencent.mm.storage.ai)localObject);
          label950:
          ae.a(paramAnonymousBoolean, "voiceinputapp", false);
          ae.a(paramAnonymousBoolean, "linkedinplugin", false);
          localai1 = c.awB().aNt("notifymessage");
          localObject = localai1;
          if (localai1 == null) {
            localObject = new com.tencent.mm.storage.ai();
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.n.b)localObject).fLJ) });
          if ((int)((com.tencent.mm.n.b)localObject).fLJ != 0) {
            break label1558;
          }
          ((com.tencent.mm.storage.ai)localObject).setUsername("notifymessage");
          ((com.tencent.mm.storage.ai)localObject).aag();
          ae.F((com.tencent.mm.storage.ai)localObject);
          ((com.tencent.mm.storage.ai)localObject).jG(3);
          c.awB().ah((com.tencent.mm.storage.ai)localObject);
          label1075:
          localai1 = c.awB().aNt("appbrandcustomerservicemsg");
          localObject = localai1;
          if (localai1 == null) {
            localObject = new com.tencent.mm.storage.ai();
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.HardCodeHelper", "hardcodeAppBrandServiceMessage:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.n.b)localObject).fLJ) });
          if ((int)((com.tencent.mm.n.b)localObject).fLJ != 0) {
            break label1593;
          }
          ((com.tencent.mm.storage.ai)localObject).setUsername("appbrandcustomerservicemsg");
          ((com.tencent.mm.storage.ai)localObject).aag();
          ae.F((com.tencent.mm.storage.ai)localObject);
          ((com.tencent.mm.storage.ai)localObject).setType(0);
          ((com.tencent.mm.storage.ai)localObject).jG(3);
          c.awB().ah((com.tencent.mm.storage.ai)localObject);
          label1188:
          localai1 = c.awB().aNt("appbrand_notify_message");
          localObject = localai1;
          if (localai1 == null) {
            localObject = new com.tencent.mm.storage.ai();
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.HardCodeHelper", "hardcodeAppBrandNotifyMessage:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.n.b)localObject).fLJ) });
          if ((int)((com.tencent.mm.n.b)localObject).fLJ != 0) {
            break label1628;
          }
          ((com.tencent.mm.storage.ai)localObject).setUsername("appbrand_notify_message");
          ((com.tencent.mm.storage.ai)localObject).aag();
          ae.F((com.tencent.mm.storage.ai)localObject);
          ((com.tencent.mm.storage.ai)localObject).jG(3);
          c.awB().ah((com.tencent.mm.storage.ai)localObject);
        }
        for (;;)
        {
          ae.a(paramAnonymousBoolean, "downloaderapp", true);
          if (paramAnonymousBoolean)
          {
            az.ayM();
            c.awG().aNG("Weixin");
            az.ayM();
            c.awB().aNA("Weixin");
          }
          az.ayM();
          c.agw().qL(l2);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMCore", "summeranrt dkwt set forceManual :%b, tid[%d], take[%s]ms, stack[%s]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l1), bs.eWi() });
          az.a(az.this);
          c.awG().a(az.c(az.ayP()).Ls());
          AppMethodBeat.o(20322);
          return;
          label1435:
          if (com.tencent.mm.n.b.ln(localai1.field_type)) {
            break;
          }
          localai1.aaf();
          az.ayM();
          c.awB().c((String)localObject, localai1);
          break;
          label1471:
          if (!paramAnonymousBoolean) {
            break label724;
          }
          ((com.tencent.mm.storage.ai)localObject).aao();
          c.awB().c("voipapp", (com.tencent.mm.storage.ai)localObject);
          break label724;
          label1497:
          if (!paramAnonymousBoolean) {
            break label831;
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
          ((com.tencent.mm.storage.ai)localObject).aag();
          c.awB().c("officialaccounts", (com.tencent.mm.storage.ai)localObject);
          break label831;
          label1532:
          if (!paramAnonymousBoolean) {
            break label950;
          }
          ((com.tencent.mm.storage.ai)localObject).aao();
          c.awB().c("voicevoipapp", (com.tencent.mm.storage.ai)localObject);
          break label950;
          label1558:
          if (!paramAnonymousBoolean) {
            break label1075;
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
          ((com.tencent.mm.storage.ai)localObject).aag();
          c.awB().c("notifymessage", (com.tencent.mm.storage.ai)localObject);
          break label1075;
          label1593:
          if (!paramAnonymousBoolean) {
            break label1188;
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.HardCodeHelper", "do update app brand service message accunt");
          ((com.tencent.mm.storage.ai)localObject).aag();
          c.awB().c("appbrandcustomerservicemsg", (com.tencent.mm.storage.ai)localObject);
          break label1188;
          label1628:
          if (paramAnonymousBoolean)
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.HardCodeHelper", "do update app brand service message accunt");
            ((com.tencent.mm.storage.ai)localObject).aag();
            c.awB().c("appbrand_notify_message", (com.tencent.mm.storage.ai)localObject);
          }
        }
      }
    };
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.b(a.class, new a());
    com.tencent.mm.kernel.g.agS().gij.bs(parama);
    this.hnt = new c();
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(99L, 142L, 1L, false);
    com.tencent.mm.ak.u.a(new com.tencent.mm.plugin.zero.a.e()
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
          paramAnonymousd = ((com.tencent.mm.protocal.q.a)paramAnonymousd).DJa.Exc.DYu.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 145: 
          paramAnonymousd = ((n.a)paramAnonymousd).DIS.DYu.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 107: 
          paramAnonymousd = ((v.a)paramAnonymousd).iKQ.DYu.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 429: 
          paramAnonymousd = ((u.a)paramAnonymousd).iKO.DYu.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 499: 
          paramAnonymousd = ((com.tencent.mm.plugin.report.c.c.a)paramAnonymousd).wTo.DYu.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 694: 
          paramAnonymousd = ((com.tencent.mm.plugin.report.c.b.a)paramAnonymousd).wTo.DYu.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 989: 
          paramAnonymousd = ((avi)((b.b)paramAnonymousd).hvw).EqX.toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 987: 
        case 997: 
          paramAnonymousd = ((wt)((b.b)paramAnonymousd).hvw).EqX.toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 481: 
          paramAnonymousd = ((s.a)paramAnonymousd).iKL.DYu.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 572: 
          paramAnonymousd = ((t.a)paramAnonymousd).iKN.DYu.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 616: 
          paramAnonymousd = ((bd.a)paramAnonymousd).hnY.DYu.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 617: 
          paramAnonymousd = ((bf.a)paramAnonymousd).hoc.DYu.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 618: 
          paramAnonymousd = ((be.a)paramAnonymousd).hoa.DYu.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        }
        paramAnonymousd = ((k.a)paramAnonymousd).DIN;
        AppMethodBeat.o(20323);
        return paramAnonymousd;
      }
    });
    com.tencent.mm.kernel.g.agS();
    paramap = com.tencent.mm.kernel.g.agQ();
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
    paramap.ghd.bs(parama);
    AppMethodBeat.o(20341);
  }
  
  public static ah Lt()
  {
    AppMethodBeat.i(20340);
    ah localah = ayJ().hnC.Lt();
    AppMethodBeat.o(20340);
    return localah;
  }
  
  public static void a(ao paramao)
  {
    AppMethodBeat.i(20333);
    com.tencent.mm.kernel.b.a(paramao);
    AppMethodBeat.o(20333);
  }
  
  public static void a(ap paramap, com.tencent.mm.ak.q.a parama)
  {
    AppMethodBeat.i(20338);
    hnD = new az(paramap, parama);
    com.tencent.mm.modelstat.o.cN(com.tencent.mm.sdk.platformtools.ai.getContext());
    AppMethodBeat.o(20338);
  }
  
  public static void a(n paramn)
  {
    AppMethodBeat.i(20331);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().a(paramn);
    AppMethodBeat.o(20331);
  }
  
  public static String afG()
  {
    AppMethodBeat.i(20356);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agP();
    String str = com.tencent.mm.kernel.a.afG();
    AppMethodBeat.o(20356);
    return str;
  }
  
  public static boolean afS()
  {
    AppMethodBeat.i(20353);
    boolean bool = com.tencent.mm.kernel.a.afS();
    AppMethodBeat.o(20353);
    return bool;
  }
  
  public static boolean agM()
  {
    AppMethodBeat.i(20352);
    if (!com.tencent.mm.sdk.platformtools.ai.ciE())
    {
      AppMethodBeat.o(20352);
      return false;
    }
    boolean bool = com.tencent.mm.kernel.g.agM();
    AppMethodBeat.o(20352);
    return bool;
  }
  
  @Deprecated
  public static com.tencent.mm.sdk.platformtools.ap agU()
  {
    AppMethodBeat.i(20344);
    com.tencent.mm.sdk.platformtools.ap localap = com.tencent.mm.kernel.g.agU();
    AppMethodBeat.o(20344);
    return localap;
  }
  
  public static String agc()
  {
    AppMethodBeat.i(20346);
    String str = com.tencent.mm.kernel.a.agc();
    AppMethodBeat.o(20346);
    return str;
  }
  
  public static com.tencent.mm.ak.q agi()
  {
    AppMethodBeat.i(20349);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.ak.q localq = com.tencent.mm.kernel.g.agQ().ghe;
    AppMethodBeat.o(20349);
    return localq;
  }
  
  public static boolean ayF()
  {
    return hnD == null;
  }
  
  public static bz ayG()
  {
    AppMethodBeat.i(20335);
    ayJ();
    bz localbz = hnF;
    AppMethodBeat.o(20335);
    return localbz;
  }
  
  public static boolean ayH()
  {
    AppMethodBeat.i(20336);
    boolean bool = com.tencent.mm.kernel.a.afR();
    AppMethodBeat.o(20336);
    return bool;
  }
  
  public static void ayI()
  {
    AppMethodBeat.i(20337);
    com.tencent.mm.kernel.a.dz(false);
    AppMethodBeat.o(20337);
  }
  
  private static az ayJ()
  {
    AppMethodBeat.i(20342);
    Assert.assertNotNull("MMCore not initialized by MMApplication", hnD);
    az localaz = hnD;
    AppMethodBeat.o(20342);
    return localaz;
  }
  
  public static ad ayK()
  {
    AppMethodBeat.i(20343);
    com.tencent.mm.kernel.g.agS();
    ad localad = com.tencent.mm.kernel.g.agR().ghx;
    AppMethodBeat.o(20343);
    return localad;
  }
  
  public static void ayL()
  {
    AppMethodBeat.i(20347);
    com.tencent.mm.g.a.ac localac = new com.tencent.mm.g.a.ac();
    com.tencent.mm.sdk.b.a.GpY.l(localac);
    AppMethodBeat.o(20347);
  }
  
  public static c ayM()
  {
    AppMethodBeat.i(20348);
    c localc = ayJ().hnt;
    if (localc != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("MMCore has not been initialize ?", bool);
      AppMethodBeat.o(20348);
      return localc;
    }
  }
  
  public static boolean ayN()
  {
    AppMethodBeat.i(20351);
    com.tencent.mm.kernel.g.agP();
    boolean bool = com.tencent.mm.kernel.a.afX();
    AppMethodBeat.o(20351);
    return bool;
  }
  
  public static f ayO()
  {
    AppMethodBeat.i(20357);
    f localf = ayJ().hnQ;
    AppMethodBeat.o(20357);
    return localf;
  }
  
  public static void b(n paramn)
  {
    AppMethodBeat.i(20332);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().b(paramn);
    AppMethodBeat.o(20332);
  }
  
  public static aq getNotification()
  {
    AppMethodBeat.i(20339);
    aq localaq = ayJ().hnC.getNotification();
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
  
  public static void ub(String paramString)
  {
    AppMethodBeat.i(20334);
    com.tencent.mm.kernel.a.ub(paramString);
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
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMCore", "collectDatabaseFactory ");
      HashMap localHashMap = new HashMap();
      localHashMap.putAll(c.baseDBFactories);
      AppMethodBeat.o(20330);
      return localHashMap;
    }
    
    public void onAccountInitialized(e.c paramc)
    {
      AppMethodBeat.i(20327);
      if (paramc.ghX) {
        com.tencent.mm.y.c.aeH().w(262145, false);
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(598L, 13L, 1L, false);
      long l = System.currentTimeMillis();
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized start tid[%d]", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
      Object localObject1 = az.a(az.this);
      com.tencent.mm.storagebase.h localh = com.tencent.mm.kernel.g.agR().ghG;
      com.tencent.mm.kernel.g.agR();
      com.tencent.mm.plugin.messenger.foundation.a.a.h localh1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr();
      localh1.a(new ba(localh1));
      Object localObject2 = new com.tencent.mm.storage.h(localh1);
      ((c)localObject1).hma = ((com.tencent.mm.storage.h)localObject2);
      localh1.a((com.tencent.mm.storage.e)localObject2);
      localObject2 = new i(localh1);
      ((c)localObject1).hmb = ((i)localObject2);
      localh1.a((com.tencent.mm.storage.e)localObject2);
      ((c)localObject1).hlY = new bu(localh, ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG());
      ((c)localObject1).hlZ = new bt(localh, ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB());
      ((c)localObject1).hmc = new com.tencent.mm.model.b.c();
      ((c)localObject1).hmd = new com.tencent.mm.model.b.d();
      ((c)localObject1).hmh = new com.tencent.mm.model.b.b();
      ((c)localObject1).hme = new com.tencent.mm.storage.k(localh);
      ((c)localObject1).hmf = new com.tencent.mm.storage.o(localh);
      ((c)localObject1).hmg = new m(localh);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(598L, 14L, 1L, false);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done initDB take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      localObject1 = az.this.hnH;
      az.a(az.this);
      ((c.a)localObject1).eu(paramc.ghX);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(598L, 15L, 1L, false);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done onAccountPostReset take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      com.tencent.mm.compatible.util.e.YD();
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(598L, 16L, 1L, false);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done all take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
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
      com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).by(com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class));
      AppMethodBeat.o(20328);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.az
 * JD-Core Version:    0.7.0.1
 */