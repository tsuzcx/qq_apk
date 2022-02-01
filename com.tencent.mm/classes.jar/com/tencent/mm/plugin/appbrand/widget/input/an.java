package com.tencent.mm.plugin.appbrand.widget.input;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public class an
  implements View.OnTouchListener
{
  private static final int Pj;
  private final Handler ngW;
  private float ngX;
  private float ngY;
  private boolean ngZ;
  
  static
  {
    AppMethodBeat.i(136611);
    Pj = ViewConfiguration.getLongPressTimeout();
    AppMethodBeat.o(136611);
  }
  
  public an()
  {
    AppMethodBeat.i(136607);
    this.ngW = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(136606);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(136606);
          return;
          if (an.a(an.this)) {
            sendMessageDelayed(Message.obtain(an.b(an.this), 2), 50L);
          }
        }
      }
    };
    this.ngZ = false;
    AppMethodBeat.o(136607);
  }
  
  private void dr(View paramView)
  {
    AppMethodBeat.i(136609);
    paramView.setPressed(false);
    this.ngZ = false;
    this.ngW.removeMessages(1);
    this.ngW.removeMessages(2);
    AppMethodBeat.o(136609);
  }
  
  protected void bEy() {}
  
  protected void bmV() {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(136608);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/appbrand/widget/input/RepeatKeyTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      a.a(true, this, "com/tencent/mm/plugin/appbrand/widget/input/RepeatKeyTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(136608);
      return true;
      dr(paramView);
      continue;
      if ((!this.ngZ) && (this.ngW.hasMessages(1))) {
        bmV();
      }
      dr(paramView);
      continue;
      int i = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if ((-i > f1) || (f1 > paramView.getWidth() + i) || (-i > f2) || (f2 > i + paramView.getHeight()))
      {
        this.ngZ = true;
        continue;
        paramView.setPressed(true);
        this.ngW.sendMessageDelayed(Message.obtain(this.ngW, 1), Pj);
        this.ngX = paramMotionEvent.getX();
        this.ngY = paramMotionEvent.getY();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.an
 * JD-Core Version:    0.7.0.1
 */