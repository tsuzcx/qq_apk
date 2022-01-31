package com.tencent.mm.plugin.appbrand.m;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.widget.b.f;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;

public final class e
  implements DialogInterface
{
  DialogInterface.OnCancelListener Oi;
  private am fqP;
  f gQg;
  private boolean mDismissed = false;
  private boolean pP = false;
  
  public final void cancel()
  {
    this.pP = true;
    if (this.gQg != null) {
      this.gQg.cancel();
    }
    while (this.Oi == null) {
      return;
    }
    this.Oi.onCancel(this);
  }
  
  public final void dismiss()
  {
    this.mDismissed = true;
    if (this.gQg != null) {
      this.gQg.dismiss();
    }
  }
  
  final void s(i parami)
  {
    if (!ai.isMainThread())
    {
      ai.d(new e.1(this, parami));
      return;
    }
    this.fqP = new am(Looper.getMainLooper(), new e.2(this, parami), false);
    this.fqP.S(500L, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.e
 * JD-Core Version:    0.7.0.1
 */