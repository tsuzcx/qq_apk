package com.tencent.mm.plugin.brandservice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.profile.b.d;

final class EnterpriseBizContactListView$a$3$1
  implements DialogInterface.OnCancelListener
{
  EnterpriseBizContactListView$a$3$1(EnterpriseBizContactListView.a.3 param3, d paramd) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(13960);
    g.Rc().a(this.jUt);
    g.Rc().b(1394, this.jUu.jUs);
    AppMethodBeat.o(13960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.a.3.1
 * JD-Core Version:    0.7.0.1
 */