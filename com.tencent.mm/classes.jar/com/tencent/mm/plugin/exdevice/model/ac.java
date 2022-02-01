package com.tencent.mm.plugin.exdevice.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.f;
import com.tencent.mm.f.a.ju;
import com.tencent.mm.f.a.ju.a;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.protocal.protobuf.crd;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.protocal.protobuf.do;
import com.tencent.mm.protocal.protobuf.dv;
import com.tencent.mm.protocal.protobuf.ecb;
import com.tencent.mm.protocal.protobuf.elj;
import com.tencent.mm.protocal.protobuf.emw;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ac
  extends IListener<ju>
  implements i
{
  private ProgressDialog iXX;
  private ju vgs;
  
  public ac()
  {
    AppMethodBeat.i(161355);
    this.__eventId = ju.class.getName().hashCode();
    AppMethodBeat.o(161355);
  }
  
  private boolean a(final ju paramju)
  {
    AppMethodBeat.i(23437);
    if (!(paramju instanceof ju))
    {
      Log.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mismatched event");
      AppMethodBeat.o(23437);
      return false;
    }
    this.vgs = paramju;
    paramju = this.vgs.fHe.result;
    Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "action = %s, key = %s", new Object[] { Integer.valueOf(this.vgs.fHe.actionCode), paramju });
    if (Util.isNullOrNil(paramju))
    {
      AppMethodBeat.o(23437);
      return false;
    }
    switch (this.vgs.fHe.actionCode)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23437);
      return false;
      if ((this.vgs.fHe.context == null) || (!(this.vgs.fHe.context instanceof Activity)))
      {
        AppMethodBeat.o(23437);
        return false;
      }
      bh.aGY().a(540, this);
      paramju = new v(paramju);
      bh.aGY().a(paramju, 0);
      Context localContext = this.vgs.fHe.context;
      this.vgs.fHe.context.getString(R.l.app_tip);
      this.iXX = h.b(localContext, this.vgs.fHe.context.getString(R.l.eRw), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(23436);
          bh.aGY().a(paramju);
          if (ac.a(ac.this).callback != null)
          {
            ac.a(ac.this).fHf.ret = 1;
            ac.a(ac.this).callback.run();
          }
          AppMethodBeat.o(23436);
        }
      });
    }
  }
  
  private void cZv()
  {
    AppMethodBeat.i(23439);
    if ((this.vgs != null) && (this.vgs.callback != null))
    {
      this.vgs.fHf.ret = 1;
      this.vgs.callback.run();
    }
    AppMethodBeat.o(23439);
  }
  
  private void cxT()
  {
    AppMethodBeat.i(23440);
    if ((this.vgs != null) && (this.vgs.callback != null))
    {
      this.vgs.fHf.ret = 2;
      this.vgs.callback.run();
    }
    AppMethodBeat.o(23440);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(23438);
    Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    if ((this.iXX != null) && (this.iXX.isShowing())) {
      this.iXX.dismiss();
    }
    if (paramq == null)
    {
      cZv();
      AppMethodBeat.o(23438);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", new Object[] { Integer.valueOf(paramq.getType()) });
      cZv();
      AppMethodBeat.o(23438);
      return;
    }
    Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", new Object[] { Integer.valueOf(paramq.getType()) });
    ecb localecb;
    ciu localciu;
    civ localciv;
    Object localObject3;
    Object localObject2;
    if (paramq.getType() == 540)
    {
      bh.aGY().b(540, this);
      paramString = (v)paramq;
      if ((paramString.rr != null) && (d.c.b(paramString.rr.lBS) != null)) {}
      for (localecb = (ecb)d.c.b(paramString.rr.lBS); localecb == null; localecb = null)
      {
        Log.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp == null");
        cZv();
        AppMethodBeat.o(23438);
        return;
      }
      localciu = localecb.RQB;
      Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "deviceId = %s, deviceType = %s", new Object[] { localciu.rVF, localciu.RMK });
      localciv = localecb.RQC;
      Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "AuthKey = %s, BrandName = %s, CloseStrategy = %s, ConnProto = %s, ConnStrategy = %s, Mac = %s", new Object[] { localciv.RMc, localciv.TpK, Integer.valueOf(localciv.TpN), localciv.TpL, Integer.valueOf(localciv.TpM), localciv.RPQ });
      paramq = "";
      paramString = "";
      localObject3 = new LinkedList();
      localObject2 = paramq;
      localObject1 = paramString;
      if (localecb.UgV == null) {
        break label2503;
      }
      if (localecb.UgV.RJl != null) {
        paramq = localecb.UgV.RJl;
      }
      if (localecb.UgV.title != null) {
        paramString = localecb.UgV.title;
      }
      localObject2 = paramq;
      localObject1 = paramString;
      if (localecb.UgV.RJm == null) {
        break label2503;
      }
    }
    for (Object localObject1 = localecb.UgV.RJm;; localObject1 = localObject3)
    {
      localObject2 = new ArrayList();
      if ((localObject1 != null) && (((LinkedList)localObject1).size() > 0))
      {
        paramInt1 = 0;
        while (paramInt1 < ((LinkedList)localObject1).size())
        {
          localObject3 = (emw)((LinkedList)localObject1).get(paramInt1);
          if (((emw)localObject3).type.contains("text")) {
            ((ArrayList)localObject2).add(((emw)localObject3).content);
          }
          paramInt1 += 1;
        }
      }
      Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp.BindTicket = %s", new Object[] { localecb.RPV });
      boolean bool;
      if (localecb.UgU == 1)
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("device_scan_mode", "SCAN_CATALOG");
        if ((localciv.TpL.contains("3")) || (localciv.TpL.contains("1"))) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          bool = localciv.TpL.contains("4");
          if ((paramInt1 == 0) || (!bool)) {
            break;
          }
          Log.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Category connect proto can not be blue&wifi at the same time...");
          AppMethodBeat.o(23438);
          return;
        }
        if (paramInt1 != 0) {
          ((Intent)localObject1).putExtra("device_scan_conn_proto", "blue");
        }
        for (;;)
        {
          ((Intent)localObject1).putExtra("device_id", localciu.rVF);
          ((Intent)localObject1).putExtra("device_type", localciu.RMK);
          ((Intent)localObject1).putExtra("device_title", localciv.TpR);
          ((Intent)localObject1).putExtra("device_desc", localciv.TpS);
          ((Intent)localObject1).putExtra("device_icon_url", localciv.CNj);
          ((Intent)localObject1).putExtra("device_category_id", localciv.TpT);
          ((Intent)localObject1).putExtra("device_brand_name", localciv.TpK);
          ((Intent)localObject1).putExtra("bind_ticket", localecb.RPV);
          ((Intent)localObject1).putExtra("device_ble_simple_proto", localciv.idY);
          ((Intent)localObject1).putExtra("device_airkiss_key", paramq);
          ((Intent)localObject1).putExtra("device_airkiss_title", paramString);
          ((Intent)localObject1).putStringArrayListExtra("device_airkiss_steps", (ArrayList)localObject2);
          com.tencent.mm.by.c.b(this.vgs.fHe.context, "exdevice", ".ui.ExdeviceBindDeviceGuideUI", (Intent)localObject1);
          cxT();
          AppMethodBeat.o(23438);
          return;
          if (bool) {
            ((Intent)localObject1).putExtra("device_scan_conn_proto", "wifi");
          }
        }
      }
      paramString = localecb.RPW;
      if (paramString == null)
      {
        Log.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mContact == null");
        cZv();
        AppMethodBeat.o(23438);
        return;
      }
      cxT();
      if (paramString == null) {
        Log.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "unable to parse mod contact");
      }
      for (;;)
      {
        paramq = com.tencent.mm.platformtools.z.a(paramString.SrH);
        if ((this.vgs != null) && (this.vgs.fHe != null) && (this.vgs.fHe.context != null)) {
          break;
        }
        Log.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "a8KeyRedirectEvent null");
        AppMethodBeat.o(23438);
        return;
        paramq = com.tencent.mm.platformtools.z.a(paramString.SrH);
        localObject1 = Util.nullAsNil(paramString.TGl);
        if ((Util.isNullOrNil(paramq)) && (Util.isNullOrNil((String)localObject1)))
        {
          Log.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact user is null user:%s enuser:%s", new Object[] { paramq, localObject1 });
        }
        else
        {
          Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact : %s", new Object[] { paramq });
          bh.beI();
          localObject2 = com.tencent.mm.model.c.bbL().RG(paramq);
          if ((localObject2 != null) && (paramq.equals(((ax)localObject2).field_encryptUsername)))
          {
            Log.w("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "cat's replace user with stranger");
          }
          else
          {
            localObject3 = new as(paramq);
            ((as)localObject3).Iq(paramString.mVD);
            ((as)localObject3).setType(paramString.Sqc & paramString.Sqd);
            label1141:
            long l;
            if (!Util.isNullOrNil((String)localObject1))
            {
              ((as)localObject3).Iy((String)localObject1);
              if (localObject2 != null) {
                break label1674;
              }
              l = 0L;
              label1149:
              ((as)localObject3).jxt = l;
              ((as)localObject3).setNickname(com.tencent.mm.platformtools.z.a(paramString.TtX));
              ((as)localObject3).It(com.tencent.mm.platformtools.z.a(paramString.SqW));
              ((as)localObject3).Iu(com.tencent.mm.platformtools.z.a(paramString.SqX));
              ((as)localObject3).pw(paramString.mVy);
              ((as)localObject3).pz(paramString.Sqi);
              ((as)localObject3).Is(com.tencent.mm.platformtools.z.a(paramString.TGf));
              ((as)localObject3).pA(paramString.Sqm);
              ((as)localObject3).pB(paramString.mVC);
              ((as)localObject3).IP(RegionCodeDecoder.bl(paramString.mVH, paramString.mVz, paramString.mVA));
              ((as)localObject3).IJ(paramString.mVB);
              ((as)localObject3).ps(paramString.TxF);
              ((as)localObject3).IO(paramString.TxG);
              ((as)localObject3).setSource(paramString.Cqs);
              ((as)localObject3).pr(paramString.TxJ);
              ((as)localObject3).Iv(paramString.TxI);
              if (ab.Rd(paramString.TxH)) {
                ((as)localObject3).IN(paramString.TxH);
              }
              ((as)localObject3).pC((int)Util.nowSecond());
              ((as)localObject3).Ir(com.tencent.mm.platformtools.z.a(paramString.TFz));
              ((as)localObject3).Iw(com.tencent.mm.platformtools.z.a(paramString.TFB));
              ((as)localObject3).Ix(com.tencent.mm.platformtools.z.a(paramString.TFA));
              ((as)localObject3).IQ(paramString.RIC);
              ((as)localObject3).IR(paramString.TGu);
              if ((localObject2 != null) && (!Util.nullAsNil(((ax)localObject2).hDr).equals(Util.nullAsNil(paramString.TGu))))
              {
                com.tencent.mm.bg.c.bnY();
                com.tencent.mm.bg.c.WQ(paramq);
              }
              bh.beI();
              com.tencent.mm.model.c.bbL().bwo(paramq);
              if (!Util.isNullOrNil(((ax)localObject3).field_username)) {
                break label1686;
              }
              Log.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "dkinit dealModContactExtInfo failed invalid contact");
              label1466:
              ((as)localObject3).pu(paramString.DeleteFlag);
              if ((paramString.TGq != null) && (paramString.TGq.RIW != null))
              {
                ((as)localObject3).IS(paramString.TGq.RIW.RQE);
                ((as)localObject3).IT(paramString.TGq.RIW.RQF);
                ((as)localObject3).IU(paramString.TGq.RIW.RQG);
              }
              if (ab.QX(paramq)) {
                ((as)localObject3).axx();
              }
              if (((as)localObject3).hxX()) {
                ((as)localObject3).axA();
              }
              if (Util.isNullOrNil((String)localObject1)) {
                break label2018;
              }
              bh.beI();
              com.tencent.mm.model.c.bbL().d((String)localObject1, (as)localObject3);
            }
            for (;;)
            {
              if ((localObject2 == null) || ((((ax)localObject2).field_type & 0x800) == (((ax)localObject3).field_type & 0x800))) {
                break label2034;
              }
              if ((((ax)localObject3).field_type & 0x800) == 0) {
                break label2036;
              }
              bh.beI();
              com.tencent.mm.model.c.bbR().bwD(((ax)localObject3).field_username);
              break;
              if ((localObject2 == null) || ((int)((com.tencent.mm.contact.d)localObject2).jxt <= 0)) {
                break label1141;
              }
              ((as)localObject3).Iy(((ax)localObject2).field_encryptUsername);
              break label1141;
              label1674:
              l = (int)((com.tencent.mm.contact.d)localObject2).jxt;
              break label1149;
              label1686:
              Object localObject4 = ((ax)localObject3).field_username;
              Object localObject5 = com.tencent.mm.am.d.a((String)localObject4, paramString, (as)localObject3);
              com.tencent.mm.am.q.bhP().b((j)localObject5);
              localObject5 = paramString.TxL;
              if ((!((ax)localObject3).field_username.endsWith("@chatroom")) && (localObject5 != null))
              {
                Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsFlag modcontact " + ((elj)localObject5).mVJ + " " + paramString.SrH);
                Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBg modcontact " + ((elj)localObject5).mVK);
                Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + ((elj)localObject5).mVL);
                Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + ((elj)localObject5).Unw);
                if (p.JPd != null) {
                  p.JPd.a(((ax)localObject3).field_username, (elj)localObject5);
                }
              }
              localObject5 = com.tencent.mm.model.z.bcZ();
              if ((localObject5 == null) || (((String)localObject5).equals(localObject4))) {
                break label1466;
              }
              localObject5 = af.bjv().Uo((String)localObject4);
              ((com.tencent.mm.api.c)localObject5).field_username = ((String)localObject4);
              ((com.tencent.mm.api.c)localObject5).field_brandList = paramString.mVI;
              localObject4 = paramString.TxM;
              if (localObject4 != null)
              {
                ((com.tencent.mm.api.c)localObject5).field_brandFlag = ((aez)localObject4).mVM;
                ((com.tencent.mm.api.c)localObject5).field_brandInfo = ((aez)localObject4).mVO;
                ((com.tencent.mm.api.c)localObject5).field_brandIconURL = ((aez)localObject4).mVP;
                ((com.tencent.mm.api.c)localObject5).field_extInfo = ((aez)localObject4).mVN;
                ((com.tencent.mm.api.c)localObject5).field_attrSyncVersion = null;
                ((com.tencent.mm.api.c)localObject5).field_incrementUpdateTime = 0L;
              }
              if (!af.bjv().h((com.tencent.mm.api.c)localObject5)) {
                af.bjv().g((com.tencent.mm.api.c)localObject5);
              }
              ((as)localObject3).pD(((com.tencent.mm.api.c)localObject5).field_type);
              break label1466;
              label2018:
              bh.beI();
              com.tencent.mm.model.c.bbL().au((as)localObject3);
            }
            label2034:
            continue;
            label2036:
            bh.beI();
            com.tencent.mm.model.c.bbR().bwE(((ax)localObject3).field_username);
          }
        }
      }
      bh.beI();
      paramString = com.tencent.mm.model.c.bbL().RG(paramq);
      if (paramString != null)
      {
        if (localciv.idX != 0)
        {
          Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to DeviceProfileUI.");
          paramq = this.vgs.fHe.context;
          localObject1 = new Intent(paramq, ExdeviceDeviceProfileUI.class);
          if (!(paramq instanceof Activity)) {
            ((Intent)localObject1).addFlags(268435456);
          }
          ((Intent)localObject1).putExtra("device_id", localciu.rVF);
          ((Intent)localObject1).putExtra("device_type", localciu.RMK);
          ((Intent)localObject1).putExtra("device_mac", localciv.RPQ);
          ((Intent)localObject1).putExtra("device_brand_name", localciv.TpK);
          ((Intent)localObject1).putExtra("device_alias", localciv.mVD);
          ((Intent)localObject1).putExtra("device_desc", localciv.TpS);
          ((Intent)localObject1).putExtra("device_title", localciv.TpR);
          ((Intent)localObject1).putExtra("device_icon_url", localciv.CNj);
          ((Intent)localObject1).putExtra("device_jump_url", localciv.CMD);
          ((Intent)localObject1).putExtra("bind_ticket", localecb.RPV);
          if (ae.cZx().gr(paramString.field_username, localciu.rVF) != null) {}
          for (bool = true;; bool = false)
          {
            ((Intent)localObject1).putExtra("device_has_bound", bool);
            paramString = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
            com.tencent.mm.hellhoundlib.a.a.b(paramq, paramString.aFh(), "com/tencent/mm/plugin/exdevice/model/SearchDeviceGetA8KeyRedirectListener", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramq.startActivity((Intent)paramString.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramq, "com/tencent/mm/plugin/exdevice/model/SearchDeviceGetA8KeyRedirectListener", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(23438);
            return;
          }
        }
        Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to ContactInfoUI.");
        paramString = new Intent();
        paramString.putExtra("Contact_User", paramq);
        paramString.putExtra("KIsHardDevice", true);
        paramString.putExtra("KHardDeviceBindTicket", localecb.RPV);
        paramString.putExtra("device_id", localciu.rVF);
        paramString.putExtra("device_type", localciu.RMK);
        com.tencent.mm.plugin.exdevice.a.cYL().c(paramString, this.vgs.fHe.context);
        AppMethodBeat.o(23438);
        return;
      }
      AppMethodBeat.o(23438);
      return;
      label2503:
      paramq = (com.tencent.mm.an.q)localObject2;
      paramString = (String)localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ac
 * JD-Core Version:    0.7.0.1
 */