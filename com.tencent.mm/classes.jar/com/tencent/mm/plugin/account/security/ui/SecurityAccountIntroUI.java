package com.tencent.mm.plugin.account.security.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.lr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public class SecurityAccountIntroUI
  extends MMWizardActivity
  implements f
{
  private String dzn;
  private ProgressDialog fMu = null;
  private String jaZ;
  private boolean jiA = false;
  private Button jiB;
  private String jiy;
  private String jiz;
  private String jumpUrl;
  
  private void aSa()
  {
    AppMethodBeat.i(125594);
    com.tencent.mm.plugin.b.a.Ma(this.jaZ);
    cancel();
    abK(1);
    AppMethodBeat.o(125594);
  }
  
  public int getLayoutId()
  {
    return 2131495330;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125593);
    setMMTitle(2131762776);
    findViewById(2131303038).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(125586);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/security/ui/SecurityAccountIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if (!SecurityAccountIntroUI.a(SecurityAccountIntroUI.this)) {}
        for (paramAnonymousView = new com.tencent.mm.modelfriend.a(SecurityAccountIntroUI.b(SecurityAccountIntroUI.this), 10, "", "", SecurityAccountIntroUI.c(SecurityAccountIntroUI.this));; paramAnonymousView = new z(SecurityAccountIntroUI.b(SecurityAccountIntroUI.this), 10, "", 0, ""))
        {
          g.aiU().a(paramAnonymousView, 0);
          localObject = SecurityAccountIntroUI.this;
          SecurityAccountIntroUI localSecurityAccountIntroUI = SecurityAccountIntroUI.this;
          SecurityAccountIntroUI.this.getString(2131755906);
          SecurityAccountIntroUI.a((SecurityAccountIntroUI)localObject, h.b(localSecurityAccountIntroUI, SecurityAccountIntroUI.this.getString(2131762772), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(125585);
              g.aiU().a(paramAnonymousView);
              AppMethodBeat.o(125585);
            }
          }));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/security/ui/SecurityAccountIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(125586);
          return;
        }
      }
    });
    if (!this.jiA)
    {
      this.jiB = ((Button)findViewById(2131298363));
      if (!bt.isNullOrNil(this.jiz)) {
        this.jiB.setText(this.jiz);
      }
      this.jiB.setVisibility(0);
      this.jiB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(125587);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/security/ui/SecurityAccountIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          paramAnonymousView = ac.f(SecurityAccountIntroUI.this.getSharedPreferences(aj.fkC(), 0));
          localObject = new Intent();
          if (bt.isNullOrNil(SecurityAccountIntroUI.d(SecurityAccountIntroUI.this))) {
            ((Intent)localObject).putExtra("rawUrl", String.format("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android", new Object[] { paramAnonymousView }));
          }
          for (;;)
          {
            ((Intent)localObject).putExtra("useJs", true);
            ((Intent)localObject).putExtra("vertical_scroll", true);
            ((Intent)localObject).putExtra("title", SecurityAccountIntroUI.this.getString(2131762767));
            ((Intent)localObject).putExtra("show_bottom", false);
            ((Intent)localObject).putExtra("showShare", false);
            ((Intent)localObject).putExtra("neverGetA8Key", true);
            ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.FnD);
            ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.Fnz);
            com.tencent.mm.plugin.account.a.a.iRG.i((Intent)localObject, SecurityAccountIntroUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/security/ui/SecurityAccountIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(125587);
            return;
            ((Intent)localObject).putExtra("rawUrl", SecurityAccountIntroUI.d(SecurityAccountIntroUI.this));
          }
        }
      });
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(125588);
        SecurityAccountIntroUI.e(SecurityAccountIntroUI.this);
        AppMethodBeat.o(125588);
        return true;
      }
    });
    AppMethodBeat.o(125593);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125589);
    super.onCreate(paramBundle);
    this.jiy = getIntent().getStringExtra("auth_ticket");
    this.dzn = getIntent().getStringExtra("binded_mobile");
    this.jiA = getIntent().getBooleanExtra("re_open_verify", false);
    paramBundle = getIntent().getStringExtra("close_safe_device_style");
    ad.i("MicroMsg.SecurityAccountIntroUI", "summerphone authTicket[%s], showStyle[%s]", new Object[] { bt.aRp(this.jiy), paramBundle });
    if (!bt.isNullOrNil(paramBundle))
    {
      paramBundle = bw.M(paramBundle, "wording");
      if (paramBundle != null)
      {
        this.jiz = ((String)paramBundle.get(".wording.title"));
        this.jumpUrl = ((String)paramBundle.get(".wording.url"));
        ad.i("MicroMsg.SecurityAccountIntroUI", "summerphone closeBtnText[%s], jumpUrl[%s]", new Object[] { this.jiz, this.jumpUrl });
      }
    }
    this.jaZ = com.tencent.mm.plugin.b.a.Mp();
    initView();
    AppMethodBeat.o(125589);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125592);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      aSa();
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
    g.aiU().b(145, this);
    g.aiU().b(132, this);
    if (!this.jiA)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.ajA();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",L600_100,");
      g.ajA();
      com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("L600_100") + ",2");
    }
    AppMethodBeat.o(125591);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125590);
    super.onResume();
    g.aiU().a(145, this);
    g.aiU().a(132, this);
    if (!this.jiA)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.ajA();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",L600_100,");
      g.ajA();
      com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("L600_100") + ",1");
      com.tencent.mm.plugin.b.a.Kc("L600_100");
    }
    AppMethodBeat.o(125590);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(125595);
    if ((this.fMu != null) && (this.fMu.isShowing()))
    {
      this.fMu.dismiss();
      this.fMu = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!this.jiA) {}
      for (paramString = ((com.tencent.mm.modelfriend.a)paramn).aHx();; paramString = ((lr)((z)paramn).rr.hNL.hNQ).Fzf)
      {
        ad.d("MicroMsg.SecurityAccountIntroUI", "duanyi test authTicket_login = " + this.jiy + "duanyi test authTicket_check = " + paramString);
        paramn = new Intent(this, SecurityAccountVerifyUI.class);
        paramn.putExtra("auth_ticket", paramString);
        paramn.putExtra("binded_mobile", this.dzn);
        paramn.putExtra("re_open_verify", this.jiA);
        paramn.putExtra("from_source", getIntent().getIntExtra("from_source", 1));
        al(this, paramn);
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
    while ((i != 0) || (com.tencent.mm.plugin.account.a.a.iRH.a(this, paramInt1, paramInt2, paramString)))
    {
      AppMethodBeat.o(125595);
      return;
      Toast.makeText(this, 2131755733, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, 2131756462, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, 2131756461, 0).show();
      i = 1;
      continue;
      h.a(this, 2131756458, 2131755906, null);
      i = 1;
    }
    Toast.makeText(this, getString(2131762770, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(125595);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountIntroUI
 * JD-Core Version:    0.7.0.1
 */