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
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class LoginFaceUI
  extends LoginHistoryUI
{
  protected final void aJQ()
  {
    int j = -1;
    AppMethodBeat.i(128087);
    super.aJQ();
    aJR();
    final s locals = new s(this.irN, this.iri, "", 0);
    int i;
    String str;
    if (this.iri == null)
    {
      i = -1;
      str = bt.aGs(this.iri);
      if (this.ird.ije != null) {
        break label162;
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.LoginFaceUI", "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), bt.aGs(this.ird.ije) });
      getString(2131755906);
      this.fpP = com.tencent.mm.ui.base.h.b(this, getString(2131760781), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128085);
          g.aeS().a(locals);
          LoginFaceUI.this.aJS();
          AppMethodBeat.o(128085);
        }
      });
      g.aeS().a(locals, 0);
      AppMethodBeat.o(128087);
      return;
      i = this.iri.length();
      break;
      label162:
      j = this.ird.ije.length();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128086);
    super.onCreate(paramBundle);
    if (this.irW)
    {
      AppMethodBeat.o(128086);
      return;
    }
    this.imi = 4;
    this.irS.setVisibility(0);
    this.irB.setVisibility(0);
    findViewById(2131299659).setEnabled(false);
    ((TextView)findViewById(2131299693)).setTextColor(getResources().getColorStateList(2131101185));
    ((TextView)findViewById(2131299693)).setBackgroundResource(getResources().getColor(2131101053));
    this.irB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128084);
        com.tencent.mm.plugin.report.service.h.vKh.f(11557, new Object[] { Integer.valueOf(2) });
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("k_user_name", LoginFaceUI.this.irN);
        paramAnonymousView.putExtra("k_purpose", 2);
        paramAnonymousView.putExtra("k_need_signature", true);
        d.b(LoginFaceUI.this.getContext(), "facedetect", ".ui.FaceDetectUI", paramAnonymousView, 1025);
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