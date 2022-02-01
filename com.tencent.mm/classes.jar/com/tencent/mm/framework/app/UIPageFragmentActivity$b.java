package com.tencent.mm.framework.app;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.i.a.f;
import com.tencent.i.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.android.wechat.MyKeyboardWindow.OnTouchListener;

final class UIPageFragmentActivity$b
  implements MyKeyboardWindow.OnTouchListener
{
  f hgG;
  g hgH;
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(214578);
    if (this.hgG != null) {
      this.hgG.a(this.hgH, paramMotionEvent);
    }
    AppMethodBeat.o(214578);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.framework.app.UIPageFragmentActivity.b
 * JD-Core Version:    0.7.0.1
 */