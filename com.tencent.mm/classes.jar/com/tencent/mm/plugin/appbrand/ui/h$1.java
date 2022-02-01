package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.base.i;

public final class h$1
  implements DialogInterface.OnCancelListener
{
  public h$1(Context paramContext, i parami) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(48654);
    paramDialogInterface = AndroidContextUtil.castActivityOrNull(this.val$context);
    if (paramDialogInterface != null) {
      paramDialogInterface.finish();
    }
    this.qVA.setOnCancelListener(null);
    AppMethodBeat.o(48654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.h.1
 * JD-Core Version:    0.7.0.1
 */