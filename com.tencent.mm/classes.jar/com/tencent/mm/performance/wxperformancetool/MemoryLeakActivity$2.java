package com.tencent.mm.performance.wxperformancetool;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ch.b;

final class MemoryLeakActivity$2
  implements DialogInterface.OnClickListener
{
  MemoryLeakActivity$2(MemoryLeakActivity paramMemoryLeakActivity, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    b.acS(this.eQJ);
    if ((MemoryLeakActivity.b(this.eQI) != null) && (MemoryLeakActivity.b(this.eQI).isShowing())) {
      MemoryLeakActivity.b(this.eQI).dismiss();
    }
    this.eQI.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.performance.wxperformancetool.MemoryLeakActivity.2
 * JD-Core Version:    0.7.0.1
 */