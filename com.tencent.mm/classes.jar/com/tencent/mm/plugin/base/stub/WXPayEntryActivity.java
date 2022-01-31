package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hd;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.plugin.wallet_index.ui.e;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class WXPayEntryActivity
  extends AutoLoginActivity
{
  private String fOI = null;
  private long jMt = 0L;
  
  private static void a(Context paramContext, f paramf, String paramString)
  {
    AppMethodBeat.i(18223);
    Signature[] arrayOfSignature = p.bv(paramContext, paramString);
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
          localObject = (String)localObject + q.aly(com.tencent.mm.a.g.w(paramContext.toByteArray())) + "|";
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
      paramContext.put("raw_package_name", bo.bf(paramString, ""));
      paramContext.put("package_name", bo.bf(paramf.field_packageName, ""));
      paramContext.put("raw_signature", localObject);
      paramContext.put("signature", bo.bf(paramf.field_signature, ""));
      paramContext.put("scene", 5);
      paramString = new hd();
      paramString.cwe.appId = paramf.field_appId;
      paramString.cwe.opType = 3;
      paramString.cwe.cpH = paramContext.toString();
      com.tencent.mm.sdk.b.a.ymk.l(paramString);
      AppMethodBeat.o(18223);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.i("MicroMsg.WXPayEntryActivity", "doIfAppInValid, jsonException = " + paramString.getMessage());
      }
    }
  }
  
  private void rK(int paramInt)
  {
    AppMethodBeat.i(18224);
    PayReq localPayReq = new PayReq();
    localPayReq.fromBundle(w.aL(getIntent()));
    PayReq.Options localOptions = new PayReq.Options();
    localOptions.fromBundle(w.aL(getIntent()));
    PayResp localPayResp = new PayResp();
    localPayResp.prepayId = localPayReq.prepayId;
    localPayResp.extData = localPayReq.extData;
    localPayResp.errCode = paramInt;
    e.a(this, w.n(getIntent(), "_mmessage_appPackage"), localPayResp, localOptions);
    AppMethodBeat.o(18224);
  }
  
  public final boolean O(Intent paramIntent)
  {
    return true;
  }
  
  public final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(18222);
    if (paramIntent == null)
    {
      finish();
      AppMethodBeat.o(18222);
      return;
    }
    ab.i("MicroMsg.WXPayEntryActivity", "postLogin, delegate intent to OrderHandlerUI, resultCode = ".concat(String.valueOf(parama)));
    boolean bool;
    switch (WXPayEntryActivity.2.jLR[parama.ordinal()])
    {
    default: 
      ab.e("MicroMsg.WXPayEntryActivity", "postLogin, unknown login result = ".concat(String.valueOf(parama)));
      this.fOI = w.n(paramIntent, "_mmessage_appPackage");
      ab.i("MicroMsg.WXPayEntryActivity", "postLogin, getCallingPackage success, value = " + this.fOI);
      if ((getIntent() == null) || (w.aL(getIntent()) == null)) {
        bool = false;
      }
      break;
    }
    for (;;)
    {
      if (!bool) {
        ab.e("MicroMsg.WXPayEntryActivity", "postLogin, checkApp fail");
      }
      if (((b)com.tencent.mm.kernel.g.E(b.class)).canOpenKindaCashier(this)) {
        break label556;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131305144), "", getString(2131297828), new WXPayEntryActivity.1(this));
      AppMethodBeat.o(18222);
      return;
      ab.i("MicroMsg.WXPayEntryActivity", "coreaccount st %s", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.a.QP()) });
      if (!com.tencent.mm.kernel.a.QP()) {
        break;
      }
      finish();
      AppMethodBeat.o(18222);
      return;
      rK(-2);
      ab.e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(parama)));
      finish();
      AppMethodBeat.o(18222);
      return;
      rK(-1);
      ab.e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(parama)));
      finish();
      AppMethodBeat.o(18222);
      return;
      parama = new PayReq();
      parama.fromBundle(w.aL(getIntent()));
      parama = parama.appId;
      ab.d("MicroMsg.WXPayEntryActivity", "postLogin, appId = ".concat(String.valueOf(parama)));
      if ((parama == null) || (parama.length() == 0))
      {
        ab.e("MicroMsg.WXPayEntryActivity", "checkApp fail, appId is null");
        bool = false;
      }
      else
      {
        f localf = com.tencent.mm.pluginsdk.model.app.g.ca(parama, true);
        if (localf == null)
        {
          ab.w("MicroMsg.WXPayEntryActivity", "checkApp fail, not reg");
          localf = new f();
          localf.field_appId = parama;
          localf.field_appName = "";
          localf.field_packageName = this.fOI;
          localf.field_status = 0;
          String str = p.bu(this, this.fOI);
          if (str != null) {
            localf.field_signature = str;
          }
          if ((al.cac().p(localf)) && (bo.isNullOrNil(localf.field_openId)))
          {
            ab.d("MicroMsg.WXPayEntryActivity", "checkApp, trigger getAppSetting, appId = ".concat(String.valueOf(parama)));
            al.cae().xB(parama);
          }
          bool = true;
        }
        else if (localf.field_status == 3)
        {
          ab.e("MicroMsg.WXPayEntryActivity", "checkApp fail, app is in blacklist");
          bool = false;
        }
        else if (!p.a(this, localf, this.fOI, true))
        {
          a(this, localf, this.fOI);
          ab.e("MicroMsg.WXPayEntryActivity", "checkApp fail, app invalid");
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
      label556:
      paramIntent.putExtra("key_scene", 0);
      parama = w.aL(paramIntent);
      parama.putLong("wallet_pay_key_check_time", this.jMt);
      com.tencent.mm.pluginsdk.wallet.h.a(this, parama, bool, "");
      finish();
      AppMethodBeat.o(18222);
      return;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.IntentUtil", parama, "", new Object[0]);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(18221);
    this.jMt = System.currentTimeMillis();
    w.b(getIntent(), "key_auto_login_wizard_exit", true);
    super.onCreate(paramBundle);
    AppMethodBeat.o(18221);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXPayEntryActivity
 * JD-Core Version:    0.7.0.1
 */