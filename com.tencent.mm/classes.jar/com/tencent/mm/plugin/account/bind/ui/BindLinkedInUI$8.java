package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.c;
import com.tencent.mm.ui.base.h;

final class BindLinkedInUI$8
  implements View.OnClickListener
{
  BindLinkedInUI$8(BindLinkedInUI paramBindLinkedInUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(109823);
    h.a(this.igh, this.igh.getString(2131757705), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109822);
        paramAnonymousDialogInterface = new c();
        BindLinkedInUI.a(BindLinkedInUI.8.this.igh, h.b(BindLinkedInUI.8.this.igh, BindLinkedInUI.8.this.igh.getString(2131760709), false, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(109821);
            g.aeS().a(paramAnonymousDialogInterface);
            AppMethodBeat.o(109821);
          }
        }));
        g.aeS().a(paramAnonymousDialogInterface, 0);
        AppMethodBeat.o(109822);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(109823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.8
 * JD-Core Version:    0.7.0.1
 */