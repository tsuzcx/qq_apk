package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class LoginVoiceUI
  extends LoginHistoryUI
{
  protected final void aJQ()
  {
    int j = -1;
    AppMethodBeat.i(128253);
    super.aJQ();
    aJR();
    final s locals = new s(this.ird.account, this.iri, "", 0);
    locals.zc(this.iri);
    int i;
    String str;
    if (this.iri == null)
    {
      i = -1;
      str = bt.aGs(this.iri);
      if (this.ird.ije != null) {
        break label173;
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.LoginVoiceUI", "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), bt.aGs(this.ird.ije) });
      getString(2131755906);
      this.fpP = com.tencent.mm.ui.base.h.b(this, getString(2131760781), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128251);
          g.aeS().a(locals);
          LoginVoiceUI.this.aJS();
          AppMethodBeat.o(128251);
        }
      });
      g.aeS().a(locals, 0);
      AppMethodBeat.o(128253);
      return;
      i = this.iri.length();
      break;
      label173:
      j = this.ird.ije.length();
    }
  }
  
  public final boolean aJT()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128252);
    super.onCreate(paramBundle);
    super.setRequestedOrientation(1);
    if (this.irW)
    {
      AppMethodBeat.o(128252);
      return;
    }
    this.imi = 1;
    this.irQ.setVisibility(0);
    this.irA.setVisibility(0);
    paramBundle = (LinearLayout.LayoutParams)this.irz.getLayoutParams();
    paramBundle.gravity = 1;
    paramBundle.leftMargin = 0;
    this.irz.setLayoutParams(paramBundle);
    findViewById(2131306484).setEnabled(false);
    ((TextView)findViewById(2131306491)).setTextColor(getResources().getColorStateList(2131101185));
    ((TextView)findViewById(2131306491)).setBackgroundResource(getResources().getColor(2131101053));
    this.irA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128250);
        com.tencent.mm.plugin.report.service.h.vKh.f(11557, new Object[] { Integer.valueOf(2) });
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("Kusername", LoginVoiceUI.this.irN);
        paramAnonymousView.putExtra("kscene_type", 1);
        d.b(LoginVoiceUI.this.getContext(), "voiceprint", ".ui.VoiceLoginUI", paramAnonymousView, 1024);
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