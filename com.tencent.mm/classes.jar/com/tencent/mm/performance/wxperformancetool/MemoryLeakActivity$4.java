package com.tencent.mm.performance.wxperformancetool;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MemoryLeakActivity$4
  implements DialogInterface.OnDismissListener
{
  MemoryLeakActivity$4(MemoryLeakActivity paramMemoryLeakActivity) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(76885);
    this.giD.finish();
    AppMethodBeat.o(76885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.performance.wxperformancetool.MemoryLeakActivity.4
 * JD-Core Version:    0.7.0.1
 */