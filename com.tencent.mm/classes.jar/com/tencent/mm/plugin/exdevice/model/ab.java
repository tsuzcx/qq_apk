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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.af;
import com.tencent.mm.al.e;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.ig;
import com.tencent.mm.g.a.ig.a;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bpt;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.protocal.protobuf.cta;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.dg;
import com.tencent.mm.protocal.protobuf.dk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ab
  extends com.tencent.mm.sdk.b.c<ig>
  implements g
{
  private ProgressDialog fts;
  ig pzG;
  
  public ab()
  {
    AppMethodBeat.i(161355);
    this.__eventId = ig.class.getName().hashCode();
    AppMethodBeat.o(161355);
  }
  
  private boolean a(final ig paramig)
  {
    AppMethodBeat.i(23437);
    if (!(paramig instanceof ig))
    {
      ac.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mismatched event");
      AppMethodBeat.o(23437);
      return false;
    }
    this.pzG = paramig;
    paramig = this.pzG.dju.result;
    ac.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "action = %s, key = %s", new Object[] { Integer.valueOf(this.pzG.dju.actionCode), paramig });
    if (bs.isNullOrNil(paramig))
    {
      AppMethodBeat.o(23437);
      return false;
    }
    switch (this.pzG.dju.actionCode)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23437);
      return false;
      if ((this.pzG.dju.context == null) || (!(this.pzG.dju.context instanceof Activity)))
      {
        AppMethodBeat.o(23437);
        return false;
      }
      az.agi().a(540, this);
      paramig = new u(paramig);
      az.agi().a(paramig, 0);
      Context localContext = this.pzG.dju.context;
      this.pzG.dju.context.getString(2131755906);
      this.fts = h.c(localContext, this.pzG.dju.context.getString(2131762836), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(23436);
          az.agi().a(paramig);
          if (ab.this.pzG.callback != null)
          {
            ab.this.pzG.djv.ret = 1;
            ab.this.pzG.callback.run();
          }
          AppMethodBeat.o(23436);
        }
      });
    }
  }
  
  private void cgN()
  {
    AppMethodBeat.i(23439);
    if ((this.pzG != null) && (this.pzG.callback != null))
    {
      this.pzG.djv.ret = 1;
      this.pzG.callback.run();
    }
    AppMethodBeat.o(23439);
  }
  
  private void stopScan()
  {
    AppMethodBeat.i(23440);
    if ((this.pzG != null) && (this.pzG.callback != null))
    {
      this.pzG.djv.ret = 2;
      this.pzG.callback.run();
    }
    AppMethodBeat.o(23440);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(23438);
    ac.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    if ((this.fts != null) && (this.fts.isShowing())) {
      this.fts.dismiss();
    }
    if (paramn == null)
    {
      cgN();
      AppMethodBeat.o(23438);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ac.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
      cgN();
      AppMethodBeat.o(23438);
      return;
    }
    ac.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
    cta localcta;
    bjb localbjb;
    bjc localbjc;
    Object localObject3;
    Object localObject2;
    if (paramn.getType() == 540)
    {
      az.agi().b(540, this);
      paramString = (u)paramn;
      if ((paramString.rr != null) && (paramString.rr.hvs.hvw != null)) {}
      for (localcta = (cta)paramString.rr.hvs.hvw; localcta == null; localcta = null)
      {
        ac.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp == null");
        cgN();
        AppMethodBeat.o(23438);
        return;
      }
      localbjb = localcta.DYb;
      ac.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "deviceId = %s, deviceType = %s", new Object[] { localbjb.ncU, localbjb.DUp });
      localbjc = localcta.DYc;
      ac.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "AuthKey = %s, BrandName = %s, CloseStrategy = %s, ConnProto = %s, ConnStrategy = %s, Mac = %s", new Object[] { localbjc.DTH, localbjc.EXZ, Integer.valueOf(localbjc.EYc), localbjc.EYa, Integer.valueOf(localbjc.EYb), localbjc.DXq });
      paramn = "";
      paramString = "";
      localObject3 = new LinkedList();
      localObject2 = paramn;
      localObject1 = paramString;
      if (localcta.FFb == null) {
        break label2501;
      }
      if (localcta.FFb.DQx != null) {
        paramn = localcta.FFb.DQx;
      }
      if (localcta.FFb.title != null) {
        paramString = localcta.FFb.title;
      }
      localObject2 = paramn;
      localObject1 = paramString;
      if (localcta.FFb.DQy == null) {
        break label2501;
      }
    }
    for (Object localObject1 = localcta.FFb.DQy;; localObject1 = localObject3)
    {
      localObject2 = new ArrayList();
      if ((localObject1 != null) && (((LinkedList)localObject1).size() > 0))
      {
        paramInt1 = 0;
        while (paramInt1 < ((LinkedList)localObject1).size())
        {
          localObject3 = (ddb)((LinkedList)localObject1).get(paramInt1);
          if (((ddb)localObject3).type.contains("text")) {
            ((ArrayList)localObject2).add(((ddb)localObject3).content);
          }
          paramInt1 += 1;
        }
      }
      ac.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp.BindTicket = %s", new Object[] { localcta.DXv });
      boolean bool;
      if (localcta.FFa == 1)
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("device_scan_mode", "SCAN_CATALOG");
        if ((localbjc.EYa.contains("3")) || (localbjc.EYa.contains("1"))) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          bool = localbjc.EYa.contains("4");
          if ((paramInt1 == 0) || (!bool)) {
            break;
          }
          ac.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Category connect proto can not be blue&wifi at the same time...");
          AppMethodBeat.o(23438);
          return;
        }
        if (paramInt1 != 0) {
          ((Intent)localObject1).putExtra("device_scan_conn_proto", "blue");
        }
        for (;;)
        {
          ((Intent)localObject1).putExtra("device_id", localbjb.ncU);
          ((Intent)localObject1).putExtra("device_type", localbjb.DUp);
          ((Intent)localObject1).putExtra("device_title", localbjc.EYg);
          ((Intent)localObject1).putExtra("device_desc", localbjc.EYh);
          ((Intent)localObject1).putExtra("device_icon_url", localbjc.IconUrl);
          ((Intent)localObject1).putExtra("device_category_id", localbjc.EYi);
          ((Intent)localObject1).putExtra("device_brand_name", localbjc.EXZ);
          ((Intent)localObject1).putExtra("bind_ticket", localcta.DXv);
          ((Intent)localObject1).putExtra("device_ble_simple_proto", localbjc.eNk);
          ((Intent)localObject1).putExtra("device_airkiss_key", paramn);
          ((Intent)localObject1).putExtra("device_airkiss_title", paramString);
          ((Intent)localObject1).putStringArrayListExtra("device_airkiss_steps", (ArrayList)localObject2);
          d.b(this.pzG.dju.context, "exdevice", ".ui.ExdeviceBindDeviceGuideUI", (Intent)localObject1);
          stopScan();
          AppMethodBeat.o(23438);
          return;
          if (bool) {
            ((Intent)localObject1).putExtra("device_scan_conn_proto", "wifi");
          }
        }
      }
      paramString = localcta.DXw;
      if (paramString == null)
      {
        ac.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mContact == null");
        cgN();
        AppMethodBeat.o(23438);
        return;
      }
      stopScan();
      if (paramString == null) {
        ac.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "unable to parse mod contact");
      }
      for (;;)
      {
        paramn = z.a(paramString.EuE);
        if ((this.pzG != null) && (this.pzG.dju != null) && (this.pzG.dju.context != null)) {
          break;
        }
        ac.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "a8KeyRedirectEvent null");
        AppMethodBeat.o(23438);
        return;
        paramn = z.a(paramString.EuE);
        localObject1 = bs.nullAsNil(paramString.FkK);
        if ((bs.isNullOrNil(paramn)) && (bs.isNullOrNil((String)localObject1)))
        {
          ac.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact user is null user:%s enuser:%s", new Object[] { paramn, localObject1 });
        }
        else
        {
          ac.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact : %s", new Object[] { paramn });
          az.ayM();
          localObject2 = com.tencent.mm.model.c.awB().aNt(paramn);
          if ((localObject2 != null) && (paramn.equals(((av)localObject2).field_encryptUsername)))
          {
            ac.w("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "cat's replace user with stranger");
          }
          else
          {
            localObject3 = new ai(paramn);
            ((ai)localObject3).qg(paramString.iJY);
            ((ai)localObject3).setType(paramString.Etk & paramString.Etl);
            label1141:
            long l;
            if (!bs.isNullOrNil((String)localObject1))
            {
              ((ai)localObject3).qp((String)localObject1);
              if (localObject2 != null) {
                break label1674;
              }
              l = 0L;
              label1149:
              ((ai)localObject3).fLJ = l;
              ((ai)localObject3).qj(z.a(paramString.Fbd));
              ((ai)localObject3).qk(z.a(paramString.EtY));
              ((ai)localObject3).ql(z.a(paramString.EtZ));
              ((ai)localObject3).jH(paramString.iJT);
              ((ai)localObject3).jJ(paramString.Etq);
              ((ai)localObject3).qi(z.a(paramString.FkE));
              ((ai)localObject3).jK(paramString.Etu);
              ((ai)localObject3).jL(paramString.iJX);
              ((ai)localObject3).qG(RegionCodeDecoder.aW(paramString.iKc, paramString.iJU, paramString.iJV));
              ((ai)localObject3).qA(paramString.iJW);
              ((ai)localObject3).jD(paramString.Feq);
              ((ai)localObject3).qF(paramString.Fer);
              ((ai)localObject3).setSource(paramString.sVo);
              ((ai)localObject3).jC(paramString.Feu);
              ((ai)localObject3).qm(paramString.Fet);
              if (w.xx(paramString.Fes)) {
                ((ai)localObject3).qE(paramString.Fes);
              }
              ((ai)localObject3).jM((int)bs.aNx());
              ((ai)localObject3).qh(z.a(paramString.Fkk));
              ((ai)localObject3).qn(z.a(paramString.Fkm));
              ((ai)localObject3).qo(z.a(paramString.Fkl));
              ((ai)localObject3).qH(paramString.DPS);
              ((ai)localObject3).qI(paramString.FkT);
              if ((localObject2 != null) && (!bs.nullAsNil(((av)localObject2).eyg).equals(bs.nullAsNil(paramString.FkT))))
              {
                com.tencent.mm.bd.c.aGS();
                com.tencent.mm.bd.c.Da(paramn);
              }
              az.ayM();
              com.tencent.mm.model.c.awB().aNz(paramn);
              if (!bs.isNullOrNil(((av)localObject3).field_username)) {
                break label1686;
              }
              ac.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "dkinit dealModContactExtInfo failed invalid contact");
              label1466:
              ((ai)localObject3).jF(paramString.DeleteFlag);
              if ((paramString.FkP != null) && (paramString.FkP.DQl != null))
              {
                ((ai)localObject3).qJ(paramString.FkP.DQl.DYe);
                ((ai)localObject3).qK(paramString.FkP.DQl.DYf);
                ((ai)localObject3).qL(paramString.FkP.DQl.DYg);
              }
              if (w.xr(paramn)) {
                ((ai)localObject3).aao();
              }
              if (((ai)localObject3).fad()) {
                ((ai)localObject3).aar();
              }
              if (bs.isNullOrNil((String)localObject1)) {
                break label2016;
              }
              az.ayM();
              com.tencent.mm.model.c.awB().d((String)localObject1, (ai)localObject3);
            }
            for (;;)
            {
              if ((localObject2 == null) || ((((av)localObject2).field_type & 0x800) == (((av)localObject3).field_type & 0x800))) {
                break label2032;
              }
              if ((((av)localObject3).field_type & 0x800) == 0) {
                break label2034;
              }
              az.ayM();
              com.tencent.mm.model.c.awG().aNO(((av)localObject3).field_username);
              break;
              if ((localObject2 == null) || ((int)((com.tencent.mm.n.b)localObject2).fLJ <= 0)) {
                break label1141;
              }
              ((ai)localObject3).qp(((av)localObject2).field_encryptUsername);
              break label1141;
              label1674:
              l = (int)((com.tencent.mm.n.b)localObject2).fLJ;
              break label1149;
              label1686:
              Object localObject4 = ((av)localObject3).field_username;
              Object localObject5 = com.tencent.mm.aj.c.a((String)localObject4, paramString);
              p.aBw().b((i)localObject5);
              localObject5 = paramString.Few;
              if ((!((av)localObject3).field_username.endsWith("@chatroom")) && (localObject5 != null))
              {
                ac.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsFlag modcontact " + ((dbt)localObject5).iKe + " " + paramString.EuE);
                ac.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBg modcontact " + ((dbt)localObject5).iKf);
                ac.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + ((dbt)localObject5).iKg);
                ac.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + ((dbt)localObject5).FLb);
                if (o.xMb != null) {
                  o.xMb.a(((av)localObject3).field_username, (dbt)localObject5);
                }
              }
              localObject5 = com.tencent.mm.model.u.axw();
              if ((localObject5 == null) || (((String)localObject5).equals(localObject4))) {
                break label1466;
              }
              localObject5 = af.aCW().AE((String)localObject4);
              ((com.tencent.mm.api.c)localObject5).field_username = ((String)localObject4);
              ((com.tencent.mm.api.c)localObject5).field_brandList = paramString.iKd;
              localObject4 = paramString.Fex;
              if (localObject4 != null)
              {
                ((com.tencent.mm.api.c)localObject5).field_brandFlag = ((aaf)localObject4).iKh;
                ((com.tencent.mm.api.c)localObject5).field_brandInfo = ((aaf)localObject4).iKj;
                ((com.tencent.mm.api.c)localObject5).field_brandIconURL = ((aaf)localObject4).iKk;
                ((com.tencent.mm.api.c)localObject5).field_extInfo = ((aaf)localObject4).iKi;
                ((com.tencent.mm.api.c)localObject5).field_attrSyncVersion = null;
                ((com.tencent.mm.api.c)localObject5).field_incrementUpdateTime = 0L;
              }
              if (!af.aCW().g((com.tencent.mm.api.c)localObject5)) {
                af.aCW().f((com.tencent.mm.api.c)localObject5);
              }
              ((ai)localObject3).jN(((com.tencent.mm.api.c)localObject5).field_type);
              break label1466;
              label2016:
              az.ayM();
              com.tencent.mm.model.c.awB().af((ai)localObject3);
            }
            label2032:
            continue;
            label2034:
            az.ayM();
            com.tencent.mm.model.c.awG().aNP(((av)localObject3).field_username);
          }
        }
      }
      az.ayM();
      paramString = com.tencent.mm.model.c.awB().aNt(paramn);
      if (paramString != null)
      {
        if (localbjc.eNj != 0)
        {
          ac.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to DeviceProfileUI.");
          paramn = this.pzG.dju.context;
          localObject1 = new Intent(paramn, ExdeviceDeviceProfileUI.class);
          if (!(paramn instanceof Activity)) {
            ((Intent)localObject1).addFlags(268435456);
          }
          ((Intent)localObject1).putExtra("device_id", localbjb.ncU);
          ((Intent)localObject1).putExtra("device_type", localbjb.DUp);
          ((Intent)localObject1).putExtra("device_mac", localbjc.DXq);
          ((Intent)localObject1).putExtra("device_brand_name", localbjc.EXZ);
          ((Intent)localObject1).putExtra("device_alias", localbjc.iJY);
          ((Intent)localObject1).putExtra("device_desc", localbjc.EYh);
          ((Intent)localObject1).putExtra("device_title", localbjc.EYg);
          ((Intent)localObject1).putExtra("device_icon_url", localbjc.IconUrl);
          ((Intent)localObject1).putExtra("device_jump_url", localbjc.thh);
          ((Intent)localObject1).putExtra("bind_ticket", localcta.DXv);
          if (ad.cgP().fv(paramString.field_username, localbjb.ncU) != null) {}
          for (bool = true;; bool = false)
          {
            ((Intent)localObject1).putExtra("device_has_bound", bool);
            paramString = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(paramn, paramString.aeD(), "com/tencent/mm/plugin/exdevice/model/SearchDeviceGetA8KeyRedirectListener", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramn.startActivity((Intent)paramString.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramn, "com/tencent/mm/plugin/exdevice/model/SearchDeviceGetA8KeyRedirectListener", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(23438);
            return;
          }
        }
        ac.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to ContactInfoUI.");
        paramString = new Intent();
        paramString.putExtra("Contact_User", paramn);
        paramString.putExtra("KIsHardDevice", true);
        paramString.putExtra("KHardDeviceBindTicket", localcta.DXv);
        paramString.putExtra("device_id", localbjb.ncU);
        paramString.putExtra("device_type", localbjb.DUp);
        com.tencent.mm.plugin.exdevice.a.pwi.c(paramString, this.pzG.dju.context);
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