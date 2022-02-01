package com.tencent.mm.plugin.exdevice.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.an.af;
import com.tencent.mm.autogen.a.kw;
import com.tencent.mm.autogen.a.kw.a;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.protocal.protobuf.cyy;
import com.tencent.mm.protocal.protobuf.dhy;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.protocal.protobuf.ed;
import com.tencent.mm.protocal.protobuf.em;
import com.tencent.mm.protocal.protobuf.evs;
import com.tencent.mm.protocal.protobuf.ffs;
import com.tencent.mm.protocal.protobuf.fhu;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import java.util.ArrayList;
import java.util.LinkedList;

public class SearchDeviceGetA8KeyRedirectListener
  extends IListener<kw>
  implements com.tencent.mm.am.h
{
  private ProgressDialog lzP;
  private kw yss;
  
  public SearchDeviceGetA8KeyRedirectListener()
  {
    super(com.tencent.mm.app.f.hfK);
    AppMethodBeat.i(161355);
    this.__eventId = kw.class.getName().hashCode();
    AppMethodBeat.o(161355);
  }
  
  private boolean a(final kw paramkw)
  {
    AppMethodBeat.i(23437);
    if (!(paramkw instanceof kw))
    {
      Log.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mismatched event");
      AppMethodBeat.o(23437);
      return false;
    }
    this.yss = paramkw;
    paramkw = this.yss.hMB.result;
    Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "action = %s, key = %s", new Object[] { Integer.valueOf(this.yss.hMB.actionCode), paramkw });
    if (Util.isNullOrNil(paramkw))
    {
      AppMethodBeat.o(23437);
      return false;
    }
    switch (this.yss.hMB.actionCode)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23437);
      return false;
      if ((this.yss.hMB.context == null) || (!(this.yss.hMB.context instanceof Activity)))
      {
        AppMethodBeat.o(23437);
        return false;
      }
      bh.aZW().a(540, this);
      paramkw = new x(paramkw);
      bh.aZW().a(paramkw, 0);
      Context localContext = this.yss.hMB.context;
      this.yss.hMB.context.getString(R.l.app_tip);
      this.lzP = com.tencent.mm.ui.base.k.b(localContext, this.yss.hMB.context.getString(R.l.gUc), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(23436);
          bh.aZW().a(paramkw);
          if (SearchDeviceGetA8KeyRedirectListener.a(SearchDeviceGetA8KeyRedirectListener.this).callback != null)
          {
            SearchDeviceGetA8KeyRedirectListener.a(SearchDeviceGetA8KeyRedirectListener.this).hMC.ret = 1;
            SearchDeviceGetA8KeyRedirectListener.a(SearchDeviceGetA8KeyRedirectListener.this).callback.run();
          }
          AppMethodBeat.o(23436);
        }
      });
    }
  }
  
  private void dFM()
  {
    AppMethodBeat.i(23439);
    if ((this.yss != null) && (this.yss.callback != null))
    {
      this.yss.hMC.ret = 1;
      this.yss.callback.run();
    }
    AppMethodBeat.o(23439);
  }
  
  private void daL()
  {
    AppMethodBeat.i(23440);
    if ((this.yss != null) && (this.yss.callback != null))
    {
      this.yss.hMC.ret = 2;
      this.yss.callback.run();
    }
    AppMethodBeat.o(23440);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(23438);
    Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    if ((this.lzP != null) && (this.lzP.isShowing())) {
      this.lzP.dismiss();
    }
    if (paramp == null)
    {
      dFM();
      AppMethodBeat.o(23438);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", new Object[] { Integer.valueOf(paramp.getType()) });
      dFM();
      AppMethodBeat.o(23438);
      return;
    }
    Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", new Object[] { Integer.valueOf(paramp.getType()) });
    evs localevs;
    cyx localcyx;
    cyy localcyy;
    Object localObject3;
    Object localObject2;
    if (paramp.getType() == 540)
    {
      bh.aZW().b(540, this);
      paramString = (x)paramp;
      if ((paramString.rr != null) && (c.c.b(paramString.rr.otC) != null)) {}
      for (localevs = (evs)c.c.b(paramString.rr.otC); localevs == null; localevs = null)
      {
        Log.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp == null");
        dFM();
        AppMethodBeat.o(23438);
        return;
      }
      localcyx = localevs.YNR;
      Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "deviceId = %s, deviceType = %s", new Object[] { localcyx.vgV, localcyx.YJY });
      localcyy = localevs.YNS;
      Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "AuthKey = %s, BrandName = %s, CloseStrategy = %s, ConnProto = %s, ConnStrategy = %s, Mac = %s", new Object[] { localcyy.YJq, localcyy.aaDM, Integer.valueOf(localcyy.aaDP), localcyy.aaDN, Integer.valueOf(localcyy.aaDO), localcyy.YNe });
      paramp = "";
      paramString = "";
      localObject3 = new LinkedList();
      localObject2 = paramp;
      localObject1 = paramString;
      if (localevs.abyw == null) {
        break label2504;
      }
      if (localevs.abyw.YGB != null) {
        paramp = localevs.abyw.YGB;
      }
      if (localevs.abyw.title != null) {
        paramString = localevs.abyw.title;
      }
      localObject2 = paramp;
      localObject1 = paramString;
      if (localevs.abyw.YGC == null) {
        break label2504;
      }
    }
    for (Object localObject1 = localevs.abyw.YGC;; localObject1 = localObject3)
    {
      localObject2 = new ArrayList();
      if ((localObject1 != null) && (((LinkedList)localObject1).size() > 0))
      {
        paramInt1 = 0;
        while (paramInt1 < ((LinkedList)localObject1).size())
        {
          localObject3 = (fhu)((LinkedList)localObject1).get(paramInt1);
          if (((fhu)localObject3).type.contains("text")) {
            ((ArrayList)localObject2).add(((fhu)localObject3).content);
          }
          paramInt1 += 1;
        }
      }
      Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp.BindTicket = %s", new Object[] { localevs.YNj });
      boolean bool;
      if (localevs.abyv == 1)
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("device_scan_mode", "SCAN_CATALOG");
        if ((localcyy.aaDN.contains("3")) || (localcyy.aaDN.contains("1"))) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          bool = localcyy.aaDN.contains("4");
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
          ((Intent)localObject1).putExtra("device_id", localcyx.vgV);
          ((Intent)localObject1).putExtra("device_type", localcyx.YJY);
          ((Intent)localObject1).putExtra("device_title", localcyy.aaDT);
          ((Intent)localObject1).putExtra("device_desc", localcyy.aaDU);
          ((Intent)localObject1).putExtra("device_icon_url", localcyy.IHo);
          ((Intent)localObject1).putExtra("device_category_id", localcyy.aaDV);
          ((Intent)localObject1).putExtra("device_brand_name", localcyy.aaDM);
          ((Intent)localObject1).putExtra("bind_ticket", localevs.YNj);
          ((Intent)localObject1).putExtra("device_ble_simple_proto", localcyy.kDi);
          ((Intent)localObject1).putExtra("device_airkiss_key", paramp);
          ((Intent)localObject1).putExtra("device_airkiss_title", paramString);
          ((Intent)localObject1).putStringArrayListExtra("device_airkiss_steps", (ArrayList)localObject2);
          com.tencent.mm.br.c.b(this.yss.hMB.context, "exdevice", ".ui.ExdeviceBindDeviceGuideUI", (Intent)localObject1);
          daL();
          AppMethodBeat.o(23438);
          return;
          if (bool) {
            ((Intent)localObject1).putExtra("device_scan_conn_proto", "wifi");
          }
        }
      }
      paramString = localevs.YNk;
      if (paramString == null)
      {
        Log.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mContact == null");
        dFM();
        AppMethodBeat.o(23438);
        return;
      }
      daL();
      if (paramString == null) {
        Log.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "unable to parse mod contact");
      }
      for (;;)
      {
        paramp = w.a(paramString.ZqL);
        if ((this.yss != null) && (this.yss.hMB != null) && (this.yss.hMB.context != null)) {
          break;
        }
        Log.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "a8KeyRedirectEvent null");
        AppMethodBeat.o(23438);
        return;
        paramp = w.a(paramString.ZqL);
        localObject1 = Util.nullAsNil(paramString.aaVR);
        if ((Util.isNullOrNil(paramp)) && (Util.isNullOrNil((String)localObject1)))
        {
          Log.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact user is null user:%s enuser:%s", new Object[] { paramp, localObject1 });
        }
        else
        {
          Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact : %s", new Object[] { paramp });
          bh.bCz();
          localObject2 = com.tencent.mm.model.c.bzA().JE(paramp);
          if ((localObject2 != null) && (paramp.equals(((az)localObject2).field_encryptUsername)))
          {
            Log.w("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "cat's replace user with stranger");
          }
          else
          {
            localObject3 = new au(paramp);
            ((au)localObject3).AV(paramString.pSk);
            ((au)localObject3).setType(paramString.ZoY & paramString.ZoZ);
            label1142:
            long l;
            if (!Util.isNullOrNil((String)localObject1))
            {
              ((au)localObject3).Bd((String)localObject1);
              if (localObject2 != null) {
                break label1675;
              }
              l = 0L;
              label1150:
              ((au)localObject3).maN = l;
              ((au)localObject3).setNickname(w.a(paramString.aaIz));
              ((au)localObject3).AY(w.a(paramString.ZpX));
              ((au)localObject3).AZ(w.a(paramString.ZpY));
              ((au)localObject3).pv(paramString.pSf);
              ((au)localObject3).py(paramString.Zpe);
              ((au)localObject3).AX(w.a(paramString.aaVL));
              ((au)localObject3).pz(paramString.Zpi);
              ((au)localObject3).pA(paramString.pSj);
              ((au)localObject3).Bu(RegionCodeDecoder.bI(paramString.pSo, paramString.pSg, paramString.pSh));
              ((au)localObject3).Bo(paramString.pSi);
              ((au)localObject3).pr(paramString.aaMm);
              ((au)localObject3).Bt(paramString.aaMn);
              ((au)localObject3).setSource(paramString.IcB);
              ((au)localObject3).pq(paramString.aaMq);
              ((au)localObject3).Ba(paramString.aaMp);
              if (ab.Jb(paramString.aaMo)) {
                ((au)localObject3).Bs(paramString.aaMo);
              }
              ((au)localObject3).pB((int)Util.nowSecond());
              ((au)localObject3).AW(w.a(paramString.aaVg));
              ((au)localObject3).Bb(w.a(paramString.aaVi));
              ((au)localObject3).Bc(w.a(paramString.aaVh));
              ((au)localObject3).Bv(paramString.crB);
              ((au)localObject3).Bw(paramString.aaWa);
              if ((localObject2 != null) && (!Util.nullAsNil(((az)localObject2).kam).equals(Util.nullAsNil(paramString.aaWa))))
              {
                com.tencent.mm.ba.c.bLL();
                com.tencent.mm.ba.c.OQ(paramp);
              }
              bh.bCz();
              com.tencent.mm.model.c.bzA().bxB(paramp);
              if (!Util.isNullOrNil(((az)localObject3).field_username)) {
                break label1687;
              }
              Log.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "dkinit dealModContactExtInfo failed invalid contact");
              label1467:
              ((au)localObject3).pt(paramString.DeleteFlag);
              if ((paramString.aaVW != null) && (paramString.aaVW.YGk != null))
              {
                ((au)localObject3).Bx(paramString.aaVW.YGk.YNT);
                ((au)localObject3).By(paramString.aaVW.YGk.YNU);
                ((au)localObject3).Bz(paramString.aaVW.YGk.YNV);
              }
              if (ab.IV(paramp)) {
                ((au)localObject3).aRZ();
              }
              if (((au)localObject3).iZC()) {
                ((au)localObject3).aSc();
              }
              if (Util.isNullOrNil((String)localObject1)) {
                break label2019;
              }
              bh.bCz();
              com.tencent.mm.model.c.bzA().e((String)localObject1, (au)localObject3);
            }
            for (;;)
            {
              if ((localObject2 == null) || ((((az)localObject2).field_type & 0x800) == (((az)localObject3).field_type & 0x800))) {
                break label2035;
              }
              if ((((az)localObject3).field_type & 0x800) == 0) {
                break label2037;
              }
              bh.bCz();
              com.tencent.mm.model.c.bzG().bxT(((az)localObject3).field_username);
              break;
              if ((localObject2 == null) || ((int)((com.tencent.mm.contact.d)localObject2).maN <= 0)) {
                break label1142;
              }
              ((au)localObject3).Bd(((az)localObject2).field_encryptUsername);
              break label1142;
              label1675:
              l = (int)((com.tencent.mm.contact.d)localObject2).maN;
              break label1150;
              label1687:
              Object localObject4 = ((az)localObject3).field_username;
              Object localObject5 = com.tencent.mm.modelavatar.d.a((String)localObject4, paramString, (au)localObject3);
              com.tencent.mm.modelavatar.q.bFE().b((j)localObject5);
              localObject5 = paramString.aaMs;
              if ((!((az)localObject3).field_username.endsWith("@chatroom")) && (localObject5 != null))
              {
                Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsFlag modcontact " + ((ffs)localObject5).pSq + " " + paramString.ZqL);
                Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBg modcontact " + ((ffs)localObject5).pSr);
                Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + ((ffs)localObject5).pSs);
                Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + ((ffs)localObject5).abFF);
                if (com.tencent.mm.plugin.sns.c.q.Qki != null) {
                  com.tencent.mm.plugin.sns.c.q.Qki.a(((az)localObject3).field_username, (ffs)localObject5);
                }
              }
              localObject5 = z.bAM();
              if ((localObject5 == null) || (((String)localObject5).equals(localObject4))) {
                break label1467;
              }
              localObject5 = af.bHf().Mn((String)localObject4);
              ((com.tencent.mm.api.c)localObject5).field_username = ((String)localObject4);
              ((com.tencent.mm.api.c)localObject5).field_brandList = paramString.pSp;
              localObject4 = paramString.aaMt;
              if (localObject4 != null)
              {
                ((com.tencent.mm.api.c)localObject5).field_brandFlag = ((ahl)localObject4).pSt;
                ((com.tencent.mm.api.c)localObject5).field_brandInfo = ((ahl)localObject4).pSv;
                ((com.tencent.mm.api.c)localObject5).field_brandIconURL = ((ahl)localObject4).pSw;
                ((com.tencent.mm.api.c)localObject5).field_extInfo = ((ahl)localObject4).pSu;
                ((com.tencent.mm.api.c)localObject5).field_attrSyncVersion = null;
                ((com.tencent.mm.api.c)localObject5).field_incrementUpdateTime = 0L;
              }
              if (!af.bHf().h((com.tencent.mm.api.c)localObject5)) {
                af.bHf().g((com.tencent.mm.api.c)localObject5);
              }
              ((au)localObject3).pC(((com.tencent.mm.api.c)localObject5).field_type);
              break label1467;
              label2019:
              bh.bCz();
              com.tencent.mm.model.c.bzA().aA((au)localObject3);
            }
            label2035:
            continue;
            label2037:
            bh.bCz();
            com.tencent.mm.model.c.bzG().bxU(((az)localObject3).field_username);
          }
        }
      }
      bh.bCz();
      paramString = com.tencent.mm.model.c.bzA().JE(paramp);
      if (paramString != null)
      {
        if (localcyy.kDh != 0)
        {
          Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to DeviceProfileUI.");
          paramp = this.yss.hMB.context;
          localObject1 = new Intent(paramp, ExdeviceDeviceProfileUI.class);
          if (!(paramp instanceof Activity)) {
            ((Intent)localObject1).addFlags(268435456);
          }
          ((Intent)localObject1).putExtra("device_id", localcyx.vgV);
          ((Intent)localObject1).putExtra("device_type", localcyx.YJY);
          ((Intent)localObject1).putExtra("device_mac", localcyy.YNe);
          ((Intent)localObject1).putExtra("device_brand_name", localcyy.aaDM);
          ((Intent)localObject1).putExtra("device_alias", localcyy.pSk);
          ((Intent)localObject1).putExtra("device_desc", localcyy.aaDU);
          ((Intent)localObject1).putExtra("device_title", localcyy.aaDT);
          ((Intent)localObject1).putExtra("device_icon_url", localcyy.IHo);
          ((Intent)localObject1).putExtra("device_jump_url", localcyy.IGI);
          ((Intent)localObject1).putExtra("bind_ticket", localevs.YNj);
          if (ah.dFO().gV(paramString.field_username, localcyx.vgV) != null) {}
          for (bool = true;; bool = false)
          {
            ((Intent)localObject1).putExtra("device_has_bound", bool);
            paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
            com.tencent.mm.hellhoundlib.a.a.b(paramp, paramString.aYi(), "com/tencent/mm/plugin/exdevice/model/SearchDeviceGetA8KeyRedirectListener", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramp.startActivity((Intent)paramString.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramp, "com/tencent/mm/plugin/exdevice/model/SearchDeviceGetA8KeyRedirectListener", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(23438);
            return;
          }
        }
        Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to ContactInfoUI.");
        paramString = new Intent();
        paramString.putExtra("Contact_User", paramp);
        paramString.putExtra("KIsHardDevice", true);
        paramString.putExtra("KHardDeviceBindTicket", localevs.YNj);
        paramString.putExtra("device_id", localcyx.vgV);
        paramString.putExtra("device_type", localcyx.YJY);
        com.tencent.mm.plugin.exdevice.a.dFc().c(paramString, this.yss.hMB.context);
        AppMethodBeat.o(23438);
        return;
      }
      AppMethodBeat.o(23438);
      return;
      label2504:
      paramp = (p)localObject2;
      paramString = (String)localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.SearchDeviceGetA8KeyRedirectListener
 * JD-Core Version:    0.7.0.1
 */