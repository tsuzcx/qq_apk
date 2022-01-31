package com.tencent.mm.bf;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class e$2
  implements DialogInterface.OnCancelListener
{
  e$2(Runnable paramRunnable) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.eEU != null) {
      this.eEU.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bf.e.2
 * JD-Core Version:    0.7.0.1
 */