package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.w;
import com.tencent.mm.an.q;
import com.tencent.mm.autogen.a.ai;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.account.friend.model.p.a;
import com.tencent.mm.plugin.account.friend.model.r.a;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.report.b.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.k.a;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.n.a;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.chi;
import com.tencent.mm.protocal.protobuf.crj;
import com.tencent.mm.protocal.protobuf.ctb;
import com.tencent.mm.protocal.protobuf.cvg;
import com.tencent.mm.protocal.protobuf.cvj;
import com.tencent.mm.protocal.protobuf.cvn;
import com.tencent.mm.protocal.protobuf.dfl;
import com.tencent.mm.protocal.protobuf.fxa;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.my;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.bx.a;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.by.a;
import com.tencent.mm.storage.by.b;
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
  private static bh okW;
  private static final ci okZ;
  private final ax okV;
  private final c okX;
  private com.tencent.mm.compatible.b.g okY;
  private final int ola;
  final c.a olb;
  private cm olc;
  private ce old;
  private e ole;
  private cp olf;
  private ae olg;
  private bx.a olh;
  private by.a oli;
  private by.a olj;
  private f olk;
  
  static
  {
    AppMethodBeat.i(20360);
    okW = null;
    okZ = new ci();
    AppMethodBeat.o(20360);
  }
  
  private bh(ax paramax, com.tencent.mm.am.s.a parama)
  {
    AppMethodBeat.i(20341);
    this.okY = null;
    this.ola = 1;
    this.olc = new cm();
    this.old = new ce();
    this.ole = new e();
    this.olf = new cp();
    this.olg = new ae();
    this.olh = new bx.a()
    {
      public final au JE(String paramAnonymousString)
      {
        return null;
      }
      
      public final void a(bx paramAnonymousbx, au paramAnonymousau)
      {
        AppMethodBeat.i(20325);
        String str = paramAnonymousau.field_username;
        if (au.bwS(paramAnonymousau.field_username)) {
          paramAnonymousau.setUsername(au.bxd(paramAnonymousau.field_username));
        }
        if (Util.isNullOrNil(paramAnonymousau.aJt())) {
          paramAnonymousau.AY(com.tencent.mm.platformtools.f.Sa(paramAnonymousau.field_nickname));
        }
        if (Util.isNullOrNil(paramAnonymousau.aJu())) {
          paramAnonymousau.AZ(com.tencent.mm.platformtools.f.RZ(paramAnonymousau.field_nickname));
        }
        if (Util.isNullOrNil(paramAnonymousau.field_conRemarkPYShort)) {
          paramAnonymousau.Bc(com.tencent.mm.platformtools.f.Sa(paramAnonymousau.field_conRemark));
        }
        if (Util.isNullOrNil(paramAnonymousau.field_conRemarkPYFull)) {
          paramAnonymousau.Bb(com.tencent.mm.platformtools.f.RZ(paramAnonymousau.field_conRemark));
        }
        if (ab.q(paramAnonymousau))
        {
          paramAnonymousau.pp(43);
          paramAnonymousau.AY(com.tencent.mm.platformtools.f.Sa(paramAnonymousau.aSU()));
          paramAnonymousau.AZ(com.tencent.mm.platformtools.f.RZ(paramAnonymousau.aSU()));
          paramAnonymousau.Bb(com.tencent.mm.platformtools.f.RZ(paramAnonymousau.aSV()));
          paramAnonymousau.Bc(paramAnonymousau.aSV());
          AppMethodBeat.o(20325);
          return;
        }
        if (ab.IV(str))
        {
          paramAnonymousau.aRK();
          paramAnonymousau.pu(4);
          paramAnonymousau.pp(33);
          if (paramAnonymousau != null) {
            break label336;
          }
        }
        label336:
        for (paramAnonymousbx = new au();; paramAnonymousbx = paramAnonymousau)
        {
          paramAnonymousbx.setUsername(str);
          paramAnonymousbx.aRK();
          ak.U(paramAnonymousbx);
          paramAnonymousbx.aRZ();
          if (paramAnonymousau.aSK()) {
            paramAnonymousau.pp(paramAnonymousau.aRH());
          }
          if (au.bwp(str))
          {
            Log.i("MicroMsg.MMCore", "update official account helper showhead %d", new Object[] { Integer.valueOf(31) });
            paramAnonymousau.pp(31);
          }
          if (paramAnonymousau.aSF())
          {
            bh.bCz();
            c.bzG().e(new String[] { str }, "@blacklist");
          }
          Log.d("MicroMsg.MMCore", "onPreInsertContact2: %s, %s", new Object[] { paramAnonymousau.field_username, paramAnonymousau.aJt() });
          AppMethodBeat.o(20325);
          return;
        }
      }
      
      public final int b(au paramAnonymousau, boolean paramAnonymousBoolean)
      {
        return 0;
      }
    };
    this.oli = new by.a()
    {
      public final void a(bb paramAnonymousbb, by paramAnonymousby)
      {
        AppMethodBeat.i(20326);
        if (paramAnonymousbb == null)
        {
          AppMethodBeat.o(20326);
          return;
        }
        if ((!au.bwL(paramAnonymousbb.field_username)) && (!au.bwN(paramAnonymousbb.field_username)) && (!au.bwS(paramAnonymousbb.field_username)) && (!ab.IS(paramAnonymousbb.field_username)) && (!au.bwO(paramAnonymousbb.field_username)))
        {
          AppMethodBeat.o(20326);
          return;
        }
        if (au.bwS(paramAnonymousbb.field_username))
        {
          paramAnonymousbb = paramAnonymousby.bxM("floatbottle");
          if (paramAnonymousbb != null) {
            break label480;
          }
          paramAnonymousbb = new bb("floatbottle");
        }
        label480:
        for (int i = 1;; i = 0)
        {
          paramAnonymousbb.pH(1);
          paramAnonymousbb.pG(s.bAD());
          bh.bCz();
          com.tencent.mm.storage.cc localcc = c.bzD().aLJ(" and not ( type = 10000 and isSend != 2 ) ");
          if ((localcc != null) && (localcc.field_msgId > 0L))
          {
            paramAnonymousbb.bG(localcc);
            paramAnonymousbb.setContent(au.bxd(localcc.field_talker) + ":" + localcc.field_content);
            paramAnonymousbb.BE(Integer.toString(localcc.getType()));
            by.b localb = paramAnonymousby.aDH();
            if (localb != null)
            {
              PString localPString1 = new PString();
              PString localPString2 = new PString();
              PInt localPInt = new PInt();
              localcc.BS("floatbottle");
              localcc.setContent(paramAnonymousbb.field_content);
              localb.a(localcc, localPString1, localPString2, localPInt, false);
              paramAnonymousbb.BF(localPString1.value);
              paramAnonymousbb.BG(localPString2.value);
              paramAnonymousbb.pJ(localPInt.value);
            }
          }
          while (i != 0)
          {
            paramAnonymousby.h(paramAnonymousbb);
            AppMethodBeat.o(20326);
            return;
            paramAnonymousbb.jaJ();
          }
          paramAnonymousby.c(paramAnonymousbb, paramAnonymousbb.field_username);
          AppMethodBeat.o(20326);
          return;
          if ((au.bwL(paramAnonymousbb.field_username)) || (au.bwN(paramAnonymousbb.field_username)))
          {
            AppMethodBeat.o(20326);
            return;
          }
          ((q)com.tencent.mm.kernel.h.ax(q.class)).bzF();
          u.b(paramAnonymousbb, paramAnonymousby);
          if ("@blacklist".equals(paramAnonymousbb.field_parentRef))
          {
            bh.bCz();
            paramAnonymousby = c.bzA().JE(paramAnonymousbb.field_username);
            if ((paramAnonymousby != null) && (!Util.isNullOrNil(paramAnonymousby.field_username)) && (!paramAnonymousby.aSF()))
            {
              bh.bCz();
              c.bzG().e(new String[] { paramAnonymousbb.field_username }, "");
            }
          }
          AppMethodBeat.o(20326);
          return;
        }
      }
    };
    this.olj = new by.a()
    {
      public final void a(bb paramAnonymousbb, by paramAnonymousby)
      {
        if (paramAnonymousbb == null) {}
      }
    };
    this.olk = new f();
    this.okV = paramax;
    this.olb = new c.a()
    {
      public final void gQ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(20322);
        Log.i("MicroMsg.MMCore", "summeranrt2 onAccountPostReset tid:%d stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Util.getStack() });
        bh.b(bh.this);
        long l1 = System.currentTimeMillis();
        bh.bCz();
        long l2 = c.getDataDB().beginTransaction(Thread.currentThread().getId());
        bh.a(bh.this);
        au localau1;
        if (paramAnonymousBoolean)
        {
          Log.i("MicroMsg.MMCore", "[doAccountPostReset] updated is true");
          c.bzA().bxC("readerapp");
          c.ban().B(256, Boolean.TRUE);
          Log.i("MicroMsg.MMCore", "[doAccountPostReset] begin to updated HardCodeUpdate");
          localObject = ab.bBT();
          if (localObject == null) {}
          for (int i = 0;; i = ((List)localObject).size())
          {
            Log.i("MicroMsg.HardCodeUpdateTask", "[updateHelperIndexFor50] size:%s", new Object[] { Integer.valueOf(i) });
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              localau1 = (au)((Iterator)localObject).next();
              if ((localau1 != null) && ((int)localau1.maN != 0) && (localau1.field_showHead == 32))
              {
                localau1.pp(localau1.aRH());
                Log.d("MicroMsg.HardCodeUpdateTask", "contact to updatefavour " + localau1.field_username);
                bh.bCz();
                c.bzA().d(localau1.field_username, localau1);
              }
            }
          }
          localObject = ab.oko;
          int j = localObject.length;
          i = 0;
          while (i < j)
          {
            localau1 = localObject[i];
            au localau2 = c.bzA().JE(localau1);
            if ((localau2 != null) && (((int)localau2.maN != 0) || (com.tencent.mm.contact.d.rs(localau2.field_type))))
            {
              localau2.aRZ();
              c.bzA().d(localau1, localau2);
            }
            i += 1;
          }
          al.bCg();
          bt.JU("ver" + com.tencent.mm.protocal.d.Yxh);
        }
        bt.b(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zte, 1), ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ztf, 0.75F), ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ztg, 0.4F), ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ztg, 0.4F));
        Object localObject = com.tencent.mm.contact.b.maH;
        boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ztz, true);
        Log.i("MicroMsg.ContactUpgradeHelper", "setDefalutOptOpen:%b", new Object[] { Boolean.valueOf(bool) });
        ((com.tencent.mm.contact.b)localObject).maK = bool;
        new ak();
        if (paramAnonymousBoolean)
        {
          ak.T(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE("filehelper"));
          localObject = z.bAM();
          if (!Util.isNullOrNil((String)localObject))
          {
            localau1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE((String)localObject);
            if ((int)localau1.maN != 0) {
              break label1945;
            }
            localau1.setUsername((String)localObject);
            localau1.aRK();
            ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().aB(localau1);
          }
          ak.a(paramAnonymousBoolean, "qqmail", false);
          ak.a(paramAnonymousBoolean, "floatbottle", false);
          ak.a(paramAnonymousBoolean, "shakeapp", false);
          ak.a(paramAnonymousBoolean, "lbsapp", false);
          ak.a(paramAnonymousBoolean, "medianote", false);
          ak.a(paramAnonymousBoolean, "newsapp", true);
          ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxK("blogapp");
          ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aLO("blogapp");
          ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxC("blogapp");
          ak.a(paramAnonymousBoolean, "facebookapp", true);
          ak.a(paramAnonymousBoolean, "qqfriend", false);
          ak.a(paramAnonymousBoolean, "masssendapp", true);
          ak.a(paramAnonymousBoolean, "feedsapp", true);
          ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxK("tmessage");
          ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxC("tmessage");
          localau1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE("voip");
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE("voipapp");
          if (localObject != null) {
            break label2310;
          }
          localObject = new au();
        }
        label1410:
        label1541:
        label2310:
        for (;;)
        {
          if ((localau1 != null) && ((int)localau1.maN != 0)) {
            ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxC("voip");
          }
          if ((int)((com.tencent.mm.contact.d)localObject).maN == 0)
          {
            ((au)localObject).setUsername("voipapp");
            ((au)localObject).aRK();
            ak.U((au)localObject);
            ((au)localObject).pu(4);
            ((au)localObject).aRZ();
            ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().aC((au)localObject);
            label983:
            localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE("officialaccounts");
            if (localObject != null) {
              break label2307;
            }
            localObject = new au();
          }
          for (;;)
          {
            Log.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.contact.d)localObject).maN) });
            if ((int)((com.tencent.mm.contact.d)localObject).maN == 0)
            {
              ((au)localObject).setUsername("officialaccounts");
              ((au)localObject).aRL();
              ak.U((au)localObject);
              ((au)localObject).pu(3);
              ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().aC((au)localObject);
              label1108:
              localau1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE("voipaudio");
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE("voicevoipapp");
              if (localObject != null) {
                break label2304;
              }
              localObject = new au();
            }
            for (;;)
            {
              if ((localau1 != null) && ((int)localau1.maN != 0)) {
                ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxC("voipaudio");
              }
              if ((int)((com.tencent.mm.contact.d)localObject).maN == 0)
              {
                ((au)localObject).setUsername("voicevoipapp");
                ((au)localObject).aRK();
                ak.U((au)localObject);
                ((au)localObject).pu(4);
                ((au)localObject).aRZ();
                ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().aC((au)localObject);
                label1267:
                ak.a(paramAnonymousBoolean, "voiceinputapp", false);
                ak.a(paramAnonymousBoolean, "linkedinplugin", false);
                localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE("notifymessage");
                if (localObject != null) {
                  break label2301;
                }
                localObject = new au();
              }
              label1945:
              label2292:
              label2295:
              label2298:
              label2301:
              for (;;)
              {
                Log.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.contact.d)localObject).maN) });
                if ((int)((com.tencent.mm.contact.d)localObject).maN == 0)
                {
                  ((au)localObject).setUsername("notifymessage");
                  ((au)localObject).aRL();
                  ak.U((au)localObject);
                  ((au)localObject).pu(3);
                  ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().aC((au)localObject);
                  localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE("appbrandcustomerservicemsg");
                  if (localObject != null) {
                    break label2298;
                  }
                  localObject = new au();
                }
                for (;;)
                {
                  Log.i("MicroMsg.HardCodeHelper", "hardcodeAppBrandServiceMessage:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.contact.d)localObject).maN) });
                  if ((int)((com.tencent.mm.contact.d)localObject).maN == 0)
                  {
                    ((au)localObject).setUsername("appbrandcustomerservicemsg");
                    ((au)localObject).aRL();
                    ak.U((au)localObject);
                    ((au)localObject).ru(0);
                    ((au)localObject).pu(3);
                    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().aC((au)localObject);
                    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE("appbrand_notify_message");
                    if (localObject != null) {
                      break label2295;
                    }
                    localObject = new au();
                  }
                  for (;;)
                  {
                    Log.i("MicroMsg.HardCodeHelper", "hardcodeAppBrandNotifyMessage:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.contact.d)localObject).maN) });
                    if ((int)((com.tencent.mm.contact.d)localObject).maN == 0)
                    {
                      ((au)localObject).setUsername("appbrand_notify_message");
                      ((au)localObject).aRL();
                      ak.U((au)localObject);
                      ((au)localObject).pu(3);
                      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().aC((au)localObject);
                      ak.a(paramAnonymousBoolean, "downloaderapp", true);
                      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE("opencustomerservicemsg");
                      if (localObject != null) {
                        break label2292;
                      }
                      localObject = new au();
                    }
                    for (;;)
                    {
                      Log.i("MicroMsg.HardCodeHelper", "hardcodeOpenImKefuService:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf((int)((com.tencent.mm.contact.d)localObject).maN) });
                      if ((int)((com.tencent.mm.contact.d)localObject).maN == 0)
                      {
                        ((au)localObject).setUsername("opencustomerservicemsg");
                        ((au)localObject).aRL();
                        ak.U((au)localObject);
                        ((au)localObject).pu(3);
                        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().aC((au)localObject);
                      }
                      for (;;)
                      {
                        if (paramAnonymousBoolean)
                        {
                          ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxK("Weixin");
                          ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxC("Weixin");
                        }
                        bh.bCz();
                        c.getDataDB().endTransaction(l2);
                        Log.i("MicroMsg.MMCore", "summeranrt dkwt set forceManual :%b, tid[%d], take[%s]ms, stack[%s]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l1), Util.getStack() });
                        bh.a(bh.this);
                        c.bzG().a(bh.c(bh.bCC()).aDH());
                        AppMethodBeat.o(20322);
                        return;
                        if (com.tencent.mm.contact.d.rs(localau1.field_type)) {
                          break;
                        }
                        localau1.aRK();
                        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().d((String)localObject, localau1);
                        break;
                        if (!paramAnonymousBoolean) {
                          break label983;
                        }
                        ((au)localObject).aRZ();
                        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().d("voipapp", (au)localObject);
                        break label983;
                        if (!paramAnonymousBoolean) {
                          break label1108;
                        }
                        Log.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
                        ((au)localObject).aRL();
                        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().d("officialaccounts", (au)localObject);
                        break label1108;
                        if (!paramAnonymousBoolean) {
                          break label1267;
                        }
                        ((au)localObject).aRZ();
                        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().d("voicevoipapp", (au)localObject);
                        break label1267;
                        if (!paramAnonymousBoolean) {
                          break label1410;
                        }
                        Log.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
                        ((au)localObject).aRL();
                        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().d("notifymessage", (au)localObject);
                        break label1410;
                        if (!paramAnonymousBoolean) {
                          break label1541;
                        }
                        Log.i("MicroMsg.HardCodeHelper", "do update app brand service message accunt");
                        ((au)localObject).aRL();
                        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().d("appbrandcustomerservicemsg", (au)localObject);
                        break label1541;
                        if (!paramAnonymousBoolean) {
                          break label1666;
                        }
                        Log.i("MicroMsg.HardCodeHelper", "do update app brand service message accunt");
                        ((au)localObject).aRL();
                        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().d("appbrand_notify_message", (au)localObject);
                        break label1666;
                        if (paramAnonymousBoolean)
                        {
                          Log.i("MicroMsg.HardCodeHelper", "do update openImKefuService accunt");
                          ((au)localObject).aRL();
                          ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().d("opencustomerservicemsg", (au)localObject);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    };
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.b(a.class, new a());
    com.tencent.mm.kernel.h.baF().mDs.add(parama);
    this.okX = new c();
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(99L, 142L, 1L, false);
    w.a(new com.tencent.mm.plugin.zero.a.e()
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
          paramAnonymousd = ((com.tencent.mm.protocal.q.a)paramAnonymousd).Yyj.Zvw.YOj.aaxD.toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 145: 
          paramAnonymousd = ((n.a)paramAnonymousd).Yyb.YOj.aaxD.toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 107: 
          paramAnonymousd = ((com.tencent.mm.plugin.account.friend.model.s.a)paramAnonymousd).pTb.YOj.aaxD.toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 429: 
          paramAnonymousd = ((r.a)paramAnonymousd).pSZ.YOj.aaxD.toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 499: 
          paramAnonymousd = ((com.tencent.mm.plugin.report.b.c.a)paramAnonymousd).Ozt.YOj.aaxD.toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 694: 
          paramAnonymousd = ((b.a)paramAnonymousd).Ozt.YOj.aaxD.toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 989: 
          paramAnonymousd = ((chi)((c.b)paramAnonymousd).otI).ZkY.toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 987: 
        case 997: 
          paramAnonymousd = ((acp)((c.b)paramAnonymousd).otI).ZkY.toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 481: 
          paramAnonymousd = ((p.a)paramAnonymousd).pSW.YOj.aaxD.toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 572: 
          paramAnonymousd = ((com.tencent.mm.plugin.account.friend.model.q.a)paramAnonymousd).pSY.YOj.aaxD.toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 616: 
          paramAnonymousd = ((bm.a)paramAnonymousd).ols.YOj.aaxD.toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 617: 
          paramAnonymousd = ((bo.a)paramAnonymousd).olw.YOj.aaxD.toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        case 618: 
          paramAnonymousd = ((bn.a)paramAnonymousd).olu.YOj.aaxD.toByteArray();
          AppMethodBeat.o(20323);
          return paramAnonymousd;
        }
        paramAnonymousd = ((k.a)paramAnonymousd).YxW;
        AppMethodBeat.o(20323);
        return paramAnonymousd;
      }
    });
    com.tencent.mm.kernel.h.baF();
    paramax = com.tencent.mm.kernel.h.baD();
    parama = new com.tencent.mm.kernel.api.d()
    {
      public final void c(com.tencent.mm.network.g paramAnonymousg)
      {
        AppMethodBeat.i(20324);
        com.tencent.mm.modelstat.p.e(paramAnonymousg);
        com.tencent.mm.modelstat.p.f(paramAnonymousg);
        AppMethodBeat.o(20324);
      }
    };
    paramax.mCl.add(parama);
    AppMethodBeat.o(20341);
  }
  
  public static void Fv(String paramString)
  {
    AppMethodBeat.i(20334);
    com.tencent.mm.kernel.b.Fv(paramString);
    AppMethodBeat.o(20334);
  }
  
  public static void a(ax paramax, com.tencent.mm.am.s.a parama)
  {
    AppMethodBeat.i(20338);
    okW = new bh(paramax, parama);
    com.tencent.mm.modelstat.n.dX(MMApplicationContext.getContext());
    AppMethodBeat.o(20338);
  }
  
  public static void a(com.tencent.mm.network.p paramp)
  {
    AppMethodBeat.i(20331);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().a(paramp);
    AppMethodBeat.o(20331);
  }
  
  public static ap aDI()
  {
    AppMethodBeat.i(20340);
    ap localap = bCw().okV.aDI();
    AppMethodBeat.o(20340);
    return localap;
  }
  
  public static boolean aZG()
  {
    AppMethodBeat.i(20353);
    boolean bool = com.tencent.mm.kernel.b.aZG();
    AppMethodBeat.o(20353);
    return bool;
  }
  
  public static void aZH()
  {
    AppMethodBeat.i(20354);
    com.tencent.mm.kernel.b.aZH();
    AppMethodBeat.o(20354);
  }
  
  public static void aZI()
  {
    AppMethodBeat.i(20355);
    com.tencent.mm.kernel.b.aZI();
    AppMethodBeat.o(20355);
  }
  
  public static String aZR()
  {
    AppMethodBeat.i(20346);
    String str = com.tencent.mm.kernel.b.aZR();
    AppMethodBeat.o(20346);
    return str;
  }
  
  public static com.tencent.mm.am.s aZW()
  {
    AppMethodBeat.i(20349);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
    AppMethodBeat.o(20349);
    return locals;
  }
  
  public static String aZu()
  {
    AppMethodBeat.i(20356);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baC();
    String str = com.tencent.mm.kernel.b.aZu();
    AppMethodBeat.o(20356);
    return str;
  }
  
  public static void b(com.tencent.mm.network.p paramp)
  {
    AppMethodBeat.i(20332);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().b(paramp);
    AppMethodBeat.o(20332);
  }
  
  public static boolean bCA()
  {
    AppMethodBeat.i(20351);
    com.tencent.mm.kernel.h.baC();
    boolean bool = com.tencent.mm.kernel.b.aZM();
    AppMethodBeat.o(20351);
    return bool;
  }
  
  public static f bCB()
  {
    AppMethodBeat.i(20357);
    f localf = bCw().olk;
    AppMethodBeat.o(20357);
    return localf;
  }
  
  public static boolean bCs()
  {
    return okW == null;
  }
  
  public static ci bCt()
  {
    AppMethodBeat.i(20335);
    bCw();
    ci localci = okZ;
    AppMethodBeat.o(20335);
    return localci;
  }
  
  public static boolean bCu()
  {
    AppMethodBeat.i(20336);
    boolean bool = com.tencent.mm.kernel.b.aZF();
    AppMethodBeat.o(20336);
    return bool;
  }
  
  public static void bCv()
  {
    AppMethodBeat.i(20337);
    com.tencent.mm.kernel.b.fA(false);
    AppMethodBeat.o(20337);
  }
  
  private static bh bCw()
  {
    AppMethodBeat.i(20342);
    Assert.assertNotNull("MMCore not initialized by MMApplication", okW);
    bh localbh = okW;
    AppMethodBeat.o(20342);
    return localbh;
  }
  
  public static com.tencent.mm.storage.ap bCx()
  {
    AppMethodBeat.i(20343);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.storage.ap localap = com.tencent.mm.kernel.h.baE().mCE;
    AppMethodBeat.o(20343);
    return localap;
  }
  
  public static void bCy()
  {
    AppMethodBeat.i(20347);
    new ai().publish();
    AppMethodBeat.o(20347);
  }
  
  public static c bCz()
  {
    AppMethodBeat.i(20348);
    c localc = bCw().okX;
    if (localc != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("MMCore has not been initialize ?", bool);
      AppMethodBeat.o(20348);
      return localc;
    }
  }
  
  @Deprecated
  public static MMHandlerThread baH()
  {
    AppMethodBeat.i(20344);
    MMHandlerThread localMMHandlerThread = com.tencent.mm.kernel.h.baH();
    AppMethodBeat.o(20344);
    return localMMHandlerThread;
  }
  
  public static boolean baz()
  {
    AppMethodBeat.i(20352);
    if (!MMApplicationContext.isMMProcess())
    {
      AppMethodBeat.o(20352);
      return false;
    }
    boolean bool = com.tencent.mm.kernel.h.baz();
    AppMethodBeat.o(20352);
    return bool;
  }
  
  public static ay getNotification()
  {
    AppMethodBeat.i(20339);
    ay localay = bCw().okV.getNotification();
    AppMethodBeat.o(20339);
    return localay;
  }
  
  public static cl getSysCmdMsgExtension()
  {
    AppMethodBeat.i(20345);
    cl localcl = ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension();
    AppMethodBeat.o(20345);
    return localcl;
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
      if (paramc.mDg) {
        com.tencent.mm.aa.c.aYo().Q(262145, false);
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(598L, 13L, 1L, false);
      long l = System.currentTimeMillis();
      Log.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized start tid[%d]", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
      Object localObject1 = bh.a(bh.this);
      com.tencent.mm.storagebase.h localh = com.tencent.mm.kernel.h.baE().mCN;
      com.tencent.mm.kernel.h.baE();
      com.tencent.mm.plugin.messenger.foundation.a.a.i locali = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ();
      locali.a(new bm(locali));
      Object localObject2 = new com.tencent.mm.storage.h(locali);
      ((c)localObject1).oiv = ((com.tencent.mm.storage.h)localObject2);
      locali.a((com.tencent.mm.storage.e)localObject2);
      localObject2 = new com.tencent.mm.storage.i(locali);
      ((c)localObject1).oiw = ((com.tencent.mm.storage.i)localObject2);
      locali.a((com.tencent.mm.storage.e)localObject2);
      ((c)localObject1).oit = new cd(localh, ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG());
      ((c)localObject1).oiu = new cc(localh, ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA());
      ((c)localObject1).oix = new com.tencent.mm.model.b.c();
      ((c)localObject1).oiy = new com.tencent.mm.model.b.d();
      ((c)localObject1).oiC = new com.tencent.mm.model.b.b();
      ((c)localObject1).oiz = new k(localh);
      ((c)localObject1).oiA = new o(localh);
      ((c)localObject1).oiB = new m(localh);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(598L, 14L, 1L, false);
      Log.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done initDB take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      localObject1 = bh.this.olb;
      bh.a(bh.this);
      ((c.a)localObject1).gQ(paramc.mDg);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(598L, 15L, 1L, false);
      Log.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done onAccountPostReset take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      com.tencent.mm.compatible.util.e.aPU();
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(598L, 16L, 1L, false);
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
      com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).db(com.tencent.mm.kernel.h.az(v.class));
      AppMethodBeat.o(20328);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bh
 * JD-Core Version:    0.7.0.1
 */