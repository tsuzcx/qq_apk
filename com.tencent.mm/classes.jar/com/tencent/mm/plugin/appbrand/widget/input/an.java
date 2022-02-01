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
  private final Handler nme;
  private float nmf;
  private float nmg;
  private boolean nmh;
  
  static
  {
    AppMethodBeat.i(136611);
    Pj = ViewConfiguration.getLongPressTimeout();
    AppMethodBeat.o(136611);
  }
  
  public an()
  {
    AppMethodBeat.i(136607);
    this.nme = new Handler(Looper.getMainLooper())
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
    this.nmh = false;
    AppMethodBeat.o(136607);
  }
  
  private void dr(View paramView)
  {
    AppMethodBeat.i(136609);
    paramView.setPressed(false);
    this.nmh = false;
    this.nme.removeMessages(1);
    this.nme.removeMessages(2);
    AppMethodBeat.o(136609);
  }
  
  protected void bFq() {}
  
  protected void bnF() {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(136608);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/appbrand/widget/input/RepeatKeyTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
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
      if ((!this.nmh) && (this.nme.hasMessages(1))) {
        bnF();
      }
      dr(paramView);
      continue;
      int i = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if ((-i > f1) || (f1 > paramView.getWidth() + i) || (-i > f2) || (f2 > i + paramView.getHeight()))
      {
        this.nmh = true;
        continue;
        paramView.setPressed(true);
        this.nme.sendMessageDelayed(Message.obtain(this.nme, 1), Pj);
        this.nmf = paramMotionEvent.getX();
        this.nmg = paramMotionEvent.getY();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.an
 * JD-Core Version:    0.7.0.1
 */