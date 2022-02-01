package com.tencent.mm.plugin.account.security.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.account.friend.model.w;
import com.tencent.mm.plugin.account.security.a.a;
import com.tencent.mm.plugin.account.security.a.b;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.mz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.k;
import java.util.Map;

public class SecurityAccountIntroUI
  extends MMWizardActivity
  implements com.tencent.mm.am.h
{
  private static final String pYs;
  private String hRk;
  private String jumpUrl;
  private ProgressDialog lzP = null;
  private String pQb;
  private String pYt;
  private String pYu;
  private boolean pYv = false;
  private Button pYw;
  
  static
  {
    AppMethodBeat.i(304854);
    pYs = "https://" + WeChatHosts.domainString(a.d.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android";
    AppMethodBeat.o(304854);
  }
  
  private void bWj()
  {
    AppMethodBeat.i(125594);
    com.tencent.mm.plugin.b.a.TA(this.pQb);
    cancel();
    aAp(1);
    AppMethodBeat.o(125594);
  }
  
  public int getLayoutId()
  {
    return a.b.security_account_intro;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125593);
    setMMTitle(a.d.safe_device_verify_phone_title);
    findViewById(a.a.operation_btn).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(125586);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/security/ui/SecurityAccountIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if (!SecurityAccountIntroUI.a(SecurityAccountIntroUI.this)) {}
        for (paramAnonymousView = new com.tencent.mm.modelfriend.a(SecurityAccountIntroUI.b(SecurityAccountIntroUI.this), 10, "", "", SecurityAccountIntroUI.c(SecurityAccountIntroUI.this));; paramAnonymousView = new w(SecurityAccountIntroUI.b(SecurityAccountIntroUI.this), 10, "", 0, "", ""))
        {
          com.tencent.mm.kernel.h.aZW().a(paramAnonymousView, 0);
          localObject = SecurityAccountIntroUI.this;
          SecurityAccountIntroUI localSecurityAccountIntroUI = SecurityAccountIntroUI.this;
          SecurityAccountIntroUI.this.getString(a.d.app_tip);
          SecurityAccountIntroUI.a((SecurityAccountIntroUI)localObject, k.a(localSecurityAccountIntroUI, SecurityAccountIntroUI.this.getString(a.d.safe_device_sending_verify_code), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(125585);
              com.tencent.mm.kernel.h.aZW().a(paramAnonymousView);
              AppMethodBeat.o(125585);
            }
          }));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/security/ui/SecurityAccountIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(125586);
          return;
        }
      }
    });
    if (!this.pYv)
    {
      this.pYw = ((Button)findViewById(a.a.close_account_protect_btn));
      if (!Util.isNullOrNil(this.pYu)) {
        this.pYw.setText(this.pYu);
      }
      this.pYw.setVisibility(0);
      this.pYw.setOnClickListener(new SecurityAccountIntroUI.2(this));
    }
    setBackBtn(new SecurityAccountIntroUI.3(this));
    AppMethodBeat.o(125593);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125589);
    super.onCreate(paramBundle);
    this.pYt = getIntent().getStringExtra("auth_ticket");
    this.hRk = getIntent().getStringExtra("binded_mobile");
    this.pYv = getIntent().getBooleanExtra("re_open_verify", false);
    paramBundle = getIntent().getStringExtra("close_safe_device_style");
    Log.i("MicroMsg.SecurityAccountIntroUI", "summerphone authTicket[%s], showStyle[%s]", new Object[] { Util.secPrint(this.pYt), paramBundle });
    if (!Util.isNullOrNil(paramBundle))
    {
      paramBundle = XmlParser.parseXml(paramBundle, "wording", null);
      if (paramBundle != null)
      {
        this.pYu = ((String)paramBundle.get(".wording.title"));
        this.jumpUrl = ((String)paramBundle.get(".wording.url"));
        Log.i("MicroMsg.SecurityAccountIntroUI", "summerphone closeBtnText[%s], jumpUrl[%s]", new Object[] { this.pYu, this.jumpUrl });
      }
    }
    this.pQb = com.tencent.mm.plugin.b.a.chY();
    initView();
    AppMethodBeat.o(125589);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125592);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      bWj();
      AppMethodBeat.o(125592);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(125592);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(125591);
    super.onPause();
    com.tencent.mm.kernel.h.aZW().b(145, this);
    com.tencent.mm.kernel.h.aZW().b(132, this);
    if (!this.pYv)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.baC();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",L600_100,");
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.plugin.b.a.z(false, com.tencent.mm.kernel.b.Fw("L600_100") + ",2");
    }
    AppMethodBeat.o(125591);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125590);
    super.onResume();
    com.tencent.mm.kernel.h.aZW().a(145, this);
    com.tencent.mm.kernel.h.aZW().a(132, this);
    if (!this.pYv)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.baC();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",L600_100,");
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.plugin.b.a.z(true, com.tencent.mm.kernel.b.Fw("L600_100") + ",1");
      com.tencent.mm.plugin.b.a.Tz("L600_100");
    }
    AppMethodBeat.o(125590);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(125595);
    if ((this.lzP != null) && (this.lzP.isShowing()))
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!this.pYv) {}
      for (paramString = ((com.tencent.mm.modelfriend.a)paramp).bIR();; paramString = ((mz)c.c.b(((w)paramp).rr.otC)).YJu)
      {
        Log.d("MicroMsg.SecurityAccountIntroUI", "duanyi test authTicket_login = " + this.pYt + "duanyi test authTicket_check = " + paramString);
        paramp = new Intent(this, SecurityAccountVerifyUI.class);
        paramp.putExtra("auth_ticket", paramString);
        paramp.putExtra("binded_mobile", this.hRk);
        paramp.putExtra("re_open_verify", this.pYv);
        paramp.putExtra("from_source", getIntent().getIntExtra("from_source", 1));
        aQ(this, paramp);
        if (getIntent().getIntExtra("from_source", 1) == 3) {
          finish();
        }
        AppMethodBeat.o(125595);
        return;
      }
    }
    int i;
    switch (paramInt2)
    {
    default: 
      i = 0;
    }
    while ((i != 0) || (com.tencent.mm.plugin.account.sdk.a.pFo.a(this, paramInt1, paramInt2, paramString)))
    {
      AppMethodBeat.o(125595);
      return;
      Toast.makeText(this, a.d.app_err_system_busy_tip, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, a.d.bind_mcontact_err_freq_limit, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, a.d.bind_mcontact_err_format, 0).show();
      i = 1;
      continue;
      k.a(this, a.d.bind_mcontact_err_BindPhone_NeedAdjust, a.d.app_tip, null);
      i = 1;
    }
    Toast.makeText(this, getString(a.d.safe_device_send_verify_code_failed, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(125595);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountIntroUI
 * JD-Core Version:    0.7.0.1
 */