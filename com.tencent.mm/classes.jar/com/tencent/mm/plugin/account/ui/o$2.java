package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class o$2
  implements DialogInterface.OnClickListener
{
  o$2(o paramo, String paramString1, String paramString2, m paramm, Boolean paramBoolean) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125252);
    g.Rc().a(126, this.gGO);
    paramDialogInterface = new u("", this.gGx, this.gGy, 0, "", this.gGO.gGG.czF, "", "", this.gGO.gGM, this.gGO.gGG.fPQ, "", ((u)this.ckS).ajG(), this.gGO.gGG.gwg.getSecImgCode(), true, this.gGz.booleanValue());
    paramDialogInterface.uq(this.gGO.gGG.gFA);
    paramDialogInterface.ur(this.gGO.gGG.gHo);
    g.Rc().a(paramDialogInterface, 0);
    MobileVerifyUI localMobileVerifyUI1 = this.gGO.gGG;
    MobileVerifyUI localMobileVerifyUI2 = this.gGO.gGG;
    this.gGO.gGG.getString(2131297087);
    localMobileVerifyUI1.eeN = h.b(localMobileVerifyUI2, this.gGO.gGG.getString(2131302482), true, new o.2.1(this, paramDialogInterface));
    AppMethodBeat.o(125252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.o.2
 * JD-Core Version:    0.7.0.1
 */