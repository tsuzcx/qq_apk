package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class LoginFaceUI
  extends LoginHistoryUI
{
  protected final void bzr()
  {
    int j = -1;
    AppMethodBeat.i(128087);
    super.bzr();
    bzs();
    final com.tencent.mm.modelsimple.t localt = new com.tencent.mm.modelsimple.t(this.ndT, this.ndo, "", 0);
    int i;
    String str;
    if (this.ndo == null)
    {
      i = -1;
      str = Util.secPrint(this.ndo);
      if (this.ndj.mUQ != null) {
        break label164;
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.LoginFaceUI", "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), Util.secPrint(this.ndj.mUQ) });
      getString(r.j.app_tip);
      this.iXX = com.tencent.mm.ui.base.h.a(this, getString(r.j.login_logining), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128085);
          com.tencent.mm.kernel.h.aGY().a(localt);
          LoginFaceUI.this.bzt();
          AppMethodBeat.o(128085);
        }
      });
      com.tencent.mm.kernel.h.aGY().a(localt, 0);
      AppMethodBeat.o(128087);
      return;
      i = this.ndo.length();
      break;
      label164:
      j = this.ndj.mUQ.length();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128086);
    super.onCreate(paramBundle);
    if (this.ned)
    {
      AppMethodBeat.o(128086);
      return;
    }
    this.loginType = 4;
    this.ndZ.setVisibility(0);
    this.ndH.setVisibility(0);
    findViewById(r.f.face_btn_icon).setEnabled(false);
    ((TextView)findViewById(r.f.face_login_btn)).setTextColor(getResources().getColorStateList(r.c.white_text_color_selector));
    ((TextView)findViewById(r.f.face_login_btn)).setBackgroundResource(getResources().getColor(r.c.transparent));
    this.ndH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128084);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/account/ui/LoginFaceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.plugin.report.service.h.IzE.a(11557, new Object[] { Integer.valueOf(2) });
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("k_user_name", LoginFaceUI.this.ndT);
        paramAnonymousView.putExtra("k_purpose", 2);
        paramAnonymousView.putExtra("k_need_signature", true);
        c.b(LoginFaceUI.this.getContext(), "facedetect", ".ui.FaceDetectUI", paramAnonymousView, 1025);
        a.a(this, "com/tencent/mm/plugin/account/ui/LoginFaceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128084);
      }
    });
    AppMethodBeat.o(128086);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginFaceUI
 * JD-Core Version:    0.7.0.1
 */