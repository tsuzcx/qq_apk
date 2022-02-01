package com.tencent.mm.framework.app;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.h.a.f;
import com.tencent.h.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.android.wechat.MyKeyboardWindow.OnTouchListener;

final class UIPageFragmentActivity$b
  implements MyKeyboardWindow.OnTouchListener
{
  f jSA;
  g jSB;
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(264611);
    if (this.jSA != null) {
      this.jSA.a(this.jSB, paramMotionEvent);
    }
    AppMethodBeat.o(264611);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.framework.app.UIPageFragmentActivity.b
 * JD-Core Version:    0.7.0.1
 */