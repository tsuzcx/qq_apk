package com.tencent.kinda.framework.widget.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

class MMInputTipAlert$2
  implements DialogInterface.OnClickListener
{
  MMInputTipAlert$2(MMInputTipAlert paramMMInputTipAlert, VoidCallback paramVoidCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(144839);
    ab.i(this.this$0.TAG, "cancel " + this.val$cancel);
    this.val$cancel.call();
    AppMethodBeat.o(144839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMInputTipAlert.2
 * JD-Core Version:    0.7.0.1
 */