package com.tencent.mm.plugin.appbrand.widget.input;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class an
  implements View.OnTouchListener
{
  private static final int Fx;
  private final Handler joH;
  private float joI;
  private float joJ;
  private boolean joK;
  
  static
  {
    AppMethodBeat.i(123871);
    Fx = ViewConfiguration.getLongPressTimeout();
    AppMethodBeat.o(123871);
  }
  
  public an()
  {
    AppMethodBeat.i(123867);
    this.joH = new an.1(this, Looper.getMainLooper());
    this.joK = false;
    AppMethodBeat.o(123867);
  }
  
  private void cX(View paramView)
  {
    AppMethodBeat.i(123869);
    paramView.setPressed(false);
    this.joK = false;
    this.joH.removeMessages(1);
    this.joH.removeMessages(2);
    AppMethodBeat.o(123869);
  }
  
  protected void aEX() {}
  
  protected void aRf() {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(123868);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(123868);
      return true;
      cX(paramView);
      continue;
      if ((!this.joK) && (this.joH.hasMessages(1))) {
        aEX();
      }
      cX(paramView);
      continue;
      int i = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if ((-i > f1) || (f1 > paramView.getWidth() + i) || (-i > f2) || (f2 > i + paramView.getHeight()))
      {
        this.joK = true;
        continue;
        paramView.setPressed(true);
        this.joH.sendMessageDelayed(Message.obtain(this.joH, 1), Fx);
        this.joI = paramMotionEvent.getX();
        this.joJ = paramMotionEvent.getY();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.an
 * JD-Core Version:    0.7.0.1
 */