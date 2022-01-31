package com.tencent.mm.plugin.account.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

public class LoginVoiceUI
  extends LoginHistoryUI
{
  protected final void XJ()
  {
    int j = -1;
    super.XJ();
    XK();
    q localq = new q(this.fmI, this.fmR, "", 0);
    localq.nd(this.fmR);
    int i;
    String str;
    if (this.fmR == null)
    {
      i = -1;
      str = bk.aac(this.fmR);
      if (this.fmA.fey != null) {
        break label162;
      }
    }
    for (;;)
    {
      y.d("MicroMsg.LoginVoiceUI", "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), bk.aac(this.fmA.fey) });
      getString(q.j.app_tip);
      this.dnm = h.b(this, getString(q.j.login_logining), true, new LoginVoiceUI.2(this, localq));
      g.Dk().a(localq, 0);
      return;
      i = this.fmR.length();
      break;
      label162:
      j = this.fmA.fey.length();
    }
  }
  
  public final boolean XN()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.fmS) {
      return;
    }
    this.fhr = 1;
    this.fmL.setVisibility(0);
    this.fmt.setVisibility(0);
    paramBundle = (LinearLayout.LayoutParams)this.fms.getLayoutParams();
    paramBundle.gravity = 1;
    paramBundle.leftMargin = 0;
    this.fms.setLayoutParams(paramBundle);
    findViewById(q.f.voice_btn_icon).setEnabled(false);
    ((TextView)findViewById(q.f.voice_login_btn)).setTextColor(getResources().getColorStateList(q.c.white_text_color_selector));
    ((TextView)findViewById(q.f.voice_login_btn)).setBackgroundResource(getResources().getColor(q.c.transparent));
    this.fmt.setOnClickListener(new LoginVoiceUI.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginVoiceUI
 * JD-Core Version:    0.7.0.1
 */