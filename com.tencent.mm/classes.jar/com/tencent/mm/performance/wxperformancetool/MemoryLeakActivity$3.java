package com.tencent.mm.performance.wxperformancetool;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MemoryLeakActivity$3
  implements DialogInterface.OnClickListener
{
  MemoryLeakActivity$3(MemoryLeakActivity paramMemoryLeakActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(76884);
    if ((MemoryLeakActivity.b(this.giD) != null) && (MemoryLeakActivity.b(this.giD).isShowing())) {
      MemoryLeakActivity.b(this.giD).dismiss();
    }
    this.giD.finish();
    AppMethodBeat.o(76884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.performance.wxperformancetool.MemoryLeakActivity.3
 * JD-Core Version:    0.7.0.1
 */