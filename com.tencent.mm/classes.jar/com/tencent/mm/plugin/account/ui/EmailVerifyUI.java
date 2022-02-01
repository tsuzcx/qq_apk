package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.plugin.account.friend.a.s.a;
import com.tencent.mm.plugin.account.friend.a.s.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView.a;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView.b;
import com.tencent.mm.ui.base.h;

public class EmailVerifyUI
  extends MMActivity
  implements f
{
  private ProgressDialog fMu = null;
  private String jaZ;
  private TextView jjp;
  private TextView jjq;
  private MMAutoSwitchEditTextView jjr;
  private Button jjs;
  private Button jjt;
  private String jju;
  private String jjv;
  private String jjw;
  private String jjx;
  private boolean jjy = false;
  
  private void goBack()
  {
    AppMethodBeat.i(127923);
    com.tencent.mm.plugin.b.a.Ma(this.jaZ);
    finish();
    AppMethodBeat.o(127923);
  }
  
  public int getLayoutId()
  {
    return 2131495823;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127921);
    setMMTitle(2131762301);
    this.jjp = ((TextView)findViewById(2131306285));
    String str = getString(2131762284);
    this.jjp.setText(Html.fromHtml(str));
    this.jjq = ((TextView)findViewById(2131299328));
    this.jju = getIntent().getStringExtra("email_address");
    if (!bt.isNullOrNil(this.jju))
    {
      this.jjq.setText(this.jju);
      this.jjw = getIntent().getStringExtra("password");
      this.jjv = getIntent().getStringExtra("email_login_page");
      ad.i("MicroMsg.EmailVerifyUI", "user register:email add:[%s], password not allowed to printf, login page:[%s]", new Object[] { this.jju, this.jjv });
      this.jjr = ((MMAutoSwitchEditTextView)findViewById(2131296992));
      this.jjr.setOnInputFinished(new MMAutoSwitchEditTextView.a()
      {
        public final void JT(String paramAnonymousString)
        {
          AppMethodBeat.i(127909);
          EmailVerifyUI.this.enableOptionMenu(true);
          EmailVerifyUI.a(EmailVerifyUI.this, paramAnonymousString);
          AppMethodBeat.o(127909);
        }
      });
      this.jjr.setOnTextChanged(new MMAutoSwitchEditTextView.b()
      {
        public final void aTK()
        {
          AppMethodBeat.i(127910);
          EmailVerifyUI.this.enableOptionMenu(false);
          AppMethodBeat.o(127910);
        }
      });
      this.jjt = ((Button)findViewById(2131303750));
      this.jjt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(127913);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/EmailVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = new StringBuilder();
          g.ajA();
          paramAnonymousView = paramAnonymousView.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R500_250,");
          g.ajA();
          com.tencent.mm.plugin.b.a.vk(com.tencent.mm.kernel.a.wS("R500_250") + ",3");
          h.a(EmailVerifyUI.this, 2131762292, 2131762282, 2131755835, 2131755691, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(127912);
              paramAnonymous2DialogInterface = new ab(EmailVerifyUI.a(EmailVerifyUI.this), EmailVerifyUI.b(EmailVerifyUI.this));
              g.aiU().a(paramAnonymous2DialogInterface, 0);
              EmailVerifyUI localEmailVerifyUI1 = EmailVerifyUI.this;
              EmailVerifyUI localEmailVerifyUI2 = EmailVerifyUI.this;
              EmailVerifyUI.this.getString(2131755906);
              EmailVerifyUI.a(localEmailVerifyUI1, h.b(localEmailVerifyUI2, EmailVerifyUI.this.getString(2131762300), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                {
                  AppMethodBeat.i(127911);
                  g.aiU().a(paramAnonymous2DialogInterface);
                  AppMethodBeat.o(127911);
                }
              }));
              AppMethodBeat.o(127912);
            }
          }, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/EmailVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(127913);
        }
      });
      this.jjs = ((Button)findViewById(2131303019));
      if ((!bt.isNullOrNil(this.jjv)) && (!bt.isNullOrNil(this.jju))) {
        break label305;
      }
      this.jjs.setVisibility(8);
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(127915);
          EmailVerifyUI.d(EmailVerifyUI.this);
          AppMethodBeat.o(127915);
          return true;
        }
      });
      addTextOptionMenu(0, getString(2131755830), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(127916);
          EmailVerifyUI.b(EmailVerifyUI.this, EmailVerifyUI.e(EmailVerifyUI.this).getText());
          if ((!bt.isNullOrNil(EmailVerifyUI.f(EmailVerifyUI.this))) && (EmailVerifyUI.f(EmailVerifyUI.this).length() == 12)) {
            EmailVerifyUI.a(EmailVerifyUI.this, EmailVerifyUI.f(EmailVerifyUI.this));
          }
          for (;;)
          {
            AppMethodBeat.o(127916);
            return true;
            EmailVerifyUI.this.enableOptionMenu(false);
          }
        }
      });
      enableOptionMenu(false);
      AppMethodBeat.o(127921);
      return;
      ad.w("MicroMsg.EmailVerifyUI", "email add is null or nill");
      break;
      label305:
      this.jjs.setVisibility(0);
      this.jjs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(127914);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/EmailVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          bt.cd(EmailVerifyUI.this, EmailVerifyUI.c(EmailVerifyUI.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/EmailVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(127914);
        }
      });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127918);
    super.onCreate(paramBundle);
    initView();
    this.jaZ = com.tencent.mm.plugin.b.a.Mp();
    AppMethodBeat.o(127918);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(127922);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(127922);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(127922);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(127920);
    super.onPause();
    g.aiU().b(481, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.ajA();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R500_200,");
    g.ajA();
    com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("R500_200") + ",2");
    AppMethodBeat.o(127920);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127919);
    super.onResume();
    g.aiU().a(481, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.ajA();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R500_200,");
    g.ajA();
    com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("R500_200") + ",1");
    com.tencent.mm.plugin.b.a.Kc("R500_200");
    AppMethodBeat.o(127919);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(127924);
    ad.i("MicroMsg.EmailVerifyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    this.jjy = false;
    if ((this.fMu != null) && (this.fMu.isShowing()))
    {
      this.fMu.dismiss();
      this.fMu = null;
    }
    if (paramn.getType() != 481)
    {
      ad.e("MicroMsg.EmailVerifyUI", "error cgi type callback:[%d]", new Object[] { Integer.valueOf(paramn.getType()) });
      AppMethodBeat.o(127924);
      return;
    }
    int j = ((s.a)((ab)paramn).hON.getReqObj()).jdU.FAt;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (j == 2)
      {
        com.tencent.mm.plugin.b.a.Ma("R200_900_email");
        paramString = new Intent(this, RegSetInfoUI.class);
        paramString.putExtra("regsetinfo_ticket", ((s.b)((ab)paramn).hON.getRespObj()).jdV.xbo);
        paramString.putExtra("regsetinfo_user", this.jju);
        paramString.putExtra("regsetinfo_ismobile", 3);
        paramString.putExtra("regsetinfo_NextStyle", ((ab)paramn).aKW());
        paramString.putExtra("regsetinfo_pwd", this.jjw);
        paramString.putExtra("regsetinfo_bind_email", this.jju);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/account/ui/EmailVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/EmailVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(127924);
        return;
      }
      if (j == 1)
      {
        paramString = new StringBuilder();
        g.ajA();
        paramString = paramString.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R22_resend_email_code_alert,");
        g.ajA();
        com.tencent.mm.plugin.b.a.vk(com.tencent.mm.kernel.a.wS("R22_resend_email_code_alert") + ",3");
        h.cl(this, getString(2131762294));
        AppMethodBeat.o(127924);
        return;
      }
      ad.e("MicroMsg.EmailVerifyUI", "err opcode");
      AppMethodBeat.o(127924);
      return;
    }
    int i;
    if (com.tencent.mm.plugin.account.a.a.iRH.a(this, paramInt1, paramInt2, paramString)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(127924);
      return;
      switch (paramInt2)
      {
      default: 
        i = 0;
        break;
      case -32: 
        h.a(this, 2131762283, 2131762282, null);
        paramString = new StringBuilder();
        g.ajA();
        paramString = paramString.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R500_260,");
        g.ajA();
        com.tencent.mm.plugin.b.a.vk(com.tencent.mm.kernel.a.wS("R500_260") + ",3");
        i = 1;
        break;
      case -33: 
        h.a(this, 2131762281, 2131762282, null);
        i = 1;
        break;
      case -34: 
        Toast.makeText(this, 2131762280, 0).show();
        i = 1;
      }
    }
    if (j == 2)
    {
      Toast.makeText(this, getString(2131762302, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(127924);
      return;
    }
    if (j == 1) {
      Toast.makeText(this, getString(2131762293, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(127924);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.EmailVerifyUI
 * JD-Core Version:    0.7.0.1
 */