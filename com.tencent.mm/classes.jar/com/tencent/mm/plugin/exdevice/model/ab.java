package com.tencent.mm.plugin.exdevice.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.g.a.hf.a;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.aui;
import com.tencent.mm.protocal.protobuf.baf;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.bxp;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.protocal.protobuf.cgn;
import com.tencent.mm.protocal.protobuf.cw;
import com.tencent.mm.protocal.protobuf.da;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ab
  extends com.tencent.mm.sdk.b.c<hf>
  implements f
{
  private ProgressDialog eeN;
  hf lFK;
  
  public ab()
  {
    AppMethodBeat.i(19368);
    this.__eventId = hf.class.getName().hashCode();
    AppMethodBeat.o(19368);
  }
  
  private boolean a(final hf paramhf)
  {
    AppMethodBeat.i(19369);
    if (!(paramhf instanceof hf))
    {
      com.tencent.mm.sdk.platformtools.ab.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mismatched event");
      AppMethodBeat.o(19369);
      return false;
    }
    this.lFK = paramhf;
    paramhf = this.lFK.cwn.result;
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "action = %s, key = %s", new Object[] { Integer.valueOf(this.lFK.cwn.actionCode), paramhf });
    if (bo.isNullOrNil(paramhf))
    {
      AppMethodBeat.o(19369);
      return false;
    }
    switch (this.lFK.cwn.actionCode)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(19369);
      return false;
      if ((this.lFK.cwn.context == null) || (!(this.lFK.cwn.context instanceof Activity)))
      {
        AppMethodBeat.o(19369);
        return false;
      }
      aw.Rc().a(540, this);
      paramhf = new u(paramhf);
      aw.Rc().a(paramhf, 0);
      Context localContext = this.lFK.cwn.context;
      this.lFK.cwn.context.getString(2131297087);
      this.eeN = com.tencent.mm.ui.base.h.b(localContext, this.lFK.cwn.context.getString(2131302913), new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(19367);
          aw.Rc().a(paramhf);
          if (ab.this.lFK.callback != null)
          {
            ab.this.lFK.cwo.ret = 1;
            ab.this.lFK.callback.run();
          }
          AppMethodBeat.o(19367);
        }
      });
    }
  }
  
  private void bpW()
  {
    AppMethodBeat.i(19371);
    if ((this.lFK != null) && (this.lFK.callback != null))
    {
      this.lFK.cwo.ret = 1;
      this.lFK.callback.run();
    }
    AppMethodBeat.o(19371);
  }
  
  private void stopScan()
  {
    AppMethodBeat.i(19372);
    if ((this.lFK != null) && (this.lFK.callback != null))
    {
      this.lFK.cwo.ret = 2;
      this.lFK.callback.run();
    }
    AppMethodBeat.o(19372);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(19370);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    if ((this.eeN != null) && (this.eeN.isShowing())) {
      this.eeN.dismiss();
    }
    if (paramm == null)
    {
      bpW();
      AppMethodBeat.o(19370);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", new Object[] { Integer.valueOf(paramm.getType()) });
      bpW();
      AppMethodBeat.o(19370);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", new Object[] { Integer.valueOf(paramm.getType()) });
    bxp localbxp;
    auh localauh;
    aui localaui;
    Object localObject3;
    Object localObject2;
    if (paramm.getType() == 540)
    {
      aw.Rc().b(540, this);
      paramString = (u)paramm;
      if ((paramString.rr != null) && (paramString.rr.fsW.fta != null)) {}
      for (localbxp = (bxp)paramString.rr.fsW.fta; localbxp == null; localbxp = null)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp == null");
        bpW();
        AppMethodBeat.o(19370);
        return;
      }
      localauh = localbxp.wvw;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "deviceId = %s, deviceType = %s", new Object[] { localauh.jJD, localauh.wsq });
      localaui = localbxp.wvx;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "AuthKey = %s, BrandName = %s, CloseStrategy = %s, ConnProto = %s, ConnStrategy = %s, Mac = %s", new Object[] { localaui.wrS, localaui.xji, Integer.valueOf(localaui.xjl), localaui.xjj, Integer.valueOf(localaui.xjk), localaui.wuT });
      paramm = "";
      paramString = "";
      localObject3 = new LinkedList();
      localObject2 = paramm;
      localObject1 = paramString;
      if (localbxp.xKs == null) {
        break label2432;
      }
      if (localbxp.xKs.wpv != null) {
        paramm = localbxp.xKs.wpv;
      }
      if (localbxp.xKs.title != null) {
        paramString = localbxp.xKs.title;
      }
      localObject2 = paramm;
      localObject1 = paramString;
      if (localbxp.xKs.wpw == null) {
        break label2432;
      }
    }
    for (Object localObject1 = localbxp.xKs.wpw;; localObject1 = localObject3)
    {
      localObject2 = new ArrayList();
      if ((localObject1 != null) && (((LinkedList)localObject1).size() > 0))
      {
        paramInt1 = 0;
        while (paramInt1 < ((LinkedList)localObject1).size())
        {
          localObject3 = (cgn)((LinkedList)localObject1).get(paramInt1);
          if (((cgn)localObject3).type.contains("text")) {
            ((ArrayList)localObject2).add(((cgn)localObject3).content);
          }
          paramInt1 += 1;
        }
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp.BindTicket = %s", new Object[] { localbxp.wuY });
      boolean bool;
      if (localbxp.xKr == 1)
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("device_scan_mode", "SCAN_CATALOG");
        if ((localaui.xjj.contains("3")) || (localaui.xjj.contains("1"))) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          bool = localaui.xjj.contains("4");
          if ((paramInt1 == 0) || (!bool)) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Category connect proto can not be blue&wifi at the same time...");
          AppMethodBeat.o(19370);
          return;
        }
        if (paramInt1 != 0) {
          ((Intent)localObject1).putExtra("device_scan_conn_proto", "blue");
        }
        for (;;)
        {
          ((Intent)localObject1).putExtra("device_id", localauh.jJD);
          ((Intent)localObject1).putExtra("device_type", localauh.wsq);
          ((Intent)localObject1).putExtra("device_title", localaui.xjp);
          ((Intent)localObject1).putExtra("device_desc", localaui.xjq);
          ((Intent)localObject1).putExtra("device_icon_url", localaui.IconUrl);
          ((Intent)localObject1).putExtra("device_category_id", localaui.xjr);
          ((Intent)localObject1).putExtra("device_brand_name", localaui.xji);
          ((Intent)localObject1).putExtra("bind_ticket", localbxp.wuY);
          ((Intent)localObject1).putExtra("device_ble_simple_proto", localaui.dCO);
          ((Intent)localObject1).putExtra("device_airkiss_key", paramm);
          ((Intent)localObject1).putExtra("device_airkiss_title", paramString);
          ((Intent)localObject1).putStringArrayListExtra("device_airkiss_steps", (ArrayList)localObject2);
          com.tencent.mm.bq.d.b(this.lFK.cwn.context, "exdevice", ".ui.ExdeviceBindDeviceGuideUI", (Intent)localObject1);
          stopScan();
          AppMethodBeat.o(19370);
          return;
          if (bool) {
            ((Intent)localObject1).putExtra("device_scan_conn_proto", "wifi");
          }
        }
      }
      paramString = localbxp.wuZ;
      if (paramString == null)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mContact == null");
        bpW();
        AppMethodBeat.o(19370);
        return;
      }
      stopScan();
      if (paramString == null) {
        com.tencent.mm.sdk.platformtools.ab.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "unable to parse mod contact");
      }
      for (;;)
      {
        paramm = aa.a(paramString.wOT);
        if ((this.lFK != null) && (this.lFK.cwn != null) && (this.lFK.cwn.context != null)) {
          break;
        }
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "a8KeyRedirectEvent null");
        AppMethodBeat.o(19370);
        return;
        paramm = aa.a(paramString.wOT);
        localObject1 = bo.nullAsNil(paramString.xtu);
        if ((bo.isNullOrNil(paramm)) && (bo.isNullOrNil((String)localObject1)))
        {
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact user is null user:%s enuser:%s", new Object[] { paramm, localObject1 });
        }
        else
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact : %s", new Object[] { paramm });
          aw.aaz();
          localObject2 = com.tencent.mm.model.c.YA().arw(paramm);
          if ((localObject2 != null) && (paramm.equals(((aq)localObject2).field_encryptUsername)))
          {
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "cat's replace user with stranger");
          }
          else
          {
            localObject3 = new com.tencent.mm.storage.ad(paramm);
            ((com.tencent.mm.storage.ad)localObject3).jm(paramString.gwU);
            ((com.tencent.mm.storage.ad)localObject3).setType(paramString.wNK & paramString.wNL);
            label1141:
            long l;
            if (!bo.isNullOrNil((String)localObject1))
            {
              ((com.tencent.mm.storage.ad)localObject3).jv((String)localObject1);
              if (localObject2 != null) {
                break label1674;
              }
              l = 0L;
              label1149:
              ((com.tencent.mm.storage.ad)localObject3).euF = l;
              ((com.tencent.mm.storage.ad)localObject3).jp(aa.a(paramString.xmi));
              ((com.tencent.mm.storage.ad)localObject3).jq(aa.a(paramString.wOv));
              ((com.tencent.mm.storage.ad)localObject3).jr(aa.a(paramString.wOw));
              ((com.tencent.mm.storage.ad)localObject3).hy(paramString.gwP);
              ((com.tencent.mm.storage.ad)localObject3).hA(paramString.wNQ);
              ((com.tencent.mm.storage.ad)localObject3).jo(aa.a(paramString.xto));
              ((com.tencent.mm.storage.ad)localObject3).hB(paramString.wNU);
              ((com.tencent.mm.storage.ad)localObject3).hC(paramString.gwT);
              ((com.tencent.mm.storage.ad)localObject3).jL(RegionCodeDecoder.aF(paramString.gwY, paramString.gwQ, paramString.gwR));
              ((com.tencent.mm.storage.ad)localObject3).jF(paramString.gwS);
              ((com.tencent.mm.storage.ad)localObject3).hu(paramString.xpe);
              ((com.tencent.mm.storage.ad)localObject3).jK(paramString.xpf);
              ((com.tencent.mm.storage.ad)localObject3).setSource(paramString.niK);
              ((com.tencent.mm.storage.ad)localObject3).ht(paramString.xpi);
              ((com.tencent.mm.storage.ad)localObject3).js(paramString.xph);
              if (t.oJ(paramString.xpg)) {
                ((com.tencent.mm.storage.ad)localObject3).jJ(paramString.xpg);
              }
              ((com.tencent.mm.storage.ad)localObject3).hE((int)bo.aox());
              ((com.tencent.mm.storage.ad)localObject3).jn(aa.a(paramString.xsT));
              ((com.tencent.mm.storage.ad)localObject3).jt(aa.a(paramString.xsV));
              ((com.tencent.mm.storage.ad)localObject3).ju(aa.a(paramString.xsU));
              ((com.tencent.mm.storage.ad)localObject3).jM(paramString.woO);
              ((com.tencent.mm.storage.ad)localObject3).jN(paramString.xtD);
              if ((localObject2 != null) && (!bo.nullAsNil(((aq)localObject2).dqU).equals(bo.nullAsNil(paramString.xtD))))
              {
                com.tencent.mm.bc.c.aiT();
                com.tencent.mm.bc.c.tW(paramm);
              }
              aw.aaz();
              com.tencent.mm.model.c.YA().arB(paramm);
              if (!bo.isNullOrNil(((aq)localObject3).field_username)) {
                break label1686;
              }
              com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "dkinit dealModContactExtInfo failed invalid contact");
              label1466:
              ((com.tencent.mm.storage.ad)localObject3).hw(paramString.DeleteFlag);
              if ((paramString.xtz != null) && (paramString.xtz.wpi != null))
              {
                ((com.tencent.mm.storage.ad)localObject3).jO(paramString.xtz.wpi.wvz);
                ((com.tencent.mm.storage.ad)localObject3).jP(paramString.xtz.wpi.wvA);
                ((com.tencent.mm.storage.ad)localObject3).jQ(paramString.xtz.wpi.wvB);
              }
              if (t.oD(paramm)) {
                ((com.tencent.mm.storage.ad)localObject3).NG();
              }
              if (((com.tencent.mm.storage.ad)localObject3).dwz()) {
                ((com.tencent.mm.storage.ad)localObject3).NJ();
              }
              if (bo.isNullOrNil((String)localObject1)) {
                break label2016;
              }
              aw.aaz();
              com.tencent.mm.model.c.YA().c((String)localObject1, (com.tencent.mm.storage.ad)localObject3);
            }
            for (;;)
            {
              if ((localObject2 == null) || ((((aq)localObject2).field_type & 0x800) == (((aq)localObject3).field_type & 0x800))) {
                break label2032;
              }
              if ((((aq)localObject3).field_type & 0x800) == 0) {
                break label2034;
              }
              aw.aaz();
              com.tencent.mm.model.c.YF().arN(((aq)localObject3).field_username);
              break;
              if ((localObject2 == null) || ((int)((com.tencent.mm.n.a)localObject2).euF <= 0)) {
                break label1141;
              }
              ((com.tencent.mm.storage.ad)localObject3).jv(((aq)localObject2).field_encryptUsername);
              break label1141;
              label1674:
              l = (int)((com.tencent.mm.n.a)localObject2).euF;
              break label1149;
              label1686:
              Object localObject4 = ((aq)localObject3).field_username;
              Object localObject5 = com.tencent.mm.ah.b.a((String)localObject4, paramString);
              o.adg().b((com.tencent.mm.ah.h)localObject5);
              localObject5 = paramString.xpk;
              if ((!((aq)localObject3).field_username.endsWith("@chatroom")) && (localObject5 != null))
              {
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsFlag modcontact " + ((cfj)localObject5).gxa + " " + paramString.wOT);
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBg modcontact " + ((cfj)localObject5).gxb);
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + ((cfj)localObject5).gxc);
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + ((cfj)localObject5).xPN);
                if (com.tencent.mm.plugin.sns.b.n.raR != null) {
                  com.tencent.mm.plugin.sns.b.n.raR.a(((aq)localObject3).field_username, (cfj)localObject5);
                }
              }
              localObject5 = r.Zn();
              if ((localObject5 == null) || (((String)localObject5).equals(localObject4))) {
                break label1466;
              }
              localObject5 = z.afi().rK((String)localObject4);
              ((com.tencent.mm.aj.d)localObject5).field_username = ((String)localObject4);
              ((com.tencent.mm.aj.d)localObject5).field_brandList = paramString.gwZ;
              localObject4 = paramString.xpl;
              if (localObject4 != null)
              {
                ((com.tencent.mm.aj.d)localObject5).field_brandFlag = ((wc)localObject4).gxd;
                ((com.tencent.mm.aj.d)localObject5).field_brandInfo = ((wc)localObject4).gxf;
                ((com.tencent.mm.aj.d)localObject5).field_brandIconURL = ((wc)localObject4).gxg;
                ((com.tencent.mm.aj.d)localObject5).field_extInfo = ((wc)localObject4).gxe;
                ((com.tencent.mm.aj.d)localObject5).field_attrSyncVersion = null;
                ((com.tencent.mm.aj.d)localObject5).field_incrementUpdateTime = 0L;
              }
              if (!z.afi().e((com.tencent.mm.aj.d)localObject5)) {
                z.afi().d((com.tencent.mm.aj.d)localObject5);
              }
              ((com.tencent.mm.storage.ad)localObject3).hF(((com.tencent.mm.aj.d)localObject5).field_type);
              break label1466;
              label2016:
              aw.aaz();
              com.tencent.mm.model.c.YA().X((com.tencent.mm.storage.ad)localObject3);
            }
            label2032:
            continue;
            label2034:
            aw.aaz();
            com.tencent.mm.model.c.YF().arO(((aq)localObject3).field_username);
          }
        }
      }
      aw.aaz();
      paramString = com.tencent.mm.model.c.YA().arw(paramm);
      if (paramString != null)
      {
        if (localaui.dCN != 0)
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to DeviceProfileUI.");
          paramm = this.lFK.cwn.context;
          localObject1 = new Intent(paramm, ExdeviceDeviceProfileUI.class);
          if (!(paramm instanceof Activity)) {
            ((Intent)localObject1).addFlags(268435456);
          }
          ((Intent)localObject1).putExtra("device_id", localauh.jJD);
          ((Intent)localObject1).putExtra("device_type", localauh.wsq);
          ((Intent)localObject1).putExtra("device_mac", localaui.wuT);
          ((Intent)localObject1).putExtra("device_brand_name", localaui.xji);
          ((Intent)localObject1).putExtra("device_alias", localaui.gwU);
          ((Intent)localObject1).putExtra("device_desc", localaui.xjq);
          ((Intent)localObject1).putExtra("device_title", localaui.xjp);
          ((Intent)localObject1).putExtra("device_icon_url", localaui.IconUrl);
          ((Intent)localObject1).putExtra("device_jump_url", localaui.npR);
          ((Intent)localObject1).putExtra("bind_ticket", localbxp.wuY);
          if (ad.bpY().dV(paramString.field_username, localauh.jJD) != null) {}
          for (bool = true;; bool = false)
          {
            ((Intent)localObject1).putExtra("device_has_bound", bool);
            paramm.startActivity((Intent)localObject1);
            AppMethodBeat.o(19370);
            return;
          }
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to ContactInfoUI.");
        paramString = new Intent();
        paramString.putExtra("Contact_User", paramm);
        paramString.putExtra("KIsHardDevice", true);
        paramString.putExtra("KHardDeviceBindTicket", localbxp.wuY);
        paramString.putExtra("device_id", localauh.jJD);
        paramString.putExtra("device_type", localauh.wsq);
        com.tencent.mm.plugin.exdevice.a.lCn.c(paramString, this.lFK.cwn.context);
        AppMethodBeat.o(19370);
        return;
      }
      AppMethodBeat.o(19370);
      return;
      label2432:
      paramm = (m)localObject2;
      paramString = (String)localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ab
 * JD-Core Version:    0.7.0.1
 */