package com.tencent.mm.plugin.account.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;

public class LoginFaceUI
  extends LoginHistoryUI
{
  protected final void bXX()
  {
    int j = -1;
    AppMethodBeat.i(128087);
    super.bXX();
    bXW();
    u localu = new u(this.pZn, this.pZt, "", 0);
    int i;
    String str;
    if (this.pZt == null)
    {
      i = -1;
      str = Util.secPrint(this.pZt);
      if (this.pZh.pRx != null) {
        break label164;
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.LoginFaceUI", "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), Util.secPrint(this.pZh.pRx) });
      getString(r.j.app_tip);
      this.lzP = k.a(this, getString(r.j.login_logining), true, new LoginFaceUI.2(this, localu));
      h.aZW().a(localu, 0);
      AppMethodBeat.o(128087);
      return;
      i = this.pZt.length();
      break;
      label164:
      j = this.pZh.pRx.length();
    }
  }
  
  public final boolean bYb()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128086);
    super.onCreate(paramBundle);
    if (this.pZu)
    {
      AppMethodBeat.o(128086);
      return;
    }
    this.loginType = 4;
    this.qaW.setVisibility(0);
    this.qaT.setVisibility(0);
    findViewById(r.f.face_btn_icon).setEnabled(false);
    ((TextView)findViewById(r.f.face_login_btn)).setTextColor(getResources().getColorStateList(r.c.white_text_color_selector));
    ((TextView)findViewById(r.f.face_login_btn)).setBackgroundResource(getResources().getColor(r.c.transparent));
    this.qaT.setOnClickListener(new LoginFaceUI.1(this));
    AppMethodBeat.o(128086);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginFaceUI
 * JD-Core Version:    0.7.0.1
 */