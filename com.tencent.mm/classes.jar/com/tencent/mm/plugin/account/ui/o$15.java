package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.modelfriend.a;

final class o$15
  implements DialogInterface.OnClickListener
{
  o$15(o paramo, m paramm) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125262);
    com.tencent.mm.kernel.g.Rc().a(701, this.gGO);
    com.tencent.mm.kernel.g.Rc().a(252, this.gGO);
    this.gGO.gFw = new g(new o.15.1(this), ((a)this.ckS).getUsername(), ((a)this.ckS).agw(), this.gGO.gGG.czF);
    this.gGO.gFw.a(this.gGO.gGG);
    this.gGO.gDn.cXw = this.gGO.gGG.gGv;
    this.gGO.gDn.cRH = 8L;
    this.gGO.gDn.ake();
    AppMethodBeat.o(125262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.o.15
 * JD-Core Version:    0.7.0.1
 */