package com.tencent.mm.plugin.base.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.plugin.game.api.b.a;

final class d$1
  implements DialogInterface.OnClickListener
{
  d$1(d paramd) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(18122);
    paramDialogInterface = b.a.bEX();
    if (paramDialogInterface != null) {
      paramDialogInterface.m(this.jLA.openId, r.Zq(), this.jLA.appId);
    }
    this.jLA.jLz.fH(false);
    AppMethodBeat.o(18122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.d.1
 * JD-Core Version:    0.7.0.1
 */