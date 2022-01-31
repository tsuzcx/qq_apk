package com.tencent.mm.performance.wxperformancetool;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class MemoryLeakActivity$3
  implements DialogInterface.OnClickListener
{
  MemoryLeakActivity$3(MemoryLeakActivity paramMemoryLeakActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((MemoryLeakActivity.b(this.eQI) != null) && (MemoryLeakActivity.b(this.eQI).isShowing())) {
      MemoryLeakActivity.b(this.eQI).dismiss();
    }
    this.eQI.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.performance.wxperformancetool.MemoryLeakActivity.3
 * JD-Core Version:    0.7.0.1
 */