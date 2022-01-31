package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.n.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.List;

final class aw$1
  implements c.a
{
  aw$1(aw paramaw) {}
  
  public final void cI(boolean paramBoolean)
  {
    AppMethodBeat.i(16276);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMCore", "summeranrt2 onAccountPostReset tid:%d stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), bo.dtY() });
    aw.b(this.fmd);
    long l1 = System.currentTimeMillis();
    aw.aaz();
    long l2 = c.Rq().kr(Thread.currentThread().getId());
    aw.a(this.fmd);
    Object localObject;
    ad localad1;
    ad localad2;
    if (paramBoolean)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMCore", "[doAccountPostReset] updated is true");
      c.YA().arC("readerapp");
      c.Ru().set(256, Boolean.TRUE);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMCore", "[doAccountPostReset] begin to updated HardCodeUpdate");
      localObject = t.aab();
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.HardCodeUpdateTask", "[updateHelperIndexFor50] size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localad1 = (ad)((Iterator)localObject).next();
        if ((localad1 != null) && ((int)localad1.euF != 0) && (localad1.field_showHead == 32))
        {
          localad1.hs(localad1.Nu());
          com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.HardCodeUpdateTask", "contact to updatefavour " + localad1.field_username);
          aw.aaz();
          c.YA().b(localad1.field_username, localad1);
        }
      }
      localObject = t.fll;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localad1 = localObject[i];
        localad2 = c.YA().arw(localad1);
        if ((localad2 != null) && (((int)localad2.euF != 0) || (a.je(localad2.field_type))))
        {
          localad2.NG();
          c.YA().b(localad1, localad2);
        }
        i += 1;
      }
      ac.aag();
      bh.pC("ver" + d.whH);
    }
    new ab(aw.a(this.fmd));
    if (paramBoolean)
    {
      ab.x(c.YA().arw("filehelper"));
      localObject = r.Zn();
      if (!bo.isNullOrNil((String)localObject))
      {
        localad1 = c.YA().arw((String)localObject);
        if ((int)localad1.euF != 0) {
          break label1328;
        }
        localad1.setUsername((String)localObject);
        localad1.Nx();
        aw.aaz();
        c.YA().Y(localad1);
      }
      ab.a(paramBoolean, "qqmail", false);
      ab.a(paramBoolean, "floatbottle", false);
      ab.a(paramBoolean, "shakeapp", false);
      ab.a(paramBoolean, "lbsapp", false);
      ab.a(paramBoolean, "medianote", false);
      ab.a(paramBoolean, "newsapp", true);
      c.YF().arF("blogapp");
      c.YC().Ts("blogapp");
      c.YA().arC("blogapp");
      ab.a(paramBoolean, "facebookapp", true);
      ab.a(paramBoolean, "qqfriend", false);
      ab.a(paramBoolean, "masssendapp", true);
      ab.a(paramBoolean, "feedsapp", true);
      c.YF().arF("tmessage");
      c.YA().arC("tmessage");
      localad2 = c.YA().arw("voip");
      localad1 = c.YA().arw("voipapp");
      localObject = localad1;
      if (localad1 == null) {
        localObject = new ad();
      }
      if ((localad2 != null) && ((int)localad2.euF != 0)) {
        c.YA().arC("voip");
      }
      if ((int)((a)localObject).euF != 0) {
        break label1364;
      }
      ((ad)localObject).setUsername("voipapp");
      ((ad)localObject).Nx();
      ab.y((ad)localObject);
      ((ad)localObject).hx(4);
      ((ad)localObject).NG();
      c.YA().Z((ad)localObject);
      label724:
      localad1 = c.YA().arw("officialaccounts");
      localObject = localad1;
      if (localad1 == null) {
        localObject = new ad();
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf((int)((a)localObject).euF) });
      if ((int)((a)localObject).euF != 0) {
        break label1390;
      }
      ((ad)localObject).setUsername("officialaccounts");
      ((ad)localObject).Ny();
      ab.y((ad)localObject);
      ((ad)localObject).hx(3);
      c.YA().Z((ad)localObject);
      label831:
      localad2 = c.YA().arw("voipaudio");
      localad1 = c.YA().arw("voicevoipapp");
      localObject = localad1;
      if (localad1 == null) {
        localObject = new ad();
      }
      if ((localad2 != null) && ((int)localad2.euF != 0)) {
        c.YA().arC("voipaudio");
      }
      if ((int)((a)localObject).euF != 0) {
        break label1425;
      }
      ((ad)localObject).setUsername("voicevoipapp");
      ((ad)localObject).Nx();
      ab.y((ad)localObject);
      ((ad)localObject).hx(4);
      ((ad)localObject).NG();
      c.YA().Z((ad)localObject);
      label950:
      ab.a(paramBoolean, "voiceinputapp", false);
      ab.a(paramBoolean, "linkedinplugin", false);
      localad1 = c.YA().arw("notifymessage");
      localObject = localad1;
      if (localad1 == null) {
        localObject = new ad();
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf((int)((a)localObject).euF) });
      if ((int)((a)localObject).euF != 0) {
        break label1451;
      }
      ((ad)localObject).setUsername("notifymessage");
      ((ad)localObject).Ny();
      ab.y((ad)localObject);
      ((ad)localObject).hx(3);
      c.YA().Z((ad)localObject);
      label1075:
      localad1 = c.YA().arw("appbrandcustomerservicemsg");
      localObject = localad1;
      if (localad1 == null) {
        localObject = new ad();
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.HardCodeHelper", "hardcodeAppBrandServiceMessage:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf((int)((a)localObject).euF) });
      if ((int)((a)localObject).euF != 0) {
        break label1486;
      }
      ((ad)localObject).setUsername("appbrandcustomerservicemsg");
      ((ad)localObject).Ny();
      ab.y((ad)localObject);
      ((ad)localObject).setType(0);
      ((ad)localObject).hx(3);
      c.YA().Z((ad)localObject);
    }
    for (;;)
    {
      ab.a(paramBoolean, "downloaderapp", true);
      if (paramBoolean)
      {
        aw.aaz();
        c.YF().arF("Weixin");
        aw.aaz();
        c.YA().arC("Weixin");
      }
      aw.aaz();
      c.Rq().nY(l2);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMCore", "summeranrt dkwt set forceManual :%b, tid[%d], take[%s]ms, stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l1), bo.dtY() });
      aw.a(this.fmd);
      c.YF().a(aw.c(aw.aaD()).BX());
      AppMethodBeat.o(16276);
      return;
      label1328:
      if (a.je(localad1.field_type)) {
        break;
      }
      localad1.Nx();
      aw.aaz();
      c.YA().b((String)localObject, localad1);
      break;
      label1364:
      if (!paramBoolean) {
        break label724;
      }
      ((ad)localObject).NG();
      c.YA().b("voipapp", (ad)localObject);
      break label724;
      label1390:
      if (!paramBoolean) {
        break label831;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
      ((ad)localObject).Ny();
      c.YA().b("officialaccounts", (ad)localObject);
      break label831;
      label1425:
      if (!paramBoolean) {
        break label950;
      }
      ((ad)localObject).NG();
      c.YA().b("voicevoipapp", (ad)localObject);
      break label950;
      label1451:
      if (!paramBoolean) {
        break label1075;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
      ((ad)localObject).Ny();
      c.YA().b("notifymessage", (ad)localObject);
      break label1075;
      label1486:
      if (paramBoolean)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.HardCodeHelper", "do update app brand service message accunt");
        ((ad)localObject).Ny();
        c.YA().b("appbrandcustomerservicemsg", (ad)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.aw.1
 * JD-Core Version:    0.7.0.1
 */