package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.ch.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class i$2$1
  implements DialogInterface.OnClickListener
{
  i$2$1(i.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(113739);
    long l = this.ohY.ohX.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
    paramDialogInterface = new ch();
    paramDialogInterface.cpK.cpM = l;
    com.tencent.mm.sdk.b.a.ymk.l(paramDialogInterface);
    boolean bool = bo.a(Boolean.valueOf(paramDialogInterface.cpL.cpz), false);
    ab.d("MicroMsg.ViewMapUI", "do del fav voice, local id %d, result %B", new Object[] { Long.valueOf(l), Boolean.valueOf(bool) });
    if (bool) {
      this.ohY.ohX.activity.finish();
    }
    AppMethodBeat.o(113739);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.i.2.1
 * JD-Core Version:    0.7.0.1
 */