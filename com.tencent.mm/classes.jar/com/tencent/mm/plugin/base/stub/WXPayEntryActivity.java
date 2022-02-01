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
import com.tencent.mm.g.a.in;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.z;
import org.json.JSONObject;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class WXPayEntryActivity
  extends AutoLoginActivity
{
  private String inV = null;
  private long nTW = 0L;
  
  private static void a(Context paramContext, com.tencent.mm.pluginsdk.model.app.g paramg, String paramString, int paramInt)
  {
    AppMethodBeat.i(22322);
    Signature[] arrayOfSignature = q.bP(paramContext, paramString);
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
          localObject = (String)localObject + r.aNm(com.tencent.mm.b.g.getMessageDigest(paramContext.toByteArray())) + "|";
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
      paramContext.put("raw_package_name", bu.bI(paramString, ""));
      paramContext.put("package_name", bu.bI(paramg.field_packageName, ""));
      paramContext.put("raw_signature", localObject);
      paramContext.put("signature", bu.bI(paramg.field_signature, ""));
      paramContext.put("scene", paramInt);
      paramString = new in();
      paramString.dwd.appId = paramg.field_appId;
      paramString.dwd.opType = 3;
      paramString.dwd.dox = paramContext.toString();
      com.tencent.mm.sdk.b.a.IvT.l(paramString);
      AppMethodBeat.o(22322);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.i("MicroMsg.WXPayEntryActivity", "doIfAppInValid, jsonException = " + paramString.getMessage());
      }
    }
  }
  
  private PayReq bNs()
  {
    AppMethodBeat.i(22324);
    if (z.k(getIntent().getExtras(), "_wxapi_command_type") == 27) {}
    for (Object localObject = new WXJointPay.JointPayReq();; localObject = new PayReq())
    {
      ((PayReq)localObject).fromBundle(z.bl(getIntent()));
      AppMethodBeat.o(22324);
      return localObject;
    }
  }
  
  private PayResp bNt()
  {
    AppMethodBeat.i(22325);
    if (z.k(getIntent().getExtras(), "_wxapi_command_type") == 27) {}
    for (Object localObject = new WXJointPay.JointPayResp();; localObject = new PayResp())
    {
      AppMethodBeat.o(22325);
      return localObject;
    }
  }
  
  private void za(int paramInt)
  {
    AppMethodBeat.i(22323);
    PayReq localPayReq = bNs();
    PayReq.Options localOptions = new PayReq.Options();
    localOptions.fromBundle(z.bl(getIntent()));
    PayResp localPayResp = bNt();
    localPayResp.prepayId = localPayReq.prepayId;
    localPayResp.extData = localPayReq.extData;
    localPayResp.errCode = paramInt;
    e.a(this, z.getStringExtra(getIntent(), "_mmessage_appPackage"), localPayResp, localOptions);
    AppMethodBeat.o(22323);
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
    ae.i("MicroMsg.WXPayEntryActivity", "postLogin, delegate intent to OrderHandlerUI, resultCode = ".concat(String.valueOf(parama)));
    boolean bool;
    switch (2.nSR[parama.ordinal()])
    {
    default: 
      ae.e("MicroMsg.WXPayEntryActivity", "postLogin, unknown login result = ".concat(String.valueOf(parama)));
      this.inV = z.getStringExtra(paramIntent, "_mmessage_appPackage");
      ae.i("MicroMsg.WXPayEntryActivity", "postLogin, getCallingPackage success, value = " + this.inV);
      if ((getIntent() == null) || (z.bl(getIntent()) == null)) {
        bool = false;
      }
      break;
    }
    for (;;)
    {
      if (!bool) {
        ae.e("MicroMsg.WXPayEntryActivity", "postLogin, checkApp fail");
      }
      if (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).canOpenKindaCashier(this)) {
        break label565;
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
      ae.i("MicroMsg.WXPayEntryActivity", "coreaccount st %s", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.a.aiT()) });
      if (!com.tencent.mm.kernel.a.aiT()) {
        break;
      }
      finish();
      AppMethodBeat.o(22321);
      return;
      za(-2);
      ae.e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(parama)));
      finish();
      AppMethodBeat.o(22321);
      return;
      za(-1);
      ae.e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(parama)));
      finish();
      AppMethodBeat.o(22321);
      return;
      parama = bNs().appId;
      ae.d("MicroMsg.WXPayEntryActivity", "postLogin, appId = ".concat(String.valueOf(parama)));
      if ((parama == null) || (parama.length() == 0))
      {
        ae.e("MicroMsg.WXPayEntryActivity", "checkApp fail, appId is null");
        bool = false;
      }
      else
      {
        com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.m(parama, true, false);
        if (localg == null)
        {
          ae.w("MicroMsg.WXPayEntryActivity", "checkApp fail, not reg");
          localg = new com.tencent.mm.pluginsdk.model.app.g();
          localg.field_appId = parama;
          localg.field_appName = "";
          localg.field_packageName = this.inV;
          localg.field_status = 0;
          String str = q.bN(this, this.inV);
          if (str != null) {
            localg.field_signature = str;
          }
          if ((ao.dBg().q(localg)) && (bu.isNullOrNil(localg.field_openId)))
          {
            ae.d("MicroMsg.WXPayEntryActivity", "checkApp, trigger getAppSetting, appId = ".concat(String.valueOf(parama)));
            ao.dBi().EL(parama);
          }
          bool = true;
        }
        else if (localg.field_status == 3)
        {
          ae.e("MicroMsg.WXPayEntryActivity", "checkApp fail, app is in blacklist");
          bool = false;
        }
        else if (!q.a(this, localg, this.inV, true))
        {
          int i = z.k(getIntent().getExtras(), "_wxapi_command_type");
          a(this, localg, this.inV, i);
          ae.e("MicroMsg.WXPayEntryActivity", "checkApp fail, app invalid");
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
      label565:
      paramIntent.putExtra("key_scene", 0);
      parama = z.bl(paramIntent);
      parama.putLong("wallet_pay_key_check_time", this.nTW);
      f.a(this, parama, bool, "");
      finish();
      AppMethodBeat.o(22321);
      return;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.IntentUtil", parama, "", new Object[0]);
      }
    }
  }
  
  public final boolean ab(Intent paramIntent)
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22320);
    this.nTW = System.currentTimeMillis();
    z.b(getIntent(), "key_auto_login_wizard_exit", true);
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