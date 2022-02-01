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
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;

public class LoginFaceUI
  extends LoginHistoryUI
{
  protected final void aTT()
  {
    int j = -1;
    AppMethodBeat.i(128087);
    super.aTT();
    aTU();
    final s locals = new s(this.jla, this.jkw, "", 0);
    int i;
    String str;
    if (this.jkw == null)
    {
      i = -1;
      str = bt.aRp(this.jkw);
      if (this.jkr.jcu != null) {
        break label162;
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.LoginFaceUI", "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), bt.aRp(this.jkr.jcu) });
      getString(2131755906);
      this.fMu = h.b(this, getString(2131760781), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128085);
          g.aiU().a(locals);
          LoginFaceUI.this.aTV();
          AppMethodBeat.o(128085);
        }
      });
      g.aiU().a(locals, 0);
      AppMethodBeat.o(128087);
      return;
      i = this.jkw.length();
      break;
      label162:
      j = this.jkr.jcu.length();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128086);
    super.onCreate(paramBundle);
    if (this.jlj)
    {
      AppMethodBeat.o(128086);
      return;
    }
    this.jfy = 4;
    this.jlf.setVisibility(0);
    this.jkO.setVisibility(0);
    findViewById(2131299659).setEnabled(false);
    ((TextView)findViewById(2131299693)).setTextColor(getResources().getColorStateList(2131101185));
    ((TextView)findViewById(2131299693)).setBackgroundResource(getResources().getColor(2131101053));
    this.jkO.setOnClickListener(new LoginFaceUI.1(this));
    AppMethodBeat.o(128086);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginFaceUI
 * JD-Core Version:    0.7.0.1
 */