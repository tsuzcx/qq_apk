package com.tencent.kinda.framework.widget.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class AlertDialogImpl$4
  implements DialogInterface.OnClickListener
{
  AlertDialogImpl$4(AlertDialogImpl paramAlertDialogImpl, VoidCallback paramVoidCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(144624);
    this.val$leftEvent.call();
    AlertDialogImpl.access$002(this.this$0, null);
    AppMethodBeat.o(144624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.AlertDialogImpl.4
 * JD-Core Version:    0.7.0.1
 */