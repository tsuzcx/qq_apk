package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;

final class RegByMobileRegAIOUI$9
  implements DialogInterface.OnCancelListener
{
  RegByMobileRegAIOUI$9(RegByMobileRegAIOUI paramRegByMobileRegAIOUI, a parama) {}
  
  public final void onCancel(DialogInterface arg1)
  {
    AppMethodBeat.i(224316);
    try
    {
      synchronized (this.jnz)
      {
        g.ajj().a(this.jnz);
        label22:
        AppMethodBeat.o(224316);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      break label22;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.9
 * JD-Core Version:    0.7.0.1
 */