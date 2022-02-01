package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;

public class LoginFaceUI
  extends LoginHistoryUI
{
  protected final void aUs()
  {
    int j = -1;
    AppMethodBeat.i(128087);
    super.aUs();
    aUt();
    final t localt = new t(this.jnU, this.jnq, "", 0);
    int i;
    String str;
    if (this.jnq == null)
    {
      i = -1;
      str = bu.aSM(this.jnq);
      if (this.jnl.jfn != null) {
        break label162;
      }
    }
    for (;;)
    {
      ae.d("MicroMsg.LoginFaceUI", "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), bu.aSM(this.jnl.jfn) });
      getString(2131755906);
      this.fOC = h.b(this, getString(2131760781), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128085);
          g.ajj().a(localt);
          LoginFaceUI.this.aUu();
          AppMethodBeat.o(128085);
        }
      });
      g.ajj().a(localt, 0);
      AppMethodBeat.o(128087);
      return;
      i = this.jnq.length();
      break;
      label162:
      j = this.jnl.jfn.length();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128086);
    super.onCreate(paramBundle);
    if (this.jod)
    {
      AppMethodBeat.o(128086);
      return;
    }
    this.jir = 4;
    this.jnZ.setVisibility(0);
    this.jnI.setVisibility(0);
    findViewById(2131299659).setEnabled(false);
    ((TextView)findViewById(2131299693)).setTextColor(getResources().getColorStateList(2131101185));
    ((TextView)findViewById(2131299693)).setBackgroundResource(getResources().getColor(2131101053));
    this.jnI.setOnClickListener(new LoginFaceUI.1(this));
    AppMethodBeat.o(128086);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginFaceUI
 * JD-Core Version:    0.7.0.1
 */