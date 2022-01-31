package com.tencent.mm.plugin.account.friend.ui;

import android.os.Bundle;
import android.os.Message;
import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.widget.a.c;

final class i$1
  extends ah
{
  i$1(i parami) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (((i.a(this.fjd) != null) && (!i.a(this.fjd).isShowing())) || (i.b(this.fjd))) {}
    do
    {
      return;
      i.a(this.fjd, i.c(this.fjd) + 1);
      i.d(this.fjd).setProgress(i.c(this.fjd));
      if (i.c(this.fjd) < i.d(this.fjd).getMax() - 2)
      {
        sendEmptyMessageDelayed(0, 1000L);
        return;
      }
      i.e(this.fjd);
      i.d(this.fjd).setIndeterminate(true);
    } while (i.f(this.fjd));
    if (i.a(this.fjd) != null) {
      i.a(this.fjd).dismiss();
    }
    i.a(this.fjd, new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.i.1
 * JD-Core Version:    0.7.0.1
 */