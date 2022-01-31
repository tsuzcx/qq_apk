package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.profile.b.d;
import com.tencent.mm.ui.base.h;

final class EnterpriseBizContactListView$a$3
  implements DialogInterface.OnClickListener
{
  EnterpriseBizContactListView$a$3(EnterpriseBizContactListView.a parama, String paramString, Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(13961);
    paramDialogInterface = new d(this.euc, true);
    g.Rc().a(1394, this.jUs);
    g.Rc().a(paramDialogInterface, 0);
    EnterpriseBizContactListView.a locala = this.jUs;
    Context localContext = this.val$context;
    this.val$context.getString(2131297087);
    locala.tipDialog = h.b(localContext, this.val$context.getString(2131297112), true, new EnterpriseBizContactListView.a.3.1(this, paramDialogInterface));
    AppMethodBeat.o(13961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.a.3
 * JD-Core Version:    0.7.0.1
 */