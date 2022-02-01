package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;

final class LoginFaceUI$1
  implements View.OnClickListener
{
  LoginFaceUI$1(LoginFaceUI paramLoginFaceUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128084);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/account/ui/LoginFaceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    h.OAn.b(11557, new Object[] { Integer.valueOf(2) });
    paramView = new Intent();
    paramView.putExtra("k_user_name", this.qaQ.pZn);
    paramView.putExtra("k_purpose", 2);
    paramView.putExtra("k_need_signature", true);
    c.b(this.qaQ.getContext(), "facedetect", ".ui.FaceDetectUI", paramView, 1025);
    a.a(this, "com/tencent/mm/plugin/account/ui/LoginFaceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginFaceUI.1
 * JD-Core Version:    0.7.0.1
 */