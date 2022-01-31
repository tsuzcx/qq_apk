package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.h.a.ce;
import com.tencent.mm.h.a.ce.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class i$2$1
  implements DialogInterface.OnClickListener
{
  i$2$1(i.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    long l = this.lKG.lKF.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
    paramDialogInterface = new ce();
    paramDialogInterface.bIp.bIr = l;
    com.tencent.mm.sdk.b.a.udP.m(paramDialogInterface);
    boolean bool = bk.a(Boolean.valueOf(paramDialogInterface.bIq.bIe), false);
    y.d("MicroMsg.ViewMapUI", "do del fav voice, local id %d, result %B", new Object[] { Long.valueOf(l), Boolean.valueOf(bool) });
    if (bool) {
      this.lKG.lKF.activity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.i.2.1
 * JD-Core Version:    0.7.0.1
 */