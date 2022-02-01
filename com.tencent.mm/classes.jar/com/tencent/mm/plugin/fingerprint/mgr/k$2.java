package com.tencent.mm.plugin.fingerprint.mgr;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

final class k$2
  implements DialogInterface.OnClickListener
{
  k$2(k paramk, CheckBox paramCheckBox) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(64394);
    if (this.Hgr.isChecked()) {
      h.baE().ban().set(at.a.acJU, Boolean.TRUE);
    }
    AppMethodBeat.o(64394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.mgr.k.2
 * JD-Core Version:    0.7.0.1
 */