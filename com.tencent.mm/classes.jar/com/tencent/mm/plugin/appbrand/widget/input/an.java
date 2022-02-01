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
  private static final int Pv;
  private final Handler ovL;
  private float ovM;
  private float ovN;
  private boolean ovO;
  
  static
  {
    AppMethodBeat.i(136611);
    Pv = ViewConfiguration.getLongPressTimeout();
    AppMethodBeat.o(136611);
  }
  
  public an()
  {
    AppMethodBeat.i(136607);
    this.ovL = new Handler(Looper.getMainLooper())
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
    this.ovO = false;
    AppMethodBeat.o(136607);
  }
  
  private void di(View paramView)
  {
    AppMethodBeat.i(136609);
    paramView.setPressed(false);
    this.ovO = false;
    this.ovL.removeMessages(1);
    this.ovL.removeMessages(2);
    AppMethodBeat.o(136609);
  }
  
  protected void bJj() {}
  
  protected void cbF() {}
  
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
      di(paramView);
      continue;
      if ((!this.ovO) && (this.ovL.hasMessages(1))) {
        bJj();
      }
      di(paramView);
      continue;
      int i = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if ((-i > f1) || (f1 > paramView.getWidth() + i) || (-i > f2) || (f2 > i + paramView.getHeight()))
      {
        this.ovO = true;
        continue;
        paramView.setPressed(true);
        this.ovL.sendMessageDelayed(Message.obtain(this.ovL, 1), Pv);
        this.ovM = paramMotionEvent.getX();
        this.ovN = paramMotionEvent.getY();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.an
 * JD-Core Version:    0.7.0.1
 */