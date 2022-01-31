package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class SimpleLoginUI$6
  implements DialogInterface.OnClickListener
{
  SimpleLoginUI$6(SimpleLoginUI paramSimpleLoginUI) {}
  
  public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
  {
    y.d("MicroMsg.SimpleLoginUI", "imgSid:" + SimpleLoginUI.g(this.fsR).feA + " img len" + SimpleLoginUI.g(this.fsR).fez.length + " " + com.tencent.mm.compatible.util.g.zI());
    paramDialogInterface = new q(SimpleLoginUI.g(this.fsR).account, SimpleLoginUI.g(this.fsR).fey, SimpleLoginUI.g(this.fsR).fns, SimpleLoginUI.h(this.fsR).getSecImgCode(), SimpleLoginUI.h(this.fsR).getSecImgSid(), SimpleLoginUI.h(this.fsR).getSecImgEncryptKey(), 0, "", false, false);
    com.tencent.mm.kernel.g.Dk().a(paramDialogInterface, 0);
    SimpleLoginUI localSimpleLoginUI1 = this.fsR;
    SimpleLoginUI localSimpleLoginUI2 = this.fsR;
    this.fsR.getString(q.j.app_tip);
    SimpleLoginUI.a(localSimpleLoginUI1, h.b(localSimpleLoginUI2, this.fsR.getString(q.j.login_logining), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        com.tencent.mm.kernel.g.Dk().c(paramDialogInterface);
      }
    }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SimpleLoginUI.6
 * JD-Core Version:    0.7.0.1
 */