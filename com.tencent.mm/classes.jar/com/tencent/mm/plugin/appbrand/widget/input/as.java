package com.tencent.mm.plugin.appbrand.widget.input;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class as
  implements View.OnTouchListener
{
  private static final int uJB;
  private final Handler H;
  private float uJC;
  private float uJD;
  private boolean uJE;
  
  static
  {
    AppMethodBeat.i(136611);
    uJB = ViewConfiguration.getLongPressTimeout();
    AppMethodBeat.o(136611);
  }
  
  public as()
  {
    AppMethodBeat.i(136607);
    this.H = new Handler(Looper.getMainLooper())
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
          if (as.a(as.this)) {
            sendMessageDelayed(Message.obtain(as.b(as.this), 2), 50L);
          }
        }
      }
    };
    this.uJE = false;
    AppMethodBeat.o(136607);
  }
  
  private void er(View paramView)
  {
    AppMethodBeat.i(136609);
    paramView.setPressed(false);
    this.uJE = false;
    this.H.removeMessages(1);
    this.H.removeMessages(2);
    AppMethodBeat.o(136609);
  }
  
  protected void cRr() {}
  
  protected void cvh() {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(136608);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(136608);
      return true;
      er(paramView);
      continue;
      if ((!this.uJE) && (this.H.hasMessages(1))) {
        cvh();
      }
      er(paramView);
      continue;
      int i = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if ((-i > f1) || (f1 > paramView.getWidth() + i) || (-i > f2) || (f2 > i + paramView.getHeight()))
      {
        this.uJE = true;
        continue;
        paramView.setPressed(true);
        this.H.sendMessageDelayed(Message.obtain(this.H, 1), uJB);
        this.uJC = paramMotionEvent.getX();
        this.uJD = paramMotionEvent.getY();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.as
 * JD-Core Version:    0.7.0.1
 */