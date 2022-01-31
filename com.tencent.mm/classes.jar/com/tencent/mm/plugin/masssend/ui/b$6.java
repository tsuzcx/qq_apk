package com.tencent.mm.plugin.masssend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.masssend.a.f;

final class b$6
  implements DialogInterface.OnCancelListener
{
  b$6(b paramb, f paramf) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(156064);
    aw.Rc().a(this.oBE);
    if (this.oBD.tipDialog != null)
    {
      this.oBD.tipDialog.dismiss();
      this.oBD.tipDialog = null;
    }
    AppMethodBeat.o(156064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.b.6
 * JD-Core Version:    0.7.0.1
 */