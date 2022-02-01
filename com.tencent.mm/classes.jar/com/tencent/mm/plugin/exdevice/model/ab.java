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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.am.ag;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.io;
import com.tencent.mm.g.a.io.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.bnj;
import com.tencent.mm.protocal.protobuf.bnk;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.protocal.protobuf.cyk;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ab
  extends com.tencent.mm.sdk.b.c<io>
  implements com.tencent.mm.al.f
{
  private ProgressDialog fMu;
  io qdl;
  
  public ab()
  {
    AppMethodBeat.i(161355);
    this.__eventId = io.class.getName().hashCode();
    AppMethodBeat.o(161355);
  }
  
  private boolean a(final io paramio)
  {
    AppMethodBeat.i(23437);
    if (!(paramio instanceof io))
    {
      com.tencent.mm.sdk.platformtools.ad.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mismatched event");
      AppMethodBeat.o(23437);
      return false;
    }
    this.qdl = paramio;
    paramio = this.qdl.dvh.result;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "action = %s, key = %s", new Object[] { Integer.valueOf(this.qdl.dvh.actionCode), paramio });
    if (bt.isNullOrNil(paramio))
    {
      AppMethodBeat.o(23437);
      return false;
    }
    switch (this.qdl.dvh.actionCode)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23437);
      return false;
      if ((this.qdl.dvh.context == null) || (!(this.qdl.dvh.context instanceof Activity)))
      {
        AppMethodBeat.o(23437);
        return false;
      }
      ba.aiU().a(540, this);
      paramio = new u(paramio);
      ba.aiU().a(paramio, 0);
      Context localContext = this.qdl.dvh.context;
      this.qdl.dvh.context.getString(2131755906);
      this.fMu = h.c(localContext, this.qdl.dvh.context.getString(2131762836), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(23436);
          ba.aiU().a(paramio);
          if (ab.this.qdl.callback != null)
          {
            ab.this.qdl.dvi.ret = 1;
            ab.this.qdl.callback.run();
          }
          AppMethodBeat.o(23436);
        }
      });
    }
  }
  
  private void clr()
  {
    AppMethodBeat.i(23439);
    if ((this.qdl != null) && (this.qdl.callback != null))
    {
      this.qdl.dvi.ret = 1;
      this.qdl.callback.run();
    }
    AppMethodBeat.o(23439);
  }
  
  private void stopScan()
  {
    AppMethodBeat.i(23440);
    if ((this.qdl != null) && (this.qdl.callback != null))
    {
      this.qdl.dvi.ret = 2;
      this.qdl.callback.run();
    }
    AppMethodBeat.o(23440);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(23438);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    if ((this.fMu != null) && (this.fMu.isShowing())) {
      this.fMu.dismiss();
    }
    if (paramn == null)
    {
      clr();
      AppMethodBeat.o(23438);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
      clr();
      AppMethodBeat.o(23438);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
    cyk localcyk;
    bnj localbnj;
    bnk localbnk;
    Object localObject3;
    Object localObject2;
    if (paramn.getType() == 540)
    {
      ba.aiU().b(540, this);
      paramString = (u)paramn;
      if ((paramString.rr != null) && (paramString.rr.hNL.hNQ != null)) {}
      for (localcyk = (cyk)paramString.rr.hNL.hNQ; localcyk == null; localcyk = null)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp == null");
        clr();
        AppMethodBeat.o(23438);
        return;
      }
      localbnj = localcyk.FDx;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "deviceId = %s, deviceType = %s", new Object[] { localbnj.nDr, localbnj.FzJ });
      localbnk = localcyk.FDy;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "AuthKey = %s, BrandName = %s, CloseStrategy = %s, ConnProto = %s, ConnStrategy = %s, Mac = %s", new Object[] { localbnk.Fzb, localbnk.GHv, Integer.valueOf(localbnk.GHy), localbnk.GHw, Integer.valueOf(localbnk.GHx), localbnk.FCM });
      paramn = "";
      paramString = "";
      localObject3 = new LinkedList();
      localObject2 = paramn;
      localObject1 = paramString;
      if (localcyk.HpA == null) {
        break label2501;
      }
      if (localcyk.HpA.FvM != null) {
        paramn = localcyk.HpA.FvM;
      }
      if (localcyk.HpA.title != null) {
        paramString = localcyk.HpA.title;
      }
      localObject2 = paramn;
      localObject1 = paramString;
      if (localcyk.HpA.FvN == null) {
        break label2501;
      }
    }
    for (Object localObject1 = localcyk.HpA.FvN;; localObject1 = localObject3)
    {
      localObject2 = new ArrayList();
      if ((localObject1 != null) && (((LinkedList)localObject1).size() > 0))
      {
        paramInt1 = 0;
        while (paramInt1 < ((LinkedList)localObject1).size())
        {
          localObject3 = (dio)((LinkedList)localObject1).get(paramInt1);
          if (((dio)localObject3).type.contains("text")) {
            ((ArrayList)localObject2).add(((dio)localObject3).content);
          }
          paramInt1 += 1;
        }
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp.BindTicket = %s", new Object[] { localcyk.FCR });
      boolean bool;
      if (localcyk.Hpz == 1)
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("device_scan_mode", "SCAN_CATALOG");
        if ((localbnk.GHw.contains("3")) || (localbnk.GHw.contains("1"))) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          bool = localbnk.GHw.contains("4");
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
          ((Intent)localObject1).putExtra("device_id", localbnj.nDr);
          ((Intent)localObject1).putExtra("device_type", localbnj.FzJ);
          ((Intent)localObject1).putExtra("device_title", localbnk.GHC);
          ((Intent)localObject1).putExtra("device_desc", localbnk.GHD);
          ((Intent)localObject1).putExtra("device_icon_url", localbnk.IconUrl);
          ((Intent)localObject1).putExtra("device_category_id", localbnk.GHE);
          ((Intent)localObject1).putExtra("device_brand_name", localbnk.GHv);
          ((Intent)localObject1).putExtra("bind_ticket", localcyk.FCR);
          ((Intent)localObject1).putExtra("device_ble_simple_proto", localbnk.ffG);
          ((Intent)localObject1).putExtra("device_airkiss_key", paramn);
          ((Intent)localObject1).putExtra("device_airkiss_title", paramString);
          ((Intent)localObject1).putStringArrayListExtra("device_airkiss_steps", (ArrayList)localObject2);
          d.b(this.qdl.dvh.context, "exdevice", ".ui.ExdeviceBindDeviceGuideUI", (Intent)localObject1);
          stopScan();
          AppMethodBeat.o(23438);
          return;
          if (bool) {
            ((Intent)localObject1).putExtra("device_scan_conn_proto", "wifi");
          }
        }
      }
      paramString = localcyk.FCS;
      if (paramString == null)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mContact == null");
        clr();
        AppMethodBeat.o(23438);
        return;
      }
      stopScan();
      if (paramString == null) {
        com.tencent.mm.sdk.platformtools.ad.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "unable to parse mod contact");
      }
      for (;;)
      {
        paramn = z.a(paramString.GbY);
        if ((this.qdl != null) && (this.qdl.dvh != null) && (this.qdl.dvh.context != null)) {
          break;
        }
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "a8KeyRedirectEvent null");
        AppMethodBeat.o(23438);
        return;
        paramn = z.a(paramString.GbY);
        localObject1 = bt.nullAsNil(paramString.GUs);
        if ((bt.isNullOrNil(paramn)) && (bt.isNullOrNil((String)localObject1)))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact user is null user:%s enuser:%s", new Object[] { paramn, localObject1 });
        }
        else
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact : %s", new Object[] { paramn });
          ba.aBQ();
          localObject2 = com.tencent.mm.model.c.azp().Bf(paramn);
          if ((localObject2 != null) && (paramn.equals(((aw)localObject2).field_encryptUsername)))
          {
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "cat's replace user with stranger");
          }
          else
          {
            localObject3 = new am(paramn);
            ((am)localObject3).sQ(paramString.jdh);
            ((am)localObject3).setType(paramString.GaB & paramString.GaC);
            label1141:
            long l;
            if (!bt.isNullOrNil((String)localObject1))
            {
              ((am)localObject3).sZ((String)localObject1);
              if (localObject2 != null) {
                break label1674;
              }
              l = 0L;
              label1149:
              ((am)localObject3).gfj = l;
              ((am)localObject3).sT(z.a(paramString.GKC));
              ((am)localObject3).sU(z.a(paramString.Gbr));
              ((am)localObject3).sV(z.a(paramString.Gbs));
              ((am)localObject3).kf(paramString.jdc);
              ((am)localObject3).kh(paramString.GaH);
              ((am)localObject3).sS(z.a(paramString.GUm));
              ((am)localObject3).ki(paramString.GaL);
              ((am)localObject3).kj(paramString.jdg);
              ((am)localObject3).tq(RegionCodeDecoder.bf(paramString.jdl, paramString.jdd, paramString.jde));
              ((am)localObject3).tk(paramString.jdf);
              ((am)localObject3).kb(paramString.GNU);
              ((am)localObject3).tp(paramString.GNV);
              ((am)localObject3).setSource(paramString.tRT);
              ((am)localObject3).ka(paramString.GNY);
              ((am)localObject3).sW(paramString.GNX);
              if (w.Av(paramString.GNW)) {
                ((am)localObject3).to(paramString.GNW);
              }
              ((am)localObject3).kk((int)bt.aQJ());
              ((am)localObject3).sR(z.a(paramString.GTS));
              ((am)localObject3).sX(z.a(paramString.GTU));
              ((am)localObject3).sY(z.a(paramString.GTT));
              ((am)localObject3).tr(paramString.Fvh);
              ((am)localObject3).ts(paramString.GUB);
              if ((localObject2 != null) && (!bt.nullAsNil(((aw)localObject2).ePE).equals(bt.nullAsNil(paramString.GUB))))
              {
                com.tencent.mm.be.c.aKd();
                com.tencent.mm.be.c.Gf(paramn);
              }
              ba.aBQ();
              com.tencent.mm.model.c.azp().aTq(paramn);
              if (!bt.isNullOrNil(((aw)localObject3).field_username)) {
                break label1686;
              }
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "dkinit dealModContactExtInfo failed invalid contact");
              label1466:
              ((am)localObject3).kd(paramString.DeleteFlag);
              if ((paramString.GUx != null) && (paramString.GUx.FvA != null))
              {
                ((am)localObject3).tt(paramString.GUx.FvA.FDA);
                ((am)localObject3).tu(paramString.GUx.FvA.FDB);
                ((am)localObject3).tv(paramString.GUx.FvA.FDC);
              }
              if (w.Ap(paramn)) {
                ((am)localObject3).acQ();
              }
              if (((am)localObject3).fqg()) {
                ((am)localObject3).acT();
              }
              if (bt.isNullOrNil((String)localObject1)) {
                break label2016;
              }
              ba.aBQ();
              com.tencent.mm.model.c.azp().d((String)localObject1, (am)localObject3);
            }
            for (;;)
            {
              if ((localObject2 == null) || ((((aw)localObject2).field_type & 0x800) == (((aw)localObject3).field_type & 0x800))) {
                break label2032;
              }
              if ((((aw)localObject3).field_type & 0x800) == 0) {
                break label2034;
              }
              ba.aBQ();
              com.tencent.mm.model.c.azv().aTF(((aw)localObject3).field_username);
              break;
              if ((localObject2 == null) || ((int)((com.tencent.mm.o.b)localObject2).gfj <= 0)) {
                break label1141;
              }
              ((am)localObject3).sZ(((aw)localObject2).field_encryptUsername);
              break label1141;
              label1674:
              l = (int)((com.tencent.mm.o.b)localObject2).gfj;
              break label1149;
              label1686:
              Object localObject4 = ((aw)localObject3).field_username;
              Object localObject5 = com.tencent.mm.ak.c.a((String)localObject4, paramString);
              p.aEx().b((i)localObject5);
              localObject5 = paramString.GOa;
              if ((!((aw)localObject3).field_username.endsWith("@chatroom")) && (localObject5 != null))
              {
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsFlag modcontact " + ((dhg)localObject5).jdn + " " + paramString.GbY);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBg modcontact " + ((dhg)localObject5).jdo);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + ((dhg)localObject5).jdp);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + ((dhg)localObject5).HvJ);
                if (o.zbT != null) {
                  o.zbT.a(((aw)localObject3).field_username, (dhg)localObject5);
                }
              }
              localObject5 = com.tencent.mm.model.u.aAm();
              if ((localObject5 == null) || (((String)localObject5).equals(localObject4))) {
                break label1466;
              }
              localObject5 = ag.aFZ().DD((String)localObject4);
              ((com.tencent.mm.api.c)localObject5).field_username = ((String)localObject4);
              ((com.tencent.mm.api.c)localObject5).field_brandList = paramString.jdm;
              localObject4 = paramString.GOb;
              if (localObject4 != null)
              {
                ((com.tencent.mm.api.c)localObject5).field_brandFlag = ((acf)localObject4).jdq;
                ((com.tencent.mm.api.c)localObject5).field_brandInfo = ((acf)localObject4).jds;
                ((com.tencent.mm.api.c)localObject5).field_brandIconURL = ((acf)localObject4).jdt;
                ((com.tencent.mm.api.c)localObject5).field_extInfo = ((acf)localObject4).jdr;
                ((com.tencent.mm.api.c)localObject5).field_attrSyncVersion = null;
                ((com.tencent.mm.api.c)localObject5).field_incrementUpdateTime = 0L;
              }
              if (!ag.aFZ().g((com.tencent.mm.api.c)localObject5)) {
                ag.aFZ().f((com.tencent.mm.api.c)localObject5);
              }
              ((am)localObject3).kl(((com.tencent.mm.api.c)localObject5).field_type);
              break label1466;
              label2016:
              ba.aBQ();
              com.tencent.mm.model.c.azp().af((am)localObject3);
            }
            label2032:
            continue;
            label2034:
            ba.aBQ();
            com.tencent.mm.model.c.azv().aTG(((aw)localObject3).field_username);
          }
        }
      }
      ba.aBQ();
      paramString = com.tencent.mm.model.c.azp().Bf(paramn);
      if (paramString != null)
      {
        if (localbnk.ffF != 0)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to DeviceProfileUI.");
          paramn = this.qdl.dvh.context;
          localObject1 = new Intent(paramn, ExdeviceDeviceProfileUI.class);
          if (!(paramn instanceof Activity)) {
            ((Intent)localObject1).addFlags(268435456);
          }
          ((Intent)localObject1).putExtra("device_id", localbnj.nDr);
          ((Intent)localObject1).putExtra("device_type", localbnj.FzJ);
          ((Intent)localObject1).putExtra("device_mac", localbnk.FCM);
          ((Intent)localObject1).putExtra("device_brand_name", localbnk.GHv);
          ((Intent)localObject1).putExtra("device_alias", localbnk.jdh);
          ((Intent)localObject1).putExtra("device_desc", localbnk.GHD);
          ((Intent)localObject1).putExtra("device_title", localbnk.GHC);
          ((Intent)localObject1).putExtra("device_icon_url", localbnk.IconUrl);
          ((Intent)localObject1).putExtra("device_jump_url", localbnk.ueY);
          ((Intent)localObject1).putExtra("bind_ticket", localcyk.FCR);
          if (ad.clt().fF(paramString.field_username, localbnj.nDr) != null) {}
          for (bool = true;; bool = false)
          {
            ((Intent)localObject1).putExtra("device_has_bound", bool);
            paramString = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(paramn, paramString.ahp(), "com/tencent/mm/plugin/exdevice/model/SearchDeviceGetA8KeyRedirectListener", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramn.startActivity((Intent)paramString.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramn, "com/tencent/mm/plugin/exdevice/model/SearchDeviceGetA8KeyRedirectListener", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(23438);
            return;
          }
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to ContactInfoUI.");
        paramString = new Intent();
        paramString.putExtra("Contact_User", paramn);
        paramString.putExtra("KIsHardDevice", true);
        paramString.putExtra("KHardDeviceBindTicket", localcyk.FCR);
        paramString.putExtra("device_id", localbnj.nDr);
        paramString.putExtra("device_type", localbnj.FzJ);
        com.tencent.mm.plugin.exdevice.a.pZN.c(paramString, this.qdl.dvh.context);
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