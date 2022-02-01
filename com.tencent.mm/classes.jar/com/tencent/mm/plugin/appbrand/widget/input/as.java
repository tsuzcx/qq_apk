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
  private static final int MM;
  private boolean ryA;
  private final Handler ryx;
  private float ryy;
  private float ryz;
  
  static
  {
    AppMethodBeat.i(136611);
    MM = ViewConfiguration.getLongPressTimeout();
    AppMethodBeat.o(136611);
  }
  
  public as()
  {
    AppMethodBeat.i(136607);
    this.ryx = new Handler(Looper.getMainLooper())
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
    this.ryA = false;
    AppMethodBeat.o(136607);
  }
  
  private void dD(View paramView)
  {
    AppMethodBeat.i(136609);
    paramView.setPressed(false);
    this.ryA = false;
    this.ryx.removeMessages(1);
    this.ryx.removeMessages(2);
    AppMethodBeat.o(136609);
  }
  
  protected void bUS() {}
  
  protected void coP() {}
  
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
      dD(paramView);
      continue;
      if ((!this.ryA) && (this.ryx.hasMessages(1))) {
        bUS();
      }
      dD(paramView);
      continue;
      int i = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if ((-i > f1) || (f1 > paramView.getWidth() + i) || (-i > f2) || (f2 > i + paramView.getHeight()))
      {
        this.ryA = true;
        continue;
        paramView.setPressed(true);
        this.ryx.sendMessageDelayed(Message.obtain(this.ryx, 1), MM);
        this.ryy = paramMotionEvent.getX();
        this.ryz = paramMotionEvent.getY();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.as
 * JD-Core Version:    0.7.0.1
 */