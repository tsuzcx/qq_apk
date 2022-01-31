package com.tencent.mm.plugin.clean.ui.newui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class CleanChattingUI$3
  implements View.OnClickListener
{
  CleanChattingUI$3(CleanChattingUI paramCleanChattingUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(18877);
    h.d(this.kJl, this.kJl.getString(2131298495), "", this.kJl.getString(2131298944), this.kJl.getString(2131297837), new DialogInterface.OnClickListener()new CleanChattingUI.3.2
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(18876);
        CleanChattingUI.a(CleanChattingUI.3.this.kJl);
        AppMethodBeat.o(18876);
      }
    }, new CleanChattingUI.3.2(this));
    AppMethodBeat.o(18877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanChattingUI.3
 * JD-Core Version:    0.7.0.1
 */