package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.profile.a.c;
import com.tencent.mm.ui.base.h;

final class EnterpriseBizContactListView$a$3
  implements DialogInterface.OnClickListener
{
  EnterpriseBizContactListView$a$3(EnterpriseBizContactListView.a parama, String paramString, Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new c(this.dAA, true);
    g.Dk().a(1394, this.idE);
    g.Dk().a(paramDialogInterface, 0);
    EnterpriseBizContactListView.a locala = this.idE;
    Context localContext = this.val$context;
    this.val$context.getString(b.h.app_tip);
    locala.tipDialog = h.b(localContext, this.val$context.getString(b.h.app_waiting), true, new EnterpriseBizContactListView.a.3.1(this, paramDialogInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.a.3
 * JD-Core Version:    0.7.0.1
 */