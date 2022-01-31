package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ah.p;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class LoginFaceUI
  extends LoginHistoryUI
{
  protected final void XJ()
  {
    int j = -1;
    super.XJ();
    XK();
    q localq = new q(this.fmI, this.fmR, "", 0);
    int i;
    String str;
    if (this.fmR == null)
    {
      i = -1;
      str = bk.aac(this.fmR);
      if (this.fmA.fey != null) {
        break label154;
      }
    }
    for (;;)
    {
      y.d("MicroMsg.LoginFaceUI", "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), bk.aac(this.fmA.fey) });
      getString(q.j.app_tip);
      this.dnm = com.tencent.mm.ui.base.h.b(this, getString(q.j.login_logining), true, new LoginFaceUI.2(this, localq));
      g.Dk().a(localq, 0);
      return;
      i = this.fmR.length();
      break;
      label154:
      j = this.fmA.fey.length();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.fmS) {
      return;
    }
    this.fhr = 4;
    this.fmN.setVisibility(0);
    this.fmu.setVisibility(0);
    findViewById(q.f.face_btn_icon).setEnabled(false);
    ((TextView)findViewById(q.f.face_login_btn)).setTextColor(getResources().getColorStateList(q.c.white_text_color_selector));
    ((TextView)findViewById(q.f.face_login_btn)).setBackgroundResource(getResources().getColor(q.c.transparent));
    this.fmu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(11557, new Object[] { Integer.valueOf(2) });
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("k_user_name", LoginFaceUI.this.fmI);
        paramAnonymousView.putExtra("k_purpose", 2);
        paramAnonymousView.putExtra("k_need_signature", true);
        d.b(LoginFaceUI.this.mController.uMN, "facedetect", ".ui.FaceDetectUI", paramAnonymousView, 1025);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginFaceUI
 * JD-Core Version:    0.7.0.1
 */