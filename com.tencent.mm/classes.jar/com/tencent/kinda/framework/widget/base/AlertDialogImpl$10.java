package com.tencent.kinda.framework.widget.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class AlertDialogImpl$10
  implements View.OnClickListener
{
  AlertDialogImpl$10(AlertDialogImpl paramAlertDialogImpl, VoidCallback paramVoidCallback) {}
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(144616);
    if (this.val$leftEvent != null) {
      this.val$leftEvent.call();
    }
    this.this$0.dismiss();
    AppMethodBeat.o(144616);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.AlertDialogImpl.10
 * JD-Core Version:    0.7.0.1
 */