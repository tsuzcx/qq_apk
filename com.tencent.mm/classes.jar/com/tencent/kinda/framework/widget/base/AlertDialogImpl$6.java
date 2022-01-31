package com.tencent.kinda.framework.widget.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class AlertDialogImpl$6
  implements DialogInterface.OnCancelListener
{
  AlertDialogImpl$6(AlertDialogImpl paramAlertDialogImpl, VoidCallback paramVoidCallback) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(144626);
    this.val$rightEvent.call();
    AlertDialogImpl.access$002(this.this$0, null);
    AppMethodBeat.o(144626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.AlertDialogImpl.6
 * JD-Core Version:    0.7.0.1
 */