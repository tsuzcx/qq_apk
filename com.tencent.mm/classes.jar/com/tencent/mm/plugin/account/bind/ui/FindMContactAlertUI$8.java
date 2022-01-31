package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class FindMContactAlertUI$8
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  FindMContactAlertUI$8(FindMContactAlertUI paramFindMContactAlertUI, View paramView) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(13570);
    this.guT.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    int i = this.guT.getMeasuredHeight();
    int j = this.guT.getMeasuredWidth();
    ab.d("MicroMsg.FindMContactAlertUI", "bg width: %s height: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    FindMContactAlertUI.b(this.guR, j, i);
    AppMethodBeat.o(13570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI.8
 * JD-Core Version:    0.7.0.1
 */