package com.tencent.mm.bf;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class e$1
  implements DialogInterface.OnClickListener
{
  e$1(Runnable paramRunnable) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.eEU != null) {
      this.eEU.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bf.e.1
 * JD-Core Version:    0.7.0.1
 */