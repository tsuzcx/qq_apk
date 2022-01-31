package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.h;

final class l$8
  implements View.OnClickListener
{
  l$8(l paraml) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125141);
    h.a(this.gFF.gFq, this.gFF.gFq.getString(2131302462) + this.gFF.account, this.gFF.gFq.getString(2131302463), this.gFF.gFq.getString(2131297018), this.gFF.gFq.getString(2131296888), false, new DialogInterface.OnClickListener()new l.8.2
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(125139);
        l.8.this.gFF.gFq.gFL.dDR();
        l.a(l.8.this.gFF, l.8.this.gFF.account);
        AppMethodBeat.o(125139);
      }
    }, new l.8.2(this));
    AppMethodBeat.o(125141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.l.8
 * JD-Core Version:    0.7.0.1
 */