package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.ku;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.modelpay.WXJointPay.JointPayReq;
import com.tencent.mm.opensdk.modelpay.WXJointPay.JointPayResp;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.wallet_index.ui.e;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.pluginsdk.model.app.v;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import org.json.JSONObject;

public class WXPayEntryActivity
  extends AutoLoginActivity
{
  private String oSi = null;
  private long vsH = 0L;
  
  private void GL(int paramInt)
  {
    AppMethodBeat.i(22323);
    PayReq localPayReq = dat();
    PayReq.Options localOptions = new PayReq.Options();
    localOptions.fromBundle(IntentUtil.getExtras(getIntent()));
    PayResp localPayResp = dau();
    localPayResp.prepayId = localPayReq.prepayId;
    localPayResp.extData = localPayReq.extData;
    localPayResp.errCode = paramInt;
    e.a(this, IntentUtil.getStringExtra(getIntent(), "_mmessage_appPackage"), localPayResp, localOptions);
    AppMethodBeat.o(22323);
  }
  
  private static void a(Context paramContext, com.tencent.mm.pluginsdk.model.app.g paramg, String paramString, int paramInt)
  {
    AppMethodBeat.i(22322);
    Signature[] arrayOfSignature = u.cG(paramContext, paramString);
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
          localObject = (String)localObject + v.bpX(com.tencent.mm.b.g.getMessageDigest(paramContext.toByteArray())) + "|";
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
      paramContext.put("raw_package_name", Util.nullAs(paramString, ""));
      paramContext.put("package_name", Util.nullAs(paramg.field_packageName, ""));
      paramContext.put("raw_signature", localObject);
      paramContext.put("signature", Util.nullAs(paramg.field_signature, ""));
      paramContext.put("scene", paramInt);
      paramString = new ku();
      paramString.hMs.appId = paramg.field_appId;
      paramString.hMs.opType = 3;
      paramString.hMs.hDd = paramContext.toString();
      paramString.publish();
      AppMethodBeat.o(22322);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.i("MicroMsg.WXPayEntryActivity", "doIfAppInValid, jsonException = " + paramString.getMessage());
      }
    }
  }
  
  private PayReq dat()
  {
    AppMethodBeat.i(22324);
    if (IntentUtil.getInt(getIntent().getExtras(), "_wxapi_command_type", 0) == 27) {}
    for (Object localObject = new WXJointPay.JointPayReq();; localObject = new PayReq())
    {
      ((PayReq)localObject).fromBundle(IntentUtil.getExtras(getIntent()));
      AppMethodBeat.o(22324);
      return localObject;
    }
  }
  
  private PayResp dau()
  {
    AppMethodBeat.i(22325);
    if (IntentUtil.getInt(getIntent().getExtras(), "_wxapi_command_type", 0) == 27) {}
    for (Object localObject = new WXJointPay.JointPayResp();; localObject = new PayResp())
    {
      AppMethodBeat.o(22325);
      return localObject;
    }
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
    Log.i("MicroMsg.WXPayEntryActivity", "postLogin, delegate intent to OrderHandlerUI, resultCode = ".concat(String.valueOf(parama)));
    switch (2.vrD[parama.ordinal()])
    {
    default: 
      Log.e("MicroMsg.WXPayEntryActivity", "postLogin, unknown login result = ".concat(String.valueOf(parama)));
      this.oSi = IntentUtil.getStringExtra(paramIntent, "_mmessage_appPackage");
      Log.i("MicroMsg.WXPayEntryActivity", "postLogin, getCallingPackage success, value = " + this.oSi);
    }
    for (;;)
    {
      try
      {
        parama = IntentUtil.getStringExtra(paramIntent, "_wxapi_payreq_appid");
        int j = IntentUtil.getIntExtra(paramIntent, "_mmessage_sdkVersion", 0);
        localObject = IntentUtil.getStringExtra(paramIntent, "_message_token");
        int k = IntentUtil.getInt(getIntent().getExtras(), "_wxapi_command_type", 0);
        str = this.oSi;
        if (!Util.isNullOrNil((String)localObject)) {
          continue;
        }
        i = 1;
        com.tencent.mm.plugin.report.service.h.OAn.b(15587, new Object[] { Integer.valueOf(0), Integer.valueOf(638058496), Integer.valueOf(j), Integer.valueOf(i), parama, Integer.valueOf(k), this.oSi, localObject, Integer.valueOf(i) });
      }
      catch (Exception parama)
      {
        ad.b localb;
        Log.printErrStackTrace("MicroMsg.WXPayEntryActivity", parama, "", new Object[0]);
        continue;
        parama = dat().appId;
        Log.d("MicroMsg.WXPayEntryActivity", "postLogin, appId = ".concat(String.valueOf(parama)));
        if ((parama != null) && (parama.length() != 0)) {
          continue;
        }
        Log.e("MicroMsg.WXPayEntryActivity", "checkApp fail, appId is null");
        boolean bool = false;
        continue;
        Object localObject = com.tencent.mm.pluginsdk.model.app.h.s(parama, true, false);
        if (localObject != null) {
          continue;
        }
        Log.w("MicroMsg.WXPayEntryActivity", "checkApp fail, not reg");
        localObject = new com.tencent.mm.pluginsdk.model.app.g();
        ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appId = parama;
        ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName = "";
        ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_packageName = this.oSi;
        ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_status = 0;
        String str = u.cE(this, this.oSi);
        if (str == null) {
          continue;
        }
        ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_signature = str;
        if ((!as.gxn().r((com.tencent.mm.pluginsdk.model.app.g)localObject)) || (!Util.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject).field_openId))) {
          continue;
        }
        Log.d("MicroMsg.WXPayEntryActivity", "checkApp, trigger getAppSetting, appId = ".concat(String.valueOf(parama)));
        as.gxp().add(parama);
        bool = true;
        continue;
        if (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_status != 3) {
          continue;
        }
        Log.e("MicroMsg.WXPayEntryActivity", "checkApp fail, app is in blacklist");
        bool = false;
        continue;
        if (u.a(this, (com.tencent.mm.pluginsdk.model.app.g)localObject, this.oSi, true)) {
          continue;
        }
        int i = IntentUtil.getInt(getIntent().getExtras(), "_wxapi_command_type", 0);
        a(this, (com.tencent.mm.pluginsdk.model.app.g)localObject, this.oSi, i);
        Log.e("MicroMsg.WXPayEntryActivity", "checkApp fail, app invalid");
        bool = false;
        continue;
        bool = true;
        continue;
        IntentUtil.putExtra(paramIntent, "key_scene", 0);
        parama = IntentUtil.getExtras(paramIntent);
        parama.putLong("wallet_pay_key_check_time", this.vsH);
        if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.znA, 0) != 1) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        finish();
        f.a(this, parama, bool, "");
        AppMethodBeat.o(22321);
        return;
        i = 0;
        continue;
        f.a(this, parama, bool, "");
        finish();
        AppMethodBeat.o(22321);
      }
      if ((getIntent() != null) && (IntentUtil.getExtras(getIntent()) != null)) {
        continue;
      }
      bool = false;
      if (!bool) {
        Log.e("MicroMsg.WXPayEntryActivity", "postLogin, checkApp fail");
      }
      if (((a)com.tencent.mm.kernel.h.ax(a.class)).canOpenKindaCashier(this)) {
        continue;
      }
      k.a(this, getString(R.l.wallet_is_paying_tips), "", getString(R.l.button_ok), new DialogInterface.OnClickListener()
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
      Log.i("MicroMsg.WXPayEntryActivity", "coreaccount st %s", new Object[] { Boolean.valueOf(b.aZG()) });
      if (!b.aZG()) {
        break;
      }
      finish();
      AppMethodBeat.o(22321);
      return;
      GL(-2);
      Log.e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(parama)));
      finish();
      AppMethodBeat.o(22321);
      return;
      GL(-1);
      Log.e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(parama)));
      finish();
      AppMethodBeat.o(22321);
      return;
      localb = ad.bCb().Jn((String)localObject);
      if (localb != null)
      {
        bool = localb.getString("open_sdk_token_package_name", "").equals(str);
        if (bool) {
          i = 0;
        } else {
          i = 3;
        }
      }
      else
      {
        i = 2;
      }
    }
  }
  
  public final boolean ad(Intent paramIntent)
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22320);
    this.vsH = System.currentTimeMillis();
    IntentUtil.putExtra(getIntent(), "key_auto_login_wizard_exit", true);
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