package com.tencent.kinda.framework.widget.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class AlertDialogImpl$3
  implements DialogInterface.OnClickListener
{
  AlertDialogImpl$3(AlertDialogImpl paramAlertDialogImpl, VoidCallback paramVoidCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(144623);
    this.val$leftEvent.call();
    AlertDialogImpl.access$002(this.this$0, null);
    AppMethodBeat.o(144623);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.AlertDialogImpl.3
 * JD-Core Version:    0.7.0.1
 */