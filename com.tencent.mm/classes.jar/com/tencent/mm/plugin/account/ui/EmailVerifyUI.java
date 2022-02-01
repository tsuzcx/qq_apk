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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.plugin.account.friend.a.s.a;
import com.tencent.mm.plugin.account.friend.a.s.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.air;
import com.tencent.mm.protocal.protobuf.ais;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView.a;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView.b;
import com.tencent.mm.ui.base.h;

public class EmailVerifyUI
  extends MMActivity
  implements i
{
  private ProgressDialog gtM = null;
  private String kbV;
  private boolean kkA = false;
  private TextView kkr;
  private TextView kks;
  private MMAutoSwitchEditTextView kkt;
  private Button kku;
  private Button kkv;
  private String kkw;
  private String kkx;
  private String kky;
  private String kkz;
  
  private void goBack()
  {
    AppMethodBeat.i(127923);
    com.tencent.mm.plugin.b.a.bwV(this.kbV);
    finish();
    AppMethodBeat.o(127923);
  }
  
  public int getLayoutId()
  {
    return 2131496786;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127921);
    setMMTitle(2131764367);
    this.kkr = ((TextView)findViewById(2131309696));
    String str = getString(2131764350);
    this.kkr.setText(Html.fromHtml(str));
    this.kks = ((TextView)findViewById(2131299940));
    this.kkw = getIntent().getStringExtra("email_address");
    if (!Util.isNullOrNil(this.kkw))
    {
      this.kks.setText(this.kkw);
      this.kky = getIntent().getStringExtra("password");
      this.kkx = getIntent().getStringExtra("email_login_page");
      Log.i("MicroMsg.EmailVerifyUI", "user register:email add:[%s], password not allowed to printf, login page:[%s]", new Object[] { this.kkw, this.kkx });
      this.kkt = ((MMAutoSwitchEditTextView)findViewById(2131297115));
      this.kkt.setOnInputFinished(new MMAutoSwitchEditTextView.a()
      {
        public final void Tq(String paramAnonymousString)
        {
          AppMethodBeat.i(127909);
          EmailVerifyUI.this.enableOptionMenu(true);
          EmailVerifyUI.a(EmailVerifyUI.this, paramAnonymousString);
          AppMethodBeat.o(127909);
        }
      });
      this.kkt.setOnTextChanged(new MMAutoSwitchEditTextView.b()
      {
        public final void boW()
        {
          AppMethodBeat.i(127910);
          EmailVerifyUI.this.enableOptionMenu(false);
          AppMethodBeat.o(127910);
        }
      });
      this.kkv = ((Button)findViewById(2131306539));
      this.kkv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(127913);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/EmailVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new StringBuilder();
          g.aAf();
          paramAnonymousView = paramAnonymousView.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R500_250,");
          g.aAf();
          com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("R500_250") + ",3");
          h.a(EmailVerifyUI.this, 2131764358, 2131764348, 2131755921, 2131755761, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(127912);
              paramAnonymous2DialogInterface = new ab(EmailVerifyUI.a(EmailVerifyUI.this), EmailVerifyUI.b(EmailVerifyUI.this));
              g.azz().a(paramAnonymous2DialogInterface, 0);
              EmailVerifyUI localEmailVerifyUI1 = EmailVerifyUI.this;
              EmailVerifyUI localEmailVerifyUI2 = EmailVerifyUI.this;
              EmailVerifyUI.this.getString(2131755998);
              EmailVerifyUI.a(localEmailVerifyUI1, h.a(localEmailVerifyUI2, EmailVerifyUI.this.getString(2131764366), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                {
                  AppMethodBeat.i(127911);
                  g.azz().a(paramAnonymous2DialogInterface);
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
      this.kku = ((Button)findViewById(2131305615));
      if ((!Util.isNullOrNil(this.kkx)) && (!Util.isNullOrNil(this.kkw))) {
        break label305;
      }
      this.kku.setVisibility(8);
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
      addTextOptionMenu(0, getString(2131755916), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(127916);
          EmailVerifyUI.b(EmailVerifyUI.this, EmailVerifyUI.e(EmailVerifyUI.this).getText());
          if ((!Util.isNullOrNil(EmailVerifyUI.f(EmailVerifyUI.this))) && (EmailVerifyUI.f(EmailVerifyUI.this).length() == 12)) {
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
      Log.w("MicroMsg.EmailVerifyUI", "email add is null or nill");
      break;
      label305:
      this.kku.setVisibility(0);
      this.kku.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(127914);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/EmailVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Util.jump(EmailVerifyUI.this, EmailVerifyUI.c(EmailVerifyUI.this));
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
    this.kbV = com.tencent.mm.plugin.b.a.bpZ();
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
    g.azz().b(481, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R500_200,");
    g.aAf();
    com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("R500_200") + ",2");
    AppMethodBeat.o(127920);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127919);
    super.onResume();
    g.azz().a(481, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R500_200,");
    g.aAf();
    com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("R500_200") + ",1");
    com.tencent.mm.plugin.b.a.bwU("R500_200");
    AppMethodBeat.o(127919);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(127924);
    Log.i("MicroMsg.EmailVerifyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    this.kkA = false;
    if ((this.gtM != null) && (this.gtM.isShowing()))
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if (paramq.getType() != 481)
    {
      Log.e("MicroMsg.EmailVerifyUI", "error cgi type callback:[%d]", new Object[] { Integer.valueOf(paramq.getType()) });
      AppMethodBeat.o(127924);
      return;
    }
    int j = ((s.a)((ab)paramq).iMO.getReqObj()).keR.KMz;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (j == 2)
      {
        com.tencent.mm.plugin.b.a.bwV("R200_900_email");
        paramString = new Intent(this, RegSetInfoUI.class);
        paramString.putExtra("regsetinfo_ticket", ((s.b)((ab)paramq).iMO.getRespObj()).keS.Bri);
        paramString.putExtra("regsetinfo_user", this.kkw);
        paramString.putExtra("regsetinfo_ismobile", 3);
        paramString.putExtra("regsetinfo_NextStyle", ((ab)paramq).bfw());
        paramString.putExtra("regsetinfo_pwd", this.kky);
        paramString.putExtra("regsetinfo_bind_email", this.kkw);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/account/ui/EmailVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/EmailVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(127924);
        return;
      }
      if (j == 1)
      {
        paramString = new StringBuilder();
        g.aAf();
        paramString = paramString.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R22_resend_email_code_alert,");
        g.aAf();
        com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("R22_resend_email_code_alert") + ",3");
        h.cD(this, getString(2131764360));
        AppMethodBeat.o(127924);
        return;
      }
      Log.e("MicroMsg.EmailVerifyUI", "err opcode");
      AppMethodBeat.o(127924);
      return;
    }
    int i;
    if (com.tencent.mm.plugin.account.a.a.jRu.a(this, paramInt1, paramInt2, paramString)) {
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
        h.a(this, 2131764349, 2131764348, null);
        paramString = new StringBuilder();
        g.aAf();
        paramString = paramString.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R500_260,");
        g.aAf();
        com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("R500_260") + ",3");
        i = 1;
        break;
      case -33: 
        h.a(this, 2131764347, 2131764348, null);
        i = 1;
        break;
      case -34: 
        Toast.makeText(this, 2131764346, 0).show();
        i = 1;
      }
    }
    if (j == 2)
    {
      Toast.makeText(this, getString(2131764368, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(127924);
      return;
    }
    if (j == 1) {
      Toast.makeText(this, getString(2131764359, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(127924);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.EmailVerifyUI
 * JD-Core Version:    0.7.0.1
 */