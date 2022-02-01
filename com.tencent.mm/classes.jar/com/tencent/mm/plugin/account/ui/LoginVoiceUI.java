package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
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
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;

public class LoginVoiceUI
  extends LoginHistoryUI
{
  protected final void aQH()
  {
    int j = -1;
    AppMethodBeat.i(128253);
    super.aQH();
    aQI();
    s locals = new s(this.iRj.account, this.iRo, "", 0);
    locals.Dh(this.iRo);
    int i;
    String str;
    if (this.iRo == null)
    {
      i = -1;
      str = bs.aLJ(this.iRo);
      if (this.iRj.iJl != null) {
        break label173;
      }
    }
    for (;;)
    {
      ac.d("MicroMsg.LoginVoiceUI", "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), bs.aLJ(this.iRj.iJl) });
      getString(2131755906);
      this.fts = h.b(this, getString(2131760781), true, new LoginVoiceUI.2(this, locals));
      g.agi().a(locals, 0);
      AppMethodBeat.o(128253);
      return;
      i = this.iRo.length();
      break;
      label173:
      j = this.iRj.iJl.length();
    }
  }
  
  public final boolean aQK()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128252);
    super.onCreate(paramBundle);
    super.setRequestedOrientation(1);
    if (this.iSb)
    {
      AppMethodBeat.o(128252);
      return;
    }
    this.iMo = 1;
    this.iRV.setVisibility(0);
    this.iRF.setVisibility(0);
    paramBundle = (LinearLayout.LayoutParams)this.iRE.getLayoutParams();
    paramBundle.gravity = 1;
    paramBundle.leftMargin = 0;
    this.iRE.setLayoutParams(paramBundle);
    findViewById(2131306484).setEnabled(false);
    ((TextView)findViewById(2131306491)).setTextColor(getResources().getColorStateList(2131101185));
    ((TextView)findViewById(2131306491)).setBackgroundResource(getResources().getColor(2131101053));
    this.iRF.setOnClickListener(new LoginVoiceUI.1(this));
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