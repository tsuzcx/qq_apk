package com.tencent.mm.plugin.exdevice.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.a.hc;
import com.tencent.mm.h.a.hc.a;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.aop;
import com.tencent.mm.protocal.c.aoq;
import com.tencent.mm.protocal.c.atz;
import com.tencent.mm.protocal.c.axd;
import com.tencent.mm.protocal.c.bnu;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.protocal.c.bvu;
import com.tencent.mm.protocal.c.cl;
import com.tencent.mm.protocal.c.cp;
import com.tencent.mm.protocal.c.sg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ab
  extends com.tencent.mm.sdk.b.c<hc>
  implements f
{
  private ProgressDialog dnm;
  hc jwl;
  
  public ab()
  {
    this.udX = hc.class.getName().hashCode();
  }
  
  private boolean a(hc paramhc)
  {
    if (!(paramhc instanceof hc)) {
      y.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mismatched event");
    }
    do
    {
      do
      {
        return false;
        this.jwl = paramhc;
        paramhc = this.jwl.bOW.result;
        y.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "action = %s, key = %s", new Object[] { Integer.valueOf(this.jwl.bOW.actionCode), paramhc });
      } while (bk.bl(paramhc));
      switch (this.jwl.bOW.actionCode)
      {
      default: 
        return false;
      }
    } while ((this.jwl.bOW.context == null) || (!(this.jwl.bOW.context instanceof Activity)));
    au.Dk().a(540, this);
    paramhc = new u(paramhc);
    au.Dk().a(paramhc, 0);
    Context localContext = this.jwl.bOW.context;
    this.jwl.bOW.context.getString(R.l.app_tip);
    this.dnm = com.tencent.mm.ui.base.h.b(localContext, this.jwl.bOW.context.getString(R.l.scan_loading_tip), new ab.1(this, paramhc));
    return false;
  }
  
  private void aLJ()
  {
    if ((this.jwl != null) && (this.jwl.bFJ != null))
    {
      this.jwl.bOX.ret = 1;
      this.jwl.bFJ.run();
    }
  }
  
  private void awl()
  {
    if ((this.jwl != null) && (this.jwl.bFJ != null))
    {
      this.jwl.bOX.ret = 2;
      this.jwl.bFJ.run();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    if ((this.dnm != null) && (this.dnm.isShowing())) {
      this.dnm.dismiss();
    }
    if (paramm == null) {
      aLJ();
    }
    do
    {
      return;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        y.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", new Object[] { Integer.valueOf(paramm.getType()) });
        aLJ();
        return;
      }
      y.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", new Object[] { Integer.valueOf(paramm.getType()) });
    } while (paramm.getType() != 540);
    au.Dk().b(540, this);
    paramString = (u)paramm;
    if ((paramString.dmK != null) && (paramString.dmK.ecF.ecN != null)) {}
    for (bnu localbnu = (bnu)paramString.dmK.ecF.ecN; localbnu == null; localbnu = null)
    {
      y.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp == null");
      aLJ();
      return;
    }
    aop localaop = localbnu.sBc;
    y.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "deviceId = %s, deviceType = %s", new Object[] { localaop.hQb, localaop.syI });
    aoq localaoq = localbnu.sBd;
    y.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "AuthKey = %s, BrandName = %s, CloseStrategy = %s, ConnProto = %s, ConnStrategy = %s, Mac = %s", new Object[] { localaoq.syp, localaoq.tkr, Integer.valueOf(localaoq.tku), localaoq.tks, Integer.valueOf(localaoq.tkt), localaoq.sAE });
    paramm = "";
    paramString = "";
    Object localObject3 = new LinkedList();
    Object localObject2 = paramm;
    Object localObject1 = paramString;
    if (localbnu.tGD != null)
    {
      if (localbnu.tGD.swi != null) {
        paramm = localbnu.tGD.swi;
      }
      if (localbnu.tGD.title != null) {
        paramString = localbnu.tGD.title;
      }
      localObject2 = paramm;
      localObject1 = paramString;
      if (localbnu.tGD.swj == null) {}
    }
    for (localObject1 = localbnu.tGD.swj;; localObject1 = localObject3)
    {
      localObject2 = new ArrayList();
      if ((localObject1 != null) && (((LinkedList)localObject1).size() > 0))
      {
        paramInt1 = 0;
        while (paramInt1 < ((LinkedList)localObject1).size())
        {
          localObject3 = (bvu)((LinkedList)localObject1).get(paramInt1);
          if (((bvu)localObject3).type.contains("text")) {
            ((ArrayList)localObject2).add(((bvu)localObject3).content);
          }
          paramInt1 += 1;
        }
      }
      y.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp.BindTicket = %s", new Object[] { localbnu.sAJ });
      boolean bool;
      if (localbnu.tGC == 1)
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("device_scan_mode", "SCAN_CATALOG");
        if ((localaoq.tks.contains("3")) || (localaoq.tks.contains("1"))) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          bool = localaoq.tks.contains("4");
          if ((paramInt1 == 0) || (!bool)) {
            break;
          }
          y.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Category connect proto can not be blue&wifi at the same time...");
          return;
        }
        if (paramInt1 != 0) {
          ((Intent)localObject1).putExtra("device_scan_conn_proto", "blue");
        }
        for (;;)
        {
          ((Intent)localObject1).putExtra("device_id", localaop.hQb);
          ((Intent)localObject1).putExtra("device_type", localaop.syI);
          ((Intent)localObject1).putExtra("device_title", localaoq.tky);
          ((Intent)localObject1).putExtra("device_desc", localaoq.tkz);
          ((Intent)localObject1).putExtra("device_icon_url", localaoq.kSy);
          ((Intent)localObject1).putExtra("device_category_id", localaoq.tkA);
          ((Intent)localObject1).putExtra("device_brand_name", localaoq.tkr);
          ((Intent)localObject1).putExtra("bind_ticket", localbnu.sAJ);
          ((Intent)localObject1).putExtra("device_ble_simple_proto", localaoq.cMY);
          ((Intent)localObject1).putExtra("device_airkiss_key", paramm);
          ((Intent)localObject1).putExtra("device_airkiss_title", paramString);
          ((Intent)localObject1).putStringArrayListExtra("device_airkiss_steps", (ArrayList)localObject2);
          com.tencent.mm.br.d.b(this.jwl.bOW.context, "exdevice", ".ui.ExdeviceBindDeviceGuideUI", (Intent)localObject1);
          awl();
          return;
          if (bool) {
            ((Intent)localObject1).putExtra("device_scan_conn_proto", "wifi");
          }
        }
      }
      paramString = localbnu.sAK;
      if (paramString == null)
      {
        y.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mContact == null");
        aLJ();
        return;
      }
      awl();
      if (paramString == null) {
        y.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "unable to parse mod contact");
      }
      for (;;)
      {
        paramm = aa.a(paramString.sQs);
        if ((this.jwl != null) && (this.jwl.bOW != null) && (this.jwl.bOW.context != null)) {
          break;
        }
        y.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "a8KeyRedirectEvent null");
        return;
        paramm = aa.a(paramString.sQs);
        localObject1 = bk.pm(paramString.ttu);
        if ((bk.bl(paramm)) && (bk.bl((String)localObject1)))
        {
          y.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact user is null user:%s enuser:%s", new Object[] { paramm, localObject1 });
        }
        else
        {
          y.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact : %s", new Object[] { paramm });
          au.Hx();
          localObject2 = com.tencent.mm.model.c.Fw().abl(paramm);
          if ((localObject2 != null) && (paramm.equals(((ao)localObject2).field_encryptUsername)))
          {
            y.w("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "cat's replace user with stranger");
          }
          else
          {
            localObject3 = new com.tencent.mm.storage.ad(paramm);
            ((com.tencent.mm.storage.ad)localObject3).cZ(paramString.ffm);
            ((com.tencent.mm.storage.ad)localObject3).setType(paramString.sPr & paramString.sPs);
            label1093:
            long l;
            if (!bk.bl((String)localObject1))
            {
              ((com.tencent.mm.storage.ad)localObject3).dq((String)localObject1);
              if (localObject2 != null) {
                break label1626;
              }
              l = 0L;
              label1101:
              ((com.tencent.mm.storage.ad)localObject3).dBe = l;
              ((com.tencent.mm.storage.ad)localObject3).dk(aa.a(paramString.tmw));
              ((com.tencent.mm.storage.ad)localObject3).dl(aa.a(paramString.sQa));
              ((com.tencent.mm.storage.ad)localObject3).dm(aa.a(paramString.sQb));
              ((com.tencent.mm.storage.ad)localObject3).fm(paramString.ffh);
              ((com.tencent.mm.storage.ad)localObject3).fp(paramString.sPx);
              ((com.tencent.mm.storage.ad)localObject3).dg(aa.a(paramString.tto));
              ((com.tencent.mm.storage.ad)localObject3).fq(paramString.sPB);
              ((com.tencent.mm.storage.ad)localObject3).fr(paramString.ffl);
              ((com.tencent.mm.storage.ad)localObject3).dF(RegionCodeDecoder.ao(paramString.ffq, paramString.ffi, paramString.ffj));
              ((com.tencent.mm.storage.ad)localObject3).dz(paramString.ffk);
              ((com.tencent.mm.storage.ad)localObject3).fi(paramString.tpg);
              ((com.tencent.mm.storage.ad)localObject3).dE(paramString.tph);
              ((com.tencent.mm.storage.ad)localObject3).setSource(paramString.swS);
              ((com.tencent.mm.storage.ad)localObject3).fh(paramString.tpk);
              ((com.tencent.mm.storage.ad)localObject3).dn(paramString.tpj);
              if (s.ia(paramString.tpi)) {
                ((com.tencent.mm.storage.ad)localObject3).dD(paramString.tpi);
              }
              ((com.tencent.mm.storage.ad)localObject3).ft((int)bk.UX());
              ((com.tencent.mm.storage.ad)localObject3).df(aa.a(paramString.tsS));
              ((com.tencent.mm.storage.ad)localObject3).jdMethod_do(aa.a(paramString.tsU));
              ((com.tencent.mm.storage.ad)localObject3).dp(aa.a(paramString.tsT));
              ((com.tencent.mm.storage.ad)localObject3).dG(paramString.sxZ);
              ((com.tencent.mm.storage.ad)localObject3).dH(paramString.ttE);
              if ((localObject2 != null) && (!bk.pm(((ao)localObject2).cCK).equals(bk.pm(paramString.ttE))))
              {
                com.tencent.mm.bb.c.PO();
                com.tencent.mm.bb.c.mM(paramm);
              }
              au.Hx();
              com.tencent.mm.model.c.Fw().abq(paramm);
              if (!bk.bl(((ao)localObject3).field_username)) {
                break label1638;
              }
              y.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "dkinit dealModContactExtInfo failed invalid contact");
              label1418:
              ((com.tencent.mm.storage.ad)localObject3).fk(paramString.ttD);
              if ((paramString.ttz != null) && (paramString.ttz.svV != null))
              {
                ((com.tencent.mm.storage.ad)localObject3).dI(paramString.ttz.svV.sBf);
                ((com.tencent.mm.storage.ad)localObject3).dJ(paramString.ttz.svV.sBg);
                ((com.tencent.mm.storage.ad)localObject3).dK(paramString.ttz.svV.sBh);
              }
              if (s.hU(paramm)) {
                ((com.tencent.mm.storage.ad)localObject3).AQ();
              }
              if (((com.tencent.mm.storage.ad)localObject3).cua()) {
                ((com.tencent.mm.storage.ad)localObject3).AT();
              }
              if (bk.bl((String)localObject1)) {
                break label1968;
              }
              au.Hx();
              com.tencent.mm.model.c.Fw().b((String)localObject1, (com.tencent.mm.storage.ad)localObject3);
            }
            for (;;)
            {
              if ((localObject2 == null) || ((((ao)localObject2).field_type & 0x800) == (((ao)localObject3).field_type & 0x800))) {
                break label1984;
              }
              if ((((ao)localObject3).field_type & 0x800) == 0) {
                break label1986;
              }
              au.Hx();
              com.tencent.mm.model.c.FB().abB(((ao)localObject3).field_username);
              break;
              if ((localObject2 == null) || ((int)((com.tencent.mm.n.a)localObject2).dBe <= 0)) {
                break label1093;
              }
              ((com.tencent.mm.storage.ad)localObject3).dq(((ao)localObject2).field_encryptUsername);
              break label1093;
              label1626:
              l = (int)((com.tencent.mm.n.a)localObject2).dBe;
              break label1101;
              label1638:
              Object localObject4 = ((ao)localObject3).field_username;
              Object localObject5 = com.tencent.mm.ag.b.a((String)localObject4, paramString);
              o.Kh().a((com.tencent.mm.ag.h)localObject5);
              localObject5 = paramString.tpm;
              if ((!((ao)localObject3).field_username.endsWith("@chatroom")) && (localObject5 != null))
              {
                y.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsFlag modcontact " + ((but)localObject5).ffs + " " + paramString.sQs);
                y.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBg modcontact " + ((but)localObject5).fft);
                y.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + ((but)localObject5).ffu);
                y.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + ((but)localObject5).tLp);
                if (n.omD != null) {
                  n.omD.a(((ao)localObject3).field_username, (but)localObject5);
                }
              }
              localObject5 = q.Gj();
              if ((localObject5 == null) || (((String)localObject5).equals(localObject4))) {
                break label1418;
              }
              localObject5 = z.My().kQ((String)localObject4);
              ((com.tencent.mm.ai.d)localObject5).field_username = ((String)localObject4);
              ((com.tencent.mm.ai.d)localObject5).field_brandList = paramString.ffr;
              localObject4 = paramString.tpn;
              if (localObject4 != null)
              {
                ((com.tencent.mm.ai.d)localObject5).field_brandFlag = ((sg)localObject4).ffv;
                ((com.tencent.mm.ai.d)localObject5).field_brandInfo = ((sg)localObject4).ffx;
                ((com.tencent.mm.ai.d)localObject5).field_brandIconURL = ((sg)localObject4).ffy;
                ((com.tencent.mm.ai.d)localObject5).field_extInfo = ((sg)localObject4).ffw;
                ((com.tencent.mm.ai.d)localObject5).field_attrSyncVersion = null;
                ((com.tencent.mm.ai.d)localObject5).field_incrementUpdateTime = 0L;
              }
              if (!z.My().e((com.tencent.mm.ai.d)localObject5)) {
                z.My().d((com.tencent.mm.ai.d)localObject5);
              }
              ((com.tencent.mm.storage.ad)localObject3).fu(((com.tencent.mm.ai.d)localObject5).field_type);
              break label1418;
              label1968:
              au.Hx();
              com.tencent.mm.model.c.Fw().U((com.tencent.mm.storage.ad)localObject3);
            }
            label1984:
            continue;
            label1986:
            au.Hx();
            com.tencent.mm.model.c.FB().abC(((ao)localObject3).field_username);
          }
        }
      }
      au.Hx();
      paramString = com.tencent.mm.model.c.Fw().abl(paramm);
      if (paramString == null) {
        break;
      }
      if (localaoq.cMX != 0)
      {
        y.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to DeviceProfileUI.");
        paramm = this.jwl.bOW.context;
        localObject1 = new Intent(paramm, ExdeviceDeviceProfileUI.class);
        if (!(paramm instanceof Activity)) {
          ((Intent)localObject1).addFlags(268435456);
        }
        ((Intent)localObject1).putExtra("device_id", localaop.hQb);
        ((Intent)localObject1).putExtra("device_type", localaop.syI);
        ((Intent)localObject1).putExtra("device_mac", localaoq.sAE);
        ((Intent)localObject1).putExtra("device_brand_name", localaoq.tkr);
        ((Intent)localObject1).putExtra("device_alias", localaoq.ffm);
        ((Intent)localObject1).putExtra("device_desc", localaoq.tkz);
        ((Intent)localObject1).putExtra("device_title", localaoq.tky);
        ((Intent)localObject1).putExtra("device_icon_url", localaoq.kSy);
        ((Intent)localObject1).putExtra("device_jump_url", localaoq.kRP);
        ((Intent)localObject1).putExtra("bind_ticket", localbnu.sAJ);
        if (ad.aLL().cR(paramString.field_username, localaop.hQb) != null) {}
        for (bool = true;; bool = false)
        {
          ((Intent)localObject1).putExtra("device_has_bound", bool);
          paramm.startActivity((Intent)localObject1);
          return;
        }
      }
      y.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to ContactInfoUI.");
      paramString = new Intent();
      paramString.putExtra("Contact_User", paramm);
      paramString.putExtra("KIsHardDevice", true);
      paramString.putExtra("KHardDeviceBindTicket", localbnu.sAJ);
      paramString.putExtra("device_id", localaop.hQb);
      paramString.putExtra("device_type", localaop.syI);
      com.tencent.mm.plugin.exdevice.a.jsN.d(paramString, this.jwl.bOW.context);
      return;
      paramm = (com.tencent.mm.ah.m)localObject2;
      paramString = (String)localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ab
 * JD-Core Version:    0.7.0.1
 */