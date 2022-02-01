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
  private static final int Mv;
  private float meA;
  private float meB;
  private boolean meC;
  private final Handler mez;
  
  static
  {
    AppMethodBeat.i(136611);
    Mv = ViewConfiguration.getLongPressTimeout();
    AppMethodBeat.o(136611);
  }
  
  public an()
  {
    AppMethodBeat.i(136607);
    this.mez = new Handler(Looper.getMainLooper())
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
    this.meC = false;
    AppMethodBeat.o(136607);
  }
  
  private void dn(View paramView)
  {
    AppMethodBeat.i(136609);
    paramView.setPressed(false);
    this.meC = false;
    this.mez.removeMessages(1);
    this.mez.removeMessages(2);
    AppMethodBeat.o(136609);
  }
  
  protected void bcn() {}
  
  protected void btw() {}
  
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
      dn(paramView);
      continue;
      if ((!this.meC) && (this.mez.hasMessages(1))) {
        bcn();
      }
      dn(paramView);
      continue;
      int i = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if ((-i > f1) || (f1 > paramView.getWidth() + i) || (-i > f2) || (f2 > i + paramView.getHeight()))
      {
        this.meC = true;
        continue;
        paramView.setPressed(true);
        this.mez.sendMessageDelayed(Message.obtain(this.mez, 1), Mv);
        this.meA = paramMotionEvent.getX();
        this.meB = paramMotionEvent.getY();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.an
 * JD-Core Version:    0.7.0.1
 */