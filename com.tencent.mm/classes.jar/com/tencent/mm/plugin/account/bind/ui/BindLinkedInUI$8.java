package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.bind.a.d;
import com.tencent.mm.ui.base.k;

final class BindLinkedInUI$8
  implements View.OnClickListener
{
  BindLinkedInUI$8(BindLinkedInUI paramBindLinkedInUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(109823);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    k.a(this.pOv, this.pOv.getString(a.i.contact_info_linkedin_account_unbind_alert), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109822);
        paramAnonymousDialogInterface = new d();
        BindLinkedInUI.a(BindLinkedInUI.8.this.pOv, k.a(BindLinkedInUI.8.this.pOv, BindLinkedInUI.8.this.pOv.getString(a.i.loading_tips), false, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(109821);
            h.aZW().a(paramAnonymousDialogInterface);
            AppMethodBeat.o(109821);
          }
        }));
        h.aZW().a(paramAnonymousDialogInterface, 0);
        AppMethodBeat.o(109822);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(109823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.8
 * JD-Core Version:    0.7.0.1
 */