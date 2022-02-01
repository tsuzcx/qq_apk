package com.tencent.mm.plugin.exdevice.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.am.e;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.hz;
import com.tencent.mm.g.a.hz.a;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI;
import com.tencent.mm.plugin.sns.c.f;
import com.tencent.mm.plugin.sns.c.o;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.protocal.protobuf.blv;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.cnt;
import com.tencent.mm.protocal.protobuf.cwh;
import com.tencent.mm.protocal.protobuf.cxp;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.di;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ab
  extends com.tencent.mm.sdk.b.c<hz>
  implements g
{
  private ProgressDialog fpP;
  hz oWv;
  
  public ab()
  {
    AppMethodBeat.i(161355);
    this.__eventId = hz.class.getName().hashCode();
    AppMethodBeat.o(161355);
  }
  
  private boolean a(final hz paramhz)
  {
    AppMethodBeat.i(23437);
    if (!(paramhz instanceof hz))
    {
      com.tencent.mm.sdk.platformtools.ad.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mismatched event");
      AppMethodBeat.o(23437);
      return false;
    }
    this.oWv = paramhz;
    paramhz = this.oWv.dlM.result;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "action = %s, key = %s", new Object[] { Integer.valueOf(this.oWv.dlM.actionCode), paramhz });
    if (bt.isNullOrNil(paramhz))
    {
      AppMethodBeat.o(23437);
      return false;
    }
    switch (this.oWv.dlM.actionCode)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23437);
      return false;
      if ((this.oWv.dlM.context == null) || (!(this.oWv.dlM.context instanceof Activity)))
      {
        AppMethodBeat.o(23437);
        return false;
      }
      az.aeS().a(540, this);
      paramhz = new u(paramhz);
      az.aeS().a(paramhz, 0);
      Context localContext = this.oWv.dlM.context;
      this.oWv.dlM.context.getString(2131755906);
      this.fpP = h.c(localContext, this.oWv.dlM.context.getString(2131762836), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(23436);
          az.aeS().a(paramhz);
          if (ab.this.oWv.callback != null)
          {
            ab.this.oWv.dlN.ret = 1;
            ab.this.oWv.callback.run();
          }
          AppMethodBeat.o(23436);
        }
      });
    }
  }
  
  private void bZE()
  {
    AppMethodBeat.i(23439);
    if ((this.oWv != null) && (this.oWv.callback != null))
    {
      this.oWv.dlN.ret = 1;
      this.oWv.callback.run();
    }
    AppMethodBeat.o(23439);
  }
  
  private void stopScan()
  {
    AppMethodBeat.i(23440);
    if ((this.oWv != null) && (this.oWv.callback != null))
    {
      this.oWv.dlN.ret = 2;
      this.oWv.callback.run();
    }
    AppMethodBeat.o(23440);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(23438);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    if ((this.fpP != null) && (this.fpP.isShowing())) {
      this.fpP.dismiss();
    }
    if (paramn == null)
    {
      bZE();
      AppMethodBeat.o(23438);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
      bZE();
      AppMethodBeat.o(23438);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
    cnt localcnt;
    bfj localbfj;
    bfk localbfk;
    Object localObject3;
    Object localObject2;
    if (paramn.getType() == 540)
    {
      az.aeS().b(540, this);
      paramString = (u)paramn;
      if ((paramString.rr != null) && (paramString.rr.gUT.gUX != null)) {}
      for (localcnt = (cnt)paramString.rr.gUT.gUX; localcnt == null; localcnt = null)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp == null");
        bZE();
        AppMethodBeat.o(23438);
        return;
      }
      localbfj = localcnt.CFB;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "deviceId = %s, deviceType = %s", new Object[] { localbfj.mAT, localbfj.CBS });
      localbfk = localcnt.CFC;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "AuthKey = %s, BrandName = %s, CloseStrategy = %s, ConnProto = %s, ConnStrategy = %s, Mac = %s", new Object[] { localbfk.CBj, localbfk.DCD, Integer.valueOf(localbfk.DCG), localbfk.DCE, Integer.valueOf(localbfk.DCF), localbfk.CEQ });
      paramn = "";
      paramString = "";
      localObject3 = new LinkedList();
      localObject2 = paramn;
      localObject1 = paramString;
      if (localcnt.Eid == null) {
        break label2501;
      }
      if (localcnt.Eid.Cyb != null) {
        paramn = localcnt.Eid.Cyb;
      }
      if (localcnt.Eid.title != null) {
        paramString = localcnt.Eid.title;
      }
      localObject2 = paramn;
      localObject1 = paramString;
      if (localcnt.Eid.Cyc == null) {
        break label2501;
      }
    }
    for (Object localObject1 = localcnt.Eid.Cyc;; localObject1 = localObject3)
    {
      localObject2 = new ArrayList();
      if ((localObject1 != null) && (((LinkedList)localObject1).size() > 0))
      {
        paramInt1 = 0;
        while (paramInt1 < ((LinkedList)localObject1).size())
        {
          localObject3 = (cxp)((LinkedList)localObject1).get(paramInt1);
          if (((cxp)localObject3).type.contains("text")) {
            ((ArrayList)localObject2).add(((cxp)localObject3).content);
          }
          paramInt1 += 1;
        }
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp.BindTicket = %s", new Object[] { localcnt.CEV });
      boolean bool;
      if (localcnt.Eic == 1)
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("device_scan_mode", "SCAN_CATALOG");
        if ((localbfk.DCE.contains("3")) || (localbfk.DCE.contains("1"))) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          bool = localbfk.DCE.contains("4");
          if ((paramInt1 == 0) || (!bool)) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Category connect proto can not be blue&wifi at the same time...");
          AppMethodBeat.o(23438);
          return;
        }
        if (paramInt1 != 0) {
          ((Intent)localObject1).putExtra("device_scan_conn_proto", "blue");
        }
        for (;;)
        {
          ((Intent)localObject1).putExtra("device_id", localbfj.mAT);
          ((Intent)localObject1).putExtra("device_type", localbfj.CBS);
          ((Intent)localObject1).putExtra("device_title", localbfk.DCK);
          ((Intent)localObject1).putExtra("device_desc", localbfk.DCL);
          ((Intent)localObject1).putExtra("device_icon_url", localbfk.IconUrl);
          ((Intent)localObject1).putExtra("device_category_id", localbfk.DCM);
          ((Intent)localObject1).putExtra("device_brand_name", localbfk.DCD);
          ((Intent)localObject1).putExtra("bind_ticket", localcnt.CEV);
          ((Intent)localObject1).putExtra("device_ble_simple_proto", localbfk.eKs);
          ((Intent)localObject1).putExtra("device_airkiss_key", paramn);
          ((Intent)localObject1).putExtra("device_airkiss_title", paramString);
          ((Intent)localObject1).putStringArrayListExtra("device_airkiss_steps", (ArrayList)localObject2);
          d.b(this.oWv.dlM.context, "exdevice", ".ui.ExdeviceBindDeviceGuideUI", (Intent)localObject1);
          stopScan();
          AppMethodBeat.o(23438);
          return;
          if (bool) {
            ((Intent)localObject1).putExtra("device_scan_conn_proto", "wifi");
          }
        }
      }
      paramString = localcnt.CEW;
      if (paramString == null)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mContact == null");
        bZE();
        AppMethodBeat.o(23438);
        return;
      }
      stopScan();
      if (paramString == null) {
        com.tencent.mm.sdk.platformtools.ad.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "unable to parse mod contact");
      }
      for (;;)
      {
        paramn = z.a(paramString.Dby);
        if ((this.oWv != null) && (this.oWv.dlM != null) && (this.oWv.dlM.context != null)) {
          break;
        }
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "a8KeyRedirectEvent null");
        AppMethodBeat.o(23438);
        return;
        paramn = z.a(paramString.Dby);
        localObject1 = bt.nullAsNil(paramString.DOt);
        if ((bt.isNullOrNil(paramn)) && (bt.isNullOrNil((String)localObject1)))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact user is null user:%s enuser:%s", new Object[] { paramn, localObject1 });
        }
        else
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact : %s", new Object[] { paramn });
          az.arV();
          localObject2 = com.tencent.mm.model.c.apM().aHY(paramn);
          if ((localObject2 != null) && (paramn.equals(((au)localObject2).field_encryptUsername)))
          {
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "cat's replace user with stranger");
          }
          else
          {
            localObject3 = new com.tencent.mm.storage.af(paramn);
            ((com.tencent.mm.storage.af)localObject3).na(paramString.ijR);
            ((com.tencent.mm.storage.af)localObject3).setType(paramString.Dan & paramString.Dao);
            label1141:
            long l;
            if (!bt.isNullOrNil((String)localObject1))
            {
              ((com.tencent.mm.storage.af)localObject3).nj((String)localObject1);
              if (localObject2 != null) {
                break label1674;
              }
              l = 0L;
              label1149:
              ((com.tencent.mm.storage.af)localObject3).fId = l;
              ((com.tencent.mm.storage.af)localObject3).nd(z.a(paramString.DFJ));
              ((com.tencent.mm.storage.af)localObject3).ne(z.a(paramString.Dbb));
              ((com.tencent.mm.storage.af)localObject3).nf(z.a(paramString.Dbc));
              ((com.tencent.mm.storage.af)localObject3).jJ(paramString.ijM);
              ((com.tencent.mm.storage.af)localObject3).jL(paramString.Dat);
              ((com.tencent.mm.storage.af)localObject3).nc(z.a(paramString.DOn));
              ((com.tencent.mm.storage.af)localObject3).jM(paramString.Dax);
              ((com.tencent.mm.storage.af)localObject3).jN(paramString.ijQ);
              ((com.tencent.mm.storage.af)localObject3).nA(RegionCodeDecoder.aT(paramString.ijV, paramString.ijN, paramString.ijO));
              ((com.tencent.mm.storage.af)localObject3).nu(paramString.ijP);
              ((com.tencent.mm.storage.af)localObject3).jF(paramString.DIV);
              ((com.tencent.mm.storage.af)localObject3).nz(paramString.DIW);
              ((com.tencent.mm.storage.af)localObject3).setSource(paramString.rNz);
              ((com.tencent.mm.storage.af)localObject3).jE(paramString.DIZ);
              ((com.tencent.mm.storage.af)localObject3).ng(paramString.DIY);
              if (w.tu(paramString.DIX)) {
                ((com.tencent.mm.storage.af)localObject3).ny(paramString.DIX);
              }
              ((com.tencent.mm.storage.af)localObject3).jO((int)bt.aGK());
              ((com.tencent.mm.storage.af)localObject3).nb(z.a(paramString.DNT));
              ((com.tencent.mm.storage.af)localObject3).nh(z.a(paramString.DNV));
              ((com.tencent.mm.storage.af)localObject3).ni(z.a(paramString.DNU));
              ((com.tencent.mm.storage.af)localObject3).nB(paramString.Cxw);
              ((com.tencent.mm.storage.af)localObject3).nC(paramString.DOC);
              if ((localObject2 != null) && (!bt.nullAsNil(((au)localObject2).evJ).equals(bt.nullAsNil(paramString.DOC))))
              {
                com.tencent.mm.be.c.aAc();
                com.tencent.mm.be.c.yV(paramn);
              }
              az.arV();
              com.tencent.mm.model.c.apM().aIe(paramn);
              if (!bt.isNullOrNil(((au)localObject3).field_username)) {
                break label1686;
              }
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "dkinit dealModContactExtInfo failed invalid contact");
              label1466:
              ((com.tencent.mm.storage.af)localObject3).jH(paramString.DeleteFlag);
              if ((paramString.DOy != null) && (paramString.DOy.CxP != null))
              {
                ((com.tencent.mm.storage.af)localObject3).nD(paramString.DOy.CxP.CFE);
                ((com.tencent.mm.storage.af)localObject3).nE(paramString.DOy.CxP.CFF);
                ((com.tencent.mm.storage.af)localObject3).nF(paramString.DOy.CxP.CFG);
              }
              if (w.to(paramn)) {
                ((com.tencent.mm.storage.af)localObject3).Zt();
              }
              if (((com.tencent.mm.storage.af)localObject3).eKB()) {
                ((com.tencent.mm.storage.af)localObject3).Zw();
              }
              if (bt.isNullOrNil((String)localObject1)) {
                break label2016;
              }
              az.arV();
              com.tencent.mm.model.c.apM().d((String)localObject1, (com.tencent.mm.storage.af)localObject3);
            }
            for (;;)
            {
              if ((localObject2 == null) || ((((au)localObject2).field_type & 0x800) == (((au)localObject3).field_type & 0x800))) {
                break label2032;
              }
              if ((((au)localObject3).field_type & 0x800) == 0) {
                break label2034;
              }
              az.arV();
              com.tencent.mm.model.c.apR().aIt(((au)localObject3).field_username);
              break;
              if ((localObject2 == null) || ((int)((com.tencent.mm.n.b)localObject2).fId <= 0)) {
                break label1141;
              }
              ((com.tencent.mm.storage.af)localObject3).nj(((au)localObject2).field_encryptUsername);
              break label1141;
              label1674:
              l = (int)((com.tencent.mm.n.b)localObject2).fId;
              break label1149;
              label1686:
              Object localObject4 = ((au)localObject3).field_username;
              Object localObject5 = com.tencent.mm.ak.c.a((String)localObject4, paramString);
              p.auF().b((i)localObject5);
              localObject5 = paramString.DJb;
              if ((!((au)localObject3).field_username.endsWith("@chatroom")) && (localObject5 != null))
              {
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsFlag modcontact " + ((cwh)localObject5).ijX + " " + paramString.Dby);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBg modcontact " + ((cwh)localObject5).ijY);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + ((cwh)localObject5).ijZ);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + ((cwh)localObject5).Eoc);
                if (o.wzH != null) {
                  o.wzH.a(((au)localObject3).field_username, (cwh)localObject5);
                }
              }
              localObject5 = com.tencent.mm.model.u.aqG();
              if ((localObject5 == null) || (((String)localObject5).equals(localObject4))) {
                break label1466;
              }
              localObject5 = com.tencent.mm.am.af.awe().wy((String)localObject4);
              ((com.tencent.mm.api.c)localObject5).field_username = ((String)localObject4);
              ((com.tencent.mm.api.c)localObject5).field_brandList = paramString.ijW;
              localObject4 = paramString.DJc;
              if (localObject4 != null)
              {
                ((com.tencent.mm.api.c)localObject5).field_brandFlag = ((zh)localObject4).ika;
                ((com.tencent.mm.api.c)localObject5).field_brandInfo = ((zh)localObject4).ikc;
                ((com.tencent.mm.api.c)localObject5).field_brandIconURL = ((zh)localObject4).ikd;
                ((com.tencent.mm.api.c)localObject5).field_extInfo = ((zh)localObject4).ikb;
                ((com.tencent.mm.api.c)localObject5).field_attrSyncVersion = null;
                ((com.tencent.mm.api.c)localObject5).field_incrementUpdateTime = 0L;
              }
              if (!com.tencent.mm.am.af.awe().g((com.tencent.mm.api.c)localObject5)) {
                com.tencent.mm.am.af.awe().f((com.tencent.mm.api.c)localObject5);
              }
              ((com.tencent.mm.storage.af)localObject3).jP(((com.tencent.mm.api.c)localObject5).field_type);
              break label1466;
              label2016:
              az.arV();
              com.tencent.mm.model.c.apM().ae((com.tencent.mm.storage.af)localObject3);
            }
            label2032:
            continue;
            label2034:
            az.arV();
            com.tencent.mm.model.c.apR().aIu(((au)localObject3).field_username);
          }
        }
      }
      az.arV();
      paramString = com.tencent.mm.model.c.apM().aHY(paramn);
      if (paramString != null)
      {
        if (localbfk.eKr != 0)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to DeviceProfileUI.");
          paramn = this.oWv.dlM.context;
          localObject1 = new Intent(paramn, ExdeviceDeviceProfileUI.class);
          if (!(paramn instanceof Activity)) {
            ((Intent)localObject1).addFlags(268435456);
          }
          ((Intent)localObject1).putExtra("device_id", localbfj.mAT);
          ((Intent)localObject1).putExtra("device_type", localbfj.CBS);
          ((Intent)localObject1).putExtra("device_mac", localbfk.CEQ);
          ((Intent)localObject1).putExtra("device_brand_name", localbfk.DCD);
          ((Intent)localObject1).putExtra("device_alias", localbfk.ijR);
          ((Intent)localObject1).putExtra("device_desc", localbfk.DCL);
          ((Intent)localObject1).putExtra("device_title", localbfk.DCK);
          ((Intent)localObject1).putExtra("device_icon_url", localbfk.IconUrl);
          ((Intent)localObject1).putExtra("device_jump_url", localbfk.rZo);
          ((Intent)localObject1).putExtra("bind_ticket", localcnt.CEV);
          if (ad.bZG().fi(paramString.field_username, localbfj.mAT) != null) {}
          for (bool = true;; bool = false)
          {
            ((Intent)localObject1).putExtra("device_has_bound", bool);
            paramString = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(paramn, paramString.adn(), "com/tencent/mm/plugin/exdevice/model/SearchDeviceGetA8KeyRedirectListener", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramn.startActivity((Intent)paramString.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramn, "com/tencent/mm/plugin/exdevice/model/SearchDeviceGetA8KeyRedirectListener", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(23438);
            return;
          }
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to ContactInfoUI.");
        paramString = new Intent();
        paramString.putExtra("Contact_User", paramn);
        paramString.putExtra("KIsHardDevice", true);
        paramString.putExtra("KHardDeviceBindTicket", localcnt.CEV);
        paramString.putExtra("device_id", localbfj.mAT);
        paramString.putExtra("device_type", localbfj.CBS);
        com.tencent.mm.plugin.exdevice.a.oSX.c(paramString, this.oWv.dlM.context);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ab
 * JD-Core Version:    0.7.0.1
 */