package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hx;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.modelpay.WXJointPay.JointPayReq;
import com.tencent.mm.opensdk.modelpay.WXJointPay.JointPayResp;
import com.tencent.mm.plugin.wallet_index.ui.e;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class WXPayEntryActivity
  extends AutoLoginActivity
{
  private String hrm = null;
  private long mLu = 0L;
  
  private static void a(Context paramContext, com.tencent.mm.pluginsdk.model.app.g paramg, String paramString, int paramInt)
  {
    AppMethodBeat.i(22322);
    Signature[] arrayOfSignature = q.bJ(paramContext, paramString);
    Object localObject = "";
    paramContext = (Context)localObject;
    if (arrayOfSignature != null)
    {
      paramContext = (Context)localObject;
      if (arrayOfSignature.length > 0)
      {
        int j = arrayOfSignature.length;
        int i = 0;
        for (;;)
        {
          paramContext = (Context)localObject;
          if (i >= j) {
            break;
          }
          paramContext = arrayOfSignature[i];
          localObject = (String)localObject + r.aAY(com.tencent.mm.b.g.getMessageDigest(paramContext.toByteArray())) + "|";
          i += 1;
        }
      }
    }
    localObject = paramContext;
    if (paramContext.length() > 1) {
      localObject = paramContext.substring(0, paramContext.length() - 1);
    }
    paramContext = new JSONObject();
    try
    {
      paramContext.put("raw_package_name", bt.by(paramString, ""));
      paramContext.put("package_name", bt.by(paramg.field_packageName, ""));
      paramContext.put("raw_signature", localObject);
      paramContext.put("signature", bt.by(paramg.field_signature, ""));
      paramContext.put("scene", paramInt);
      paramString = new hx();
      paramString.dlD.appId = paramg.field_appId;
      paramString.dlD.opType = 3;
      paramString.dlD.deE = paramContext.toString();
      com.tencent.mm.sdk.b.a.ESL.l(paramString);
      AppMethodBeat.o(22322);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.i("MicroMsg.WXPayEntryActivity", "doIfAppInValid, jsonException = " + paramString.getMessage());
      }
    }
  }
  
  private PayReq bBn()
  {
    AppMethodBeat.i(22324);
    if (y.k(getIntent().getExtras(), "_wxapi_command_type") == 27) {}
    for (Object localObject = new WXJointPay.JointPayReq();; localObject = new PayReq())
    {
      ((PayReq)localObject).fromBundle(y.be(getIntent()));
      AppMethodBeat.o(22324);
      return localObject;
    }
  }
  
  private PayResp bBo()
  {
    AppMethodBeat.i(22325);
    if (y.k(getIntent().getExtras(), "_wxapi_command_type") == 27) {}
    for (Object localObject = new WXJointPay.JointPayResp();; localObject = new PayResp())
    {
      AppMethodBeat.o(22325);
      return localObject;
    }
  }
  
  private void xp(int paramInt)
  {
    AppMethodBeat.i(22323);
    PayReq localPayReq = bBn();
    PayReq.Options localOptions = new PayReq.Options();
    localOptions.fromBundle(y.be(getIntent()));
    PayResp localPayResp = bBo();
    localPayResp.prepayId = localPayReq.prepayId;
    localPayResp.extData = localPayReq.extData;
    localPayResp.errCode = paramInt;
    e.a(this, y.getStringExtra(getIntent(), "_mmessage_appPackage"), localPayResp, localOptions);
    AppMethodBeat.o(22323);
  }
  
  public final boolean Z(Intent paramIntent)
  {
    return true;
  }
  
  public final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(22321);
    if (paramIntent == null)
    {
      finish();
      AppMethodBeat.o(22321);
      return;
    }
    ad.i("MicroMsg.WXPayEntryActivity", "postLogin, delegate intent to OrderHandlerUI, resultCode = ".concat(String.valueOf(parama)));
    boolean bool;
    switch (2.mKE[parama.ordinal()])
    {
    default: 
      ad.e("MicroMsg.WXPayEntryActivity", "postLogin, unknown login result = ".concat(String.valueOf(parama)));
      this.hrm = y.getStringExtra(paramIntent, "_mmessage_appPackage");
      ad.i("MicroMsg.WXPayEntryActivity", "postLogin, getCallingPackage success, value = " + this.hrm);
      if ((getIntent() == null) || (y.be(getIntent()) == null)) {
        bool = false;
      }
      break;
    }
    for (;;)
    {
      if (!bool) {
        ad.e("MicroMsg.WXPayEntryActivity", "postLogin, checkApp fail");
      }
      if (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).canOpenKindaCashier(this)) {
        break label569;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131765336), "", getString(2131756757), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(22318);
          WXPayEntryActivity.this.finish();
          AppMethodBeat.o(22318);
        }
      });
      AppMethodBeat.o(22321);
      return;
      ad.i("MicroMsg.WXPayEntryActivity", "coreaccount st %s", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.a.aeC()) });
      if (!com.tencent.mm.kernel.a.aeC()) {
        break;
      }
      finish();
      AppMethodBeat.o(22321);
      return;
      xp(-2);
      ad.e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(parama)));
      finish();
      AppMethodBeat.o(22321);
      return;
      xp(-1);
      ad.e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(parama)));
      finish();
      AppMethodBeat.o(22321);
      return;
      parama = bBn().appId;
      ad.d("MicroMsg.WXPayEntryActivity", "postLogin, appId = ".concat(String.valueOf(parama)));
      if ((parama == null) || (parama.length() == 0))
      {
        ad.e("MicroMsg.WXPayEntryActivity", "checkApp fail, appId is null");
        bool = false;
      }
      else
      {
        com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.j(parama, true, false);
        if (localg == null)
        {
          ad.w("MicroMsg.WXPayEntryActivity", "checkApp fail, not reg");
          localg = new com.tencent.mm.pluginsdk.model.app.g();
          localg.field_appId = parama;
          localg.field_appName = "";
          localg.field_packageName = this.hrm;
          localg.field_status = 0;
          String str = q.bH(this, this.hrm);
          if (str != null) {
            localg.field_signature = str;
          }
          if ((ap.cZQ().q(localg)) && (bt.isNullOrNil(localg.field_openId)))
          {
            ad.d("MicroMsg.WXPayEntryActivity", "checkApp, trigger getAppSetting, appId = ".concat(String.valueOf(parama)));
            ap.cZS().xe(parama);
          }
          bool = true;
        }
        else if (localg.field_status == 3)
        {
          ad.e("MicroMsg.WXPayEntryActivity", "checkApp fail, app is in blacklist");
          bool = false;
        }
        else if (!q.a(this, localg, this.hrm, true))
        {
          int i = y.k(getIntent().getExtras(), "_wxapi_command_type");
          a(this, localg, this.hrm, i);
          ad.e("MicroMsg.WXPayEntryActivity", "checkApp fail, app invalid");
          bool = false;
        }
        else
        {
          bool = true;
        }
      }
    }
    try
    {
      label569:
      paramIntent.putExtra("key_scene", 0);
      parama = y.be(paramIntent);
      parama.putLong("wallet_pay_key_check_time", this.mLu);
      f.a(this, parama, bool, "");
      finish();
      AppMethodBeat.o(22321);
      return;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.IntentUtil", parama, "", new Object[0]);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22320);
    this.mLu = System.currentTimeMillis();
    y.b(getIntent(), "key_auto_login_wizard_exit", true);
    super.onCreate(paramBundle);
    AppMethodBeat.o(22320);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXPayEntryActivity
 * JD-Core Version:    0.7.0.1
 */