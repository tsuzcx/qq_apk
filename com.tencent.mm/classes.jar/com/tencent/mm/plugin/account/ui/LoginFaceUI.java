package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class LoginFaceUI
  extends LoginHistoryUI
{
  protected final void arq()
  {
    int j = -1;
    AppMethodBeat.i(124912);
    super.arq();
    arr();
    s locals = new s(this.gEc, this.gEl, "", 0);
    int i;
    String str;
    if (this.gEl == null)
    {
      i = -1;
      str = bo.aqg(this.gEl);
      if (this.gDU.gwh != null) {
        break label162;
      }
    }
    for (;;)
    {
      ab.d("MicroMsg.LoginFaceUI", "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), bo.aqg(this.gDU.gwh) });
      getString(2131297087);
      this.eeN = com.tencent.mm.ui.base.h.b(this, getString(2131301149), true, new LoginFaceUI.2(this, locals));
      g.Rc().a(locals, 0);
      AppMethodBeat.o(124912);
      return;
      i = this.gEl.length();
      break;
      label162:
      j = this.gDU.gwh.length();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(124911);
    super.onCreate(paramBundle);
    if (this.gEm)
    {
      AppMethodBeat.o(124911);
      return;
    }
    this.gyZ = 4;
    this.gEh.setVisibility(0);
    this.gDO.setVisibility(0);
    findViewById(2131825472).setEnabled(false);
    ((TextView)findViewById(2131825473)).setTextColor(getResources().getColorStateList(2131690799));
    ((TextView)findViewById(2131825473)).setBackgroundResource(getResources().getColor(2131690605));
    this.gDO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(124909);
        com.tencent.mm.plugin.report.service.h.qsU.e(11557, new Object[] { Integer.valueOf(2) });
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("k_user_name", LoginFaceUI.this.gEc);
        paramAnonymousView.putExtra("k_purpose", 2);
        paramAnonymousView.putExtra("k_need_signature", true);
        d.b(LoginFaceUI.this.getContext(), "facedetect", ".ui.FaceDetectUI", paramAnonymousView, 1025);
        AppMethodBeat.o(124909);
      }
    });
    AppMethodBeat.o(124911);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginFaceUI
 * JD-Core Version:    0.7.0.1
 */