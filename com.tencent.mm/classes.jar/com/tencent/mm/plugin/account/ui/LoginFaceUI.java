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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;

public class LoginFaceUI
  extends LoginHistoryUI
{
  protected final void bpf()
  {
    int j = -1;
    AppMethodBeat.i(128087);
    super.bpf();
    bpg();
    final com.tencent.mm.modelsimple.t localt = new com.tencent.mm.modelsimple.t(this.kmc, this.kly, "", 0);
    int i;
    String str;
    if (this.kly == null)
    {
      i = -1;
      str = Util.secPrint(this.kly);
      if (this.klt.kdq != null) {
        break label162;
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.LoginFaceUI", "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), Util.secPrint(this.klt.kdq) });
      getString(2131755998);
      this.gtM = h.a(this, getString(2131762532), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128085);
          com.tencent.mm.kernel.g.azz().a(localt);
          LoginFaceUI.this.bph();
          AppMethodBeat.o(128085);
        }
      });
      com.tencent.mm.kernel.g.azz().a(localt, 0);
      AppMethodBeat.o(128087);
      return;
      i = this.kly.length();
      break;
      label162:
      j = this.klt.kdq.length();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128086);
    super.onCreate(paramBundle);
    if (this.kmm)
    {
      AppMethodBeat.o(128086);
      return;
    }
    this.loginType = 4;
    this.kmi.setVisibility(0);
    this.klQ.setVisibility(0);
    findViewById(2131300310).setEnabled(false);
    ((TextView)findViewById(2131300355)).setTextColor(getResources().getColorStateList(2131101430));
    ((TextView)findViewById(2131300355)).setBackgroundResource(getResources().getColor(2131101287));
    this.klQ.setOnClickListener(new LoginFaceUI.1(this));
    AppMethodBeat.o(128086);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginFaceUI
 * JD-Core Version:    0.7.0.1
 */