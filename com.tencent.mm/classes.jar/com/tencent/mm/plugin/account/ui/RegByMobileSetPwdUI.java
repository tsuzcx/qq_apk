package com.tencent.mm.plugin.account.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.k.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.plugin.account.sdk.c.a.a;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.ik;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.k;
import java.io.IOException;

public class RegByMobileSetPwdUI
  extends SetPwdUI
{
  private String hFb = null;
  private String hint = null;
  private TextView qcL;
  private TextView qfH;
  private View qfI;
  private View qfJ;
  private TextView qfK;
  public View qfL;
  public EditText qfM;
  private boolean qfN = false;
  public boolean qfO;
  private int qfP = 0;
  private gol qfQ = null;
  
  protected final void a(a.a parama)
  {
    AppMethodBeat.i(128613);
    switch (3.pXF[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128613);
      return;
      k.s(this, r.j.regbymobile_reg_setpwd_alert_diff, r.j.regbymobile_reg_setpwd_alert_title);
      AppMethodBeat.o(128613);
      return;
      k.s(this, r.j.regbymobile_reg_setpwd_alert_more_byte, r.j.regbymobile_reg_setpwd_alert_title);
      AppMethodBeat.o(128613);
      return;
      k.s(this, r.j.verify_password_all_num_tip, r.j.regbymobile_reg_setpwd_alert_title);
      AppMethodBeat.o(128613);
      return;
      k.s(this, r.j.verify_password_tip, r.j.regbymobile_reg_setpwd_alert_title);
    }
  }
  
  protected final String bYA()
  {
    AppMethodBeat.i(128611);
    String str = ((EditText)findViewById(r.f.regbymobilereg_pass_again_et)).getText().toString();
    AppMethodBeat.o(128611);
    return str;
  }
  
  protected final void bYK()
  {
    AppMethodBeat.i(128612);
    if ((Util.isNullOrNil(this.hFb)) && (this.qfO))
    {
      ae localae = new ae(this.qfM.getText().toString(), "", "", "");
      h.aZW().a(localae, 0);
      getString(r.j.app_tip);
      this.lzP = k.a(this, getString(r.j.app_sending), false, null);
      AppMethodBeat.o(128612);
      return;
    }
    super.bYK();
    AppMethodBeat.o(128612);
  }
  
  public final boolean bYL()
  {
    return true;
  }
  
  protected final p bYy()
  {
    AppMethodBeat.i(128610);
    if (Util.isNullOrNil(this.hFb)) {
      this.hFb = ((String)h.baE().ban().d(77830, null));
    }
    ab localab = new ab(this.qgY, this.hFb, this.qfP, this.qfQ);
    AppMethodBeat.o(128610);
    return localab;
  }
  
  protected final String bYz()
  {
    AppMethodBeat.i(128609);
    String str = ((EditText)findViewById(r.f.regbymobilereg_pass_et)).getText().toString();
    AppMethodBeat.o(128609);
    return str;
  }
  
  public int getLayoutId()
  {
    return r.g.regbymobilesetpwd_reg;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128608);
    if (!this.dqR) {
      showMMLogo();
    }
    setMMTitle(r.j.regbymobile_reg_setpwd_title);
    this.qfH = ((TextView)findViewById(r.f.username_tv));
    this.qfJ = findViewById(r.f.account_container);
    this.qcL = ((TextView)findViewById(r.f.regbymobilerag_pass_hint));
    this.qfK = ((TextView)findViewById(r.f.account_wording));
    if ((this.hint != null) && (this.hint.length() > 0)) {
      this.qcL.setText(this.hint);
    }
    this.qfL = findViewById(r.f.regbymobile_reg_old_pwd_container);
    this.qfM = ((EditText)this.qfL.findViewById(r.f.regbymobilereg_old_pwd_et));
    this.qfI = findViewById(r.f.forgot_old_password);
    this.qfI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(128602);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/RegByMobileSetPwdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = (String)h.baE().ban().d(6, null);
        if ((z.bAT()) && (!Util.isNullOrNil(i.aRC().getValue("AffiliatedAcctForgetPwdUrl"))))
        {
          com.tencent.mm.plugin.account.sdk.c.a.b(RegByMobileSetPwdUI.this, i.aRC().getValue("AffiliatedAcctForgetPwdUrl"), 0, true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSetPwdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128602);
          return;
        }
        if (Util.isNullOrNil(paramAnonymousView))
        {
          Log.i("MicorMsg.RegByMobileSetPwdUI", "has not bind mobile");
          paramAnonymousView = new Intent(RegByMobileSetPwdUI.this, BindMContactUI.class);
          paramAnonymousView.putExtra("bind_scene", 4);
          k.a(RegByMobileSetPwdUI.this, RegByMobileSetPwdUI.this.getString(r.j.regbymobile_reg_setpwd_no_mobile), "", RegByMobileSetPwdUI.this.getString(r.j.bind_start), RegByMobileSetPwdUI.this.getString(r.j.app_cancel), true, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(128600);
              MMWizardActivity.aQ(RegByMobileSetPwdUI.this, paramAnonymousView);
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
          k.a(RegByMobileSetPwdUI.this, RegByMobileSetPwdUI.this.getString(r.j.regbymobile_reg_setpwd_has_mobile, new Object[] { paramAnonymousView }), "", RegByMobileSetPwdUI.this.getString(r.j.app_send), RegByMobileSetPwdUI.this.getString(r.j.app_cancel), true, new DialogInterface.OnClickListener()
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
    if ((this.qfN) || (!h.baC().aZN()))
    {
      this.qfJ.setVisibility(8);
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
      float f1 = this.qfK.getPaint().measureText(this.qfK.getText().toString());
      float f2 = ((TextView)localObject1).getPaint().measureText(((TextView)localObject1).getText().toString());
      float f3 = ((TextView)localObject2).getPaint().measureText(((TextView)localObject2).getText().toString());
      float f4 = ((TextView)localObject3).getPaint().measureText(((TextView)localObject3).getText().toString());
      f1 = Math.max(Math.max(Math.max(f1, f3), f4), f2);
      ((TextView)localObject1).setWidth((int)f1);
      this.qfK.setWidth((int)f1);
      ((TextView)localObject2).setWidth((int)f1);
      ((TextView)localObject2).setWidth((int)f1);
      AppMethodBeat.o(128608);
      return;
    }
    this.qfJ.setVisibility(0);
    Object localObject2 = z.bAN();
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2))
    {
      localObject2 = z.bAM();
      localObject1 = localObject2;
      if (au.bxb((String)localObject2)) {
        localObject1 = null;
      }
    }
    if (Util.isNullOrNil((String)localObject1))
    {
      localObject2 = (String)h.baE().ban().d(6, null);
      localObject1 = (String)h.baE().ban().d(5, null);
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
      this.qfK.setText(r.j.settings_mobile);
      this.qfH.setText((CharSequence)localObject1);
      this.qcL.setText(r.j.regbymobile_reg_setpwd_title_mobile);
      break;
      if (!Util.isNullOrNil((String)localObject1))
      {
        this.qfH.setText((CharSequence)localObject1);
        this.qfK.setText(r.j.settings_email_addr);
        this.qcL.setText(r.j.regbymobile_reg_setpwd_title_email);
        break;
      }
      this.qfJ.setVisibility(8);
      break;
      this.qfK.setText(r.j.settings_username);
      this.qfH.setText((CharSequence)localObject1);
      break;
    }
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
        this.hFb = paramIntent;
        this.qfP = 6;
        this.qfL.setVisibility(8);
        this.qfI.setVisibility(8);
      }
    }
    AppMethodBeat.o(128616);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128605);
    super.onCreate(paramBundle);
    this.hint = getIntent().getStringExtra("kintent_hint");
    this.dqR = getIntent().getBooleanExtra("kintent_cancelable", true);
    this.qfN = getIntent().getBooleanExtra("from_unbind", false);
    h.aZW().a(384, this);
    h.aZW().a(255, this);
    initView();
    paramBundle = Util.decodeHexString(bj.bCE().getString("_auth_key", ""));
    ik localik = new ik();
    if (!Util.isNullOrNil(paramBundle)) {}
    for (this.qfQ = new gol().df(paramBundle);; this.qfQ = new gol().df(new byte[0])) {
      try
      {
        localik.parseFrom(paramBundle);
        paramBundle = new v(1);
        h.aZW().a(paramBundle, 0);
        getString(r.j.app_tip);
        this.lzP = k.a(this, getString(r.j.app_loading), false, null);
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
    h.aZW().b(384, this);
    h.aZW().b(255, this);
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
      this.hFb = paramIntent;
      this.qfP = 4;
      this.qfL.setVisibility(8);
      this.qfI.setVisibility(8);
    }
    AppMethodBeat.o(128607);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(128615);
    Log.i("MicorMsg.RegByMobileSetPwdUI", "errorCode %d, errorMsg %s, scene %s", new Object[] { Integer.valueOf(paramInt2), paramString, paramp });
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    if (paramp.getType() == 255)
    {
      if (((v)paramp).oSU == 1)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.qfL.setVisibility(0);
          this.qfI.setVisibility(0);
          this.qfO = true;
          AppMethodBeat.o(128615);
          return;
        }
        if ((paramInt2 == -3) && (paramInt1 == 4))
        {
          this.qfO = false;
          AppMethodBeat.o(128615);
          return;
        }
        this.qfL.setVisibility(0);
        this.qfI.setVisibility(0);
        paramString = com.tencent.mm.broadcast.a.CH(paramString);
        if (paramString != null)
        {
          Log.i("MicorMsg.RegByMobileSetPwdUI", "summertips errCode[%d], showType[%d], url[%s], desc[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramString.hAN), paramString.url, paramString.desc });
          k.a(this, paramString.desc, paramString.hAP, false, new DialogInterface.OnClickListener()
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
    else if (paramp.getType() == 384)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        h.baE().ban().B(77830, ((ae)paramp).bIQ());
        bYZ();
        AppMethodBeat.o(128615);
        return;
      }
      k.s(this, r.j.regbymobile_reg_setpwd_old_pwd_alert, r.j.app_tip);
    }
    AppMethodBeat.o(128615);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final boolean q(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128614);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      finish();
      AppMethodBeat.o(128614);
      return true;
    }
    boolean bool = p(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(128614);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI
 * JD-Core Version:    0.7.0.1
 */