package com.tencent.kinda.framework.widget.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class AlertDialogImpl$15
  implements View.OnClickListener
{
  AlertDialogImpl$15(AlertDialogImpl paramAlertDialogImpl, VoidCallback paramVoidCallback) {}
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(144621);
    if (this.val$rightEvent != null) {
      this.val$rightEvent.call();
    }
    this.this$0.dismiss();
    AppMethodBeat.o(144621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.AlertDialogImpl.15
 * JD-Core Version:    0.7.0.1
 */