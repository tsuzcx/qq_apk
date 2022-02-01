package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;

public class LoginFaceUI
  extends LoginHistoryUI
{
  protected final void aQH()
  {
    int j = -1;
    AppMethodBeat.i(128087);
    super.aQH();
    aQI();
    s locals = new s(this.iRS, this.iRo, "", 0);
    int i;
    String str;
    if (this.iRo == null)
    {
      i = -1;
      str = bs.aLJ(this.iRo);
      if (this.iRj.iJl != null) {
        break label162;
      }
    }
    for (;;)
    {
      ac.d("MicroMsg.LoginFaceUI", "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), bs.aLJ(this.iRj.iJl) });
      getString(2131755906);
      this.fts = h.b(this, getString(2131760781), true, new LoginFaceUI.2(this, locals));
      g.agi().a(locals, 0);
      AppMethodBeat.o(128087);
      return;
      i = this.iRo.length();
      break;
      label162:
      j = this.iRj.iJl.length();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128086);
    super.onCreate(paramBundle);
    if (this.iSb)
    {
      AppMethodBeat.o(128086);
      return;
    }
    this.iMo = 4;
    this.iRX.setVisibility(0);
    this.iRG.setVisibility(0);
    findViewById(2131299659).setEnabled(false);
    ((TextView)findViewById(2131299693)).setTextColor(getResources().getColorStateList(2131101185));
    ((TextView)findViewById(2131299693)).setBackgroundResource(getResources().getColor(2131101053));
    this.iRG.setOnClickListener(new LoginFaceUI.1(this));
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