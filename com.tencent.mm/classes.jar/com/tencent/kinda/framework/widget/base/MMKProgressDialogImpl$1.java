package com.tencent.kinda.framework.widget.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class MMKProgressDialogImpl$1
  implements DialogInterface.OnCancelListener
{
  MMKProgressDialogImpl$1(MMKProgressDialogImpl paramMMKProgressDialogImpl, VoidCallback paramVoidCallback) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(144939);
    this.val$cancel.call();
    MMKProgressDialogImpl.access$002(this.this$0, null);
    AppMethodBeat.o(144939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKProgressDialogImpl.1
 * JD-Core Version:    0.7.0.1
 */