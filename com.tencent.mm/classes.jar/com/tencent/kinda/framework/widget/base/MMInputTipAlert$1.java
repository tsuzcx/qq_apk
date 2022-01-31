package com.tencent.kinda.framework.widget.base;

import com.tencent.kinda.gen.VoidStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h.b;

class MMInputTipAlert$1
  implements h.b
{
  MMInputTipAlert$1(MMInputTipAlert paramMMInputTipAlert, VoidStringCallback paramVoidStringCallback) {}
  
  public boolean onFinish(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(144838);
    ab.i(this.this$0.TAG, "ok ".concat(String.valueOf(paramCharSequence)));
    this.val$ok.call(String.valueOf(paramCharSequence));
    AppMethodBeat.o(144838);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMInputTipAlert.1
 * JD-Core Version:    0.7.0.1
 */