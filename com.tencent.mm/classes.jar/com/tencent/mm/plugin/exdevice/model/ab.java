package com.tencent.mm.plugin.exdevice.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.a.je;
import com.tencent.mm.g.a.je.a;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cau;
import com.tencent.mm.protocal.protobuf.cih;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.dq;
import com.tencent.mm.protocal.protobuf.dsf;
import com.tencent.mm.protocal.protobuf.dv;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.protocal.protobuf.ecv;
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

public final class ab
  extends IListener<je>
  implements com.tencent.mm.ak.i
{
  private ProgressDialog gtM;
  private je rAL;
  
  public ab()
  {
    AppMethodBeat.i(161355);
    this.__eventId = je.class.getName().hashCode();
    AppMethodBeat.o(161355);
  }
  
  private boolean a(final je paramje)
  {
    AppMethodBeat.i(23437);
    if (!(paramje instanceof je))
    {
      Log.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mismatched event");
      AppMethodBeat.o(23437);
      return false;
    }
    this.rAL = paramje;
    paramje = this.rAL.dNT.result;
    Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "action = %s, key = %s", new Object[] { Integer.valueOf(this.rAL.dNT.actionCode), paramje });
    if (Util.isNullOrNil(paramje))
    {
      AppMethodBeat.o(23437);
      return false;
    }
    switch (this.rAL.dNT.actionCode)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23437);
      return false;
      if ((this.rAL.dNT.context == null) || (!(this.rAL.dNT.context instanceof Activity)))
      {
        AppMethodBeat.o(23437);
        return false;
      }
      bg.azz().a(540, this);
      paramje = new u(paramje);
      bg.azz().a(paramje, 0);
      Context localContext = this.rAL.dNT.context;
      this.rAL.dNT.context.getString(2131755998);
      this.gtM = h.b(localContext, this.rAL.dNT.context.getString(2131764943), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(23436);
          bg.azz().a(paramje);
          if (ab.a(ab.this).callback != null)
          {
            ab.a(ab.this).dNU.ret = 1;
            ab.a(ab.this).callback.run();
          }
          AppMethodBeat.o(23436);
        }
      });
    }
  }
  
  private void cKJ()
  {
    AppMethodBeat.i(23439);
    if ((this.rAL != null) && (this.rAL.callback != null))
    {
      this.rAL.dNU.ret = 1;
      this.rAL.callback.run();
    }
    AppMethodBeat.o(23439);
  }
  
  private void stopScan()
  {
    AppMethodBeat.i(23440);
    if ((this.rAL != null) && (this.rAL.callback != null))
    {
      this.rAL.dNU.ret = 2;
      this.rAL.callback.run();
    }
    AppMethodBeat.o(23440);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(23438);
    Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    if ((this.gtM != null) && (this.gtM.isShowing())) {
      this.gtM.dismiss();
    }
    if (paramq == null)
    {
      cKJ();
      AppMethodBeat.o(23438);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", new Object[] { Integer.valueOf(paramq.getType()) });
      cKJ();
      AppMethodBeat.o(23438);
      return;
    }
    Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", new Object[] { Integer.valueOf(paramq.getType()) });
    dsf localdsf;
    cat localcat;
    cau localcau;
    Object localObject3;
    Object localObject2;
    if (paramq.getType() == 540)
    {
      bg.azz().b(540, this);
      paramString = (u)paramq;
      if ((paramString.rr != null) && (paramString.rr.iLL.iLR != null)) {}
      for (localdsf = (dsf)paramString.rr.iLL.iLR; localdsf == null; localdsf = null)
      {
        Log.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp == null");
        cKJ();
        AppMethodBeat.o(23438);
        return;
      }
      localcat = localdsf.KPD;
      Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "deviceId = %s, deviceType = %s", new Object[] { localcat.oTH, localcat.KLO });
      localcau = localdsf.KPE;
      Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "AuthKey = %s, BrandName = %s, CloseStrategy = %s, ConnProto = %s, ConnStrategy = %s, Mac = %s", new Object[] { localcau.KLg, localcau.MfY, Integer.valueOf(localcau.Mgb), localcau.MfZ, Integer.valueOf(localcau.Mga), localcau.KOS });
      paramq = "";
      paramString = "";
      localObject3 = new LinkedList();
      localObject2 = paramq;
      localObject1 = paramString;
      if (localdsf.MUL == null) {
        break label2501;
      }
      if (localdsf.MUL.KHR != null) {
        paramq = localdsf.MUL.KHR;
      }
      if (localdsf.MUL.title != null) {
        paramString = localdsf.MUL.title;
      }
      localObject2 = paramq;
      localObject1 = paramString;
      if (localdsf.MUL.KHS == null) {
        break label2501;
      }
    }
    for (Object localObject1 = localdsf.MUL.KHS;; localObject1 = localObject3)
    {
      localObject2 = new ArrayList();
      if ((localObject1 != null) && (((LinkedList)localObject1).size() > 0))
      {
        paramInt1 = 0;
        while (paramInt1 < ((LinkedList)localObject1).size())
        {
          localObject3 = (ecv)((LinkedList)localObject1).get(paramInt1);
          if (((ecv)localObject3).type.contains("text")) {
            ((ArrayList)localObject2).add(((ecv)localObject3).content);
          }
          paramInt1 += 1;
        }
      }
      Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp.BindTicket = %s", new Object[] { localdsf.KOX });
      boolean bool;
      if (localdsf.MUK == 1)
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("device_scan_mode", "SCAN_CATALOG");
        if ((localcau.MfZ.contains("3")) || (localcau.MfZ.contains("1"))) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          bool = localcau.MfZ.contains("4");
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
          ((Intent)localObject1).putExtra("device_id", localcat.oTH);
          ((Intent)localObject1).putExtra("device_type", localcat.KLO);
          ((Intent)localObject1).putExtra("device_title", localcau.Mgf);
          ((Intent)localObject1).putExtra("device_desc", localcau.Mgg);
          ((Intent)localObject1).putExtra("device_icon_url", localcau.IconUrl);
          ((Intent)localObject1).putExtra("device_category_id", localcau.Mgh);
          ((Intent)localObject1).putExtra("device_brand_name", localcau.MfY);
          ((Intent)localObject1).putExtra("bind_ticket", localdsf.KOX);
          ((Intent)localObject1).putExtra("device_ble_simple_proto", localcau.fMg);
          ((Intent)localObject1).putExtra("device_airkiss_key", paramq);
          ((Intent)localObject1).putExtra("device_airkiss_title", paramString);
          ((Intent)localObject1).putStringArrayListExtra("device_airkiss_steps", (ArrayList)localObject2);
          com.tencent.mm.br.c.b(this.rAL.dNT.context, "exdevice", ".ui.ExdeviceBindDeviceGuideUI", (Intent)localObject1);
          stopScan();
          AppMethodBeat.o(23438);
          return;
          if (bool) {
            ((Intent)localObject1).putExtra("device_scan_conn_proto", "wifi");
          }
        }
      }
      paramString = localdsf.KOY;
      if (paramString == null)
      {
        Log.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mContact == null");
        cKJ();
        AppMethodBeat.o(23438);
        return;
      }
      stopScan();
      if (paramString == null) {
        Log.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "unable to parse mod contact");
      }
      for (;;)
      {
        paramq = com.tencent.mm.platformtools.z.a(paramString.Lqk);
        if ((this.rAL != null) && (this.rAL.dNT != null) && (this.rAL.dNT.context != null)) {
          break;
        }
        Log.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "a8KeyRedirectEvent null");
        AppMethodBeat.o(23438);
        return;
        paramq = com.tencent.mm.platformtools.z.a(paramString.Lqk);
        localObject1 = Util.nullAsNil(paramString.Mvn);
        if ((Util.isNullOrNil(paramq)) && (Util.isNullOrNil((String)localObject1)))
        {
          Log.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact user is null user:%s enuser:%s", new Object[] { paramq, localObject1 });
        }
        else
        {
          Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact : %s", new Object[] { paramq });
          bg.aVF();
          localObject2 = com.tencent.mm.model.c.aSN().Kn(paramq);
          if ((localObject2 != null) && (paramq.equals(((ax)localObject2).field_encryptUsername)))
          {
            Log.w("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "cat's replace user with stranger");
          }
          else
          {
            localObject3 = new as(paramq);
            ((as)localObject3).BC(paramString.ked);
            ((as)localObject3).setType(paramString.LoG & paramString.LoH);
            label1141:
            long l;
            if (!Util.isNullOrNil((String)localObject1))
            {
              ((as)localObject3).BK((String)localObject1);
              if (localObject2 != null) {
                break label1674;
              }
              l = 0L;
              label1149:
              ((as)localObject3).gMZ = l;
              ((as)localObject3).setNickname(com.tencent.mm.platformtools.z.a(paramString.Mjj));
              ((as)localObject3).BF(com.tencent.mm.platformtools.z.a(paramString.LpA));
              ((as)localObject3).BG(com.tencent.mm.platformtools.z.a(paramString.LpB));
              ((as)localObject3).nj(paramString.kdY);
              ((as)localObject3).nl(paramString.LoM);
              ((as)localObject3).BE(com.tencent.mm.platformtools.z.a(paramString.Mvh));
              ((as)localObject3).nm(paramString.LoQ);
              ((as)localObject3).nn(paramString.kec);
              ((as)localObject3).Cb(RegionCodeDecoder.bq(paramString.keh, paramString.kdZ, paramString.kea));
              ((as)localObject3).BV(paramString.keb);
              ((as)localObject3).nf(paramString.MmK);
              ((as)localObject3).Ca(paramString.MmL);
              ((as)localObject3).setSource(paramString.xub);
              ((as)localObject3).ne(paramString.MmO);
              ((as)localObject3).BH(paramString.MmN);
              if (com.tencent.mm.model.ab.JK(paramString.MmM)) {
                ((as)localObject3).BZ(paramString.MmM);
              }
              ((as)localObject3).no((int)Util.nowSecond());
              ((as)localObject3).BD(com.tencent.mm.platformtools.z.a(paramString.MuI));
              ((as)localObject3).BI(com.tencent.mm.platformtools.z.a(paramString.MuK));
              ((as)localObject3).BJ(com.tencent.mm.platformtools.z.a(paramString.MuJ));
              ((as)localObject3).Cc(paramString.KHk);
              ((as)localObject3).Cd(paramString.Mvw);
              if ((localObject2 != null) && (!Util.nullAsNil(((ax)localObject2).fuS).equals(Util.nullAsNil(paramString.Mvw))))
              {
                com.tencent.mm.bd.c.bez();
                com.tencent.mm.bd.c.Pt(paramq);
              }
              bg.aVF();
              com.tencent.mm.model.c.aSN().bjQ(paramq);
              if (!Util.isNullOrNil(((ax)localObject3).field_username)) {
                break label1686;
              }
              Log.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "dkinit dealModContactExtInfo failed invalid contact");
              label1466:
              ((as)localObject3).nh(paramString.DeleteFlag);
              if ((paramString.Mvs != null) && (paramString.Mvs.KHD != null))
              {
                ((as)localObject3).Ce(paramString.Mvs.KHD.KPG);
                ((as)localObject3).Cf(paramString.Mvs.KHD.KPH);
                ((as)localObject3).Cg(paramString.Mvs.KHD.KPI);
              }
              if (com.tencent.mm.model.ab.JE(paramq)) {
                ((as)localObject3).aqZ();
              }
              if (((as)localObject3).gBM()) {
                ((as)localObject3).arc();
              }
              if (Util.isNullOrNil((String)localObject1)) {
                break label2016;
              }
              bg.aVF();
              com.tencent.mm.model.c.aSN().d((String)localObject1, (as)localObject3);
            }
            for (;;)
            {
              if ((localObject2 == null) || ((((ax)localObject2).field_type & 0x800) == (((ax)localObject3).field_type & 0x800))) {
                break label2032;
              }
              if ((((ax)localObject3).field_type & 0x800) == 0) {
                break label2034;
              }
              bg.aVF();
              com.tencent.mm.model.c.aST().bke(((ax)localObject3).field_username);
              break;
              if ((localObject2 == null) || ((int)((com.tencent.mm.contact.c)localObject2).gMZ <= 0)) {
                break label1141;
              }
              ((as)localObject3).BK(((ax)localObject2).field_encryptUsername);
              break label1141;
              label1674:
              l = (int)((com.tencent.mm.contact.c)localObject2).gMZ;
              break label1149;
              label1686:
              Object localObject4 = ((ax)localObject3).field_username;
              Object localObject5 = com.tencent.mm.aj.c.a((String)localObject4, paramString);
              p.aYB().b((com.tencent.mm.aj.i)localObject5);
              localObject5 = paramString.MmQ;
              if ((!((ax)localObject3).field_username.endsWith("@chatroom")) && (localObject5 != null))
              {
                Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsFlag modcontact " + ((ebj)localObject5).kej + " " + paramString.Lqk);
                Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBg modcontact " + ((ebj)localObject5).kek);
                Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + ((ebj)localObject5).kel);
                Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + ((ebj)localObject5).Nbc);
                if (o.DCN != null) {
                  o.DCN.a(((ax)localObject3).field_username, (ebj)localObject5);
                }
              }
              localObject5 = com.tencent.mm.model.z.aTY();
              if ((localObject5 == null) || (((String)localObject5).equals(localObject4))) {
                break label1466;
              }
              localObject5 = ag.bah().MT((String)localObject4);
              ((com.tencent.mm.api.c)localObject5).field_username = ((String)localObject4);
              ((com.tencent.mm.api.c)localObject5).field_brandList = paramString.kei;
              localObject4 = paramString.MmR;
              if (localObject4 != null)
              {
                ((com.tencent.mm.api.c)localObject5).field_brandFlag = ((aeq)localObject4).kem;
                ((com.tencent.mm.api.c)localObject5).field_brandInfo = ((aeq)localObject4).keo;
                ((com.tencent.mm.api.c)localObject5).field_brandIconURL = ((aeq)localObject4).kep;
                ((com.tencent.mm.api.c)localObject5).field_extInfo = ((aeq)localObject4).ken;
                ((com.tencent.mm.api.c)localObject5).field_attrSyncVersion = null;
                ((com.tencent.mm.api.c)localObject5).field_incrementUpdateTime = 0L;
              }
              if (!ag.bah().h((com.tencent.mm.api.c)localObject5)) {
                ag.bah().g((com.tencent.mm.api.c)localObject5);
              }
              ((as)localObject3).np(((com.tencent.mm.api.c)localObject5).field_type);
              break label1466;
              label2016:
              bg.aVF();
              com.tencent.mm.model.c.aSN().ao((as)localObject3);
            }
            label2032:
            continue;
            label2034:
            bg.aVF();
            com.tencent.mm.model.c.aST().bkf(((ax)localObject3).field_username);
          }
        }
      }
      bg.aVF();
      paramString = com.tencent.mm.model.c.aSN().Kn(paramq);
      if (paramString != null)
      {
        if (localcau.fMf != 0)
        {
          Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to DeviceProfileUI.");
          paramq = this.rAL.dNT.context;
          localObject1 = new Intent(paramq, ExdeviceDeviceProfileUI.class);
          if (!(paramq instanceof Activity)) {
            ((Intent)localObject1).addFlags(268435456);
          }
          ((Intent)localObject1).putExtra("device_id", localcat.oTH);
          ((Intent)localObject1).putExtra("device_type", localcat.KLO);
          ((Intent)localObject1).putExtra("device_mac", localcau.KOS);
          ((Intent)localObject1).putExtra("device_brand_name", localcau.MfY);
          ((Intent)localObject1).putExtra("device_alias", localcau.ked);
          ((Intent)localObject1).putExtra("device_desc", localcau.Mgg);
          ((Intent)localObject1).putExtra("device_title", localcau.Mgf);
          ((Intent)localObject1).putExtra("device_icon_url", localcau.IconUrl);
          ((Intent)localObject1).putExtra("device_jump_url", localcau.xIy);
          ((Intent)localObject1).putExtra("bind_ticket", localdsf.KOX);
          if (ad.cKL().gc(paramString.field_username, localcat.oTH) != null) {}
          for (bool = true;; bool = false)
          {
            ((Intent)localObject1).putExtra("device_has_bound", bool);
            paramString = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(paramq, paramString.axQ(), "com/tencent/mm/plugin/exdevice/model/SearchDeviceGetA8KeyRedirectListener", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramq.startActivity((Intent)paramString.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramq, "com/tencent/mm/plugin/exdevice/model/SearchDeviceGetA8KeyRedirectListener", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(23438);
            return;
          }
        }
        Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to ContactInfoUI.");
        paramString = new Intent();
        paramString.putExtra("Contact_User", paramq);
        paramString.putExtra("KIsHardDevice", true);
        paramString.putExtra("KHardDeviceBindTicket", localdsf.KOX);
        paramString.putExtra("device_id", localcat.oTH);
        paramString.putExtra("device_type", localcat.KLO);
        com.tencent.mm.plugin.exdevice.a.rxo.c(paramString, this.rAL.dNT.context);
        AppMethodBeat.o(23438);
        return;
      }
      AppMethodBeat.o(23438);
      return;
      label2501:
      paramq = (q)localObject2;
      paramString = (String)localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ab
 * JD-Core Version:    0.7.0.1
 */