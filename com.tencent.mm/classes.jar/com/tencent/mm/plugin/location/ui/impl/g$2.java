package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.location.model.o;
import com.tencent.mm.plugin.location.ui.k;
import com.tencent.mm.plugin.location.ui.m;

final class g$2
  implements DialogInterface.OnClickListener
{
  g$2(g paramg) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(155622);
    this.ohw.ohj.iU(false);
    this.ohw.ohk.stop();
    this.ohw.ohk.yb(2);
    k.bLT();
    this.ohw.activity.finish();
    AppMethodBeat.o(155622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.g.2
 * JD-Core Version:    0.7.0.1
 */