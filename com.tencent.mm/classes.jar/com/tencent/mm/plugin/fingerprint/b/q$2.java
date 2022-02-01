package com.tencent.mm.plugin.fingerprint.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

final class q$2
  implements DialogInterface.OnClickListener
{
  q$2(q paramq, CheckBox paramCheckBox) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(64394);
    if (this.tht.isChecked()) {
      g.ajC().ajl().set(al.a.Isc, Boolean.TRUE);
    }
    AppMethodBeat.o(64394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.q.2
 * JD-Core Version:    0.7.0.1
 */