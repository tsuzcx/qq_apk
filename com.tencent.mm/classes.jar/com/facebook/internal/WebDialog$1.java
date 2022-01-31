package com.facebook.internal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

class WebDialog$1
  implements DialogInterface.OnCancelListener
{
  WebDialog$1(WebDialog paramWebDialog) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(96655);
    this.this$0.cancel();
    AppMethodBeat.o(96655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.internal.WebDialog.1
 * JD-Core Version:    0.7.0.1
 */