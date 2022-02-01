package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;

public class LoginVoiceUI
  extends LoginHistoryUI
{
  protected final void aTT()
  {
    int j = -1;
    AppMethodBeat.i(128253);
    super.aTT();
    aTU();
    final s locals = new s(this.jkr.account, this.jkw, "", 0);
    locals.Gm(this.jkw);
    int i;
    String str;
    if (this.jkw == null)
    {
      i = -1;
      str = bt.aRp(this.jkw);
      if (this.jkr.jcu != null) {
        break label173;
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.LoginVoiceUI", "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), bt.aRp(this.jkr.jcu) });
      getString(2131755906);
      this.fMu = h.b(this, getString(2131760781), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128251);
          g.aiU().a(locals);
          LoginVoiceUI.this.aTV();
          AppMethodBeat.o(128251);
        }
      });
      g.aiU().a(locals, 0);
      AppMethodBeat.o(128253);
      return;
      i = this.jkw.length();
      break;
      label173:
      j = this.jkr.jcu.length();
    }
  }
  
  public final boolean aTW()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128252);
    super.onCreate(paramBundle);
    super.setRequestedOrientation(1);
    if (this.jlj)
    {
      AppMethodBeat.o(128252);
      return;
    }
    this.jfy = 1;
    this.jld.setVisibility(0);
    this.jkN.setVisibility(0);
    paramBundle = (LinearLayout.LayoutParams)this.jkM.getLayoutParams();
    paramBundle.gravity = 1;
    paramBundle.leftMargin = 0;
    this.jkM.setLayoutParams(paramBundle);
    findViewById(2131306484).setEnabled(false);
    ((TextView)findViewById(2131306491)).setTextColor(getResources().getColorStateList(2131101185));
    ((TextView)findViewById(2131306491)).setBackgroundResource(getResources().getColor(2131101053));
    this.jkN.setOnClickListener(new LoginVoiceUI.1(this));
    AppMethodBeat.o(128252);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginVoiceUI
 * JD-Core Version:    0.7.0.1
 */