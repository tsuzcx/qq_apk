package com.tencent.kinda.framework.widget.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class MMKProgressDialogImpl$2
  implements DialogInterface.OnCancelListener
{
  MMKProgressDialogImpl$2(MMKProgressDialogImpl paramMMKProgressDialogImpl, VoidCallback paramVoidCallback) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(144940);
    this.val$cancel.call();
    MMKProgressDialogImpl.access$102(this.this$0, null);
    AppMethodBeat.o(144940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKProgressDialogImpl.2
 * JD-Core Version:    0.7.0.1
 */