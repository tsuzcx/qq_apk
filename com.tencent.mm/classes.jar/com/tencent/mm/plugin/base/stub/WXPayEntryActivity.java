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
import com.tencent.mm.g.a.jc;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.modelpay.WXJointPay.JointPayReq;
import com.tencent.mm.opensdk.modelpay.WXJointPay.JointPayResp;
import com.tencent.mm.plugin.wallet_index.ui.e;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class WXPayEntryActivity
  extends AutoLoginActivity
{
  private String jjd = null;
  private long peJ = 0L;
  
  private void CH(int paramInt)
  {
    AppMethodBeat.i(22323);
    PayReq localPayReq = ckn();
    PayReq.Options localOptions = new PayReq.Options();
    localOptions.fromBundle(IntentUtil.getExtras(getIntent()));
    PayResp localPayResp = cko();
    localPayResp.prepayId = localPayReq.prepayId;
    localPayResp.extData = localPayReq.extData;
    localPayResp.errCode = paramInt;
    e.a(this, IntentUtil.getStringExtra(getIntent(), "_mmessage_appPackage"), localPayResp, localOptions);
    AppMethodBeat.o(22323);
  }
  
  private static void a(Context paramContext, com.tencent.mm.pluginsdk.model.app.g paramg, String paramString, int paramInt)
  {
    AppMethodBeat.i(22322);
    Signature[] arrayOfSignature = q.cj(paramContext, paramString);
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
          localObject = (String)localObject + r.bdM(com.tencent.mm.b.g.getMessageDigest(paramContext.toByteArray())) + "|";
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
      paramString = new jc();
      paramString.dNK.appId = paramg.field_appId;
      paramString.dNK.opType = 3;
      paramString.dNK.dFN = paramContext.toString();
      EventCenter.instance.publish(paramString);
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
  
  private PayReq ckn()
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
  
  private PayResp cko()
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
    boolean bool;
    switch (WXPayEntryActivity.2.pdF[parama.ordinal()])
    {
    default: 
      Log.e("MicroMsg.WXPayEntryActivity", "postLogin, unknown login result = ".concat(String.valueOf(parama)));
      this.jjd = IntentUtil.getStringExtra(paramIntent, "_mmessage_appPackage");
      Log.i("MicroMsg.WXPayEntryActivity", "postLogin, getCallingPackage success, value = " + this.jjd);
      if ((getIntent() == null) || (IntentUtil.getExtras(getIntent()) == null)) {
        bool = false;
      }
      break;
    }
    for (;;)
    {
      if (!bool) {
        Log.e("MicroMsg.WXPayEntryActivity", "postLogin, checkApp fail");
      }
      if (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).canOpenKindaCashier(this)) {
        break label566;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131767779), "", getString(2131756920), new DialogInterface.OnClickListener()
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
      Log.i("MicroMsg.WXPayEntryActivity", "coreaccount st %s", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.a.azj()) });
      if (!com.tencent.mm.kernel.a.azj()) {
        break;
      }
      finish();
      AppMethodBeat.o(22321);
      return;
      CH(-2);
      Log.e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(parama)));
      finish();
      AppMethodBeat.o(22321);
      return;
      CH(-1);
      Log.e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(parama)));
      finish();
      AppMethodBeat.o(22321);
      return;
      parama = ckn().appId;
      Log.d("MicroMsg.WXPayEntryActivity", "postLogin, appId = ".concat(String.valueOf(parama)));
      if ((parama == null) || (parama.length() == 0))
      {
        Log.e("MicroMsg.WXPayEntryActivity", "checkApp fail, appId is null");
        bool = false;
      }
      else
      {
        com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.o(parama, true, false);
        if (localg == null)
        {
          Log.w("MicroMsg.WXPayEntryActivity", "checkApp fail, not reg");
          localg = new com.tencent.mm.pluginsdk.model.app.g();
          localg.field_appId = parama;
          localg.field_appName = "";
          localg.field_packageName = this.jjd;
          localg.field_status = 0;
          String str = q.ch(this, this.jjd);
          if (str != null) {
            localg.field_signature = str;
          }
          if ((ao.eAS().r(localg)) && (Util.isNullOrNil(localg.field_openId)))
          {
            Log.d("MicroMsg.WXPayEntryActivity", "checkApp, trigger getAppSetting, appId = ".concat(String.valueOf(parama)));
            ao.eAU().add(parama);
          }
          bool = true;
        }
        else if (localg.field_status == 3)
        {
          Log.e("MicroMsg.WXPayEntryActivity", "checkApp fail, app is in blacklist");
          bool = false;
        }
        else if (!q.a(this, localg, this.jjd, true))
        {
          int i = IntentUtil.getInt(getIntent().getExtras(), "_wxapi_command_type", 0);
          a(this, localg, this.jjd, i);
          Log.e("MicroMsg.WXPayEntryActivity", "checkApp fail, app invalid");
          bool = false;
        }
        else
        {
          bool = true;
        }
      }
    }
    label566:
    IntentUtil.putExtra(paramIntent, "key_scene", 0);
    parama = IntentUtil.getExtras(paramIntent);
    parama.putLong("wallet_pay_key_check_time", this.peJ);
    f.a(this, parama, bool, "");
    finish();
    AppMethodBeat.o(22321);
  }
  
  public final boolean ab(Intent paramIntent)
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22320);
    this.peJ = System.currentTimeMillis();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXPayEntryActivity
 * JD-Core Version:    0.7.0.1
 */