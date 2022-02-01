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
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;

public class LoginVoiceUI
  extends LoginHistoryUI
{
  protected final void aUs()
  {
    int j = -1;
    AppMethodBeat.i(128253);
    super.aUs();
    aUt();
    final t localt = new t(this.jnl.account, this.jnq, "", 0);
    localt.GO(this.jnq);
    int i;
    String str;
    if (this.jnq == null)
    {
      i = -1;
      str = bu.aSM(this.jnq);
      if (this.jnl.jfn != null) {
        break label173;
      }
    }
    for (;;)
    {
      ae.d("MicroMsg.LoginVoiceUI", "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), bu.aSM(this.jnl.jfn) });
      getString(2131755906);
      this.fOC = h.b(this, getString(2131760781), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128251);
          g.ajj().a(localt);
          LoginVoiceUI.this.aUu();
          AppMethodBeat.o(128251);
        }
      });
      g.ajj().a(localt, 0);
      AppMethodBeat.o(128253);
      return;
      i = this.jnq.length();
      break;
      label173:
      j = this.jnl.jfn.length();
    }
  }
  
  public final boolean aUv()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128252);
    super.onCreate(paramBundle);
    super.setRequestedOrientation(1);
    if (this.jod)
    {
      AppMethodBeat.o(128252);
      return;
    }
    this.jir = 1;
    this.jnX.setVisibility(0);
    this.jnH.setVisibility(0);
    paramBundle = (LinearLayout.LayoutParams)this.jnG.getLayoutParams();
    paramBundle.gravity = 1;
    paramBundle.leftMargin = 0;
    this.jnG.setLayoutParams(paramBundle);
    findViewById(2131306484).setEnabled(false);
    ((TextView)findViewById(2131306491)).setTextColor(getResources().getColorStateList(2131101185));
    ((TextView)findViewById(2131306491)).setBackgroundResource(getResources().getColor(2131101053));
    this.jnH.setOnClickListener(new LoginVoiceUI.1(this));
    AppMethodBeat.o(128252);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginVoiceUI
 * JD-Core Version:    0.7.0.1
 */