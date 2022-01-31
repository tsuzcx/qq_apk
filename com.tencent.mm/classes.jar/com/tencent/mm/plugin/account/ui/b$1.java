package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class b$1
  implements DialogInterface.OnClickListener
{
  b$1(b paramb, Context paramContext) {}
  
  public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.fkU.a(this.fkU.fkS, this.fkU.fex.getSecImgCode());
    g.Dk().a(paramDialogInterface, 0);
    Context localContext = this.fkT;
    this.fkT.getString(q.j.app_tip);
    h.b(localContext, this.fkT.getString(q.j.login_logining), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        g.Dk().c(paramDialogInterface);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.b.1
 * JD-Core Version:    0.7.0.1
 */