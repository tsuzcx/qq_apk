package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.t;
import com.tencent.mm.ak.x;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.account.friend.a.s.a;
import com.tencent.mm.plugin.account.friend.a.u.a;
import com.tencent.mm.plugin.account.friend.a.v.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.k.a;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.n.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aak;
import com.tencent.mm.protocal.protobuf.air;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.ajm;
import com.tencent.mm.protocal.protobuf.blg;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bvt;
import com.tencent.mm.protocal.protobuf.bxj;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.cfv;
import com.tencent.mm.protocal.protobuf.eqi;
import com.tencent.mm.protocal.protobuf.mh;
import com.tencent.mm.protocal.q.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.bw.a;
import com.tencent.mm.storage.bw.b;
import com.tencent.mm.storage.k;
import com.tencent.mm.storage.m;
import com.tencent.mm.storage.u;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class bg
{
  private static bg iDx;
  private static final cg iDz;
  private final int iDA;
  final c.a iDB;
  private ck iDC;
  private cc iDD;
  private e iDE;
  private cn iDF;
  private ae iDG;
  private bv.a iDH;
  private bw.a iDI;
  private bw.a iDJ;
  private f iDK;
  private final c iDn;
  private final aw iDw;
  private com.tencent.mm.compatible.b.g iDy;
  
  static
  {
    AppMethodBeat.i(20360);
    iDx = null;
    iDz = new cg();
    AppMethodBeat.o(20360);
  }
  
  private bg(aw paramaw, com.tencent.mm.ak.t.a parama)
  {
    AppMethodBeat.i(20341);
    this.iDy = null;
    this.iDA = 1;
    this.iDC = new ck();
    this.iDD = new cc();
    this.iDE = new e();
    this.iDF = new cn();
    this.iDG = new ae();
    this.iDH = new bv.a()
    {
      public final as Kn(String paramAnonymousString)
      {
        return null;
      }
      
      public final void a(bv paramAnonymousbv, as paramAnonymousas)
      {
        AppMethodBeat.i(20325);
        String str = paramAnonymousas.field_username;
        if (as.IG(paramAnonymousas.field_username)) {
          paramAnonymousas.setUsername(as.bjz(paramAnonymousas.field_username));
        }
        if (Util.isNullOrNil(paramAnonymousas.ajz())) {
          paramAnonymousas.BF(com.tencent.mm.platformtools.f.Si(paramAnonymousas.field_nickname));
        }
        if (Util.isNullOrNil(paramAnonymousas.ajA())) {
          paramAnonymousas.BG(com.tencent.mm.platformtools.f.Sh(paramAnonymousas.field_nickname));
        }
        if (Util.isNullOrNil(paramAnonymousas.field_conRemarkPYShort)) {
          paramAnonymousas.BJ(com.tencent.mm.platformtools.f.Si(paramAnonymousas.field_conRemark));
        }
        if (Util.isNullOrNil(paramAnonymousas.field_conRemarkPYFull)) {
          paramAnonymousas.BI(com.tencent.mm.platformtools.f.Sh(paramAnonymousas.field_conRemark));
        }
        if (ab.p(paramAnonymousas))
        {
          paramAnonymousas.nd(43);
          paramAnonymousas.BF(com.tencent.mm.platformtools.f.Si(paramAnonymousas.arI()));
          paramAnonymousas.BG(com.tencent.mm.platformtools.f.Sh(paramAnonymousas.arI()));
          paramAnonymousas.BI(com.tencent.mm.platformtools.f.Sh(paramAnonymousas.arJ()));
          paramAnonymousas.BJ(paramAnonymousas.arJ());
          AppMethodBeat.o(20325);
          return;
        }
        if (ab.JE(str))
        {
          paramAnonymousas.aqQ();
          paramAnonymousas.ni(4);
          paramAnonymousas.nd(33);
          if (paramAnonymousas != null) {
            break label336;
          }
        }
        label336:
        for (paramAnonymousbv = new as();; paramAnonymousbv = paramAnonymousas)
        {
          paramAnonymousbv.setUsername(str);
          paramAnonymousbv.aqQ();
          ak.M(paramAnonymousbv);
          paramAnonymousbv.aqZ();
          if (paramAnonymousas.arA()) {
            paramAnonymousas.nd(paramAnonymousas.aqN());
          }
          if (ab.Js(str))
          {
            Log.i("MicroMsg.MMCore", "update official account helper showhead %d", new Object[] { Integer.valueOf(31) });
            paramAnonymousas.nd(31);
          }
          if (paramAnonymousas.ary())
          {
            bg.aVF();
            c.aST().c(new String[] { str }, "@blacklist");
          }
          Log.d("MicroMsg.MMCore", "onPreInsertContact2: %s, %s", new Object[] { paramAnonymousas.field_username, paramAnonymousas.ajz() });
          AppMethodBeat.o(20325);
          return;
        }
      }
      
      public final int b(as paramAnonymousas, boolean paramAnonymousBoolean)
      {
        return 0;
      }
    };
    this.iDI = new bw.a()
    {
      public final void a(az paramAnonymousaz, bw paramAnonymousbw)
      {
        AppMethodBeat.i(20326);
        if (paramAnonymousaz == null)
        {
          AppMethodBeat.o(20326);
          return;
        }
        if ((!as.bjm(paramAnonymousaz.field_username)) && (!as.bjo(paramAnonymousaz.field_username)) && (!as.IG(paramAnonymousaz.field_username)) && (!ab.IT(paramAnonymousaz.field_username)) && (!as.bjp(paramAnonymousaz.field_username)))
        {
          AppMethodBeat.o(20326);
          return;
        }
        if (as.IG(paramAnonymousaz.field_username))
        {
          paramAnonymousaz = paramAnonymousbw.bjY("floatbottle");
          if (paramAnonymousaz != null) {
            break label472;
          }
          paramAnonymousaz = new az("floatbottle");
        }
        label472:
        for (int i = 1;; i = 0)
        {
          paramAnonymousaz.nu(1);
          paramAnonymousaz.nt(s.aTQ());
          bg.aVF();
          com.tencent.mm.storage.ca localca = c.aSQ().aEA(" and not ( type = 10000 and isSend != 2 ) ");
          if ((localca != null) && (localca.field_msgId > 0L))
          {
            paramAnonymousaz.aX(localca);
            paramAnonymousaz.setContent(as.bjz(localca.field_talker) + ":" + localca.field_content);
            paramAnonymousaz.Cl(Integer.toString(localca.getType()));
            bw.b localb = paramAnonymousbw.Xh();
            if (localb != null)
            {
              PString localPString1 = new PString();
              PString localPString2 = new PString();
              PInt localPInt = new PInt();
              localca.Cy("floatbottle");
              localca.setContent(paramAnonymousaz.field_content);
              localb.a(localca, localPString1, localPString2, localPInt, false);
              paramAnonymousaz.Cm(localPString1.value);
              paramAnonymousaz.Cn(localPString2.value);
              paramAnonymousaz.nw(localPInt.value);
            }
          }
          while (i != 0)
          {
            paramAnonymousbw.e(paramAnonymousaz);
            AppMethodBeat.o(20326);
            return;
            paramAnonymousaz.gCr();
          }
          paramAnonymousbw.a(paramAnonymousaz, paramAnonymousaz.field_username);
          AppMethodBeat.o(20326);
          return;
          if ((as.bjm(paramAnonymousaz.field_username)) || (as.bjo(paramAnonymousaz.field_username)))
          {
            AppMethodBeat.o(20326);
            return;
          }
          com.tencent.mm.kernel.g.af(com.tencent.mm.al.q.class);
          u.b(paramAnonymousaz, paramAnonymousbw);
          if ("@blacklist".equals(paramAnonymousaz.field_parentRef))
          {
            bg.aVF();
            paramAnonymousbw = c.aSN().Kn(paramAnonymousaz.field_username);
            if ((paramAnonymousbw != null) && (!Util.isNullOrNil(paramAnonymousbw.field_username)) && (!paramAnonymousbw.ary()))
            {
              bg.aVF();
              c.aST().c(new String[] { paramAnonymousaz.field_username }, "");
            }
          }
          AppMethodBeat.o(20326);
          return;
        }
      }
    };
    this.iDJ = new bw.a()
    {
      public final void a(az paramAnonymousaz, bw paramAnonymousbw)
      {
        if (paramAnonymousaz == null) {}
      }
    };
    this.iDK = new f();
    this.iDw = paramaw;
    this.iDB = new c.a()
    {
      public final void fo(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(20322);
        Log.i("MicroMsg.MMCore", "summeranrt2 onAccountPostReset tid:%d stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Util.getStack() });
        bg.b(bg.this);
        long l1 = System.currentTimeMillis();
        bg.aVF();
        long l2 = c.getDataDB().beginTransaction(Thread.currentThread().getId());
        bg.a(bg.this);
        Object localObject;
        as localas1;
        as localas2;
        if (paramAnonymousBoolean)
        {
          Log.i("MicroMsg.MMCore", "[doAccountPostReset] updated is true");
          c.aSN().aNa("readerapp");
          c.azQ().set(256, Boolean.TRUE);
          Log.i("MicroMsg.MMCore", "[doAccountPostReset] begin to updated HardCodeUpdate");
          localObject = ab.aUZ();
          Log.i("MicroMsg.HardCodeUpdateTask", "[updateHelperIndexFor50] size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localas1 = (as)((Iterator)localObject).next();
            if ((localas1 != null) && ((int)localas1.gMZ != 0) && (localas1.field_showHead == 32))
            {
              localas1.nd(localas1.aqN());
              Log.d("MicroMsg.HardCodeUpdateTask", "contact to updatefavour " + localas1.field_username);
              bg.aVF();
              c.aSN().c(localas1.field_username, localas1);
            }
          }
          localObject = ab.iCO;
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            localas1 = localObject[i];
            localas2 = c.aSN().Kn(localas1);
            if ((localas2 != null) && (((int)localas2.gMZ != 0) || (com.tencent.mm.contact.c.oR(localas2.field_type))))
            {
              localas2.aqZ();
              c.aSN().c(localas1, localas2);
            }
            i += 1;
          }
          al.aVk();
          br.KA("ver" + com.tencent.mm.protocal.d.KyO);
        }
        br.b(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sog, 1), ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.soh, 0.75F), ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.soi, 0.4F), ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.soi, 0.4F));
        new ak(bg.a(bg.this));
        if (paramAnonymousBoolean)
        {
          ak.L(c.aSN().Kn("filehelper"));
          localObject = z.aTY();
          if (!Util.isNullOrNil((String)localObject))
          {
            localas1 = c.aSN().Kn((String)localObject);
            if ((int)localas1.gMZ != 0) {
              break label1513;
            }
            localas1.setUsername((String)localObject);
            localas1.aqQ();
            bg.aVF();
            c.aSN().ap(localas1);
          }
          ak.a(paramAnonymousBoolean, "qqmail", false);
          ak.a(paramAnonymousBoolean, "floatbottle", false);
          ak.a(paramAnonymousBoolean, "shakeapp", false);
          ak.a(paramAnonymousBoolean, "lbsapp", false);
          ak.a(paramAnonymousBoolean, "medianote", false);
          ak.a(paramAnonymousBoolean, "newsapp", true);
          c.aST().bjW("blogapp");
          c.aSQ().aEE("blogapp");
          c.aSN().aNa("blogapp");
          ak.a(paramAnonymousBoolean, "facebookapp", true);
          ak.a(paramAnonymousBoolean, "qqfriend", false);
          ak.a(paramAnonymousBoolean, "masssendapp", true);
          ak.a(paramAnonymousBoolean, "feedsapp", true);
          c.aST().bjW("tmessage");
          c.aSN().aNa("tmessage");
          localas2 = c.aSN().Kn("voip");
          localas1 = c.aSN().Kn("voipapp");
          localObject = localas1;
          if (localas1 == null) {
            localObject = new as();
          }
          if ((localas2 != null) && ((int)localas2.gMZ != 0)) {
            c.aSN().aNa("voip");
          }
          if ((int)((com.tencent.mm.contact.c)localObject).gMZ != 0) {
            break label1549;
          }
          ((as)localObject).setUsername("voipapp");
          ((as)localObject).aqQ();
          ak.M((as)localObject);
          ((as)localObject).ni(4);
          ((as)localObject).aqZ();
          c.aSN().aq((as)localObject);
          label802:
          localas1 = c.aSN().Kn("officialaccounts");
          localObject = localas1;
          if (localas1 == null) {
            localObject = new as();
          }
          Log.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.contact.c)localObject).gMZ) });
          if ((int)((com.tencent.mm.contact.c)localObject).gMZ != 0) {
            break label1575;
          }
          ((as)localObject).setUsername("officialaccounts");
          ((as)localObject).aqR();
          ak.M((as)localObject);
          ((as)localObject).ni(3);
          c.aSN().aq((as)localObject);
          label909:
          localas2 = c.aSN().Kn("voipaudio");
          localas1 = c.aSN().Kn("voicevoipapp");
          localObject = localas1;
          if (localas1 == null) {
            localObject = new as();
          }
          if ((localas2 != null) && ((int)localas2.gMZ != 0)) {
            c.aSN().aNa("voipaudio");
          }
          if ((int)((com.tencent.mm.contact.c)localObject).gMZ != 0) {
            break label1610;
          }
          ((as)localObject).setUsername("voicevoipapp");
          ((as)localObject).aqQ();
          ak.M((as)localObject);
          ((as)localObject).ni(4);
          ((as)localObject).aqZ();
          c.aSN().aq((as)localObject);
          label1028:
          ak.a(paramAnonymousBoolean, "voiceinputapp", false);
          ak.a(paramAnonymousBoolean, "linkedinplugin", false);
          localas1 = c.aSN().Kn("notifymessage");
          localObject = localas1;
          if (localas1 == null) {
            localObject = new as();
          }
          Log.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.contact.c)localObject).gMZ) });
          if ((int)((com.tencent.mm.contact.c)localObject).gMZ != 0) {
            break label1636;
          }
          ((as)localObject).setUsername("notifymessage");
          ((as)localObject).aqR();
          ak.M((as)localObject);
          ((as)localObject).ni(3);
          c.aSN().aq((as)localObject);
          label1153:
          localas1 = c.aSN().Kn("appbrandcustomerservicemsg");
          localObject = localas1;
          if (localas1 == null) {
            localObject = new as();
          }
          Log.i("MicroMsg.HardCodeHelper", "hardcodeAppBrandServiceMessage:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.contact.c)localObject).gMZ) });
          if ((int)((com.tencent.mm.contact.c)localObject).gMZ != 0) {
            break label1671;
          }
          ((as)localObject).setUsername("appbrandcustomerservicemsg");
          ((as)localObject).aqR();
          ak.M((as)localObject);
          ((as)localObject).setType(0);
          ((as)localObject).ni(3);
          c.aSN().aq((as)localObject);
          label1266:
          localas1 = c.aSN().Kn("appbrand_notify_message");
          localObject = localas1;
          if (localas1 == null) {
            localObject = new as();
          }
          Log.i("MicroMsg.HardCodeHelper", "hardcodeAppBrandNotifyMessage:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.contact.c)localObject).gMZ) });
          if ((int)((com.tencent.mm.contact.c)localObject).gMZ != 0) {
            break label1706;
          }
          ((as)localObject).setUsername("appbrand_notify_message");
          ((as)localObject).aqR();
          ak.M((as)localObject);
          ((as)localObject).ni(3);
          c.aSN().aq((as)localObject);
        }
        for (;;)
        {
          ak.a(paramAnonymousBoolean, "downloaderapp", true);
          if (paramAnonymousBoolean)
          {
            bg.aVF();
            c.aST().bjW("Weixin");
            bg.aVF();
            c.aSN().aNa("Weixin");
          }
          bg.aVF();
          c.getDataDB().endTransaction(l2);
          Log.i("MicroMsg.MMCore", "summeranrt dkwt set forceManual :%b, tid[%d], take[%s]ms, stack[%s]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l1), Util.getStack() });
          bg.a(bg.this);
          c.aST().a(bg.c(bg.aVI()).Xh());
          AppMethodBeat.o(20322);
          return;
          label1513:
          if (com.tencent.mm.contact.c.oR(localas1.field_type)) {
            break;
          }
          localas1.aqQ();
          bg.aVF();
          c.aSN().c((String)localObject, localas1);
          break;
          label1549:
          if (!paramAnonymousBoolean) {
            break label802;
          }
          ((as)localObject).aqZ();
          c.aSN().c("voipapp", (as)localObject);
          break label802;
          label1575:
          if (!paramAnonymousBoolean) {
            break label909;
          }
          Log.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
          ((as)localObject).aqR();
          c.aSN().c("officialaccounts", (as)localObject);
          break label909;
          label1610:
          if (!paramAnonymousBoolean) {
            break label1028;
          }
          ((as)localObject).aqZ();
          c.aSN().c("voicevoipapp", (as)localObject);
          break label1028;
          label1636:
          if (!paramAnonymousBoolean) {
            break label1153;
          }
          Log.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
          ((as)localObject).aqR();
          c.aSN().c("notifymessage", (as)localObject);
          break label1153;
          label1671:
          if (!paramAnonymousBoolean) {
            break label1266;
          }
          Log.i("MicroMsg.HardCodeHelper", "do update app brand service message accunt");
          ((as)localObject).aqR();
          c.aSN().c("appbrandcustomerservicemsg", (as)localObject);
          break label1266;
          label1706:
          if (paramAnonymousBoolean)
          {
            Log.i("MicroMsg.HardCodeHelper", "do update app brand service message accunt");
            ((as)localObject).aqR();
            c.aSN().c("appbrand_notify_message", (as)localObject);
          }
        }
      }
    };
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.b(a.class, new a());
    com.tencent.mm.kernel.g.aAi().hro.add(parama);
    this.iDn = new c();
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(99L, 142L, 1L, false);
    x.a(new com.tencent.mm.plugin.zero.a.e()
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
          paramAnonymousd = ((q.a)paramAnonymousd).KzQ.LsW.KPW.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 145: 
          paramAnonymousd = ((n.a)paramAnonymousd).KzI.KPW.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 107: 
          paramAnonymousd = ((v.a)paramAnonymousd).keW.KPW.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 429: 
          paramAnonymousd = ((u.a)paramAnonymousd).keU.KPW.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 499: 
          paramAnonymousd = ((com.tencent.mm.plugin.report.b.c.a)paramAnonymousd).CxL.KPW.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 694: 
          paramAnonymousd = ((com.tencent.mm.plugin.report.b.b.a)paramAnonymousd).CxL.KPW.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 989: 
          paramAnonymousd = ((blg)((d.b)paramAnonymousd).iLR).LlC.toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 987: 
        case 997: 
          paramAnonymousd = ((aak)((d.b)paramAnonymousd).iLR).LlC.toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 481: 
          paramAnonymousd = ((s.a)paramAnonymousd).keR.KPW.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 572: 
          paramAnonymousd = ((com.tencent.mm.plugin.account.friend.a.t.a)paramAnonymousd).keT.KPW.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 616: 
          paramAnonymousd = ((bk.a)paramAnonymousd).iDS.KPW.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 617: 
          paramAnonymousd = ((bm.a)paramAnonymousd).iDW.KPW.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 618: 
          paramAnonymousd = ((bl.a)paramAnonymousd).iDU.KPW.getBuffer().toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        }
        paramAnonymousd = ((k.a)paramAnonymousd).KzD;
        AppMethodBeat.o(20323);
        return paramAnonymousd;
      }
    });
    com.tencent.mm.kernel.g.aAi();
    paramaw = com.tencent.mm.kernel.g.aAg();
    parama = new com.tencent.mm.kernel.api.d()
    {
      public final void b(com.tencent.mm.network.g paramAnonymousg)
      {
        AppMethodBeat.i(20324);
        com.tencent.mm.modelstat.q.d(paramAnonymousg);
        com.tencent.mm.modelstat.q.e(paramAnonymousg);
        AppMethodBeat.o(20324);
      }
    };
    paramaw.hqh.add(parama);
    AppMethodBeat.o(20341);
  }
  
  public static void FM(String paramString)
  {
    AppMethodBeat.i(20334);
    com.tencent.mm.kernel.a.FM(paramString);
    AppMethodBeat.o(20334);
  }
  
  public static an Xi()
  {
    AppMethodBeat.i(20340);
    an localan = aVC().iDw.Xi();
    AppMethodBeat.o(20340);
    return localan;
  }
  
  public static void a(av paramav)
  {
    AppMethodBeat.i(20333);
    com.tencent.mm.kernel.b.a(paramav);
    AppMethodBeat.o(20333);
  }
  
  public static void a(aw paramaw, com.tencent.mm.ak.t.a parama)
  {
    AppMethodBeat.i(20338);
    iDx = new bg(paramaw, parama);
    com.tencent.mm.modelstat.o.dh(MMApplicationContext.getContext());
    AppMethodBeat.o(20338);
  }
  
  public static void a(p paramp)
  {
    AppMethodBeat.i(20331);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().a(paramp);
    AppMethodBeat.o(20331);
  }
  
  public static boolean aAc()
  {
    AppMethodBeat.i(20352);
    if (!MMApplicationContext.isMMProcess())
    {
      AppMethodBeat.o(20352);
      return false;
    }
    boolean bool = com.tencent.mm.kernel.g.aAc();
    AppMethodBeat.o(20352);
    return bool;
  }
  
  @Deprecated
  public static MMHandlerThread aAk()
  {
    AppMethodBeat.i(20344);
    MMHandlerThread localMMHandlerThread = com.tencent.mm.kernel.g.aAk();
    AppMethodBeat.o(20344);
    return localMMHandlerThread;
  }
  
  public static boolean aVA()
  {
    AppMethodBeat.i(20336);
    boolean bool = com.tencent.mm.kernel.a.azi();
    AppMethodBeat.o(20336);
    return bool;
  }
  
  public static void aVB()
  {
    AppMethodBeat.i(20337);
    com.tencent.mm.kernel.a.es(false);
    AppMethodBeat.o(20337);
  }
  
  private static bg aVC()
  {
    AppMethodBeat.i(20342);
    Assert.assertNotNull("MMCore not initialized by MMApplication", iDx);
    bg localbg = iDx;
    AppMethodBeat.o(20342);
    return localbg;
  }
  
  public static com.tencent.mm.storage.an aVD()
  {
    AppMethodBeat.i(20343);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.storage.an localan = com.tencent.mm.kernel.g.aAh().hqB;
    AppMethodBeat.o(20343);
    return localan;
  }
  
  public static void aVE()
  {
    AppMethodBeat.i(20347);
    com.tencent.mm.g.a.ae localae = new com.tencent.mm.g.a.ae();
    EventCenter.instance.publish(localae);
    AppMethodBeat.o(20347);
  }
  
  public static c aVF()
  {
    AppMethodBeat.i(20348);
    c localc = aVC().iDn;
    if (localc != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("MMCore has not been initialize ?", bool);
      AppMethodBeat.o(20348);
      return localc;
    }
  }
  
  public static boolean aVG()
  {
    AppMethodBeat.i(20351);
    com.tencent.mm.kernel.g.aAf();
    boolean bool = com.tencent.mm.kernel.a.azo();
    AppMethodBeat.o(20351);
    return bool;
  }
  
  public static f aVH()
  {
    AppMethodBeat.i(20357);
    f localf = aVC().iDK;
    AppMethodBeat.o(20357);
    return localf;
  }
  
  public static boolean aVy()
  {
    return iDx == null;
  }
  
  public static cg aVz()
  {
    AppMethodBeat.i(20335);
    aVC();
    cg localcg = iDz;
    AppMethodBeat.o(20335);
    return localcg;
  }
  
  public static String ayX()
  {
    AppMethodBeat.i(20356);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAf();
    String str = com.tencent.mm.kernel.a.ayX();
    AppMethodBeat.o(20356);
    return str;
  }
  
  public static boolean azj()
  {
    AppMethodBeat.i(20353);
    boolean bool = com.tencent.mm.kernel.a.azj();
    AppMethodBeat.o(20353);
    return bool;
  }
  
  public static String azt()
  {
    AppMethodBeat.i(20346);
    String str = com.tencent.mm.kernel.a.azt();
    AppMethodBeat.o(20346);
    return str;
  }
  
  public static t azz()
  {
    AppMethodBeat.i(20349);
    com.tencent.mm.kernel.g.aAi();
    t localt = com.tencent.mm.kernel.g.aAg().hqi;
    AppMethodBeat.o(20349);
    return localt;
  }
  
  public static void b(p paramp)
  {
    AppMethodBeat.i(20332);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().b(paramp);
    AppMethodBeat.o(20332);
  }
  
  public static ax getNotification()
  {
    AppMethodBeat.i(20339);
    ax localax = aVC().iDw.getNotification();
    AppMethodBeat.o(20339);
    return localax;
  }
  
  public static cj getSysCmdMsgExtension()
  {
    AppMethodBeat.i(20345);
    cj localcj = ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension();
    AppMethodBeat.o(20345);
    return localcj;
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
    
    public void onAccountInitialized(e.c paramc)
    {
      AppMethodBeat.i(20327);
      if (paramc.hrc) {
        com.tencent.mm.y.c.axV().A(262145, false);
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(598L, 13L, 1L, false);
      long l = System.currentTimeMillis();
      Log.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized start tid[%d]", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
      Object localObject1 = bg.a(bg.this);
      com.tencent.mm.storagebase.h localh = com.tencent.mm.kernel.g.aAh().hqK;
      com.tencent.mm.kernel.g.aAh();
      com.tencent.mm.plugin.messenger.foundation.a.a.i locali = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy();
      locali.a(new bk(locali));
      Object localObject2 = new com.tencent.mm.storage.h(locali);
      ((c)localObject1).iBq = ((com.tencent.mm.storage.h)localObject2);
      locali.a((com.tencent.mm.storage.e)localObject2);
      localObject2 = new com.tencent.mm.storage.i(locali);
      ((c)localObject1).iBr = ((com.tencent.mm.storage.i)localObject2);
      locali.a((com.tencent.mm.storage.e)localObject2);
      ((c)localObject1).iBo = new cb(localh, ((l)com.tencent.mm.kernel.g.af(l.class)).aST());
      ((c)localObject1).iBp = new ca(localh, ((l)com.tencent.mm.kernel.g.af(l.class)).aSN());
      ((c)localObject1).iBs = new com.tencent.mm.model.b.c();
      ((c)localObject1).iBt = new com.tencent.mm.model.b.d();
      ((c)localObject1).iBx = new com.tencent.mm.model.b.b();
      ((c)localObject1).iBu = new k(localh);
      ((c)localObject1).iBv = new com.tencent.mm.storage.o(localh);
      ((c)localObject1).iBw = new m(localh);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(598L, 14L, 1L, false);
      Log.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done initDB take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      localObject1 = bg.this.iDB;
      bg.a(bg.this);
      ((c.a)localObject1).fo(paramc.hrc);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(598L, 15L, 1L, false);
      Log.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done onAccountPostReset take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      com.tencent.mm.compatible.util.e.apn();
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(598L, 16L, 1L, false);
      Log.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done all take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(20327);
    }
    
    public void onAccountRelease() {}
    
    public void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
    
    public void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
    {
      AppMethodBeat.i(20329);
      bg.a(bg.this);
      AppMethodBeat.o(20329);
    }
    
    public void parallelsDependency()
    {
      AppMethodBeat.i(20328);
      com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bI(com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class));
      AppMethodBeat.o(20328);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bg
 * JD-Core Version:    0.7.0.1
 */