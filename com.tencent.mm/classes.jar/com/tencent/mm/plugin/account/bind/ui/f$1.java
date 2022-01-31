package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.ui.base.h;

final class f$1
  implements DialogInterface.OnClickListener
{
  f$1(f paramf, EditText paramEditText) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.feE.few = null;
    paramDialogInterface = this.feE;
    Object localObject = this.feD.getText().toString().trim();
    paramDialogInterface.Fj();
    paramDialogInterface.fey = ((String)localObject);
    localObject = paramDialogInterface.context;
    paramDialogInterface.context.getString(a.i.app_tip);
    paramDialogInterface.fev = h.b((Context)localObject, paramDialogInterface.context.getString(a.i.sendrequest_sending), true, new f.3(paramDialogInterface));
    g.Dk().a(new ab(5, paramDialogInterface.fey, "", "", "", false, 1), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.f.1
 * JD-Core Version:    0.7.0.1
 */