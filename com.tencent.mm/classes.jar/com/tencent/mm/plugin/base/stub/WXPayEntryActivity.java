package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import com.jg.JgClassChecked;
import com.tencent.mm.h.a.gz;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.plugin.wallet_index.ui.e;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class WXPayEntryActivity
  extends AutoLoginActivity
{
  private String eyT = null;
  private long hSH = 0L;
  
  private static void a(Context paramContext, f paramf, String paramString)
  {
    Signature[] arrayOfSignature = p.bj(paramContext, paramString);
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
          localObject = (String)localObject + p.VZ(com.tencent.mm.a.g.o(paramContext.toByteArray())) + "|";
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
      paramContext.put("raw_package_name", bk.aM(paramString, ""));
      paramContext.put("package_name", bk.aM(paramf.field_packageName, ""));
      paramContext.put("raw_signature", localObject);
      paramContext.put("signature", bk.aM(paramf.field_signature, ""));
      paramContext.put("scene", 5);
      paramString = new gz();
      paramString.bON.appId = paramf.field_appId;
      paramString.bON.opType = 3;
      paramString.bON.bIm = paramContext.toString();
      com.tencent.mm.sdk.b.a.udP.m(paramString);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        y.i("MicroMsg.WXPayEntryActivity", "doIfAppInValid, jsonException = " + paramString.getMessage());
      }
    }
  }
  
  private void nX(int paramInt)
  {
    PayReq localPayReq = new PayReq();
    localPayReq.fromBundle(t.al(getIntent()));
    PayReq.Options localOptions = new PayReq.Options();
    localOptions.fromBundle(t.al(getIntent()));
    PayResp localPayResp = new PayResp();
    localPayResp.prepayId = localPayReq.prepayId;
    localPayResp.extData = localPayReq.extData;
    localPayResp.errCode = paramInt;
    e.a(this, t.j(getIntent(), "_mmessage_appPackage"), localPayResp, localOptions);
  }
  
  protected final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    boolean bool2 = true;
    if (paramIntent == null)
    {
      finish();
      return;
    }
    y.i("MicroMsg.WXPayEntryActivity", "postLogin, delegate intent to OrderHandlerUI, resultCode = " + parama);
    switch (WXPayEntryActivity.1.hSj[parama.ordinal()])
    {
    default: 
      y.e("MicroMsg.WXPayEntryActivity", "postLogin, unknown login result = " + parama);
    }
    for (;;)
    {
      this.eyT = t.j(paramIntent, "_mmessage_appPackage");
      y.i("MicroMsg.WXPayEntryActivity", "postLogin, getCallingPackage success, value = " + this.eyT);
      boolean bool1;
      if ((getIntent() == null) || (t.al(getIntent()) == null))
      {
        bool1 = false;
        label142:
        if (!bool1) {
          y.e("MicroMsg.WXPayEntryActivity", "postLogin, checkApp fail");
        }
      }
      try
      {
        paramIntent.putExtra("key_scene", 0);
        parama = t.al(paramIntent);
        parama.putLong("wallet_pay_key_check_time", this.hSH);
        h.a(this, parama, bool1, "");
        finish();
        return;
        y.i("MicroMsg.WXPayEntryActivity", "coreaccount st %s", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.a.CW()) });
        if (!com.tencent.mm.kernel.a.CW()) {
          continue;
        }
        finish();
        return;
        nX(-2);
        y.e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = " + parama);
        finish();
        return;
        nX(-1);
        y.e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = " + parama);
        finish();
        return;
        parama = new PayReq();
        parama.fromBundle(t.al(getIntent()));
        parama = parama.appId;
        y.d("MicroMsg.WXPayEntryActivity", "postLogin, appId = " + parama);
        if ((parama == null) || (parama.length() == 0))
        {
          y.e("MicroMsg.WXPayEntryActivity", "checkApp fail, appId is null");
          bool1 = false;
          break label142;
        }
        f localf = com.tencent.mm.pluginsdk.model.app.g.by(parama, true);
        if (localf == null)
        {
          y.w("MicroMsg.WXPayEntryActivity", "checkApp fail, not reg");
          localf = new f();
          localf.field_appId = parama;
          localf.field_appName = "";
          localf.field_packageName = this.eyT;
          localf.field_status = 0;
          String str = p.bi(this, this.eyT);
          if (str != null) {
            localf.field_signature = str;
          }
          bool1 = bool2;
          if (!ap.brn().l(localf)) {
            break label142;
          }
          bool1 = bool2;
          if (!bk.bl(localf.field_openId)) {
            break label142;
          }
          y.d("MicroMsg.WXPayEntryActivity", "checkApp, trigger getAppSetting, appId = " + parama);
          ap.brp().qh(parama);
          bool1 = bool2;
          break label142;
        }
        if (localf.field_status == 3)
        {
          y.e("MicroMsg.WXPayEntryActivity", "checkApp fail, app is in blacklist");
          bool1 = false;
          break label142;
        }
        bool1 = bool2;
        if (p.c(this, localf, this.eyT)) {
          break label142;
        }
        a(this, localf, this.eyT);
        y.e("MicroMsg.WXPayEntryActivity", "checkApp fail, app invalid");
        bool1 = false;
      }
      catch (Exception parama)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.IntentUtil", parama, "", new Object[0]);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.hSH = System.currentTimeMillis();
    t.b(getIntent(), "key_auto_login_wizard_exit", true);
    super.onCreate(paramBundle);
  }
  
  protected final boolean w(Intent paramIntent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXPayEntryActivity
 * JD-Core Version:    0.7.0.1
 */