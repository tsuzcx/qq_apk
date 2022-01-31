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
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

public class LoginVoiceUI
  extends LoginHistoryUI
{
  protected final void arq()
  {
    int j = -1;
    AppMethodBeat.i(125076);
    super.arq();
    arr();
    s locals = new s(this.gEc, this.gEl, "", 0);
    locals.up(this.gEl);
    int i;
    String str;
    if (this.gEl == null)
    {
      i = -1;
      str = bo.aqg(this.gEl);
      if (this.gDU.gwh != null) {
        break label170;
      }
    }
    for (;;)
    {
      ab.d("MicroMsg.LoginVoiceUI", "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), bo.aqg(this.gDU.gwh) });
      getString(2131297087);
      this.eeN = h.b(this, getString(2131301149), true, new LoginVoiceUI.2(this, locals));
      g.Rc().a(locals, 0);
      AppMethodBeat.o(125076);
      return;
      i = this.gEl.length();
      break;
      label170:
      j = this.gDU.gwh.length();
    }
  }
  
  public final boolean art()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125075);
    super.onCreate(paramBundle);
    if (this.gEm)
    {
      AppMethodBeat.o(125075);
      return;
    }
    this.gyZ = 1;
    this.gEf.setVisibility(0);
    this.gDN.setVisibility(0);
    paramBundle = (LinearLayout.LayoutParams)this.gDM.getLayoutParams();
    paramBundle.gravity = 1;
    paramBundle.leftMargin = 0;
    this.gDM.setLayoutParams(paramBundle);
    findViewById(2131825467).setEnabled(false);
    ((TextView)findViewById(2131825468)).setTextColor(getResources().getColorStateList(2131690799));
    ((TextView)findViewById(2131825468)).setBackgroundResource(getResources().getColor(2131690605));
    this.gDN.setOnClickListener(new LoginVoiceUI.1(this));
    AppMethodBeat.o(125075);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginVoiceUI
 * JD-Core Version:    0.7.0.1
 */