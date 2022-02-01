package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.plugin.account.sdk.b.a.a;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.ho;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMWizardActivity;
import java.io.IOException;

public class RegByMobileSetPwdUI
  extends SetPwdUI
{
  private String fAo = null;
  private String hint = null;
  private TextView nfC;
  public boolean niA;
  private int niB = 0;
  private eae niC = null;
  private TextView nit;
  private View niu;
  private View niv;
  private TextView niw;
  public View nix;
  public EditText niy;
  private boolean niz = false;
  
  protected final void a(a.a parama)
  {
    AppMethodBeat.i(128613);
    switch (3.nax[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128613);
      return;
      com.tencent.mm.ui.base.h.p(this, r.j.regbymobile_reg_setpwd_alert_diff, r.j.regbymobile_reg_setpwd_alert_title);
      AppMethodBeat.o(128613);
      return;
      com.tencent.mm.ui.base.h.p(this, r.j.regbymobile_reg_setpwd_alert_more_byte, r.j.regbymobile_reg_setpwd_alert_title);
      AppMethodBeat.o(128613);
      return;
      com.tencent.mm.ui.base.h.p(this, r.j.verify_password_all_num_tip, r.j.regbymobile_reg_setpwd_alert_title);
      AppMethodBeat.o(128613);
      return;
      com.tencent.mm.ui.base.h.p(this, r.j.verify_password_tip, r.j.regbymobile_reg_setpwd_alert_title);
    }
  }
  
  protected final q bzJ()
  {
    AppMethodBeat.i(128610);
    if (Util.isNullOrNil(this.fAo)) {
      this.fAo = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(77830, null));
    }
    aa localaa = new aa(this.njK, this.fAo, this.niB, this.niC);
    AppMethodBeat.o(128610);
    return localaa;
  }
  
  protected final String bzK()
  {
    AppMethodBeat.i(128609);
    String str = ((EditText)findViewById(r.f.regbymobilereg_pass_et)).getText().toString();
    AppMethodBeat.o(128609);
    return str;
  }
  
  protected final String bzL()
  {
    AppMethodBeat.i(128611);
    String str = ((EditText)findViewById(r.f.regbymobilereg_pass_again_et)).getText().toString();
    AppMethodBeat.o(128611);
    return str;
  }
  
  protected final void bzS()
  {
    AppMethodBeat.i(128612);
    if ((Util.isNullOrNil(this.fAo)) && (this.niA))
    {
      ad localad = new ad(this.niy.getText().toString(), "", "", "");
      com.tencent.mm.kernel.h.aGY().a(localad, 0);
      getString(r.j.app_tip);
      this.iXX = com.tencent.mm.ui.base.h.a(this, getString(r.j.app_sending), false, null);
      AppMethodBeat.o(128612);
      return;
    }
    super.bzS();
    AppMethodBeat.o(128612);
  }
  
  public final boolean bzT()
  {
    return true;
  }
  
  public int getLayoutId()
  {
    return r.g.regbymobilesetpwd_reg;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128608);
    if (!this.bxO) {
      showMMLogo();
    }
    setMMTitle(r.j.regbymobile_reg_setpwd_title);
    this.nit = ((TextView)findViewById(r.f.username_tv));
    this.niv = findViewById(r.f.account_container);
    this.nfC = ((TextView)findViewById(r.f.regbymobilerag_pass_hint));
    this.niw = ((TextView)findViewById(r.f.account_wording));
    if ((this.hint != null) && (this.hint.length() > 0)) {
      this.nfC.setText(this.hint);
    }
    this.nix = findViewById(r.f.regbymobile_reg_old_pwd_container);
    this.niy = ((EditText)this.nix.findViewById(r.f.regbymobilereg_old_pwd_et));
    this.niu = findViewById(r.f.forgot_old_password);
    this.niu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(128602);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/RegByMobileSetPwdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = (String)com.tencent.mm.kernel.h.aHG().aHp().b(6, null);
        if (Util.isNullOrNil(paramAnonymousView))
        {
          Log.i("MicorMsg.RegByMobileSetPwdUI", "has not bind mobile");
          paramAnonymousView = new Intent(RegByMobileSetPwdUI.this, BindMContactUI.class);
          paramAnonymousView.putExtra("bind_scene", 4);
          com.tencent.mm.ui.base.h.a(RegByMobileSetPwdUI.this, RegByMobileSetPwdUI.this.getString(r.j.regbymobile_reg_setpwd_no_mobile), "", RegByMobileSetPwdUI.this.getString(r.j.bind_start), RegByMobileSetPwdUI.this.getString(r.j.app_cancel), true, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(128600);
              MMWizardActivity.aH(RegByMobileSetPwdUI.this, paramAnonymousView);
              AppMethodBeat.o(128600);
            }
          }, null);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSetPwdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128602);
          return;
          Log.i("MicorMsg.RegByMobileSetPwdUI", "has bind mobile");
          com.tencent.mm.ui.base.h.a(RegByMobileSetPwdUI.this, RegByMobileSetPwdUI.this.getString(r.j.regbymobile_reg_setpwd_has_mobile, new Object[] { paramAnonymousView }), "", RegByMobileSetPwdUI.this.getString(r.j.app_send), RegByMobileSetPwdUI.this.getString(r.j.app_cancel), true, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(128601);
              paramAnonymous2DialogInterface = new Intent(RegByMobileSetPwdUI.this, MobileVerifyUI.class);
              paramAnonymous2DialogInterface.putExtra("bindmcontact_mobile", paramAnonymousView);
              paramAnonymous2DialogInterface.putExtra("mobile_verify_purpose", 5);
              RegByMobileSetPwdUI.this.startActivityForResult(paramAnonymous2DialogInterface, 10001);
              AppMethodBeat.o(128601);
            }
          }, null);
        }
      }
    });
    Object localObject3;
    if ((this.niz) || (!com.tencent.mm.kernel.h.aHE().aGM()))
    {
      this.niv.setVisibility(8);
      localObject1 = (TextView)findViewById(r.f.old_password_wording);
      localObject2 = (TextView)findViewById(r.f.password_wording);
      localObject3 = (TextView)findViewById(r.f.confirm_wording);
      EditText localEditText1 = (EditText)findViewById(r.f.regbymobilereg_pass_et);
      EditText localEditText2 = (EditText)findViewById(r.f.regbymobilereg_pass_again_et);
      if (!LocaleUtil.isChineseAppLang())
      {
        ((TextView)localObject1).setTextSize(1, 14.0F);
        ((TextView)localObject2).setTextSize(1, 14.0F);
        ((TextView)localObject3).setTextSize(1, 14.0F);
        localEditText1.setTextSize(1, 14.0F);
        localEditText2.setTextSize(1, 14.0F);
      }
      float f1 = this.niw.getPaint().measureText(this.niw.getText().toString());
      float f2 = ((TextView)localObject1).getPaint().measureText(((TextView)localObject1).getText().toString());
      float f3 = ((TextView)localObject2).getPaint().measureText(((TextView)localObject2).getText().toString());
      float f4 = ((TextView)localObject3).getPaint().measureText(((TextView)localObject3).getText().toString());
      f1 = Math.max(Math.max(Math.max(f1, f3), f4), f2);
      ((TextView)localObject1).setWidth((int)f1);
      this.niw.setWidth((int)f1);
      ((TextView)localObject2).setWidth((int)f1);
      ((TextView)localObject2).setWidth((int)f1);
      AppMethodBeat.o(128608);
      return;
    }
    this.niv.setVisibility(0);
    Object localObject2 = z.bda();
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2))
    {
      localObject2 = z.bcZ();
      localObject1 = localObject2;
      if (as.bvU((String)localObject2)) {
        localObject1 = null;
      }
    }
    if (Util.isNullOrNil((String)localObject1))
    {
      localObject2 = (String)com.tencent.mm.kernel.h.aHG().aHp().b(6, null);
      localObject1 = (String)com.tencent.mm.kernel.h.aHG().aHp().b(5, null);
      if (!Util.isNullOrNil((String)localObject2)) {
        if (Util.isPhoneNumber((String)localObject2).booleanValue())
        {
          localObject3 = new PhoneFormater();
          localObject1 = "86";
          if (!((String)localObject2).startsWith("+")) {
            break label712;
          }
          localObject2 = ((String)localObject2).replace("+", "");
          localObject1 = PhoneFormater.extractCountryCode((String)localObject2);
          if (localObject1 == null) {
            break label709;
          }
          localObject2 = ((String)localObject2).substring(((String)localObject1).length());
        }
      }
    }
    label709:
    label712:
    for (;;)
    {
      localObject1 = ((PhoneFormater)localObject3).formatNumber((String)localObject1, (String)localObject2);
      this.niw.setText(r.j.settings_mobile);
      this.nit.setText((CharSequence)localObject1);
      this.nfC.setText(r.j.regbymobile_reg_setpwd_title_mobile);
      break;
      if (!Util.isNullOrNil((String)localObject1))
      {
        this.nit.setText((CharSequence)localObject1);
        this.niw.setText(r.j.settings_email_addr);
        this.nfC.setText(r.j.regbymobile_reg_setpwd_title_email);
        break;
      }
      this.niv.setVisibility(8);
      break;
      this.niw.setText(r.j.settings_username);
      this.nit.setText((CharSequence)localObject1);
      break;
    }
  }
  
  protected final boolean o(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128614);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      finish();
      AppMethodBeat.o(128614);
      return true;
    }
    boolean bool = n(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(128614);
    return bool;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(128616);
    if ((paramInt1 == 10001) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("setpwd_ticket");
      Log.i("MicorMsg.RegByMobileSetPwdUI", "get reset pwd ticket %s", new Object[] { paramIntent });
      if (!Util.isNullOrNil(paramIntent))
      {
        this.fAo = paramIntent;
        this.niB = 6;
        this.nix.setVisibility(8);
        this.niu.setVisibility(8);
      }
    }
    AppMethodBeat.o(128616);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128605);
    super.onCreate(paramBundle);
    this.hint = getIntent().getStringExtra("kintent_hint");
    this.bxO = getIntent().getBooleanExtra("kintent_cancelable", true);
    this.niz = getIntent().getBooleanExtra("from_unbind", false);
    com.tencent.mm.kernel.h.aGY().a(384, this);
    com.tencent.mm.kernel.h.aGY().a(255, this);
    initView();
    paramBundle = Util.decodeHexString(bi.beN().getString("_auth_key", ""));
    ho localho = new ho();
    if (!Util.isNullOrNil(paramBundle)) {}
    for (this.niC = new eae().dc(paramBundle);; this.niC = new eae().dc(new byte[0])) {
      try
      {
        localho.parseFrom(paramBundle);
        paramBundle = new u(1);
        com.tencent.mm.kernel.h.aGY().a(paramBundle, 0);
        getString(r.j.app_tip);
        this.iXX = com.tencent.mm.ui.base.h.a(this, getString(r.j.app_loading), false, null);
        AppMethodBeat.o(128605);
        return;
      }
      catch (IOException paramBundle)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicorMsg.RegByMobileSetPwdUI", paramBundle, "summersetpwd Failed parse autoauthkey buf", new Object[0]);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128606);
    super.onDestroy();
    com.tencent.mm.kernel.h.aGY().b(384, this);
    com.tencent.mm.kernel.h.aGY().b(255, this);
    AppMethodBeat.o(128606);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(128607);
    super.onNewIntent(paramIntent);
    paramIntent = paramIntent.getStringExtra("setpwd_ticket");
    Log.i("MicorMsg.RegByMobileSetPwdUI", "onNewIntent get reset pwd ticket %s", new Object[] { paramIntent });
    if (!Util.isNullOrNil(paramIntent))
    {
      this.fAo = paramIntent;
      this.niB = 4;
      this.nix.setVisibility(8);
      this.niu.setVisibility(8);
    }
    AppMethodBeat.o(128607);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(128615);
    Log.i("MicorMsg.RegByMobileSetPwdUI", "errorCode %d, errorMsg %s, scene %s", new Object[] { Integer.valueOf(paramInt2), paramString, paramq });
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    if (paramq.getType() == 255)
    {
      if (((u)paramq).mae == 1)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.nix.setVisibility(0);
          this.niu.setVisibility(0);
          this.niA = true;
          AppMethodBeat.o(128615);
          return;
        }
        if ((paramInt2 == -3) && (paramInt1 == 4))
        {
          this.niA = false;
          AppMethodBeat.o(128615);
          return;
        }
        this.nix.setVisibility(0);
        this.niu.setVisibility(0);
        paramString = com.tencent.mm.h.a.Kb(paramString);
        if (paramString != null)
        {
          Log.i("MicorMsg.RegByMobileSetPwdUI", "summertips errCode[%d], showType[%d], url[%s], desc[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramString.fwp), paramString.url, paramString.desc });
          com.tencent.mm.ui.base.h.a(this, paramString.desc, paramString.fwr, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128603);
              RegByMobileSetPwdUI.this.finish();
              AppMethodBeat.o(128603);
            }
          });
        }
        AppMethodBeat.o(128615);
      }
    }
    else if (paramq.getType() == 384)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.kernel.h.aHG().aHp().i(77830, ((ad)paramq).bkW());
        bAh();
        AppMethodBeat.o(128615);
        return;
      }
      com.tencent.mm.ui.base.h.p(this, r.j.regbymobile_reg_setpwd_old_pwd_alert, r.j.app_tip);
    }
    AppMethodBeat.o(128615);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI
 * JD-Core Version:    0.7.0.1
 */