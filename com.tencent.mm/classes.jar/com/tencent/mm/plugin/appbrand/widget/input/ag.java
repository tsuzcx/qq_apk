package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e.f;
import com.tencent.mm.plugin.appbrand.widget.base.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Locale;

final class ag<Input extends EditText,  extends ab>
{
  final String TAG;
  final Input ova;
  final float ovb;
  e.f ovc;
  MotionEvent ovd;
  boolean ove;
  final Runnable ovf;
  final Runnable ovg;
  
  ag(Input paramInput)
  {
    AppMethodBeat.i(136577);
    this.ove = false;
    this.ovf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136575);
        ag.this.ove = true;
        Log.v(ag.this.TAG, "[apptouch] pendingCheckForTap run, pointerDown TRUE");
        ag.this.ova.postDelayed(ag.this.ovg, ViewConfiguration.getLongPressTimeout());
        AppMethodBeat.o(136575);
      }
    };
    this.ovg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136576);
        if (!ag.this.ove)
        {
          AppMethodBeat.o(136576);
          return;
        }
        e.f localf = e.cv(ag.this.ova);
        if ((ag.this.ovc == null) || (Math.abs(ag.this.ovc.x - localf.x) > 1.0F) || (Math.abs(ag.this.ovc.y - localf.y) > 1.0F))
        {
          Log.v(ag.this.TAG, "check long press timeout, but view has moved.");
          AppMethodBeat.o(136576);
          return;
        }
        if (ag.this.ovd == null)
        {
          AppMethodBeat.o(136576);
          return;
        }
        ag.this.ove = false;
        ag.this.ova.removeCallbacks(ag.this.ovf);
        AppMethodBeat.o(136576);
      }
    };
    this.ova = paramInput;
    this.TAG = ("MicroMsg.AppBrand.InputFakeTapEventEmitter" + String.format(Locale.US, "[%s]", new Object[] { paramInput.toString() }));
    this.ovb = ViewConfiguration.get(paramInput.getContext()).getScaledTouchSlop();
    AppMethodBeat.o(136577);
  }
  
  final boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    AppMethodBeat.i(136579);
    float f1 = paramMotionEvent1.getX(paramMotionEvent1.getActionIndex());
    float f2 = paramMotionEvent1.getY(paramMotionEvent1.getActionIndex());
    float f3 = paramMotionEvent2.getX(paramMotionEvent2.getActionIndex());
    float f4 = paramMotionEvent2.getY(paramMotionEvent2.getActionIndex());
    Log.v(this.TAG, "[apptouch] checkTapArea touchSlop %f, X[%f:%f], Y[%f:%f], [%s : %s]", new Object[] { Float.valueOf(this.ovb), Float.valueOf(f1), Float.valueOf(f3), Float.valueOf(f2), Float.valueOf(f4), a.K(paramMotionEvent1), a.K(paramMotionEvent2) });
    if ((Math.abs(f4 - f2) <= this.ovb) && (Math.abs(f3 - f1) <= this.ovb))
    {
      AppMethodBeat.o(136579);
      return true;
    }
    AppMethodBeat.o(136579);
    return false;
  }
  
  final void cbX()
  {
    AppMethodBeat.i(136578);
    this.ove = false;
    this.ova.removeCallbacks(this.ovf);
    this.ova.removeCallbacks(this.ovg);
    this.ovc = null;
    if (this.ovd != null)
    {
      this.ovd.recycle();
      this.ovd = null;
    }
    AppMethodBeat.o(136578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ag
 * JD-Core Version:    0.7.0.1
 */