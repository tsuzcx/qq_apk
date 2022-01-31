package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class f$5
  implements DialogInterface.OnClickListener
{
  f$5(f paramf) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(13755);
    paramDialogInterface = new ac(5, this.gwn.gwh, this.gwn.gwg.getSecImgSid(), this.gwn.gwg.getSecImgCode(), this.gwn.gwg.getSecImgEncryptKey(), true, 1);
    this.gwn.Yj();
    g.Rc().a(paramDialogInterface, 0);
    f localf = this.gwn;
    Context localContext = this.gwn.context;
    this.gwn.context.getString(2131297087);
    localf.gwe = h.b(localContext, this.gwn.context.getString(2131301149), true, new f.5.1(this, paramDialogInterface));
    AppMethodBeat.o(13755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.f.5
 * JD-Core Version:    0.7.0.1
 */