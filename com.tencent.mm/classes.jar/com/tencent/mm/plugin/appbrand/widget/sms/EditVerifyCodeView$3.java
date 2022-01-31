package com.tencent.mm.plugin.appbrand.widget.sms;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EditVerifyCodeView$3
  implements View.OnKeyListener
{
  EditVerifyCodeView$3(EditVerifyCodeView paramEditVerifyCodeView) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(134403);
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 1))
    {
      EditVerifyCodeView.c(this.jwB);
      AppMethodBeat.o(134403);
      return true;
    }
    AppMethodBeat.o(134403);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView.3
 * JD-Core Version:    0.7.0.1
 */