package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cu;
import com.tencent.mm.g.a.cu.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class k$2$1
  implements DialogInterface.OnClickListener
{
  k$2$1(k.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(56201);
    long l = this.yOq.yOp.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
    paramDialogInterface = new cu();
    paramDialogInterface.dFU.dFW = l;
    EventCenter.instance.publish(paramDialogInterface);
    boolean bool = Util.nullAs(Boolean.valueOf(paramDialogInterface.dFV.dFE), false);
    Log.d("MicroMsg.ViewMapUI", "do del fav voice, local id %d, result %B", new Object[] { Long.valueOf(l), Boolean.valueOf(bool) });
    if (bool) {
      this.yOq.yOp.activity.finish();
    }
    AppMethodBeat.o(56201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.k.2.1
 * JD-Core Version:    0.7.0.1
 */