package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class b$1
  implements DialogInterface.OnClickListener
{
  b$1(b paramb, Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(124716);
    paramDialogInterface = this.gCl.a(this.gCl.gCj, this.gCl.gwg.getSecImgCode());
    g.Rc().a(paramDialogInterface, 0);
    Context localContext = this.gCk;
    this.gCk.getString(2131297087);
    h.b(localContext, this.gCk.getString(2131301149), true, new b.1.1(this, paramDialogInterface));
    AppMethodBeat.o(124716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.b.1
 * JD-Core Version:    0.7.0.1
 */