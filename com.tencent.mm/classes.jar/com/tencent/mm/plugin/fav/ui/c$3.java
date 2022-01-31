package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;

final class c$3
  implements DialogInterface.OnClickListener
{
  c$3(Context paramContext, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(73979);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_enter_fav_cleanui_from", 3);
    b.b(this.val$context, ".ui.FavCleanUI", localIntent);
    paramDialogInterface.dismiss();
    if (this.mwj != null) {
      this.mwj.onClick(paramDialogInterface, -2);
    }
    AppMethodBeat.o(73979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c.3
 * JD-Core Version:    0.7.0.1
 */