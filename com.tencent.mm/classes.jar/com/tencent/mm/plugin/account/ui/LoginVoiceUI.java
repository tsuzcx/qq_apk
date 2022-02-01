package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class LoginVoiceUI
  extends LoginHistoryUI
{
  protected final void bzr()
  {
    int j = -1;
    AppMethodBeat.i(128253);
    super.bzr();
    bzs();
    final com.tencent.mm.modelsimple.t localt = new com.tencent.mm.modelsimple.t(this.ndj.account, this.ndo, "", 0);
    localt.WY(this.ndo);
    int i;
    String str;
    if (this.ndo == null)
    {
      i = -1;
      str = Util.secPrint(this.ndo);
      if (this.ndj.mUQ != null) {
        break label175;
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.LoginVoiceUI", "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), Util.secPrint(this.ndj.mUQ) });
      getString(r.j.app_tip);
      this.iXX = com.tencent.mm.ui.base.h.a(this, getString(r.j.login_logining), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128251);
          com.tencent.mm.kernel.h.aGY().a(localt);
          LoginVoiceUI.this.bzt();
          AppMethodBeat.o(128251);
        }
      });
      com.tencent.mm.kernel.h.aGY().a(localt, 0);
      AppMethodBeat.o(128253);
      return;
      i = this.ndo.length();
      break;
      label175:
      j = this.ndj.mUQ.length();
    }
  }
  
  public final boolean bzu()
  {
    return false;
  }
  
  public void initView()
  {
    AppMethodBeat.i(219080);
    super.initView();
    if (getIntent() != null)
    {
      int i = getIntent().getIntExtra("key_errType", 0);
      int j = getIntent().getIntExtra("key_errCode", 0);
      Object localObject = getIntent().getStringExtra("key_errMsg");
      Log.i("MicroMsg.LoginVoiceUI", "initView,errType %d,errCode %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (a.ei(i, j))
      {
        localObject = com.tencent.mm.h.a.Kb((String)localObject);
        if (localObject != null) {
          ((com.tencent.mm.h.a)localObject).a(this, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface) {}
          });
        }
      }
    }
    AppMethodBeat.o(219080);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128252);
    super.onCreate(paramBundle);
    super.setRequestedOrientation(1);
    if (this.ned)
    {
      AppMethodBeat.o(128252);
      return;
    }
    this.loginType = 1;
    this.ndX.setVisibility(0);
    this.ndG.setVisibility(0);
    paramBundle = (LinearLayout.LayoutParams)this.ndF.getLayoutParams();
    paramBundle.gravity = 1;
    paramBundle.leftMargin = 0;
    this.ndF.setLayoutParams(paramBundle);
    findViewById(r.f.voice_btn_icon).setEnabled(false);
    ((TextView)findViewById(r.f.voice_login_btn)).setTextColor(getResources().getColorStateList(r.c.white_text_color_selector));
    ((TextView)findViewById(r.f.voice_login_btn)).setBackgroundResource(getResources().getColor(r.c.transparent));
    this.ndG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128250);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/LoginVoiceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.plugin.report.service.h.IzE.a(11557, new Object[] { Integer.valueOf(2) });
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("Kusername", LoginVoiceUI.this.ndT);
        paramAnonymousView.putExtra("kscene_type", 1);
        c.b(LoginVoiceUI.this.getContext(), "voiceprint", ".ui.VoiceLoginUI", paramAnonymousView, 1024);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginVoiceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128250);
      }
    });
    AppMethodBeat.o(128252);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginVoiceUI
 * JD-Core Version:    0.7.0.1
 */