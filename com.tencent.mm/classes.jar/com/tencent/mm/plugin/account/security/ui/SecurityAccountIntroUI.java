package com.tencent.mm.plugin.account.security.ui;

import android.app.Activity;
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
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.mi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public class SecurityAccountIntroUI
  extends MMWizardActivity
  implements i
{
  private static final String kju;
  private String dSf;
  private ProgressDialog gtM = null;
  private String jumpUrl;
  private String kbV;
  private String kjv;
  private String kjw;
  private boolean kjx = false;
  private Button kjy;
  
  static
  {
    AppMethodBeat.i(238820);
    kju = "https://" + WeChatHosts.domainString(2131761742) + "/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android";
    AppMethodBeat.o(238820);
  }
  
  private void bnm()
  {
    AppMethodBeat.i(125594);
    com.tencent.mm.plugin.b.a.bwV(this.kbV);
    cancel();
    ala(1);
    AppMethodBeat.o(125594);
  }
  
  public int getLayoutId()
  {
    return 2131496191;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125593);
    setMMTitle(2131764861);
    findViewById(2131305641).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(125586);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/security/ui/SecurityAccountIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        if (!SecurityAccountIntroUI.a(SecurityAccountIntroUI.this)) {}
        for (paramAnonymousView = new com.tencent.mm.modelfriend.a(SecurityAccountIntroUI.b(SecurityAccountIntroUI.this), 10, "", "", SecurityAccountIntroUI.c(SecurityAccountIntroUI.this));; paramAnonymousView = new z(SecurityAccountIntroUI.b(SecurityAccountIntroUI.this), 10, "", 0, ""))
        {
          g.azz().a(paramAnonymousView, 0);
          localObject = SecurityAccountIntroUI.this;
          SecurityAccountIntroUI localSecurityAccountIntroUI = SecurityAccountIntroUI.this;
          SecurityAccountIntroUI.this.getString(2131755998);
          SecurityAccountIntroUI.a((SecurityAccountIntroUI)localObject, h.a(localSecurityAccountIntroUI, SecurityAccountIntroUI.this.getString(2131764857), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(125585);
              g.azz().a(paramAnonymousView);
              AppMethodBeat.o(125585);
            }
          }));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/security/ui/SecurityAccountIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(125586);
          return;
        }
      }
    });
    if (!this.kjx)
    {
      this.kjy = ((Button)findViewById(2131298768));
      if (!Util.isNullOrNil(this.kjw)) {
        this.kjy.setText(this.kjw);
      }
      this.kjy.setVisibility(0);
      this.kjy.setOnClickListener(new SecurityAccountIntroUI.2(this));
    }
    setBackBtn(new SecurityAccountIntroUI.3(this));
    AppMethodBeat.o(125593);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125589);
    super.onCreate(paramBundle);
    this.kjv = getIntent().getStringExtra("auth_ticket");
    this.dSf = getIntent().getStringExtra("binded_mobile");
    this.kjx = getIntent().getBooleanExtra("re_open_verify", false);
    paramBundle = getIntent().getStringExtra("close_safe_device_style");
    Log.i("MicroMsg.SecurityAccountIntroUI", "summerphone authTicket[%s], showStyle[%s]", new Object[] { Util.secPrint(this.kjv), paramBundle });
    if (!Util.isNullOrNil(paramBundle))
    {
      paramBundle = XmlParser.parseXml(paramBundle, "wording", null);
      if (paramBundle != null)
      {
        this.kjw = ((String)paramBundle.get(".wording.title"));
        this.jumpUrl = ((String)paramBundle.get(".wording.url"));
        Log.i("MicroMsg.SecurityAccountIntroUI", "summerphone closeBtnText[%s], jumpUrl[%s]", new Object[] { this.kjw, this.jumpUrl });
      }
    }
    this.kbV = com.tencent.mm.plugin.b.a.bpZ();
    initView();
    AppMethodBeat.o(125589);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125592);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      bnm();
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
    g.azz().b(145, this);
    g.azz().b(132, this);
    if (!this.kjx)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.aAf();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L600_100,");
      g.aAf();
      com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("L600_100") + ",2");
    }
    AppMethodBeat.o(125591);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125590);
    super.onResume();
    g.azz().a(145, this);
    g.azz().a(132, this);
    if (!this.kjx)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.aAf();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L600_100,");
      g.aAf();
      com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("L600_100") + ",1");
      com.tencent.mm.plugin.b.a.bwU("L600_100");
    }
    AppMethodBeat.o(125590);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(125595);
    if ((this.gtM != null) && (this.gtM.isShowing()))
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!this.kjx) {}
      for (paramString = ((com.tencent.mm.modelfriend.a)paramq).bbH();; paramString = ((mi)((z)paramq).rr.iLL.iLR).KLk)
      {
        Log.d("MicroMsg.SecurityAccountIntroUI", "duanyi test authTicket_login = " + this.kjv + "duanyi test authTicket_check = " + paramString);
        paramq = new Intent(this, SecurityAccountVerifyUI.class);
        paramq.putExtra("auth_ticket", paramString);
        paramq.putExtra("binded_mobile", this.dSf);
        paramq.putExtra("re_open_verify", this.kjx);
        paramq.putExtra("from_source", getIntent().getIntExtra("from_source", 1));
        ay(this, paramq);
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
    while ((i != 0) || (com.tencent.mm.plugin.account.a.a.jRu.a(this, paramInt1, paramInt2, paramString)))
    {
      AppMethodBeat.o(125595);
      return;
      Toast.makeText(this, 2131755804, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, 2131756598, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, 2131756597, 0).show();
      i = 1;
      continue;
      h.a(this, 2131756594, 2131755998, null);
      i = 1;
    }
    Toast.makeText(this, getString(2131764855, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(125595);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountIntroUI
 * JD-Core Version:    0.7.0.1
 */