package com.tencent.mm.plugin.base.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.plugin.game.api.b.a;

final class a$1
  implements DialogInterface.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(18109);
    paramDialogInterface = b.a.bEX();
    if (paramDialogInterface != null) {
      paramDialogInterface.m(this.jLv.openId, r.Zq(), this.jLv.appId);
    }
    this.jLv.jLz.fH(false);
    AppMethodBeat.o(18109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.a.1
 * JD-Core Version:    0.7.0.1
 */