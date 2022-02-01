package com.tencent.mm.plugin.exdevice.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.ip;
import com.tencent.mm.g.a.ip.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.protocal.protobuf.caj;
import com.tencent.mm.protocal.protobuf.cze;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ab
  extends com.tencent.mm.sdk.b.c<ip>
  implements com.tencent.mm.ak.f
{
  private ProgressDialog fOC;
  ip qjQ;
  
  public ab()
  {
    AppMethodBeat.i(161355);
    this.__eventId = ip.class.getName().hashCode();
    AppMethodBeat.o(161355);
  }
  
  private boolean a(final ip paramip)
  {
    AppMethodBeat.i(23437);
    if (!(paramip instanceof ip))
    {
      ae.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mismatched event");
      AppMethodBeat.o(23437);
      return false;
    }
    this.qjQ = paramip;
    paramip = this.qjQ.dwm.result;
    ae.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "action = %s, key = %s", new Object[] { Integer.valueOf(this.qjQ.dwm.actionCode), paramip });
    if (bu.isNullOrNil(paramip))
    {
      AppMethodBeat.o(23437);
      return false;
    }
    switch (this.qjQ.dwm.actionCode)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23437);
      return false;
      if ((this.qjQ.dwm.context == null) || (!(this.qjQ.dwm.context instanceof Activity)))
      {
        AppMethodBeat.o(23437);
        return false;
      }
      bc.ajj().a(540, this);
      paramip = new u(paramip);
      bc.ajj().a(paramip, 0);
      Context localContext = this.qjQ.dwm.context;
      this.qjQ.dwm.context.getString(2131755906);
      this.fOC = h.c(localContext, this.qjQ.dwm.context.getString(2131762836), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(23436);
          bc.ajj().a(paramip);
          if (ab.this.qjQ.callback != null)
          {
            ab.this.qjQ.dwn.ret = 1;
            ab.this.qjQ.callback.run();
          }
          AppMethodBeat.o(23436);
        }
      });
    }
  }
  
  private void cmH()
  {
    AppMethodBeat.i(23439);
    if ((this.qjQ != null) && (this.qjQ.callback != null))
    {
      this.qjQ.dwn.ret = 1;
      this.qjQ.callback.run();
    }
    AppMethodBeat.o(23439);
  }
  
  private void stopScan()
  {
    AppMethodBeat.i(23440);
    if ((this.qjQ != null) && (this.qjQ.callback != null))
    {
      this.qjQ.dwn.ret = 2;
      this.qjQ.callback.run();
    }
    AppMethodBeat.o(23440);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(23438);
    ae.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    if ((this.fOC != null) && (this.fOC.isShowing())) {
      this.fOC.dismiss();
    }
    if (paramn == null)
    {
      cmH();
      AppMethodBeat.o(23438);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ae.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
      cmH();
      AppMethodBeat.o(23438);
      return;
    }
    ae.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
    cze localcze;
    bob localbob;
    boc localboc;
    Object localObject3;
    Object localObject2;
    if (paramn.getType() == 540)
    {
      bc.ajj().b(540, this);
      paramString = (u)paramn;
      if ((paramString.rr != null) && (paramString.rr.hQE.hQJ != null)) {}
      for (localcze = (cze)paramString.rr.hQE.hQJ; localcze == null; localcze = null)
      {
        ae.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp == null");
        cmH();
        AppMethodBeat.o(23438);
        return;
      }
      localbob = localcze.FVS;
      ae.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "deviceId = %s, deviceType = %s", new Object[] { localbob.nIM, localbob.FSh });
      localboc = localcze.FVT;
      ae.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "AuthKey = %s, BrandName = %s, CloseStrategy = %s, ConnProto = %s, ConnStrategy = %s, Mac = %s", new Object[] { localboc.FRz, localboc.HaX, Integer.valueOf(localboc.Hba), localboc.HaY, Integer.valueOf(localboc.HaZ), localboc.FVh });
      paramn = "";
      paramString = "";
      localObject3 = new LinkedList();
      localObject2 = paramn;
      localObject1 = paramString;
      if (localcze.HJc == null) {
        break label2501;
      }
      if (localcze.HJc.FOk != null) {
        paramn = localcze.HJc.FOk;
      }
      if (localcze.HJc.title != null) {
        paramString = localcze.HJc.title;
      }
      localObject2 = paramn;
      localObject1 = paramString;
      if (localcze.HJc.FOl == null) {
        break label2501;
      }
    }
    for (Object localObject1 = localcze.HJc.FOl;; localObject1 = localObject3)
    {
      localObject2 = new ArrayList();
      if ((localObject1 != null) && (((LinkedList)localObject1).size() > 0))
      {
        paramInt1 = 0;
        while (paramInt1 < ((LinkedList)localObject1).size())
        {
          localObject3 = (djj)((LinkedList)localObject1).get(paramInt1);
          if (((djj)localObject3).type.contains("text")) {
            ((ArrayList)localObject2).add(((djj)localObject3).content);
          }
          paramInt1 += 1;
        }
      }
      ae.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp.BindTicket = %s", new Object[] { localcze.FVm });
      boolean bool;
      if (localcze.HJb == 1)
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("device_scan_mode", "SCAN_CATALOG");
        if ((localboc.HaY.contains("3")) || (localboc.HaY.contains("1"))) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          bool = localboc.HaY.contains("4");
          if ((paramInt1 == 0) || (!bool)) {
            break;
          }
          ae.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Category connect proto can not be blue&wifi at the same time...");
          AppMethodBeat.o(23438);
          return;
        }
        if (paramInt1 != 0) {
          ((Intent)localObject1).putExtra("device_scan_conn_proto", "blue");
        }
        for (;;)
        {
          ((Intent)localObject1).putExtra("device_id", localbob.nIM);
          ((Intent)localObject1).putExtra("device_type", localbob.FSh);
          ((Intent)localObject1).putExtra("device_title", localboc.Hbe);
          ((Intent)localObject1).putExtra("device_desc", localboc.Hbf);
          ((Intent)localObject1).putExtra("device_icon_url", localboc.IconUrl);
          ((Intent)localObject1).putExtra("device_category_id", localboc.Hbg);
          ((Intent)localObject1).putExtra("device_brand_name", localboc.HaX);
          ((Intent)localObject1).putExtra("bind_ticket", localcze.FVm);
          ((Intent)localObject1).putExtra("device_ble_simple_proto", localboc.fhD);
          ((Intent)localObject1).putExtra("device_airkiss_key", paramn);
          ((Intent)localObject1).putExtra("device_airkiss_title", paramString);
          ((Intent)localObject1).putStringArrayListExtra("device_airkiss_steps", (ArrayList)localObject2);
          d.b(this.qjQ.dwm.context, "exdevice", ".ui.ExdeviceBindDeviceGuideUI", (Intent)localObject1);
          stopScan();
          AppMethodBeat.o(23438);
          return;
          if (bool) {
            ((Intent)localObject1).putExtra("device_scan_conn_proto", "wifi");
          }
        }
      }
      paramString = localcze.FVn;
      if (paramString == null)
      {
        ae.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mContact == null");
        cmH();
        AppMethodBeat.o(23438);
        return;
      }
      stopScan();
      if (paramString == null) {
        ae.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "unable to parse mod contact");
      }
      for (;;)
      {
        paramn = z.a(paramString.GuF);
        if ((this.qjQ != null) && (this.qjQ.dwm != null) && (this.qjQ.dwm.context != null)) {
          break;
        }
        ae.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "a8KeyRedirectEvent null");
        AppMethodBeat.o(23438);
        return;
        paramn = z.a(paramString.GuF);
        localObject1 = bu.nullAsNil(paramString.HnT);
        if ((bu.isNullOrNil(paramn)) && (bu.isNullOrNil((String)localObject1)))
        {
          ae.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact user is null user:%s enuser:%s", new Object[] { paramn, localObject1 });
        }
        else
        {
          ae.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact : %s", new Object[] { paramn });
          bc.aCg();
          localObject2 = com.tencent.mm.model.c.azF().BH(paramn);
          if ((localObject2 != null) && (paramn.equals(((aw)localObject2).field_encryptUsername)))
          {
            ae.w("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "cat's replace user with stranger");
          }
          else
          {
            localObject3 = new an(paramn);
            ((an)localObject3).tl(paramString.jga);
            ((an)localObject3).setType(paramString.Gti & paramString.Gtj);
            label1141:
            long l;
            if (!bu.isNullOrNil((String)localObject1))
            {
              ((an)localObject3).tu((String)localObject1);
              if (localObject2 != null) {
                break label1674;
              }
              l = 0L;
              label1149:
              ((an)localObject3).ght = l;
              ((an)localObject3).to(z.a(paramString.Hed));
              ((an)localObject3).tp(z.a(paramString.GtY));
              ((an)localObject3).tq(z.a(paramString.GtZ));
              ((an)localObject3).kh(paramString.jfV);
              ((an)localObject3).kj(paramString.Gto);
              ((an)localObject3).tn(z.a(paramString.HnN));
              ((an)localObject3).kk(paramString.Gts);
              ((an)localObject3).kl(paramString.jfZ);
              ((an)localObject3).tL(RegionCodeDecoder.bg(paramString.jge, paramString.jfW, paramString.jfX));
              ((an)localObject3).tF(paramString.jfY);
              ((an)localObject3).kd(paramString.Hhu);
              ((an)localObject3).tK(paramString.Hhv);
              ((an)localObject3).setSource(paramString.ucK);
              ((an)localObject3).kc(paramString.Hhy);
              ((an)localObject3).tr(paramString.Hhx);
              if (x.Bf(paramString.Hhw)) {
                ((an)localObject3).tJ(paramString.Hhw);
              }
              ((an)localObject3).km((int)bu.aRi());
              ((an)localObject3).tm(z.a(paramString.Hnt));
              ((an)localObject3).ts(z.a(paramString.Hnv));
              ((an)localObject3).tt(z.a(paramString.Hnu));
              ((an)localObject3).tM(paramString.FNF);
              ((an)localObject3).tN(paramString.Hoc);
              if ((localObject2 != null) && (!bu.nullAsNil(((aw)localObject2).eRp).equals(bu.nullAsNil(paramString.Hoc))))
              {
                com.tencent.mm.bd.c.aKw();
                com.tencent.mm.bd.c.GH(paramn);
              }
              bc.aCg();
              com.tencent.mm.model.c.azF().aUR(paramn);
              if (!bu.isNullOrNil(((aw)localObject3).field_username)) {
                break label1686;
              }
              ae.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "dkinit dealModContactExtInfo failed invalid contact");
              label1466:
              ((an)localObject3).kf(paramString.DeleteFlag);
              if ((paramString.HnY != null) && (paramString.HnY.FNY != null))
              {
                ((an)localObject3).tO(paramString.HnY.FNY.FVV);
                ((an)localObject3).tP(paramString.HnY.FNY.FVW);
                ((an)localObject3).tQ(paramString.HnY.FNY.FVX);
              }
              if (x.AZ(paramn)) {
                ((an)localObject3).adb();
              }
              if (((an)localObject3).fug()) {
                ((an)localObject3).adf();
              }
              if (bu.isNullOrNil((String)localObject1)) {
                break label2016;
              }
              bc.aCg();
              com.tencent.mm.model.c.azF().d((String)localObject1, (an)localObject3);
            }
            for (;;)
            {
              if ((localObject2 == null) || ((((aw)localObject2).field_type & 0x800) == (((aw)localObject3).field_type & 0x800))) {
                break label2032;
              }
              if ((((aw)localObject3).field_type & 0x800) == 0) {
                break label2034;
              }
              bc.aCg();
              com.tencent.mm.model.c.azL().aVg(((aw)localObject3).field_username);
              break;
              if ((localObject2 == null) || ((int)((com.tencent.mm.contact.c)localObject2).ght <= 0)) {
                break label1141;
              }
              ((an)localObject3).tu(((aw)localObject2).field_encryptUsername);
              break label1141;
              label1674:
              l = (int)((com.tencent.mm.contact.c)localObject2).ght;
              break label1149;
              label1686:
              Object localObject4 = ((aw)localObject3).field_username;
              Object localObject5 = com.tencent.mm.aj.c.a((String)localObject4, paramString);
              p.aEN().b((i)localObject5);
              localObject5 = paramString.HhA;
              if ((!((aw)localObject3).field_username.endsWith("@chatroom")) && (localObject5 != null))
              {
                ae.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsFlag modcontact " + ((dia)localObject5).jgg + " " + paramString.GuF);
                ae.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBg modcontact " + ((dia)localObject5).jgh);
                ae.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + ((dia)localObject5).jgi);
                ae.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + ((dia)localObject5).HPm);
                if (o.zsw != null) {
                  o.zsw.a(((aw)localObject3).field_username, (dia)localObject5);
                }
              }
              localObject5 = v.aAC();
              if ((localObject5 == null) || (((String)localObject5).equals(localObject4))) {
                break label1466;
              }
              localObject5 = ag.aGp().Ef((String)localObject4);
              ((com.tencent.mm.api.c)localObject5).field_username = ((String)localObject4);
              ((com.tencent.mm.api.c)localObject5).field_brandList = paramString.jgf;
              localObject4 = paramString.HhB;
              if (localObject4 != null)
              {
                ((com.tencent.mm.api.c)localObject5).field_brandFlag = ((aco)localObject4).jgj;
                ((com.tencent.mm.api.c)localObject5).field_brandInfo = ((aco)localObject4).jgl;
                ((com.tencent.mm.api.c)localObject5).field_brandIconURL = ((aco)localObject4).jgm;
                ((com.tencent.mm.api.c)localObject5).field_extInfo = ((aco)localObject4).jgk;
                ((com.tencent.mm.api.c)localObject5).field_attrSyncVersion = null;
                ((com.tencent.mm.api.c)localObject5).field_incrementUpdateTime = 0L;
              }
              if (!ag.aGp().g((com.tencent.mm.api.c)localObject5)) {
                ag.aGp().f((com.tencent.mm.api.c)localObject5);
              }
              ((an)localObject3).kn(((com.tencent.mm.api.c)localObject5).field_type);
              break label1466;
              label2016:
              bc.aCg();
              com.tencent.mm.model.c.azF().am((an)localObject3);
            }
            label2032:
            continue;
            label2034:
            bc.aCg();
            com.tencent.mm.model.c.azL().aVh(((aw)localObject3).field_username);
          }
        }
      }
      bc.aCg();
      paramString = com.tencent.mm.model.c.azF().BH(paramn);
      if (paramString != null)
      {
        if (localboc.fhC != 0)
        {
          ae.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to DeviceProfileUI.");
          paramn = this.qjQ.dwm.context;
          localObject1 = new Intent(paramn, ExdeviceDeviceProfileUI.class);
          if (!(paramn instanceof Activity)) {
            ((Intent)localObject1).addFlags(268435456);
          }
          ((Intent)localObject1).putExtra("device_id", localbob.nIM);
          ((Intent)localObject1).putExtra("device_type", localbob.FSh);
          ((Intent)localObject1).putExtra("device_mac", localboc.FVh);
          ((Intent)localObject1).putExtra("device_brand_name", localboc.HaX);
          ((Intent)localObject1).putExtra("device_alias", localboc.jga);
          ((Intent)localObject1).putExtra("device_desc", localboc.Hbf);
          ((Intent)localObject1).putExtra("device_title", localboc.Hbe);
          ((Intent)localObject1).putExtra("device_icon_url", localboc.IconUrl);
          ((Intent)localObject1).putExtra("device_jump_url", localboc.uqf);
          ((Intent)localObject1).putExtra("bind_ticket", localcze.FVm);
          if (ad.cmJ().fJ(paramString.field_username, localbob.nIM) != null) {}
          for (bool = true;; bool = false)
          {
            ((Intent)localObject1).putExtra("device_has_bound", bool);
            paramString = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(paramn, paramString.ahE(), "com/tencent/mm/plugin/exdevice/model/SearchDeviceGetA8KeyRedirectListener", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramn.startActivity((Intent)paramString.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramn, "com/tencent/mm/plugin/exdevice/model/SearchDeviceGetA8KeyRedirectListener", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(23438);
            return;
          }
        }
        ae.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to ContactInfoUI.");
        paramString = new Intent();
        paramString.putExtra("Contact_User", paramn);
        paramString.putExtra("KIsHardDevice", true);
        paramString.putExtra("KHardDeviceBindTicket", localcze.FVm);
        paramString.putExtra("device_id", localbob.nIM);
        paramString.putExtra("device_type", localbob.FSh);
        com.tencent.mm.plugin.exdevice.a.qgs.c(paramString, this.qjQ.dwm.context);
        AppMethodBeat.o(23438);
        return;
      }
      AppMethodBeat.o(23438);
      return;
      label2501:
      paramn = (n)localObject2;
      paramString = (String)localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ab
 * JD-Core Version:    0.7.0.1
 */