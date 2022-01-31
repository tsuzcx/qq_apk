package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;

final class au$1
  implements c.a
{
  au$1(au paramau) {}
  
  public final void bG(boolean paramBoolean)
  {
    y.i("MicroMsg.MMCore", "summeranrt2 onAccountPostReset tid:%d stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), bk.csb() });
    au.b(this.dVT);
    long l1 = System.currentTimeMillis();
    au.Hx();
    long l2 = c.Dv().eV(Thread.currentThread().getId());
    au.a(this.dVT);
    au.Ht();
    Object localObject;
    ad localad1;
    if (paramBoolean)
    {
      c.Fw().abr("readerapp");
      c.Dz().o(256, Boolean.valueOf(true));
      ab.He();
      ab.He();
      localObject = c.Fw().cup();
      if (((Cursor)localObject).moveToFirst()) {
        do
        {
          localad1 = new ad();
          localad1.d((Cursor)localObject);
          localad1.AT();
          c.Fw().a(localad1.field_username, localad1);
        } while (((Cursor)localObject).moveToNext());
      }
      ((Cursor)localObject).close();
      bf.iO("ver" + d.spa);
    }
    new aa(au.a(this.dVT));
    if (paramBoolean)
    {
      aa.x(c.Fw().abl("filehelper"));
      localObject = q.Gj();
      if (!bk.bl((String)localObject))
      {
        localad1 = c.Fw().abl((String)localObject);
        if ((int)localad1.dBe != 0) {
          break label1145;
        }
        localad1.setUsername((String)localObject);
        localad1.AH();
        au.Hx();
        c.Fw().V(localad1);
      }
      aa.a(paramBoolean, "qqmail", false);
      aa.a(paramBoolean, "floatbottle", false);
      aa.a(paramBoolean, "shakeapp", false);
      aa.a(paramBoolean, "lbsapp", false);
      aa.a(paramBoolean, "medianote", false);
      aa.a(paramBoolean, "newsapp", true);
      c.FB().abu("blogapp");
      c.Fy().HG("blogapp");
      c.Fw().abr("blogapp");
      aa.a(paramBoolean, "facebookapp", true);
      aa.a(paramBoolean, "qqfriend", false);
      aa.a(paramBoolean, "masssendapp", true);
      aa.a(paramBoolean, "feedsapp", true);
      c.FB().abu("tmessage");
      c.Fw().abr("tmessage");
      ad localad2 = c.Fw().abl("voip");
      localad1 = c.Fw().abl("voipapp");
      localObject = localad1;
      if (localad1 == null) {
        localObject = new ad();
      }
      if ((localad2 != null) && ((int)localad2.dBe != 0)) {
        c.Fw().abr("voip");
      }
      if ((int)((a)localObject).dBe != 0) {
        break label1181;
      }
      ((ad)localObject).setUsername("voipapp");
      ((ad)localObject).AH();
      aa.y((ad)localObject);
      ((ad)localObject).fl(4);
      ((ad)localObject).AQ();
      c.Fw().W((ad)localObject);
      label548:
      localad1 = c.Fw().abl("officialaccounts");
      localObject = localad1;
      if (localad1 == null) {
        localObject = new ad();
      }
      y.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf((int)((a)localObject).dBe) });
      if ((int)((a)localObject).dBe != 0) {
        break label1207;
      }
      ((ad)localObject).setUsername("officialaccounts");
      ((ad)localObject).AI();
      aa.y((ad)localObject);
      ((ad)localObject).fl(3);
      c.Fw().W((ad)localObject);
      label655:
      localad2 = c.Fw().abl("voipaudio");
      localad1 = c.Fw().abl("voicevoipapp");
      localObject = localad1;
      if (localad1 == null) {
        localObject = new ad();
      }
      if ((localad2 != null) && ((int)localad2.dBe != 0)) {
        c.Fw().abr("voipaudio");
      }
      if ((int)((a)localObject).dBe != 0) {
        break label1242;
      }
      ((ad)localObject).setUsername("voicevoipapp");
      ((ad)localObject).AH();
      aa.y((ad)localObject);
      ((ad)localObject).fl(4);
      ((ad)localObject).AQ();
      c.Fw().W((ad)localObject);
      label774:
      aa.a(paramBoolean, "voiceinputapp", false);
      aa.a(paramBoolean, "linkedinplugin", false);
      localad1 = c.Fw().abl("notifymessage");
      localObject = localad1;
      if (localad1 == null) {
        localObject = new ad();
      }
      y.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf((int)((a)localObject).dBe) });
      if ((int)((a)localObject).dBe != 0) {
        break label1268;
      }
      ((ad)localObject).setUsername("notifymessage");
      ((ad)localObject).AI();
      aa.y((ad)localObject);
      ((ad)localObject).fl(3);
      c.Fw().W((ad)localObject);
      label899:
      localad1 = c.Fw().abl("appbrandcustomerservicemsg");
      localObject = localad1;
      if (localad1 == null) {
        localObject = new ad();
      }
      y.i("MicroMsg.HardCodeHelper", "hardcodeAppBrandServiceMessage:update[%B], contactID[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf((int)((a)localObject).dBe) });
      if ((int)((a)localObject).dBe != 0) {
        break label1303;
      }
      ((ad)localObject).setUsername("appbrandcustomerservicemsg");
      ((ad)localObject).AI();
      aa.y((ad)localObject);
      ((ad)localObject).setType(0);
      ((ad)localObject).fl(3);
      c.Fw().W((ad)localObject);
    }
    for (;;)
    {
      aa.a(paramBoolean, "downloaderapp", true);
      if (paramBoolean)
      {
        au.Hx();
        c.FB().abu("Weixin");
        au.Hx();
        c.Fw().abr("Weixin");
      }
      au.Hx();
      c.Dv().hI(l2);
      y.i("MicroMsg.MMCore", "summeranrt dkwt set forceManual :%b, tid[%d], take[%s]ms, stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l1), bk.csb() });
      au.a(this.dVT);
      c.FB().a(au.c(au.HB()).tt());
      return;
      label1145:
      if (a.gR(localad1.field_type)) {
        break;
      }
      localad1.AH();
      au.Hx();
      c.Fw().a((String)localObject, localad1);
      break;
      label1181:
      if (!paramBoolean) {
        break label548;
      }
      ((ad)localObject).AQ();
      c.Fw().a("voipapp", (ad)localObject);
      break label548;
      label1207:
      if (!paramBoolean) {
        break label655;
      }
      y.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
      ((ad)localObject).AI();
      c.Fw().a("officialaccounts", (ad)localObject);
      break label655;
      label1242:
      if (!paramBoolean) {
        break label774;
      }
      ((ad)localObject).AQ();
      c.Fw().a("voicevoipapp", (ad)localObject);
      break label774;
      label1268:
      if (!paramBoolean) {
        break label899;
      }
      y.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
      ((ad)localObject).AI();
      c.Fw().a("notifymessage", (ad)localObject);
      break label899;
      label1303:
      if (paramBoolean)
      {
        y.i("MicroMsg.HardCodeHelper", "do update app brand service message accunt");
        ((ad)localObject).AI();
        c.Fw().a("appbrandcustomerservicemsg", (ad)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.model.au.1
 * JD-Core Version:    0.7.0.1
 */