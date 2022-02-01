package com.tencent.luggage.h;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$1
  implements DialogInterface.OnClickListener
{
  h$1(Activity paramActivity, String paramString, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(140518);
    paramDialogInterface.dismiss();
    paramDialogInterface = this.val$activity;
    String str = this.cgh;
    paramInt = this.val$requestCode;
    a.a(paramDialogInterface, new String[] { str }, paramInt);
    AppMethodBeat.o(140518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.h.h.1
 * JD-Core Version:    0.7.0.1
 */