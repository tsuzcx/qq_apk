package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aa.e;
import com.tencent.mm.plugin.appbrand.jsapi.aa.e.f;
import com.tencent.mm.plugin.appbrand.widget.base.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Locale;

final class ag<Input extends EditText,  extends ab>
{
  final String TAG;
  final Input nlt;
  final float nlu;
  e.f nlv;
  MotionEvent nlw;
  boolean nlx;
  final Runnable nly;
  final Runnable nlz;
  
  ag(Input paramInput)
  {
    AppMethodBeat.i(136577);
    this.nlx = false;
    this.nly = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136575);
        ag.this.nlx = true;
        ae.v(ag.this.TAG, "[apptouch] pendingCheckForTap run, pointerDown TRUE");
        ag.this.nlt.postDelayed(ag.this.nlz, ViewConfiguration.getLongPressTimeout());
        AppMethodBeat.o(136575);
      }
    };
    this.nlz = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136576);
        if (!ag.this.nlx)
        {
          AppMethodBeat.o(136576);
          return;
        }
        e.f localf = e.cF(ag.this.nlt);
        if ((ag.this.nlv == null) || (Math.abs(ag.this.nlv.x - localf.x) > 1.0F) || (Math.abs(ag.this.nlv.y - localf.y) > 1.0F))
        {
          ae.v(ag.this.TAG, "check long press timeout, but view has moved.");
          AppMethodBeat.o(136576);
          return;
        }
        if (ag.this.nlw == null)
        {
          AppMethodBeat.o(136576);
          return;
        }
        ag.this.nlx = false;
        ag.this.nlt.removeCallbacks(ag.this.nly);
        AppMethodBeat.o(136576);
      }
    };
    this.nlt = paramInput;
    this.TAG = ("MicroMsg.AppBrand.InputFakeTapEventEmitter" + String.format(Locale.US, "[%s]", new Object[] { paramInput.toString() }));
    this.nlu = ViewConfiguration.get(paramInput.getContext()).getScaledTouchSlop();
    AppMethodBeat.o(136577);
  }
  
  final boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    AppMethodBeat.i(136579);
    float f1 = paramMotionEvent1.getX(paramMotionEvent1.getActionIndex());
    float f2 = paramMotionEvent1.getY(paramMotionEvent1.getActionIndex());
    float f3 = paramMotionEvent2.getX(paramMotionEvent2.getActionIndex());
    float f4 = paramMotionEvent2.getY(paramMotionEvent2.getActionIndex());
    ae.v(this.TAG, "[apptouch] checkTapArea touchSlop %f, X[%f:%f], Y[%f:%f], [%s : %s]", new Object[] { Float.valueOf(this.nlu), Float.valueOf(f1), Float.valueOf(f3), Float.valueOf(f2), Float.valueOf(f4), a.G(paramMotionEvent1), a.G(paramMotionEvent2) });
    if ((Math.abs(f4 - f2) <= this.nlu) && (Math.abs(f3 - f1) <= this.nlu))
    {
      AppMethodBeat.o(136579);
      return true;
    }
    AppMethodBeat.o(136579);
    return false;
  }
  
  final void bFH()
  {
    AppMethodBeat.i(136578);
    this.nlx = false;
    this.nlt.removeCallbacks(this.nly);
    this.nlt.removeCallbacks(this.nlz);
    this.nlv = null;
    if (this.nlw != null)
    {
      this.nlw.recycle();
      this.nlw = null;
    }
    AppMethodBeat.o(136578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ag
 * JD-Core Version:    0.7.0.1
 */